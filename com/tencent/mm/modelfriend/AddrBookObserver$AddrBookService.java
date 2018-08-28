package com.tencent.mm.modelfriend;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import com.tencent.mm.g.a.ik;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public class AddrBookObserver$AddrBookService extends Service {
    public static boolean aBS = false;
    public static boolean dRw = false;
    public static String dRy = "key_sync_session";
    private b dRz = new 1(this);

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        String str = "MicroMsg.AddrBookObserver";
        String str2 = "service start intent:%b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(intent == null);
        x.i(str, str2, objArr);
        if (intent == null) {
            x.e("MicroMsg.AddrBookObserver", "intent == null, stop service");
            stopSelf();
        } else {
            float floatExtra = intent.getFloatExtra(dRy, -1.0f);
            if (floatExtra == -1.0f) {
                x.e("MicroMsg.AddrBookObserver", "onStartCommand session == -1, stop service");
                stopSelf();
            } else {
                SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences(ad.chY(), 0);
                if (sharedPreferences.getFloat(dRy, 0.0f) == floatExtra) {
                    x.d("MicroMsg.AddrBookObserver", "onStartCommand session the same : %f", new Object[]{Float.valueOf(sharedPreferences.getFloat(dRy, 0.0f))});
                    stopSelf();
                } else {
                    sharedPreferences.edit().putFloat(dRy, floatExtra).commit();
                    x.d("MicroMsg.AddrBookObserver", "onStartCommand new session:%f", new Object[]{Float.valueOf(floatExtra)});
                    if (aBS) {
                        x.i("MicroMsg.AddrBookObserver", "service canceled");
                        aBS = false;
                        stopSelf();
                    } else {
                        try {
                            if (g.Eg().Dx()) {
                                if (com.tencent.mm.k.g.AT().getInt("WCOEntranceSwitch", 0) > 0) {
                                    a.sFg.m(new ik());
                                }
                                if (!l.XF() || l.XB()) {
                                    x.e("MicroMsg.AddrBookObserver", "can not sync addr book now, stop service");
                                    stopSelf();
                                } else {
                                    x.i("MicroMsg.AddrBookObserver", "start sync");
                                    if (com.tencent.mm.platformtools.x.cd(this)) {
                                        x.e("MicroMsg.AddrBookObserver", "requestSync false, stop service");
                                        stopSelf();
                                    } else {
                                        dRw = true;
                                        com.tencent.mm.platformtools.b.syncAddrBook(this.dRz);
                                    }
                                }
                            } else {
                                x.i("MicroMsg.AddrBookObserver", "account not ready, stop sync");
                                stopSelf();
                            }
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.AddrBookObserver", e, "", new Object[0]);
                            x.e("MicroMsg.AddrBookObserver", "AddrBookService onStart [%s]", new Object[]{e.getMessage()});
                            stopSelf();
                        }
                    }
                }
            }
        }
        return 2;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }
}
