package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.protocal.c.aql;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class s extends i<t> {
    public static final String frM = i.a(t.fgt, "LaunchWxaAppRespTable");

    public s(e eVar) {
        super(eVar, t.fgt, "LaunchWxaAppRespTable", t.ciG);
    }

    public final t a(String str, aql aql) {
        if (bi.oW(str) || aql == null) {
            return null;
        }
        boolean z;
        t tVar = new t();
        tVar.a(aql);
        tVar.field_appId = str;
        t tVar2 = new t();
        tVar2.field_appId = str;
        boolean z2 = !b(tVar2, "appId");
        if (z2 || !tVar2.equals(tVar)) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.LaunchWxaAppCacheStorage", "flush resp, appId %s, apply %B, insert %B", new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (z) {
            if (z2) {
                a(tVar, false);
            } else {
                b(tVar, false, "appId");
            }
        }
        if (z) {
            if (b(tVar2, "appId")) {
                return tVar2;
            }
        }
        return tVar;
    }

    public final boolean a(t tVar, boolean z, String... strArr) {
        if (!bi.G(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    tVar.field_appIdHash = tVar.field_appId.hashCode();
                    break;
                }
            }
        }
        return super.a(tVar, z, strArr);
    }

    /* renamed from: a */
    public final boolean b(t tVar, String... strArr) {
        if (!bi.G(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    tVar.field_appIdHash = tVar.field_appId.hashCode();
                    break;
                }
            }
        }
        return super.b(tVar, strArr);
    }

    private boolean a(t tVar, boolean z) {
        tVar.field_appIdHash = tVar.field_appId.hashCode();
        super.a(tVar, z);
        x.i("MicroMsg.LaunchWxaAppCacheStorage", "insertNotify appId %s ret %B", new Object[]{tVar.field_appId, Boolean.valueOf(b(tVar, "appId"))});
        return b(tVar, "appId");
    }

    private boolean b(t tVar, boolean z, String... strArr) {
        if (!bi.G(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    tVar.field_appIdHash = tVar.field_appId.hashCode();
                    break;
                }
            }
        }
        x.i("MicroMsg.LaunchWxaAppCacheStorage", "updateNotify appId %s, ret %B", new Object[]{tVar.field_appId, Boolean.valueOf(super.b(tVar, z, strArr))});
        return super.b(tVar, z, strArr);
    }
}
