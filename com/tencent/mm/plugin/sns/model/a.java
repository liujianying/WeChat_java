package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import android.util.Base64;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bfl;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.boc;
import com.tencent.mm.protocal.c.bof;
import com.tencent.mm.protocal.c.boh;
import com.tencent.mm.protocal.c.boi;
import com.tencent.mm.protocal.c.bon;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.bpm;
import com.tencent.mm.protocal.c.bqw;
import com.tencent.mm.protocal.c.bqx;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.protocal.c.cg;
import com.tencent.mm.protocal.c.z;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StreamCorruptedException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a {
    private static final String nmw;
    private static LinkedHashMap<Long, Integer> nmx;
    private static Comparator<bon> nmy = new 1();

    static {
        StringBuilder stringBuilder = new StringBuilder();
        g.Ek();
        nmw = stringBuilder.append(g.Ei().cachePath).append("sns_recvd_ad").toString();
    }

    public static void a(boc boc, bhy bhy) {
        if (boc == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else if (boc.slX == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else {
            e b = b(boc);
            if (b != null) {
                b.Ni(a(b.field_adinfo, bhy));
                if (af.byr().fa(boc.slX.rlK)) {
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "ind this adobj and update" + boc.slX.rlK);
                    af.byr().b(boc.slX.rlK, b);
                    return;
                }
                x.i("MicroMsg.AdSnsInfoStorageLogic", "local can not find this adobj " + boc.slX.rlK);
            }
        }
    }

    public static void a(bpm bpm) {
        a(b(bpm));
    }

    public static void a(boc boc) {
        if (boc == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else if (boc.slX == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else {
            af.byr().a(boc.slX.rlK, b(boc));
        }
    }

    private static e b(boc boc) {
        e eVar;
        e eZ = af.byr().eZ(boc.slX.rlK);
        boy boy = boc.slX;
        String str = null;
        if (eZ == null) {
            eVar = new e();
        } else {
            str = eZ.bAJ().nNV;
            eVar = eZ;
        }
        String b = ab.b(boy.smH);
        if (bi.oW(b)) {
            return null;
        }
        if (!eVar.Nj(b)) {
            return null;
        }
        bsu bAJ;
        Iterator it;
        if (!bi.oW(str)) {
            bAJ = eVar.bAJ();
            bAJ.nNV = str;
            eVar.c(bAJ);
        }
        boy.smY = aj.b(boy.smY, eVar.field_attrBuf);
        x.d("MicroMsg.AdSnsInfoStorageLogic", "from server xml ok %d", new Object[]{Long.valueOf(boy.rlK)});
        boy.smH.bq(new byte[0]);
        eVar.field_userName = boy.rdS;
        if (boc.slY != null) {
            str = ab.a(boc.slY);
            if (!bi.oW(str)) {
                eVar.field_recxml = str;
            }
            str = eVar.field_recxml;
            if (!(bi.oW(str) || str.equals(eVar.field_adxml))) {
                x.i("MicroMsg.AdSnsInfoStorageLogic", "update field adxml " + str);
                eVar.field_adxml = str;
            }
        }
        eVar.field_likeFlag = boy.smI;
        long j = boy.rlK;
        eVar.field_snsId = j;
        if (j != 0) {
            eVar.field_stringSeq = i.eF(j);
            eVar.field_stringSeq = i.LK(eVar.field_stringSeq);
            x.d("MicroMsg.AdSnsInfo", j + " stringSeq " + eVar.field_stringSeq);
        }
        eVar.wZ(2);
        eVar.wZ(32);
        try {
            boy boy2;
            List<bon> linkedList;
            Iterator it2;
            bon bon;
            Iterator it3;
            bon bon2;
            com.tencent.mm.storage.ab Yg;
            if (eVar.field_attrBuf == null) {
                boy2 = new boy();
            } else {
                boy2 = (boy) new boy().aG(eVar.field_attrBuf);
            }
            if (!(boy2 == null || boy2.smO == null)) {
                linkedList = new LinkedList();
                it2 = boy.smO.iterator();
                while (it2.hasNext()) {
                    bon = (bon) it2.next();
                    if (bon.rXs > 0) {
                        linkedList.add(bon);
                        it3 = boy2.smO.iterator();
                        while (it3.hasNext()) {
                            bon2 = (bon) it3.next();
                            if (bon2.smk == bon.smk) {
                                boy2.smO.remove(bon2);
                                break;
                            }
                        }
                    }
                }
                for (bon bon3 : linkedList) {
                    boy.smO.remove(bon3);
                }
                linkedList.clear();
                Iterator it4 = boy2.smO.iterator();
                while (it4.hasNext()) {
                    bon3 = (bon) it4.next();
                    if (!(b(bon3, boy.smO) || bon3.smk == 0)) {
                        g.Ek();
                        Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg(bon3.rdS);
                        if (Yg == null || !com.tencent.mm.l.a.gd(Yg.field_type) || Yg.BA()) {
                            x.i("MicroMsg.AdSnsInfoStorageLogic", "not in ommentlist not mycontact " + bon3.rdS);
                        } else {
                            boy.smO.add(bon3);
                            boy.smN = boy.smO.size();
                        }
                    }
                }
            }
            Collections.sort(boy.smO, nmy);
            if (boy.smL != null) {
                linkedList = new LinkedList();
                it2 = boy.smL.iterator();
                while (it2.hasNext()) {
                    bon3 = (bon) it2.next();
                    if (bon3.rXs > 0) {
                        linkedList.add(bon3);
                        it3 = boy2.smL.iterator();
                        while (it3.hasNext()) {
                            bon2 = (bon) it3.next();
                            if (!bi.oW(bon2.rdS)) {
                                if (bon2.rdS.equals(bon3.rdS)) {
                                }
                            }
                            boy2.smL.remove(bon2);
                        }
                    }
                }
                for (bon bon32 : linkedList) {
                    boy.smL.remove(bon32);
                }
                linkedList.clear();
                if (!(boy2 == null || boy2.smL == null)) {
                    it = boy2.smL.iterator();
                    while (it.hasNext()) {
                        bon32 = (bon) it.next();
                        if (!a(bon32, boy.smL)) {
                            g.Ek();
                            Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg(bon32.rdS);
                            if (Yg == null || !com.tencent.mm.l.a.gd(Yg.field_type) || Yg.BA()) {
                                x.i("MicroMsg.AdSnsInfoStorageLogic", "not in likelist not mycontact " + bon32.rdS);
                            } else {
                                boy.smL.add(bon32);
                                boy.smK = boy.smL.size();
                            }
                        }
                    }
                }
                Collections.sort(boy.smL, nmy);
            }
        } catch (Throwable e) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "error " + e.getMessage());
            x.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
        }
        try {
            eVar.aK(boy.toByteArray());
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e2, "", new Object[0]);
        }
        bAJ = eVar.bAJ();
        bAJ.hbL = boy.rdS;
        eVar.field_pravited = bAJ.rVG;
        x.d("MicroMsg.AdSnsInfoStorageLogic", "ext flag " + boy.rXx + " " + boy.smO.size() + " " + boy.smL.size());
        it = bAJ.sqc.ruA.iterator();
        while (it.hasNext()) {
            ((ate) it.next()).nkG = true;
        }
        eVar.c(bAJ);
        eVar.field_type = bAJ.sqc.ruz;
        eVar.field_subType = bAJ.sqc.ruB;
        return eVar;
    }

    private static boolean a(bon bon, List<bon> list) {
        for (bon bon2 : list) {
            if (!bi.oW(bon.rdS) && bon.rdS.equals(bon2.rdS)) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(bon bon, List<bon> list) {
        for (bon bon2 : list) {
            if (bon.smk == bon2.smk && bon2.smk != 0) {
                return true;
            }
        }
        return false;
    }

    private static void a(cg cgVar, int i, int i2, com.tencent.mm.plugin.sns.storage.a aVar) {
        if (cgVar == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else if (cgVar.rcB == null || cgVar.rcB.slX == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else {
            String a;
            boy boy = cgVar.rcB.slX;
            e b = b(cgVar.rcB);
            bsu bAJ = b.bAJ();
            bqw bqw = new bqw();
            bqw.soW = new bqx();
            bqw.soW.spa = aVar.ntU;
            bqw.soW.soZ = bAJ.ksA;
            bqw.soW.source = b.getSource();
            bqw.soW.nIO = p.a(bqw.soW);
            if (bAJ.sqc.ruz == 1) {
                bqw.soW.egL = 1;
            } else if (bAJ.sqc.ruz == 15) {
                bqw.soW.egL = 2;
            } else {
                bqw.soW.egL = 0;
            }
            bqx bqx = bqw.soW;
            b bAG = b.bAG();
            bqx.spb = bAG == null ? 0 : bAG.nyZ;
            try {
                x.i("MicroMsg.AdSnsInfoStorageLogic", "replace newly add snsId:%s, statExtStr:%s(id=%s,uxInfo=%s)", new Object[]{bAJ.ksA, Base64.encodeToString(bqw.toByteArray(), 0).replace("\n", ""), bqw.soW.soZ, bqw.soW.spa});
                bAJ.nNV = a;
                b.c(bAJ);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
            }
            if (b != null) {
                b.field_createTime = i;
                b.field_exposureTime = 0;
                b.field_createAdTime = i2;
                a = ab.a(cgVar.rcB.slY);
                if (!bi.oW(a)) {
                    b.field_recxml = a;
                }
                b.field_adinfo = ab.a(cgVar.rcC);
                b.field_adxml = b.field_recxml;
                af.byr().a(boy.rlK, b);
            }
        }
    }

    private static boc b(bpm bpm) {
        if (bpm == null) {
            return null;
        }
        boc boc = new boc();
        boc.slY = bpm.snA;
        if (boc.slY == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "recommendObj.RecommendXml is null");
        }
        boc.slX = bpm.slX;
        return boc;
    }

    private static cg a(bfl bfl) {
        if (bfl == null) {
            return null;
        }
        cg cgVar = new cg();
        cgVar.rcC = bfl.sgL;
        if (cgVar.rcC == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "recObject.RecommendInfo is null");
            return null;
        }
        cgVar.rcB = b(bfl.sgK);
        return cgVar;
    }

    public static void b(bfl bfl) {
        cg a = a(bfl);
        if (a != null) {
            com.tencent.mm.plugin.sns.storage.a aVar = new com.tencent.mm.plugin.sns.storage.a(ab.a(a.rcC));
            int i = aVar.nxS;
            int i2 = i <= 0 ? 1 : i + 1;
            int Ny = af.byo().Ny("");
            x.i("MicroMsg.AdSnsInfoStorageLogic", "ad.pos = %d, dbLimit = %d, createTime.limit = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(Ny)});
            o byo = af.byo();
            String str = "";
            String str2 = (o.nJr + " from SnsInfo where ") + o.bBu();
            if (o.Nt(str)) {
                str2 = str2 + " AND " + byo.Nu(str);
            }
            String str3 = ((((str2 + " AND createTime >= " + Ny) + " UNION ") + o.nJr + " from AdSnsInfo where createTime > " + Ny) + o.nJs) + " limit " + i2;
            x.d("MicroMsg.SnsInfoStorage", "getAdCursorForTimeLine " + str3 + " limtiSeq: " + str);
            Cursor rawQuery = byo.diF.rawQuery(str3, null);
            if (rawQuery == null || rawQuery.getCount() <= 0) {
                x.i("MicroMsg.AdSnsInfoStorageLogic", "db return nothing");
                i2 = (int) bi.VE();
            } else {
                x.i("MicroMsg.AdSnsInfoStorageLogic", "db return %d feeds", new Object[]{Integer.valueOf(rawQuery.getCount())});
                n nVar = new n();
                if (i < 0) {
                    i2 = 0;
                } else {
                    i2 = i;
                }
                if (rawQuery.moveToPosition(i2)) {
                    nVar.d(rawQuery);
                } else {
                    rawQuery.moveToLast();
                    nVar.d(rawQuery);
                }
                i2 = nVar.field_createTime + 1;
            }
            rawQuery.close();
            x.i("MicroMsg.AdSnsInfoStorageLogic", "inserting snsid  " + a.rcB.slX.rlK + " ,createTime " + i2);
            a(a, i2, (int) bi.VE(), aVar);
            a(a);
            a(a.rcB.slX.rlK, aVar);
        }
    }

    public static void d(LinkedList<bfl> linkedList, LinkedList<boy> linkedList2) {
        if (linkedList != null) {
            LinkedList ab = ab(linkedList);
            x.i("MicroMsg.AdSnsInfoStorageLogic", "convert " + ab.size() + " recObj to AdvertiseObj");
            Iterator it = ab.iterator();
            while (it.hasNext()) {
                cg cgVar = (cg) it.next();
                if (eH(cgVar.rcB.slX.rlK)) {
                    x.w("MicroMsg.AdSnsInfoStorageLogic", "ignore recvd ad filter by snsId " + cgVar.rcB.slX.rlK);
                    it.remove();
                }
            }
            a(ab, linkedList2, true);
        }
    }

    public static void e(LinkedList<cg> linkedList, LinkedList<boy> linkedList2) {
        a(linkedList, linkedList2, false);
    }

    private static LinkedList<cg> ab(LinkedList<bfl> linkedList) {
        LinkedList<cg> linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            cg a = a((bfl) it.next());
            if (a != null) {
                linkedList2.add(a);
            }
        }
        return linkedList2;
    }

    private static void a(LinkedList<cg> linkedList, LinkedList<boy> linkedList2, boolean z) {
        if (linkedList != null && linkedList2 != null && linkedList2.size() != 0) {
            int a = a((boy) linkedList2.get(linkedList2.size() - 1));
            for (int i = 0; i < linkedList.size(); i++) {
                cg cgVar = (cg) linkedList.get(i);
                if (cgVar == null) {
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "ad is null");
                } else if (cgVar.rcB == null) {
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject is null");
                } else if (cgVar.rcB.slX == null) {
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject.SnsObject is null");
                } else if (z && af.byr().fa(cgVar.rcB.slX.rlK)) {
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "snsId %d already exist, ignore ", new Object[]{Long.valueOf(cgVar.rcB.slX.rlK)});
                } else {
                    String a2 = ab.a(cgVar.rcC);
                    String a3 = ab.a(cgVar.rcB.slY);
                    String b = ab.b(cgVar.rcB.slX.smH);
                    com.tencent.mm.plugin.sns.storage.a aVar = new com.tencent.mm.plugin.sns.storage.a(a2);
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "skXml " + a2);
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "adXml " + a3);
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "snsXml " + b + "\r\n");
                    b bVar = new b(a3);
                    if (bVar.nza == 0 || !eH(bVar.nza)) {
                        int i2 = a + 1;
                        if (aVar.nxS >= linkedList2.size() || aVar.nxS < 0) {
                            x.w("MicroMsg.AdSnsInfoStorageLogic", "invalid ad.pos " + aVar.nxS);
                        } else {
                            i2 = a((boy) linkedList2.get(aVar.nxS)) + 1;
                            x.i("MicroMsg.AdSnsInfoStorageLogic", "create adinfo time  " + i2 + " pos " + aVar.nxS);
                        }
                        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                        x.i("MicroMsg.AdSnsInfoStorageLogic", "gettime " + currentTimeMillis);
                        a(cgVar, i2, currentTimeMillis, aVar);
                        eI(cgVar.rcB.slX.rlK);
                        eI(bVar.nza);
                        a(cgVar.rcB.slX.rlK, aVar);
                    } else {
                        x.w("MicroMsg.AdSnsInfoStorageLogic", "ignore recvd ad filter by originSnsId " + bVar.nza);
                    }
                }
            }
        }
    }

    private static void a(long j, com.tencent.mm.plugin.sns.storage.a aVar) {
        if (aVar.nyu && !bi.oW(aVar.nyt)) {
            m mVar = new m(j, 1, aVar.nyt);
            g.Ek();
            g.Eh().dpP.a(mVar, 0);
        }
    }

    public static void ac(LinkedList<bfl> linkedList) {
        if (linkedList != null && !linkedList.isEmpty()) {
            LinkedList ab = ab(linkedList);
            x.i("MicroMsg.AdSnsInfoStorageLogic", "convert " + ab.size() + " recObj to AdvertiseObj");
            ad(ab);
        }
    }

    public static void ad(LinkedList<cg> linkedList) {
        if (linkedList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < linkedList.size()) {
                    a((cg) linkedList.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private static void a(cg cgVar) {
        String a = ab.a(cgVar.rcB.slY);
        if (!bi.oW(a) && new b(a).bzm()) {
            f.bAB().e("adId", a, "adxml", 0);
        }
    }

    public static void ae(LinkedList<boy> linkedList) {
        if (linkedList != null) {
            o byo = af.byo();
            for (int i = 0; i < linkedList.size(); i++) {
                boy boy = (boy) linkedList.get(i);
                if (boy != null) {
                    n fi = byo.fi(boy.rlK);
                    if (fi != null) {
                        bsu bAJ = fi.bAJ();
                        if (!(bAJ == null || bi.oW(bAJ.ogR))) {
                            f.bAB().e("adId", bAJ.ogR, "adxml", 0);
                        }
                    }
                }
            }
        }
    }

    public static void LU(String str) {
        if (!bi.oW(str)) {
            f.bAB().e("adId", str, "adxml", 1);
        }
    }

    private static int a(boy boy) {
        n fi = af.byo().fi(boy.rlK);
        return fi == null ? boy.lOH : fi.field_createTime;
    }

    public static boolean a(long j, boi boi, int i, int i2, int i3, boolean z) {
        if (boi != null) {
            boh boh = boi.smo;
            if (!(boh.hcE == 7 || boh.hcE == 8)) {
                return false;
            }
        }
        String GF = q.GF();
        if (boi != null && boi.smp != null && boi.smp.seC != null && boi.smp.seC.equals(GF)) {
            return true;
        }
        e eZ = af.byr().eZ(j);
        try {
            n Nk;
            com.tencent.mm.plugin.sns.storage.a bAH;
            c cVar;
            bon bon;
            int i4;
            boy boy = (boy) new boy().aG(eZ.field_attrBuf);
            boy.rlK = j;
            int i5 = eZ.field_firstControlTime;
            boh boh2 = boi.smo;
            int source;
            Object[] objArr;
            if (boh2.hcE == 7) {
                if (i2 > 0 && i5 + i2 < boh2.lOH) {
                    if (z) {
                        Nk = af.byo().Nk(eZ.bAK());
                        if (Nk != null) {
                            bAH = Nk.bAH();
                            if (bAH != null) {
                                cVar = (c) g.l(c.class);
                                source = eZ.getSource();
                                objArr = new Object[7];
                                objArr[0] = Long.valueOf(v.NE(eZ.bAK()));
                                objArr[1] = bAH.fvT;
                                objArr[2] = Integer.valueOf(2);
                                objArr[3] = Integer.valueOf(1);
                                objArr[4] = Integer.valueOf(boy.smL != null ? boy.smL.size() : 0);
                                objArr[5] = Integer.valueOf(boy.smO != null ? boy.smO.size() : 0);
                                objArr[6] = Integer.valueOf((int) (System.currentTimeMillis() / 1000));
                                cVar.a(13182, source, objArr);
                            } else {
                                x.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
                            }
                        } else {
                            x.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
                        }
                    }
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "snsid " + j + " firstCreateTime " + i5 + " actionLikeTimeLimit: " + i2 + " curAction.createTime: " + boh2.lOH + "is over the time limit!");
                    return false;
                }
            } else if (boh2.hcE == 8 && i3 > 0 && i5 + i3 < boh2.lOH) {
                if (z) {
                    Nk = af.byo().Nk(eZ.bAK());
                    if (Nk != null) {
                        bAH = Nk.bAH();
                        if (bAH != null) {
                            cVar = (c) g.l(c.class);
                            source = eZ.getSource();
                            objArr = new Object[7];
                            objArr[0] = Long.valueOf(v.NE(eZ.bAK()));
                            objArr[1] = bAH.fvT;
                            objArr[2] = Integer.valueOf(2);
                            objArr[3] = Integer.valueOf(2);
                            objArr[4] = Integer.valueOf(boy.smL != null ? boy.smL.size() : 0);
                            objArr[5] = Integer.valueOf(boy.smO != null ? boy.smO.size() : 0);
                            objArr[6] = Integer.valueOf((int) (System.currentTimeMillis() / 1000));
                            cVar.a(13182, source, objArr);
                        } else {
                            x.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
                        }
                    } else {
                        x.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
                    }
                }
                x.i("MicroMsg.AdSnsInfoStorageLogic", "snsid " + j + " firstCreateTime " + i5 + " actionCommentTimeLimit: " + i3 + " curAction.createTime: " + boh2.lOH + "is over the time limit!");
                return false;
            }
            int i6 = 0;
            Iterator it = boy.smL.iterator();
            while (it.hasNext()) {
                bon = (bon) it.next();
                if (bon.lOH <= i5 || !(bon == null || bon.rdS == null || !bon.rdS.equals(GF))) {
                    i4 = i6;
                } else {
                    i4 = i6 + 1;
                }
                i6 = i4;
            }
            int i7 = i6 + 0;
            i6 = 0;
            Iterator it2 = boy.smO.iterator();
            while (it2.hasNext()) {
                bon = (bon) it2.next();
                if (bon.lOH <= i5 || !(bon == null || bon.rdS == null || !bon.rdS.equals(GF))) {
                    i4 = i6;
                } else {
                    i4 = i6 + 1;
                }
                i6 = i4;
            }
            i4 = i7 + i6;
            x.i("MicroMsg.AdSnsInfoStorageLogic", "totalsize " + i4 + " firstCreateTime " + i5 + " actionLimit: " + i + " actionLikeTimeLimit: " + i2 + " actionCommentTimeLimit: " + i3);
            if (i4 >= i) {
                if (z) {
                    Nk = af.byo().Nk(eZ.bAK());
                    if (Nk != null) {
                        bAH = Nk.bAH();
                        if (bAH != null) {
                            cVar = (c) g.l(c.class);
                            i5 = eZ.getSource();
                            Object[] objArr2 = new Object[7];
                            objArr2[0] = Long.valueOf(v.NE(eZ.bAK()));
                            objArr2[1] = bAH.fvT;
                            objArr2[2] = Integer.valueOf(1);
                            objArr2[3] = Integer.valueOf(2);
                            objArr2[4] = Integer.valueOf(boy.smL != null ? boy.smL.size() : 0);
                            objArr2[5] = Integer.valueOf(boy.smO != null ? boy.smO.size() : 0);
                            objArr2[6] = Integer.valueOf((int) (System.currentTimeMillis() / 1000));
                            cVar.a(13182, i5, objArr2);
                        } else {
                            x.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
                        }
                    } else {
                        x.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
                    }
                }
                return false;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
        }
        return true;
    }

    public static boolean a(long j, boi boi) {
        boh boh = boi.smo;
        if (boh.hcE != 7 && boh.hcE != 8) {
            return false;
        }
        e eZ = af.byr().eZ(j);
        if (eZ == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "pass the action because the snsinfo is null " + j);
            return false;
        }
        try {
            boy boy = (boy) new boy().aG(eZ.field_attrBuf);
            boy.rlK = j;
            Iterator it;
            bon bon;
            if (boh.hcE == 7) {
                it = boy.smL.iterator();
                while (it.hasNext()) {
                    bon = (bon) it.next();
                    if (bon.lOH == boh.lOH && bon.rdS.equals(boh.seC)) {
                        x.i("MicroMsg.AdSnsInfoStorageLogic", "like create time " + bon.lOH + " ");
                        return false;
                    }
                }
                boy.smL.add(ad.a(boi));
            } else if (boh.hcE == 8) {
                it = boy.smO.iterator();
                while (it.hasNext()) {
                    bon = (bon) it.next();
                    if (bon.lOH == boh.lOH && bon.rdS.equals(boh.seC)) {
                        x.i("MicroMsg.AdSnsInfoStorageLogic", "like create time " + bon.lOH + " ");
                        return false;
                    }
                }
                boy.smO.add(ad.a(boi));
            }
            eZ.aK(boy.toByteArray());
            af.byr().a(boy.rlK, eZ);
        } catch (Throwable e) {
            x.e("MicroMsg.AdSnsInfoStorageLogic", "e " + e.getMessage());
            x.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
        }
        return true;
    }

    private static boolean eH(long j) {
        bxq();
        return nmx.get(Long.valueOf(j)) != null;
    }

    private static void bxq() {
        Throwable e;
        if (nmx == null) {
            byte[] Tq = com.tencent.mm.pluginsdk.g.a.d.a.Tq(nmw);
            if (Tq != null) {
                ObjectInput objectInputStream;
                try {
                    objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Tq));
                    try {
                        nmx = (LinkedHashMap) objectInputStream.readObject();
                        try {
                            objectInputStream.close();
                        } catch (IOException e2) {
                        }
                    } catch (StreamCorruptedException e3) {
                        e = e3;
                        try {
                            x.e("MicroMsg.AdSnsInfoStorageLogic", bi.i(e));
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (IOException e4) {
                                }
                            }
                            if (nmx != null) {
                                nmx = new 2(((int) Math.ceil(666.6666870117188d)) + 1);
                            }
                        } catch (Throwable th) {
                            e = th;
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (IOException e5) {
                                }
                            }
                            throw e;
                        }
                    } catch (IOException e6) {
                        e = e6;
                        x.e("MicroMsg.AdSnsInfoStorageLogic", bi.i(e));
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e7) {
                            }
                        }
                        if (nmx != null) {
                            nmx = new 2(((int) Math.ceil(666.6666870117188d)) + 1);
                        }
                    } catch (ClassNotFoundException e8) {
                        e = e8;
                        x.e("MicroMsg.AdSnsInfoStorageLogic", bi.i(e));
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e9) {
                            }
                        }
                        if (nmx != null) {
                            nmx = new 2(((int) Math.ceil(666.6666870117188d)) + 1);
                        }
                    }
                } catch (StreamCorruptedException e10) {
                    e = e10;
                    objectInputStream = null;
                    x.e("MicroMsg.AdSnsInfoStorageLogic", bi.i(e));
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e42) {
                        }
                    }
                    if (nmx != null) {
                        nmx = new 2(((int) Math.ceil(666.6666870117188d)) + 1);
                    }
                } catch (IOException e11) {
                    e = e11;
                    objectInputStream = null;
                    x.e("MicroMsg.AdSnsInfoStorageLogic", bi.i(e));
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e72) {
                        }
                    }
                    if (nmx != null) {
                        nmx = new 2(((int) Math.ceil(666.6666870117188d)) + 1);
                    }
                } catch (ClassNotFoundException e12) {
                    e = e12;
                    objectInputStream = null;
                    x.e("MicroMsg.AdSnsInfoStorageLogic", bi.i(e));
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e92) {
                        }
                    }
                    if (nmx != null) {
                        nmx = new 2(((int) Math.ceil(666.6666870117188d)) + 1);
                    }
                } catch (Throwable th2) {
                    e = th2;
                    objectInputStream = null;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e52) {
                        }
                    }
                    throw e;
                }
            }
            if (nmx != null) {
                nmx = new 2(((int) Math.ceil(666.6666870117188d)) + 1);
            }
        }
    }

    private static void eI(long j) {
        if (j != 0) {
            if (nmx == null) {
                bxq();
            }
            nmx.put(Long.valueOf(j), Integer.valueOf(0));
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ObjectOutput objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(nmx);
                objectOutputStream.flush();
                com.tencent.mm.pluginsdk.g.a.d.a.v(nmw, byteArrayOutputStream.toByteArray());
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
            } catch (Throwable e2) {
                x.e("MicroMsg.AdSnsInfoStorageLogic", bi.i(e2));
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                }
            } catch (Throwable e22) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e4) {
                }
                throw e22;
            }
        }
    }

    private static String a(String str, bhy bhy) {
        if (bhy == null || str == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "update with empty dynamic data");
            return str;
        }
        String str2;
        try {
            z zVar = new z();
            zVar.aG(bhy.siK.lR);
            if (zVar.qYY != null) {
                String str3 = "<(([a-zA-Z0-9\\-_]+)([^>]+)dynamicKey=[\"']%s[\"']([^>]*))";
                String str4 = "";
                Iterator it = zVar.qYY.iterator();
                str2 = str;
                while (it.hasNext()) {
                    try {
                        String str5;
                        bof bof = (bof) it.next();
                        if (bof.aAL != null) {
                            String format = String.format(str3, new Object[]{bof.aAL});
                            Matcher matcher = Pattern.compile(format).matcher(str2);
                            if (matcher.find()) {
                                String group = matcher.group(2);
                                if (group != null && group.length() > 0) {
                                    str2 = str2.replaceAll(format + String.format("((>[\\s\\S]*</%s>)|(/([^>]*)>))", new Object[]{group}), String.format("<$1>%s</%s>", new Object[]{bof.value, group}));
                                    str5 = str4 + bof.aAL + ":" + bof.value + ";";
                                    str4 = str5;
                                }
                            }
                        }
                        str5 = str4;
                        str4 = str5;
                    } catch (Exception e) {
                        x.w("MicroMsg.AdSnsInfoStorageLogic", "replace error occurs!");
                        return str2;
                    }
                }
                x.i("MicroMsg.AdSnsInfoStorageLogic", "DynamicData is: [%s]", new Object[]{str4});
                if (bl.z(str, "ADInfo") == null) {
                    x.w("MicroMsg.AdSnsInfoStorageLogic", "DynamicData xml format error!");
                    return str;
                }
            }
            str2 = str;
        } catch (Exception e2) {
            str2 = str;
            x.w("MicroMsg.AdSnsInfoStorageLogic", "replace error occurs!");
            return str2;
        }
        return str2;
    }
}
