package com.tencent.mm.plugin.appbrand.appcache;

import android.os.StatFs;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.e.w;
import com.tencent.mm.pluginsdk.g.a.c.f.b;
import com.tencent.mm.pluginsdk.g.a.c.j;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.pluginsdk.g.a.c.n.a;
import java.io.File;

final class ah$c extends a<com.tencent.mm.plugin.appbrand.appcache.base.a> {
    private static final ThreadLocal<ah.a> fhp = new 1();
    String fhq = null;
    final s.a fhr;

    protected final /* bridge */ /* synthetic */ b ach() {
        return (com.tencent.mm.plugin.appbrand.appcache.base.a) super.ach();
    }

    ah$c(com.tencent.mm.plugin.appbrand.appcache.base.a aVar) {
        super(aVar);
        s.a a = s.a(aVar);
        if (a == null) {
            a = g.ffx;
        }
        this.fhr = a;
    }

    protected final com.tencent.mm.plugin.appbrand.appcache.base.a abZ() {
        return (com.tencent.mm.plugin.appbrand.appcache.base.a) super.ach();
    }

    public final String getURL() {
        return this.fhq;
    }

    protected final m a(j jVar) {
        m a;
        com.tencent.mm.plugin.appbrand.appcache.base.a aVar = (com.tencent.mm.plugin.appbrand.appcache.base.a) super.ach();
        e.deleteFile(aVar.getFilePath());
        this.fhq = aVar.url;
        s.a aVar2 = this.fhr;
        this.fhq.startsWith("https");
        aVar2.abs();
        m a2 = ((ah.a) fhp.get()).a(this);
        Object obj = ((a2 == null || a2.status == 3) && this.fhq.startsWith("http://")) ? 1 : null;
        if ((a2 == null || a2.status == 3) && this.fhq.startsWith("https")) {
            Object obj2;
            this.fhr.abu();
            if (aVar instanceof ad) {
                obj2 = null;
            } else {
                int obj22 = 1;
            }
            if (obj22 != null) {
                this.fhq = this.fhq.replaceFirst("https", "http");
                a = super.a(jVar);
            }
            a = a2;
        } else {
            if (a2 == null || obj != null) {
                a = super.a(jVar);
            }
            a = a2;
        }
        this.fhr.a(a);
        if (a == null) {
            return new m(this, null, -1, 3);
        }
        return a;
    }

    public final boolean bM(long j) {
        StatFs statFs = new StatFs(new File(getFilePath()).getParentFile().getAbsolutePath());
        long availableBlocks = (long) (statFs.getAvailableBlocks() * statFs.getBlockSize());
        return availableBlocks < 0 || availableBlocks > j;
    }

    public final String aca() {
        return "AppBrandWxaPkgDownloader";
    }

    public final boolean acb() {
        return true;
    }

    public final boolean acc() {
        return false;
    }

    public final boolean acd() {
        return true;
    }

    protected final boolean ace() {
        return false;
    }

    public final boolean acf() {
        return true;
    }

    public final boolean acg() {
        switch (w.zQ()) {
            case 1:
                return super.acg();
            default:
                return false;
        }
    }
}
