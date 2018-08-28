package com.google.android.gms.wearable;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.wearable.c.b;
import com.google.android.gms.wearable.k.a;
import com.google.android.gms.wearable.n.c;

public abstract class WearableListenerService extends Service implements a$a, b$a, b, a, n.b, c {
    private boolean aFR;
    private IBinder aMX;
    private volatile int bdD = -1;
    private String bdE;
    private Handler bdF;
    private Object bdG = new Object();

    public void a(Channel channel) {
    }

    public void a(Channel channel, int i, int i2) {
    }

    public void a(e eVar) {
    }

    public void a(l lVar) {
    }

    public void a(m mVar) {
    }

    public void b(Channel channel, int i, int i2) {
    }

    public void b(m mVar) {
    }

    public void c(Channel channel, int i, int i2) {
    }

    public final IBinder onBind(Intent intent) {
        return "com.google.android.gms.wearable.BIND_LISTENER".equals(intent.getAction()) ? this.aMX : null;
    }

    public void onCreate() {
        super.onCreate();
        if (Log.isLoggable("WearableLS", 3)) {
            new StringBuilder("onCreate: ").append(getPackageName());
        }
        this.bdE = getPackageName();
        HandlerThread handlerThread = new HandlerThread("WearableListenerService");
        handlerThread.start();
        this.bdF = new Handler(handlerThread.getLooper());
        this.aMX = new a(this);
    }

    public void onDestroy() {
        synchronized (this.bdG) {
            this.aFR = true;
            if (this.bdF == null) {
                throw new IllegalStateException("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()?");
            }
            this.bdF.getLooper().quit();
        }
        super.onDestroy();
    }
}
