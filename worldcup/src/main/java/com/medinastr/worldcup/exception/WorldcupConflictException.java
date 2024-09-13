package com.medinastr.worldcup.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class WorldcupConflictException extends RuntimeException {

    public WorldcupConflictException() {
    }

    public WorldcupConflictException(String message) {
        super(message);
    }
}
