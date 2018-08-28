package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.plugin.location.model.d;
import com.tencent.mm.plugin.location.ui.i.a;
import com.tencent.mm.plugin.location.ui.m;
import com.tencent.mm.protocal.c.bxg;
import com.tencent.mm.sdk.platformtools.bi;

class g$6 implements a {
    final /* synthetic */ g kJY;

    g$6(g gVar) {
        this.kJY = gVar;
    }

    public final void FT(String str) {
        TrackPoint trackPoint = (TrackPoint) this.kJY.kHR.kEZ.getViewByItag(str);
        if (trackPoint != null) {
            d dVar;
            trackPoint.set2Top();
            this.kJY.kHR.kEZ.invalidate();
            m mVar = this.kJY.kJL;
            if (!bi.oW(str)) {
                if (mVar.kDI == null || !str.equals(mVar.kDI.rdS)) {
                    if (mVar.kGQ != null && mVar.kGQ.size() > 0) {
                        for (bxg bxg : mVar.kGQ) {
                            if (bxg.rdS.equals(str)) {
                                dVar = new d(bxg.stK.rji, bxg.stK.rjj);
                                break;
                            }
                        }
                    }
                }
                dVar = new d(mVar.kDI.stK.rji, mVar.kDI.stK.rjj);
                if (dVar != null) {
                    this.kJY.kHR.kEZ.getIController().animateTo(dVar.kCw, dVar.kCx);
                }
            }
            dVar = null;
            if (dVar != null) {
                this.kJY.kHR.kEZ.getIController().animateTo(dVar.kCw, dVar.kCx);
            }
        }
    }
}
