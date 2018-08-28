package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import com.tencent.mm.g.a.kd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.x;

class n$1 extends c<kd> {
    final /* synthetic */ n usU;

    n$1(n nVar) {
        this.usU = nVar;
        this.sFo = kd.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = true;
        kd kdVar = (kd) bVar;
        x.v("MicroMsg.NetWarnView", "diagnose callback, stage:%d, status:%d", new Object[]{Integer.valueOf(kdVar.bUv.bUw), Integer.valueOf(kdVar.bUv.status)});
        n nVar;
        if (kdVar.bUv.bUw == 0) {
            this.usU.usM = 33;
            nVar = this.usU;
            if (kdVar.bUv.status != 0) {
                z = false;
            }
            nVar.usN = z;
        } else if (kdVar.bUv.bUw == 1) {
            this.usU.usM = 66;
            nVar = this.usU;
            if (kdVar.bUv.status != 0) {
                z = false;
            }
            nVar.usO = z;
        } else if (kdVar.bUv.bUw == 2) {
            nVar = this.usU;
            if (kdVar.bUv.status != 0) {
                z = false;
            }
            nVar.usP = z;
        }
        if (kdVar.bUv.bUx) {
            this.usU.usM = 0;
            this.usU.oDy = 0;
            this.usU.usQ = kdVar.bUv.bUy;
            this.usU.czg();
            ah.A(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.NetWarnView", "curr top activity is: %s", new Object[]{l.bQ((Context) n$1.this.usU.qJS.get())});
                    if (!l.bQ((Context) n$1.this.usU.qJS.get()).endsWith("NetworkDiagnoseAllInOneUI")) {
                        int i;
                        if (n$1.this.usU.usN) {
                            i = 2;
                        } else if (n$1.this.usU.usO) {
                            i = 4;
                        } else if (n$1.this.usU.usP) {
                            i = 5;
                        } else {
                            i = 3;
                        }
                        n.a(n$1.this.usU, i);
                    }
                }
            });
        }
        ah.A(new 2(this));
        return false;
    }
}
