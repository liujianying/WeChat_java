package com.tencent.mm.plugin.freewifi.c;

import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class a {
    public String bssid;
    public String jju;
    public String jjv;
    public long jjw;
    public String jjx;
    public long jjy;
    public String ssid;
    public String type;
    public long uin;

    private a() {
    }

    public static a BW(String str) {
        x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "It starts to parse msgContent for FreeWifiSchemaMsg. msgContent=%s", new Object[]{str});
        if (m.isEmpty(str)) {
            x.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "msgCoentent is empty. return.");
            return null;
        }
        x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Shorten msgContent into one line. msgContent=%s", new Object[]{str});
        Map z = bl.z(str, "sysmsg");
        if (z == null || z.size() == 0) {
            x.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsing xml failed");
            return null;
        }
        x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsed values = " + z.toString());
        if ("freewifi".equalsIgnoreCase((String) z.get(".sysmsg.$type"))) {
            a aVar = new a();
            aVar.type = (String) z.get(".sysmsg.type");
            x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type=" + aVar.type);
            if ("schemamsg".equals(aVar.type)) {
                boolean l = m.l(z, "MicroMsg.FreeWifi.FreeWifiSchemaMsg");
                x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "checkMsgPushedVersion=" + l);
                if (l) {
                    aVar.uin = bi.getLong((String) z.get(".sysmsg.uin"), 0);
                    x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.uin=" + aVar.uin);
                    aVar.ssid = (String) z.get(".sysmsg.schemamsg.ssid");
                    x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.ssid=" + aVar.ssid);
                    if (m.isEmpty(aVar.ssid)) {
                        x.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.ssid is empty. return.");
                        return null;
                    }
                    aVar.bssid = m.BR((String) z.get(".sysmsg.schemamsg.bssid"));
                    x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.bssid=" + aVar.bssid);
                    aVar.jju = (String) z.get(".sysmsg.schemamsg.mobilemac");
                    x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mobilemac=" + aVar.jju);
                    if (m.isEmpty(aVar.jju)) {
                        x.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.mobilemac is empty. return.");
                        return null;
                    }
                    aVar.jjv = (String) z.get(".sysmsg.schemamsg.mpappid");
                    x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpappid=" + aVar.jjv);
                    aVar.jjw = bi.getLong((String) z.get(".sysmsg.schemamsg.mpshopid"), 0);
                    x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpshopid=" + aVar.jjw);
                    aVar.jjx = (String) z.get(".sysmsg.schemamsg.schemaurl");
                    x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.schemaurl=" + aVar.jjx);
                    if (m.isEmpty(aVar.jjx)) {
                        x.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.schemaurl is empty. return.");
                        return null;
                    }
                    aVar.jjy = bi.getLong((String) z.get(".sysmsg.schemamsg.expiredseconds"), 0);
                    x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schema.expiredseconds=" + aVar.jjy);
                    return aVar;
                }
                x.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "version not matched. return.");
                return null;
            }
            x.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type is not schemamsg. return.");
            return null;
        }
        x.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "sysmsg type is not freewifi. return.");
        return null;
    }
}
