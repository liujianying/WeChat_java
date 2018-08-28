package com.tencent.mm.modelvoice;

import com.tencent.mm.e.b.b.a;
import com.tencent.mm.sdk.platformtools.x;

class t$1 implements a {
    final /* synthetic */ t epW;

    t$1(t tVar) {
        this.epW = tVar;
    }

    public final void onError() {
        if (t.a(this.epW) != null) {
            t.a(this.epW).onError();
        }
        try {
            t.b(this.epW).release();
            t.c(this.epW);
        } catch (Exception e) {
            x.e("VoiceRecorder", "setErrorListener File[" + this.epW.fileName + "] ErrMsg[" + e.getStackTrace() + "]");
        }
    }
}
