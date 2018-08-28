package com.tencent.mm.aa;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.ab.e;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.Builder;
import com.tencent.mm.plugin.p.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public class q implements ar {
    private static HashMap<Integer, d> cVM;
    private k dIl;
    private f dIm;
    private e dIn;
    private i dIo;
    private String dIp;
    private al dIq = new al(g.Em().lnJ.getLooper(), new a() {
        public final boolean vD() {
            if (!g.Eg().Dx() || q.Kp() == null) {
                x.w("MicroMsg.SubCoreAvatar", "upAssetsHandler onTimerExpired acc:%b astg:%s ", Boolean.valueOf(g.Eg().Dx()), q.Kp());
            } else {
                if (((Boolean) g.Ei().DT().get(90113, Boolean.valueOf(false))).booleanValue()) {
                    q.KL();
                    q.KK();
                }
                g.Ei().DT().set(90113, Boolean.valueOf(false));
            }
            return false;
        }

        public final String toString() {
            return super.toString() + "|upAssetsHandler";
        }
    }, false);

    static /* synthetic */ void KL() {
        try {
            Context context = ad.getContext();
            for (String str : f.dHm.keySet()) {
                int intValue = f.dHm.containsKey(str) ? ((Integer) f.dHm.get(str)).intValue() : 0;
                if (intValue != 0) {
                    x.d("MicroMsg.SubCoreAvatar", "updateAssetsAvatar user:%s ", str);
                    Kp().f(str, com.tencent.mm.compatible.g.a.decodeResource(context.getResources(), intValue));
                }
            }
        } catch (Throwable e) {
            x.e("MicroMsg.SubCoreAvatar", "exception:%s", bi.i(e));
        }
    }

    public static q KG() {
        return (q) p.v(q.class);
    }

    public static k KH() {
        g.Eg().Ds();
        if (KG().dIl == null) {
            KG().dIl = new k(g.Ei().dqq);
        }
        return KG().dIl;
    }

    public static f Kp() {
        g.Eg().Ds();
        if (KG().dIm == null) {
            KG().dIm = new f();
        }
        return KG().dIm;
    }

    public static i KI() {
        g.Eg().Ds();
        if (KG().dIo == null) {
            KG().dIo = new i(g.Ei().dqq);
        }
        return KG().dIo;
    }

    public static e KJ() {
        g.Eg().Ds();
        if (KG().dIn == null) {
            KG().dIn = new e();
        }
        return KG().dIn;
    }

    public final void onAccountRelease() {
        this.dIq.SO();
        f fVar = KG().dIm;
        if (fVar != null) {
            f.reset();
            fVar.dHl.removeAllListeners();
        }
        e eVar = KG().dIn;
        if (eVar != null) {
            g.DF().b(123, eVar);
        }
        k kVar = KG().dIl;
        if (kVar != null) {
            kVar.dHU.clear();
        }
        if (this.dIp != null) {
            FileOp.mC(this.dIp);
            this.dIp = null;
        }
    }

    public final void gi(int i) {
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("IMG_FLAG_TABLE".hashCode()), new d() {
            public final String[] xb() {
                return k.diD;
            }
        });
        cVM.put(Integer.valueOf("HDHEADIMGINFO_TABLE".hashCode()), new d() {
            public final String[] xb() {
                return i.diD;
            }
        });
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void bn(boolean z) {
        FileOp.mL(g.Ei().dqp + "sfs");
        this.dIp = com.tencent.mm.plugin.g.a.aqI();
        FileOp.a(this.dIp, new Builder().setDBDirectory(g.Ei().cachePath + "sfs").setStoragePath(c.aWD()).setName("avatar"));
        Kp().Kt();
        if (z) {
            x.d("MicroMsg.SubCoreAvatar", "update all plugin avatars");
            g.Ei().DT().set(90113, Boolean.valueOf(true));
            try {
                String GF = com.tencent.mm.model.q.GF();
                f Kp = Kp();
                Kp.Kt();
                f.B(GF, false);
                f.B(GF, true);
                Kp.e(GF, null);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SubCoreAvatar", e, "Failed to refresh avatar.", new Object[0]);
            }
        }
        this.dIq.J(10000, 10000);
    }

    static Context getContext() {
        return ad.getContext();
    }

    public final void bo(boolean z) {
        if (this.dIp != null) {
            FileOp.mC(this.dIp);
            this.dIp = com.tencent.mm.plugin.g.a.aqI();
            FileOp.a(this.dIp, new Builder().setDBDirectory(g.Ei().cachePath + "sfs").setStoragePath(c.aWD()).setName("avatar"));
        }
    }

    public static boolean KK() {
        if (bi.a((Boolean) g.Ei().DT().get(59, null), false)) {
            return true;
        }
        boolean z;
        String c = Kp().c(com.tencent.mm.model.q.GF(), false, false);
        if (FileOp.cn(c) || FileOp.cn(c + ".bm")) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        c = com.tencent.mm.model.q.GF();
        if (bi.oW(c)) {
            return false;
        }
        Bitmap jZ = f.d.jZ(c.Gb() + "user_" + com.tencent.mm.a.g.u(c.getBytes()) + ".png");
        if (jZ == null || jZ.isRecycled()) {
            return false;
        }
        return Kp().f(c, jZ);
    }
}
