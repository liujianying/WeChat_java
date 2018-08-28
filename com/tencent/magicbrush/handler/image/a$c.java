package com.tencent.magicbrush.handler.image;

import android.graphics.Bitmap;

class a$c implements Runnable {
    private String boK;
    private boolean boM;
    private a$b boN;
    final /* synthetic */ a boO;

    /* synthetic */ a$c(a aVar, String str, byte b) {
        this(aVar, str);
    }

    static /* synthetic */ void a(a$c a_c) {
        synchronized (a_c) {
            a_c.boM = true;
            if (a_c.boN != null) {
                a_c.boN.boM = true;
            }
        }
    }

    private a$c(a aVar, String str) {
        this.boO = aVar;
        this.boM = false;
        this.boK = str;
    }

    public final void run() {
        Bitmap loadBitmapSync = this.boO.loadBitmapSync(this.boK);
        synchronized (this) {
            if (this.boM) {
                return;
            }
            this.boN = new a$b(this.boK, loadBitmapSync, (byte) 0);
            this.boO.boD.e(this.boN);
        }
    }
}
