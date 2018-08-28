package com.tencent.mm.splash;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.system.OsConstants;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

public final class a {
    private static String sMl;
    private static String sMm;
    private static File sMn;
    private static long sMo;
    @SuppressLint({"HandlerLeak"})
    private static Handler sMp = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            a aVar = (a) message.obj;
            if (a.cjN()) {
                if (!a.gf(a.sMo)) {
                    a.b(aVar);
                    return;
                } else if (a.fZ(h.sMx)) {
                    if (!a.gc(h.sMx)) {
                        h.ckd().f(675, 18, 1);
                    }
                    h.ckd().f(675, 17, 1);
                    aVar.cjR();
                } else {
                    h.ckd().f(675, 25, 1);
                    aVar.cjQ();
                    return;
                }
            } else if (!a.cjO()) {
                h.ckd().f(675, 15, 1);
                aVar.cjQ();
            } else if (a.fZ(h.sMx)) {
                h.ckd().f(675, 16, 1);
                aVar.bxm();
            } else {
                h.ckd().f(675, 26, 1);
                h.ckd().f(675, 15, 1);
                aVar.cjQ();
            }
            a.sMo = 0;
        }
    };

    public interface a {
        void bxm();

        void cjQ();

        void cjR();
    }

    static /* synthetic */ boolean gf(long j) {
        return System.currentTimeMillis() - j > 180000;
    }

    public static void e(Application application) {
        sMl = new File(application.getFilesDir(), "dexopt_service").getAbsolutePath();
    }

    public static String cjM() {
        if (sMl == null) {
            throw new IllegalStateException("data directory should not be null, give one.");
        }
        File file = new File(sMl);
        if (!(file.exists() || file.mkdirs())) {
            h.b("WxSplash.DexOpt", "data directory create failed.", new Object[0]);
        }
        return sMl;
    }

    public static boolean fZ(Context context) {
        h.b("WxSplash.DexOpt", "if need dexopt %s", Boolean.valueOf(h.sMA.aZ(context)));
        return h.sMA.aZ(context);
    }

    public static void ga(Context context) {
        if (!f.lY) {
            boolean aY;
            h.ckd().f(675, 22, 1);
            try {
                aY = h.sMA.aY(context);
            } catch (Throwable th) {
                h.a(th, "multidex install failed");
                aY = false;
            }
            h.b("WxSplash.DexOpt", "install multidex result %s", Boolean.valueOf(aY));
            if (!aY) {
                h.b("WxSplash.DexOpt", "install multidex failed, kill self.", new Object[0]);
                h.cjX();
            }
        }
    }

    public static void gb(Context context) {
        h.b("WxSplash.DexOpt", "start dex opt service", new Object[0]);
        String an = bi.an(context, Process.myPid());
        an.replace(':', '_');
        sMm = "DexOpt_Request_" + an;
        h.ckd().f(675, 14, 1);
        try {
            XA(sMm);
        } catch (Throwable e) {
            Throwable th = e;
            if (VERSION.SDK_INT <= 19 && th.getClass().getCanonicalName().equals("libcore.io.ErrnoException")) {
                try {
                    Field field = th.getClass().getField("errno");
                    field.setAccessible(true);
                    if (((Integer) field.get(th)).intValue() == OsConstants.ENOSPC) {
                        int i;
                        File file = new File(cjM());
                        if (file.exists()) {
                            h.b("WxSplash.DexOpt", "check dexopt directory size %s.", Integer.valueOf(file.listFiles().length));
                            i = file.listFiles().length < 10000 ? 1 : 0;
                        } else {
                            i = 1;
                        }
                        if (i != 0) {
                            h.sMA.ba(context);
                        } else {
                            h.b("WxSplash.DexOpt", "check dexopt directory size not ok, clean it and throw exception.", new Object[0]);
                            file = new File(cjM());
                            if (file.exists()) {
                                e.l(file);
                            }
                        }
                    }
                } catch (Exception e2) {
                    h.b("WxSplash.DexOpt", "%s, %s", e2.getMessage());
                }
            }
            throw new RuntimeException(th);
        }
        context.startService(new Intent(context, DexOptService.class));
    }

    private static synchronized void XA(String str) {
        synchronized (a.class) {
            String cjM = cjM();
            File file = new File(cjM);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(cjM + "/" + str);
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            sMn = file;
        }
    }

    private static boolean gc(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            List<RunningServiceInfo> runningServices = activityManager.getRunningServices(Integer.MAX_VALUE);
            if (runningServices == null) {
                h.b("WxSplash.DexOpt", "dexopt service may dead, get running services return null.", new Object[0]);
                return false;
            }
            for (RunningServiceInfo runningServiceInfo : runningServices) {
                if ("com.tencent.mm.splash.DexOptService".equals(runningServiceInfo.service.getClassName())) {
                    return true;
                }
            }
        }
        h.b("WxSplash.DexOpt", "dexopt service may dead", new Object[0]);
        return false;
    }

    public static boolean gd(Context context) {
        long j = 0;
        long currentTimeMillis = System.currentTimeMillis();
        h.b("WxSplash.DexOpt", "block checking dex opt result.", new Object[0]);
        while (cjN()) {
            j++;
            Thread.sleep(100);
            if (j >= 5) {
                j = 0;
                if (System.currentTimeMillis() - currentTimeMillis > 180000) {
                    h.b("WxSplash.DexOpt", "block checking dex opt timeout.", new Object[0]);
                    if (fZ(context)) {
                        if (!gc(context)) {
                            h.ckd().f(675, 18, 1);
                        }
                        h.ckd().f(675, 17, 1);
                        return false;
                    }
                    h.ckd().f(675, 25, 1);
                    h.ckd().f(675, 15, 1);
                    return true;
                }
            }
        }
        if (!cjO()) {
            h.ckd().f(675, 15, 1);
            return true;
        } else if (fZ(context)) {
            h.ckd().f(675, 16, 1);
            return false;
        } else {
            h.ckd().f(675, 26, 1);
            h.ckd().f(675, 15, 1);
            return true;
        }
    }

    public static void a(a aVar) {
        b(aVar);
    }

    private static void b(a aVar) {
        if (sMo == 0) {
            sMo = System.currentTimeMillis();
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = aVar;
        sMp.sendMessageDelayed(obtain, 100);
    }

    private static boolean cjN() {
        if (sMn != null) {
            return sMn.exists();
        }
        throw new IllegalStateException("tmp file field should not be null");
    }

    private static boolean cjO() {
        return new File(cjM() + "/DexOpt_Failed").exists();
    }
}
