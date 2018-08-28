package com.tencent.mm.modelvoiceaddr.ui;

import com.tencent.mm.modelvoiceaddr.e.b;
import com.tencent.mm.sdk.platformtools.x;

class VoiceSearchLayout$4 implements b {
    final /* synthetic */ VoiceSearchLayout erE;

    VoiceSearchLayout$4(VoiceSearchLayout voiceSearchLayout) {
        this.erE = voiceSearchLayout;
    }

    public final void TZ() {
        VoiceSearchLayout.k(this.erE);
        VoiceSearchLayout.l(this.erE);
        if (VoiceSearchLayout.m(this.erE) != null) {
            VoiceSearchLayout.m(this.erE).SO();
        }
    }

    public final void a(String[] strArr, long j) {
        try {
            x.d("MicroMsg.VoiceSearchLayout", "dkaddr onRes ");
            if (strArr != null) {
                x.d("MicroMsg.VoiceSearchLayout", "dkaddr onRes size:" + strArr.length + " " + strArr.toString());
                for (String str : strArr) {
                    x.d("MicroMsg.VoiceSearchLayout", "search username  :" + str);
                }
            }
            this.erE.reset();
            VoiceSearchLayout.n(this.erE).a(true, strArr, j);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VoiceSearchLayout", e, "", new Object[0]);
        }
    }

    public final void TY() {
        this.erE.reset();
        VoiceSearchLayout.n(this.erE).a(false, null, -1);
    }
}
