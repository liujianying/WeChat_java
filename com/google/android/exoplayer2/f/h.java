package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.b.e;

public final class h extends e implements Comparable<h> {
    public long aek;

    public final /* synthetic */ int compareTo(Object obj) {
        h hVar = (h) obj;
        if (jy() != hVar.jy()) {
            return jy() ? 1 : -1;
        } else {
            long j = this.aih - hVar.aih;
            if (j == 0) {
                return 0;
            }
            return j <= 0 ? -1 : 1;
        }
    }

    public h() {
        super(1);
    }
}
