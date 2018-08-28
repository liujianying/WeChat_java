package com.tencent.mm.plugin.appbrand.permission;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.permission.b.3;
import com.tencent.mm.sdk.platformtools.x;

class b$3$1 implements OnClickListener {
    final /* synthetic */ 3 gpZ;

    b$3$1(3 3) {
        this.gpZ = 3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.a(this.gpZ.gpW, this.gpZ.gpY, 1);
        b.amj().put(b.a(this.gpZ.gpW), b.b(this.gpZ.gpW));
        x.i("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user confirm, appId %s, api %s", b.a(this.gpZ.gpW), b.b(this.gpZ.gpW));
        b.c(this.gpZ.gpW).aml();
    }
}
