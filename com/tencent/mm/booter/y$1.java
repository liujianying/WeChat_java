package com.tencent.mm.booter;

import android.content.SharedPreferences;
import android.os.Process;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.network.b;
import com.tencent.mm.network.u;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.appbrand.jsapi.f.m;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

class y$1 implements Runnable {
    final /* synthetic */ y cXG;

    public y$1(y yVar) {
        this.cXG = yVar;
    }

    public final void run() {
        String str;
        Throwable e;
        long VF = ai.VF();
        Process.setThreadPriority(10);
        y yVar = this.cXG;
        int i = e.bxk;
        String zz = q.zz();
        int i2 = d.qVN;
        String str2 = "0";
        String chP = w.chP();
        int i3 = yVar.context.getSharedPreferences(ad.chY(), 0).getInt("last_reportdevice_channel", 0);
        int i4 = yVar.context.getSharedPreferences(ad.chY(), 0).getInt("last_reportdevice_clientversion", 0);
        if (i3 == 0 && i4 == 0) {
            i4 = 0;
        } else if (i3 == i && i4 == i2) {
            str = null;
            x.i("MicroMsg.StartupReport", "tryReport thread:%s pri:%d  Url[%s] ", new Object[]{Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())), str});
            if (ai.oW(str)) {
                u a;
                try {
                    a = b.a(str, null);
                    try {
                        a.setConnectTimeout(10000);
                        a.setReadTimeout(10000);
                        a.connect();
                        if (a.getResponseCode() == m.CTRL_INDEX) {
                            y yVar2 = this.cXG;
                            i2 = e.bxk;
                            int i5 = d.qVN;
                            SharedPreferences sharedPreferences = yVar2.context.getSharedPreferences(ad.chY(), 0);
                            sharedPreferences.edit().putInt("last_reportdevice_channel", i2).commit();
                            sharedPreferences.edit().putInt("last_reportdevice_clientversion", i5).commit();
                        }
                        x.d("MicroMsg.StartupReport", "report FIN time:%d resp:%d url[%s]", new Object[]{Long.valueOf(ai.bH(VF)), Integer.valueOf(r3), str});
                    } catch (Throwable e2) {
                        e = e2;
                        x.printErrStackTrace("MicroMsg.StartupReport", e, "", new Object[0]);
                        x.e("MicroMsg.StartupReport", "tryReport error url[%s]", new Object[]{str});
                        if (a == null) {
                            a.aBv.disconnect();
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    a = null;
                    x.printErrStackTrace("MicroMsg.StartupReport", e, "", new Object[0]);
                    x.e("MicroMsg.StartupReport", "tryReport error url[%s]", new Object[]{str});
                    if (a == null) {
                        a.aBv.disconnect();
                    }
                }
                if (a == null) {
                    a.aBv.disconnect();
                }
            }
        } else {
            i4 = 1;
        }
        str = "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/reportdevice?channel=" + e.bxk + "&deviceid=" + zz + "&clientversion=" + i2 + "&platform=" + str2 + "&lang=" + chP + "&installtype=" + i4;
        x.i("MicroMsg.StartupReport", "tryReport thread:%s pri:%d  Url[%s] ", new Object[]{Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())), str});
        if (ai.oW(str)) {
            u a2;
            try {
                a2 = b.a(str, null);
                try {
                    a2.setConnectTimeout(10000);
                    a2.setReadTimeout(10000);
                    a2.connect();
                    if (a2.getResponseCode() == m.CTRL_INDEX) {
                        y yVar22 = this.cXG;
                        i2 = e.bxk;
                        int i52 = d.qVN;
                        SharedPreferences sharedPreferences2 = yVar22.context.getSharedPreferences(ad.chY(), 0);
                        sharedPreferences2.edit().putInt("last_reportdevice_channel", i2).commit();
                        sharedPreferences2.edit().putInt("last_reportdevice_clientversion", i52).commit();
                    }
                    x.d("MicroMsg.StartupReport", "report FIN time:%d resp:%d url[%s]", new Object[]{Long.valueOf(ai.bH(VF)), Integer.valueOf(r3), str});
                } catch (Throwable e22) {
                    e = e22;
                    x.printErrStackTrace("MicroMsg.StartupReport", e, "", new Object[0]);
                    x.e("MicroMsg.StartupReport", "tryReport error url[%s]", new Object[]{str});
                    if (a2 == null) {
                        a2.aBv.disconnect();
                    }
                }
            } catch (Exception e32) {
                e = e32;
                a2 = null;
                x.printErrStackTrace("MicroMsg.StartupReport", e, "", new Object[0]);
                x.e("MicroMsg.StartupReport", "tryReport error url[%s]", new Object[]{str});
                if (a2 == null) {
                    a2.aBv.disconnect();
                }
            }
            if (a2 == null) {
                a2.aBv.disconnect();
            }
        }
    }
}
