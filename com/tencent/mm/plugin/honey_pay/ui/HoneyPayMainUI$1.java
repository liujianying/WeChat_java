package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class HoneyPayMainUI$1 implements OnClickListener {
    final /* synthetic */ HoneyPayMainUI klC;

    HoneyPayMainUI$1(HoneyPayMainUI honeyPayMainUI) {
        this.klC = honeyPayMainUI;
    }

    public final void onClick(View view) {
        x.d(this.klC.TAG, "click add friend");
        HoneyPayMainUI.a(this.klC);
    }
}
