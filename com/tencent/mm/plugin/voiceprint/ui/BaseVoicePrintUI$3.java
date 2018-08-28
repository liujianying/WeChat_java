package com.tencent.mm.plugin.voiceprint.ui;

import com.tencent.mm.plugin.voiceprint.model.p;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class BaseVoicePrintUI$3 implements a {
    final /* synthetic */ BaseVoicePrintUI oFR;

    BaseVoicePrintUI$3(BaseVoicePrintUI baseVoicePrintUI) {
        this.oFR = baseVoicePrintUI;
    }

    public final boolean vD() {
        if (BaseVoicePrintUI.a(this.oFR) != null) {
            int maxAmplitude;
            p a = BaseVoicePrintUI.a(this.oFR);
            if (a.bAY != null) {
                maxAmplitude = a.bAY.getMaxAmplitude();
                if (maxAmplitude > p.bFx) {
                    p.bFx = maxAmplitude;
                }
                x.d("MicroMsg.VoicePrintRecoder", " map: " + maxAmplitude + " max:" + p.bFx + " per:" + ((maxAmplitude * 100) / p.bFx));
                maxAmplitude = (maxAmplitude * 100) / p.bFx;
            } else {
                maxAmplitude = 0;
            }
            BaseVoicePrintUI.a(this.oFR, (float) maxAmplitude);
        }
        return true;
    }
}
