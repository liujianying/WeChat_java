package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.j;
import java.io.File;

class ar extends Thread {
    final /* synthetic */ Context a;
    final /* synthetic */ Context b;
    final /* synthetic */ an c;

    ar(an anVar, Context context, Context context2) {
        this.c = anVar;
        this.a = context;
        this.b = context2;
    }

    public void run() {
        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread start");
        try {
            File file = this.a == null ? new File(TbsShareManager.getHostCorePathAppDefined()) : TbsShareManager.isThirdPartyApp(this.b) ? (TbsShareManager.c(this.b) == null || !TbsShareManager.c(this.b).contains("decouple")) ? this.c.q(this.a) : this.c.p(this.a) : this.c.q(this.a);
            File q = this.c.q(this.b);
            int i = VERSION.SDK_INT;
            if (i != 19 && i < 21) {
                j.a(file, q, new as(this));
            }
            j.a(file, q, new at(this));
            TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread done");
        } catch (Exception e) {
        }
    }
}
