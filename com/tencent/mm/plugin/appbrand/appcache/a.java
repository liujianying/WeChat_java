package com.tencent.mm.plugin.appbrand.appcache;

import android.util.SparseIntArray;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class a {
    private static final SparseIntArray ffp;

    static int D(byte[] bArr, int i) {
        if (bArr == null) {
            return 0;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, 4);
        wrap.order(ByteOrder.BIG_ENDIAN);
        return wrap.getInt();
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(3);
        ffp = sparseIntArray;
        sparseIntArray.put(0, com.tencent.mm.plugin.appbrand.e.a.a.app_empty_string);
        ffp.put(1, com.tencent.mm.plugin.appbrand.e.a.a.app_brand_app_debug_type_testing);
        ffp.put(2, com.tencent.mm.plugin.appbrand.e.a.a.app_brand_app_debug_type_previewing);
    }

    public static String jB(int i) {
        return ad.getResources().getString(ffp.get(i, com.tencent.mm.plugin.appbrand.e.a.a.app_empty_string));
    }

    public static String qB(String str) {
        if (bi.oW(str)) {
            return str;
        }
        int i = 0;
        while (i < str.length() && '/' == str.charAt(i)) {
            i++;
        }
        return str.substring(i);
    }

    public static String qC(String str) {
        int i = 0;
        x.d("MicroMsg.AppBrandAppCacheUtil", "eliminateDuplicateSlashForPkgFile, original file name = [%s]", new Object[]{str});
        if (bi.oW(str)) {
            return "";
        }
        String trim = str.trim();
        if (!trim.startsWith("/")) {
            return "/" + trim;
        }
        while (i < trim.length() && '/' == trim.charAt(i)) {
            i++;
        }
        return "/" + trim.substring(i);
    }
}
