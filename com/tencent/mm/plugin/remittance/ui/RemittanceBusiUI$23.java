package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.view.a;
import com.tencent.mm.plugin.wxpay.a.i;

class RemittanceBusiUI$23 implements OnClickListener {
    final /* synthetic */ RemittanceBusiUI mBt;

    RemittanceBusiUI$23(RemittanceBusiUI remittanceBusiUI) {
        this.mBt = remittanceBusiUI;
    }

    public final void onClick(View view) {
        if (!RemittanceBusiUI.j(this.mBt)) {
            this.mBt.Wq();
        }
        h.mEJ.h(15235, new Object[]{Integer.valueOf(6)});
        a.a(this.mBt, this.mBt.getString(i.remittance_busi_add_desc), RemittanceBusiUI.k(this.mBt), this.mBt.getString(i.remittance_busi_desc_max_words_count_tip), 20, new 1(this), new 2(this));
    }
}
