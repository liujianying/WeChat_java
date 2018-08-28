package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.InputStream;
import org.json.JSONObject;

public final class af {
    public static final int VERSION;
    public static final String[] fgM;
    static final a fgN;
    private static Boolean fgO = null;

    static {
        int i = -1;
        try {
            if (ad.cic()) {
                String abT = abT();
                if (!bi.oW(abT) && e.cn(abT)) {
                    i = new JSONObject(e.ct(abT)).optInt("version");
                }
            }
        } catch (Exception e) {
        }
        if (i > 0) {
            VERSION = i;
            fgM = a.foo;
            fgN = a.fgS;
        } else {
            VERSION = 115;
            fgM = a.foo;
            fgN = a.fgS;
        }
    }

    public static void abS() {
        e.deleteFile(abT());
    }

    static String abT() {
        return new File(ah.abY() + "/MockLibInfo.json").getAbsolutePath();
    }

    public static boolean abU() {
        if (fgO == null) {
            ad.chZ();
            fgO = Boolean.valueOf(false);
        }
        return fgO.booleanValue();
    }

    public static InputStream openRead(String str) {
        String qC = a.qC(str);
        switch (1.fgP[fgN.ordinal()]) {
            case 1:
                return qL("wxa_library/local" + qC);
            case 2:
                return qL("wxa_library/develop" + qC);
            default:
                return qL("wxa_library" + qC);
        }
    }

    private static InputStream qL(String str) {
        try {
            return ad.getContext().getAssets().open(str);
        } catch (Exception e) {
            x.v("MicroMsg.AppBrand.WxaLocalLibPkg", "openRead file( %s ) failed, exp = %s", new Object[]{str, e});
            return null;
        }
    }

    public static WxaPkgWrappingInfo abV() {
        WxaPkgWrappingInfo wxaPkgWrappingInfo = new WxaPkgWrappingInfo();
        wxaPkgWrappingInfo.fii = VERSION;
        wxaPkgWrappingInfo.fik = true;
        return wxaPkgWrappingInfo;
    }
}
