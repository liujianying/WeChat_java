package com.tencent.mm.plugin.secinforeport.a;

public enum d implements c {
    ;
    
    private static c mOx;

    private d(String str) {
    }

    static {
        mOx = new a((byte) 0);
    }

    public static void a(c cVar) {
        if (cVar != null) {
            mOx = cVar;
        }
    }

    public final boolean H(int i, long j) {
        return mOx.H(i, j);
    }

    public final void a(int i, boolean z, boolean z2, boolean z3) {
        mOx.a(i, z, z2, z3);
    }

    public final void vJ(int i) {
        mOx.vJ(i);
    }

    public final void bto() {
        mOx.bto();
    }
}
