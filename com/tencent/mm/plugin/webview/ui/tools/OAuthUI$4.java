package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

class OAuthUI$4 implements DownloadListener {
    final /* synthetic */ OAuthUI pVZ;

    OAuthUI$4(OAuthUI oAuthUI) {
        this.pVZ = oAuthUI;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        this.pVZ.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }
}
