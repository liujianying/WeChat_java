package com.google.android.exoplayer2.f.c;

import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.t;
import java.util.Collections;
import java.util.List;

final class b implements d {
    private final a[] ayy;
    private final long[] ayz;

    public b(a[] aVarArr, long[] jArr) {
        this.ayy = aVarArr;
        this.ayz = jArr;
    }

    public final int P(long j) {
        int a = t.a(this.ayz, j);
        return a < this.ayz.length ? a : -1;
    }

    public final int lj() {
        return this.ayz.length;
    }

    public final long cM(int i) {
        boolean z;
        boolean z2 = true;
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        com.google.android.exoplayer2.i.a.ao(z);
        if (i >= this.ayz.length) {
            z2 = false;
        }
        com.google.android.exoplayer2.i.a.ao(z2);
        return this.ayz[i];
    }

    public final List<a> Q(long j) {
        int a = t.a(this.ayz, j, false);
        if (a == -1 || this.ayy[a] == null) {
            return Collections.emptyList();
        }
        return Collections.singletonList(this.ayy[a]);
    }
}
