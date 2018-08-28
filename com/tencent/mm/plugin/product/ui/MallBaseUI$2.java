package com.tencent.mm.plugin.product.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class MallBaseUI$2 implements OnClickListener {
    final /* synthetic */ MallBaseUI lSf;

    MallBaseUI$2(MallBaseUI mallBaseUI) {
        this.lSf = mallBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.lSf.finish();
    }
}
