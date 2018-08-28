package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONObject;

public abstract class e extends b {
    public String fEX;

    public final String f(String str, Map<String, ? extends Object> map) {
        Map hashMap = new HashMap();
        hashMap.put("errMsg", getName() + ":" + str);
        if (map != null) {
            if (b.chp() && map.containsKey("errMsg")) {
                Assert.assertTrue("api " + getName() + ": Cant put errMsg in res!!!", false);
            }
            hashMap.putAll(map);
        }
        c.m(hashMap);
        return new JSONObject(hashMap).toString();
    }

    public final String a(l lVar, String str, Map<String, ? extends Object> map) {
        if (m.a(lVar, map, this)) {
            return f(str, map);
        }
        return f(this.fEX, null);
    }

    public static MMActivity c(l lVar) {
        n nVar = lVar.fdO.fcz;
        if (nVar == null) {
            return null;
        }
        Context context = nVar.getContext();
        if (context instanceof MMActivity) {
            return (MMActivity) context;
        }
        return null;
    }

    public static p d(l lVar) {
        n nVar = lVar.fdO.fcz;
        if (nVar == null || nVar.getCurrentPage() == null) {
            return null;
        }
        return nVar.getCurrentPage().getCurrentPageView();
    }
}
