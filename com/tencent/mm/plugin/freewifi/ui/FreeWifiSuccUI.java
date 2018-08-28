package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.c;

public class FreeWifiSuccUI extends MMActivity implements e {
    private String bPS;
    private String bPg;
    private CheckBox hHb;
    private String jkJ;
    private TextView jnP;
    private int jnW;
    private String jnX;
    private View joc;
    private TextView jod;
    private View joe;
    private TextView jof;
    private View jog;
    private Button joh;
    private int joi;
    private boolean joj = false;
    private boolean jok = false;
    private String signature;

    static /* synthetic */ void a(FreeWifiSuccUI freeWifiSuccUI) {
        freeWifiSuccUI.aPJ();
        WifiInfo aOA = d.aOA();
        a aOa = k.aOa();
        if (aOA != null) {
            String macAddress = aOA.getMacAddress();
            if (VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
                macAddress = m.aOf();
            }
            aOa.ssid = m.BQ(aOA.getSSID());
            aOa.bssid = aOA.getBSSID();
            aOa.bIR = macAddress;
        }
        aOa.bIQ = m.I(freeWifiSuccUI.getIntent());
        aOa.jic = freeWifiSuccUI.bPS;
        aOa.jid = m.E(freeWifiSuccUI.getIntent());
        aOa.jie = m.G(freeWifiSuccUI.getIntent());
        aOa.jif = b.jiv.jiQ;
        aOa.jig = b.jiv.name;
        aOa.bVU = m.H(freeWifiSuccUI.getIntent());
        aOa.jih = freeWifiSuccUI.bPg;
        aOa.aOc().aOb();
        if (freeWifiSuccUI.jnW == 1 && !bi.oW(freeWifiSuccUI.jnX)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", Uri.parse(freeWifiSuccUI.jnX).buildUpon().appendQueryParameter("lang", w.d(freeWifiSuccUI.getSharedPreferences(ad.chY(), 0))).build().toString());
            intent.putExtra("show_bottom", false);
            intent.putExtra("stastic_scene", 7);
            intent.putExtra("neverBlockLocalRequest", true);
            com.tencent.mm.bg.d.b(freeWifiSuccUI, "webview", ".ui.tools.WebViewUI", intent);
            x.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "jump to ad page after connect wifi success, url is : %s", new Object[]{intent.getStringExtra("rawUrl")});
        } else if (freeWifiSuccUI.jnW != 0 && freeWifiSuccUI.jnW == 3 && !bi.oW(freeWifiSuccUI.jnX)) {
            ((com.tencent.mm.plugin.appbrand.n.e) g.l(com.tencent.mm.plugin.appbrand.n.e.class)).b(freeWifiSuccUI, freeWifiSuccUI.jnX, 1078, null);
            x.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "jump to wxa after connect wifi success, url is : %s", new Object[]{freeWifiSuccUI.jnX});
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bPS = getIntent().getStringExtra("free_wifi_appid");
        this.jkJ = getIntent().getStringExtra("free_wifi_app_nickname");
        this.bPg = getIntent().getStringExtra("free_wifi_app_username");
        this.jnW = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
        this.jnX = getIntent().getStringExtra("free_wifi_finish_url");
        this.joi = getIntent().getIntExtra(c.thu, 0);
        this.signature = getIntent().getStringExtra("free_wifi_signature");
        x.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", new Object[]{this.bPS, this.jkJ, this.bPg, Integer.valueOf(this.jnW), this.jnX, this.signature});
        WifiInfo aOA = d.aOA();
        a aOa = k.aOa();
        String macAddress = aOA.getMacAddress();
        if (VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
            macAddress = m.aOf();
        }
        if (aOA != null) {
            aOa.ssid = m.BQ(aOA.getSSID());
            aOa.bssid = aOA.getBSSID();
            aOa.bIR = macAddress;
        }
        aOa.bIQ = getIntent().getStringExtra("free_wifi_ap_key");
        aOa.jic = this.bPS;
        aOa.jid = m.E(getIntent());
        aOa.jie = m.G(getIntent());
        aOa.jif = b.jir.jiQ;
        aOa.jig = b.jir.name;
        aOa.bVU = m.H(getIntent());
        aOa.jih = this.bPg;
        aOa.aOc().aOb();
    }

    protected void onResume() {
        super.onResume();
        initView();
    }

    public void finish() {
        super.finish();
        aPJ();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        au.DF().b(1703, this);
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.free_wifi_succ_page;
    }

    protected final void initView() {
        setMMTitle(R.l.free_wifi_title);
        lD(false);
        this.joc = findViewById(R.h.free_wifi_succ_follow_outter);
        this.jod = (TextView) findViewById(R.h.free_wifi_succ_follow_title_tv);
        this.hHb = (CheckBox) findViewById(R.h.free_wifi_succ_follow_cb);
        this.joe = findViewById(R.h.free_wifi_succ_appdesc_outter);
        this.jof = (TextView) findViewById(R.h.free_wifi_succ_appdesc_tv);
        this.jog = findViewById(R.h.free_wifi_succ_profile_outter);
        this.jnP = (TextView) findViewById(R.h.free_wifi_succ_appname_tv);
        this.joh = (Button) findViewById(R.h.connect_wifi_finish_btn);
        this.joh.setOnClickListener(new 1(this));
        if (bi.oW(this.bPS) || bi.oW(this.bPg) || bi.oW(this.jkJ)) {
            this.joc.setVisibility(8);
            this.joe.setVisibility(8);
            this.jog.setVisibility(8);
        } else if (s.hf(this.bPg) && s.he(this.bPg)) {
            com.tencent.mm.plugin.freewifi.l.b(d.aOB(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), true);
            this.joc.setVisibility(8);
            this.joe.setVisibility(8);
            this.jog.setVisibility(0);
            this.jnP.setText(this.jkJ);
            this.jog.setOnClickListener(new 2(this));
        } else {
            com.tencent.mm.plugin.freewifi.l.b(d.aOB(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), false);
            this.jog.setVisibility(8);
            this.joc.setVisibility(0);
            if (bi.oW(this.signature)) {
                this.joe.setVisibility(8);
                findViewById(R.h.free_wifi_succ_follow_item).setBackgroundColor(getResources().getColor(R.e.white));
            } else {
                this.joe.setVisibility(0);
                this.jof.setText(this.signature);
            }
            this.jod.setText(getString(R.l.free_wifi_follow_tips, new Object[]{this.jkJ}));
            if (this.joi == 1) {
                this.hHb.setChecked(true);
                this.joj = true;
            } else {
                this.hHb.setChecked(false);
                this.joj = false;
            }
            this.hHb.setOnCheckedChangeListener(new 3(this));
        }
        if (m.H(getIntent()) == 10) {
            final String str = q.deR.dfn;
            if (!m.isEmpty(str) && !m.isEmpty(q.br(this.mController.tml))) {
                Button button = (Button) findViewById(R.h.free_wifi_succui_manufacturer_link);
                button.setText(String.format(getString(R.l.free_wifi_succ_manu_wording), new Object[]{q.br(this.mController.tml)}));
                button.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", str);
                        com.tencent.mm.bg.d.b(FreeWifiSuccUI.this, "profile", ".ui.ContactInfoUI", intent);
                    }
                });
                button.setVisibility(0);
            }
        }
    }

    private void aPJ() {
        if (!this.jok) {
            this.jok = true;
            if (!(!this.joj || bi.oW(this.bPS) || (s.hf(this.bPg) && s.he(this.bPg)))) {
                au.DF().a(1703, this);
                au.DF().a(new i(this.bPS, getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_channel_id", 0), m.E(getIntent())), 0);
            }
            com.tencent.mm.plugin.freewifi.l.c(d.aOB(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), this.joj);
        }
    }
}
