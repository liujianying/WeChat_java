package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.GeolocationPermissions.Callback;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$h$1 implements OnClickListener {
    final /* synthetic */ Callback jJY;
    final /* synthetic */ String jJZ;
    final /* synthetic */ h qaH;

    WebViewUI$h$1(h hVar, Callback callback, String str) {
        this.qaH = hVar;
        this.jJY = callback;
        this.jJZ = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt ok, origin = %s");
        this.jJY.invoke(this.jJZ, true, false);
        d.a(this.qaH.pZJ.gcO, 14340, new Object[]{this.qaH.pZJ.cbP, this.qaH.pZJ.getCurrentURL(), Integer.valueOf(this.qaH.pZJ.cfR), this.qaH.pZJ.getIntent().getStringExtra("geta8key_username"), Integer.valueOf(ak.bUp()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
    }
}
