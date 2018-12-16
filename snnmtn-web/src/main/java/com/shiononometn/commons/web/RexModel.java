package com.shiononometn.commons.web;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RexModel<T> {
    private String message;
    private String error;
    private T data;

    public RexModel() {
    }

    public RexModel(T data) {
        this.data = data;
    }

    public RexModel<T> withMessage(String message) {
        this.message = message;
        return this;
    }

    public RexModel<T> withError(String error) {
        this.error = error;
        return this;
    }

    public RexModel<T> withData(T data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <A> RexModel<A> success() {
        return new RexModel<A>().withMessage("success");
    }

    public static <A> RexModel<A> error(String error) {
        return new RexModel<A>().withError(error);
    }

    public static <A> RexModel<A> data(A content) {
        return new RexModel<A>().withData(content);
    }
}
