package com.tencent.mm.h;

import com.tencent.mm.g.a.ah;
import com.tencent.mm.g.a.ah.a;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.Iterator;

class b$1 extends c<ah> {
    final /* synthetic */ b cZR;

    b$1(b bVar) {
        this.cZR = bVar;
        this.sFo = ah.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ah ahVar = (ah) bVar;
        a aVar = ahVar.bHy;
        b bVar2;
        long j;
        b$a b_a;
        ry ryVar;
        switch (aVar.type) {
            case 1:
                bVar2 = this.cZR;
                String str = aVar.bHA;
                j = bi.getLong(str, 0);
                int i = aVar.position;
                x.i("MicroMsg.BroadcastController", "summerdiz cancelUIEvent cancelNoticeIDStr[%s] cancelPosition[%d], oldNoticeInfo[%s] newDisasterNoticeInfoMap[%d] ", new Object[]{str, Integer.valueOf(i), bVar2.cZN, Integer.valueOf(bVar2.cZP.size())});
                if (bVar2.cZP.size() > 0 && j > 0) {
                    b_a = (b$a) bVar2.cZP.get(Long.valueOf(j));
                    if (b_a != null) {
                        x.i("MicroMsg.BroadcastController", "summerdiz cancelUIEvent found info[%s]", new Object[]{b_a});
                        if (i <= 0) {
                            Collection values = b_a.cZX.values();
                            if (values != null) {
                                Iterator it = values.iterator();
                                if (it != null) {
                                    while (it.hasNext()) {
                                        ryVar = (ry) it.next();
                                        if (ryVar != null && ryVar.ccN.YN) {
                                            x.i("MicroMsg.BroadcastController", "summerdiz cancelPosition[%d] found event[%b]", new Object[]{Long.valueOf(j), Boolean.valueOf(ryVar.ccN.YN)});
                                            ryVar.ccN.YN = false;
                                            com.tencent.mm.sdk.b.a.sFg.m(ryVar);
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                        ryVar = (ry) b_a.cZX.get(Integer.valueOf(i));
                        if (ryVar != null) {
                            x.i("MicroMsg.BroadcastController", "summerdiz cancelPosition[%d] found event[%b]", new Object[]{Integer.valueOf(i), Boolean.valueOf(ryVar.ccN.YN)});
                            if (ryVar.ccN.YN) {
                                ryVar.ccN.YN = false;
                                com.tencent.mm.sdk.b.a.sFg.m(ryVar);
                                h.mEJ.h(13939, new Object[]{Integer.valueOf(2)});
                                break;
                            }
                        }
                        x.i("MicroMsg.BroadcastController", "summerdiz cancelPosition[%d] not found event", new Object[]{Integer.valueOf(i)});
                    } else {
                        x.i("MicroMsg.BroadcastController", "summerdiz cancelNoticeID not found info");
                    }
                }
                if (bVar2.cZN != null) {
                    if (!bi.oW(str) && !str.equals(bVar2.cZN.cZU)) {
                        x.i("MicroMsg.BroadcastController", "summerdiz cancelUIEvent old now:[%s], want to cancel:[%s], drop id", new Object[]{bVar2.cZN.cZU, str});
                        break;
                    }
                    ryVar = (ry) bVar2.cZN.cZX.get(Integer.valueOf(0));
                    if (ryVar != null && ryVar.ccN.YN) {
                        h.mEJ.h(13939, new Object[]{Integer.valueOf(2)});
                        ryVar.ccN.YN = false;
                        com.tencent.mm.sdk.b.a.sFg.m(ryVar);
                        break;
                    }
                }
                break;
            case 2:
                bVar2 = this.cZR;
                int i2 = ahVar.bHy.position;
                x.i("MicroMsg.BroadcastController", "summerdiz handlePullNotify position[%d],oldNoticeInfo[%s], positionNoticeIdMap[%d]", new Object[]{Integer.valueOf(i2), bVar2.cZN, Integer.valueOf(bVar2.cZO.size())});
                if (i2 <= 0 || bVar2.cZO.size() <= 0) {
                    if (bVar2.cZN != null) {
                        ryVar = (ry) bVar2.cZN.cZX.get(Integer.valueOf(0));
                        if (ryVar != null) {
                            ahVar.bHz.desc = ryVar.ccN.desc;
                            ahVar.bHz.bHB = ryVar.ccN.bHB;
                            ahVar.bHz.showType = ryVar.ccN.showType;
                            ahVar.bHz.url = ryVar.ccN.url;
                            ahVar.bHz.YN = ryVar.ccN.YN;
                            ahVar.bHz.bHE = ryVar.ccN.bHE;
                            ahVar.bHz.bHC = ryVar.ccN.bHC;
                            ahVar.bHz.bHD = ryVar.ccN.bHD;
                            ahVar.bHz.bHF = ryVar.ccN.bHF;
                            ahVar.bHz.position = ryVar.ccN.position;
                            if (ryVar.ccN.YN) {
                                h.mEJ.h(13936, new Object[]{Integer.valueOf(i2)});
                            }
                            bVar2.ym();
                            break;
                        }
                    }
                }
                j = bi.a((Long) bVar2.cZO.get(Integer.valueOf(i2)), 0);
                x.i("MicroMsg.BroadcastController", "summerdiz handlePullNotify position[%d] found noticeId[%d]", new Object[]{Integer.valueOf(i2), Long.valueOf(j)});
                if (j > 0) {
                    b_a = (b$a) bVar2.cZP.get(Long.valueOf(j));
                    if (b_a != null) {
                        ryVar = (ry) b_a.cZX.get(Integer.valueOf(i2));
                        if (ryVar != null) {
                            ahVar.bHz.desc = ryVar.ccN.desc;
                            ahVar.bHz.bHB = ryVar.ccN.bHB;
                            ahVar.bHz.showType = ryVar.ccN.showType;
                            ahVar.bHz.url = ryVar.ccN.url;
                            ahVar.bHz.YN = ryVar.ccN.YN;
                            ahVar.bHz.bHE = ryVar.ccN.bHE;
                            ahVar.bHz.bHC = ryVar.ccN.bHC;
                            ahVar.bHz.bHD = ryVar.ccN.bHD;
                            ahVar.bHz.bHF = ryVar.ccN.bHF;
                            ahVar.bHz.position = ryVar.ccN.position;
                            if (ryVar.ccN.YN) {
                                h.mEJ.h(13936, new Object[]{Integer.valueOf(i2)});
                                break;
                            }
                        }
                    }
                    bVar2.cZO.remove(Integer.valueOf(i2));
                    break;
                }
                break;
            case 4:
                this.cZR.eW(aVar.bHA);
                break;
            case 5:
                this.cZR.a(ahVar);
                break;
        }
        return false;
    }
}
