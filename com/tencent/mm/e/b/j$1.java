package com.tencent.mm.e.b;

import com.tencent.mm.e.b.b.a;
import com.tencent.mm.sdk.platformtools.x;

class j$1 implements a {
    final /* synthetic */ j bFy;

    j$1(j jVar) {
        this.bFy = jVar;
    }

    public final void onError() {
        j.a(this.bFy).zY();
        if (j.b(this.bFy) != null) {
            j.b(this.bFy).onError();
        }
        try {
            j.c(this.bFy).release();
            j.d(this.bFy);
        } catch (Exception e) {
            x.e("MicroMsg.SimpleVoiceRecorder", "setErrorListener File[" + this.bFy.fileName + "] ErrMsg[" + e.getStackTrace() + "]");
        }
    }
}
