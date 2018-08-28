package com.tencent.mm.plugin.exdevice.ui;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.e.b;
import com.tencent.mm.plugin.exdevice.model.j;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.plugin.exdevice.model.p;
import com.tencent.mm.plugin.exdevice.model.t;
import com.tencent.mm.plugin.exdevice.model.v;
import com.tencent.mm.protocal.c.aed;
import com.tencent.mm.protocal.c.aly;
import com.tencent.mm.protocal.c.aue;
import com.tencent.mm.protocal.c.biv;
import com.tencent.mm.protocal.c.bkb;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import junit.framework.Assert;
import org.json.JSONObject;

@SuppressLint({"Assert"})
public class ExdeviceBindDeviceUI extends MMActivity implements e, b {
    static final /* synthetic */ boolean $assertionsDisabled = (!ExdeviceBindDeviceUI.class.desiredAssertionStatus());
    private ListView CU;
    private ProgressDialog eHw;
    private ScrollView fPS;
    private TextView hEy;
    private a iAT;
    private View iAU;
    private TextView iAV;
    private ImageView iAW;
    private View iAX;
    private int iAY;
    private String iAZ;
    private TextView iAg;
    private TextView iAh;
    private String iBa;
    private boolean iBb = false;
    private a iBc;
    private boolean iBd = false;
    private boolean iBe = false;
    private String ius;
    private a ivf;
    private String izI;

