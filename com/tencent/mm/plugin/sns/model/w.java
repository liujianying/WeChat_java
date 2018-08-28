package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bps;
import com.tencent.mm.protocal.c.bpv;
import com.tencent.mm.protocal.c.bpw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class w extends l implements k {
    private int bNI;
    private b diG;
    public e diJ;
    private long noI;
    private int scene = 0;

    public w(int i, long j, String str, int i2, List<String> list, int i3) {
        x.d("MicroMsg.NetSceneSnsTagMemberOption", "opCode " + i + " tagName " + str + " memberList " + list.size() + " scene " + i3);
        this.bNI = i;
        this.noI = j;
        this.scene = i3;
        a aVar = new a();
        aVar.dIG = new bpv();
        aVar.dIH = new bpw();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstagmemberoption";
        aVar.dIF = 291;
        aVar.dII = 115;
        aVar.dIJ = 1000000115;
        this.diG = aVar.KT();
        bpv bpv = (bpv) this.diG.dID.dIL;
        bpv.qZc = i;
        bpv.snO = j;
        bpv.jSt = str;
        bpv.hbF = i2;
        bpv.otY = this.scene;
        LinkedList linkedList = new LinkedList();
        for (String VO : list) {
            linkedList.add(new bhz().VO(VO));
        }
        bpv.hbG = linkedList;
        x.d("MicroMsg.NetSceneSnsTagMemberOption", "rr.req.rImpl " + bpv.toString());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 291;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSnsTagMemberOption", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            bps bps = ((bpw) ((b) qVar).dIE.dIL).snQ;
            x.d("MicroMsg.NetSceneSnsTagMemberOption", "Resp.rImpl " + bps.toString());
            t fk = af.byu().fk(bps.snO);
            fk.field_tagId = bps.snO;
            fk.field_tagName = bi.aG(bps.jSt, "");
            switch (this.bNI) {
                case 1:
                case 2:
                case 3:
                    fk.field_count = bps.hbF;
                    fk.co(bps.hbG);
                    break;
            }
            af.byu().a(fk);
            this.diJ.a(i2, i3, str, this);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }
}
