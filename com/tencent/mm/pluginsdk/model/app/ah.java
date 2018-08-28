package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.b.b;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.ac.a.a$a;
import com.tencent.mm.protocal.c.aig;
import com.tencent.mm.protocal.c.aih;
import com.tencent.mm.protocal.c.ba;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.cib;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.util.Iterator;
import java.util.LinkedList;

public final class ah extends x {
    private int dPU;
    LinkedList<f> qAr;
    private LinkedList<f> qAs;
    private LinkedList<String> qAt;

    public ah(String str, LinkedList<String> linkedList) {
        x.i("MicroMsg.NetSceneGetSuggestionAppList", "offset: 0, limit = 20, lang = " + str + "installedApp list size: " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            x.i("MicroMsg.NetSceneGetSuggestionAppList", "install id:[%s]", new Object[]{(String) it.next()});
        }
        this.dPU = 3;
        a aVar = new a();
        aVar.dIG = new aig();
        aVar.dIH = new aih();
        aVar.uri = "/cgi-bin/micromsg-bin/getsuggestionapplist";
        aVar.dIF = TbsListener$ErrorCode.INFO_CAN_NOT_USE_X5_TBS_AVAILABLE;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.ivx = aVar.KT();
        aig aig = (aig) this.ivx.dID.dIL;
        aig.jPr = 3;
        aig.jSa = 0;
        aig.jSb = 20;
        aig.jRj = str;
        LinkedList aq = aq(linkedList);
        aig.rLd = aq.size();
        aig.jRK = aq;
        this.qAr = new LinkedList();
        this.qAs = new LinkedList();
        this.qAt = new LinkedList();
        this.qAt.addAll(linkedList);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            aih aih = (aih) this.ivx.dIE.dIL;
            if (aih == null) {
                x.e("MicroMsg.NetSceneGetSuggestionAppList", "resp == null");
                return;
            }
            x.v("MicroMsg.NetSceneGetSuggestionAppList", "suggestion app count = %s, appType = %s, ", new Object[]{Integer.valueOf(aih.rLe), Integer.valueOf(this.dPU)});
            i bmk = a$a.bmm().bmk();
            b(bmk, aih.rLf);
            a(bmk, aih.jSI);
            return;
        }
        x.e("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + i2 + ", errCode = " + i3);
    }

