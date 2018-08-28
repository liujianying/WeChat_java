package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.modelvideo.i;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.av;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class ar implements a {
    boolean emK;
    boolean emL;
    f emO;
    c nrA;
    ay nrJ;
    LinkedList<ay> nrK;
    Map<String, ay> nrL;
    LinkedList<n> nrM;
    c nrN;
    c nrz;

    static /* synthetic */ void a(ar arVar) {
        g.Ek();
        g.Em().H(new 8(arVar));
    }

    static /* synthetic */ j b(n nVar, int i, String str) {
        if (nVar == null) {
            return null;
        }
        ate ate = (ate) nVar.bAJ().sqc.ruA.get(0);
        String bBe = nVar.bBe();
        String a = aq.a(bBe, ate);
        if (bi.oW(a)) {
            boolean cr = e.cr(aq.Ms(ate.ksA));
            a = aq.D(ate);
            r Mt = aq.Mt(bBe);
            if (Mt == null) {
                aq.cf(bBe, 30);
            } else {
                aq.c(Mt, 30);
            }
            x.i("MicroMsg.SnsVideoService", "preload stream download sns video %s mkDir %b", new Object[]{a, Boolean.valueOf(cr)});
            com.tencent.mm.plugin.sns.model.a.a aVar = new com.tencent.mm.plugin.sns.model.a.a(ate.ksA);
            aVar.noc = ate;
            av clY = av.clY();
            clY.time = nVar.field_createTime;
            aVar.nsJ = clY;
            aVar.nsH = true;
            aVar.url = ate.jPK;
            int i2 = ate.hcE;
            aVar.nsG = false;
            com.tencent.mm.modelvideo.n.SY();
            o.Tb();
            j a2 = com.tencent.mm.modelcdntran.f.a(aVar.nsJ, aVar.url, a, aq.nJ(bBe), 2);
            if (a2 == null) {
                return null;
            }
            a2.bxC = ate.rVZ;
            a2.field_preloadRatio = i;
            a2.bSZ = str;
            String str2 = nVar.field_userName;
            a2.dQn = str2;
            a2.bSS = str2;
            return a2;
        }
        x.i("MicroMsg.SnsVideoService", "this video[%s] already download finish, do nothing.", new Object[]{a});
        o.Tc().a(ate.rVZ, 3, (long) e.cm(a), nVar.field_userName, "", 0, "", ate.jPK, str);
        h.mEJ.a(354, 147, 1, false);
        return null;
    }

    public ar() {
        this.nrK = null;
        this.nrL = null;
        this.emO = null;
        this.nrM = null;
        this.emK = false;
        this.emL = false;
        this.nrN = new 9(this);
        this.nrz = new 10(this);
        this.nrA = new c<com.tencent.mm.g.a.ar>() {
            {
                this.sFo = com.tencent.mm.g.a.ar.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                com.tencent.mm.g.a.ar arVar = (com.tencent.mm.g.a.ar) bVar;
                ar.this.emK = arVar.bIf.bIg;
                x.d("MicroMsg.SnsVideoService", "set isInChatting:%b", new Object[]{Boolean.valueOf(ar.this.emK)});
                if (ar.this.emL || ar.this.emK) {
                    ar.this.byS();
                }
                if (!(ar.this.emK || ar.this.emL)) {
                    ar.this.byR();
                }
                i Tc = o.Tc();
                Tc.emK = ar.this.emK;
                if (Tc.emK) {
                    Tc.stopDownload();
                } else {
                    Tc.ST();
                }
                return false;
            }
        };
        this.nrJ = null;
        this.nrK = new LinkedList();
        this.nrL = new HashMap();
        this.nrM = new LinkedList();
        com.tencent.mm.sdk.b.a.sFg.b(this.nrN);
        com.tencent.mm.sdk.b.a.sFg.b(this.nrz);
        com.tencent.mm.sdk.b.a.sFg.b(this.nrA);
    }

    public final void byR() {
        g.Em().H(new Runnable() {
            public final void run() {
                if (ar.this.nrJ == null && ar.this.nrK.isEmpty() && ar.this.emO == null && !ar.this.emK && !ar.this.emL) {
                    n nVar;
                    n nVar2 = null;
                    j jVar = null;
                    PBool pBool = new PBool();
                    PInt pInt = new PInt();
                    PString pString = new PString();
                    synchronized (ar.this.nrM) {
                        Iterator it = ar.this.nrM.iterator();
                        while (it.hasNext()) {
                            Object obj;
                            nVar2 = (n) it.next();
                            ar arVar = ar.this;
                            if (nVar2 == null) {
                                pBool.value = true;
                                obj = null;
                            } else if (bi.bG((long) nVar2.field_createTime) >= 86400) {
                                pBool.value = true;
                                obj = null;
                            } else if (o.Tc().bU(false)) {
                                pBool.value = true;
                                obj = null;
                            } else {
                                boy m = aj.m(nVar2);
                                if (m == null || m.sna == null) {
                                    x.i("MicroMsg.SnsVideoService", "sns obj is null or sns obj PreDownloadInfo is null");
                                    pBool.value = true;
                                    obj = null;
                                } else {
                                    x.i("MicroMsg.SnsVideoService", "%d check sns video[%s] preload [%d %d %s]", new Object[]{Integer.valueOf(arVar.hashCode()), nVar2.bBe(), Integer.valueOf(m.sna.sdz), Integer.valueOf(m.sna.sdA), m.sna.sdB});
                                    if (m.sna.sdz <= 0) {
                                        x.i("MicroMsg.SnsVideoService", "%d can not preload because percent <= 0", new Object[]{Integer.valueOf(arVar.hashCode())});
                                        pBool.value = true;
                                        obj = null;
                                    } else {
                                        pString.value = m.rlK;
                                        pInt.value = m.sna.sdz;
                                        if (!com.tencent.mm.modelcontrol.b.lz(m.sna.sdB)) {
                                            int i;
                                            if (ao.isWifi(ad.getContext())) {
                                                i = m.sna.sdA & 1;
                                            } else if (ao.is4G(ad.getContext())) {
                                                i = m.sna.sdA & 2;
                                            } else if (ao.is3G(ad.getContext())) {
                                                i = m.sna.sdA & 4;
                                            } else {
                                                pBool.value = false;
                                                obj = null;
                                            }
                                            if (i > 0) {
                                                pBool.value = false;
                                                obj = 1;
                                            }
                                        }
                                        pBool.value = false;
                                        obj = null;
                                    }
                                }
                            }
                            if (pBool.value) {
                                it.remove();
                            }
                            if (obj != null) {
                                jVar = ar.b(nVar2, pInt.value, pString.value);
                                if (jVar != null) {
                                    break;
                                }
                                it.remove();
                            } else {
                                nVar2 = null;
                            }
                        }
                        nVar = nVar2;
                    }
                    if (nVar != null && jVar != null) {
                        Object obj2 = null;
                        if (jVar != null) {
                            try {
                                ar.this.emO = new f(jVar, nVar.bBe());
                                if (ar.this.emO.a(ar.this) < 0) {
                                    x.w("MicroMsg.SnsVideoService", "%s curr preload task do scene error.", new Object[]{Integer.valueOf(ar.this.hashCode())});
                                    obj2 = 1;
                                    ar.this.emO = null;
                                }
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.SnsVideoService", e, "", new Object[0]);
                                return;
                            }
                        }
                        obj2 = 1;
                        if (obj2 != null) {
                            synchronized (ar.this.nrM) {
                                Iterator it2 = ar.this.nrM.iterator();
                                while (it2.hasNext()) {
                                    nVar2 = (n) it2.next();
                                    if (nVar2 != null && bi.fS(nVar2.bBe(), nVar.bBe())) {
                                        x.i("MicroMsg.SnsVideoService", "%d find sns info[%s], remove now", new Object[]{Integer.valueOf(ar.this.hashCode()), nVar.bBe()});
                                        it2.remove();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    public final void byS() {
        x.d("MicroMsg.SnsVideoService", "%d stop preload %s", new Object[]{Integer.valueOf(hashCode()), bi.cjd()});
        g.Em().H(new 1(this));
    }

    public final void a(f fVar, boolean z, int i, int i2) {
        if (fVar == null) {
            x.e("MicroMsg.SnsVideoService", "%d on preload finish but scene is null?", new Object[]{Integer.valueOf(hashCode())});
            return;
        }
        if (this.emO != fVar) {
            x.w("MicroMsg.SnsVideoService", "%d on preload finish, but scene callback not same object.", new Object[]{Integer.valueOf(hashCode())});
        }
        x.i("MicroMsg.SnsVideoService", "%d preload video[%s] finish success[%b] range[%d, %d]", new Object[]{Integer.valueOf(hashCode()), fVar.SS(), Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)});
        g.Em().H(new 4(this, fVar));
    }

    final boolean byT() {
        int i;
        long VG = bi.VG();
        x.i("MicroMsg.SnsVideoService", "%d start to delete expired file limit[%d] status[%d] expiredTime[%d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(1), Integer.valueOf(130), Long.valueOf(bi.VE() - (((long) ((com.tencent.mm.plugin.zero.b.a) g.l(com.tencent.mm.plugin.zero.b.a.class)).AT().getInt("SnSPreLoadVideoExpiredTime", 1)) * 86400))});
        List<r> n = o.Ta().n(130, r0);
        if (n == null || n.isEmpty()) {
            return false;
        }
        int i2 = 0;
        for (r rVar : n) {
            if (rVar != null) {
                try {
                    int i3;
                    String D = aq.D((ate) af.byo().Nl(aq.Mr(rVar.getFileName())).bAJ().sqc.ruA.get(0));
                    if (!bi.oW(D)) {
                        File file = new File(D);
                        if (file.exists()) {
                            long length = file.length();
                            x.i("MicroMsg.SnsVideoService", "%s file[%d %d] lastmodifytime[%d] path[%s]", new Object[]{rVar.getFileName(), Long.valueOf(length), Integer.valueOf(rVar.bSX), Long.valueOf(rVar.enK), D});
                            if (length > 0 && length <= ((long) rVar.bSX)) {
                                file.delete();
                                i3 = i2 + 1;
                                rVar.bSX = 0;
                                rVar.bWA = 1;
                                t.e(rVar);
                                i2 = i3;
                            }
                        }
                    }
                    i3 = i2;
                    try {
                        rVar.bSX = 0;
                        rVar.bWA = 1;
                        t.e(rVar);
                        i2 = i3;
                    } catch (Exception e) {
                        i = i3;
                        i2 = i;
                    }
                } catch (Exception e2) {
                    i = i2;
                    i2 = i;
                }
            }
        }
        h.mEJ.a(354, 145, (long) i2, false);
        x.i("MicroMsg.SnsVideoService", "%d delete expire file size %d delete count %d costTime[%d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(n.size()), Integer.valueOf(i2), Long.valueOf(bi.bI(VG))});
        return false;
    }

    public final boolean a(ate ate, int i, String str, boolean z, boolean z2, int i2) {
        int i3 = 0;
        if (ate.rVD == 2) {
            x.w("MicroMsg.SnsVideoService", "add video task, but url is weixin, do nothing");
            return false;
        }
        ay ayVar = new ay();
        ayVar.elz = aq.aG(i, ate.jPK);
        ayVar.caK = ate;
        ayVar.dTR = i;
        ayVar.bKW = str;
        if (z) {
            i3 = 1;
        }
        ayVar.dQm = i3;
        ayVar.dQo = i2;
        g.Ek();
        g.Em().H(new 6(this, ayVar, z2));
        if (z2) {
            byU();
        }
        return true;
    }

    final void byU() {
        g.Ek();
        g.Em().H(new 7(this));
    }

    final boolean a(ay ayVar, boolean z) {
        if (bi.oW(aq.a(ayVar.bKW, ayVar.caK))) {
            boolean cr = e.cr(aq.Ms(ayVar.caK.ksA));
            String D = aq.D(ayVar.caK);
            r Mt = aq.Mt(ayVar.bKW);
            if (Mt == null) {
                aq.cf(ayVar.bKW, ayVar.dQo);
            } else {
                aq.c(Mt, ayVar.dQo);
            }
            x.i("MicroMsg.SnsVideoService", "prepare stream download sns video %s mkDir %b", new Object[]{D, Boolean.valueOf(cr)});
            com.tencent.mm.plugin.sns.model.a.a aVar = new com.tencent.mm.plugin.sns.model.a.a(ayVar.caK.ksA);
            aVar.noc = ayVar.caK;
            av clY = av.clY();
            clY.time = ayVar.dTR;
            aVar.nsJ = clY;
            aVar.nsH = true;
            aVar.url = ayVar.caK.jPK;
            int i = ayVar.caK.hcE;
            aVar.nsG = false;
            com.tencent.mm.modelvideo.n.SY();
            o.Tb();
            j a = com.tencent.mm.modelcdntran.f.a(aVar.nsJ, aVar.url, D, aq.nJ(ayVar.bKW), ayVar.dQm);
            if (a == null) {
                return false;
            }
            D = ayVar.nsF;
            a.dQn = D;
            a.bSS = D;
            try {
                boy m = aj.m(af.byo().Nl(ayVar.bKW));
                if (m != null) {
                    a.bSZ = m.rlK;
                    a.dQr = m.sna.sdz;
                }
            } catch (Exception e) {
            }
            this.nrJ = ayVar;
            this.nrJ.elz = a.field_mediaId;
            x.i("MicroMsg.SnsVideoService", "start stream download sns video cdnMediaId %s delay %b", new Object[]{this.nrJ.elz, Boolean.valueOf(z)});
            o.Tb().a(a, z);
            return true;
        }
        x.i("MicroMsg.SnsVideoService", "this video[%s] already download finish, do nothing. [%s, %s]", new Object[]{ayVar.elz, ayVar.bKW, aq.a(ayVar.bKW, ayVar.caK)});
        return false;
    }
}