    static /* synthetic */ void a(ExdeviceBindDeviceUI exdeviceBindDeviceUI, int i, int i2, String str, l lVar) {
        f As;
        if (lVar instanceof p) {
            if (exdeviceBindDeviceUI.eHw != null && exdeviceBindDeviceUI.eHw.isShowing()) {
                exdeviceBindDeviceUI.eHw.dismiss();
            }
            exdeviceBindDeviceUI.iBb = false;
            p pVar = (p) lVar;
            if (!(i == 0 && i2 == 0)) {
                x.e("MicroMsg.ExdeviceBindDeviceUI", "NetSceneGetHardDeviceHelpUrl onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            }
            exdeviceBindDeviceUI.iBa = ((aed) pVar.diG.dIE.dIL).rIq;
            String str2 = exdeviceBindDeviceUI.iBa;
            if (bi.oW(str2)) {
                x.i("MicroMsg.ExdeviceBindDeviceUI", "Jump to webview failed, url is null or nil.");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            d.b(exdeviceBindDeviceUI, "webview", ".ui.tools.WebViewUI", intent);
        } else if (lVar instanceof t) {
            biv aHa = ((t) lVar).aHa();
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            } else if (aHa.rhl == null) {
                x.e("MicroMsg.ExdeviceBindDeviceUI", "HardDeviceAttr is null");
            } else {
                As = exdeviceBindDeviceUI.iAT.As(aHa.rhl.rgL);
                if (As == null) {
                    x.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice is null");
                } else if (As.iBC != null) {
                    x.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice.mHardDevice is not null");
                } else {
                    As.iBD = aHa.rhl;
                    As.iBC = aHa.rhk;
                    As.iAH = aHa.rgQ;
                    As.iBF = aHa.rgR;
                    exdeviceBindDeviceUI.iAT.b(As);
                    exdeviceBindDeviceUI.iAT.notifyDataSetChanged();
                    x.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice onSceneEnd, deviceType(%s) deviceId(%s), title(%s), mac(%s), isEnterMainDevice(%d).", new Object[]{aHa.rhk.reT, aHa.rhk.hbO, aHa.rhl.rOC, aHa.rhl.rgL, Integer.valueOf(aHa.rhl.cCV)});
                }
            }
        } else if (!(lVar instanceof v)) {
        } else {
            if (i == 0 && i2 == 0) {
                bkb bkb = (bkb) ((v) lVar).diG.dIE.dIL;
                if (bkb.rhk == null) {
                    x.e("MicroMsg.ExdeviceBindDeviceUI", "HardDevice info is null");
                    return;
                }
                a aVar = exdeviceBindDeviceUI.iAT;
                String str3 = bkb.rhk.reT;
                String str4 = bkb.rhk.hbO;
                if (str3 == null || str3.length() == 0 || str4 == null || str4.length() == 0) {
                    As = null;
                } else {
                    int cC = aVar.cC(str3, str4);
                    As = cC < 0 ? null : (f) aVar.iBm.get(cC);
                }
                if (As == null) {
                    x.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice is null");
                    return;
                } else if (As.iBC != null) {
                    x.e("MicroMsg.ExdeviceBindDeviceUI", "DiscoverDevice.mHardDevice is not null");
                    return;
                } else {
                    As.iBD = bkb.rhl;
                    As.iBC = bkb.rhk;
                    As.iAH = bkb.rgQ;
                    As.iBF = bkb.rgR;
                    exdeviceBindDeviceUI.iAT.b(As);
                    exdeviceBindDeviceUI.iAT.notifyDataSetChanged();
                    x.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice onSceneEnd, deviceType(%s) deviceId(%s), title(%s), isEnterMainDevice(%d).", new Object[]{bkb.rhk.reT, bkb.rhk.hbO, bkb.rhl.rOC, Integer.valueOf(bkb.rhl.cCV)});
                    return;
                }
            }
            x.e("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        }
    }

    static /* synthetic */ void a(ExdeviceBindDeviceUI exdeviceBindDeviceUI, f fVar) {
        Intent intent = new Intent(exdeviceBindDeviceUI, ExdeviceDeviceProfileUI.class);
        aly aly = fVar.iBD;
        intent.putExtra("device_mac", aly.rgL);
        intent.putExtra("device_brand_name", aly.rOv);
        intent.putExtra("device_desc", aly.rOD);
        intent.putExtra("device_title", aly.rOC);
        intent.putExtra("device_icon_url", aly.jPG);
        intent.putExtra("device_alias", aly.eJM);
        intent.putExtra("device_jump_url", aly.jOU);
        intent.putExtra("bind_ticket", fVar.iAH);
        intent.putExtra("device_type", fVar.iBC.reT);
        intent.putExtra("device_id", fVar.iBC.hbO);
        intent.putExtra("hide_device_panel", true);
        intent.putExtra("subscribe_flag", fVar.iBE);
        if (fVar.iBz == b.iBr) {
            intent.putExtra("device_ble_simple_proto", aly.cCW);
        } else if (fVar.iBz != b.iBq) {
            Assert.assertTrue(false);
            return;
        }
        exdeviceBindDeviceUI.startActivityForResult(intent, 0);
    }

    static /* synthetic */ void b(ExdeviceBindDeviceUI exdeviceBindDeviceUI, f fVar) {
        if (fVar == null) {
            x.e("MicroMsg.ExdeviceBindDeviceUI", "Device == null");
        } else if (fVar.iBF == null) {
            x.e("MicroMsg.ExdeviceBindDeviceUI", "Device.contact == null");
        } else {
            aue aue = fVar.iBF;
            au.HU();
            ab Yg = c.FR().Yg(com.tencent.mm.platformtools.ab.a(aue.rvi));
            Intent intent = new Intent();
            intent.putExtra("device_id", fVar.iBC.hbO);
            intent.putExtra("device_type", fVar.iBC.reT);
            intent.putExtra("Contact_User", com.tencent.mm.platformtools.ab.a(aue.rvi));
            intent.putExtra("Contact_Scene", aue.ruu);
            intent.putExtra("KIsHardDevice", true);
            intent.putExtra("KHardDeviceBindTicket", fVar.iAH);
            if (Yg != null) {
                if (!com.tencent.mm.l.a.gd(Yg.field_type)) {
                    intent.putExtra("Contact_Alias", aue.eJM);
                    intent.putExtra("Contact_Nick", aue.rQz.toString());
                    intent.putExtra("Contact_Signature", aue.eJK);
                    intent.putExtra("Contact_RegionCode", RegionCodeDecoder.aq(aue.eJQ, aue.eJI, aue.eJJ));
                    intent.putExtra("Contact_Sex", aue.eJH);
                    intent.putExtra("Contact_VUser_Info", aue.rTf);
                    intent.putExtra("Contact_VUser_Info_Flag", aue.rTe);
                    intent.putExtra("Contact_KWeibo_flag", aue.rTi);
                    intent.putExtra("Contact_KWeibo", aue.rTg);
                    intent.putExtra("Contact_KWeiboNick", aue.rTh);
                    if (aue.rTl != null) {
                        try {
                            intent.putExtra("Contact_customInfo", aue.rTl.toByteArray());
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.ExdeviceBindDeviceUI", e, "", new Object[0]);
                        }
                    }
                }
                d.b(exdeviceBindDeviceUI.mController.tml, "profile", ".ui.ContactInfoUI", intent);
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.exdevice_bind_device_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new 1(this));
        Intent intent = getIntent();
        this.iAZ = intent.getStringExtra("device_category_id");
        this.ius = intent.getStringExtra("device_brand_name");
        this.izI = intent.getStringExtra("device_type");
        if (this.izI == null || this.izI.length() == 0) {
            this.izI = this.ius;
        }
        String stringExtra = intent.getStringExtra("device_scan_conn_proto");
        String stringExtra2 = intent.getStringExtra("device_scan_mode");
        String str = "";
        String stringExtra3 = intent.getStringExtra("device_title");
        if (bi.oW(stringExtra3)) {
            stringExtra3 = this.mController.tml.getString(R.l.exdevice_device_default_name);
        }
        if (stringExtra2.contains("SCAN_MY_DEVICE")) {
            this.iAY = e.iBv;
            str = this.mController.tml.getString(R.l.exdevice_add_device);
        } else if (stringExtra2.compareTo("SCAN_CATALOG") == 0) {
            this.iAY = e.iBw;
            str = this.mController.tml.getString(R.l.exdevice_add_catalog_device);
        } else {
            Assert.assertTrue(false);
        }
        setMMTitle(str);
        if (this.iAY == e.iBw) {
            this.iBd = stringExtra.contains("wifi");
            this.iBe = stringExtra.contains("blue");
            x.i("MicroMsg.ExdeviceBindDeviceUI", "mIsScanWifi(%b), mIsScanBlue(%b)", new Object[]{Boolean.valueOf(this.iBd), Boolean.valueOf(this.iBe)});
        } else if (this.iAY == e.iBv) {
            this.iBe = true;
            this.iBd = true;
        }
        this.ivf = new a() {
            public final void e(int i, Object... objArr) {
                Throwable e;
                if (i == 10 && objArr != null) {
                    String string;
                    String string2;
                    String string3;
                    try {
                        JSONObject jSONObject = new JSONObject(new String((byte[]) objArr[0]));
                        JSONObject jSONObject2 = jSONObject.getJSONObject("deviceInfo");
                        string = jSONObject2.getString("deviceType");
                        try {
                            string3 = jSONObject2.getString("deviceId");
                        } catch (Exception e2) {
                            e = e2;
                            string3 = null;
                        }
                        try {
                            if (!jSONObject.isNull("manufacturerData")) {
                                string2 = jSONObject.getString("manufacturerData");
                                if (string != null && string3 != null) {
                                    f fVar = new f(ExdeviceBindDeviceUI.this, (byte) 0);
                                    fVar.iBz = b.iBq;
                                    fVar.iBB = new d(ExdeviceBindDeviceUI.this, (byte) 0);
                                    fVar.iBB.izI = string;
                                    fVar.iBB.iut = string3;
                                    if (bi.oW(string2)) {
                                        fVar.iBG = null;
                                    } else {
                                        fVar.iBG = Base64.encodeToString(string2.getBytes(), 2);
                                        x.i("MicroMsg.ExdeviceBindDeviceUI", "device.mManufacturerData: %s", new Object[]{fVar.iBG});
                                    }
                                    ah.A(new 1(this, fVar));
                                    return;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            x.printErrStackTrace("MicroMsg.ExdeviceBindDeviceUI", e, "", new Object[0]);
                            x.e("MicroMsg.ExdeviceBindDeviceUI", "json decode failed: deviceInfo decode");
                            string2 = null;
                            if (string != null) {
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        string3 = null;
                        string = null;
                    }
                    string2 = null;
                    if (string != null) {
                    }
                }
            }
        };
        this.iBc = new 4(this);
        initView();
        this.hEy.setText(this.mController.tml.getString(R.l.exdevice_search_catalog_device, new Object[]{stringExtra3}));
        au.DF().a(1264, this);
        au.DF().a(1706, this);
        au.DF().a(1270, this);
        au.DF().a(1719, this);
        if (this.iBe) {
            ad.aHp().a(this);
        }
        if (this.iBd) {
            j.aGV().a(10, this.ivf);
            j.aGV().a(11, this.iBc);
            Java2CExDevice.initWCLanDeviceLib();
        }
    }

    protected void onResume() {
        super.onResume();
        x.i("MicroMsg.ExdeviceBindDeviceUI", "onResume start scan.");
        if (this.iBe) {
            ad.aHp();
            com.tencent.mm.plugin.exdevice.model.e.aGR();
        }
        if (this.iBd) {
            Java2CExDevice.startScanWCLanDevice(new byte[0], 1000);
        }
        this.iAT.aHM();
        this.iAT.notifyDataSetChanged();
    }

    protected final void initView() {
        this.CU = (ListView) findViewById(R.h.listview);
        View inflate = View.inflate(this, R.i.exdevice_bind_device_ui_header, null);
        this.iAX = View.inflate(this, R.i.exdevice_searching_device_tips_view, null);
        this.iAU = this.iAX.findViewById(R.h.searchingTipsV);
        this.hEy = (TextView) this.iAX.findViewById(R.h.tipsTV);
        this.iAV = (TextView) findViewById(R.h.scanHelpTV);
        this.iAW = (ImageView) findViewById(R.h.logoTV);
        this.iAg = (TextView) findViewById(R.h.errTips);
        this.iAh = (TextView) findViewById(R.h.errTipsDetail);
        this.fPS = (ScrollView) findViewById(R.h.devListScrollView);
        this.CU.addHeaderView(inflate, null, false);
        this.CU.addFooterView(this.iAX, null, false);
        this.iAT = new a(this.ius, this.iAY, this.iAZ);
        this.CU.setAdapter(this.iAT);
        this.CU.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                f pe = ExdeviceBindDeviceUI.this.iAT.pe(i - ((ListView) adapterView).getHeaderViewsCount());
                if (pe.iBD.cCV != 0) {
                    ExdeviceBindDeviceUI.a(ExdeviceBindDeviceUI.this, pe);
                } else {
                    ExdeviceBindDeviceUI.b(ExdeviceBindDeviceUI.this, pe);
                }
            }
        });
        if (this.iBe && !this.iBd) {
            if (!com.tencent.mm.plugin.h.a.e.a.cT(this.mController.tml)) {
                x.i("MicroMsg.ExdeviceBindDeviceUI", "now sdk version not support ble device : %d", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
                pc(4);
                return;
            } else if (!com.tencent.mm.plugin.h.a.e.a.atY()) {
                x.i("MicroMsg.ExdeviceBindDeviceUI", "Bluetooth is not open, Just leave");
                pc(3);
                return;
            }
        }
        if (!this.iBe && this.iBd && !ao.isWifi(this.mController.tml)) {
            x.i("MicroMsg.ExdeviceBindDeviceUI", "wifi is not open, Just leave");
            pc(5);
        } else if (this.iAY == e.iBv) {
            pc(0);
        } else if (this.iAY != e.iBw) {
            int i = e.iBu;
            Assert.assertTrue(false);
        } else if (this.iBe && this.iBd) {
            Assert.assertTrue(false);
            pc(1);
        } else if (this.iBe) {
            pc(2);
        } else if (this.iBd) {
            pc(1);
        }
    }

    protected void onPause() {
        super.onPause();
        x.i("MicroMsg.ExdeviceBindDeviceUI", "onPause stop scan.");
        if (this.iBd) {
            Java2CExDevice.stopScanWCLanDevice();
        }
        if (this.iBe) {
            ad.aHq().atI();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.iBd) {
            au.Em().H(new 6(this));
            j.aGV().b(10, this.ivf);
            j.aGV().b(11, this.iBc);
        }
        if (this.iBe) {
            ad.aHp().b(this);
            ad.aHq().atI();
        }
        au.DF().b(1264, this);
        au.DF().b(1706, this);
        au.DF().b(1270, this);
        au.DF().b(1719, this);
    }

    public final void j(String str, String str2, boolean z) {
        x.d("MicroMsg.ExdeviceBindDeviceUI", "onScanResult, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[]{str, str2, Boolean.valueOf(z)});
        if (bi.oW(str2)) {
            x.e("MicroMsg.ExdeviceBindDeviceUI", "onScanResult failed, broadcastName(%s), mac(%s), isCompleted(%b).", new Object[]{str, str2, Boolean.valueOf(z)});
            return;
        }
        f fVar = new f(this, (byte) 0);
        fVar.iBz = b.iBr;
        fVar.iBA = new c(this, (byte) 0);
        fVar.iBA.iBt = str;
        fVar.iBA.bvw = com.tencent.mm.plugin.exdevice.j.b.cZ(com.tencent.mm.plugin.exdevice.j.b.Az(str2));
        ah.A(new 7(this, fVar));
    }

    public final void d(String str, int i, long j) {
    }

    public final void b(String str, byte[] bArr, boolean z) {
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, errType(%d) errCode(%d) errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (lVar == null) {
            x.e("MicroMsg.ExdeviceBindDeviceUI", "onSceneEnd, scene is null.");
        } else {
            ah.A(new 8(this, i, i2, str, lVar));
        }
    }

    final void a(f fVar) {
        if (!this.iAT.Ar(fVar.getKey())) {
            x.d("MicroMsg.ExdeviceBindDeviceUI", "Add device: " + fVar.aHN());
            a aVar = this.iAT;
            if (!(fVar == null || aVar.Ar(fVar.getKey()))) {
                fVar.iBy = aVar.c(fVar);
                aVar.iBm.add(fVar);
            }
            this.iAT.notifyDataSetChanged();
            if (fVar.iBz == b.iBr) {
                x.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchBLEHardDevice doScene, mac(%s), brandName(%s),categoryId(%s)", new Object[]{fVar.iBA.bvw, this.ius, this.iAZ});
                au.DF().a(new t(fVar.iBA.bvw, this.ius, this.iAZ), 0);
            } else if (fVar.iBz == b.iBq) {
                x.i("MicroMsg.ExdeviceBindDeviceUI", "NetSceneSearchWiFiHardDevice doScene, deviceType(%s), deviceId(%s)", new Object[]{fVar.iBB.izI, fVar.iBB.iut});
                au.DF().a(new v(fVar.iBB.izI, fVar.iBB.iut, fVar.iBG), 0);
            } else {
                Assert.assertTrue(false);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.iAT.aHM();
        this.iAT.notifyDataSetChanged();
    }

    private void pc(int i) {
        String string;
        String string2;
        CharSequence spannableString;
        switch (i) {
            case 0:
                string = getString(R.l.exdevice_bind_device_help_help);
                CharSequence spannableString2 = new SpannableString(string);
                spannableString2.setSpan(new ForegroundColorSpan(R.e.link_color), 0, string.length(), 33);
                spannableString2.setSpan(new 9(this), 0, string.length(), 33);
                this.iAV.setMovementMethod(LinkMovementMethod.getInstance());
                this.iAV.setText(spannableString2);
                break;
            case 1:
                string = getString(R.l.exdevice_bind_device_help_tips_wifi);
                string2 = getString(R.l.exdevice_connect_wifi);
                spannableString = new SpannableString(string + string2);
                spannableString.setSpan(new ForegroundColorSpan(R.e.link_color), string.length(), string.length() + string2.length(), 33);
                spannableString.setSpan(new ClickableSpan() {
                    public final void onClick(View view) {
                        ExdeviceBindDeviceUI.this.finish();
                    }

                    public final void updateDrawState(TextPaint textPaint) {
                        textPaint.setColor(textPaint.linkColor);
                        textPaint.setUnderlineText(false);
                    }
                }, string.length(), string.length() + string2.length(), 33);
                this.iAV.setMovementMethod(LinkMovementMethod.getInstance());
                this.iAV.setText(spannableString);
                break;
            case 2:
                string = getString(R.l.exdevice_bind_device_help_tips_blue);
                string2 = getString(R.l.exdevice_bind_device_help_prepare);
                spannableString = new SpannableString(string + string2);
                spannableString.setSpan(new ForegroundColorSpan(R.e.link_color), string.length(), string.length() + string2.length(), 33);
                spannableString.setSpan(new 10(this), string.length(), string.length() + string2.length(), 33);
                this.iAV.setMovementMethod(LinkMovementMethod.getInstance());
                this.iAV.setText(spannableString);
                break;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                this.iAW.setImageResource(R.k.bluetooth_logo);
                this.iAg.setText(R.l.exdevice_can_not_scan);
                this.iAh.setText(R.l.exdevice_bind_device_blue_no_open_detail);
                break;
            case 4:
                this.iAW.setImageResource(R.k.bluetooth_logo);
                this.iAg.setText(R.l.exdevice_ble_version_below_4_0);
                this.iAh.setText("");
                break;
            case 5:
                this.iAW.setImageResource(R.k.wifi_logo);
                this.iAg.setText(R.l.exdevice_can_not_scan);
                this.iAh.setText(R.l.exdevice_bind_device_wifi_no_open_detail);
                break;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
                this.iAU.setVisibility(0);
                this.CU.setVisibility(0);
                this.iAV.setVisibility(0);
                this.iAW.setVisibility(8);
                this.iAg.setVisibility(8);
                this.iAh.setVisibility(8);
                return;
            case 3:
            case 4:
            case 5:
                this.fPS.setVisibility(8);
                this.iAU.setVisibility(8);
                this.CU.setVisibility(8);
                this.iAV.setVisibility(8);
                this.iAW.setVisibility(0);
                this.iAg.setVisibility(0);
                if (i == 4) {
                    this.iAh.setVisibility(8);
                    return;
                } else {
                    this.iAh.setVisibility(0);
                    return;
                }
            default:
                return;
        }
    }
}
