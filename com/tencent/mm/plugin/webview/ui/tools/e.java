package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.Map;

public final class e {
    private WebView pVK;
    private Map<String, a> pWV;
    private JsapiPermissionWrapper pWW;
    private GeneralControlWrapper pWX;
    private final JsapiPermissionWrapper pWY = new JsapiPermissionWrapper(2);
    private final GeneralControlWrapper pWZ = GeneralControlWrapper.qVY;
    private int[] pXa;
    private int[] pXb;

    private static class a {
        public JsapiPermissionWrapper pXc;
        public GeneralControlWrapper pXd;

        public a(JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
            this.pXc = jsapiPermissionWrapper;
            this.pXd = generalControlWrapper;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Permission: jsPerm = ");
            stringBuilder.append(this.pXc);
            stringBuilder.append(", genCtrl = ");
            stringBuilder.append(this.pXd);
            return stringBuilder.toString();
        }
    }

    public e(Activity activity, WebView webView) {
        int i;
        this.pWW = (JsapiPermissionWrapper) activity.getIntent().getParcelableExtra("hardcode_jspermission");
        if (af.exh == null || af.exh.length() == 0) {
            x.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission is null");
        } else {
            try {
                i = bi.getInt(af.exh, 0);
                if (i < 0) {
                    x.w("MicroMsg.WebViewPermission", "setHardcodeJsPermission, Test.jsapiPermission wrong");
                } else {
                    this.pWW = new JsapiPermissionWrapper(i);
                    x.i("MicroMsg.WebViewPermission", "setHardcodeJsPermission, hardcodeJsPerm = " + this.pWW);
                }
            } catch (Exception e) {
                x.e("MicroMsg.WebViewPermission", "setHardcodeJsPermission, parse jsapi fail, ex = " + e.getMessage());
                this.pWW = null;
            }
        }
        this.pWX = (GeneralControlWrapper) activity.getIntent().getParcelableExtra("hardcode_general_ctrl");
        if (af.exi == null || af.exi.length() == 0) {
            x.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, Test.generalCtrl is null");
        } else {
            try {
                x.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, permission = %d", new Object[]{Integer.valueOf(bi.getInt(af.exi, 0))});
                yl ylVar = new yl();
                ylVar.rEl = i;
                this.pWX = new GeneralControlWrapper(ylVar);
            } catch (Exception e2) {
                x.e("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl fail, ex = %s", new Object[]{e2.getMessage()});
                this.pWX = null;
            }
            x.i("MicroMsg.WebViewPermission", "setHardcodeGeneralCtrl, hardcodeGenCtrl = " + this.pWX);
        }
        x.i("MicroMsg.WebViewPermission", "edw <init> hardcodeJsPerm = " + this.pWW + ", hardcodeGenCtrl = " + this.pWX);
        this.pVK = webView;
        this.pWV = new HashMap();
        this.pXa = activity.getIntent().getIntArrayExtra("jsapi_blacklist");
        this.pXb = activity.getIntent().getIntArrayExtra("jsapi_whitelist");
        if (!(this.pXa == null || this.pXa.length <= 0 || this.pWW == null)) {
            x.i("MicroMsg.WebViewPermission", "albie: setBlacklist jsapi(%s).", new Object[]{this.pXa});
            this.pWW.q(this.pXa);
        }
        if (this.pXb != null && this.pXb.length > 0 && this.pWW != null) {
            x.i("MicroMsg.WebViewPermission", "albie: setWhitelist jsapi(%s).", new Object[]{this.pXb});
            this.pWW.r(this.pXb);
        }
    }

    public final void b(String str, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        if (bi.oW(str)) {
            x.e("MicroMsg.WebViewPermission", "update fail, url is null");
            return;
        }
        String Dq = Dq(str);
        if (jsapiPermissionWrapper == null) {
            jsapiPermissionWrapper = this.pWY;
        }
        if (generalControlWrapper == null) {
            generalControlWrapper = this.pWZ;
        }
        if (this.pXa != null && this.pXa.length > 0) {
            x.i("MicroMsg.WebViewPermission", "albie: update setBlacklist jsapi(%s).", new Object[]{this.pXa});
            jsapiPermissionWrapper.q(this.pXa);
        }
        if (this.pXb != null && this.pXb.length > 0) {
            x.i("MicroMsg.WebViewPermission", "albie: update setWhitelist jsapi(%s).", new Object[]{this.pXb});
            jsapiPermissionWrapper.r(this.pXb);
        }
        x.i("MicroMsg.WebViewPermission", "edw update, jsPerm = " + jsapiPermissionWrapper + ", genCtrl = " + generalControlWrapper + ", url = " + Dq);
        this.pWV.put(Dq, new a(jsapiPermissionWrapper, generalControlWrapper));
    }

    public final boolean has(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.WebViewPermission", "has fail, url is null");
            return false;
        }
        a aVar = (a) this.pWV.get(Dq(str));
        return (aVar == null || aVar.pXc == this.pWY || aVar.pXd == this.pWZ) ? false : true;
    }

    public final JsapiPermissionWrapper bVR() {
        if (this.pWW != null) {
            x.i("MicroMsg.WebViewPermission", "getJsPerm, return hardcodeJsPerm = " + this.pWW);
            return this.pWW;
        }
        return Rl(this.pVK == null ? null : this.pVK.getUrl());
    }

    public final JsapiPermissionWrapper Rl(String str) {
        if (this.pWW != null) {
            x.i("MicroMsg.WebViewPermission", "getJsPerm, return hardcodeJsPerm = " + this.pWW);
            return this.pWW;
        } else if (bi.oW(str)) {
            x.e("MicroMsg.WebViewPermission", "getJsPerm fail, url = " + str);
            return this.pWY;
        } else {
            String Dq = Dq(str);
            if (this.pWV == null) {
                x.e("MicroMsg.WebViewPermission", "getJsPerm fail, permMap is null");
                return this.pWY;
            }
            a aVar = (a) this.pWV.get(Dq);
            return aVar == null ? this.pWY : aVar.pXc;
        }
    }

    public final GeneralControlWrapper bVS() {
        Object obj = null;
        if (this.pWX != null) {
            x.i("MicroMsg.WebViewPermission", "getGenCtrl, return hardcodeGenCtrl = " + this.pWX);
            return this.pWX;
        }
        String url;
        if (this.pVK != null) {
            url = this.pVK.getUrl();
            if (!bi.oW(url)) {
                String Dq = Dq(url);
                a aVar = (a) this.pWV.get(Dq);
                String str = "MicroMsg.WebViewPermission";
                StringBuilder stringBuilder = new StringBuilder("edw getGenCtrl, genCtrl = ");
                if (aVar != null) {
                    obj = aVar.pXd;
                }
                x.i(str, stringBuilder.append(obj).append(", url = ").append(Dq).toString());
                return aVar == null ? this.pWZ : aVar.pXd;
            }
        } else {
            url = null;
        }
        x.e("MicroMsg.WebViewPermission", "getGenCtrl fail, url = " + url);
        return this.pWZ;
    }

    public final void detach() {
        x.i("MicroMsg.WebViewPermission", "detach");
        this.pWV.clear();
        this.pWV = null;
        this.pVK = null;
    }

    private static String Dq(String str) {
        int indexOf = str.indexOf("#");
        return indexOf < 0 ? str : str.substring(0, indexOf);
    }
}
