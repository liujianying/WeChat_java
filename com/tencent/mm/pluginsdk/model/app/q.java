package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class q {
    public static boolean g(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.ApplicationUtil", "install app failed: " + uri.toString() + ", ex = " + e.getMessage());
            return false;
        }
    }

    public static boolean bi(Context context, String str) {
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW", parse);
        intent.addFlags(268435456);
        if (getPackageInfo(context, "com.android.vending") != null) {
            x.v("MicroMsg.ApplicationUtil", "installAppWithGP, gp is installed, url = %s", new Object[]{str});
            intent.setPackage("com.android.vending");
        } else {
            x.v("MicroMsg.ApplicationUtil", "installAppWithGP, gp is not installed, url = %s", new Object[]{str});
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.ApplicationUtil", "installAppWithGP first, ex = %s", new Object[]{e.getMessage()});
            try {
                intent = new Intent("android.intent.action.VIEW", parse);
                intent.addFlags(268435456);
                context.startActivity(intent);
                return true;
            } catch (Exception e2) {
                x.e("MicroMsg.ApplicationUtil", "installAppWithGP second, ex = %s", new Object[]{e2.getMessage()});
                return false;
            }
        }
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        PackageInfo packageInfo = null;
        if (str.length() == 0) {
            x.e("MicroMsg.ApplicationUtil", "getPackageInfo, packageName is null");
            return packageInfo;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
            x.w("MicroMsg.ApplicationUtil", "app not installed, packageName = " + str);
            return packageInfo;
        }
    }

    public static String Td(String str) {
        String str2 = null;
        if (bi.oW(str)) {
            return str2;
        }
        try {
            PackageInfo packageArchiveInfo = ad.getContext().getPackageManager().getPackageArchiveInfo(str, 0);
            if (packageArchiveInfo == null) {
                throw new RuntimeException("info is null; " + str);
            }
            x.i("MicroMsg.ApplicationUtil", "get package name from archive filepath  :%s, package name is : %s", new Object[]{str, packageArchiveInfo.packageName});
            return packageArchiveInfo.packageName;
        } catch (Exception e) {
            x.e("MicroMsg.ApplicationUtil", "get package name from archive file path, failed : %s", new Object[]{e.getMessage()});
            return str2;
        }
    }

    public static int Te(String str) {
        int i = 0;
        if (bi.oW(str)) {
            return i;
        }
        try {
            PackageInfo packageArchiveInfo = ad.getContext().getPackageManager().getPackageArchiveInfo(str, 0);
            if (packageArchiveInfo == null) {
                throw new RuntimeException("info is null; " + str);
            }
            x.i("MicroMsg.ApplicationUtil", "get package version code from archive filepath  :%s, package version code is : %d", new Object[]{str, Integer.valueOf(packageArchiveInfo.versionCode)});
            return packageArchiveInfo.versionCode;
        } catch (Exception e) {
            x.e("MicroMsg.ApplicationUtil", "get package version code from archive file path, failed : %s", new Object[]{e.getMessage()});
            return i;
        }
    }
}
