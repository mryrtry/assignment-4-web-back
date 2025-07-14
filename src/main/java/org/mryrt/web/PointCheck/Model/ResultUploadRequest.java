package org.mryrt.web.PointCheck.Model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ResultUploadRequest {

    @NotNull(message = "X is required")
    private Float x;

    @NotNull(message = "Y is required")
    private Float y;

    @NotNull(message = "R is required")
    private Float r;

}
