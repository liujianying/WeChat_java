package com.tencent.tencentmap.mapsdk.a;

class kd$1 implements Runnable {
    final /* synthetic */ kd a;

    kd$1(kd kdVar) {
        this.a = kdVar;
    }

    public void run() {
        try {
            if (kd.a(this.a) != null) {
                kd.a(this.a).a();
            }
        } catch (NullPointerException e) {
        }
    }
}
