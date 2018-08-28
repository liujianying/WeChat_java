package com.tencent.mm.ak;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class q {
    private static String[] dWM = null;

    public static boolean Pn() {
        boolean z;
        if (dWM == null) {
            Po();
        }
        if (VERSION.SDK_INT < 14 || dWM == null || dWM.length <= 0 || com.tencent.mm.compatible.e.q.deW.der != 1) {
            z = false;
        } else {
            z = true;
        }
        x.d("MicroMsg.WebpUtil", "isSupportWebp: %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    private static void Po() {
        try {
            String value = ((a) g.l(a.class)).AT().getValue("BizEnableWebpUrl");
            x.d("MicroMsg.WebpUtil", "initCdnUrlList, urllist: %s", new Object[]{value});
            if (!bi.oW(value)) {
                dWM = value.split(";");
                x.d("MicroMsg.WebpUtil", "initCdnUrlList, CDN_URL_LIST.length: %d", new Object[]{Integer.valueOf(dWM.length)});
            }
        } catch (b e) {
            x.w("MicroMsg.WebpUtil", "initCdnUrlList fail, AccountNotReady");
        } catch (Exception e2) {
            x.d("MicroMsg.WebpUtil", "initCdnUrlList error: %s", new Object[]{e2.getMessage()});
        }
    }

    private static boolean lW(String str) {
        if (dWM == null || dWM.length <= 0 || bi.oW(str)) {
            return false;
        }
        for (String startsWith : dWM) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    public static String lX(String str) {
        if (dWM == null || dWM.length == 0) {
            x.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, cdn url is null");
            Po();
        }
        if (lW(str)) {
            try {
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter("wxtype");
                if (bi.oW(queryParameter)) {
                    return str;
                }
                queryParameter = queryParameter.toLowerCase();
                x.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, wxtype:%s", new Object[]{queryParameter});
                if (queryParameter.equals("gif") || queryParameter.contains("gif")) {
                    return str;
                }
                String queryParameter2 = parse.getQueryParameter("tp");
                if ((!bi.oW(queryParameter2) && queryParameter2.equals("webp")) || bi.oW(queryParameter)) {
                    return str;
                }
                x.d("MicroMsg.WebpUtil", "webpURL: %s", new Object[]{parse.buildUpon().appendQueryParameter("tp", "webp").build().toString()});
                return parse.buildUpon().appendQueryParameter("tp", "webp").build().toString();
            } catch (Exception e) {
                return str;
            }
        }
        x.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, is not cdn url");
        return str;
    }

    public static boolean lY(String str) {
        try {
            if (bi.oW(str) || !lW(str)) {
                return false;
            }
            String queryParameter = Uri.parse(str).getQueryParameter("tp");
            if (bi.oW(queryParameter) || !queryParameter.equals("webp")) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static int Pp() {
        Context context = ad.getContext();
        if (ao.isWifi(context)) {
            return 1;
        }
        if (ao.is4G(context)) {
            return 4;
        }
        if (ao.is3G(context)) {
            return 3;
        }
        if (ao.is2G(context)) {
            return 2;
        }
        return 0;
    }

    public static String hY(int i) {
        return String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[]{Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(Pp()), Integer.valueOf(2)});
    }

    public static String hZ(int i) {
        return String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[]{Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(Pp()), Integer.valueOf(1)});
    }

    public static String lZ(String str) {
        try {
            if (!lW(str)) {
                return null;
            }
            String toLowerCase = Uri.parse(str).getQueryParameter("wxtype").toLowerCase();
            if (bi.oW(toLowerCase)) {
                return null;
            }
            return toLowerCase.toLowerCase();
        } catch (Exception e) {
            return null;
        }
    }
}