    private void a(i iVar, LinkedList<ba> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ba baVar = (ba) it.next();
                f bl = g.bl(baVar.jPc, true);
                if (bl != null) {
                    a(bl, baVar);
                    iVar.a(bl, new String[0]);
                } else {
                    bl = new f();
                    bl.field_appId = baVar.jPc;
                    a(bl, baVar);
                    iVar.l(bl);
                }
                this.qAs.add(bl);
            }
        }
    }

    private void b(i iVar, LinkedList<bet> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                bet bet = (bet) it.next();
                if (bi.oW(bet.jPc)) {
                    x.e("MicroMsg.NetSceneGetSuggestionAppList", "error appinfo, the appid is null");
                } else {
                    Object obj;
                    boolean z = true;
                    boolean z2 = false;
                    f bl = g.bl(bet.jPc, true);
                    String str;
                    String str2;
                    Object[] objArr;
                    if (bl != null) {
                        boolean z3;
                        a(bl, bet);
                        if (this.dPU == 3) {
                            bl.field_status = 5;
                            if (bi.oW(bl.cmM) || bi.oW(bl.cmL)) {
                                str = "MicroMsg.NetSceneGetSuggestionAppList";
                                str2 = "wrong suggestion params1, has IntroUrl %s, has IconUrl %s";
                                objArr = new Object[2];
                                objArr[0] = Boolean.valueOf(bl.cmM != null);
                                objArr[1] = Boolean.valueOf(bl.cmL != null);
                                x.e(str, str2, objArr);
                                z = false;
                                z3 = false;
                                x.i("MicroMsg.NetSceneGetSuggestionAppList", "update appinfo: AppID = %s, ret = %s, needAddToList = %s", new Object[]{bet.jPc, Boolean.valueOf(z3), Boolean.valueOf(z)});
                                obj = bl;
                            }
                        }
                        z3 = iVar.a(bl, new String[0]);
                        x.i("MicroMsg.NetSceneGetSuggestionAppList", "update appinfo: AppID = %s, ret = %s, needAddToList = %s", new Object[]{bet.jPc, Boolean.valueOf(z3), Boolean.valueOf(z)});
                        obj = bl;
                    } else {
                        f obj2;
                        bl = new f();
                        bl.field_appId = bet.jPc;
                        a(bl, bet);
                        if (this.dPU == 3) {
                            bl.field_status = 5;
                            if (bi.oW(bl.cmM) || bi.oW(bl.cmL)) {
                                str = "MicroMsg.NetSceneGetSuggestionAppList";
                                str2 = "wrong suggestion params2, has IntroUrl %s, has IconUrl %s";
                                objArr = new Object[2];
                                objArr[0] = Boolean.valueOf(bl.cmM != null);
                                objArr[1] = Boolean.valueOf(bl.cmL != null);
                                x.e(str, str2, objArr);
                                z = false;
                                x.i("MicroMsg.NetSceneGetSuggestionAppList", "insert appinfo: AppID = %s, ret = %s, needAddToList = %s", new Object[]{bet.jPc, Boolean.valueOf(z2), Boolean.valueOf(z)});
                                obj2 = bl;
                            }
                        }
                        z2 = iVar.l(bl);
                        x.i("MicroMsg.NetSceneGetSuggestionAppList", "insert appinfo: AppID = %s, ret = %s, needAddToList = %s", new Object[]{bet.jPc, Boolean.valueOf(z2), Boolean.valueOf(z)});
                        obj2 = bl;
                    }
                    if (!(!z || this.qAt.contains(bet.jPc) || this.qAr.contains(obj2))) {
                        this.qAr.add(obj2);
                    }
                }
            }
        }
    }

    private static LinkedList<bhz> aq(LinkedList<String> linkedList) {
        LinkedList<bhz> linkedList2 = new LinkedList();
        if (linkedList == null) {
            return linkedList2;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!bi.oW(str)) {
                linkedList2.add(ab.oT(str));
            }
        }
        return linkedList2;
    }

    private static void a(f fVar, bet bet) {
        fVar.di(bet.rbg);
        fVar.field_appIconUrl = bet.rbh;
        fVar.dh(bet.sgh);
        fVar.field_appName = bet.jSv;
        fVar.dj(bet.rbi);
        fVar.field_appType = bet.rit;
        fVar.dl(bet.jPT);
        fVar.field_packageName = bet.rbj;
        fVar.dm(bet.rbk);
        if (!bi.oW(bet.rbk)) {
            x.i("MicroMsg.NetSceneGetSuggestionAppList", "google play download url is : %s, download flag is %d", new Object[]{bet.rbk, Integer.valueOf(bet.sgr)});
            fVar.eA(bet.sgr);
        }
        fVar.dn(bet.sgo);
        fVar.do(bet.sgp);
        a(fVar, bet.rbl);
        if (!bi.oW(fVar.field_appType)) {
            if (fVar.field_appType.startsWith("1") || fVar.field_appType.startsWith("6")) {
                if (!fVar.field_appType.endsWith(",")) {
                    fVar.field_appType += ",";
                }
                fVar.field_appType = "," + fVar.field_appType;
            }
        }
    }

    private static void a(f fVar, cib cib) {
        x.v("MicroMsg.NetSceneGetSuggestionAppList", "dealYYBDownloadInfos, appId = %s", new Object[]{fVar.field_appId});
        if (cib != null) {
            fVar.eA(cib.sBY);
            fVar.dr(cib.rcY);
            fVar.ds(cib.jTz);
            fVar.dp(cib.sBZ);
            fVar.dq(cib.jTB);
            fVar.cmS = cib.jTC;
            fVar.clZ = true;
            fVar.eB(cib.jTD);
            x.i("MicroMsg.NetSceneGetSuggestionAppList", "get yyb download infos:[%d],[%s],[%s],[%s],[%s],[%s],[%d]", new Object[]{Integer.valueOf(cib.sBY), cib.rcY, cib.jTz, cib.sBZ, cib.jTB, cib.jTC, Integer.valueOf(cib.jTD)});
        }
    }

    private static void a(f fVar, ba baVar) {
        fVar.di(baVar.rbg);
        fVar.dl(baVar.jPT);
        fVar.dj(baVar.rbi);
        fVar.field_appName = baVar.jSv;
        fVar.field_appIconUrl = baVar.rbh;
        fVar.dm(baVar.rbk);
        fVar.cmU = baVar.rbm;
        fVar.clZ = true;
        a(fVar, baVar.rbl);
    }

    public final byte[] cbx() {
        try {
            return ((b) this.ivx.KV()).Ie();
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneGetSuggestionAppList", e.getMessage());
            x.printErrStackTrace("MicroMsg.NetSceneGetSuggestionAppList", e, "", new Object[0]);
            return null;
        }
    }

    public final void bg(byte[] bArr) {
        if (bArr == null) {
            x.e("MicroMsg.NetSceneGetSuggestionAppList", "buf is null");
            return;
        }
        try {
            this.ivx.dIE.G(bArr);
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneGetSuggestionAppList", e.getMessage());
            x.printErrStackTrace("MicroMsg.NetSceneGetSuggestionAppList", e, "", new Object[0]);
        }
    }

    public final int getType() {
        return 4;
    }
}
