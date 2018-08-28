package com.tencent.mm.modelcdntran;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.a.g;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.HttpURLConnection;
import java.util.List;

public final class d {
    public static int dPg = 1;
    public static int dPh = 2;
    public static int dPi = 3;
    public static int dPj = -1;
    public static int dPk = 3;
    public static int dPl = 4;
    public static int dPm = 5;
    public static int dPn = 1;
    public static int dPo = 2;
    public static int dPp = -10001;
    public static int dPq = -10002;
    public static int dPr = -10003;
    public static int dPs = -10004;

    public static void b(byte[] bArr, String str, int i) {
        if (bi.bC(bArr)) {
            bArr = new byte[0];
        }
        String str2 = new String(bArr);
        if (i == 4) {
            x.e(str, str2);
        } else if (i == 3) {
            x.w(str, str2);
        } else if (i == 2) {
            x.i(str, str2);
        } else if (i == 1) {
            x.d(str, str2);
        } else if (i == 0) {
            x.v(str, str2);
        }
    }

    private static String ly(String str) {
        if (bi.oW(str)) {
            return str;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!bi.o(charAt) && !bi.p(charAt)) {
                return null;
            }
        }
        return str;
    }

    public static String a(String str, long j, String str2, String str3) {
        x.d("MicroMsg.CdnUtil", "cdntra genClientId prefix[%s] createtime:%d talker[%s] suffix:[%s] stack[%s]", new Object[]{str, Long.valueOf(j), str2, str3, bi.cjd()});
        if (bi.oW(ly(str)) || bi.oW(str2) || j <= 0) {
            return null;
        }
        String oV = bi.oV(ly(str3));
        String str4 = "a" + str + "_" + g.u((q.GF() + "-" + str2).getBytes()).substring(0, 16) + "_" + j;
        if (bi.oW(oV)) {
            return str4;
        }
        return str4 + "_" + oV;
    }

    public static int bK(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return dPg;
            }
            if (activeNetworkInfo.getType() == 1) {
                return dPi;
            }
            if (activeNetworkInfo.getSubtype() == 1) {
                return dPg;
            }
            if (activeNetworkInfo.getSubtype() == 2) {
                return dPg;
            }
            if (activeNetworkInfo.getSubtype() >= 3) {
                return dPh;
            }
            return dPg;
        } catch (Throwable e) {
            x.e("MicroMsg.CdnUtil", "exception:%s", new Object[]{bi.i(e)});
            return dPg;
        }
    }

    public static int bL(Context context) {
        int netType = ao.getNetType(context);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return dPj;
        }
        if (activeNetworkInfo.getType() == 1) {
            return dPn;
        }
        if (activeNetworkInfo.getSubtype() == 1 || activeNetworkInfo.getSubtype() == 2) {
            return dPk;
        }
        if (activeNetworkInfo.getSubtype() >= 13) {
            return dPm;
        }
        if (activeNetworkInfo.getSubtype() >= 3) {
            return dPl;
        }
        if (ao.isWap(netType)) {
            return dPo;
        }
        return dPk;
    }

    public static int c(HttpURLConnection httpURLConnection) {
        try {
            List list = (List) httpURLConnection.getHeaderFields().get("cache-control");
            if (list == null || list.size() == 0) {
                return 0;
            }
            if (bi.oW(list.toString()) || !list.toString().contains("no-cache")) {
                return 0;
            }
            return -1;
        } catch (Throwable e) {
            x.e("MicroMsg.CdnUtil", "exception:%s", new Object[]{bi.i(e)});
            return -2;
        }
    }
}
