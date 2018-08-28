package com.tencent.matrix.a.b;

import android.app.AlarmManager.OnAlarmListener;
import android.app.PendingIntent;
import android.os.Build.VERSION;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class b {
    private static boolean bpC;
    private static com.tencent.matrix.a.c.b.b bpD = new com.tencent.matrix.a.c.b.b() {
        public final void b(Method method, Object[] objArr) {
            com.tencent.matrix.d.b.v("Matrix.AlarmManagerServiceHooker", "onServiceMethodInvoke: method name %s", method.getName());
            b.a(method, objArr);
        }
    };
    private static com.tencent.matrix.a.c.b bpE = new com.tencent.matrix.a.c.b("alarm", "android.app.IAlarmManager", bpD);
    private static List<c> bpF = new ArrayList();
    private static Class bpG;
    private static Field bpH;

    private static final class a {
        OnAlarmListener bpq;
        PendingIntent bpy;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    private static final class b {
        static a d(Object[] objArr) {
            if (objArr.length != 2) {
                com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createCancelArgs2 args length invalid : %d", Integer.valueOf(objArr.length));
                return null;
            }
            a aVar = new a();
            if (objArr[0] == null || (objArr[0] instanceof PendingIntent)) {
                aVar.bpy = (PendingIntent) objArr[0];
                if (b.bpG == null || b.bpH == null) {
                    com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs sListenerWrapperCls sListenerField null", new Object[0]);
                    return null;
                } else if (objArr[1] == null || b.bpG.isInstance(objArr[1])) {
                    try {
                        if (objArr[1] != null) {
                            aVar.bpq = (OnAlarmListener) b.bpH.get(objArr[1]);
                        }
                        return aVar;
                    } catch (IllegalAccessException e) {
                        com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 init exp:%s", e.getLocalizedMessage());
                        return null;
                    }
                } else {
                    com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 not ListenerWrapper, %s", objArr[1]);
                    return null;
                }
            }
            com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createCancelArgs2 args idx 0 not PendingIntent, %s", objArr[0]);
            return null;
        }
    }

    public interface c {
        void a(int i, long j, long j2, long j3, int i2, PendingIntent pendingIntent, OnAlarmListener onAlarmListener);

        void a(PendingIntent pendingIntent, OnAlarmListener onAlarmListener);
    }

    private static final class d {
        long bpI;
        long bpn;
        long bpo;
        OnAlarmListener bpq;
        PendingIntent bpy;
        int flags;
        int type;

        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    private static final class e {
        static d e(Object[] objArr) {
            if (objArr.length != 11) {
                com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                return null;
            }
            d dVar = new d();
            if (objArr[1] instanceof Integer) {
                dVar.type = ((Integer) objArr[1]).intValue();
                if (objArr[2] instanceof Long) {
                    dVar.bpn = ((Long) objArr[2]).longValue();
                    if (objArr[3] instanceof Long) {
                        dVar.bpI = ((Long) objArr[3]).longValue();
                        if (objArr[4] instanceof Long) {
                            dVar.bpo = ((Long) objArr[4]).longValue();
                            if (objArr[5] instanceof Integer) {
                                dVar.flags = ((Integer) objArr[5]).intValue();
                                if (objArr[6] == null || (objArr[6] instanceof PendingIntent)) {
                                    dVar.bpy = (PendingIntent) objArr[6];
                                    if (b.bpG == null || b.bpH == null) {
                                        com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs sListenerWrapperCls sListenerField null", new Object[0]);
                                        return null;
                                    }
                                    if (VERSION.SDK_INT >= 24) {
                                        if (objArr[7] == null || b.bpG.isInstance(objArr[7])) {
                                            try {
                                                if (objArr[7] != null) {
                                                    dVar.bpq = (OnAlarmListener) b.bpH.get(objArr[7]);
                                                }
                                            } catch (IllegalAccessException e) {
                                                com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 7 init exp:%s", e.getLocalizedMessage());
                                                return null;
                                            }
                                        }
                                        com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 7 not ListenerWrapper, %s", objArr[7]);
                                        return null;
                                    }
                                    return dVar;
                                }
                                com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 6 not PendingIntent, %s", objArr[6]);
                                return null;
                            }
                            com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 5 not Integer, %s", objArr[5]);
                            return null;
                        }
                        com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 4 not Long, %s", objArr[4]);
                        return null;
                    }
                    com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 3 not Long, %s", objArr[3]);
                    return null;
                }
                com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 2 not Long, %s", objArr[2]);
                return null;
            }
            com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 not Integer, %s", objArr[1]);
            return null;
        }
    }

    static /* synthetic */ void a(Method method, Object[] objArr) {
        a aVar = null;
        int i = (byte) 0;
        if (method.getName().equals("set") || method.getName().equals("setRepeating") || method.getName().equals("setInexactRepeating")) {
            d dVar;
            if (objArr != null) {
                com.tencent.matrix.d.b.i("Matrix.AlarmManagerServiceHooker", "createSetArgs apiLevel:%d, codeName:%s, versionRelease:%s", Integer.valueOf(VERSION.SDK_INT), VERSION.CODENAME, Integer.valueOf(VERSION.SDK_INT));
                com.tencent.matrix.d.b.i("Matrix.AlarmManagerServiceHooker", "createSetArgsAccordingToArgsLength: length:%s", Integer.valueOf(objArr.length));
                d dVar2;
                switch (objArr.length) {
                    case 3:
                        if (objArr.length == 3) {
                            dVar2 = new d();
                            if (!(objArr[0] instanceof Integer)) {
                                com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 0 not Integer, %s", objArr[0]);
                                dVar = null;
                                break;
                            }
                            dVar2.type = ((Integer) objArr[0]).intValue();
                            if (!(objArr[1] instanceof Long)) {
                                com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 not Long, %s", objArr[1]);
                                dVar = null;
                                break;
                            }
                            dVar2.bpn = ((Long) objArr[1]).longValue();
                            if (objArr[2] != null && !(objArr[2] instanceof PendingIntent)) {
                                com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 2 not PendingIntent, %s", objArr[2]);
                                dVar = null;
                                break;
                            }
                            dVar2.bpy = (PendingIntent) objArr[2];
                            dVar = dVar2;
                            break;
                        }
                        com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                        dVar = null;
                        break;
                        break;
                    case 4:
                        if (objArr.length == 4) {
                            dVar2 = new d();
                            if (!(objArr[0] instanceof Integer)) {
                                com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 0 not Integer, %s", objArr[0]);
                                dVar = null;
                                break;
                            }
                            dVar2.type = ((Integer) objArr[0]).intValue();
                            if (!(objArr[1] instanceof Long)) {
                                com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 not Long, %s", objArr[1]);
                                dVar = null;
                                break;
                            }
                            dVar2.bpn = ((Long) objArr[1]).longValue();
                            if (!(objArr[2] instanceof Long)) {
                                com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 2 not Long, %s", objArr[2]);
                                dVar = null;
                                break;
                            }
                            dVar2.bpo = ((Long) objArr[2]).longValue();
                            if (objArr[3] != null && !(objArr[3] instanceof PendingIntent)) {
                                com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 3 not PendingIntent, %s", objArr[3]);
                                dVar = null;
                                break;
                            }
                            dVar2.bpy = (PendingIntent) objArr[3];
                            dVar = dVar2;
                            break;
                        }
                        com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                        dVar = null;
                        break;
                        break;
                    case 6:
                    case 7:
                        if (objArr.length != 7 && objArr.length != 6) {
                            com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                            dVar = null;
                            break;
                        }
                        dVar2 = new d();
                        if (!(objArr[0] instanceof Integer)) {
                            com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 0 not Integer, %s", objArr[0]);
                            dVar = null;
                            break;
                        }
                        dVar2.type = ((Integer) objArr[0]).intValue();
                        if (!(objArr[1] instanceof Long)) {
                            com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 not Long, %s", objArr[1]);
                            dVar = null;
                            break;
                        }
                        dVar2.bpn = ((Long) objArr[1]).longValue();
                        if (!(objArr[2] instanceof Long)) {
                            com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 2 not Long, %s", objArr[2]);
                            dVar = null;
                            break;
                        }
                        dVar2.bpI = ((Long) objArr[2]).longValue();
                        if (!(objArr[3] instanceof Long)) {
                            com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 3 not Long, %s", objArr[3]);
                            dVar = null;
                            break;
                        }
                        dVar2.bpo = ((Long) objArr[3]).longValue();
                        if (objArr[4] != null && !(objArr[4] instanceof PendingIntent)) {
                            com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 4 not PendingIntent, %s", objArr[4]);
                            dVar = null;
                            break;
                        }
                        dVar2.bpy = (PendingIntent) objArr[4];
                        dVar = dVar2;
                        break;
                        break;
                    case 8:
                        if (objArr.length == 8) {
                            dVar2 = new d();
                            if (!(objArr[0] instanceof Integer)) {
                                com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 0 not Integer, %s", objArr[0]);
                                dVar = null;
                                break;
                            }
                            dVar2.type = ((Integer) objArr[0]).intValue();
                            if (!(objArr[1] instanceof Long)) {
                                com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 1 not Long, %s", objArr[1]);
                                dVar = null;
                                break;
                            }
                            dVar2.bpn = ((Long) objArr[1]).longValue();
                            if (!(objArr[2] instanceof Long)) {
                                com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 2 not Long, %s", objArr[2]);
                                dVar = null;
                                break;
                            }
                            dVar2.bpI = ((Long) objArr[2]).longValue();
                            if (!(objArr[3] instanceof Long)) {
                                com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 3 not Long, %s", objArr[3]);
                                dVar = null;
                                break;
                            }
                            dVar2.bpo = ((Long) objArr[3]).longValue();
                            if (!(objArr[4] instanceof Integer)) {
                                com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 4 not Integer, %s", objArr[4]);
                                dVar = null;
                                break;
                            }
                            dVar2.flags = ((Integer) objArr[4]).intValue();
                            if (objArr[5] != null && !(objArr[5] instanceof PendingIntent)) {
                                com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args idx 5 not PendingIntent, %s", objArr[5]);
                                dVar = null;
                                break;
                            }
                            dVar2.bpy = (PendingIntent) objArr[5];
                            dVar = dVar2;
                            break;
                        }
                        com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args length invalid : %d", Integer.valueOf(objArr.length));
                        dVar = null;
                        break;
                        break;
                    default:
                        dVar = e.e(objArr);
                        break;
                }
            }
            com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createSetArgs args null", new Object[0]);
            dVar = null;
            if (dVar == null) {
                com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "dispatchSet setArgs null", new Object[0]);
                return;
            }
            synchronized (b.class) {
                while (true) {
                    byte b;
                    byte b2 = b;
                    if (b2 < bpF.size()) {
                        ((c) bpF.get(b2)).a(dVar.type, dVar.bpn, dVar.bpI, dVar.bpo, dVar.flags, dVar.bpy, dVar.bpq);
                        b = b2 + 1;
                    }
                }
            }
        } else if (method.getName().equals("remove")) {
            if (objArr != null) {
                com.tencent.matrix.d.b.i("Matrix.AlarmManagerServiceHooker", "createCancelArgs apiLevel:%d, codeName:%s, versionRelease:%s", Integer.valueOf(VERSION.SDK_INT), VERSION.CODENAME, Integer.valueOf(VERSION.SDK_INT));
                com.tencent.matrix.d.b.i("Matrix.AlarmManagerServiceHooker", "createCancelArgsAccordingToArgsLength: length:%s", Integer.valueOf(objArr.length));
                switch (objArr.length) {
                    case 1:
                        if (objArr.length == 1) {
                            a aVar2 = new a();
                            if (objArr[0] != null && !(objArr[0] instanceof PendingIntent)) {
                                com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createCancelArgs1 args idx 0 not PendingIntent, %s", objArr[0]);
                                break;
                            }
                            aVar2.bpy = (PendingIntent) objArr[0];
                            aVar = aVar2;
                            break;
                        }
                        com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createCancelArgs1 args length invalid : %d", Integer.valueOf(objArr.length));
                        break;
                        break;
                    default:
                        aVar = b.d(objArr);
                        break;
                }
            }
            com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "createCancelArgs args null", new Object[0]);
            if (aVar == null) {
                com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "dispatchCancel cancelArgs null", new Object[0]);
                return;
            }
            synchronized (b.class) {
                while (i < bpF.size()) {
                    ((c) bpF.get(i)).a(aVar.bpy, aVar.bpq);
                    i++;
                }
            }
        }
    }

    static {
        try {
            Class cls = Class.forName("android.app.AlarmManager$ListenerWrapper");
            bpG = cls;
            Field declaredField = cls.getDeclaredField("mListener");
            bpH = declaredField;
            declaredField.setAccessible(true);
        } catch (ClassNotFoundException e) {
            com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "static init exp:%s", e);
        } catch (NoSuchFieldException e2) {
            com.tencent.matrix.d.b.w("Matrix.AlarmManagerServiceHooker", "static init exp:%s", e2);
        }
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (cVar != null) {
                if (!bpF.contains(cVar)) {
                    bpF.add(cVar);
                    if (!(bpC || bpF.isEmpty())) {
                        com.tencent.matrix.d.b.i("Matrix.AlarmManagerServiceHooker", "checkHook hookRet:%b", Boolean.valueOf(bpE.doHook()));
                        bpC = true;
                    }
                }
            }
        }
    }

    public static synchronized void b(c cVar) {
        synchronized (b.class) {
            if (cVar != null) {
                bpF.remove(cVar);
                if (bpC && bpF.isEmpty()) {
                    com.tencent.matrix.d.b.i("Matrix.AlarmManagerServiceHooker", "checkUnHook unHookRet:%b", Boolean.valueOf(bpE.doUnHook()));
                    bpC = false;
                }
            }
        }
    }
}
