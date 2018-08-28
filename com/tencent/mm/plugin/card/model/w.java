package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.aqo;
import com.tencent.mm.protocal.c.ld;
import com.tencent.mm.protocal.c.le;
import com.tencent.mm.protocal.c.lh;
import com.tencent.mm.protocal.c.pm;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.List;

public final class w extends l implements k {
    private byte[] dZu;
    private final b diG;
    private e diJ;
    private int hxe = 0;

    public w(int i) {
        x.d("MicroMsg.NetSceneCardSync", "<init>, selector = %d", new Object[]{Integer.valueOf(1)});
        a aVar = new a();
        aVar.dIG = new ld();
        aVar.dIH = new le();
        aVar.uri = "/cgi-bin/micromsg-bin/cardsync";
        aVar.dIF = 558;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aqo aqo = new aqo();
        aqo.hym = (String) g.Ei().DT().get(aa.a.sPR, null);
        aqo.latitude = (double) am.axo().cXm;
        aqo.longitude = (double) am.axo().cXn;
        ld ldVar = (ld) this.diG.dID.dIL;
        ldVar.rnx = 1;
        ldVar.rnz = aqo;
        ldVar.rnA = i;
        this.hxe = i;
    }

    public final int getType() {
        return 558;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        ld ldVar = (ld) this.diG.dID.dIL;
        this.dZu = bi.WP(bi.oV((String) g.Ei().DT().get(282880, null)));
        if (this.dZu == null || this.dZu.length == 0) {
            x.e("MicroMsg.NetSceneCardSync", "doScene, keyBuf is null, init card sync~~~");
        }
        ldVar.rny = ab.O(this.dZu);
        String str = "MicroMsg.NetSceneCardSync";
        String str2 = "doScene, keyBuf.length = %d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(this.dZu == null ? 0 : this.dZu.length);
        x.i(str, str2, objArr);
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            le leVar = (le) this.diG.dIE.dIL;
            if (leVar.rnC == 1) {
                x.i("MicroMsg.NetSceneCardSync", "need do getCardsLayoutScene");
            }
            this.dZu = ab.a(leVar.rny, new byte[0]);
            List<pm> list = leVar.rnB == null ? null : leVar.rnB.hbG;
            String str2 = "MicroMsg.NetSceneCardSync";
            String str3 = "onGYNetEnd, cmd list size = %d, synckey length = %d, continueFlag = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
            objArr[1] = Integer.valueOf(this.dZu == null ? 0 : this.dZu.length);
            objArr[2] = Integer.valueOf(leVar.rlm);
            x.i(str2, str3, objArr);
            if (list == null || list.size() <= 0) {
                x.i("MicroMsg.NetSceneCardSync", "cmdList == null or size is 0");
                com.tencent.mm.plugin.card.b.b axh = am.axh();
                x.i("MicroMsg.BatchGetCardMgr", "retryAll, getNow = %b", new Object[]{Boolean.valueOf(true)});
                synchronized (axh.dsN) {
                    axh.hty.addAll(axh.htz);
                    axh.htz.clear();
                }
                axh.awz();
            } else {
                int i4 = 0;
                for (pm a : list) {
                    int i5;
                    if (a(a)) {
                        i5 = i4;
                    } else {
                        i5 = i4 + 1;
                    }
                    i4 = i5;
                }
                x.i("MicroMsg.NetSceneCardSync", "onGYNetEnd, %d fail cmds", new Object[]{Integer.valueOf(i4)});
                am.axh().awz();
            }
            g.Ei().DT().set(282880, bi.bE(this.dZu));
            if (leVar.rlm > 0) {
                x.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, should continue, continueFlag = %d", new Object[]{Integer.valueOf(leVar.rlm)});
                if (a(this.dIX, this.diJ) <= 0) {
                    x.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, doScene again fail, ret = %d", new Object[]{Integer.valueOf(a(this.dIX, this.diJ))});
                    this.diJ.a(3, -1, str, this);
                    return;
                }
                return;
            }
            this.diJ.a(0, 0, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, card sync fail, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.diJ.a(i2, i3, str, this);
    }

    private static boolean a(pm pmVar) {
        if (pmVar == null) {
            x.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null cmd");
            return false;
        }
        byte[] a = ab.a(pmVar.rtN);
        if (a == null || a.length == 0) {
            x.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null buf");
            return false;
        }
        x.d("MicroMsg.NetSceneCardSync", "processCmdItem, buf length = %d, cmdId = %d", new Object[]{Integer.valueOf(a.length), Integer.valueOf(pmVar.rtM)});
        try {
            switch (pmVar.rtM) {
                case 1:
                    lh lhVar = (lh) new lh().aG(a);
                    x.i("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, Status = %d", new Object[]{Integer.valueOf(lhVar.hcd)});
                    switch (lhVar.hcd) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 7:
                            com.tencent.mm.plugin.card.b.b axh = am.axh();
                            if (lhVar != null) {
                                long j;
                                CardInfo xm = am.axi().xm(lhVar.ros);
                                String str = "MicroMsg.BatchGetCardMgr";
                                String str2 = "pushCardUserItem, cardUserId = %s, localSeq = %d, svrSeq = %d";
                                Object[] objArr = new Object[3];
                                objArr[0] = lhVar.ros;
                                if (xm == null) {
                                    j = 0;
                                } else {
                                    j = xm.field_updateSeq;
                                }
                                objArr[1] = Long.valueOf(j);
                                objArr[2] = Long.valueOf(lhVar.rot);
                                x.i(str, str2, objArr);
                                if (xm != null && xm.field_updateSeq == lhVar.rot) {
                                    x.e("MicroMsg.BatchGetCardMgr", "push CardUserItem fail, card.field_updateSeq == item.UpdateSequence");
                                    break;
                                }
                                ak a2 = ak.a(lhVar);
                                synchronized (axh.dsN) {
                                    if (!axh.hty.contains(a2)) {
                                        if (!axh.htz.contains(a2)) {
                                            axh.hty.add(a2);
                                            boolean b = am.axj().b(a2);
                                            x.i("MicroMsg.BatchGetCardMgr", "pushCardUserItem, insertRet = %b", new Object[]{Boolean.valueOf(b)});
                                            break;
                                        }
                                    }
                                }
                            } else {
                                x.e("MicroMsg.BatchGetCardMgr", "push fail, CardUserItem is null");
                                break;
                            }
                            break;
                        case 6:
                            break;
                        default:
                            x.e("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, unknown StateFlag = %d", new Object[]{Integer.valueOf(lhVar.rou)});
                            return false;
                    }
                    return true;
                default:
                    x.w("MicroMsg.NetSceneCardSync", "processCmdItem, unknown cmdId = %d", new Object[]{Integer.valueOf(pmVar.rtM)});
                    return false;
            }
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, ex = %s", new Object[]{e.getMessage()});
            return false;
        }
        x.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, ex = %s", new Object[]{e.getMessage()});
        return false;
    }
}
