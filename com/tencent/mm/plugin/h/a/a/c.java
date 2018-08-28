package com.tencent.mm.plugin.h.a.a;

import java.util.Arrays;

public final class c {
    public String bvw = "";
    String heN = null;
    public e heO = null;
    public double heP = 0.0d;

    public final int hashCode() {
        if (this.heO == null) {
            return 0;
        }
        return Arrays.hashCode(this.heO.heS.hft);
    }

    public final boolean equals(Object obj) {
        if (this.heO == null || obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return Arrays.equals(((c) obj).heO.heS.hft, this.heO.heS.hft);
    }
}
