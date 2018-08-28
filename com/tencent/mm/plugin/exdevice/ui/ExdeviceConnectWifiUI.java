package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.MulticastLock;
import android.os.Bundle;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.exdevice.d.a;
import com.tencent.mm.plugin.exdevice.d.b;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;

public class ExdeviceConnectWifiUI extends MMActivity {
    private TextWatcher UE;
    private EditText eQO;
    private View iBH;
    private TextView iBI;
    private View iBJ;
    private View iBK;
    private p iBL;
    private WifiInfo iBM;
    private a iBN;
    private String iBO;
    private boolean iBP;
    private boolean iBQ;
    private boolean iBR;
    private int iBS;
    private byte[] iBT;
    private int iBU;
    private int iBV;
    private int iBW;
    private String iBX = "";
    private int iBY;
    private long iBZ;
    boolean iCa = false;
    private b iCb;
    private int iCc;
    private n iCd;
    private j.a iCe;
    private MulticastLock iCf;
    private Runnable iCg = new 1(this);
    private String iil = "";

    static /* synthetic */ void q(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        if (exdeviceConnectWifiUI.iBM == null) {
            x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "wifiInfo is null.");
            return;
        }
        String ssid = exdeviceConnectWifiUI.iBM.getSSID();
        String oV = bi.oV(exdeviceConnectWifiUI.getPassword());
        if (bi.oW(ssid)) {
            x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid is null or nil.");
            return;
        }
        if (bi.oW(exdeviceConnectWifiUI.iBN.iwF) || (ssid.equals(exdeviceConnectWifiUI.iBN.iwF) && !oV.equals(exdeviceConnectWifiUI.iBN.iwG))) {
            a Z = exdeviceConnectWifiUI.Z(exdeviceConnectWifiUI.iBS, ssid);
            if (Z == null) {
                Z = new a();
                Z.iwF = ssid;
                Z.iwE = exdeviceConnectWifiUI.iBS;
                exdeviceConnectWifiUI.iCb.iwH.add(Z);
            }
            Z.iwG = com.tencent.mm.plugin.base.model.b.bT(oV, a.aa(exdeviceConnectWifiUI.iBS, ssid));
        } else if (!exdeviceConnectWifiUI.iBP) {
            x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "password hasn't changed, so do not need to save.");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        ssid = stringBuilder.append(c.Gq()).append("exdevice_wifi_infos").toString();
        try {
            byte[] toByteArray = exdeviceConnectWifiUI.iCb.toByteArray();
            e.b(ssid, toByteArray, toByteArray.length);
        } catch (Throwable e) {
            x.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", e.getMessage());
            x.printErrStackTrace("MicroMsg.exdevice.ExdeviceConnectWifiUI", e, "", new Object[0]);
        }
        x.v("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Current wifiInfo was save to file(%s).", new Object[]{ssid});
    }

    static /* synthetic */ void r(ExdeviceConnectWifiUI exdeviceConnectWifiUI) {
        Java2CExDevice.stopAirKiss();
        exdeviceConnectWifiUI.ey(true);
        if (exdeviceConnectWifiUI.iCf.isHeld()) {
            exdeviceConnectWifiUI.iCf.release();
        }
    }

    protected final int getLayoutId() {
        return R.i.exdevice_connect_wifi;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iCd = new 8(this);
        this.iCc = b.iCr;
        if (au.HX()) {
            this.iCb = new b();
            this.iBN = new a();
            au.HU();
            this.iBS = c.Df();
            String stringExtra = getIntent().getStringExtra("encryptKey");
            this.iBU = getIntent().getIntExtra("procInterval", 0);
            this.iBV = getIntent().getIntExtra("dataInterval", 0);
            x.d("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Process interval:" + this.iBU + " Data interval:" + this.iBV);
            if (!bi.oW(stringExtra)) {
                this.iBT = Base64.decode(stringExtra, 0);
                this.iBY = 1;
            }
            this.iCa = false;
            this.iBW = getIntent().getExtras().getInt("exdevice_airkiss_open_type");
            if (this.iBW == 2) {
                this.iBX = getIntent().getStringExtra("device_brand_name");
                this.iil = getIntent().getStringExtra("device_category_id");
            }
            this.iCe = new 9(this);
            j.aGV().a(0, this.iCe);
            initView();
            au.Em().H(new 3(this));
            pf(1);
            this.iCf = ((WifiManager) getSystemService("wifi")).createMulticastLock("localWifi");
            return;
        }
        finish();
    }

    protected void onResume() {
        super.onResume();
        ey(false);
        au.a(this.iCd);
        if (this.iBQ) {
            aHO();
            this.iBQ = false;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!this.iCa) {
            pf(2);
        }
        j.aGV().b(0, this.iCe);
    }

    protected void onStop() {
        super.onStop();
        au.b(this.iCd);
    }

    protected final void initView() {
        setMMTitle(R.l.exdevice_connect_wifi);
        setBackBtn(new 10(this));
        this.iBH = findViewById(R.h.setDeviceWifiPwPanel);
        this.iBI = (TextView) findViewById(R.h.nameTV);
        this.iBJ = findViewById(R.h.alertView);
        this.eQO = (EditText) findViewById(R.h.passwordET);
        this.iBK = findViewById(R.h.connetBtn);
        this.UE = new 11(this);
        this.iBH.setOnTouchListener(new 12(this));
        this.iBK.setOnClickListener(new 13(this));
        this.eQO.setTransformationMethod(new PasswordTransformationMethod());
        this.eQO.addTextChangedListener(this.UE);
        this.eQO.setOnEditorActionListener(new 14(this));
        this.eQO.setOnKeyListener(new 15(this));
        this.eQO.requestFocus();
    }

    private void pf(int i) {
        long j = 0;
        if (i == 4) {
            j = System.currentTimeMillis() - this.iBZ;
        }
        h.mEJ.h(13503, new Object[]{Integer.valueOf(i), Integer.valueOf(this.iBW), Long.valueOf(j), this.iBX, this.iil, Integer.valueOf(this.iBY)});
    }

    private a Z(int i, String str) {
        if (bi.oW(str) || this.iCb == null) {
            x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "ssid or wifiInfoList is null or nil.");
            return null;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.iCb.iwH.size()) {
                return null;
            }
            a aVar = (a) this.iCb.iwH.get(i3);
            if (aVar == null) {
                i2 = i3 - 1;
                this.iCb.iwH.remove(i3);
                this.iBP = true;
                i3 = i2;
            } else if (aVar.iwE == i && str.equals(aVar.iwF)) {
                return aVar;
            }
            i2 = i3 + 1;
        }
    }

    private void aHO() {
        if (this.iBM == null) {
            x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "wifiInfo is null, delay to fill.");
            this.iBQ = true;
            return;
        }
        this.iBN.iwG = "";
        this.iBN.iwF = "";
        a Z = Z(this.iBS, this.iBM.getSSID());
        if (Z == null) {
            return;
        }
        if (bi.oW(Z.iwG)) {
            x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Do not have a local password to fill for the current wifi.");
            this.iCb.iwH.remove(Z);
            this.iBP = true;
            return;
        }
        this.iBN.iwG = com.tencent.mm.plugin.base.model.b.bT(Z.iwG, a.aa(this.iBS, Z.iwF));
        this.iBN.iwF = Z.iwF;
        ah.A(this.iCg);
    }

    private String getPassword() {
        return this.eQO.getText() != null ? this.eQO.getText().toString() : null;
    }

    private void ey(boolean z) {
        this.iBM = ao.getWifiInfo(this);
        int i = z ? b.iCr : this.iCc;
        if (this.iBM == null) {
            i = b.iCs;
        } else {
            String ssid = this.iBM.getSSID();
            x.i("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Get SSID(%s)", new Object[]{ssid});
            if (bi.oW(ssid)) {
                this.iBI.setText("");
            } else {
                this.iBI.setText(ssid.replaceAll("\"", ""));
            }
            if (!(bi.oW(ssid) || ssid.equals(this.iBO))) {
                this.iBO = ssid;
            }
        }
        pg(i);
    }

    public final synchronized void pg(int i) {
        if (i == 0) {
            x.e("MicroMsg.exdevice.ExdeviceConnectWifiUI", "Status is null.");
        } else {
            this.iCc = i;
            switch (7.iCn[i - 1]) {
                case 1:
                    f(true, false, false);
                    break;
                case 2:
                    f(true, true, false);
                    break;
                case 3:
                    f(false, false, false);
                    break;
                case 4:
                    pf(5);
                    this.iBR = true;
                    setResult(1);
                    break;
                case 5:
                    pf(4);
                    f(true, false, true);
                    this.iBR = true;
                    setResult(-1);
                    au.Em().H(new 4(this));
                    if (getIntent().getBooleanExtra("jumpToBindDevice", false)) {
                        Intent intent = new Intent();
                        intent.putExtra("device_scan_mode", getIntent().getStringExtra("device_scan_mode"));
                        intent.putExtra("device_scan_conn_proto", getIntent().getStringExtra("device_scan_conn_proto"));
                        intent.putExtra("device_id", getIntent().getStringExtra("device_id"));
                        intent.putExtra("device_type", getIntent().getStringExtra("device_type"));
                        intent.putExtra("device_title", getIntent().getStringExtra("device_title"));
                        intent.putExtra("device_desc", getIntent().getStringExtra("device_desc"));
                        intent.putExtra("device_icon_url", getIntent().getStringExtra("device_icon_url"));
                        intent.putExtra("device_category_id", getIntent().getStringExtra("device_category_id"));
                        intent.putExtra("device_brand_name", getIntent().getStringExtra("device_brand_name"));
                        intent.putExtra("bind_ticket", getIntent().getStringExtra("bind_ticket"));
                        d.b(this.mController.tml, "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
                        break;
                    }
                    break;
            }
            finish();
            if (i != b.iCr) {
                this.eQO.clearFocus();
                YC();
            }
        }
    }

    private void f(boolean z, boolean z2, boolean z3) {
        this.iBH.setVisibility(z ? 0 : 8);
        if (z2) {
            runOnUiThread(new 5(this));
        } else {
            runOnUiThread(new 6(this));
            if (this.iCf.isHeld()) {
                this.iCf.release();
            }
        }
        if (z3) {
            Toast.makeText(this.mController.tml, R.l.exdevice_connected, 0).show();
        }
    }
}
