package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mm.br.f;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.emoji.e.a;
import com.tencent.mm.plugin.emoji.e.b;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.e.h;
import com.tencent.mm.plugin.emoji.e.j;
import com.tencent.mm.plugin.emoji.e.j.1;
import com.tencent.mm.plugin.emoji.e.l;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager.ConnectivityReceiver;
import com.tencent.mm.pluginsdk.g.a.a.m;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.emotion.n;
import com.tencent.mm.view.SmileyPanelImpl;
import java.util.HashMap;

public class i implements ar {
    private static HashMap<Integer, d> cVM;
    private d ihK;
    private a ihL;
    private g ihM;
    private j ihN;
    private g ihO;
    private e ihP;
    private com.tencent.mm.plugin.emoji.sync.a<com.tencent.mm.plugin.emoji.sync.d> ihQ;
    private volatile h ihR;
    private volatile b ihS;
    private volatile l ihT;
    private volatile j ihU;
    private com.tencent.mm.ak.a.a ihV;
    private c ihW;

    private static i aEt() {
        au.HN();
        i iVar = (i) bs.iK("plugin.emoji");
        if (iVar == null) {
            synchronized (i.class) {
                if (iVar == null) {
                    iVar = new i();
                    au.HN().a("plugin.emoji", iVar);
                }
            }
        }
        return iVar;
    }

