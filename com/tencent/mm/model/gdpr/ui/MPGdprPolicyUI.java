package com.tencent.mm.model.gdpr.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.o.a.b;
import com.tencent.mm.plugin.webview.ui.tools.widget.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.n;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Locale;

@a(1)
public class MPGdprPolicyUI extends MMActivity {
    private MMFalseProgressBar dEm;
    private MMWebView dEn;
    private com.tencent.mm.model.gdpr.a dEo;
    private String dEp;
    private ResultReceiver dEq;

    protected final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (getIntent() != null) {
                ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra("MPGdprPolicyUI_KEY_RECEIVER");
                this.dEq = resultReceiver;
                if (resultReceiver != null) {
                    this.dEo = com.tencent.mm.model.gdpr.a.iY(getIntent().getStringExtra("MPGdprPolicyUI_KEY_BUSINESS"));
                    if (this.dEo == null) {
                        x.e("MicroMsg.MPGdprPolicyUI", "onCreate get empty business");
                        bw(false);
                        finish();
                        return;
                    }
                    this.dEp = getIntent().getStringExtra("MPGdprPolicyUI_KEY_APPID");
                    return;
                }
            }
            finish();
        } catch (Exception e) {
            x.e("MicroMsg.MPGdprPolicyUI", "onCreate get receiver ex = %s", new Object[]{e});
            finish();
        }
    }

    private void bw(boolean z) {
        if (this.dEq != null) {
            this.dEq.send(z ? 1 : -1, null);
        }
    }

    public void finish() {
        super.finish();
        if (this.dEq != null) {
            bw(false);
            this.dEq = null;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "InlinedApi"})
    protected final void dealContentView(View view) {
        super.dealContentView(view);
        this.dEn = f.a.qkE.cS(this);
        this.dEn.getSettings().cIv();
        this.dEn.getSettings().setJavaScriptEnabled(true);
        this.dEn.getSettings().setMediaPlaybackRequiresUserGesture(false);
        this.dEn.getSettings().cIx();
        this.dEn.getSettings().setUserAgentString(n.aV(this.mController.tml, this.dEn.getSettings().getUserAgentString()) + " miniProgram");
        this.dEn.getView().setHorizontalScrollBarEnabled(false);
        this.dEn.getView().setVerticalScrollBarEnabled(false);
        this.dEn.getSettings().setBuiltInZoomControls(true);
        this.dEn.getSettings().setUseWideViewPort(true);
        this.dEn.getSettings().setLoadWithOverviewMode(true);
        this.dEn.getSettings().cIq();
        this.dEn.getSettings().cIp();
        this.dEn.getSettings().setGeolocationEnabled(true);
        this.dEn.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.dEn.getSettings().cIt();
        this.dEn.getSettings().setAppCachePath(this.mController.tml.getDir("webviewcache", 0).getAbsolutePath());
        this.dEn.getSettings().cIs();
        this.dEn.getSettings().cIu();
        this.dEn.getSettings().setDatabasePath(e.duM + "databases/");
        Bundle bundle = new Bundle(1);
        bundle.putBoolean("KInitialParam_Force_wcPrivacyPolicyResult_DoInService", true);
        this.dEn.setWebViewClient(c.a.qkD.a(this.dEn, new 1(this), bundle));
        this.dEn.setWebChromeClient(com.tencent.mm.plugin.webview.ui.tools.widget.a.a.qkC.a(this.dEn, new 2(this)));
        ((FrameLayout) view).addView(this.dEn, -1, -1);
        this.dEm = new MMFalseProgressBar(this);
        this.dEm.setProgressDrawable(com.tencent.mm.bp.a.f(this, com.tencent.mm.plugin.o.a.a.mm_webview_progress_horizontal));
        ((FrameLayout) view).addView(this.dEm, -1, com.tencent.mm.bp.a.fromDPToPix(this, 3));
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        setBackBtn(new 3(this), b.actionbar_icon_dark_close);
        lF(-1);
        this.dEn.loadUrl(String.format(Locale.US, "https://weixin.qq.com/cgi-bin/newreadtemplate?t=gdpr/confirm&business=%s&lang=%s&cc=%s", new Object[]{this.dEo.dEe, w.fD(this), (String) g.Ei().DT().get(274436, null)}));
    }

    protected void onDestroy() {
        super.onDestroy();
        try {
            this.dEn.destroy();
        } catch (Exception e) {
            x.e("MicroMsg.MPGdprPolicyUI", "destroy WebView e = %s", new Object[]{e});
        } finally {
            this.dEn = null;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.dEn.canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.dEn.goBack();
        return true;
    }
}
