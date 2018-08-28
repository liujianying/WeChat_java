package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aad;
import com.tencent.mm.protocal.c.aae;
import com.tencent.mm.protocal.c.ane;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class i extends l implements k {
    public final b dZf;
    private e diJ;

    public i(List<ane> list, String str) {
        a aVar = new a();
        aVar.dIG = new aad();
        aVar.dIH = new aae();
        aVar.uri = "/cgi-bin/mmo2o-bin/getbeaconsingroup";
        aVar.dIF = 1704;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.dZf = aVar.KT();
        aad aad = (aad) this.dZf.dID.dIL;
        aad.rFH.addAll(list);
        aad.bPS = str;
        x.i("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang]getBeaconsInGroupRequest.beacons.size:%d", new Object[]{Integer.valueOf(aad.rFH.size())});
    }

    public final int getType() {
        return 1704;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dZf, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:net end ok");
        } else {
            x.d("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:net end not ok");
        }
        this.diJ.a(i2, i3, str, this);
    }
}
