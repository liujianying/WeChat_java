package com.tencent.mm.plugin.subapp.a;

import com.tencent.mm.a.e;
import com.tencent.mm.model.am.c;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.bi;

public final class b implements c {
    public final String gX(int i) {
        return V(i, true);
    }

    public final String gY(int i) {
        return V(i, false);
    }

    private String V(int i, boolean z) {
        int i2 = 0;
        au.HU();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            return null;
        }
        int i3;
        if (i != 0) {
            i3 = 0;
            while (i3 < 32) {
                i = (i >> 1) & Integer.MAX_VALUE;
                if (i == 0) {
                    break;
                }
                i3++;
            }
        } else {
            i3 = -1;
        }
        if (i3 != -1) {
            i2 = 1 << i3;
        }
        String w = i2 == 0 ? null : w(i2, z);
        if (e.cn(w)) {
            return w;
        }
        HE();
        return null;
    }

    public final void HE() {
        au.HU();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            au.HU();
            long a = bi.a((Long) com.tencent.mm.model.c.DT().get(66051, null), 0);
            long VF = bi.VF();
            if (432000000 <= VF - a) {
                au.HU();
                com.tencent.mm.model.c.DT().set(66051, Long.valueOf(VF));
                a aVar = new a();
            }
        }
    }

    public final boolean gZ(int i) {
        if (i == 0) {
            return false;
        }
        int i2 = 0;
        while (i2 < 32) {
            if (!e.cn(w((1 << i2) & i, false)) || !e.cn(w((1 << i2) & i, true))) {
                return false;
            }
            i2++;
        }
        return true;
    }

    public final String w(int i, boolean z) {
        if (i == 0) {
            return null;
        }
        return com.tencent.mm.compatible.util.e.dgm + "vuserpic_" + Integer.toHexString(i) + (z ? "_HD" : "") + ".png";
    }
}
