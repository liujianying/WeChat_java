package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.gn;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.xweb.x5.sdk.d;
import java.util.HashMap;

@a(2)
public class WebViewDownloadWithX5UI extends MMActivity {
    private Context mContext;
    private final com.tencent.mm.plugin.webview.modeltools.a pWN = new com.tencent.mm.plugin.webview.modeltools.a();
    private Button pWy;

    static /* synthetic */ void a(WebViewDownloadWithX5UI webViewDownloadWithX5UI, String str, String str2) {
        int i;
        gn gnVar = new gn();
        gnVar.bPI.url = str;
        gnVar.bPI.bKg = "";
        gnVar.bPI.extInfo = "";
        gnVar.bPI.appId = "";
        com.tencent.mm.sdk.b.a.sFg.m(gnVar);
        h.mEJ.h(14217, new Object[]{"", Integer.valueOf(2), str2, str, Integer.valueOf(1)});
        int tbsVersion = d.getTbsVersion(webViewDownloadWithX5UI);
        if (au.HX()) {
            au.HU();
            String str3 = (String) c.DT().get(274528, "");
            if (TextUtils.isEmpty(str3) || !p.r(webViewDownloadWithX5UI.mController.tml, str3)) {
                i = 0;
            } else {
                x.i("MicroMsg.WebViewDownloadWithX5UI", "use always option PackageName is %s", new Object[]{str3});
                i = 1;
            }
        } else {
            i = 0;
        }
        if (i != 0 || tbsVersion <= 0) {
            com.tencent.mm.plugin.webview.modeltools.a.d(webViewDownloadWithX5UI, str);
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("ChannelID", "com.tencent.mm");
        hashMap.put("PosID", "9");
        x.i("MicroMsg.WebViewDownloadWithX5UI", "startQbOrMiniQBToLoadUrl ret = %b", new Object[]{Boolean.valueOf(d.a(webViewDownloadWithX5UI, str, hashMap, new ValueCallback<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                x.i("MicroMsg.WebViewDownloadWithX5UI", "onReceiveValue Value = %s", new Object[]{(String) obj});
                if ("closeMiniQb".equals((String) obj)) {
                    WebViewDownloadWithX5UI.this.finish();
                }
            }
        }))});
        if (!d.a(webViewDownloadWithX5UI, str, hashMap, /* anonymous class already generated */)) {
            com.tencent.mm.plugin.webview.modeltools.a.d(webViewDownloadWithX5UI, str);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        setMMTitle(getString(R.l.webview_download_ui_title));
        setBackBtn(new 1(this));
        overridePendingTransition(MMFragmentActivity.a.tnC, MMFragmentActivity.a.tnD);
        this.pWy = (Button) findViewById(R.h.download_op_btn);
        ImageView imageView = (ImageView) findViewById(R.h.download_thumb);
        TextView textView = (TextView) findViewById(R.h.download_title);
        String stringExtra = getIntent().getStringExtra("task_url");
        CharSequence stringExtra2 = getIntent().getStringExtra("title");
        long longExtra = getIntent().getLongExtra("task_size", 0);
        String stringExtra3 = getIntent().getStringExtra("page_url");
        x.i("MicroMsg.WebViewDownloadWithX5UI", "onCreate: url=%s,taskSize=%d, thumbUrl=%s", new Object[]{stringExtra, Long.valueOf(longExtra), getIntent().getStringExtra("thumb_url")});
        if (longExtra > 0) {
            String gc = bi.gc(longExtra);
            this.pWy.setText(getString(R.l.webview_download_ui_btn_state_to_download_size, new Object[]{gc}));
        }
        if (au.HX()) {
            com.tencent.mm.ak.a.a Pj = o.Pj();
            com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
            aVar.dXN = R.k.webview_download_thumb_unknown;
            aVar.dXy = true;
            Pj.a(r7, imageView, aVar.Pt());
        } else {
            imageView.setImageResource(R.k.webview_download_thumb_unknown);
        }
        textView.setVisibility(0);
        if (bi.oW(stringExtra2)) {
            textView.setText(getString(R.l.webview_download_ui_downloading_unknown_title));
        } else {
            textView.setText(stringExtra2);
        }
        h.mEJ.h(14217, new Object[]{"", Integer.valueOf(1), stringExtra3, stringExtra, Integer.valueOf(1)});
        this.pWy.setOnClickListener(new 2(this, longExtra, stringExtra, stringExtra3));
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.webview_download_ui;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (com.tencent.mm.plugin.webview.modeltools.a.b(this, i, i2, intent) && -1 == i2) {
            finish();
        }
    }
}
