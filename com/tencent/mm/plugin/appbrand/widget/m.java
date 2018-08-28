package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;

public final class m extends i<l> {
    public static final String[] dzV = new String[]{i.a(l.dzU, "WxaWidgetInfo")};
    public static final String[] dzW = new String[0];

    public m(e eVar) {
        super(eVar, l.dzU, "WxaWidgetInfo", dzW);
    }

    public final l wg(String str) {
        if (bi.oW(str)) {
            return null;
        }
        l lVar = new l();
        lVar.field_appId = str;
        lVar.field_appIdHash = str.hashCode();
        if (b(lVar, new String[]{"appIdHash"})) {
            return lVar;
        }
        return null;
    }
}
