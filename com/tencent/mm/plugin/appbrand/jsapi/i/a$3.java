package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.content.Intent;
import com.tencent.mm.ui.MMActivity.a;

class a$3 implements a {
    final /* synthetic */ b.a fWJ;
    final /* synthetic */ a fWK;

    a$3(a aVar, b.a aVar2) {
        this.fWK = aVar;
        this.fWJ = aVar2;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == (this.fWK.hashCode() & 65535)) {
            if (i2 == -1) {
                if (this.fWJ != null) {
                    this.fWJ.a(1, null, null);
                }
            } else if (this.fWJ != null) {
                this.fWJ.a(2, null, null);
            }
        }
    }
}
