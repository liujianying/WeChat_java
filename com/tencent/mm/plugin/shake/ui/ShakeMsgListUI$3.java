package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.view.View.OnClickListener;

class ShakeMsgListUI$3 implements OnClickListener {
    final /* synthetic */ View lCA;
    final /* synthetic */ ShakeMsgListUI mZP;

    ShakeMsgListUI$3(ShakeMsgListUI shakeMsgListUI, View view) {
        this.mZP = shakeMsgListUI;
        this.lCA = view;
    }

    public final void onClick(View view) {
        ShakeMsgListUI.a(this.mZP, ShakeMsgListUI.d(this.mZP) + 8);
        ShakeMsgListUI.b(this.mZP).vZ(ShakeMsgListUI.d(this.mZP));
        if (ShakeMsgListUI.e(this.mZP) <= ShakeMsgListUI.d(this.mZP)) {
            ShakeMsgListUI.f(this.mZP).removeFooterView(this.lCA);
        }
    }
}
