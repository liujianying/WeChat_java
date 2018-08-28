package com.tencent.mm.plugin.label.ui.widget;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class InputClearablePreference$1 implements TextWatcher {
    final /* synthetic */ InputClearablePreference kCq;

    InputClearablePreference$1(InputClearablePreference inputClearablePreference) {
        this.kCq = inputClearablePreference;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence != null) {
            x.d("MicroMsg.Label.InputClearablePreference", "cpan[onTextChanged] :%s", new Object[]{charSequence.toString()});
            if (InputClearablePreference.a(this.kCq) != null) {
                InputClearablePreference.a(this.kCq).FH(charSequence.toString());
            }
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        boolean z = false;
        if (editable != null) {
            String obj = editable.toString();
            InputClearablePreference.a(this.kCq, obj);
            InputClearablePreference inputClearablePreference = this.kCq;
            if (!bi.oW(obj)) {
                z = true;
            }
            InputClearablePreference.a(inputClearablePreference, z);
            InputClearablePreference.b(this.kCq, obj);
            return;
        }
        InputClearablePreference.a(this.kCq, false);
    }
}
