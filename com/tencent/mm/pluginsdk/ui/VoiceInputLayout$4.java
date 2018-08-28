package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.modelvoiceaddr.f;
import com.tencent.mm.sdk.platformtools.al.a;

class VoiceInputLayout$4 implements a {
    final /* synthetic */ VoiceInputLayout qHD;

    VoiceInputLayout$4(VoiceInputLayout voiceInputLayout) {
        this.qHD = voiceInputLayout;
    }

    public final boolean vD() {
        if (VoiceInputLayout.b(this.qHD) != null) {
            f b = VoiceInputLayout.b(this.qHD);
            int i = b.eqt;
            b.eqt = 0;
            if (i > f.bFx) {
                f.bFx = i;
            }
            int i2 = (i * 100) / f.bFx;
            if (this.qHD.qHc == 2) {
                this.qHD.BV(i2);
            }
        }
        return true;
    }
}
