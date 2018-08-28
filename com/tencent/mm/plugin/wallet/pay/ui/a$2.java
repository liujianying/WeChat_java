package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class a$2 implements OnCancelListener {
    final /* synthetic */ a pft;

    a$2(a aVar) {
        this.pft = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.pft.bNx();
    }
}
