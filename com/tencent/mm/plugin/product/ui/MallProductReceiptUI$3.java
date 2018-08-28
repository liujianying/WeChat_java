package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.product.b.d;

class MallProductReceiptUI$3 implements OnClickListener {
    final /* synthetic */ MallProductReceiptUI lSZ;

    MallProductReceiptUI$3(MallProductReceiptUI mallProductReceiptUI) {
        this.lSZ = mallProductReceiptUI;
    }

    public final void onClick(View view) {
        d c = MallProductReceiptUI.c(this.lSZ);
        c.lRd.clear();
        c.bna();
        MallProductReceiptUI.d(this.lSZ).notifyDataSetChanged();
    }
}
