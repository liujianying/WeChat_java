package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;

public final class d extends i<a> {
    public static final String[] dzV = new String[]{i.a(a.dzU, "AppBrandAppLaunchUsernameDuplicateRecord")};
    public final e fgu;

    public d(e eVar) {
        super(eVar, a.dzU, "AppBrandAppLaunchUsernameDuplicateRecord", a.ciG);
        this.fgu = eVar;
    }

    public final boolean u(String str, long j) {
        if (bi.oW(str)) {
            return false;
        }
        a aVar = new a();
        aVar.field_username = str;
        boolean b = b(aVar, new String[0]);
        aVar.field_updateTime = j;
        return b ? c(aVar, new String[0]) : b(aVar);
    }
}
