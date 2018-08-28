package com.tencent.mm.plugin.freewifi.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
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
import com.tencent.mm.plugin.freewifi.e.a;
import com.tencent.mm.plugin.freewifi.e.f;
import com.tencent.mm.plugin.freewifi.e.g;
import com.tencent.mm.plugin.freewifi.e.h;
import com.tencent.mm.plugin.freewifi.e.i;
import com.tencent.mm.plugin.freewifi.e.j;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.c.ep;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FreeWifiFrontPageUI extends MMActivity {
    protected String bIQ;
    protected String bPS;
    protected int bxk;
    protected String className;
    private final c dXk;
    private ag dvh = new 1(this);
    protected Intent intent;
    protected String jkH;
    protected int jkI;
    protected String jkJ;
    protected TextView jmC;
    protected TextView jmD;
    protected TextView jmE;
    protected ImageView jmP;
    protected TextView jmQ;
    protected TextView jmR;
    protected Button jmS;
    protected Button jmT;
    protected Dialog jmU;
    protected View jmV;
    protected String jmW;
    protected String jmX;
    protected String jmY;
    protected String jmZ;
    protected a jna;
    private Lock jnb;
    private d jnc;
    protected int source;
    protected String ssid;

    public FreeWifiFrontPageUI() {
        c.a aVar = new c.a();
        aVar.dXw = true;
        aVar.dXx = true;
        aVar.dXN = R.g.free_wifi_icon_default;
        aVar.dXW = true;
        aVar.dXX = 0.0f;
        this.dXk = aVar.Pt();
    }

    private d aPy() {
        try {
            this.jnb.lock();
            d dVar = this.jnc;
            return dVar;
        } finally {
            this.jnb.unlock();
        }
    }

    public final void a(d dVar, Object obj) {
        try {
            this.jnb.lock();
            this.jnc = dVar;
            Message obtain = Message.obtain();
            obtain.obj = new c(dVar, obj);
            this.dvh.sendMessage(obtain);
        } finally {
            this.jnb.unlock();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        switch (this.jkI) {
            case 1:
                this.jna = new g(this);
                break;
            case 4:
                this.jna = new f(this);
                break;
            case 31:
                this.jna = new h(this);
                this.jmV.setVisibility(0);
                aPz();
                break;
            case 32:
                this.jna = new j(this);
                this.jmV.setVisibility(0);
                break;
            case 33:
                this.jna = new i(this);
                break;
        }
        x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.onCreate, desc=it goes into connect frontpage. apKey=%s", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent())), this.className, this.bIQ});
        l.s(d.aOB(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    }

    public final void initView() {
        setBackBtn(new 2(this));
        if (this.jmU != null) {
            this.jmU.dismiss();
        }
        this.jnb = new ReentrantLock();
        this.className = getClass().getSimpleName();
        this.intent = getIntent();
        this.ssid = getIntent().getStringExtra("free_wifi_ssid");
        this.jkH = getIntent().getStringExtra("free_wifi_url");
        this.bIQ = getIntent().getStringExtra("free_wifi_ap_key");
        this.source = getIntent().getIntExtra("free_wifi_source", 1);
        this.bxk = getIntent().getIntExtra("free_wifi_channel_id", 0);
        this.jkI = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
        this.bPS = getIntent().getStringExtra("free_wifi_appid");
        this.jmW = getIntent().getStringExtra("free_wifi_head_img_url");
        this.jmX = getIntent().getStringExtra("free_wifi_welcome_msg");
        this.jmY = getIntent().getStringExtra("free_wifi_welcome_sub_title");
        this.jmZ = getIntent().getStringExtra("free_wifi_privacy_url");
        this.jkJ = getIntent().getStringExtra("free_wifi_app_nickname");
        x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.initView, desc=Initializing the view. ssid=%s, fullUrl=%s, apKey=%s, source=%d, channel=%d, protocolNumber=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent())), this.className, this.ssid, this.jkH, this.bIQ, Integer.valueOf(this.source), Integer.valueOf(this.bxk), Integer.valueOf(this.jkI), this.bPS, this.jmW, this.jmX, this.jmZ});
        this.jmV = findViewById(R.h.user_protocol_phone_text);
        this.jmP = (ImageView) findViewById(R.h.free_wifi_app_logo_iv);
        this.jmQ = (TextView) findViewById(R.h.free_wifi_welcomemsg_tv);
        this.jmR = (TextView) findViewById(R.h.free_wifi_ssidname_tv);
        this.jmC = (TextView) findViewById(R.h.free_wifi_connectfail_tv);
        this.jmD = (TextView) findViewById(R.h.free_wifi_connectfail_mark_tv);
        this.jmE = (TextView) findViewById(R.h.free_wifi_connectfail_open_detail_tv);
        this.jmS = (Button) findViewById(R.h.connect_wifi_btn);
        this.jmS.setOnClickListener(new 3(this));
        this.jmT = (Button) findViewById(R.h.user_protocol_privacy_btn);
        this.jmT.setOnClickListener(new 4(this));
        if (bi.oW(this.ssid)) {
            this.jmR.setText(getString(R.l.free_wifi_ssid_empty_tips));
            this.jmS.setVisibility(4);
        }
        setMMTitle(getString(R.l.free_wifi_title));
        a(d.jnh, null);
    }

    private void aPz() {
        l.t(d.aOB(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        d aPy = aPy();
        x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=User click the connect button and starts the connect wifi process. uiState=%s", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent())), this.className, aPy.name()});
        if (aPy() == d.jnh || aPy() == d.jnj) {
            x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=It makes a decision whether to bind phone number. shoudBindPhone=%b, userPhoneState=%d(0 means no phone number. 1 means having a china phone number. 2 means having a foreign number.)", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent())), this.className, Boolean.valueOf(this.intent.getBooleanExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", false)), Integer.valueOf(m.aOg())});
            if (this.intent.getBooleanExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", false) && r1 == 1 && this.jkI != 33) {
                com.tencent.mm.ui.base.h.a(this, R.l.free_wifi_bind_phone_msg, R.l.free_wifi_bind_phone_title, new 5(this), null);
                return;
            }
            this.jnc = d.jni;
            aPB();
            this.jna.connect();
        }
    }

    protected final void aPA() {
        this.jmC.setVisibility(4);
        if (this.jkI == 31) {
            this.jmS.setVisibility(8);
        } else {
            this.jmS.setVisibility(0);
            this.jmS.setText(R.l.connect_state_wating);
        }
        if (!(m.H(getIntent()) != 10 || m.isEmpty(q.deR.dfn) || m.isEmpty(q.br(this.mController.tml)))) {
            this.jmS.setText(String.format(getString(R.l.free_wifi_connect_btn_manu_wording), new Object[]{q.br(this.mController.tml)}));
        }
        if (!bi.oW(this.jmY)) {
            this.jmR.setText(this.jmY);
        } else if (this.jkI == 33) {
            this.jmR.setText(getString(R.l.connect_state_connecting_default_tips) + ": " + this.ssid);
        } else {
            this.jmR.setText(getString(R.l.connect_state_connecting_default_tips));
        }
        if (!bi.oW(this.bPS)) {
            if (!bi.oW(this.jkJ)) {
                this.jmQ.setText(this.jkJ);
            }
            if (!bi.oW(this.jmW)) {
                o.Pj().a(this.jmW, this.jmP, this.dXk);
            }
        }
        x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnectStart, desc=it initializes the connect front page.", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent()))});
    }

    protected final void aPB() {
        this.jmC.setVisibility(4);
        this.jmD.setVisibility(4);
        this.jmE.setVisibility(4);
        this.jmS.setText(R.l.connect_state_connecting_ing);
        ActionBarActivity actionBarActivity = this.mController.tml;
        6 6 = new 6(this);
        View inflate = View.inflate(actionBarActivity, R.i.free_wifi_progress_dialog, null);
        com.tencent.mm.ui.base.i iVar = new com.tencent.mm.ui.base.i(actionBarActivity, R.m.FreeWifiProgressDialogStyle);
        iVar.setCancelable(true);
        iVar.setContentView(inflate);
        iVar.setOnCancelListener(6);
        this.jmU = iVar;
        x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent()))});
        this.jmU.show();
    }

    protected final void by(Object obj) {
        if (obj instanceof a) {
            CharSequence string;
            a aVar = (a) obj;
            x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, desc=Connect failed. errcode=%s", new Object[]{m.E(this.intent), Integer.valueOf(m.F(this.intent)), a.a(aVar)});
            if (this.jmU != null) {
                this.jmU.dismiss();
            }
            this.jmC.setVisibility(0);
            if (m.isEmpty(a.b(aVar))) {
                if (a.c(aVar) == 0) {
                    a.a(aVar, R.l.free_wifi_connect_fail_tips);
                }
                string = getString(a.c(aVar));
            } else {
                string = a.b(aVar);
            }
            this.jmC.setText(string);
            this.jmC.setVisibility(0);
            this.jmD.setVisibility(0);
            this.jmE.setVisibility(0);
            final String str = getString(R.l.free_wifi_errorcode_type) + ": " + a.a(aVar);
            this.jmE.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("free_wifi_show_detail_error", 1);
                    intent.putExtra("free_wifi_error_ui_error_msg", FreeWifiFrontPageUI.this.getString(R.l.free_wifi_connect_fail_msg));
                    intent.putExtra("free_wifi_error_ui_error_msg_detail1", str);
                    intent.setClass(FreeWifiFrontPageUI.this, FreeWifiErrorUI.class);
                    FreeWifiFrontPageUI.this.startActivity(intent);
                }
            });
            this.jmS.setVisibility(0);
            this.jmS.setText(R.l.free_wifi_re_connect);
            x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toFail, desc=connect failed.", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent()))});
        }
    }

    protected final void bz(Object obj) {
        if (obj instanceof b) {
            k.a aOa;
            ep epVar = ((b) obj).jng;
            if (!(this.jkI == 31 || this.jmU == null)) {
                this.jmU.dismiss();
            }
            this.jmS.setText(R.l.connect_state_connected);
            this.jmS.setClickable(false);
            Intent intent = getIntent();
            intent.putExtra("free_wifi_appid", epVar.rbW);
            intent.putExtra("free_wifi_app_nickname", epVar.hcS);
            intent.putExtra("free_wifi_app_username", epVar.hbL);
            intent.putExtra("free_wifi_signature", epVar.eJK);
            intent.putExtra("free_wifi_finish_actioncode", epVar.rfa);
            intent.putExtra("free_wifi_finish_url", epVar.rfb);
            intent.putExtra(e.c.thu, epVar.joi);
            if (epVar.rfa == 2) {
                if (bi.oW(epVar.hbL)) {
                    intent.setClass(this, FreeWifiSuccUI.class);
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", epVar.hbL);
                    com.tencent.mm.bg.d.b(this, "profile", ".ui.ContactInfoUI", intent2);
                    d.xP();
                    x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent()))});
                    aOa = k.aOa();
                    aOa.bIQ = this.bIQ;
                    aOa.jid = m.E(intent);
                    aOa.jif = b.jiF.jiQ;
                    aOa.jig = b.jiF.name;
                    aOa.bVU = m.H(intent);
                    aOa.jie = m.G(intent);
                    aOa.result = 0;
                    aOa.hKX = "";
                    aOa.aOc().b(intent, true).aOb();
                    return;
                }
            } else if (m.isEmpty(epVar.rfc)) {
                intent.setClass(this, FreeWifiSuccUI.class);
            } else {
                intent.putExtra("free_wifi_qinghuai_url", epVar.rfc);
                intent.setClass(this, FreeWifiSuccWebViewUI.class);
            }
            aOa = k.aOa();
            aOa.bIQ = this.bIQ;
            aOa.jid = m.E(intent);
            aOa.jif = b.jiE.jiQ;
            aOa.jig = b.jiE.name;
            aOa.bVU = m.H(intent);
            aOa.jie = m.G(intent);
            aOa.result = 0;
            aOa.hKX = "";
            aOa.aOc().b(intent, true).aOb();
            finish();
            startActivity(intent);
            d.xP();
            x.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", new Object[]{m.E(getIntent()), Integer.valueOf(m.F(getIntent()))});
        }
    }

    public void finish() {
        super.finish();
        k.a aOa = k.aOa();
        aOa.bIQ = this.bIQ;
        aOa.jid = m.E(this.intent);
        aOa.jif = b.jiC.jiQ;
        aOa.jig = b.jiC.name;
        aOa.bVU = m.H(this.intent);
        aOa.jie = m.G(this.intent);
        aOa.result = 0;
        aOa.hKX = "";
        aOa.aOc().b(this.intent, true).aOb();
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
        k.a aOa = k.aOa();
        aOa.bIQ = this.bIQ;
        aOa.jid = m.E(this.intent);
        aOa.jif = b.jiD.jiQ;
        aOa.jig = b.jiD.name;
        aOa.bVU = m.H(this.intent);
        aOa.jie = m.G(this.intent);
        aOa.result = 0;
        aOa.hKX = "";
        aOa.aOc().b(this.intent, true).aOb();
        com.tencent.mm.plugin.freewifi.g.ezn.i(new Intent(), this);
        finish();
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.freewifi.model.j.aON().release();
    }
}
