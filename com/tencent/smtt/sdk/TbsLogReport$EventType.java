package com.tencent.smtt.sdk;

public enum TbsLogReport$EventType {
    TYPE_DOWNLOAD(0),
    TYPE_INSTALL(1),
    TYPE_LOAD(2),
    TYPE_DOWNLOAD_DECOUPLE(3),
    TYPE_INSTALL_DECOUPLE(4),
    TYPE_COOKIE_DB_SWITCH(5);
    
    int a;

    private TbsLogReport$EventType(int i) {
        this.a = i;
    }
}
