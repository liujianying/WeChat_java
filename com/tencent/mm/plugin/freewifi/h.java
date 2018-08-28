package com.tencent.mm.plugin.freewifi;

import android.net.Uri;
import com.tencent.mm.plugin.freewifi.g.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.c.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class h {
    private String aBr;
    private b jhO;

    enum a {
        version("version", "2"),
        httpConnectTimeoutMillis("httpConnectTimeoutMillis", "5000"),
        httpReadTimeoutMillis("httpReadTimeoutMillis", "5000"),
        pingEnabled("pingEnabled", "1"),
        pingUrl("pingUrl", "http://o2o.gtimg.com/wifi/echo"),
        threeTwoBlackUrl("threeTwoBlackUrl", "http://o2o.gtimg.com/wifi/echo.html");
        
        String aAL;
        String jhV;

        private a(String str, String str2) {
            this.aAL = str;
            this.jhV = str2;
        }
    }

    /* synthetic */ h(byte b) {
        this();
    }

    private h() {
        this.jhO = j.aOL();
    }

    public final synchronized void a(ad adVar) {
        aNR();
        if (adVar == null || adVar.qZy == null) {
            x.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config is null.");
        } else {
            this.jhO.aPl();
            if (adVar.qZy.version == -1) {
                this.jhO.aPm();
                x.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "all local config data deleted.");
                this.jhO.aPl();
            } else if (adVar.qZy.version > aNS()) {
                x.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version is %d, local version is %d.", new Object[]{Integer.valueOf(adVar.qZy.version), Integer.valueOf(aNS())});
                x.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version = %d " + adVar.qZy.version);
                x.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpConnectTimeoutMillis = %d " + adVar.qZy.rua);
                x.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpReadTimeoutMillis = %d " + adVar.qZy.rub);
                x.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingUrl = %s " + adVar.qZy.bIP);
                x.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingEnabled = %s " + adVar.qZy.bIO);
                x.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.ThreeTwoBlackUrl = %s " + adVar.qZy.ruc);
                pV(adVar.qZy.rua);
                pW(adVar.qZy.rub);
                BN(adVar.qZy.bIP);
                BM(adVar.qZy.bIO);
                BO(adVar.qZy.ruc);
                pU(adVar.qZy.version);
                x.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "local config data changed.");
                this.jhO.aPl();
            }
        }
    }

    private synchronized void aNR() {
        try {
            String Ce = this.jhO.Ce(a.version.aAL);
            if (!m.isEmpty(Ce) && Integer.valueOf(Ce).intValue() < Integer.valueOf(a.version.jhV).intValue()) {
                pV(Integer.valueOf(a.httpConnectTimeoutMillis.jhV).intValue());
                pW(Integer.valueOf(a.httpReadTimeoutMillis.jhV).intValue());
                BN(a.pingUrl.jhV);
                BM(a.pingEnabled.jhV);
                BO(a.threeTwoBlackUrl.jhV);
                pU(Integer.valueOf(a.version.jhV).intValue());
            }
        } catch (Exception e) {
            x.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "updateDiskDbCacheIfLowerThanDefault exception. " + m.h(e));
        }
        return;
    }

    public final synchronized int aNS() {
        int intValue;
        aNR();
        try {
            String Ce = this.jhO.Ce(a.version.aAL);
            if (m.isEmpty(Ce)) {
                intValue = Integer.valueOf(a.version.jhV).intValue();
            } else {
                intValue = Integer.valueOf(Ce).intValue();
            }
        } catch (Exception e) {
            intValue = Integer.valueOf(a.version.jhV).intValue();
        }
        return intValue;
    }

    private synchronized void pU(int i) {
        if (i > Integer.valueOf(a.version.jhV).intValue()) {
            j.aOL().cR(a.version.aAL, String.valueOf(i));
        }
    }

    public final int aNT() {
        aNR();
        try {
            String Ce = this.jhO.Ce(a.httpConnectTimeoutMillis.aAL);
            if (m.isEmpty(Ce)) {
                return Integer.valueOf(a.httpConnectTimeoutMillis.jhV).intValue();
            }
            return Integer.valueOf(Ce).intValue();
        } catch (Exception e) {
            return Integer.valueOf(a.httpConnectTimeoutMillis.jhV).intValue();
        }
    }

    private static void pV(int i) {
        if (i > 0) {
            j.aOL().cR(a.httpConnectTimeoutMillis.aAL, String.valueOf(i));
        }
    }

    public final int aNU() {
        aNR();
        try {
            String Ce = this.jhO.Ce(a.httpReadTimeoutMillis.aAL);
            if (m.isEmpty(Ce)) {
                return Integer.valueOf(a.httpReadTimeoutMillis.jhV).intValue();
            }
            return Integer.valueOf(Ce).intValue();
        } catch (Exception e) {
            return Integer.valueOf(a.httpReadTimeoutMillis.jhV).intValue();
        }
    }

    private void pW(int i) {
        if (i > 0) {
            this.jhO.cR(a.httpReadTimeoutMillis.aAL, String.valueOf(i));
        }
    }

    public final String aNV() {
        aNR();
        try {
            if ("0".equals(this.jhO.Ce(a.pingEnabled.aAL))) {
                return "0";
            }
            return "1";
        } catch (Exception e) {
            return a.pingEnabled.jhV;
        }
    }

    private void BM(String str) {
        if ("0".equals(str) || "1".equals(str)) {
            try {
                this.jhO.cR(a.pingEnabled.aAL, str);
            } catch (Exception e) {
            }
        }
    }

    public final String aNW() {
        aNR();
        try {
            String Ce = this.jhO.Ce(a.pingUrl.aAL);
            if (m.isEmpty(Ce)) {
                return a.pingUrl.jhV;
            }
            Uri.parse(Ce);
            return Ce;
        } catch (Exception e) {
            return a.pingUrl.jhV;
        }
    }

    private void BN(String str) {
        if (!m.isEmpty(str)) {
            try {
                Uri.parse(str);
                this.jhO.cR(a.pingUrl.aAL, str);
            } catch (Exception e) {
            }
        }
    }

    public final String aNX() {
        aNR();
        try {
            String Ce = this.jhO.Ce(a.threeTwoBlackUrl.aAL);
            if (m.isEmpty(Ce)) {
                return a.threeTwoBlackUrl.jhV;
            }
            Uri.parse(Ce);
            return Ce;
        } catch (Exception e) {
            return a.threeTwoBlackUrl.jhV;
        }
    }

    private void BO(String str) {
        if (!m.isEmpty(str)) {
            try {
                Uri.parse(str);
                this.jhO.cR(a.threeTwoBlackUrl.aAL, str);
            } catch (Exception e) {
            }
        }
    }

    public final String getUserAgent() {
        if (m.isEmpty(this.aBr)) {
            this.aBr = s.aV(com.tencent.mm.sdk.platformtools.ad.getContext(), null).toLowerCase();
        }
        return this.aBr;
    }
}
