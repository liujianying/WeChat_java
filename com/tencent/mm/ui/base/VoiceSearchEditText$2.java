package com.tencent.mm.ui.base;

import android.text.Editable;
import android.text.TextWatcher;

class VoiceSearchEditText$2 implements TextWatcher {
    final /* synthetic */ VoiceSearchEditText tBv;

    VoiceSearchEditText$2(VoiceSearchEditText voiceSearchEditText) {
        this.tBv = voiceSearchEditText;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        VoiceSearchEditText.a(this.tBv, true);
        VoiceSearchEditText.e(this.tBv);
    }

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
