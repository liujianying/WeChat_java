package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.i;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public abstract class PreLoadWebViewUI extends WebViewUI {
    protected String bJK;
    protected String bWr;
    private int pMb = -1;
    boolean qeP;
    CountDownLatch qeQ = new CountDownLatch(bXt() + 2);
    private w qeR;

    protected class a extends i {
        protected a() {
            super(PreLoadWebViewUI.this);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (TextUtils.isEmpty(this.bJK)) {
            this.bJK = getIntent().getStringExtra("sessionId");
            this.bWr = getIntent().getStringExtra("subSessionId");
            if (TextUtils.isEmpty(this.bWr)) {
                this.bWr = this.bJK;
            }
        }
    }

    protected final w bWi() {
        return this.qeR;
    }

    protected final MMWebView bTf() {
        ab abVar;
        Intent intent = getIntent();
        if (intent != null) {
            this.pMb = intent.getIntExtra("key_preload_biz", -1);
            x.i("PreLoadWebViewUI", "getting preloaded  webview, biz %d", new Object[]{Integer.valueOf(this.pMb)});
            abVar = (ab) z.bTc().Aa(this.pMb).ev(this);
        } else {
            abVar = null;
        }
        MMWebView mMWebView = abVar == null ? null : (MMWebView) abVar.pMi;
        this.qeR = abVar == null ? null : abVar.pMj;
        if (mMWebView == null) {
            x.i("PreLoadWebViewUI", "no available preloaded webview");
            this.qeP = false;
            Object rawUrl = getRawUrl();
            boolean z = !TextUtils.isEmpty(rawUrl) ? bi.WU(Uri.parse(rawUrl).getQueryParameter("isOpenPreload")) == 1 : false;
            if (z) {
                h.mEJ.h(15005, new Object[]{Integer.valueOf(this.pMb), Integer.valueOf(4), Integer.valueOf(0)});
            }
            if (this.pMb == 2) {
                return com.tencent.mm.ui.widget.MMWebView.a.cS(this);
            }
            try {
                return af.bTr().bTs() ? com.tencent.mm.ui.widget.MMWebView.a.hf(this) : com.tencent.mm.ui.widget.MMWebView.a.cS(this);
            } catch (Exception e) {
                return com.tencent.mm.ui.widget.MMWebView.a.cS(this);
            }
        }
        x.i("PreLoadWebViewUI", "use preloaded webview ,%s ", new Object[]{mMWebView.toString()});
        this.qeP = true;
        h.mEJ.h(15005, new Object[]{Integer.valueOf(this.pMb), Integer.valueOf(3), Integer.valueOf(0)});
        return mMWebView;
    }

    public void ant() {
        super.ant();
        this.qeQ.countDown();
        if (this.pNV == null || this.pNV.qhq) {
            bXA();
        } else {
            this.pNV.a(new 1(this));
        }
        if (!b.chp()) {
            return;
        }
        if (this.qeP) {
            s.makeText(ad.getContext(), "use preloaded webview(安装coolassist时弹出), sys " + af.bTr().bTs(), 1).show();
        } else {
            s.makeText(ad.getContext(), "no preloaded webview(安装coolassist时弹出), sys " + af.bTr().bTs(), 1).show();
        }
    }

    private void bXA() {
        if (this.qeP) {
            new Thread(new 2(this)).start();
        }
    }

    protected void onResume() {
        super.onResume();
        this.qeQ.countDown();
    }

    protected final boolean bWj() {
        return this.qeP;
    }

    protected final void bWk() {
        this.qeP = false;
    }

    public final Map<String, Object> bXB() {
        Map<String, Object> emptyMap;
        Object rawUrl = getRawUrl();
        if (TextUtils.isEmpty(rawUrl)) {
            emptyMap = Collections.emptyMap();
        } else {
            Map<String, Object> hashMap = new HashMap();
            Uri parse = Uri.parse(rawUrl);
            for (String str : parse.getQueryParameterNames()) {
                hashMap.put(str, parse.getQueryParameter(str));
            }
            emptyMap = hashMap;
        }
        Map bXu = bXu();
        if (bXu != null) {
            emptyMap.putAll(bXu);
        }
        x.i("PreLoadWebViewUI", "buildOnUiInitParams %s", new Object[]{emptyMap.toString()});
        return emptyMap;
    }

    protected Map<String, Object> bXu() {
        return null;
    }

    public int bXt() {
        return 0;
    }

    protected void bXr() {
    }

    protected final void bWB() {
        h.mEJ.h(15005, new Object[]{Integer.valueOf(this.pMb), Integer.valueOf(5), Integer.valueOf(0)});
    }
}
