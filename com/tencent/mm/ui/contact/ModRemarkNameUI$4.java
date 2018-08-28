package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;

class ModRemarkNameUI$4 implements OnClickListener {
    final /* synthetic */ ModRemarkNameUI ukX;

    ModRemarkNameUI$4(ModRemarkNameUI modRemarkNameUI) {
        this.ukX = modRemarkNameUI;
    }

    public final void onClick(View view) {
        ModRemarkNameUI.f(this.ukX).setVisibility(0);
        ModRemarkNameUI.g(this.ukX).setVisibility(8);
        ModRemarkNameUI.h(this.ukX).requestFocus();
        this.ukX.showVKB();
    }
}
