package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.sandbox.c;
import com.tencent.mm.sandbox.updater.j.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20141015", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class UpdaterService extends Service {
    private static UpdaterService sES = null;
    static final long sEU = 1800000;
    private boolean eaR = false;
    Map<Integer, a> sET = new HashMap();
    private al sEV = new al(new 1(this), true);
    private a sEW = null;

    public static void cy() {
        x.i("MicroMsg.UpdaterService", "UpdaterService stopInstance()");
        if (sES != null) {
            sES.chm();
        }
    }

    public static UpdaterService chl() {
        return sES;
    }

    public void onCreate() {
        super.onCreate();
        x.i("MicroMsg.UpdaterService", "onCreate");
        c.i(hashCode(), this);
        sES = this;
        this.sET.put(Integer.valueOf(0), a.sER);
        this.sET.put(Integer.valueOf(1), d.cgU());
        this.sET.put(Integer.valueOf(2), d.cgU());
        this.sET.put(Integer.valueOf(4), k.a.sEZ);
        this.sET.put(Integer.valueOf(5), k.a.sEZ);
        MMActivity.initLanguage(this);
        al alVar = this.sEV;
        long j = sEU;
        alVar.J(j, j);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.sEW = new a();
        registerReceiver(this.sEW, intentFilter);
    }

    public void onStart(Intent intent, int i) {
        x.i("MicroMsg.UpdaterService", "onStart intent = %s", new Object[]{intent});
        l(intent);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        x.i("MicroMsg.UpdaterService", "onStartCommand intent = %s", new Object[]{intent});
        if (intent != null) {
            if (intent.getBooleanExtra("intent_extra_run_in_foreground", false)) {
                x.i("MicroMsg.UpdaterService", "runServiceInForground");
                startForeground(0, new Builder(this).setTicker("updater service running forground").setWhen(System.currentTimeMillis()).setContentTitle("Updater Service").setContentText("updater service running forground").setContentIntent(PendingIntent.getService(this, 0, new Intent(), 0)).getNotification());
                this.eaR = true;
            } else if (VERSION.SDK_INT < 18 && !this.eaR) {
                startForeground(-1314, new Notification());
                this.eaR = true;
            }
        }
        l(intent);
        return 2;
    }

    public void onDestroy() {
        x.i("MicroMsg.UpdaterService", "onDestroy");
        this.sEV.SO();
        if (this.sEW != null) {
            unregisterReceiver(this.sEW);
        }
        if (this.eaR) {
            stopForeground(true);
        }
        for (a onDestroy : this.sET.values()) {
            onDestroy.onDestroy();
        }
        this.sET.clear();
        sES = null;
        c.j(hashCode(), this);
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    private void l(Intent intent) {
        if (intent != null) {
            x.i("MicroMsg.UpdaterService", "handleCommand, downloadType = %d", new Object[]{Integer.valueOf(intent.getIntExtra("intent_extra_download_type", 0))});
            a aVar = (a) this.sET.get(Integer.valueOf(r0));
            if (aVar != null) {
                x.i("MicroMsg.UpdaterService", "handleCommand ret = %b", new Object[]{Boolean.valueOf(aVar.ao(intent))});
                if (!aVar.ao(intent)) {
                    chm();
                }
            }
        }
    }

    private boolean chm() {
        if (this.sET.size() > 0) {
            for (a isBusy : this.sET.values()) {
                if (isBusy.isBusy()) {
                    x.i("MicroMsg.UpdaterService", "checkAndTryStopSelf, dont stop, some download mgr still busy");
                    return false;
                }
            }
        }
        x.i("MicroMsg.UpdaterService", "checkAndTryStopSelf, UpdaterService killed self");
        ah.i(new Runnable() {
            public final void run() {
                if (UpdaterService.this.sET.size() > 0) {
                    for (a isBusy : UpdaterService.this.sET.values()) {
                        if (isBusy.isBusy()) {
                            x.i("MicroMsg.UpdaterService", "checkAndTryStopSelf2, dont stop, some download mgr still busy");
                            return;
                        }
                    }
                }
                if (u.a.cbC()) {
                    x.i("TBSDownloadMgr", "is still busy");
                } else {
                    UpdaterService.this.stopSelf();
                }
            }
        }, 10000);
        return true;
    }
}
