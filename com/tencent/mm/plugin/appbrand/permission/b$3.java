package com.tencent.mm.plugin.appbrand.permission;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.widget.c.b;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements Runnable {
    final /* synthetic */ g fel;
    final /* synthetic */ b gpW;
    final /* synthetic */ String gpX;
    final /* synthetic */ String gpY;

    b$3(b bVar, g gVar, String str, String str2) {
        this.gpW = bVar;
        this.fel = gVar;
        this.gpX = str;
        this.gpY = str2;
    }

    public final void run() {
        if (this.fel != null && this.fel.fcz != null) {
            b bVar = new b(this.fel.fcz.getContext());
            bVar.setMessage(this.gpX);
            bVar.a(j.app_brand_jsapi_user_auth_confirm, new 1(this));
            bVar.b(j.app_brand_jsapi_user_auth_deny, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    b.a(b$3.this.gpW, b$3.this.gpY, 2);
                    b.amj().F(b.a(b$3.this.gpW), b.b(b$3.this.gpW));
                    x.i("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user deny, appId %s, api %s", new Object[]{b.a(b$3.this.gpW), b.b(b$3.this.gpW)});
                    b.c(b$3.this.gpW).amm();
                }
            });
            bVar.setOnCancelListener(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    b.amj().F(b.a(b$3.this.gpW), b.b(b$3.this.gpW));
                    x.i("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user cancel, appId %s, api %s", new Object[]{b.a(b$3.this.gpW), b.b(b$3.this.gpW)});
                    b.c(b$3.this.gpW).onCancel();
                }
            });
            this.fel.a(bVar);
        }
    }
}
