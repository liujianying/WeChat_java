package com.tencent.mm.plugin.aa.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class AASelectContactUI$2 implements OnCheckedChangeListener {
    final /* synthetic */ AASelectContactUI eCw;

    AASelectContactUI$2(AASelectContactUI aASelectContactUI) {
        this.eCw = aASelectContactUI;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        AASelectContactUI.e(this.eCw);
    }
}
