package com.tencent.mm.plugin.sns.model;

import android.content.Intent;
import android.os.Looper;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.plugin.sns.b.h.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.c.boh;
import com.tencent.mm.protocal.c.boi;
import com.tencent.mm.protocal.c.bon;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class am$a implements e, h {
    public static int nrk = -1;
    private Map<a, String> dJw = new HashMap();
    private Map<String, Long> nrl = new HashMap();
    private Map<String, Integer> nrm = new HashMap();
    private int nrn = 0;
    public long nro = 0;
    private LinkedList<String> nrp = new LinkedList();
    public Map<String, ArrayList<b>> nrq = new HashMap();
    public Map<String, Integer> nrr = new HashMap();

    static /* synthetic */ void a(am$a am_a) {
        if (!af.bxX() && am_a.dJw.isEmpty()) {
            af.byl().bxC();
            x.d("MicroMsg.SnsService", "clean sns cache");
        }
    }

    public final void h(String str, ArrayList<b> arrayList) {
        this.nrq.put(str, arrayList);
    }

    public final Intent e(Intent intent, String str) {
        intent.putExtra("sns_userName", str);
        if (this.nrp != null && this.nrp.contains(str)) {
            intent.addFlags(536870912);
            intent.addFlags(67108864);
        }
        return intent;
    }

    public final void a(int i, String str, a aVar) {
        x.i("MicroMsg.SnsService", "startServer " + i + " " + aVar);
        af.byn().cXR = q.GF();
        af.byn().bxP();
        af.byk().bwX();
        if (this.dJw.isEmpty()) {
            g.Ek();
            g.Eh().dpP.a(211, this);
            g.Ek();
            g.Eh().dpP.a(212, this);
        }
        if (!this.dJw.containsKey(aVar)) {
            if (i == 1) {
                this.dJw.put(aVar, "@__weixintimtline");
            } else if (i == 2 || i == 3) {
                this.dJw.put(aVar, str);
            } else if (i == 4) {
                this.dJw.put(aVar, "@__classify_timeline");
            } else if (i == 5) {
                this.dJw.put(aVar, "");
            } else {
                this.dJw.put(aVar, "");
            }
        }
        switch (i) {
            case 1:
                this.nro = 0;
                this.nrn = byM();
                y.Mc("@__weixintimtline");
                return;
            case 2:
                synchronized (this.nrl) {
                    this.nrl.put(str, Long.valueOf(0));
                }
                synchronized (this.nrm) {
                    if (!this.nrm.containsKey(str)) {
                        this.nrm.put(str, Integer.valueOf(byM()));
                    }
                }
                aa.Mf(str);
                this.nrp.add(str);
                return;
            default:
                return;
        }
    }

    public final boolean a(a aVar, int i) {
        x.d("MicroMsg.SnsService", "closeServer");
        this.dJw.remove(aVar);
        if (i == 2 && this.nrp.size() > 0) {
            this.nrp.removeLast();
        }
        if (this.dJw.isEmpty()) {
            g.Ek();
            g.Eh().dpP.b(211, this);
            g.Ek();
            g.Eh().dpP.b(212, this);
            an.release();
            n.release();
            new ag(Looper.getMainLooper()).postDelayed(new 1(this), 5000);
            aj.byG();
            x.i("MicroMsg.SnsService", "close finish");
        }
        return true;
    }

    public final void b(int i, String str, boolean z, int i2) {
        if (!af.ewT) {
            synchronized (this.nrl) {
                x.d("MicroMsg.SnsService", "DO NP　NP ~_~ %s type %s timeLastId: %s userLastIds: %s", new Object[]{str, Integer.valueOf(i), Long.valueOf(this.nro), this.nrl});
            }
            if (i == 2) {
                if (aa.Me(str)) {
                    long j = 0;
                    synchronized (this.nrl) {
                        if (this.nrl.containsKey(str)) {
                            j = ((Long) this.nrl.get(str)).longValue();
                        }
                    }
                    if (j == 0) {
                        y.Mc(str);
                        return;
                    }
                    g.Ek();
                    g.Eh().dpP.a(new aa(str, j, z, i2), 0);
                }
            } else if (i == 1) {
                if (!y.Mb("@__weixintimtline")) {
                    return;
                }
                if (this.nro == 0) {
                    y.Mc("@__weixintimtline");
                    return;
                }
                g.Ek();
                g.Eh().dpP.a(new y(this.nro), 0);
            } else if (i == 3 || i != 4 || !n.Mb("@__classify_timeline")) {
            } else {
                if (this.nro == 0) {
                    n.Mc("@__classify_timeline");
                    return;
                }
                g.Ek();
                g.Eh().dpP.a(new n(""), 0);
            }
        }
    }

    public final void a(int i, String str, boolean z, int i2) {
        if (!af.ewT) {
            x.d("MicroMsg.SnsService", "doFpList type: %s, objectId: %s", new Object[]{Integer.valueOf(i), str});
            if (i == 2) {
                if (aa.Me(str)) {
                    g.Ek();
                    g.Eh().dpP.a(new aa(str, 0, z, i2), 0);
                }
            } else if (i == 1) {
                if (y.Mb("@__weixintimtline")) {
                    g.Ek();
                    g.Ei().DT().set(68377, "");
                    g.Ek();
                    g.Eh().dpP.a(new y(0), 0);
                }
            } else if (i != 3 && i == 4 && n.Mb("@__classify_timeline")) {
                g.Ek();
                g.Eh().dpP.a(new n(""), 0);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int Mo(java.lang.String r3) {
        /*
        r2 = this;
        r1 = r2.nrm;
        monitor-enter(r1);
        r0 = r2.nrm;	 Catch:{ all -> 0x0026 }
        r0 = r0.containsKey(r3);	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x0020;
    L_0x000b:
        r0 = r2.nrm;	 Catch:{ all -> 0x0026 }
        r0 = r0.get(r3);	 Catch:{ all -> 0x0026 }
        r0 = (java.lang.Integer) r0;	 Catch:{ all -> 0x0026 }
        r0 = r0.intValue();	 Catch:{ all -> 0x0026 }
        if (r0 <= 0) goto L_0x001b;
    L_0x0019:
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
    L_0x001a:
        return r0;
    L_0x001b:
        r0 = com.tencent.mm.plugin.sns.data.i.bwZ();	 Catch:{ all -> 0x0026 }
        goto L_0x0019;
    L_0x0020:
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        r0 = com.tencent.mm.plugin.sns.data.i.bwZ();
        goto L_0x001a;
    L_0x0026:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.model.am$a.Mo(java.lang.String):int");
    }

    public final int byM() {
        return this.nrn > 0 ? this.nrn : i.bwZ();
    }

    public final void z(long j, int i) {
        x.d("MicroMsg.SnsService", "setTimeLastId %d", new Object[]{Long.valueOf(j)});
        if (i > 0) {
            this.nrn = i;
            i.wm(i);
        }
        if (j != 0) {
            this.nro = j;
        }
    }

    public static int byN() {
        if (nrk != -1) {
            return nrk;
        }
        int bwY = i.bwY();
        nrk = bwY;
        return bwY;
    }

    public final void a(int i, int i2, String str, l lVar) {
        Object obj;
        x.i("MicroMsg.SnsService", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + lVar.getType());
        if (!((i == 4 && i2 == 207) || (i == 4 && i2 == com.tencent.mm.plugin.appbrand.jsapi.share.b.CTRL_INDEX))) {
            if (i == 4 && (i2 == 2001 || i2 == 2004)) {
                obj = 1;
                if (obj != null) {
                    int i3;
                    switch (lVar.getType()) {
                        case 211:
                            y yVar = (y) lVar;
                            z(yVar.nnT, yVar.nnV);
                            i3 = yVar.nnW;
                            if (nrk != i3) {
                                i.wl(i3);
                            }
                            nrk = i3;
                            break;
                        case 212:
                            aa aaVar = (aa) lVar;
                            String str2 = aaVar.userName;
                            long j = aaVar.nnT;
                            i3 = aaVar.nnV;
                            if (i3 > 0) {
                                synchronized (this.nrm) {
                                    this.nrm.put(str2, Integer.valueOf(i3));
                                }
                            }
                            if (j != 0) {
                                synchronized (this.nrl) {
                                    this.nrl.put(str2, Long.valueOf(j));
                                }
                            }
                            break;
                    }
                    if (lVar.getType() == 212 || lVar.getType() == 211) {
                        d dVar = (d) lVar;
                        Iterator it = new ArrayList(this.dJw.keySet()).iterator();
                        while (it.hasNext()) {
                            a aVar = (a) it.next();
                            if (this.dJw.containsKey(aVar)) {
                                String str3 = (String) this.dJw.get(aVar);
                                if (dVar.getUserName().equals(str3)) {
                                    x.d("MicroMsg.SnsService", "notify ui " + str3);
                                    String eG = dVar.bxy() == 0 ? "" : i.eG(dVar.bxy());
                                    boolean bxv;
                                    boolean bxz;
                                    boolean z;
                                    if (dVar.bxu()) {
                                        boolean bxw = dVar.bxw();
                                        bxv = dVar.bxv();
                                        bxz = dVar.bxz();
                                        z = i == 4 && (i2 == 2001 || i2 == 2004 || i2 == 2003);
                                        aVar.a(bxw, bxv, eG, bxz, z, i2, dVar.bxA());
                                    } else {
                                        bxv = dVar.bxv();
                                        bxz = dVar.bxx();
                                        z = i == 4 && (i2 == 2001 || i2 == 2004 || i2 == 2003);
                                        aVar.a(bxv, eG, bxz, z, i2, dVar.bxA());
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (i == 4 && (i2 == 2001 || i2 == 2003)) {
                obj = 1;
                if (obj != null) {
                    int i32;
                    switch (lVar.getType()) {
                        case 211:
                            y yVar2 = (y) lVar;
                            z(yVar2.nnT, yVar2.nnV);
                            i32 = yVar2.nnW;
                            if (nrk != i32) {
                                i.wl(i32);
                            }
                            nrk = i32;
                            break;
                        case 212:
                            aa aaVar2 = (aa) lVar;
                            String str22 = aaVar2.userName;
                            long j2 = aaVar2.nnT;
                            i32 = aaVar2.nnV;
                            if (i32 > 0) {
                                synchronized (this.nrm) {
                                    this.nrm.put(str22, Integer.valueOf(i32));
                                }
                            }
                            if (j2 != 0) {
                                synchronized (this.nrl) {
                                    this.nrl.put(str22, Long.valueOf(j2));
                                }
                            }
                            break;
                    }
                    if (lVar.getType() == 212 || lVar.getType() == 211) {
                        d dVar2 = (d) lVar;
                        Iterator it2 = new ArrayList(this.dJw.keySet()).iterator();
                        while (it2.hasNext()) {
                            a aVar2 = (a) it2.next();
                            if (this.dJw.containsKey(aVar2)) {
                                String str32 = (String) this.dJw.get(aVar2);
                                if (dVar2.getUserName().equals(str32)) {
                                    x.d("MicroMsg.SnsService", "notify ui " + str32);
                                    String eG2 = dVar2.bxy() == 0 ? "" : i.eG(dVar2.bxy());
                                    boolean bxv2;
                                    boolean bxz2;
                                    boolean z2;
                                    if (dVar2.bxu()) {
                                        boolean bxw2 = dVar2.bxw();
                                        bxv2 = dVar2.bxv();
                                        bxz2 = dVar2.bxz();
                                        z2 = i == 4 && (i2 == 2001 || i2 == 2004 || i2 == 2003);
                                        aVar2.a(bxw2, bxv2, eG2, bxz2, z2, i2, dVar2.bxA());
                                    } else {
                                        bxv2 = dVar2.bxv();
                                        bxz2 = dVar2.bxx();
                                        z2 = i == 4 && (i2 == 2001 || i2 == 2004 || i2 == 2003);
                                        aVar2.a(bxv2, eG2, bxz2, z2, i2, dVar2.bxA());
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (!(i == 0 && i2 == 0)) {
                obj = null;
                if (obj != null) {
                    int i322;
                    switch (lVar.getType()) {
                        case 211:
                            y yVar22 = (y) lVar;
                            z(yVar22.nnT, yVar22.nnV);
                            i322 = yVar22.nnW;
                            if (nrk != i322) {
                                i.wl(i322);
                            }
                            nrk = i322;
                            break;
                        case 212:
                            aa aaVar22 = (aa) lVar;
                            String str222 = aaVar22.userName;
                            long j22 = aaVar22.nnT;
                            i322 = aaVar22.nnV;
                            if (i322 > 0) {
                                synchronized (this.nrm) {
                                    this.nrm.put(str222, Integer.valueOf(i322));
                                }
                            }
                            if (j22 != 0) {
                                synchronized (this.nrl) {
                                    this.nrl.put(str222, Long.valueOf(j22));
                                }
                            }
                            break;
                    }
                    if (lVar.getType() == 212 || lVar.getType() == 211) {
                        d dVar22 = (d) lVar;
                        Iterator it22 = new ArrayList(this.dJw.keySet()).iterator();
                        while (it22.hasNext()) {
                            a aVar22 = (a) it22.next();
                            if (this.dJw.containsKey(aVar22)) {
                                String str322 = (String) this.dJw.get(aVar22);
                                if (dVar22.getUserName().equals(str322)) {
                                    x.d("MicroMsg.SnsService", "notify ui " + str322);
                                    String eG22 = dVar22.bxy() == 0 ? "" : i.eG(dVar22.bxy());
                                    boolean bxv22;
                                    boolean bxz22;
                                    boolean z22;
                                    if (dVar22.bxu()) {
                                        boolean bxw22 = dVar22.bxw();
                                        bxv22 = dVar22.bxv();
                                        bxz22 = dVar22.bxz();
                                        z22 = i == 4 && (i2 == 2001 || i2 == 2004 || i2 == 2003);
                                        aVar22.a(bxw22, bxv22, eG22, bxz22, z22, i2, dVar22.bxA());
                                    } else {
                                        bxv22 = dVar22.bxv();
                                        bxz22 = dVar22.bxx();
                                        z22 = i == 4 && (i2 == 2001 || i2 == 2004 || i2 == 2003);
                                        aVar22.a(bxv22, eG22, bxz22, z22, i2, dVar22.bxA());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        obj = 1;
        if (obj != null) {
            int i3222;
            switch (lVar.getType()) {
                case 211:
                    y yVar222 = (y) lVar;
                    z(yVar222.nnT, yVar222.nnV);
                    i3222 = yVar222.nnW;
                    if (nrk != i3222) {
                        i.wl(i3222);
                    }
                    nrk = i3222;
                    break;
                case 212:
                    aa aaVar222 = (aa) lVar;
                    String str2222 = aaVar222.userName;
                    long j222 = aaVar222.nnT;
                    i3222 = aaVar222.nnV;
                    if (i3222 > 0) {
                        synchronized (this.nrm) {
                            this.nrm.put(str2222, Integer.valueOf(i3222));
                        }
                    }
                    if (j222 != 0) {
                        synchronized (this.nrl) {
                            this.nrl.put(str2222, Long.valueOf(j222));
                        }
                    }
                    break;
            }
            if (lVar.getType() == 212 || lVar.getType() == 211) {
                d dVar222 = (d) lVar;
                Iterator it222 = new ArrayList(this.dJw.keySet()).iterator();
                while (it222.hasNext()) {
                    a aVar222 = (a) it222.next();
                    if (this.dJw.containsKey(aVar222)) {
                        String str3222 = (String) this.dJw.get(aVar222);
                        if (dVar222.getUserName().equals(str3222)) {
                            x.d("MicroMsg.SnsService", "notify ui " + str3222);
                            String eG222 = dVar222.bxy() == 0 ? "" : i.eG(dVar222.bxy());
                            boolean bxv222;
                            boolean bxz222;
                            boolean z222;
                            if (dVar222.bxu()) {
                                boolean bxw222 = dVar222.bxw();
                                bxv222 = dVar222.bxv();
                                bxz222 = dVar222.bxz();
                                z222 = i == 4 && (i2 == 2001 || i2 == 2004 || i2 == 2003);
                                aVar222.a(bxw222, bxv222, eG222, bxz222, z222, i2, dVar222.bxA());
                            } else {
                                bxv222 = dVar222.bxv();
                                bxz222 = dVar222.bxx();
                                z222 = i == 4 && (i2 == 2001 || i2 == 2004 || i2 == 2003);
                                aVar222.a(bxv222, eG222, bxz222, z222, i2, dVar222.bxA());
                            }
                        }
                    }
                }
            }
        }
    }

    public static void Mp(String str) {
        ad byn = af.byn();
        if (bi.oW(byn.cXR)) {
            byn.cXR = q.GF();
        }
        String str2 = byn.cXR;
        n Nk = com.tencent.mm.plugin.sns.storage.h.Nk(str);
        try {
            boy boy = (boy) new boy().aG(Nk.field_attrBuf);
            Iterator it = boy.smL.iterator();
            while (it.hasNext()) {
                bon bon = (bon) it.next();
                if (bon.rdS.equals(str2)) {
                    boy.smL.remove(bon);
                    boy.smJ--;
                    Nk.field_attrBuf = boy.toByteArray();
                    if (Nk.xb(32)) {
                        af.byr().a(Nk.bBp());
                    } else {
                        af.byo().z(Nk);
                    }
                    if (af.byn().eU(v.NE(str))) {
                        if (Nk.xb(32)) {
                            Object obj;
                            com.tencent.mm.plugin.sns.storage.a bAH = Nk.bAH();
                            if (bAH == null) {
                                obj = "";
                            } else {
                                String obj2 = bAH.fvT;
                            }
                            ((c) g.l(c.class)).a(11855, Nk.bBq(), new Object[]{Integer.valueOf(0), obj2, Integer.valueOf(Nk.bBq())});
                            g.Ek();
                            g.Eh().dpP.a(new r(v.NE(str), 7), 0);
                            return;
                        }
                        g.Ek();
                        g.Eh().dpP.a(new r(v.NE(str), 5), 0);
                    }
                }
            }
        } catch (Exception e) {
        }
        if (af.byn().eU(v.NE(str))) {
            if (Nk.xb(32)) {
                Object obj22;
                com.tencent.mm.plugin.sns.storage.a bAH2 = Nk.bAH();
                if (bAH2 == null) {
                    obj22 = "";
                } else {
                    String obj222 = bAH2.fvT;
                }
                ((c) g.l(c.class)).a(11855, Nk.bBq(), new Object[]{Integer.valueOf(0), obj222, Integer.valueOf(Nk.bBq())});
                g.Ek();
                g.Eh().dpP.a(new r(v.NE(str), 7), 0);
                return;
            }
            g.Ek();
            g.Eh().dpP.a(new r(v.NE(str), 5), 0);
        }
    }

    public static bon a(n nVar, int i, String str) {
        return b(nVar, i, str, null, false, 0);
    }

    public static bon a(n nVar, int i, String str, bon bon, int i2) {
        return a(nVar, i, str, bon, false, i2);
    }

    public static bon a(n nVar, int i, String str, bon bon, boolean z, int i2) {
        return b(nVar, i, str, bon, z, i2);
    }

    private static bon b(n nVar, int i, String str, bon bon, boolean z, int i2) {
        boh boh = new boh();
        boh.jSA = str;
        boh.lOH = (int) (bi.VF() / 1000);
        boh.sme = q.GH();
        boh.seC = q.GF();
        boh.rdq = 0;
        boh.smf = ((com.tencent.mm.plugin.messenger.a.b) g.l(com.tencent.mm.plugin.messenger.a.b.class)).gT(nVar.field_userName);
        boh.rxF = nVar.field_userName;
        boh.hcE = i;
        boh.smm = i2;
        if (nVar.xb(32)) {
            boh.smj = bon == null ? 0 : bon.smk;
        } else {
            boh.smg = bon == null ? 0 : bon.smh;
        }
        boh boh2 = new boh();
        boh2.seC = bon == null ? "" : bon.rdS;
        boi boi = new boi();
        boi.rlK = nVar.field_snsId;
        boi.smo = boh;
        boi.smp = boh2;
        String str2 = "";
        if (nVar.xb(32)) {
            Object obj;
            com.tencent.mm.plugin.sns.storage.a bAH = nVar.bAH();
            if (bAH == null) {
                obj = "";
            } else {
                String obj2 = bAH.fvT;
            }
            str2 = bAH == null ? "" : bAH.ntU;
            if (boh.hcE == 7) {
                ((c) g.l(c.class)).a(11855, nVar.bBq(), new Object[]{Integer.valueOf(1), obj2, Integer.valueOf(nVar.bBq())});
            } else if (boh.hcE == 8) {
                ((c) g.l(c.class)).a(11855, nVar.bBq(), new Object[]{Integer.valueOf(2), obj2, Integer.valueOf(nVar.bBq())});
            }
            com.tencent.mm.plugin.sns.storage.e bBp = nVar.bBp();
            if (bBp != null && bBp.field_firstControlTime == 0) {
                bBp.field_firstControlTime = boh.lOH;
                af.byr().b(bBp.field_snsId, bBp);
            }
        }
        String u = com.tencent.mm.a.g.u((bi.VG()).getBytes());
        if (nVar.xb(32)) {
            u = "_AD_TAG_" + u;
        }
        if (!af.byn().a(u, boi)) {
            x.e("MicroMsg.SnsService", "can not add Comment");
        } else if (ad.Mg(u)) {
            g.Ek();
            g.Eh().dpP.a(new k(boi, u, str2), 0);
        } else {
            g.Ek();
            g.Eh().dpP.a(new o(boi, u), 0);
        }
        if (!z) {
            return null;
        }
        bon bon2 = new bon();
        bon2.lOH = boh.lOH;
        bon2.hcE = boh.hcE;
        bon2.rdq = boh.rdq;
        bon2.rdS = boh.seC;
        bon2.rTW = boh.sme;
        bon2.jSA = boh.jSA;
        bon2.smm = boh.smm;
        if (nVar.xb(32)) {
            bon2.smj = bon == null ? 0 : bon.smk;
        } else {
            bon2.smg = bon == null ? 0 : bon.smh;
        }
        bon2.smB = bon == null ? "" : bon.rdS;
        return bon2;
    }

    public static bon a(n nVar, int i, String str, String str2, int i2) {
        boh boh = new boh();
        boh.jSA = str;
        boh.lOH = (int) (bi.VF() / 1000);
        boh.sme = q.GH();
        boh.seC = q.GF();
        boh.rdq = i2;
        boh.smf = ((com.tencent.mm.plugin.messenger.a.b) g.l(com.tencent.mm.plugin.messenger.a.b.class)).gT(nVar.field_userName);
        boh.rxF = nVar.field_userName;
        boh.hcE = i;
        if (nVar.xb(32)) {
            boh.smj = 0;
        } else {
            boh.smg = 0;
        }
        boh boh2 = new boh();
        boh2.seC = str2;
        boi boi = new boi();
        boi.rlK = nVar.field_snsId;
        boi.smo = boh;
        boi.smp = boh2;
        String str3 = "";
        if (nVar.xb(32)) {
            Object obj;
            com.tencent.mm.plugin.sns.storage.a bAH = nVar.bAH();
            if (bAH == null) {
                obj = "";
            } else {
                String obj2 = bAH.fvT;
            }
            str3 = bAH == null ? "" : bAH.ntU;
            if (boh.hcE == 7) {
                ((c) g.l(c.class)).a(11855, nVar.bBq(), new Object[]{Integer.valueOf(1), obj2, Integer.valueOf(nVar.bBq())});
            } else if (boh.hcE == 8) {
                ((c) g.l(c.class)).a(11855, nVar.bBq(), new Object[]{Integer.valueOf(2), obj2, Integer.valueOf(nVar.bBq())});
            }
        }
        String u = com.tencent.mm.a.g.u((bi.VG()).getBytes());
        if (nVar.xb(32)) {
            u = "_AD_TAG_" + u;
        }
        if (!af.byn().a(u, boi, str3)) {
            x.e("MicroMsg.SnsService", "can not add Comment");
        } else if (ad.Mg(u)) {
            g.Ek();
            g.Eh().dpP.a(new k(boi, u, str3), 0);
        } else {
            g.Ek();
            g.Eh().dpP.a(new o(boi, u), 0);
        }
        return null;
    }

    public static void a(String str, int i, String str2, n nVar, int i2) {
        if (i == 3 || i == 5) {
            boh boh = new boh();
            boh.jSA = str2;
            boh.lOH = (int) (System.currentTimeMillis() / 1000);
            boh.sme = q.GH();
            boh.seC = q.GF();
            boh.rdq = i2;
            boh.smf = ((com.tencent.mm.plugin.messenger.a.b) g.l(com.tencent.mm.plugin.messenger.a.b.class)).gT(str);
            boh.rxF = str;
            boh.hcE = i;
            boi boi = new boi();
            boi.rlK = nVar.field_snsId;
            boi.smo = boh;
            boi.smp = new boh();
            String u = com.tencent.mm.a.g.u((bi.VG()).getBytes());
            long j = nVar.field_snsId;
            try {
                x.v("MicroMsg.SnsService", "comment stg inserted");
                j jVar = new j();
                jVar.field_talker = str;
                jVar.field_snsID = j;
                jVar.field_createTime = (int) (System.currentTimeMillis() / 1000);
                jVar.field_curActionBuf = boh.toByteArray();
                jVar.field_type = i;
                jVar.field_isSend = true;
                jVar.field_isRead = (short) 1;
                af.byt().b(jVar);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsService", e, "", new Object[0]);
            }
            af.byn().a(u, boi);
        }
    }

    public final void Ly(String str) {
        String accSnsPath = af.getAccSnsPath();
        String str2 = str + "bg_";
        String str3 = str + "tbg_";
        if (FileOp.cn(str2)) {
            FileOp.deleteFile(an.s(accSnsPath, str) + str3);
            FileOp.i(an.s(accSnsPath, str), str2, str3);
        }
    }
}
