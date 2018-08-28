package com.google.android.gms.c;

import java.util.Arrays;

public final class l$a {
    public final int aXx;
    public final int aXy;

    public l$a(int i, int i2) {
        this.aXx = i;
        this.aXy = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof l$a)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        l$a l_a = (l$a) obj;
        return l_a.aXx == this.aXx && l_a.aXy == this.aXy;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.aXx), Integer.valueOf(this.aXy)});
    }
}
