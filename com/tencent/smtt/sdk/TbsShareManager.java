package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.j;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TbsShareManager {
    private static Context a;
    private static boolean b;
    private static String c = null;
    private static String d = null;
    private static int e = 0;
    private static String f = null;
    private static boolean g = false;
    private static boolean h = false;
    private static String i = null;
    private static boolean j = false;
    private static boolean k = false;
    public static boolean mHasQueryed = false;

    static int a(Context context, boolean z) {
        b(context, z);
        return e;
    }

    static Context a(Context context, String str) {
        Context context2 = null;
        try {
            return context.createPackageContext(str, 2);
        } catch (NameNotFoundException e) {
            return context2;
        } catch (Exception e2) {
            return context2;
        }
    }

    static String a() {
        return d;
    }

    static void a(Context context) {
        try {
            TbsLinuxToolsJni tbsLinuxToolsJni = new TbsLinuxToolsJni(context);
            a(context, tbsLinuxToolsJni, an.a().q(context));
            tbsLinuxToolsJni.a(an.a().r(context).getAbsolutePath(), "755");
        } catch (Throwable th) {
        }
    }

    private static void a(Context context, TbsLinuxToolsJni tbsLinuxToolsJni, File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            tbsLinuxToolsJni.a(file.getAbsolutePath(), "755");
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    if (file2.getAbsolutePath().indexOf(".so") > 0) {
                        tbsLinuxToolsJni.a(file2.getAbsolutePath(), "755");
                    } else {
                        tbsLinuxToolsJni.a(file2.getAbsolutePath(), "644");
                    }
                } else if (file2.isDirectory()) {
                    a(context, tbsLinuxToolsJni, file2);
                } else {
                    TbsLog.e("TbsShareManager", "unknown file type.", true);
                }
            }
        }
    }

    private static File b(Context context, String str) {
        File r = an.a().r(context);
        if (r == null) {
            return null;
        }
        File file = new File(r, str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e) {
            return null;
        }
    }

    static void b(Context context) {
        try {
            a(context, new TbsLinuxToolsJni(context), an.a().p(context));
        } catch (Throwable th) {
        }
    }

    static boolean b(Context context, boolean z) {
        if (i(context)) {
            return true;
        }
        if (z) {
            QbSdk.a(context, "TbsShareManager::isShareTbsCoreAvailable forceSysWebViewInner!");
        }
        return false;
    }

    static String c(Context context) {
        j(context);
        return d;
    }

    private static void c(Context context, boolean z) {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream2 = null;
        BufferedInputStream bufferedInputStream2;
        BufferedOutputStream bufferedOutputStream3;
        try {
            File b = b(context, "core_info");
            if (b == null) {
                if (null != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e) {
                    }
                }
                if (null != null) {
                    try {
                        bufferedOutputStream2.close();
                        return;
                    } catch (Exception e2) {
                        return;
                    }
                }
                return;
            }
            bufferedInputStream2 = new BufferedInputStream(new FileInputStream(b));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream2);
                properties.setProperty("core_disabled", "false");
                if (z) {
                    String absolutePath = an.a().q(context).getAbsolutePath();
                    String packageName = context.getApplicationContext().getPackageName();
                    int b2 = b.b(context);
                    properties.setProperty("core_packagename", packageName);
                    properties.setProperty("core_path", absolutePath);
                    properties.setProperty("app_version", String.valueOf(b2));
                }
                bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(b));
                try {
                    properties.store(bufferedOutputStream3, null);
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception e3) {
                        }
                    }
                    if (bufferedOutputStream3 != null) {
                        bufferedOutputStream3.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = bufferedOutputStream3;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception e4) {
                        }
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e42) {
                    }
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e52) {
                    }
                }
                throw th;
            }
        } catch (Throwable th32) {
            th = th32;
            bufferedOutputStream = null;
            bufferedInputStream2 = null;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (Exception e422) {
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (Exception e522) {
                }
            }
            throw th;
        }
    }

    static int d(Context context) {
        return a(context, true);
    }

    static Context e(Context context) {
        j(context);
        if (f == null) {
            return null;
        }
        Context a = a(context, f);
        return !an.a().f(a) ? null : a;
    }

    static synchronized String f(Context context) {
        BufferedInputStream bufferedInputStream;
        String str;
        Throwable th;
        synchronized (TbsShareManager.class) {
            bufferedInputStream = null;
            BufferedInputStream bufferedInputStream2;
            try {
                File b = b(context, "core_info");
                if (b == null) {
                    if (null != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e) {
                        }
                    }
                    str = null;
                } else {
                    bufferedInputStream2 = new BufferedInputStream(new FileInputStream(b));
                    try {
                        Properties properties = new Properties();
                        properties.load(bufferedInputStream2);
                        str = properties.getProperty("core_packagename", "");
                        if ("".equals(str)) {
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (Exception e2) {
                                }
                            }
                            str = null;
                        } else if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (Exception e3) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (Exception e4) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream2 = null;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e42) {
                    }
                }
                throw th;
            }
        }
        return str;
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (Exception e5) {
            }
        }
        str = null;
        return str;
        str = null;
        return str;
    }

    public static int findCoreForThirdPartyApp(Context context) {
        n(context);
        TbsLog.i("TbsShareManager", "core_info mAvailableCoreVersion is " + e + " mAvailableCorePath is " + d + " mSrcPackageName is " + f);
        if (f == null) {
            TbsLog.e("TbsShareManager", "mSrcPackageName is null !!!");
        }
        if (f == null || !f.equals("AppDefined")) {
            if (!(k(context) || l(context))) {
                e = 0;
                d = null;
                f = null;
                TbsLog.i("TbsShareManager", "core_info error checkCoreInfo is false and checkCoreInOthers is false ");
            }
        } else if (e != an.a().a(c)) {
            e = 0;
            d = null;
            f = null;
            TbsLog.i("TbsShareManager", "check AppDefined core is error src is " + e + " dest is " + an.a().a(c));
        }
        if (e > 0) {
            String str = "com.jd.jrapp";
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i = ("com.tencent.android.qqdownloader".equals(applicationInfo.packageName) || str.equals(applicationInfo.packageName)) ? 1 : 0;
            if ((i == 0 ? QbSdk.a(context, e) : false) || g) {
                e = 0;
                d = null;
                f = null;
                TbsLog.i("TbsShareManager", "core_info error QbSdk.isX5Disabled ");
            }
        }
        return e;
    }

    public static boolean forceLoadX5FromTBSDemo(Context context) {
        return false;
    }

    public static void forceToLoadX5ForThirdApp(Context context, boolean z) {
    }

    static String g(Context context) {
        try {
            n(context);
            if (d == null || TextUtils.isEmpty(d)) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder(d);
            stringBuilder.append(File.separator);
            stringBuilder.append("res.apk");
            return stringBuilder.toString();
        } catch (Throwable th) {
            new StringBuilder("getTbsResourcesPath exception: ").append(Log.getStackTraceString(th));
            return null;
        }
    }

    public static boolean getCoreDisabled() {
        return g;
    }

    public static boolean getCoreFormOwn() {
        return j;
    }

    public static String[] getCoreProviderAppList() {
        return new String[]{"com.tencent.tbs", "com.tencent.mm", "com.tencent.mobileqq", "com.qzone"};
    }

    public static int getCoreShareDecoupleCoreVersion(Context context, String str) {
        return 0;
    }

    public static String getHostCorePathAppDefined() {
        return c;
    }

    public static long getHostCoreVersions(Context context) {
        long j = 0;
        for (String str : getCoreProviderAppList()) {
            if (str.equalsIgnoreCase("com.tencent.mm")) {
                j += ((long) getSharedTbsCoreVersion(context, str)) * 10000000000L;
            } else if (str.equalsIgnoreCase("com.tencent.mobileqq")) {
                j += ((long) getSharedTbsCoreVersion(context, str)) * 100000;
            } else if (str.equalsIgnoreCase("com.qzone")) {
                j += (long) getSharedTbsCoreVersion(context, str);
            }
        }
        return j;
    }

    public static int getSharedTbsCoreVersion(Context context, String str) {
        Context a = a(context, str);
        return a != null ? an.a().i(a) : 0;
    }

    static synchronized int h(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        int i = 0;
        synchronized (TbsShareManager.class) {
            TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #1");
            BufferedInputStream bufferedInputStream2 = null;
            BufferedInputStream bufferedInputStream3;
            try {
                File b = b(context, "core_info");
                if (b == null) {
                    TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #2");
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception e) {
                        }
                    }
                } else {
                    bufferedInputStream3 = new BufferedInputStream(new FileInputStream(b));
                    try {
                        Properties properties = new Properties();
                        properties.load(bufferedInputStream3);
                        String property = properties.getProperty("core_version", "");
                        if ("".equals(property)) {
                            TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #4");
                            if (bufferedInputStream3 != null) {
                                bufferedInputStream3.close();
                            }
                        } else {
                            TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #3");
                            i = Math.max(Integer.parseInt(property), 0);
                            if (bufferedInputStream3 != null) {
                                bufferedInputStream3.close();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedInputStream3 != null) {
                            try {
                                bufferedInputStream3.close();
                            } catch (Exception e2) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream3 = bufferedInputStream2;
                if (bufferedInputStream3 != null) {
                    try {
                        bufferedInputStream3.close();
                    } catch (Exception e22) {
                    }
                }
                throw th;
            }
        }
        return i;
    }

    static boolean i(Context context) {
        try {
            if (e == 0) {
                findCoreForThirdPartyApp(context);
            }
            if (e == 0) {
                TbsLog.addLog(994, null, new Object[0]);
                return false;
            }
            if (c == null) {
                if (e != 0 && getSharedTbsCoreVersion(context, f) == e) {
                    return true;
                }
            } else if (e != 0 && an.a().a(c) == e) {
                return true;
            }
            if (l(context)) {
                return true;
            }
            TbsCoreLoadStat.getInstance().a(context, 418, new Throwable("mAvailableCoreVersion=" + e + "; mSrcPackageName=" + f + "; getSharedTbsCoreVersion(ctx, mSrcPackageName) is " + getSharedTbsCoreVersion(context, f) + "; getHostCoreVersions is " + getHostCoreVersions(context)));
            d = null;
            e = 0;
            TbsLog.addLog(993, null, new Object[0]);
            QbSdk.a(context, "TbsShareManager::isShareTbsCoreAvailableInner forceSysWebViewInner!");
            return false;
        } catch (Throwable th) {
            TbsLog.addLog(992, null, new Object[0]);
            return false;
        }
    }

    public static boolean isThirdPartyApp(Context context) {
        try {
            if (a != null && a.equals(context.getApplicationContext())) {
                return b;
            }
            Context applicationContext = context.getApplicationContext();
            a = applicationContext;
            String packageName = applicationContext.getPackageName();
            for (Object equals : getCoreProviderAppList()) {
                if (packageName.equals(equals)) {
                    b = false;
                    return false;
                }
            }
            b = true;
            return true;
        } catch (Throwable th) {
        }
    }

    static boolean j(Context context) {
        return b(context, true);
    }

    private static boolean k(Context context) {
        return f != null && e == getSharedTbsCoreVersion(context, f);
    }

    private static boolean l(Context context) {
        if (QbSdk.getOnlyDownload()) {
            return false;
        }
        for (String str : getCoreProviderAppList()) {
            if (e > 0 && e == getSharedTbsCoreVersion(context, str)) {
                Context a = a(context, str);
                if (an.a().f(context)) {
                    d = an.a().b(context, a).getAbsolutePath();
                    f = str;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean m(Context context) {
        if (context == null) {
            return false;
        }
        writeProperties(context, Integer.toString(0), "", "", Integer.toString(0));
        return true;
    }

    private static synchronized void n(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        BufferedInputStream bufferedInputStream2;
        synchronized (TbsShareManager.class) {
            if (!k) {
                BufferedInputStream bufferedInputStream3 = null;
                try {
                    File b = b(context, "core_info");
                    if (b != null) {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(b));
                        try {
                            Properties properties = new Properties();
                            properties.load(bufferedInputStream);
                            String property = properties.getProperty("core_version", "");
                            if (!"".equals(property)) {
                                e = Math.max(Integer.parseInt(property), 0);
                            }
                            property = properties.getProperty("core_packagename", "");
                            if (!"".equals(property)) {
                                f = property;
                            }
                            if (!(f == null || a == null)) {
                                if (f.equals(a.getPackageName())) {
                                    j = true;
                                } else {
                                    j = false;
                                }
                            }
                            property = properties.getProperty("core_path", "");
                            if (!"".equals(property)) {
                                d = property;
                            }
                            property = properties.getProperty("app_version", "");
                            if (!"".equals(property)) {
                                i = property;
                            }
                            g = Boolean.parseBoolean(properties.getProperty("core_disabled", "false"));
                            k = true;
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedInputStream2 = bufferedInputStream;
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (Exception e) {
                                }
                            }
                            throw th;
                        }
                    } else if (bufferedInputStream3 != null) {
                        try {
                            bufferedInputStream3.close();
                        } catch (Exception e2) {
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream2 = bufferedInputStream3;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception e3) {
                        }
                    }
                    throw th;
                }
            }
        }
        return;
        if (bufferedInputStream != null) {
            bufferedInputStream.close();
        }
        return;
    }

    public static void setHostCorePathAppDefined(String str) {
        c = str;
    }

    public static synchronized void writeCoreInfoForThirdPartyApp(Context context, int i, boolean z) {
        int i2 = 0;
        synchronized (TbsShareManager.class) {
            TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersion is " + i);
            if (i == 0) {
                m(context);
                TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-401);
            } else {
                int h = h(context);
                TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersionFromConfig is " + h);
                if (h < 0) {
                    TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-402);
                } else if (i == h) {
                    c(context, z);
                    TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-403);
                } else if (i < h) {
                    m(context);
                    TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-404);
                } else {
                    h = an.a().i(context);
                    TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersionFromCoreShare is " + h);
                    if (i < h) {
                        m(context);
                        TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-404);
                    } else {
                        String[] strArr;
                        File b;
                        TbsLinuxToolsJni tbsLinuxToolsJni;
                        Context a;
                        String absolutePath;
                        if (QbSdk.getOnlyDownload()) {
                            strArr = new String[]{context.getApplicationContext().getPackageName()};
                        } else {
                            String[] coreProviderAppList = getCoreProviderAppList();
                            if (z) {
                                strArr = new String[]{context.getApplicationContext().getPackageName()};
                            } else {
                                strArr = coreProviderAppList;
                            }
                        }
                        if (c != null) {
                            if (i == an.a().a(c)) {
                                writeProperties(context, Integer.toString(i), "AppDefined", c, Integer.toString(1));
                                try {
                                    b = b(context, "core_info");
                                    if (!(h || b == null)) {
                                        tbsLinuxToolsJni = new TbsLinuxToolsJni(a);
                                        tbsLinuxToolsJni.a(b.getAbsolutePath(), "644");
                                        tbsLinuxToolsJni.a(an.a().r(context).getAbsolutePath(), "755");
                                        h = true;
                                    }
                                } catch (Throwable th) {
                                }
                            } else if (i > an.a().a(c)) {
                                for (String str : strArr) {
                                    if (i == getSharedTbsCoreVersion(context, str)) {
                                        a = a(context, str);
                                        absolutePath = an.a().q(a).getAbsolutePath();
                                        b.b(context);
                                        if (an.a().f(a)) {
                                            try {
                                                j.a(new File(absolutePath), new File(c), new bc());
                                                writeProperties(context, Integer.toString(i), "AppDefined", c, Integer.toString(1));
                                                b = b(context, "core_info");
                                                if (!(h || b == null)) {
                                                    tbsLinuxToolsJni = new TbsLinuxToolsJni(a);
                                                    tbsLinuxToolsJni.a(b.getAbsolutePath(), "644");
                                                    tbsLinuxToolsJni.a(an.a().r(context).getAbsolutePath(), "755");
                                                    h = true;
                                                }
                                            } catch (Throwable th2) {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        h = strArr.length;
                        while (i2 < h) {
                            String str2 = strArr[i2];
                            if (i == getSharedTbsCoreVersion(context, str2)) {
                                a = a(context, str2);
                                absolutePath = an.a().q(a).getAbsolutePath();
                                int b2 = b.b(context);
                                if (an.a().f(a)) {
                                    if (!str2.equals(context.getApplicationContext().getPackageName())) {
                                        TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + i);
                                        try {
                                            j.b(an.a().q(context));
                                            TbsLog.i("TbsShareManager", "thirdAPP success--> delete old core_share Directory");
                                        } catch (Throwable th3) {
                                        }
                                    }
                                    writeProperties(context, Integer.toString(i), str2, absolutePath, Integer.toString(b2));
                                    try {
                                        b = b(context, "core_info");
                                        if (!(h || b == null)) {
                                            tbsLinuxToolsJni = new TbsLinuxToolsJni(a);
                                            tbsLinuxToolsJni.a(b.getAbsolutePath(), "644");
                                            tbsLinuxToolsJni.a(an.a().r(context).getAbsolutePath(), "755");
                                            h = true;
                                        }
                                    } catch (Throwable th4) {
                                    }
                                }
                            }
                            i2++;
                        }
                    }
                }
            }
        }
    }

    public static void writeProperties(Context context, String str, String str2, String str3, String str4) {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        int i = 0;
        TbsLog.i("TbsShareManager", "writeProperties coreVersion is " + str + " corePackageName is " + str2 + " corePath is " + str3);
        TbsLog.i("TbsShareManager", "writeProperties -- stack: " + Log.getStackTraceString(new Throwable("#")));
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream2 = null;
        BufferedOutputStream bufferedOutputStream3;
        try {
            File b = b(context, "core_info");
            if (b == null) {
                TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-405);
                if (null != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e) {
                    }
                }
                if (null != null) {
                    try {
                        bufferedOutputStream2.close();
                        return;
                    } catch (Exception e2) {
                        return;
                    }
                }
                return;
            }
            Properties properties;
            bufferedInputStream = new BufferedInputStream(new FileInputStream(b));
            try {
                properties = new Properties();
                properties.load(bufferedInputStream);
                try {
                    i = Integer.parseInt(str);
                } catch (Exception e3) {
                }
                if (i != 0) {
                    properties.setProperty("core_version", str);
                    properties.setProperty("core_disabled", "false");
                    properties.setProperty("core_packagename", str2);
                    properties.setProperty("core_path", str3);
                    properties.setProperty("app_version", str4);
                } else {
                    properties.setProperty("core_disabled", "true");
                }
                bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(b));
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e4) {
                    }
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e5) {
                    }
                }
                throw th;
            }
            try {
                properties.store(bufferedOutputStream3, null);
                k = false;
                TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-406);
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e6) {
                    }
                }
                if (bufferedOutputStream3 != null) {
                    bufferedOutputStream3.close();
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = bufferedOutputStream3;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e42) {
                    }
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e52) {
                    }
                }
                throw th;
            }
        } catch (Throwable th22) {
            th = th22;
            bufferedOutputStream = null;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (Exception e422) {
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (Exception e522) {
                }
            }
            throw th;
        }
    }
}
