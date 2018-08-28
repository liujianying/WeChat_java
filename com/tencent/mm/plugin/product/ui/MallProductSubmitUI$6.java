package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class MallProductSubmitUI$6 implements OnClickListener {
    final /* synthetic */ MallProductSubmitUI lTQ;

    MallProductSubmitUI$6(MallProductSubmitUI mallProductSubmitUI) {
        this.lTQ = mallProductSubmitUI;
    }

    public final void onClick(View view) {
        f d = MallProductSubmitUI.d(this.lTQ);
        d.ftd.startActivityForResult(new Intent(d.ftd, MallProductReceiptUI.class), 4);
    }
}
