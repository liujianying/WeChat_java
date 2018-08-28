package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.l;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import org.json.JSONObject;

public final class br extends a {
    public static final int CTRL_INDEX = 150;
    public static final String NAME = "switchTab";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
        if (lVar.fdO.fcv.foP.rH(optString)) {
            lVar.fdO.fcz.uW(optString);
            lVar.E(i, f("ok", null));
            return;
        }
        lVar.E(i, f("fail:can not switch to non-TabBar page", null));
    }
}
