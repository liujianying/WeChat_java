package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;

class sl$2 implements Runnable {
    private /* synthetic */ Bitmap a;
    private /* synthetic */ sl b;

    sl$2(sl slVar, Bitmap bitmap) {
        this.b = slVar;
        this.a = bitmap;
    }

    public final void run() {
        this.b.a(this.a);
    }
}
