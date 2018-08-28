package com.tencent.mm.plugin.fts;

import android.util.Log;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.io.File;

class PluginFTS$b extends a {
    final /* synthetic */ PluginFTS jpM;

    private PluginFTS$b(PluginFTS pluginFTS) {
        this.jpM = pluginFTS;
    }

    /* synthetic */ PluginFTS$b(PluginFTS pluginFTS, byte b) {
        this(pluginFTS);
    }

    public final boolean execute() {
        g.Ek();
        if (2 != ((Integer) g.Ei().DT().get(aa.a.sXU, Integer.valueOf(0))).intValue()) {
            d.aPR();
            g.Ek();
            g.Ei().DT().a(aa.a.sXU, Integer.valueOf(2));
        }
        g.Ek();
        File file = new File(g.Ei().cachePath, "IndexMicroMsg.db");
        if (file.exists()) {
            file.delete();
        }
        try {
            PluginFTS pluginFTS = this.jpM;
            g.Ek();
            PluginFTS.access$202(pluginFTS, new d(g.Ei().cachePath));
            PluginFTS.access$600(this.jpM);
            PluginFTS.access$700(this.jpM);
            PluginFTS.access$800(this.jpM);
            PluginFTS.access$900(this.jpM);
        } catch (Throwable e) {
            if (!PluginFTS.jpy) {
                x.printErrStackTrace("MicroMsg.FTS.PluginFTS", e, "Index database corruption detected", new Object[0]);
                e.qd(19);
                PluginFTS.access$300(this.jpM);
                PluginFTS.access$400(this.jpM);
                PluginFTS.access$200(this.jpM).close();
                d.aPR();
                h.mEJ.c("FTS", "InitSearchTask: " + Log.getStackTraceString(e), null);
            }
        }
        return true;
    }

    public final String getName() {
        return "InitSearchTask";
    }
}
