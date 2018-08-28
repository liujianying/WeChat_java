package com.tencent.mm.plugin.voiceprint.ui;

import com.tencent.mm.plugin.voiceprint.model.p;
import com.tencent.mm.plugin.voiceprint.model.p.a;
import com.tencent.mm.sdk.platformtools.x;

class BaseVoicePrintUI$1 implements a {
    final /* synthetic */ BaseVoicePrintUI oFR;

    BaseVoicePrintUI$1(BaseVoicePrintUI baseVoicePrintUI) {
        this.oFR = baseVoicePrintUI;
    }

    public final void bIY() {
        p a = BaseVoicePrintUI.a(this.oFR);
        if (a.bAY != null) {
            a.bAY.we();
            x.e("MicroMsg.VoicePrintRecoder", "Reset recorder.stopReocrd");
        }
        a.fileName = "";
        a.oFx = null;
        a.orz = 0;
        a.iZe = 0;
        if (a.epT != null) {
            a.epT.zY();
        }
        x.e("MicroMsg.BaseVoicePrintUI", "record stop on error");
        BaseVoicePrintUI.a(this.oFR, null);
        BaseVoicePrintUI.b(this.oFR);
    }
}
