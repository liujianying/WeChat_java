package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.os.HandlerThread;
import android.view.View;
import com.tencent.mm.sdk.f.e;
import java.io.Closeable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class ListenerInstanceMonitor {
    private static final Map<Object, Set<a>> sFW = new WeakHashMap();
    private static final byte[] sFX = new byte[0];
    private static Field sFY;
    private static HandlerThread sFZ;
    private static ag sGa;
    private static volatile boolean sGb;
    private static final String sGc = Activity.class.getName();
    private static final Runnable sGd = new Runnable() {
        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r14 = this;
            r4 = 1;
            r2 = 0;
            r1 = com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.sGd;
            monitor-enter(r1);
            r0 = com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.sGb;	 Catch:{ all -> 0x0042 }
            if (r0 != 0) goto L_0x000f;
        L_0x000d:
            monitor-exit(r1);	 Catch:{ all -> 0x0042 }
        L_0x000e:
            return;
        L_0x000f:
            monitor-exit(r1);	 Catch:{ all -> 0x0042 }
            r1 = com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.sFX;
            monitor-enter(r1);
            r0 = com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.sFW;	 Catch:{ all -> 0x0056 }
            r0 = r0.isEmpty();	 Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x0045;
        L_0x001f:
            r0 = "MicroMsg.ListenerInstanceMonitor";
            r2 = "[tomys] monitor task: no listener or cb was added, skip rest logic.";
            com.tencent.mm.sdk.platformtools.x.d(r0, r2);	 Catch:{ all -> 0x0056 }
            monitor-exit(r1);	 Catch:{ all -> 0x0056 }
        L_0x0029:
            r1 = com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.sGd;
            monitor-enter(r1);
            r0 = com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.sGb;	 Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x003d;
        L_0x0034:
            r0 = com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.sGa;	 Catch:{ all -> 0x003f }
            r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
            r0.postDelayed(r14, r2);	 Catch:{ all -> 0x003f }
        L_0x003d:
            monitor-exit(r1);	 Catch:{ all -> 0x003f }
            goto L_0x000e;
        L_0x003f:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x003f }
            throw r0;
        L_0x0042:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0042 }
            throw r0;
        L_0x0045:
            monitor-exit(r1);	 Catch:{ all -> 0x0056 }
            r0 = android.os.Debug.isDebuggerConnected();
            if (r0 == 0) goto L_0x0059;
        L_0x004c:
            r0 = "MicroMsg.ListenerInstanceMonitor";
            r1 = "[tomys] monitor task: found debugger connected, disable monitor works in case of misreport.";
            com.tencent.mm.sdk.platformtools.x.w(r0, r1);
            goto L_0x0029;
        L_0x0056:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0056 }
            throw r0;
        L_0x0059:
            r0 = "MicroMsg.ListenerInstanceMonitor";
            r1 = "[tomys] monitor task: triggering gc...";
            com.tencent.mm.sdk.platformtools.x.d(r0, r1);
            r0 = java.lang.Runtime.getRuntime();	 Catch:{ Throwable -> 0x0211 }
            r0.gc();	 Catch:{ Throwable -> 0x0211 }
            r0 = 100;
            java.lang.Thread.sleep(r0);	 Catch:{ Throwable -> 0x0211 }
            r0 = java.lang.Runtime.getRuntime();	 Catch:{ Throwable -> 0x0211 }
            r0.runFinalization();	 Catch:{ Throwable -> 0x0211 }
        L_0x0075:
            r5 = com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.sFX;
            monitor-enter(r5);
            r0 = com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.sFW;	 Catch:{ all -> 0x00d1 }
            r0 = r0.entrySet();	 Catch:{ all -> 0x00d1 }
            r6 = r0.iterator();	 Catch:{ all -> 0x00d1 }
        L_0x0086:
            r0 = r6.hasNext();	 Catch:{ all -> 0x00d1 }
            if (r0 == 0) goto L_0x020e;
        L_0x008c:
            r0 = r6.next();	 Catch:{ all -> 0x00d1 }
            r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x00d1 }
            r0 = r0.getValue();	 Catch:{ all -> 0x00d1 }
            r0 = (java.util.Set) r0;	 Catch:{ all -> 0x00d1 }
            r7 = r0.iterator();	 Catch:{ all -> 0x00d1 }
        L_0x009c:
            r0 = r7.hasNext();	 Catch:{ all -> 0x00d1 }
            if (r0 == 0) goto L_0x0086;
        L_0x00a2:
            r0 = r7.next();	 Catch:{ all -> 0x00d1 }
            r0 = (com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.a) r0;	 Catch:{ all -> 0x00d1 }
            r1 = r0.sGe;	 Catch:{ all -> 0x00d1 }
            r8 = r1.get();	 Catch:{ all -> 0x00d1 }
            r1 = r0.sGf;	 Catch:{ all -> 0x00d1 }
            r1 = r1.get();	 Catch:{ all -> 0x00d1 }
            r1 = (android.app.Activity) r1;	 Catch:{ all -> 0x00d1 }
            if (r1 != 0) goto L_0x00d4;
        L_0x00b8:
            r1 = "MicroMsg.ListenerInstanceMonitor";
            r3 = "[tomys] monitor task: Ok, ui [%s] was recycled.";
            r8 = 1;
            r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x00d1 }
            r9 = 0;
            r0 = r0.sGg;	 Catch:{ all -> 0x00d1 }
            r0 = r0.getName();	 Catch:{ all -> 0x00d1 }
            r8[r9] = r0;	 Catch:{ all -> 0x00d1 }
            com.tencent.mm.sdk.platformtools.x.i(r1, r3, r8);	 Catch:{ all -> 0x00d1 }
            r7.remove();	 Catch:{ all -> 0x00d1 }
            goto L_0x009c;
        L_0x00d1:
            r0 = move-exception;
            monitor-exit(r5);	 Catch:{ all -> 0x00d1 }
            throw r0;
        L_0x00d4:
            r1 = r1.isDestroyed();	 Catch:{ all -> 0x00d1 }
            if (r1 != 0) goto L_0x0136;
        L_0x00da:
            r1 = r2;
        L_0x00db:
            if (r1 == 0) goto L_0x009c;
        L_0x00dd:
            if (r8 != 0) goto L_0x009c;
        L_0x00df:
            r1 = r0.sGj;	 Catch:{ all -> 0x00d1 }
            r3 = 3;
            if (r1 <= r3) goto L_0x01e8;
        L_0x00e4:
            r7.remove();	 Catch:{ all -> 0x00d1 }
            r1 = com.tencent.mm.sdk.platformtools.bj.cjh();	 Catch:{ all -> 0x00d1 }
            if (r1 != 0) goto L_0x00f3;
        L_0x00ed:
            r1 = com.tencent.mm.sdk.platformtools.bj.chn();	 Catch:{ all -> 0x00d1 }
            if (r1 == 0) goto L_0x0169;
        L_0x00f3:
            r3 = r4;
        L_0x00f4:
            r8 = new com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor$ListenerLeakedException;	 Catch:{ all -> 0x00d1 }
            r1 = r0.sGf;	 Catch:{ all -> 0x00d1 }
            r1 = r1.get();	 Catch:{ all -> 0x00d1 }
            if (r1 != 0) goto L_0x0189;
        L_0x00fe:
            r1 = r0.sGh;	 Catch:{ all -> 0x00d1 }
            if (r1 == 0) goto L_0x016b;
        L_0x0102:
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d1 }
            r9 = "ui of class [";
            r1.<init>(r9);	 Catch:{ all -> 0x00d1 }
            r9 = r0.sGg;	 Catch:{ all -> 0x00d1 }
            r9 = r9.getName();	 Catch:{ all -> 0x00d1 }
            r1 = r1.append(r9);	 Catch:{ all -> 0x00d1 }
            r9 = "] held by\n [";
            r1 = r1.append(r9);	 Catch:{ all -> 0x00d1 }
            r9 = r0.chK();	 Catch:{ all -> 0x00d1 }
            r1 = r1.append(r9);	 Catch:{ all -> 0x00d1 }
            r9 = "] is recycled";
            r1 = r1.append(r9);	 Catch:{ all -> 0x00d1 }
            r1 = r1.toString();	 Catch:{ all -> 0x00d1 }
        L_0x012e:
            r0 = r0.sGi;	 Catch:{ all -> 0x00d1 }
            r8.<init>(r1, r0);	 Catch:{ all -> 0x00d1 }
            if (r3 == 0) goto L_0x01da;
        L_0x0135:
            throw r8;	 Catch:{ all -> 0x00d1 }
        L_0x0136:
            r3 = android.os.Looper.getMainLooper();	 Catch:{ all -> 0x00d1 }
            r3 = r3.getThread();	 Catch:{ all -> 0x00d1 }
            r9 = r3.getStackTrace();	 Catch:{ all -> 0x00d1 }
            r10 = r9.length;	 Catch:{ all -> 0x00d1 }
            r3 = r2;
        L_0x0144:
            if (r3 >= r10) goto L_0x00db;
        L_0x0146:
            r11 = r9[r3];	 Catch:{ all -> 0x00d1 }
            r12 = com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.sGc;	 Catch:{ all -> 0x00d1 }
            r13 = r11.getClassName();	 Catch:{ all -> 0x00d1 }
            r12 = r12.equals(r13);	 Catch:{ all -> 0x00d1 }
            if (r12 == 0) goto L_0x0166;
        L_0x0156:
            r12 = "performDestroy";
            r11 = r11.getMethodName();	 Catch:{ all -> 0x00d1 }
            r11 = r12.equals(r11);	 Catch:{ all -> 0x00d1 }
            if (r11 == 0) goto L_0x0166;
        L_0x0163:
            r1 = r2;
            goto L_0x00db;
        L_0x0166:
            r3 = r3 + 1;
            goto L_0x0144;
        L_0x0169:
            r3 = r2;
            goto L_0x00f4;
        L_0x016b:
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d1 }
            r9 = "ui of class [";
            r1.<init>(r9);	 Catch:{ all -> 0x00d1 }
            r9 = r0.sGg;	 Catch:{ all -> 0x00d1 }
            r9 = r9.getName();	 Catch:{ all -> 0x00d1 }
            r1 = r1.append(r9);	 Catch:{ all -> 0x00d1 }
            r9 = "] which is subclass of\n listener or callback and held by other 'Manager' class is recycled";
            r1 = r1.append(r9);	 Catch:{ all -> 0x00d1 }
            r1 = r1.toString();	 Catch:{ all -> 0x00d1 }
            goto L_0x012e;
        L_0x0189:
            r1 = r0.sGh;	 Catch:{ all -> 0x00d1 }
            if (r1 == 0) goto L_0x01bb;
        L_0x018d:
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d1 }
            r9 = "ui of class [";
            r1.<init>(r9);	 Catch:{ all -> 0x00d1 }
            r9 = r0.sGg;	 Catch:{ all -> 0x00d1 }
            r9 = r9.getName();	 Catch:{ all -> 0x00d1 }
            r1 = r1.append(r9);	 Catch:{ all -> 0x00d1 }
            r9 = "] held by\n [";
            r1 = r1.append(r9);	 Catch:{ all -> 0x00d1 }
            r9 = r0.chK();	 Catch:{ all -> 0x00d1 }
            r1 = r1.append(r9);	 Catch:{ all -> 0x00d1 }
            r9 = "] is leaked.\n Perhaps you should remove the holder from any 'Manager' class when the leaked ui was destroyed.";
            r1 = r1.append(r9);	 Catch:{ all -> 0x00d1 }
            r1 = r1.toString();	 Catch:{ all -> 0x00d1 }
            goto L_0x012e;
        L_0x01bb:
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00d1 }
            r9 = "ui of class [";
            r1.<init>(r9);	 Catch:{ all -> 0x00d1 }
            r9 = r0.sGg;	 Catch:{ all -> 0x00d1 }
            r9 = r9.getName();	 Catch:{ all -> 0x00d1 }
            r1 = r1.append(r9);	 Catch:{ all -> 0x00d1 }
            r9 = "] which is subclass of\n listener or callback and held by other 'Manager' class is leaked.\n Perhaps you should remove any instance of this class from any 'Manager'";
            r1 = r1.append(r9);	 Catch:{ all -> 0x00d1 }
            r1 = r1.toString();	 Catch:{ all -> 0x00d1 }
            goto L_0x012e;
        L_0x01da:
            r0 = "MicroMsg.ListenerInstanceMonitor";
            r1 = "";
            r3 = 0;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x00d1 }
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r0, r8, r1, r3);	 Catch:{ all -> 0x00d1 }
            goto L_0x009c;
        L_0x01e8:
            r1 = r0.sGj;	 Catch:{ all -> 0x00d1 }
            r1 = r1 + 1;
            r0.sGj = r1;	 Catch:{ all -> 0x00d1 }
            r1 = "MicroMsg.ListenerInstanceMonitor";
            r3 = "[tomys] monitor task: ui [%s] was recycled, but its instance is still exists in %s time(s) check.";
            r8 = 2;
            r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x00d1 }
            r9 = 0;
            r10 = r0.sGg;	 Catch:{ all -> 0x00d1 }
            r10 = r10.getName();	 Catch:{ all -> 0x00d1 }
            r8[r9] = r10;	 Catch:{ all -> 0x00d1 }
            r9 = 1;
            r0 = r0.sGj;	 Catch:{ all -> 0x00d1 }
            r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x00d1 }
            r8[r9] = r0;	 Catch:{ all -> 0x00d1 }
            com.tencent.mm.sdk.platformtools.x.w(r1, r3, r8);	 Catch:{ all -> 0x00d1 }
            goto L_0x009c;
        L_0x020e:
            monitor-exit(r5);	 Catch:{ all -> 0x00d1 }
            goto L_0x0029;
        L_0x0211:
            r0 = move-exception;
            goto L_0x0075;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor.1.run():void");
        }
    };

    private static final class ListenerLeakedException extends RuntimeException {
        ListenerLeakedException(String str, Throwable th) {
            super(str + "\n See stacktrace to find where is the holder(listener) being added.");
            setStackTrace(th.getStackTrace());
        }

        public final Throwable fillInStackTrace() {
            return this;
        }
    }

    private static class a {
        final WeakReference<Object> sGe = new WeakReference(new Object());
        WeakReference<Activity> sGf;
        Class<?> sGg;
        Field sGh;
        Throwable sGi;
        int sGj;

        a(Activity activity, Field field, Throwable th) {
            this.sGf = new WeakReference(activity);
            this.sGg = activity.getClass();
            this.sGh = field;
            this.sGi = th;
            this.sGj = 0;
        }

        public final String toString() {
            return chK() + "@" + chJ().replace(10, '|');
        }

        private String chJ() {
            Throwable th;
            Writer stringWriter = new StringWriter();
            Closeable printWriter;
            try {
                printWriter = new PrintWriter(stringWriter);
                try {
                    this.sGi.printStackTrace(printWriter);
                    bi.d(printWriter);
                    return stringWriter.toString();
                } catch (Throwable th2) {
                    th = th2;
                    bi.d(printWriter);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                printWriter = null;
                bi.d(printWriter);
                throw th;
            }
        }

        final String chK() {
            if (this.sGh == null) {
                return "#null#";
            }
            Object declaringClass = this.sGh.getDeclaringClass();
            if (!declaringClass.isAnonymousClass()) {
                return "field " + this.sGh.getName() + " defined in " + declaringClass.getName();
            }
            Type genericSuperclass = declaringClass.getGenericSuperclass();
            if (Object.class.equals(genericSuperclass)) {
                declaringClass = declaringClass.getGenericInterfaces()[0];
            } else if (genericSuperclass != null) {
                Type declaringClass2 = genericSuperclass;
            }
            return "field " + this.sGh.getName() + " define in anonymous class of " + declaringClass2.toString().replace('<', '#').replace('>', '#');
        }

        public final int hashCode() {
            int hashCode;
            int hashCode2;
            int i = 0;
            Object obj = this.sGf.get();
            if (obj != null) {
                hashCode = obj.hashCode();
            } else {
                hashCode = 0;
            }
            if (this.sGh != null) {
                hashCode2 = this.sGh.hashCode();
            } else {
                hashCode2 = 0;
            }
            if (this.sGi != null) {
                i = this.sGi.hashCode();
            }
            return (hashCode + hashCode2) + i;
        }

        public final boolean equals(Object obj) {
            boolean z = true;
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.sGf.get();
            Object obj3 = aVar.sGf.get();
            boolean equals = (obj2 == null && obj3 == null) ? true : (obj2 == null || obj3 == null) ? false : obj2.equals(obj3);
            if (!equals) {
                return false;
            }
            Field field = this.sGh;
            Field field2 = aVar.sGh;
            equals = (field == null && field2 == null) ? true : (field == null || field2 == null) ? false : field.equals(field2);
            if (!equals) {
                return false;
            }
            Throwable th = this.sGi;
            Throwable th2 = aVar.sGi;
            if (!(th == null && th2 == null)) {
                z = (th == null || th2 == null) ? false : th.equals(th2);
            }
            return z;
        }
    }

    static {
        sFY = null;
        sFZ = null;
        sGa = null;
        sGb = false;
        if (!bj.cjh() && !bj.chn()) {
            x.w("MicroMsg.ListenerInstanceMonitor", "Not debug, assist or monkey env, keep disabled.");
        } else if (ad.cic()) {
            try {
                Field declaredField = View.class.getDeclaredField("mContext");
                sFY = declaredField;
                declaredField.setAccessible(true);
                synchronized (sGd) {
                    if (!sGb) {
                        HandlerThread Xs = e.Xs("ListenerInstanceMonitor");
                        sFZ = Xs;
                        Xs.start();
                        ag agVar = new ag(sFZ.getLooper());
                        sGa = agVar;
                        agVar.postDelayed(sGd, 10000);
                        sGb = true;
                    }
                }
            } catch (Throwable th) {
                x.printErrStackTrace("MicroMsg.ListenerInstanceMonitor", th, "init failed, keep disabled.", new Object[0]);
            }
        } else {
            x.w("MicroMsg.ListenerInstanceMonitor", "Not mm process, keep disabled.");
        }
    }

    public static void cc(Object obj) {
        if (obj != null) {
            Throwable th = new Throwable();
            for (Class cls = obj.getClass(); !Object.class.equals(cls); cls = cls.getSuperclass()) {
                if (Activity.class.isAssignableFrom(cls)) {
                    a(obj, null, th);
                } else if (View.class.isAssignableFrom(cls)) {
                    b(obj, null, th);
                } else {
                    for (Field field : cls.getDeclaredFields()) {
                        Class type = field.getType();
                        if (Activity.class.isAssignableFrom(type)) {
                            a(obj, field, th);
                        } else if (View.class.isAssignableFrom(type)) {
                            b(obj, field, th);
                        }
                    }
                }
            }
        }
    }

    private static void a(Object obj, Field field, Throwable th) {
        Activity activity;
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            try {
                activity = (Activity) field.get(obj);
                if (activity == null) {
                    return;
                }
            } catch (Throwable th2) {
                return;
            }
        } else if (obj instanceof Activity) {
            activity = (Activity) obj;
        } else {
            return;
        }
        a(obj, activity, field, th);
    }

    private static void b(Object obj, Field field, Throwable th) {
        Object obj2;
        if (field == null) {
            if (obj instanceof View) {
                obj2 = (View) obj;
            } else {
                return;
            }
        } else if (sFY != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            try {
                View obj22 = (View) field.get(obj);
                if (obj22 == null) {
                    return;
                }
            } catch (Throwable th2) {
                return;
            }
        } else {
            return;
        }
        try {
            obj22 = sFY.get(obj22);
            if (obj22 instanceof Activity) {
                a(obj, (Activity) obj22, field, th);
            }
        } catch (Throwable th3) {
        }
    }

    private static void a(Object obj, Activity activity, Field field, Throwable th) {
        int length;
        f fVar = null;
        if (obj.getClass().isAnnotationPresent(f.class)) {
            fVar = (f) obj.getClass().getAnnotation(f.class);
        } else {
            for (Method method : obj.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(f.class)) {
                    fVar = (f) method.getAnnotation(f.class);
                    break;
                }
            }
        }
        if (fVar != null) {
            int i;
            Class cls = activity.getClass();
            Class[] chx = fVar.chx();
            if (chx != null && chx.length > 0) {
                length = chx.length;
                i = 0;
                while (i < length) {
                    if (!cls.equals(chx[i])) {
                        i++;
                    }
                }
                i = 0;
                if (i != 0) {
                    x.w("MicroMsg.ListenerInstanceMonitor", "Activity %s held by %s is ignored !!", activity, obj);
                    return;
                }
            }
            i = 1;
            if (i != 0) {
                x.w("MicroMsg.ListenerInstanceMonitor", "Activity %s held by %s is ignored !!", activity, obj);
                return;
            }
        }
        synchronized (sFX) {
            Set set = (Set) sFW.get(obj);
            if (set == null) {
                set = new HashSet();
                sFW.put(obj, set);
            }
            set.add(new a(activity, field, th));
        }
    }

    public static void cd(Object obj) {
        if (obj != null) {
            synchronized (sFX) {
                sFW.remove(obj);
            }
        }
    }
}
