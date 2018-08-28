package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.o;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

@Deprecated
public class ProtocolThreeOneUI extends MMActivity {
    private boolean bBc = false;
    private String bIQ;
    private String bLe;
    private int bLv = 1;
    protected String bPS;
    protected String bPg;
    protected int bxk;
    private final c dXk;
    private Intent intent;
    protected String jkH;
    protected String jkJ;
    private String jkS;
    private int jkT = 0;
    protected String jlY;
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
    private a jme;
    private p jnR;
    protected int jnW;
    protected String jnX;
    protected String jnY;
    private al jou = new al(new 1(this), false);
    protected String signature;
    protected int source;
    protected String ssid;

    public ProtocolThreeOneUI() {
        c.a aVar = new c.a();
        aVar.dXw = true;
        aVar.dXx = true;
        aVar.dXN = R.g.free_wifi_icon_default;
        aVar.dXW = true;
        aVar.dXX = 0.0f;
        this.dXk = aVar.Pt();
    }

    static /* synthetic */ void e(ProtocolThreeOneUI protocolThreeOneUI) {
        protocolThreeOneUI.ai(0, "");
        j.aON().aOv().post(new 8(protocolThreeOneUI));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.intent = getIntent();
        this.bIQ = getIntent().getStringExtra("free_wifi_ap_key");
        this.bLe = getIntent().getStringExtra("free_wifi_schema_ticket");
        this.jkS = getIntent().getStringExtra("free_wifi_portal_ap_info_authurl_with_params");
        x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.onCreate, desc=it goes into Protocol31 connect frontpage. apKey=%s, ticket=%s", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent())), this.bIQ, this.bLe});
        initView();
        if (bi.oW(this.ssid)) {
            x.e("MicroMsg.FreeWifi.Protocol31UI", "ssid is null");
        } else {
            int i;
            com.tencent.mm.plugin.freewifi.g.c Cg = j.aOK().Cg(this.ssid);
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
            Cg.field_wifiType = 3;
            Cg.field_connectState = 1;
            if (i != 0) {
                j.aOK().b(Cg);
            } else {
                j.aOK().c(Cg, new String[0]);
            }
            x.i("MicroMsg.FreeWifi.Protocol31UI", "ssid : %s, mid : %s, source : %d", new Object[]{this.ssid, this.jlY, Integer.valueOf(this.source)});
            this.jme = new 5(this);
            j.aOK().c(this.jme);
            x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent())), Cg.field_ssidmd5, Cg.field_ssid, Cg.field_url, Cg.field_mid, Integer.valueOf(Cg.field_wifiType), Integer.valueOf(Cg.field_connectState)});
            x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=it initializes the front page. ", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent()))});
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
        x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initView, desc=Initializing the view. ssid=%s, mid=%s, fullUrl=%s, source=%d, channel=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent())), this.ssid, this.jlY, this.jkH, Integer.valueOf(this.source), Integer.valueOf(this.bxk), this.bPS, this.jmW, this.jmX, this.jmZ});
        setBackBtn(new 2(this));
        findViewById(R.h.user_protocol_phone_text).setVisibility(0);
        this.jmP = (ImageView) findViewById(R.h.free_wifi_app_logo_iv);
        this.jmQ = (TextView) findViewById(R.h.free_wifi_welcomemsg_tv);
        this.jmR = (TextView) findViewById(R.h.free_wifi_ssidname_tv);
        this.jmC = (TextView) findViewById(R.h.free_wifi_connectfail_tv);
        this.jmS = (Button) findViewById(R.h.connect_wifi_btn);
        this.jmS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                l.t(d.aOB(), ProtocolThreeOneUI.this.getIntent().getStringExtra("free_wifi_ap_key"), ProtocolThreeOneUI.this.getIntent().getIntExtra("free_wifi_protocol_type", 0));
                x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[]{m.E(ProtocolThreeOneUI.this.getIntent()), Integer.valueOf(m.F(ProtocolThreeOneUI.this.getIntent())), d.pZ(ProtocolThreeOneUI.this.aPq())});
                if (ProtocolThreeOneUI.this.aPq() == 2) {
                    ProtocolThreeOneUI.this.finish();
                    return;
                }
                d.a(ProtocolThreeOneUI.this.ssid, 1, ProtocolThreeOneUI.this.getIntent());
                ProtocolThreeOneUI.this.connect();
            }
        });
        this.jmT = (Button) findViewById(R.h.user_protocol_privacy_btn);
        this.jmT.setOnClickListener(new 4(this));
        if (bi.oW(this.ssid)) {
            this.jmR.setText(getString(R.l.free_wifi_ssid_empty_tips));
            this.jmS.setVisibility(4);
        }
        setMMTitle(getString(R.l.free_wifi_title));
    }

    protected final void connect() {
        this.bLv = aPq();
        x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent())), d.pZ(this.bLv)});
        if (this.bLv != 2) {
            this.jou.J(15000, 15000);
            x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent())), Integer.valueOf(60)});
            j.aON().aOv().post(new 6(this, this.jkS));
            return;
        }
        d.a(this.ssid, 2, getIntent());
    }

    protected final void qb(int i) {
        x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent())), Integer.valueOf(i)});
        switch (i) {
            case 1:
                this.jmC.setVisibility(4);
                this.jmS.setText(R.l.connect_state_connecting_ing);
                this.jnR = h.a(this.mController.tml, getString(R.l.connect_state_connecting_ing), true, new 9(this));
                x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent()))});
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
                x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toSuccess, desc=connect succeeded.", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent()))});
                return;
            case 3:
                if (this.jnR != null) {
                    this.jnR.dismiss();
                }
                this.jou.SO();
                this.jmC.setVisibility(0);
                this.jmS.setText(R.l.free_wifi_re_connect);
                x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toFail, desc=connect failed.", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent()))});
                return;
            case 4:
                if (this.jnR != null) {
                    this.jnR.dismiss();
                }
                this.jou.SO();
                this.jmC.setVisibility(4);
                this.jmS.setText(R.l.connect_state_wating);
                if (!(m.H(getIntent()) != 10 || m.isEmpty(q.deR.dfn) || m.isEmpty(q.br(this.mController.tml)))) {
                    this.jmS.setText(String.format(getString(R.l.free_wifi_connect_btn_manu_wording), new Object[]{q.br(this.mController.tml)}));
                }
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
                x.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnectStart, desc=it initializes the connect front page.", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent()))});
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
            x.d("MicroMsg.FreeWifi.Protocol31UI", "Illegal SSID");
            return 0;
        }
        com.tencent.mm.plugin.freewifi.g.c Cg = j.aOK().Cg(this.ssid);
        if (Cg == null || !Cg.field_ssid.equalsIgnoreCase(this.ssid)) {
            return 0;
        }
        return Cg.field_connectState;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    private void ai(int i, String str) {
        k.a aOa = k.aOa();
        aOa.ssid = this.ssid;
        aOa.bssid = m.BT("MicroMsg.FreeWifi.Protocol31UI");
        aOa.bIR = m.BU("MicroMsg.FreeWifi.Protocol31UI");
        aOa.bIQ = this.bIQ;
        aOa.jic = this.bPS;
        aOa.jid = m.E(this.intent);
        aOa.jie = m.G(this.intent);
        aOa.jif = b.jiG.jiQ;
        aOa.jig = b.jiG.name;
        aOa.result = i;
        aOa.hKX = str;
        aOa.bVU = m.H(this.intent);
        aOa.jih = this.bPg;
        aOa.aOc().aOb();
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
