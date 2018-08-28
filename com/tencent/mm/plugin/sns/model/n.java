package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.bol;
import com.tencent.mm.protocal.c.bom;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public final class n extends l implements k {
    private static Vector<String> nnU = new Vector();
    final int bJt;
    private String desc = "";
    private b diG;
    public e diJ;
    private boolean hxu = false;
    private ArrayList<com.tencent.mm.plugin.sns.storage.n> hyp = new ArrayList();
    private boolean nnR;
    private long nnS = 0;
    private long nnT = 0;
    public int nnV = 0;
    public int nnW = 0;

    public static synchronized boolean Mb(String str) {
        boolean z;
        synchronized (n.class) {
            if (nnU.contains(str)) {
                z = false;
            } else {
                nnU.add(str);
                z = true;
            }
        }
        return z;
    }

    public static synchronized boolean Mc(String str) {
        synchronized (n.class) {
            nnU.remove(str);
        }
        return true;
    }

    public n(String str) {
        a aVar = new a();
        aVar.dIG = new bol();
        aVar.dIH = new bom();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsclassifytimeline";
        aVar.dIF = 601;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.nnS = 0;
        this.nnR = 0 == 0;
        this.bJt = 2;
        bol bol = (bol) this.diG.dID.dIL;
        bol.smu = "";
        bol.smv = 0;
        bol.smw = str;
        bol.smx = 1;
        x.d("MicroMsg.NetSceneSnsClassifyTimeLine", "maxid %s classifyid %s classifyType %d", new Object[]{i.eF(0), str, Integer.valueOf(0)});
    }

    private com.tencent.mm.plugin.sns.storage.n b(boy boy) {
        com.tencent.mm.plugin.sns.storage.n nVar = new com.tencent.mm.plugin.sns.storage.n();
        String str = new String(boy.smH.siK.toByteArray());
        x.d("MicroMsg.NetSceneSnsClassifyTimeLine", "from server %d ", new Object[]{Long.valueOf(boy.rlK)});
        if (!nVar.Nj(str)) {
            return null;
        }
        boy.smH.bq(new byte[0]);
        nVar.field_userName = boy.rdS;
        nVar.hK(boy.lOH);
        nVar.field_likeFlag = boy.smI;
        nVar.fe(boy.rlK);
        nVar.fg(boy.rlK);
        nVar.wZ(this.bJt);
        try {
            nVar.aK(boy.toByteArray());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneSnsClassifyTimeLine", e, "", new Object[0]);
        }
        bsu bAJ = nVar.bAJ();
        bAJ.hbL = boy.rdS;
        nVar.field_pravited = bAJ.rVG;
        x.d("MicroMsg.NetSceneSnsClassifyTimeLine", "ext flag " + boy.rXx);
        nVar.bBb();
        nVar.c(bAJ);
        nVar.field_type = bAJ.sqc.ruz;
        nVar.field_subType = bAJ.sqc.ruB;
        return nVar;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSnsClassifyTimeLine", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bom bom = (bom) ((b) qVar).dIE.dIL;
        if (qVar.Id().qWB == 207 || qVar.Id().qWB == 0 || qVar.Id().qWB == 212) {
            this.hxu = qVar.Id().qWB == 212;
            this.nnV = bom.smy;
            this.desc = bom.rej;
            i.eG(this.nnS);
            x.d("MicroMsg.NetSceneSnsClassifyTimeLine", "resp objCount %d desc %s", new Object[]{Integer.valueOf(bom.rXE), this.desc});
            Iterator it = bom.rgH.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.sns.storage.n b = b((boy) it.next());
                if (b != null) {
                    this.hyp.add(b);
                }
            }
            Mc("@__classify_timeline");
            this.diJ.a(i2, i3, str, this);
            return;
        }
        Mc("@__classify_timeline");
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 601;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
