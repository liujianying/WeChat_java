package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.ab.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.e;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.aom;
import com.tencent.mm.protocal.c.bxq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

class ak$a implements a {
    private String appId;
    private int fFd;
    private d jGq;

    ak$a(d dVar, int i, String str) {
        this.jGq = dVar;
        this.fFd = i;
        this.appId = str;
    }

    public final void a(int i, int i2, String str, b bVar) {
        if (this.jGq != null) {
            if (i == 0 && i2 == 0) {
                aom aom = (aom) bVar.dIE.dIL;
                if (aom == null || aom.rQI == null || aom.rQI.bMH != 0) {
                    tp(com.tencent.mm.plugin.game.gamewebview.a.d.Da("pre_verify_jsapi:fail_" + str));
                    return;
                }
                d dVar = this.jGq;
                String str2 = this.appId;
                if (!(bi.oW(str2) || bi.oW(dVar.getCurrentURL()))) {
                    dVar.jJJ.put(d.Dq(dVar.getCurrentURL()), str2);
                }
                c.d dVar2 = new c.d();
                dVar2.appId = this.appId;
                dVar2.qhi = aom.rQX;
                d dVar3 = this.jGq;
                if (!bi.oW(dVar3.getCurrentURL())) {
                    dVar3.jJK.put(dVar3.getCurrentURL(), dVar2);
                }
                Object obj = aom.rQW;
                JsapiPermissionWrapper jsapiPermissionWrapper = this.jGq.getJsapiPermissionWrapper();
                if (jsapiPermissionWrapper == null) {
                    tp(com.tencent.mm.plugin.game.gamewebview.a.d.Da("pre_verify_jsapi:ok"));
                    return;
                }
                if (!bi.cX(obj)) {
                    Iterator it = obj.iterator();
                    while (it.hasNext()) {
                        bxq bxq = (bxq) it.next();
                        com.tencent.mm.plugin.game.gamewebview.jsapi.c cVar = (com.tencent.mm.plugin.game.gamewebview.jsapi.c) e.aSw().get(bxq.rQC);
                        if (!(cVar == null || jsapiPermissionWrapper.CB(cVar.aSs()) == bxq.state)) {
                            jsapiPermissionWrapper.a(cVar.aSs(), (byte) bxq.state);
                        }
                    }
                }
                tp(com.tencent.mm.plugin.game.gamewebview.a.d.Da("pre_verify_jsapi:ok"));
                return;
            }
            x.e("MicroMsg.GameJsApiPreVerify", "errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            tp(com.tencent.mm.plugin.game.gamewebview.a.d.Da("pre_verify_jsapi:fail_" + str));
        }
    }

    private void tp(String str) {
        this.jGq.E(this.fFd, str);
        this.jGq = null;
        this.appId = null;
    }
}
