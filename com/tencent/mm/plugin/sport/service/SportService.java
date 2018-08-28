package com.tencent.mm.plugin.sport.service;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.os.Process;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.plugin.sport.a.a.a;
import com.tencent.mm.plugin.sport.c.c;
import com.tencent.mm.plugin.sport.c.g;
import com.tencent.mm.plugin.sport.c.i;
import com.tencent.mm.plugin.sport.c.k;
import com.tencent.mm.plugin.sport.c.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class SportService extends Service implements c {
    private SensorManager ejl;
    private k opr;
    private boolean ops = false;
    private final a opt = new a() {
        public final long bFz() {
            try {
                long ciZ = bi.ciZ() / 10000;
                long xS = i.xS(202);
                long xS2 = i.xS(201);
                int bFO = (int) k.bFO();
                if (k.bFP() == ciZ) {
                    x.i("MicroMsg.Sport.SportService", "cacheTime %s cacheStep:%s", new Object[]{Long.valueOf(k.bFP()), Integer.valueOf(bFO)});
                    return (long) bFO;
                } else if (xS == ciZ) {
                    x.i("MicroMsg.Sport.SportService", "saveTime %s saveStep:%s", new Object[]{Long.valueOf(xS), Long.valueOf(xS2)});
                    return (long) ((int) xS2);
                } else {
                    x.i("MicroMsg.Sport.SportService", "getStepCount:0, new day");
                    x.i("MicroMsg.Sport.SportService", "saveTime:%s, cacheTime: %S, beginOfToday:%s", new Object[]{Long.valueOf(xS), Long.valueOf(r8), Long.valueOf(ciZ)});
                    return 0;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Sport.SportService", e, "exception in :exdevice getTodayDeviceStepCount", new Object[0]);
                return 0;
            }
        }

        public final void Oe(String str) {
            g.Of(str);
            if (!SportService.this.bFT()) {
                SportService.this.stopSelf();
            }
        }

        public final void bFA() {
        }

        public final void K(int i, long j) {
            ((PluginSport) com.tencent.mm.kernel.g.n(PluginSport.class)).getSportFileStorage().setLong(i, j);
        }

        public final long getLong(int i, long j) {
            return ((PluginSport) com.tencent.mm.kernel.g.n(PluginSport.class)).getSportFileStorage().getLong(i, j);
        }

        public final void bFB() {
            ((PluginSport) com.tencent.mm.kernel.g.n(PluginSport.class)).getSportFileStorage().reset();
            Process.killProcess(Process.myPid());
        }
    };
    private Sensor sensor;

    public void onCreate() {
        super.onCreate();
        x.i("MicroMsg.Sport.SportService", "onCreate");
        this.ops = n.ei(this);
        x.i("MicroMsg.Sport.SportService", "isSupportDeviceStep %b", new Object[]{Boolean.valueOf(this.ops)});
        if (this.ops) {
            bFR();
            return;
        }
        x.i("MicroMsg.Sport.SportService", "stop self");
        stopSelf();
    }

    public IBinder onBind(Intent intent) {
        return this.opt;
    }

    private boolean bFR() {
        try {
            if (this.ejl == null) {
                this.ejl = (SensorManager) getSystemService("sensor");
            }
            if (this.opr == null) {
                this.opr = new k();
                this.opr.opk = this;
            }
            if (this.ejl == null || !getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")) {
                x.i("MicroMsg.Sport.SportService", "no step sensor");
                return false;
            }
            this.sensor = this.ejl.getDefaultSensor(19);
            if (this.sensor == null) {
                x.i("MicroMsg.Sport.SportService", " TYPE_STEP_COUNTER sensor null");
                return false;
            }
            boolean registerListener = this.ejl.registerListener(this.opr, this.sensor, g.bFJ().optInt("stepCounterRateUs", 60000));
            if (!registerListener) {
                bFS();
            }
            x.i("MicroMsg.Sport.SportService", "registerDetector() ok.(result : %s)", new Object[]{Boolean.valueOf(registerListener)});
            return registerListener;
        } catch (Exception e) {
            x.e("MicroMsg.Sport.SportService", "Exception in registerDetector %s", new Object[]{e.getMessage()});
        }
    }

    private void bFS() {
        try {
            if (this.ejl == null) {
                this.ejl = (SensorManager) getSystemService("sensor");
            }
            this.ejl.unregisterListener(this.opr);
            x.i("MicroMsg.Sport.SportService", "unregisterDetector() success!");
        } catch (Exception e) {
            x.e("MicroMsg.Sport.SportService", "Exception in unregisterDetector %s", new Object[]{e.getMessage()});
        }
    }

    public void onDestroy() {
        x.i("MicroMsg.Sport.SportService", "onDestroy");
        if (this.ops) {
            bFS();
        }
        super.onDestroy();
    }

    public final boolean bFT() {
        this.ops = n.ei(this);
        if (!this.ops) {
            return false;
        }
        bFS();
        return bFR();
    }

    public final void bFH() {
        bFS();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        x.i("MicroMsg.Sport.SportService", "onStartCommand");
        try {
            if (this.ops) {
                if (this.opr != null) {
                    this.opr.opk = this;
                }
                if (bFT()) {
                    return 1;
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Sport.SportService", e, "Exception onStartCommand %s", new Object[0]);
        }
        return super.onStartCommand(intent, i, i2);
    }
}
