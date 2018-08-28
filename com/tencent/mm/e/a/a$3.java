package com.tencent.mm.e.a;

import com.tencent.mm.modelvoice.d.a;
import com.tencent.mm.sdk.f.e;

class a$3 implements a {
    final /* synthetic */ a bCV;

    a$3(a aVar) {
        this.bCV = aVar;
    }

    public final void wd() {
        e.post(new 1(this), "SceneVoice_onCompletion");
    }
}
