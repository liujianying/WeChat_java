package com.tencent.mm.ui.base.preference;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

class ChoicePreference$1 implements OnCheckedChangeListener {
    final /* synthetic */ ChoicePreference tBL;

    ChoicePreference$1(ChoicePreference choicePreference) {
        this.tBL = choicePreference;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (ChoicePreference.a(this.tBL) != null) {
            if (i != -1) {
                ChoicePreference.a(this.tBL, ChoicePreference.b(this.tBL)[i - 1048576]);
            } else {
                ChoicePreference.a(this.tBL, null);
            }
            ChoicePreference.a(this.tBL, i);
            ChoicePreference.a(this.tBL).a(this.tBL, this.tBL.value);
        }
    }
}
