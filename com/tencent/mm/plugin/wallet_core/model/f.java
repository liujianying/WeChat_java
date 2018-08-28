package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class f {
    public int pmu;
    public String pmv;
    public String pmw;
    public String pmx;
    public String pmy;
    public String pmz;

    public static f OU(String str) {
        if (!bi.oW(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                f fVar = new f();
                fVar.pmu = jSONObject.optInt("menu_jump_type", -1);
                fVar.pmv = jSONObject.optString("menu_jump_url", "");
                fVar.pmw = jSONObject.optString("menu_username", "");
                fVar.pmx = jSONObject.optString("menu_path", "");
                fVar.pmy = jSONObject.optString("menu_title", "");
                fVar.pmz = jSONObject.optString("menu_icon_url", "");
                x.i("BindCardMenu", "parse bind card menu, type: %s, title: %s", new Object[]{Integer.valueOf(fVar.pmu), fVar.pmy});
                return fVar;
            } catch (Throwable e) {
                x.printErrStackTrace("BindCardMenu", e, "", new Object[0]);
            }
        }
        return null;
    }
}
