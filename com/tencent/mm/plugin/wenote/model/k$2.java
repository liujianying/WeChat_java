package com.tencent.mm.plugin.wenote.model;

import com.tencent.mm.e.b.j.a;
import com.tencent.mm.sdk.platformtools.x;

class k$2 implements a {
    final /* synthetic */ k qoG;

    public k$2(k kVar) {
        this.qoG = kVar;
    }

    public final void onError() {
        x.e("MicroMsg.WNNoteVoiceLogic", "SimpleVoiceRecorder,Record Failed");
        k.a(this.qoG).SO();
    }
}
