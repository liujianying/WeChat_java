package com.tencent.mm.plugin.wallet_index.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class OrderHandlerUI$2 implements OnClickListener {
    final /* synthetic */ OrderHandlerUI pDx;

    OrderHandlerUI$2(OrderHandlerUI orderHandlerUI) {
        this.pDx = orderHandlerUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.pDx.finish();
    }
}
