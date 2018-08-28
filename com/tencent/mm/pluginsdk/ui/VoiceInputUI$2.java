package com.tencent.mm.pluginsdk.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;

class VoiceInputUI$2 implements OnTouchListener {
    final /* synthetic */ VoiceInputUI qHV;

    VoiceInputUI$2(VoiceInputUI voiceInputUI) {
        this.qHV = voiceInputUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            VoiceInputUI.a(this.qHV);
        } else if (motionEvent.getAction() == 1) {
            VoiceInputFooter b;
            if (VoiceInputUI.b(this.qHV).cdy()) {
                b = VoiceInputUI.b(this.qHV);
                b.cdz();
                b.setVisibility(8);
            }
            if (VoiceInputUI.b(this.qHV).bEw()) {
                b = VoiceInputUI.b(this.qHV);
                b.hideSmileyPanel();
                b.setVisibility(8);
            }
            b = VoiceInputUI.b(this.qHV);
            b.setVisibility(0);
            if (b.qHg != null) {
                b.qHg.setImageResource(R.g.chatting_setmode_biaoqing_btn);
            }
        }
        return false;
    }
}
