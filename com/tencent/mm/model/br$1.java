package com.tencent.mm.model;

import com.tencent.mm.model.br.a;
import com.tencent.mm.sdk.platformtools.bi;

class br$1 extends a {
    final /* synthetic */ br dDr;

    br$1(br brVar) {
        this.dDr = brVar;
        super(brVar, (byte) 0);
    }

    public final boolean a(bp bpVar) {
        if (System.currentTimeMillis() - bpVar.dDj <= 3600000 || bi.getInt(bpVar.dDi, 0) <= 0) {
            return false;
        }
        br.r(23, bpVar.dDi + "_3");
        bpVar.dDi = "0";
        bpVar.dDj = System.currentTimeMillis();
        return true;
    }
}
