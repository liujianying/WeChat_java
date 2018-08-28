package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.aa.q;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.g.a.kx;
import com.tencent.mm.g.a.ty;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.webview.fts.h;
import com.tencent.mm.plugin.webview.fts.i;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.ad;
import com.tencent.mm.plugin.webview.model.ae;
import com.tencent.mm.plugin.webview.model.ag;
import com.tencent.mm.plugin.webview.model.am;
import com.tencent.mm.plugin.webview.modelcache.k;
import com.tencent.mm.protocal.c.cfk;
import com.tencent.mm.protocal.c.iv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

public final class e implements ar {
    private static final HashMap<Integer, d> cVM;
    private a hdi = new 15(this);
    private n jkm = new 9(this);
    private c<bc> jul = new 7(this);
    private ad pTR;
    private ae pTS;
    private ac pTT;
    private h pTU;
    private com.tencent.mm.plugin.webview.model.e pTV;
    private ag pTW;
    private com.tencent.mm.plugin.webview.b.e pTX;
    private i pTY;
    private com.tencent.mm.plugin.webview.fts.c pTZ;
    private com.tencent.mm.plugin.webview.fts.d pUa;
    private com.tencent.mm.plugin.webview.c.a pUb;
    private final com.tencent.mm.plugin.webview.modelcache.n pUc = new com.tencent.mm.plugin.webview.modelcache.n();
    c pUd = new 16(this);
    final c<ty> pUe = new c<ty>() {
        {
            this.sFo = ty.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            am.pSK = ((ty) bVar).cfE.cfF.substring(11);
            return true;
        }
    };
    c pUf = new 2(this);
    c pUg = new 3(this);
    c pUh = new 4(this);
    c pUi = new 5(this);
    c pUj = new 6(this);
    private c pUk = new c<kx>() {
        {
            this.sFo = kx.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            kx kxVar = (kx) bVar;
            if (kxVar.bVh.scene == 0) {
                e.bUV().pPq = 0;
                e.bUV().pLd = null;
            } else {
                e.bUV().pPq = 1;
                e.bUV().pLd = new cfk();
                e.bUV().pLd.szS = 1;
                e.bUV().pLd.szT = new iv();
                e.bUV().pLd.szT.bPS = kxVar.bVh.appId;
                e.bUV().pLd.szT.rka = kxVar.bVh.type;
                e.bUV().pLd.szT.rkb = kxVar.bVh.version;
                e.bUV().pLd.szT.rkc = kxVar.bVh.bVj;
            }
            return false;
        }
    };

    public static e bUR() {
        au.HN();
        e eVar = (e) bs.iK("plugin.webview");
        if (eVar != null) {
            return eVar;
        }
        eVar = new e();
        x.e("MicroMsg.SubCoreTools", "new SubCoreTools add to subCore:%d", new Object[]{Integer.valueOf(eVar.hashCode())});
        au.HN().a("plugin.webview", eVar);
        return eVar;
    }

    public static com.tencent.mm.plugin.webview.c.a bUS() {
        if (bUR().pUb == null) {
            bUR().pUb = new com.tencent.mm.plugin.webview.c.a();
        }
        return bUR().pUb;
    }

    public static com.tencent.mm.plugin.webview.fts.c bUT() {
        if (bUR().pTZ == null) {
            bUR().pTZ = new com.tencent.mm.plugin.webview.fts.c();
        }
        return bUR().pTZ;
    }

    public static com.tencent.mm.plugin.webview.fts.d bUU() {
        if (bUR().pUa == null) {
            bUR().pUa = new com.tencent.mm.plugin.webview.fts.d();
        }
        return bUR().pUa;
    }

    public static i bUV() {
        if (bUR().pTY == null) {
            bUR().pTY = new i();
        }
        return bUR().pTY;
    }

    public static ad bUW() {
        if (bUR().pTR == null) {
            bUR().pTR = new ad();
        }
        return bUR().pTR;
    }

    public static ae bUX() {
        if (bUR().pTS == null) {
            bUR().pTS = ae.bUk();
        }
        return bUR().pTS;
    }

    public static h bUY() {
        if (bUR().pTU == null) {
            e bUR = bUR();
            au.HU();
            bUR.pTU = new h(com.tencent.mm.model.c.FO());
        }
        return bUR().pTU;
    }

