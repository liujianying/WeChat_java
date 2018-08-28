package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.ui.base.h;

class c$8 implements OnClickListener {
    final /* synthetic */ c lLe;

    c$8(c cVar) {
        this.lLe = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        a.blJ();
        h.bA(this.lLe.mActivity, this.lLe.mActivity.getResources().getString(a$i.wallet_wx_offline_close_toast_tips));
        c.a(this.lLe);
    }
}
