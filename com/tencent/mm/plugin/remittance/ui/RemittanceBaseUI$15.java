package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.view.a;
import com.tencent.mm.plugin.wxpay.a.i;

class RemittanceBaseUI$15 implements OnClickListener {
    final /* synthetic */ RemittanceBaseUI mzz;

    RemittanceBaseUI$15(RemittanceBaseUI remittanceBaseUI) {
        this.mzz = remittanceBaseUI;
    }

    public final void onClick(View view) {
        String string;
        String string2;
        this.mzz.Wq();
        h.mEJ.h(12689, new Object[]{Integer.valueOf(9), Integer.valueOf(1)});
        if (this.mzz.fdx == 1 || this.mzz.fdx == 6) {
            string = this.mzz.getString(i.remittance_add_f2f_desc_link);
            string2 = this.mzz.getString(i.remittance_desc_max_words_count_tip);
            h.mEJ.h(14074, new Object[]{Integer.valueOf(1)});
        } else {
            string = this.mzz.getString(i.remittance_add_desc_link);
            string2 = this.mzz.getString(i.remittance_busi_desc_max_words_count_tip);
        }
        a.a(this.mzz, string, this.mzz.cZG, string2, 20, new 1(this), new 2(this));
    }
}
