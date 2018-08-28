package com.tencent.mm.plugin.appbrand.jsapi.audio;

public abstract class a implements c, Runnable {
    private long fHP = 0;
    private long fHQ = 0;

    public void run() {
        this.fHQ = System.currentTimeMillis();
        ahW();
    }

    public final void ahT() {
        this.fHP = System.currentTimeMillis();
        b.q(this);
    }

    public final void ahU() {
        this.fHP = System.currentTimeMillis();
        ahW();
    }

    public void En() {
        String name = getClass().getName();
        if (name.contains("$")) {
            name.substring(name.lastIndexOf("$") + 1);
            System.currentTimeMillis();
            System.currentTimeMillis();
            this.fHQ = 0;
            this.fHP = 0;
        }
    }
}
