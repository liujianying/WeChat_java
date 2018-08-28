package com.tencent.mm.ui.base.preference;

import com.tencent.mm.ui.widget.MMSwitchBtn.a;

class CheckBoxPreference$1 implements a {
    final /* synthetic */ CheckBoxPreference tBE;

    CheckBoxPreference$1(CheckBoxPreference checkBoxPreference) {
        this.tBE = checkBoxPreference;
    }

    public final void cf(boolean z) {
        this.tBE.callChangeListener(Boolean.valueOf(z));
    }
}
