package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.g.a.tk;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class RemittanceBusiUI$20 extends c<tk> {
    final /* synthetic */ RemittanceBusiUI mBt;

    RemittanceBusiUI$20(RemittanceBusiUI remittanceBusiUI) {
        this.mBt = remittanceBusiUI;
        this.sFo = tk.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        tk tkVar = (tk) bVar;
        a.sFg.c(RemittanceBusiUI.F(this.mBt));
        if (tkVar.ceX.result == -1) {
            RemittanceBusiUI.r(this.mBt).performClick();
        }
        return false;
    }
}
