package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.google.android.exoplayer2.h.r.c;
import com.google.android.exoplayer2.i.t;

public final class s<T> implements c {
    private final a<? extends T> aBR;
    private volatile boolean aBS;
    public volatile long aBT;
    private final f aiC;
    public final i asJ;
    public volatile T result;
    public final int type = 4;

    public s(f fVar, Uri uri, a<? extends T> aVar) {
        this.aiC = fVar;
        this.asJ = new i(uri);
        this.aBR = aVar;
    }

    public final void kQ() {
        this.aBS = true;
    }

    public final boolean kR() {
        return this.aBS;
    }

    public final void kS() {
        h hVar = new h(this.aiC, this.asJ);
        try {
            hVar.lP();
            this.result = this.aBR.b(this.aiC.getUri(), hVar);
        } finally {
            this.aBT = hVar.aAH;
            t.b(hVar);
        }
    }
}
