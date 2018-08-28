package com.tencent.mm.splash;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import java.io.File;

public class DexOptService extends Service {
    private HandlerThread mHandlerThread = new HandlerThread("DexOpt-Thread");
    private Handler sMq;
    private volatile boolean sMr = false;
    private Handler sMs = new Handler() {
        public final void handleMessage(Message message) {
            h.b("WxSplash.DexOptService", "dexopt process quit.", new Object[0]);
            DexOptService.this.stopSelf();
        }
    };
    private volatile Throwable sMt;

    static /* synthetic */ void Jv() {
        String cjM = a.cjM();
        File file = new File(cjM);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(cjM + "/DexOpt_Failed");
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
            h.b("WxSplash.DexOptService", "addFailedFile", new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    static /* synthetic */ void aSp() {
        File file = new File(a.cjM());
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.exists() && file2.getName().startsWith("DexOpt_Request")) {
                    h.b("WxSplash.DexOptService", "remove temp file %s result %s", file2, Boolean.valueOf(file2.delete()));
                    if (!file2.delete()) {
                        throw new RuntimeException("remove temp file failed");
                    }
                }
            }
            h.b("WxSplash.DexOptService", "removeDexOptTempFiles", new Object[0]);
        }
    }

    static /* synthetic */ void bwD() {
        File file = new File(a.cjM() + "/DexOpt_Failed");
        if (file.exists()) {
            boolean delete = file.delete();
            h.b("WxSplash.DexOptService", "remove failed file %s result %s", file, Boolean.valueOf(delete));
        }
        h.b("WxSplash.DexOptService", "removeFailedFile", new Object[0]);
    }

    static /* synthetic */ void c(DexOptService dexOptService) {
        if (dexOptService.sMt != null) {
            throw new RuntimeException(dexOptService.sMt);
        }
    }

    public void onCreate() {
        h.b("WxSplash.DexOptService", "onCreate", new Object[0]);
        super.onCreate();
        this.mHandlerThread.start();
        this.sMq = new Handler(this.mHandlerThread.getLooper()) {
            public final void handleMessage(Message message) {
                if (DexOptService.this.sMr) {
                    h.b("WxSplash.DexOptService", "dex opt progressing.", new Object[0]);
                    return;
                }
                DexOptService.this.sMr = true;
                if (DexOptService.this.cjS()) {
                    DexOptService.bwD();
                } else {
                    DexOptService.Jv();
                    DexOptService.c(DexOptService.this);
                }
                DexOptService.aSp();
                DexOptService.this.sMr = false;
            }
        };
    }

    private boolean cjS() {
        boolean aY;
        h.b("WxSplash.DexOptService", "doDexOpt start", new Object[0]);
        try {
            aY = h.sMA.aY(getApplicationContext());
        } catch (Throwable th) {
            this.sMt = th;
            aY = false;
        }
        h.b("WxSplash.DexOptService", "schedule to quit", new Object[0]);
        this.sMs.removeCallbacksAndMessages(null);
        this.sMs.sendEmptyMessageDelayed(0, 120000);
        h.b("WxSplash.DexOptService", "doDexOpt done, result %s", Boolean.valueOf(aY));
        return aY;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        this.sMq.sendEmptyMessage(0);
        h.b("WxSplash.DexOptService", "onStartCommand", new Object[0]);
        return super.onStartCommand(intent, i, i2);
    }

    public IBinder onBind(Intent intent) {
        h.b("WxSplash.DexOptService", "onBind", new Object[0]);
        return null;
    }

    public void onDestroy() {
        h.b("WxSplash.DexOptService", "onDestroy", new Object[0]);
        super.onDestroy();
    }
}
