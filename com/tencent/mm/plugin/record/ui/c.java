package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.g.a.fw;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.plugin.record.ui.h.a.b;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements a {
    public c(Context context) {
        fw fwVar = new fw();
        fwVar.bOx.opType = 3;
        fwVar.bOx.context = context;
        com.tencent.mm.sdk.b.a.sFg.m(fwVar);
    }

    public final void a(a.a aVar) {
        x.d("MicroMsg.FavImageServiceProxy", "attachThumb favLocalId %s", new Object[]{Long.valueOf(aVar.msT)});
        fw fwVar = new fw();
        fwVar.bOx.opType = 1;
        fwVar.bOx.bOA = aVar.bOA;
        fwVar.bOx.bOz = aVar.bOz;
        fwVar.bOx.bJA = aVar.msT;
        fwVar.bOx.bOB = aVar.bOB;
        fwVar.bOx.width = aVar.width;
        fwVar.bOx.height = aVar.height;
        com.tencent.mm.sdk.b.a.sFg.m(fwVar);
    }

    public final Bitmap a(com.tencent.mm.plugin.record.ui.h.a.c cVar) {
        fw fwVar = new fw();
        fwVar.bOx.opType = 0;
        fwVar.bOx.bOz = cVar.bOz;
        fwVar.bOx.bJA = cVar.msT;
        com.tencent.mm.sdk.b.a.sFg.m(fwVar);
        x.d("MicroMsg.FavImageServiceProxy", "getThumb favLocalId %s, retBmp %s", new Object[]{Long.valueOf(cVar.msT), fwVar.bOy.bOF});
        return fwVar.bOy.bOF;
    }

    public final Bitmap a(b bVar) {
        fw fwVar = new fw();
        fwVar.bOx.opType = 2;
        fwVar.bOx.bOE = false;
        if (bVar.bOC) {
            fwVar.bOx.bOz = bVar.bOz;
            fwVar.bOx.bOC = bVar.bOC;
        } else {
            fwVar.bOx.bOz = bVar.bOz;
            fwVar.bOx.bJA = bVar.msT;
            fwVar.bOx.maxWidth = bVar.maxWidth;
            fwVar.bOx.bOD = bVar.bOD;
        }
        com.tencent.mm.sdk.b.a.sFg.m(fwVar);
        x.d("MicroMsg.FavImageServiceProxy", "getSuitableBigImg favLocalId %s, dataId %s, retBmp %s, fromCache", new Object[]{Long.valueOf(bVar.msT), bVar.bOz.jdM, fwVar.bOy.bOF, Boolean.valueOf(fwVar.bOx.bOC)});
        return fwVar.bOy.bOF;
    }

    public final void bqy() {
        fw fwVar = new fw();
        fwVar.bOx.opType = 4;
        com.tencent.mm.sdk.b.a.sFg.m(fwVar);
    }
}
