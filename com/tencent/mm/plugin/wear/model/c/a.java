package com.tencent.mm.plugin.wear.model.c;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class a {
    public static final void ee(int i, int i2) {
        if (com.tencent.mm.plugin.wear.model.a.bSl().pIM.pJd.pJT != null) {
            x.v("MicroMsg.Wear.ReportKVUtil", "report kv operation=%d scene=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            h.mEJ.h(11632, new Object[]{Integer.valueOf(i), r0.hbQ, r0.sze, Integer.valueOf(i2)});
        }
    }

    public static final void zC(int i) {
        h.mEJ.a(249, (long) i, 1, false);
    }

    public static final void jO(boolean z) {
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(249);
        iDKey.SetKey(12);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        if (z) {
            iDKey = new IDKey();
            iDKey.SetID(249);
            iDKey.SetKey(13);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        }
        h.mEJ.b(arrayList, false);
    }
}
