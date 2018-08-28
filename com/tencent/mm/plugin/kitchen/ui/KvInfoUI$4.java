package com.tencent.mm.plugin.kitchen.ui;

import android.view.View;
import android.view.View.OnClickListener;

class KvInfoUI$4 implements OnClickListener {
    final /* synthetic */ KvInfoUI kAs;

    KvInfoUI$4(KvInfoUI kvInfoUI) {
        this.kAs = kvInfoUI;
    }

    public final void onClick(View view) {
        KvInfoUI.a(this.kAs, KvInfoUI.a(this.kAs).getText().toString().trim());
    }
}
