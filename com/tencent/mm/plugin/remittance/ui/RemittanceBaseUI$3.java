package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;

class RemittanceBaseUI$3 implements OnClickListener {
    final /* synthetic */ RemittanceBaseUI mzz;

    RemittanceBaseUI$3(RemittanceBaseUI remittanceBaseUI) {
        this.mzz = remittanceBaseUI;
    }

    public final void onClick(View view) {
        b.a(this.mzz, this.mzz.fdx, RemittanceBaseUI.d(this.mzz), RemittanceBaseUI.a(this.mzz));
        if (this.mzz.fdx == 1) {
            h.mEJ.h(12689, new Object[]{Integer.valueOf(13), Integer.valueOf(1)});
            return;
        }
        h.mEJ.h(12689, new Object[]{Integer.valueOf(4), Integer.valueOf(1)});
    }
}
