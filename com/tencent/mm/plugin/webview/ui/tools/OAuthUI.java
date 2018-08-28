package com.tencent.mm.plugin.webview.ui.tools;

import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.plugin.webview.stub.c;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.i;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.xweb.WebView;
import com.tencent.xweb.j;

public class OAuthUI extends WebViewUI {
    private String appId;
    private boolean kUd = false;
    private boolean pVV = true;
    private Req pVW;
    private c pVX;
    private al pVY;

    static /* synthetic */ void a(OAuthUI oAuthUI, String str) {
        String QR;
        Exception e;
        String str2 = null;
        x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, url = " + str);
        if (!bi.oW(str)) {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                oAuthUI.mhH.loadUrl(str);
                return;
            }
            String bVr;
            x.i("MicroMsg.OAuthUI", "check schema as appId:" + oAuthUI.appId);
            try {
                QR = oAuthUI.gcO.QR(oAuthUI.appId);
                try {
                    bVr = oAuthUI.gcO.bVr();
                    try {
                        str2 = oAuthUI.gcO.aU(274436, null);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    bVr = str2;
                }
            } catch (Exception e4) {
                e = e4;
                bVr = str2;
                QR = str2;
            }
            if (bi.oW(QR)) {
                x.e("MicroMsg.OAuthUI", "find app info failed, appid=" + oAuthUI.appId);
                oAuthUI.mhH.loadUrl(str);
            } else if (str.toLowerCase().startsWith("http")) {
                x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, http scheme, loadUrl");
                oAuthUI.mhH.loadUrl(str);
            } else if (oAuthUI.kUd) {
                x.e("MicroMsg.OAuthUI", "checkUrlAndLoad has callback, ignore this callback");
            } else {
                oAuthUI.kUd = true;
                Resp resp = new Resp();
                resp.transaction = oAuthUI.pVW.transaction;
                resp.lang = bVr;
                resp.country = str2;
                str2 = parse.getQueryParameter("code");
                x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code = " + str2);
                if (bi.oW(str2)) {
                    resp.errCode = -1;
                } else if (str2.toLowerCase().equals("authdeny")) {
                    resp.errCode = -4;
                } else {
                    resp.errCode = 0;
                    resp.code = str2;
                }
                resp.state = parse.getQueryParameter(DownloadInfoColumns.STATE);
                resp.errStr = parse.getQueryParameter("reason");
                resp.url = str;
                x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code=" + resp.code + ", errCode=" + resp.errCode + ", state=" + resp.state + ", reason=" + resp.errStr);
                Bundle bundle = new Bundle();
                resp.toBundle(bundle);
                p.ae(bundle);
                Args args = new Args();
                args.targetPkgName = QR;
                args.bundle = bundle;
                MMessageActV2.send(oAuthUI, args);
                oAuthUI.finish();
            }
        }
        return;
        x.w("MicroMsg.OAuthUI", "getPackageName, ex = " + e.getMessage());
        if (bi.oW(QR)) {
            x.e("MicroMsg.OAuthUI", "find app info failed, appid=" + oAuthUI.appId);
            oAuthUI.mhH.loadUrl(str);
        } else if (str.toLowerCase().startsWith("http")) {
            x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, http scheme, loadUrl");
            oAuthUI.mhH.loadUrl(str);
        } else if (oAuthUI.kUd) {
            x.e("MicroMsg.OAuthUI", "checkUrlAndLoad has callback, ignore this callback");
        } else {
            oAuthUI.kUd = true;
            Resp resp2 = new Resp();
            resp2.transaction = oAuthUI.pVW.transaction;
            resp2.lang = bVr;
            resp2.country = str2;
            str2 = parse.getQueryParameter("code");
            x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code = " + str2);
            if (bi.oW(str2)) {
                resp2.errCode = -1;
            } else if (str2.toLowerCase().equals("authdeny")) {
                resp2.errCode = -4;
            } else {
                resp2.errCode = 0;
                resp2.code = str2;
            }
            resp2.state = parse.getQueryParameter(DownloadInfoColumns.STATE);
            resp2.errStr = parse.getQueryParameter("reason");
            resp2.url = str;
            x.i("MicroMsg.OAuthUI", "checkUrlAndLoad, code=" + resp2.code + ", errCode=" + resp2.errCode + ", state=" + resp2.state + ", reason=" + resp2.errStr);
            Bundle bundle2 = new Bundle();
            resp2.toBundle(bundle2);
            p.ae(bundle2);
            Args args2 = new Args();
            args2.targetPkgName = QR;
            args2.bundle = bundle2;
            MMessageActV2.send(oAuthUI, args2);
            oAuthUI.finish();
        }
    }

