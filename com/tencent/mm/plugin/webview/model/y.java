package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bxm;
import com.tencent.mm.protocal.c.bxn;
import com.tencent.mm.sdk.platformtools.x;

public final class y extends l implements k {
    public final b dZf;
    private e diJ;

    public y(String str, String str2, String str3) {
        a aVar = new a();
        aVar.dIG = new bxm();
        aVar.dIH = new bxn();
        aVar.uri = "/cgi-bin/mmo2o-bin/verifybeaconjspermission";
        aVar.dIF = 1702;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.dZf = aVar.KT();
        bxm bxm = (bxm) this.dZf.dID.dIL;
        bxm.jPK = str;
        bxm.bPS = str2;
        bxm.bLe = str3;
    }

    public final int getType() {
        return 1702;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dZf, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:net end ok");
        } else {
            x.d("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:net end not ok");
        }
        this.diJ.a(i2, i3, str, this);
    }
}
