package com.pinicius.android.casapiclient;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pinicius on 26/11/16.
 */

public class CASError {
    private static final int ERROR_CODE = 500;

    @SerializedName("code") private int code;
    @SerializedName("message") private String message;

    public int getCode() {
        return ERROR_CODE;
    }

    public String getMessage() {
        return message;
    }
}