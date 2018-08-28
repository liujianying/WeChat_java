package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.plugin.report.service.h;

class RemittanceBaseUI$10 implements OnClickListener {
    final /* synthetic */ v mzA;
    final /* synthetic */ RemittanceBaseUI mzz;

    RemittanceBaseUI$10(RemittanceBaseUI remittanceBaseUI, v vVar) {
        this.mzz = remittanceBaseUI;
        this.mzA = vVar;
    }

    public final void onClick(View view) {
        this.mzz.a(this.mzA.bQa, this.mzz.cYO, this.mzz.mzk, this.mzA);
        if (this.mzz.fdx == 1) {
            h.mEJ.h(12689, new Object[]{Integer.valueOf(12), Integer.valueOf(1)});
            return;
        }
        h.mEJ.h(12689, new Object[]{Integer.valueOf(3), Integer.valueOf(1)});
    }
}
