package com.tencent.tencentmap.mapsdk.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Base64;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.util.EncodingUtils;

public final class e {
    private static e a;

    private static NetworkInfo o(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th) {
            ct.a(th);
            return null;
        }
    }

    public static int j(Context context) {
        ct.a(" RecordDAO.countRecordNum() start", new Object[0]);
        if (context == null) {
            ct.d(" countRecordNum() have null args!", new Object[0]);
            return -1;
        }
        return cb.b(context, new int[]{1});
    }

    public static cp a(di diVar) {
        if (diVar == null || !"UA".equals(diVar.b())) {
            return null;
        }
        Map e = diVar.e();
        if (e == null) {
            return null;
        }
        try {
            cp cpVar = new cp();
            cpVar.a = (String) e.get("A19");
            cpVar.c = diVar.d();
            cpVar.h = diVar.c();
            cpVar.b = (String) e.get("A28");
            cpVar.f = Long.parseLong((String) e.get("A26"));
            cpVar.d = Boolean.parseBoolean((String) e.get("A25"));
            cpVar.e = Long.parseLong((String) e.get("A27"));
            e.remove("A19");
            e.remove("A28");
            e.remove("A26");
            e.remove("A25");
            e.remove("A27");
            cpVar.g = a(e);
            return cpVar;
        } catch (Throwable th) {
            ct.a(th);
            ct.d(th.getMessage(), new Object[0]);
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object[] a(android.content.Context r10, java.lang.String r11) {
        /*
        r8 = 0;
        r9 = com.tencent.tencentmap.mapsdk.a.cd.a;
        monitor-enter(r9);
        if (r10 != 0) goto L_0x0012;
    L_0x0006:
        r0 = "context == null ";
        r1 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x0095 }
        com.tencent.tencentmap.mapsdk.a.ct.c(r0, r1);	 Catch:{ all -> 0x0095 }
        monitor-exit(r9);	 Catch:{ all -> 0x0095 }
        r0 = r8;
    L_0x0011:
        return r0;
    L_0x0012:
        if (r11 != 0) goto L_0x0020;
    L_0x0014:
        r0 = "key == null ";
        r1 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x0095 }
        com.tencent.tencentmap.mapsdk.a.ct.c(r0, r1);	 Catch:{ all -> 0x0095 }
        monitor-exit(r9);	 Catch:{ all -> 0x0095 }
        r0 = r8;
        goto L_0x0011;
    L_0x0020:
        r0 = com.tencent.tencentmap.mapsdk.a.cd.a(r10);	 Catch:{ Exception -> 0x00a7, all -> 0x00b5 }
        r0 = r0.getWritableDatabase();	 Catch:{ Exception -> 0x00a7, all -> 0x00b5 }
        if (r0 != 0) goto L_0x0036;
    L_0x002a:
        r0 = "getWritableDatabase fail! ";
        r1 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x00a7, all -> 0x00b5 }
        com.tencent.tencentmap.mapsdk.a.ct.c(r0, r1);	 Catch:{ Exception -> 0x00a7, all -> 0x00b5 }
        monitor-exit(r9);	 Catch:{ all -> 0x0095 }
        r0 = r8;
        goto L_0x0011;
    L_0x0036:
        r1 = "t_conf";
        r2 = 0;
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00a7, all -> 0x00b5 }
        r4 = "_key = '";
        r3.<init>(r4);	 Catch:{ Exception -> 0x00a7, all -> 0x00b5 }
        r3 = r3.append(r11);	 Catch:{ Exception -> 0x00a7, all -> 0x00b5 }
        r4 = "'";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00a7, all -> 0x00b5 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00a7, all -> 0x00b5 }
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r1 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x00a7, all -> 0x00b5 }
        if (r1 == 0) goto L_0x0098;
    L_0x005b:
        r0 = r1.moveToNext();	 Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
        if (r0 == 0) goto L_0x0098;
    L_0x0061:
        r0 = 3;
        r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
        r2 = 0;
        r0[r2] = r11;	 Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
        r2 = 1;
        r3 = "_value";
        r3 = r1.getColumnIndex(r3);	 Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
        r3 = r1.getString(r3);	 Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
        r0[r2] = r3;	 Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
        r2 = 2;
        r3 = "_vdate";
        r3 = r1.getColumnIndex(r3);	 Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
        r4 = r1.getLong(r3);	 Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
        r3 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
        r0[r2] = r3;	 Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
        if (r1 == 0) goto L_0x0092;
    L_0x0089:
        r2 = r1.isClosed();	 Catch:{ all -> 0x0095 }
        if (r2 != 0) goto L_0x0092;
    L_0x008f:
        r1.close();	 Catch:{ all -> 0x0095 }
    L_0x0092:
        monitor-exit(r9);	 Catch:{ all -> 0x0095 }
        goto L_0x0011;
    L_0x0095:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
    L_0x0098:
        if (r1 == 0) goto L_0x00a3;
    L_0x009a:
        r0 = r1.isClosed();	 Catch:{ all -> 0x0095 }
        if (r0 != 0) goto L_0x00a3;
    L_0x00a0:
        r1.close();	 Catch:{ all -> 0x0095 }
    L_0x00a3:
        monitor-exit(r9);	 Catch:{ all -> 0x0095 }
        r0 = r8;
        goto L_0x0011;
    L_0x00a7:
        r0 = move-exception;
        r0 = r8;
    L_0x00a9:
        if (r0 == 0) goto L_0x00a3;
    L_0x00ab:
        r1 = r0.isClosed();	 Catch:{ all -> 0x0095 }
        if (r1 != 0) goto L_0x00a3;
    L_0x00b1:
        r0.close();	 Catch:{ all -> 0x0095 }
        goto L_0x00a3;
    L_0x00b5:
        r0 = move-exception;
    L_0x00b6:
        if (r8 == 0) goto L_0x00c1;
    L_0x00b8:
        r1 = r8.isClosed();	 Catch:{ all -> 0x0095 }
        if (r1 != 0) goto L_0x00c1;
    L_0x00be:
        r8.close();	 Catch:{ all -> 0x0095 }
    L_0x00c1:
        throw r0;	 Catch:{ all -> 0x0095 }
    L_0x00c2:
        r0 = move-exception;
        r8 = r1;
        goto L_0x00b6;
    L_0x00c5:
        r0 = move-exception;
        r0 = r1;
        goto L_0x00a9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.e.a(android.content.Context, java.lang.String):java.lang.Object[]");
    }

    public static synchronized boolean a(Context context, cl clVar) {
        boolean z = true;
        boolean z2 = false;
        synchronized (e.class) {
            if (context == null || clVar == null) {
                ct.c("context == null || bean == null}", new Object[0]);
            } else {
                try {
                    SQLiteDatabase writableDatabase = cd.a(context).getWritableDatabase();
                    if (writableDatabase == null) {
                        ct.d("get db fail!,return false ", new Object[0]);
                    } else {
                        ContentValues contentValues;
                        if (clVar == null) {
                            contentValues = null;
                        } else {
                            contentValues = new ContentValues();
                            if (clVar.a() >= 0) {
                                contentValues.put("_id", Long.valueOf(clVar.a()));
                            }
                            contentValues.put("_key", Integer.valueOf(clVar.b()));
                            contentValues.put("_datas", clVar.c());
                        }
                        if (contentValues != null) {
                            long replace = writableDatabase.replace("t_strategy", "_id", contentValues);
                            if (replace < 0) {
                                ct.c("insert failure! return false ", new Object[0]);
                            } else {
                                clVar.a(replace);
                                ct.e("update strategy  %d true ", new Object[]{Integer.valueOf(clVar.b())});
                            }
                        } else {
                            z = false;
                        }
                        z2 = z;
                    }
                } catch (Throwable th) {
                    ct.d("Error strategy update!  %s", new Object[]{th.toString()});
                }
            }
        }
        return z2;
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            if (a == null && context != null) {
                a = new e();
            }
            eVar = a;
        }
        return eVar;
    }

    public static boolean l(Context context) {
        NetworkInfo o = o(context);
        if (o == null || o.getType() != 1) {
            return false;
        }
        return true;
    }

    public static Long[] a(Context context, List<di> list) {
        int i = 0;
        ct.a(" RecordDAO.insertList() start", new Object[0]);
        if (context == null || list == null) {
            ct.d(" insertList() have null args!", new Object[0]);
            return null;
        }
        int size = list.size();
        if (size == 0) {
            ct.b(" list siez == 0 , return true!", new Object[0]);
            return null;
        }
        Long[] lArr = new Long[size];
        List<cb> arrayList = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = (di) list.get(i2);
            if (obj == null || obj.b() == null || !obj.b().equals("UA")) {
                ct.d(" bean's type is error!", new Object[0]);
            } else {
                try {
                    arrayList.add(new cb(obj.c(), a(obj)));
                } catch (Throwable th) {
                    ct.a(th);
                }
            }
        }
        if (!cb.a(context, arrayList)) {
            return null;
        }
        for (cb cbVar : arrayList) {
            if (i < size) {
                lArr[i] = Long.valueOf(cbVar.a);
            }
            i++;
        }
        return lArr;
    }

    private e() {
    }

    public static boolean m(Context context) {
        NetworkInfo o = o(context);
        if (o == null || !o.isConnected()) {
            return false;
        }
        return true;
    }

    public static String a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            ct.d("getDeviceName error", new Object[0]);
            ct.a(th);
            return "";
        }
    }

    public static Date d(String str) {
        Date date = null;
        if (str == null || str.trim().length() <= 0) {
            return date;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(str);
        } catch (Throwable e) {
            ct.a(e);
            return date;
        }
    }

    public static String n(Context context) {
        NetworkInfo o = o(context);
        if (o == null) {
            return "unknown";
        }
        if (o.getType() == 1) {
            return TencentExtraKeys.LOCATION_SOURCE_WIFI;
        }
        String extraInfo = o.getExtraInfo();
        if (extraInfo == null || extraInfo.length() <= 64) {
            return extraInfo;
        }
        return extraInfo.substring(0, 64);
    }

    public static String b() {
        try {
            return VERSION.RELEASE;
        } catch (Throwable th) {
            ct.d("getVersion error", new Object[0]);
            ct.a(th);
            return "";
        }
    }

    public static String b(String str) {
        String str2 = "unknown";
        if (str == null || str.trim().length() == 0) {
            return str2;
        }
        String trim = str.trim();
        int length = trim.length();
        char charAt;
        do {
            length--;
            if (length < 0) {
                length = 1;
                break;
            }
            charAt = trim.charAt(length);
            if (charAt < '0') {
                break;
            }
        } while (charAt <= '9');
        length = 0;
        if (length != 0) {
            str2 = str.trim();
            if (str2.length() > 16) {
                return str2.substring(0, 16);
            }
            return str2;
        }
        ct.c("channelID is invalid!! channelID should be Numeric! channelID:" + str, new Object[0]);
        return str2;
    }

    public static di a(Context context, String str, boolean z, long j, long j2, Map<String, String> map, boolean z2) {
        if (str == null) {
            return null;
        }
        c m = c.m();
        if (m == null) {
            ct.d("  CommonInfo or DeviceInfo have not been Created return null!", new Object[0]);
            return null;
        }
        da.a();
        long time = new Date().getTime() + m.h();
        String g = m.g();
        Object n = n(context);
        if (n == null) {
            n = "null";
        }
        Map hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        Object obj = null;
        if (dl.d().g().h() && !str.startsWith("rqd_")) {
            obj = 1;
        }
        dd a = dd.a(context);
        if (obj == null) {
            String b = da.b();
            if (!(b == null || b.equals(""))) {
                hashMap.put("QQ", b);
            }
            hashMap.put("A2", m.i());
            hashMap.put("A4", a.c());
            hashMap.put("A6", a.b());
            hashMap.put("A7", a.d());
            hashMap.put("A23", m.k());
            hashMap.put("A31", a.f());
            hashMap.put("A67", a.i(context));
            hashMap.put("A76", a.a());
            hashMap.put("A95", a.e(context));
        }
        hashMap.put("A19", n);
        hashMap.put("A28", g);
        hashMap.put("A25", String.valueOf(z));
        hashMap.put("A26", String.valueOf(j));
        hashMap.put("A27", String.valueOf(j2));
        di diVar = new di();
        diVar.b(str);
        diVar.b(time);
        diVar.a("UA");
        diVar.a(hashMap);
        diVar.a(z2);
        return diVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r8, java.lang.String r9, java.lang.Object[] r10) {
        /*
        r2 = 1;
        r1 = 0;
        r3 = com.tencent.tencentmap.mapsdk.a.cd.a;
        monitor-enter(r3);
        if (r8 == 0) goto L_0x000e;
    L_0x0007:
        if (r9 == 0) goto L_0x000e;
    L_0x0009:
        if (r10 == 0) goto L_0x000e;
    L_0x000b:
        r0 = r10.length;	 Catch:{ all -> 0x0085 }
        if (r0 != 0) goto L_0x0011;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x0085 }
        r0 = r1;
    L_0x0010:
        return r0;
    L_0x0011:
        r0 = com.tencent.tencentmap.mapsdk.a.cd.a(r8);	 Catch:{ Exception -> 0x008a }
        r4 = r0.getWritableDatabase();	 Catch:{ Exception -> 0x008a }
        r0 = "t_conf";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x008a }
        r6 = "_key = '";
        r5.<init>(r6);	 Catch:{ Exception -> 0x008a }
        r5 = r5.append(r9);	 Catch:{ Exception -> 0x008a }
        r6 = "'";
        r5 = r5.append(r6);	 Catch:{ Exception -> 0x008a }
        r5 = r5.toString();	 Catch:{ Exception -> 0x008a }
        r6 = 0;
        r4.delete(r0, r5, r6);	 Catch:{ Exception -> 0x008a }
        r5 = new android.content.ContentValues;	 Catch:{ Exception -> 0x008a }
        r5.<init>();	 Catch:{ Exception -> 0x008a }
        r0 = "_key";
        r5.put(r0, r9);	 Catch:{ Exception -> 0x008a }
        r6 = "_value";
        r0 = 0;
        r0 = r10[r0];	 Catch:{ Exception -> 0x008a }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x008a }
        r5.put(r6, r0);	 Catch:{ Exception -> 0x008a }
        r6 = "_vdate";
        r0 = 1;
        r0 = r10[r0];	 Catch:{ Exception -> 0x008a }
        r0 = (java.lang.Long) r0;	 Catch:{ Exception -> 0x008a }
        r5.put(r6, r0);	 Catch:{ Exception -> 0x008a }
        r0 = "_time";
        r6 = new java.util.Date;	 Catch:{ Exception -> 0x008a }
        r6.<init>();	 Catch:{ Exception -> 0x008a }
        r6 = r6.getTime();	 Catch:{ Exception -> 0x008a }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ Exception -> 0x008a }
        r5.put(r0, r6);	 Catch:{ Exception -> 0x008a }
        r0 = "t_conf";
        r6 = 0;
        r4 = r4.insert(r0, r6, r5);	 Catch:{ Exception -> 0x008a }
        r6 = 0;
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 >= 0) goto L_0x0088;
    L_0x0079:
        r0 = " insertOrUpdateByKey failure! return false!";
        r2 = 0;
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x008a }
        com.tencent.tencentmap.mapsdk.a.ct.d(r0, r2);	 Catch:{ Exception -> 0x008a }
        r0 = r1;
    L_0x0083:
        monitor-exit(r3);	 Catch:{ all -> 0x0085 }
        goto L_0x0010;
    L_0x0085:
        r0 = move-exception;
        monitor-exit(r3);
        throw r0;
    L_0x0088:
        r0 = r2;
        goto L_0x0083;
    L_0x008a:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0083;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.e.a(android.content.Context, java.lang.String, java.lang.Object[]):boolean");
    }

    private static byte[] a(Object obj) {
        Throwable e;
        byte[] bArr = null;
        ct.b("en obj 2 bytes ", new Object[0]);
        if (obj == null || !Serializable.class.isInstance(obj)) {
            ct.c("not serial obj ", new Object[0]);
        } else {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream;
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeObject(obj);
                    objectOutputStream.flush();
                    bArr = byteArrayOutputStream.toByteArray();
                    try {
                        objectOutputStream.close();
                    } catch (Throwable e2) {
                        ct.a(e2);
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable e22) {
                        ct.a(e22);
                    }
                } catch (Throwable th) {
                    e22 = th;
                }
            } catch (Throwable th2) {
                e22 = th2;
                objectOutputStream = bArr;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (Throwable th3) {
                        ct.a(th3);
                    }
                }
                byteArrayOutputStream.close();
                throw e22;
            }
        }
        return bArr;
    }

    public static String c() {
        try {
            return VERSION.SDK;
        } catch (Throwable th) {
            ct.d("getApiLevel error", new Object[0]);
            ct.a(th);
            return "";
        }
    }

    private static byte[] a(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return null;
        }
        for (int length = str.length(); length < 16; length++) {
            str = str + "0";
        }
        String substring = str.substring(0, 16);
        Key secretKeySpec = new SecretKeySpec(substring.getBytes(), "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKeySpec, new IvParameterSpec(substring.getBytes()));
        return instance.doFinal(bArr);
    }

    private static byte[] a(byte[] bArr) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = gZIPInputStream.read(bArr2, 0, 1024);
            if (read != -1) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                gZIPInputStream.close();
                byteArrayInputStream.close();
                return bArr2;
            }
        }
    }

    public static String b(Context context) {
        String str = "";
        if (context == null) {
            ct.d("getImei but context == null!", new Object[0]);
            return str;
        }
        String deviceId;
        try {
            if (a.f(context)) {
                deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (deviceId == null) {
                    try {
                        deviceId = "";
                    } catch (Throwable th) {
                    }
                } else {
                    deviceId = deviceId.toLowerCase();
                }
            } else {
                deviceId = str;
            }
            ct.a("IMEI:" + deviceId, new Object[0]);
            return deviceId;
        } catch (Throwable th2) {
            deviceId = str;
            ct.d("getImei error!", new Object[0]);
            return deviceId;
        }
    }

    private static String a(Map<String, String> map) {
        ct.b("map 2 str", new Object[0]);
        if (map == null) {
            return "";
        }
        Set<String> keySet = map.keySet();
        if (keySet == null) {
            return "";
        }
        String str;
        if (keySet.size() > 50) {
            ct.c("The Map<String, String> params size is more than 50, effective size is <= 50!", new Object[0]);
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : keySet) {
            int length = str2.trim().length();
            if (length <= 0 || !c(str2)) {
                ct.c("The Map<String, String> params key is invalid!! key should be ASCII code in 32-126! key:" + str2, new Object[0]);
            } else {
                String trim = str2.trim();
                if (length > 64) {
                    trim = trim.substring(0, 64);
                }
                stringBuffer.append("&");
                stringBuffer.append(trim.replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
                stringBuffer.append("=");
                str2 = (String) map.get(str2);
                if (str2 != null) {
                    str2 = str2.trim();
                    if (str2.contains(";")) {
                        if (str2.length() > 10240) {
                            str2 = str2.substring(0, 10240);
                            str2 = str2.substring(0, str2.lastIndexOf(";"));
                        }
                    } else if (str2.length() > 1024) {
                        str2 = str2.substring(0, 1024);
                    }
                    stringBuffer.append(str2.replace(10, ' ').replace(13, ' ').replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
                }
            }
        }
        str2 = stringBuffer.substring(1);
        stringBuffer.setLength(0);
        return str2;
    }

    public static synchronized cl h(Context context) {
        cl clVar;
        Throwable th;
        Throwable th2;
        cl clVar2 = null;
        synchronized (e.class) {
            if (context == null) {
                ct.c("context == null}", new Object[0]);
                clVar = null;
            } else {
                Cursor query;
                try {
                    SQLiteDatabase writableDatabase = cd.a(context).getWritableDatabase();
                    if (writableDatabase == null) {
                        ct.c("getWritableDatabase fail! ", new Object[0]);
                        clVar = null;
                    } else {
                        query = writableDatabase.query("t_strategy", null, String.format(Locale.US, " %s = %d ", new Object[]{"_key", Integer.valueOf(101)}), null, null, null, null);
                        if (query != null) {
                            try {
                                if (query.moveToNext()) {
                                    if (!(query == null || query.isBeforeFirst() || query.isAfterLast())) {
                                        ct.b("parse bean}", new Object[0]);
                                        clVar = new cl();
                                        clVar.a(query.getLong(query.getColumnIndex("_id")));
                                        clVar.a(query.getInt(query.getColumnIndex("_key")));
                                        clVar.a(query.getBlob(query.getColumnIndex("_datas")));
                                        clVar2 = clVar;
                                    }
                                    if (clVar2 != null) {
                                        try {
                                            ct.g("read strategy key: %d", new Object[]{Integer.valueOf(clVar2.b())});
                                        } catch (Throwable th3) {
                                            th = th3;
                                            clVar = clVar2;
                                            try {
                                                ct.a(th);
                                                if (query != null) {
                                                    if (!query.isClosed()) {
                                                        query.close();
                                                    }
                                                }
                                                return clVar;
                                            } catch (Throwable th4) {
                                                th2 = th4;
                                                if (!(query == null || query.isClosed())) {
                                                    query.close();
                                                }
                                                throw th2;
                                            }
                                        }
                                    }
                                    clVar = clVar2;
                                    if (query != null) {
                                        if (!query.isClosed()) {
                                            query.close();
                                        }
                                    }
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                clVar = null;
                                ct.a(th);
                                if (query != null) {
                                    if (!query.isClosed()) {
                                        query.close();
                                    }
                                }
                                return clVar;
                            }
                        }
                        clVar = null;
                        if (query != null) {
                            if (!query.isClosed()) {
                                query.close();
                            }
                        }
                    }
                } catch (Throwable th6) {
                    th2 = th6;
                    query = null;
                    query.close();
                    throw th2;
                }
            }
        }
        return clVar;
    }

    public static List<di> a(Context context, int i) {
        ct.a(" RecordDAO.queryRecentRecord() start", new Object[0]);
        if (context == null) {
            ct.d(" queryRecentRecord() have null args!", new Object[0]);
            return null;
        }
        List a = cb.a(context, new int[]{1}, i);
        if (a == null || a.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = a.iterator();
        while (it.hasNext()) {
            cb cbVar = (cb) it.next();
            try {
                Object b = b(cbVar.b);
                if (b != null && di.class.isInstance(b)) {
                    di diVar = (di) di.class.cast(b);
                    diVar.a(cbVar.a);
                    arrayList.add(diVar);
                    it.remove();
                }
            } catch (Throwable th) {
                ct.a(th);
                ct.d(" query have error!", new Object[0]);
            }
        }
        if (a.size() > 0) {
            ct.a(" there are error datas ,should be remove " + a.size(), new Object[0]);
            Long[] lArr = new Long[a.size()];
            for (int i2 = 0; i2 < a.size(); i2++) {
                lArr[i2] = Long.valueOf(((cb) a.get(i2)).a);
            }
            cb.a(context, lArr);
        }
        ct.a(" RecordDAO.queryRecentRecord() end", new Object[0]);
        return arrayList;
    }

    private static byte[] b(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return null;
        }
        for (int length = str.length(); length < 16; length++) {
            str = str + "0";
        }
        String substring = str.substring(0, 16);
        Key secretKeySpec = new SecretKeySpec(substring.getBytes(), "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, secretKeySpec, new IvParameterSpec(substring.getBytes()));
        return instance.doFinal(bArr);
    }

    public static String c(Context context) {
        String str = "";
        if (context == null) {
            ct.d("getImsi but context == null!", new Object[0]);
            return str;
        }
        String toLowerCase;
        try {
            if (a.f(context)) {
                str = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
                toLowerCase = str == null ? "" : str.toLowerCase();
            } else {
                toLowerCase = str;
            }
        } catch (Throwable th) {
            toLowerCase = str;
            ct.d("getImsi error!", new Object[0]);
        }
        return toLowerCase;
    }

    private static Object b(byte[] bArr) {
        Object readObject;
        Throwable e;
        ObjectInputStream readObject2 = null;
        ct.b("de byte 2 obj ", new Object[0]);
        if (bArr != null && bArr.length >= 0) {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ObjectInputStream objectInputStream;
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    readObject2 = objectInputStream.readObject();
                    try {
                        objectInputStream.close();
                    } catch (Throwable e2) {
                        ct.a(e2);
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable e22) {
                        ct.a(e22);
                    }
                } catch (Throwable th) {
                    e22 = th;
                }
            } catch (Throwable th2) {
                e22 = th2;
                objectInputStream = readObject2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Throwable th3) {
                        ct.a(th3);
                    }
                }
                byteArrayInputStream.close();
                throw e22;
            }
        }
        return readObject2;
    }

    public static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        byte[] doFinal;
        try {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA", "BC").generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCsAxNCSLyNUCOP1QqYStE8ZeiU\nv4afaMqEmoLCKb0mUZYvYOoVN7LPMi2IVY2MRaFJvuND3glVw1RDm2VJJtjQkwUd\n3kpR9TrHAf7UQOVTpNo3Vi7pXTOqZ6bh3ZA/fs56jDCCKV6+wT/pCeu8N6vVnPrD\nz3SdHIeNeWb/woazCwIDAQAB", 0)));
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, rSAPublicKey);
            doFinal = instance.doFinal(str.getBytes());
        } catch (Exception e) {
            doFinal = null;
        }
        return doFinal;
    }

    public static String d(Context context) {
        String str = "";
        if (context == null) {
            ct.d("getAndroidId but context == null!", new Object[0]);
            return str;
        }
        try {
            str = Secure.getString(context.getContentResolver(), "android_id");
            if (str == null) {
                return "";
            }
            return str.toLowerCase();
        } catch (Throwable th) {
            ct.d("getAndroidId error!", new Object[0]);
            ct.a(th);
            return str;
        }
    }

    public static String e(Context context) {
        Throwable th;
        int i = 0;
        String str = "";
        if (context == null) {
            ct.d("getMacAddress but context == null!", new Object[0]);
            return str;
        }
        String macAddress;
        try {
            if (Integer.valueOf(VERSION.SDK).intValue() < 23) {
                macAddress = ((WifiManager) context.getSystemService(TencentExtraKeys.LOCATION_SOURCE_WIFI)).getConnectionInfo().getMacAddress();
                if (macAddress != null) {
                    return macAddress.toLowerCase();
                }
                try {
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    ct.a(th);
                    return macAddress;
                }
            }
            String[] strArr = new String[]{"/sys/class/net/wlan0/address", "/sys/devices/virtual/net/wlan0/address"};
            macAddress = str;
            while (i < 2) {
                macAddress = e(strArr[i]).toString().trim();
                if (macAddress != null && macAddress.length() > 0) {
                    return macAddress.toLowerCase();
                }
                i++;
            }
            return macAddress;
        } catch (Throwable th3) {
            th = th3;
            macAddress = str;
            ct.a(th);
            return macAddress;
        }
    }

    private static byte[] a(byte[] bArr, int i, String str) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        ct.b("enD:} %d %d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i)});
        if (i != 1) {
            return i == 3 ? b(str, bArr) : null;
        } else {
            if (str == null || bArr == null) {
                return null;
            }
            try {
                Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
                instance.init(1, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes("UTF-8"))), new IvParameterSpec(str.getBytes("UTF-8")));
                return instance.doFinal(bArr);
            } catch (Throwable th) {
                ct.a(th);
                ct.d("err enD: %s", new Object[]{th.toString()});
                return null;
            }
        }
    }

    public static boolean c(String str) {
        boolean z = true;
        int length = str.length();
        while (true) {
            length--;
            if (length < 0) {
                return z;
            }
            char charAt = str.charAt(length);
            if (charAt < ' ' || charAt >= 127) {
                z = false;
            }
        }
    }

    public static synchronized int i(Context context) {
        int i = 0;
        synchronized (e.class) {
            if (context == null) {
                ct.c("context == null ||key < -1}", new Object[0]);
            } else {
                try {
                    SQLiteDatabase writableDatabase = cd.a(context).getWritableDatabase();
                    if (writableDatabase == null) {
                        ct.d("get db fail!,return ", new Object[0]);
                    } else {
                        i = writableDatabase.delete("t_strategy", String.format("%s = %d", new Object[]{"_key", Integer.valueOf(101)}), null);
                        ct.g("delete Strategy key} %d , num} %d", new Object[]{Integer.valueOf(101), Integer.valueOf(i)});
                    }
                } catch (Throwable th) {
                    ct.a(th);
                }
            }
        }
        return i;
    }

    private static byte[] b(byte[] bArr, int i, String str) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        if (i != 1) {
            return i == 3 ? a(str, bArr) : null;
        } else {
            if (str == null || bArr == null) {
                return null;
            }
            try {
                Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
                instance.init(2, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes("UTF-8"))), new IvParameterSpec(str.getBytes("UTF-8")));
                return instance.doFinal(bArr);
            } catch (Throwable th) {
                ct.a(th);
                ct.d("err unD: %s", new Object[]{th.toString()});
                return null;
            }
        }
    }

    private static byte[] a(byte[] bArr, int i) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        ct.b("zp: %s len: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(bArr.length)});
        OutputStream byteArrayOutputStream;
        if (i == 1) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
                ZipEntry zipEntry = new ZipEntry("zip");
                zipEntry.setSize((long) bArr.length);
                zipOutputStream.putNextEntry(zipEntry);
                zipOutputStream.write(bArr);
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                bArr = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return bArr;
            } catch (Throwable th) {
                ct.a(th);
                ct.d("err zp : %s", new Object[]{th.toString()});
                return null;
            }
        } else if (i != 2) {
            return null;
        } else {
            byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bArr;
        }
    }

    private static byte[] b(byte[] bArr, int i) {
        if (bArr == null || i == -1) {
            return bArr;
        }
        ct.b("unzp: %s len: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(bArr.length)});
        if (i != 1) {
            return i == 2 ? a(bArr) : null;
        } else {
            try {
                InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                ZipInputStream zipInputStream = new ZipInputStream(byteArrayInputStream);
                bArr = null;
                while (zipInputStream.getNextEntry() != null) {
                    byte[] bArr2 = new byte[1024];
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        int read = zipInputStream.read(bArr2, 0, 1024);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                }
                zipInputStream.close();
                byteArrayInputStream.close();
                return bArr;
            } catch (Throwable th) {
                ct.a(th);
                ct.d("err unzp}" + th.toString(), new Object[0]);
                return null;
            }
        }
    }

    public static int a(Context context, Long[] lArr) {
        ct.a(" RecordDAO.deleteRecordList() start", new Object[0]);
        if (context == null) {
            ct.d(" deleteRecordList() have null args!", new Object[0]);
            return -1;
        }
        ct.a(" RecordDAO.deleteRecordList() end", new Object[0]);
        return cb.a(context, lArr);
    }

    public static cn a(int i, c cVar, byte[] bArr, int i2, int i3) {
        ct.b("en2Req", new Object[0]);
        if (cVar == null) {
            ct.d("error no com info! ", new Object[0]);
            return null;
        }
        try {
            cn cnVar = new cn();
            synchronized (cVar) {
                cnVar.j = cVar.a();
                cnVar.k = cVar.b();
                cnVar.a = cVar.c();
                cnVar.b = cVar.j();
                cnVar.c = cVar.d();
                cnVar.d = cVar.e();
                cnVar.e = cVar.f();
                cnVar.l = "";
                if (i == 100) {
                    Map hashMap = new HashMap();
                    hashMap.put("A1", da.a());
                    hashMap.put("A2", cVar.i());
                    dd a = dd.a(cVar.l());
                    hashMap.put("A4", a.c());
                    hashMap.put("A6", a.b());
                    hashMap.put("A7", a.d());
                    hashMap.put("A3", a.e());
                    hashMap.put("A23", cVar.k());
                    hashMap.put("A31", a.f());
                    a(cVar.l());
                    hashMap.put("A33", g(cVar.l()));
                    if (a.g(cVar.l())) {
                        hashMap.put("A66", "F");
                    } else {
                        hashMap.put("A66", "B");
                    }
                    hashMap.put("A67", a.i(cVar.l()));
                    hashMap.put("A68", a.h(cVar.l()));
                    hashMap.put("A85", a.b ? "Y" : "N");
                    cnVar.l = a(hashMap);
                }
            }
            if (i == 4 || i == 2 || i == 1) {
                cnVar.l = a(da.c());
            }
            cnVar.f = i;
            cnVar.h = (byte) i3;
            cnVar.i = (byte) i2;
            if (bArr == null) {
                bArr = "".getBytes();
            }
            cnVar.g = bArr;
            return cnVar;
        } catch (Throwable th) {
            ct.a(th);
            return null;
        }
    }

    public static String d() {
        String str = null;
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            ct.d("getBrand error!", new Object[0]);
            ct.a(th);
            return str;
        }
    }

    public static String e() {
        String str = null;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            long blockSize = (long) statFs.getBlockSize();
            return (((((long) statFs.getBlockCount()) * blockSize) / 1024) / 1024);
        } catch (Throwable th) {
            ct.d("getDisplayMetrics error!", new Object[0]);
            ct.a(th);
            return str;
        }
    }

    public static String f(Context context) {
        if (a != null) {
            return g(context);
        }
        return "unknown";
    }

    public static String g(Context context) {
        String str = "unknown";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return str;
            }
            String str2;
            if (activeNetworkInfo.getType() == 1) {
                str2 = TencentExtraKeys.LOCATION_SOURCE_WIFI;
            } else {
                if (activeNetworkInfo.getType() == 0) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        switch (telephonyManager.getNetworkType()) {
                            case 1:
                                str2 = "GPRS";
                                break;
                            case 2:
                                str2 = "EDGE";
                                break;
                            case 3:
                                str2 = "UMTS";
                                break;
                            case 4:
                                str2 = "CDMA";
                                break;
                            case 5:
                                str2 = "EVDO_0";
                                break;
                            case 6:
                                str2 = "EVDO_A";
                                break;
                            case 7:
                                str2 = "1xRTT";
                                break;
                            case 8:
                                str2 = "HSDPA";
                                break;
                            case 9:
                                str2 = "HSUPA";
                                break;
                            case 10:
                                str2 = "HSPA";
                                break;
                            case 11:
                                str2 = "iDen";
                                break;
                            case 12:
                                str2 = "EVDO_B";
                                break;
                            case 13:
                                str2 = "LTE";
                                break;
                            case 14:
                                str2 = "eHRPD";
                                break;
                            case 15:
                                str2 = "HSPA+";
                                break;
                            default:
                                str2 = "unknown";
                                break;
                        }
                    }
                }
                str2 = str;
            }
            return str2;
        } catch (Throwable e) {
            ct.a(e);
        }
    }

    public static byte[] a(byte[] bArr, int i, int i2, String str) {
        byte[] bArr2 = null;
        if (bArr == null) {
            return bArr2;
        }
        try {
            return a(a(bArr, i), i2, str);
        } catch (Throwable th) {
            ct.a(th);
            return bArr2;
        }
    }

    public static byte[] b(byte[] bArr, int i, int i2, String str) {
        try {
            return b(b(bArr, i2, str), i);
        } catch (Throwable e) {
            ct.a(e);
            return null;
        }
    }

    public static String f() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/sys/block/mmcblk0/device/type")));
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            stringBuilder.append(readLine).append(",");
            bufferedReader = new BufferedReader(new FileReader(new File("/sys/block/mmcblk0/device/name")));
            readLine = bufferedReader.readLine();
            bufferedReader.close();
            stringBuilder.append(readLine).append(",");
            bufferedReader = new BufferedReader(new FileReader(new File("/sys/block/mmcblk0/device/cid")));
            readLine = bufferedReader.readLine();
            bufferedReader.close();
            stringBuilder.append(readLine);
        } catch (Throwable e) {
            ct.a(e);
        }
        return stringBuilder.toString();
    }

    public static String g() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
        } catch (Throwable th) {
            ct.a(th);
            return "";
        }
    }

    public static String e(String str) {
        String str2 = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            str2 = EncodingUtils.getString(bArr, "UTF-8");
            fileInputStream.close();
            return str2;
        } catch (Exception e) {
            ct.d("Read file %s failed.", new Object[]{str});
            return str2;
        }
    }

    private static String f(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (Throwable e) {
            ct.a(e);
            return str;
        }
    }

    private static String g(String str) {
        String f = f(str);
        if (f == null) {
            return f;
        }
        try {
            return f.substring(8, 24);
        } catch (Exception e) {
            return f;
        }
    }

    public static String b(Context context, int i) {
        try {
            dd a = dd.a(context);
            String a2 = a.a();
            return g(a2 + "_" + a.b() + "_" + new Date().getTime() + "_" + i);
        } catch (Exception e) {
            return null;
        }
    }

    public static String k(Context context) {
        try {
            String d = dd.a(context).d();
            String str = "";
            c m = c.m();
            if (m != null) {
                str = m.j();
            }
            return g(str + "_" + d + "_" + new Date().getTime() + "_" + ((int) (Math.random() * 2.147483647E9d)));
        } catch (Exception e) {
            return null;
        }
    }

    public static HashSet<String> a(ArrayList<String> arrayList) {
        int size = arrayList.size();
        if (arrayList == null || size <= 0) {
            return null;
        }
        HashSet<String> hashSet = new HashSet(size);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            hashSet.add((String) it.next());
        }
        return hashSet;
    }
}
