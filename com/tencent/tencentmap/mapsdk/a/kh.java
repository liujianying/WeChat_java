package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.map.lib.basemap.data.GeoPoint;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class kh {
    private static String A = null;
    private static int B = 0;
    private static String C = null;
    public static String a = null;
    public static String b = "TencentMapSDK";
    public static String c = null;
    public static String d = "undefined";
    public static float e = 1.0f;
    public static a f = a.c;
    public static int g = 0;
    public static int h = 0;
    public static int i = 0;
    public static boolean j = false;
    public static Bitmap k = null;
    public static final int l = Color.argb(200, 0, 163, 255);
    public static String m = "tencentmap/mapsdk_vector/mark_location_big.png";
    public static int n = 2;
    public static int o = 4000000;
    public static int p = 53500000;
    public static int q = 73670000;
    public static int r = 135100000;
    public static int s = 160;
    public static float t = 0.0f;
    public static nn u = null;
    private static String v = null;
    private static String w = null;
    private static String x = null;
    private static String y = null;
    private static String z = null;

    public static String a() {
        if (y == null) {
            return "";
        }
        return y;
    }

    public static String b() {
        if (z == null) {
            return "";
        }
        return z;
    }

    private static String e(String str) {
        if (str == null) {
            return "";
        }
        return str.replace("&", "").replace("#", "").replace("?", "");
    }

    private static String f(String str) {
        return Pattern.compile("[^a-zA-Z0-9]").matcher(str).replaceAll("").trim();
    }

    public static void a(Context context) {
        String str;
        if (C == null) {
            try {
                str = Build.MODEL;
                C = str;
                str = e(str);
                C = str;
                C = URLEncoder.encode(str, "utf-8");
            } catch (Exception e) {
            }
        }
        if (B == 0) {
            B = VERSION.SDK_INT;
        }
        if (A == null) {
            try {
                str = context.getPackageName();
                A = str;
                str = e(str);
                A = str;
                A = URLEncoder.encode(str, "utf-8");
            } catch (Exception e2) {
            }
        }
        if (x == null) {
            try {
                str = g(context);
                x = str;
                str = e(str);
                x = str;
                x = URLEncoder.encode(str, "utf-8");
            } catch (Exception e3) {
            }
        }
        if (y == null) {
            try {
                str = f(context);
                y = str;
                str = e(str);
                y = str;
                y = URLEncoder.encode(str, "utf-8");
            } catch (Exception e4) {
            }
        }
        if (z == null) {
            try {
                str = pp.c(context);
                z = str;
                str = e(str);
                z = str;
                z = URLEncoder.encode(str, "utf-8");
            } catch (Exception e5) {
            }
        }
        if (w == null) {
            try {
                str = e(context);
                w = str;
                str = f(str);
                w = str;
                w = URLEncoder.encode(str, "utf-8");
            } catch (Exception e6) {
            }
        }
        if (v == null) {
            try {
                str = d(context);
                v = str;
                str = e(str);
                v = str;
                v = URLEncoder.encode(str, "utf-8");
            } catch (Exception e7) {
            }
        }
        if (a == null) {
            try {
                str = c(context);
                a = str;
                a = URLEncoder.encode(str, "utf-8");
            } catch (Exception e8) {
            }
        }
        if (c == null) {
            try {
                str = d();
                c = str;
                c = URLEncoder.encode(str, "utf-8");
            } catch (Exception e9) {
            }
        }
        if (e == 1.0f) {
            e = 320.0f / ((float) context.getResources().getDisplayMetrics().densityDpi);
        }
        t = context.getResources().getDisplayMetrics().density;
        j = r.a(context).f();
    }

    private static String d() {
        return a(String.format("key=%s&output=json&ref=%s&pf=%s&imei=%s&pid=%s&os=%s&hm=%s&imsi=%s&mac=%s", new Object[]{a, x, "androidsdk", y, A, Integer.valueOf(B), C, v, w}));
    }

    public static String c() {
        return String.format("http://apikey.map.qq.com/mkey/index.php/mkey/check?key=%s&output=json&ref=%s&pf=%s&imei=%s&pid=%s&os=%s&hm=%s&imsi=%s&mac=%s&nt=%s&suid=%s&ver=%s", new Object[]{a, x, "androidsdk", y, A, Integer.valueOf(B), C, v, w, z, c, "4.0.8"});
    }

    public static String a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            return a(instance.digest(), "");
        } catch (Exception e) {
            return str;
        }
    }

    private static String a(byte[] bArr, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            stringBuilder.append(Integer.toHexString(b & 255)).append(str);
        }
        return stringBuilder.toString();
    }

    private static String c(Context context) {
        if (context == null) {
            return "";
        }
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (NameNotFoundException e) {
        }
        if (applicationInfo == null) {
            return "";
        }
        if (applicationInfo.metaData == null) {
            return "";
        }
        return applicationInfo.metaData.getString(b);
    }

    private static String d(Context context) {
        if (context == null) {
            return "";
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        String subscriberId = telephonyManager.getSubscriberId();
        if (subscriberId == null) {
            return "";
        }
        return subscriberId;
    }

    private static String e(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager == null) {
            return "";
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            return "";
        }
        String macAddress = connectionInfo.getMacAddress();
        if (macAddress == null) {
            return "";
        }
        return macAddress;
    }

    private static String f(Context context) {
        if (context == null) {
            return "";
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        String deviceId = telephonyManager.getDeviceId();
        if (deviceId == null) {
            return "";
        }
        return deviceId;
    }

    private static String g(Context context) {
        if (context == null) {
            return "";
        }
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
        } catch (NameNotFoundException e) {
        }
        return applicationInfo.loadLabel(packageManager).toString();
    }

    public static void b(Context context) {
        if (context != null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            Field field = null;
            try {
                field = displayMetrics.getClass().getField("densityDpi");
            } catch (SecurityException e) {
            } catch (NoSuchFieldException e2) {
            }
            if (field != null) {
                long j = (long) (displayMetrics.widthPixels * displayMetrics.heightPixels);
                try {
                    s = field.getInt(displayMetrics);
                } catch (IllegalArgumentException e3) {
                } catch (IllegalAccessException e4) {
                }
                if (s <= 120) {
                    n = 1;
                    return;
                }
                if (s > 160) {
                    if (s <= 240) {
                        n = 3;
                        return;
                    } else if (j > 153600) {
                        n = 3;
                        return;
                    } else if (j < 153600) {
                        n = 1;
                        return;
                    }
                }
                n = 2;
                return;
            }
            long j2 = (long) (displayMetrics.widthPixels * displayMetrics.heightPixels);
            if (j2 > 153600) {
                n = 3;
            } else if (j2 < 153600) {
                n = 1;
            } else {
                n = 2;
            }
        }
    }

    public static final Bitmap a(Context context, String str) {
        Throwable th;
        InputStream inputStream;
        Bitmap bitmap = null;
        if (str != null) {
            InputStream fileInputStream;
            try {
                if (str.trim().length() != 0) {
                    String str2;
                    if (str.trim().charAt(0) != '/') {
                        str2 = context.getFilesDir() + "/" + str;
                    } else {
                        str2 = context.getFilesDir() + str;
                    }
                    fileInputStream = new FileInputStream(str2);
                    try {
                        bitmap = BitmapFactory.decodeStream(fileInputStream);
                        try {
                            fileInputStream.close();
                        } catch (Exception e) {
                        }
                    } catch (Exception e2) {
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = fileInputStream;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e3) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e4) {
                fileInputStream = bitmap;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e5) {
                    }
                }
                return bitmap;
            } catch (Throwable th3) {
                th = th3;
                inputStream = bitmap;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e32) {
                    }
                }
                throw th;
            }
        }
        return bitmap;
    }

    public static final Bitmap a(Bitmap bitmap) {
        Bitmap bitmap2 = null;
        try {
            return Bitmap.createBitmap(bitmap);
        } catch (OutOfMemoryError e) {
            return bitmap2;
        }
    }

    public static final Bitmap b(String str) {
        Bitmap bitmap = null;
        try {
            return BitmapFactory.decodeFile(str);
        } catch (OutOfMemoryError e) {
            return bitmap;
        }
    }

    public static final Bitmap b(Context context, String str) {
        Closeable b;
        Throwable th;
        Closeable closeable;
        Bitmap bitmap = null;
        try {
            b = q.b(o.a(context).i() + str);
            if (b == null) {
                try {
                    if (p.a() != null) {
                        b = p.b(context, p.a() + str);
                    } else if (p.b() != null) {
                        b = q.b(p.b() + str);
                    }
                } catch (Exception e) {
                    q.a(b);
                    return bitmap;
                } catch (OutOfMemoryError e2) {
                    q.a(b);
                    return bitmap;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = b;
                    q.a(closeable);
                    throw th;
                }
            }
            if (b == null) {
                b = p.b(context, "tencentmap/mapsdk_vector/" + str);
            }
            bitmap = BitmapFactory.decodeStream(b);
            q.a(b);
        } catch (Exception e3) {
            b = null;
        } catch (OutOfMemoryError e4) {
            b = null;
            q.a(b);
            return bitmap;
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            q.a(closeable);
            throw th;
        }
        return bitmap;
    }

    public static Bitmap a(Context context, int i) {
        Bitmap bitmap = null;
        try {
            return BitmapFactory.decodeResource(context.getResources(), i);
        } catch (OutOfMemoryError e) {
            return bitmap;
        }
    }

    public static Bitmap b(Bitmap bitmap) {
        if (bitmap == null) {
            return bitmap;
        }
        try {
            return Bitmap.createScaledBitmap(bitmap, (int) (((float) bitmap.getWidth()) / e), (int) (((float) bitmap.getHeight()) / e), true);
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final android.graphics.Bitmap c(android.content.Context r3, java.lang.String r4) {
        /*
        r1 = 0;
        r0 = r3.getAssets();
        r2 = r0.open(r4);	 Catch:{ Exception -> 0x0011, OutOfMemoryError -> 0x0014 }
        r0 = android.graphics.BitmapFactory.decodeStream(r2);	 Catch:{ Exception -> 0x0011, OutOfMemoryError -> 0x0014 }
        r2.close();	 Catch:{ Exception -> 0x0011, OutOfMemoryError -> 0x0017 }
    L_0x0010:
        return r0;
    L_0x0011:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0010;
    L_0x0014:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0010;
    L_0x0017:
        r1 = move-exception;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.kh.c(android.content.Context, java.lang.String):android.graphics.Bitmap");
    }

    public static GeoPoint a(ox oxVar) {
        if (oxVar == null) {
            return null;
        }
        return new GeoPoint((int) (oxVar.a * 1000000.0d), (int) (oxVar.b * 1000000.0d));
    }

    public static ox a(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return null;
        }
        return new ox(((double) geoPoint.getLatitudeE6()) / 1000000.0d, ((double) geoPoint.getLongitudeE6()) / 1000000.0d);
    }

    public static String c(String str) {
        StringBuilder stringBuilder = new StringBuilder(256);
        if (!TextUtils.isEmpty(y)) {
            stringBuilder.append("&deviceid=");
            stringBuilder.append(y);
        }
        if (!TextUtils.isEmpty(A)) {
            stringBuilder.append("&appid=");
            stringBuilder.append(A);
        }
        if (!TextUtils.isEmpty("4.0.8")) {
            stringBuilder.append("&sdkver=");
            stringBuilder.append("4.0.8");
        }
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append("&ui=");
            stringBuilder.append(str);
        }
        if (!TextUtils.isEmpty(d)) {
            stringBuilder.append("&appsuid=");
            try {
                stringBuilder.append(URLEncoder.encode(d, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                stringBuilder.append(f(d));
            }
        }
        stringBuilder.append("&api_key=" + a);
        return stringBuilder.toString();
    }

    public static List<ox> a(List<GeoPoint> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<ox> arrayList = new ArrayList(list.size());
        for (GeoPoint a : list) {
            arrayList.add(a(a));
        }
        return arrayList;
    }

    public static double a(double d, double d2) {
        return (6.698324247899813d * d) / Math.cos(0.017453292519943295d * d2);
    }

    public static boolean a(Context context, byte[] bArr, String str) {
        File fileStreamPath = context.getFileStreamPath("tecentmap");
        if (!fileStreamPath.exists()) {
            fileStreamPath.mkdirs();
        }
        if (q.a(bArr, fileStreamPath.getPath() + "/" + str, false) == 0) {
            return false;
        }
        return true;
    }

    public static byte[] d(Context context, String str) {
        Closeable b = q.b(context.getFileStreamPath("tecentmap").getPath() + "/" + str);
        byte[] a = q.a(b);
        q.a(b);
        return a;
    }

    public static String[] d(String str) {
        String[] strArr = new String[3];
        try {
            JSONObject jSONObject = new JSONObject(str);
            strArr[0] = jSONObject.optString("version");
            strArr[1] = jSONObject.optString("data");
            strArr[2] = jSONObject.optString("otherDistrict");
        } catch (JSONException e) {
        }
        return strArr;
    }
}
