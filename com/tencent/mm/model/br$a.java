package com.tencent.mm.model;

import com.tencent.mm.sdk.platformtools.bi;

abstract class br$a {
    final /* synthetic */ br dDr;

    public abstract boolean a(bp bpVar);

    private br$a(br brVar) {
        this.dDr = brVar;
    }

    /* synthetic */ br$a(br brVar, byte b) {
        this(brVar);
    }

    public bp d(int i, Object... objArr) {
        int i2 = 1;
        if (objArr != null && objArr.length > 0) {
            i2 = bi.p(objArr[0], 1);
        }
        bp bpVar = new bp();
        bpVar.key = i;
        bpVar.dDi = String.valueOf(i2);
        bpVar.dDj = 0;
        return bpVar;
    }

    public void a(bp bpVar, Object... objArr) {
        int i = 1;
        if (objArr != null && objArr.length > 0) {
            i = bi.p(objArr[0], 1);
        }
        bpVar.dDi = (i + bi.getInt(bpVar.dDi, 0));
    }
}
