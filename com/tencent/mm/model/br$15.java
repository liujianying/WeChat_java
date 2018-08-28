package com.tencent.mm.model;

import com.tencent.mm.sdk.platformtools.bi;

class br$15 extends br$a {
    final /* synthetic */ br dDr;

    br$15(br brVar) {
        this.dDr = brVar;
        super(brVar, (byte) 0);
    }

    public final boolean a(bp bpVar) {
        if (System.currentTimeMillis() - bpVar.dDj <= 1800000 || bi.getInt(bpVar.dDi, 0) <= 0) {
            return false;
        }
        br.r(bpVar.key, bpVar.dDi);
        bpVar.dDi = "0";
        bpVar.dDj = System.currentTimeMillis();
        return true;
    }
}
