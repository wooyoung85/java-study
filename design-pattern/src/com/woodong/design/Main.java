package com.woodong.design;

import com.woodong.design.singleton.AClazz;
import com.woodong.design.singleton.BClazz;
import com.woodong.design.singleton.SocketClient;

public class Main {
    public static void main(String[] args) {
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.print("두 객체는 동일한가? : ");
        System.out.println(aClient.equals(bClient));
    }
}
