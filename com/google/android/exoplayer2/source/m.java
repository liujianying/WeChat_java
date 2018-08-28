package com.google.android.exoplayer2.source;

import java.util.Arrays;

public final class m {
    public static final m asH = new m(new l[0]);
    private int aeo;
    public final l[] asI;
    public final int length;

    public m(l... lVarArr) {
        this.asI = lVarArr;
        this.length = lVarArr.length;
    }

    public final int a(l lVar) {
        for (int i = 0; i < this.length; i++) {
            if (this.asI[i] == lVar) {
                return i;
            }
        }
        return -1;
    }

    public final int hashCode() {
        if (this.aeo == 0) {
            this.aeo = Arrays.hashCode(this.asI);
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
        m mVar = (m) obj;
        if (this.length == mVar.length && Arrays.equals(this.asI, mVar.asI)) {
            return true;
        }
        return false;
    }
}
