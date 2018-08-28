package com.tencent.mm.plugin.wenote.model;

import com.tencent.mm.ab.i.a;
import com.tencent.mm.sdk.platformtools.x;

class k$1 implements a {
    final /* synthetic */ k qoG;

    public k$1(k kVar) {
        this.qoG = kVar;
    }

    public final void onError() {
        x.e("MicroMsg.WNNoteVoiceLogic", "SpeexRecorder,Record Failed");
        k.a(this.qoG).SO();
    }
}
