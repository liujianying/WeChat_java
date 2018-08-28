package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.sdk.platformtools.ad;

public final class a {
    private static a oXz;
    public i oNt = new i(ad.getContext());

    private a() {
    }

    public static a bMC() {
        if (oXz == null) {
            oXz = new a();
        }
        return oXz;
    }

    public static a bMD() {
        if (oXz == null) {
            oXz = bMC();
        }
        return oXz;
    }

    public final void bME() {
        if (this.oNt != null) {
            this.oNt.n(R.k.phonering, 0, true);
        }
    }

    public final void stopRing() {
        if (this.oNt != null) {
            this.oNt.stop();
        }
    }

    public final boolean bKY() {
        if (this.oNt != null) {
            return this.oNt.alf();
        }
        return true;
    }
}
