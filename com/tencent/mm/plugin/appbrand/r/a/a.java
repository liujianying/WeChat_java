package com.tencent.mm.plugin.appbrand.r.a;

import android.content.Context;

public enum a implements e, com.tencent.mm.plugin.appbrand.r.d.a {
    ;
    
    public static final c gCh = null;
    private final e gCi;

    private a(String str) {
        this.gCi = new b();
    }

    static {
        gCh = new c();
    }

    public final void init(Context context) {
        this.gCi.init(context);
    }

    public final void release() {
        this.gCi.release();
    }

    public final c aoB() {
        return this.gCi.aoB();
    }

    public final void cL(Context context) {
        init(context);
    }

    public final void aoy() {
        release();
    }
}
