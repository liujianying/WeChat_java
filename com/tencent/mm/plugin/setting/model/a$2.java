package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.kernel.b;
import com.tencent.mm.model.aj;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements aj {
    final /* synthetic */ a mOI;

    public a$2(a aVar) {
        this.mOI = aVar;
    }

    public final void gW(int i) {
        if (i < 0 || i >= 100) {
            b.a(null);
            this.mOI.egv = false;
        }
        x.d("MicroMsg.FixToolsUplogModel", "ipxx progress:%d, isUploading:%b", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.mOI.egv)});
        a.mOG.vK(i);
    }
}
