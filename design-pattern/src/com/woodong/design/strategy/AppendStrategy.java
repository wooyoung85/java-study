package com.woodong.design.strategy;

public class AppendStrategy implements EncodingStrategy{
    @Override
    public String encode(String text) {
        return "ABCD" + text;
    }
}
