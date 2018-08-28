package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.collect.b.m;
import com.tencent.mm.wallet_core.ui.e;

class CollectHKMainUI$2 implements OnClickListener {
    final /* synthetic */ m hXI;
    final /* synthetic */ CollectHKMainUI hXK;

    CollectHKMainUI$2(CollectHKMainUI collectHKMainUI, m mVar) {
        this.hXK = collectHKMainUI;
        this.hXI = mVar;
    }

    public final void onClick(View view) {
        e.l(this.hXK.mController.tml, this.hXI.hUv, false);
    }
}
