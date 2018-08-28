package com.tencent.mm.plugin.freewifi.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Menu;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.freewifi.j;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k$b;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.i;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.s.b;

public class FreeWifiSuccWebViewUI extends WebViewUI implements e {
    private String bPS;
    private String bPg;
    private int bVU;
    private String jkJ;
    private int jnW;
    private String jnX;
    private boolean joj = false;
    private String signature;

    static /* synthetic */ void a(FreeWifiSuccWebViewUI freeWifiSuccWebViewUI) {
        String str = j.userName;
        if (bi.oW(freeWifiSuccWebViewUI.bPg) || !freeWifiSuccWebViewUI.bPg.equals(str)) {
            freeWifiSuccWebViewUI.joj = false;
        } else {
            freeWifiSuccWebViewUI.joj = true;
        }
        if (!(!freeWifiSuccWebViewUI.joj || bi.oW(freeWifiSuccWebViewUI.bPS) || (s.hf(freeWifiSuccWebViewUI.bPg) && s.he(freeWifiSuccWebViewUI.bPg)))) {
            au.DF().a(1703, freeWifiSuccWebViewUI);
            au.DF().a(new i(freeWifiSuccWebViewUI.bPS, freeWifiSuccWebViewUI.getIntent().getStringExtra("free_wifi_ap_key"), freeWifiSuccWebViewUI.getIntent().getIntExtra("free_wifi_channel_id", 0), m.E(freeWifiSuccWebViewUI.getIntent())), 0);
        }
        l.c(d.aOB(), freeWifiSuccWebViewUI.getIntent().getStringExtra("free_wifi_ap_key"), freeWifiSuccWebViewUI.getIntent().getIntExtra("free_wifi_protocol_type", 0), freeWifiSuccWebViewUI.joj);
        WifiInfo aOA = d.aOA();
        a aOa = k.aOa();
        if (aOA != null) {
            str = aOA.getMacAddress();
            if (VERSION.SDK_INT > 22 && (str == null || str.equals("02:00:00:00:00:00"))) {
                str = m.aOf();
            }
            aOa.ssid = m.BQ(aOA.getSSID());
            aOa.bssid = aOA.getBSSID();
            aOa.bIR = str;
        }
        aOa.bIQ = m.I(freeWifiSuccWebViewUI.getIntent());
        aOa.jic = freeWifiSuccWebViewUI.bPS;
        aOa.jid = m.E(freeWifiSuccWebViewUI.getIntent());
        aOa.jie = m.G(freeWifiSuccWebViewUI.getIntent());
        aOa.jif = k$b.QinghuaiBackpageFinished.jiQ;
        aOa.jig = k$b.QinghuaiBackpageFinished.name;
        aOa.bVU = m.H(freeWifiSuccWebViewUI.getIntent());
        aOa.jih = freeWifiSuccWebViewUI.bPg;
        aOa.aOc().aOb();
        String stringExtra = freeWifiSuccWebViewUI.getIntent().getStringExtra("free_wifi_finish_url");
        if (freeWifiSuccWebViewUI.jnW == 1 && !bi.oW(stringExtra)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", Uri.parse(stringExtra).buildUpon().appendQueryParameter("lang", w.d(freeWifiSuccWebViewUI.getSharedPreferences(ad.chY(), 0))).build().toString());
            intent.putExtra("show_bottom", false);
            intent.putExtra("stastic_scene", 7);
            intent.putExtra("neverBlockLocalRequest", true);
            com.tencent.mm.bg.d.b(freeWifiSuccWebViewUI, "webview", ".ui.tools.WebViewUI", intent);
            x.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "jump to ad page after connect wifi success, url is : %s", new Object[]{intent.getStringExtra("rawUrl")});
        } else if (freeWifiSuccWebViewUI.jnW == 3 && !bi.oW(stringExtra)) {
            ((com.tencent.mm.plugin.appbrand.n.e) g.l(com.tencent.mm.plugin.appbrand.n.e.class)).b(freeWifiSuccWebViewUI, stringExtra, 1078, null);
            x.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "jump to wxa after connect wifi success, url is : %s", new Object[]{stringExtra});
        }
    }

    public void onCreate(Bundle bundle) {
        String str;
        j.userName = "";
        j.type = 0;
        x.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "qinghuaiUrl=%s", new Object[]{getIntent().getStringExtra("free_wifi_qinghuai_url")});
        getIntent().putExtra("rawUrl", str);
        getIntent().putExtra("showShare", false);
        super.onCreate(bundle);
        this.bPS = getIntent().getStringExtra("free_wifi_appid");
        this.jkJ = getIntent().getStringExtra("free_wifi_app_nickname");
        this.bPg = getIntent().getStringExtra("free_wifi_app_username");
        this.jnW = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
        this.jnX = getIntent().getStringExtra("free_wifi_finish_url");
        this.signature = getIntent().getStringExtra("free_wifi_signature");
        this.bVU = m.H(getIntent());
        if (this.bVU == 10) {
            str = q.deR.dfn;
            String br = q.br(this.mController.tml);
            if (!(m.isEmpty(str) || m.isEmpty(br))) {
                this.jnX = Uri.parse(this.jnX).buildUpon().appendQueryParameter("manufacturer", br).appendQueryParameter("manufacturerUsername", str).toString();
            }
        }
        x.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", new Object[]{this.bPS, this.jkJ, this.bPg, Integer.valueOf(this.jnW), this.jnX, this.signature});
        WifiInfo aOA = d.aOA();
        a aOa = k.aOa();
        if (aOA != null) {
            str = aOA.getMacAddress();
            if (VERSION.SDK_INT > 22 && (str == null || str.equals("02:00:00:00:00:00"))) {
                str = m.aOf();
            }
            aOa.ssid = m.BQ(aOA.getSSID());
            aOa.bssid = aOA.getBSSID();
            aOa.bIR = str;
        }
        aOa.bIQ = getIntent().getStringExtra("free_wifi_ap_key");
        aOa.jic = this.bPS;
        aOa.jid = m.E(getIntent());
        aOa.jie = m.G(getIntent());
        aOa.jif = k$b.GetBackPage.jiQ;
        aOa.jig = k$b.GetBackPage.name;
        aOa.bVU = m.H(getIntent());
        aOa.jih = this.bPg;
        aOa.aOc().aOb();
    }

    @TargetApi(11)
    protected void onDestroy() {
        super.onDestroy();
        au.DF().b(1703, this);
    }

    protected final void ant() {
        super.ant();
    }

    public void finish() {
        super.finish();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    protected final void initView() {
        super.initView();
        lD(false);
        a(0, getString(R.l.free_wifi_finish), new 1(this), b.tnc);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if (!getString(R.l.free_wifi_finish).equals((String) menu.getItem(0).getTitle())) {
            a(0, getString(R.l.free_wifi_finish), new 2(this), b.tnc);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        au.DF().b(1703, this);
    }
}
