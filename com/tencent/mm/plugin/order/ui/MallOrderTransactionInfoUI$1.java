package com.tencent.mm.plugin.order.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class MallOrderTransactionInfoUI$1 implements OnClickListener {
    final /* synthetic */ MallOrderTransactionInfoUI lQd;

    MallOrderTransactionInfoUI$1(MallOrderTransactionInfoUI mallOrderTransactionInfoUI) {
        this.lQd = mallOrderTransactionInfoUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.lQd.finish();
    }
}
