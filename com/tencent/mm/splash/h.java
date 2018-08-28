package com.tencent.mm.splash;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.splash.a.a;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class h {
    static b sMA;
    static e sMB;
    static Set<SplashActivity> sMC = new HashSet();
    private static boolean sMD = false;
    private static volatile boolean sME = false;
    private static boolean sMF = false;
    private static o sMG;
    private static boolean sMH = false;
    static c sMI;
    private static Class<? extends SplashActivity> sMJ;
    private static Class<? extends Activity> sMK;
    private static n sML = new n();
    private static boolean sMM = false;
    @SuppressLint({"HandlerLeak"})
    private static Handler sMN = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 0) {
                h.ckb();
                return;
            }
            a.gb(h.sMx);
            a.a(new a() {
                public final void cjQ() {
                    h.ckb();
                }

                public final void bxm() {
                    h.b("WxSplash.Splash", "dexopt service return failed. kill self.", new Object[0]);
                    h.cjX();
                }

                public final void cjR() {
                    h.b("WxSplash.Splash", "dexopt service return timeout. kill self.", new Object[0]);
                    h.cjX();
                }
            });
        }
    };
    public static final ArrayList<i> sMv = new ArrayList();
    public static final ArrayList<Message> sMw = new ArrayList();
    static Application sMx;
    static String sMy;
    static d sMz;

    static /* synthetic */ void access$100() {
        boolean z = true;
        try {
            Object cG = cG(sMx);
            String str = "WxSplash.Splash";
            String str2 = "spy, activityThread %s";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(cG == l.sNl);
            b(str, str2, objArr);
            Field declaredField = cG.getClass().getDeclaredField("mH");
            declaredField.setAccessible(true);
            Handler handler = (Handler) declaredField.get(cG);
            str = "WxSplash.Splash";
            str2 = "spy, ActivityThread_mH %s";
            objArr = new Object[1];
            objArr[0] = Boolean.valueOf(handler == l.sNm);
            b(str, str2, objArr);
            Field declaredField2 = Handler.class.getDeclaredField("mCallback");
            declaredField2.setAccessible(true);
            Callback callback = (Callback) declaredField2.get(handler);
            String str3 = "WxSplash.Splash";
            str = "spy, callback %s %s";
            Object[] objArr2 = new Object[2];
            if (callback != l.sNr) {
                z = false;
            }
            objArr2[0] = Boolean.valueOf(z);
            objArr2[1] = callback;
            b(str3, str, objArr2);
        } catch (Throwable e) {
            a(e, "spy failed.");
        }
    }

    static /* synthetic */ void amB() {
        sME = true;
        b("WxSplash.Splash", "pending early replay %s", Boolean.valueOf(sME));
        cjZ();
    }

    static void a(SplashActivity splashActivity) {
        sMC.add(splashActivity);
    }

    static void b(SplashActivity splashActivity) {
        sMC.remove(splashActivity);
    }

    public static String T(Activity activity) {
        if (activity instanceof i) {
            return ((i) activity).sMW;
        }
        return "";
    }

    public static void a(o oVar) {
        sMG = oVar;
    }

    public static void J(Class<? extends SplashActivity> cls) {
        sMJ = cls;
    }

    public static void K(Class<? extends Activity> cls) {
        sMK = cls;
    }

    public static void a(c cVar) {
        sMI = cVar;
    }

    public static void a(d dVar) {
        sMz = dVar;
    }

    public static void a(b bVar) {
        sMA = bVar;
    }

    public static void a(e eVar) {
        sMB = eVar;
    }

    public static void gf(Context context) {
        Object obj = 1;
        try {
            ComponentName fW = bi.fW(context);
            if (fW != null && fW.getPackageName().equals(context.getPackageName()) && sMy != null && fW.getClassName().equals(sMy)) {
                b("WxSplash.Splash", "it is LauncherUI", new Object[0]);
            } else if (fW == null || !fW.getPackageName().startsWith("com.excelliance")) {
                obj = null;
            } else {
                b("WxSplash.Splash", "it is dual open", new Object[0]);
            }
            if (obj == null) {
                b("WxSplash.Splash", "do nothing and return.", new Object[0]);
                return;
            }
            sML.f(675, 36, 1);
            String cjM = a.cjM();
            File file = new File(cjM);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(cjM + "/main-process-blocking");
            if (file.exists()) {
                file.delete();
            }
            if (file.createNewFile()) {
                Intent intent = new Intent(context, sMK);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                context.startActivity(intent);
            }
        } catch (Throwable e) {
            a(e, "request fig leaf failed.");
        }
    }

    public static void XB(String str) {
        sMy = str;
    }

    public static synchronized boolean f(Application application) {
        boolean z;
        synchronized (h.class) {
            if (sMF) {
                b("WxSplash.Splash", "Splash has hacked before.", new Object[0]);
                z = true;
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                sMx = application;
                sML.f(675, 4, 1);
                try {
                    Class cls = Class.forName("android.app.ActivityManagerNative");
                    Method declaredMethod = cls.getDeclaredMethod("getDefault", new Class[0]);
                    declaredMethod.setAccessible(true);
                    Object invoke = declaredMethod.invoke(cls, new Object[0]);
                    if (invoke != null) {
                        b("WxSplash.Splash", "getDefault %s", invoke);
                        if (invoke.getClass().getCanonicalName().startsWith("com.morgoo.droidplugin")) {
                            sML.f(675, 33, 1);
                            b("WxSplash.Splash", "found using droidplugin", new Object[0]);
                        }
                        if (Proxy.isProxyClass(invoke.getClass())) {
                            b("WxSplash.Splash", "found ActivityManager is a Proxy class, " + invoke.getClass(), new Object[0]);
                        }
                    }
                    try {
                        Object obj;
                        Object cG = cG(application);
                        Field declaredField = cG.getClass().getDeclaredField("mInstrumentation");
                        declaredField.setAccessible(true);
                        Instrumentation instrumentation = (Instrumentation) declaredField.get(cG);
                        if (Object.class != instrumentation.getClass().getSuperclass()) {
                            String canonicalName = instrumentation.getClass().getCanonicalName();
                            if (canonicalName.startsWith("android.support.test") || canonicalName.startsWith("android.test")) {
                                b("WxSplash.Splash", "android instrument test is running, do not need splash.", new Object[0]);
                                obj = 1;
                                if (obj != null) {
                                    z = false;
                                } else if (instrumentation == null) {
                                    throw new NullPointerException("Instrumentation original should not be null.");
                                } else if (Object.class != instrumentation.getClass().getSuperclass()) {
                                    sML.f(675, 7, 1);
                                    b("WxSplash.Splash", "Instrumentation original's super class is not Object, maybe hacked by others. orig: %s, super: %s.", instrumentation.getClass(), instrumentation.getClass().getSuperclass());
                                    canonicalName = instrumentation.getClass().getCanonicalName();
                                    RuntimeException runtimeException = new RuntimeException("invalid environment for hack, " + instrumentation.getClass());
                                    int[] iArr = new int[]{40, 41, 42, 43, 44, 45, 46};
                                    if (canonicalName.startsWith(new String[]{"com.excelliance", "com.lbe", "com.beike", "com.lody", "com.doubleagent", "com.svm", "com.morgoo"}[0])) {
                                        sML.f(675, 30, 1);
                                        b("WxSplash.Splash", "invalid environment for hack, dual open.", new Object[0]);
                                    }
                                    sML.f(675, 0, 1);
                                    throw runtimeException;
                                } else {
                                    if (instrumentation instanceof k) {
                                        b("WxSplash.Splash", "instrumentation is splash hacked, why? failed before?", new Object[0]);
                                    } else {
                                        declaredField.set(cG, new k(instrumentation));
                                    }
                                    l.sNl = cG;
                                    Field declaredField2 = cG.getClass().getDeclaredField("mH");
                                    declaredField2.setAccessible(true);
                                    Handler handler = (Handler) declaredField2.get(cG);
                                    if (handler == null) {
                                        throw new RuntimeException("mH is null!");
                                    }
                                    l.sNm = handler;
                                    Field declaredField3 = Handler.class.getDeclaredField("mCallback");
                                    declaredField3.setAccessible(true);
                                    Callback callback = (Callback) declaredField3.get(handler);
                                    l.sNs = declaredField3;
                                    if (callback != null) {
                                        b("WxSplash.Splash", "Handler.Callback original is not null, maybe hacked by others. orig: %s", callback);
                                        sML.f(675, 8, 1);
                                    }
                                    if (callback == null || !(callback instanceof j)) {
                                        j jVar = new j(application, callback);
                                        declaredField3.setAccessible(true);
                                        declaredField3.set(handler, jVar);
                                        l.sNr = jVar;
                                    } else {
                                        b("WxSplash.Splash", "callback is splash hacked, why? failed before?", new Object[0]);
                                    }
                                    handler = new Handler();
                                    j.aa(new Runnable() {
                                        public final void run() {
                                            h.sMM = true;
                                            handler.removeCallbacksAndMessages(null);
                                            h.b("WxSplash.Splash", "verify mH callback hack, result ok.", new Object[0]);
                                        }
                                    });
                                    l.sNm.sendEmptyMessage(987654321);
                                    handler.postDelayed(new Runnable() {
                                        public final void run() {
                                            if (!h.sMM) {
                                                h.b("WxSplash.Splash", "verify mH callback hack, result failed!.", new Object[0]);
                                                h.ckd().f(675, 32, 1);
                                                h.access$100();
                                            }
                                        }
                                    }, 2000);
                                    if (!f.lY) {
                                        Method declaredMethod2 = cG.getClass().getDeclaredMethod("installContentProviders", new Class[]{Context.class, List.class});
                                        declaredMethod2.setAccessible(true);
                                        l.sNq = declaredMethod2;
                                        declaredField2 = cG.getClass().getDeclaredField("mBoundApplication");
                                        declaredField2.setAccessible(true);
                                        invoke = declaredField2.get(cG);
                                        l.sNn = invoke;
                                        Field declaredField4 = invoke.getClass().getDeclaredField("restrictedBackupMode");
                                        declaredField4.setAccessible(true);
                                        declaredField4.set(invoke, Boolean.valueOf(true));
                                        declaredField4 = invoke.getClass().getDeclaredField("providers");
                                        declaredField4.setAccessible(true);
                                        l.sNp = (List) declaredField4.get(invoke);
                                    }
                                    sMF = true;
                                    sMD = true;
                                    b("WxSplash.Splash", "splash hack success.", new Object[0]);
                                    b("WxSplash.Splash", "we need splash. time spent %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    z = true;
                                }
                            }
                        }
                        obj = null;
                        if (obj != null) {
                            z = false;
                        } else if (instrumentation == null) {
                            throw new NullPointerException("Instrumentation original should not be null.");
                        } else if (Object.class != instrumentation.getClass().getSuperclass()) {
                            sML.f(675, 7, 1);
                            b("WxSplash.Splash", "Instrumentation original's super class is not Object, maybe hacked by others. orig: %s, super: %s.", instrumentation.getClass(), instrumentation.getClass().getSuperclass());
                            canonicalName = instrumentation.getClass().getCanonicalName();
                            RuntimeException runtimeException2 = new RuntimeException("invalid environment for hack, " + instrumentation.getClass());
                            int[] iArr2 = new int[]{40, 41, 42, 43, 44, 45, 46};
                            if (canonicalName.startsWith(new String[]{"com.excelliance", "com.lbe", "com.beike", "com.lody", "com.doubleagent", "com.svm", "com.morgoo"}[0])) {
                                sML.f(675, 30, 1);
                                b("WxSplash.Splash", "invalid environment for hack, dual open.", new Object[0]);
                            }
                            sML.f(675, 0, 1);
                            throw runtimeException2;
                        } else {
                            if (instrumentation instanceof k) {
                                b("WxSplash.Splash", "instrumentation is splash hacked, why? failed before?", new Object[0]);
                            } else {
                                declaredField.set(cG, new k(instrumentation));
                            }
                            l.sNl = cG;
                            Field declaredField22 = cG.getClass().getDeclaredField("mH");
                            declaredField22.setAccessible(true);
                            Handler handler2 = (Handler) declaredField22.get(cG);
                            if (handler2 == null) {
                                throw new RuntimeException("mH is null!");
                            }
                            l.sNm = handler2;
                            Field declaredField32 = Handler.class.getDeclaredField("mCallback");
                            declaredField32.setAccessible(true);
                            Callback callback2 = (Callback) declaredField32.get(handler2);
                            l.sNs = declaredField32;
                            if (callback2 != null) {
                                b("WxSplash.Splash", "Handler.Callback original is not null, maybe hacked by others. orig: %s", callback2);
                                sML.f(675, 8, 1);
                            }
                            if (callback2 == null || !(callback2 instanceof j)) {
                                j jVar2 = new j(application, callback2);
                                declaredField32.setAccessible(true);
                                declaredField32.set(handler2, jVar2);
                                l.sNr = jVar2;
                            } else {
                                b("WxSplash.Splash", "callback is splash hacked, why? failed before?", new Object[0]);
                            }
                            handler2 = new Handler();
                            j.aa(/* anonymous class already generated */);
                            l.sNm.sendEmptyMessage(987654321);
                            handler2.postDelayed(/* anonymous class already generated */, 2000);
                            if (!f.lY) {
                                Method declaredMethod22 = cG.getClass().getDeclaredMethod("installContentProviders", new Class[]{Context.class, List.class});
                                declaredMethod22.setAccessible(true);
                                l.sNq = declaredMethod22;
                                declaredField22 = cG.getClass().getDeclaredField("mBoundApplication");
                                declaredField22.setAccessible(true);
                                invoke = declaredField22.get(cG);
                                l.sNn = invoke;
                                Field declaredField42 = invoke.getClass().getDeclaredField("restrictedBackupMode");
                                declaredField42.setAccessible(true);
                                declaredField42.set(invoke, Boolean.valueOf(true));
                                declaredField42 = invoke.getClass().getDeclaredField("providers");
                                declaredField42.setAccessible(true);
                                l.sNp = (List) declaredField42.get(invoke);
                            }
                            sMF = true;
                            sMD = true;
                            b("WxSplash.Splash", "splash hack success.", new Object[0]);
                            b("WxSplash.Splash", "we need splash. time spent %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            z = true;
                        }
                    } catch (Throwable e) {
                        a(e, "splash hack error!");
                        z = false;
                    }
                } catch (Throwable e2) {
                    a(e2, "validateEnvironment found some thing.");
                }
            }
        }
        return z;
    }

    public static void cjT() {
        boolean z = true;
        if (sMF) {
            try {
                Callback callback = (Callback) l.sNs.get(l.sNm);
                String str = "WxSplash.Splash";
                String str2 = "double check, callback %s %s";
                Object[] objArr = new Object[2];
                if (callback != l.sNr) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                objArr[1] = callback;
                b(str, str2, objArr);
                if (callback != l.sNr) {
                    b("WxSplash.Splash", "double check found problem!", new Object[0]);
                    Field field = l.sNs;
                    l.sNr.lGF = callback;
                    field.setAccessible(true);
                    field.set(l.sNm, l.sNr);
                    sML.f(675, 31, 1);
                    l.sNm.sendEmptyMessage(987654321);
                }
            } catch (Throwable e) {
                a(e, "double check exception.");
            }
        }
    }

    public static boolean cjU() {
        return true;
    }

    public static boolean cjV() {
        if (sMD) {
            return true;
        }
        return false;
    }

    public static boolean cjW() {
        return sME;
    }

    public static void cjX() {
        Process.killProcess(Process.myPid());
    }

    public static void cjY() {
        if (f.lY) {
            sMN.sendEmptyMessage(0);
        } else {
            sMN.postDelayed(new Runnable() {
                public final void run() {
                    e.post(new Runnable() {
                        public final void run() {
                            h.sMN.sendEmptyMessage(a.fZ(h.sMx) ? 1 : 0);
                        }
                    }, "checking-need-dexopt");
                }
            }, 150);
        }
    }

    private static void cjZ() {
        b("WxSplash.Splash", "Gonna replay %s pending message(s).", Integer.valueOf(sMw.size()));
        Iterator it = sMw.iterator();
        while (it.hasNext()) {
            l.sNm.sendMessage((Message) it.next());
        }
        sMw.clear();
    }

    private static void cka() {
        b("WxSplash.Splash", "splash done, do finally things. ", new Object[0]);
        sMD = false;
        for (SplashActivity splashActivity : sMC) {
            b("WxSplash.Splash", "iterate splash activity %s.", splashActivity);
            splashActivity.ckh();
        }
        b("WxSplash.Splash", "resend all %s pending message. ", Integer.valueOf(sMw.size()));
        if (!sME) {
            cjZ();
        }
        sMG = null;
        b("WxSplash.Splash", "we need splash no more.", new Object[0]);
        synchronized (h.class) {
            sMH = false;
        }
        n nVar = sML;
        if (nVar.mStartTimestamp > 0) {
            long currentTimeMillis = System.currentTimeMillis() - nVar.mStartTimestamp;
            if (f.lY) {
                nVar.f(676, 1, 1);
                nVar.f(676, 3, currentTimeMillis);
                return;
            }
            nVar.f(676, 0, 1);
            nVar.f(676, 2, currentTimeMillis);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void ckb() {
        /*
        r10 = com.tencent.mm.splash.h.class;
        monitor-enter(r10);
        r2 = sMx;	 Catch:{ all -> 0x002e }
        com.tencent.mm.splash.a.ga(r2);	 Catch:{ all -> 0x002e }
        r3 = com.tencent.mm.splash.h.class;
        monitor-enter(r3);	 Catch:{ all -> 0x002e }
        r2 = sMH;	 Catch:{ all -> 0x0031 }
        if (r2 == 0) goto L_0x0012;
    L_0x000f:
        monitor-exit(r3);	 Catch:{ all -> 0x0031 }
    L_0x0010:
        monitor-exit(r10);
        return;
    L_0x0012:
        r2 = 1;
        sMH = r2;	 Catch:{ all -> 0x0031 }
        monitor-exit(r3);	 Catch:{ all -> 0x0031 }
        r2 = sMF;	 Catch:{ Exception -> 0x0045 }
        if (r2 != 0) goto L_0x0034;
    L_0x001a:
        r2 = "WxSplash.Splash";
        r3 = "not hacked, return.";
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0045 }
        b(r2, r3, r4);	 Catch:{ Exception -> 0x0045 }
    L_0x0026:
        r2 = sMG;	 Catch:{ all -> 0x002e }
        if (r2 != 0) goto L_0x00e9;
    L_0x002a:
        cka();	 Catch:{ all -> 0x002e }
        goto L_0x0010;
    L_0x002e:
        r2 = move-exception;
        monitor-exit(r10);
        throw r2;
    L_0x0031:
        r2 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0031 }
        throw r2;	 Catch:{ all -> 0x002e }
    L_0x0034:
        r2 = com.tencent.mm.splash.f.lY;	 Catch:{ Exception -> 0x0045 }
        if (r2 == 0) goto L_0x0058;
    L_0x0038:
        r2 = "WxSplash.Splash";
        r3 = "not hack content provider, return.";
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0045 }
        b(r2, r3, r4);	 Catch:{ Exception -> 0x0045 }
        goto L_0x0026;
    L_0x0045:
        r2 = move-exception;
        r3 = sML;	 Catch:{ all -> 0x002e }
        r4 = 675; // 0x2a3 float:9.46E-43 double:3.335E-321;
        r6 = 11;
        r8 = 1;
        r3.f(r4, r6, r8);	 Catch:{ all -> 0x002e }
        r3 = "install provider failed!";
        a(r2, r3);	 Catch:{ all -> 0x002e }
        goto L_0x0026;
    L_0x0058:
        r2 = com.tencent.mm.splash.l.sNp;	 Catch:{ Exception -> 0x0045 }
        if (r2 == 0) goto L_0x0026;
    L_0x005c:
        r2 = com.tencent.mm.splash.l.sNp;	 Catch:{ Exception -> 0x0045 }
        r2 = r2.size();	 Catch:{ Exception -> 0x0045 }
        if (r2 == 0) goto L_0x0026;
    L_0x0064:
        r3 = sML;	 Catch:{ Exception -> 0x0045 }
        r4 = 675; // 0x2a3 float:9.46E-43 double:3.335E-321;
        r6 = 10;
        r8 = 1;
        r3.f(r4, r6, r8);	 Catch:{ Exception -> 0x0045 }
        r4 = com.tencent.mm.splash.l.sNl;	 Catch:{ Exception -> 0x0045 }
        r2 = r4.getClass();	 Catch:{ Exception -> 0x0045 }
        r3 = "mInitialApplication";
        r2 = r2.getDeclaredField(r3);	 Catch:{ Exception -> 0x0045 }
        r3 = 1;
        r2.setAccessible(r3);	 Catch:{ Exception -> 0x0045 }
        r3 = r2.get(r4);	 Catch:{ Exception -> 0x0045 }
        r0 = r3;
        r0 = (android.app.Application) r0;	 Catch:{ Exception -> 0x0045 }
        r2 = r0;
        com.tencent.mm.splash.l.sNo = r2;	 Catch:{ Exception -> 0x0045 }
        if (r3 != 0) goto L_0x009a;
    L_0x008c:
        r2 = "WxSplash.Splash";
        r3 = "mInitialApplication is null, use mine. ";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0045 }
        b(r2, r3, r5);	 Catch:{ Exception -> 0x0045 }
        r3 = sMx;	 Catch:{ Exception -> 0x0045 }
    L_0x009a:
        r2 = "com.tencent.mm.plugin.base.stub.WXCommProvider";
        java.lang.Class.forName(r2);	 Catch:{ Throwable -> 0x00e1 }
        r2 = "com.tencent.mm.plugin.base.stub.WXCommProvider$1";
        java.lang.Class.forName(r2);	 Catch:{ Throwable -> 0x00e1 }
        r2 = "WxSplash.Splash";
        r5 = "WXCommProvider is ok";
        r6 = 0;
        r6 = new java.lang.Object[r6];	 Catch:{ Throwable -> 0x00e1 }
        b(r2, r5, r6);	 Catch:{ Throwable -> 0x00e1 }
    L_0x00b2:
        r2 = "WxSplash.Splash";
        r5 = "before delay install ContentProviders. ";
        r6 = 0;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0045 }
        b(r2, r5, r6);	 Catch:{ Exception -> 0x0045 }
        r2 = com.tencent.mm.splash.l.sNq;	 Catch:{ Exception -> 0x0045 }
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0045 }
        r6 = 0;
        r5[r6] = r3;	 Catch:{ Exception -> 0x0045 }
        r3 = 1;
        r6 = com.tencent.mm.splash.l.sNp;	 Catch:{ Exception -> 0x0045 }
        r5[r3] = r6;	 Catch:{ Exception -> 0x0045 }
        r2.invoke(r4, r5);	 Catch:{ Exception -> 0x0045 }
        r2 = "WxSplash.Splash";
        r3 = "delay install ContentProviders. ";
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0045 }
        b(r2, r3, r4);	 Catch:{ Exception -> 0x0045 }
        r2 = com.tencent.mm.splash.l.sNp;	 Catch:{ Exception -> 0x0045 }
        r2.clear();	 Catch:{ Exception -> 0x0045 }
        goto L_0x0026;
    L_0x00e1:
        r2 = move-exception;
        r5 = "before install provider, we found a weird thing.";
        a(r2, r5);	 Catch:{ Exception -> 0x0045 }
        goto L_0x00b2;
    L_0x00e9:
        r2 = sMG;	 Catch:{ all -> 0x002e }
        r3 = new com.tencent.mm.splash.h$5;	 Catch:{ all -> 0x002e }
        r3.<init>();	 Catch:{ all -> 0x002e }
        r2.d(r3);	 Catch:{ all -> 0x002e }
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.splash.h.ckb():void");
    }

    public static Class<? extends Activity> ckc() {
        return sMJ;
    }

    private static Object cG(Context context) {
        Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
        method.setAccessible(true);
        Object invoke = method.invoke(null, new Object[0]);
        if (invoke != null) {
            return invoke;
        }
        Field field = context.getClass().getField("mLoadedApk");
        field.setAccessible(true);
        invoke = field.get(context);
        Field declaredField = invoke.getClass().getDeclaredField("mActivityThread");
        declaredField.setAccessible(true);
        return declaredField.get(invoke);
    }

    public static void b(String str, String str2, Object... objArr) {
        if (sMI != null) {
            sMI.b(str, str2, objArr);
        }
    }

    public static void a(Throwable th, String str) {
        if (sMI != null) {
            sMI.a(th, str);
        }
    }

    public static n ckd() {
        return sML;
    }
}
