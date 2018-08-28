package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

@Deprecated
public class ProtocolThreeThreeUI extends MMActivity {
    protected String appId;
    protected String bJT;
    private int bLv = 1;
    protected String bPg;
    protected String bssid;
    protected int bxk;
    protected String jkJ;
    private int jkT = 0;
    protected String jkW;
    protected String jkX;
    protected String jkY;
    private Uri jkZ;
    private String jla;
    private TextView jmC;
    private ImageView jmP;
    private TextView jmQ;
    private TextView jmR;
    private Button jmS;
    private Button jmT;
    private a jme;
    private p jnR;
    protected int jnW;
    protected String jnX;
    protected String jnY;
    private al jou = new al(new 1(this), false);
    protected String sign;
    protected String signature;
    protected int source;
    protected String ssid;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jla = getIntent().getStringExtra("free_wifi_schema_uri");
        this.jkZ = Uri.parse(this.jla);
        this.appId = this.jkZ.getQueryParameter("appId");
        this.jkW = this.jkZ.getQueryParameter("shopId");
        this.jkX = this.jkZ.getQueryParameter("authUrl");
        this.jkY = this.jkZ.getQueryParameter("extend");
        this.bJT = this.jkZ.getQueryParameter("timestamp");
        this.sign = this.jkZ.getQueryParameter("sign");
        x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.onCreate, desc=it goes into Protocol33 connect frontpage. uri = %s", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent())), this.jla});
        initView();
        if (bi.oW(this.ssid)) {
            x.e("MicroMsg.FreeWifi.Protocol33UI", "ssid is null");
        } else {
            int i;
            c Cg = j.aOK().Cg(this.ssid);
            if (Cg == null) {
                Cg = new c();
                Cg.field_ssidmd5 = ac.ce(this.ssid);
                Cg.field_ssid = this.ssid;
                i = 1;
            } else {
                i = 0;
            }
            Cg.field_url = "";
            Cg.field_mid = "";
            Cg.field_wifiType = 33;
            Cg.field_connectState = 1;
            if (i != 0) {
                j.aOK().b(Cg);
            } else {
                j.aOK().c(Cg, new String[0]);
            }
            x.i("MicroMsg.FreeWifi.Protocol33UI", "ssid : %s, mid : %s, source : %d", new Object[]{this.ssid, "", Integer.valueOf(this.source)});
            this.jme = new a() {
                private int joa = -999999999;

                public final void a(String str, l lVar) {
                    ProtocolThreeThreeUI.this.bLv = ProtocolThreeThreeUI.this.aPq();
                    if (this.joa != ProtocolThreeThreeUI.this.bLv) {
                        this.joa = ProtocolThreeThreeUI.this.bLv;
                        ProtocolThreeThreeUI.this.qb(ProtocolThreeThreeUI.this.bLv);
                    }
                }
            };
            j.aOK().c(this.jme);
            x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent())), Cg.field_ssidmd5, Cg.field_ssid, Cg.field_url, Cg.field_mid, Integer.valueOf(Cg.field_wifiType), Integer.valueOf(Cg.field_connectState)});
            x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=it initializes the front page. ", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent()))});
            d.a(this.ssid, 4, getIntent());
        }
        com.tencent.mm.plugin.freewifi.l.s(d.aOB(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    }

    public final void initView() {
        this.ssid = m.BS("MicroMsg.FreeWifi.Protocol33UI");
        this.bssid = m.BT("MicroMsg.FreeWifi.Protocol33UI");
        this.source = getIntent().getIntExtra("free_wifi_source", 1);
        this.bxk = getIntent().getIntExtra("free_wifi_channel_id", 0);
        setBackBtn(new 2(this));
        findViewById(R.h.user_protocol_phone_text).setVisibility(0);
        this.jmP = (ImageView) findViewById(R.h.free_wifi_app_logo_iv);
        this.jmQ = (TextView) findViewById(R.h.free_wifi_welcomemsg_tv);
        this.jmR = (TextView) findViewById(R.h.free_wifi_ssidname_tv);
        this.jmC = (TextView) findViewById(R.h.free_wifi_connectfail_tv);
        this.jmS = (Button) findViewById(R.h.connect_wifi_btn);
        this.jmS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.plugin.freewifi.l.t(d.aOB(), ProtocolThreeThreeUI.this.getIntent().getStringExtra("free_wifi_ap_key"), ProtocolThreeThreeUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[]{m.E(ProtocolThreeThreeUI.this.getIntent()), Integer.valueOf(m.F(ProtocolThreeThreeUI.this.getIntent())), d.pZ(ProtocolThreeThreeUI.this.aPq())});
                if (ProtocolThreeThreeUI.this.aPq() == 2) {
                    ProtocolThreeThreeUI.this.finish();
                    return;
                }
                d.a(ProtocolThreeThreeUI.this.ssid, 1, ProtocolThreeThreeUI.this.getIntent());
                ProtocolThreeThreeUI.this.connect();
            }
        });
        this.jmT = (Button) findViewById(R.h.user_protocol_privacy_btn);
        this.jmT.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
            }
        });
        if (bi.oW(this.ssid)) {
            this.jmR.setText(getString(R.l.free_wifi_ssid_empty_tips));
            this.jmS.setVisibility(4);
        }
        setMMTitle(getString(R.l.free_wifi_title));
    }

    protected final void connect() {
        if (m.isEmpty(this.ssid)) {
            x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent()))});
            d.a(this.ssid, 3, getIntent());
        } else if (m.isEmpty(this.jkX)) {
            x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent()))});
            d.a(this.ssid, 3, getIntent());
        } else {
            this.bLv = aPq();
            x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent())), d.pZ(this.bLv)});
            if (this.bLv != 2) {
                this.jou.J(30000, 30000);
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent())), Integer.valueOf(60)});
                m.isEmpty(this.jkX);
                StringBuilder stringBuilder = new StringBuilder(this.jkX);
                if (this.jkX.indexOf("?") == -1) {
                    stringBuilder.append("?extend=").append(this.jkY);
                } else {
                    stringBuilder.append("&extend=").append(this.jkY);
                }
                j.aON().aOv().post(new 6(this, stringBuilder.toString()));
                return;
            }
            d.a(this.ssid, 2, getIntent());
        }
    }

    protected final void qb(int i) {
        x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent())), Integer.valueOf(i)});
        switch (i) {
            case 1:
                this.jmC.setVisibility(4);
                this.jmS.setText(R.l.connect_state_connecting_ing);
                this.jnR = h.a(this.mController.tml, getString(R.l.connect_state_connecting_ing), true, new 9(this));
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent()))});
                return;
            case 2:
                if (this.jnR != null) {
                    this.jnR.dismiss();
                }
                this.jou.SO();
                this.jmS.setText(R.l.connect_state_connected);
                this.jmS.setClickable(false);
                Intent intent = getIntent();
                intent.putExtra("free_wifi_appid", this.appId);
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
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toSuccess, desc=connect succeeded.", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent()))});
                return;
            case 3:
                if (this.jnR != null) {
                    this.jnR.dismiss();
                }
                this.jou.SO();
                this.jmC.setVisibility(0);
                this.jmS.setText(R.l.free_wifi_re_connect);
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toFail, desc=connect failed.", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent()))});
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
                } else {
                    this.jmR.setText(getString(R.l.connect_state_connecting_tips, new Object[]{this.ssid}));
                }
                x.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnectStart, desc=it initializes the connect front page.", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent()))});
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
        com.tencent.mm.plugin.freewifi.l.u(d.aOB(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        g.ezn.i(new Intent(), this);
        finish();
    }

    protected final int aPq() {
        if (bi.oW(this.ssid)) {
            x.d("MicroMsg.FreeWifi.Protocol33UI", "Illegal SSID");
            return 0;
        }
        c Cg = j.aOK().Cg(this.ssid);
        if (Cg == null || !Cg.field_ssid.equalsIgnoreCase(this.ssid)) {
            return 0;
        }
        return Cg.field_connectState;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.jme != null) {
            j.aOK().d(this.jme);
        }
        this.jou.SO();
        j.aON().release();
    }
}
