package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo.State;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.o;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.b;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

@Deprecated
public abstract class FreeWifiStateUI extends MMActivity implements a, b {
    protected String bIQ;
    private int bLv = 1;
    protected String bPS;
    protected String bPg;
    protected int bxk;
    private final c dXk;
    protected String jkH;
    protected String jkJ;
    protected String jlY;
    protected FreeWifiNetworkReceiver jlZ;
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
    protected boolean jma = false;
    private al jmc = new al(new 1(this), false);
    private al jmd = new al(new 2(this), true);
    private j.a jme;
    private p jnR = null;
    protected int jnW;
    protected String jnX;
    protected String jnY;
    protected String signature;
    protected int source;
    protected String ssid;

    protected abstract void Yz();

    public abstract void a(State state);

    protected abstract void aPp();

    protected abstract int aPq();

    public FreeWifiStateUI() {
        c.a aVar = new c.a();
        aVar.dXw = true;
        aVar.dXx = true;
        aVar.dXN = R.g.free_wifi_icon_default;
        aVar.dXW = true;
        aVar.dXX = 0.0f;
        this.dXk = aVar.Pt();
        this.jme = new 3(this);
    }

    static /* synthetic */ void d(FreeWifiStateUI freeWifiStateUI) {
        if (freeWifiStateUI.jlZ == null) {
            freeWifiStateUI.aPv();
        }
        freeWifiStateUI.jlZ.jjY = freeWifiStateUI;
        d.aOw();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r9) {
        /*
        r8 = this;
        r7 = 3;
        r6 = 2;
        r1 = 1;
        r2 = 0;
        super.onCreate(r9);
        r0 = r8.getIntent();
        r3 = "free_wifi_ap_key";
        r0 = r0.getStringExtra(r3);
        r8.bIQ = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_ssid";
        r0 = r0.getStringExtra(r3);
        r8.ssid = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_mid";
        r0 = r0.getStringExtra(r3);
        r8.jlY = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_url";
        r0 = r0.getStringExtra(r3);
        r8.jkH = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_source";
        r0 = r0.getIntExtra(r3, r1);
        r8.source = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_channel_id";
        r0 = r0.getIntExtra(r3, r2);
        r8.bxk = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_appid";
        r0 = r0.getStringExtra(r3);
        r8.bPS = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_head_img_url";
        r0 = r0.getStringExtra(r3);
        r8.jmW = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_welcome_msg";
        r0 = r0.getStringExtra(r3);
        r8.jmX = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_welcome_sub_title";
        r0 = r0.getStringExtra(r3);
        r8.jmY = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_privacy_url";
        r0 = r0.getStringExtra(r3);
        r8.jmZ = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_app_nickname";
        r0 = r0.getStringExtra(r3);
        r8.jkJ = r0;
        r0 = r8.source;
        switch(r0) {
            case 1: goto L_0x011b;
            case 2: goto L_0x00e3;
            case 3: goto L_0x011b;
            case 4: goto L_0x011b;
            case 5: goto L_0x011b;
            case 6: goto L_0x011b;
            default: goto L_0x00a8;
        };
    L_0x00a8:
        r0 = r8.ssid;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 == 0) goto L_0x0178;
    L_0x00b0:
        r0 = "MicroMsg.FreeWifi.FreeWifiStateUI";
        r1 = "ssid is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
    L_0x00b9:
        r8.initView();
        r0 = com.tencent.mm.plugin.freewifi.model.j.aOK();
        r1 = r8.jme;
        r0.c(r1);
        r0 = com.tencent.mm.plugin.freewifi.model.d.aOB();
        r1 = r8.getIntent();
        r3 = "free_wifi_ap_key";
        r1 = r1.getStringExtra(r3);
        r3 = r8.getIntent();
        r4 = "free_wifi_protocol_type";
        r2 = r3.getIntExtra(r4, r2);
        com.tencent.mm.plugin.freewifi.l.s(r0, r1, r2);
        return;
    L_0x00e3:
        r0 = com.tencent.mm.plugin.freewifi.model.j.aOK();
        r0 = r0.aPn();
        if (r0 == 0) goto L_0x0111;
    L_0x00ed:
        r3 = r0.field_ssid;
        r8.ssid = r3;
        r3 = r0.field_mid;
        r8.jlY = r3;
        r0 = r0.field_url;
        r8.jkH = r0;
        r0 = "MicroMsg.FreeWifi.FreeWifiStateUI";
        r3 = "source from mainui banner, ssid : %s, mid : %s, url : %s";
        r4 = new java.lang.Object[r7];
        r5 = r8.ssid;
        r4[r2] = r5;
        r5 = r8.jlY;
        r4[r1] = r5;
        r5 = r8.jkH;
        r4[r6] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r0, r3, r4);
        goto L_0x00a8;
    L_0x0111:
        r0 = "MicroMsg.FreeWifi.FreeWifiStateUI";
        r3 = "there is no connect sucessfull wifi info";
        com.tencent.mm.sdk.platformtools.x.i(r0, r3);
        goto L_0x00a8;
    L_0x011b:
        r0 = r8.ssid;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 == 0) goto L_0x012d;
    L_0x0123:
        r0 = "MicroMsg.FreeWifi.FreeWifiStateUI";
        r1 = "ssid is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x00b9;
    L_0x012d:
        r0 = com.tencent.mm.plugin.freewifi.model.j.aOK();
        r3 = r8.ssid;
        r3 = r0.Cg(r3);
        if (r3 != 0) goto L_0x0195;
    L_0x0139:
        r3 = new com.tencent.mm.plugin.freewifi.g.c;
        r3.<init>();
        r0 = r8.ssid;
        r0 = com.tencent.mm.sdk.platformtools.ac.ce(r0);
        r3.field_ssidmd5 = r0;
        r0 = r8.ssid;
        r3.field_ssid = r0;
        r0 = r1;
    L_0x014b:
        r4 = r8.jkH;
        r3.field_url = r4;
        r4 = r8.jlY;
        r3.field_mid = r4;
        r4 = r8.getIntent();
        r5 = "free_wifi_auth_type";
        r4 = r4.getIntExtra(r5, r6);
        r3.field_wifiType = r4;
        r3.field_connectState = r1;
        if (r0 == 0) goto L_0x016d;
    L_0x0164:
        r0 = com.tencent.mm.plugin.freewifi.model.j.aOK();
        r0.b(r3);
        goto L_0x00a8;
    L_0x016d:
        r0 = com.tencent.mm.plugin.freewifi.model.j.aOK();
        r4 = new java.lang.String[r2];
        r0.c(r3, r4);
        goto L_0x00a8;
    L_0x0178:
        r0 = "MicroMsg.FreeWifi.FreeWifiStateUI";
        r3 = "ssid : %s, mid : %s, source : %d";
        r4 = new java.lang.Object[r7];
        r5 = r8.ssid;
        r4[r2] = r5;
        r5 = r8.jlY;
        r4[r1] = r5;
        r1 = r8.source;
        r1 = java.lang.Integer.valueOf(r1);
        r4[r6] = r1;
        com.tencent.mm.sdk.platformtools.x.i(r0, r3, r4);
        goto L_0x00b9;
    L_0x0195:
        r0 = r2;
        goto L_0x014b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI.onCreate(android.os.Bundle):void");
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void initView() {
        setBackBtn(new 4(this));
        if (getIntent().getIntExtra("free_wifi_protocol_type", 0) == 1) {
            findViewById(R.h.user_protocol_phone_text).setVisibility(0);
        }
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
    }

    protected final void aPs() {
        if (this.jlZ != null) {
            x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister wifi state change receiver");
            this.jlZ.jjY = null;
        }
    }

    protected final void aPt() {
        if (this.jlZ == null) {
            aPv();
        }
        this.jlZ.jjZ = this;
    }

    protected final void aPu() {
        if (this.jlZ != null) {
            x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister network changed receiver");
            this.jlZ.jjZ = null;
        }
    }

    private void aPv() {
        this.jlZ = new FreeWifiNetworkReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        registerReceiver(this.jlZ, intentFilter);
    }

    protected final void aPw() {
        if (d.isWifiEnabled()) {
            this.bLv = aPq();
            x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now before connect, the connect state : %d", Integer.valueOf(this.bLv));
            if (this.bLv != 2) {
                if (m.G(getIntent()) == 4) {
                    this.jmc.J(30000, 30000);
                } else {
                    this.jmc.J(60000, 60000);
                }
                this.jmd.J(1000, 1000);
                if (d.BY(this.ssid)) {
                    x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "start auth now, isAuting : %b", Boolean.valueOf(this.jma));
                    if (this.jma) {
                        x.d("MicroMsg.FreeWifi.FreeWifiStateUI", "now it is authing");
                        return;
                    }
                    this.jmc.J(60000, 60000);
                    this.jmd.J(1000, 1000);
                    Yz();
                    this.jma = true;
                    return;
                }
                com.tencent.mm.plugin.freewifi.model.j.aON().aOv().post(new 8(this));
                return;
            }
            d.a(this.ssid, this.bLv, getIntent());
            return;
        }
        this.jmc.J(60000, 60000);
        this.jmd.J(1000, 1000);
        x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "wifi is not enable, enable it");
        com.tencent.mm.plugin.freewifi.model.j.aON().aOv().post(new 7(this));
    }

    protected final void ph(int i) {
        x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "Current connection state : %d", Integer.valueOf(i));
        switch (i) {
            case -2014:
                if (this.jnR != null) {
                    this.jnR.dismiss();
                }
                this.jmc.SO();
                this.jmd.SO();
                this.jmC.setVisibility(0);
                this.jmS.setText(R.l.free_wifi_re_connect);
                return;
            case -1:
                return;
            case 1:
                this.jmC.setVisibility(4);
                this.jmS.setText(R.l.connect_state_connecting_ing);
                this.jnR = h.a(this.mController.tml, getString(R.l.connect_state_connecting_ing), true, new 9(this));
                return;
            case 2:
                if (this.jnR != null) {
                    this.jnR.dismiss();
                }
                this.jmc.SO();
                this.jmd.SO();
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
                a();
                startActivity(intent);
                d.xP();
                return;
            case 3:
                if (this.jnR != null) {
                    this.jnR.dismiss();
                }
                this.jmc.SO();
                this.jmd.SO();
                this.jmC.setVisibility(0);
                this.jmS.setText(R.l.free_wifi_re_connect);
                return;
            case 4:
                if (this.jnR != null) {
                    this.jnR.dismiss();
                }
                this.jmc.SO();
                this.jmd.SO();
                this.jma = false;
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
                    if (!bi.oW(this.jmX)) {
                        this.jmQ.setText(this.jmX);
                    }
                    if (!bi.oW(this.jmW)) {
                        o.Pj().a(this.jmW, this.jmP, this.dXk);
                        return;
                    }
                    return;
                }
                return;
            default:
                if (this.jnR != null) {
                    this.jnR.dismiss();
                }
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
                    if (!bi.oW(this.jmX)) {
                        this.jmQ.setText(this.jmX);
                    }
                    if (!bi.oW(this.jmW)) {
                        o.Pj().a(this.jmW, this.jmP, this.dXk);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.free_wifi_front_page;
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.freewifi.model.j.aOK().d(this.jme);
        aPs();
        aPu();
        if (this.jlZ != null) {
            unregisterReceiver(this.jlZ);
        }
        this.jmc.SO();
        this.jmd.SO();
        com.tencent.mm.plugin.freewifi.model.j.aON().release();
    }

    public final void qa(int i) {
        x.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now wifi state : %d", Integer.valueOf(i));
        switch (i) {
            case 3:
                aPs();
                aPw();
                return;
            default:
                return;
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
        l.u(d.aOB(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        g.ezn.i(new Intent(), this);
        a();
    }
}
