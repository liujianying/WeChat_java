package com.tencent.mm.plugin.label.ui.widget;

import android.view.inputmethod.InputMethodManager;

class InputClearablePreference$4 implements Runnable {
    final /* synthetic */ InputClearablePreference kCq;

    InputClearablePreference$4(InputClearablePreference inputClearablePreference) {
        this.kCq = inputClearablePreference;
    }

    public final void run() {
        if (InputClearablePreference.b(this.kCq) != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) InputClearablePreference.b(this.kCq).getContext().getSystemService("input_method");
            InputClearablePreference.b(this.kCq).requestFocus();
            inputMethodManager.showSoftInput(InputClearablePreference.b(this.kCq), 0);
            InputClearablePreference.b(this.kCq).setCursorVisible(false);
            InputClearablePreference.b(this.kCq).setCursorVisible(true);
        }
    }
}
