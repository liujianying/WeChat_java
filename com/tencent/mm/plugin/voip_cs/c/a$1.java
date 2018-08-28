package com.tencent.mm.plugin.voip_cs.c;

import com.tencent.mm.sdk.platformtools.al.a;

class a$1 implements a {
    final /* synthetic */ a oYs;

    a$1(a aVar) {
        this.oYs = aVar;
    }

    public final boolean vD() {
        int i = this.oYs.oQE[this.oYs.oQG % this.oYs.oQE.length];
        if (this.oYs.ih != null) {
            if (-1 == i) {
                this.oYs.ih.setText(null);
            } else {
                this.oYs.ih.setText(i);
            }
        }
        a aVar = this.oYs;
        aVar.oQG++;
        return true;
    }
}
