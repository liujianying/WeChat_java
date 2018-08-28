package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.appstorage.e.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

class e$9 implements a {
    final /* synthetic */ e fkl;

    e$9(e eVar) {
        this.fkl = eVar;
    }

    public final j a(File file, Object... objArr) {
        Exception e;
        Throwable th;
        if (k.z(file)) {
            return j.fkS;
        }
        InputStream inputStream = (InputStream) objArr[0];
        boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
        if (inputStream instanceof ZipInputStream) {
            if (k.a((ZipInputStream) inputStream, file.getAbsolutePath()) != 0) {
                return j.fkJ;
            }
            if (e.b(this.fkl) <= 0 || e.c(this.fkl) <= e.b(this.fkl)) {
                return j.fkI;
            }
            file.delete();
            return j.fkT;
        } else if (file.isDirectory()) {
            return j.fkN;
        } else {
            if (e.b(this.fkl) > 0) {
                try {
                    if (((long) inputStream.available()) + e.c(this.fkl) > e.b(this.fkl)) {
                        return j.fkT;
                    }
                } catch (Exception e2) {
                    x.e("MicroMsg.AppBrandNonFlattenedFileStorage", "writeFile, access available e=%s", new Object[]{e2});
                    return j.fkJ;
                }
            }
            Closeable fileOutputStream;
            j jVar;
            try {
                fileOutputStream = new FileOutputStream(file, booleanValue);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 4096);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileOutputStream.flush();
                            jVar = j.fkI;
                            bi.d(fileOutputStream);
                            bi.d(inputStream);
                            return jVar;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        x.i("MicroMsg.AppBrandNonFlattenedFileStorage", "writeFile exp %s", new Object[]{e});
                        jVar = j.fkJ;
                        bi.d(fileOutputStream);
                        bi.d(inputStream);
                        return jVar;
                    } catch (Throwable th2) {
                        th = th2;
                        bi.d(fileOutputStream);
                        bi.d(inputStream);
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e = e4;
                fileOutputStream = null;
                x.i("MicroMsg.AppBrandNonFlattenedFileStorage", "writeFile exp %s", new Object[]{e});
                jVar = j.fkJ;
                bi.d(fileOutputStream);
                bi.d(inputStream);
                return jVar;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                bi.d(fileOutputStream);
                bi.d(inputStream);
                throw th;
            }
        }
    }
}
