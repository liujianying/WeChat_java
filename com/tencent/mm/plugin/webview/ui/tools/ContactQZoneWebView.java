package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class ContactQZoneWebView extends WebViewUI {
    private String lRt = "";
    private boolean pVm = false;
    private String pVn = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(getString(R.l.contact_info_qq_view_qzone));
        this.mhH.setWebViewClient(new 1(this));
        this.mhH.loadUrl(this.cbP);
        x.d("MicroMsg.ContactQZoneWebView", "loadUrl:loadUrl, url = " + this.cbP);
    }

    protected void onResume() {
        super.onResume();
        this.pVm = false;
    }

    final void Ra(String str) {
        if (!this.pVm) {
            this.pVm = true;
            String substring = str.substring(19);
            x.d("MicroMsg.ContactQZoneWebView", "get url :" + substring);
            Intent intent = new Intent();
            intent.putExtra("nowUrl", substring);
            intent.putExtra("tweetid", bi.oV(getIntent().getStringExtra("tweetid")));
            intent.putExtra("htmlData", this.pVn);
            intent.putExtra("type", getIntent().getIntExtra("type", 0));
            Bundle bundle = new Bundle();
            bundle.putInt("stat_scene", 4);
            bundle.putString("stat_url", getCurrentURL());
            intent.putExtra("_stat_obj", bundle);
            startActivity(intent);
            a.ezn.r(intent, this);
        }
    }
}
