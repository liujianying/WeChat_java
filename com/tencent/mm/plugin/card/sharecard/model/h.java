package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.a.2;
import com.tencent.mm.protocal.c.bmw;
import com.tencent.mm.protocal.c.bmx;
import com.tencent.mm.protocal.c.bmy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.List;

public final class h extends l implements k {
    private final b diG;
    private e diJ;

    public h() {
        a aVar = new a();
        aVar.dIG = new bmx();
        aVar.dIH = new bmy();
        aVar.uri = "/cgi-bin/micromsg-bin/sharecardsync";
        aVar.dIF = 906;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((bmx) this.diG.dID.dIL).slc = ((Long) g.Ei().DT().get(aa.a.sQb, Long.valueOf(0))).longValue();
    }

    public final int getType() {
        return 906;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(906), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            bmy bmy = (bmy) this.diG.dIE.dIL;
            List<bmw> list = bmy.dzs == null ? null : bmy.dzs;
            String str2 = "MicroMsg.NetSceneShareCardSync";
            String str3 = "onGYNetEnd, share card cmd list size = %d, continueFlag = %d, req = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
            objArr[1] = Integer.valueOf(bmy.sld);
            objArr[2] = Long.valueOf(bmy.slb);
            x.i(str2, str3, objArr);
            if (list == null || list.size() <= 0) {
                x.i("MicroMsg.NetSceneShareCardSync", "share cmdList == null or size is 0");
                com.tencent.mm.plugin.card.sharecard.a.a axp = am.axp();
                x.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr sharecardsync retryAll, getNow = %b", new Object[]{Boolean.valueOf(true)});
                synchronized (axp.dsN) {
                    axp.hty.addAll(axp.htz);
                    axp.htz.clear();
                }
                axp.awz();
            } else {
                int i4 = 0;
                for (bmw a : list) {
                    int i5;
                    if (a(a)) {
                        i5 = i4;
                    } else {
                        i5 = i4 + 1;
                    }
                    i4 = i5;
                }
                x.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, %d fail share cmds", new Object[]{Integer.valueOf(i4)});
                am.axp().awz();
            }
            g.Ei().DT().a(aa.a.sQb, Long.valueOf(bmy.slb));
            am.axp().hyc = bmy.hyc;
            if (bmy.sld > 0) {
                x.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, should continue, continueFlag = %d", new Object[]{Integer.valueOf(bmy.sld)});
                com.tencent.mm.plugin.card.sharecard.a.a axp2 = am.axp();
                axp2.mHandler.post(new 2(axp2));
            }
            this.diJ.a(i2, i3, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, share card sync fail, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.diJ.a(i2, i3, str, this);
    }

    private static boolean a(bmw bmw) {
        if (bmw == null) {
            x.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, null cmd");
            return false;
        }
        x.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, item card_id = %s, seq = %d", new Object[]{bmw.cac, Long.valueOf(bmw.slb)});
        try {
            x.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, Status = %d", new Object[]{Integer.valueOf(bmw.hyk)});
            switch (bmw.hyk) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                    com.tencent.mm.plugin.card.sharecard.a.a axp = am.axp();
                    if (bmw != null) {
                        long j;
                        ShareCardInfo xC = am.axq().xC(bmw.cac);
                        String str = "MicroMsg.ShareCardBatchGetCardMgr";
                        String str2 = "scsmgr pushShareCardSyncItem, card_id = %s, localSeq = %d, svrSeq = %d";
                        Object[] objArr = new Object[3];
                        objArr[0] = bmw.cac;
                        if (xC == null) {
                            j = 0;
                        } else {
                            j = xC.field_updateSeq;
                        }
                        objArr[1] = Long.valueOf(j);
                        objArr[2] = Long.valueOf(bmw.slb);
                        x.i(str, str2, objArr);
                        if (xC != null && xC.field_updateSeq == bmw.slb) {
                            x.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr push ShareCardSyncItem fail, card.field_updateSeq == item.seq");
                            break;
                        }
                        n b = n.b(bmw);
                        synchronized (axp.dsN) {
                            if (!axp.hty.contains(b)) {
                                if (!axp.htz.contains(b)) {
                                    axp.hty.add(b);
                                    boolean b2 = am.axr().b(b);
                                    x.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr pushShareCardSyncItem, insertRet = %b", new Object[]{Boolean.valueOf(b2)});
                                    break;
                                }
                            }
                        }
                    } else {
                        x.e("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr push fail, ShareCardSyncItem is null");
                        break;
                    }
                    break;
                case 6:
                    com.tencent.mm.plugin.card.sharecard.a.a axp2 = am.axp();
                    if (bmw != null) {
                        ShareCardInfo xC2 = am.axq().xC(bmw.cac);
                        am.axq().xB(bmw.cac);
                        x.i("MicroMsg.ShareCardBatchGetCardMgr", "delete share card for id " + bmw.cac);
                        if (xC2 != null) {
                            com.tencent.mm.plugin.card.sharecard.a.b.a(ad.getContext(), xC2);
                        } else {
                            x.e("MicroMsg.ShareCardBatchGetCardMgr", "info is null");
                        }
                        axp2.auM();
                        break;
                    }
                    x.e("MicroMsg.ShareCardBatchGetCardMgr", "delete item is  null");
                    break;
                default:
                    x.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, unknown StateFlag = %d", new Object[]{Integer.valueOf(bmw.hyk)});
                    return false;
            }
            if (!(bmw.hyk == 0 || bmw.hyk == 5)) {
                String str3 = (String) g.Ei().DT().get(aa.a.sQj, "");
                boolean booleanValue = ((Boolean) g.Ei().DT().get(aa.a.sQk, Boolean.valueOf(false))).booleanValue();
                if (booleanValue && !bi.oW(str3) && str3.equals(bmw.cac)) {
                    x.i("MicroMsg.NetSceneShareCardSync", "need check is true, do clearRedDotAndWording()");
                    com.tencent.mm.plugin.card.b.k.awV();
                } else if (booleanValue) {
                    x.i("MicroMsg.NetSceneShareCardSync", "need check is true, but card id is diff!");
                } else {
                    x.i("MicroMsg.NetSceneShareCardSync", "need check is false");
                }
            }
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, ex = %s", new Object[]{e.getMessage()});
            return false;
        }
    }
}
