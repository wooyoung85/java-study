package com.woodong.design;

import com.woodong.design.adapter.*;
import com.woodong.design.aop.AopBrowser;
import com.woodong.design.proxy.Browser;
import com.woodong.design.proxy.BrowserProxy;
import com.woodong.design.proxy.IBrowser;
import com.woodong.design.singleton.AClazz;
import com.woodong.design.singleton.BClazz;
import com.woodong.design.singleton.SocketClient;

import java.util.concurrent.atomic.AtomicLong;

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

        IBrowser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();

        browser = new BrowserProxy("www.naver.com");
        browser.show();
        browser.show();
        browser.show();

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();
        browser = new AopBrowser("www.naver.com",
                () -> {
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                () -> {
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                });
        browser.show();
        System.out.println("loading time : " + end.get());
        browser.show();
        System.out.println("loading time : " + end.get());
    }

    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
}
