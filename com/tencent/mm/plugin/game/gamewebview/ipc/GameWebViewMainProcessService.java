package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.os.Parcel;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.downloader.model.b;
import com.tencent.mm.plugin.game.gamewebview.ipc.b.a;
import com.tencent.mm.plugin.game.gamewebview.model.d;
import com.tencent.mm.plugin.game.gamewebview.model.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class GameWebViewMainProcessService extends Service {
    private static ServiceConnection fDH;
    private static final LinkedList<Parcel> fDI = new LinkedList();
    private static Map<String, WeakReference<GWMainProcessTask>> fDJ = new ConcurrentHashMap();
    private static Handler fDK = new 3();
    private static Messenger fDL = new Messenger(fDK);
    private static b jGm;
    private static Set<Object> jGn = new HashSet();
    private final Messenger fDE = new Messenger(this.mHandler);
    private d jGj;
    private e jGk;
    private final a jGl = new 2(this);
    private final Handler mHandler = new 1(this, com.tencent.mm.plugin.game.gamewebview.a.d.Em().lnJ.getLooper());

    static /* synthetic */ GWMainProcessTask De(String str) {
        if (fDJ.containsKey(str)) {
            return ((WeakReference) fDJ.get(str)).get() == null ? null : (GWMainProcessTask) ((WeakReference) fDJ.get(str)).get();
        } else {
            return null;
        }
    }

    static /* synthetic */ void aSp() {
        if (jGm != null) {
            synchronized (fDI) {
                Iterator it = fDI.iterator();
                while (it.hasNext()) {
                    Parcel parcel = (Parcel) it.next();
                    Bundle bundle = new Bundle();
                    bundle.setClassLoader(GWMainProcessTask.class.getClassLoader());
                    parcel.setDataPosition(0);
                    bundle.readFromParcel(parcel);
                    r(bundle);
                    parcel.recycle();
                }
                fDI.clear();
            }
        }
    }

    static /* synthetic */ void aSq() {
        Iterator it = jGn.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    static /* synthetic */ void aSr() {
        Iterator it = jGn.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public void onCreate() {
        x.i("MicroMsg.GameWebViewMainProcessService", "onCreate");
        super.onCreate();
        if (g.Eg().Dx()) {
            this.jGj = new d();
            com.tencent.mm.plugin.webview.modeltools.e.bUW().a(this.jGj);
        }
        this.jGk = new e();
        com.tencent.mm.plugin.downloader.model.d.aCU();
        b.a(this.jGk);
    }

    public void onDestroy() {
        x.i("MicroMsg.GameWebViewMainProcessService", "onDestroy");
        super.onDestroy();
        com.tencent.mm.plugin.downloader.model.d.aCU();
        b.b(this.jGk);
        if (au.HX()) {
            com.tencent.mm.plugin.webview.modeltools.e.bUW().b(this.jGj);
        }
    }

    public IBinder onBind(Intent intent) {
        return this.jGl;
    }

    public static void a(GWMainProcessTask gWMainProcessTask) {
        fDJ.put(gWMainProcessTask.fEl, new WeakReference(gWMainProcessTask));
        r(a(gWMainProcessTask, true));
    }

    public static boolean b(GWMainProcessTask gWMainProcessTask) {
        Bundle a = a(gWMainProcessTask, false);
        if (!q(a)) {
            return false;
        }
        a(d(a, false), gWMainProcessTask);
        gWMainProcessTask.aaj();
        return true;
    }

    private static boolean q(Bundle bundle) {
        try {
            jGm.t(bundle);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.GameWebViewMainProcessService", e.getMessage());
            return false;
        }
    }

    private static void r(Bundle bundle) {
        if (jGm == null) {
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
            jGm.s(bundle);
        } catch (Exception e) {
            x.e("MicroMsg.GameWebViewMainProcessService", e.getMessage());
        }
    }

    private static void ahr() {
        if (fDH == null) {
            fDH = new 4();
        }
        x.i("MicroMsg.GameWebViewMainProcessService", "tryBindService");
        Context context = ad.getContext();
        context.bindService(new Intent(context, GameWebViewMainProcessService.class), fDH, 1);
    }

    private static void a(GWMainProcessTask gWMainProcessTask, GWMainProcessTask gWMainProcessTask2) {
        Parcel obtain = Parcel.obtain();
        gWMainProcessTask.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        gWMainProcessTask2.g(obtain);
        obtain.recycle();
    }

    static Bundle a(GWMainProcessTask gWMainProcessTask, boolean z) {
        Bundle bundle = new Bundle(3);
        bundle.putParcelable("task_object", gWMainProcessTask);
        if (z) {
            bundle.putParcelable("task_client", fDL);
        }
        bundle.putString("task_id", gWMainProcessTask.fEl);
        return bundle;
    }

    private static GWMainProcessTask d(Bundle bundle, boolean z) {
        bundle.setClassLoader(GWMainProcessTask.class.getClassLoader());
        GWMainProcessTask gWMainProcessTask = (GWMainProcessTask) bundle.getParcelable("task_object");
        if (z) {
            gWMainProcessTask.fEz = (Messenger) bundle.getParcelable("task_client");
        }
        gWMainProcessTask.fEl = bundle.getString("task_id");
        return gWMainProcessTask;
    }
}
