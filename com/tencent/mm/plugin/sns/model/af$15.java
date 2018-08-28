package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.mm.g.a.rb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;

class af$15 extends c<rb> {
    final /* synthetic */ af nqT;

    af$15(af afVar) {
        this.nqT = afVar;
        this.sFo = rb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rb rbVar = (rb) bVar;
        if (rbVar.cbQ.bNI != 9 && rbVar.cbQ.bNI == 7) {
            new ag(Looper.getMainLooper()).post(new 1(this, rbVar));
        }
        return false;
    }
}
