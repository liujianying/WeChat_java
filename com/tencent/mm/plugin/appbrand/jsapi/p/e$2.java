package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class e$2 implements OnCancelListener {
    final /* synthetic */ e gdb;

    e$2(e eVar) {
        this.gdb = eVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.gdb.gcU != null && e.h(this.gdb) != null) {
            try {
                e.h(this.gdb).QX(this.gdb.gcU.pUp);
                this.gdb.gcU.bVc();
            } catch (Exception e) {
                x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "cancel capture failed");
            }
        }
    }
}
