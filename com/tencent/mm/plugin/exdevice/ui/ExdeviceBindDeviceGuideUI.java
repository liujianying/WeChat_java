package com.tencent.mm.plugin.exdevice.ui;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import junit.framework.Assert;

public class ExdeviceBindDeviceGuideUI extends MMActivity implements e {
    private ListView CU;
    private String cZH;
    private Button eWk;
    BroadcastReceiver hiJ = new 4(this);
    private TextView iAA;
    private ScrollView iAB;
    private ImageView iAC;
    private TextView iAD;
    private String iAE;
    private String iAF;
    private String iAG;
    private String iAH;
    private long iAI;
    private ArrayList<String> iAJ;
    private String iAK;
    private boolean iAL = false;
    private boolean iAM = false;
    private String iAa;
    private String iAb;
    private TextView iAg;
    private LocationManager iAj;
    private boolean iAk = false;
    private a iAy;
    private Button iAz;
    private String ius;
    private String iut;
    private String izI;
    private String pM;

    private static final class a extends BaseAdapter {
        private ArrayList<String> iAO;

        private static class a {
            TextView iAP;
            TextView iAQ;
            View iAR;
            View iAS;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }
        }

        public a(ArrayList<String> arrayList) {
            this.iAO = arrayList;
        }

        public final int getCount() {
            if (this.iAO != null) {
                return this.iAO.size();
            }
            return 0;
        }

