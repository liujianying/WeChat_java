package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.collect.b.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.e;

class CollectHKMainUI$3 implements OnClickListener {
    final /* synthetic */ m hXI;
    final /* synthetic */ CollectHKMainUI hXK;

    CollectHKMainUI$3(CollectHKMainUI collectHKMainUI, m mVar) {
        this.hXK = collectHKMainUI;
        this.hXI = mVar;
    }

    public final void onClick(View view) {
        if (!bi.oW(this.hXI.hUz)) {
            e.l(this.hXK.mController.tml, this.hXI.hUz, true);
        }
    }
}
