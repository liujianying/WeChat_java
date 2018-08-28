package com.tencent.mm.plugin.zero;

import android.os.Build.VERSION;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mars.sdt.SdtLogic;
import com.tencent.mm.app.e;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.by.i;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.a;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.zero.a.b;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.w;
import com.tencent.mm.vending.h.h;
import java.io.File;

public class PluginZero extends f implements d {
    private a qxE = new a();
    private b qxF = new b();
    private final e qxG = new e();
    public b qxH;
    public b qxI = new b();
    public a qxJ = new a();

    public String toString() {
        return "plugin-zero";
    }

    public void installed() {
        alias(d.class);
    }

    public void dependency() {
        dependsOnRoot();
    }

    public void configure(g gVar) {
        try {
            initSDRoot();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.PluginZero", e, "what happened?", new Object[0]);
        }
        ad.bZ(gVar.dox);
        a.j("configure [%s], setup broken library handler...", new Object[]{this});
        k.setupBrokenLibraryHandler();
        setupVendingLog();
        if (gVar.ES()) {
            a.j("configure [%s], for process[%s]...", new Object[]{this, gVar.dox});
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.zero.b.a.class, new com.tencent.mm.kernel.c.e(this.qxE));
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.zero.b.b.class, new com.tencent.mm.kernel.c.e(this.qxF));
            a.j("configure [%s], make worker core...", new Object[]{this});
            com.tencent.mm.kernel.g Ek = com.tencent.mm.kernel.g.Ek();
            if (!Ek.dqV) {
                Ek.dqV = true;
                Ek.dqO = new com.tencent.mm.kernel.e(c.Et());
                Ek.dqP = new com.tencent.mm.kernel.a(c.Et());
                Ek.dqQ = new com.tencent.mm.kernel.b(Ek.dqS, Ek.dpO);
                Ek.dqR = new com.tencent.mm.bs.b(ad.getContext());
            }
            com.tencent.mm.kernel.g.Ek().a(new 1(this, gVar));
            com.tencent.mm.kernel.g.Ek();
            i.uZN = new h(com.tencent.mm.by.d.b(com.tencent.mm.kernel.g.Em().cil()), "WeChat.WORKER");
            com.tencent.mm.vending.h.g.a("WeChat.WORKER", i.uZN);
            new com.tencent.mm.plugin.zero.tasks.a().before(this);
        }
        if (gVar.ES() || gVar.gn(":push")) {
            new LoadProtocolJNITask().before(this);
        }
        if (gVar.gn(":push")) {
            AppLogic.setCallBack(new AppCallBack(ad.getContext()));
            k.b(com.tencent.mm.kernel.b.dpN, getClass().getClassLoader());
            SdtLogic.setHttpNetcheckCGI("/mmnetcheck");
        }
    }

    private void initSDRoot() {
        if (new File(aa.duN + "SdcardInfo.cfg").exists()) {
            String str;
            String str2 = com.tencent.mm.compatible.util.e.bnC;
            w wVar = new w(aa.duN + "SdcardInfo.cfg");
            String str3 = (String) wVar.get(1, "");
            int intValue = ((Integer) wVar.get(2, Integer.valueOf(0))).intValue();
            int i = VERSION.SDK_INT;
            if (bi.oW(str3)) {
                wVar.set(1, str2);
                wVar.set(2, Integer.valueOf(i));
                str = str2;
            } else {
                str = str3;
            }
            x.i("MicroMsg.PluginZero", "initSdCardPath cfgSdcardRoot[%s], initSdcardRoot[%s], primarySD[%s], ver[%d], sdk[%d]", new Object[]{str3, str, str2, Integer.valueOf(intValue), Integer.valueOf(i)});
            com.tencent.mm.compatible.util.e.ff(str);
            if (intValue != i && !com.tencent.mm.compatible.util.f.zZ()) {
                if (com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted") && new File(com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getAbsolutePath()).canWrite()) {
                    wVar.set(1, str2);
                    wVar.set(2, Integer.valueOf(i));
                    com.tencent.mm.compatible.util.e.ff(str2);
                    x.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change and old not avail reset SDCARD_ROOT[%s][%b]", new Object[]{com.tencent.mm.compatible.util.e.bnC, Boolean.valueOf(com.tencent.mm.compatible.util.f.zZ())});
                    return;
                }
                x.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change but neither primarySD nor old avail keep do nothing[%s][%b][%s]", new Object[]{com.tencent.mm.compatible.util.e.bnC, Boolean.valueOf(com.tencent.mm.compatible.util.f.zZ()), str2});
                return;
            }
            return;
        }
        com.tencent.mm.compatible.util.e.ff(com.tencent.mm.compatible.util.e.bnC);
        x.i("MicroMsg.PluginZero", "summermount initSdCardPath sdcard info file not existed use[%s]", new Object[]{com.tencent.mm.compatible.util.e.bnC});
    }

    public void execute(g gVar) {
        if (gVar.ES()) {
            com.tencent.mm.kernel.g.Ek().dqS.aI(new 2(this, gVar));
            NotifyReceiver.xA();
        }
    }

    private void setupVendingLog() {
        com.tencent.mm.vending.f.a.a(new 3(this));
    }

    public void setILightPushDelegate(b bVar) {
        this.qxH = bVar;
    }

    public com.tencent.mm.vending.b.b addNotifyReceiverCallback(com.tencent.mm.plugin.zero.a.c cVar) {
        x.i("MicroMsg.PluginZero", "addNotifyReceiverCallback this %s delegate %s ", new Object[]{this, cVar});
        return this.qxI.aI(cVar);
    }

    public com.tencent.mm.vending.b.b addICoreServiceLifecycleCallback(com.tencent.mm.plugin.zero.a.a aVar) {
        return this.qxJ.aI(aVar);
    }
}
