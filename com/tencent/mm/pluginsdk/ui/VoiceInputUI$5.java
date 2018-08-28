package com.tencent.mm.pluginsdk.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.x;

class VoiceInputUI$5 implements TextWatcher {
    final /* synthetic */ VoiceInputUI qHV;

    VoiceInputUI$5(VoiceInputUI voiceInputUI) {
        this.qHV = voiceInputUI;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        x.d("VoiceInputUI", "afterTextChanged firstTextChange:%s,textChange:%s", new Object[]{Boolean.valueOf(VoiceInputUI.f(this.qHV)), Boolean.valueOf(VoiceInputUI.g(this.qHV))});
        if (VoiceInputUI.f(this.qHV)) {
            VoiceInputUI.h(this.qHV);
            return;
        }
        VoiceInputUI.d(this.qHV);
        VoiceInputUI.c(this.qHV).requestLayout();
    }
}
