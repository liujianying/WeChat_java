package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ac extends n {
    public static final int CTRL_INDEX = -1;
    public static final String NAME = "getMenuButtonBoundingClientRect";

    public final String a(l lVar, JSONObject jSONObject) {
        p d = d(lVar);
        if (d == null) {
            x.w("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "invoke JsApi JsApiGetMenuButtonBoundingClientRect failed, current page view is null.");
            return f("fail", null);
        } else if (d.gnn == null || d.gnn.getActionView().getWidth() == 0) {
            x.w("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "invoke JsApi JsApiGetMenuButtonBoundingClientRect failed, actionbar is not ready.");
            return f("fail", null);
        } else {
            Map hashMap = new HashMap();
            hashMap.put("width", Integer.valueOf(f.lO(d.gnn.getActionView().getWidth())));
            hashMap.put("height", Integer.valueOf(f.lO(d.gnn.getActionView().getHeight())));
            hashMap.put("top", Integer.valueOf(f.lO(d.gnn.getActionView().getTop())));
            hashMap.put("right", Integer.valueOf(f.lO(d.gnn.getActionView().getRight())));
            hashMap.put("bottom", Integer.valueOf(f.lO(d.gnn.getActionView().getBottom())));
            hashMap.put("left", Integer.valueOf(f.lO(d.gnn.getActionView().getLeft())));
            x.i("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getMenuButtonBoundingClientRect : %s", new Object[]{f("ok", hashMap)});
            return f("ok", hashMap);
        }
    }
}
