package com.zooplus.Zooplus;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@NoArgsConstructor
public class CityNotFoundException extends RuntimeException
{
    public CityNotFoundException(String exception) {
        super(exception);
    }
}