package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.g.a.h;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiAddNativeDownloadTask.AddNativeDownloadTaskTask;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

class JsApiAddNativeDownloadTask$AddNativeDownloadTaskTask$1 extends c<h> {
    final /* synthetic */ AddNativeDownloadTaskTask fFD;

    JsApiAddNativeDownloadTask$AddNativeDownloadTaskTask$1(AddNativeDownloadTaskTask addNativeDownloadTaskTask) {
        this.fFD = addNativeDownloadTaskTask;
        this.sFo = h.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        h hVar = (h) bVar;
        if (!(hVar instanceof h)) {
            x.w("MicroMsg.JsApiAddNativeDownloadTask", "mismatched event");
            return false;
        } else if (hVar.bGk.scene != 1) {
            x.i("MicroMsg.JsApiAddNativeDownloadTask", "not jsapi api callback");
            return false;
        } else {
            if (hVar.bGk.bGl) {
                x.i("MicroMsg.JsApiAddNativeDownloadTask", "AddNativeDownloadTaskTask callback, cancel");
                this.fFD.bWA = 0;
                AddNativeDownloadTaskTask.a(this.fFD);
            } else if (hVar.bGk.bGm > 0) {
                new HashMap().put("download_id", Long.valueOf(hVar.bGk.bGm));
                this.fFD.bGm = hVar.bGk.bGm;
                x.i("MicroMsg.JsApiAddNativeDownloadTask", "AddNativeDownloadTaskTask callback, ok downloadId:%s", new Object[]{Long.valueOf(this.fFD.bGm)});
                this.fFD.bWA = 2;
                AddNativeDownloadTaskTask.b(this.fFD);
            } else {
                x.i("MicroMsg.JsApiAddNativeDownloadTask", "AddNativeDownloadTaskTask callback, failed");
                this.fFD.bWA = 1;
                AddNativeDownloadTaskTask.c(this.fFD);
            }
            a.sFg.c(AddNativeDownloadTaskTask.d(this.fFD));
            return true;
        }
    }
}
