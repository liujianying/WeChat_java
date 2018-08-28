package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.mmsight.model.d;
import com.tencent.mm.sdk.platformtools.x;

class ac$2 implements d {
    final /* synthetic */ ac npp;

    ac$2(ac acVar) {
        this.npp = acVar;
    }

    public final boolean bcM() {
        x.i("MicroMsg.SightCdnUpload", "iUpdateVideoFile");
        ac.a(this.npp);
        return false;
    }
}
