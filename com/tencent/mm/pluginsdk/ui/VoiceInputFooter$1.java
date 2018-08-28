package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.View.OnClickListener;

class VoiceInputFooter$1 implements OnClickListener {
    final /* synthetic */ VoiceInputFooter qHn;

    VoiceInputFooter$1(VoiceInputFooter voiceInputFooter) {
        this.qHn = voiceInputFooter;
    }

    public final void onClick(View view) {
        if (this.qHn.getVisibility() == 8) {
            this.qHn.setVisibility(0);
        }
        if (this.qHn.cdy()) {
            VoiceInputFooter.a(this.qHn);
        }
        if (this.qHn.bEw()) {
            VoiceInputFooter.b(this.qHn);
        }
    }
}
