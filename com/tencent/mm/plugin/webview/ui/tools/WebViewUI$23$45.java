package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$23$45 implements Runnable {
    final /* synthetic */ int fyo;
    final /* synthetic */ 23 pZM;
    final /* synthetic */ String pZP;
    final /* synthetic */ Boolean qan;

    WebViewUI$23$45(23 23, String str, int i, Boolean bool) {
        this.pZM = 23;
        this.pZP = str;
        this.fyo = i;
        this.qan = bool;
    }

    public final void run() {
        boolean z = false;
        if (this.pZM.pZJ.pNV != null && this.pZM.pZJ.gcP != null && this.pZM.pZJ.gcP.bVR() != null) {
            this.pZM.pZJ.gcP.bVR();
            JsapiPermissionWrapper.cgl();
            this.pZM.pZJ.pNV.cB(this.pZP, this.fyo);
        } else if (this.pZM.pZJ.pNV == null || !this.qan.booleanValue()) {
            String str = "MicroMsg.WebViewUI";
            String str2 = "something null, %s, %s";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.pZM.pZJ.pNV == null);
            if (this.pZM.pZJ.gcP == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.w(str, str2, objArr);
        } else {
            this.pZM.pZJ.pNV.cB(this.pZP, this.fyo);
        }
    }
}
