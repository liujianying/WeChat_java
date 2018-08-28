package com.tencent.mm.plugin.exdevice.f.a;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import java.io.File;

public final class d {
    private static final String ixp = (e.dgt + "uploaded_photos/");
    private static final String ixq = (e.dgt + "temp/");

    public static String Ac(String str) {
        String str2;
        if (bi.oW(str)) {
            str2 = "";
        } else {
            str2 = new File(aHr(), ac.ce(str) + "_t").getAbsolutePath();
        }
        c.c(str, 640, 640, CompressFormat.JPEG, 100, str2);
        System.currentTimeMillis();
        return str2;
    }

    public static File aHr() {
        File file = new File(ixp);
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        return file;
    }
}
