package com.tencent.matrix.mrs.core;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.d.b;
import java.util.TimeZone;

public final class MrsLogic {
    private static final String TAG = "MrsLogic";
    private static MrsCallback mrsCallback = null;
    private static PhoneInfo phoneInfo;

    public static class PhoneInfo {
        public String deviceBrand;
        public String deviceModel;
        public String languageVer;
        public String osName;
        public String osVersion;
    }

    static native void collectData(String str, byte[] bArr);

    static native void onCrash();

    static native void onCreate();

    static native void onDestroy();

    static native void onForeground(boolean z);

    static native void onReportResp(int i, int i2, byte[] bArr);

    static native void onStrategyResp(int i, int i2, byte[] bArr);

    static native void setClientVersion(long j);

    static native void setDebugFlag(boolean z);

    static native void setPhoneInfo(PhoneInfo phoneInfo);

    static native void setRevision(String str);

    public static native void setTimeZone(int i);

    static native void setUin(long j);

    private MrsLogic() {
    }

    static void init(long j, String str, boolean z) {
        onCreate();
        onForeground(true);
        setTimeZone(TimeZone.getDefault().getRawOffset() / 3600000);
        setClientVersion(j);
        setRevision(str);
        setDebugFlag(z);
        setPhoneInfo(getPhoneInfo());
    }

    private static String replayUnderlineWithDoc(String str) {
        return TextUtils.isEmpty(str) ? str : str.replace("_", "-");
    }

    private static String limitRevision(String str) {
        return (!TextUtils.isEmpty(str) && str.length() > 7) ? str.substring(0, 7) : str;
    }

    private static PhoneInfo getPhoneInfoInternal() {
        PhoneInfo phoneInfo = new PhoneInfo();
        phoneInfo.deviceModel = replayUnderlineWithDoc(Build.MODEL);
        phoneInfo.deviceBrand = replayUnderlineWithDoc(Build.BRAND);
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            str = Build.BRAND;
        }
        phoneInfo.osName = replayUnderlineWithDoc(str);
        phoneInfo.osVersion = VERSION.SDK_INT;
        phoneInfo.languageVer = "";
        return phoneInfo;
    }

    static void setCallBack(MrsCallback mrsCallback) {
        mrsCallback = mrsCallback;
    }

    static PhoneInfo getPhoneInfo() {
        if (phoneInfo == null) {
            phoneInfo = getPhoneInfoInternal();
        }
        return phoneInfo;
    }

    static void onMrsReportDataReady(byte[] bArr) {
        try {
            if (mrsCallback == null) {
                throw new RuntimeException("onMrsReportDataReady, but mrsCallback is null");
            }
            mrsCallback.onMrsReportDataReady(bArr);
        } catch (Throwable e) {
            b.printErrStackTrace(TAG, e, "jni callback exception", new Object[0]);
        }
    }

    static String getPublicSharePath() {
        try {
            if (mrsCallback != null) {
                return mrsCallback.getPublicSharePath();
            }
            throw new RuntimeException("getPublicSharePath, but mrsCallback is null");
        } catch (Throwable e) {
            b.printErrStackTrace(TAG, e, "jni callback exception", new Object[0]);
            return null;
        }
    }

    static boolean onRequestGetMrsStrategy(byte[] bArr) {
        boolean z = false;
        try {
            if (mrsCallback != null) {
                return mrsCallback.onRequestGetMrsStrategy(bArr);
            }
            throw new RuntimeException("onRequestGetMrsStrategy, but mrsCallback is null");
        } catch (Throwable e) {
            b.printErrStackTrace(TAG, e, "jni callback exception", new Object[z]);
            return z;
        }
    }

    static void onStrategyNotify(String str) {
        try {
            if (mrsCallback == null) {
                throw new RuntimeException("onRequestGetMrsStrategy, but mrsCallback is null");
            }
            Intent intent = new Intent();
            intent.setAction("strategyNotify");
            intent.putExtra("strategy", str);
            MatrixReport.with().getContext().sendBroadcast(intent, "com.tencent.mm.matrix.strategynotify");
            mrsCallback.onStrategyNotify(str, true);
        } catch (Throwable e) {
            b.printErrStackTrace(TAG, e, "jni callback exception", new Object[0]);
        }
    }
}
