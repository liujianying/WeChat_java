package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.g;

public final class m {
    public String appId;
    public int bGF;
    public final String bJK;
    public int cbu;
    public final g fdD;
    public String grI;
    public volatile long gsj;
    public volatile boolean gsk = false;
    public int gsl;
    public int gsm;
    public long gsn;
    public long gso;
    public int scene;

    public m(g gVar) {
        this.fdD = gVar;
        this.bJK = gVar.fct.fdE;
    }

    public final String toString() {
        return "kv_14576{, networkType='" + this.grI + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.cbu + ", appState=" + this.bGF + ", scene=" + this.scene + ", sessionId='" + this.bJK + '\'' + ", is_download_code=" + this.gsl + ", is_load_x5=" + this.gsm + ", cost_time=" + this.gsn + ", event_time=" + this.gso + '}';
    }
}
