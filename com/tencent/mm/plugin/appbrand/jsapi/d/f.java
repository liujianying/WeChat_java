package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.view.View;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.d;
import com.tencent.mm.plugin.appbrand.widget.input.c;
import com.tencent.mm.plugin.appbrand.widget.input.c.a;
import com.tencent.mm.plugin.appbrand.widget.input.c.a.b;
import com.tencent.mm.plugin.appbrand.widget.input.c.e;
import com.tencent.mm.plugin.appbrand.widget.input.g;
import com.tencent.mm.plugin.appbrand.widget.input.h;
import com.tencent.mm.plugin.appbrand.widget.input.h.1;
import com.tencent.mm.plugin.appbrand.widget.input.h.2;
import com.tencent.mm.plugin.appbrand.widget.input.h.3;
import com.tencent.mm.plugin.appbrand.widget.input.h.4;
import com.tencent.mm.plugin.appbrand.widget.input.m;
import com.tencent.mm.plugin.appbrand.widget.input.z;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f extends a<e> {
    public static final int CTRL_INDEX = 1;
    static final String NAME = "showKeyboard";

    static /* synthetic */ void a(f fVar, p pVar, int i, int i2, String str, e eVar, int i3) {
        Object obj;
        int intValue;
        int intValue2;
        WeakReference weakReference;
        h apn = h$a.gGP;
        c a = a.a(eVar.gLv, pVar, eVar);
        if (a == null) {
            obj = null;
        } else {
            boolean z;
            if (eVar.gLA != null) {
                a.wh(eVar.gLA);
            }
            a.a(eVar);
            if (eVar.gLz != null) {
                com.tencent.mm.plugin.appbrand.widget.input.c.a.a aVar = eVar.gLz;
                p pVar2 = (p) a.gGm.get();
                if (!(pVar2 == null || a.aph() == null)) {
                    d.a(pVar2, a.aph(), aVar);
                }
            }
            int intValue3 = eVar.gLB.intValue();
            int intValue4 = eVar.gLC.intValue();
            intValue = eVar.gLE.intValue();
            intValue2 = eVar.gLD.intValue();
            p pVar3 = (p) a.gGm.get();
            if (pVar3 == null || pVar3.gns == null) {
                z = false;
            } else {
                View aph = a.aph();
                if (aph == null) {
                    z = false;
                } else {
                    com.tencent.mm.plugin.appbrand.widget.input.f fVar2 = pVar3.gnr;
                    if (fVar2 == null) {
                        z = false;
                    } else {
                        boolean a2 = fVar2.a(pVar3.gns, aph, intValue3, intValue4, intValue, intValue2);
                        if (a2) {
                            ((z) aph).a(a.gGn);
                            aph.addTextChangedListener(a);
                        }
                        z = a2;
                    }
                }
            }
            if (!z) {
                obj = null;
            } else if (a.showKeyboard(i, i2)) {
                weakReference = new WeakReference(pVar);
                intValue4 = a.getInputId();
                ((z) a.aph()).setOnKeyUpPostImeListener(new 2(apn, weakReference, a, str));
                a.gGj = new 3(apn, weakReference, a, intValue4, str);
                a.gGk = new 4(apn, weakReference, intValue4);
                if (!(pVar == null || a == null)) {
                    int inputId = a.getInputId();
                    pVar.a(new 1(apn, inputId));
                    apn.gGJ.put(inputId, a);
                }
                obj = Integer.valueOf(intValue4);
            } else {
                obj = null;
            }
        }
        if (obj != null) {
            Map hashMap = new HashMap(1);
            hashMap.put("inputId", obj);
            pVar.E(i3, fVar.f("ok", hashMap));
            return;
        }
        final String str2 = pVar.mAppId;
        final int hashCode = pVar.hashCode();
        weakReference = new WeakReference(pVar);
        eVar.gGm = weakReference;
        final AppBrandInputInvokeHandler a3 = fVar.a(weakReference, str, i3);
        a3.setOnValueChangeListener(new com.tencent.mm.plugin.appbrand.widget.input.a.c() {
            public final void aD(String str, int i) {
                int inputId = a3.getInputId();
                if (a3.getWidget() == null) {
                    x.e("MicroMsg.JsApiShowKeyboard", "dispatchKBValue(%s), but get NULL inputWidget", new Object[]{str2});
                    return;
                }
                b bVar = new b();
                Map hashMap = new HashMap();
                hashMap.put("value", com.tencent.mm.plugin.appbrand.r.c.vT(str));
                hashMap.put("data", f.kJ(inputId));
                hashMap.put("cursor", Integer.valueOf(i));
                hashMap.put("inputId", Integer.valueOf(inputId));
                hashMap.put("keyCode", Integer.valueOf(a3.getWidget().getLastKeyPressed()));
                bVar.aC(str2, hashCode).x(hashMap).ahM();
            }
        });
        fVar.a(a3);
        final e eVar2 = eVar;
        intValue = i;
        intValue2 = i2;
        com.tencent.mm.plugin.appbrand.r.c.runOnUiThread(new Runnable() {
            public final void run() {
                p pVar = (p) weakReference.get();
                if (pVar != null && pVar.gns != null) {
                    g.apm().o(pVar.gns);
                    a3.insertInput(eVar2, intValue, intValue2);
                }
            }
        });
    }

    public void a(p pVar, JSONObject jSONObject, int i) {
        int optInt;
        int optInt2;
        int optInt3 = jSONObject.optInt("cursor", -2);
        if (jSONObject.has("selectionStart") || jSONObject.has("selectionEnd")) {
            optInt = jSONObject.optInt("selectionStart", -2);
            optInt2 = jSONObject.optInt("selectionEnd", -2);
        } else {
            optInt2 = optInt3;
            optInt = optInt3;
        }
        try {
            int i2 = jSONObject.getInt("inputId");
            if (aiU()) {
                ah.A(new 1(this, pVar, i2, optInt, optInt2, i));
                return;
            }
        } catch (JSONException e) {
        }
        e eVar = new e();
        if (a(eVar, jSONObject, pVar, i)) {
            if (!jSONObject.has("inputId")) {
                eVar.gGq = (pVar.hashCode() + "#" + System.currentTimeMillis() + "#" + System.nanoTime()).hashCode();
            }
            com.tencent.mm.plugin.appbrand.r.c.runOnUiThread(new 2(this, pVar, optInt, optInt2, jSONObject.optString("data"), eVar, i));
        }
    }

    protected boolean aiU() {
        return true;
    }

    protected boolean aiV() {
        return true;
    }

    protected void a(AppBrandInputInvokeHandler appBrandInputInvokeHandler) {
    }

    protected boolean aiW() {
        return true;
    }

    protected AppBrandInputInvokeHandler a(WeakReference<p> weakReference, String str, int i) {
        return new 5(this, weakReference, i, str);
    }

    protected boolean a(e eVar, JSONObject jSONObject, p pVar, int i) {
        int i2 = 0;
        if (!super.a(eVar, jSONObject, pVar, i)) {
            return false;
        }
        int i3;
        eVar.dGN = jSONObject.optInt("parentId");
        eVar.gGq = jSONObject.optInt("inputId");
        eVar.gLB = Integer.valueOf(Math.max(0, eVar.gLB.intValue()));
        if (eVar.gLC == null) {
            i3 = 0;
        } else {
            i3 = Math.max(0, eVar.gLC.intValue());
        }
        eVar.gLC = Integer.valueOf(i3);
        eVar.gLv = jSONObject.optString("type", "text");
        if (m.gHr.contains(eVar.gLv)) {
            if (eVar.gLZ == null) {
                eVar.gLZ = Boolean.valueOf(true);
            }
            eVar.gLw = jSONObject.optBoolean("password");
            eVar.gMh = Boolean.valueOf(jSONObject.optBoolean("password"));
            if (aiV()) {
                JSONObject optJSONObject = jSONObject.optJSONObject("dropdown");
                if (optJSONObject != null) {
                    com.tencent.mm.plugin.appbrand.widget.input.c.a.a aVar = new com.tencent.mm.plugin.appbrand.widget.input.c.a.a();
                    aVar.gLh = optJSONObject.optInt("marginLeft");
                    aVar.gLi = optJSONObject.optInt("marginRight");
                    aVar.gLj = optJSONObject.optString("width");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("options");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        aVar.gLk = new ArrayList();
                        while (i2 < optJSONArray.length()) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                            if (optJSONObject2 != null) {
                                String optString = optJSONObject2.optString("id");
                                String optString2 = optJSONObject2.optString("title");
                                String optString3 = optJSONObject2.optString("content");
                                if (!(bi.oW(optString) || bi.oW(optString2))) {
                                    b bVar = new b();
                                    bVar.id = optString;
                                    bVar.title = optString2;
                                    bVar.content = optString3;
                                    aVar.gLk.add(bVar);
                                }
                            }
                            i2++;
                        }
                        eVar.gLz = aVar;
                    }
                }
            }
            return true;
        }
        pVar.E(i, f("fail:unsupported input type", null));
        return false;
    }
}
