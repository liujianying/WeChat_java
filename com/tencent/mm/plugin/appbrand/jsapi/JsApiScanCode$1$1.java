package com.tencent.mm.plugin.appbrand.jsapi;

import android.net.Uri;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode.1;
import com.tencent.mm.sdk.platformtools.bi;
import java.net.URLDecoder;
import java.util.HashMap;

class JsApiScanCode$1$1 implements Runnable {
    final /* synthetic */ JsApiScanCode$GetA8KeyTask fGQ;
    final /* synthetic */ HashMap fGR;
    final /* synthetic */ 1 fGS;

    JsApiScanCode$1$1(1 1, JsApiScanCode$GetA8KeyTask jsApiScanCode$GetA8KeyTask, HashMap hashMap) {
        this.fGS = 1;
        this.fGQ = jsApiScanCode$GetA8KeyTask;
        this.fGR = hashMap;
    }

    public final void run() {
        this.fGQ.ahB();
        if (this.fGQ.actionCode == 26) {
            Uri parse = Uri.parse(this.fGQ.fGU);
            if (this.fGS.fCl.fdO.fcu.bGy.equals(parse.getQueryParameter("username"))) {
                this.fGR.put("path", URLDecoder.decode(bi.oV(parse.getQueryParameter("path"))));
            }
        }
        this.fGS.fCl.E(this.fGS.doP, this.fGS.fGP.f("ok", this.fGR));
    }
}
