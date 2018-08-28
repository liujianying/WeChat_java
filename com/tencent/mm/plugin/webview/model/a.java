package com.tencent.mm.plugin.webview.model;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;

public final class a {
    private static String[] pQW = null;

    public static void a(MMWebView mMWebView, d dVar) {
        if (dVar == null) {
            x.e("MicroMsg.AutoPlayLogic", "invoker null");
        } else if (mMWebView == null) {
            x.e("MicroMsg.AutoPlayLogic", "webView null");
        } else {
            String url = mMWebView.getUrl();
            x.i("MicroMsg.AutoPlayLogic", "currentUrl:%s", new Object[]{url});
            if (!bi.oW(url)) {
                if (a(url, dVar)) {
                    a(mMWebView, true);
                    x.i("MicroMsg.AutoPlayLogic", "enableAutoPlay (true)");
                    return;
                }
                a(mMWebView, false);
                x.i("MicroMsg.AutoPlayLogic", "enableAutoPlay (false)");
            }
        }
    }

    private static boolean a(String str, d dVar) {
        if (pQW == null) {
            try {
                Bundle g = dVar.g(100, new Bundle());
                String str2 = null;
                if (g != null) {
                    str2 = g.getString("enable_auto_play_host_paths");
                }
                x.i("MicroMsg.AutoPlayLogic", "autoPlayHostsStr config:%s", new Object[]{str2});
                if (bi.oW(str2)) {
                    str2 = "mp.weixin.qq.com/s;mp.weixin.qq.com/mp/appmsg/show";
                }
                pQW = str2.split(";");
            } catch (RemoteException e) {
                x.w("MicroMsg.AutoPlayLogic", "isOauthHost exp:%s", new Object[]{e.getLocalizedMessage()});
                return false;
            }
        }
        Uri parse = Uri.parse(str);
        String str3 = parse.getAuthority() + parse.getPath();
        for (String startsWith : pQW) {
            if (str3.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    private static void a(MMWebView mMWebView, boolean z) {
        if (mMWebView.getIsX5Kernel()) {
            try {
                new Bundle().putBoolean("require", !z);
                a.a.cJ(mMWebView.getX5WebViewExtension()).y("invokeMiscMethod", new Object[]{"setVideoPlaybackRequiresUserGesture", r3});
                return;
            } catch (Exception e) {
                x.e("MicroMsg.AutoPlayLogic", "enableAutoPlay :%s", new Object[]{e});
                return;
            }
        }
        x.i("MicroMsg.AutoPlayLogic", "not x5 all enable");
        mMWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
    }
}
