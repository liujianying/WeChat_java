package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import android.util.SparseArray;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.model.g.1;
import com.tencent.mm.plugin.freewifi.model.g.2;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    private g jjA = new g();
    SparseArray<Long> jjz = new SparseArray();

    public final void a(String str, b bVar, int i, Intent intent) {
        j.aON().aOv().post(new 1(this.jjA, str, intent, bVar, i));
    }

    public final void a(String str, String str2, Intent intent) {
        j.aON().aOv().post(new 2(this.jjA, str2, str, intent));
    }

    public final synchronized void aOs() {
        x.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "ap check for bar.");
        String aOz = d.aOz();
        x.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "autuApAuth, get ssid is %s ", aOz);
        if (!bi.oW(aOz)) {
            if (j.aOK().Cf(aOz) == null) {
                int i;
                String aOx = d.aOx();
                String str = "MicroMsg.FreeWifi.FreeWifiAuthManager";
                String str2 = "freewifi info is null, now try to check is the wechat wifi fromserver, ssid is : %s, mac is : %s, nowmac hashcode : %d";
                Object[] objArr = new Object[3];
                objArr[0] = aOz;
                objArr[1] = aOx;
                if (aOx == null) {
                    i = 0;
                } else {
                    i = aOx.hashCode();
                }
                objArr[2] = Integer.valueOf(i);
                x.i(str, str2, objArr);
                if (!bi.oW(aOx)) {
                    boolean z;
                    c Cg = j.aOK().Cg(aOz);
                    str2 = "MicroMsg.FreeWifi.FreeWifiAuthManager";
                    String str3 = "now mac is : %s, loacal mac is : %s";
                    Object[] objArr2 = new Object[2];
                    objArr2[0] = aOx;
                    objArr2[1] = Cg == null ? "null free wifiinfo" : Cg.field_mac;
                    x.i(str2, str3, objArr2);
                    if (Cg != null) {
                        x.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "freewifi is not null, expired time = %d", Long.valueOf(Cg.field_expiredTime));
                        if (!aOx.equalsIgnoreCase(Cg.field_mac) || Cg.field_expiredTime - bi.VE() < 0) {
                            x.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has expierd time or mac has changed");
                            z = true;
                        }
                        z = false;
                    } else if (this.jjz.indexOfKey(aOx.hashCode()) >= 0) {
                        x.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has checked this mac, now time - last check time = %d", Long.valueOf(bi.VF() - ((Long) this.jjz.get(aOx.hashCode())).longValue()));
                        if (bi.VF() - ((Long) this.jjz.get(aOx.hashCode())).longValue() > 43200000) {
                            z = true;
                        }
                        z = false;
                    } else {
                        x.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "has not checked this mac, try to check from server");
                        z = true;
                    }
                    x.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "Should request bar from back end = %b", Boolean.valueOf(z));
                    if (z) {
                        x.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "now should do ap check, rssi is :  %d, mac : %s, mac hashcode : %d", Integer.valueOf(d.aOy()), aOx, Integer.valueOf(aOx.hashCode()));
                        if (System.currentTimeMillis() - com.tencent.mm.plugin.freewifi.i.a.aNZ().oX("LOCAL_CONFIG_LAST_APCHECK_SAVE_DELAY_CRD_TIMEMILLIS") > ((long) ((((com.tencent.mm.plugin.freewifi.i.a.aNZ().getInt("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", 7) * 24) * 60) * 60) * 1000))) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        if (com.tencent.mm.plugin.freewifi.i.a.aNZ().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_BAR_APPEARED", 0) == 1) {
                            i |= 2;
                        }
                        if (com.tencent.mm.plugin.freewifi.i.a.aNZ().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_USE_WECHAT_FREEWIFI", 0) == 1) {
                            i |= 4;
                        }
                        if (com.tencent.mm.plugin.freewifi.i.a.aNZ().getInt("LOCAL_CONFIG_FEATURES_DEFINE_ONCE_RECV_FREEWIFI_SYSMSG", 0) == 1) {
                            i |= 8;
                        }
                        x.i("MicroMsg.FreeWifi.FreeWifiAuthManager", "features : " + i);
                        new com.tencent.mm.plugin.freewifi.d.b(aOx, aOz, r5, i).b(new 1(this));
                    }
                }
            }
        }
    }
}
