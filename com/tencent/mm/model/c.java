package com.tencent.mm.model;

import android.content.SharedPreferences;
import com.tencent.mm.bt.h.a;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b.b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelstat.m;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.h;
import com.tencent.mm.storage.j;
import com.tencent.mm.storage.l;
import com.tencent.mm.storage.n;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.p;
import com.tencent.mm.storage.y;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c {
    public static HashMap<Integer, d> cVM;
    public bn dAb;
    public bm dAc;
    h dAd;
    com.tencent.mm.model.b.c dAe;
    com.tencent.mm.model.b.d dAf;
    j dAg;
    n dAh;
    l dAi;
    b dAj;

    public c() {
        g.Ek();
        e Ei = g.Ei();
        Ei.dqm.aI(new a() {
            public final void Ea() {
                g.Ek();
                if (g.Eg().Dx()) {
                    m Sj = q.Sj();
                    if (Sj != null) {
                        x.i("MicroMsg.AccountStorage", "summer preCloseCallback netStatStg: " + Sj);
                        long currentTimeMillis = System.currentTimeMillis();
                        Sj.ekz.li(true);
                        x.i("MicroMsg.NetStat", "summer net appendAllToDisk end takes: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                    }
                }
            }

            public final void Eb() {
            }

            public final void Ec() {
            }
        });
        com.tencent.mm.kernel.a.c.Et().add(new com.tencent.mm.kernel.api.b() {
            public final List<String> collectStoragePaths() {
                Object linkedList = new LinkedList();
                Collections.addAll(linkedList, new String[]{"image/shakeTranImg/", "emoji/", "locallog", "mailapp/", "mailapp/", "voice2/", "video/", "attachment/"});
                return linkedList;
            }
        });
        com.tencent.mm.kernel.a.c.Et().add(new 3(this));
    }

    public static int Df() {
        g.Ek();
        g.Eg();
        return com.tencent.mm.kernel.a.Df();
    }

    public static String FL() {
        g.Ek();
        return g.Ei().dqo;
    }

    public static void DV() {
        g.Ek();
        g.Ei().DV();
    }

    public static boolean isSDCardAvailable() {
        g.Ek();
        return g.Ei().isSDCardAvailable();
    }

    public static String DP() {
        g.Ek();
        return g.Ei().DP();
    }

    public static void closeDB() {
        g.Ek();
        g.Ei().ex(null);
    }

    public static void a(aq aqVar) {
        g.Ek();
        com.tencent.mm.kernel.a Eg = g.Eg();
        x.i("MMKernel.CoreAccount", "UserStatusChange: add %s", new Object[]{aqVar});
        synchronized (Eg.dpz) {
            if (!Eg.dpz.contains(aqVar)) {
                Eg.dpz.add(aqVar);
            }
        }
    }

    public static void b(aq aqVar) {
        g.Ek();
        com.tencent.mm.kernel.a Eg = g.Eg();
        x.i("MMKernel.CoreAccount", "UserStatusChange: remove %s", new Object[]{aqVar});
        synchronized (Eg.dpz) {
            Eg.dpz.remove(aqVar);
        }
    }

    public static void Dt() {
        g.Ek();
        g.Eg().Dt();
    }

    public static boolean FM() {
        g.Ek();
        return com.tencent.mm.kernel.a.gI(g.Eg().dpx);
    }

    public static int FN() {
        g.Ek();
        return g.Eg().dpy;
    }

    public static com.tencent.mm.bt.h FO() {
        g.Ek();
        return g.Ei().dqq;
    }

    public static com.tencent.mm.bt.h FP() {
        g.Ek();
        return g.Ei().dqr;
    }

    public static SharedPreferences gh(String str) {
        g.Ek();
        return g.Ei().gh(str);
    }

    public static com.tencent.mm.storage.x DT() {
        g.Ek();
        return g.Ei().DT();
    }

    public static bn DU() {
        g.Ek();
        return g.Ei().DU();
    }

    public static com.tencent.mm.plugin.messenger.foundation.a.a.g FQ() {
        return ((i) g.l(i.class)).FQ();
    }

    public static ay FR() {
        return ((i) g.l(i.class)).FR();
    }

    public static k FS() {
        return ((i) g.l(i.class)).FS();
    }

    public static f FT() {
        return ((i) g.l(i.class)).bcY();
    }

    public static o FU() {
        return ((com.tencent.mm.ac.o) g.l(com.tencent.mm.ac.o.class)).FU();
    }

    public static p FV() {
        return ((com.tencent.mm.ac.o) g.l(com.tencent.mm.ac.o.class)).FV();
    }

    public static az FW() {
        return ((i) g.l(i.class)).FW();
    }

    public static com.tencent.mm.plugin.downloader.c.b FX() {
        return ((com.tencent.mm.plugin.downloader.a.c) g.l(com.tencent.mm.plugin.downloader.a.c.class)).FX();
    }

    public static bc FY() {
        return ((com.tencent.mm.plugin.t.a.a) g.l(com.tencent.mm.plugin.t.a.a.class)).FY();
    }

    public static com.tencent.mm.plugin.messenger.foundation.a.a.i FZ() {
        return ((i) g.l(i.class)).FZ();
    }

    public static af Ga() {
        g.Ek();
        g.Eg().Ds();
        return ((com.tencent.mm.plugin.chatroom.b.b) g.l(com.tencent.mm.plugin.chatroom.b.b.class)).Ga();
    }

    public static String Gb() {
        return com.tencent.mm.plugin.p.c.Gb();
    }

    public static String Gc() {
        return com.tencent.mm.plugin.p.c.Gc();
    }

    public static String Gd() {
        return com.tencent.mm.modelvoice.q.Gd();
    }

    public static String Ge() {
        return com.tencent.mm.plugin.record.b.Ge();
    }

    public static String Gf() {
        return y.Gf();
    }

    public static String Gg() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Ek();
        return stringBuilder.append(g.Ei().dqp).append("emoji/").toString();
    }

    public static String Gh() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Ek();
        return stringBuilder.append(g.Ei().dqp).append("mailapp/").toString();
    }

    public static String getAccVideoPath() {
        com.tencent.mm.modelvideo.o.SZ();
        return com.tencent.mm.modelvideo.o.getAccVideoPath();
    }

    public static String Gi() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Ek();
        return stringBuilder.append(g.Ei().dqp).append("image/shakeTranImg/").toString();
    }

    public static String Gj() {
        return com.tencent.mm.plugin.m.a.Gj();
    }

    public static String Gk() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Ek();
        return stringBuilder.append(g.Ei().dqp).append("attachment/").toString();
    }

    public static String Gl() {
        return ((com.tencent.mm.ac.o) g.l(com.tencent.mm.ac.o.class)).Gl();
    }

    public static String Gm() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Ek();
        return stringBuilder.append(g.Ei().dqp).append("record/").toString();
    }

    public static String getAccSnsPath() {
        return ((com.tencent.mm.plugin.sns.b.b) g.n(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsPath();
    }

    public static String getAccSnsTmpPath() {
        return ((com.tencent.mm.plugin.sns.b.b) g.n(com.tencent.mm.plugin.sns.b.b.class)).getAccSnsTmpPath();
    }

    public static String Gn() {
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        return stringBuilder.append(Gq()).append("voiceremind/").toString();
    }

    public static String Go() {
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        return stringBuilder.append(Gq()).append("wenote/").toString();
    }

    public static String DQ() {
        g.Ek();
        return g.Ei().DQ();
    }

    public static String DR() {
        g.Ek();
        return g.Ei().DR();
    }

    public static String Gp() {
        g.Ek();
        return g.Ei().cachePath;
    }

    public static String Gq() {
        g.Ek();
        return g.Ei().dqp;
    }

    public final void Gr() {
        StringBuilder stringBuilder = new StringBuilder("mm");
        g.Ek();
        g.Eg();
        String u = com.tencent.mm.a.g.u(stringBuilder.append(com.tencent.mm.kernel.a.Df()).toString().getBytes());
        String str = aa.duN + u + "/";
        String str2 = com.tencent.mm.compatible.util.e.bnE + u + "/";
        String[] list = new File(str).list(new 4(this));
        if (list != null) {
            for (String str3 : list) {
                String str4 = str2 + str3 + ".dump";
                FileOp.deleteFile(str4);
                FileOp.y(str + str3, str4);
                x.i("MicroMsg.AccountStorage", "Exported: " + str4);
            }
        }
    }

    public static void Gs() {
    }

    public static void gi(int i) {
        p.gS(i);
        if ((i & 16) != 0) {
            bd.a("medianote", null);
            au.HU();
            FW().Yp("medianote");
        }
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("BOTTLE_MESSAGE_TABLE".hashCode()), new 5());
        cVM.put(Integer.valueOf("APPBRAND_MESSAGE_TABLE".hashCode()), new 6());
        cVM.put(Integer.valueOf("BackupMoveTime".hashCode()), new 7());
        cVM.put(Integer.valueOf("BackupTempMoveTime".hashCode()), new 8());
        cVM.put(Integer.valueOf("BackupRecoverMsgListDataId".hashCode()), new 9());
    }

    public final com.tencent.mm.model.b.c Gt() {
        g.Ek();
        g.Eg().Ds();
        return this.dAe;
    }

    public final com.tencent.mm.model.b.d Gu() {
        g.Ek();
        g.Eg().Ds();
        return this.dAf;
    }

    public final b Gv() {
        g.Ek();
        g.Eg().Ds();
        return this.dAj;
    }

    public static com.tencent.mm.storage.g Gw() {
        g.Ek();
        g.Eg().Ds();
        return com.tencent.mm.plugin.d.a.ZN().Gw();
    }

    public static com.tencent.mm.plugin.messenger.foundation.a.a.b Gx() {
        g.Ek();
        g.Eg().Ds();
        return ((i) g.l(i.class)).Gx();
    }

    public final j Gy() {
        g.Ek();
        g.Eg().Ds();
        return this.dAg;
    }

    public final n Gz() {
        g.Ek();
        g.Eg().Ds();
        return this.dAh;
    }

    public final l GA() {
        g.Ek();
        g.Eg().Ds();
        return this.dAi;
    }
}
