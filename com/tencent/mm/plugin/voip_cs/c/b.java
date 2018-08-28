package com.tencent.mm.plugin.voip_cs.c;

import android.content.Context;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class b {
    public static final int lvg = a.fromDPToPix(ad.getContext(), 3);
    public static final int lvh = a.fromDPToPix(ad.getContext(), 4);
    public static final int lvi = a.fromDPToPix(ad.getContext(), 8);
    public static final int lvj = a.fromDPToPix(ad.getContext(), 10);
    public static final int lvk = a.fromDPToPix(ad.getContext(), 14);
    public static final int lvl = a.fromDPToPix(ad.getContext(), 30);
    public static final int lvn = a.fromDPToPix(ad.getContext(), 32);
    public static final int lvo = a.fromDPToPix(ad.getContext(), 96);
    public static final int lvp = a.fromDPToPix(ad.getContext(), 76);
    public static final int lvq = a.fromDPToPix(ad.getContext(), 230);
    private static int oYt = 0;

    public static int er(Context context) {
        if (oYt == 0) {
            oYt = a.fl(context);
        }
        return oYt;
    }
}
