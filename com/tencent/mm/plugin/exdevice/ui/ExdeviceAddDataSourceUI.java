package com.tencent.mm.plugin.exdevice.ui;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.eh;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.e.b;
import com.tencent.mm.plugin.exdevice.model.l;
import com.tencent.mm.plugin.exdevice.model.t;
import com.tencent.mm.plugin.h.a.e.a;
import com.tencent.mm.protocal.c.biv;
import com.tencent.mm.protocal.c.hd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceAddDataSourceUI extends MMActivity implements e, b {
    private ListView CU;
    private p fUo;
    private final BroadcastReceiver hiJ = new 4(this);
    private a iAd;
    private List<b> iAe;
    private TextView iAf;
    private TextView iAg;
    private TextView iAh;
    private RelativeLayout iAi;
    private LocationManager iAj;
    private boolean iAk = false;
    private l iAl;
    private View iln;

    private enum c {
        ;

        static {
            iAu = 1;
            iAv = 2;
            iAw = 3;
            iAx = new int[]{iAu, iAv, iAw};
        }
    }

    protected final int getLayoutId() {
        return R.i.exdevice_add_data_source_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new 1(this));
        setMMTitle(R.l.exdevice_add_data_source);
        if (!(!d.fR(23) || VERSION.RELEASE.equalsIgnoreCase("6.0") || VERSION.RELEASE.equalsIgnoreCase("6.0.0"))) {
            this.iAk = true;
        }
        this.iAe = new LinkedList();
        this.iAj = (LocationManager) this.mController.tml.getSystemService("location");
        initView();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.location.MODE_CHANGED");
        this.mController.tml.registerReceiver(this.hiJ, intentFilter);
        au.DF().a(536, this);
        au.DF().a(1706, this);
        ad.aHp().a(this);
        if (!a.cT(this.mController.tml)) {
            x.i("MicroMsg.ExdeviceAddDataSourceUI", "now sdk version not support ble device : %d", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
            pc(2);
        } else if (!a.atY()) {
            x.i("MicroMsg.ExdeviceAddDataSourceUI", "Bluetooth is not open, Just leave");
            pc(1);
        } else if (this.iAj == null || !this.iAk || this.iAj.isProviderEnabled(TencentLocationListener.GPS)) {
            ad.aHp();
            com.tencent.mm.plugin.exdevice.model.e.aGR();
        } else {
            x.i("MicroMsg.ExdeviceAddDataSourceUI", "Android 6.0.1, gps not open");
            pc(4);
        }
    }

    private void pc(int i) {
        switch (i) {
            case 1:
                this.iAi.setVisibility(8);
                this.iAg.setText(R.l.exdevice_can_not_scan);
                this.iAh.setText(R.l.exdevice_bind_device_blue_no_open_detail);
                return;
            case 2:
                this.iAi.setVisibility(8);
                this.iAg.setText(R.l.exdevice_ble_version_below_4_0);
                this.iAh.setText("");
                return;
            case 3:
                this.iAi.setVisibility(0);
                this.iln.setVisibility(0);
                return;
            case 4:
                this.iAi.setVisibility(8);
                this.iAg.setText(R.l.exdevice_can_not_scan);
                this.iAh.setText(R.l.exdevice_gps_not_open);
                return;
            default:
                return;
        }
    }

    protected final void initView() {
        this.CU = (ListView) findViewById(R.h.listview);
        View inflate = View.inflate(this, R.i.exdevice_add_data_source_ui_header, null);
        this.iAi = (RelativeLayout) findViewById(R.h.searchLayout);
        this.iln = View.inflate(this, R.i.exdevice_add_data_source_ui_footer, null);
        this.iAf = (TextView) findViewById(R.h.scanHelpTV);
        this.iAg = (TextView) findViewById(R.h.errTips);
        this.iAh = (TextView) findViewById(R.h.errTipsDetail);
        String string = getString(R.l.exdevice_scan_device_help_tips);
        String string2 = getString(R.l.exdevice_connect_device_help);
        CharSequence spannableString = new SpannableString(string + string2);
        spannableString.setSpan(new ForegroundColorSpan(R.e.link_color), string.length(), string.length() + string2.length(), 33);
        spannableString.setSpan(new 5(this), string.length(), string.length() + string2.length(), 33);
        this.iAf.setMovementMethod(LinkMovementMethod.getInstance());
        this.iAf.setText(spannableString);
        this.CU.addHeaderView(inflate, null, false);
        this.CU.addFooterView(this.iln, null, false);
        this.iAd = new a();
        this.CU.setAdapter(this.iAd);
        this.CU.setOnItemClickListener(new 6(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        au.Em().H(new 7(this));
        au.DF().b(536, this);
        au.DF().b(1706, this);
        this.mController.tml.unregisterReceiver(this.hiJ);
        ad.aHp().b(this);
        ad.aHq().atI();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.ExdeviceAddDataSourceUI", "errType(%d), errCode(%d), errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (lVar == null) {
            x.e("MicroMsg.ExdeviceAddDataSourceUI", "netscene is null.");
        } else if (lVar.getType() == 536) {
            aHL();
            this.iAl = null;
            hd aGX = ((l) lVar).aGX();
            if (i == 0 && i2 == 0) {
                Intent intent = new Intent();
                intent.putExtra("device_mac", com.tencent.mm.plugin.exdevice.j.b.Az(com.tencent.mm.plugin.exdevice.j.b.AA(aGX.rhl.rgL)));
                ao(com.tencent.mm.plugin.exdevice.j.b.AA(aGX.rhl.rgL), false);
                setResult(-1, intent);
                finish();
                return;
            }
            b Aq = this.iAd.Aq(com.tencent.mm.plugin.exdevice.j.b.AA(aGX.rhl.rgL));
            if (Aq != null) {
                Aq.iAt = c.iAu;
                ao(Aq.mac, false);
            }
            x.e("MicroMsg.ExdeviceAddDataSourceUI", "doScene failed.");
        } else if (lVar.getType() == 1706) {
            biv aHa = ((t) lVar).aHa();
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.ExdeviceAddDataSourceUI", "HardDeviceAttr_bleSimpleProtol(%d)", new Object[]{Long.valueOf(aHa.rhl.cCW)});
                if (0 == (aHa.rhl.cCW & 1)) {
                    return;
                }
                if (ad.aHe().cz(aHa.rhk.hbO, aHa.rhk.reT) != null) {
                    x.i("MicroMsg.ExdeviceAddDataSourceUI", "(%s)has been bound.", new Object[]{aHa.rhl.rgL});
                    return;
                }
                b bVar = new b((byte) 0);
                bVar.name = aHa.rgR.rQz == null ? "" : ab.a(aHa.rgR.rQz);
                bVar.mac = com.tencent.mm.plugin.exdevice.j.b.AA(aHa.rhl.rgL);
                bVar.bLe = aHa.rgQ;
                bVar.iconUrl = aHa.rhl.jPG;
                this.iAe.add(bVar);
                x.i("MicroMsg.ExdeviceAddDataSourceUI", "Add device, mac(%s), name(%s)", new Object[]{bVar.mac, bVar.name});
                runOnUiThread(new 8(this));
                return;
            }
            x.e("MicroMsg.ExdeviceAddDataSourceUI", "NetSceneSearchBLEHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        }
    }

    public final void j(String str, String str2, boolean z) {
        x.d("MicroMsg.ExdeviceAddDataSourceUI", "onScanResult, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[]{str, str2, Boolean.valueOf(z)});
        if (z) {
            runOnUiThread(new 9(this));
        }
        if (bi.oW(str2)) {
            x.e("MicroMsg.ExdeviceAddDataSourceUI", "onScanResult failed, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[]{str, str2, Boolean.valueOf(z)});
            return;
        }
        int i = 0;
        while (i < this.iAe.size()) {
            int i2;
            b bVar = (b) this.iAe.get(i);
            if (bVar == null || bi.oW(bVar.mac)) {
                i2 = i - 1;
                this.iAe.remove(i);
            } else if (bVar.mac.equalsIgnoreCase(str2)) {
                x.i("MicroMsg.ExdeviceAddDataSourceUI", "the device(%s) has added into the list before.", new Object[]{str2});
                return;
            } else {
                i2 = i;
            }
            i = i2 + 1;
        }
        boolean a = au.DF().a(new t(str2.replaceAll(":", ""), null, null), 0);
        x.i("MicroMsg.ExdeviceAddDataSourceUI", "SearchBLEHardDevice doScene result(%s), mac(%s)", new Object[]{Boolean.valueOf(a), str2});
    }

    public final void d(String str, int i, long j) {
        if (bi.oW(str)) {
            x.e("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, mac is null or nil.");
            return;
        }
        b Aq = this.iAd.Aq(str);
        if (Aq == null) {
            x.w("MicroMsg.ExdeviceAddDataSourceUI", "onConnectStateChanged, info is null.(%s)", new Object[]{str});
            return;
        }
        if (Aq.iAt == c.iAv && i == 4) {
            Aq.iAt = c.iAu;
            aHL();
            runOnUiThread(new 10(this, Aq));
        } else if (i == 2) {
            if (Aq.iAt == c.iAv) {
                Aq.iAt = c.iAw;
                x.i("MicroMsg.ExdeviceAddDataSourceUI", "Bind Hard device, mac(%s), name(%s)", new Object[]{Aq.mac, Aq.name});
                if (Aq.bLe != null) {
                    this.iAl = new l(Aq.bLe, 0);
                    au.DF().a(this.iAl, 0);
                }
            } else {
                x.i("MicroMsg.ExdeviceAddDataSourceUI", "try to disconnect, mac : %s.", new Object[]{str});
                ao(str, false);
            }
        } else if (i != 1 && i != 2) {
            Aq.iAt = c.iAu;
        } else {
            return;
        }
        runOnUiThread(new 11(this));
    }

    public final void b(String str, byte[] bArr, boolean z) {
    }

    private static boolean ao(String str, boolean z) {
        eh ehVar = new eh();
        ehVar.bMh.mac = str;
        ehVar.bMh.bKD = z;
        if (com.tencent.mm.sdk.b.a.sFg.m(ehVar)) {
            return true;
        }
        x.i("MicroMsg.ExdeviceAddDataSourceUI", "connect failed, mac(%s).", new Object[]{str});
        return false;
    }

    private void aHL() {
        runOnUiThread(new 2(this));
    }
}
