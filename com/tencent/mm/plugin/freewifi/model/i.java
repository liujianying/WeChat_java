package com.tencent.mm.plugin.freewifi.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.br;
import com.tencent.mm.protocal.c.bs;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends l implements k {
    private String bPS;
    private final b diG;
    private e diJ;

    private i() {
        a aVar = new a();
        aVar.dIG = new br();
        aVar.dIH = new bs();
        aVar.uri = "/cgi-bin/mmo2o-bin/addcontact";
        aVar.dIF = 1703;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public i(String str, String str2, int i, String str3) {
        this();
        this.bPS = str;
        br brVar = (br) this.diG.dID.dIL;
        brVar.rbW = str;
        brVar.jPK = str2;
        brVar.qZe = i;
        brVar.qZf = str3;
        x.i("MicroMsg.FreeWifi.NetSceneAddContact", "appid = %s", new Object[]{str});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.FreeWifi.NetSceneAddContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, appid = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, this.bPS});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1703;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
