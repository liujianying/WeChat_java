package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import com.google.android.gms.c.aa;
import com.google.android.gms.c.u;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.stats.c.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class b {
    private static final Object aOv = new Object();
    private static b aPH;
    private static final ComponentName aPM = new ComponentName("com.google.android.gms", "com.google.android.gms.common.stats.GmsCoreStatsService");
    private static Integer aPO;
    private final List<String> aPI;
    private final List<String> aPJ;
    private final List<String> aPK;
    private final List<String> aPL;
    private e aPN;

    private b() {
        if (getLogLevel() == d.LOG_LEVEL_OFF) {
            this.aPI = Collections.EMPTY_LIST;
            this.aPJ = Collections.EMPTY_LIST;
            this.aPK = Collections.EMPTY_LIST;
            this.aPL = Collections.EMPTY_LIST;
            return;
        }
        String str = (String) a.aPR.get();
        this.aPI = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) a.aPS.get();
        this.aPJ = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) a.aPT.get();
        this.aPK = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        str = (String) a.aPU.get();
        this.aPL = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        this.aPN = new e(((Long) a.aPV.get()).longValue());
    }

    private static ServiceInfo c(Context context, Intent intent) {
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), aa.dy(20)});
            return null;
        }
        if (queryIntentServices.size() > 1) {
            String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), aa.dy(20)});
            Iterator it = queryIntentServices.iterator();
            if (it.hasNext()) {
                String str = ((ResolveInfo) it.next()).serviceInfo.name;
                return null;
            }
        }
        return ((ResolveInfo) queryIntentServices.get(0)).serviceInfo;
    }

    private static int getLogLevel() {
        if (aPO == null) {
            try {
                aPO = Integer.valueOf(u.qe() ? ((Integer) a.aPQ.get()).intValue() : d.LOG_LEVEL_OFF);
            } catch (SecurityException e) {
                aPO = Integer.valueOf(d.LOG_LEVEL_OFF);
            }
        }
        return aPO.intValue();
    }

    public static b pG() {
        synchronized (aOv) {
            if (aPH == null) {
                aPH = new b();
            }
        }
        return aPH;
    }

    public final void a(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
        a(context, serviceConnection, null, null, 1);
    }

    public final void a(Context context, ServiceConnection serviceConnection, String str, Intent intent, int i) {
        if (f.aNr) {
            Object obj;
            String valueOf = String.valueOf((Process.myPid() << 32) | System.identityHashCode(serviceConnection));
            int logLevel = getLogLevel();
            if (logLevel == d.LOG_LEVEL_OFF || this.aPN == null) {
                obj = null;
            } else if (i == 4 || i == 1) {
                obj = this.aPN.bl(valueOf) ? 1 : null;
            } else {
                ServiceInfo c = c(context, intent);
                if (c == null) {
                    String.format("Client %s made an invalid request %s", new Object[]{str, intent.toUri(0)});
                    obj = null;
                } else {
                    String as = aa.as(context);
                    String str2 = c.processName;
                    String str3 = c.name;
                    if (this.aPI.contains(as) || this.aPJ.contains(str) || this.aPK.contains(str2) || this.aPL.contains(str3) || (str2.equals(as) && (logLevel & d.aQa) != 0)) {
                        obj = null;
                    } else {
                        this.aPN.bk(valueOf);
                        obj = 1;
                    }
                }
            }
            if (obj != null) {
                Parcelable connectionEvent;
                long currentTimeMillis = System.currentTimeMillis();
                String str4 = null;
                if ((getLogLevel() & d.aPZ) != 0) {
                    str4 = aa.dy(5);
                }
                long j = 0;
                if ((getLogLevel() & d.aQb) != 0) {
                    j = Debug.getNativeHeapAllocatedSize();
                }
                if (i == 1 || i == 4) {
                    connectionEvent = new ConnectionEvent(currentTimeMillis, i, null, null, null, null, str4, valueOf, SystemClock.elapsedRealtime(), j);
                } else {
                    ServiceInfo c2 = c(context, intent);
                    connectionEvent = new ConnectionEvent(currentTimeMillis, i, aa.as(context), str, c2.processName, c2.name, str4, valueOf, SystemClock.elapsedRealtime(), j);
                }
                context.startService(new Intent().setComponent(aPM).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", connectionEvent));
            }
        }
    }

    public final boolean a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return a(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    public final boolean a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        ComponentName component = intent.getComponent();
        boolean l = (component == null || (f.aNr && "com.google.android.gms".equals(component.getPackageName()))) ? false : u.l(context, component.getPackageName());
        if (l) {
            return false;
        }
        boolean bindService = context.bindService(intent, serviceConnection, i);
        if (bindService) {
            a(context, serviceConnection, str, intent, 2);
        }
        return bindService;
    }
}
