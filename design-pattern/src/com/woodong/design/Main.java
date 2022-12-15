package com.woodong.design;

import com.woodong.design.strategy.*;

public class Main {
    public static void main(String[] args) {
        Encoder encoder = new Encoder();
        EncodingStrategy normal = new NormalStrategy();
        EncodingStrategy base64 = new Base64Strategy();
        String message = "hello java";
        encoder.setEncodingStrategy(base64);
        System.out.println(encoder.getMessage(message));

        encoder.setEncodingStrategy(normal);
        System.out.println(encoder.getMessage(message));

        encoder.setEncodingStrategy(new AppendStrategy());
        System.out.println(encoder.getMessage(message));
    }
}
