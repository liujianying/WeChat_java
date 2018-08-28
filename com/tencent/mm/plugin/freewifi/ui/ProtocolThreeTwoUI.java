package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.freewifi.a;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

@Deprecated
public class ProtocolThreeTwoUI extends MMActivity {
    private String bIQ;
    private String bJT;
    private int bLv = 1;
    protected String bPS;
    protected String bPg;
    protected int bxk;
    private final c dXk;
    private Intent intent;
    protected String jkH;
    protected String jkJ;
    private a jkN;
    private int jkT = 0;
    protected String jlY;
    private String jle;
    private TextView jmC;
    private ImageView jmP;
    private TextView jmQ;
    private TextView jmR;
    private Button jmS;
    private Button jmT;
    protected String jmW;
    protected String jmX;
    protected String jmY;
    protected String jmZ;
    private j.a jme;
    private p jnR;
    protected int jnW;
    protected String jnX;
    protected String jnY;
    private al jou = new al(new al.a() {
        public final boolean vD() {
            if (!bi.oW(ProtocolThreeTwoUI.this.ssid)) {
                ProtocolThreeTwoUI.this.bLv = ProtocolThreeTwoUI.this.aPq();
                if (ProtocolThreeTwoUI.this.bLv != 2) {
                    x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[]{m.E(ProtocolThreeTwoUI.this.getIntent()), Integer.valueOf(m.F(ProtocolThreeTwoUI.this.getIntent())), d.pZ(ProtocolThreeTwoUI.this.bLv)});
                    d.a(ProtocolThreeTwoUI.this.ssid, 3, ProtocolThreeTwoUI.this.getIntent());
                    ProtocolThreeTwoUI.this.ai(33, "AUTH_302_TIMES_EXCESS");
                }
            }
            return false;
        }
    }, false);
    private String openId;
    private String sign;
    protected String signature;
    protected int source;
    protected String ssid;

    public ProtocolThreeTwoUI() {
        c.a aVar = new c.a();
        aVar.dXw = true;
        aVar.dXx = true;
        aVar.dXN = R.g.free_wifi_icon_default;
        aVar.dXW = true;
        aVar.dXX = 0.0f;
        this.dXk = aVar.Pt();
    }

    static /* synthetic */ void b(ProtocolThreeTwoUI protocolThreeTwoUI, String str) {
        protocolThreeTwoUI.jkT++;
        if (protocolThreeTwoUI.jkT > 3) {
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.E(protocolThreeTwoUI.getIntent()), Integer.valueOf(m.F(protocolThreeTwoUI.getIntent()))});
            d.a(protocolThreeTwoUI.ssid, 3, protocolThreeTwoUI.getIntent());
            protocolThreeTwoUI.ai(33, "AUTH_302_TIMES_EXCESS");
            return;
        }
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", new Object[]{m.E(protocolThreeTwoUI.getIntent()), Integer.valueOf(m.F(protocolThreeTwoUI.getIntent())), str});
        if (m.isEmpty(str)) {
            d.a(protocolThreeTwoUI.ssid, 3, protocolThreeTwoUI.getIntent());
            protocolThreeTwoUI.ai(34, "EMPTY_AUTH_LOCATION");
            return;
        }
        11 11 = new 11(protocolThreeTwoUI);
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter("method"))) {
            com.tencent.mm.plugin.freewifi.a.a.aOj();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), 11);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.aOj();
        com.tencent.mm.plugin.freewifi.a.a.a(str, 11);
    }

    static /* synthetic */ void c(ProtocolThreeTwoUI protocolThreeTwoUI) {
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connectSsid, desc=it starts to connect ssid. ssid=%s", new Object[]{m.E(protocolThreeTwoUI.getIntent()), Integer.valueOf(m.F(protocolThreeTwoUI.getIntent())), protocolThreeTwoUI.ssid});
        protocolThreeTwoUI.jkN.a(new 9(protocolThreeTwoUI));
    }

    static /* synthetic */ void f(ProtocolThreeTwoUI protocolThreeTwoUI) {
        protocolThreeTwoUI.ai(0, "");
        com.tencent.mm.plugin.freewifi.model.j.aON().aOv().post(new 2(protocolThreeTwoUI));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.intent = getIntent();
        this.bIQ = getIntent().getStringExtra("free_wifi_ap_key");
        this.openId = getIntent().getStringExtra("free_wifi_openid");
        this.jle = getIntent().getStringExtra("free_wifi_tid");
        this.bJT = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
        this.sign = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.onCreate, desc=it goes into Protocol32 connect frontpage. apKey=%s", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent())), this.bIQ});
        initView();
        if (bi.oW(this.ssid)) {
            x.e("MicroMsg.FreeWifi.Protocol32UI", "ssid is null");
        } else {
            int i;
            com.tencent.mm.plugin.freewifi.g.c Cg = com.tencent.mm.plugin.freewifi.model.j.aOK().Cg(this.ssid);
            if (Cg == null) {
                Cg = new com.tencent.mm.plugin.freewifi.g.c();
                Cg.field_ssidmd5 = ac.ce(this.ssid);
                Cg.field_ssid = this.ssid;
                i = 1;
            } else {
                i = 0;
            }
            Cg.field_url = this.jkH;
            Cg.field_mid = this.jlY;
            Cg.field_wifiType = 32;
            Cg.field_connectState = 1;
            if (i != 0) {
                com.tencent.mm.plugin.freewifi.model.j.aOK().b(Cg);
            } else {
                com.tencent.mm.plugin.freewifi.model.j.aOK().c(Cg, new String[0]);
            }
            x.i("MicroMsg.FreeWifi.Protocol32UI", "ssid : %s, mid : %s, source : %d", new Object[]{this.ssid, this.jlY, Integer.valueOf(this.source)});
            this.jme = new 7(this);
            com.tencent.mm.plugin.freewifi.model.j.aOK().c(this.jme);
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent())), Cg.field_ssidmd5, Cg.field_ssid, Cg.field_url, Cg.field_mid, Integer.valueOf(Cg.field_wifiType), Integer.valueOf(Cg.field_connectState)});
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=it initializes the front page. ", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent()))});
            d.a(this.ssid, 4, getIntent());
        }
        l.s(d.aOB(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    }

    public final void initView() {
        this.ssid = getIntent().getStringExtra("free_wifi_ssid");
        this.jlY = getIntent().getStringExtra("free_wifi_mid");
        this.jkH = getIntent().getStringExtra("free_wifi_url");
        this.source = getIntent().getIntExtra("free_wifi_source", 1);
        this.bxk = getIntent().getIntExtra("free_wifi_channel_id", 0);
        this.bPS = getIntent().getStringExtra("free_wifi_appid");
        this.jmW = getIntent().getStringExtra("free_wifi_head_img_url");
        this.jmX = getIntent().getStringExtra("free_wifi_welcome_msg");
        this.jmY = getIntent().getStringExtra("free_wifi_welcome_sub_title");
        this.jmZ = getIntent().getStringExtra("free_wifi_privacy_url");
        this.jkJ = getIntent().getStringExtra("free_wifi_app_nickname");
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initView, desc=Initializing the view. ssid=%s, mid=%s, fullUrl=%s, source=%d, channel=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent())), this.ssid, this.jlY, this.jkH, Integer.valueOf(this.source), Integer.valueOf(this.bxk), this.bPS, this.jmW, this.jmX, this.jmZ});
        setBackBtn(new 4(this));
        findViewById(R.h.user_protocol_phone_text).setVisibility(0);
        this.jmP = (ImageView) findViewById(R.h.free_wifi_app_logo_iv);
        this.jmQ = (TextView) findViewById(R.h.free_wifi_welcomemsg_tv);
        this.jmR = (TextView) findViewById(R.h.free_wifi_ssidname_tv);
        this.jmC = (TextView) findViewById(R.h.free_wifi_connectfail_tv);
        this.jmS = (Button) findViewById(R.h.connect_wifi_btn);
        this.jmS.setOnClickListener(new 5(this));
        this.jmT = (Button) findViewById(R.h.user_protocol_privacy_btn);
        this.jmT.setOnClickListener(new 6(this));
        if (bi.oW(this.ssid)) {
            this.jmR.setText(getString(R.l.free_wifi_ssid_empty_tips));
            this.jmS.setVisibility(4);
        }
        setMMTitle(getString(R.l.free_wifi_title));
    }

    protected final void connect() {
        this.bLv = aPq();
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent())), d.pZ(this.bLv)});
        if (this.bLv != 2) {
            this.jou.J(45000, 45000);
            x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent())), Integer.valueOf(60)});
            this.jkN = new a(this.ssid, this);
            com.tencent.mm.plugin.freewifi.model.j.aON().aOv().post(new 8(this));
            return;
        }
        d.a(this.ssid, 2, getIntent());
    }

    protected final void qb(int i) {
        x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent())), Integer.valueOf(i)});
        switch (i) {
            case 1:
                this.jmC.setVisibility(4);
                this.jmS.setText(R.l.connect_state_connecting_ing);
                this.jnR = h.a(this.mController.tml, getString(R.l.connect_state_connecting_ing), true, new 3(this));
                x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent()))});
                return;
            case 2:
                if (this.jnR != null) {
                    this.jnR.dismiss();
                }
                this.jou.SO();
                this.jmS.setText(R.l.connect_state_connected);
                this.jmS.setClickable(false);
                Intent intent = getIntent();
                intent.putExtra("free_wifi_appid", this.bPS);
                intent.putExtra("free_wifi_app_nickname", this.jkJ);
                intent.putExtra("free_wifi_app_username", this.bPg);
                intent.putExtra("free_wifi_signature", this.signature);
                intent.putExtra("free_wifi_finish_actioncode", this.jnW);
                intent.putExtra("free_wifi_finish_url", this.jnX);
                if (bi.oW(this.jnY)) {
                    intent.setClass(this, FreeWifiSuccUI.class);
                } else {
                    intent.putExtra("free_wifi_qinghuai_url", this.jnY);
                    intent.setClass(this, FreeWifiSuccWebViewUI.class);
                }
                finish();
                startActivity(intent);
                d.xP();
                x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toSuccess, desc=connect succeeded.", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent()))});
                return;
            case 3:
                if (this.jnR != null) {
                    this.jnR.dismiss();
                }
                this.jou.SO();
                this.jmC.setVisibility(0);
                this.jmS.setText(R.l.free_wifi_re_connect);
                x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toFail, desc=connect failed.", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent()))});
                return;
            case 4:
                if (this.jnR != null) {
                    this.jnR.dismiss();
                }
                this.jou.SO();
                this.jmC.setVisibility(4);
                this.jmS.setText(R.l.connect_state_wating);
                if (this.source == 3) {
                    this.jmR.setText(getString(R.l.mig_connect_state_connecting_tips, new Object[]{this.ssid}));
                } else if (bi.oW(this.jmY)) {
                    this.jmR.setText(getString(R.l.connect_state_connecting_default_tips));
                } else {
                    this.jmR.setText(this.jmY);
                }
                if (!bi.oW(this.bPS)) {
                    if (!bi.oW(this.jkJ)) {
                        this.jmQ.setText(this.jkJ);
                    }
                    if (!bi.oW(this.jmW)) {
                        o.Pj().a(this.jmW, this.jmP, this.dXk);
                    }
                }
                x.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnectStart, desc=it initializes the connect front page.", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent()))});
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.free_wifi_front_page;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        l.u(d.aOB(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        g.ezn.i(new Intent(), this);
        finish();
    }

    protected final int aPq() {
        if (bi.oW(this.ssid)) {
            x.d("MicroMsg.FreeWifi.Protocol32UI", "Illegal SSID");
            return 0;
        }
        com.tencent.mm.plugin.freewifi.g.c Cg = com.tencent.mm.plugin.freewifi.model.j.aOK().Cg(this.ssid);
        if (Cg == null || !Cg.field_ssid.equalsIgnoreCase(this.ssid)) {
            return 0;
        }
        return Cg.field_connectState;
    }

    private void ai(int i, String str) {
        k.a aOa = k.aOa();
        aOa.ssid = this.ssid;
        aOa.bssid = m.BT("MicroMsg.FreeWifi.Protocol32UI");
        aOa.bIR = m.BU("MicroMsg.FreeWifi.Protocol32UI");
        aOa.bIQ = this.bIQ;
        aOa.jic = this.bPS;
        aOa.jid = m.E(this.intent);
        aOa.jie = m.G(this.intent);
        aOa.jif = b.jiH.jiQ;
        aOa.jig = b.jiH.name;
        aOa.result = i;
        aOa.hKX = str;
        aOa.bVU = m.H(this.intent);
        aOa.jih = this.bPg;
        aOa.aOc().aOb();
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.jme != null) {
            com.tencent.mm.plugin.freewifi.model.j.aOK().d(this.jme);
        }
        this.jou.SO();
        com.tencent.mm.plugin.freewifi.model.j.aON().release();
    }
}
