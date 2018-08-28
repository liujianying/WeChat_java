package com.tencent.magicbrush.handler.image;

import android.graphics.Bitmap;
import com.tencent.magicbrush.engine.c;

class a$b implements Runnable {
    private String boK;
    private Bitmap boL;
    volatile boolean boM;

    /* synthetic */ a$b(String str, Bitmap bitmap, byte b) {
        this(str, bitmap);
    }

    private a$b(String str, Bitmap bitmap) {
        this.boM = false;
        this.boK = str;
        this.boL = bitmap;
    }

    public final void run() {
        if (this.boM) {
            this.boL.recycle();
        } else {
            c.b(this.boK, this.boL);
        }
    }
}
