package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;

public final class c extends i<b> {
    public static final String[] dzV = new String[]{i.a(b.dzU, "AppBrandCommonKVData")};
    public final e fgu;

    public c(e eVar) {
        super(eVar, b.dzU, "AppBrandCommonKVData", null);
        this.fgu = eVar;
    }

    public final boolean bd(String str, String str2) {
        if (bi.oW(str)) {
            return false;
        }
        b bVar = new b();
        bVar.field_key = str;
        bVar.field_value = str2;
        if (!bi.oW(bVar.field_value)) {
            return super.a(bVar);
        }
        if (super.a(bVar, new String[0])) {
            return false;
        }
        return true;
    }

    public final String get(String str, String str2) {
        if (bi.oW(str)) {
            return str2;
        }
        b bVar = new b();
        bVar.field_key = str;
        if (super.b(bVar, new String[0])) {
            return bVar.field_value;
        }
        return str2;
    }

    public final void rI(String str) {
        super.fV("AppBrandCommonKVData", String.format("delete from %s where %s like '%s%%'", new Object[]{"AppBrandCommonKVData", "key", str}));
    }
}
