package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.os.RemoteException;
import com.tencent.mm.plugin.webview.modeltools.f.c;
import com.tencent.mm.sdk.platformtools.x;

class e$7 implements c {
    final /* synthetic */ e gdb;

    e$7(e eVar) {
        this.gdb = eVar;
    }

    public final void ug(String str) {
        try {
            if (e.h(this.gdb) != null) {
                e.h(this.gdb).c(str, new int[]{5});
                return;
            }
            x.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "viewCaptureCallback, invoker is null");
        } catch (RemoteException e) {
            x.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "recog failed");
        }
    }
}
