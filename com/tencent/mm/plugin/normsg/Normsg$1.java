package com.tencent.mm.plugin.normsg;

class Normsg$1 implements Runnable {
    final /* synthetic */ boolean[] lFA;

    Normsg$1(boolean[] zArr) {
        this.lFA = zArr;
    }

    public final void run() {
        synchronized (this.lFA) {
            System.loadLibrary("stlport_shared");
            System.loadLibrary("wechatxlog");
            System.loadLibrary("wechatnormsg");
            this.lFA[0] = true;
            this.lFA.notifyAll();
        }
    }
}
