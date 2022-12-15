package com.woodong.design;

import com.woodong.design.adapter.*;
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

        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);

        AirConditioner airConditioner = new AirConditioner();
        adapter = new SocketAdapter(airConditioner);
        connect(adapter);
    }

    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }
}
