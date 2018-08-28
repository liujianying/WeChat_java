package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.config.WxaAttributes.e;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.Closeable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class n implements Closeable {
    private final WxaPkgWrappingInfo fgi;
    private final Map<String, ag> fgj = new HashMap();

    n(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        this.fgi = wxaPkgWrappingInfo;
        this.fgi.aco();
    }

    final ag qG(String str) {
        if (bi.oW(str)) {
            return null;
        }
        String str2;
        String qC = a.qC(str);
        if (qC.startsWith("__APP__")) {
            str2 = "__APP__";
        } else {
            Iterator it = this.fgi.fil.iterator();
            while (it.hasNext()) {
                ModulePkgInfo modulePkgInfo = (ModulePkgInfo) it.next();
                if (qC.startsWith(modulePkgInfo.name)) {
                    str2 = modulePkgInfo.name;
                    break;
                }
            }
            str2 = null;
            if (bi.oW(str2)) {
                str2 = "__APP__";
            }
        }
        return qH(str2);
    }

    final void abJ() {
        synchronized (this.fgj) {
            qH("__APP__");
            Iterator it = this.fgi.fil.iterator();
            while (it.hasNext()) {
                qH(((e) it.next()).name);
            }
        }
    }

    final ag qH(String str) {
        ag agVar;
        synchronized (this.fgj) {
            agVar = (ag) this.fgj.get(str);
            if (agVar != null) {
            } else {
                String str2;
                if ("__APP__".equals(str)) {
                    str2 = this.fgi.ffK;
                } else {
                    Iterator it = this.fgi.fil.iterator();
                    while (it.hasNext()) {
                        ModulePkgInfo modulePkgInfo = (ModulePkgInfo) it.next();
                        if (str.equals(modulePkgInfo.name)) {
                            str2 = modulePkgInfo.ffK;
                            break;
                        }
                    }
                    str2 = null;
                }
                if (bi.oW(str2)) {
                } else {
                    agVar = new ag(str2);
                    this.fgj.put(str, agVar);
                }
            }
        }
        if (agVar != null) {
            agVar.abW();
        }
        return agVar;
    }

    public final void close() {
        synchronized (this.fgj) {
            Collection<ag> values = this.fgj.values();
        }
        for (ag close : values) {
            close.close();
        }
    }
}
