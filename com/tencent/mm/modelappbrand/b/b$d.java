package com.tencent.mm.modelappbrand.b;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class b$d {
    private final ag dGb;
    final Map<String, List<a>> dGc;
    final Map<String, Boolean> dGd;

    interface a {
        void Kf();

        void Kg();
    }

    /* synthetic */ b$d(ag agVar, byte b) {
        this(agVar);
    }

    private b$d(ag agVar) {
        this.dGc = new HashMap();
        this.dGd = new HashMap();
        this.dGb = agVar;
    }

    final void jA(String str) {
        if (!bi.oW(str)) {
            List<a> list = (List) this.dGc.remove(str);
            if (!bi.cX(list)) {
                for (a Kf : list) {
                    Kf.Kf();
                }
            }
        }
    }

    final void jB(String str) {
        if (!bi.oW(str)) {
            this.dGd.remove(str);
        }
    }

    final void a(String str, a aVar) {
        if (!bi.oW(str) && aVar != null) {
            List list = (List) this.dGc.get(str);
            if (list != null) {
                list.remove(aVar);
            }
        }
    }

    final void jC(String str) {
        if (!bi.oW(str)) {
            List<a> list = (List) this.dGc.remove(str);
            if (!bi.cX(list)) {
                for (a Kg : list) {
                    Kg.Kg();
                }
                list.clear();
            }
        }
    }

    final void j(Runnable runnable) {
        this.dGb.post(runnable);
    }
}
