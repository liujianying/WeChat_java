package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;

class HardCoderSettingUI$3 implements OnClickListener {
    final /* synthetic */ HardCoderSettingUI uzO;

    HardCoderSettingUI$3(HardCoderSettingUI hardCoderSettingUI) {
        this.uzO = hardCoderSettingUI;
    }

    public final void onClick(View view) {
        HardCoderSettingUI.a(this.uzO, false);
        this.uzO.showDialog(1);
    }
}