        private String jl(int i) {
            if (this.iAO == null || this.iAO.size() <= 0) {
                return null;
            }
            return (String) this.iAO.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (this.iAO == null || this.iAO.size() <= 0) {
                return null;
            }
            a aVar;
            CharSequence jl = jl(i);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(viewGroup.getContext(), R.i.exdevice_bind_device_guide_item, null);
                aVar2.iAQ = (TextView) view.findViewById(R.h.contentTV);
                aVar2.iAP = (TextView) view.findViewById(R.h.stepTV);
                aVar2.iAR = view.findViewById(R.h.topView);
                aVar2.iAS = view.findViewById(R.h.bottomView);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.iAP.setText(Integer.toString(i + 1));
            aVar.iAQ.setText(jl);
            if (i == 0 && this.iAO.size() == 1) {
                aVar.iAR.setVisibility(4);
                aVar.iAS.setVisibility(4);
                return view;
            } else if (i == 0) {
                aVar.iAR.setVisibility(4);
                aVar.iAS.setVisibility(0);
                return view;
            } else if (i != this.iAO.size() - 1) {
                return view;
            } else {
                aVar.iAS.setVisibility(4);
                aVar.iAR.setVisibility(0);
                return view;
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.exdevice_bind_device_guide_ui;
    }

    public void onCreate(Bundle bundle) {
        IntentFilter intentFilter;
        super.onCreate(bundle);
        setBackBtn(new 1(this));
        if (!(!d.fR(23) || VERSION.RELEASE.equalsIgnoreCase("6.0") || VERSION.RELEASE.equalsIgnoreCase("6.0.0"))) {
            x.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth limited version(%s)", new Object[]{VERSION.RELEASE});
            this.iAk = true;
        }
        Intent intent = getIntent();
        this.iAE = intent.getStringExtra("device_scan_mode");
        this.iAF = intent.getStringExtra("device_scan_conn_proto");
        this.iut = intent.getStringExtra("device_id");
        this.izI = intent.getStringExtra("device_type");
        this.iAG = intent.getStringExtra("device_title");
        this.iAa = intent.getStringExtra("device_desc");
        this.iAb = intent.getStringExtra("device_icon_url");
        this.pM = intent.getStringExtra("device_category_id");
        this.ius = intent.getStringExtra("device_brand_name");
        this.iAH = intent.getStringExtra("bind_ticket");
        this.iAI = intent.getLongExtra("device_ble_simple_proto", -1);
        this.iAJ = intent.getStringArrayListExtra("device_airkiss_steps");
        this.iAK = intent.getStringExtra("device_airkiss_key");
        this.cZH = intent.getStringExtra("device_airkiss_title");
        x.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Category config guide steps(%d)", new Object[]{Integer.valueOf(this.iAJ.size())});
        this.iAj = (LocationManager) this.mController.tml.getSystemService("location");
        this.CU = (ListView) findViewById(R.h.contentList);
        View inflate = View.inflate(this, R.i.exdeivce_bind_device_guide_ui_header, null);
        this.iAA = (TextView) inflate.findViewById(R.h.titleTV);
        this.iAy = new a(this.iAJ);
        this.CU.addHeaderView(inflate);
        this.CU.setDividerHeight(0);
        this.CU.setClickable(false);
        this.CU.setFooterDividersEnabled(false);
        this.CU.setAdapter(this.iAy);
        this.iAC = (ImageView) findViewById(R.h.logoTV);
        this.iAB = (ScrollView) findViewById(R.h.guideListScrollView);
        this.iAz = (Button) findViewById(R.h.connectButton);
        this.eWk = (Button) findViewById(R.h.nextButton);
        this.iAg = (TextView) findViewById(R.h.errTips);
        this.iAD = (TextView) findViewById(R.h.errTipsDetail);
        String str = "";
        if (this.iAE.compareTo("SCAN_CATALOG") != 0) {
            Assert.assertTrue(false);
        } else if (this.iAF.contains("wifi")) {
            this.iAL = true;
            str = this.mController.tml.getString(R.l.exdevice_connect_wifi);
        } else if (this.iAF.contains("blue")) {
            this.iAM = true;
            str = this.mController.tml.getString(R.l.exdevice_bind_device_help_prepare);
        } else {
            Assert.assertTrue(false);
        }
        setMMTitle(str);
        if (this.iAM && !this.iAL) {
            if (!com.tencent.mm.plugin.h.a.e.a.cT(this.mController.tml)) {
                x.i("MicroMsg.ExdeviceBindDeviceGuideUI", "now sdk version not support ble device : %d", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
                pc(4);
            } else if (!com.tencent.mm.plugin.h.a.e.a.atY()) {
                x.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth is not open, Just leave");
                pc(3);
            } else if (!(this.iAj == null || !this.iAk || this.iAj.isProviderEnabled("gps"))) {
                x.i("MicroMsg.ExdeviceBindDeviceGuideUI", "BLE limited version, GPS do not open");
                pc(6);
            }
            this.iAz.setOnClickListener(new 2(this));
            this.eWk.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (ExdeviceBindDeviceGuideUI.this.iAL && !ExdeviceBindDeviceGuideUI.this.iAM) {
                        Intent intent = new Intent();
                        intent.putExtra("device_scan_mode", ExdeviceBindDeviceGuideUI.this.iAE);
                        intent.putExtra("device_scan_conn_proto", ExdeviceBindDeviceGuideUI.this.iAF);
                        intent.putExtra("device_id", ExdeviceBindDeviceGuideUI.this.iut);
                        intent.putExtra("device_type", ExdeviceBindDeviceGuideUI.this.izI);
                        intent.putExtra("device_title", ExdeviceBindDeviceGuideUI.this.iAG);
                        intent.putExtra("device_desc", ExdeviceBindDeviceGuideUI.this.iAa);
                        intent.putExtra("device_icon_url", ExdeviceBindDeviceGuideUI.this.iAb);
                        intent.putExtra("device_category_id", ExdeviceBindDeviceGuideUI.this.pM);
                        intent.putExtra("device_brand_name", ExdeviceBindDeviceGuideUI.this.ius);
                        intent.putExtra("bind_ticket", ExdeviceBindDeviceGuideUI.this.iAH);
                        com.tencent.mm.bg.d.b(ExdeviceBindDeviceGuideUI.this.mController.tml, "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
                    }
                }
            });
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.location.MODE_CHANGED");
            this.mController.tml.registerReceiver(this.hiJ, intentFilter);
        }
        if (!this.iAM && this.iAL && !ao.isWifi(this.mController.tml)) {
            x.i("MicroMsg.ExdeviceBindDeviceGuideUI", "wifi is not open, Just leave");
            pc(5);
            this.iAz.setOnClickListener(new 2(this));
            this.eWk.setOnClickListener(/* anonymous class already generated */);
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.location.MODE_CHANGED");
            this.mController.tml.registerReceiver(this.hiJ, intentFilter);
        } else if (!this.iAL || this.iAM) {
            if (this.iAM && !this.iAL) {
                pc(2);
            }
            this.iAz.setOnClickListener(new 2(this));
            this.eWk.setOnClickListener(/* anonymous class already generated */);
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.location.MODE_CHANGED");
            this.mController.tml.registerReceiver(this.hiJ, intentFilter);
        } else {
            pc(1);
            this.iAz.setOnClickListener(new 2(this));
            this.eWk.setOnClickListener(/* anonymous class already generated */);
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.location.MODE_CHANGED");
            this.mController.tml.registerReceiver(this.hiJ, intentFilter);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.mController.tml.unregisterReceiver(this.hiJ);
    }

    public final void a(int i, int i2, String str, l lVar) {
    }

    private void pc(int i) {
        switch (i) {
            case 1:
                this.iAz.setText(this.mController.tml.getString(R.l.exdevice_connect_wifi));
                this.eWk.setText(this.mController.tml.getString(R.l.exdevice_already_connect_wifi));
                this.iAA.setText(this.mController.tml.getString(R.l.exdevice_connect_wifi_guide));
                break;
            case 2:
                this.iAz.setText(this.mController.tml.getString(R.l.exdevice_connect_bt_next));
                this.eWk.setVisibility(8);
                this.iAA.setText(this.mController.tml.getString(R.l.exdevice_connect_bt_guide));
                break;
            case 3:
                this.iAC.setImageResource(R.k.bluetooth_logo);
                this.iAg.setText(R.l.exdevice_can_not_scan);
                this.iAD.setText(R.l.exdevice_bind_device_blue_no_open_detail);
                break;
            case 4:
                this.iAC.setImageResource(R.k.bluetooth_logo);
                this.iAg.setText(R.l.exdevice_ble_version_below_4_0);
                this.iAD.setText("");
                break;
            case 5:
                this.iAC.setImageResource(R.k.wifi_logo);
                this.iAg.setText(R.l.exdevice_can_not_scan);
                this.iAD.setText(R.l.exdevice_bind_device_wifi_no_open_detail);
                break;
            case 6:
                this.iAC.setImageResource(R.k.bluetooth_logo);
                this.iAg.setText(R.l.exdevice_can_not_scan);
                this.iAD.setText(R.l.exdevice_gps_not_open);
                break;
        }
        switch (i) {
            case 1:
            case 2:
                this.iAC.setVisibility(8);
                this.iAg.setVisibility(8);
                this.iAD.setVisibility(8);
                this.CU.setVisibility(0);
                this.iAB.setVisibility(0);
                return;
            case 3:
            case 4:
            case 5:
            case 6:
                this.iAC.setVisibility(0);
                this.iAg.setVisibility(0);
                this.CU.setVisibility(8);
                this.iAB.setVisibility(8);
                if (i == 4) {
                    this.iAD.setVisibility(8);
                    return;
                } else {
                    this.iAD.setVisibility(0);
                    return;
                }
            default:
                return;
        }
    }
}