    public static com.tencent.mm.ak.a.a aDZ() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (aEt().ihV == null) {
            com.tencent.mm.ak.a.a.b.a aVar = new com.tencent.mm.ak.a.a.b.a(ad.getContext());
            aVar.dXn = new com.tencent.mm.plugin.emoji.d.a();
            aVar.dXl = new com.tencent.mm.view.d.a();
            com.tencent.mm.ak.a.a.b Ps = aVar.Ps();
            aEt().ihV = new com.tencent.mm.ak.a.a(Ps);
        }
        return aEt().ihV;
    }

    public static d aEu() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (aEt().ihK == null) {
            aEt().ihK = new d();
        }
        return aEt().ihK;
    }

    public static a aEv() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (aEt().ihL == null) {
            aEt().ihL = new a();
        }
        return aEt().ihL;
    }

    public static g aEw() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (aEt().ihM == null) {
            aEt().ihM = new g();
        }
        return aEt().ihM;
    }

    public static com.tencent.mm.plugin.emoji.sync.a<com.tencent.mm.plugin.emoji.sync.d> aEx() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (aEt().ihQ == null) {
            aEt().ihQ = new com.tencent.mm.plugin.emoji.sync.a();
        }
        return aEt().ihQ;
    }

    private static synchronized h aEy() {
        h hVar;
        synchronized (i.class) {
            com.tencent.mm.kernel.g.Eg().Ds();
            if (aEt().ihR == null) {
                aEt().ihR = new h();
            }
            hVar = aEt().ihR;
        }
        return hVar;
    }

    private static b aEz() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (aEt().ihS == null) {
            aEt().ihS = new b();
        }
        return aEt().ihS;
    }

    public static l aEA() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (aEt().ihT == null) {
            aEt().ihT = new l();
        }
        return aEt().ihT;
    }

    public static j aEB() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (aEt().ihU == null) {
            aEt().ihU = new j();
        }
        return aEt().ihU;
    }

    public final void onAccountRelease() {
        h aEy = aEy();
        au.getSysCmdMsgExtension().b("emotionstore", aEy.ifv, true);
        au.getSysCmdMsgExtension().b("NewRecommendEmotion", aEy.ifw, true);
        au.getSysCmdMsgExtension().b("EmojiBackup", aEy.ifx, true);
        au.getSysCmdMsgExtension().b("EmotionBackup", aEy.ifx, true);
        b aEz = aEz();
        com.tencent.mm.sdk.b.a.sFg.c(aEz.ieT);
        com.tencent.mm.sdk.b.a.sFg.c(aEz.ieX);
        com.tencent.mm.sdk.b.a.sFg.c(aEz.ieY);
        com.tencent.mm.sdk.b.a.sFg.c(aEz.ieZ);
        com.tencent.mm.sdk.b.a.sFg.c(aEz.ifa);
        com.tencent.mm.sdk.b.a.sFg.c(aEz.ifb);
        com.tencent.mm.sdk.b.a.sFg.c(aEz.ifc);
        com.tencent.mm.sdk.b.a.sFg.c(aEz.ifd);
        com.tencent.mm.sdk.b.a.sFg.c(aEz.ife);
        com.tencent.mm.sdk.b.a.sFg.c(aEz.ieU);
        com.tencent.mm.sdk.b.a.sFg.c(aEz.ieV);
        com.tencent.mm.sdk.b.a.sFg.c(aEz.iff);
        com.tencent.mm.sdk.b.a.sFg.c(aEz.ifg);
        com.tencent.mm.sdk.b.a.sFg.c(aEz.ieW);
        l aEA = aEA();
        aEA.igx.d(aEA.igR);
        aEA.igy.d(aEA.igP);
        aEA.igz.d(aEA.igQ);
        com.tencent.mm.sdk.b.a.sFg.c(aEA.igS);
        if (l.igN != null) {
            l.igN.clear();
            l.igN = null;
        }
        if (l.igO != null) {
            l.igO.clear();
            l.igO = null;
        }
        aEv().clear();
        ((c) com.tencent.mm.kernel.g.n(c.class)).removeEmojiMgr();
        d aEu = aEu();
        au.DF().b(175, aEu);
        aEu.ihh.clear();
        aEu.ihf.clear();
        aEu.ihk.clear();
        j aEB = aEB();
        aEB.igf = null;
        if (aEB.igg != null) {
            aEB.igg.clear();
        }
        BKGLoaderManager bKGLoaderManager = aEx().ije;
        x.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg detach");
        if (bKGLoaderManager.ijA != null) {
            bKGLoaderManager.ijA.clear();
        }
        if (bKGLoaderManager.ijB != null) {
            bKGLoaderManager.ijB.clear();
        }
        if (bKGLoaderManager.ijC != null) {
            bKGLoaderManager.ijC.clear();
        }
        bKGLoaderManager.ijr = false;
        com.tencent.mm.sdk.b.a.sFg.c(bKGLoaderManager.ijI);
        com.tencent.mm.sdk.b.a.sFg.c(bKGLoaderManager.ijJ);
        if (bKGLoaderManager.ijE != null) {
            ad.getContext().unregisterReceiver(bKGLoaderManager.ijE);
            bKGLoaderManager.ijE = null;
        }
        if (this.ihN != null) {
            j jVar = this.ihN;
            com.tencent.mm.sdk.b.a.sFg.c(jVar.iib);
            com.tencent.mm.sdk.b.a.sFg.c(jVar.iic);
        }
        if (this.ihO != null) {
            g gVar = this.ihO;
            gVar.ihv.clear();
            aEu().ihj = null;
            gVar.ihw.dead();
        }
        if (this.ihV != null) {
            this.ihV.detach();
        }
        au.DF().b(697, aED());
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("EMOJIINFO_TABLE".hashCode()), new 1());
        cVM.put(Integer.valueOf("EMOJIGROUPINFO_TABLE".hashCode()), new 7());
        cVM.put(Integer.valueOf("EMOJIINFODESC_TABLE".hashCode()), new 8());
        cVM.put(Integer.valueOf("EMOTIONDETAIL_TABLE".hashCode()), new 9());
        cVM.put(Integer.valueOf("GETEMOTIONLISTCACHE_TABLE".hashCode()), new 10());
        cVM.put(Integer.valueOf("EmotionRewardINFO_TABLE".hashCode()), new 11());
        cVM.put(Integer.valueOf("EmotionDesignerInfoStorage_TABLE".hashCode()), new 12());
        cVM.put(Integer.valueOf("EmotionRewardTipStorage_TABLE".hashCode()), new d() {
            public final String[] xb() {
                return n.diD;
            }
        });
        cVM.put(Integer.valueOf("SmileyInfoStorage_TABLE".hashCode()), new 14());
        cVM.put(Integer.valueOf("SmileyPanelConfigInfoStorage_TABLE".hashCode()), new 2());
        cVM.put(Integer.valueOf("EmojiDescMapStorage".hashCode()), new 3());
        cVM.put(Integer.valueOf("DELETE".hashCode()), new 4());
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        x.i("MicroMsg.emoji.SubCoreEmoji", "[onAccountPostReset]");
        e.qMK = new e.b() {
            public final ChatFooterPanel da(Context context) {
                return new SmileyPanelImpl(context);
            }
        };
        e.qML = new 6(this);
        ((c) com.tencent.mm.kernel.g.n(c.class)).setEmojiMgr();
        h aEy = aEy();
        au.getSysCmdMsgExtension().a("emotionstore", aEy.ifv, true);
        au.getSysCmdMsgExtension().a("NewRecommendEmotion", aEy.ifw, true);
        au.getSysCmdMsgExtension().a("EmojiBackup", aEy.ifx, true);
        au.getSysCmdMsgExtension().a("EmotionBackup", aEy.ifx, true);
        b aEz = aEz();
        com.tencent.mm.sdk.b.a.sFg.b(aEz.ieT);
        com.tencent.mm.sdk.b.a.sFg.b(aEz.ieX);
        com.tencent.mm.sdk.b.a.sFg.b(aEz.ieY);
        com.tencent.mm.sdk.b.a.sFg.b(aEz.ieZ);
        com.tencent.mm.sdk.b.a.sFg.b(aEz.ifa);
        com.tencent.mm.sdk.b.a.sFg.b(aEz.ifb);
        com.tencent.mm.sdk.b.a.sFg.b(aEz.ifc);
        com.tencent.mm.sdk.b.a.sFg.b(aEz.ifd);
        com.tencent.mm.sdk.b.a.sFg.b(aEz.ife);
        com.tencent.mm.sdk.b.a.sFg.b(aEz.ieU);
        com.tencent.mm.sdk.b.a.sFg.b(aEz.ieV);
        com.tencent.mm.sdk.b.a.sFg.b(aEz.iff);
        com.tencent.mm.sdk.b.a.sFg.b(aEz.ifg);
        com.tencent.mm.sdk.b.a.sFg.b(aEz.ieW);
        l aEA = aEA();
        aEA.igx.c(aEA.igR);
        aEA.igy.c(aEA.igP);
        aEA.igz.c(aEA.igQ);
        com.tencent.mm.sdk.b.a.sFg.b(aEA.igS);
        aEv();
        j aEB = aEB();
        String value = com.tencent.mm.k.g.AT().getValue("EmotionRewardTipsLimit");
        if (!bi.oW(value)) {
            x.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateConfig dynamic config %s", new Object[]{value});
            String[] split = value.split(",");
            if (split != null && split.length == 3) {
                aEB.igd = bi.getInt(split[0], 0) == 0 ? 863913600000L : ((long) bi.getInt(split[0], 0)) * 86400000;
                aEB.ige = bi.getInt(split[1], 20) - 1;
                aEB.hou = bi.getInt(split[2], 80) - 1;
            }
        }
        boolean aEh = com.tencent.mm.plugin.emoji.e.n.aEh();
        au.HU();
        boolean z2 = aEh && ((Boolean) com.tencent.mm.model.c.DT().get(aa.a.sPf, Boolean.valueOf(true))).booleanValue();
        aEB.igc = z2;
        x.i("MicroMsg.emoji.EmojiRewardTipMgr", "init RewardTipMgr RewardTipEnable:%b isEnableRewardTip:%b isTipsEnable:%b", new Object[]{Boolean.valueOf(aEB.igc), Boolean.valueOf(aEh), Boolean.valueOf(r4)});
        au.Em().H(new 1(aEB));
        BKGLoaderManager bKGLoaderManager = aEx().ije;
        x.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg attach");
        com.tencent.mm.sdk.b.a.sFg.b(bKGLoaderManager.ijI);
        com.tencent.mm.sdk.b.a.sFg.b(bKGLoaderManager.ijJ);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        bKGLoaderManager.ijE = new ConnectivityReceiver(bKGLoaderManager);
        ad.getContext().registerReceiver(bKGLoaderManager.ijE, intentFilter);
        x.i("MicroMsg.emoji.SubCoreEmoji", "[oneliang]initCore");
        aEA().aEf();
        this.ihN = new j();
        this.ihO = new g();
        com.tencent.mm.ag.a.bJ(z);
        au.DF().a(697, aED());
        int cjK = f.cjI().cjK();
        int apV = com.tencent.mm.br.e.cjH().apV();
        if (cjK < 0) {
            au.HU();
            if (((Integer) com.tencent.mm.model.c.DT().get(aa.a.sPi, Integer.valueOf(0))).intValue() > 0) {
                b$c.qCd.e(37, 1, -1, false);
                au.HU();
                com.tencent.mm.model.c.DT().a(aa.a.sPi, Integer.valueOf(0));
                au.DF().a(new m(37), 0);
                com.tencent.mm.plugin.report.service.h.mEJ.a(165, 10, 1, false);
            }
        }
        if (apV < 0) {
            au.HU();
            if (((Integer) com.tencent.mm.model.c.DT().get(aa.a.sPj, Integer.valueOf(0))).intValue() > 0) {
                b$c.qCd.e(37, 2, -1, false);
                au.HU();
                com.tencent.mm.model.c.DT().a(aa.a.sPj, Integer.valueOf(0));
                au.DF().a(new m(37), 0);
                com.tencent.mm.plugin.report.service.h.mEJ.a(165, 11, 1, false);
            }
        }
    }

    public final void bo(boolean z) {
    }

    public static e aEC() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (aEt().ihP == null) {
            aEt().ihP = new e();
        }
        return aEt().ihP;
    }

    public static c aED() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (aEt().ihW == null) {
            aEt().ihW = new c();
        }
        return aEt().ihW;
    }
}
