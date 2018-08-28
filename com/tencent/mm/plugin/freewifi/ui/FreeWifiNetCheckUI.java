package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.d.h;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.ui.b.1;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiNetCheckUI extends MMActivity {
    private String aAL;
    private al bAZ;
    private int bVU;
    private Intent intent;
    private int[] jnB = new int[]{R.g.free_wifi_loading_1, R.g.free_wifi_loading_2, R.g.free_wifi_loading_3, R.g.free_wifi_loading_4, R.g.free_wifi_loading_5};
    ag jnC = new 1(this);
    private b jnJ;
    ImageView jnv;
    private final int jny = 1;
    private final int jnz = 2;
    private int scene;

    static /* synthetic */ void a(FreeWifiNetCheckUI freeWifiNetCheckUI, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("free_wifi_error_ui_error_msg", str);
        intent.putExtra("free_wifi_error_ui_error_msg_detail1", str2);
        intent.setClass(freeWifiNetCheckUI, FreeWifiErrorUI.class);
        freeWifiNetCheckUI.finish();
        freeWifiNetCheckUI.startActivity(intent);
    }

    static /* synthetic */ void c(FreeWifiNetCheckUI freeWifiNetCheckUI) {
        Intent intent = new Intent();
        intent.setClass(freeWifiNetCheckUI, FreeWifiNoWifiUI.class);
        freeWifiNetCheckUI.startActivity(intent);
    }

    public void finish() {
        if (this.bAZ != null) {
            this.bAZ.SO();
        }
        this.jnC.sendEmptyMessage(2);
        super.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.free_wifi_title);
        setBackBtn(new 2(this));
        this.intent = getIntent();
        m.D(this.intent);
        this.aAL = getIntent().getStringExtra("free_wifi_ap_key");
        this.scene = getIntent().getIntExtra("free_wifi_source", 1);
        x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.onCreate, desc=it goes into black loading ui and starts to connect. get qrcode key = %s, current connected ssid = %s", new Object[]{m.E(this.intent), Integer.valueOf(m.F(this.intent)), this.aAL, d.aOz()});
        this.jnv = (ImageView) findViewById(R.h.free_wifi_app_logo_iv);
        this.bAZ = new al(new 3(this), true);
        this.bAZ.J(200, 200);
        String str;
        switch (this.scene) {
            case 1:
                getIntent().putExtra("free_wifi_channel_id", 2);
                this.bVU = 2;
                if (!bi.oW(this.aAL)) {
                    Uri uri = null;
                    str = "";
                    try {
                        uri = Uri.parse(this.aAL);
                        str = uri.getQueryParameter("q");
                    } catch (Exception e) {
                        finish();
                    }
                    if (!"pc".equalsIgnoreCase(str)) {
                        "_test".equals(str);
                        aPI();
                        break;
                    }
                    str = uri.getQueryParameter("appid");
                    String queryParameter = uri.getQueryParameter("shopid");
                    String queryParameter2 = uri.getQueryParameter("ticket");
                    m.d(getIntent(), queryParameter2);
                    a aOa = k.aOa();
                    aOa.jib = queryParameter;
                    aOa.jic = str;
                    aOa.jid = queryParameter2;
                    aOa.jif = b.jiK.jiQ;
                    aOa.jig = b.jiK.name;
                    aOa.aOc().aOb();
                    x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=handlePcRequest, desc=It starts NetSceneGetPcFrontPage.shopid=%s, appid=%s, ticket=%s", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent())), queryParameter, str, queryParameter2});
                    new h(str, Integer.valueOf(queryParameter).intValue(), queryParameter2).b(new 4(this, queryParameter, queryParameter2, str));
                    break;
                }
                x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
                finish();
                break;
            case 4:
                str = getIntent().getStringExtra("free_wifi_jsapi_param_type");
                if ("1".equals(str)) {
                    getIntent().putExtra("free_wifi_channel_id", 9);
                    this.bVU = 9;
                } else if ("0".equals(str)) {
                    getIntent().putExtra("free_wifi_channel_id", 8);
                    this.bVU = 8;
                } else {
                    getIntent().putExtra("free_wifi_channel_id", 4);
                    this.bVU = 4;
                }
                str = getIntent().getStringExtra("free_wifi_jsapi_param_type");
                if (!str.equals("0") || !bi.oW(this.aAL)) {
                    if (!str.equals("0")) {
                        if (!str.equals("1")) {
                            x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "undefined jsapi type");
                            finish();
                            break;
                        }
                        str = getIntent().getStringExtra("free_wifi_jsapi_param_username");
                        if (!d.isWifiEnabled()) {
                            d.aOw();
                        }
                        h$b.jkd.a(new 5(this, str));
                        break;
                    }
                    aPI();
                    break;
                }
                x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key fail");
                finish();
                break;
                break;
            case 5:
                this.bVU = getIntent().getIntExtra("free_wifi_channel_id", 1);
                if (!bi.oW(this.aAL)) {
                    aPI();
                    break;
                }
                x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
                finish();
                break;
            case 6:
                getIntent().putExtra("free_wifi_channel_id", 10);
                this.bVU = 10;
                if (!bi.oW(this.aAL)) {
                    aPI();
                    break;
                }
                x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
                finish();
                break;
            default:
                x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "unkown scene, just finish");
                finish();
                break;
        }
        x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.handleRequstByScene, desc=it decides the channel. channel=%d", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(this.intent)), Integer.valueOf(this.bVU)});
    }

    private void aPI() {
        if (bi.oW(this.aAL)) {
            x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
            finish();
            return;
        }
        this.jnJ = new b(this, this.aAL, this.bVU);
        x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiNetCheckUI.connectFreewifi, desc=base params are ready and it will connets wifi.apKey=%s, channel=%d", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(this.intent)), this.aAL, Integer.valueOf(this.bVU)});
        b bVar = this.jnJ;
        if (bi.oW(bVar.bIQ)) {
            x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get key failed");
            bVar.activity.finish();
        }
        bVar.activity.getIntent().putExtra("free_wifi_url", bVar.bIQ);
        bVar.activity.getIntent().putExtra("free_wifi_ap_key", bVar.bIQ);
        if (bi.oW(bVar.bIQ)) {
            x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ap key is null");
            bVar.activity.finish();
            return;
        }
        x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo, desc=it starts net request [getApInfo] for retrieving protocol type and frontpage info. apKey=%s, channel=%d", new Object[]{m.E(bVar.intent), Integer.valueOf(m.F(bVar.intent)), bVar.bIQ, Integer.valueOf(bVar.bVU)});
        a aOa = k.aOa();
        aOa.bIQ = bVar.bIQ;
        aOa.jid = m.E(bVar.intent);
        aOa.jif = b.jin.jiQ;
        aOa.jig = b.jin.name;
        aOa.bVU = bVar.bVU;
        aOa.jie = m.G(bVar.intent);
        aOa.aOc().b(bVar.intent, false).aOb();
        new com.tencent.mm.plugin.freewifi.d.a(bVar.bIQ, bVar.bVU, m.E(bVar.intent)).s(bVar.activity).b(new 1(bVar));
    }

    protected final int getLayoutId() {
        return R.i.free_wifi_net_check;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.jnJ != null) {
            this.jnJ = null;
        }
        this.bAZ.SO();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }
}
