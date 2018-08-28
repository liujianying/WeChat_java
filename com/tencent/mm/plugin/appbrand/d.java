package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.g.f;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.report.service.h;

public final class d extends c {
    private final l fbP;

    d(l lVar, f fVar) {
        super(lVar, fVar);
        this.fbP = lVar;
    }

    protected final void aag() {
        h.mEJ.a(370, 39, 1, false);
        a.a(this.fbP.mAppId, this.fbP.fdO.fcu.frm.fii, this.fbP.fdO.fcu.frm.fih, 370, 39);
    }

    protected final void cq(boolean z) {
        h.mEJ.a(370, 40, 1, false);
        if (z) {
            h.mEJ.a(370, 41, 1, false);
            return;
        }
        h.mEJ.a(370, 42, 1, false);
        a.a(this.fbP.mAppId, this.fbP.fdO.fcu.frm.fii, this.fbP.fdO.fcu.frm.fih, 370, 42);
    }

    protected final void aah() {
        h.mEJ.a(370, 48, 1, false);
        a.a(this.fbP.mAppId, this.fbP.fdO.fcu.frm.fii, this.fbP.fdO.fcu.frm.fih, 370, 48);
    }

    protected final void cr(boolean z) {
        h.mEJ.a(370, 44, 1, false);
        if (z) {
            h.mEJ.a(370, 45, 1, false);
            return;
        }
        h.mEJ.a(370, 46, 1, false);
        a.a(this.fbP.mAppId, this.fbP.fdO.fcu.frm.fii, this.fbP.fdO.fcu.frm.fih, 370, 46);
    }
}
