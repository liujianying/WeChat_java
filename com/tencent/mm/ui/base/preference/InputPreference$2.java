package com.tencent.mm.ui.base.preference;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class InputPreference$2 implements OnEditorActionListener {
    final /* synthetic */ InputPreference tCy;

    InputPreference$2(InputPreference inputPreference) {
        this.tCy = inputPreference;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (3 != i || InputPreference.a(this.tCy) == null || InputPreference.b(this.tCy) == null) {
            return false;
        }
        if (InputPreference.b(this.tCy).getText() != null) {
            InputPreference.b(this.tCy).getText().toString();
        }
        return true;
    }
}
