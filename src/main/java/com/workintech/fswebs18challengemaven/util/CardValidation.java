package com.workintech.fswebs18challengemaven.util;

import com.workintech.fswebs18challengemaven.exceptions.CardException;
import org.springframework.http.HttpStatus;

public class CardValidation {
    public static void checkId(Long id) {
        if(id == null || id.toString().isEmpty()) {
            throw new CardException("Id is either null or empty!", HttpStatus.BAD_REQUEST);
        }
    }
}
