package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import java.util.List;
import org.json.JSONArray;

public final class c {
    public String fHW = "ok";
    public List<b> gdB = null;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mErrorMsg:");
        stringBuilder.append(this.fHW);
        stringBuilder.append(" mWifiList:");
        if (this.gdB == null || this.gdB.size() <= 0) {
            stringBuilder.append("null:");
        } else {
            for (b bVar : this.gdB) {
                stringBuilder.append(" WiFiItem:");
                stringBuilder.append(bVar);
            }
        }
        return stringBuilder.toString();
    }

    public final JSONArray aku() {
        JSONArray jSONArray = new JSONArray();
        for (b tR : this.gdB) {
            jSONArray.put(tR.tR());
        }
        return jSONArray;
    }
}
