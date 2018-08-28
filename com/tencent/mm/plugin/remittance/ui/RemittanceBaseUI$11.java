package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.g.a.fo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class RemittanceBaseUI$11 extends c<fo> {
    final /* synthetic */ RemittanceBaseUI mzz;

    RemittanceBaseUI$11(RemittanceBaseUI remittanceBaseUI) {
        this.mzz = remittanceBaseUI;
        this.sFo = fo.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fo foVar = (fo) bVar;
        if (foVar.bNX.bOa == 1) {
            h.mEJ.h(15386, new Object[]{Integer.valueOf(4), Integer.valueOf(1)});
        } else {
            h.mEJ.h(15386, new Object[]{Integer.valueOf(5), Integer.valueOf(1)});
        }
        String str = foVar.bNX.bNY;
        if (this.mzz.myU == 33) {
            this.mzz.a(this.mzz.cZG, this.mzz.mzh, str, foVar);
        } else {
            this.mzz.a(this.mzz.cZG, null, str, foVar);
        }
        return false;
    }
}
