package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ep;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.pb.common.c.g;

public class FreeWifiCopyPwdUI extends MMActivity {
    public static int jmz = f$k.AppCompatTheme_switchStyle;
    private String appId;
    private String bIQ;
    private int bxk;
    private ag dvh = new 4(this);
    private Intent intent;
    private int jkI;
    private int jmA = 1;
    private int jmB = 2;
    protected TextView jmC;
    protected TextView jmD;
    protected TextView jmE;
    private String ssid;

    public static class a {
        public static a jmH = new a();
        private int glH;
        String jmI;
        String text;
    }

    static /* synthetic */ void b(FreeWifiCopyPwdUI freeWifiCopyPwdUI, Object obj) {
        if (obj instanceof a) {
            CharSequence string;
            a aVar = (a) obj;
            x.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, desc=Connect failed. errcode=%s", new Object[]{m.E(freeWifiCopyPwdUI.intent), Integer.valueOf(m.F(freeWifiCopyPwdUI.intent)), aVar.jmI});
            freeWifiCopyPwdUI.jmC.setVisibility(0);
            if (m.isEmpty(aVar.text)) {
                if (aVar.glH == 0) {
                    aVar.glH = R.l.free_wifi_connect_fail_tips;
                }
                string = freeWifiCopyPwdUI.getString(aVar.glH);
            } else {
                string = aVar.text;
            }
            freeWifiCopyPwdUI.jmC.setText(string);
            freeWifiCopyPwdUI.jmC.setVisibility(0);
            freeWifiCopyPwdUI.jmD.setVisibility(0);
            freeWifiCopyPwdUI.jmE.setVisibility(0);
            freeWifiCopyPwdUI.jmE.setOnClickListener(new 5(freeWifiCopyPwdUI, freeWifiCopyPwdUI.getString(R.l.free_wifi_errorcode_type) + ": " + aVar.jmI));
            x.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, method=Protocol.toFail, desc=connect failed.", new Object[]{m.E(freeWifiCopyPwdUI.getIntent()), Integer.valueOf(m.F(freeWifiCopyPwdUI.getIntent()))});
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new 1(this));
        this.intent = getIntent();
        this.ssid = getIntent().getStringExtra("free_wifi_ssid");
        this.bIQ = this.intent.getStringExtra("free_wifi_ap_key");
        this.appId = this.intent.getStringExtra("free_wifi_appid");
        this.bxk = this.intent.getIntExtra("free_wifi_channel_id", 0);
        this.jkI = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
        ((TextView) findViewById(R.h.free_wifi_ssidname)).setText(this.ssid);
        com.tencent.mm.pluginsdk.f.a.a(this.mController.tml, "wifi password", getIntent().getStringExtra("free_wifi_passowrd"));
        ((Button) findViewById(R.h.free_wifi_copy_btn)).setOnClickListener(new 2(this));
        this.jmC = (TextView) findViewById(R.h.free_wifi_copypwd_connectfail_tv);
        this.jmD = (TextView) findViewById(R.h.free_wifi_copypwd_connectfail_mark_tv);
        this.jmE = (TextView) findViewById(R.h.free_wifi_copypwd_open_detail_tv);
        String aOB = d.aOB();
        String stringExtra = getIntent().getStringExtra("free_wifi_ap_key");
        int intExtra = getIntent().getIntExtra("free_wifi_protocol_type", 0);
        h.mEJ.h(12651, new Object[]{Integer.valueOf(6), aOB, Integer.valueOf(0), stringExtra, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(intExtra)});
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == jmz && m.aOh() && !g.isNullOrEmpty(this.ssid) && this.ssid.equals(d.aOC())) {
            x.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, desc=connect ssid succeeded. ", new Object[]{m.E(this.intent), Integer.valueOf(m.F(this.intent))});
            com.tencent.mm.plugin.freewifi.k.a aOa = k.aOa();
            aOa.ssid = this.ssid;
            aOa.bssid = m.BT("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
            aOa.bIR = m.BU("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
            aOa.bIQ = this.bIQ;
            aOa.jic = this.appId;
            aOa.jid = m.E(this.intent);
            aOa.jie = m.G(this.intent);
            aOa.jif = b.jiq.jiQ;
            aOa.jig = b.jiq.name;
            aOa.result = 0;
            aOa.bVU = m.H(this.intent);
            aOa.aOc().aOb();
            m.a(this.intent, this.bIQ, this.jkI, this.bxk, new com.tencent.mm.plugin.freewifi.m.a() {
                public final void j(int i, int i2, String str, l lVar) {
                    FreeWifiCopyPwdUI freeWifiCopyPwdUI;
                    FreeWifiCopyPwdUI freeWifiCopyPwdUI2;
                    int c;
                    a aVar;
                    if (i == 0 && i2 == 0) {
                        if (lVar instanceof com.tencent.mm.plugin.freewifi.d.a) {
                            ep aOY = ((com.tencent.mm.plugin.freewifi.d.a) lVar).aOY();
                            if (aOY != null) {
                                x.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[]{aOY.rbW, aOY.hcS, aOY.hbL, Integer.valueOf(aOY.rfa), aOY.rfb, aOY.eJK, aOY.rfc});
                                FreeWifiCopyPwdUI.a(FreeWifiCopyPwdUI.this, new b(FreeWifiCopyPwdUI.this, FreeWifiCopyPwdUI.this.jmA, aOY));
                                return;
                            }
                            x.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo is null");
                            freeWifiCopyPwdUI = FreeWifiCopyPwdUI.this;
                            freeWifiCopyPwdUI2 = FreeWifiCopyPwdUI.this;
                            c = FreeWifiCopyPwdUI.this.jmB;
                            aVar = new a();
                            aVar.jmI = m.a(FreeWifiCopyPwdUI.this.jkI, b.jis, 21);
                            FreeWifiCopyPwdUI.a(freeWifiCopyPwdUI, new b(freeWifiCopyPwdUI2, c, aVar));
                        }
                    } else if (!m.cD(i, i2) || m.isEmpty(str)) {
                        freeWifiCopyPwdUI = FreeWifiCopyPwdUI.this;
                        freeWifiCopyPwdUI2 = FreeWifiCopyPwdUI.this;
                        c = FreeWifiCopyPwdUI.this.jmB;
                        aVar = new a();
                        aVar.jmI = m.a(FreeWifiCopyPwdUI.this.jkI, b.jis, i2);
                        FreeWifiCopyPwdUI.a(freeWifiCopyPwdUI, new b(freeWifiCopyPwdUI2, c, aVar));
                    } else {
                        freeWifiCopyPwdUI = FreeWifiCopyPwdUI.this;
                        freeWifiCopyPwdUI2 = FreeWifiCopyPwdUI.this;
                        c = FreeWifiCopyPwdUI.this.jmB;
                        aVar = new a();
                        aVar.text = str;
                        aVar.jmI = m.a(FreeWifiCopyPwdUI.this.jkI, b.jis, i2);
                        FreeWifiCopyPwdUI.a(freeWifiCopyPwdUI, new b(freeWifiCopyPwdUI2, c, aVar));
                    }
                }
            }, "MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        com.tencent.mm.plugin.freewifi.l.u(d.aOB(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        com.tencent.mm.plugin.freewifi.k.a aOa = k.aOa();
        aOa.bIQ = this.bIQ;
        aOa.jid = m.E(this.intent);
        aOa.jif = b.jiP.jiQ;
        aOa.jig = b.jiP.name;
        aOa.bVU = m.H(this.intent);
        aOa.jie = m.G(this.intent);
        aOa.result = 0;
        aOa.hKX = "";
        aOa.aOc().b(this.intent, true).aOb();
        com.tencent.mm.plugin.freewifi.g.ezn.i(new Intent(), this);
        finish();
    }

    protected final int getLayoutId() {
        return R.i.free_wifi_copy_pwd;
    }
}
