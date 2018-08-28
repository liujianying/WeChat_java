package com.tencent.mm.ak;

import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.g.3;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.g.a.ov;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.HashMap;

public class o implements ar {
    private static HashMap<Integer, d> cVM;
    private b dWA = null;
    private p dWB = null;
    private c dWC = new c<ov>() {
        {
            this.sFo = ov.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            bd bdVar = ((ov) bVar).bZP.bGS;
            i Pd = o.Pd();
            e br = o.Pf().br(bdVar.field_msgId);
            br.hJ(0);
            o.Pf().a(Long.valueOf(br.dTK), br);
            int i = br.ON() ? 1 : 0;
            String o = o.Pf().o(br.dTL, "", "");
            if (o == null || o.equals("") || !e.cn(o)) {
                x.e("MicroMsg.ImgService", "sendMsgImage: filePath is null or empty");
            } else {
                ah.A(new i$6(Pd, br, i));
            }
            return false;
        }
    };
    private a dWD = null;
    private SFSContext dWE = null;
    private SFSContext dWF = null;
    private g dWu;
    private i dWv;
    private c dWw;
    private j dWx = new j();
    private d dWy = null;
    private h dWz = new h();

    private static synchronized o Pc() {
        o oVar;
        synchronized (o.class) {
            oVar = (o) p.v(o.class);
        }
        return oVar;
    }

    public static i Pd() {
        if (Pc().dWv == null) {
            Pc().dWv = new i();
        }
        return Pc().dWv;
    }

    public static c Pe() {
        g.Eg().Ds();
        if (Pc().dWw == null) {
            Pc().dWw = new c();
        }
        return Pc().dWw;
    }

    public static g Pf() {
        g.Eg().Ds();
        if (Pc().dWu == null) {
            Pc().dWu = new g(g.Ei().dqq);
        }
        return Pc().dWu;
    }

    public static d Pg() {
        g.Eg().Ds();
        if (Pc().dWy == null) {
            Pc().dWy = new d();
        }
        return Pc().dWy;
    }

    public static b Ph() {
        g.Eg().Ds();
        if (Pc().dWA == null) {
            Pc().dWA = new b(Looper.getMainLooper());
        }
        return Pc().dWA;
    }

    public static p Pi() {
        g.Eg().Ds();
        if (Pc().dWB == null) {
            Pc().dWB = new p();
        }
        return Pc().dWB;
    }

    public static a Pj() {
        g.Eg().Ds();
        if (Pc().dWD == null) {
            Pc().dWD = a.Pq();
        }
        return Pc().dWD;
    }

    public static SFSContext Pk() {
        return null;
    }

    public final void onAccountRelease() {
        o Pc = Pc();
        if (Pc.dWv != null) {
            i iVar = Pc.dWv;
            iVar.bFj = 0;
            g.Eh().dpP.b(110, iVar);
        }
        if (Pc.dWA != null) {
            b bVar = Pc.dWA;
            synchronized (bVar.dTg) {
                bVar.dTg.clear();
                bVar.dTh = 0;
                Pg().a(bVar);
            }
            com.tencent.mm.sdk.b.a.sFg.c(bVar.dTs);
            com.tencent.mm.sdk.b.a.sFg.c(bVar.dTt);
        }
        if (Pc.dWy != null) {
            d dVar = Pc.dWy;
            x.i("ModelImage.DownloadImgService", "on detach");
            x.i("ModelImage.DownloadImgService", "cancel all net scene");
            dVar.dTC = true;
            dVar.b(dVar.dTA);
            while (dVar.dTy.size() > 0) {
                dVar.b((d$b) dVar.dTy.get(0));
            }
            dVar.OL();
            g.Eh().dpP.b(109, dVar);
        }
        if (Pc.dWB != null) {
            p pVar = Pc.dWB;
            x.i("MicroMsg.UrlImageCacheService", "detach");
            pVar.dWH.clear();
            pVar.dWJ = true;
        }
        Pl();
        com.tencent.mm.ab.d.c.b(Integer.valueOf(3), this.dWz);
        com.tencent.mm.ab.d.c.b(Integer.valueOf(23), this.dWz);
        com.tencent.mm.cache.e.a.a("local_cdn_img_cache", null);
        com.tencent.mm.sdk.b.a.sFg.c(this.dWC);
        if (Pc.dWD != null) {
            Pc.dWD.detach();
            Pc.dWD = null;
        }
        if (Pc.dWE != null) {
            Pc.dWE.release();
            Pc.dWE = null;
        }
        if (Pc.dWF != null) {
            Pc.dWF.release();
            Pc.dWF = null;
        }
    }

    public static void Pl() {
        g gVar = Pc().dWu;
        if (gVar != null) {
            x.i("MicroMsg.ImgInfoStorage", "clearCacheMap stack:%s", new Object[]{bi.cjd()});
            gVar.dUr.a(new 3(gVar));
        }
        a aVar = Pc().dWD;
        if (aVar != null) {
            aVar.detach();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("IMGINFO_TABLE".hashCode()), new 2());
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        com.tencent.mm.ab.d.c.a(Integer.valueOf(3), this.dWz);
        com.tencent.mm.ab.d.c.a(Integer.valueOf(23), this.dWz);
        com.tencent.mm.cache.e.a.a("local_cdn_img_cache", this.dWx);
        com.tencent.mm.sdk.b.a.sFg.b(this.dWC);
    }

    public final void bo(boolean z) {
    }
}
