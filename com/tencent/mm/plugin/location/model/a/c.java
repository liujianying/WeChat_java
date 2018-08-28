package com.tencent.mm.plugin.location.model.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bfu;
import com.tencent.mm.protocal.c.bfv;
import com.tencent.mm.protocal.c.btp;
import com.tencent.mm.protocal.c.bxg;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c extends l implements k {
    public final b diG;
    private e diJ;
    private Runnable egq;
    public String fFG;
    public int kEb;
    public btp kEc = null;
    public List<bxg> kEd = null;
    public bfv kEe;
    public int kEf;
    private String kEg;

    public c(String str, int i, bxg bxg, int i2, btp btp) {
        a aVar = new a();
        aVar.dIG = new bfu();
        aVar.dIH = new bfv();
        aVar.uri = "/cgi-bin/micromsg-bin/refreshtrackroom";
        aVar.dIF = 492;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bfu bfu = (bfu) this.diG.dID.dIL;
        bfu.rxQ = str;
        bfu.hcE = i;
        bfu.sgW = bxg;
        bfu.jRa = i2;
        bfu.sgX = btp;
        this.kEg = str;
        this.kEf = bfu.hcE;
        x.d("MicroMsg.NetSceneRefreshTrackRoom", "userPosiItem " + bxg.rdS + " " + bxg.stK.rjj + " " + bxg.stK.rji + " heading:" + bxg.stK.sds);
        x.d("MicroMsg.NetSceneRefreshTrackRoom", "userPoi " + btp.rjj + " " + btp.rji + " " + btp.jPe);
        x.d("MicroMsg.NetSceneRefreshTrackRoom", "trackRoomId:" + str + " uploadStatus:" + i);
    }

    public final int getType() {
        return 492;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.kEe = (bfv) ((b) qVar).dIE.dIL;
        if (this.kEe != null) {
            this.fFG = this.kEe.rmO;
        }
        if (i2 == 0 && i3 == 0) {
            this.kEb = this.kEe.rSw;
            this.kEc = this.kEe.sgZ;
            this.kEd = this.kEe.sgY;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(String.format("[ resp count %d ] ", new Object[]{Integer.valueOf(this.kEe.hbF)}));
            if (this.kEc != null) {
                stringBuffer.append(String.format("[ roomPoi  %f %f %s] ", new Object[]{Double.valueOf(this.kEc.rjj), Double.valueOf(this.kEc.rji), this.kEc.jPe}));
            }
            x.d("MicroMsg.NetSceneRefreshTrackRoom", "onGynetEnd " + stringBuffer.toString());
            List linkedList = new LinkedList();
            Iterator it = this.kEe.sgY.iterator();
            while (it.hasNext()) {
                bxg bxg = (bxg) it.next();
                if (bxg == null) {
                    linkedList.add(bxg);
                } else {
                    if (bxg.stK == null) {
                        linkedList.add(bxg);
                    }
                    if (Math.abs(bxg.stK.rji) > 180.0d || Math.abs(bxg.stK.rjj) > 90.0d) {
                        x.w("MicroMsg.NetSceneRefreshTrackRoom", "server lat lng invalid %s %f %f %f", new Object[]{bxg.rdS, Double.valueOf(bxg.stK.rjj), Double.valueOf(bxg.stK.rji), Double.valueOf(bxg.stK.sds)});
                        linkedList.add(bxg);
                    }
                }
            }
            this.kEe.hbF = this.kEe.sgY.size();
        }
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
        if (this.egq != null) {
            this.egq.run();
        }
    }
}
