package com.tencent.mm.plugin.wallet_core.ui;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class k$10 implements OnCheckedChangeListener {
    final /* synthetic */ Button pvH;

    public k$10(Button button) {
        this.pvH = button;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.pvH.setEnabled(true);
            this.pvH.setClickable(true);
            return;
        }
        this.pvH.setEnabled(false);
        this.pvH.setClickable(false);
    }
}
