package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.mm.model.u$b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a extends d {
    public abstract View a(p pVar, JSONObject jSONObject);

    public final void a(l lVar, JSONObject jSONObject, int i) {
        super.a(lVar, jSONObject, i);
        p d = d(lVar);
        if (d == null) {
            x.w("MicroMsg.BaseInsertViewJsApi", "invoke JsApi insertView failed, current page view is null.");
            lVar.E(i, f("fail:page is null", null));
            return;
        }
        a((c) lVar, i, d, jSONObject);
    }

    public void a(p pVar, JSONObject jSONObject, int i) {
        super.a(pVar, jSONObject, i);
        a((c) pVar, i, pVar, jSONObject);
    }

    private void a(c cVar, int i, p pVar, JSONObject jSONObject) {
        final p pVar2 = pVar;
        final c cVar2 = cVar;
        final int i2 = i;
        final JSONObject jSONObject2 = jSONObject;
        ah.A(new Runnable() {
            public final void run() {
                if (pVar2 == null) {
                    x.w("MicroMsg.BaseInsertViewJsApi", "page view has been release.");
                    cVar2.E(i2, a.this.f("fail:page is null", null));
                    return;
                }
                View a = a.this.a(pVar2, jSONObject2);
                if (a == null) {
                    x.w("MicroMsg.BaseInsertViewJsApi", "inflate view return null.");
                    cVar2.E(i2, a.this.f("inflate view failed", null));
                    return;
                }
                try {
                    int k = a.this.k(jSONObject2);
                    if (pVar2.agU().lw(k)) {
                        x.w("MicroMsg.BaseInsertViewJsApi", "insert view(%d) failed, it has been inserted before.", new Object[]{Integer.valueOf(k)});
                        cVar2.E(i2, a.this.f("fail:the view has already exist", null));
                        return;
                    }
                    boolean a2;
                    u$b E;
                    String str;
                    int optInt = jSONObject2.optInt("parentId", 0);
                    try {
                        float[] l = a.l(jSONObject2);
                        int m = a.m(jSONObject2);
                        Boolean n = a.n(jSONObject2);
                        u agU = pVar2.agU();
                        boolean z = n != null && n.booleanValue();
                        a2 = agU.a(a, k, optInt, l, m, z);
                    } catch (JSONException e) {
                        x.e("MicroMsg.BaseInsertViewJsApi", "parse position error. Exception :%s", new Object[]{e});
                        a2 = false;
                    }
                    if (a2) {
                        a aVar = a.this;
                        p pVar = pVar2;
                        JSONObject jSONObject = jSONObject2;
                        if (aVar.aii()) {
                            E = pVar.agU().E(k, true);
                            E.w("disableScroll", jSONObject.optBoolean("disableScroll", false));
                            E.w("enableLongClick", aVar.aij());
                            E.O("data", jSONObject.optString("data"));
                            if (jSONObject.optBoolean("gesture", false)) {
                                if (pVar == null || a == null || E == null) {
                                    x.i("MicroMsg.ViewMotionHelper", "setOnTouchListener failed, page or view or keyValueSet is null.");
                                } else {
                                    a.setOnTouchListener(new com.tencent.mm.plugin.appbrand.jsapi.o.b.a(pVar, E));
                                }
                            }
                        }
                        a.this.a(pVar2, k, a, jSONObject2);
                    }
                    a aVar2 = a.this;
                    p pVar2 = pVar2;
                    E = pVar2.agU().E(k, true);
                    if (((e) E.get("baseViewDestroyListener", null)) == null) {
                        e 2 = new 2(aVar2, pVar2, k, E);
                        E.p("baseViewDestroyListener", 2);
                        pVar2.a(2);
                    }
                    x.i("MicroMsg.BaseInsertViewJsApi", "insert view(parentId : %s, viewId : %s, view : %s, r : %s)", new Object[]{Integer.valueOf(optInt), Integer.valueOf(k), Integer.valueOf(a.hashCode()), Boolean.valueOf(a2)});
                    c cVar = cVar2;
                    k = i2;
                    a aVar3 = a.this;
                    if (a2) {
                        str = "ok";
                    } else {
                        str = "fail:insert view fail";
                    }
                    cVar.E(k, aVar3.f(str, null));
                } catch (JSONException e2) {
                    cVar2.E(i2, a.this.f("fail:invalid view id", null));
                }
            }
        });
    }

    public void a(p pVar, int i, View view, JSONObject jSONObject) {
    }

    public boolean aii() {
        return false;
    }

    public boolean aij() {
        return false;
    }
}
