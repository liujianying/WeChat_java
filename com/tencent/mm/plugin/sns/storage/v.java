package com.tencent.mm.plugin.sns.storage;

import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;

public final class v {
    public static String ah(String str, long j) {
        return str + j;
    }

    public static String ai(String str, long j) {
        return str + j;
    }

    public static boolean ND(String str) {
        return str != null && str.startsWith("ad_table_");
    }

    public static boolean Lr(String str) {
        return str != null && str.startsWith("sns_table_");
    }

    public static long NE(String str) {
        if (bi.oW(str)) {
            return 0;
        }
        if (str.startsWith("ad_table_")) {
            return bi.WV(str.substring(9));
        }
        if (str.startsWith("sns_table_")) {
            return bi.WV(str.substring(10));
        }
        return bi.WV(str);
    }

    public static int NF(String str) {
        if (bi.oW(str)) {
            return 0;
        }
        if (str.startsWith("ad_table_")) {
            return bi.WU(str.substring(9));
        }
        return bi.WU(str.substring(10));
    }

    public static boolean NG(String str) {
        if (str.startsWith("ad_table_")) {
            if (bi.WV(str.substring(9)) != 0) {
                return true;
            }
            return false;
        } else if (bi.WV(str.substring(10)) == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean NH(String str) {
        return !NG(str);
    }

    public static int eN(String str, String str2) {
        g.Eg();
        return ae(str, str2, a.Dg());
    }

    public static int ae(String str, String str2, String str3) {
        String af = af(str, str2, str3);
        if (bi.oW(af)) {
            return 0;
        }
        String[] split = af.split("&");
        int i = 0;
        while (i < split.length) {
            if (split[i] != null && split[i].contains("voteResultIndex=")) {
                return Integer.valueOf(split[i].substring(16)).intValue();
            }
            i++;
        }
        return 0;
    }

    public static String af(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        if (str == null) {
            str = "";
        }
        stringBuilder.append(str);
        if (str2 == null) {
            str2 = "";
        }
        stringBuilder.append(str2);
        if (str3 == null) {
            str3 = "";
        }
        stringBuilder.append(str3);
        if (stringBuilder.length() > 0) {
            return ad.getContext().getSharedPreferences("SnsAdVote", 0).getString(stringBuilder.toString(), "");
        }
        return "";
    }

    public static void g(String str, String str2, String str3, int i, int i2) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            if (str == null) {
                str = "";
            }
            stringBuilder.append(str);
            if (str2 == null) {
                str2 = "";
            }
            stringBuilder.append(str2);
            if (str3 == null) {
                str3 = "";
            }
            stringBuilder.append(str3);
            if (stringBuilder.length() > 0) {
                Editor edit = ad.getContext().getSharedPreferences("SnsAdVote", 0).edit();
                edit.putString(stringBuilder.toString(), "voteResultIndex=" + i + "&isUpdate=" + i2);
                edit.commit();
            }
        }
    }
}
