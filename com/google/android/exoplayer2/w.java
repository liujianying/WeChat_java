package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.i.a;

public abstract class w {
    public static final w aeW = new 1();

    public abstract int V(Object obj);

    public abstract a a(int i, a aVar, boolean z);

    public abstract b a(int i, b bVar, long j);

    public abstract int iU();

    public abstract int iV();

    public final boolean isEmpty() {
        return iU() == 0;
    }

    public final int a(int i, a aVar, b bVar, int i2) {
        int i3 = a(i, aVar, false).adO;
        if (a(i3, bVar, 0).afk != i) {
            return i + 1;
        }
        switch (i2) {
            case 0:
                if (i3 != iU() - 1) {
                    i3++;
                    break;
                }
                i3 = -1;
                break;
            case 1:
                break;
            case 2:
                if (i3 != iU() - 1) {
                    i3++;
                    break;
                }
                i3 = 0;
                break;
            default:
                throw new IllegalStateException();
        }
        if (i3 == -1) {
            return -1;
        }
        return a(i3, bVar, 0).afj;
    }

    public final Pair<Integer, Long> a(b bVar, a aVar, int i, long j) {
        return a(bVar, aVar, i, j, 0);
    }

    public final Pair<Integer, Long> a(b bVar, a aVar, int i, long j, long j2) {
        a.av(i, iU());
        a(i, bVar, j2);
        if (j == -9223372036854775807L) {
            j = bVar.afl;
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = bVar.afj;
        long j3 = bVar.afm + j;
        long j4 = a(i2, aVar, false).aet;
        while (j4 != -9223372036854775807L && j3 >= j4 && i2 < bVar.afk) {
            j3 -= j4;
            i2++;
            j4 = a(i2, aVar, false).aet;
        }
        return Pair.create(Integer.valueOf(i2), Long.valueOf(j3));
    }
}
