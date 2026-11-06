package com.br.BetinhoDev.bookStore.entities.enums;

import com.br.BetinhoDev.bookStore.exceptions.NotFoundStatusException;

public enum Status {
    REQUESTED(1),
    LOANED(2),
    RETURNED(3);

    private final int code;

    Status(int code){
        this.code = code;
    }

    public int getCode(){
        return this.code;
    }

    public static Status valueOf(int code){
        for (Status st : Status.values()){
            if (st.code == code){
                return st;
            }
        }
        throw new NotFoundStatusException("Status not found code: "+code);
    }
}
