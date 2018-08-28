package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

class RemittanceDetailUI$9 implements OnClickListener {
    final /* synthetic */ RemittanceDetailUI mCf;

    RemittanceDetailUI$9(RemittanceDetailUI remittanceDetailUI) {
        this.mCf = remittanceDetailUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.bA(this.mCf.mController.tml, this.mCf.getString(i.remittance_detail_msg_collect_suc));
    }
}
