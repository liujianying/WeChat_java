package com.tencent.mm.booter;

import com.tencent.mm.g.a.mx;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$2 extends c<mx> {
    final /* synthetic */ a cWA;

    a$2(a aVar) {
        this.cWA = aVar;
        this.sFo = mx.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        switch (((mx) bVar).bXZ.state) {
            case 0:
                x.d("MicroMsg.BackgroundPlayer", "jacks record resume event");
                this.cWA.xv();
                break;
            case 1:
                x.d("MicroMsg.BackgroundPlayer", "jacks record pause event");
                this.cWA.xu();
                break;
        }
        return false;
    }
}
