package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.g.a.fo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class RemittanceBusiUI$18 extends c<fo> {
    final /* synthetic */ RemittanceBusiUI mBt;

    RemittanceBusiUI$18(RemittanceBusiUI remittanceBusiUI) {
        this.mBt = remittanceBusiUI;
        this.sFo = fo.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fo foVar = (fo) bVar;
        if (foVar.bNX.bOa == 1) {
            h.mEJ.h(15386, new Object[]{Integer.valueOf(4), Integer.valueOf(2)});
        } else {
            h.mEJ.h(15386, new Object[]{Integer.valueOf(5), Integer.valueOf(2)});
        }
        RemittanceBusiUI.a(this.mBt, foVar.bNX.bNY, foVar);
        return false;
    }
}
