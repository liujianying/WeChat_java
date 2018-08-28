package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.List;
import org.json.JSONObject;

public final class h extends i<g> {
    public static final String[] dzV = new String[]{i.a(g.fgt, "DevPkgLaunchExtInfo")};

    public h(e eVar) {
        super(eVar, g.fgt, "DevPkgLaunchExtInfo", g.ciG);
    }

    public final boolean n(String str, int i, String str2) {
        boolean z;
        if (bi.oW(str)) {
            z = false;
        } else {
            g gVar = new g();
            gVar.field_appId = str;
            gVar.field_versionType = i;
            if (super.b(gVar, g.fgs)) {
                gVar.field_extJson = bi.aG(str2, "{}");
                z = super.c(gVar, new String[0]);
            } else {
                gVar.field_extJson = bi.aG(str2, "{}");
                z = super.b(gVar);
            }
        }
        if (z) {
            List list = null;
            try {
                list = WxaAttributes.e.sj(new JSONObject(str2).optString("module_list"));
            } catch (Exception e) {
            }
            if (!bi.cX(list)) {
                com.tencent.mm.plugin.appbrand.app.e.abi().a(str, i, -1, list);
            }
        }
        return z;
    }

    public final String aH(String str, int i) {
        if (bi.oW(str)) {
            return "";
        }
        g gVar = new g();
        gVar.field_appId = str;
        gVar.field_versionType = i;
        if (super.b(gVar, g.fgs)) {
            return gVar.field_extJson;
        }
        return "";
    }
}
