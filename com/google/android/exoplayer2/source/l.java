package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.a;
import java.util.Arrays;

public final class l {
    private int aeo;
    public final Format[] asb;
    public final int length;

    public l(Format... formatArr) {
        a.ap(formatArr.length > 0);
        this.asb = formatArr;
        this.length = formatArr.length;
    }

    public final int j(Format format) {
        for (int i = 0; i < this.asb.length; i++) {
            if (format == this.asb[i]) {
                return i;
            }
        }
        return -1;
    }

    public final int hashCode() {
        if (this.aeo == 0) {
            this.aeo = Arrays.hashCode(this.asb) + 527;
        }
        return this.aeo;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        if (this.length == lVar.length && Arrays.equals(this.asb, lVar.asb)) {
            return true;
        }
        return false;
    }
}
