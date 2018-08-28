package com.tencent.mm.plugin.appbrand.i;

import com.tencent.mm.a.e;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.i.a.d;
import com.tencent.mm.plugin.appbrand.launching.RuntimeLoadModuleTask.1;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b implements a {
    final g fdD;
    private final Set<String> gkm = new HashSet();
    final com.tencent.mm.plugin.appbrand.q.g<String, a> gkn = new com.tencent.mm.plugin.appbrand.q.g();
    private final Map<String, Boolean> gko = new HashMap();

    private static class a {
        com.tencent.mm.plugin.appbrand.i.a.b gkx;
        a$a gky;

        public a(com.tencent.mm.plugin.appbrand.i.a.b bVar, a$a a_a) {
            this.gkx = bVar;
            this.gky = a_a;
        }
    }

    static /* synthetic */ void a(b bVar, String str, d dVar) {
        synchronized (bVar.gkm) {
            bVar.gkm.remove(str);
        }
        Set<a> bp = bVar.gkn.bp(str);
        if (bp == null) {
            x.e("MicroMsg.AppBrand.RuntimeModularizingHelper", "markLoadingFinished %s, result %s, get null callbackSet, maybe canceled by user before", new Object[]{str, dVar.name()});
            return;
        }
        for (a aVar : bp) {
            if (aVar.gkx != null) {
                aVar.gkx.a(dVar);
            }
        }
    }

    public b(g gVar) {
        this.fdD = gVar;
    }

    public final boolean alp() {
        return true;
    }

    private boolean c(String str, h<ModulePkgInfo> hVar) {
        ModulePkgInfo uD = bi.oW(str) ? this.fdD.fcu.frm : uD(str);
        hVar.value = uD;
        if (bi.oW(uD.ffK)) {
            return false;
        }
        long VF = bi.VF();
        boolean cn = e.cn(uD.ffK);
        VF = bi.VF() - VF;
        x.d("MicroMsg.AppBrand.RuntimeModularizingHelper", "checkModuleLoaded with path(%s), check file cost %d", new Object[]{str, Long.valueOf(VF)});
        if (cn) {
            uC(uD.name);
        }
        return cn;
    }

    final void uC(String str) {
        if (!"__APP__".equals(str)) {
            synchronized (this.gko) {
                if (this.gko.containsKey(str)) {
                    return;
                }
                this.fdD.fcy.qw(str);
                this.gko.put(str, Boolean.valueOf(true));
                x.i("MicroMsg.AppBrand.RuntimeModularizingHelper", "module (%s) injected", new Object[]{str});
            }
        }
    }

    public final void a(String str, boolean z, com.tencent.mm.plugin.appbrand.i.a.b bVar, a$a a_a) {
        if (this.fdD.mFinished) {
            x.e("MicroMsg.AppBrand.RuntimeModularizingHelper", "loadModule with path(%s), but runtime(%s) finished", new Object[]{str, this.fdD.mAppId});
            bVar.a(d.gkj);
        } else if (this.fdD.dti) {
            h hVar = new h();
            if (!c(str, hVar) || bVar == null) {
                boolean contains;
                String str2 = ((ModulePkgInfo) hVar.value).name;
                if (bVar != null) {
                    this.gkn.o(str2, new a(bVar, a_a));
                }
                synchronized (this.gkm) {
                    contains = this.gkm.contains(str2);
                    if (!contains) {
                        this.gkm.add(str2);
                    }
                }
                if (!contains) {
                    h hVar2 = new h();
                    if (z) {
                        ah.A(new 2(this, str2, hVar2));
                    }
                    String str3 = (String) this.fdD.fcu.frm.fim.get(str2);
                    3 3 = new 3(this, this.fdD.mAppId, this.fdD.fcu.frm.fih, this.fdD.fcu.frm.fii, str3, str2, hVar2);
                    XIPCInvoker.a("com.tencent.mm", 3.ggL, com.tencent.mm.plugin.appbrand.launching.RuntimeLoadModuleTask.a.class, new 1(3));
                    return;
                }
                return;
            }
            bVar.a(d.gki);
        } else {
            ah.A(new 1(this, str, z, bVar, a_a));
        }
    }

    public final String uB(String str) {
        return uD(str).name;
    }

    private ModulePkgInfo uD(String str) {
        WxaPkgWrappingInfo wxaPkgWrappingInfo = this.fdD.fcu.frm;
        if (bi.oW(str)) {
            return wxaPkgWrappingInfo;
        }
        String qC = com.tencent.mm.plugin.appbrand.appcache.a.qC(str);
        Iterator it = wxaPkgWrappingInfo.fil.iterator();
        while (it.hasNext()) {
            ModulePkgInfo modulePkgInfo = (ModulePkgInfo) it.next();
            if (qC.startsWith(modulePkgInfo.name)) {
                return modulePkgInfo;
            }
        }
        return wxaPkgWrappingInfo;
    }
}
