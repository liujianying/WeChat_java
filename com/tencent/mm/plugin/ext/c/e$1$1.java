package com.tencent.mm.plugin.ext.c;

import com.tencent.mm.plugin.ext.c.e.1;
import com.tencent.mm.plugin.ext.c.e.a;
import com.tencent.mm.plugin.facedetect.model.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class e$1$1 implements q {
    final /* synthetic */ 1 iKU;

    e$1$1(1 1) {
        this.iKU = 1;
    }

    public final void N(String str, int i, int i2) {
        x.i("MicroMsg.ExtQrCodeHandler", "hy: result: %s, code type: %d, code version: %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        if (bi.oW(str)) {
            x.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved result!");
            this.iKU.cf(null);
            return;
        }
        this.iKU.cf(new a(i, str, i2));
    }
}
