package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.qq.taf.jce.BuildConfig;
import com.tencent.smtt.sdk.TbsLogReport.EventType;
import com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.j;
import com.tencent.smtt.utils.m;
import com.tencent.smtt.utils.s;
import java.io.File;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class TbsDownloader {
    public static final boolean DEBUG_DISABLE_DOWNLOAD = false;
    public static boolean DOWNLOAD_OVERSEA_TBS = false;
    public static final String LOGTAG = "TbsDownload";
    static boolean a;
    private static String b;
    private static Context c;
    private static Handler d;
    private static String e;
    private static Object f = new byte[0];
    private static ag g;
    private static HandlerThread h;
    private static boolean i = false;
    private static boolean j = false;
    private static boolean k = false;
    private static long l = -1;

    protected static File a(int i) {
        File file = null;
        for (String str : TbsShareManager.getCoreProviderAppList()) {
            if (!str.equals(c.getApplicationInfo().packageName)) {
                file = new File(j.a(c, str, 4, false), getOverSea(c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                if (!file.exists()) {
                    TbsLog.i(LOGTAG, "can not find local backup core file");
                } else if (a.a(c, file) == i) {
                    TbsLog.i(LOGTAG, "local tbs version fond,path = " + file.getAbsolutePath());
                    break;
                } else {
                    TbsLog.i(LOGTAG, "version is not match");
                }
            }
        }
        return file;
    }

    static String a(Context context) {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        String str;
        Locale locale = Locale.getDefault();
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = VERSION.RELEASE;
        try {
            str = new String(str2.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e) {
            str = str2;
        }
        if (str == null) {
            stringBuffer.append(BuildConfig.VERSION_NAME);
        } else if (str.length() > 0) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append(BuildConfig.VERSION_NAME);
        }
        stringBuffer.append("; ");
        str = locale.getLanguage();
        if (str != null) {
            stringBuffer.append(str.toLowerCase());
            str = locale.getCountry();
            if (str != null) {
                stringBuffer.append("-");
                stringBuffer.append(str.toLowerCase());
            }
        } else {
            stringBuffer.append("en");
        }
        if ("REL".equals(VERSION.CODENAME)) {
            str2 = Build.MODEL;
            try {
                str = new String(str2.getBytes("UTF-8"), "ISO8859-1");
            } catch (Exception e2) {
                str = str2;
            }
            if (str == null) {
                stringBuffer.append("; ");
            } else if (str.length() > 0) {
                stringBuffer.append("; ");
                stringBuffer.append(str);
            }
        }
        str = (Build.ID == null ? "" : Build.ID).replaceAll("[一-龥]", "");
        if (str == null) {
            stringBuffer.append(" Build/");
            stringBuffer.append("00");
        } else if (str.length() > 0) {
            stringBuffer.append(" Build/");
            stringBuffer.append(str);
        }
        str = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", new Object[]{stringBuffer});
        b = str;
        return str;
    }

    private static String a(String str) {
        return str == null ? "" : str;
    }

    private static void a(boolean z, TbsDownloaderCallback tbsDownloaderCallback) {
        int i = 0;
        TbsLog.i(LOGTAG, "[TbsDownloader.queryConfig]");
        d.removeMessages(100);
        Message obtain = Message.obtain(d, 100);
        if (tbsDownloaderCallback != null) {
            obtain.obj = tbsDownloaderCallback;
        }
        obtain.arg1 = 0;
        if (z) {
            i = 1;
        }
        obtain.arg1 = i;
        obtain.sendToTarget();
    }

    private static boolean a(Context context, boolean z, TbsDownloaderCallback tbsDownloaderCallback) {
        Matcher matcher = null;
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(context);
        if (VERSION.SDK_INT < 8) {
            instance.setDownloadInterruptCode(-102);
            return false;
        }
        if (!instance.mPreferences.contains("is_oversea")) {
            if (z && !"com.tencent.mm".equals(context.getApplicationInfo().packageName)) {
                TbsLog.i(LOGTAG, "needDownload-oversea is true, but not WX");
                z = false;
            }
            instance.a.put("is_oversea", Boolean.valueOf(z));
            instance.commit();
            j = z;
            TbsLog.i(LOGTAG, "needDownload-first-called--isoversea = " + z);
        }
        if (!getOverSea(context) || VERSION.SDK_INT == 16 || VERSION.SDK_INT == 17 || VERSION.SDK_INT == 18) {
            CharSequence string = instance.mPreferences.getString("device_cpuabi", matcher);
            e = string;
            if (!TextUtils.isEmpty(string)) {
                try {
                    matcher = Pattern.compile("i686|mips|x86_64").matcher(e);
                } catch (Exception e) {
                }
                if (matcher != null && matcher.find()) {
                    if (tbsDownloaderCallback != null) {
                        tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
                    }
                    instance.setDownloadInterruptCode(-104);
                    return false;
                }
            }
            return true;
        }
        TbsLog.i(LOGTAG, "needDownload- return false,  because of  version is " + VERSION.SDK_INT + ", and overea");
        if (tbsDownloaderCallback != null) {
            tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
        }
        instance.setDownloadInterruptCode(-103);
        return false;
    }

    private static boolean a(Context context, boolean z, boolean z2) {
        boolean z3;
        TbsLogInfo a;
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(context);
        String str = null;
        if (!z) {
            String string = instance.mPreferences.getString("app_versionname", null);
            int i = instance.mPreferences.getInt("app_versioncode", 0);
            String string2 = instance.mPreferences.getString("app_metadata", null);
            String a2 = b.a(c);
            int b = b.b(c);
            String a3 = b.a(c, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
            TbsLog.i(LOGTAG, "[TbsDownloader.needSendQueryRequest] appVersionName=" + a2 + " oldAppVersionName=" + string + " appVersionCode=" + b + " oldAppVersionCode=" + i + " appMetadata=" + a3 + " oldAppVersionMetadata=" + string2);
            long currentTimeMillis = System.currentTimeMillis();
            long j = instance.mPreferences.getLong("last_check", 0);
            TbsLog.i(LOGTAG, "[TbsDownloader.needSendQueryRequest] timeLastCheck=" + j + " timeNow=" + currentTimeMillis);
            if (z2) {
                boolean contains = instance.mPreferences.contains("last_check");
                TbsLog.i(LOGTAG, "[TbsDownloader.needSendQueryRequest] hasLaskCheckKey=" + contains);
                if (contains && j == 0) {
                    j = currentTimeMillis;
                }
            }
            long j2 = instance.mPreferences.getLong("last_request_success", 0);
            long j3 = instance.mPreferences.getLong("count_request_fail_in_24hours", 0);
            long retryInterval = instance.getRetryInterval();
            TbsLog.i(LOGTAG, "retryInterval = " + retryInterval + " s");
            if (currentTimeMillis - j <= 1000 * retryInterval && (!TbsShareManager.isThirdPartyApp(c) || j2 <= 0 || currentTimeMillis - j2 <= retryInterval * 1000 || j3 >= 11)) {
                if (TbsShareManager.isThirdPartyApp(c) && TbsShareManager.findCoreForThirdPartyApp(c) == 0 && !d()) {
                    an.a().d(c);
                    z3 = true;
                    a = TbsLogReport.a(c).a();
                    a.setErrorCode(-119);
                    a.setFailDetail(str);
                    TbsLogReport.a(c).a(EventType.TYPE_DOWNLOAD, a);
                    return z3;
                }
                String str2;
                if (a2 == null || b == 0 || a3 == null) {
                    if (TbsShareManager.isThirdPartyApp(c)) {
                        str2 = "timeNow - timeLastCheck is " + (currentTimeMillis - j) + " TbsShareManager.findCoreForThirdPartyApp(sAppContext) is " + TbsShareManager.findCoreForThirdPartyApp(c) + " sendRequestWithSameHostCoreVersion() is " + d() + " appVersionName is " + a2 + " appVersionCode is " + b + " appMetadata is " + a3 + " oldAppVersionName is " + string + " oldAppVersionCode is " + i + " oldAppVersionMetadata is " + string2;
                    }
                    str2 = null;
                } else {
                    if (!(a2.equals(string) && b == i && a3.equals(string2))) {
                        z3 = true;
                        if (!z3 && TbsShareManager.isThirdPartyApp(c)) {
                            a = TbsLogReport.a(c).a();
                            a.setErrorCode(-119);
                            a.setFailDetail(str);
                            TbsLogReport.a(c).a(EventType.TYPE_DOWNLOAD, a);
                        }
                        return z3;
                    }
                    str2 = null;
                }
                str = str2;
                z3 = false;
                a = TbsLogReport.a(c).a();
                a.setErrorCode(-119);
                a.setFailDetail(str);
                TbsLogReport.a(c).a(EventType.TYPE_DOWNLOAD, a);
                return z3;
            }
        }
        z3 = true;
        a = TbsLogReport.a(c).a();
        a.setErrorCode(-119);
        a.setFailDetail(str);
        TbsLogReport.a(c).a(EventType.TYPE_DOWNLOAD, a);
        return z3;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.TargetApi(11)
    private static boolean a(java.lang.String r30, int r31, boolean r32, boolean r33) {
        /*
        r2 = "TbsDownload";
        r3 = new java.lang.StringBuilder;
        r4 = "[TbsDownloader.readResponse] response=";
        r3.<init>(r4);
        r0 = r30;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.smtt.utils.TbsLog.i(r2, r3);
        r2 = c;
        r13 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r2);
        r2 = android.text.TextUtils.isEmpty(r30);
        if (r2 == 0) goto L_0x003c;
    L_0x0024:
        if (r32 == 0) goto L_0x0036;
    L_0x0026:
        r2 = -108; // 0xffffffffffffff94 float:NaN double:NaN;
        r13.setDownloadInterruptCode(r2);
    L_0x002b:
        r2 = "TbsDownload";
        r3 = "[TbsDownloader.readResponse] return #1,response is empty...";
        com.tencent.smtt.utils.TbsLog.i(r2, r3);
        r2 = 0;
    L_0x0035:
        return r2;
    L_0x0036:
        r2 = -208; // 0xffffffffffffff30 float:NaN double:NaN;
        r13.setDownloadInterruptCode(r2);
        goto L_0x002b;
    L_0x003c:
        r14 = new org.json.JSONObject;
        r0 = r30;
        r14.<init>(r0);
        r2 = "RET";
        r2 = r14.getInt(r2);
        if (r2 == 0) goto L_0x0071;
    L_0x004c:
        if (r32 == 0) goto L_0x006b;
    L_0x004e:
        r3 = -109; // 0xffffffffffffff93 float:NaN double:NaN;
        r13.setDownloadInterruptCode(r3);
    L_0x0053:
        r3 = "TbsDownload";
        r4 = new java.lang.StringBuilder;
        r5 = "[TbsDownloader.readResponse] return #2,returnCode=";
        r4.<init>(r5);
        r2 = r4.append(r2);
        r2 = r2.toString();
        com.tencent.smtt.utils.TbsLog.i(r3, r2);
        r2 = 0;
        goto L_0x0035;
    L_0x006b:
        r3 = -209; // 0xffffffffffffff2f float:NaN double:NaN;
        r13.setDownloadInterruptCode(r3);
        goto L_0x0053;
    L_0x0071:
        r2 = "RESPONSECODE";
        r15 = r14.getInt(r2);
        r2 = "DOWNLOADURL";
        r16 = r14.getString(r2);
        r2 = "URLLIST";
        r3 = "";
        r17 = r14.optString(r2, r3);
        r2 = "TBSAPKSERVERVERSION";
        r18 = r14.getInt(r2);
        r2 = "DOWNLOADMAXFLOW";
        r19 = r14.getInt(r2);
        r2 = "DOWNLOAD_MIN_FREE_SPACE";
        r20 = r14.getInt(r2);
        r2 = "DOWNLOAD_SUCCESS_MAX_RETRYTIMES";
        r21 = r14.getInt(r2);
        r2 = "DOWNLOAD_FAILED_MAX_RETRYTIMES";
        r22 = r14.getInt(r2);
        r2 = "DOWNLOAD_SINGLE_TIMEOUT";
        r24 = r14.getLong(r2);
        r2 = "TBSAPKFILESIZE";
        r26 = r14.getLong(r2);
        r2 = "RETRY_INTERVAL";
        r4 = 0;
        r10 = r14.optLong(r2, r4);
        r2 = "FLOWCTR";
        r3 = -1;
        r23 = r14.optInt(r2, r3);
        r2 = 0;
        r3 = "USEBBACKUPVER";
        r2 = r14.getInt(r3);	 Catch:{ Exception -> 0x0801 }
    L_0x00d3:
        r3 = r13.a;
        r4 = "use_backup_version";
        r2 = java.lang.Integer.valueOf(r2);
        r3.put(r4, r2);
        if (r32 == 0) goto L_0x0105;
    L_0x00e1:
        r2 = com.tencent.smtt.sdk.QbSdk.i;
        if (r2 == 0) goto L_0x0105;
    L_0x00e5:
        r2 = c;
        r2 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r2);
        if (r2 == 0) goto L_0x0105;
    L_0x00ed:
        r2 = "BUGLY";
        r3 = 0;
        r2 = r14.optInt(r2, r3);	 Catch:{ Throwable -> 0x023e }
        r3 = com.tencent.smtt.sdk.TbsExtensionFunctionManager.getInstance();	 Catch:{ Throwable -> 0x023e }
        r4 = c;	 Catch:{ Throwable -> 0x023e }
        r5 = "bugly_switch.txt";
        r6 = 1;
        if (r2 != r6) goto L_0x023b;
    L_0x0101:
        r2 = 1;
    L_0x0102:
        r3.setFunctionEnable(r4, r5, r2);	 Catch:{ Throwable -> 0x023e }
    L_0x0105:
        if (r32 == 0) goto L_0x015d;
    L_0x0107:
        r2 = "TEMPLATESWITCH";
        r3 = 0;
        r3 = r14.optInt(r2, r3);	 Catch:{ Throwable -> 0x0261 }
        r2 = r3 & 1;
        if (r2 == 0) goto L_0x025b;
    L_0x0113:
        r2 = 1;
    L_0x0114:
        r4 = com.tencent.smtt.sdk.TbsExtensionFunctionManager.getInstance();	 Catch:{ Throwable -> 0x0261 }
        r5 = c;	 Catch:{ Throwable -> 0x0261 }
        r6 = "cookie_switch.txt";
        r4.setFunctionEnable(r5, r6, r2);	 Catch:{ Throwable -> 0x0261 }
        r4 = "TbsDownload";
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0261 }
        r6 = "useCookieCompatiable:";
        r5.<init>(r6);	 Catch:{ Throwable -> 0x0261 }
        r2 = r5.append(r2);	 Catch:{ Throwable -> 0x0261 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0261 }
        com.tencent.smtt.utils.TbsLog.w(r4, r2);	 Catch:{ Throwable -> 0x0261 }
        r2 = r3 & 2;
        if (r2 == 0) goto L_0x025e;
    L_0x013a:
        r2 = 1;
    L_0x013b:
        r3 = com.tencent.smtt.sdk.TbsExtensionFunctionManager.getInstance();	 Catch:{ Throwable -> 0x0261 }
        r4 = c;	 Catch:{ Throwable -> 0x0261 }
        r5 = "disable_get_apk_version_switch.txt";
        r3.setFunctionEnable(r4, r5, r2);	 Catch:{ Throwable -> 0x0261 }
        r3 = "TbsDownload";
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0261 }
        r5 = "disableGetApkVersionByReadFile:";
        r4.<init>(r5);	 Catch:{ Throwable -> 0x0261 }
        r2 = r4.append(r2);	 Catch:{ Throwable -> 0x0261 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0261 }
        com.tencent.smtt.utils.TbsLog.w(r3, r2);	 Catch:{ Throwable -> 0x0261 }
    L_0x015d:
        r9 = 0;
        r8 = 0;
        r4 = 0;
        r7 = 0;
        r6 = 0;
        r3 = 1;
        r5 = "";
        r2 = "PKGMD5";
        r9 = r14.getString(r2);	 Catch:{ Exception -> 0x0284 }
        r2 = "RESETX5";
        r8 = r14.getInt(r2);	 Catch:{ Exception -> 0x0284 }
        r2 = "UPLOADLOG";
        r7 = r14.getInt(r2);	 Catch:{ Exception -> 0x0284 }
        r2 = "RESETTOKEN";
        r2 = r14.has(r2);	 Catch:{ Exception -> 0x0284 }
        if (r2 == 0) goto L_0x018f;
    L_0x0184:
        r2 = "RESETTOKEN";
        r2 = r14.getInt(r2);	 Catch:{ Exception -> 0x0284 }
        if (r2 == 0) goto L_0x027e;
    L_0x018d:
        r2 = 1;
    L_0x018e:
        r6 = r2;
    L_0x018f:
        r2 = "SETTOKEN";
        r2 = r14.has(r2);	 Catch:{ Exception -> 0x0284 }
        if (r2 == 0) goto L_0x019f;
    L_0x0198:
        r2 = "SETTOKEN";
        r5 = r14.getString(r2);	 Catch:{ Exception -> 0x0284 }
    L_0x019f:
        r2 = "ENABLE_LOAD_RENAME_FILE_LOCK";
        r2 = r14.has(r2);	 Catch:{ Exception -> 0x0284 }
        if (r2 == 0) goto L_0x080a;
    L_0x01a8:
        r2 = "ENABLE_LOAD_RENAME_FILE_LOCK";
        r2 = r14.getInt(r2);	 Catch:{ Exception -> 0x0284 }
        if (r2 == 0) goto L_0x0281;
    L_0x01b1:
        r2 = 1;
    L_0x01b2:
        r12 = r2;
    L_0x01b3:
        r2 = "RESETDECOUPLECORE";
        r2 = r14.getInt(r2);	 Catch:{ Exception -> 0x028a }
    L_0x01ba:
        r3 = 0;
        r4 = "RESETTODECOUPLECORE";
        r3 = r14.getInt(r4);	 Catch:{ Exception -> 0x07fe }
    L_0x01c2:
        r4 = f;
        monitor-enter(r4);
        if (r6 == 0) goto L_0x01d6;
    L_0x01c7:
        r6 = r13.a;	 Catch:{ all -> 0x028e }
        r28 = "tbs_deskey_token";
        r29 = "";
        r0 = r28;
        r1 = r29;
        r6.put(r0, r1);	 Catch:{ all -> 0x028e }
    L_0x01d6:
        r6 = android.text.TextUtils.isEmpty(r5);	 Catch:{ all -> 0x028e }
        if (r6 != 0) goto L_0x020c;
    L_0x01dc:
        r6 = r5.length();	 Catch:{ all -> 0x028e }
        r28 = 96;
        r0 = r28;
        if (r6 != r0) goto L_0x020c;
    L_0x01e6:
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x028e }
        r6.<init>();	 Catch:{ all -> 0x028e }
        r5 = r6.append(r5);	 Catch:{ all -> 0x028e }
        r6 = "&";
        r5 = r5.append(r6);	 Catch:{ all -> 0x028e }
        r6 = com.tencent.smtt.utils.n.c();	 Catch:{ all -> 0x028e }
        r5 = r5.append(r6);	 Catch:{ all -> 0x028e }
        r5 = r5.toString();	 Catch:{ all -> 0x028e }
        r6 = r13.a;	 Catch:{ all -> 0x028e }
        r28 = "tbs_deskey_token";
        r0 = r28;
        r6.put(r0, r5);	 Catch:{ all -> 0x028e }
    L_0x020c:
        monitor-exit(r4);	 Catch:{ all -> 0x028e }
        r4 = 1;
        if (r8 != r4) goto L_0x0299;
    L_0x0210:
        if (r32 == 0) goto L_0x0291;
    L_0x0212:
        r2 = -110; // 0xffffffffffffff92 float:NaN double:NaN;
        r13.setDownloadInterruptCode(r2);
    L_0x0217:
        r4 = c;
        r2 = 1;
        if (r3 != r2) goto L_0x0297;
    L_0x021c:
        r2 = 1;
    L_0x021d:
        com.tencent.smtt.sdk.QbSdk.reset(r4, r2);
        r2 = "TbsDownload";
        r3 = new java.lang.StringBuilder;
        r4 = "[TbsDownloader.readResponse] return #3,needResetTbs=1,isQuery=";
        r3.<init>(r4);
        r0 = r32;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.smtt.utils.TbsLog.i(r2, r3);
        r2 = 0;
        goto L_0x0035;
    L_0x023b:
        r2 = 0;
        goto L_0x0102;
    L_0x023e:
        r2 = move-exception;
        r3 = "qbsdk";
        r4 = new java.lang.StringBuilder;
        r5 = "throwable:";
        r4.<init>(r5);
        r2 = r2.toString();
        r2 = r4.append(r2);
        r2 = r2.toString();
        com.tencent.smtt.utils.TbsLog.i(r3, r2);
        goto L_0x0105;
    L_0x025b:
        r2 = 0;
        goto L_0x0114;
    L_0x025e:
        r2 = 0;
        goto L_0x013b;
    L_0x0261:
        r2 = move-exception;
        r3 = "qbsdk";
        r4 = new java.lang.StringBuilder;
        r5 = "throwable:";
        r4.<init>(r5);
        r2 = r2.toString();
        r2 = r4.append(r2);
        r2 = r2.toString();
        com.tencent.smtt.utils.TbsLog.i(r3, r2);
        goto L_0x015d;
    L_0x027e:
        r2 = 0;
        goto L_0x018e;
    L_0x0281:
        r2 = 0;
        goto L_0x01b2;
    L_0x0284:
        r2 = move-exception;
        r2 = r5;
        r5 = r2;
        r12 = r3;
        goto L_0x01b3;
    L_0x028a:
        r2 = move-exception;
        r2 = r4;
        goto L_0x01ba;
    L_0x028e:
        r2 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x028e }
        throw r2;
    L_0x0291:
        r2 = -210; // 0xffffffffffffff2e float:NaN double:NaN;
        r13.setDownloadInterruptCode(r2);
        goto L_0x0217;
    L_0x0297:
        r2 = 0;
        goto L_0x021d;
    L_0x0299:
        if (r12 != 0) goto L_0x029e;
    L_0x029b:
        r13.setTbsCoreLoadRenameFileLockEnable(r12);
    L_0x029e:
        r3 = 1;
        if (r2 != r3) goto L_0x02a6;
    L_0x02a1:
        r2 = c;
        com.tencent.smtt.sdk.QbSdk.resetDecoupleCore(r2);
    L_0x02a6:
        r2 = 1;
        if (r7 != r2) goto L_0x02bb;
    L_0x02a9:
        r2 = d;
        r3 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        r2.removeMessages(r3);
        r2 = d;
        r3 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        r2 = android.os.Message.obtain(r2, r3);
        r2.sendToTarget();
    L_0x02bb:
        r4 = 86400; // 0x15180 float:1.21072E-40 double:4.26873E-319;
        r2 = 1;
        r0 = r23;
        if (r0 != r2) goto L_0x0804;
    L_0x02c3:
        r2 = 604800; // 0x93a80 float:8.47505E-40 double:2.98811E-318;
        r2 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x0807;
    L_0x02ca:
        r2 = 604800; // 0x93a80 float:8.47505E-40 double:2.98811E-318;
    L_0x02cd:
        r6 = 0;
        r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r6 <= 0) goto L_0x0804;
    L_0x02d3:
        r4 = getRetryIntervalInSeconds();
        r6 = 0;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 < 0) goto L_0x02e1;
    L_0x02dd:
        r2 = getRetryIntervalInSeconds();
    L_0x02e1:
        r4 = r13.a;
        r5 = "retry_interval";
        r2 = java.lang.Long.valueOf(r2);
        r4.put(r5, r2);
        r2 = 0;
        r3 = 0;
        if (r32 == 0) goto L_0x03ab;
    L_0x02f1:
        r4 = "DECOUPLECOREVERSION";
        r2 = r14.getInt(r4);	 Catch:{ Exception -> 0x07fb }
    L_0x02f8:
        r4 = c;	 Catch:{ Exception -> 0x07f8 }
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);	 Catch:{ Exception -> 0x07f8 }
        r4 = r4.mPreferences;	 Catch:{ Exception -> 0x07f8 }
        r5 = "tbs_downloaddecouplecore";
        r6 = 0;
        r3 = r4.getInt(r5, r6);	 Catch:{ Exception -> 0x07f8 }
    L_0x0308:
        if (r32 == 0) goto L_0x031e;
    L_0x030a:
        r4 = c;
        r4 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r4);
        if (r4 != 0) goto L_0x031e;
    L_0x0312:
        if (r2 != 0) goto L_0x031e;
    L_0x0314:
        r2 = com.tencent.smtt.sdk.an.a();
        r4 = c;
        r2 = r2.h(r4);
    L_0x031e:
        r4 = "TbsDownload";
        r5 = new java.lang.StringBuilder;
        r6 = "in response decoupleCoreVersion is ";
        r5.<init>(r6);
        r5 = r5.append(r2);
        r5 = r5.toString();
        com.tencent.smtt.utils.TbsLog.i(r4, r5);
        r4 = r13.a;
        r5 = "tbs_decouplecoreversion";
        r6 = java.lang.Integer.valueOf(r2);
        r4.put(r5, r6);
        r4 = r13.a;
        r5 = "tbs_downloaddecouplecore";
        r6 = java.lang.Integer.valueOf(r3);
        r4.put(r5, r6);
        r4 = c;
        r4 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r4);
        if (r4 != 0) goto L_0x0377;
    L_0x0354:
        if (r2 <= 0) goto L_0x03bd;
    L_0x0356:
        r4 = com.tencent.smtt.sdk.an.a();
        r5 = c;
        r4 = r4.h(r5);
        if (r2 == r4) goto L_0x03bd;
    L_0x0362:
        r4 = com.tencent.smtt.sdk.an.a();
        r5 = c;
        r4 = r4.i(r5);
        if (r2 != r4) goto L_0x03bd;
    L_0x036e:
        r2 = com.tencent.smtt.sdk.an.a();
        r4 = c;
        r2.n(r4);
    L_0x0377:
        r2 = android.text.TextUtils.isEmpty(r16);
        if (r2 == 0) goto L_0x03cf;
    L_0x037d:
        r2 = c;
        r2 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r2);
        if (r2 == 0) goto L_0x03cf;
    L_0x0385:
        r2 = r13.a;
        r3 = "tbs_needdownload";
        r4 = 0;
        r4 = java.lang.Boolean.valueOf(r4);
        r2.put(r3, r4);
        r13.commit();
        if (r32 == 0) goto L_0x039f;
    L_0x0397:
        r2 = c;
        r3 = 0;
        r0 = r18;
        com.tencent.smtt.sdk.TbsShareManager.writeCoreInfoForThirdPartyApp(r2, r0, r3);
    L_0x039f:
        r2 = "TbsDownload";
        r3 = "[TbsDownloader.readResponse] return #4,current app is third app...";
        com.tencent.smtt.utils.TbsLog.i(r2, r3);
        r2 = 0;
        goto L_0x0035;
    L_0x03ab:
        r4 = c;	 Catch:{ Exception -> 0x07fb }
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r4);	 Catch:{ Exception -> 0x07fb }
        r4 = r4.mPreferences;	 Catch:{ Exception -> 0x07fb }
        r5 = "tbs_decouplecoreversion";
        r6 = 0;
        r2 = r4.getInt(r5, r6);	 Catch:{ Exception -> 0x07fb }
        goto L_0x02f8;
    L_0x03bd:
        if (r2 != 0) goto L_0x0377;
    L_0x03bf:
        r2 = com.tencent.smtt.sdk.an.a();	 Catch:{ Throwable -> 0x03cd }
        r4 = c;	 Catch:{ Throwable -> 0x03cd }
        r2 = r2.p(r4);	 Catch:{ Throwable -> 0x03cd }
        com.tencent.smtt.utils.j.b(r2);	 Catch:{ Throwable -> 0x03cd }
        goto L_0x0377;
    L_0x03cd:
        r2 = move-exception;
        goto L_0x0377;
    L_0x03cf:
        r2 = "TbsDownload";
        r4 = new java.lang.StringBuilder;
        r5 = "in response responseCode is ";
        r4.<init>(r5);
        r4 = r4.append(r15);
        r4 = r4.toString();
        com.tencent.smtt.utils.TbsLog.i(r2, r4);
        if (r15 != 0) goto L_0x043e;
    L_0x03e7:
        r2 = r13.a;
        r3 = "tbs_responsecode";
        r4 = java.lang.Integer.valueOf(r15);
        r2.put(r3, r4);
        r2 = r13.a;
        r3 = "tbs_needdownload";
        r4 = 0;
        r4 = java.lang.Boolean.valueOf(r4);
        r2.put(r3, r4);
        if (r32 == 0) goto L_0x042a;
    L_0x0402:
        r2 = r13.a;
        r3 = "tbs_download_interrupt_code_reason";
        r4 = -111; // 0xffffffffffffff91 float:NaN double:NaN;
        r4 = java.lang.Integer.valueOf(r4);
        r2.put(r3, r4);
    L_0x0410:
        r13.commit();
        r2 = c;
        r2 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r2);
        if (r2 != 0) goto L_0x041e;
    L_0x041b:
        startDecoupleCoreIfNeeded();
    L_0x041e:
        r2 = "TbsDownload";
        r3 = "[TbsDownloader.readResponse] return #5,responseCode=0";
        com.tencent.smtt.utils.TbsLog.i(r2, r3);
        r2 = 0;
        goto L_0x0035;
    L_0x042a:
        r2 = r13.a;
        r3 = "tbs_download_interrupt_code_reason";
        r4 = -211; // 0xffffffffffffff2d float:NaN double:NaN;
        r4 = java.lang.Integer.valueOf(r4);
        r2.put(r3, r4);
        r2 = -211; // 0xffffffffffffff2d float:NaN double:NaN;
        r13.setDownloadInterruptCode(r2);
        goto L_0x0410;
    L_0x043e:
        r2 = c;
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r2);
        r2 = r2.mPreferences;
        r4 = "tbs_download_version";
        r5 = 0;
        r4 = r2.getInt(r4, r5);
        r0 = r18;
        if (r4 <= r0) goto L_0x0460;
    L_0x0452:
        r2 = g;
        r2.d();
        r2 = com.tencent.smtt.sdk.an.a();
        r5 = c;
        r2.o(r5);
    L_0x0460:
        r2 = 0;
        r5 = c;
        r5 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r5);
        if (r5 != 0) goto L_0x049b;
    L_0x0469:
        r5 = com.tencent.smtt.sdk.an.a();
        r6 = c;
        r5 = r5.g(r6);
        r0 = r18;
        if (r5 < r0) goto L_0x0478;
    L_0x0477:
        r2 = 1;
    L_0x0478:
        r6 = "TbsDownload";
        r7 = new java.lang.StringBuilder;
        r8 = "tmpCoreVersion is ";
        r7.<init>(r8);
        r5 = r7.append(r5);
        r7 = " tbsDownloadVersion is";
        r5 = r5.append(r7);
        r0 = r18;
        r5 = r5.append(r0);
        r5 = r5.toString();
        com.tencent.smtt.utils.TbsLog.i(r6, r5);
    L_0x049b:
        r0 = r31;
        r1 = r18;
        if (r0 >= r1) goto L_0x04a9;
    L_0x04a1:
        r5 = android.text.TextUtils.isEmpty(r16);
        if (r5 != 0) goto L_0x04a9;
    L_0x04a7:
        if (r2 == 0) goto L_0x0570;
    L_0x04a9:
        r2 = 1;
        if (r3 == r2) goto L_0x0570;
    L_0x04ac:
        r2 = r13.a;
        r3 = "tbs_needdownload";
        r5 = 0;
        r5 = java.lang.Boolean.valueOf(r5);
        r2.put(r3, r5);
        if (r32 == 0) goto L_0x0547;
    L_0x04bb:
        r2 = android.text.TextUtils.isEmpty(r16);
        if (r2 == 0) goto L_0x0512;
    L_0x04c1:
        r2 = r13.a;
        r3 = "tbs_download_interrupt_code_reason";
        r5 = -124; // 0xffffffffffffff84 float:NaN double:NaN;
        r5 = java.lang.Integer.valueOf(r5);
        r2.put(r3, r5);
    L_0x04cf:
        r13.commit();
        r2 = "TbsDownload";
        r3 = new java.lang.StringBuilder;
        r5 = "version error or downloadUrl empty ,return ahead tbsLocalVersion=";
        r3.<init>(r5);
        r0 = r31;
        r3 = r3.append(r0);
        r5 = " tbsDownloadVersion=";
        r3 = r3.append(r5);
        r0 = r18;
        r3 = r3.append(r0);
        r5 = " tbsLastDownloadVersion=";
        r3 = r3.append(r5);
        r3 = r3.append(r4);
        r4 = " downloadUrl=";
        r3 = r3.append(r4);
        r0 = r16;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.smtt.utils.TbsLog.i(r2, r3);
        r2 = 0;
        goto L_0x0035;
    L_0x0512:
        if (r18 > 0) goto L_0x0523;
    L_0x0514:
        r2 = r13.a;
        r3 = "tbs_download_interrupt_code_reason";
        r5 = -125; // 0xffffffffffffff83 float:NaN double:NaN;
        r5 = java.lang.Integer.valueOf(r5);
        r2.put(r3, r5);
        goto L_0x04cf;
    L_0x0523:
        r0 = r31;
        r1 = r18;
        if (r0 < r1) goto L_0x0538;
    L_0x0529:
        r2 = r13.a;
        r3 = "tbs_download_interrupt_code_reason";
        r5 = -127; // 0xffffffffffffff81 float:NaN double:NaN;
        r5 = java.lang.Integer.valueOf(r5);
        r2.put(r3, r5);
        goto L_0x04cf;
    L_0x0538:
        r2 = r13.a;
        r3 = "tbs_download_interrupt_code_reason";
        r5 = -112; // 0xffffffffffffff90 float:NaN double:NaN;
        r5 = java.lang.Integer.valueOf(r5);
        r2.put(r3, r5);
        goto L_0x04cf;
    L_0x0547:
        r2 = -212; // 0xffffffffffffff2c float:NaN double:NaN;
        r3 = android.text.TextUtils.isEmpty(r16);
        if (r3 == 0) goto L_0x0562;
    L_0x054f:
        r2 = -217; // 0xffffffffffffff27 float:NaN double:NaN;
    L_0x0551:
        r3 = r13.a;
        r5 = "tbs_download_interrupt_code_reason";
        r6 = java.lang.Integer.valueOf(r2);
        r3.put(r5, r6);
        r13.setDownloadInterruptCode(r2);
        goto L_0x04cf;
    L_0x0562:
        if (r18 > 0) goto L_0x0567;
    L_0x0564:
        r2 = -218; // 0xffffffffffffff26 float:NaN double:NaN;
        goto L_0x0551;
    L_0x0567:
        r0 = r31;
        r1 = r18;
        if (r0 < r1) goto L_0x0551;
    L_0x056d:
        r2 = -219; // 0xffffffffffffff25 float:NaN double:NaN;
        goto L_0x0551;
    L_0x0570:
        r2 = r13.mPreferences;
        r4 = "tbs_downloadurl";
        r5 = 0;
        r2 = r2.getString(r4, r5);
        r0 = r16;
        r2 = r0.equals(r2);
        if (r2 != 0) goto L_0x05a1;
    L_0x0582:
        r2 = g;
        r2.d();
        r2 = r13.a;
        r4 = "tbs_download_failed_retrytimes";
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r2.put(r4, r5);
        r2 = r13.a;
        r4 = "tbs_download_success_retrytimes";
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r2.put(r4, r5);
    L_0x05a1:
        r2 = r13.a;
        r4 = "tbs_download_version";
        r5 = java.lang.Integer.valueOf(r18);
        r2.put(r4, r5);
        r2 = "TbsDownload";
        r4 = new java.lang.StringBuilder;
        r5 = "put KEY_TBS_DOWNLOAD_V is ";
        r4.<init>(r5);
        r0 = r18;
        r4 = r4.append(r0);
        r4 = r4.toString();
        com.tencent.smtt.utils.TbsLog.i(r2, r4);
        if (r18 <= 0) goto L_0x05ed;
    L_0x05c7:
        r2 = 1;
        if (r3 != r2) goto L_0x06b6;
    L_0x05ca:
        r2 = r13.a;
        r4 = "tbs_download_version_type";
        r5 = 1;
        r5 = java.lang.Integer.valueOf(r5);
        r2.put(r4, r5);
    L_0x05d7:
        r2 = "TbsDownload";
        r4 = new java.lang.StringBuilder;
        r5 = "put KEY_TBS_DOWNLOAD_V_TYPE is ";
        r4.<init>(r5);
        r3 = r4.append(r3);
        r3 = r3.toString();
        com.tencent.smtt.utils.TbsLog.i(r2, r3);
    L_0x05ed:
        r2 = r13.a;
        r3 = "tbs_downloadurl";
        r0 = r16;
        r2.put(r3, r0);
        r2 = r13.a;
        r3 = "tbs_downloadurl_list";
        r0 = r17;
        r2.put(r3, r0);
        r2 = r13.a;
        r3 = "tbs_responsecode";
        r4 = java.lang.Integer.valueOf(r15);
        r2.put(r3, r4);
        r2 = r13.a;
        r3 = "tbs_download_maxflow";
        r4 = java.lang.Integer.valueOf(r19);
        r2.put(r3, r4);
        r2 = r13.a;
        r3 = "tbs_download_min_free_space";
        r4 = java.lang.Integer.valueOf(r20);
        r2.put(r3, r4);
        r2 = r13.a;
        r3 = "tbs_download_success_max_retrytimes";
        r4 = java.lang.Integer.valueOf(r21);
        r2.put(r3, r4);
        r2 = r13.a;
        r3 = "tbs_download_failed_max_retrytimes";
        r4 = java.lang.Integer.valueOf(r22);
        r2.put(r3, r4);
        r2 = r13.a;
        r3 = "tbs_single_timeout";
        r4 = java.lang.Long.valueOf(r24);
        r2.put(r3, r4);
        r2 = r13.a;
        r3 = "tbs_apkfilesize";
        r4 = java.lang.Long.valueOf(r26);
        r2.put(r3, r4);
        r13.commit();
        if (r9 == 0) goto L_0x0662;
    L_0x065a:
        r2 = r13.a;
        r3 = "tbs_apk_md5";
        r2.put(r3, r9);
    L_0x0662:
        if (r33 != 0) goto L_0x06d9;
    L_0x0664:
        r2 = com.tencent.smtt.sdk.an.a();
        r3 = c;
        r0 = r18;
        r2 = r2.a(r3, r0);
        if (r2 == 0) goto L_0x06d9;
    L_0x0672:
        if (r32 == 0) goto L_0x06c5;
    L_0x0674:
        r2 = r13.a;
        r3 = "tbs_download_interrupt_code_reason";
        r4 = -113; // 0xffffffffffffff8f float:NaN double:NaN;
        r4 = java.lang.Integer.valueOf(r4);
        r2.put(r3, r4);
    L_0x0682:
        r2 = r13.a;
        r3 = "tbs_needdownload";
        r4 = 0;
        r4 = java.lang.Boolean.valueOf(r4);
        r2.put(r3, r4);
        r2 = "TbsDownload";
        r3 = "[TbsDownloader.readResponse] ##6 set needDownload=false";
        com.tencent.smtt.utils.TbsLog.i(r2, r3);
    L_0x0698:
        r2 = "stop_pre_oat";
        r3 = 0;
        r2 = r14.optInt(r2, r3);
        r3 = 1;
        if (r2 != r3) goto L_0x06b0;
    L_0x06a3:
        r2 = r13.a;
        r3 = "tbs_stop_preoat";
        r4 = 1;
        r4 = java.lang.Boolean.valueOf(r4);
        r2.put(r3, r4);
    L_0x06b0:
        r13.commit();
        r2 = 1;
        goto L_0x0035;
    L_0x06b6:
        r2 = r13.a;
        r4 = "tbs_download_version_type";
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r2.put(r4, r5);
        goto L_0x05d7;
    L_0x06c5:
        r2 = r13.a;
        r3 = "tbs_download_interrupt_code_reason";
        r4 = -213; // 0xffffffffffffff2b float:NaN double:NaN;
        r4 = java.lang.Integer.valueOf(r4);
        r2.put(r3, r4);
        r2 = -213; // 0xffffffffffffff2b float:NaN double:NaN;
        r13.setDownloadInterruptCode(r2);
        goto L_0x0682;
    L_0x06d9:
        if (r33 != 0) goto L_0x0756;
    L_0x06db:
        r3 = g;
        r2 = 1;
        if (r15 == r2) goto L_0x06e3;
    L_0x06e0:
        r2 = 2;
        if (r15 != r2) goto L_0x0748;
    L_0x06e3:
        r2 = 1;
    L_0x06e4:
        r0 = r33;
        r2 = r3.a(r0, r2);
        if (r2 == 0) goto L_0x0756;
    L_0x06ec:
        r2 = r13.a;
        r3 = "tbs_needdownload";
        r4 = 0;
        r4 = java.lang.Boolean.valueOf(r4);
        r2.put(r3, r4);
        r2 = c;
        r2 = com.tencent.smtt.sdk.TbsLogReport.a(r2);
        r2 = r2.a();
        r3 = 100;
        r2.setErrorCode(r3);
        r3 = new java.lang.StringBuilder;
        r4 = "use local backup apk in needDownload";
        r3.<init>(r4);
        r4 = g;
        r4 = r4.a;
        r3 = r3.append(r4);
        r3 = r3.toString();
        r2.setFailDetail(r3);
        r3 = c;
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r3);
        r3 = r3.mPreferences;
        r4 = "tbs_downloaddecouplecore";
        r5 = 0;
        r3 = r3.getInt(r4, r5);
        r4 = 1;
        if (r3 != r4) goto L_0x074a;
    L_0x0732:
        r3 = c;
        r3 = com.tencent.smtt.sdk.TbsLogReport.a(r3);
        r4 = com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE;
        r3.a(r4, r2);
    L_0x073d:
        r2 = "TbsDownload";
        r3 = "[TbsDownloader.readResponse] ##7 set needDownload=false";
        com.tencent.smtt.utils.TbsLog.i(r2, r3);
        goto L_0x0698;
    L_0x0748:
        r2 = 0;
        goto L_0x06e4;
    L_0x074a:
        r3 = c;
        r3 = com.tencent.smtt.sdk.TbsLogReport.a(r3);
        r4 = com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_DOWNLOAD;
        r3.a(r4, r2);
        goto L_0x073d;
    L_0x0756:
        r2 = c;
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r2);
        r2 = r2.mPreferences;
        r3 = "tbs_download_version_type";
        r4 = 0;
        r2 = r2.getInt(r3, r4);
        r3 = 1;
        if (r2 != r3) goto L_0x07d9;
    L_0x0769:
        r2 = g;
        r2 = r2.a();
        if (r2 == 0) goto L_0x07d9;
    L_0x0771:
        r2 = r13.a;
        r3 = "tbs_needdownload";
        r4 = 0;
        r4 = java.lang.Boolean.valueOf(r4);
        r2.put(r3, r4);
        r2 = c;
        r2 = com.tencent.smtt.sdk.TbsLogReport.a(r2);
        r2 = r2.a();
        r3 = 100;
        r2.setErrorCode(r3);
        r3 = new java.lang.StringBuilder;
        r4 = "installDecoupleCoreFromBackup";
        r3.<init>(r4);
        r4 = g;
        r4 = r4.a;
        r3 = r3.append(r4);
        r3 = r3.toString();
        r2.setFailDetail(r3);
        r3 = c;
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r3);
        r3 = r3.mPreferences;
        r4 = "tbs_downloaddecouplecore";
        r5 = 0;
        r3 = r3.getInt(r4, r5);
        r4 = 1;
        if (r3 != r4) goto L_0x07cd;
    L_0x07b7:
        r3 = c;
        r3 = com.tencent.smtt.sdk.TbsLogReport.a(r3);
        r4 = com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE;
        r3.a(r4, r2);
    L_0x07c2:
        r2 = "TbsDownload";
        r3 = "[TbsDownloader.readResponse] ##8 set needDownload=false";
        com.tencent.smtt.utils.TbsLog.i(r2, r3);
        goto L_0x0698;
    L_0x07cd:
        r3 = c;
        r3 = com.tencent.smtt.sdk.TbsLogReport.a(r3);
        r4 = com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_DOWNLOAD;
        r3.a(r4, r2);
        goto L_0x07c2;
    L_0x07d9:
        if (r32 != 0) goto L_0x07e0;
    L_0x07db:
        r2 = -216; // 0xffffffffffffff28 float:NaN double:NaN;
        r13.setDownloadInterruptCode(r2);
    L_0x07e0:
        r2 = r13.a;
        r3 = "tbs_needdownload";
        r4 = 1;
        r4 = java.lang.Boolean.valueOf(r4);
        r2.put(r3, r4);
        r2 = "TbsDownload";
        r3 = "[TbsDownloader.readResponse] ##9 set needDownload=true";
        com.tencent.smtt.utils.TbsLog.i(r2, r3);
        goto L_0x0698;
    L_0x07f8:
        r4 = move-exception;
        goto L_0x0308;
    L_0x07fb:
        r4 = move-exception;
        goto L_0x02f8;
    L_0x07fe:
        r4 = move-exception;
        goto L_0x01c2;
    L_0x0801:
        r3 = move-exception;
        goto L_0x00d3;
    L_0x0804:
        r2 = r4;
        goto L_0x02d3;
    L_0x0807:
        r2 = r10;
        goto L_0x02cd;
    L_0x080a:
        r2 = r3;
        goto L_0x01b2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloader.a(java.lang.String, int, boolean, boolean):boolean");
    }

    protected static File b(int i) {
        File file = null;
        for (String str : TbsShareManager.getCoreProviderAppList()) {
            File file2 = new File(j.a(c, str, 4, false), getOverSea(c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            if (file2.exists() && a.a(c, file2) == i) {
                TbsLog.i(LOGTAG, "local tbs version fond,path = " + file2.getAbsolutePath());
                return file2;
            }
            file = new File(j.a(c, str, 4, false), "x5.tbs.decouple");
            if (file.exists() && a.a(c, file) == i) {
                TbsLog.i(LOGTAG, "local tbs version fond,path = " + file.getAbsolutePath());
                return file;
            }
        }
        return file;
    }

    private static JSONObject b(boolean z, boolean z2, boolean z3) {
        Object obj;
        Object simCountryIso;
        JSONObject jSONObject;
        int m;
        int i;
        boolean z4;
        boolean booleanValue;
        Object obj2 = null;
        TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData]isQuery: " + z + " forDecoupleCore is " + z3);
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(c);
        String a = a(c);
        String d = b.d(c);
        String c = b.c(c);
        String f = b.f(c);
        String str = "";
        String str2 = "";
        String id = TimeZone.getDefault().getID();
        if (id != null) {
            obj = id;
        } else {
            String obj3 = str;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) c.getSystemService("phone");
            if (telephonyManager != null) {
                simCountryIso = telephonyManager.getSimCountryIso();
                if (simCountryIso == null) {
                    str = str2;
                }
                jSONObject = new JSONObject();
                jSONObject.put("TIMEZONEID", obj3);
                jSONObject.put("COUNTRYISO", simCountryIso);
                jSONObject.put("PROTOCOLVERSION", 1);
                if (TbsShareManager.isThirdPartyApp(c)) {
                    m = an.a().m(c);
                    if (m == 0 && an.a().l(c)) {
                        m = -1;
                    }
                    TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData] tbsLocalVersion=" + m + " isDownloadForeground=" + z2);
                    if (!z2) {
                        i = m;
                        if (z) {
                            jSONObject.put("FUNCTION", 2);
                        } else {
                            jSONObject.put("FUNCTION", i == 0 ? 0 : 1);
                        }
                        JSONArray e;
                        if (TbsShareManager.isThirdPartyApp(c)) {
                            e = e();
                            jSONObject.put("TBSVLARR", e);
                            instance.a.put("last_thirdapp_sendrequest_coreversion", e.toString());
                            instance.commit();
                            if (QbSdk.c) {
                                jSONObject.put("THIRDREQ", 1);
                            }
                        } else {
                            e = g();
                            if (Apn.getApnType(c) != 3 && e.length() != 0 && i == 0 && z) {
                                jSONObject.put("TBSBACKUPARR", e);
                            }
                        }
                        jSONObject.put("APPN", c.getPackageName());
                        jSONObject.put("APPVN", a(instance.mPreferences.getString("app_versionname", null)));
                        jSONObject.put("APPVC", instance.mPreferences.getInt("app_versioncode", 0));
                        jSONObject.put("APPMETA", a(instance.mPreferences.getString("app_metadata", null)));
                        jSONObject.put("TBSSDKV", 43610);
                        jSONObject.put("TBSV", i);
                        jSONObject.put("DOWNLOADDECOUPLECORE", z3 ? 1 : 0);
                        instance.a.put("tbs_downloaddecouplecore", Integer.valueOf(z3 ? 1 : 0));
                        instance.commit();
                        if (i != 0) {
                            jSONObject.put("TBSBACKUPV", g.b());
                        }
                        jSONObject.put("CPU", e);
                        jSONObject.put("UA", a);
                        jSONObject.put("IMSI", a(d));
                        jSONObject.put("IMEI", a(c));
                        jSONObject.put("ANDROID_ID", a(f));
                        if (!TbsShareManager.isThirdPartyApp(c)) {
                            if (i != 0) {
                                jSONObject.put("STATUS", QbSdk.a(c, i) ? 0 : 1);
                            } else {
                                jSONObject.put("STATUS", 0);
                            }
                            jSONObject.put("TBSDV", an.a().h(c));
                        }
                        z4 = TbsDownloadConfig.getInstance(c).mPreferences.getBoolean("request_full_package", false);
                        simCountryIso = QbSdk.a(c, "can_unlzma", null);
                        booleanValue = (simCountryIso == null && (simCountryIso instanceof Boolean)) ? ((Boolean) simCountryIso).booleanValue() : false;
                        if (booleanValue && !z4) {
                            obj2 = 1;
                        }
                        if (obj2 != null) {
                            jSONObject.put("REQUEST_LZMA", 1);
                        }
                        if (getOverSea(c)) {
                            jSONObject.put("OVERSEA", 1);
                        }
                        if (z2) {
                            jSONObject.put("DOWNLOAD_FOREGROUND", 1);
                        }
                        TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
                        return jSONObject;
                    } else if (!an.a().l(c)) {
                        m = 0;
                    }
                } else {
                    m = QbSdk.c ? TbsShareManager.a(c, false) : TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0);
                }
                i = m;
                if (z) {
                    jSONObject.put("FUNCTION", i == 0 ? 0 : 1);
                } else {
                    jSONObject.put("FUNCTION", 2);
                }
                if (TbsShareManager.isThirdPartyApp(c)) {
                    e = g();
                    if (Apn.getApnType(c) != 3 && e.length() != 0 && i == 0 && z) {
                        jSONObject.put("TBSBACKUPARR", e);
                    }
                } else {
                    e = e();
                    jSONObject.put("TBSVLARR", e);
                    instance.a.put("last_thirdapp_sendrequest_coreversion", e.toString());
                    instance.commit();
                    if (QbSdk.c) {
                        jSONObject.put("THIRDREQ", 1);
                    }
                }
                jSONObject.put("APPN", c.getPackageName());
                jSONObject.put("APPVN", a(instance.mPreferences.getString("app_versionname", null)));
                jSONObject.put("APPVC", instance.mPreferences.getInt("app_versioncode", 0));
                jSONObject.put("APPMETA", a(instance.mPreferences.getString("app_metadata", null)));
                jSONObject.put("TBSSDKV", 43610);
                jSONObject.put("TBSV", i);
                if (z3) {
                }
                jSONObject.put("DOWNLOADDECOUPLECORE", z3 ? 1 : 0);
                if (z3) {
                }
                instance.a.put("tbs_downloaddecouplecore", Integer.valueOf(z3 ? 1 : 0));
                instance.commit();
                if (i != 0) {
                    jSONObject.put("TBSBACKUPV", g.b());
                }
                jSONObject.put("CPU", e);
                jSONObject.put("UA", a);
                jSONObject.put("IMSI", a(d));
                jSONObject.put("IMEI", a(c));
                jSONObject.put("ANDROID_ID", a(f));
                if (TbsShareManager.isThirdPartyApp(c)) {
                    if (i != 0) {
                        jSONObject.put("STATUS", QbSdk.a(c, i) ? 0 : 1);
                    } else {
                        jSONObject.put("STATUS", 0);
                    }
                    jSONObject.put("TBSDV", an.a().h(c));
                }
                z4 = TbsDownloadConfig.getInstance(c).mPreferences.getBoolean("request_full_package", false);
                simCountryIso = QbSdk.a(c, "can_unlzma", null);
                if (simCountryIso == null) {
                }
                obj2 = 1;
                if (obj2 != null) {
                    jSONObject.put("REQUEST_LZMA", 1);
                }
                if (getOverSea(c)) {
                    jSONObject.put("OVERSEA", 1);
                }
                if (z2) {
                    jSONObject.put("DOWNLOAD_FOREGROUND", 1);
                }
                TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
                return jSONObject;
            }
        } catch (Exception e2) {
        }
        str = id;
        if (simCountryIso == null) {
            str = str2;
        }
        jSONObject = new JSONObject();
        try {
            jSONObject.put("TIMEZONEID", obj3);
            jSONObject.put("COUNTRYISO", simCountryIso);
            jSONObject.put("PROTOCOLVERSION", 1);
            if (TbsShareManager.isThirdPartyApp(c)) {
                m = an.a().m(c);
                if (m == 0 && an.a().l(c)) {
                    m = -1;
                }
                TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData] tbsLocalVersion=" + m + " isDownloadForeground=" + z2);
                if (!z2) {
                    i = m;
                    if (z) {
                        jSONObject.put("FUNCTION", 2);
                    } else {
                        jSONObject.put("FUNCTION", i == 0 ? 0 : 1);
                    }
                    JSONArray e3;
                    if (TbsShareManager.isThirdPartyApp(c)) {
                        e3 = e();
                        jSONObject.put("TBSVLARR", e3);
                        instance.a.put("last_thirdapp_sendrequest_coreversion", e3.toString());
                        instance.commit();
                        if (QbSdk.c) {
                            jSONObject.put("THIRDREQ", 1);
                        }
                    } else {
                        e3 = g();
                        if (Apn.getApnType(c) != 3 && e3.length() != 0 && i == 0 && z) {
                            jSONObject.put("TBSBACKUPARR", e3);
                        }
                    }
                    jSONObject.put("APPN", c.getPackageName());
                    jSONObject.put("APPVN", a(instance.mPreferences.getString("app_versionname", null)));
                    jSONObject.put("APPVC", instance.mPreferences.getInt("app_versioncode", 0));
                    jSONObject.put("APPMETA", a(instance.mPreferences.getString("app_metadata", null)));
                    jSONObject.put("TBSSDKV", 43610);
                    jSONObject.put("TBSV", i);
                    jSONObject.put("DOWNLOADDECOUPLECORE", z3 ? 1 : 0);
                    instance.a.put("tbs_downloaddecouplecore", Integer.valueOf(z3 ? 1 : 0));
                    instance.commit();
                    if (i != 0) {
                        jSONObject.put("TBSBACKUPV", g.b());
                    }
                    jSONObject.put("CPU", e);
                    jSONObject.put("UA", a);
                    jSONObject.put("IMSI", a(d));
                    jSONObject.put("IMEI", a(c));
                    jSONObject.put("ANDROID_ID", a(f));
                    if (!TbsShareManager.isThirdPartyApp(c)) {
                        if (i != 0) {
                            jSONObject.put("STATUS", QbSdk.a(c, i) ? 0 : 1);
                        } else {
                            jSONObject.put("STATUS", 0);
                        }
                        jSONObject.put("TBSDV", an.a().h(c));
                    }
                    z4 = TbsDownloadConfig.getInstance(c).mPreferences.getBoolean("request_full_package", false);
                    simCountryIso = QbSdk.a(c, "can_unlzma", null);
                    booleanValue = (simCountryIso == null && (simCountryIso instanceof Boolean)) ? ((Boolean) simCountryIso).booleanValue() : false;
                    if (booleanValue && !z4) {
                        obj2 = 1;
                    }
                    if (obj2 != null) {
                        jSONObject.put("REQUEST_LZMA", 1);
                    }
                    if (getOverSea(c)) {
                        jSONObject.put("OVERSEA", 1);
                    }
                    if (z2) {
                        jSONObject.put("DOWNLOAD_FOREGROUND", 1);
                    }
                    TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
                    return jSONObject;
                } else if (!an.a().l(c)) {
                    m = 0;
                }
            } else {
                m = QbSdk.c ? TbsShareManager.a(c, false) : TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0);
            }
            i = m;
            if (z) {
                jSONObject.put("FUNCTION", 2);
            } else {
                jSONObject.put("FUNCTION", i == 0 ? 0 : 1);
            }
            if (TbsShareManager.isThirdPartyApp(c)) {
                e3 = e();
                jSONObject.put("TBSVLARR", e3);
                instance.a.put("last_thirdapp_sendrequest_coreversion", e3.toString());
                instance.commit();
                if (QbSdk.c) {
                    jSONObject.put("THIRDREQ", 1);
                }
            } else {
                e3 = g();
                if (Apn.getApnType(c) != 3 && e3.length() != 0 && i == 0 && z) {
                    jSONObject.put("TBSBACKUPARR", e3);
                }
            }
            jSONObject.put("APPN", c.getPackageName());
            jSONObject.put("APPVN", a(instance.mPreferences.getString("app_versionname", null)));
            jSONObject.put("APPVC", instance.mPreferences.getInt("app_versioncode", 0));
            jSONObject.put("APPMETA", a(instance.mPreferences.getString("app_metadata", null)));
            jSONObject.put("TBSSDKV", 43610);
            jSONObject.put("TBSV", i);
            if (z3) {
            }
            jSONObject.put("DOWNLOADDECOUPLECORE", z3 ? 1 : 0);
            if (z3) {
            }
            instance.a.put("tbs_downloaddecouplecore", Integer.valueOf(z3 ? 1 : 0));
            instance.commit();
            if (i != 0) {
                jSONObject.put("TBSBACKUPV", g.b());
            }
            jSONObject.put("CPU", e);
            jSONObject.put("UA", a);
            jSONObject.put("IMSI", a(d));
            jSONObject.put("IMEI", a(c));
            jSONObject.put("ANDROID_ID", a(f));
            if (TbsShareManager.isThirdPartyApp(c)) {
                if (i != 0) {
                    jSONObject.put("STATUS", QbSdk.a(c, i) ? 0 : 1);
                } else {
                    jSONObject.put("STATUS", 0);
                }
                jSONObject.put("TBSDV", an.a().h(c));
            }
            z4 = TbsDownloadConfig.getInstance(c).mPreferences.getBoolean("request_full_package", false);
            simCountryIso = QbSdk.a(c, "can_unlzma", null);
            if (simCountryIso == null) {
            }
            obj2 = 1;
            if (obj2 != null) {
                jSONObject.put("REQUEST_LZMA", 1);
            }
            if (getOverSea(c)) {
                jSONObject.put("OVERSEA", 1);
            }
            if (z2) {
                jSONObject.put("DOWNLOAD_FOREGROUND", 1);
            }
        } catch (Exception e4) {
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
        return jSONObject;
    }

    @TargetApi(11)
    static void b(Context context) {
        TbsDownloadConfig.getInstance(context).clear();
        TbsLogReport.a(context).d();
        ag.c(context);
        (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_extension_config", 4) : context.getSharedPreferences("tbs_extension_config", 0)).edit().clear().commit();
        (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit().clear().commit();
    }

    private static boolean b(boolean z, boolean z2) {
        return c(z, z2, false);
    }

    private static synchronized void c() {
        synchronized (TbsDownloader.class) {
            if (h == null) {
                h = al.a();
                try {
                    g = new ag(c);
                    d = new aj(h.getLooper());
                } catch (Exception e) {
                    i = true;
                    TbsLog.e(LOGTAG, "TbsApkDownloader init has Exception");
                }
            }
        }
        return;
    }

    private static boolean c(boolean z, boolean z2, boolean z3) {
        if (QbSdk.n != null && QbSdk.n.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.n.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
            return false;
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest]isQuery: " + z + " forDecoupleCore is " + z3);
        if (an.a().c(c)) {
            TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!");
            return false;
        }
        int i;
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(c);
        File file = new File(j.a(c, 1), getOverSea(c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        File file2 = new File(j.a(c, 2), getOverSea(c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        File file3 = new File(j.a(c, 3), getOverSea(c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        File file4 = new File(j.a(c, 4), getOverSea(c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        if (!file4.exists()) {
            if (file3.exists()) {
                file3.renameTo(file4);
            } else if (file2.exists()) {
                file2.renameTo(file4);
            } else if (file.exists()) {
                file.renameTo(file4);
            }
        }
        if (e == null) {
            e = b.a();
            instance.a.put("device_cpuabi", e);
            instance.commit();
        }
        Object obj = null;
        if (!TextUtils.isEmpty(e)) {
            Matcher matcher = null;
            try {
                matcher = Pattern.compile("i686|mips|x86_64").matcher(e);
            } catch (Exception e) {
            }
            if (matcher != null && matcher.find()) {
                if (TbsShareManager.isThirdPartyApp(c)) {
                    TbsLogInfo a = TbsLogReport.a(c).a();
                    if (z) {
                        instance.setDownloadInterruptCode(-104);
                        a.setErrorCode(-104);
                    } else {
                        instance.setDownloadInterruptCode(-205);
                        a.setErrorCode(-205);
                    }
                    a.setFailDetail("mycpu is " + e);
                    TbsLogReport.a(c).a(EventType.TYPE_DOWNLOAD, a);
                } else if (z) {
                    instance.setDownloadInterruptCode(-104);
                } else {
                    instance.setDownloadInterruptCode(-205);
                }
                obj = 1;
            }
        }
        JSONObject b = b(z, z2, z3);
        int i2 = -1;
        try {
            i = b.getInt("TBSV");
        } catch (Exception e2) {
            i = i2;
        }
        if (!(obj == null && i == -1)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (TbsShareManager.isThirdPartyApp(c)) {
                instance.a.put("count_request_fail_in_24hours", Long.valueOf(currentTimeMillis - instance.mPreferences.getLong("request_fail", 0) < instance.getRetryInterval() * 1000 ? 1 + instance.mPreferences.getLong("count_request_fail_in_24hours", 0) : 1));
            }
            instance.a.put("last_check", Long.valueOf(currentTimeMillis));
            instance.a.put("request_fail", Long.valueOf(currentTimeMillis));
            instance.a.put("app_versionname", b.a(c));
            instance.a.put("app_versioncode", Integer.valueOf(b.b(c)));
            instance.a.put("app_metadata", b.a(c, "com.tencent.mm.BuildInfo.CLIENT_VERSION"));
            instance.commit();
            if (obj != null) {
                return false;
            }
        }
        if (i != -1) {
            try {
                String d = s.a(c).d();
                TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest] postUrl=" + d);
                return a(m.a(d, b.toString().getBytes("utf-8"), new ak(instance, z), false), i, z, z2);
            } catch (Throwable th) {
                if (z) {
                    instance.setDownloadInterruptCode(-106);
                    return false;
                }
                instance.setDownloadInterruptCode(-206);
            }
        }
        return false;
    }

    private static boolean d() {
        try {
            return TbsDownloadConfig.getInstance(c).mPreferences.getString("last_thirdapp_sendrequest_coreversion", "").equals(e().toString());
        } catch (Exception e) {
            return false;
        }
    }

    private static JSONArray e() {
        int i = 0;
        if (!TbsShareManager.isThirdPartyApp(c)) {
            return null;
        }
        int length;
        int i2;
        JSONArray jSONArray = new JSONArray();
        String[] strArr;
        if (QbSdk.getOnlyDownload()) {
            strArr = new String[]{c.getApplicationContext().getPackageName()};
        } else {
            Object coreProviderAppList = TbsShareManager.getCoreProviderAppList();
            String packageName = c.getApplicationContext().getPackageName();
            if (packageName.equals(TbsShareManager.f(c))) {
                length = coreProviderAppList.length;
                strArr = new String[(length + 1)];
                System.arraycopy(coreProviderAppList, 0, strArr, 0, length);
                strArr[length] = packageName;
            } else {
                Object strArr2 = coreProviderAppList;
            }
        }
        for (String str : strArr2) {
            int sharedTbsCoreVersion = TbsShareManager.getSharedTbsCoreVersion(c, str);
            if (sharedTbsCoreVersion > 0) {
                Context a = TbsShareManager.a(c, str);
                if (a == null || an.a().f(a)) {
                    for (i2 = 0; i2 < jSONArray.length(); i2++) {
                        if (jSONArray.optInt(i2) == sharedTbsCoreVersion) {
                            i2 = 1;
                            break;
                        }
                    }
                    i2 = 0;
                    if (i2 == 0) {
                        jSONArray.put(sharedTbsCoreVersion);
                    }
                } else {
                    TbsLog.e(LOGTAG, "host check failed,packageName = " + str);
                }
            }
        }
        if (TbsShareManager.getHostCorePathAppDefined() == null) {
            return jSONArray;
        }
        i2 = an.a().a(TbsShareManager.getHostCorePathAppDefined());
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            if (jSONArray.optInt(i3) == i2) {
                i = 1;
                break;
            }
        }
        if (i == 0) {
            jSONArray.put(i2);
        }
        return jSONArray;
    }

    private static boolean f() {
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(c);
        if (instance.mPreferences.getInt("tbs_download_success_retrytimes", 0) >= instance.getDownloadSuccessMaxRetrytimes()) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] out of success retrytimes", true);
            instance.setDownloadInterruptCode(-115);
            return false;
        } else if (instance.mPreferences.getInt("tbs_download_failed_retrytimes", 0) >= instance.getDownloadFailedMaxRetrytimes()) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
            instance.setDownloadInterruptCode(-116);
            return false;
        } else if (j.b(c)) {
            if (System.currentTimeMillis() - instance.mPreferences.getLong("tbs_downloadstarttime", 0) <= 86400000) {
                long j = instance.mPreferences.getLong("tbs_downloadflow", 0);
                TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] downloadFlow=" + j);
                if (j >= instance.getDownloadMaxflow()) {
                    TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
                    instance.setDownloadInterruptCode(-120);
                    return false;
                }
            }
            return true;
        } else {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] local rom freespace limit", true);
            instance.setDownloadInterruptCode(-117);
            return false;
        }
    }

    private static JSONArray g() {
        JSONArray jSONArray = new JSONArray();
        for (String a : TbsShareManager.getCoreProviderAppList()) {
            File file = new File(j.a(c, a, 4, false), getOverSea(c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            if (file.exists()) {
                long a2 = (long) a.a(c, file);
                if (a2 > 0) {
                    boolean z;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (((long) jSONArray.optInt(i)) == a2) {
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    if (!z) {
                        jSONArray.put(a2);
                    }
                }
            }
        }
        return jSONArray;
    }

    public static int getCoreShareDecoupleCoreVersion() {
        return an.a().h(c);
    }

    public static int getCoreShareDecoupleCoreVersionByContext(Context context) {
        return an.a().h(context);
    }

    public static synchronized boolean getOverSea(Context context) {
        boolean z;
        synchronized (TbsDownloader.class) {
            if (!k) {
                k = true;
                TbsDownloadConfig instance = TbsDownloadConfig.getInstance(context);
                if (instance.mPreferences.contains("is_oversea")) {
                    j = instance.mPreferences.getBoolean("is_oversea", false);
                    TbsLog.i(LOGTAG, "[TbsDownloader.getOverSea]  first called. sOverSea = " + j);
                }
                TbsLog.i(LOGTAG, "[TbsDownloader.getOverSea]  sOverSea = " + j);
            }
            z = j;
        }
        return z;
    }

    public static long getRetryIntervalInSeconds() {
        return l;
    }

    public static HandlerThread getsTbsHandlerThread() {
        return h;
    }

    public static boolean isDownloadForeground() {
        return g != null && g.e();
    }

    public static synchronized boolean isDownloading() {
        boolean z;
        synchronized (TbsDownloader.class) {
            TbsLog.i(LOGTAG, "[TbsDownloader.isDownloading] is " + a);
            z = a;
        }
        return z;
    }

    public static boolean needDownload(Context context, boolean z) {
        return needDownload(context, z, false, null);
    }

    public static boolean needDownload(Context context, boolean z, boolean z2, TbsDownloaderCallback tbsDownloaderCallback) {
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] oversea=" + z + ",isDownloadForeground=" + z2);
        TbsLog.initIfNeed(context);
        if (an.b) {
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#1,return false");
            return false;
        }
        TbsLog.app_extra(LOGTAG, context);
        Context applicationContext = context.getApplicationContext();
        c = applicationContext;
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(applicationContext);
        instance.setDownloadInterruptCode(-100);
        if (a(c, z, tbsDownloaderCallback)) {
            c();
            if (i) {
                if (tbsDownloaderCallback != null) {
                    tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
                }
                instance.setDownloadInterruptCode(-105);
                TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#3,return false");
                return false;
            }
            boolean contains;
            boolean z3;
            boolean a = a(c, z2, false);
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload],needSendRequest=" + a);
            if (a) {
                a(z2, tbsDownloaderCallback);
                instance.setDownloadInterruptCode(-114);
            }
            d.removeMessages(102);
            Message.obtain(d, 102).sendToTarget();
            if (QbSdk.c || !TbsShareManager.isThirdPartyApp(context)) {
                contains = instance.mPreferences.contains("tbs_needdownload");
                TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] hasNeedDownloadKey=" + contains);
                z3 = (contains || TbsShareManager.isThirdPartyApp(context)) ? instance.mPreferences.getBoolean("tbs_needdownload", false) : true;
            } else {
                z3 = false;
                contains = false;
            }
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#4,needDownload=" + z3 + ",hasNeedDownloadKey=" + contains);
            if (!z3) {
                int m = an.a().m(c);
                TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#7,tbsLocalVersion=" + m + ",needSendRequest=" + a);
                if (a || m <= 0) {
                    d.removeMessages(103);
                    if (m > 0 || a) {
                        Message.obtain(d, 103, 1, 0, c).sendToTarget();
                    } else {
                        Message.obtain(d, 103, 0, 0, c).sendToTarget();
                    }
                    instance.setDownloadInterruptCode(-121);
                } else {
                    instance.setDownloadInterruptCode(-119);
                }
            } else if (f()) {
                instance.setDownloadInterruptCode(-118);
                TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#6");
            } else {
                TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#5,set needDownload = false");
                z3 = false;
            }
            if (!(a || tbsDownloaderCallback == null)) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] needDownload=" + z3);
            return z3;
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#2,return false");
        return false;
    }

    public static boolean needDownloadDecoupleCore() {
        if (TbsShareManager.isThirdPartyApp(c) || TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1) {
            return false;
        }
        if (System.currentTimeMillis() - TbsDownloadConfig.getInstance(c).mPreferences.getLong("last_download_decouple_core", 0) < 1000 * TbsDownloadConfig.getInstance(c).getRetryInterval()) {
            return false;
        }
        int i = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_decouplecoreversion", 0);
        return (i <= 0 || i == an.a().h(c) || TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) == i) ? false : true;
    }

    public static boolean needSendRequest(Context context, boolean z) {
        boolean z2 = true;
        c = context.getApplicationContext();
        TbsLog.initIfNeed(context);
        if (!a(c, z, null)) {
            return false;
        }
        int m = an.a().m(context);
        TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] localTbsVersion=" + m);
        if (m > 0) {
            return false;
        }
        if (a(c, false, true)) {
            return true;
        }
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(c);
        boolean contains = instance.mPreferences.contains("tbs_needdownload");
        TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] hasNeedDownloadKey=" + contains);
        boolean z3 = !contains ? true : instance.mPreferences.getBoolean("tbs_needdownload", false);
        TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] needDownload=" + z3);
        if (!(z3 && f())) {
            z2 = false;
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] ret=" + z2);
        return z2;
    }

    public static void setRetryIntervalInSeconds(Context context, long j) {
        if (context != null) {
            if (context.getApplicationInfo().packageName.equals("com.tencent.qqlive")) {
                l = j;
            }
            TbsLog.i(LOGTAG, "mRetryIntervalInSeconds is " + l);
        }
    }

    public static boolean startDecoupleCoreIfNeeded() {
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded ");
        if (TbsShareManager.isThirdPartyApp(c)) {
            return false;
        }
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #1");
        if (TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1) {
            return false;
        }
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #2");
        long j = TbsDownloadConfig.getInstance(c).mPreferences.getLong("last_download_decouple_core", 0);
        if (System.currentTimeMillis() - j < 1000 * TbsDownloadConfig.getInstance(c).getRetryInterval()) {
            return false;
        }
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #3");
        int i = TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_decouplecoreversion", 0);
        if (i <= 0 || i == an.a().h(c)) {
            TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded no need, deCoupleCoreVersion is " + i + " getTbsCoreShareDecoupleCoreVersion is " + an.a().h(c));
            return false;
        } else if (TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) != i || TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version_type", 0) == 1) {
            TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #4");
            a = true;
            d.removeMessages(108);
            Message obtain = Message.obtain(d, 108, QbSdk.m);
            obtain.arg1 = 0;
            obtain.sendToTarget();
            TbsDownloadConfig.getInstance(c).a.put("last_download_decouple_core", Long.valueOf(System.currentTimeMillis()));
            return true;
        } else {
            TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded no need, KEY_TBS_DOWNLOAD_V is " + TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version", 0) + " deCoupleCoreVersion is " + i + " KEY_TBS_DOWNLOAD_V_TYPE is " + TbsDownloadConfig.getInstance(c).mPreferences.getInt("tbs_download_version_type", 0));
            return false;
        }
    }

    public static void startDownload(Context context) {
        startDownload(context, false);
    }

    public static synchronized void startDownload(Context context, boolean z) {
        int i = 1;
        synchronized (TbsDownloader.class) {
            TbsLog.i(LOGTAG, "[TbsDownloader.startDownload] sAppContext=" + c);
            if (!an.b) {
                a = true;
                Context applicationContext = context.getApplicationContext();
                c = applicationContext;
                TbsDownloadConfig.getInstance(applicationContext).setDownloadInterruptCode(-200);
                if (VERSION.SDK_INT < 8) {
                    QbSdk.m.onDownloadFinish(110);
                    TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(-201);
                } else {
                    c();
                    if (i) {
                        QbSdk.m.onDownloadFinish(TbsListener$ErrorCode.THREAD_INIT_ERROR);
                        TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(-202);
                    } else {
                        if (z) {
                            stopDownload();
                        }
                        d.removeMessages(101);
                        d.removeMessages(100);
                        Message obtain = Message.obtain(d, 101, QbSdk.m);
                        if (!z) {
                            i = 0;
                        }
                        obtain.arg1 = i;
                        obtain.sendToTarget();
                    }
                }
            }
        }
    }

    public static void stopDownload() {
        if (!i) {
            TbsLog.i(LOGTAG, "[TbsDownloader.stopDownload]");
            if (g != null) {
                g.c();
            }
            if (d != null) {
                d.removeMessages(100);
                d.removeMessages(101);
                d.removeMessages(108);
            }
        }
    }
}
