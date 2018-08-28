package com.tencent.mm.modelmulti;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.aaf;
import com.tencent.mm.protocal.c.aag;
import com.tencent.mm.protocal.c.ane;
import com.tencent.mm.protocal.c.ang;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class d extends l implements k {
    public final b dZf;
    private e diJ;

    public d(List<ane> list, long j, ang ang) {
        a aVar = new a();
        aVar.dIG = new aaf();
        aVar.dIH = new aag();
        aVar.uri = "/cgi-bin/mmo2o-bin/getbeaconspushmessage";
        aVar.dIF = 1708;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.dZf = aVar.KT();
        aaf aaf = (aaf) this.dZf.dID.dIL;
        aaf.rFH.addAll(list);
        aaf.rFK = j;
        aaf.rFJ = ang;
        x.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma]getBeaconsPushMessageReq.beacons.size:%d", new Object[]{Integer.valueOf(aaf.rFH.size())});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.diJ.a(i2, i3, str, this);
        aaf aaf = (aaf) this.dZf.dID.dIL;
        ane ane = (ane) aaf.rFH.get(0);
        ang ang = aaf.rFJ;
        aag aag = (aag) ((b) qVar).dIE.dIL;
        if (i2 == 0 && i3 == 0) {
            if (aag.result != 0) {
                h.mEJ.h(12659, new Object[]{Integer.valueOf(1), Integer.valueOf(r2.size()), ane.fMk, Integer.valueOf(ane.major), Integer.valueOf(ane.minor), String.valueOf(ang.latitude), String.valueOf(ang.longitude), Integer.valueOf(2), Integer.valueOf(aag.result)});
            }
            x.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end ok");
            return;
        }
        h.mEJ.h(12659, new Object[]{Integer.valueOf(1), Integer.valueOf(r2.size()), ane.fMk, Integer.valueOf(ane.major), Integer.valueOf(ane.minor), String.valueOf(ang.latitude), String.valueOf(ang.longitude), Integer.valueOf(1), Integer.valueOf(aag.result)});
        x.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end not ok");
    }

    public final int getType() {
        return 1708;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dZf, this);
    }
}
