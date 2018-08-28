package com.tencent.tencentmap.mapsdk.dynamic;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Base64;
import com.tencent.tencentmap.mapsdk.a.i;
import com.tencent.tencentmap.mapsdk.a.j;
import com.tencent.tencentmap.mapsdk.a.k;
import com.tencent.tencentmap.mapsdk.a.l;
import com.tencent.tencentmap.mapsdk.a.s;
import com.tencent.tencentmap.mapsdk.a.t;
import com.tencent.tencentmap.mapsdk.a.u;
import com.tencent.tencentmap.mapsdk.a.v;
import com.tencent.tencentmap.mapsdk.a.w;
import com.tencent.tencentmap.mapsdk.map.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements IInitializer {
    private static final String[] a = new String[]{"1.0.0", BuildConfig.VERSION_NAME};
    private static volatile b b;
    private static l d;
    private static volatile boolean f;
    private Context c;
    private v e = v.a(this.c);
    private boolean g;

    private b(Context context) {
        this.c = context;
        j.a(this.c);
        t.a(this.c);
        d = l.a(context);
    }

    public static b a(Context context) {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b(context.getApplicationContext());
                }
            }
        }
        return b;
    }

    public void downLoadVectorMapResource() {
        a();
    }

    protected boolean a() {
        this.g = d();
        if (!this.g) {
            this.e.a(0);
        }
        new Thread(new 1(this)).start();
        return this.g;
    }

    private boolean d() {
        if (e() && b()) {
            return true;
        }
        return false;
    }

    protected boolean b() {
        if (a(new File(d.b() + File.separator + "mapconfig.dat"), this.e.b()) && a(new File(d.b() + File.separator + "poi_icon.png"), this.e.c())) {
            return true;
        }
        return false;
    }

    private boolean e() {
        boolean z = true;
        if (!BuildConfig.VERSION_NAME.equals(this.e.e())) {
            this.e.d(BuildConfig.VERSION_NAME);
            for (int length = a.length - 1; length > 0; length--) {
                if (b(a[length])) {
                    this.e.a(a);
                    break;
                }
            }
            z = false;
            this.e.a(a);
        }
        return z;
    }

    private boolean a(File file, String str) {
        try {
            String a = s.a(file);
            if (a != null) {
                return a.equals(str);
            }
            return false;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    private a f() {
        HttpURLConnection httpURLConnection;
        Throwable th;
        HttpURLConnection httpURLConnection2;
        Closeable closeable;
        int i = 0;
        String str = "http://apikey.map.qq.com/sdkapis/v1/getresource?";
        Map treeMap = new TreeMap();
        treeMap.put("ota_ver", i());
        treeMap.put("sdk_ver", BuildConfig.VERSION_NAME);
        treeMap.put("arch", "wx");
        treeMap.put("imei", t.b());
        treeMap.put("system", "0");
        treeMap.put("device", t.c());
        treeMap.put("sys_version", t.d());
        treeMap.put("module", "0");
        treeMap.put("appname", t.e());
        treeMap.put("package_name", t.f());
        treeMap.put("apikey", t.g());
        Object obj = "";
        NetworkInfo b = u.b(this.c);
        if (b != null) {
            obj = b.getTypeName();
        }
        treeMap.put("env", obj);
        treeMap.put("timestamp", Long.toString(System.currentTimeMillis() / 1000));
        String str2 = str + Uri.encode(a(treeMap), "&=_");
        HttpURLConnection httpURLConnection3 = null;
        Closeable closeable2 = null;
        Closeable closeable3 = null;
        while (i < 3) {
            try {
                Closeable byteArrayOutputStream;
                httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (MalformedURLException e) {
                    k.a(closeable3);
                    k.a(closeable2);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    i++;
                    httpURLConnection3 = httpURLConnection;
                } catch (Exception e2) {
                    k.a(closeable3);
                    k.a(closeable2);
                    if (httpURLConnection == null) {
                        httpURLConnection.disconnect();
                    }
                    i++;
                    httpURLConnection3 = httpURLConnection;
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection2 = httpURLConnection;
                    closeable = closeable2;
                }
                try {
                    byte[] bArr = new byte[4096];
                    closeable3 = httpURLConnection.getInputStream();
                    while (true) {
                        int read = closeable3.read(bArr, 0, 4096);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                        byteArrayOutputStream.flush();
                    }
                    a a = a(new String(byteArrayOutputStream.toByteArray(), "utf-8"));
                    k.a(closeable3);
                    k.a(byteArrayOutputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return a;
                } catch (MalformedURLException e3) {
                    closeable2 = byteArrayOutputStream;
                } catch (Exception e4) {
                    closeable2 = byteArrayOutputStream;
                    k.a(closeable3);
                    k.a(closeable2);
                    if (httpURLConnection == null) {
                        httpURLConnection.disconnect();
                    }
                    i++;
                    httpURLConnection3 = httpURLConnection;
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection2 = httpURLConnection;
                    closeable = byteArrayOutputStream;
                }
            } catch (MalformedURLException e5) {
                httpURLConnection = httpURLConnection3;
                k.a(closeable3);
                k.a(closeable2);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                i++;
                httpURLConnection3 = httpURLConnection;
            } catch (Exception e6) {
                httpURLConnection = httpURLConnection3;
                k.a(closeable3);
                k.a(closeable2);
                if (httpURLConnection == null) {
                    httpURLConnection.disconnect();
                }
                i++;
                httpURLConnection3 = httpURLConnection;
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection2 = httpURLConnection3;
                closeable = closeable2;
            }
        }
        return null;
        k.a(closeable3);
        k.a(closeable);
        if (httpURLConnection2 != null) {
            httpURLConnection2.disconnect();
        }
        throw th;
    }

    private String a(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] strArr = (String[]) map.keySet().toArray(new String[map.keySet().size()]);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length - 1) {
                break;
            }
            stringBuilder.append(strArr[i2]).append("=").append((String) map.get(strArr[i2])).append("&");
            i = i2 + 1;
        }
        stringBuilder.append(strArr[strArr.length - 1]).append("=").append((String) map.get(strArr[strArr.length - 1]));
        String str = null;
        try {
            str = s.a(w.a(Base64.encodeToString(stringBuilder.toString().getBytes("utf-8"), 2)));
        } catch (UnsupportedEncodingException e) {
            i.a("Hash params failed with error:" + e.getMessage());
        }
        return stringBuilder.append("&sig=").append(str).toString();
    }

    private a a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            a aVar = new a(null);
            try {
                aVar.a = jSONObject.getInt("status");
            } catch (JSONException e) {
            }
            try {
                aVar.b = jSONObject.getString("message");
            } catch (JSONException e2) {
            }
            try {
                aVar.c = jSONObject.getString("version");
            } catch (JSONException e3) {
            }
            try {
                aVar.d = jSONObject.getString("full_location");
            } catch (JSONException e4) {
            }
            try {
                aVar.e = jSONObject.getString("full_md5");
            } catch (JSONException e5) {
            }
            try {
                aVar.f = jSONObject.getInt("full_size");
            } catch (JSONException e6) {
            }
            try {
                aVar.g = jSONObject.getString("increment_location");
            } catch (JSONException e7) {
            }
            try {
                aVar.h = jSONObject.getString("increment_md5");
            } catch (JSONException e8) {
            }
            try {
                aVar.i = jSONObject.getInt("increment_size");
            } catch (JSONException e9) {
            }
            try {
                if (jSONObject.getString("enforcement").equals("15151515")) {
                    aVar.j = true;
                } else {
                    aVar.j = false;
                }
            } catch (JSONException e10) {
            }
            try {
                if (jSONObject.getInt("ver_consisten") == 1) {
                    aVar.k = true;
                    return aVar;
                }
                aVar.k = false;
                return aVar;
            } catch (JSONException e11) {
                return aVar;
            }
        } catch (JSONException e12) {
            return null;
        }
    }

    protected void a(boolean z) {
        if (System.currentTimeMillis() - this.e.d() >= 3600000) {
            a f = f();
            if (f == null || f.a != 0 || !f.k || (b(f.c) && !z)) {
                this.e.a(System.currentTimeMillis());
                return;
            }
            File a = a(f.g, f.h, f.i);
            if (a == null) {
                a = a(f.d, f.e, f.f);
            }
            if (a != null) {
                if (a(a)) {
                    this.e.a(f.c);
                    this.e.a(System.currentTimeMillis());
                }
                a.deleteOnExit();
                g();
                k.a(d.a());
            }
        }
    }

    private void g() {
        Closeable inputStream;
        MalformedURLException e;
        Closeable closeable;
        HttpURLConnection httpURLConnection;
        IOException e2;
        Throwable th;
        String str = "http://apikey.map.qq.com/sdkapis/v1/getresource?";
        Map treeMap = new TreeMap();
        treeMap.put("qt", "fb");
        treeMap.put("ota_ver", i());
        treeMap.put("sdk_ver", BuildConfig.VERSION_NAME);
        treeMap.put("arch", t.a());
        treeMap.put("imei", t.b());
        treeMap.put("system", "0");
        treeMap.put("device", t.c());
        treeMap.put("sys_version", t.d());
        treeMap.put("module", "0");
        treeMap.put("appname", t.e());
        treeMap.put("package_name", t.f());
        treeMap.put("apikey", t.g());
        Object obj = "";
        NetworkInfo b = u.b(this.c);
        if (b != null) {
            obj = b.getTypeName();
        }
        treeMap.put("env", obj);
        treeMap.put("timestamp", Long.toString(System.currentTimeMillis() / 1000));
        treeMap.put("type", "0");
        treeMap.put("status", "ok");
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str + Uri.encode(a(treeMap), "&=_")).openConnection();
            try {
                httpURLConnection2.setDoOutput(true);
                inputStream = httpURLConnection2.getInputStream();
            } catch (MalformedURLException e3) {
                e = e3;
                closeable = null;
                httpURLConnection = httpURLConnection2;
                inputStream = null;
            } catch (IOException e4) {
                e2 = e4;
                closeable = null;
                httpURLConnection = httpURLConnection2;
                inputStream = null;
                i.a("feedback failed with error:" + e2.getMessage());
                k.a(inputStream);
                k.a(closeable);
                if (httpURLConnection == null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th2) {
                th = th2;
                closeable = null;
                httpURLConnection = httpURLConnection2;
                inputStream = null;
                k.a(inputStream);
                k.a(closeable);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
            try {
                closeable = new ByteArrayOutputStream();
            } catch (MalformedURLException e5) {
                e = e5;
                closeable = null;
                httpURLConnection = httpURLConnection2;
                try {
                    i.a("feedback failed with error:" + e.getMessage());
                    k.a(inputStream);
                    k.a(closeable);
                    if (httpURLConnection == null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    k.a(inputStream);
                    k.a(closeable);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e2 = e6;
                closeable = null;
                httpURLConnection = httpURLConnection2;
                i.a("feedback failed with error:" + e2.getMessage());
                k.a(inputStream);
                k.a(closeable);
                if (httpURLConnection == null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th4) {
                th = th4;
                closeable = null;
                httpURLConnection = httpURLConnection2;
                k.a(inputStream);
                k.a(closeable);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr, 0, 1024);
                    if (read == -1) {
                        break;
                    }
                    closeable.write(bArr, 0, read);
                    closeable.flush();
                }
                k.a(inputStream);
                k.a(closeable);
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (MalformedURLException e7) {
                e = e7;
                httpURLConnection = httpURLConnection2;
                i.a("feedback failed with error:" + e.getMessage());
                k.a(inputStream);
                k.a(closeable);
                if (httpURLConnection == null) {
                    httpURLConnection.disconnect();
                }
            } catch (IOException e8) {
                e2 = e8;
                httpURLConnection = httpURLConnection2;
                i.a("feedback failed with error:" + e2.getMessage());
                k.a(inputStream);
                k.a(closeable);
                if (httpURLConnection == null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th5) {
                th = th5;
                httpURLConnection = httpURLConnection2;
                k.a(inputStream);
                k.a(closeable);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (MalformedURLException e9) {
            e = e9;
            closeable = null;
            httpURLConnection = null;
            inputStream = null;
            i.a("feedback failed with error:" + e.getMessage());
            k.a(inputStream);
            k.a(closeable);
            if (httpURLConnection == null) {
                httpURLConnection.disconnect();
            }
        } catch (IOException e10) {
            e2 = e10;
            closeable = null;
            httpURLConnection = null;
            inputStream = null;
            i.a("feedback failed with error:" + e2.getMessage());
            k.a(inputStream);
            k.a(closeable);
            if (httpURLConnection == null) {
                httpURLConnection.disconnect();
            }
        } catch (Throwable th32) {
            th = th32;
            closeable = null;
            httpURLConnection = null;
            inputStream = null;
            k.a(inputStream);
            k.a(closeable);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    protected boolean a(File file) {
        k.b(d.b());
        try {
            k.a(file, d.b());
            try {
                this.e.b(s.a(new File(d.b() + "mapconfig.dat")));
                try {
                    this.e.c(s.a(new File(d.b() + "poi_icon.png")));
                    return true;
                } catch (FileNotFoundException e) {
                    return false;
                }
            } catch (FileNotFoundException e2) {
                return false;
            }
        } catch (IOException e3) {
            return false;
        }
    }

    private File a(String str, String str2, int i) {
        HttpURLConnection httpURLConnection;
        Closeable closeable;
        Closeable closeable2;
        MalformedURLException e;
        Throwable th;
        IOException e2;
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty() || i < 0 || !u.a(this.c)) {
            return null;
        }
        k.b(d.a());
        File file = new File(d.a() + File.separator + str.substring(str.lastIndexOf(47) + 1));
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e3) {
                i.a("Downloading file can't be create:" + e3.getMessage());
                return null;
            }
        }
        int i2 = 0;
        httpURLConnection = null;
        closeable = null;
        closeable2 = null;
        while (i2 < 3) {
            HttpURLConnection httpURLConnection2;
            Closeable fileOutputStream;
            try {
                httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    closeable2 = httpURLConnection2.getInputStream();
                    fileOutputStream = new FileOutputStream(file, false);
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = closeable2.read(bArr, 0, 4096);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                            fileOutputStream.flush();
                        }
                        k.a(closeable2);
                        k.a(fileOutputStream);
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        if (file.length() != ((long) i)) {
                            return null;
                        }
                        try {
                            if (s.a(file).equals(str2)) {
                                return file;
                            }
                            return null;
                        } catch (FileNotFoundException e4) {
                            i.a("Calculate downloaded file md5 failed:" + e4.getMessage());
                            return null;
                        }
                    } catch (MalformedURLException e5) {
                        e = e5;
                        try {
                            i.a("Downloading vector lib failed with error:" + e.getMessage());
                            k.a(closeable2);
                            k.a(fileOutputStream);
                            if (httpURLConnection2 == null) {
                                httpURLConnection2.disconnect();
                            }
                            i2++;
                            httpURLConnection = httpURLConnection2;
                            closeable = fileOutputStream;
                        } catch (Throwable th2) {
                            th = th2;
                            httpURLConnection = httpURLConnection2;
                            closeable = fileOutputStream;
                        }
                    } catch (IOException e6) {
                        e2 = e6;
                        i.a("Downloading vector lib failed with error:" + e2.getMessage());
                        k.a(closeable2);
                        k.a(fileOutputStream);
                        if (httpURLConnection2 == null) {
                            httpURLConnection2.disconnect();
                        }
                        i2++;
                        httpURLConnection = httpURLConnection2;
                        closeable = fileOutputStream;
                    }
                } catch (MalformedURLException e7) {
                    e = e7;
                    fileOutputStream = closeable;
                    i.a("Downloading vector lib failed with error:" + e.getMessage());
                    k.a(closeable2);
                    k.a(fileOutputStream);
                    if (httpURLConnection2 == null) {
                        httpURLConnection2.disconnect();
                    }
                    i2++;
                    httpURLConnection = httpURLConnection2;
                    closeable = fileOutputStream;
                } catch (IOException e8) {
                    e2 = e8;
                    fileOutputStream = closeable;
                    i.a("Downloading vector lib failed with error:" + e2.getMessage());
                    k.a(closeable2);
                    k.a(fileOutputStream);
                    if (httpURLConnection2 == null) {
                        httpURLConnection2.disconnect();
                    }
                    i2++;
                    httpURLConnection = httpURLConnection2;
                    closeable = fileOutputStream;
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection2;
                }
            } catch (MalformedURLException e9) {
                e = e9;
                httpURLConnection2 = httpURLConnection;
                fileOutputStream = closeable;
                i.a("Downloading vector lib failed with error:" + e.getMessage());
                k.a(closeable2);
                k.a(fileOutputStream);
                if (httpURLConnection2 == null) {
                    httpURLConnection2.disconnect();
                }
                i2++;
                httpURLConnection = httpURLConnection2;
                closeable = fileOutputStream;
            } catch (IOException e10) {
                e2 = e10;
                httpURLConnection2 = httpURLConnection;
                fileOutputStream = closeable;
                i.a("Downloading vector lib failed with error:" + e2.getMessage());
                k.a(closeable2);
                k.a(fileOutputStream);
                if (httpURLConnection2 == null) {
                    httpURLConnection2.disconnect();
                }
                i2++;
                httpURLConnection = httpURLConnection2;
                closeable = fileOutputStream;
            } catch (Throwable th4) {
                th = th4;
            }
        }
        if (file.length() != ((long) i)) {
            return null;
        }
        try {
            if (s.a(file).equals(str2)) {
                return file;
            }
            return null;
        } catch (FileNotFoundException e42) {
            i.a("Calculate downloaded file md5 failed:" + e42.getMessage());
            return null;
        }
        k.a(closeable2);
        k.a(closeable);
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        throw th;
    }

    private String[] h() {
        if (this.e.a() != null) {
            return this.e.a();
        }
        this.e.a(a);
        return a;
    }

    private String i() {
        String[] h = h();
        return h[h.length - 1];
    }

    private boolean b(String str) {
        String[] h = h();
        if (str == null || h == null) {
            return false;
        }
        for (int length = h.length - 1; length > 0; length--) {
            if (str.equals(h[length])) {
                return true;
            }
        }
        return false;
    }
}
