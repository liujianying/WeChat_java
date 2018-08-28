package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONException;
import org.json.JSONObject;

public class b$a implements OnTouchListener {
    private static volatile View gcq;
    private b doS;
    private c$f gcA;
    private c$f gcB;
    private Map<Integer, c$f> gcr = new HashMap();
    private boolean gcs;
    private boolean gct;
    private c$f gcu;
    private Runnable gcv;
    private int gcw;
    private float gcx;
    private MotionEvent gcy;
    private MotionEvent gcz;
    private String mAppId;
    private View mView;

    public b$a(p pVar, b bVar) {
        Assert.assertNotNull(pVar);
        Assert.assertNotNull(bVar);
        this.doS = bVar;
        this.mAppId = pVar.mAppId;
        this.gcw = pVar.hashCode();
        this.gcx = (float) ViewConfiguration.get(pVar.mContext).getScaledTouchSlop();
        this.gcA = new c$f();
        this.gcB = new c$f();
        this.gcv = new 1(this);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(android.view.View r19, android.view.MotionEvent r20) {
        /*
        r18 = this;
        r2 = gcq;
        if (r2 == 0) goto L_0x0019;
    L_0x0004:
        r2 = gcq;
        r0 = r19;
        r2 = r2.equals(r0);
        if (r2 != 0) goto L_0x0019;
    L_0x000e:
        r2 = "MicroMsg.OnTouchListenerImpl";
        r3 = "onTouch, not current motion view";
        com.tencent.mm.sdk.platformtools.x.v(r2, r3);
        r4 = 0;
    L_0x0018:
        return r4;
    L_0x0019:
        r0 = r20;
        r1 = r18;
        r1.gcz = r0;
        r7 = r20.getActionMasked();
        r2 = r20.getActionIndex();
        r20.getPointerCount();
        r0 = r20;
        r8 = r0.getPointerId(r2);
        r0 = r20;
        r9 = r0.getX(r2);
        r0 = r20;
        r10 = r0.getY(r2);
        r5 = 0;
        if (r7 == 0) goto L_0x0057;
    L_0x003f:
        r0 = r18;
        r2 = r0.doS;
        r3 = "isTouching";
        r2 = r2.ie(r3);
        if (r2 != 0) goto L_0x0057;
    L_0x004c:
        r2 = android.support.v4.view.z.ak(r19);
        if (r2 != 0) goto L_0x0057;
    L_0x0052:
        r2 = 3;
        if (r7 == r2) goto L_0x0057;
    L_0x0055:
        r4 = 0;
        goto L_0x0018;
    L_0x0057:
        r0 = r18;
        r2 = r0.doS;
        r3 = "data";
        r4 = "";
        r11 = r2.getString(r3, r4);
        r0 = r18;
        r2 = r0.doS;
        r3 = "disableScroll";
        r4 = 0;
        r12 = r2.getBoolean(r3, r4);
        r0 = r18;
        r2 = r0.doS;
        r3 = "fakeDownEvent";
        r4 = 0;
        r2 = r2.getBoolean(r3, r4);
        r0 = r18;
        r3 = r0.doS;
        r4 = "onLongClick";
        r6 = 0;
        r3 = r3.getBoolean(r4, r6);
        r0 = r18;
        r4 = r0.doS;
        r6 = "enableLongClick";
        r13 = 0;
        r4 = r4.getBoolean(r6, r13);
        r0 = r18;
        r0.gct = r4;
        r0 = r18;
        r4 = r0.gcB;
        r4.a(r8, r9, r10);
        r4 = r12 | r3;
        switch(r7) {
            case 0: goto L_0x00a7;
            case 1: goto L_0x028b;
            case 2: goto L_0x0192;
            case 3: goto L_0x02f2;
            case 4: goto L_0x00a5;
            case 5: goto L_0x0393;
            case 6: goto L_0x02c7;
            default: goto L_0x00a5;
        };
    L_0x00a5:
        goto L_0x0018;
    L_0x00a7:
        r0 = r18;
        r6 = r0.gcy;
        if (r6 == 0) goto L_0x0390;
    L_0x00ad:
        r14 = r20.getDownTime();
        r0 = r18;
        r6 = r0.gcy;
        r16 = r6.getDownTime();
        r6 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
        if (r6 == 0) goto L_0x0390;
    L_0x00bd:
        r2 = 0;
        r0 = r18;
        r6 = r0.doS;
        r13 = "fakeDownEvent";
        r14 = 0;
        r6.w(r13, r14);
        r6 = "MicroMsg.OnTouchListenerImpl";
        r13 = "try to handle fake event failed";
        com.tencent.mm.sdk.platformtools.x.v(r6, r13);
        r6 = r2;
    L_0x00d3:
        if (r12 != 0) goto L_0x00d7;
    L_0x00d5:
        if (r6 == 0) goto L_0x0269;
    L_0x00d7:
        r2 = r19.getParent();
        r12 = 1;
        r2.requestDisallowInterceptTouchEvent(r12);
        r2 = 0;
        r0 = r19;
        r0.setDuplicateParentStateEnabled(r2);
        r2 = "MicroMsg.OnTouchListenerImpl";
        r12 = "onLongClick fake down event.";
        com.tencent.mm.sdk.platformtools.x.i(r2, r12);
    L_0x00ee:
        if (r6 == 0) goto L_0x0271;
    L_0x00f0:
        r3 = 1;
        r2 = 1;
        r0 = r18;
        r4 = r0.doS;
        r12 = "fakeDownEvent";
        r13 = 0;
        r4.w(r12, r13);
        r0 = r18;
        r4 = r0.doS;
        r12 = "onLongClick";
        r13 = 1;
        r4.w(r12, r13);
    L_0x0108:
        r0 = r18;
        r4 = r0.doS;
        r12 = "isTouching";
        r13 = 1;
        r4.w(r12, r13);
        r0 = r18;
        r4 = r0.gct;
        if (r4 == 0) goto L_0x0137;
    L_0x0119:
        if (r3 != 0) goto L_0x0137;
    L_0x011b:
        r0 = r18;
        r4 = r0.gcr;
        r12 = java.lang.Integer.valueOf(r8);
        r4 = r4.containsKey(r12);
        if (r4 != 0) goto L_0x0137;
    L_0x0129:
        r0 = r18;
        r4 = r0.gcv;
        r12 = android.view.ViewConfiguration.getLongPressTimeout();
        r12 = (long) r12;
        r0 = r19;
        r0.postDelayed(r4, r12);
    L_0x0137:
        r4 = r2;
    L_0x0138:
        r2 = 0;
        r2 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x0285;
    L_0x013d:
        r2 = 0;
        r2 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x0285;
    L_0x0142:
        r2 = r19.getWidth();
        r2 = (float) r2;
        r2 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1));
        if (r2 > 0) goto L_0x0285;
    L_0x014b:
        r2 = r19.getHeight();
        r2 = (float) r2;
        r2 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1));
        if (r2 > 0) goto L_0x0285;
    L_0x0154:
        r2 = 1;
    L_0x0155:
        if (r2 == 0) goto L_0x0018;
    L_0x0157:
        r12 = new com.tencent.mm.plugin.appbrand.jsapi.o.c$f;
        r12.<init>(r8, r9, r10);
        if (r7 != 0) goto L_0x0288;
    L_0x015e:
        if (r3 != 0) goto L_0x0288;
    L_0x0160:
        r2 = 1;
    L_0x0161:
        r0 = r18;
        r1 = r19;
        r0.e(r1, r2);
        r0 = r18;
        r2 = r0.gcr;
        r3 = java.lang.Integer.valueOf(r8);
        r2 = r2.containsKey(r3);
        if (r2 == 0) goto L_0x038d;
    L_0x0176:
        r2 = 1;
    L_0x0177:
        r0 = r18;
        r3 = r0.gcr;
        r5 = java.lang.Integer.valueOf(r8);
        r3.put(r5, r12);
        if (r6 != 0) goto L_0x0018;
    L_0x0184:
        if (r2 != 0) goto L_0x0018;
    L_0x0186:
        r2 = new com.tencent.mm.plugin.appbrand.jsapi.o.c$c;
        r2.<init>();
        r0 = r18;
        r0.a(r12, r2, r11);
        goto L_0x0018;
    L_0x0192:
        r2 = 0;
        r3 = r2;
    L_0x0194:
        r2 = r20.getPointerCount();
        if (r3 >= r2) goto L_0x024c;
    L_0x019a:
        r0 = r20;
        r5 = r0.getX(r3);
        r0 = r20;
        r6 = r0.getY(r3);
        r0 = r20;
        r2 = r0.getPointerId(r3);
        r0 = r18;
        r7 = r0.gcr;
        r2 = java.lang.Integer.valueOf(r2);
        r2 = r7.get(r2);
        r2 = (com.tencent.mm.plugin.appbrand.jsapi.o.c$f) r2;
        if (r2 == 0) goto L_0x0247;
    L_0x01bc:
        r7 = r2.x;
        r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r5 != 0) goto L_0x01c8;
    L_0x01c2:
        r2 = r2.y;
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x0247;
    L_0x01c8:
        r2 = 1;
    L_0x01c9:
        if (r2 == 0) goto L_0x0018;
    L_0x01cb:
        r0 = r18;
        r2 = r0.gcr;
        r2 = r2.size();
        r3 = 1;
        if (r2 != r3) goto L_0x0216;
    L_0x01d6:
        r0 = r18;
        r2 = r0.gcs;
        if (r2 == 0) goto L_0x0216;
    L_0x01dc:
        r0 = r18;
        r2 = r0.gcA;
        r2 = r2.x;
        r0 = r18;
        r3 = r0.gcB;
        r3 = r3.x;
        r2 = r2 - r3;
        r2 = java.lang.Math.abs(r2);
        r0 = r18;
        r3 = r0.gcx;
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r2 > 0) goto L_0x020e;
    L_0x01f5:
        r0 = r18;
        r2 = r0.gcA;
        r2 = r2.y;
        r0 = r18;
        r3 = r0.gcB;
        r3 = r3.y;
        r2 = r2 - r3;
        r2 = java.lang.Math.abs(r2);
        r0 = r18;
        r3 = r0.gcx;
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r2 <= 0) goto L_0x0216;
    L_0x020e:
        r2 = 0;
        r0 = r18;
        r1 = r19;
        r0.e(r1, r2);
    L_0x0216:
        r3 = new org.json.JSONObject;
        r3.<init>();
        r5 = new org.json.JSONArray;
        r5.<init>();
        r2 = "data";
        r3.put(r2, r11);	 Catch:{ JSONException -> 0x038a }
        r2 = "touches";
        r3.put(r2, r5);	 Catch:{ JSONException -> 0x038a }
    L_0x022c:
        r0 = r18;
        r1 = r20;
        r6 = r0.y(r1);
        r2 = r6.length;
        if (r2 <= 0) goto L_0x024f;
    L_0x0237:
        r2 = 0;
    L_0x0238:
        r7 = r6.length;
        if (r2 >= r7) goto L_0x024f;
    L_0x023b:
        r7 = r6[r2];
        r7 = r7.tR();
        r5.put(r7);
        r2 = r2 + 1;
        goto L_0x0238;
    L_0x0247:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x0194;
    L_0x024c:
        r2 = 0;
        goto L_0x01c9;
    L_0x024f:
        r0 = r18;
        r2 = r0.gcr;
        r2 = r2.size();
        if (r2 == 0) goto L_0x0018;
    L_0x0259:
        r2 = new com.tencent.mm.plugin.appbrand.jsapi.o.c$d;
        r2.<init>();
        r3 = r3.toString();
        r0 = r18;
        r0.a(r2, r3);
        goto L_0x0018;
    L_0x0269:
        r2 = 1;
        r0 = r19;
        r0.setDuplicateParentStateEnabled(r2);
        goto L_0x00ee;
    L_0x0271:
        gcq = r19;
        r2 = com.tencent.mm.plugin.appbrand.jsapi.o.c.bL(r19);
        r0 = r18;
        r0.gcu = r2;
        r0 = r18;
        r2 = r0.gcA;
        r2.a(r8, r9, r10);
        r2 = r4;
        goto L_0x0108;
    L_0x0285:
        r2 = 0;
        goto L_0x0155;
    L_0x0288:
        r2 = 0;
        goto L_0x0161;
    L_0x028b:
        if (r12 != 0) goto L_0x028f;
    L_0x028d:
        if (r3 == 0) goto L_0x02eb;
    L_0x028f:
        r2 = r19.getParent();
        r3 = 0;
        r2.requestDisallowInterceptTouchEvent(r3);
    L_0x0297:
        r2 = 0;
        gcq = r2;
        r0 = r18;
        r2 = r0.doS;
        r3 = "isTouching";
        r5 = 0;
        r2.w(r3, r5);
        r0 = r18;
        r2 = r0.doS;
        r3 = "disableScroll-nextState";
        r2 = r2.containsKey(r3);
        if (r2 == 0) goto L_0x02c7;
    L_0x02b2:
        r0 = r18;
        r2 = r0.doS;
        r3 = "disableScroll";
        r0 = r18;
        r5 = r0.doS;
        r6 = "disableScroll-nextState";
        r5 = r5.getBoolean(r6, r12);
        r2.w(r3, r5);
    L_0x02c7:
        r0 = r18;
        r2 = r0.gcr;
        r3 = java.lang.Integer.valueOf(r8);
        r2 = r2.remove(r3);
        r2 = (com.tencent.mm.plugin.appbrand.jsapi.o.c$f) r2;
        if (r2 == 0) goto L_0x0018;
    L_0x02d7:
        r3 = 0;
        r0 = r18;
        r1 = r19;
        r0.e(r1, r3);
        r3 = new com.tencent.mm.plugin.appbrand.jsapi.o.c$e;
        r3.<init>();
        r0 = r18;
        r0.a(r2, r3, r11);
        goto L_0x0018;
    L_0x02eb:
        r2 = 0;
        r0 = r19;
        r0.setDuplicateParentStateEnabled(r2);
        goto L_0x0297;
    L_0x02f2:
        r2 = 0;
        gcq = r2;
        r2 = 0;
        r0 = r18;
        r1 = r19;
        r0.e(r1, r2);
        if (r12 != 0) goto L_0x0301;
    L_0x02ff:
        if (r3 == 0) goto L_0x036a;
    L_0x0301:
        r2 = r19.getParent();
        r3 = 0;
        r2.requestDisallowInterceptTouchEvent(r3);
    L_0x0309:
        r0 = r18;
        r2 = r0.doS;
        r3 = "isTouching";
        r5 = 0;
        r2.w(r3, r5);
        r0 = r18;
        r2 = r0.doS;
        r3 = "disableScroll-nextState";
        r2 = r2.containsKey(r3);
        if (r2 == 0) goto L_0x0336;
    L_0x0321:
        r0 = r18;
        r2 = r0.doS;
        r3 = "disableScroll";
        r0 = r18;
        r5 = r0.doS;
        r6 = "disableScroll-nextState";
        r5 = r5.getBoolean(r6, r12);
        r2.w(r3, r5);
    L_0x0336:
        r2 = android.support.v4.view.z.ak(r19);
        if (r2 == 0) goto L_0x037f;
    L_0x033c:
        r3 = new org.json.JSONObject;
        r3.<init>();
        r5 = new org.json.JSONArray;
        r5.<init>();
        r2 = "data";
        r3.put(r2, r11);	 Catch:{ JSONException -> 0x0388 }
        r2 = "touches";
        r3.put(r2, r5);	 Catch:{ JSONException -> 0x0388 }
    L_0x0352:
        r0 = r18;
        r1 = r20;
        r6 = r0.y(r1);
        r2 = 0;
    L_0x035b:
        r7 = r6.length;
        if (r2 >= r7) goto L_0x0371;
    L_0x035e:
        r7 = r6[r2];
        r7 = r7.tR();
        r5.put(r7);
        r2 = r2 + 1;
        goto L_0x035b;
    L_0x036a:
        r2 = 0;
        r0 = r19;
        r0.setDuplicateParentStateEnabled(r2);
        goto L_0x0309;
    L_0x0371:
        r2 = new com.tencent.mm.plugin.appbrand.jsapi.o.c$b;
        r2.<init>();
        r3 = r3.toString();
        r0 = r18;
        r0.a(r2, r3);
    L_0x037f:
        r0 = r18;
        r2 = r0.gcr;
        r2.clear();
        goto L_0x0018;
    L_0x0388:
        r2 = move-exception;
        goto L_0x0352;
    L_0x038a:
        r2 = move-exception;
        goto L_0x022c;
    L_0x038d:
        r2 = r5;
        goto L_0x0177;
    L_0x0390:
        r6 = r2;
        goto L_0x00d3;
    L_0x0393:
        r6 = r2;
        goto L_0x0138;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.o.b$a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private void e(View view, boolean z) {
        this.mView = view;
        this.gcs = z;
        if (!z) {
            this.doS.w("fakeDownEvent", false);
            this.doS.w("onLongClick", false);
            this.mView.removeCallbacks(this.gcv);
            this.gcA.a(-1, 0.0f, 0.0f);
            this.gcy = null;
        }
    }

    private void a(c$f c_f, h hVar, String str) {
        if (c_f != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", str);
                jSONObject.put("touch", c_f.tR());
            } catch (JSONException e) {
            }
            a(hVar, jSONObject.toString());
        }
    }

    private void a(h hVar, String str) {
        h aC = hVar.aC(this.mAppId, this.gcw);
        aC.mData = str;
        aC.ahM();
    }

    private c$f[] y(MotionEvent motionEvent) {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
            c$f c_f = (c$f) this.gcr.get(Integer.valueOf(motionEvent.getPointerId(i2)));
            if (c_f != null) {
                c_f.x = motionEvent.getX(i2);
                c_f.y = motionEvent.getY(i2);
                arrayList.add(c_f);
            }
        }
        c$f[] c_fArr = new c$f[arrayList.size()];
        while (i < arrayList.size()) {
            c_fArr[i] = (c$f) arrayList.get(i);
            i++;
        }
        return c_fArr;
    }
}
