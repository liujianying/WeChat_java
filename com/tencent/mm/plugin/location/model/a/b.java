package com.tencent.mm.plugin.location.model.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.apj;
import com.tencent.mm.protocal.c.apk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

public final class b extends l implements k {
    public String Yy;
    public final com.tencent.mm.ab.b diG;
    private e diJ;
    private Runnable egq;
    public int errCode;
    public int errType;
    public String fFG;
    public String kCu = "";

    public b(String str) {
        a aVar = new a();
        aVar.dIG = new apj();
        aVar.dIH = new apk();
        aVar.uri = "/cgi-bin/micromsg-bin/jointrackroom";
        aVar.dIF = 490;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((apj) this.diG.dID.dIL).rSl = str;
        x.d("MicroMsg.NetSceneJoinTrackRoom", "chatNameId:" + str);
    }

    public final int getType() {
        return 490;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        apk apk;
        this.errType = i2;
        this.errCode = i3;
        this.Yy = str;
        if (((com.tencent.mm.ab.b) qVar).dIE.dIL != null) {
            apk = (apk) ((com.tencent.mm.ab.b) qVar).dIE.dIL;
        } else {
            apk = null;
        }
        x.d("MicroMsg.NetSceneJoinTrackRoom", "onGYNetEnd errType %d errCode%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if ((i3 == 0 || i3 >= BaseReportManager.MAX_READ_COUNT) && apk != null) {
            this.kCu = apk.rxQ;
            x.d("MicroMsg.NetSceneJoinTrackRoom", "get trackRoomid %s", new Object[]{this.kCu});
        }
        if (apk != null) {
            this.fFG = apk.rmO;
        }
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
        if (this.egq != null) {
            this.egq.run();
        }
    }
}
