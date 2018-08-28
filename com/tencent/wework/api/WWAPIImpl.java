package com.tencent.wework.api;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.utils.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public final class WWAPIImpl implements IWWAPI {
    private static final String[] vzD = new String[]{"com.tencent.wework", "com.tencent.weworklocal"};
    private Context context;
    private Map<String, Object> nmm = new HashMap();
    private String vzE;
    private BroadcastReceiver vzF = new 1(this);

    public WWAPIImpl(Context context) {
        this.context = context;
    }

    public final boolean cIf() {
        int adu;
        for (String str : vzD) {
            adu = adu(str);
            if (adu != 0) {
                Log.i("WWAPIImpl", "getWWAppSupportAPI, pkg: " + str + ", versioncode: " + adu);
                break;
            }
        }
        adu = 0;
        return adu >= 100;
    }

    public final String cIg() {
        String[] strArr = vzD;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            try {
                PackageManager packageManager = this.context.getPackageManager();
                str = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 0)).toString();
                if (TextUtils.isEmpty(str)) {
                    return "企业微信";
                }
                return str;
            } catch (Throwable th) {
                Log.w("WWAPIImpl", "getWWAppName failed", th);
                i++;
            }
        }
        return "企业微信";
    }

    public final boolean a(BaseMessage baseMessage) {
        String[] strArr = vzD;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            String adt = adt(str);
            Log.d("WWAPIImpl", "isValidSignature, pkg: " + str + ", signature: " + adt);
            if ("011A40266C8C75D181DDD8E4DDC50075".equals(adt)) {
                Intent intent = new Intent("com.tencent.wework.apihost");
                intent.setClassName(str, "com.tencent.wework.apihost.WWAPIActivity");
                intent.addFlags(411041792);
                try {
                    baseMessage.setContext(this.context);
                    intent.putExtras(BaseMessage.b(baseMessage));
                    intent.putExtra("PendingIntent", PendingIntent.getBroadcast(this.context, 0, new Intent(this.context, this.vzF.getClass()), 134217728));
                    this.context.startActivity(intent);
                    Log.i("WWAPIImpl", "sendMessage, start WWAPIActivity, pkg: " + str);
                    return true;
                } catch (Throwable th) {
                    Log.w("WWAPIImpl", "sendMessage failed, pkg: " + str, th);
                }
            } else {
                i++;
            }
        }
        return false;
    }

    private String adt(String str) {
        try {
            return bU(this.context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray());
        } catch (Throwable th) {
            Log.w("WWAPIImpl", "getSignature failed, pkg: " + str, th);
            return "";
        }
    }

    private int adu(String str) {
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(str, 128);
            if (packageInfo == null) {
                return 0;
            }
            return packageInfo.versionCode;
        } catch (Throwable th) {
            Log.w("WWAPIImpl", "getVersioncode failed, pkg: " + str, th);
            return 0;
        }
    }

    private static String bU(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bArr);
            byte[] digest = instance.digest();
            StringBuilder stringBuilder = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                stringBuilder.append(Integer.toHexString((b & 240) >>> 4));
                stringBuilder.append(Integer.toHexString(b & 15));
            }
            return stringBuilder.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }
}
