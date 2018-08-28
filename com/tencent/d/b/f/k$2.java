package com.tencent.d.b.f;

import com.tencent.d.a.c.c;
import com.tencent.d.a.c.h;
import com.tencent.d.b.d.a;
import com.tencent.d.b.e.e;
import com.tencent.d.b.f.k.3;

class k$2 implements a {
    final /* synthetic */ k vng;

    k$2(k kVar) {
        this.vng = kVar;
    }

    public final void onError(int i, String str) {
        c.w("Soter.TaskPrepareAuthKey", "soter: auth key %s generate failed. errcode: %d, errmsg: %s", new Object[]{this.vng.vlV, Integer.valueOf(i), str});
        k.dC(this.vng.vlV, 0);
        this.vng.b(new com.tencent.d.b.a.c(i, str));
    }

    public final void onSuccess() {
        c.i("Soter.TaskPrepareAuthKey", "soter: auth key generate successfully. start upload", new Object[0]);
        if (this.vng.vnd != null) {
            k.dC(this.vng.vlV, 2);
        } else {
            k.dC(this.vng.vlV, 0);
        }
        k kVar = this.vng;
        h acB = com.tencent.d.a.a.acB(kVar.vlV);
        if (acB == null) {
            c.e("Soter.TaskPrepareAuthKey", "soter: auth key model is null even after generation. fatal error", new Object[0]);
            com.tencent.d.a.a.bD(kVar.vlV, false);
            kVar.b(new com.tencent.d.b.a.c(12, "auth key model is null even after generation."));
        } else if (kVar.vnd != null) {
            kVar.vnd.bx(new e.a(acB.signature, acB.vlD));
            kVar.vnd.a(new 3(kVar, acB));
            kVar.vnd.execute();
        } else {
            c.d("Soter.TaskPrepareAuthKey", "soter: not provide network wrapper instance. please check if it is what you want. we treat it as normal", new Object[0]);
            kVar.b(new com.tencent.d.b.a.c("treat as normal because you do not provide the net wrapper", acB));
        }
    }
}
