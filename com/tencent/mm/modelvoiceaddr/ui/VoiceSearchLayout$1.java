package com.tencent.mm.modelvoiceaddr.ui;

import com.tencent.mm.modelvoiceaddr.e;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class VoiceSearchLayout$1 implements a {
    final /* synthetic */ VoiceSearchLayout erE;

    VoiceSearchLayout$1(VoiceSearchLayout voiceSearchLayout) {
        this.erE = voiceSearchLayout;
    }

    public final boolean vD() {
        if (VoiceSearchLayout.a(this.erE) != null) {
            if (VoiceSearchLayout.b(this.erE) < VoiceSearchLayout.Ui().length) {
                VoiceSearchLayout.a(this.erE, VoiceSearchLayout.Ui()[VoiceSearchLayout.c(this.erE)]);
            } else {
                e a = VoiceSearchLayout.a(this.erE);
                x.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + a.eqt);
                int i = a.eqt;
                a.eqt = 0;
                if (i > e.bFx) {
                    e.bFx = i;
                }
                x.d("getMaxAmplitude", " map: " + i + " max:" + e.bFx + " per:" + ((i * 100) / e.bFx));
                int i2 = (i * 100) / e.bFx;
                x.d("MicroMsg.VoiceSearchLayout", "addr vol:" + i2);
                i = VoiceSearchLayout.d(this.erE);
                if (VoiceSearchLayout.d(this.erE) == VoiceSearchLayout.e(this.erE)) {
                    if (i2 <= 10) {
                        VoiceSearchLayout.f(this.erE);
                        if (VoiceSearchLayout.g(this.erE) >= VoiceSearchLayout.Uj().length) {
                            VoiceSearchLayout.h(this.erE);
                        }
                        VoiceSearchLayout.a(this.erE, VoiceSearchLayout.Uj()[VoiceSearchLayout.g(this.erE)]);
                    } else {
                        i2 /= 5;
                        if (i2 >= VoiceSearchLayout.Uk().length) {
                            i2 = VoiceSearchLayout.Uk().length - 1;
                        }
                        x.d("MicroMsg.VoiceSearchLayout", "addr mvol:" + i2);
                        VoiceSearchLayout.b(this.erE, i2);
                    }
                } else if (VoiceSearchLayout.d(this.erE) > VoiceSearchLayout.e(this.erE)) {
                    VoiceSearchLayout.i(this.erE);
                } else {
                    VoiceSearchLayout.j(this.erE);
                }
                VoiceSearchLayout.a(this.erE, VoiceSearchLayout.Uk()[i]);
            }
        }
        return true;
    }
}
