package org.mryrt.web.PointCheck.Exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class InvalidResultUpload extends RuntimeException {

    private String exCause;

    public InvalidResultUpload(String exCause) {
        this.exCause = exCause;
    }

}
