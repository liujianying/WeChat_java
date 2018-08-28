package com.google.android.gms.c;

import java.io.IOException;

public abstract class be {
    protected volatile int baj = -1;

    public static final <T extends be> T a(T t, byte[] bArr, int i) {
        try {
            aw awVar = new aw(bArr, i);
            t.a(awVar);
            awVar.dz(0);
            return t;
        } catch (bd e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final byte[] c(be beVar) {
        byte[] bArr = new byte[beVar.qS()];
        try {
            ax p = ax.p(bArr, bArr.length);
            beVar.a(p);
            if (p.aZX.remaining() == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public abstract be a(aw awVar);

    public void a(ax axVar) {
    }

    protected int pU() {
        return 0;
    }

    /* renamed from: qH */
    public be clone() {
        return (be) super.clone();
    }

    public final int qR() {
        if (this.baj < 0) {
            qS();
        }
        return this.baj;
    }

    public final int qS() {
        int pU = pU();
        this.baj = pU;
        return pU;
    }

    public String toString() {
        return bf.d(this);
    }
}
