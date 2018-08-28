package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.gn;
import com.tencent.mm.plugin.downloader.model.b;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader.model.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;

public class WebViewDownloadUI extends MMActivity {
    private long fGL;
    private TextView hXT;
    private l hjE = new 4(this);
    private int icd;
    private Context mContext;
    private a pWA;
    private String pWB;
    private TextView pWC;
    private int pWD;
    private boolean pWr;
    private Button pWy;
    private TextView pWz;

    static /* synthetic */ void a(WebViewDownloadUI webViewDownloadUI, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        gn gnVar = new gn();
        gnVar.bPI.url = str;
        gnVar.bPI.bKg = str2;
        gnVar.bPI.extInfo = str3;
        gnVar.bPI.appId = str4;
        a.sFg.m(gnVar);
        h.mEJ.h(14217, new Object[]{str4, Integer.valueOf(2), str6, str, Integer.valueOf(0)});
        e.a aVar = new e.a();
        aVar.yQ(str);
        aVar.yR(str5);
        aVar.yS(str7);
        aVar.yT(str2);
        aVar.setAppId(str4);
        aVar.cQ(str8);
        aVar.ef(true);
        aVar.ox(webViewDownloadUI.icd);
        aVar.yU(str3);
        long a = d.aCU().a(aVar.ick);
        x.i("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick, lastDownloadId = %d, downloadId=%d", new Object[]{Long.valueOf(webViewDownloadUI.fGL), Long.valueOf(a)});
        webViewDownloadUI.fGL = a;
        com.tencent.mm.g.a.h hVar = new com.tencent.mm.g.a.h();
        hVar.bGk.bGm = a;
        hVar.bGk.bGl = false;
        hVar.bGk.scene = webViewDownloadUI.pWD;
        a.sFg.m(hVar);
        webViewDownloadUI.pWr = true;
        if (a <= 0) {
            Toast.makeText(webViewDownloadUI.mController.tml, webViewDownloadUI.getString(R.l.webview_download_ui_download_failed), 1).show();
            webViewDownloadUI.finish();
            return;
        }
        Toast.makeText(webViewDownloadUI.mController.tml, webViewDownloadUI.getString(R.l.webview_download_ui_btn_state_started), 1).show();
        webViewDownloadUI.a(a.pWL);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        setMMTitle(getString(R.l.webview_download_ui_title));
        setBackBtn(new 1(this));
        overridePendingTransition(MMFragmentActivity.a.tnC, MMFragmentActivity.a.tnD);
        this.pWy = (Button) findViewById(R.h.download_op_btn);
        this.pWz = (TextView) findViewById(R.h.download_cancel_btn);
        TextView textView = (TextView) findViewById(R.h.download_title);
        this.pWC = (TextView) findViewById(R.h.download_size);
        ImageView imageView = (ImageView) findViewById(R.h.download_thumb);
        this.hXT = (TextView) findViewById(R.h.download_tips);
        a(a.pWK);
        String stringExtra = getIntent().getStringExtra("task_name");
        String stringExtra2 = getIntent().getStringExtra("task_url");
        String stringExtra3 = getIntent().getStringExtra("alternative_url");
        long longExtra = getIntent().getLongExtra("task_size", 0);
        String stringExtra4 = getIntent().getStringExtra("file_md5");
        String stringExtra5 = getIntent().getStringExtra("extInfo");
        String stringExtra6 = getIntent().getStringExtra("fileType");
        String stringExtra7 = getIntent().getStringExtra("appid");
        String stringExtra8 = getIntent().getStringExtra("package_name");
        String stringExtra9 = getIntent().getStringExtra("thumb_url");
        CharSequence stringExtra10 = getIntent().getStringExtra("title");
        String stringExtra11 = getIntent().getStringExtra("page_url");
        this.pWD = getIntent().getIntExtra("page_scene", 0);
        h.mEJ.h(14217, new Object[]{stringExtra7, Integer.valueOf(1), stringExtra11, stringExtra2, Integer.valueOf(0)});
        this.icd = bi.getInt(stringExtra6, 1);
        if (bi.oW(stringExtra10)) {
            stringExtra10 = bi.oV(stringExtra);
        }
        if (!bi.oW(stringExtra10)) {
            textView.setText(stringExtra10);
            textView.setVisibility(0);
        }
        if (longExtra > 0) {
            this.pWB = bi.gc(longExtra);
            this.pWC.setText(this.pWB);
            this.pWy.setText(getString(R.l.webview_download_ui_btn_state_to_download_size, new Object[]{this.pWB}));
        }
        com.tencent.mm.ak.a.a Pj = o.Pj();
        c.a aVar = new c.a();
        aVar.dXN = R.k.webview_download_thumb_unknown;
        aVar.dXy = true;
        Pj.a(stringExtra9, imageView, aVar.Pt());
        this.pWy.setOnClickListener(new 2(this, stringExtra2, stringExtra4, stringExtra5, stringExtra7, stringExtra3, stringExtra11, stringExtra, stringExtra8));
        this.pWz.setOnClickListener(new 3(this, stringExtra7, stringExtra11, stringExtra2));
        d.aCU();
        b.a(this.hjE);
    }

    protected void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.WebViewDownloadUI", "onDestroy hasCallback=%b", new Object[]{Boolean.valueOf(this.pWr)});
        if (!this.pWr) {
            com.tencent.mm.g.a.h hVar = new com.tencent.mm.g.a.h();
            hVar.bGk.bGl = true;
            hVar.bGk.scene = this.pWD;
            a.sFg.m(hVar);
            this.pWr = true;
        }
        d.aCU();
        b.b(this.hjE);
    }

    protected final int getLayoutId() {
        return R.i.webview_download_ui;
    }

    private void a(a aVar) {
        x.i("MicroMsg.WebViewDownloadUI", "setDownloadState old=%s new=%s", new Object[]{this.pWA, aVar});
        this.pWA = aVar;
        switch (5.pWJ[this.pWA.ordinal()]) {
            case 1:
                this.pWy.setVisibility(0);
                this.hXT.setVisibility(8);
                this.pWz.setVisibility(8);
                break;
            case 2:
                this.pWy.setVisibility(8);
                this.pWz.setVisibility(0);
                this.hXT.setVisibility(0);
                if (!bi.oW(this.pWB)) {
                    this.pWC.setVisibility(0);
                    return;
                }
                break;
            default:
                return;
        }
        this.pWC.setVisibility(8);
    }
}
