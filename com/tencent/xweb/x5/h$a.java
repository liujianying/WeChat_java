package com.tencent.xweb.x5;

import android.webkit.JavascriptInterface;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class h$a {
    private static final AtomicInteger vDJ = new AtomicInteger(1);
    HashMap<Integer, byte[]> geu = new HashMap();

    @JavascriptInterface
    public final int getNativeBufferId() {
        int i;
        int i2;
        do {
            i = vDJ.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!vDJ.compareAndSet(i, i2));
        return i;
    }

    @JavascriptInterface
    public final void setNativeBuffer(int i, byte[] bArr) {
        this.geu.put(Integer.valueOf(i), bArr);
    }

    @JavascriptInterface
    public final byte[] getNativeBuffer(int i) {
        return (byte[]) this.geu.remove(Integer.valueOf(i));
    }
}
