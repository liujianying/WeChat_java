package com.tencent.mm.sandbox.monitor;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import com.tencent.mm.sandbox.c;
import com.tencent.mm.sandbox.monitor.b.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class ExceptionMonitorService extends Service {
    public static long dDj = 0;
    public static int sDa = 0;
    private static ExceptionMonitorService sDe = null;
    private long sDb = 300000;
    private ag sDc = new ag();
    private Runnable sDd = new 1(this);
    private long sDf;

    public void onCreate() {
        super.onCreate();
        sDe = this;
        c.i(hashCode(), this);
        this.sDc.postDelayed(this.sDd, this.sDb);
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
        l(intent);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        l(intent);
        return 1;
    }

    public void onDestroy() {
        super.onDestroy();
        sDe = null;
        c.j(hashCode(), this);
        this.sDc.removeCallbacks(this.sDd);
    }

    private void l(Intent intent) {
        if (intent != null) {
            this.sDc.removeCallbacks(this.sDd);
            this.sDc.postDelayed(this.sDd, this.sDb);
            String action = intent.getAction();
            x.d("MicroMsg.CrashMonitorService", "dkcrash handleCommand action:" + action);
            try {
                String stringExtra = intent.getStringExtra("tag");
                if (stringExtra == null) {
                    stringExtra = "exception";
                }
                int intExtra = intent.getIntExtra("exceptionPid", 0);
                stringExtra.equals("exception");
                sDa = intExtra;
                dDj = intent.getLongExtra("exceptionTime", SystemClock.elapsedRealtime());
                String stringExtra2 = intent.getStringExtra("exceptionMsg");
                String stringExtra3 = intent.getStringExtra("userName");
                boolean booleanExtra = intent.getBooleanExtra("exceptionWriteSdcard", true);
                x.d("MicroMsg.CrashMonitorService", "dkcrash handleCommand. action=" + action + " pid:" + intExtra + " tag=" + stringExtra + ", userName=" + stringExtra3 + ", message" + stringExtra2);
                if (!bi.oW(stringExtra2)) {
                    if (a.a(stringExtra3, stringExtra, new a(stringExtra3, stringExtra, bi.VE(), stringExtra2, booleanExtra)) == 0) {
                        fn(this);
                    }
                    if (System.currentTimeMillis() - this.sDf > 600000) {
                        this.sDf = System.currentTimeMillis();
                        e.post(new Runnable() {
                            public final void run() {
                                com.tencent.mm.modelrecovery.a.Qr();
                            }
                        }, "RecoveryWriteLogThread");
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CrashMonitorService", e, "", new Object[0]);
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public static void fn(Context context) {
        Intent intent = new Intent(context, CrashUploadAlarmReceiver.class);
        if (PendingIntent.getBroadcast(context, 0, intent, 536870912) == null) {
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 0);
            ((AlarmManager) context.getSystemService("alarm")).set(0, bi.VF() + 1800000, broadcast);
            x.d("MicroMsg.CrashMonitorService", "dkcrash startAlarmMgr pendingIntent:%d %d", new Object[]{Integer.valueOf(broadcast.hashCode()), Long.valueOf(r2)});
        }
    }
}
