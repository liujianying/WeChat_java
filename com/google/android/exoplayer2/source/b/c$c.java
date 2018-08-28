package com.google.android.exoplayer2.source.b;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.source.l;

final class c$c extends a {
    private int atr;

    public c$c(l lVar, int[] iArr) {
        int i = 0;
        super(lVar, iArr);
        Format format = lVar.asb[0];
        while (i < this.length) {
            if (this.asb[i] == format) {
                break;
            }
            i++;
        }
        i = -1;
        this.atr = i;
    }

    public final void kU() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (f(this.atr, elapsedRealtime)) {
            int i = this.length - 1;
            while (i >= 0) {
                if (f(i, elapsedRealtime)) {
                    i--;
                } else {
                    this.atr = i;
                    return;
                }
            }
            throw new IllegalStateException();
        }
    }

    public final int kV() {
        return this.atr;
    }

    public final int kW() {
        return 0;
    }

    public final Object kX() {
        return null;
    }
}
