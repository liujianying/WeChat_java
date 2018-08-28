package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;

class n$5 implements OnClickListener {
    final /* synthetic */ n qNT;

    n$5(n nVar) {
        this.qNT = nVar;
    }

    public final void onClick(View view) {
        this.qNT.reset();
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        voiceInputBehavior.clear = 1;
        n.c(voiceInputBehavior);
    }
}
