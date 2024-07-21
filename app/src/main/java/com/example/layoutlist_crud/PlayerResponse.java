package com.example.layoutlist_crud;

import java.util.List;

public class PlayerResponse<T> {
    List<T> result;
    public List<T> getResult() {

        return result;
    }
    public void setResult(List<T> result) {

        this.result = result;
    }
}