    public static com.tencent.mm.plugin.webview.model.e bUZ() {
        if (bUR().pTV == null) {
            e bUR = bUR();
            au.HU();
            bUR.pTV = new com.tencent.mm.plugin.webview.model.e(com.tencent.mm.model.c.FO());
        }
        return bUR().pTV;
    }

    public static ag bVa() {
        if (bUR().pTW == null) {
            e bUR = bUR();
            au.HU();
            bUR.pTW = new ag(com.tencent.mm.model.c.FO());
        }
        return bUR().pTW;
    }

    public static com.tencent.mm.plugin.webview.b.e bVb() {
        if (bUR().pTX == null) {
            e bUR = bUR();
            g.Ek();
            bUR.pTX = new com.tencent.mm.plugin.webview.b.e(g.Ei().dqq);
        }
        return bUR().pTX;
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.SubCoreTools", "onAccountRelease hc:%d", new Object[]{Integer.valueOf(hashCode())});
        com.tencent.mm.sdk.b.a.sFg.c(this.pUf);
        com.tencent.mm.sdk.b.a.sFg.c(this.pUh);
        com.tencent.mm.sdk.b.a.sFg.c(this.pUi);
        com.tencent.mm.sdk.b.a.sFg.c(this.pUj);
        com.tencent.mm.sdk.b.a.sFg.c(this.pUd);
        com.tencent.mm.sdk.b.a.sFg.c(this.pUk);
        com.tencent.mm.sdk.b.a.sFg.c(this.jul);
        com.tencent.mm.sdk.b.a.sFg.c(this.pUg);
        au.b(this.jkm);
        if (this.pTT != null) {
            ac acVar = this.pTT;
            if (acVar.pRI != null) {
                com.tencent.mm.plugin.downloader.model.d.aCU();
                com.tencent.mm.plugin.downloader.model.b.b(acVar.pRI);
            }
            if (acVar.pRJ != null && acVar.pRJ.size() > 0) {
                for (Long l : acVar.pRJ) {
                    x.i("MicroMsg.WebViewAutoDownloader", "remove download task : %d", new Object[]{l});
                    com.tencent.mm.plugin.downloader.model.d.aCU().cl(l.longValue());
                }
            }
        }
        if (this.pUa != null) {
            com.tencent.mm.plugin.webview.fts.d dVar = this.pUa;
            com.tencent.mm.sdk.b.a.sFg.c(dVar.fIu);
            if (dVar.pOz != null) {
                au.DF().b(1048, dVar);
                au.DF().c(dVar.pOz);
                dVar.pOz = null;
            }
            this.pUa = null;
        }
        if (this.pTY != null) {
            i iVar = this.pTY;
            iVar.pPi.dead();
            iVar.pPt.dead();
            i.a aVar = iVar.pPv;
            if (aVar.pPn != null) {
                au.DF().c(aVar.pPn);
            }
            if (aVar.pPB != null) {
                aVar.pPB.gYf = true;
            }
            i.b bVar = iVar.pPw;
            if (bVar.pPD != null) {
                au.DF().b(bVar.pPD.getType(), bVar.pPx);
            }
            if (iVar.jsw != null) {
                ((com.tencent.mm.plugin.fts.a.n) g.n(com.tencent.mm.plugin.fts.a.n.class)).cancelSearchTask(iVar.jsw);
                iVar.jsw = null;
            }
            this.pTY = null;
        }
        if (this.pTZ != null) {
            com.tencent.mm.plugin.webview.fts.c cVar = this.pTZ;
            cVar.nll.dead();
            cVar.pOt.dead();
            q.KH().d(cVar);
            this.pTZ = null;
        }
        au.getSysCmdMsgExtension().b("hijackconfig", this.hdi, true);
        if (this.pTV != null) {
            this.pTV.bTV();
        }
        com.tencent.mm.plugin.webview.modelcache.n nVar = this.pUc;
        au.getSysCmdMsgExtension().b("webcache", nVar.pTc, true);
        com.tencent.mm.sdk.b.a.sFg.c(nVar.pTd);
        com.tencent.mm.sdk.b.a.sFg.c(nVar.pTe);
        com.tencent.mm.plugin.webview.modelcache.q bUL = com.tencent.mm.plugin.webview.modelcache.q.a.bUL();
        com.tencent.mm.sdk.b.a.sFg.c(bUL.pTk);
        com.tencent.mm.sdk.b.a.sFg.c(bUL.pTl);
        bUL.release(true);
        this.pUe.dead();
        h bTK = h.bTK();
        h.a aVar2 = bTK.pPb;
        if (aVar2.pPn != null) {
            au.DF().c(aVar2.pPn);
        }
        if (aVar2.pPo != null) {
            aVar2.pPo.gYf = true;
        }
        bTK.pPi.dead();
        g.m(com.tencent.mm.plugin.webview.d.a.class);
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("WebViewHostsFilterTable".hashCode()), new 1());
        List<com.tencent.mm.plugin.webview.modelcache.d.a> linkedList = new LinkedList();
        linkedList.add(com.tencent.mm.plugin.webview.modelcache.a.bUD());
        linkedList.addAll(k.bUH());
        linkedList.add(com.tencent.mm.plugin.webview.modelcache.h.bUD());
        for (com.tencent.mm.plugin.webview.modelcache.d.a aVar : linkedList) {
            cVM.put(Integer.valueOf(aVar.id), aVar);
        }
        cVM.put(Integer.valueOf("WEBVIEW_JSLOG_BLOCK_LIST_TABLE".hashCode()), new 10());
        cVM.put(Integer.valueOf("WEBVIEW_LOCAL_DATA".hashCode()), new 11());
        cVM.put(Integer.valueOf("WEBVIEW_DATA".hashCode()), new 12());
        cVM.put(Integer.valueOf("WEBVIEW_HISTORY_DATA".hashCode()), new 13());
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        x.i("MicroMsg.SubCoreTools", "onAccountPostReset hc:%d", new Object[]{Integer.valueOf(hashCode())});
        au.HN();
        if (((e) bs.iK("plugin.webview")) == null) {
            au.HN().a("plugin.webview", new e());
            x.e("MicroMsg.SubCoreTools", "getCore, should not be here:%d", new Object[]{Integer.valueOf(r0.hashCode())});
        }
        com.tencent.mm.sdk.b.a.sFg.b(this.pUf);
        com.tencent.mm.sdk.b.a.sFg.b(this.pUh);
        com.tencent.mm.sdk.b.a.sFg.b(this.pUi);
        com.tencent.mm.sdk.b.a.sFg.b(this.pUj);
        com.tencent.mm.sdk.b.a.sFg.b(this.pUd);
        com.tencent.mm.sdk.b.a.sFg.b(this.pUk);
        com.tencent.mm.sdk.b.a.sFg.b(this.jul);
        com.tencent.mm.sdk.b.a.sFg.b(this.pUg);
        au.getSysCmdMsgExtension().a("hijackconfig", this.hdi, true);
        au.a(this.jkm);
        com.tencent.mm.plugin.webview.modelcache.n nVar = this.pUc;
        com.tencent.mm.plugin.webview.modelcache.n.bUJ();
        com.tencent.mm.plugin.webview.modelcache.q bUL = com.tencent.mm.plugin.webview.modelcache.q.a.bUL();
        com.tencent.mm.sdk.b.a.sFg.b(bUL.pTk);
        com.tencent.mm.sdk.b.a.sFg.b(bUL.pTl);
        au.getSysCmdMsgExtension().a("webcache", nVar.pTc, true);
        com.tencent.mm.sdk.b.a.sFg.b(nVar.pTd);
        com.tencent.mm.sdk.b.a.sFg.b(nVar.pTe);
        com.tencent.mm.plugin.ah.c.nbP.a(new am());
        this.pUe.cht();
        com.tencent.mm.y.g.b.a(new 14(this));
        XWalkEnvironment.init(com.tencent.mm.sdk.platformtools.ad.getContext());
        g.Eg();
        XWalkEnvironment.setGrayValueByUserId(com.tencent.mm.kernel.a.Df());
        h.bTK();
        h.start();
        g.a(com.tencent.mm.plugin.webview.d.a.class, new com.tencent.mm.plugin.webview.ui.tools.bag.k());
    }

    public final void bo(boolean z) {
        com.tencent.mm.plugin.webview.modelcache.n.bUJ();
    }
}
