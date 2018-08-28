package com.tencent.mm.plugin.freewifi.ui;

import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.d.i;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k$a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.ui.b.2;
import com.tencent.mm.protocal.c.bdp;
import com.tencent.mm.protocal.c.xq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements e {
    final /* synthetic */ b jmu;

    b$1(b bVar) {
        this.jmu = bVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        k$a aOa = k.aOa();
        aOa.bIQ = this.jmu.bIQ;
        aOa.jid = m.E(this.jmu.intent);
        aOa.jif = b.jio.jiQ;
        aOa.jig = b.jio.name;
        aOa.jie = m.G(this.jmu.intent);
        aOa.bVU = this.jmu.bVU;
        aOa.result = i2;
        aOa.hKX = str;
        aOa.aOc().b(this.jmu.intent, i2 != 0).aOb();
        x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback, desc=net request [getApInfo] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.E(this.jmu.intent), Integer.valueOf(m.F(this.jmu.intent)), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            b bVar = this.jmu;
            if (lVar instanceof a) {
                a aVar = (a) lVar;
                bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", aVar.aOU());
                xq aOV = aVar.aOV();
                if (aOV != null) {
                    x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo/getFrontPage), desc=net request [getapinfo] gets response. frontpageinfo:  appid: %s, nickName: %s, userName: %s, headImgUrl: %s, welcomeMsg: %s, privacyDescriUrl: %s, timestamp=%s, sign=%s, HasMobile=%d", new Object[]{m.E(bVar.intent), Integer.valueOf(m.F(bVar.intent)), aOV.rbW, aOV.hcS, aOV.hbL, aOV.jPM, aOV.rDu, aOV.rDv, aOV.rhq, aOV.rsy, Integer.valueOf(aOV.qZg)});
                    bVar.intent.putExtra("free_wifi_appid", aOV.rbW);
                    bVar.intent.putExtra("free_wifi_head_img_url", aOV.jPM);
                    bVar.intent.putExtra("free_wifi_welcome_msg", aOV.rDu);
                    bVar.intent.putExtra("free_wifi_privacy_url", aOV.rDv);
                    bVar.intent.putExtra("free_wifi_app_nickname", aOV.hcS);
                    bVar.intent.putExtra("free_wifi_welcome_sub_title", aOV.rDw);
                }
                if (bVar.bVU != 2) {
                    bVar.activity.getIntent().putExtra("free_wifi_jump_to_main_ui", true);
                }
                bdp aOT = aVar.aOT();
                if (aOT == null) {
                    x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstring from server is null");
                    bVar.activity.finish();
                    aOa = k.aOa();
                    aOa.bIQ = bVar.bIQ;
                    aOa.jid = m.E(bVar.intent);
                    aOa.jif = b.jip.jiQ;
                    aOa.jig = b.jip.name;
                    aOa.jie = m.G(bVar.intent);
                    aOa.bVU = bVar.bVU;
                    aOa.result = -1;
                    aOa.hKX = "qstrInfo is null.";
                    aOa.aOc().b(bVar.intent, true).aOb();
                    return;
                } else if (m.isEmpty(aOT.iwF)) {
                    x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "get qstrInfo.ssid from server is empty");
                    bVar.activity.finish();
                    aOa = k.aOa();
                    aOa.bIQ = bVar.bIQ;
                    aOa.jid = m.E(bVar.intent);
                    aOa.jif = b.jip.jiQ;
                    aOa.jig = b.jip.name;
                    aOa.jie = m.G(bVar.intent);
                    aOa.bVU = bVar.bVU;
                    aOa.result = -1;
                    aOa.hKX = "qstrInfo.Ssid is empty.";
                    aOa.aOc().b(bVar.intent, true).aOb();
                    return;
                } else {
                    bVar.intent.putExtra("free_wifi_ssid", aOT.iwF);
                    x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. qstrInfo:  prototype = %d, ssid : %s, pssword : %s", new Object[]{m.E(bVar.intent), Integer.valueOf(m.F(bVar.intent)), Integer.valueOf(aOT.sfQ), aOT.iwF, aOT.ryU});
                    String aOW = aVar.aOW();
                    String aOX = aVar.aOX();
                    bVar.intent.putExtra("free_wifi_openid", aOW);
                    bVar.intent.putExtra("free_wifi_tid", aOX);
                    bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP", aOV.rhq);
                    bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_SIGN", aOV.rsy);
                    x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=net request [getApInfo/getFrontPage] gets response. openId=%s, tid=%s", new Object[]{m.E(bVar.intent), Integer.valueOf(m.F(bVar.intent)), aOW, aOX});
                    bVar.intent.putExtra("free_wifi_protocol_type", aOT.sfQ);
                    if (aOT.sfQ == 10) {
                        if (bi.oW(aOT.iwF) || bi.oW(aOT.ryU)) {
                            x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
                            bVar.activity.finish();
                            return;
                        }
                        bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 4);
                        bVar.intent.putExtra("free_wifi_auth_type", 2);
                        bVar.intent.putExtra("free_wifi_passowrd", aOT.ryU);
                        bVar.intent.setClass(bVar.activity, FreeWifiFrontPageUI.class);
                        bVar.activity.startActivity(bVar.intent);
                        bVar.activity.finish();
                        bVar.activity.overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
                        return;
                    } else if (aOT.sfQ == 11) {
                        if (bi.oW(aOT.iwF) || bi.oW(aOT.ryU)) {
                            x.e("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "ssid or password is null");
                            bVar.activity.finish();
                            return;
                        }
                        bVar.intent.putExtra("free_wifi_auth_type", 2);
                        bVar.intent.putExtra("free_wifi_passowrd", aOT.ryU);
                        bVar.intent.setClass(bVar.activity, FreewifiActivateWeChatNoAuthStateUI.class);
                        bVar.activity.startActivity(bVar.intent);
                        bVar.activity.finish();
                        bVar.activity.overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
                        return;
                    } else if (aOT.sfQ == 12) {
                        bVar.intent.putExtra("free_wifi_auth_type", 1);
                        bVar.intent.setClass(bVar.activity, FreeWifiActivateAuthStateUI.class);
                        bVar.activity.startActivity(bVar.intent);
                        bVar.activity.finish();
                        bVar.activity.overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
                        return;
                    } else if (aOT.sfQ == 31) {
                        bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
                        x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 31 handle branch.", new Object[]{m.E(bVar.intent), Integer.valueOf(m.F(bVar.intent))});
                        String stringExtra = bVar.intent.getStringExtra("free_wifi_schema_ticket");
                        x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it tries to get ticket. ticket=%s.", new Object[]{m.E(bVar.intent), Integer.valueOf(m.F(bVar.intent)), stringExtra});
                        if (bi.oW(stringExtra)) {
                            bVar.activity.finish();
                            aOa = k.aOa();
                            aOa.bIQ = bVar.bIQ;
                            aOa.jid = m.E(bVar.intent);
                            aOa.jif = b.jip.jiQ;
                            aOa.jig = b.jip.name;
                            aOa.bVU = bVar.bVU;
                            aOa.jie = m.G(bVar.intent);
                            aOa.result = -1;
                            aOa.hKX = "31 ticket is empty.";
                            aOa.aOc().b(bVar.intent, true).aOb();
                            return;
                        }
                        String str2 = aOT.iwF;
                        String str3 = aOV.rhq;
                        String str4 = aOV.rsy;
                        WifiInfo aOA = d.aOA();
                        if (aOA == null) {
                            x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it tries to get current connected wifi info but return null, so it fails to connect wifi. ", new Object[]{m.E(bVar.intent), Integer.valueOf(m.F(bVar.intent))});
                            bVar.Ci(bVar.activity.getString(R.l.free_wifi_errmsg_retry));
                            aOa = k.aOa();
                            aOa.bIQ = bVar.bIQ;
                            aOa.jid = m.E(bVar.intent);
                            aOa.jif = b.jip.jiQ;
                            aOa.jig = b.jip.name;
                            aOa.bVU = bVar.bVU;
                            aOa.jie = m.G(bVar.intent);
                            aOa.result = -1;
                            aOa.hKX = "wifiInfo is empty.";
                            aOa.aOc().b(bVar.intent, true).aOb();
                            return;
                        }
                        boolean BY = d.BY(str2);
                        String str5 = "MicroMsg.FreeWifi.FreeWifiNetCheckUI";
                        String str6 = "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it gets connected wifi info. wifiInfo=%s, is_current_connected_ssid_equals_target_ssid=%b";
                        Object[] objArr = new Object[4];
                        objArr[0] = m.E(bVar.intent);
                        objArr[1] = Integer.valueOf(m.F(bVar.intent));
                        objArr[2] = aOA == null ? "null" : aOA.toString();
                        objArr[3] = Boolean.valueOf(BY);
                        x.i(str5, str6, objArr);
                        str5 = m.BQ(aOA.getSSID());
                        str6 = aOA.getBSSID();
                        String macAddress = aOA.getMacAddress();
                        if (VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
                            macAddress = m.aOf();
                        }
                        x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo desc=it starts net request [GetPortalApInfo]  for portal ap info. apKey=%s, apSsid=%s, apBssid=%s, mobileMac=%s, ticket=%s", new Object[]{m.E(bVar.intent), Integer.valueOf(m.F(bVar.intent)), bVar.bIQ, str5, str6, macAddress, stringExtra});
                        aOa = k.aOa();
                        aOa.bIQ = bVar.bIQ;
                        aOa.jid = m.E(bVar.intent);
                        aOa.jif = b.jip.jiQ;
                        aOa.jig = b.jip.name;
                        aOa.bVU = bVar.bVU;
                        aOa.jie = m.G(bVar.intent);
                        aOa.result = 0;
                        aOa.hKX = "";
                        aOa.aOc().b(bVar.intent, true).aOb();
                        aOa = k.aOa();
                        aOa.ssid = bVar.intent.getStringExtra("free_wifi_ssid");
                        aOa.bIQ = bVar.bIQ;
                        aOa.jic = bVar.intent.getStringExtra("free_wifi_appid");
                        aOa.jid = m.E(bVar.intent);
                        aOa.jie = m.G(bVar.intent);
                        aOa.jif = b.jiz.jiQ;
                        aOa.jig = b.jiz.name;
                        aOa.bVU = m.H(bVar.intent);
                        aOa.jie = m.G(bVar.intent);
                        aOa.aOc().b(bVar.intent, false).aOb();
                        new i(bVar.bIQ, str5, str6, macAddress, stringExtra, m.E(bVar.intent)).s(bVar.activity).b(new 2(bVar, aOW, aOX, str3, str4));
                        return;
                    } else if (aOT.sfQ == 32) {
                        bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 32);
                        x.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getApInfo.callback(openFrontPageByApInfo), desc=it goes into protocal 32 handle branch.", new Object[]{m.E(bVar.intent), Integer.valueOf(m.F(bVar.intent))});
                        bVar.intent.setClass(bVar.activity, FreeWifiFrontPageUI.class);
                        bVar.activity.startActivity(bVar.intent);
                        bVar.activity.finish();
                        bVar.activity.overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
                        return;
                    } else if (aOT.sfQ == 1) {
                        bVar.intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 1);
                        bVar.intent.putExtra("free_wifi_auth_type", 1);
                        bVar.intent.setClass(bVar.activity, FreeWifiFrontPageUI.class);
                        bVar.activity.startActivity(bVar.intent);
                        bVar.activity.finish();
                        bVar.activity.overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
                        return;
                    } else {
                        bVar.activity.finish();
                        bVar.Ci(bVar.activity.getString(R.l.free_wifi_errmsg_update_client));
                        return;
                    }
                }
            }
            bVar.Ci(bVar.activity.getString(R.l.free_wifi_errmsg_retry));
        } else if (m.cD(i, i2) && !m.isEmpty(str)) {
            this.jmu.Ci(str + "(" + m.a(m.G(this.jmu.intent), b.jio, i2) + ")");
        } else if (i2 == -30031) {
            this.jmu.Ci(this.jmu.activity.getString(R.l.free_wifi_errmsg_ssid_not_match_3));
        } else {
            this.jmu.Ci(this.jmu.activity.getString(R.l.free_wifi_errmsg_retry) + "(" + String.format("%02d", new Object[]{Integer.valueOf(m.G(this.jmu.intent))}) + b.jio.jiQ + Math.abs(i2) + ")");
        }
    }
}
