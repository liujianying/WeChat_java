package com.tencent.mm.plugin.fts;

import android.content.res.AssetManager;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.g;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;

class PluginFTS$a extends a {
    final /* synthetic */ PluginFTS jpM;

    private PluginFTS$a(PluginFTS pluginFTS) {
        this.jpM = pluginFTS;
    }

    /* synthetic */ PluginFTS$a(PluginFTS pluginFTS, byte b) {
        this(pluginFTS);
    }

    public final boolean execute() {
        int i;
        Throwable e;
        long s;
        long currentTimeMillis;
        CA("start");
        AssetManager assets = ad.getContext().getAssets();
        InputStream inputStream = null;
        try {
            inputStream = assets.open("fts_t2s.txt");
            for (String split : new String(e.g(inputStream)).split("\n")) {
                String[] split2 = split.split(",");
                g.eww.put(split2[0], split2[1]);
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.FTS.PluginFTS", e2, e2.getMessage(), new Object[0]);
        } finally {
            e.f(inputStream);
        }
        CA("t2s");
        InputStream open;
        try {
            open = assets.open("fts_py.txt");
            try {
                String[] split3 = new String(e.g(open)).split("\n");
                int i2 = 0;
                while (true) {
                    i = i2;
                    if (i >= split3.length) {
                        break;
                    }
                    String[] split4 = split3[i].split(",");
                    Object obj = split4[0];
                    Object obj2 = new String[(split4.length - 1)];
                    for (i2 = 0; i2 < obj2.length; i2++) {
                        if (i2 + 1 < split4.length) {
                            obj2[i2] = split4[i2 + 1];
                        }
                    }
                    if (obj2.length > 0) {
                        for (String CC : obj2) {
                            g.jrl.CC(CC);
                        }
                        g.jrm.put(obj, obj2);
                    }
                    i2 = i + 1;
                }
                e.f(open);
            } catch (Throwable e3) {
                e2 = e3;
                try {
                    x.printErrStackTrace("MicroMsg.FTS.PluginFTS", e2, e2.getMessage(), new Object[0]);
                    e.f(open);
                    CA("py");
                    com.tencent.mm.plugin.fts.a.e.jqL.jqN = d.aPS().length() / 1048576;
                    com.tencent.mm.plugin.fts.a.e.jqL.jqO = PluginFTS.access$200(this.jpM).s(-301, 0);
                    com.tencent.mm.plugin.fts.a.e.jqL.jqP = PluginFTS.access$200(this.jpM).s(-302, 0);
                    com.tencent.mm.plugin.fts.a.e.jqL.jqR = PluginFTS.access$200(this.jpM).s(-303, 0);
                    com.tencent.mm.plugin.fts.a.e.jqL.jqQ = PluginFTS.access$200(this.jpM).s(-304, 0);
                    s = ((n) com.tencent.mm.kernel.g.n(n.class)).getFTSIndexDB().s(-300, 0);
                    currentTimeMillis = System.currentTimeMillis();
                    if (d.u(s, currentTimeMillis)) {
                        x.i("MicroMsg.FTS.PluginFTS", "not need to report fts data");
                    } else {
                        com.tencent.mm.plugin.fts.a.e.aPZ();
                        ((n) com.tencent.mm.kernel.g.n(n.class)).getFTSIndexDB().t(-300, currentTimeMillis);
                    }
                    CA("reportData");
                    return true;
                } catch (Throwable e32) {
                    e2 = e32;
                    e.f(open);
                    throw e2;
                }
            }
        } catch (Exception e4) {
            e2 = e4;
            open = inputStream;
        } catch (Throwable th) {
            e2 = th;
            open = inputStream;
            e.f(open);
            throw e2;
        }
        CA("py");
        com.tencent.mm.plugin.fts.a.e.jqL.jqN = d.aPS().length() / 1048576;
        com.tencent.mm.plugin.fts.a.e.jqL.jqO = PluginFTS.access$200(this.jpM).s(-301, 0);
        com.tencent.mm.plugin.fts.a.e.jqL.jqP = PluginFTS.access$200(this.jpM).s(-302, 0);
        com.tencent.mm.plugin.fts.a.e.jqL.jqR = PluginFTS.access$200(this.jpM).s(-303, 0);
        com.tencent.mm.plugin.fts.a.e.jqL.jqQ = PluginFTS.access$200(this.jpM).s(-304, 0);
        s = ((n) com.tencent.mm.kernel.g.n(n.class)).getFTSIndexDB().s(-300, 0);
        currentTimeMillis = System.currentTimeMillis();
        if (d.u(s, currentTimeMillis)) {
            com.tencent.mm.plugin.fts.a.e.aPZ();
            ((n) com.tencent.mm.kernel.g.n(n.class)).getFTSIndexDB().t(-300, currentTimeMillis);
        } else {
            x.i("MicroMsg.FTS.PluginFTS", "not need to report fts data");
        }
        CA("reportData");
        return true;
    }

    public final String afC() {
        return String.format("{T2S: %d PY: %d}", new Object[]{Integer.valueOf(g.eww.size()), Integer.valueOf(g.jrm.size())});
    }

    public final String getName() {
        return "InitResourceTask";
    }
}
