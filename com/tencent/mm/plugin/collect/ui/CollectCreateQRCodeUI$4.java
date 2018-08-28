package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.ui.view.a;
import com.tencent.mm.plugin.wxpay.a$i;

class CollectCreateQRCodeUI$4 implements OnClickListener {
    final /* synthetic */ CollectCreateQRCodeUI hXF;

    CollectCreateQRCodeUI$4(CollectCreateQRCodeUI collectCreateQRCodeUI) {
        this.hXF = collectCreateQRCodeUI;
    }

    public final void onClick(View view) {
        this.hXF.Wq();
        a.a(this.hXF, this.hXF.getString(a$i.collect_main_add_desc_title), CollectCreateQRCodeUI.b(this.hXF), "", 32, new 1(this), new 2(this));
    }
}
