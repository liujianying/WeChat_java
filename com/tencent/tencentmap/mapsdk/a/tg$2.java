package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;

class tg$2 implements Runnable {
    private /* synthetic */ ArrayList a;
    private /* synthetic */ tg b;

    tg$2(tg tgVar, ArrayList arrayList) {
        this.b = tgVar;
        this.a = arrayList;
    }

    public final void run() {
        tg.a(this.b).clear();
        synchronized (tg.b(this.b)) {
            tg.b(this.b).clear();
            tg.b(this.b).putAll(tg.c(this.b));
        }
        for (int i = 0; i < this.a.size(); i++) {
            for (td tdVar : ((tc) this.a.get(i)).b()) {
                tf a;
                try {
                    a = te.a().a(tdVar);
                } catch (Throwable th) {
                    if (tz.n() != null) {
                        tz.n().a("TileEngineManager getTiles Runnable call CacheManager Get occured Exception,tileInfo:x=" + tdVar.b() + ",y=" + tdVar.c() + ",z=" + tdVar.d() + "Exception Info:" + th.toString());
                    }
                    a = null;
                }
                if (a.b() != null && a.d() == tdVar.l()) {
                    tdVar.a(a.b());
                    if (tdVar.m() == tc$a.TENCENT && !tg.d(this.b).r()) {
                        sl.a++;
                    }
                    if (tdVar.m() == tc$a.WORLD) {
                        sl.b++;
                    }
                } else if (a.b() != null && a.d() != tdVar.l() && tdVar.m() == tc$a.TENCENT) {
                    new StringBuilder("Have got cache,but version is not ok,tileBitmap.getVersion：").append(a.d()).append(",tileData.getVersion:").append(tdVar.l());
                    tg.a(this.b, tdVar, true, a);
                } else if (a.b() == null) {
                    tg.a(this.b, tdVar, false, null);
                    if (tdVar.m() == tc$a.TENCENT && !tg.d(this.b).r()) {
                        tg.d(this.b);
                        sl.c++;
                    }
                    if (tdVar.m() == tc$a.WORLD) {
                        tg.d(this.b);
                        sl.d++;
                    }
                }
            }
            tg.d(this.b).c().postInvalidate();
        }
    }
}
