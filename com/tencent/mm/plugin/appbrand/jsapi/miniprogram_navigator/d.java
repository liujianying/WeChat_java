package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.plugin.appbrand.jsapi.a;

public final class d extends a {
    public static final int CTRL_INDEX = 251;
    public static final String NAME = "navigateToMiniProgram";

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.c r12, org.json.JSONObject r13, int r14) {
        /*
        r11 = this;
        r8 = 2;
        r4 = 1;
        r2 = 0;
        r7 = 0;
        r0 = "appId";
        r1 = r13.optString(r0, r2);
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r0 == 0) goto L_0x001c;
    L_0x0011:
        r0 = "fail:invalid data";
        r0 = r11.f(r0, r2);
        r12.E(r14, r0);
    L_0x001b:
        return;
    L_0x001c:
        r0 = r12.getAppId();
        r0 = r1.equals(r0);
        if (r0 == 0) goto L_0x0031;
    L_0x0026:
        r0 = "fail:target appId is the same as the caller appId";
        r0 = r11.f(r0, r2);
        r12.E(r14, r0);
        goto L_0x001b;
    L_0x0031:
        r0 = "path";
        r3 = r13.optString(r0, r2);
        r0 = "extraData";
        r5 = r13.optJSONObject(r0);
        if (r5 != 0) goto L_0x0046;
    L_0x0041:
        r5 = new org.json.JSONObject;
        r5.<init>();
    L_0x0046:
        r0 = "envVersion";
        r0 = r13.optString(r0);
        r2 = "privateExtraData";
        r6 = r13.optJSONObject(r2);
        if (r6 != 0) goto L_0x005b;
    L_0x0056:
        r6 = new org.json.JSONObject;
        r6.<init>();
    L_0x005b:
        r2 = r12.getRuntime();
        r2 = r2.fcu;
        r2 = r2.frm;
        r9 = r2.fih;
        if (r0 != 0) goto L_0x006a;
    L_0x0067:
        r0 = "";
    L_0x006a:
        r2 = -1;
        r10 = r0.hashCode();
        switch(r10) {
            case 110628630: goto L_0x00cd;
            case 1090594823: goto L_0x00d8;
            case 1559690845: goto L_0x00c2;
            default: goto L_0x0072;
        };
    L_0x0072:
        r0 = r2;
    L_0x0073:
        switch(r0) {
            case 0: goto L_0x00e3;
            case 1: goto L_0x00e5;
            default: goto L_0x0076;
        };
    L_0x0076:
        r2 = r7;
    L_0x0077:
        if (r9 == r4) goto L_0x007c;
    L_0x0079:
        if (r9 == r8) goto L_0x007c;
    L_0x007b:
        r2 = r7;
    L_0x007c:
        r0 = "sourcetype";
        r0 = r13.optInt(r0, r7);
        r4 = "agentId";
        r8 = r13.optString(r4);
        r4 = new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.e$a;
        r4.<init>();
        r9 = "scene";
        r9 = r13.optInt(r9, r7);
        r4.scene = r9;
        r9 = "sceneNote";
        r9 = r13.optString(r9);
        r4.bGG = r9;
        r9 = "preScene";
        r7 = r13.optInt(r9, r7);
        r4.cbB = r7;
        r7 = "preSceneNote";
        r7 = r13.optString(r7);
        r4.cbC = r7;
        r4.bJt = r0;
        r4.fqH = r8;
        r7 = new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.d$1;
        r7.<init>(r11, r12, r14);
        r0 = r12;
        com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.e.a(r0, r1, r2, r3, r4, r5, r6, r7);
        goto L_0x001b;
    L_0x00c2:
        r10 = "develop";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0072;
    L_0x00cb:
        r0 = r7;
        goto L_0x0073;
    L_0x00cd:
        r10 = "trial";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0072;
    L_0x00d6:
        r0 = r4;
        goto L_0x0073;
    L_0x00d8:
        r10 = "release";
        r0 = r0.equals(r10);
        if (r0 == 0) goto L_0x0072;
    L_0x00e1:
        r0 = r8;
        goto L_0x0073;
    L_0x00e3:
        r2 = r4;
        goto L_0x0077;
    L_0x00e5:
        r2 = r8;
        goto L_0x0077;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.d.a(com.tencent.mm.plugin.appbrand.jsapi.c, org.json.JSONObject, int):void");
    }
}
