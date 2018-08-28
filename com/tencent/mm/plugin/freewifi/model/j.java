package com.tencent.mm.plugin.freewifi.model;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.RemoteException;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.g.a.ad;
import com.tencent.mm.g.a.ae;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.bv;
import com.tencent.mm.network.n;
import com.tencent.mm.plugin.freewifi.g.f;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class j implements ar {
    private static HashMap<Integer, d> cVM;
    private c bannerOnInitListener = new c<ad>() {
        {
            this.sFo = ad.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ae aeVar = new ae();
            aeVar.bHl.bHn = new a(com.tencent.mm.sdk.platformtools.ad.getContext());
            com.tencent.mm.sdk.b.a.sFg.m(aeVar);
            return false;
        }
    };
    private bv.a iwx = new 4(this);
    private volatile d jke;
    private volatile com.tencent.mm.plugin.freewifi.g.d jkf;
    private volatile com.tencent.mm.plugin.freewifi.g.b jkg;
    private volatile f jkh;
    private volatile c jki;
    private volatile c jkj;
    private volatile a jkk;
    private volatile e jkl;
    private n jkm = new 7(this);
    private c jkn = new 8(this);
    private c jko = new 9(this);
    private c jkp = new 10(this);
    private c jkq = new 11(this);
    private c jkr = new 12(this);
    private c jks = new 2(this);

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("FREEWIFIINFO_TABLE".hashCode()), new 1());
        cVM.put(Integer.valueOf("FREEWIFICONFIG_TABLE".hashCode()), new 5());
        cVM.put(Integer.valueOf("FREEWIFILOG_TABLE".hashCode()), new 6());
    }

    public static j aOI() {
        au.HN();
        j jVar = (j) bs.iK("plugin.freewifi");
        if (jVar != null) {
            return jVar;
        }
        x.w("MicroMsg.FreeWifi.SubCoreFreeWifi", "not found in MMCore, new one");
        jVar = new j();
        au.HN().a("plugin.freewifi", jVar);
        return jVar;
    }

    public static d aOJ() {
        g.Eg().Ds();
        if (aOI().jke == null) {
            aOI().jke = new d();
        }
        return aOI().jke;
    }

    public static com.tencent.mm.plugin.freewifi.g.d aOK() {
        g.Eg().Ds();
        if (aOI().jkf == null) {
            j aOI = aOI();
            au.HU();
            aOI.jkf = new com.tencent.mm.plugin.freewifi.g.d(com.tencent.mm.model.c.FO());
        }
        return aOI().jkf;
    }

    public static com.tencent.mm.plugin.freewifi.g.b aOL() {
        g.Eg().Ds();
        if (aOI().jkg == null) {
            j aOI = aOI();
            au.HU();
            aOI.jkg = new com.tencent.mm.plugin.freewifi.g.b(com.tencent.mm.model.c.FO());
        }
        return aOI().jkg;
    }

    public static f aOM() {
        g.Eg().Ds();
        if (aOI().jkh == null) {
            j aOI = aOI();
            au.HU();
            aOI.jkh = new f(com.tencent.mm.model.c.FO());
        }
        return aOI().jkh;
    }

    public static c aON() {
        g.Eg().Ds();
        if (aOI().jki == null) {
            aOI().jki = new c();
        }
        return aOI().jki;
    }

    public static c aOO() {
        g.Eg().Ds();
        if (aOI().jkj == null) {
            aOI().jkj = new c();
        }
        return aOI().jkj;
    }

    public static synchronized a aOP() {
        a aVar;
        synchronized (j.class) {
            g.Eg().Ds();
            if (aOI().jkk == null) {
                aOI().jkk = new a();
            }
            aVar = aOI().jkk;
        }
        return aVar;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        au.getSysCmdMsgExtension().a("freewifi", this.iwx, true);
        au.a(this.jkm);
        com.tencent.mm.sdk.b.a.sFg.b(this.jkn);
        com.tencent.mm.sdk.b.a.sFg.b(this.jko);
        com.tencent.mm.sdk.b.a.sFg.b(this.jkp);
        com.tencent.mm.sdk.b.a.sFg.b(this.jkq);
        com.tencent.mm.sdk.b.a.sFg.b(this.jkr);
        com.tencent.mm.sdk.b.a.sFg.b(this.jks);
        com.tencent.mm.sdk.b.a.sFg.b(this.bannerOnInitListener);
        try {
            this.jkm.ev(-9);
        } catch (RemoteException e) {
            x.e("MicroMsg.FreeWifi.SubCoreFreeWifi", "netChanged.onNetworkChange(NETWORK_ACCOUNT_POST_RESET) error. e.getMessage()=" + e.getMessage());
        }
        b aOu = b.b.aOu();
        x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "initialized");
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) com.tencent.mm.sdk.platformtools.ad.getContext().getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi=%s", new Object[]{networkInfo.toString()});
            IntentFilter intentFilter;
            if (networkInfo == null || !networkInfo.isConnected()) {
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                x.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoMobile=%s", new Object[]{networkInfo2.toString()});
                if (networkInfo2 != null && networkInfo2.isConnected()) {
                    b.a aVar = new b.a((byte) 0);
                    aVar.jjF = System.currentTimeMillis();
                    aVar.type = 0;
                    aVar.ssid = "";
                    aVar.bssid = "";
                    aVar.jjG = m.BR(networkInfo2.getExtraInfo());
                    b.a(aOu.jjC.aOt(), aVar);
                    aOu.jjC = aVar;
                }
                intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                aOu.aNO();
                com.tencent.mm.sdk.platformtools.ad.getContext().registerReceiver(aOu.jjD, intentFilter);
            }
            WifiInfo connectionInfo = ((WifiManager) com.tencent.mm.sdk.platformtools.ad.getContext().getSystemService("wifi")).getConnectionInfo();
            String BQ = m.BQ(connectionInfo.getSSID());
            String toLowerCase = m.BR(connectionInfo.getBSSID()).toLowerCase();
            b.a aVar2 = new b.a((byte) 0);
            aVar2.jjF = System.currentTimeMillis();
            aVar2.type = 1;
            aVar2.ssid = BQ;
            aVar2.bssid = toLowerCase;
            aVar2.jjG = "";
            b.b(aOu.jjC.aOt(), aVar2);
            aOu.jjC = aVar2;
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            aOu.aNO();
            com.tencent.mm.sdk.platformtools.ad.getContext().registerReceiver(aOu.jjD, intentFilter);
        } catch (Exception e2) {
            k.a aOa = k.aOa();
            aOa.bIQ = "UnExpectedException";
            aOa.result = -1;
            aOa.hKX = m.g(e2);
            aOa.aOc().aOb();
            x.e("MicroMsg.FreeWifi.UnExcepctedException", m.h(e2));
        }
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        au.getSysCmdMsgExtension().b("freewifi", this.iwx, true);
        aOJ();
        d.release();
        aON().release();
        au.b(this.jkm);
        com.tencent.mm.sdk.b.a.sFg.c(this.jkn);
        com.tencent.mm.sdk.b.a.sFg.c(this.jko);
        com.tencent.mm.sdk.b.a.sFg.c(this.jkp);
        com.tencent.mm.sdk.b.a.sFg.c(this.jkq);
        com.tencent.mm.sdk.b.a.sFg.c(this.jkr);
        com.tencent.mm.sdk.b.a.sFg.c(this.jks);
        com.tencent.mm.sdk.b.a.sFg.c(this.bannerOnInitListener);
        b.b.aOu().aNO();
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public static e aOQ() {
        g.Eg().Ds();
        if (aOI().jkl == null) {
            aOI().jkl = new e();
        }
        return aOI().jkl;
    }
}
