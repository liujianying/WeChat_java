package com.tencent.weui.base.preference;

import com.tencent.mm.ui.widget.MMSwitchBtn.a;

class CheckBoxPreference$1 implements a {
    final /* synthetic */ CheckBoxPreference vzx;

    CheckBoxPreference$1(CheckBoxPreference checkBoxPreference) {
        this.vzx = checkBoxPreference;
    }

    public final void cf(boolean z) {
        CheckBoxPreference.a(this.vzx, Boolean.valueOf(z));
    }
}
