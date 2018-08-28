package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.o.c$c;
import com.tencent.mm.plugin.appbrand.jsapi.o.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.o.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.o.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.o.c.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static void a(p pVar, View view, MotionEvent motionEvent, String str, boolean z) {
        h c_c;
        int i = 0;
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float x = motionEvent.getX(actionIndex);
        float y = motionEvent.getY(actionIndex);
        f fVar = new f();
        fVar.a(pointerId, x, y);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, str);
        } catch (JSONException e) {
        }
        x.i("MicroMsg.InsertViewTouchEventDispatch", "action:%d", new Object[]{Integer.valueOf(motionEvent.getAction())});
        JSONArray jSONArray;
        f[] y2;
        switch (motionEvent.getAction()) {
            case 0:
                try {
                    jSONObject.put("touch", fVar.tR());
                } catch (JSONException e2) {
                }
                c_c = new c$c();
                break;
            case 1:
                try {
                    jSONObject.put("touch", fVar.tR());
                } catch (JSONException e3) {
                }
                e eVar = new e();
                view.getParent().requestDisallowInterceptTouchEvent(false);
                c_c = eVar;
                break;
            case 2:
                jSONArray = new JSONArray();
                try {
                    jSONObject.put("touches", jSONArray);
                } catch (JSONException e4) {
                }
                y2 = y(motionEvent);
                if (y2.length > 0) {
                    while (i < y2.length) {
                        jSONArray.put(y2[i].tR());
                        i++;
                    }
                }
                c_c = new d();
                break;
            case 3:
                jSONArray = new JSONArray();
                try {
                    jSONObject.put("touches", jSONArray);
                } catch (JSONException e5) {
                }
                y2 = y(motionEvent);
                if (y2.length > 0) {
                    while (i < y2.length) {
                        jSONArray.put(y2[i].tR());
                        i++;
                    }
                }
                c_c = new b();
                break;
            default:
                c_c = null;
                break;
        }
        if (c_c != null && z) {
            c_c = c_c.a(pVar);
            c_c.mData = jSONObject.toString();
            c_c.h(null);
        } else if (c_c != null) {
            c_c = c_c.a(pVar);
            c_c.mData = jSONObject.toString();
            c_c.ahM();
        }
    }

    private static f[] y(MotionEvent motionEvent) {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
            f fVar = new f();
            fVar.id = motionEvent.getPointerId(i2);
            fVar.x = motionEvent.getX(i2);
            fVar.y = motionEvent.getY(i2);
            arrayList.add(fVar);
        }
        f[] fVarArr = new f[arrayList.size()];
        while (i < arrayList.size()) {
            fVarArr[i] = (f) arrayList.get(i);
            i++;
        }
        return fVarArr;
    }
}
