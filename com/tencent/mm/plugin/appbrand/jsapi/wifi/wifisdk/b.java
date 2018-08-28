package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import org.json.JSONObject;

public final class b {
    public boolean gdA = false;
    public String gdv = "";
    public String gdw = "";
    public int gdx;
    public boolean gdy = false;
    public boolean gdz = false;

    public final String toString() {
        return "WiFiItem{mSsid='" + this.gdv + '\'' + ", mBssid='" + this.gdw + '\'' + ", mSignalStrength=" + this.gdx + ", mSecurity=" + this.gdy + '}';
    }

    public final JSONObject tR() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("SSID", this.gdv);
        jSONObject.put("BSSID", this.gdw);
        jSONObject.put("secure", this.gdy);
        jSONObject.put("signalStrength", this.gdx);
        return jSONObject;
    }
}
