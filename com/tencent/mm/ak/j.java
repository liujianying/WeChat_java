package com.tencent.mm.ak;

import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.cache.e;

final class j implements e {
    private f<String, Bitmap> dVf = new f(5);

    j() {
    }

    public final void o(Object obj, Object obj2) {
        this.dVf.m((String) obj, (Bitmap) obj2);
    }

    public final Object get(Object obj) {
        return this.dVf.get((String) obj);
    }

    public final Object remove(Object obj) {
        this.dVf.remove((String) obj);
        return null;
    }
}
