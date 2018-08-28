package com.tencent.d.b.f;

import com.tencent.d.a.c.c;
import com.tencent.d.b.a.a;
import com.tencent.d.b.e.b;
import com.tencent.d.b.e.f;

class h$3 implements b<f.b> {
    final /* synthetic */ h vmN;

    h$3(h hVar) {
        this.vmN = hVar;
    }

    public final /* synthetic */ void cG(Object obj) {
        if (((f.b) obj).iMA) {
            c.i("Soter.TaskAuthentication", "soter: upload and verify succeed", new Object[0]);
            this.vmN.b(new a(this.vmN.vmI));
            return;
        }
        c.w("Soter.TaskAuthentication", "soter: upload or verify failed", new Object[0]);
        this.vmN.b(new a(23));
    }
}
