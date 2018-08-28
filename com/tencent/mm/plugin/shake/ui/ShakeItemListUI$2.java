package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.view.View.OnClickListener;

class ShakeItemListUI$2 implements OnClickListener {
    final /* synthetic */ ShakeItemListUI mZA;

    ShakeItemListUI$2(ShakeItemListUI shakeItemListUI) {
        this.mZA = shakeItemListUI;
    }

    public final void onClick(View view) {
        ShakeItemListUI.a(this.mZA, ShakeItemListUI.a(this.mZA) ^ -1);
        this.mZA.wa(ShakeItemListUI.a(this.mZA));
    }
}
