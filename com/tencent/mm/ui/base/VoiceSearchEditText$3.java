package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.sdk.platformtools.x;

class VoiceSearchEditText$3 implements OnFocusChangeListener {
    final /* synthetic */ VoiceSearchEditText tBv;

    VoiceSearchEditText$3(VoiceSearchEditText voiceSearchEditText) {
        this.tBv = voiceSearchEditText;
    }

    public final void onFocusChange(View view, boolean z) {
        x.d("MicroMsg.VoiceSearchEditText", "onFocusChange hasFocus = [%s], currentFocusState = [%s]", new Object[]{Boolean.valueOf(z), Boolean.valueOf(VoiceSearchEditText.f(this.tBv))});
        if (!z && VoiceSearchEditText.f(this.tBv)) {
            VoiceSearchEditText.e(this.tBv);
            VoiceSearchEditText.a(this.tBv, false);
        }
    }
}
