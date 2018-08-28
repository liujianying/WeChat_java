package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.c;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.amh;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.boh;
import com.tencent.mm.protocal.c.boi;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.bpq;
import com.tencent.mm.protocal.c.bpr;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.protocal.c.pm;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class u extends l implements k {
    private static List<ap> nou = new LinkedList();
    private static c now;
    private static boolean nox = true;
    private String cXR = "";
    b diG;
    e diJ;
    private a nov = new a(this);

    public u() {
        a aVar = new a();
        aVar.dIG = new bpq();
        aVar.dIH = new bpr();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnssync";
        aVar.dIF = 214;
        aVar.dII = 102;
        aVar.dIJ = 1000000102;
        this.diG = aVar.KT();
        ((bpq) this.diG.dID.dIL).rnx = 256;
        this.cXR = q.GF();
        if (nox) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            g.Ek();
            String stringBuilder2 = stringBuilder.append(g.Ei().cachePath).append("ad_1100007").toString();
            x.i("MicroMsg.NetSceneNewSyncAlbum", "filepath to list  " + stringBuilder2);
            byte[] e = FileOp.e(stringBuilder2, 0, -1);
            if (e != null) {
                try {
                    now = (c) new c().aG(e);
                    x.i("MicroMsg.NetSceneNewSyncAlbum", "fileToList " + (System.currentTimeMillis() - currentTimeMillis));
                    if (now == null) {
                        x.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId parser error");
                    } else {
                        x.i("MicroMsg.NetSceneNewSyncAlbum", "igNoreAbTestId size " + now.nuR.size());
                    }
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e2, "", new Object[0]);
                    FileOp.deleteFile(stringBuilder2);
                }
            }
            nox = false;
        }
    }

    protected final int Cc() {
        return 10;
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return b.dJm;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        g.Ek();
        byte[] WP = bi.WP(bi.oV((String) g.Ei().DT().get(8195, null)));
        bhy bhy = new bhy();
        bhy.bq(WP);
        ((bpq) this.diG.dID.dIL).rny = bhy;
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public static void eM(long j) {
        if (now == null) {
            now = new c();
        }
        now.nuR.add(Long.valueOf(j));
    }

    public static void eN(long j) {
        if (now != null) {
            now.nuR.remove(Long.valueOf(j));
        }
    }

    public static boolean eO(long j) {
        if (now != null && now.nuR.contains(Long.valueOf(j))) {
            return true;
        }
        return false;
    }

    public static void bxJ() {
        if (now != null) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            g.Ek();
            String stringBuilder2 = stringBuilder.append(g.Ei().cachePath).append("ad_1100007").toString();
            x.i("MicroMsg.NetSceneNewSyncAlbum", "listToFile to list  " + stringBuilder2);
            try {
                byte[] toByteArray = now.toByteArray();
                com.tencent.mm.a.e.b(stringBuilder2, toByteArray, toByteArray.length);
                x.i("MicroMsg.NetSceneNewSyncAlbum", "listTofile " + (System.currentTimeMillis() - currentTimeMillis) + " igNoreAbTestId " + now.nuR.size());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "listToFile failed: " + stringBuilder2, new Object[0]);
            }
        }
    }

    public final boolean KX() {
        return true;
    }

    public final int getType() {
        return 214;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneNewSyncAlbum", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            bpr bpr = (bpr) ((b) qVar).dIE.dIL;
            LinkedList linkedList = bpr.rnB.hbG;
            if (linkedList == null || linkedList.size() <= 0) {
                if (!(bpr.rny == null || bpr.rny.siK == null)) {
                    byte[] g = z.g(((bpq) ((b) qVar).dID.dIL).rny.siK.toByteArray(), bpr.rny.siK.toByteArray());
                    if (g != null && g.length > 0) {
                        g.Ek();
                        g.Ei().DT().set(8195, bi.bE(g));
                    }
                }
                this.diJ.a(i2, i3, str, this);
                return;
            }
            x.d("MicroMsg.NetSceneNewSyncAlbum", "cmlList size:" + linkedList.size());
            a aVar = this.nov;
            aVar.iWX = linkedList;
            aVar.iWY.sendEmptyMessage(0);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final boolean a(pm pmVar, ag agVar) {
        try {
            boy boy = (boy) new boy().aG(pmVar.rtN.siK.toByteArray());
            String str = new String(boy.smH.siK.toByteArray());
            boolean z = str.indexOf("<contentStyle><![CDATA[1]]></contentStyle>") >= 0 || str.indexOf("<contentStyle>1</contentStyle>") >= 0;
            x.i("MicroMsg.NetSceneNewSyncAlbum", "snsSync " + boy.rlK + " " + i.eF(boy.rlK) + " isPhoto " + z);
            if (z) {
                String eF = i.eF(boy.rlK);
                com.tencent.mm.plugin.sns.storage.l Np = af.bys().Np(boy.rdS);
                if (bi.oW(Np.field_newerIds)) {
                    af.bys().eM(boy.rdS, eF);
                } else {
                    String[] split = Np.field_newerIds.split(",");
                    z = true;
                    for (Object equals : split) {
                        if (eF.equals(equals)) {
                            z = false;
                        }
                    }
                    int i = 0;
                    String str2 = eF;
                    while (i < 2 && i < split.length && z) {
                        str2 = str2 + "," + split[i];
                        i++;
                    }
                    x.d("MicroMsg.NetSceneNewSyncAlbum", "snsync newerIds " + boy.rlK + " S: " + eF + " list " + Np.field_newerIds + " newer " + str2);
                    if (z) {
                        af.bys().eM(boy.rdS, str2);
                    }
                }
            }
            if (af.byo().fa(boy.rlK)) {
                x.i("MicroMsg.NetSceneNewSyncAlbum", "this item has in your sns pass it");
                return false;
            }
            com.tencent.mm.sdk.b.a.sFg.m(new qf());
            af.aRu().post(new 1(this, boy, agVar));
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return false;
        }
    }

    public final boolean b(pm pmVar, ag agVar) {
        try {
            boolean z;
            boi boi = (boi) new boi().aG(pmVar.rtN.siK.toByteArray());
            long j = boi.rlK;
            long j2 = boi.smn;
            boh boh = boi.smo;
            String str = boi.rcc;
            if (str == null) {
                str = "";
            }
            x.i("MicroMsg.NetSceneNewSyncAlbum", "process action " + boh.hcE + " " + j + " " + str);
            j c;
            boolean a;
            com.tencent.mm.plugin.sns.storage.k byt;
            String str2;
            switch (boh.hcE) {
                case 9:
                    c = af.byt().c(j, (long) boh.smh, boh.hcE);
                    if (c != null) {
                        c.bAN();
                        a = af.byt().a(c.sKx, c);
                        aj.b(j, boi);
                        x.i("MicroMsg.NetSceneNewSyncAlbum", " setdel flag  " + a);
                        break;
                    }
                    break;
                case 10:
                    c = af.byt().c(j, boh.smk, boh.hcE);
                    if (c != null) {
                        c.bAN();
                        a = af.byt().a(c.sKx, c);
                        aj.b(j, boi);
                        x.i("MicroMsg.NetSceneNewSyncAlbum", " setdel ad flag  " + a);
                        break;
                    }
                    break;
                case 11:
                    byt = af.byt();
                    str2 = " update SnsComment set commentflag = commentflag | 2 where snsID = " + j;
                    x.i("MicroMsg.SnsCommentStorage", "set sns del " + str2);
                    x.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsDelAction " + byt.dCZ.fV("SnsComment", str2));
                    break;
                case 12:
                    byt = af.byt();
                    str2 = " update SnsComment set commentflag = commentflag | 2 where snsID = " + j + " and talker = " + bi.oU(boh.seC);
                    x.i("MicroMsg.SnsCommentStorage", "set sns del  by username " + str2);
                    x.i("MicroMsg.NetSceneNewSyncAlbum", "processSnsDelAction " + byt.dCZ.fV("SnsComment", str2));
                    break;
                case 13:
                    b(boi, boh, j, j2, str);
                    break;
                case 14:
                    c(boi, boh, j, j2, str);
                    break;
                case 15:
                    com.tencent.mm.plugin.sns.storage.i.fb(j);
                    n fi = af.byo().fi(j);
                    bsu bAJ = fi.bAJ();
                    bAJ.csE = 1;
                    fi.c(bAJ);
                    af.byo().b(j, fi);
                    break;
                default:
                    a(boi, boh, j, j2, str);
                    break;
            }
            if ((boh.smm & 2) == 0) {
                z = true;
            } else {
                z = false;
            }
            af.aRu().post(new 2(this, z, boh, agVar));
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return false;
        }
    }

    public static boolean eP(long j) {
        try {
            return a.a(j, null, bi.getInt(com.tencent.mm.k.g.AT().getValue("SnsAdNotifyLimit"), 0), bi.getInt(com.tencent.mm.k.g.AT().getValue("SnsAdNotifyLikeTimeLimit"), 0), bi.getInt(com.tencent.mm.k.g.AT().getValue("SnsAdNotifyCommentTimeLimit"), 0), false);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return true;
        }
    }

    private static boolean a(boi boi, boh boh, long j, long j2, String str) {
        try {
            boolean a;
            int i = bi.getInt(com.tencent.mm.k.g.AT().getValue("SnsAdNotifyLimit"), 0);
            int i2 = bi.getInt(com.tencent.mm.k.g.AT().getValue("SnsAdNotifyLikeTimeLimit"), 0);
            int i3 = bi.getInt(com.tencent.mm.k.g.AT().getValue("SnsAdNotifyCommentTimeLimit"), 0);
            if ((i > 0 || i2 > 0 || i3 > 0) && (boh.hcE == 8 || boh.hcE == 7)) {
                a = a.a(j, boi, i, i2, i3, true);
                if (eO(j)) {
                    x.i("MicroMsg.NetSceneNewSyncAlbum", "user open notify off");
                }
                if (!a) {
                    x.i("MicroMsg.NetSceneNewSyncAlbum", "pass the comment clientId " + str + " snsId: " + j + " " + boh.smk + " " + boh.smh + " actionLimit:" + i + " actionLikeTimeLimit:" + i2 + " actionCommentTimeLimit:" + i3);
                    if (a.a(j, boi)) {
                        return false;
                    }
                    x.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID  " + boi.smo.smk);
                    return false;
                }
            }
            x.i("MicroMsg.NetSceneNewSyncAlbum", "processNormalAction clientId " + str + " snsId: " + j + " " + boh.smk + " " + boh.smh + " actionLimit: " + i);
            if (af.byt().a(j, boh.seC, boh.lOH, str)) {
                return false;
            }
            boh boh2 = boi.smp;
            j jVar = new j();
            jVar.field_snsID = j;
            jVar.field_parentID = j2;
            jVar.field_createTime = boh.lOH;
            jVar.field_talker = boh.seC;
            jVar.field_type = boh.hcE;
            jVar.field_curActionBuf = boh.toByteArray();
            jVar.field_refActionBuf = boh2.toByteArray();
            jVar.field_clientId = str;
            jVar.field_isSilence = (boh.smm & 2) == 0 ? 0 : 1;
            if (boh.hcE == 8 || boh.hcE == 7) {
                jVar.field_commentSvrID = boh.smk;
                if (!a.a(j, boi)) {
                    x.i("MicroMsg.NetSceneNewSyncAlbum", "pass comment ID " + jVar.field_snsID + " " + jVar.field_commentSvrID);
                    return false;
                }
            }
            jVar.field_commentSvrID = (long) boh.smh;
            if (!aj.a(j, boi)) {
                return false;
            }
            af.byt().b(jVar);
            com.tencent.mm.plugin.sns.storage.k byt = af.byt();
            if ((boh.smm & 2) != 0) {
                a = true;
            } else {
                a = false;
            }
            byt.s(j, a);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return false;
        }
    }

    private static boolean b(boi boi, boh boh, long j, long j2, String str) {
        try {
            x.i("MicroMsg.NetSceneNewSyncAlbum", "processHbAction clientId " + str + " snsId: " + j + " " + boh.smk + " " + boh.smh);
            if (com.tencent.mm.plugin.sns.lucky.a.g.bxd()) {
                if (af.byt().a(j, boh.seC, boh.lOH, str)) {
                    return false;
                }
                boh boh2 = boi.smp;
                j jVar = new j();
                jVar.field_snsID = j;
                jVar.field_parentID = j2;
                jVar.field_createTime = boh.lOH;
                jVar.field_talker = boh.seC;
                jVar.field_type = boh.hcE;
                jVar.field_curActionBuf = boh.toByteArray();
                jVar.field_refActionBuf = boh2.toByteArray();
                jVar.field_clientId = str;
                jVar.field_commentSvrID = (long) boh.smh;
                x.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + boh.sml);
                aj.c(j, boi);
                HI();
                af.byt().b(jVar);
                return true;
            }
            x.i("MicroMsg.NetSceneNewSyncAlbum", "passed because close lucky");
            return false;
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + e.getMessage());
            x.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return false;
        }
    }

    private static boolean c(boi boi, boh boh, long j, long j2, String str) {
        try {
            x.i("MicroMsg.NetSceneNewSyncAlbum", "processGrabHbAction clientId " + str + " snsId: " + j + " " + boh.smk + " " + boh.smh);
            if (af.byt().a(j, boh.seC, boh.lOH, str)) {
                return false;
            }
            boh boh2 = boi.smp;
            j jVar = new j();
            jVar.field_snsID = j;
            jVar.field_parentID = j2;
            jVar.field_createTime = boh.lOH;
            jVar.field_talker = boh.seC;
            jVar.field_type = boh.hcE;
            jVar.field_curActionBuf = boh.toByteArray();
            jVar.field_refActionBuf = boh2.toByteArray();
            jVar.field_clientId = str;
            jVar.field_commentSvrID = (long) boh.smh;
            amh amh = new amh();
            x.i("MicroMsg.NetSceneNewSyncAlbum", "curAction.HBBuffer " + boh.sml);
            amh.aG(ab.a(boh.sml));
            x.i("MicroMsg.NetSceneNewSyncAlbum", "hbbuffer  " + amh.cfh);
            af.byt().b(jVar);
            return true;
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneNewSyncAlbum", "error processHbAction " + e.getMessage());
            x.printErrStackTrace("MicroMsg.NetSceneNewSyncAlbum", e, "", new Object[0]);
            return false;
        }
    }

    public static void bxK() {
        for (ap apVar : nou) {
            if (apVar != null) {
                apVar.HJ();
            }
        }
    }

    private static void HI() {
        for (ap apVar : nou) {
            if (apVar != null) {
                apVar.HI();
            }
        }
    }

    public static void a(ap apVar) {
        if (!nou.contains(apVar)) {
            nou.add(apVar);
        }
    }

    public static void b(ap apVar) {
        nou.remove(apVar);
    }
}
