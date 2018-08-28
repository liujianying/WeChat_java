package com.tencent.mm.plugin.traceroute.ui;

import com.tencent.mm.g.a.kd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class NetworkDiagnoseAllInOneUI$1 extends c<kd> {
    final /* synthetic */ NetworkDiagnoseAllInOneUI oDK;

    NetworkDiagnoseAllInOneUI$1(NetworkDiagnoseAllInOneUI networkDiagnoseAllInOneUI) {
        this.oDK = networkDiagnoseAllInOneUI;
        this.sFo = kd.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i;
        boolean z = true;
        kd kdVar = (kd) bVar;
        x.v("MicroMsg.NetworkDiagnoseAllInOneUI", "diagnose callback, stage:%d, status:%d", new Object[]{Integer.valueOf(kdVar.bUv.bUw), Integer.valueOf(kdVar.bUv.status)});
        NetworkDiagnoseAllInOneUI networkDiagnoseAllInOneUI;
        if (kdVar.bUv.bUw == 0) {
            NetworkDiagnoseAllInOneUI.a(this.oDK, 33);
            networkDiagnoseAllInOneUI = this.oDK;
            if (kdVar.bUv.status != 0) {
                z = false;
            }
            NetworkDiagnoseAllInOneUI.a(networkDiagnoseAllInOneUI, z);
        } else if (kdVar.bUv.bUw == 1) {
            NetworkDiagnoseAllInOneUI.a(this.oDK, 66);
            networkDiagnoseAllInOneUI = this.oDK;
            if (kdVar.bUv.status != 0) {
                z = false;
            }
            NetworkDiagnoseAllInOneUI.b(networkDiagnoseAllInOneUI, z);
        } else if (kdVar.bUv.bUw == 2) {
            networkDiagnoseAllInOneUI = this.oDK;
            if (kdVar.bUv.status != 0) {
                z = false;
            }
            NetworkDiagnoseAllInOneUI.c(networkDiagnoseAllInOneUI, z);
        }
        int a = NetworkDiagnoseAllInOneUI.a(this.oDK);
        if (kdVar.bUv.bUx) {
            NetworkDiagnoseAllInOneUI.a(this.oDK, 100);
            i = 1000;
            ah.A(new 1(this));
            NetworkDiagnoseAllInOneUI.a(this.oDK, kdVar.bUv.bUy);
            a = NetworkDiagnoseAllInOneUI.c(this.oDK) ? 2 : NetworkDiagnoseAllInOneUI.d(this.oDK) ? 4 : NetworkDiagnoseAllInOneUI.e(this.oDK) ? 5 : 3;
        } else {
            i = 0;
        }
        ah.i(new 2(this, a), (long) i);
        return false;
    }
}
