package com.woodong.design.facade;

public class Ftp {
    private String host;
    private int port;
    private String path;

    public Ftp(String host, int port, String path) {
        this.host = host;
        this.port = port;
        this.path = path;
    }

    public void connect() {
        System.out.println("FTP Host : " + this.host + "Port : " + this.port + " 로 연결합니다.");
    }

    public void moveDirectory() {
        System.out.println("FTP path : " + this.path + "로 이동합니다.");
    }

    public void disConnect() {
        System.out.println("FTP 연결을 종료합니다.");
    }
}
