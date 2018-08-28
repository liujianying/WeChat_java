package com.tencent.mm.plugin.order.ui.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.order.ui.a.a.3;

class a$3$1 implements OnClickListener {
    final /* synthetic */ 3 lQg;

    a$3$1(3 3) {
        this.lQg = 3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("transaction_id", this.lQg.lNC.bOe);
        intent.putExtra("receiver_name", this.lQg.lNC.lOk);
        intent.putExtra("resend_msg_from_flag", 1);
        d.b(this.lQg.val$context, "remittance", ".ui.RemittanceResendMsgUI", intent);
    }
}
