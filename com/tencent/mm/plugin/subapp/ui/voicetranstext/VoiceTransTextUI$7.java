package com.tencent.mm.plugin.subapp.ui.voicetranstext;

class VoiceTransTextUI$7 implements Runnable {
    final /* synthetic */ boolean ouC;
    final /* synthetic */ VoiceTransTextUI ouz;

    VoiceTransTextUI$7(VoiceTransTextUI voiceTransTextUI, boolean z) {
        this.ouz = voiceTransTextUI;
        this.ouC = z;
    }

    public final void run() {
        if (VoiceTransTextUI.r(this.ouz).getMeasuredHeight() >= VoiceTransTextUI.s(this.ouz).getMeasuredHeight()) {
            VoiceTransTextUI.r(this.ouz).fullScroll(130);
            int scrollY = VoiceTransTextUI.r(this.ouz).getScrollY();
            VoiceTransTextUI.d(this.ouz, VoiceTransTextUI.r(this.ouz).getPaddingTop());
            VoiceTransTextUI.d(this.ouz, VoiceTransTextUI.t(this.ouz) - scrollY);
            if (this.ouC) {
                VoiceTransTextUI.r(this.ouz).setPadding(0, 0, 0, 0);
                VoiceTransTextUI.u(this.ouz).setVisibility(8);
                VoiceTransTextUI.u(this.ouz).setHeight(0);
            } else if (VoiceTransTextUI.t(this.ouz) > 0) {
                VoiceTransTextUI.r(this.ouz).setPadding(0, VoiceTransTextUI.t(this.ouz), 0, 0);
            }
        }
    }
}
