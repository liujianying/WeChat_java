package com.google.android.exoplayer2.a;

import android.media.AudioAttributes;

public final class b {
    public static final b afu;
    public final int afv;
    public final int afw;
    AudioAttributes afx;
    public final int flags;

    private /* synthetic */ b(int i, int i2, int i3, byte b) {
        this(i, i2, i3);
    }

    static {
        a aVar = new a();
        afu = new b(aVar.afv, aVar.flags, aVar.afw, (byte) 0);
    }

    private b(int i, int i2, int i3) {
        this.afv = i;
        this.flags = i2;
        this.afw = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.afv == bVar.afv && this.flags == bVar.flags && this.afw == bVar.afw) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.afv + 527) * 31) + this.flags) * 31) + this.afw;
    }
}
