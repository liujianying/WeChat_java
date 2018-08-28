package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.File;

final class m {
    static String i(String... strArr) {
        File file;
        StringBuilder stringBuilder = new StringBuilder(";");
        for (String oV : strArr) {
            stringBuilder.append(bi.oV(oV)).append(';');
        }
        String u = g.u(stringBuilder.toString().getBytes());
        if (f.zZ()) {
            String str = e.bnE;
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            file = new File(str + "wxanewfiles/");
        } else {
            file = null;
        }
        if (file == null) {
            return "[INVALID]";
        }
        return new File(file.getPath() + "/" + u).getPath();
    }

    static boolean e(File file, File file2) {
        while (file2 != null) {
            if (file.equals(file2)) {
                return true;
            }
            file2 = file2.getParentFile();
        }
        return false;
    }
}
