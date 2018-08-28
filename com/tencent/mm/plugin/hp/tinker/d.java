package com.tencent.mm.plugin.hp.tinker;

import android.os.Build.VERSION;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tinker.lib.c.f;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tinkerboots.sdk.a$a;
import com.tinkerboots.sdk.tinker.b.b;
import com.tinkerboots.sdk.tinker.b.c;
import com.tinkerboots.sdk.tinker.service.TinkerServerResultService;

public final class d {
    private static boolean knb = false;

    public static void b(ApplicationLike applicationLike) {
        x.i("Tinker.TinkerPatchManager", "try installing tinker");
        if (knb) {
            x.w("Tinker.TinkerPatchManager", "install tinker, but has installed, ignore");
            return;
        }
        long j;
        long j2 = 0;
        try {
            j2 = ((long) a.Dz()) & 4294967295L;
            x.i("Tinker.TinkerPatchManager", "uin is %s", new Object[]{bi.Xf(String.valueOf(j2))});
            j = j2;
        } catch (Throwable e) {
            x.printErrStackTrace("Tinker.TinkerPatchManager", e, "tinker patch manager get uin failed.", new Object[0]);
            j = j2;
        }
        a$a a_a = new a$a(applicationLike);
        c cVar = new c(applicationLike.getApplication());
        if (a_a.vsy != null) {
            throw new TinkerRuntimeException("loadReporter is already set.");
        }
        a_a.vsy = cVar;
        e eVar = new e(applicationLike.getApplication());
        if (a_a.vsz != null) {
            throw new TinkerRuntimeException("patchReporter is already set.");
        }
        a_a.vsz = eVar;
        b bVar = new b(applicationLike.getApplication());
        if (a_a.vsx != null) {
            throw new TinkerRuntimeException("listener is already set.");
        }
        a_a.vsx = bVar;
        Class cls = TinkerPatchResultService.class;
        if (a_a.vGa != null) {
            throw new TinkerRuntimeException("resultServiceClass is already set.");
        }
        a_a.vGa = cls;
        if (a_a.vsy == null) {
            a_a.vsy = new com.tinkerboots.sdk.tinker.b.a(a_a.context);
        }
        if (a_a.vsz == null) {
            a_a.vsz = new c(a_a.context);
        }
        if (a_a.vsx == null) {
            a_a.vsx = new b(a_a.context);
        }
        if (a_a.vFZ == null) {
            a_a.vFZ = new f();
        }
        if (a_a.vGa == null) {
            a_a.vGa = TinkerServerResultService.class;
        }
        if (a_a.vGb == null) {
            a_a.vGb = new com.tinkerboots.sdk.a.a.a();
        }
        com.tinkerboots.sdk.a aVar = new com.tinkerboots.sdk.a(a_a.context, a_a.applicationLike, a_a.vsy, a_a.vsz, a_a.vsx, a_a.vFZ, a_a.vGa, a_a.vGb);
        if (com.tinkerboots.sdk.a.vFU != null) {
            throw new TinkerRuntimeException("TinkerClient instance is already set.");
        }
        com.tinkerboots.sdk.a.vFU = aVar;
        aVar = com.tinkerboots.sdk.a.cJC().Iz(g.dJ(ad.getContext()));
        boolean chp = com.tencent.mm.sdk.a.b.chp();
        if (aVar.vFW == null || aVar.vFV == null) {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setDebugger, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
            aVar = com.tinkerboots.sdk.a.vFU;
        } else {
            com.tencent.tinker.lib.f.a.i("Tinker.TinkerClient", "set debugger to %b", new Object[]{Boolean.valueOf(chp)});
            aVar.vFW.isDebug = chp;
            aVar = com.tinkerboots.sdk.a.vFU;
        }
        aVar = aVar.gy("uin", String.valueOf(j)).gy("code-version", com.tencent.mm.sdk.platformtools.d.CLIENT_VERSION).gy("code-reversion", com.tencent.mm.sdk.platformtools.d.REV).gy("network", String.valueOf(ao.isWifi(ad.getContext()) ? 3 : 2)).gy("sdk", String.valueOf(VERSION.SDK_INT)).gy("os-name", com.tencent.mm.protocal.d.qVK).gy("device-brand", com.tencent.mm.protocal.d.qVH).gy("device-name", com.tencent.mm.protocal.d.DEVICE_NAME);
        f fVar = new f();
        if (aVar.vFW == null || aVar.vFV == null) {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setPatchRequestCallback, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
        } else {
            com.tencent.tinker.lib.f.a.i("Tinker.TinkerClient", "setPatchRequestCallback with hashcode %d", new Object[]{Integer.valueOf(fVar.hashCode())});
            aVar.vFW.vGb = fVar;
        }
        x.i("Tinker.TinkerPatchManager", "try installing end");
        knb = true;
    }

    public static void aWs() {
        com.tencent.tinker.lib.f.a.a(new 1());
    }

    public static void aWt() {
        if (knb) {
            com.tencent.tinker.lib.e.a.hL(com.tencent.mm.app.b.applicationLike.getApplication()).aWt();
            return;
        }
        throw new RuntimeException("cleanPatch but tinker is not installed");
    }

    public static void EH(String str) {
        if (knb) {
            com.tencent.tinker.lib.e.c.bP(com.tencent.mm.app.b.applicationLike.getApplication(), str);
            return;
        }
        throw new RuntimeException("upgrade patch but tinker is not installed");
    }
}
