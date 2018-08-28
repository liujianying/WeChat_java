package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.mm.protocal.c.aqn;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bi;

public final class i extends com.tencent.mm.sdk.e.i<j> {
    public static final String frM = com.tencent.mm.sdk.e.i.a(j.fgt, "LaunchWxaWidgetRespData");

    public i(e eVar) {
        super(eVar, j.fgt, "LaunchWxaWidgetRespData", j.ciG);
    }

    public final j a(String str, int i, int i2, aqn aqn) {
        if (bi.oW(str) || aqn == null) {
            return null;
        }
        int i3;
        int i4;
        j jVar = new j();
        jVar.field_appIdHash = str.hashCode();
        jVar.field_appId = str;
        jVar.field_pkgType = i;
        jVar.field_widgetType = i2;
        if (b(jVar, "appId", "pkgType", "widgetType")) {
            boolean i32 = false;
        } else {
            i32 = 1;
        }
        if (com.tencent.mm.plugin.appbrand.q.i.a(jVar.field_launchAction, aqn.rTa)) {
            boolean i42 = false;
        } else {
            jVar.field_launchAction = aqn.rTa;
            i42 = 1;
        }
        if (!com.tencent.mm.plugin.appbrand.q.i.a(jVar.field_jsApiInfo, aqn.rSV)) {
            jVar.field_jsApiInfo = aqn.rSV;
            i42 = 1;
        }
        if (!com.tencent.mm.plugin.appbrand.q.i.a(jVar.field_versionInfo, aqn.rTb)) {
            jVar.field_versionInfo = aqn.rTb;
            i42 = 1;
        }
        if (!com.tencent.mm.plugin.appbrand.q.i.a(jVar.field_widgetSetting, aqn.rTc)) {
            jVar.field_widgetSetting = aqn.rTc;
            i42 = 1;
        }
        if (i42 != 0) {
            if (i32 != 0) {
                a(jVar, false);
            } else {
                a(jVar, false, "appId", "pkgType", "widgetType");
            }
        }
        if (i42 != 0) {
            b(jVar, "appId", "pkgType", "widgetType");
        }
        return jVar;
    }

    /* renamed from: a */
    public final boolean b(j jVar, String... strArr) {
        if (!bi.G(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    jVar.field_appIdHash = jVar.field_appId.hashCode();
                    break;
                }
            }
        }
        return super.b(jVar, strArr);
    }

    private boolean a(j jVar, boolean z) {
        jVar.field_appIdHash = jVar.field_appId.hashCode();
        super.a(jVar, z);
        return b(jVar, "appId");
    }

    private boolean a(j jVar, boolean z, String... strArr) {
        if (!bi.G(strArr)) {
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("appId")) {
                    strArr[i] = "appIdHash";
                    jVar.field_appIdHash = jVar.field_appId.hashCode();
                    break;
                }
            }
        }
        return super.b(jVar, z, strArr);
    }
}
