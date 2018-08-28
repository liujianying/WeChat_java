package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.mm.plugin.appbrand.jsapi.n;

public final class d extends n {
    public static final int CTRL_INDEX = 436;
    public static final String NAME = "measureText";

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(com.tencent.mm.plugin.appbrand.l r12, org.json.JSONObject r13) {
        /*
        r11 = this;
        r10 = 0;
        r0 = -1;
        r4 = 2;
        r2 = 1;
        r1 = 0;
        if (r13 != 0) goto L_0x0018;
    L_0x0007:
        r0 = "MicroMsg.JsApiMeasureText";
        r1 = "measureText, data is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = "fail:data is null";
        r0 = r11.f(r0, r10);
    L_0x0017:
        return r0;
    L_0x0018:
        r3 = "text";
        r5 = r13.optString(r3);
        r3 = "fontSize";
        r6 = 4625196817309499392; // 0x4030000000000000 float:0.0 double:16.0;
        r6 = r13.optDouble(r3, r6);
        r3 = (float) r6;
        r6 = "MicroMsg.JsApiMeasureText";
        r7 = "measureText data:%s";
        r8 = new java.lang.Object[r2];
        r9 = r13.toString();
        r8[r1] = r9;
        com.tencent.mm.sdk.platformtools.x.i(r6, r7, r8);
        r6 = android.text.TextUtils.isEmpty(r5);
        if (r6 != 0) goto L_0x0045;
    L_0x0040:
        r6 = 0;
        r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1));
        if (r6 > 0) goto L_0x0056;
    L_0x0045:
        r0 = "MicroMsg.JsApiMeasureText";
        r1 = "measureText, param is illegal";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = "fail:param is illegal";
        r0 = r11.f(r0, r10);
        goto L_0x0017;
    L_0x0056:
        r6 = new com.tencent.mm.plugin.appbrand.canvas.b.a;
        r6.<init>();
        r3 = com.tencent.mm.plugin.appbrand.q.f.ae(r3);
        r6.setTextSize(r3);
        r3 = "fontFamily";
        r3 = r13.getString(r3);	 Catch:{ JSONException -> 0x0104 }
        r6.rp(r3);	 Catch:{ JSONException -> 0x0104 }
    L_0x006c:
        r3 = "fontStyle";
        r3 = r13.getString(r3);	 Catch:{ JSONException -> 0x013a }
        r7 = r3.hashCode();	 Catch:{ JSONException -> 0x013a }
        switch(r7) {
            case -1657669071: goto L_0x0110;
            case -1178781136: goto L_0x011c;
            case -1039745817: goto L_0x0128;
            default: goto L_0x007a;
        };
    L_0x007a:
        r3 = r0;
    L_0x007b:
        switch(r3) {
            case 0: goto L_0x0134;
            case 1: goto L_0x0146;
            case 2: goto L_0x014c;
            default: goto L_0x007e;
        };
    L_0x007e:
        r3 = "fontWeight";
        r3 = r13.getString(r3);	 Catch:{ JSONException -> 0x0170 }
        r7 = r3.hashCode();	 Catch:{ JSONException -> 0x0170 }
        switch(r7) {
            case -1039745817: goto L_0x015e;
            case 3029637: goto L_0x0152;
            default: goto L_0x008c;
        };
    L_0x008c:
        switch(r0) {
            case 0: goto L_0x016a;
            case 1: goto L_0x017c;
            default: goto L_0x008f;
        };
    L_0x008f:
        r0 = r6.measureText(r5);
        r3 = r6.getFontMetrics();
        r5 = r3.bottom;
        r6 = r3.top;
        r5 = r5 - r6;
        r5 = java.lang.Math.abs(r5);
        r6 = "MicroMsg.JsApiMeasureText";
        r7 = "fontMetrics.bottom : %f, fontMetrics.top : %f, width : %f, height : %f";
        r8 = 4;
        r8 = new java.lang.Object[r8];
        r9 = r3.bottom;
        r9 = java.lang.Float.valueOf(r9);
        r8[r1] = r9;
        r3 = r3.top;
        r3 = java.lang.Float.valueOf(r3);
        r8[r2] = r3;
        r3 = java.lang.Float.valueOf(r0);
        r8[r4] = r3;
        r3 = 3;
        r4 = java.lang.Float.valueOf(r5);
        r8[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r6, r7, r8);
        r0 = com.tencent.mm.plugin.appbrand.q.f.ad(r0);
        r3 = com.tencent.mm.plugin.appbrand.q.f.ad(r5);
        r4 = new java.util.HashMap;
        r4.<init>();
        r5 = "width";
        r0 = java.lang.Float.valueOf(r0);
        r4.put(r5, r0);
        r0 = "height";
        r3 = java.lang.Float.valueOf(r3);
        r4.put(r0, r3);
        r0 = "MicroMsg.JsApiMeasureText";
        r3 = "map:%s";
        r2 = new java.lang.Object[r2];
        r5 = r4.toString();
        r2[r1] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r0, r3, r2);
        r0 = "ok";
        r0 = r11.f(r0, r4);
        goto L_0x0017;
    L_0x0104:
        r3 = move-exception;
        r3 = "MicroMsg.JsApiMeasureText";
        r7 = "get 'fontFamily' error";
        com.tencent.mm.sdk.platformtools.x.i(r3, r7);
        goto L_0x006c;
    L_0x0110:
        r7 = "oblique";
        r3 = r3.equals(r7);	 Catch:{ JSONException -> 0x013a }
        if (r3 == 0) goto L_0x007a;
    L_0x0119:
        r3 = r1;
        goto L_0x007b;
    L_0x011c:
        r7 = "italic";
        r3 = r3.equals(r7);	 Catch:{ JSONException -> 0x013a }
        if (r3 == 0) goto L_0x007a;
    L_0x0125:
        r3 = r2;
        goto L_0x007b;
    L_0x0128:
        r7 = "normal";
        r3 = r3.equals(r7);	 Catch:{ JSONException -> 0x013a }
        if (r3 == 0) goto L_0x007a;
    L_0x0131:
        r3 = r4;
        goto L_0x007b;
    L_0x0134:
        r3 = 2;
        r6.jN(r3);	 Catch:{ JSONException -> 0x013a }
        goto L_0x007e;
    L_0x013a:
        r3 = move-exception;
        r3 = "MicroMsg.JsApiMeasureText";
        r7 = "get 'fontStyle' error.";
        com.tencent.mm.sdk.platformtools.x.i(r3, r7);
        goto L_0x007e;
    L_0x0146:
        r3 = 2;
        r6.jN(r3);	 Catch:{ JSONException -> 0x013a }
        goto L_0x007e;
    L_0x014c:
        r3 = 0;
        r6.jN(r3);	 Catch:{ JSONException -> 0x013a }
        goto L_0x007e;
    L_0x0152:
        r7 = "bold";
        r3 = r3.equals(r7);	 Catch:{ JSONException -> 0x0170 }
        if (r3 == 0) goto L_0x008c;
    L_0x015b:
        r0 = r1;
        goto L_0x008c;
    L_0x015e:
        r7 = "normal";
        r3 = r3.equals(r7);	 Catch:{ JSONException -> 0x0170 }
        if (r3 == 0) goto L_0x008c;
    L_0x0167:
        r0 = r2;
        goto L_0x008c;
    L_0x016a:
        r0 = 1;
        r6.setFakeBoldText(r0);	 Catch:{ JSONException -> 0x0170 }
        goto L_0x008f;
    L_0x0170:
        r0 = move-exception;
        r0 = "MicroMsg.JsApiMeasureText";
        r3 = "get 'fontWeight' error.";
        com.tencent.mm.sdk.platformtools.x.i(r0, r3);
        goto L_0x008f;
    L_0x017c:
        r0 = 0;
        r6.setFakeBoldText(r0);	 Catch:{ JSONException -> 0x0170 }
        goto L_0x008f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.b.d.a(com.tencent.mm.plugin.appbrand.l, org.json.JSONObject):java.lang.String");
    }
}
