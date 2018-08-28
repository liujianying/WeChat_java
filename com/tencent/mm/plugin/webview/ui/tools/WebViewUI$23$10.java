package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.23;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$23$10 implements Runnable {
    final /* synthetic */ Bundle bAE;
    final /* synthetic */ 23 pZM;

    WebViewUI$23$10(23 23, Bundle bundle) {
        this.pZM = 23;
        this.bAE = bundle;
    }

    public final void run() {
        boolean z = false;
        byte[] byteArray = this.bAE.getByteArray("jsapi_control_bytes");
        if (byteArray == null || this.pZM.pZJ.gcP == null || this.pZM.pZJ.gcP.bVR() == null) {
            String str = "MicroMsg.WebViewUI";
            String str2 = "has JSAPI_CONTROL_BYTES %b, has wvPerm %b";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(byteArray != null);
            if (this.pZM.pZJ.gcP != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.e(str, str2, objArr);
        } else {
            x.i("MicroMsg.WebViewUI", "update control bytes by preverify, %d", new Object[]{Integer.valueOf(byteArray.length)});
            this.pZM.pZJ.gcP.bVR().qWe = byteArray;
        }
        if (this.pZM.pZJ.pNV != null) {
            this.pZM.pZJ.pNV.bXS();
        }
    }
}
