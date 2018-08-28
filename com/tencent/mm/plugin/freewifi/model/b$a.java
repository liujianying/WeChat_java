package com.tencent.mm.plugin.freewifi.model;

class b$a {
    String bssid;
    long jjF;
    String jjG;
    String ssid;
    int type;

    private b$a() {
        this.ssid = "";
        this.bssid = "";
        this.jjG = "";
    }

    /* synthetic */ b$a(byte b) {
        this();
    }

    public final b$a aOt() {
        b$a b_a = new b$a();
        b_a.jjF = this.jjF;
        b_a.type = this.type;
        b_a.ssid = this.ssid;
        b_a.bssid = this.bssid;
        b_a.jjG = this.jjG;
        return b_a;
    }

    public final String toString() {
        return String.format("NetworkInfoConnectedRecord(timeMillis=%d, type=%d, ssid=%s, bssid=%s, mobileNetworkType=%s)", new Object[]{Long.valueOf(this.jjF), Integer.valueOf(this.type), this.ssid, this.bssid, this.jjG});
    }
}
