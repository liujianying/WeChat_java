package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk;

public final class a {
    public static boolean fLB = false;
    public static int fLC = 5;
    public static boolean fLG = true;
    public static a fLt = new a().ais();
    public static boolean fLw = false;
    public static boolean fLx = true;
    public static boolean fLz = true;
    public boolean Zq;
    public int djl;
    public boolean fLA;
    public String fLD;
    public int fLE;
    public boolean fLF;
    public boolean fLu;
    public long fLv;
    public boolean fLy;

    public static void a(a aVar) {
        fLt = aVar;
    }

    public a(a aVar) {
        this.djl = aVar.djl;
        this.fLu = aVar.fLu;
        this.fLv = aVar.fLv;
        this.Zq = aVar.Zq;
        this.fLy = aVar.fLy;
        this.fLA = aVar.fLA;
        this.fLD = aVar.fLD;
        this.fLE = aVar.fLE;
        this.fLF = aVar.fLF;
    }

    public final String toString() {
        return "BleConfig{interval=" + this.djl + ", allowDuplicatesKey=" + this.fLu + ", actionTimeOutTime=" + this.fLv + ", debug=" + this.Zq + ", mainThread=" + this.fLy + ", serial=" + this.fLA + ", mode='" + this.fLD + '\'' + ", actionDelayTime=" + this.fLE + '}';
    }
}
