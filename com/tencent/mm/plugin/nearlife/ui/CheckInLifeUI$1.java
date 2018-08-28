package com.tencent.mm.plugin.nearlife.ui;

import android.view.View;
import android.view.View.OnClickListener;

class CheckInLifeUI$1 implements OnClickListener {
    final /* synthetic */ CheckInLifeUI lDY;

    CheckInLifeUI$1(CheckInLifeUI checkInLifeUI) {
        this.lDY = checkInLifeUI;
    }

    public final void onClick(View view) {
        CheckInLifeUI.a(this.lDY, view, false);
    }
}
