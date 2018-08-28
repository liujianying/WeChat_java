package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import android.util.Log;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.c;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.bxq;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.util.Iterator;
import java.util.LinkedList;

class g$53 extends c {
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;
    final /* synthetic */ String qjr;
    final /* synthetic */ e qjs;

    g$53(g gVar, String str, e eVar, i iVar) {
        this.qiK = gVar;
        this.qjr = str;
        this.qjs = eVar;
        this.qiH = iVar;
    }

    public final void a(a aVar, String str, LinkedList<bxq> linkedList, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("_url", this.qjr);
        try {
            bundle = this.qjs.g(146, bundle);
            if (bundle == null) {
                x.i("MicroMsg.MsgHandler", "getWvPermission(%s) failed, result is null", new Object[]{this.qjr});
                g.a(this.qiK, this.qiH, "pre_verify_jsapi:fail", null);
                return;
            }
            bundle.setClassLoader(g.class.getClassLoader());
            JsapiPermissionWrapper jsapiPermissionWrapper = (JsapiPermissionWrapper) bundle.getParcelable("_permission_wrapper");
            if (jsapiPermissionWrapper == null) {
                x.i("MicroMsg.MsgHandler", "getWvPermission(%s) failed, jsPerm is null", new Object[]{this.qjr});
                g.a(this.qiK, this.qiH, "pre_verify_jsapi:fail", null);
            } else if (aVar != a.qhc || jsapiPermissionWrapper.qWe == null) {
                if (this.qjs != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putByteArray("jsapi_control_bytes", jsapiPermissionWrapper.qWe);
                    try {
                        x.e("MicroMsg.MsgHandler", "doPreVerifyJSAPI fail, update controlBytes with default permission");
                        this.qjs.c(TXLiveConstants.PUSH_EVT_CHANGE_BITRATE, bundle2);
                    } catch (Exception e) {
                        x.e("MicroMsg.MsgHandler", "doPreVerifyJSAPI remote ex, %s", new Object[]{e.getMessage()});
                    }
                }
                if (bi.oW(str)) {
                    g.a(this.qiK, this.qiH, "pre_verify_jsapi:fail", null);
                } else {
                    g.a(this.qiK, this.qiH, "pre_verify_jsapi:fail_" + str, null);
                }
            } else {
                g.b(this.qiK, bi.VE());
                Object obj = null;
                StringBuilder stringBuilder = new StringBuilder();
                if (linkedList != null && linkedList.size() > 0) {
                    stringBuilder.append("[");
                    Iterator it = linkedList.iterator();
                    Object obj2 = null;
                    while (it.hasNext()) {
                        bxq bxq = (bxq) it.next();
                        g Ux = com.tencent.mm.protocal.c.Ux(bi.oV(bxq.rQC));
                        if (Ux == null) {
                            x.i("MicroMsg.MsgHandler", "updateJsApi permission failed, func do not exist(%s, %d)", new Object[]{bxq.rQC, Integer.valueOf(bxq.state)});
                        } else {
                            if (jsapiPermissionWrapper.CB(Ux.cfY()) != bxq.state) {
                                jsapiPermissionWrapper.a(Ux.cfY(), (byte) bxq.state);
                                obj2 = 1;
                                stringBuilder.append(Ux.cfY()).append(":").append(bxq.state).append(",");
                            }
                            obj2 = obj2;
                        }
                    }
                    stringBuilder.append("]");
                    obj = obj2;
                }
                if (!(obj == null || this.qjs == null)) {
                    x.i("MicroMsg.MsgHandler", "updateJsApis permission(%s)", new Object[]{stringBuilder});
                    Bundle bundle3 = new Bundle();
                    bundle3.putByteArray("jsapi_control_bytes", jsapiPermissionWrapper.qWe);
                    try {
                        String str2 = "MicroMsg.MsgHandler";
                        String str3 = "doPreVerifyJSAPI update controlBytes, %d, jsPerm = %s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(jsapiPermissionWrapper.qWe == null ? 0 : jsapiPermissionWrapper.qWe.length);
                        objArr[1] = jsapiPermissionWrapper;
                        x.i(str2, str3, objArr);
                        this.qjs.c(TXLiveConstants.PUSH_EVT_CHANGE_BITRATE, bundle3);
                    } catch (Exception e2) {
                        x.e("MicroMsg.MsgHandler", "doPreVerifyJSAPI remote ex, %s", new Object[]{e2.getMessage()});
                    }
                }
                g.a(this.qiK, this.qiH, "pre_verify_jsapi:ok", null);
            }
        } catch (Throwable e3) {
            x.e("MicroMsg.MsgHandler", "getWvPermission(%s) error, %s", new Object[]{this.qjr, Log.getStackTraceString(e3)});
            g.a(this.qiK, this.qiH, "pre_verify_jsapi:fail", null);
        }
    }

    public final boolean bXP() {
        return this.qhh;
    }
}
