package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.content.IntentFilter;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.g;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.b;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public abstract class FreeWifiActivateStateUI extends MMActivity implements a, b {
    private int bLv = 1;
    protected int bxk;
    protected String jkH;
    private FreeWifiStateView jlT;
    private TextView jlU;
    private TextView jlV;
    private Button jlW;
    protected Button jlX;
    protected String jlY;
    protected FreeWifiNetworkReceiver jlZ;
    protected boolean jma = false;
    private boolean jmb = false;
    private al jmc = new al(new al.a() {
        public final boolean vD() {
            if (!bi.oW(FreeWifiActivateStateUI.this.ssid)) {
                FreeWifiActivateStateUI.this.bLv = FreeWifiActivateStateUI.this.aPq();
                x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now auth time out, ssid is %s, the connect state is %d", new Object[]{FreeWifiActivateStateUI.this.ssid, Integer.valueOf(FreeWifiActivateStateUI.this.bLv)});
                FreeWifiActivateStateUI.this.jmd.SO();
                if (FreeWifiActivateStateUI.this.bLv != 2) {
                    FreeWifiActivateStateUI.this.aPu();
                    FreeWifiActivateStateUI.this.aPs();
                    d.a(FreeWifiActivateStateUI.this.ssid, 3, FreeWifiActivateStateUI.this.getIntent());
                }
            }
            return false;
        }
    }, false);
    private al jmd = new al(new 2(this), true);
    private j.a jme = new 3(this);
    protected int source;
    protected String ssid;

    protected abstract void Yz();

    protected abstract void aPp();

    protected abstract int aPq();

    static /* synthetic */ void d(FreeWifiActivateStateUI freeWifiActivateStateUI) {
        if (freeWifiActivateStateUI.jlZ == null) {
            freeWifiActivateStateUI.aPv();
        }
        freeWifiActivateStateUI.jlZ.jjY = freeWifiActivateStateUI;
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
        r0 = r8.source;
        switch(r0) {
            case 1: goto L_0x00a3;
            case 2: goto L_0x006b;
            case 3: goto L_0x00a3;
            case 4: goto L_0x00a3;
            case 5: goto L_0x00a3;
            default: goto L_0x004d;
        };
    L_0x004d:
        r0 = r8.ssid;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 == 0) goto L_0x0100;
    L_0x0055:
        r0 = "MicroMsg.FreeWifi.FreeWifiActivateStateUI";
        r1 = "ssid is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
    L_0x005e:
        r8.initView();
        r0 = com.tencent.mm.plugin.freewifi.model.j.aOK();
        r1 = r8.jme;
        r0.c(r1);
        return;
    L_0x006b:
        r0 = com.tencent.mm.plugin.freewifi.model.j.aOK();
        r0 = r0.aPn();
        if (r0 == 0) goto L_0x0099;
    L_0x0075:
        r3 = r0.field_ssid;
        r8.ssid = r3;
        r3 = r0.field_mid;
        r8.jlY = r3;
        r0 = r0.field_url;
        r8.jkH = r0;
        r0 = "MicroMsg.FreeWifi.FreeWifiActivateStateUI";
        r3 = "source from mainui banner, ssid : %s, mid : %s, url : %s";
        r4 = new java.lang.Object[r7];
        r5 = r8.ssid;
        r4[r2] = r5;
        r5 = r8.jlY;
        r4[r1] = r5;
        r5 = r8.jkH;
        r4[r6] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r0, r3, r4);
        goto L_0x004d;
    L_0x0099:
        r0 = "MicroMsg.FreeWifi.FreeWifiActivateStateUI";
        r3 = "there is no connect sucessfull wifi info";
        com.tencent.mm.sdk.platformtools.x.i(r0, r3);
        goto L_0x004d;
    L_0x00a3:
        r0 = r8.ssid;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 == 0) goto L_0x00b5;
    L_0x00ab:
        r0 = "MicroMsg.FreeWifi.FreeWifiActivateStateUI";
        r1 = "ssid is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x005e;
    L_0x00b5:
        r0 = com.tencent.mm.plugin.freewifi.model.j.aOK();
        r3 = r8.ssid;
        r3 = r0.Cg(r3);
        if (r3 != 0) goto L_0x011d;
    L_0x00c1:
        r3 = new com.tencent.mm.plugin.freewifi.g.c;
        r3.<init>();
        r0 = r8.ssid;
        r0 = com.tencent.mm.sdk.platformtools.ac.ce(r0);
        r3.field_ssidmd5 = r0;
        r0 = r8.ssid;
        r3.field_ssid = r0;
        r3.field_connectState = r1;
        r0 = r1;
    L_0x00d5:
        r4 = r8.jkH;
        r3.field_url = r4;
        r4 = r8.jlY;
        r3.field_mid = r4;
        r4 = r8.getIntent();
        r5 = "free_wifi_auth_type";
        r4 = r4.getIntExtra(r5, r6);
        r3.field_wifiType = r4;
        if (r0 == 0) goto L_0x00f5;
    L_0x00ec:
        r0 = com.tencent.mm.plugin.freewifi.model.j.aOK();
        r0.b(r3);
        goto L_0x004d;
    L_0x00f5:
        r0 = com.tencent.mm.plugin.freewifi.model.j.aOK();
        r4 = new java.lang.String[r2];
        r0.c(r3, r4);
        goto L_0x004d;
    L_0x0100:
        r0 = "MicroMsg.FreeWifi.FreeWifiActivateStateUI";
        r3 = "ssid : %s, mid : %s, source : %d";
        r4 = new java.lang.Object[r7];
        r5 = r8.ssid;
        r4[r2] = r5;
        r2 = r8.jlY;
        r4[r1] = r2;
        r1 = r8.source;
        r1 = java.lang.Integer.valueOf(r1);
        r4[r6] = r1;
        com.tencent.mm.sdk.platformtools.x.i(r0, r3, r4);
        goto L_0x005e;
    L_0x011d:
        r0 = r2;
        goto L_0x00d5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.onCreate(android.os.Bundle):void");
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onResume() {
        super.onResume();
        if (!bi.oW(this.ssid)) {
            aPw();
        }
    }

    protected void initView() {
        setBackBtn(new 4(this));
        this.jlT = (FreeWifiStateView) findViewById(R.h.free_wifi_connect_state_iv);
        this.jlU = (TextView) findViewById(R.h.free_wifi_connect_state_tv);
        this.jlV = (TextView) findViewById(R.h.free_wifi_connect_tips);
        if (this.source == 3) {
            this.jlV.setText(getString(R.l.mig_connect_state_connecting_tips, new Object[]{this.ssid}));
        } else {
            this.jlV.setText(getString(R.l.connect_state_connecting_tips, new Object[]{this.ssid}));
        }
        this.jlW = (Button) findViewById(R.h.re_scan_qrcode);
        this.jlW.setOnClickListener(new 5(this));
        this.jlX = (Button) findViewById(R.h.help_btn);
        this.jlX.setOnClickListener(new 6(this));
    }

    protected final void aPs() {
        if (this.jlZ != null) {
            x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister wifi state change receiver");
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
            x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister network changed receiver");
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
            x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now before connect, the connect state : %d", new Object[]{Integer.valueOf(this.bLv)});
            if (this.bLv != 2) {
                this.jmc.J(60000, 60000);
                this.jmd.J(1000, 1000);
                if (d.BY(this.ssid)) {
                    x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "start auth now, isAuting : %b", new Object[]{Boolean.valueOf(this.jma)});
                    if (this.jma) {
                        x.d("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now it is authing");
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
            ph(this.bLv);
            return;
        }
        this.jmc.J(60000, 60000);
        this.jmd.J(1000, 1000);
        x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "wifi is not enable, enable it");
        com.tencent.mm.plugin.freewifi.model.j.aON().aOv().post(new 7(this));
    }

    protected final void ph(int i) {
        this.jlT.setOnClickListener(null);
        x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "Current connection state : %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case -2014:
                this.jmc.SO();
                this.jmd.SO();
                this.jlT.setImageResource(R.g.free_wifi_state_illegal_ap);
                this.jlT.setState(3);
                this.jlU.setText(R.l.free_wifi_illegal_ap_tile);
                this.jlU.setVisibility(0);
                this.jlV.setText(R.l.free_wifi_illegal_ap_tips);
                this.jlV.setVisibility(0);
                break;
            case 1:
                this.jlT.setImageResource(R.g.free_wifi_state_normal);
                this.jlT.setState(1);
                this.jlU.setText(R.l.connect_state_connecting);
                break;
            case 2:
                this.jlT.setImageResource(R.g.free_wifi_state_connected);
                this.jlT.setState(2);
                this.jlU.setText(R.l.connect_state_connected);
                this.jlW.setVisibility(0);
                this.jlW.setText(R.l.free_wifi_back);
                this.jmc.SO();
                this.jmd.SO();
                if (this.source == 1 || this.source == 5 || this.source == 4) {
                    this.jlW.setVisibility(4);
                    c Cg = com.tencent.mm.plugin.freewifi.model.j.aOK().Cg(this.ssid);
                    if (!(Cg == null || bi.oW(Cg.field_showUrl) || this.jmb)) {
                        this.jmb = true;
                        ah.i(new 9(this, Cg), 1000);
                    }
                }
                d.xP();
                return;
            case 3:
                this.jlT.setImageResource(R.g.free_wifi_state_normal);
                this.jlT.setState(3);
                this.jlT.iCE = 2;
                this.jlU.setText(R.l.connect_state_failed);
                this.jlW.setVisibility(0);
                this.jlW.setText(R.l.free_wifi_re_connect);
                this.jmc.SO();
                this.jmd.SO();
                return;
            default:
                this.jlT.setImageResource(R.g.free_wifi_state_normal);
                this.jlU.setText(R.l.connect_state_connecting);
                if (this.source != 3) {
                    this.jlV.setText(getString(R.l.connect_state_connecting_tips, new Object[]{this.ssid}));
                    break;
                }
                this.jlV.setText(getString(R.l.mig_connect_state_connecting_tips, new Object[]{this.ssid}));
                break;
        }
        this.jlW.setVisibility(8);
    }

    protected final int getLayoutId() {
        return R.i.free_wifi_state;
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
        x.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now wifi state : %d", new Object[]{Integer.valueOf(i)});
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
        finish();
        if (getIntent().getBooleanExtra("free_wifi_jump_to_main_ui", false)) {
            g.ezn.i(new Intent(), this);
        }
    }
}
