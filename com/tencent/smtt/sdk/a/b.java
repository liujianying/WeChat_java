package com.tencent.smtt.sdk.a;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.TbsCoreLoadStat;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.o;
import com.tencent.smtt.utils.r;
import com.tencent.smtt.utils.s;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import org.json.JSONObject;

public class b {
    public static byte[] a;

    static {
        a = null;
        try {
            a = "65dRa93L".getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
        }
    }

    private static String a(Context context) {
        try {
            byte[] toByteArray = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
            if (toByteArray == null) {
                return null;
            }
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(toByteArray);
            toByteArray = instance.digest();
            if (toByteArray == null) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder("");
            if (toByteArray == null || toByteArray.length <= 0) {
                return null;
            }
            for (int i = 0; i < toByteArray.length; i++) {
                String toUpperCase = Integer.toHexString(toByteArray[i] & 255).toUpperCase();
                if (i > 0) {
                    stringBuilder.append(":");
                }
                if (toUpperCase.length() < 2) {
                    stringBuilder.append(0);
                }
                stringBuilder.append(toUpperCase);
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static void a(ThirdAppInfoNew thirdAppInfoNew, Context context) {
        new c("HttpUtils", context, thirdAppInfoNew).start();
    }

    public static void a(Context context, String str, String str2, String str3, int i, boolean z, long j) {
        if (QbSdk.getSettings() != null && QbSdk.getSettings().containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.getSettings().get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.i("sdkreport", "[HttpUtils.doReport] -- SET_SENDREQUEST_AND_UPLOAD is false");
            return;
        }
        String str4;
        int i2;
        ThirdAppInfoNew thirdAppInfoNew;
        String str5 = "";
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (TbsConfig.APP_QQ.equals(applicationInfo.packageName)) {
                str5 = context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0).versionName;
                if (!TextUtils.isEmpty(QbSdk.getQQBuildNumber())) {
                    str5 = str5 + "." + QbSdk.getQQBuildNumber();
                }
            }
            str4 = str5;
        } catch (Exception e) {
            str4 = str5;
        } catch (Throwable th) {
            return;
        }
        ThirdAppInfoNew thirdAppInfoNew2 = new ThirdAppInfoNew();
        thirdAppInfoNew2.sAppName = context.getApplicationContext().getApplicationInfo().packageName;
        s.a(context);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
        thirdAppInfoNew2.sTime = simpleDateFormat.format(Calendar.getInstance().getTime());
        thirdAppInfoNew2.sGuid = str;
        if (z) {
            thirdAppInfoNew2.sQua2 = str2;
        } else {
            thirdAppInfoNew2.sQua2 = r.a(context);
        }
        thirdAppInfoNew2.sLc = str3;
        str5 = com.tencent.smtt.utils.b.e(context);
        String c = com.tencent.smtt.utils.b.c(context);
        String d = com.tencent.smtt.utils.b.d(context);
        Object f = com.tencent.smtt.utils.b.f(context);
        if (!(c == null || "".equals(c))) {
            thirdAppInfoNew2.sImei = c;
        }
        if (!(d == null || "".equals(d))) {
            thirdAppInfoNew2.sImsi = d;
        }
        if (!TextUtils.isEmpty(f)) {
            thirdAppInfoNew2.sAndroidID = f;
        }
        if (!(str5 == null || "".equals(str5))) {
            thirdAppInfoNew2.sMac = str5;
        }
        thirdAppInfoNew2.iPv = (long) i;
        ThirdAppInfoNew thirdAppInfoNew3;
        if (TbsShareManager.isThirdPartyApp(context)) {
            if (!z) {
                thirdAppInfoNew3 = thirdAppInfoNew2;
                i2 = 0;
                thirdAppInfoNew = thirdAppInfoNew3;
            } else if (TbsShareManager.getCoreFormOwn()) {
                i2 = 2;
                thirdAppInfoNew = thirdAppInfoNew2;
            } else {
                i2 = 1;
                thirdAppInfoNew = thirdAppInfoNew2;
            }
        } else if (z) {
            i2 = 1;
            thirdAppInfoNew = thirdAppInfoNew2;
        } else {
            thirdAppInfoNew3 = thirdAppInfoNew2;
            i2 = 0;
            thirdAppInfoNew = thirdAppInfoNew3;
        }
        thirdAppInfoNew.iCoreType = i2;
        thirdAppInfoNew2.sAppVersionName = str4;
        thirdAppInfoNew2.sAppSignature = a(context);
        if (!z) {
            thirdAppInfoNew2.sWifiConnectedTime = j;
            thirdAppInfoNew2.localCoreVersion = QbSdk.getTbsVersion(context);
        }
        a(thirdAppInfoNew2, context.getApplicationContext());
    }

    private static JSONObject c(ThirdAppInfoNew thirdAppInfoNew, Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("APPNAME", thirdAppInfoNew.sAppName);
            jSONObject.put("TIME", thirdAppInfoNew.sTime);
            jSONObject.put("QUA2", thirdAppInfoNew.sQua2);
            jSONObject.put("LC", thirdAppInfoNew.sLc);
            jSONObject.put("GUID", thirdAppInfoNew.sGuid);
            jSONObject.put("IMEI", thirdAppInfoNew.sImei);
            jSONObject.put("IMSI", thirdAppInfoNew.sImsi);
            jSONObject.put("MAC", thirdAppInfoNew.sMac);
            jSONObject.put("PV", thirdAppInfoNew.iPv);
            jSONObject.put("CORETYPE", thirdAppInfoNew.iCoreType);
            jSONObject.put("APPVN", thirdAppInfoNew.sAppVersionName);
            if (thirdAppInfoNew.sAppSignature == null) {
                jSONObject.put("SIGNATURE", "0");
            } else {
                jSONObject.put("SIGNATURE", thirdAppInfoNew.sAppSignature);
            }
            jSONObject.put("PROTOCOL_VERSION", 3);
            jSONObject.put("ANDROID_ID", thirdAppInfoNew.sAndroidID);
            if (TbsShareManager.isThirdPartyApp(context)) {
                jSONObject.put("HOST_COREVERSION", TbsShareManager.getHostCoreVersions(context));
            } else {
                jSONObject.put("HOST_COREVERSION", TbsDownloader.getCoreShareDecoupleCoreVersionByContext(context));
                jSONObject.put("DECOUPLE_COREVERSION", TbsDownloader.getCoreShareDecoupleCoreVersionByContext(context));
            }
            if (thirdAppInfoNew.iCoreType == 0) {
                jSONObject.put("WIFICONNECTEDTIME", thirdAppInfoNew.sWifiConnectedTime);
                jSONObject.put("CORE_EXIST", thirdAppInfoNew.localCoreVersion);
                int i = TbsCoreLoadStat.mLoadErrorCode;
                if (thirdAppInfoNew.localCoreVersion <= 0) {
                    jSONObject.put("TBS_ERROR_CODE", TbsDownloadConfig.getInstance(context).getDownloadInterruptCode());
                } else {
                    jSONObject.put("TBS_ERROR_CODE", i);
                }
                if (i == -1) {
                    TbsLog.e("sdkreport", "ATTENTION: Load errorCode missed!");
                }
            }
            try {
                if (QbSdk.getTID() == null) {
                    return jSONObject;
                }
                if (thirdAppInfoNew.sAppName.equals(TbsConfig.APP_QQ)) {
                    jSONObject.put("TID", o.a().a(QbSdk.getTID()));
                    jSONObject.put("TIDTYPE", 1);
                    return jSONObject;
                } else if (!thirdAppInfoNew.sAppName.equals("com.tencent.mm")) {
                    return jSONObject;
                } else {
                    jSONObject.put("TID", QbSdk.getTID());
                    jSONObject.put("TIDTYPE", 0);
                    return jSONObject;
                }
            } catch (Exception e) {
                return jSONObject;
            }
        } catch (Exception e2) {
            TbsLog.e("sdkreport", "getPostData exception!");
            return null;
        }
    }
}
