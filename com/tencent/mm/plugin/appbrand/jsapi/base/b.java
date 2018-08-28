package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b extends d {
    public void a(p pVar, JSONObject jSONObject, int i) {
        super.a(pVar, jSONObject, i);
        a(pVar, i, pVar, jSONObject);
    }

    public final void a(l lVar, JSONObject jSONObject, int i) {
        super.a(lVar, jSONObject, i);
        p d = d(lVar);
        if (d == null) {
            x.w("MicroMsg.BaseRemoveViewJsApi", "Remove view failed, AppBrandPageView is null.");
            lVar.E(i, f("fail:page is null", null));
            return;
        }
        a(lVar, i, d, jSONObject);
    }

    private void a(c cVar, int i, p pVar, JSONObject jSONObject) {
        try {
            boolean lt;
            int k = k(jSONObject);
            View lx = pVar.agU().lx(k);
            if (pVar.agU().lw(k)) {
                lt = pVar.agU().lt(k);
                if (lt) {
                    lt = b(pVar, k, lx, jSONObject);
                }
            } else {
                lt = false;
            }
            if (lt) {
                pVar.agU().ly(k);
            }
            x.i("MicroMsg.BaseRemoveViewJsApi", "remove view(parentId : %s, viewId : %s, r : %s)", new Object[]{Integer.valueOf(jSONObject.optInt("parentId", 0)), Integer.valueOf(k), Boolean.valueOf(lt)});
            cVar.E(i, f(lt ? "ok" : "fail", null));
        } catch (JSONException e) {
            x.e("MicroMsg.BaseRemoveViewJsApi", "get viewId error. exception : %s", new Object[]{e});
            cVar.E(i, f("fail:view id do not exist", null));
        }
    }

    public boolean b(p pVar, int i, View view, JSONObject jSONObject) {
        return true;
    }
}
