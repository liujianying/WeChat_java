package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.view.MotionEvent;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.o.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.c.f;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class b$a$1 implements Runnable {
    final /* synthetic */ a gcC;

    b$a$1(a aVar) {
        this.gcC = aVar;
    }

    public final void run() {
        if (a.a(this.gcC)) {
            f bL = c.bL(a.b(this.gcC));
            if (Math.abs(a.c(this.gcC).x - bL.x) > 1.0f || Math.abs(a.c(this.gcC).y - bL.y) > 1.0f) {
                x.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but view has moved.");
                return;
            } else if (a.d(this.gcC).size() != 1) {
                x.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but more then one point.");
                return;
            } else if (Math.abs(a.e(this.gcC).x - a.f(this.gcC).x) > a.g(this.gcC) || Math.abs(a.e(this.gcC).y - a.f(this.gcC).y) > a.g(this.gcC)) {
                x.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but point has moved(%s, %s, %s, %s).", new Object[]{Float.valueOf(a.e(this.gcC).x), Float.valueOf(a.f(this.gcC).x), Float.valueOf(a.e(this.gcC).y), Float.valueOf(a.f(this.gcC).y)});
                return;
            } else {
                x.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, publish event(%s, %s, %s, %s).", new Object[]{Float.valueOf(a.e(this.gcC).x), Float.valueOf(a.f(this.gcC).x), Float.valueOf(a.e(this.gcC).y), Float.valueOf(a.f(this.gcC).y)});
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, a.h(this.gcC).getString(SlookAirButtonFrequentContactAdapter.DATA, ""));
                    jSONObject.put("touch", a.e(this.gcC).tR());
                } catch (JSONException e) {
                }
                if (!a.h(this.gcC).getBoolean("disableScroll", false)) {
                    a.a(this.gcC, MotionEvent.obtain(a.i(this.gcC)));
                    a.j(this.gcC).setAction(0);
                    a.h(this.gcC).w("fakeDownEvent", true);
                    a.b(this.gcC).getParent().requestDisallowInterceptTouchEvent(true);
                    a.b(this.gcC).setDuplicateParentStateEnabled(false);
                    a.a(a.b(this.gcC), MotionEvent.obtain(a.j(this.gcC)));
                }
                a.a(this.gcC, new c.a(), jSONObject.toString());
                return;
            }
        }
        x.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but pressed is false or pointer is null.");
    }
}
