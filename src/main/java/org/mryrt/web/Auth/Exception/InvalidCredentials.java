package org.mryrt.web.Auth.Exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class InvalidCredentials extends RuntimeException {

    private final String field;

    private final String exCause;

    public InvalidCredentials(String field, String exCause) {
        log.info("Invalid credentials field: {} cause: {}", field, exCause);
        this.field = field;
        this.exCause = exCause;
        log.warn("Invalid credentials for {}: {}", field, exCause);
    }

}
