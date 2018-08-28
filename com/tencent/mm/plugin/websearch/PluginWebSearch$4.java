package com.tencent.mm.plugin.websearch;

import com.tencent.mm.a.e;
import com.tencent.mm.g.a.ix;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

class PluginWebSearch$4 extends c<ix> {
    final /* synthetic */ PluginWebSearch pKx;

    PluginWebSearch$4(PluginWebSearch pluginWebSearch) {
        this.pKx = pluginWebSearch;
        this.sFo = ix.class.getName().hashCode();
    }

    private boolean a(ix ixVar) {
        Throwable e;
        int intValue;
        if (ixVar != null && ixVar.bSA.bIC == 27) {
            File file;
            if (ixVar.bSA.bID == 1) {
                File file2 = new File(ixVar.bSA.filePath);
                if (file2.exists()) {
                    x.i("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdateListener callback to update %s", new Object[]{file2.getAbsoluteFile()});
                    File file3 = new File(p.zU(ixVar.bSA.bID), "temp");
                    file = new File(file3, p.zV(ixVar.bSA.bID));
                    file3.mkdirs();
                    e.y(file2.getAbsolutePath(), file.getAbsolutePath());
                    if (bi.fR(file.getAbsolutePath(), file3.getAbsolutePath()) >= 0) {
                        Properties properties = new Properties();
                        InputStream fileInputStream;
                        try {
                            fileInputStream = new FileInputStream(new File(file3, "config.conf"));
                            try {
                                properties.load(fileInputStream);
                                e.f(fileInputStream);
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    x.printErrStackTrace("MicroMsg.WebSearch.PluginWebSearch", e, e.getMessage(), new Object[0]);
                                    e.f(fileInputStream);
                                    intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                                    e.k(file3);
                                    x.i("MicroMsg.WebSearch.PluginWebSearch", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(p.zP(0)), Integer.valueOf(intValue)});
                                    PluginWebSearch.access$300(this.pKx, file2, ixVar.bSA.bID);
                                    return false;
                                } catch (Throwable th) {
                                    e = th;
                                    e.f(fileInputStream);
                                    throw e;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            fileInputStream = null;
                            x.printErrStackTrace("MicroMsg.WebSearch.PluginWebSearch", e, e.getMessage(), new Object[0]);
                            e.f(fileInputStream);
                            intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                            e.k(file3);
                            x.i("MicroMsg.WebSearch.PluginWebSearch", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(p.zP(0)), Integer.valueOf(intValue)});
                            PluginWebSearch.access$300(this.pKx, file2, ixVar.bSA.bID);
                            return false;
                        } catch (Throwable th2) {
                            e = th2;
                            fileInputStream = null;
                            e.f(fileInputStream);
                            throw e;
                        }
                        intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                    } else {
                        intValue = 1;
                    }
                    e.k(file3);
                    x.i("MicroMsg.WebSearch.PluginWebSearch", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(p.zP(0)), Integer.valueOf(intValue)});
                    PluginWebSearch.access$300(this.pKx, file2, ixVar.bSA.bID);
                } else {
                    x.e("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdateListener file not exist");
                }
            } else if (ixVar.bSA.bID == 2) {
                file = new File(ixVar.bSA.filePath);
                if (file.exists()) {
                    int zP = p.zP(1);
                    PluginWebSearch.access$300(this.pKx, file, ixVar.bSA.bID);
                    x.i("MicroMsg.WebSearch.PluginWebSearch", "res update template currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(zP), Integer.valueOf(p.zP(1))});
                } else {
                    x.e("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdateListener file not exist");
                }
            }
        }
        return false;
    }
}
