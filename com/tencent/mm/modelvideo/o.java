package com.tencent.mm.modelvideo;

import com.tencent.mm.ab.d.c;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.b;
import com.tencent.mm.model.p;
import com.tencent.mm.modelcdntran.f;
import com.tencent.mm.modelvideo.x.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.HashMap;

public class o implements ar {
    private static HashMap<Integer, d> cVM;
    private static ah enA = null;
    private static ag enB = null;
    private f enC = null;
    private i enD = null;
    private volatile u ent = new u();
    private volatile s enu;
    private volatile w env;
    private volatile a enw = null;
    private volatile l enx = null;
    private volatile k eny = null;
    private volatile m enz = null;

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("VIDEOINFO_TABLE".hashCode()), new 1());
        cVM.put(Integer.valueOf("VIDEOPLAYHISTORY_TABLE".hashCode()), new d() {
            public final String[] xb() {
                return w.diD;
            }
        });
        cVM.put(Integer.valueOf("SIGHTDRAFTSINFO_TABLE".hashCode()), new d() {
            public final String[] xb() {
                return l.diD;
            }
        });
    }

    public static o SZ() {
        return (o) p.v(o.class);
    }

    public static s Ta() {
        if (g.Eg().Dx()) {
            if (SZ().enu == null) {
                SZ().enu = new s(g.Ei().dqq);
            }
            return SZ().enu;
        }
        throw new b();
    }

    public static f Tb() {
        g.Eg().Ds();
        if (SZ().enC == null) {
            SZ().enC = new f();
        }
        if ((com.tencent.mm.modelcdntran.g.NE().dOO == null ? 1 : null) != null) {
            com.tencent.mm.modelcdntran.g.NE().dOO = SZ().enC;
        }
        return SZ().enC;
    }

    public static i Tc() {
        g.Eg().Ds();
        if (SZ().enD == null) {
            SZ().enD = new i();
        }
        return SZ().enD;
    }

    public static w Td() {
        if (g.Eg().Dx()) {
            if (SZ().env == null) {
                SZ().env = new w(g.Ei().dqq);
            }
            return SZ().env;
        }
        throw new b();
    }

    public static synchronized l Te() {
        l lVar;
        synchronized (o.class) {
            if (g.Eg().Dx()) {
                if (SZ().enx == null) {
                    SZ().enx = new l(g.Ei().dqq);
                }
                lVar = SZ().enx;
            } else {
                throw new b();
            }
        }
        return lVar;
    }

    public static a Tf() {
        if (g.Eg().Dx()) {
            if (SZ().enw == null) {
                SZ().enw = new a();
            }
            return SZ().enw;
        }
        throw new b();
    }

    public static m Tg() {
        if (g.Eg().Dx()) {
            if (SZ().enz == null) {
                SZ().enz = new m();
            }
            return SZ().enz;
        }
        throw new b();
    }

    private static void Th() {
        boolean z = false;
        if (enB == null || enA == null) {
            String str = "MicroMsg.SubCoreVideo";
            String str2 = "check decoder thread available fail, handler[%B] thread[%B] stack[%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(enB != null);
            if (enA != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = bi.cjd();
            x.w(str, str2, objArr);
            if (enB != null) {
                enB.removeCallbacksAndMessages(null);
            }
            if (enA != null) {
                enA.a(null);
            } else {
                enA = new ah("Short-Video-Decoder-Thread-" + System.currentTimeMillis());
            }
            enB = new ag(enA.lnJ.getLooper());
        }
    }

    public static boolean d(Runnable runnable, long j) {
        if (runnable == null) {
            return false;
        }
        Th();
        if (j > 0) {
            enB.postDelayed(runnable, j);
        } else {
            enB.post(runnable);
        }
        return true;
    }

    public static boolean l(Runnable runnable) {
        if (runnable == null) {
            return true;
        }
        Th();
        if (enB == null) {
            x.e("MicroMsg.SubCoreVideo", "short video decoder handler is null");
            return false;
        }
        enB.removeCallbacks(runnable);
        return true;
    }

    public final void onAccountRelease() {
        a aVar;
        x.i("MicroMsg.SubCoreVideo", "%d onAccountRelease ", new Object[]{Integer.valueOf(hashCode())});
        try {
            if (SZ().enw != null) {
                aVar = SZ().enw;
                aVar.bFj = 0;
                if (aVar.eox != null) {
                    g.DF().c(aVar.eox);
                }
                if (aVar.eoy != null) {
                    g.DF().c(aVar.eoy);
                }
                g.DF().b(149, aVar);
                g.DF().b(150, aVar);
            }
            if (SZ().enz != null) {
                m mVar = SZ().enz;
                mVar.bFj = 0;
                x.i("MicroMsg.SightMassSendService", "stop, cur cdn client id %s", new Object[]{mVar.emW});
                if (!bi.oW(mVar.emW)) {
                    com.tencent.mm.modelcdntran.g.ND().lw(mVar.emW);
                }
            }
            if (SZ().enD != null) {
                i iVar = SZ().enD;
                iVar.stopDownload();
                iVar.emG.clear();
            }
            if (SZ().enC != null) {
                g.DF().b(379, SZ().enC);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SubCoreVideo", e, "", new Object[0]);
        }
        c.b(Integer.valueOf(43), this.ent);
        c.b(Integer.valueOf(44), this.ent);
        c.b(Integer.valueOf(62), this.ent);
        if (enB != null) {
            enB.removeCallbacksAndMessages(null);
        }
        try {
            aVar = Tf();
            x.i("MicroMsg.VideoService", "quitVideoSendThread: %s", new Object[]{aVar.eor});
            if (aVar.eor != null) {
                try {
                    aVar.eor.quit();
                    aVar.eot = false;
                    aVar.eos = null;
                    aVar.eor = null;
                } catch (Exception e2) {
                    x.e("MicroMsg.VideoService", "quitVideoSendThread error: %s", new Object[]{e2.getMessage()});
                }
            }
        } catch (Exception e22) {
            x.e("MicroMsg.SubCoreVideo", "onAccountRelease, quitVideoSendThread error: %s", new Object[]{e22.getMessage()});
        }
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        x.i("MicroMsg.SubCoreVideo", "%d onAccountPostReset ", new Object[]{Integer.valueOf(hashCode())});
        c.a(Integer.valueOf(43), this.ent);
        c.a(Integer.valueOf(44), this.ent);
        c.a(Integer.valueOf(62), this.ent);
        if (enB != null) {
            enB.removeCallbacksAndMessages(null);
        }
        g.Em().H(new 4(this));
        File file = new File(k.SU());
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
    }

    public static String getAccVideoPath() {
        StringBuilder stringBuilder = new StringBuilder();
        g.Ek();
        return stringBuilder.append(g.Ei().dqp).append("video/").toString();
    }

    public final void bo(boolean z) {
    }
}
