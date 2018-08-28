package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.plugin.voip.model.a;

class c$3 implements a {
    final /* synthetic */ c ltg;

    c$3(c cVar) {
        this.ltg = cVar;
    }

    public final int P(byte[] bArr, int i) {
        int U;
        if (this.ltg.lte != null) {
            U = this.ltg.lte.U(bArr, i);
        } else {
            U = 0;
        }
        if (U < 0) {
            return -1;
        }
        return 0;
    }
}
