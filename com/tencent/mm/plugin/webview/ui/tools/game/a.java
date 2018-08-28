package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi$a;
import com.tencent.mm.plugin.webview.ui.tools.widget.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;

public final class a {
    ViewGroup CK;
    MMWebView dEn;
    String jIl;
    c jJI = new 1(this);
    Context mContext;
    d qcA;
    GameWebViewUI qfK;
    private d qfL;
    com.tencent.mm.plugin.webview.ui.tools.jsapi.d qfM;
    com.tencent.mm.plugin.game.wepkg.a qfN;
    a qfO;
    f qfP;
    k qfQ = new 3(this);

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.a$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String val$url;

        AnonymousClass2(String str) {
            this.val$url = str;
        }

        public final void run() {
            a.this.dEn.setVisibility(8);
            a.this.qfO.RB(this.val$url);
        }
    }

    private class b extends com.tencent.xweb.x5.a.a.a.a.b {
        private b() {
        }

        /* synthetic */ b(a aVar, byte b) {
            this();
        }

        public final Object onMiscCallBack(String str, Bundle bundle) {
            Object onMiscCallBack = a.this.qfN.kdM.onMiscCallBack(str, bundle);
            return onMiscCallBack != null ? onMiscCallBack : super.onMiscCallBack(str, bundle);
        }
    }

    public a(GameWebViewUI gameWebViewUI, ViewGroup viewGroup) {
        this.mContext = gameWebViewUI;
        this.qfK = gameWebViewUI;
        this.CK = viewGroup;
        MMWebViewWithJsApi eC = MMWebViewWithJsApi$a.eC(this.mContext);
        eC.setBackgroundResource(17170445);
        eC.setBackgroundColor(0);
        eC.setVisibility(4);
        this.qfO = new a(this, eC);
        eC.setWebViewClient(this.qfO);
        if (eC.getIsX5Kernel()) {
            eC.setWebViewClientExtension(new b(this, (byte) 0));
        }
        eC.getSettings().setJavaScriptEnabled(true);
        eC.getSettings().cIv();
        eC.getSettings().setBuiltInZoomControls(false);
        eC.getSettings().setUseWideViewPort(true);
        eC.getSettings().setLoadWithOverviewMode(true);
        eC.getSettings().cIq();
        eC.getSettings().cIp();
        eC.getSettings().setGeolocationEnabled(true);
        eC.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        eC.getSettings().cIx();
        eC.getSettings().cIt();
        eC.getSettings().setAppCachePath(this.mContext.getDir("webviewcache", 0).getAbsolutePath());
        eC.getSettings().cIs();
        eC.getSettings().cIu();
        eC.getSettings().setDatabasePath(e.duM + "databases/");
        com.tencent.xweb.b.cIi().cIj();
        com.tencent.xweb.b.cIi().c(eC);
        this.dEn = eC;
        this.qfL = new d(gameWebViewUI.getIntent());
        this.qfN = new com.tencent.mm.plugin.game.wepkg.a(gameWebViewUI, this.dEn, this.dEn.hashCode());
    }

    final int cA(String str, int i) {
        if (i == 0) {
            if (str == null || str.length() <= 0) {
                i = 0;
            } else if (this.qcA == null) {
                i = 1;
            } else {
                try {
                    i = this.qcA.hO(str) ? 8 : this.qcA.hf(str) ? 7 : 1;
                } catch (Exception e) {
                    x.e("MicroMsg.GameFloatWebView", "getScene fail, ex = " + e.getMessage());
                    i = 1;
                }
            }
        }
        x.i("MicroMsg.GameFloatWebView", "KGetA8KeyScene = %s", new Object[]{Integer.valueOf(i)});
        return i;
    }

    public final void onDestroy() {
        c.a(this.jJI.qfW.qfX);
    }
}
