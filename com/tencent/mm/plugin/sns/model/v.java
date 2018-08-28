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
import com.tencent.mm.protocal.c.bpt;
import com.tencent.mm.protocal.c.bpu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class v extends l implements k {
    private String bKg;
    private int bNI;
    private b diG;
    public e diJ;
    public LinkedList<bps> noG = null;
    public int noH;

    public v(int i) {
        String str;
        this.bNI = i;
        a aVar = new a();
        aVar.dIG = new bpt();
        aVar.dIH = new bpu();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstaglist";
        aVar.dIF = 292;
        aVar.dII = 116;
        aVar.dIJ = 1000000116;
        this.diG = aVar.KT();
        String str2 = af.bys().Np("@__weixintsnstag").field_md5;
        if (str2 == null) {
            str = "";
        } else {
            str = str2;
        }
        this.bKg = str;
        bpt bpt = (bpt) this.diG.dID.dIL;
        bpt.qZc = i;
        bpt.snP = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 292;
    }

    public static t a(t tVar, bps bps) {
        tVar.field_tagId = bps.snO;
        tVar.field_tagName = bi.aG(bps.jSt, "");
        tVar.field_count = bps.hbF;
        tVar.co(bps.hbG);
        x.d("MicroMsg.NetSceneSnsTagList", "tagInfo getList: " + bps.toString());
        return tVar;
    }

    private static boolean a(List<Long> list, Long l) {
        for (Long longValue : list) {
            if (longValue.longValue() == l.longValue()) {
                return true;
            }
        }
        return false;
    }

    public final List<String> eQ(long j) {
        List<String> linkedList = new LinkedList();
        if (this.noG == null) {
            return linkedList;
        }
        Iterator it = this.noG.iterator();
        while (it.hasNext()) {
            bps bps = (bps) it.next();
            if (bps.snO == j) {
                it = bps.hbG.iterator();
                while (it.hasNext()) {
                    linkedList.add(((bhz) it.next()).siM);
                }
                return linkedList;
            }
        }
        return linkedList;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSnsTagList", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            bpu bpu = (bpu) ((b) qVar).dIE.dIL;
            x.d("MicroMsg.NetSceneSnsTagList", "[onGYNetEnd]State：%s", Integer.valueOf(this.noH));
            this.noH = bpu.noH;
            this.noG = bpu.hbG;
            String str2 = bpu.snP;
            if (this.bKg.equals(str2)) {
                this.diJ.a(i2, i3, str, this);
                return;
            }
            List bBG = af.byu().bBG();
            if (this.bNI != 3) {
                Iterator it = bBG.iterator();
                while (it.hasNext()) {
                    Object obj;
                    Long l = (Long) it.next();
                    Iterator it2 = bpu.hbG.iterator();
                    while (it2.hasNext()) {
                        if (l.longValue() == ((bps) it2.next()).snO) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        it.remove();
                        af.byu().fl(l.longValue());
                    }
                }
            }
            Iterator it3 = bpu.hbG.iterator();
            while (it3.hasNext()) {
                bps bps = (bps) it3.next();
                t fk;
                if (a(bBG, Long.valueOf(bps.snO))) {
                    fk = af.byu().fk(bps.snO);
                    if ((fk.field_tagName != null && !fk.field_tagName.equals(bps.jSt)) || fk.field_count != bps.hbF || b(fk, bps)) {
                        a(fk, bps);
                        af.byu().a(fk);
                    }
                } else {
                    fk = new t();
                    a(fk, bps);
                    af.byu().a(fk);
                }
            }
            com.tencent.mm.plugin.sns.storage.l Np = af.bys().Np("@__weixintsnstag");
            Np.field_md5 = str2;
            af.bys().a(Np);
            this.diJ.a(i2, i3, str, this);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }

    private static boolean b(t tVar, bps bps) {
        String[] split = tVar.field_memberList.split(",");
        Iterator it = bps.hbG.iterator();
        while (it.hasNext()) {
            boolean z;
            bhz bhz = (bhz) it.next();
            for (String equals : split) {
                if (equals.equals(bhz)) {
                    z = true;
                    continue;
                    break;
                }
            }
            z = false;
            continue;
            if (!z) {
                return true;
            }
        }
        return false;
    }
}
