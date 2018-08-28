package com.google.android.exoplayer2.h;

import com.google.android.exoplayer2.h.q.a;

public final class o extends a {
    private final t<? super f> aAB;
    private final boolean aBo;
    private final int aBp;
    private final int aBq;
    private final String aBr;

    protected final /* synthetic */ q a(q$f q_f) {
        return new n(this.aBr, this.aAB, this.aBp, this.aBq, this.aBo, q_f);
    }

    public o(String str, t<? super f> tVar) {
        this(str, tVar, (byte) 0);
    }

    private o(String str, t<? super f> tVar, byte b) {
        this.aBr = str;
        this.aAB = tVar;
        this.aBp = 8000;
        this.aBq = 8000;
        this.aBo = false;
    }
}
