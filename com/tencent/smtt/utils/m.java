package com.tencent.smtt.utils;

import android.os.Build.VERSION;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class m {
    public static String a(String str, Map<String, String> map, byte[] bArr, a aVar, boolean z) {
        if (bArr == null) {
            return null;
        }
        HttpURLConnection a = a(str, (Map) map);
        if (a == null) {
            return null;
        }
        if (z) {
            a(a, bArr);
        } else {
            b(a, bArr);
        }
        return a(a, aVar, false);
    }

    public static String a(String str, byte[] bArr, a aVar, boolean z) {
        String c;
        if (z) {
            try {
                c = o.a().c();
            } catch (Exception e) {
                return null;
            }
        }
        c = n.a().b();
        c = str + c;
        if (z) {
            try {
                bArr = o.a().a(bArr);
            } catch (Exception e2) {
            }
        } else {
            bArr = n.a().a(bArr);
        }
        if (bArr == null) {
            return null;
        }
        Map hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Content-Length", String.valueOf(bArr.length));
        HttpURLConnection a = a(c, hashMap);
        if (a == null) {
            return null;
        }
        b(a, bArr);
        return a(a, aVar, z);
    }

    private static String a(HttpURLConnection httpURLConnection, a aVar, boolean z) {
        Closeable inflaterInputStream;
        Closeable byteArrayOutputStream;
        Throwable th;
        Closeable closeable;
        try {
            String str;
            int responseCode = httpURLConnection.getResponseCode();
            if (aVar != null) {
                aVar.a(responseCode);
            }
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                String contentEncoding = httpURLConnection.getContentEncoding();
                if (contentEncoding == null || !contentEncoding.equalsIgnoreCase("gzip")) {
                    if (contentEncoding != null) {
                        if (contentEncoding.equalsIgnoreCase("deflate")) {
                            inflaterInputStream = new InflaterInputStream(inputStream, new Inflater(true));
                        }
                    }
                    Object inflaterInputStream2 = inputStream;
                } else {
                    inflaterInputStream2 = new GZIPInputStream(inputStream);
                }
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Throwable th2) {
                    th = th2;
                    closeable = null;
                    a(inflaterInputStream2);
                    a(closeable);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[128];
                    while (true) {
                        int read = inflaterInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    str = z ? new String(byteArrayOutputStream.toByteArray(), "utf-8") : new String(n.a().c(byteArrayOutputStream.toByteArray()));
                } catch (Throwable th3) {
                    th = th3;
                    closeable = byteArrayOutputStream;
                    a(inflaterInputStream2);
                    a(closeable);
                    throw th;
                }
            }
            byteArrayOutputStream = null;
            inflaterInputStream2 = null;
            str = null;
            a(inflaterInputStream2);
            a(byteArrayOutputStream);
            return str;
        } catch (Throwable th22) {
            th = th22;
            closeable = null;
            inflaterInputStream2 = null;
            a(inflaterInputStream2);
            a(closeable);
            throw th;
        }
    }

    private static HttpURLConnection a(String str, Map<String, String> map) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(20000);
                if (VERSION.SDK_INT > 13) {
                    httpURLConnection.setRequestProperty("Connection", "close");
                } else {
                    httpURLConnection.setRequestProperty("http.keepAlive", "false");
                }
                for (Entry entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                return httpURLConnection;
            } catch (Exception e) {
                return httpURLConnection;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    private static void a(HttpURLConnection httpURLConnection, byte[] bArr) {
        Throwable th;
        Closeable closeable;
        Closeable gZIPOutputStream;
        try {
            gZIPOutputStream = new GZIPOutputStream(new BufferedOutputStream(httpURLConnection.getOutputStream(), 204800));
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.flush();
                a(null);
                a(gZIPOutputStream);
            } catch (Exception e) {
                a(null);
                a(gZIPOutputStream);
            } catch (Throwable th2) {
                th = th2;
                closeable = gZIPOutputStream;
                a(null);
                a(closeable);
                throw th;
            }
        } catch (Exception e2) {
            gZIPOutputStream = null;
            a(null);
            a(gZIPOutputStream);
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            a(null);
            a(closeable);
            throw th;
        }
    }

    private static void b(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.flush();
        } catch (Exception e) {
        }
    }
}
