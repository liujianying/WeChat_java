package com.tencent.mm.modelappbrand.b;

import com.tencent.mm.a.e;
import com.tencent.mm.modelappbrand.b.b.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class b$a implements g {
    private b$a() {
    }

    /* synthetic */ b$a(byte b) {
        this();
    }

    public final OutputStream jx(String str) {
        try {
            return new FileOutputStream(b.access$1200() + str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", e, "openWrite fileName %s", new Object[]{str});
            return null;
        }
    }

    public final InputStream openRead(String str) {
        try {
            return new FileInputStream(b.access$1200() + str);
        } catch (IOException e) {
            x.d("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openRead fileName %s, e %s", new Object[]{str, e});
            return null;
        }
    }

    public final boolean jy(String str) {
        return !bi.oW(str) && e.deleteFile(b.access$1200() + str);
    }
}
