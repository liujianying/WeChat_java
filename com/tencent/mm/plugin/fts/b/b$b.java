package com.tencent.mm.plugin.fts.b;

import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

class b$b extends a {
    final /* synthetic */ b jum;

    private b$b(b bVar) {
        this.jum = bVar;
    }

    /* synthetic */ b$b(b bVar, byte b) {
        this(bVar);
    }

    public final boolean execute() {
        Throwable e;
        x.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "start to check feature resource task %d", Integer.valueOf(b.K(b.aQl())));
        if (b.K(b.aQl()) < 0) {
            File file = new File(ad.getContext().getCacheDir(), "fts_feature.zip");
            InputStream open;
            OutputStream fileOutputStream;
            try {
                open = ad.getContext().getAssets().open("fts_feature.zip");
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = open.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        e.f(open);
                        e.closeOutputStream(fileOutputStream);
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            x.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", e, "CheckFeatureResourceTask", new Object[0]);
                            e.f(open);
                            e.closeOutputStream(fileOutputStream);
                            if (file.exists()) {
                                b bcVar = new bc();
                                bcVar.bIB.bIC = 35;
                                bcVar.bIB.bID = 1;
                                bcVar.bIB.filePath = file.getAbsolutePath();
                                com.tencent.mm.sdk.b.a.sFg.a(bcVar, Looper.getMainLooper());
                            }
                            return true;
                        } catch (Throwable th) {
                            e = th;
                            e.f(open);
                            e.closeOutputStream(fileOutputStream);
                            throw e;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = null;
                    x.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", e, "CheckFeatureResourceTask", new Object[0]);
                    e.f(open);
                    e.closeOutputStream(fileOutputStream);
                    if (file.exists()) {
                        b bcVar2 = new bc();
                        bcVar2.bIB.bIC = 35;
                        bcVar2.bIB.bID = 1;
                        bcVar2.bIB.filePath = file.getAbsolutePath();
                        com.tencent.mm.sdk.b.a.sFg.a(bcVar2, Looper.getMainLooper());
                    }
                    return true;
                } catch (Throwable th2) {
                    e = th2;
                    fileOutputStream = null;
                    e.f(open);
                    e.closeOutputStream(fileOutputStream);
                    throw e;
                }
            } catch (Exception e4) {
                e = e4;
                fileOutputStream = null;
                open = null;
            } catch (Throwable th3) {
                e = th3;
                fileOutputStream = null;
                open = null;
                e.f(open);
                e.closeOutputStream(fileOutputStream);
                throw e;
            }
            if (file.exists()) {
                b bcVar22 = new bc();
                bcVar22.bIB.bIC = 35;
                bcVar22.bIB.bID = 1;
                bcVar22.bIB.filePath = file.getAbsolutePath();
                com.tencent.mm.sdk.b.a.sFg.a(bcVar22, Looper.getMainLooper());
            }
        }
        return true;
    }

    public final String getName() {
        return "CheckFeatureResourceTask";
    }
}
