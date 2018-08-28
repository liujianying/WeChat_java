package com.tencent.mm.plugin.sport.c;

import android.os.Build;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.cdm;
import com.tencent.mm.protocal.c.cdn;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bn;

public final class e extends l implements k {
    private b dZf;
    private com.tencent.mm.ab.e diJ;
    cdn ooX;

    public e() {
        a aVar = new a();
        aVar.dIF = 1947;
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/getwxsportconfig";
        aVar.dIG = new cdm();
        aVar.dIH = new cdn();
        this.dZf = aVar.KT();
        cdm cdm = (cdm) this.dZf.dID.dIL;
        cdm.hbP = d.DEVICE_NAME;
        cdm.reT = bn.cmZ();
        cdm.rjM = Build.BRAND;
        cdm.rjL = Build.MODEL;
        cdm.syX = d.qVJ;
        cdm.rjN = d.qVK;
        cdm.rjO = d.qVL;
        cdm.syY = com.tencent.mm.sdk.platformtools.d.CLIENT_VERSION;
        cdm.syZ = Build.MANUFACTURER;
        x.i("MicroMsg.Sport.NetSceneGetWeSportConfig", "request params=[%s, %s, %s, %s, %s, %s, %s, %s, %s]", new Object[]{cdm.reT, cdm.rjM, cdm.rjL, cdm.hbP, cdm.rjO, cdm.rjN, cdm.rjO, cdm.syY, cdm.syZ});
    }

    public final int getType() {
        return 1947;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dZf, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Sport.NetSceneGetWeSportConfig", "onGYNetEnd %d %d %d %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.ooX = (cdn) this.dZf.dIE.dIL;
            this.diJ.a(i2, i3, str, this);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }
}
