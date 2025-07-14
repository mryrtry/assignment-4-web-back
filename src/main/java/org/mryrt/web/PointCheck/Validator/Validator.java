package org.mryrt.web.PointCheck.Validator;

import org.jetbrains.annotations.NotNull;
import org.mryrt.web.PointCheck.Model.ResultUploadRequest;

public class Validator {

    private static boolean _checkPointInRectangle(float x, float y, float r) {
        return x <= 0 && x >= -r && y <= 0 && y >= - r / 2;
    }

    private static boolean _checkPointInSector(float x, float y, float r) {
        return x >= 0 && y >= 0 && x * x + y * y <= r * r;
    }

    private static boolean _checkPointInTriangle(float x, float y, float r) {
        return x >= 0 && y <= 0 && y >= x -r;
    }

    public static boolean validateParams(@NotNull ResultUploadRequest resultUploadRequest) {
        float x = resultUploadRequest.getX();
        float y = resultUploadRequest.getY();
        float r = resultUploadRequest.getR();

        if (x < -5.5 || x > 5.5) return false;
        if (y < -5.5 || y > 5.5) return false;
        if (Math.round(r * 2) != r * 2 || r < 1 || r > 3) return false;

        return true;
    }

    public static boolean checkPointInArea(@NotNull ResultUploadRequest resultUploadRequest) {
        float x = resultUploadRequest.getX();
        float y = resultUploadRequest.getY();
        float r = resultUploadRequest.getR();

        return _checkPointInRectangle(x, y, r) || _checkPointInSector(x, y, r) || _checkPointInTriangle(x, y, r);
    }
}