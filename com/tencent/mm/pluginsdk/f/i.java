package com.tencent.mm.pluginsdk.f;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Base64;
import com.tencent.mm.a.g;
import com.tencent.mm.c.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.protocal.c.bsx;
import com.tencent.mm.protocal.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.List;

public final class i {
    private static final long[] qBt = new long[]{0, 259200000, 604800000};
    private static String qBu = "tinker-boots-install-info";
    private static String qBv = "tinker-boots-last-show";
    private static String qBw = "tinker-boots-show-time";
    private static String qBx = "";

    public static String cce() {
        return ad.getContext().getSharedPreferences("update_config_prefs", 4).getString("update_downloaded_pack_md5_key", null);
    }

    public static int ccf() {
        return ad.getContext().getSharedPreferences("update_config_prefs", 4).getInt("update_downloaded_pack_update_type", 3);
    }

    public static boolean ccg() {
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("update_config_prefs", 4);
        long j = sharedPreferences.getLong("update_downloaded_cancel_ts", 0);
        int i = sharedPreferences.getInt("update_downloaded_cancel_times", 0);
        x.i("MicroMsg.UpdateUtil", "checkIgnoreDownloadedPack last: %s times: %s", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        if (i > qBt.length - 1) {
            return true;
        }
        if (System.currentTimeMillis() - j > qBt[i]) {
            return false;
        }
        if (System.currentTimeMillis() - j >= 0) {
            return true;
        }
        x.e("MicroMsg.UpdateUtil", "user modify mobile time. we just remove the config.");
        ad.getContext().getSharedPreferences("update_config_prefs", 4).edit().clear().commit();
        x.i("MicroMsg.UpdateUtil", "clearUpdateConfigPrefs");
        return true;
    }

    public static boolean cch() {
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("update_config_prefs", 4);
        long j = sharedPreferences.getLong("update_downloading_in_silence", 0);
        boolean z = sharedPreferences.getBoolean("update_download_start_one_immediate", false);
        x.i("MicroMsg.UpdateUtil", "hasUnfinishDownloadingInSilence unfinish %s", new Object[]{Long.valueOf(j)});
        if (z || (j != 0 && System.currentTimeMillis() - j > 3600000)) {
            return true;
        }
        return false;
    }

    public static String eU(Context context) {
        String eV = eV(context);
        if (eV == null || !new File(eV).exists()) {
            return null;
        }
        a cD = a.cD(eV);
        return (cD == null || cD.bxh == null) ? g.cu(eV) : cD.bxh.apkMd5;
    }

    public static String eV(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.UpdateUtil", e, "", new Object[0]);
            return null;
        }
    }

    public static void bk(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    public static bsx cci() {
        bsx bsx;
        Throwable e;
        String string = ad.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString(qBu, "");
        if (bi.oW(string)) {
            bsx = null;
        } else {
            bsx bsx2;
            try {
                bsx2 = new bsx();
                try {
                    bsx = (bsx) bsx2.aG(Base64.decode(string, 0));
                } catch (Exception e2) {
                    e = e2;
                    x.printErrStackTrace("MicroMsg.UpdateUtil", e, "parse tinker install failed.", new Object[0]);
                    bsx = bsx2;
                    if (bsx == null) {
                        return bsx;
                    }
                    x.i("MicroMsg.UpdateUtil", "update info is null.");
                    return null;
                }
            } catch (Exception e3) {
                e = e3;
                bsx2 = null;
                x.printErrStackTrace("MicroMsg.UpdateUtil", e, "parse tinker install failed.", new Object[0]);
                bsx = bsx2;
                if (bsx == null) {
                    return bsx;
                }
                x.i("MicroMsg.UpdateUtil", "update info is null.");
                return null;
            }
        }
        if (bsx == null) {
            return bsx;
        }
        x.i("MicroMsg.UpdateUtil", "update info is null.");
        return null;
    }

    public static boolean ccj() {
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("tinker_patch_share_config", 4);
        long j = sharedPreferences.getLong(qBv, 0);
        int i = sharedPreferences.getInt(qBw, 0);
        x.d("MicroMsg.UpdateUtil", "isNeedShowTinkerDialog now:%d last:%d time:%d", new Object[]{Long.valueOf(System.currentTimeMillis()), Long.valueOf(j), Integer.valueOf(i)});
        if (System.currentTimeMillis() - j <= 21600000 || i >= 3) {
            return false;
        }
        return true;
    }

    public static void cck() {
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("tinker_patch_share_config", 4);
        sharedPreferences.edit().putLong(qBv, System.currentTimeMillis()).apply();
        sharedPreferences.edit().putInt(qBw, sharedPreferences.getInt(qBw, 0) + 1).apply();
    }

    public static void a(bsx bsx) {
        try {
            ad.getContext().getSharedPreferences("tinker_patch_share_config", 4).edit().putString(qBu, Base64.encodeToString(bsx.toByteArray(), 0)).apply();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.UpdateUtil", e, "", new Object[0]);
        }
        x.d("MicroMsg.UpdateUtil", "save tinker install update info.");
    }

    public static void ccl() {
        x.i("MicroMsg.UpdateUtil", "clearInstallUpdateInfo.");
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("tinker_patch_share_config", 4);
        sharedPreferences.edit().putString(qBu, "").apply();
        sharedPreferences.edit().putLong(qBv, 0).apply();
        sharedPreferences.edit().putInt(qBw, 0).apply();
    }

    public static void ccm() {
        au.Em().H(new 1());
    }

    public static String ccn() {
        if (bi.oW(qBx)) {
            qBx = e.dgj + "bsdiff/";
        }
        return qBx;
    }

    public static String Tg(String str) {
        return ccn() + str + ".apk";
    }

    public static String[] getShortIps() {
        int i = 0;
        if (af.ewV == null || af.ewV.length() <= 0) {
            String string = ad.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
            if (string == null || string.length() <= 0) {
                string = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
            }
            List Uz = n.Uz(string);
            String[] strArr = new String[Uz.size()];
            while (i < Uz.size()) {
                strArr[i] = ((n) Uz.get(i)).kCs;
                i++;
            }
            return strArr;
        }
        return new String[]{af.ewV};
    }
}
