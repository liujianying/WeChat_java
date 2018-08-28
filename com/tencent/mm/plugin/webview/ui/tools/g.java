package com.tencent.mm.plugin.webview.ui.tools;

import android.net.wifi.WifiInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.ak;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class g {
    public static g pXv = new g();
    private String bJK;
    private String bssid;
    boolean dDR = false;
    d gcO = null;
    private int networkType;
    String nyj;
    String pXw;
    private String ssid;

    private g() {
    }

    public final void fr(String str, String str2) {
        x.i("MicroMsg.WebViewReportUtil", "setting traceid " + str + ",usename " + str2);
        this.nyj = str;
        this.networkType = ak.bUp();
        this.bJK = ac.ce(str2 + bi.VF());
        WifiInfo wifiInfo = ao.getWifiInfo(ad.getContext());
        if (wifiInfo == null) {
            this.ssid = "";
            this.bssid = "";
        } else {
            this.ssid = wifiInfo.getSSID();
            this.bssid = wifiInfo.getBSSID();
        }
        this.dDR = false;
    }

    public final void AI(int i) {
        x.v("MicroMsg.WebViewReportUtil", "onReceivedError traceid %s", new Object[]{this.nyj});
        if (!bi.oW(this.nyj)) {
            f(3, "", i);
        }
    }

    public final void close() {
        x.v("MicroMsg.WebViewReportUtil", "close traceid %s", new Object[]{this.nyj});
        this.dDR = true;
        if (!bi.oW(this.nyj)) {
            kB(4);
            this.nyj = null;
        }
    }

    final void kB(int i) {
        f(i, "", 0);
    }

    final void f(int i, String str, int i2) {
        com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
        dVar.r("20adInfo", this.nyj + ",");
        dVar.r("21optype", i + ",");
        dVar.r("22sessionId", this.bJK + ",");
        dVar.r("23currURL", this.pXw + ",");
        dVar.r("24referURL", str + ",");
        dVar.r("25errCode", i2 + ",");
        dVar.r("26networkType", this.networkType + ",");
        dVar.r("27timeStamp", bi.VF() + ",");
        dVar.r("28ssid", this.ssid + ",");
        dVar.r("29bssid", this.bssid + ",");
        x.i("MicroMsg.WebViewReportUtil", "report logbuffer adPageOp(13791): optype:%d, sessionId:%s, currUrl:%s, referUrl:%s, errCode:%d, networkType:%d", new Object[]{Integer.valueOf(i), this.bJK, this.pXw, str, Integer.valueOf(i2), Integer.valueOf(this.networkType)});
        h.mEJ.h(13791, new Object[]{dVar});
        if (this.gcO == null) {
            x.e("MicroMsg.WebViewReportUtil", "report invoker null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("ad_report_data_str", dVar.toString());
        try {
            this.gcO.s(1295, bundle);
        } catch (RemoteException e) {
            x.e("MicroMsg.WebViewReportUtil", "report: exp:%s", new Object[]{e});
        }
    }
}
