package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.ui.m;

class CollectMainUI$18 implements OnClickListener {
    final /* synthetic */ CollectMainUI hYN;
    final /* synthetic */ m hYU;
    final /* synthetic */ m hYV;

    CollectMainUI$18(CollectMainUI collectMainUI, m mVar, m mVar2) {
        this.hYN = collectMainUI;
        this.hYU = mVar;
        this.hYV = mVar2;
    }

    public final void onClick(View view) {
        if (CollectMainUI.g(this.hYN).getText().toString().equals(CollectMainUI.i(this.hYN))) {
            this.hYU.onClick(view);
        } else {
            this.hYV.onClick(view);
        }
    }
}
