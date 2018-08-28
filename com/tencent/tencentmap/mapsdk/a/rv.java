package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Stack;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

public class rv {
    private String a;
    private b b;

    static class b extends AsyncTask<String, Void, Boolean> {
        private a a;

        public b(a aVar) {
            this.a = aVar;
        }

        private Boolean a(String... strArr) {
            if (strArr != null && strArr.length > 0) {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strArr[0]).openConnection();
                    httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                    if (httpURLConnection.getResponseCode() == 200) {
                        String headerField = httpURLConnection.getHeaderField("Content-Encoding");
                        boolean z = headerField != null && headerField.length() > 0 && headerField.toLowerCase().contains("gzip");
                        JSONObject jSONObject = new JSONObject(new String(rv.a(z ? new GZIPInputStream(httpURLConnection.getInputStream()) : httpURLConnection.getInputStream())));
                        if (jSONObject.optInt("error") != 0) {
                            return Boolean.valueOf(false);
                        }
                        jSONObject = jSONObject.optJSONObject("info");
                        if (jSONObject == null) {
                            return Boolean.valueOf(false);
                        }
                        jSONObject = jSONObject.optJSONObject("raster");
                        if (jSONObject == null) {
                            return Boolean.valueOf(false);
                        }
                        int optInt = jSONObject.optInt("style", 1000);
                        int optInt2 = jSONObject.optInt("version", ro.a);
                        int optInt3 = jSONObject.optInt("sat", ro.c);
                        int optInt4 = jSONObject.optInt("cur", ro.b);
                        sy a = sy.a();
                        a.a("tencent_style", optInt);
                        a.a("tencent_version", optInt2);
                        a.a("sat_version", optInt3);
                        a.a("tencent_clean_cache_version", optInt4);
                        new 1(this, sn.c() != optInt4, sn.d() != optInt3).start();
                        boolean z2 = (optInt3 != sn.d() ? 1 : 0) | (((optInt2 != sn.b() ? 1 : 0) | (optInt != sn.a() ? 1 : 0)) | (optInt4 != sn.c() ? 1 : 0));
                        sn.a(optInt, optInt2, optInt4, optInt3);
                        return Boolean.valueOf(z2);
                    }
                } catch (Exception e) {
                    new StringBuilder("check version got error:").append(e.getMessage());
                }
            }
            return Boolean.valueOf(false);
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            Boolean bool = (Boolean) obj;
            if (bool != null && this.a != null) {
                this.a.a(bool.booleanValue());
            }
        }
    }

    public rv(Context context, a aVar) {
        String a = sz.a(context);
        context.getPackageName();
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("https://confinfo.map.qq.com/confinfo?apikey=");
        stringBuilder.append(a);
        stringBuilder.append("&type=2");
        stringBuilder.append("&pf=Android_2D");
        stringBuilder.append("&uk=");
        stringBuilder.append(rk.b());
        this.a = stringBuilder.toString();
        this.b = new b(aVar);
    }

    public static double a(qw qwVar, qw qwVar2) {
        double c = qwVar.c();
        double b = qwVar.b();
        c *= 0.01745329251994329d;
        b *= 0.01745329251994329d;
        double c2 = qwVar2.c() * 0.01745329251994329d;
        double b2 = qwVar2.b() * 0.01745329251994329d;
        double sin = Math.sin(c);
        double sin2 = Math.sin(b);
        c = Math.cos(c);
        b = Math.cos(b);
        double sin3 = Math.sin(c2);
        double sin4 = Math.sin(b2);
        c2 = Math.cos(c2);
        b2 = Math.cos(b2);
        r18 = new double[3];
        double[] dArr = new double[]{c * b, b * sin, sin2};
        dArr[0] = b2 * c2;
        dArr[1] = b2 * sin3;
        dArr[2] = sin4;
        return Math.asin(Math.sqrt((((r18[0] - dArr[0]) * (r18[0] - dArr[0])) + ((r18[1] - dArr[1]) * (r18[1] - dArr[1]))) + ((r18[2] - dArr[2]) * (r18[2] - dArr[2]))) / 2.0d) * 1.27420015798544E7d;
    }

    public static qw a(ru ruVar) {
        return new qw((double) ((float) (57.29577951308232d * ((2.0d * Math.atan(Math.exp((((double) ((float) ((ruVar.a() * 180.0d) / 2.003750834E7d))) * 3.141592653589793d) / 180.0d))) - 1.5707963267948966d))), (double) ((float) ((ruVar.b() * 180.0d) / 2.003750834E7d)));
    }

    public static ru a(PointF pointF, ru ruVar, PointF pointF2, rs rsVar) {
        return new ru(ruVar.b() + (((double) (pointF.x - pointF2.x)) * rsVar.d()), ruVar.a() - (((double) (pointF.y - pointF2.y)) * rsVar.d()));
    }

    public static ru a(qw qwVar) {
        if (qwVar == null) {
            return null;
        }
        return new ru((qwVar.c() * 2.003750834E7d) / 180.0d, ((Math.log(Math.tan(((qwVar.b() + 90.0d) * 3.141592653589793d) / 360.0d)) / 0.017453292519943295d) * 2.003750834E7d) / 180.0d);
    }

    public static rw a(float f, Point point) {
        sa saVar = new sa();
        saVar.a(f);
        saVar.a(point);
        return saVar;
    }

    public static rw a(qs qsVar) {
        ry ryVar = new ry();
        ryVar.a(qsVar);
        return ryVar;
    }

    public static rw a(qx qxVar, int i, int i2, int i3) {
        rx rxVar = new rx();
        rxVar.a(qxVar);
        rxVar.c(i3);
        rxVar.a(i);
        rxVar.b(i2);
        return rxVar;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Stack stack = new Stack();
        stack.push(str);
        while (!stack.isEmpty()) {
            File file = new File((String) stack.peek());
            if (!file.exists()) {
                stack.pop();
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    file.delete();
                    stack.pop();
                } else {
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            stack.push(file2.getAbsolutePath());
                        } else {
                            file2.delete();
                        }
                    }
                }
            } else {
                file.delete();
                stack.pop();
            }
        }
        return true;
    }

    public static byte[] a(InputStream inputStream) {
        IOException e;
        Throwable th;
        byte[] bArr = null;
        Closeable byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr2 = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr2, 0, 4096);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                }
                byteArrayOutputStream.flush();
                bArr = byteArrayOutputStream.toByteArray();
                a(byteArrayOutputStream);
            } catch (IOException e2) {
                e = e2;
                try {
                    new StringBuilder("IO:").append(e.toString());
                    a(byteArrayOutputStream);
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    a(byteArrayOutputStream);
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            byteArrayOutputStream = bArr;
            new StringBuilder("IO:").append(e.toString());
            a(byteArrayOutputStream);
            return bArr;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = bArr;
            a(byteArrayOutputStream);
            throw th;
        }
        return bArr;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                return true;
            }
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            return file.mkdirs();
        } catch (Exception e) {
            return false;
        }
    }

    public final void a() {
        this.b.execute(new String[]{this.a});
    }
}
