package com.tencent.mm.model;

import com.tencent.mm.model.br.a;

class br$17 extends a {
    final /* synthetic */ br dDr;

    br$17(br brVar) {
        this.dDr = brVar;
        super(brVar, (byte) 0);
    }

    public final bp d(int i, Object... objArr) {
        bp bpVar = new bp();
        bpVar.key = i;
        if (objArr != null && objArr.length > 0) {
            bpVar.dDi = objArr[0];
        }
        bpVar.dDj = 0;
        return bpVar;
    }

    public final void a(bp bpVar, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            bpVar.dDi = objArr[0];
        }
    }

    public final boolean a(bp bpVar) {
        if (System.currentTimeMillis() - bpVar.dDj <= 3600000 || bpVar.dDi.length() <= 0) {
            return false;
        }
        br.r(bpVar.key, bpVar.dDi);
        bpVar.dDi = "";
        bpVar.dDj = System.currentTimeMillis();
        return true;
    }
}
