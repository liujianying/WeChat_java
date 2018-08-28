package com.tencent.mm.plugin.freewifi;

import android.content.Intent;
import com.tencent.mm.plugin.freewifi.f.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONObject;

public final class k {
    public static Map<String, String> jhZ = new 1();
    private String bIQ;
    private String bIR;
    private int bVU;
    private String bssid;
    private String hKX;
    private int jia;
    private String jib;
    private String jic;
    private String jid;
    private int jie;
    private long jif;
    private String jig;
    private String jih;
    private long jii;
    private int result;
    private String ssid;

    /* synthetic */ k(byte b) {
        this();
    }

    public static String BP(String str) {
        return m.BR((String) jhZ.get(str));
    }

    private k() {
    }

    public static a aOa() {
        return new a((byte) 0);
    }

    public final k aOb() {
        h.mEJ.h(12804, new Object[]{m.BR(this.ssid), m.BR(this.bssid), m.BR(this.bIR), m.BR(this.bIQ), Integer.valueOf(this.jia), m.BR(this.jib), m.BR(this.jic), m.BR(this.jid), Integer.valueOf(this.jie), Long.valueOf(this.jif), m.BR(this.jig), Integer.valueOf(this.result), Integer.valueOf(this.bVU), m.BR(this.jih), Long.valueOf(this.jii), m.BR(this.hKX)});
        return this;
    }

    public final k b(Intent intent, boolean z) {
        try {
            final int G = m.G(intent);
            if (G == 31) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ssid", this.ssid);
                    jSONObject.put("bssid", this.bssid);
                    jSONObject.put("clientMac", this.bIR);
                    jSONObject.put("apKey", this.bIQ);
                    jSONObject.put("qrtype", this.jia);
                    jSONObject.put("mpShopId", this.jib);
                    jSONObject.put("mpAppId", this.jic);
                    jSONObject.put("sessionKey", this.jid);
                    jSONObject.put("protocolType", this.jie);
                    jSONObject.put("stageCode", this.jif);
                    jSONObject.put("stageName", this.jig);
                    jSONObject.put("result", this.result);
                    jSONObject.put("channel", this.bVU);
                    jSONObject.put("mpUserName", this.jih);
                    jSONObject.put("timeCost", this.jii);
                    jSONObject.put("resultMsg", this.hKX);
                    jSONObject.put("logCurrentTimeMillis", System.currentTimeMillis());
                } catch (Exception e) {
                    x.e("MicroMsg.FreeWifi.FreeWifiQualityReporter", "JSONException e. " + m.h(e));
                }
                String jSONObject2 = jSONObject.toString();
                String stringExtra = intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON");
                if (m.isEmpty(stringExtra)) {
                    intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON", jSONObject2);
                } else {
                    intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON", stringExtra + "," + jSONObject2);
                }
                final long currentTimeMillis = System.currentTimeMillis();
                final String stringExtra2 = intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID");
                final String stringExtra3 = intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_JSON");
                if (z) {
                    j.aOO().aOv().post(new Runnable() {
                        public final void run() {
                            j.aOM().a(stringExtra2, G, stringExtra3, currentTimeMillis);
                            if (m.aOh()) {
                                b.kB(1);
                            }
                        }
                    });
                }
            }
        } catch (Exception e2) {
            x.e("MicroMsg.FreeWifi.FreeWifiQualityReporter", "reportWifiServer() write to local file exception. " + m.h(e2));
        }
        return this;
    }
}
