package com.tencent.liteav.basic.b;

import android.os.Looper;

class a$3 implements Runnable {
    final /* synthetic */ a a;

    a$3(a aVar) {
        this.a = aVar;
    }

    public void run() {
        a.a(this.a, false);
        a.a(this.a);
        try {
            Looper.myLooper().quit();
        } catch (Exception e) {
        }
    }
}
