package com.tencent.mm.ui.appbrand;

import android.view.View;
import com.tencent.mm.ui.appbrand.a.h;
import com.tencent.mm.ui.base.l;

public class a$c implements h {
    final /* synthetic */ a tre;

    public a$c(a aVar) {
        this.tre = aVar;
    }

    public View cqZ() {
        return null;
    }

    public void a(l lVar) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMMMenuItemSelected(android.view.MenuItem r11, int r12) {
        /*
        r10 = this;
        r4 = 100;
        r9 = 4;
        r0 = 0;
        r1 = 1;
        r2 = r11.getItemId();
        switch(r2) {
            case 2: goto L_0x0016;
            case 3: goto L_0x0020;
            case 4: goto L_0x002a;
            case 5: goto L_0x0033;
            case 6: goto L_0x0061;
            case 7: goto L_0x0090;
            case 8: goto L_0x00eb;
            default: goto L_0x000c;
        };
    L_0x000c:
        if (r0 == 0) goto L_0x0015;
    L_0x000e:
        r0 = r10.tre;
        r0 = r0.gmE;
        r0.bzW();
    L_0x0015:
        return;
    L_0x0016:
        r0 = new com.tencent.mm.ui.appbrand.a$c$1;
        r0.<init>();
        com.tencent.mm.sdk.platformtools.ah.i(r0, r4);
        r0 = r1;
        goto L_0x000c;
    L_0x0020:
        r0 = new com.tencent.mm.ui.appbrand.a$c$2;
        r0.<init>(r10);
        com.tencent.mm.sdk.platformtools.ah.i(r0, r4);
        r0 = r1;
        goto L_0x000c;
    L_0x002a:
        r0 = r10.tre;
        r0 = r0.gmE;
        r0.bzW();
        r0 = r1;
        goto L_0x000c;
    L_0x0033:
        r0 = r10.tre;
        r0 = r0.username;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x0144;
    L_0x003d:
        r0 = r10.tre;
        r0 = r0.context;
        r2 = r10.tre;
        r2 = r2.username;
        com.tencent.mm.ui.appbrand.b.i(r0, r2, r1);
        r0 = r10.tre;
        r0 = r0.gPm;
        if (r0 == 0) goto L_0x0056;
    L_0x004e:
        r0 = r10.tre;
        r2 = 6;
        com.tencent.mm.ui.appbrand.a.a(r0, r2);
        r0 = r1;
        goto L_0x000c;
    L_0x0056:
        r0 = r10.tre;
        r2 = r10.tre;
        r2 = r2.scene;
        r0.eO(r2, r9);
        r0 = r1;
        goto L_0x000c;
    L_0x0061:
        r2 = r10.tre;
        r2 = r2.username;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 != 0) goto L_0x0144;
    L_0x006b:
        r2 = r10.tre;
        r2 = r2.context;
        r3 = r10.tre;
        r3 = r3.username;
        com.tencent.mm.ui.appbrand.b.i(r2, r3, r0);
        r0 = r10.tre;
        r0 = r0.gPm;
        if (r0 == 0) goto L_0x0083;
    L_0x007c:
        r0 = r10.tre;
        com.tencent.mm.ui.appbrand.a.a(r0, r1);
        r0 = r1;
        goto L_0x000c;
    L_0x0083:
        r0 = r10.tre;
        r2 = r10.tre;
        r2 = r2.scene;
        r3 = 2;
        r0.eO(r2, r3);
        r0 = r1;
        goto L_0x000c;
    L_0x0090:
        r2 = r10.tre;
        r3 = r10.tre;
        r3 = r3.context;
        r4 = r10.tre;
        r4 = r4.gvj;
        if (r4 != 0) goto L_0x00a8;
    L_0x009c:
        r0 = "MicroMsg.AppBrandSerivceActionSheet";
        r2 = "exportUrlParams is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r2);
        r0 = r1;
        goto L_0x000c;
    L_0x00a8:
        r5 = "MicroMsg.AppBrandSerivceActionSheet";
        r6 = "exportUrlParams : %s";
        r7 = new java.lang.Object[r1];
        r8 = r4.toString();
        r7[r0] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r5, r6, r7);
        r0 = r4.username;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x00e8;
    L_0x00c1:
        r0 = new android.content.Intent;
        r0.<init>();
        r5 = "key_username";
        r6 = r4.username;
        r0.putExtra(r5, r6);
        r5 = "key_from_scene";
        r0.putExtra(r5, r9);
        r5 = "key_scene_exposed_params";
        r0.putExtra(r5, r4);
        r4 = "appbrand";
        r5 = ".ui.AppBrandProfileUI";
        com.tencent.mm.bg.d.b(r3, r4, r5, r0);
        r0 = r2.scene;
        r2.eO(r0, r1);
    L_0x00e8:
        r0 = r1;
        goto L_0x000c;
    L_0x00eb:
        r2 = r10.tre;
        r3 = new android.content.Intent;
        r3.<init>();
        r0 = r2.gvj;
        r4 = r0.appId;
        r0 = r2.gvj;
        r5 = r0.bVs;
        r0 = r2.gvj;
        r0 = r0.appId;
        r6 = r2.getAppId();
        r0 = r0.equals(r6);
        if (r0 == 0) goto L_0x013f;
    L_0x0108:
        r0 = "";
    L_0x010b:
        r0 = com.tencent.mm.ui.appbrand.a.as(r4, r5, r0);
        r4 = "MicroMsg.AppBrandSerivceActionSheet";
        r5 = new java.lang.StringBuilder;
        r6 = "KRawUrl ";
        r5.<init>(r6);
        r5 = r5.append(r0);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.x.v(r4, r5);
        r4 = "rawUrl";
        r3.putExtra(r4, r0);
        r0 = "forceHideShare";
        r3.putExtra(r0, r1);
        r0 = r2.context;
        r2 = "webview";
        r4 = ".ui.tools.WebViewUI";
        com.tencent.mm.bg.d.b(r0, r2, r4, r3);
        r0 = r1;
        goto L_0x000c;
    L_0x013f:
        r0 = r2.getAppId();
        goto L_0x010b;
    L_0x0144:
        r0 = r1;
        goto L_0x000c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.appbrand.a$c.onMMMenuItemSelected(android.view.MenuItem, int):void");
    }
}
