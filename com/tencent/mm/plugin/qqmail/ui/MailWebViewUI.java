package com.tencent.mm.plugin.qqmail.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.widget.FrameLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.p$a;
import com.tencent.mm.plugin.qqmail.b.p$c;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.Map;

public class MailWebViewUI extends MMActivity {
    private String bxz;
    private ag handler;
    private d iMQ = new d(this);
    private long mea;
    private MMWebView mhH;
    private View mhI;
    private p$a mhJ = new p$a() {
        public final void onSuccess(String str, Map map) {
            MailWebViewUI.this.handler.post(new 1(this, str));
        }

        public final void onError(int i, String str) {
            MailWebViewUI.this.handler.post(new 2(this, str));
        }
    };

    static /* synthetic */ void a(MailWebViewUI mailWebViewUI, String str) {
        if (mailWebViewUI.mhH != null && str != null) {
            if (mailWebViewUI.bxz == null) {
                mailWebViewUI.mhH.loadData(str, "text/html", "utf-8");
                return;
            }
            mailWebViewUI.mhH.loadDataWithBaseURL(mailWebViewUI.bxz, str, "text/html", "utf-8", null);
        }
    }

    static /* synthetic */ void b(MailWebViewUI mailWebViewUI) {
        String stringExtra = mailWebViewUI.getIntent().getStringExtra("uri");
        String[] stringArrayExtra = mailWebViewUI.getIntent().getStringArrayExtra("params");
        Map hashMap = new HashMap();
        for (int i = 0; i < stringArrayExtra.length; i++) {
            int indexOf = stringArrayExtra[i].indexOf("=");
            hashMap.put(stringArrayExtra[i].substring(0, indexOf), stringArrayExtra[i].substring(indexOf + 1));
        }
        mailWebViewUI.bxz = mailWebViewUI.getIntent().getStringExtra("baseurl");
        String aG = bi.aG(mailWebViewUI.getIntent().getStringExtra("method"), "get");
        if (aG == null || aG.length() == 0 || stringExtra == null || stringExtra.length() == 0) {
            x.e("MicroMsg.QQMail.WebViewUI", "doSend invalid argument.");
            return;
        }
        p$c p_c = new p$c();
        p_c.mdm = false;
        p_c.toBundle(new Bundle());
        try {
            if (aG.equals("get")) {
                mailWebViewUI.mea = ((Long) new ReadMailProxy(mailWebViewUI.iMQ, mailWebViewUI.mhJ).REMOTE_CALL("get", new Object[]{stringExtra, hashMap, r5})).longValue();
                return;
            }
            mailWebViewUI.mea = ((Long) new ReadMailProxy(mailWebViewUI.iMQ, mailWebViewUI.mhJ).REMOTE_CALL("post", new Object[]{stringExtra, hashMap, r5})).longValue();
        } catch (Exception e) {
            x.w("MicroMsg.QQMail.WebViewUI", "get/post, method = %s, ex = %s", new Object[]{aG, e.getMessage()});
        }
    }

    static /* synthetic */ void b(MailWebViewUI mailWebViewUI, String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.QQMail.WebViewUI", "dealGetContentWidthScheme fail, url is null");
            return;
        }
        String substring = str.substring(33);
        final int i = bi.getInt(substring, 480);
        x.d("MicroMsg.QQMail.WebViewUI", "getContentWidth:" + substring);
        mailWebViewUI.mhH.post(new Runnable() {
            public final void run() {
                View view = (View) MailWebViewUI.this.mhH.getParent();
                if (view != null) {
                    int width = view.getWidth();
                    if (i > width) {
                        int i = 10;
                        float f = ((float) width) / ((float) i);
                        while (f < MailWebViewUI.this.mhH.getScale()) {
                            i--;
                            if (i > 0) {
                                MailWebViewUI.this.mhH.zoomOut();
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        });
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
        return R.i.qqmail_webview;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.handler = new ag();
        initView();
        String stringExtra = getIntent().getStringExtra("title");
        if (stringExtra != null) {
            setMMTitle(stringExtra);
        }
        this.iMQ.K(new 2(this));
    }

    protected void onStop() {
        this.mhH.stopLoading();
        super.onStop();
    }

    protected void onDestroy() {
        this.mhH.setVisibility(8);
        this.mhH.destroy();
        this.mhH = null;
        this.iMQ.release();
        super.onDestroy();
    }

    protected final void initView() {
        this.mhI = findViewById(R.h.web_navigator);
        if (this.mhI != null) {
            this.mhI.setVisibility(8);
        }
        Boolean valueOf = Boolean.valueOf(getIntent().getBooleanExtra("singleColumn", false));
        this.mhH = a.cS(this.mController.tml);
        this.mhH.setBackgroundDrawable(com.tencent.mm.bp.a.f(this, R.e.navpage));
        ((FrameLayout) findViewById(R.h.container)).addView(this.mhH);
        this.mhH.getSettings().setJavaScriptEnabled(true);
        if (valueOf.booleanValue()) {
            MMWebView mMWebView = this.mhH;
            if (VERSION.SDK_INT >= 8) {
                mMWebView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
            }
        }
        this.mhH.getSettings().cIr();
        this.mhH.getSettings().setSupportZoom(true);
        this.mhH.getSettings().setBuiltInZoomControls(true);
        this.mhH.setWebViewClient(new 3(this));
        this.mhH.setWebChromeClient(new 4(this));
        this.mhH.cAx();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                MailWebViewUI.this.finish();
                return true;
            }
        });
    }
}
