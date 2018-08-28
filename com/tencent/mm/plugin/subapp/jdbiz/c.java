package com.tencent.mm.plugin.subapp.jdbiz;

import android.os.Looper;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.f.f;
import com.tencent.mm.pluginsdk.f.f.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public class c implements ar, b {
    private com.tencent.mm.sdk.b.c cXu = new 1(this);
    private a oqU = null;
    private b oqV = null;
    Map<String, Integer> oqW = new HashMap();

    public c() {
        x.i("MicroMsg.SubCoreJdIP6", "new SubCoreJDBiz this: " + hashCode() + " stack: " + bi.cjd());
    }

    public static c bGg() {
        c cVar = (c) f.qBo;
        if (cVar != null) {
            return cVar;
        }
        cVar = new c();
        f.qBo = cVar;
        return cVar;
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        x.i("MicroMsg.SubCoreJdIP6", "onAccountPostReset");
        if (this.oqU == null) {
            this.oqU = new a();
        }
        au.getSysCmdMsgExtension().a("jd", this.oqU, true);
        a.sFg.b(this.cXu);
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.SubCoreJdIP6", "onAccountRelease");
        if (this.oqU != null) {
            a.sFg.c(this.oqU.oqD);
            au.getSysCmdMsgExtension().b("jd", this.oqU, true);
        }
        this.oqW.clear();
        this.oqU = null;
        a.sFg.c(this.cXu);
    }

    public final boolean bGh() {
        au.HU();
        return "1".equals((String) com.tencent.mm.model.c.DT().get(327939, ""));
    }

    public final boolean bGi() {
        au.HU();
        return "1".equals((String) com.tencent.mm.model.c.DT().get(327938, ""));
    }

    public final void bGj() {
        au.HU();
        com.tencent.mm.model.c.DT().set(327938, "");
    }

    public final void bGk() {
        au.HU();
        com.tencent.mm.model.c.DT().set(327939, "");
    }

    /* renamed from: bGl */
    public final b bGq() {
        if (this.oqV == null) {
            this.oqV = b.bFY();
        }
        return this.oqV;
    }

    public static void b(b bVar) {
        g.Eg().Ds();
        c bGg = bGg();
        if (bGg.oqV == null) {
            bGg.oqV = b.bFY();
        }
        x.i("MicroMsg.SubCoreJdIP6", "updatejdMsgContent old: %s new: %s", new Object[]{bGg.oqV.bGa(), bVar.bGa()});
        if (bVar.a(bGg.oqV)) {
            if (!bi.oW(bVar.oqK) || bVar.oqJ) {
                au.HU();
                com.tencent.mm.model.c.DT().set(327939, "1");
            }
            if (bVar.oqI) {
                au.HU();
                com.tencent.mm.model.c.DT().set(327938, "1");
            } else {
                au.HU();
                com.tencent.mm.model.c.DT().set(327938, "");
            }
            bGg.oqV = bVar;
            au.HU();
            com.tencent.mm.model.c.DT().set(327942, bVar.bWW);
            bGg.bGm();
            return;
        }
        x.i("MicroMsg.SubCoreJdIP6", "fo zu baoyou! the activityid is same");
    }

    private void bGm() {
        new ag(Looper.getMainLooper()).post(new 2(this));
    }

    public final void bGn() {
        if (!au.HX()) {
            return;
        }
        if (bGg().bGh() || bGg().bGi()) {
            b bGl = bGg().bGq();
            if ((!bi.oW(bGl.oqK) || bGl.oqJ) && bGl.bFZ()) {
                x.i("MicroMsg.SubCoreJdIP6", "clear red dot/friend dot");
                bGg().bGj();
                bGg().bGk();
                bGg().bGm();
            }
        }
    }

    public static String cl(String str, int i) {
        if (-1 != str.indexOf(35)) {
            return str;
        }
        if (-1 == str.indexOf(63)) {
            return str + "?wc_scene=" + i;
        }
        return str + "&wc_scene=" + i;
    }

    public static boolean bGo() {
        return (bi.oW(com.tencent.mm.k.g.AT().getValue("JDEntranceConfigName")) || bi.oW(com.tencent.mm.k.g.AT().getValue("JDEntranceConfigIconUrl")) || bi.oW(com.tencent.mm.k.g.AT().getValue("JDEntranceConfigJumpUrl"))) ? false : true;
    }

    public final String bGp() {
        int i = 1;
        String value = com.tencent.mm.k.g.AT().getValue("JDEntranceConfigJumpUrl");
        if (bi.oW(value)) {
            return null;
        }
        int i2;
        int i3;
        b bGl = bGq();
        if (bGh()) {
            if (!bGl.bFZ() && "3".equals(bGl.oqG) && !bi.oW(bGl.jumpUrl)) {
                x.i("MicroMsg.SubCoreJdIP6", "jumpUrl update %s", new Object[]{bGl.jumpUrl});
                value = bGl.jumpUrl;
                i2 = 6;
                if (bGl.oqM < System.currentTimeMillis() / 1000) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                if (i3 != 0) {
                    if (bGl.oqN == 0 || bGl.oqN >= System.currentTimeMillis() / 1000) {
                        i = 0;
                    }
                    if (i == 0) {
                        value = bGl.jumpUrl;
                        i2 = 3;
                    }
                }
                return cl(value, i2);
            } else if (bGl.oqJ) {
                i2 = 2;
                if ("2".equals(bGl.oqG) && !bi.oW(bGl.jumpUrl)) {
                    if (bGl.oqM < System.currentTimeMillis() / 1000) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    if (i3 != 0) {
                        if (bGl.oqN == 0 || bGl.oqN >= System.currentTimeMillis() / 1000) {
                            i = 0;
                        }
                        if (i == 0) {
                            value = bGl.jumpUrl;
                            i2 = 3;
                        }
                    }
                }
                return cl(value, i2);
            }
        }
        i2 = 1;
        if (bGl.oqM < System.currentTimeMillis() / 1000) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            if (bGl.oqN == 0 || bGl.oqN >= System.currentTimeMillis() / 1000) {
                i = 0;
            }
            if (i == 0) {
                value = bGl.jumpUrl;
                i2 = 3;
            }
        }
        return cl(value, i2);
    }
}
