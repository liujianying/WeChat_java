package com.davemorrissey.labs.subscaleview.a;

import android.graphics.Bitmap.Config;

public final class a<T> implements b<T> {
    private Class<? extends T> Yw;
    private Config Yx;

    public a(Class<? extends T> cls) {
        this(cls, (byte) 0);
    }

    private a(Class<? extends T> cls, byte b) {
        this.Yw = cls;
        this.Yx = null;
    }

    public final T hu() {
        if (this.Yx == null) {
            return this.Yw.newInstance();
        }
        return this.Yw.getConstructor(new Class[]{Config.class}).newInstance(new Object[]{this.Yx});
    }
}
