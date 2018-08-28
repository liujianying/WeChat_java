package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;

class HardCoderSettingUI$2 implements OnClickListener {
    final /* synthetic */ HardCoderSettingUI uzO;

    HardCoderSettingUI$2(HardCoderSettingUI hardCoderSettingUI) {
        this.uzO = hardCoderSettingUI;
    }

    public final void onClick(View view) {
        HardCoderSettingUI.a(this.uzO, true);
        this.uzO.showDialog(1);
    }
}
