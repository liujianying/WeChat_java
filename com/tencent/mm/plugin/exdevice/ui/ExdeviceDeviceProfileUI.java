package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.z;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.m;
import com.tencent.mm.plugin.exdevice.model.y;
import com.tencent.mm.protocal.c.alx;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;

public class ExdeviceDeviceProfileUI extends MMPreference implements e {
    private String bvw;
    private p fUo;
    private String iAG;
    private String iAH;
    private String iAa;
    private int iBE;
    private p iBL = null;
    private String iCI;
    private String iCJ;
    private boolean iCK;
    private String iCL;
    private boolean iCM;
    private String iCN;
    private b iCO;
    private String ius;
    private String iut;
    private long ivC;
    private String izI;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r11) {
        /*
        r10 = this;
        r6 = 2;
        r3 = 1;
        r2 = 0;
        super.onCreate(r11);
        r0 = new com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI$1;
        r0.<init>(r10);
        r10.setBackBtn(r0);
        r0 = com.tencent.mm.R.l.exdevice_bind_device_profile_title;
        r10.setMMTitle(r0);
        r0 = new com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI$7;
        r0.<init>(r10);
        r10.iCO = r0;
        r0 = r10.getIntent();
        r1 = "device_mac";
        r1 = r0.getStringExtra(r1);
        r10.bvw = r1;
        r1 = "device_ble_simple_proto";
        r4 = 0;
        r4 = r0.getLongExtra(r1, r4);
        r10.ivC = r4;
        r1 = "device_jump_url";
        r1 = r0.getStringExtra(r1);
        r10.iCI = r1;
        r1 = "device_brand_name";
        r1 = r0.getStringExtra(r1);
        r10.ius = r1;
        r1 = "device_id";
        r1 = r0.getStringExtra(r1);
        r10.iut = r1;
        r1 = "device_type";
        r1 = r0.getStringExtra(r1);
        r10.izI = r1;
        r1 = "bind_ticket";
        r1 = r0.getStringExtra(r1);
        r10.iAH = r1;
        r1 = "subscribe_flag";
        r1 = r0.getIntExtra(r1, r2);
        r10.iBE = r1;
        r1 = "device_has_bound";
        r1 = r0.getBooleanExtra(r1, r2);
        r10.iCK = r1;
        r1 = "device_title";
        r1 = r0.getStringExtra(r1);
        r10.iAG = r1;
        r1 = "device_alias";
        r1 = r0.getStringExtra(r1);
        r10.iCJ = r1;
        r1 = "device_desc";
        r1 = r0.getStringExtra(r1);
        r10.iAa = r1;
        r1 = "device_icon_url";
        r0 = r0.getStringExtra(r1);
        r10.iCL = r0;
        r0 = r10.iut;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x00a5;
    L_0x009d:
        r0 = r10.izI;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 == 0) goto L_0x00cb;
    L_0x00a5:
        r0 = "MicroMsg.ExdeviceDeviceProfileUI";
        r1 = "deviceId or deviceType is null.";
        r4 = new java.lang.Object[r6];
        r5 = r10.iut;
        r4[r2] = r5;
        r5 = r10.izI;
        r4[r3] = r5;
        com.tencent.mm.sdk.platformtools.x.e(r0, r1, r4);
    L_0x00b8:
        if (r2 != 0) goto L_0x01b4;
    L_0x00ba:
        r0 = r10.mController;
        r0 = r0.tml;
        r1 = com.tencent.mm.R.l.exdevice_jump_failed;
        r0 = android.widget.Toast.makeText(r0, r1, r3);
        r0.show();
        r10.finish();
    L_0x00ca:
        return;
    L_0x00cb:
        r0 = com.tencent.mm.plugin.exdevice.model.ad.aHe();
        r1 = r10.iut;
        r4 = r10.izI;
        r0 = r0.cz(r1, r4);
        if (r0 == 0) goto L_0x01a9;
    L_0x00d9:
        r10.iCK = r3;
        r1 = r10.iCJ;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 == 0) goto L_0x00eb;
    L_0x00e3:
        r1 = r0.cCR;
        r1 = com.tencent.mm.sdk.platformtools.bi.oV(r1);
        r10.iCJ = r1;
    L_0x00eb:
        r1 = r10.iAG;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 == 0) goto L_0x00fb;
    L_0x00f3:
        r1 = r0.cCS;
        r1 = com.tencent.mm.sdk.platformtools.bi.oV(r1);
        r10.iAG = r1;
    L_0x00fb:
        r1 = r10.ius;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 == 0) goto L_0x010b;
    L_0x0103:
        r1 = r0.field_brandName;
        r1 = com.tencent.mm.sdk.platformtools.bi.oV(r1);
        r10.ius = r1;
    L_0x010b:
        r1 = r10.iAa;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 == 0) goto L_0x011b;
    L_0x0113:
        r1 = r0.cCT;
        r1 = com.tencent.mm.sdk.platformtools.bi.oV(r1);
        r10.iAa = r1;
    L_0x011b:
        r1 = r10.iCL;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 == 0) goto L_0x012b;
    L_0x0123:
        r1 = r0.iconUrl;
        r1 = com.tencent.mm.sdk.platformtools.bi.oV(r1);
        r10.iCL = r1;
    L_0x012b:
        r1 = r10.iCI;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 == 0) goto L_0x013b;
    L_0x0133:
        r1 = r0.jumpUrl;
        r1 = com.tencent.mm.sdk.platformtools.bi.oV(r1);
        r10.iCI = r1;
    L_0x013b:
        r0 = r0.cCV;
        if (r0 != r6) goto L_0x01b1;
    L_0x013f:
        r10.iCM = r3;
        r0 = r10.iAG;
        r10.iCN = r0;
        r0 = com.tencent.mm.plugin.exdevice.model.ad.aHe();
        r0 = r0.aHJ();
        r4 = r0.iterator();
    L_0x0151:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x01b1;
    L_0x0157:
        r0 = r4.next();
        r0 = (com.tencent.mm.plugin.exdevice.h.b) r0;
        r1 = r0.field_deviceType;
        r5 = r10.izI;
        r1 = r1.equals(r5);
        if (r1 == 0) goto L_0x0151;
    L_0x0167:
        r1 = r0.cDa;
        if (r1 == 0) goto L_0x0151;
    L_0x016b:
        r5 = r1.length();
        if (r5 <= 0) goto L_0x0151;
    L_0x0171:
        r5 = ",";
        r5 = r1.split(r5);
        r1 = r2;
    L_0x0179:
        r6 = r5.length;
        if (r1 >= r6) goto L_0x0151;
    L_0x017c:
        r6 = r5[r1];
        r7 = r10.iut;
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x01a1;
    L_0x0186:
        r6 = r0.cCR;
        r6 = com.tencent.mm.sdk.platformtools.bi.oW(r6);
        if (r6 == 0) goto L_0x01a4;
    L_0x018e:
        r6 = r0.cCS;
        r10.iCN = r6;
    L_0x0192:
        r6 = "MicroMsg.ExdeviceDeviceProfileUI";
        r7 = "mGateWayTitle %s";
        r8 = new java.lang.Object[r3];
        r9 = r10.iCN;
        r8[r2] = r9;
        com.tencent.mm.sdk.platformtools.x.i(r6, r7, r8);
    L_0x01a1:
        r1 = r1 + 1;
        goto L_0x0179;
    L_0x01a4:
        r6 = r0.cCR;
        r10.iCN = r6;
        goto L_0x0192;
    L_0x01a9:
        r0 = r10.iAH;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x00b8;
    L_0x01b1:
        r2 = r3;
        goto L_0x00b8;
    L_0x01b4:
        r10.aHR();
        goto L_0x00ca;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.onCreate(android.os.Bundle):void");
    }

    private void aHR() {
        String str;
        boolean z;
        f fVar;
        h hVar = this.tCL;
        DeviceProfileHeaderPreference deviceProfileHeaderPreference = (DeviceProfileHeaderPreference) hVar.ZZ("device_profile_header");
        deviceProfileHeaderPreference.a(1, new 8(this));
        deviceProfileHeaderPreference.a(4, new 9(this));
        a(deviceProfileHeaderPreference);
        deviceProfileHeaderPreference.setIconUrl(this.iCL);
        KeyValuePreference keyValuePreference = (KeyValuePreference) hVar.ZZ("connect_setting");
        KeyValuePreference keyValuePreference2 = (KeyValuePreference) hVar.ZZ("user_list");
        ((KeyValuePreference) hVar.ZZ("message_manage")).lO(true);
        keyValuePreference.lO(true);
        keyValuePreference2.lO(true);
        hVar.bw("message_manage", true);
        hVar.bw("connect_setting", true);
        hVar.bw("user_list", true);
        if (this.iCM) {
            hVar.bw("sub_device_desc", false);
            hVar.ZZ("sub_device_desc").setTitle(getResources().getString(R.l.exdevice_sub_device_desc, new Object[]{this.iCN}));
            hVar.bw("bind_device", true);
            str = "unbind_device";
            z = true;
            fVar = hVar;
        } else {
            hVar.bw("sub_device_desc", true);
            hVar.bw("bind_device", this.iCK);
            str = "unbind_device";
            if (this.iCK) {
                z = false;
                fVar = hVar;
            } else {
                z = true;
                fVar = hVar;
            }
        }
        fVar.bw(str, z);
        if (bi.oW(this.iCI)) {
            hVar.bw("open_device_panel", true);
        }
    }

    private void a(DeviceProfileHeaderPreference deviceProfileHeaderPreference) {
        CharSequence charSequence = bi.oW(this.iAG) ? this.ius : this.iAG;
        if (bi.oW(this.iCJ)) {
            deviceProfileHeaderPreference.setName(charSequence);
            deviceProfileHeaderPreference.Ao("");
            deviceProfileHeaderPreference.H(3, false);
            deviceProfileHeaderPreference.H(4, false);
            deviceProfileHeaderPreference.H(1, this.iCK);
        } else {
            deviceProfileHeaderPreference.setName(this.iCJ);
            deviceProfileHeaderPreference.Ao(getString(R.l.exdevice_device_name, new Object[]{charSequence}));
            deviceProfileHeaderPreference.H(3, true);
            deviceProfileHeaderPreference.H(4, true);
            deviceProfileHeaderPreference.H(1, false);
        }
        charSequence = this.iAa;
        deviceProfileHeaderPreference.iAa = charSequence;
        if (deviceProfileHeaderPreference.izX != null) {
            deviceProfileHeaderPreference.izX.setText(charSequence);
        }
    }

    public final int Ys() {
        return R.o.exdevice_device_profile_pref;
    }

    public final boolean a(f fVar, Preference preference) {
        x.d("MicroMsg.ExdeviceDeviceProfileUI", "onPreferenceTreeClcik.(key : %s)", preference.mKey);
        String str;
        l lVar;
        if ("bind_device".equals(preference.mKey)) {
            if (bi.oW(this.iAH)) {
                x.i("MicroMsg.ExdeviceDeviceProfileUI", "Do unauth bind device.");
                l mVar = new m(com.tencent.mm.plugin.exdevice.j.b.Az(this.bvw), this.ius, "3", this.ivC);
                j(mVar);
                au.DF().a(1262, (e) this);
                au.DF().a(mVar, 0);
            } else {
                x.i("MicroMsg.ExdeviceDeviceProfileUI", "Do normal bind device.");
                str = this.iAH;
                int i = this.iBE;
                au.DF().a(536, (e) this);
                cv cvVar = new cv();
                cvVar.bKm.bKo = str;
                cvVar.bKm.opType = 1;
                cvVar.bKm.bKp = i;
                a.sFg.m(cvVar);
                lVar = cvVar.bKn.bKq;
                getString(R.l.app_tip);
                this.iBL = com.tencent.mm.ui.base.h.a(this, getString(R.l.exdevice_binding), true, new 10(this, lVar));
            }
        } else if ("unbind_device".equals(preference.mKey)) {
            alx alx = new alx();
            alx.hbO = this.iut;
            alx.reT = this.izI;
            com.tencent.mm.plugin.exdevice.h.b cz = ad.aHe().cz(this.iut, this.izI);
            if (cz != null) {
                str = cz.cDa;
                if (str != null && str.length() > 0) {
                    String[] split = str.split(",");
                    for (String cB : split) {
                        ad.aHe().cB(cB, this.izI);
                    }
                }
            }
            lVar = new com.tencent.mm.plugin.exdevice.model.x(alx, 2);
            j(lVar);
            au.DF().a(537, (e) this);
            au.DF().a(lVar, 0);
        } else if ("open_device_panel".equals(preference.mKey)) {
            com.tencent.mm.plugin.exdevice.model.f.ae(this.mController.tml, this.iCI);
        } else if ("contact_info_biz_go_chatting".equals(preference.mKey)) {
            au.HU();
            ai Yg = c.FR().Yg(this.ius);
            Intent intent = new Intent();
            intent.putExtra("device_id", this.iut);
            intent.putExtra("device_type", this.izI);
            intent.putExtra("KIsHardDevice", true);
            intent.putExtra("KHardDeviceBindTicket", this.iAH);
            if (Yg != null) {
                if (com.tencent.mm.l.a.gd(Yg.field_type) && Yg.ckW()) {
                    z.MY().kA(Yg.field_username);
                    intent.putExtra("Chat_User", this.ius);
                    intent.putExtra("finish_direct", true);
                    com.tencent.mm.plugin.exdevice.a.isu.e(intent, this.mController.tml);
                } else {
                    intent.putExtra("Contact_User", this.ius);
                    intent.putExtra("force_get_contact", true);
                    d.b(this.mController.tml, "profile", ".ui.ContactInfoUI", intent);
                }
            }
        } else if (!("message_manage".equals(preference.mKey) || "connect_setting".equals(preference.mKey) || "user_list".equals(preference.mKey))) {
            return false;
        }
        return true;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (lVar == null) {
            x.e("MicroMsg.ExdeviceDeviceProfileUI", "scene is null.");
            return;
        }
        x.d("MicroMsg.ExdeviceDeviceProfileUI", "type = %s", Integer.valueOf(lVar.getType()));
        com.tencent.mm.plugin.exdevice.h.b cX;
        if (lVar instanceof com.tencent.mm.plugin.exdevice.model.l) {
            aHL();
            au.DF().b(lVar.getType(), (e) this);
            if (i == 0 && i2 == 0) {
                aHT();
                f(ad.aHe().cz(this.iut, this.izI));
                runOnUiThread(new 11(this));
                return;
            }
            x.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(lVar.getType()));
            aHS();
        } else if (lVar instanceof m) {
            aHL();
            au.DF().b(lVar.getType(), (e) this);
            cX = ad.aHe().cX(com.tencent.mm.plugin.exdevice.j.b.Az(this.bvw));
            if (i == 0 && i2 == 0 && cX != null) {
                f(cX);
                runOnUiThread(new 12(this));
                aHT();
                return;
            }
            x.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(lVar.getType()));
            aHS();
        } else if (lVar instanceof y) {
            aHL();
            au.DF().b(1263, (e) this);
            if (i == 0 && i2 == 0) {
                this.iCJ = ((y) lVar).cCR;
                runOnUiThread(new 13(this));
                cX = ad.aHe().cz(this.iut, this.izI);
                if (cX == null) {
                    x.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", this.iut, this.izI);
                    return;
                }
                cX.du(this.iCJ);
                ad.aHe().c(cX, new String[0]);
                return;
            }
            x.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(lVar.getType()));
            Toast.makeText(this.mController.tml, getString(R.l.exdevice_edit_alias_failed), 1).show();
        } else if (lVar instanceof com.tencent.mm.plugin.exdevice.model.x) {
            aHL();
            if (i == 0 && i2 == 0) {
                runOnUiThread(new 14(this));
                finish();
                return;
            }
            x.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd, unbind failed (%d, %d, %s).(type : %d)", Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(lVar.getType()));
            runOnUiThread(new 6(this));
        }
    }

    protected void onDestroy() {
        au.DF().b(537, (e) this);
        super.onDestroy();
    }

    private void f(com.tencent.mm.plugin.exdevice.h.b bVar) {
        if (bVar != null) {
            this.iut = bVar.field_deviceID;
            this.izI = bVar.field_deviceType;
            this.iCJ = bi.oV(bVar.cCR);
            this.iAG = bi.oV(bVar.cCS);
            this.ius = bi.oV(bVar.field_brandName);
            this.iAa = bi.oV(bVar.cCT);
            this.iCL = bi.oV(bVar.iconUrl);
            this.iCI = bi.oV(bVar.jumpUrl);
        }
    }

    private void aHL() {
        runOnUiThread(new 2(this));
    }

    private void aHS() {
        runOnUiThread(new 3(this));
    }

    private void aHT() {
        runOnUiThread(new 4(this));
    }

    private void j(l lVar) {
        runOnUiThread(new 5(this, lVar));
    }
}
