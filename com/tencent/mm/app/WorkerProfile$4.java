package com.tencent.mm.app;

import android.content.Intent;
import com.tencent.mm.g.a.ip;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.w;

class WorkerProfile$4 extends c<ip> {
    final /* synthetic */ WorkerProfile bzO;

    WorkerProfile$4(WorkerProfile workerProfile) {
        this.bzO = workerProfile;
        this.sFo = ip.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ip ipVar = (ip) bVar;
        String str = ipVar.bSb.bSc;
        String str2 = ipVar.bSb.url;
        x.i("MicroMsg.WorkerProfile", "summertoken KickOffline callback wording[%s], url[%s]", new Object[]{str, str2});
        h.mEJ.a(322, 21, 1, true);
        LauncherUI cpQ = LauncherUI.cpQ();
        h hVar = h.mEJ;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(4021);
        String str3 = "%s|%s|%b";
        Object[] objArr2 = new Object[3];
        objArr2[0] = str;
        objArr2[1] = str2;
        boolean z = cpQ == null || cpQ.isFinishing();
        objArr2[2] = Boolean.valueOf(z);
        objArr[1] = String.format(str3, objArr2);
        hVar.h(11098, objArr);
        if (cpQ == null || cpQ.isFinishing()) {
            h.mEJ.a(322, 22, 1, true);
            hVar = h.mEJ;
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(4022);
            str3 = "%s|%s|%b";
            objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = str2;
            objArr2[2] = Boolean.valueOf(cpQ == null);
            objArr[1] = String.format(str3, objArr2);
            hVar.h(11098, objArr);
            x.w("MicroMsg.WorkerProfile", "summertoken KickOffline error LauncherUI is null launcherisFirst[%b], launcheruiOnTop[%b] return", new Object[]{Boolean.valueOf(this.bzO.bzD), Boolean.valueOf(this.bzO.bzE)});
        }
        w.a(cpQ, str, str2, new Intent().setClass(cpQ, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864));
        return false;
    }
}
