package com.tencent.mm.plugin.webview.ui.tools;

import android.os.RemoteException;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

class WebViewUI$32 implements OnMenuItemClickListener {
    final /* synthetic */ String gdi;
    final /* synthetic */ String gdj;
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$32(WebViewUI webViewUI, String str, String str2) {
        this.pZJ = webViewUI;
        this.gdi = str;
        this.gdj = str2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        try {
            this.pZJ.gcO.h(this.gdi, this.pZJ.getCurrentURL(), WebViewUI.Ru(this.gdj), this.pZJ.gcS, this.pZJ.gcT);
            x.i("MicroMsg.WebViewUI", "onMenuItemClick recognize qbcode");
        } catch (RemoteException e) {
            x.e("MicroMsg.WebViewUI", "recognize qbar result failed");
        }
        return false;
    }
}
