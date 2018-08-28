package com.tencent.mm.plugin.freewifi;

public class k$a {
    public String bIQ;
    public String bIR;
    public int bVU;
    public String bssid;
    public String hKX;
    private int jia;
    public String jib;
    public String jic;
    public String jid;
    public int jie;
    public long jif;
    public String jig;
    public String jih;
    private long jii;
    public int result;
    public String ssid;

    /* synthetic */ k$a(byte b) {
        this();
    }

    private k$a() {
    }

    public final k aOc() {
        k kVar = new k((byte) 0);
        k.a(kVar, this.ssid);
        k.b(kVar, this.bssid);
        k.c(kVar, this.bIR);
        k.d(kVar, this.bIQ);
        k.a(kVar, this.jia);
        k.e(kVar, this.jib);
        k.f(kVar, this.jic);
        k.g(kVar, this.jid);
        k.b(kVar, this.jie);
        k.a(kVar, (long) Integer.valueOf("1" + String.format("%03d", new Object[]{Integer.valueOf(this.jie)}) + String.format("%03d", new Object[]{Long.valueOf(this.jif)})).intValue());
        k.h(kVar, this.jig);
        k.c(kVar, this.result);
        k.d(kVar, this.bVU);
        k.i(kVar, this.jih);
        k.b(kVar, this.jii);
        k.j(kVar, this.hKX);
        return kVar;
    }
}
