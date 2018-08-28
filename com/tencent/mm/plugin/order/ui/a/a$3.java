package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

class a$3 implements OnClickListener {
    final /* synthetic */ MallTransactionObject lNC;
    final /* synthetic */ a lQe;
    final /* synthetic */ Context val$context;

    a$3(a aVar, Context context, MallTransactionObject mallTransactionObject) {
        this.lQe = aVar;
        this.val$context = context;
        this.lNC = mallTransactionObject;
    }

    public final void onClick(View view) {
        h.a(this.val$context, this.val$context.getString(i.remittance_confirm_resend_msg), this.val$context.getString(i.app_remind), this.val$context.getString(i.remittance_resend), this.val$context.getString(i.app_cancel), new 1(this), new 2(this));
    }
}
