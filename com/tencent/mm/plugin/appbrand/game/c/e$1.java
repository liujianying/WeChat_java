package com.tencent.mm.plugin.appbrand.game.c;

import android.os.Debug.MemoryInfo;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class e$1 implements a {
    final /* synthetic */ e fBC;

    public e$1(e eVar) {
        this.fBC = eVar;
    }

    public final boolean vD() {
        e eVar = this.fBC;
        int i = i.fCa.fCg == null ? 0 : i.fCa.fCg.booleanValue() ? 1 : 2;
        eVar.fBA = i;
        g pY = com.tencent.mm.plugin.appbrand.a.pY(i.fCa.mAppId);
        i = (pY == null || pY.fcr == null) ? 0 : pY.fcr.aaB();
        eVar.fBB = i;
        i iVar = i.fCa;
        int currentTimeMillis = (int) (iVar.fCj <= 0 ? 0 : System.currentTimeMillis() - iVar.fCj);
        f agw = i.fCa.agw();
        if (agw != null) {
            i = agw.fBQ;
            h.mEJ.h(14959, new Object[]{eVar.appId, Integer.valueOf(eVar.cbu), Integer.valueOf(eVar.bGF), Integer.valueOf(eVar.fBA), Integer.valueOf(e.a.fBE.fBN), Integer.valueOf(i), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.fBB)});
            x.i("MicroMsg.Kv_14959", "Kv_14959.reportCpu cpu = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.fBB), Integer.valueOf(eVar.fBA)});
        }
        h agv = i.fCa.agv();
        if (agv != null) {
            MemoryInfo agu = h.agu();
            int b = h.b(agu);
            int i2 = agu == null ? 0 : agu.nativePss / 1024;
            int i3 = agu == null ? 0 : agu.dalvikPss / 1024;
            i = agu == null ? 0 : agu.otherPss / 1024;
            int a = agv.a(agu);
            h.mEJ.h(14959, new Object[]{eVar.appId, Integer.valueOf(eVar.cbu), Integer.valueOf(eVar.bGF), Integer.valueOf(eVar.fBA), Integer.valueOf(e.a.fBF.fBN), Integer.valueOf(b), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.fBB)});
            h.mEJ.h(14959, new Object[]{eVar.appId, Integer.valueOf(eVar.cbu), Integer.valueOf(eVar.bGF), Integer.valueOf(eVar.fBA), Integer.valueOf(e.a.fBJ.fBN), Integer.valueOf(i2), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.fBB)});
            h.mEJ.h(14959, new Object[]{eVar.appId, Integer.valueOf(eVar.cbu), Integer.valueOf(eVar.bGF), Integer.valueOf(eVar.fBA), Integer.valueOf(e.a.fBK.fBN), Integer.valueOf(i3), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.fBB)});
            h.mEJ.h(14959, new Object[]{eVar.appId, Integer.valueOf(eVar.cbu), Integer.valueOf(eVar.bGF), Integer.valueOf(eVar.fBA), Integer.valueOf(e.a.fBL.fBN), Integer.valueOf(i), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.fBB)});
            h.mEJ.h(14959, new Object[]{eVar.appId, Integer.valueOf(eVar.cbu), Integer.valueOf(eVar.bGF), Integer.valueOf(eVar.fBA), Integer.valueOf(e.a.fBM.fBN), Integer.valueOf(a), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.fBB)});
            x.i("MicroMsg.Kv_14959", "Kv_14959.reportMemory pid = [%d] native = [%d] dalvik = [%d] other = [%d] delta = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[]{Integer.valueOf(b), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(a), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.fBB), Integer.valueOf(eVar.fBA)});
        }
        g agx = i.fCa.agx();
        if (agx != null) {
            i = (int) Math.round(agx.fBW);
            h.mEJ.h(14959, new Object[]{eVar.appId, Integer.valueOf(eVar.cbu), Integer.valueOf(eVar.bGF), Integer.valueOf(eVar.fBA), Integer.valueOf(e.a.fBD.fBN), Integer.valueOf(i), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.fBB)});
            x.i("MicroMsg.Kv_14959", "Kv_14959.reportFps fps = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(currentTimeMillis), Integer.valueOf(eVar.fBB), Integer.valueOf(eVar.fBA)});
        }
        return true;
    }
}
