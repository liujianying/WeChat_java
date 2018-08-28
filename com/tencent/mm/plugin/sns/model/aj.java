package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.mm.a.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.a;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.ari;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.atf;
import com.tencent.mm.protocal.c.ath;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.boh;
import com.tencent.mm.protocal.c.boi;
import com.tencent.mm.protocal.c.bon;
import com.tencent.mm.protocal.c.bou;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.bpg;
import com.tencent.mm.protocal.c.bpn;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.protocal.c.cj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class aj {
    private static Map<String, boy> nrf = new ConcurrentHashMap();

    public static List<n> a(String str, boolean z, String str2, boolean z2) {
        Cursor b;
        if (z2) {
            b = af.byo().b(str, 10, z, str2);
        } else {
            b = af.byo().b(str, 0, z, str2);
        }
        List<n> arrayList = new ArrayList();
        if (b.getCount() == 0) {
            b.close();
            return arrayList;
        }
        if (b.moveToFirst()) {
            do {
                n nVar = new n();
                nVar.d(b);
                arrayList.add(nVar);
            } while (b.moveToNext());
        }
        b.close();
        return arrayList;
    }

    public static n Mk(String str) {
        Cursor b = af.byo().b(str, 1, false, "");
        if (b.getCount() == 0) {
            b.close();
            return null;
        }
        b.moveToFirst();
        n nVar = new n();
        nVar.d(b);
        if (b.isClosed()) {
            return nVar;
        }
        b.close();
        return nVar;
    }

    public static void byG() {
        if (nrf != null) {
            nrf.clear();
        }
    }

    public static boy m(n nVar) {
        try {
            boy c = af.byn().c((boy) new boy().aG(nVar.field_attrBuf));
            nrf.clear();
            return c;
        } catch (Throwable e) {
            x.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
            x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            return new boy();
        }
    }

    public static boy n(n nVar) {
        try {
            boy boy;
            if (nVar.nJb == null) {
                nVar.nJb = g.u(nVar.field_content) + g.u(nVar.field_attrBuf);
            }
            if (nrf.containsKey(nVar.nJb)) {
                boy = (boy) nrf.get(nVar.nJb);
                if (boy != null) {
                    af.byn().c(boy);
                    return boy;
                }
            }
            boy = (boy) new boy().aG(nVar.field_attrBuf);
            nrf.put(nVar.nJb, boy);
            af.byn().c(boy);
            return boy;
        } catch (Throwable e) {
            x.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
            x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            return new boy();
        }
    }

    public static void b(long j, boi boi) {
        boh boh = boi.smo;
        if (boh.hcE == 9) {
            n fi = af.byo().fi(j);
            if (fi != null) {
                try {
                    boy boy = (boy) new boy().aG(fi.field_attrBuf);
                    boy.rlK = j;
                    Iterator it = boy.smO.iterator();
                    while (it.hasNext()) {
                        bon bon = (bon) it.next();
                        if (bon.smh == boh.smh && !bi.oW(bon.rdS) && bon.rdS.equals(boh.seC)) {
                            boy.smO.remove(bon);
                            break;
                        }
                    }
                    fi.aK(boy.toByteArray());
                    af.byo().a(boy.rlK, fi);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
                }
            }
        }
    }

    public static void c(long j, boi boi) {
        boh boh = boi.smo;
        if (boh.hcE == 13) {
            n fi = af.byo().fi(j);
            if (fi != null) {
                try {
                    boy boy = (boy) new boy().aG(fi.field_attrBuf);
                    boy.rlK = j;
                    if (boy.smZ == null) {
                        boy.smZ = new bpn();
                    }
                    if (boh.hcE == 13) {
                        Iterator it = boy.smZ.snC.iterator();
                        while (it.hasNext()) {
                            if (((bou) it.next()).rdS.equals(boh.seC)) {
                                return;
                            }
                        }
                        bou bou = new bou();
                        bou.sml = boh.sml;
                        bou.lOH = boh.lOH;
                        bou.rdS = boh.seC;
                        boy.smZ.snC.add(bou);
                        boy.smZ.snB = boy.smZ.snC.size();
                    }
                    fi.aK(boy.toByteArray());
                    af.byo().a(boy.rlK, fi);
                } catch (Throwable e) {
                    x.e("MicroMsg.SnsInfoStorageLogic", "error for update hbaction " + e.getMessage());
                    x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
                }
            }
        }
    }

    public static boolean a(long j, boi boi) {
        boh boh = boi.smo;
        if (boh.hcE != 1 && boh.hcE != 2) {
            return true;
        }
        n fi = af.byo().fi(j);
        if (fi == null) {
            return true;
        }
        if (fi.field_type != 21 || com.tencent.mm.plugin.sns.lucky.a.g.bxd()) {
            try {
                boy boy = (boy) new boy().aG(fi.field_attrBuf);
                boy.rlK = j;
                Iterator it;
                bon bon;
                if (boh.hcE == 1) {
                    it = boy.smL.iterator();
                    while (it.hasNext()) {
                        bon = (bon) it.next();
                        if (bon.lOH == boh.lOH && bon.rdS.equals(boh.seC)) {
                            return true;
                        }
                    }
                    boy.smL.add(ad.a(boi));
                } else if (boh.hcE == 2) {
                    it = boy.smO.iterator();
                    while (it.hasNext()) {
                        bon = (bon) it.next();
                        if (bon.lOH == boh.lOH && bon.rdS.equals(boh.seC)) {
                            return true;
                        }
                    }
                    boy.smO.add(ad.a(boi));
                }
                fi.aK(boy.toByteArray());
                af.byo().a(boy.rlK, fi);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            }
            return true;
        }
        x.i("MicroMsg.SnsInfoStorageLogic", "passed because close lucky");
        return false;
    }

    public static long d(boy boy) {
        String str = "";
        n fi = af.byo().fi(boy.rlK);
        if (fi == null) {
            fi = new n();
        }
        return a(fi, boy, str, 0);
    }

    private static long a(n nVar, boy boy, String str, int i) {
        int i2 = 1;
        if (nVar == null) {
            nVar = new n();
        }
        if (!af.byn().eR(nVar.field_snsId)) {
            return boy.rlK;
        }
        if (boy.smS != 0) {
            x.i("MicroMsg.SnsInfoStorageLogic", "hit the filter id:" + boy.rlK + "  " + i.eF(boy.rlK));
            if (nVar.xb(i)) {
                i2 = 0;
            } else {
                nVar.wZ(i);
            }
            if (i2 != 0) {
                af.byo().a(boy.rlK, nVar);
            }
            return boy.rlK;
        }
        LinkedList linkedList = boy.smO;
        x.i("MicroMsg.SnsInfoStorageLogic", "hasChange id:  %s listSize %s Stringid %s", new Object[]{Long.valueOf(boy.rlK), Integer.valueOf(linkedList.size()), i.eF(boy.rlK)});
        if (boy.smH == null || boy.smH.siK == null) {
            x.i("MicroMsg.SnsInfoStorageLogic", "object desc is null");
            return boy.rlK;
        }
        String str2 = new String(boy.smH.siK.toByteArray());
        x.d("MicroMsg.SnsInfoStorageLogic", "from server %d ", new Object[]{Long.valueOf(boy.rlK)});
        if (bi.oW(str2)) {
            return boy.rlK;
        }
        if (!nVar.Nj(str2)) {
            return boy.rlK;
        }
        int i3;
        boy.smY = b(boy.smY, nVar.field_attrBuf);
        x.d("MicroMsg.SnsInfoStorageLogic", "from server xml ok %d", new Object[]{Long.valueOf(boy.rlK)});
        boy.smH.bq(new byte[0]);
        nVar.field_userName = boy.rdS;
        nVar.hK(boy.lOH);
        nVar.field_likeFlag = boy.smI;
        nVar.fe(boy.rlK);
        nVar.fg(boy.rlK);
        nVar.wZ(i);
        try {
            long VG = bi.VG();
            try {
                if (nVar.field_type == 15) {
                    boy boy2 = (boy) new boy().aG(nVar.field_attrBuf);
                    if (!(boy2 == null || boy2.sna == null || boy2.sna.sdz <= 0)) {
                        boy.sna = boy2.sna;
                        x.i("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo predownload info [%d %d %s] cost[%d]", new Object[]{Integer.valueOf(boy.sna.sdz), Integer.valueOf(boy.sna.sdA), boy.sna.sdB, Long.valueOf(bi.bI(VG))});
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo error %s", new Object[]{e.toString()});
            }
            nVar.aK(boy.toByteArray());
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e2, "", new Object[0]);
        }
        bsu bAJ = nVar.bAJ();
        bAJ.hbL = boy.rdS;
        int i4 = bAJ.rVG;
        nVar.field_pravited = i4;
        x.i("MicroMsg.SnsInfoStorageLogic", "ext flag %s  extflag %s", new Object[]{Long.valueOf(boy.rlK), Integer.valueOf(boy.rXx)});
        if ((boy.rXx & 1) > 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            nVar.bBb();
        } else {
            nVar.bBc();
        }
        if (i4 != 1 || i == 4) {
            if (i4 == 1 || (!str.equals(boy.rdS) && i == 4)) {
                nVar.bAY();
            }
            nVar.c(bAJ);
            nVar.field_type = bAJ.sqc.ruz;
            nVar.field_subType = bAJ.sqc.ruB;
            af.byo().a(boy.rlK, nVar);
            return boy.rlK;
        }
        x.e("MicroMsg.SnsInfoStorageLogic", "svr error push me the private pic in timelnie or others");
        return 0;
    }

    public static bhy b(bhy bhy, byte[] bArr) {
        bhy bhy2;
        if (bArr != null) {
            try {
                bhy2 = ((boy) new boy().aG(bArr)).smY;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
                return null;
            }
        }
        bhy2 = null;
        if (bhy == null) {
            return bhy2;
        }
        bpg bpg = new bpg();
        if (bhy2 != null) {
            bpg = (bpg) bpg.aG(bhy2.siK.lR);
        }
        bpg bpg2 = (bpg) new bpg().aG(bhy.siK.lR);
        if (bpg2.snn == null) {
            bpg2.snn = bpg.snn;
        }
        if (bpg.snm == null) {
            bpg2.snm = null;
        } else if (bpg2.snm == null) {
            bpg2.snm = bpg.snm;
        }
        return new bhy().bq(bpg2.toByteArray());
    }

    private static String cg(List<String> list) {
        String str = "";
        Iterator it = list.iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return str2;
            }
            str = (String) it.next();
            if (str2.length() != 0) {
                str = str2 + "," + str;
            }
        }
    }

    public static void a(String str, int i, LinkedList<boy> linkedList, String str2) {
        if (linkedList != null && !linkedList.isEmpty()) {
            String str3;
            String str4;
            Cursor rawQuery;
            o byo = af.byo();
            List arrayList = new ArrayList();
            List linkedList2 = new LinkedList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= linkedList.size()) {
                    break;
                }
                boy boy = (boy) linkedList.get(i3);
                n fi = byo.fi(boy.rlK);
                if (fi == null) {
                    fi = new n();
                }
                if (a(fi, boy, str, i) != 0) {
                    if (linkedList2.size() < 3 && (fi.field_type == 1 || fi.field_type == 15)) {
                        linkedList2.add(i.eF(fi.field_snsId));
                    }
                    arrayList.add(Long.valueOf(boy.rlK));
                }
                i2 = i3 + 1;
            }
            if ((i == 4 || i == 8) && str2.equals("")) {
                l Np = af.bys().Np(str);
                List F = bi.F(bi.aG(Np != null ? Np.field_newerIds : "", "").split(","));
                x.d("MicroMsg.SnsInfoStorageLogic", "newerIds " + cg(linkedList2));
                while (linkedList2.size() < 3 && F.size() > 0) {
                    str3 = (String) F.remove(0);
                    if (str3 != null) {
                        i2 = 0;
                        while (true) {
                            int i4 = i2;
                            if (i4 >= linkedList2.size()) {
                                break;
                            }
                            str4 = (String) linkedList2.get(i4);
                            if (str3.compareTo(str4) == 0) {
                                break;
                            } else if (str3.compareTo(str4) > 0) {
                                linkedList2.add(0, str3);
                                break;
                            } else {
                                i2 = i4 + 1;
                            }
                        }
                        if (!linkedList2.contains(str3)) {
                            linkedList2.add(str3);
                        }
                    }
                }
                x.i("MicroMsg.SnsInfoStorageLogic", "merge newerIds " + cg(linkedList2));
                af.bys().eM(str, cg(linkedList2));
            }
            str3 = i.LK(i.eF(((boy) linkedList.getLast()).rlK));
            x.d("MicroMsg.SnsInfoStorageLogic", "FIlTER SEQ :: " + str2 + "  -  " + str3);
            o byo2;
            if (i == 2) {
                byo2 = af.byo();
                str4 = o.bBw();
                if (str2 == null || !str2.equals("")) {
                    str4 = str4 + " AND " + byo2.Nx(str2);
                }
                if (o.Nt(str3)) {
                    str4 = str4 + " AND " + byo2.Nu(str3);
                }
                x.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq " + str4);
                rawQuery = byo2.diF.rawQuery(str4, null);
            } else {
                byo2 = af.byo();
                str4 = o.aV(str, i == 4);
                if (o.Nt(str2)) {
                    str4 = str4 + " AND " + byo2.Nx(str2);
                }
                if (o.Nt(str3)) {
                    str4 = str4 + " AND " + byo2.Nu(str3);
                }
                x.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq " + str4);
                rawQuery = byo2.diF.rawQuery(str4, null);
            }
            if (rawQuery == null) {
                return;
            }
            if (rawQuery.moveToFirst()) {
                do {
                    n nVar = new n();
                    nVar.d(rawQuery);
                    long j = nVar.field_snsId;
                    if (nVar.bBf()) {
                        x.d("MicroMsg.SnsInfoStorageLogic", "uploading one ");
                    } else if (nVar.bBg()) {
                        x.d("MicroMsg.SnsInfoStorageLogic", "die one ");
                    } else if (!arrayList.contains(Long.valueOf(j))) {
                        nVar.xc(i);
                        af.byo().b(j, nVar);
                        x.i("MicroMsg.SnsInfoStorageLogic", "removeSourceFlag sns Id " + j + " source " + i);
                    }
                } while (rawQuery.moveToNext());
                rawQuery.close();
                return;
            }
            rawQuery.close();
        }
    }

    public static boolean O(int i, boolean z) {
        if (!z || i <= 0) {
            return false;
        }
        return true;
    }

    public static boolean wx(int i) {
        Throwable e;
        x.d("MicroMsg.SnsInfoStorageLogic", "retryPostItem localId　" + i);
        n xd = af.byo().xd(i);
        if (xd == null) {
            return false;
        }
        xd.bBh();
        xd.hK((int) (System.currentTimeMillis() / 1000));
        atf atf = null;
        try {
            atf atf2 = (atf) new atf().aG(xd.field_postBuf);
            try {
                atf2.dHg = 0;
                atf2.rWf = System.currentTimeMillis();
                xd.field_postBuf = atf2.toByteArray();
                atf = atf2;
            } catch (Exception e2) {
                e = e2;
                atf = atf2;
                x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
                if (atf != null) {
                    return false;
                }
                af.byo().b(i, xd);
                for (int i2 = 0; i2 < atf.rWc.size(); i2++) {
                    int i3 = ((ari) atf.rWc.get(i2)).rTF;
                    r fj = af.byd().fj((long) i3);
                    if (fj != null) {
                        fj.offset = 0;
                        try {
                            ath ath = (ath) new ath().aG(fj.nJM);
                            if (ath.rWA == 0) {
                                continue;
                            } else {
                                ath.rWA = 2;
                                ath.rWB = "";
                                fj.nJM = ath.toByteArray();
                                af.byd().a(i3, fj);
                            }
                        } catch (Exception e3) {
                            x.e("MicroMsg.SnsInfoStorageLogic", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
                            return false;
                        }
                    }
                }
                return true;
            }
        } catch (Throwable e4) {
            e = e4;
            x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            if (atf != null) {
                return false;
            }
            af.byo().b(i, xd);
            for (int i22 = 0; i22 < atf.rWc.size(); i22++) {
                int i32 = ((ari) atf.rWc.get(i22)).rTF;
                r fj2 = af.byd().fj((long) i32);
                if (fj2 != null) {
                    fj2.offset = 0;
                    try {
                        ath ath2 = (ath) new ath().aG(fj2.nJM);
                        if (ath2.rWA == 0) {
                            continue;
                        } else {
                            ath2.rWA = 2;
                            ath2.rWB = "";
                            fj2.nJM = ath2.toByteArray();
                            af.byd().a(i32, fj2);
                        }
                    } catch (Exception e32) {
                        x.e("MicroMsg.SnsInfoStorageLogic", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
                        return false;
                    }
                }
            }
            return true;
        }
        if (atf != null) {
            return false;
        }
        af.byo().b(i, xd);
        for (int i222 = 0; i222 < atf.rWc.size(); i222++) {
            int i322 = ((ari) atf.rWc.get(i222)).rTF;
            r fj22 = af.byd().fj((long) i322);
            if (fj22 != null) {
                fj22.offset = 0;
                try {
                    ath ath22 = (ath) new ath().aG(fj22.nJM);
                    if (ath22.rWA == 0) {
                        continue;
                    } else {
                        ath22.rWA = 2;
                        ath22.rWB = "";
                        fj22.nJM = ath22.toByteArray();
                        af.byd().a(i322, fj22);
                    }
                } catch (Exception e322) {
                    x.e("MicroMsg.SnsInfoStorageLogic", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean Ml(String str) {
        return q.GF().equals(str.trim());
    }

    public static List<n> byH() {
        List arrayList = new ArrayList();
        o byo = af.byo();
        Cursor rawQuery = byo.diF.rawQuery(o.bBx() + " AND " + o.nJy + " AND  (snsId = 0  ) ", null);
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
        } else {
            rawQuery.moveToFirst();
            do {
                n nVar = new n();
                nVar.d(rawQuery);
                arrayList.add(nVar);
            } while (rawQuery.moveToNext());
            rawQuery.close();
        }
        return arrayList;
    }

    public static String Mm(String str) {
        int i = 1;
        List linkedList = new LinkedList();
        Cursor cursor = af.byu().getCursor();
        if (cursor.moveToFirst()) {
            do {
                t tVar = new t();
                tVar.d(cursor);
                linkedList.add(bi.aG(tVar.field_tagName, ""));
            } while (cursor.moveToNext());
        }
        cursor.close();
        String str2 = str;
        while (linkedList.contains(str2)) {
            StringBuilder append = new StringBuilder().append(str);
            int i2 = i + 1;
            str2 = append.append(i).toString();
            i = i2;
        }
        return str2;
    }

    public static n wy(int i) {
        n nVar = new n();
        o byo = af.byo();
        x.i("MicroMsg.SnsInfoStorage", "getTimelineByCreateTime sql %s", new Object[]{((o.bBy() + " and createTime < " + i) + o.nJs) + " LIMIT 1"});
        Cursor rawQuery = byo.diF.rawQuery(r3, null);
        if (rawQuery == null) {
            rawQuery = null;
        }
        if (rawQuery == null) {
            return null;
        }
        if (rawQuery.moveToFirst()) {
            nVar.d(rawQuery);
            rawQuery.close();
            return nVar;
        }
        rawQuery.close();
        return null;
    }

    public static List<b> ey(String str, String str2) {
        int i = 0;
        List<b> arrayList = new ArrayList();
        cj cjVar = null;
        try {
            String str3 = str2 + str + "_ARTISTF.mm";
            String str4 = str2 + str + "_ARTIST.mm";
            if (FileOp.cn(str3)) {
                cjVar = (cj) new cj().aG(FileOp.e(str3, 0, (int) FileOp.mI(str3)));
            }
            if (cjVar == null) {
                FileOp.deleteFile(str3);
                cjVar = a.MP(new String(FileOp.e(str4, 0, (int) FileOp.mI(str4))));
                FileOp.b(str3, cjVar.toByteArray(), -1);
            }
            Iterator it = cjVar.rcM.iterator();
            while (it.hasNext()) {
                alh alh = (alh) it.next();
                str4 = alh.jPe;
                Iterator it2 = alh.ruA.iterator();
                while (it2.hasNext()) {
                    ate ate = (ate) it2.next();
                    ate.jOS = str4;
                    b bVar = new b();
                    bVar.caK = ate;
                    bVar.nuP = "";
                    int i2 = i + 1;
                    bVar.nuQ = i;
                    arrayList.add(bVar);
                    i = i2;
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.SnsInfoStorageLogic", "error initDataArtist");
        }
        return arrayList;
    }

    public static ate a(n nVar, int i) {
        if (af.bxX() || nVar == null) {
            return null;
        }
        bsu bAJ = nVar.bAJ();
        if (bAJ.sqc == null || bAJ.sqc.ruA.size() == 0 || bAJ.sqc.ruA.size() <= i) {
            return null;
        }
        return (ate) bAJ.sqc.ruA.get(i);
    }

    public static ate a(n nVar, String str) {
        bsu bAJ = nVar.bAJ();
        if (bAJ.sqc == null || bAJ.sqc.ruA.size() == 0) {
            return null;
        }
        Iterator it = bAJ.sqc.ruA.iterator();
        while (it.hasNext()) {
            ate ate = (ate) it.next();
            if (ate.ksA.equals(str)) {
                return ate;
            }
        }
        return null;
    }

    public static List<b> Mn(String str) {
        List<b> arrayList = new ArrayList();
        if (af.bxX()) {
            return arrayList;
        }
        n Nl = h.Nl(str);
        if (Nl == null) {
            return arrayList;
        }
        bsu bAJ = Nl.bAJ();
        if (bAJ.sqc == null || bAJ.sqc.ruA.size() == 0) {
            return arrayList;
        }
        arrayList.clear();
        int i = 0;
        Iterator it = bAJ.sqc.ruA.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return arrayList;
            }
            ate ate = (ate) it.next();
            b bVar = new b();
            bVar.caK = ate;
            bVar.nuP = str;
            bVar.dTR = bAJ.lOH;
            i = i2 + 1;
            bVar.nuQ = i2;
            arrayList.add(bVar);
        }
    }

    public static List<b> ch(List<String> list) {
        List<b> arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        arrayList.clear();
        int i = 0;
        Iterator it = list.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return arrayList;
            }
            String str = (String) it.next();
            b bVar = new b();
            ate ate = new ate();
            ate.ksA = "pre_temp_extend_pic" + str;
            bVar.caK = ate;
            bVar.nuP = "";
            i = i2 + 1;
            bVar.nuQ = i2;
            arrayList.add(bVar);
        }
    }

    public static void wz(int i) {
        x.d("MicroMsg.SnsInfoStorageLogic", "unsetOmitResendFlag localId　" + i);
        n xd = af.byo().xd(i);
        if (xd != null) {
            if (((xd.field_localFlag & 64) > 0 ? 1 : null) != null) {
                xd.field_localFlag &= -65;
            }
            af.byo().b(i, xd);
        }
    }

    public static void byI() {
        Cursor ch = af.byo().ch("", 0);
        if (ch != null) {
            x.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId begin");
            while (ch.moveToNext()) {
                n nVar = new n();
                nVar.d(ch);
                x.i("MicroMsg.SnsInfoStorageLogic", nVar.bAK());
            }
            x.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId end");
            ch.close();
        }
    }
}
