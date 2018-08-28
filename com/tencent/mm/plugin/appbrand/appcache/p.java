package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;

final class p {
    static String a(ag agVar, String str) {
        String str2 = null;
        if (!(agVar == null || bi.oW(str))) {
            agVar.abW();
            Closeable qN = agVar.qN(str);
            if (qN != null) {
                try {
                    qN.mark(qN.available());
                    String b = g.b(qN, Downloads.RECV_BUFFER_SIZE);
                    qN.reset();
                    File file = new File(agVar.fgV.getAbsolutePath() + "_xdir/" + str);
                    File parentFile = file.getParentFile();
                    if (parentFile.exists() && parentFile.isFile()) {
                        parentFile.delete();
                    }
                    parentFile.mkdirs();
                    if (!b.equals(g.m(file))) {
                        if (file.isDirectory()) {
                            Runtime.getRuntime().exec("rm -r " + file.getAbsolutePath());
                        } else {
                            file.delete();
                        }
                        Closeable fileOutputStream = new FileOutputStream(file);
                        e.d(qN, fileOutputStream);
                        bi.d(fileOutputStream);
                    }
                    str2 = file.getAbsolutePath();
                    bi.d(qN);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AppBrand.PkgPartialCopy", e, "copy failed", new Object[0]);
                    bi.d(qN);
                } catch (Throwable th) {
                    bi.d(qN);
                    throw th;
                }
            }
        }
        return str2;
    }
}
