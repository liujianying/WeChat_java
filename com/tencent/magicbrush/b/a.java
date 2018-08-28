package com.tencent.magicbrush.b;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.magicbrush.a.c.f;

@SuppressLint({"LongLogTag"})
public class a {
    private static volatile a boP = null;
    public b boQ = new a(this, (byte) 0);

    public interface b {
        Bitmap aL(int i, int i2);

        void init();
    }

    private class a implements b {
        private a() {
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        public final void init() {
            f.i("MiroMsg.MBBitmapPool", "hy: dummy init", new Object[0]);
        }

        public final Bitmap aL(int i, int i2) {
            f.i("MiroMsg.MBBitmapPool", "hy: dummy getTask", new Object[0]);
            return Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        }
    }

    public static a tf() {
        if (boP != null) {
            return boP;
        }
        a aVar;
        synchronized (a.class) {
            if (boP == null) {
                boP = new a();
            }
            aVar = boP;
        }
        return aVar;
    }

    private a() {
        this.boQ.init();
    }
}
