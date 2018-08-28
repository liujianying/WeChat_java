package com.tencent.mm.plugin.websearch;

import com.tencent.mm.a.e;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

class PluginWebSearch$3 extends c<bc> {
    final /* synthetic */ PluginWebSearch pKx;

    PluginWebSearch$3(PluginWebSearch pluginWebSearch) {
        this.pKx = pluginWebSearch;
        this.sFo = bc.class.getName().hashCode();
    }

    private boolean a(bc bcVar) {
        Throwable e;
        int intValue;
        if (bcVar != null && bcVar.bIB.bIC == 27) {
            if (bcVar.bIB.bID == 2 && !PluginWebSearch.checkTopStoryTemplateFolderValid()) {
                PluginWebSearch.access$200(bcVar.bIB.bID, 12);
            }
            String zU = p.zU(bcVar.bIB.bID);
            String zV = p.zV(bcVar.bIB.bID);
            int zW = p.zW(bcVar.bIB.bID);
            if (!(bi.oW(zU) || bi.oW(zV))) {
                File file = new File(bcVar.bIB.filePath);
                if (file.exists()) {
                    x.i("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdateListener callback to update %s", new Object[]{file.getAbsoluteFile()});
                    File file2 = new File(zU, "temp");
                    File file3 = new File(file2, zV);
                    file2.mkdirs();
                    e.y(file.getAbsolutePath(), file3.getAbsolutePath());
                    int fR = bi.fR(file3.getAbsolutePath(), file2.getAbsolutePath());
                    if (fR >= 0) {
                        Properties properties = new Properties();
                        InputStream fileInputStream;
                        try {
                            fileInputStream = new FileInputStream(new File(file2, "config.conf"));
                            try {
                                properties.load(fileInputStream);
                                e.f(fileInputStream);
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    x.printErrStackTrace("MicroMsg.WebSearch.PluginWebSearch", e, e.getMessage(), new Object[0]);
                                    e.f(fileInputStream);
                                    intValue = Integer.valueOf(properties.getProperty("version", "1")).intValue();
                                    e.k(file2);
                                    if (zW < intValue) {
                                        if (fR >= 0) {
                                            PluginWebSearch.access$200(bcVar.bIB.bID, 13);
                                        } else {
                                            PluginWebSearch.access$200(bcVar.bIB.bID, 11);
                                        }
                                        x.i("MicroMsg.WebSearch.PluginWebSearch", "res no need update template subtype:%d currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(bcVar.bIB.bID), Integer.valueOf(zW), Integer.valueOf(intValue)});
                                    } else {
                                        PluginWebSearch.access$200(bcVar.bIB.bID, 9);
                                        x.i("MicroMsg.WebSearch.PluginWebSearch", "res update template subtype:%d currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(bcVar.bIB.bID), Integer.valueOf(zW), Integer.valueOf(intValue)});
                                        PluginWebSearch.access$300(this.pKx, file, bcVar.bIB.bID);
                                    }
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
                            e.k(file2);
                            if (zW < intValue) {
                                PluginWebSearch.access$200(bcVar.bIB.bID, 9);
                                x.i("MicroMsg.WebSearch.PluginWebSearch", "res update template subtype:%d currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(bcVar.bIB.bID), Integer.valueOf(zW), Integer.valueOf(intValue)});
                                PluginWebSearch.access$300(this.pKx, file, bcVar.bIB.bID);
                            } else {
                                if (fR >= 0) {
                                    PluginWebSearch.access$200(bcVar.bIB.bID, 13);
                                } else {
                                    PluginWebSearch.access$200(bcVar.bIB.bID, 11);
                                }
                                x.i("MicroMsg.WebSearch.PluginWebSearch", "res no need update template subtype:%d currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(bcVar.bIB.bID), Integer.valueOf(zW), Integer.valueOf(intValue)});
                            }
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
                    e.k(file2);
                    if (zW < intValue) {
                        PluginWebSearch.access$200(bcVar.bIB.bID, 9);
                        x.i("MicroMsg.WebSearch.PluginWebSearch", "res update template subtype:%d currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(bcVar.bIB.bID), Integer.valueOf(zW), Integer.valueOf(intValue)});
                        PluginWebSearch.access$300(this.pKx, file, bcVar.bIB.bID);
                    } else {
                        if (fR >= 0) {
                            PluginWebSearch.access$200(bcVar.bIB.bID, 13);
                        } else {
                            PluginWebSearch.access$200(bcVar.bIB.bID, 11);
                        }
                        x.i("MicroMsg.WebSearch.PluginWebSearch", "res no need update template subtype:%d currentVersion:%d resVersion:%d", new Object[]{Integer.valueOf(bcVar.bIB.bID), Integer.valueOf(zW), Integer.valueOf(intValue)});
                    }
                } else {
                    x.e("MicroMsg.WebSearch.PluginWebSearch", "checkResUpdateListener file not exist");
                }
            }
        }
        return false;
    }
}
