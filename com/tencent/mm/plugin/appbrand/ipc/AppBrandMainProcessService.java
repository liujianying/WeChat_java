package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Messenger;
import android.os.Parcel;
import com.tencent.mm.plugin.appbrand.ipc.c.a;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AppBrandMainProcessService extends Service {
    private static c fDG;
    private static ServiceConnection fDH;
    private static final LinkedList<Parcel> fDI = new LinkedList();
    private static Map<String, WeakReference<MainProcessTask>> fDJ = new ConcurrentHashMap();
    private static Handler fDK = new 3();
    private static Messenger fDL = new Messenger(fDK);
    private static final Set<a> fDM = Collections.newSetFromMap(new ConcurrentHashMap());
    private final HashMap<String, DeathRecipient> fDD = new HashMap();
    private final Messenger fDE = new Messenger(this.mHandler);
    private final a fDF = new 2(this);
    private final Handler mHandler = new 1(this, c.Em().lnJ.getLooper());

    static /* synthetic */ void ahs() {
        for (a aaz : fDM) {
            aaz.aaz();
        }
    }

    static /* synthetic */ void aht() {
        for (a aay : fDM) {
            aay.aay();
        }
    }

    static /* synthetic */ void ahu() {
        if (fDG != null) {
            synchronized (fDI) {
                Iterator it = fDI.iterator();
                while (it.hasNext()) {
                    Parcel parcel = (Parcel) it.next();
                    Bundle bundle = new Bundle();
                    bundle.setClassLoader(MainProcessTask.class.getClassLoader());
                    parcel.setDataPosition(0);
                    bundle.readFromParcel(parcel);
                    r(bundle);
                    parcel.recycle();
                }
                fDI.clear();
            }
        }
    }

    static /* synthetic */ MainProcessTask td(String str) {
        if (fDJ.containsKey(str)) {
            return ((WeakReference) fDJ.get(str)).get() == null ? null : (MainProcessTask) ((WeakReference) fDJ.get(str)).get();
        } else {
            return null;
        }
    }

    public IBinder onBind(Intent intent) {
        return this.fDF;
    }

    public static void a(MainProcessTask mainProcessTask) {
        fDJ.put(mainProcessTask.fEl, new WeakReference(mainProcessTask));
        r(a(mainProcessTask, true));
    }

    public static boolean b(MainProcessTask mainProcessTask) {
        Bundle a = a(mainProcessTask, false);
        if (!q(a)) {
            return false;
        }
        a(a(a, false), mainProcessTask);
        mainProcessTask.aaj();
        return true;
    }

    private static boolean q(Bundle bundle) {
        try {
            fDG.t(bundle);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandMainProcessService", e.getMessage());
            return false;
        }
    }

    private static void r(Bundle bundle) {
        if (fDG == null) {
            ahr();
            synchronized (fDI) {
                LinkedList linkedList = fDI;
                Parcel obtain = Parcel.obtain();
                bundle.writeToParcel(obtain, 0);
                linkedList.add(obtain);
            }
            return;
        }
        try {
            fDG.s(bundle);
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandMainProcessService", e.getMessage());
        }
    }

    public static void ahr() {
        if (fDH == null) {
            fDH = new 4();
        }
        x.i("MicroMsg.AppBrandMainProcessService", "tryBindService");
        Context context = ad.getContext();
        context.bindService(new Intent(context, AppBrandMainProcessService.class), fDH, 1);
    }

    public static void a(a aVar) {
        fDM.add(aVar);
    }

    public static void b(a aVar) {
        fDM.remove(aVar);
    }

    private static void a(MainProcessTask mainProcessTask, MainProcessTask mainProcessTask2) {
        Parcel obtain = Parcel.obtain();
        mainProcessTask.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        mainProcessTask2.g(obtain);
        obtain.recycle();
    }

    static Bundle a(MainProcessTask mainProcessTask, boolean z) {
        Bundle bundle = new Bundle(3);
        bundle.putParcelable("task_object", mainProcessTask);
        if (z) {
            bundle.putParcelable("task_client", fDL);
        }
        bundle.putString("task_id", mainProcessTask.fEl);
        return bundle;
    }

    private static MainProcessTask a(Bundle bundle, boolean z) {
        bundle.setClassLoader(MainProcessTask.class.getClassLoader());
        MainProcessTask mainProcessTask = (MainProcessTask) bundle.getParcelable("task_object");
        if (z) {
            mainProcessTask.fEz = (Messenger) bundle.getParcelable("task_client");
        }
        mainProcessTask.fEl = bundle.getString("task_id");
        return mainProcessTask;
    }
}
