package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class VoiceTransTextUI$3 implements OnTouchListener {
    final /* synthetic */ VoiceTransTextUI ouz;

    VoiceTransTextUI$3(VoiceTransTextUI voiceTransTextUI) {
        this.ouz = voiceTransTextUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                VoiceTransTextUI.c(this.ouz);
                VoiceTransTextUI.a(this.ouz, view.getScrollY());
                VoiceTransTextUI.b(this.ouz, VoiceTransTextUI.d(this.ouz));
                VoiceTransTextUI.e(this.ouz).removeMessages(0);
                if (VoiceTransTextUI.f(this.ouz)) {
                    VoiceTransTextUI.g(this.ouz);
                    VoiceTransTextUI.a(this.ouz, true);
                    break;
                }
                break;
            case 1:
            case 3:
            case 4:
                if (Math.abs(VoiceTransTextUI.h(this.ouz) - view.getScrollY()) > VoiceTransTextUI.i(this.ouz)) {
                    VoiceTransTextUI.e(this.ouz).sendMessage(VoiceTransTextUI.e(this.ouz).obtainMessage(0, view));
                }
                if (VoiceTransTextUI.j(this.ouz) < 800 && Math.abs(VoiceTransTextUI.h(this.ouz) - view.getScrollY()) <= VoiceTransTextUI.i(this.ouz) && !VoiceTransTextUI.k(this.ouz)) {
                    VoiceTransTextUI.e(this.ouz).removeMessages(0);
                    VoiceTransTextUI.l(this.ouz);
                    this.ouz.finish();
                }
                VoiceTransTextUI.a(this.ouz, false);
                break;
        }
        return false;
    }
}
