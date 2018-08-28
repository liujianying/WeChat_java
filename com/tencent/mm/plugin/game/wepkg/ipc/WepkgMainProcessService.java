package com.tencent.mm.plugin.game.wepkg.ipc;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import com.tencent.mm.plugin.game.wepkg.ipc.a.a;
import com.tencent.mm.plugin.game.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WepkgMainProcessService extends Service {
    private static ServiceConnection fDH;
    private static Map<Integer, WeakReference<WepkgMainProcessTask>> fDJ = new ConcurrentHashMap();
    private static Handler fDK = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            int i = message.what;
            WepkgMainProcessTask C = WepkgMainProcessService.B(message.getData());
            WepkgMainProcessTask rc = WepkgMainProcessService.rc(i);
            if (rc == null) {
                x.e("MicroMsg.Wepkg.WepkgMainProcessService", "receive client msg, get null task by id %s", new Object[]{Integer.valueOf(i)});
                return;
            }
            WepkgMainProcessService.a(C, rc);
            rc.aaj();
        }
    };
    private static Messenger fDL = new Messenger(fDK);
    private static a keI;
    private static final LinkedList<Message> keJ = new LinkedList();
    private final Messenger fDE = new Messenger(this.mHandler);
    private final a keH = new a() {
        public final void o(Message message) {
            WepkgMainProcessService.this.fDE.send(message);
        }

        public final void t(Bundle bundle) {
            WepkgMainProcessService.B(bundle).aai();
        }
    };
    private final Handler mHandler = new 1(this, d.Em().lnJ.getLooper());

    static /* synthetic */ void aSp() {
        if (keI != null) {
            synchronized (keJ) {
                Iterator it = keJ.iterator();
                while (it.hasNext()) {
                    p((Message) it.next());
                }
                keJ.clear();
            }
        }
    }

    static /* synthetic */ WepkgMainProcessTask rc(int i) {
        if (fDJ.containsKey(Integer.valueOf(i))) {
            return ((WeakReference) fDJ.get(Integer.valueOf(i))).get() == null ? null : (WepkgMainProcessTask) ((WeakReference) fDJ.get(Integer.valueOf(i))).get();
        } else {
            return null;
        }
    }

    public IBinder onBind(Intent intent) {
        return this.keH;
    }

    public static void a(WepkgMainProcessTask wepkgMainProcessTask) {
        fDJ.put(Integer.valueOf(wepkgMainProcessTask.hashCode()), new WeakReference(wepkgMainProcessTask));
        Message obtain = Message.obtain();
        obtain.what = wepkgMainProcessTask.hashCode();
        obtain.replyTo = fDL;
        obtain.setData(c(wepkgMainProcessTask));
        p(obtain);
    }

    public static boolean b(WepkgMainProcessTask wepkgMainProcessTask) {
        Bundle c = c(wepkgMainProcessTask);
        if (!q(c)) {
            return false;
        }
        a(B(c), wepkgMainProcessTask);
        wepkgMainProcessTask.aaj();
        return true;
    }

    private static boolean q(Bundle bundle) {
        try {
            keI.t(bundle);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.Wepkg.WepkgMainProcessService", e.getMessage());
            return false;
        }
    }

    private static void p(Message message) {
        message.replyTo = fDL;
        if (keI == null) {
            ahr();
            synchronized (keJ) {
                keJ.add(message);
            }
            return;
        }
        try {
            keI.o(message);
        } catch (Exception e) {
            x.e("MicroMsg.Wepkg.WepkgMainProcessService", e.getMessage());
        }
    }

    private static void ahr() {
        if (fDH == null) {
            fDH = new ServiceConnection() {
                public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    WepkgMainProcessService.keI = a.S(iBinder);
                    WepkgMainProcessService.aSp();
                    x.i("MicroMsg.Wepkg.WepkgMainProcessService", "onServiceConnected(%s)", new Object[]{ad.getProcessName()});
                }

                public final void onServiceDisconnected(ComponentName componentName) {
                    WepkgMainProcessService.keI = null;
                    WepkgMainProcessService.ahr();
                    x.i("MicroMsg.Wepkg.WepkgMainProcessService", "onServiceDisconnected(%s)", new Object[]{ad.getProcessName()});
                }
            };
        }
        x.i("MicroMsg.Wepkg.WepkgMainProcessService", "tryBindService");
        Context context = ad.getContext();
        context.bindService(new Intent(context, WepkgMainProcessService.class), fDH, 1);
    }

    public static boolean ajG() {
        if (keI != null) {
            return true;
        }
        return false;
    }

    static Bundle c(WepkgMainProcessTask wepkgMainProcessTask) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("task_object", wepkgMainProcessTask);
        return bundle;
    }

    private static WepkgMainProcessTask B(Bundle bundle) {
        bundle.setClassLoader(WepkgMainProcessTask.class.getClassLoader());
        return (WepkgMainProcessTask) bundle.getParcelable("task_object");
    }

    private static void a(WepkgMainProcessTask wepkgMainProcessTask, WepkgMainProcessTask wepkgMainProcessTask2) {
        Parcel obtain = Parcel.obtain();
        wepkgMainProcessTask.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        wepkgMainProcessTask2.g(obtain);
        obtain.recycle();
    }
}