    static /* synthetic */ void a(OAuthUI oAuthUI, String str, String str2, String str3) {
        View inflate = ((ViewStub) oAuthUI.findViewById(R.h.native_oauth)).inflate();
        oAuthUI.setMMTitle(oAuthUI.getString(R.l.wechat_login_title));
        oAuthUI.setMMSubTitle(oAuthUI.getString(R.l.sdk_oauth_login_subtitle));
        oAuthUI.removeOptionMenu(1);
        ImageView imageView = (ImageView) oAuthUI.findViewById(R.h.head_img);
        TextView textView = (TextView) oAuthUI.findViewById(R.h.wording);
        ThreeDotsLoadingView threeDotsLoadingView = (ThreeDotsLoadingView) oAuthUI.findViewById(R.h.loading);
        threeDotsLoadingView.cAG();
        a aVar = new a();
        aVar.dXX = 10.0f;
        aVar.dXN = R.k.native_oauth_default_head_img;
        com.tencent.mm.ak.a.a.Pq().a(str, imageView, aVar.Pt());
        if (bi.oW(str2)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str2);
        }
        oAuthUI.pVY = new al(new 8(oAuthUI, str3, inflate, threeDotsLoadingView), false);
        oAuthUI.pVY.J(1000, 1000);
    }

    static /* synthetic */ void b(OAuthUI oAuthUI, String str) {
        ((ViewStub) oAuthUI.findViewById(R.h.native_oauth_error)).inflate();
        oAuthUI.setMMTitle(oAuthUI.getString(R.l.wechat_login_title));
        oAuthUI.setMMSubTitle(oAuthUI.getString(R.l.sdk_oauth_login_subtitle));
        oAuthUI.removeOptionMenu(1);
        TextView textView = (TextView) oAuthUI.findViewById(R.h.wording);
        if (bi.oW(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
    }

    protected void onResume() {
        super.onResume();
        WebView.enablePlatformNotifications();
    }

    protected void onPause() {
        super.onPause();
        WebView.disablePlatformNotifications();
    }

    protected final int getLayoutId() {
        return R.i.webview_oauth;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.pQY != null) {
            this.pQY.bUv().cbP = "weixin://mark/oauth";
        }
    }

    protected final void ant() {
        boolean aSn;
        super.ant();
        try {
            aSn = this.gcO.aSn();
        } catch (Exception e) {
            x.w("MicroMsg.OAuthUI", "hasSetUin, ex = " + e.getMessage());
            aSn = false;
        }
        if (aSn) {
            this.mhH.setWebChromeClient(new j() {
                public final void d(WebView webView, String str) {
                    super.d(webView, str);
                    OAuthUI.this.setMMTitle(str);
                }
            });
            this.mhH.setWebViewClient(new i() {
                public final boolean Rb(String str) {
                    x.i("MicroMsg.OAuthUI", "mmShouldOverrideUrlLoading, url = " + str);
                    if (!(str.startsWith("weixinping://iframe") || str.startsWith("weixinpreinject://iframe"))) {
                        OAuthUI.a(OAuthUI.this, str);
                    }
                    return true;
                }
            });
            this.mhH.setDownloadListener(new 4(this));
            this.mhH.cAx();
            setBackBtn(new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    OAuthUI.this.bVG();
                    OAuthUI.this.finish();
                    return true;
                }
            });
            addTextOptionMenu(1, getString(R.l.app_retry), new 6(this));
            Bundle extras = getIntent().getExtras();
            String string = extras.getString("_mmessage_content");
            if (bi.oW(string)) {
                x.f("MicroMsg.OAuthUI", "content is null");
                return;
            }
            this.appId = Uri.parse(string).getQueryParameter("appid");
            x.i("MicroMsg.OAuthUI", "initView, appId = " + this.appId);
            try {
                this.gcO.QQ(this.appId);
            } catch (Exception e2) {
                x.w("MicroMsg.OAuthUI", "checkGetAppSetting, ex = " + e2.getMessage());
            }
            this.pVW = new Req(extras);
            try {
                this.pYp.bWJ();
            } catch (Exception e22) {
                x.w("MicroMsg.OAuthUI", "AC_ADD_SCENE_END, ex = " + e22.getMessage());
            }
            bVI();
            return;
        }
        x.e("MicroMsg.OAuthUI", "start, hasSetUin fail");
        Toast.makeText(this, R.l.account_not_login, 1).show();
        setBackBtn(new 1(this));
        enableOptionMenu(false);
    }

    protected void onStop() {
        this.mhH.stopLoading();
        super.onStop();
    }

    protected void onDestroy() {
        try {
            this.pYp.bWK();
        } catch (Exception e) {
            x.w("MicroMsg.OAuthUI", "AC_REMOVE_SCENE_END, ex = " + e.getMessage());
        }
        if (this.pVY != null) {
            this.pVY.SO();
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.pVV && i == 4 && this.mhH.canGoBack()) {
            this.mhH.goBack();
            return true;
        } else if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        } else {
            bVG();
            finish();
            return true;
        }
    }

    private void bVG() {
        String QR;
        Exception e;
        String str = null;
        x.i("MicroMsg.OAuthUI", "callbackResultCancel, appId = " + this.appId);
        if (this.kUd) {
            x.e("MicroMsg.OAuthUI", "has callback, ignore this callback");
            return;
        }
        String bVr;
        this.kUd = true;
        try {
            QR = this.gcO.QR(this.appId);
            try {
                bVr = this.gcO.bVr();
                try {
                    str = this.gcO.aU(274436, null);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                bVr = str;
            }
        } catch (Exception e4) {
            e = e4;
            bVr = str;
            QR = str;
        }
        if (bi.oW(QR)) {
            Resp resp = new Resp();
            resp.transaction = this.pVW.transaction;
            resp.errCode = -2;
            resp.lang = bVr;
            resp.country = str;
            Bundle bundle = new Bundle();
            resp.toBundle(bundle);
            p.ae(bundle);
            Args args = new Args();
            args.targetPkgName = QR;
            args.bundle = bundle;
            MMessageActV2.send(this, args);
            return;
        }
        x.e("MicroMsg.OAuthUI", "callbackResultCancel, get app info failed, appid=" + this.appId);
        x.w("MicroMsg.OAuthUI", "getPackageName, ex = " + e.getMessage());
        if (bi.oW(QR)) {
            Resp resp2 = new Resp();
            resp2.transaction = this.pVW.transaction;
            resp2.errCode = -2;
            resp2.lang = bVr;
            resp2.country = str;
            Bundle bundle2 = new Bundle();
            resp2.toBundle(bundle2);
            p.ae(bundle2);
            Args args2 = new Args();
            args2.targetPkgName = QR;
            args2.bundle = bundle2;
            MMessageActV2.send(this, args2);
            return;
        }
        x.e("MicroMsg.OAuthUI", "callbackResultCancel, get app info failed, appid=" + this.appId);
    }

    protected final boolean bVH() {
        return true;
    }

    protected final void initView() {
        super.initView();
        this.mhH.getSettings().setJavaScriptEnabled(true);
        this.mhH.setVerticalScrollBarEnabled(false);
    }

    private void bVI() {
        w.d(getSharedPreferences(ad.chY(), 0));
        this.pVX = c.a(this, this.appId, this.pVW, new 7(this), this.gcO);
    }

    public final void b(c cVar) {
        c cVar2;
        int bVj;
        int bVk;
        String string;
        int i;
        Exception e;
        boolean z;
        c.a aVar;
        c cVar3;
        boolean z2 = true;
        if (this.pVX != null) {
            cVar2 = this.pVX;
            if (cVar2.pVQ) {
                String string2;
                String string3;
                try {
                    bVj = cVar.bVj();
                    try {
                        bVk = cVar.bVk();
                        try {
                            cVar.LG();
                            string = cVar.getData().getString("geta8key_result_full_url");
                            try {
                                string2 = cVar.getData().getString("geta8key_result_head_img");
                                try {
                                    string3 = cVar.getData().getString("geta8key_result_wording");
                                    try {
                                        i = cVar.getData().getInt("geta8key_result_action_code", -1);
                                    } catch (Exception e2) {
                                        e = e2;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    string3 = null;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                string3 = null;
                                string2 = null;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            string3 = null;
                            string2 = null;
                            string = null;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        string3 = null;
                        string2 = null;
                        string = null;
                        bVk = -1;
                    }
                } catch (Exception e7) {
                    e = e7;
                    string3 = null;
                    string2 = null;
                    string = null;
                    bVk = -1;
                    bVj = -1;
                }
                x.i("MicroMsg.OAuthSession", "onSceneEnd, errType = " + bVj + ", errCode = " + bVk + " , actionCode=" + i);
                if (cVar2.jnR != null) {
                    cVar2.jnR.dismiss();
                }
                cVar2.pVP = false;
                cVar2.dHa.SO();
                if ((bVk == 0 || bVj != 0) && bVk != -2033) {
                    if (bVj == 4 || bVk != -100) {
                        if (bVj != 1 || bVj == 2 || bVj == 7 || bVj == 8) {
                            x.e("MicroMsg.OAuthSession", "isNetworkAvailable false, errType = " + bVj);
                            z = false;
                        } else if (ao.isConnected(cVar2.pVS)) {
                            z = true;
                        } else {
                            x.e("MicroMsg.OAuthSession", "isNetworkAvailable false, not connected");
                            z = false;
                        }
                        if (z) {
                            aVar = cVar2.pVR;
                            string = null;
                            cVar3 = cVar2;
                        } else {
                            c.a aVar2 = cVar2.pVR;
                            if (bVk == -1) {
                                cVar3 = cVar2;
                                aVar = aVar2;
                            } else {
                                z2 = false;
                                cVar3 = cVar2;
                                aVar = aVar2;
                            }
                        }
                        aVar.a(cVar3, string, z2);
                    }
                    cVar2.pVS.M(true, true);
                    try {
                        cVar2.gcO.ab(bVj, bVk, cVar2.hashCode());
                        return;
                    } catch (Exception e8) {
                        x.w("MicroMsg.OAuthSession", "accountExpired, ex = " + e8.getMessage());
                        return;
                    }
                } else if (i == 27) {
                    cVar2.pVQ = false;
                    cVar2.pVR.c(bVk == 0, string, string2, string3);
                    return;
                } else {
                    cVar2.pVR.a(cVar2, string, false);
                    return;
                }
            }
            x.w("MicroMsg.OAuthSession", "onScenEnd, not listening");
            return;
        }
        return;
        x.e("MicroMsg.OAuthSession", "onSceneEnd, ex = " + e8.getMessage());
        i = -1;
        x.i("MicroMsg.OAuthSession", "onSceneEnd, errType = " + bVj + ", errCode = " + bVk + " , actionCode=" + i);
        if (cVar2.jnR != null) {
            cVar2.jnR.dismiss();
        }
        cVar2.pVP = false;
        cVar2.dHa.SO();
        if (bVk == 0) {
        }
        if (bVj == 4) {
        }
        if (bVj != 1) {
        }
        x.e("MicroMsg.OAuthSession", "isNetworkAvailable false, errType = " + bVj);
        z = false;
        if (z) {
            c.a aVar22 = cVar2.pVR;
            if (bVk == -1) {
                cVar3 = cVar2;
                aVar = aVar22;
            } else {
                z2 = false;
                cVar3 = cVar2;
                aVar = aVar22;
            }
        } else {
            aVar = cVar2.pVR;
            string = null;
            cVar3 = cVar2;
        }
        aVar.a(cVar3, string, z2);
    }
}
