package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class u extends i<t> {
    public static final String[] dzV = new String[]{i.a(t.fgt, "PkgUpdateStats")};

    public u(e eVar) {
        super(eVar, t.fgt, "PkgUpdateStats", t.ciG);
    }

    final boolean af(String str, int i) {
        t tVar = new t();
        tVar.field_key = str;
        tVar.field_version = i;
        return super.a(tVar, t.fgs);
    }
}
