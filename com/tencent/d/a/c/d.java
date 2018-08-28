package com.tencent.d.a.c;

public class d {
    private static volatile d vlx = null;
    public String vly = a.vlv;

    public static d cFJ() {
        if (vlx != null) {
            return vlx;
        }
        d dVar;
        synchronized (d.class) {
            if (vlx == null) {
                vlx = new d();
            }
            dVar = vlx;
        }
        return dVar;
    }
}
