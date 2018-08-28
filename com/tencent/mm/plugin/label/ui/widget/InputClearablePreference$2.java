package com.tencent.mm.plugin.label.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;

class InputClearablePreference$2 implements OnClickListener {
    final /* synthetic */ InputClearablePreference kCq;

    InputClearablePreference$2(InputClearablePreference inputClearablePreference) {
        this.kCq = inputClearablePreference;
    }

    public final void onClick(View view) {
        if (InputClearablePreference.b(this.kCq) != null) {
            InputClearablePreference.b(this.kCq).setText("");
            InputClearablePreference.b(this.kCq, "");
        }
    }
}
