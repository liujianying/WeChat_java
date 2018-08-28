package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.View;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

class RemittanceDetailUI$2 implements a {
    final /* synthetic */ RemittanceDetailUI mCf;

    RemittanceDetailUI$2(RemittanceDetailUI remittanceDetailUI) {
        this.mCf = remittanceDetailUI;
    }

    public final void onClick(View view) {
        h.a(this.mCf, this.mCf.getString(i.remittance_confirm_resend_msg), this.mCf.getString(i.app_remind), this.mCf.getString(i.remittance_resend), this.mCf.getString(i.app_cancel), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent();
                intent.putExtra("transaction_id", RemittanceDetailUI$2.this.mCf.mBW);
                intent.putExtra("receiver_name", RemittanceDetailUI.b(RemittanceDetailUI$2.this.mCf));
                RemittanceDetailUI$2.this.mCf.X(intent);
            }
        }, new 2(this));
    }
}
