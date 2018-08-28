package com.tencent.mm.plugin.label.ui.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class InputClearablePreference$3 implements OnTouchListener {
    final /* synthetic */ InputClearablePreference kCq;

    InputClearablePreference$3(InputClearablePreference inputClearablePreference) {
        this.kCq = inputClearablePreference;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (InputClearablePreference.b(this.kCq) != null) {
            InputClearablePreference.b(this.kCq).clearFocus();
        }
        return false;
    }
}
