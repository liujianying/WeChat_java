package com.tencent.mm.plugin.pwdgroup.a;

import com.tencent.mm.aa.j;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.vr;
import com.tencent.mm.protocal.c.vs;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a extends l implements k {
    public int bOa;
    private b diG;
    private e diJ;

    public a(int i, String str, String str2, float f, float f2, int i2, int i3, String str3, String str4) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new vr();
        aVar.dIH = new vs();
        aVar.uri = "/cgi-bin/micromsg-bin/mmfacingcreatechatroom";
        aVar.dIF = 653;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        vr vrVar = (vr) this.diG.dID.dIL;
        this.bOa = i;
        vrVar.qZc = i;
        vrVar.ryU = str;
        vrVar.rwj = str2;
        vrVar.rmr = f2;
        vrVar.rms = f;
        vrVar.ryV = i2;
        if (!bi.oW(str3)) {
            vrVar.ryW = str3;
        }
        if (!bi.oW(str4)) {
            vrVar.ryX = str4;
        }
        vrVar.ryY = i3;
        x.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "OpCode:%d, Ticket:%s, Longitude:%f, Latitude:%f, Precision:%d, MackAddr:%s, CellId:%s, GPSSource:%d", new Object[]{Integer.valueOf(i), str2, Float.valueOf(f2), Float.valueOf(f), Integer.valueOf(i2), str3, str4, Integer.valueOf(i3)});
        o.a(2007, f2, f, i2);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "netId:%d errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.bOa == 0) {
            vs bnR = bnR();
            if (bnR != null) {
                LinkedList linkedList = bnR.rbQ;
                if (linkedList != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    int size = linkedList.size();
                    List arrayList = new ArrayList();
                    for (int i4 = 0; i4 < size; i4++) {
                        vt vtVar = (vt) linkedList.get(i4);
                        j jVar = new j();
                        if (bi.oW(vtVar.hbL)) {
                            jVar.username = vtVar.ryZ;
                        } else {
                            jVar.username = vtVar.hbL;
                        }
                        x.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "cpan[onGYNetEnd]UserName:%s SmallImgUrl:%s", new Object[]{vtVar.hbL, vtVar.rwN});
                        jVar.dHQ = vtVar.rwN;
                        jVar.by(true);
                        arrayList.add(jVar);
                    }
                    com.tencent.mm.aa.q.KH().L(arrayList);
                    x.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "use time:%s", new Object[]{(System.currentTimeMillis() - currentTimeMillis)});
                }
            }
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 653;
    }

    public final vs bnR() {
        return (vs) this.diG.dIE.dIL;
    }
}
