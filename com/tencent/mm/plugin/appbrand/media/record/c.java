package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class c {
    private static Map<String, com.tencent.mm.sdk.b.c> gij = new HashMap();
    private static ArrayList<String> gik = new ArrayList();
    private static boolean gil = false;

    private static final class a implements i<IPCVoid, IPCString> {
        private a() {
        }

        private static IPCString alc() {
            try {
                x.i("MicroMsg.Record.AppBrandRecordClientService", "ipc updateDeviceInfo");
                return new IPCString(g.Ei().DU().cmX());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Record.AppBrandRecordClientService", e, "ipc updateDeviceInfo task", new Object[0]);
                return new IPCString("");
            }
        }
    }

    static /* synthetic */ void vg() {
        if (gil) {
            x.i("MicroMsg.Record.AppBrandRecordClientService", "update device info done!");
            return;
        }
        x.i("MicroMsg.Record.AppBrandRecordClientService", "to do update device info!");
        gil = true;
        IPCString iPCString = (IPCString) XIPCInvoker.a("com.tencent.mm", null, a.class);
        if (iPCString != null && iPCString.value != null) {
            q.fd(iPCString.value);
            x.i("MicroMsg.Record.AppBrandRecordClientService", "update device info success!");
        }
    }

    public static void onCreate() {
    }

    public static void onDestroy() {
        x.i("MicroMsg.Record.AppBrandRecordClientService", "onDestroy");
        Iterator it = gik.iterator();
        while (it.hasNext()) {
            com.tencent.mm.sdk.b.c cVar = (com.tencent.mm.sdk.b.c) gij.remove((String) it.next());
            if (cVar != null) {
                com.tencent.mm.sdk.b.a.sFg.c(cVar);
            }
        }
        gij.clear();
        gik.clear();
        e ale = e.ale();
        x.i("MicroMsg.Record.AudioRecordMgr", "destroy");
        if (ale.gix == com.tencent.mm.plugin.appbrand.media.record.e.a.giK || ale.gix == com.tencent.mm.plugin.appbrand.media.record.e.a.giL || ale.gix == com.tencent.mm.plugin.appbrand.media.record.e.a.giO) {
            ale.we();
        }
    }

    public static void b(String str, com.tencent.mm.sdk.b.c cVar) {
        if (gij.containsKey(str)) {
            x.e("MicroMsg.Record.AppBrandRecordClientService", "appId:%s has add listener", new Object[]{str});
        } else if (cVar == null) {
            x.e("MicroMsg.Record.AppBrandRecordClientService", "listener is null");
        } else {
            x.i("MicroMsg.Record.AppBrandRecordClientService", "addRecordListener,appId:%s", new Object[]{str});
            gij.put(str, cVar);
            if (!gik.contains(str)) {
                gik.add(str);
            }
            com.tencent.mm.sdk.b.a.sFg.a(cVar);
        }
    }

    public static void uv(String str) {
        if (gij.containsKey(str)) {
            x.i("MicroMsg.Record.AppBrandRecordClientService", "removeRecordListener,appId:%s", new Object[]{str});
            gik.remove(str);
            com.tencent.mm.sdk.b.c cVar = (com.tencent.mm.sdk.b.c) gij.remove(str);
            if (cVar != null) {
                com.tencent.mm.sdk.b.a.sFg.c(cVar);
                return;
            }
            return;
        }
        x.e("MicroMsg.Record.AppBrandRecordClientService", "appId:%s not exist the appId for listener", new Object[]{str});
    }

    public static void alb() {
        if (gil) {
            x.i("MicroMsg.Record.AppBrandRecordClientService", "update device info done!");
        } else {
            e.post(new Runnable() {
                public final void run() {
                    c.vg();
                }
            }, "record_update_device_info");
        }
    }
}
