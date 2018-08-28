package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.widget.i.4;
import com.tencent.mm.sdk.platformtools.x;

class i$4$4 implements Runnable {
    final /* synthetic */ Bundle bAE;
    final /* synthetic */ 4 qkX;

    i$4$4(4 4, Bundle bundle) {
        this.qkX = 4;
        this.bAE = bundle;
    }

    public final void run() {
        boolean z = false;
        byte[] byteArray = this.bAE.getByteArray("jsapi_control_bytes");
        if (byteArray == null || this.qkX.qkV.qhr == null || this.qkX.qkV.qhr.bVR() == null) {
            String str = "MicroMsg.MMWebViewClient";
            String str2 = "has JSAPI_CONTROL_BYTES %b, has wvPerm %b";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(byteArray != null);
            if (this.qkX.qkV.qhr != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.e(str, str2, objArr);
        } else {
            x.i("MicroMsg.MMWebViewClient", "update control bytes by preverify, %d", new Object[]{Integer.valueOf(byteArray.length)});
            this.qkX.qkV.qhr.bVR().qWe = byteArray;
        }
        if (this.qkX.qkV.qfM != null) {
            this.qkX.qkV.qfM.bXS();
        }
    }
}
