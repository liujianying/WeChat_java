package com.tencent.mm.plugin.expt.b;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.adm;
import com.tencent.mm.protocal.c.adn;
import com.tencent.mm.protocal.c.un;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public final class b extends l implements k {
    private e diJ;
    private int iHZ;

    public b() {
        this.iHZ = 0;
        this.iHZ = 1;
    }

    public final int getType() {
        return 2738;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 0;
        this.diJ = eVar2;
        long VG = bi.VG();
        a aVar = new a();
        aVar.dIG = new adm();
        aVar.dIH = new adn();
        aVar.uri = "/cgi-bin/mmexptappsvr-bin/getexptconfig";
        aVar.dIF = 2738;
        aVar.dII = 0;
        aVar.dIJ = 0;
        com.tencent.mm.ab.b KT = aVar.KT();
        adm adm = (adm) KT.dID.dIL;
        adm.otY = this.iHZ;
        adm.rHT = ((Integer) g.Ei().DT().get(aa.a.sZW, Integer.valueOf(0))).intValue();
        List<com.tencent.mm.plugin.expt.c.a> aIH = a.aIu().iHQ.aIH();
        if (aIH != null && aIH.size() > 0) {
            adm.rHU = new LinkedList();
            for (com.tencent.mm.plugin.expt.c.a aVar2 : aIH) {
                un unVar = new un();
                unVar.rxV = aVar2.field_exptId;
                unVar.rxW = aVar2.field_groupId;
                unVar.rxX = aVar2.field_exptSeq;
                adm.rHU.add(unVar);
            }
            x.i("MicroMsg.NetSceneGetExpt", "req local exptList [%s] ", new Object[]{Arrays.toString(aIH.toArray())});
        }
        h.mEJ.a(863, 0, 1, false);
        String str = "MicroMsg.NetSceneGetExpt";
        String str2 = "get expt config scene[%d] lastGetSvrSec[%d] localExptList[%d] cost[%d]";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(adm.otY);
        objArr[1] = Integer.valueOf(adm.rHT);
        if (adm.rHU != null) {
            i = adm.rHU.size();
        }
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Long.valueOf(bi.bI(VG));
        x.i(str, str2, objArr);
        return a(eVar, KT, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetExpt", "get expt on gy end. errType[%d] erroCode[%d] errMsg[%s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            adn adn = (adn) ((com.tencent.mm.ab.b) qVar).dIE.dIL;
            if (adn != null) {
                if (adn.six.rfn != 0) {
                    x.w("MicroMsg.NetSceneGetExpt", "get expt error. resp baseResp [%d] [%s]", new Object[]{Integer.valueOf(adn.six.rfn), adn.six.rgv});
                    h.mEJ.a(863, 2, 1, false);
                } else {
                    Object obj;
                    int i4;
                    int i5;
                    long VG = bi.VG();
                    po(adn.rHV);
                    int i6 = adn.rHW;
                    g.Ei().DT().a(aa.a.sZV, Integer.valueOf(i6));
                    if (adn.rHZ == 1) {
                        h.mEJ.a(863, 7, 1, false);
                        long VG2 = bi.VG();
                        a aIu = a.aIu();
                        int aIG = aIu.iHQ.aIG();
                        int aIG2 = aIu.iHR.aIG();
                        x.i("MicroMsg.ExptService", "delete all expt count[%d] map count[%d]", new Object[]{Integer.valueOf(aIG), Integer.valueOf(aIG2)});
                        aIu.aIt();
                        x.i("MicroMsg.NetSceneGetExpt", "check need del all expt count[%d] cost[%d]", new Object[]{Integer.valueOf(aIG), Long.valueOf(bi.bI(VG2))});
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    List list = adn.rHX;
                    if (list == null || list.size() <= 0) {
                        i4 = 0;
                    } else {
                        x.i("MicroMsg.NetSceneGetExpt", "delete expt [%s]", new Object[]{Arrays.toString(list.toArray())});
                        i4 = a.aIu().aV(list);
                    }
                    LinkedList<un> linkedList = adn.rHY;
                    if (linkedList == null || linkedList.size() <= 0) {
                        i5 = 0;
                    } else {
                        List linkedList2 = new LinkedList();
                        for (un unVar : linkedList) {
                            com.tencent.mm.plugin.expt.c.a aVar = new com.tencent.mm.plugin.expt.c.a();
                            aVar.AC(unVar.rxY);
                            if (aVar.field_exptId != unVar.rxV || aVar.field_groupId != unVar.rxW || aVar.field_exptSeq != unVar.rxX) {
                                x.w("MicroMsg.NetSceneGetExpt", "expt item proto[%d %d %d] is different expt content[%d %d %d]", new Object[]{Integer.valueOf(unVar.rxV), Integer.valueOf(unVar.rxW), Integer.valueOf(unVar.rxX), Integer.valueOf(aVar.field_exptId), Integer.valueOf(aVar.field_groupId), Integer.valueOf(aVar.field_exptSeq)});
                                h.mEJ.a(863, 6, 1, false);
                            }
                            linkedList2.add(aVar);
                            x.i("MicroMsg.NetSceneGetExpt", "get expt item [%s]", new Object[]{aVar.toString()});
                        }
                        i5 = a.aIu().aU(linkedList2);
                    }
                    if (obj != null || i4 > 0 || i5 > 0) {
                        a.aIu();
                        a.aIv();
                    }
                    h.mEJ.a(863, 1, 1, false);
                    String str2 = "MicroMsg.NetSceneGetExpt";
                    String str3 = "update expt svrTime:%d interval:%d exptFlag:%d  deleteCount:[svr:%d local:%d] replaceCount:[svr:%d local:%d] cost[%d]";
                    Object[] objArr = new Object[8];
                    objArr[0] = Integer.valueOf(adn.rHV);
                    objArr[1] = Integer.valueOf(i6);
                    objArr[2] = Integer.valueOf(adn.rHZ);
                    objArr[3] = Integer.valueOf(list != null ? list.size() : 0);
                    objArr[4] = Integer.valueOf(i4);
                    objArr[5] = Integer.valueOf(linkedList != null ? linkedList.size() : 0);
                    objArr[6] = Integer.valueOf(i5);
                    objArr[7] = Long.valueOf(bi.bI(VG));
                    x.i(str2, str3, objArr);
                }
            }
        } else {
            h.mEJ.a(863, 2, 1, false);
            x.w("MicroMsg.NetSceneGetExpt", "get expt error");
            po((int) bi.VE());
        }
        this.diJ.a(i2, i3, str, this);
    }

    private static void po(int i) {
        int VE = (int) bi.VE();
        if (VE > i) {
            g.Ei().DT().a(aa.a.sZW, Integer.valueOf(VE));
        } else {
            g.Ei().DT().a(aa.a.sZW, Integer.valueOf(i));
        }
    }
}
