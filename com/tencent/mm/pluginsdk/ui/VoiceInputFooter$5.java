package com.tencent.mm.pluginsdk.ui;

import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.x;

class VoiceInputFooter$5 implements ChatFooterPanel$a {
    final /* synthetic */ VoiceInputFooter qHn;

    VoiceInputFooter$5(VoiceInputFooter voiceInputFooter) {
        this.qHn = voiceInputFooter;
    }

    public final void bbF() {
    }

    public final void gp(boolean z) {
    }

    public final void apK() {
        VoiceInputFooter.e(this.qHn).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        VoiceInputFooter.e(this.qHn).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
    }

    public final void append(String str) {
        try {
            VoiceInputFooter.e(this.qHn).abr(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VoiceInputFooter", e, "", new Object[0]);
        }
    }
}
