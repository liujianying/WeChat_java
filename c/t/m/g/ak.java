package c.t.m.g;

import android.os.SystemClock;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;

public final class ak extends ae {
    boolean A = false;
    private HttpURLConnection B;
    private DataOutputStream C;
    private DataInputStream D;
    private String E;
    private ai F;
    aj o;
    boolean p;
    boolean q;
    String r = "";
    int s;
    long t = 0;
    String u;
    a v = new a((byte) 0);
    long w;
    boolean x = false;
    boolean y = false;
    int z = 0;

    public ak(String str, String str2, boolean z, Map<String, String> map, byte[] bArr, int i, String str3) {
        this.E = str;
        this.b = str2;
        this.c = z;
        this.d = map;
        this.e = bArr;
        int a = p.g() == 2 ? w.a("direct_access_time_out", BaseReportManager.MAX_READ_COUNT, 60000, 15000) : w.a("direct_access_time_out", BaseReportManager.MAX_READ_COUNT, 60000, 10000);
        if (i >= a) {
            i = a;
        }
        this.f = ci.a(i, 200, 60000, 10000);
        this.g = str3;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r9) {
        /*
        r8 = this;
        r1 = 0;
        r3 = new java.io.BufferedInputStream;	 Catch:{ OutOfMemoryError -> 0x0048, Exception -> 0x0065 }
        r0 = r8.B;	 Catch:{ OutOfMemoryError -> 0x0048, Exception -> 0x0065 }
        r0 = r0.getInputStream();	 Catch:{ OutOfMemoryError -> 0x0048, Exception -> 0x0065 }
        r3.<init>(r0);	 Catch:{ OutOfMemoryError -> 0x0048, Exception -> 0x0065 }
        r4 = new java.io.ByteArrayOutputStream;	 Catch:{ OutOfMemoryError -> 0x0048, Exception -> 0x0065 }
        r4.<init>();	 Catch:{ OutOfMemoryError -> 0x0048, Exception -> 0x0065 }
        r0 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r5 = new byte[r0];	 Catch:{ OutOfMemoryError -> 0x0048, Exception -> 0x0065 }
        r2 = 1;
        r0 = r1;
    L_0x0017:
        r6 = r3.read(r5);	 Catch:{ OutOfMemoryError -> 0x0076, Exception -> 0x0065 }
        r7 = -1;
        if (r6 == r7) goto L_0x0078;
    L_0x001e:
        r7 = 0;
        r4.write(r5, r7, r6);	 Catch:{ OutOfMemoryError -> 0x0076, Exception -> 0x0065 }
        r0 = r0 + r6;
        if (r0 <= r9) goto L_0x0017;
    L_0x0025:
        r2 = r8.o;	 Catch:{ OutOfMemoryError -> 0x0076, Exception -> 0x0065 }
        r3 = -303; // 0xfffffffffffffed1 float:NaN double:NaN;
        r2.a = r3;	 Catch:{ OutOfMemoryError -> 0x0076, Exception -> 0x0065 }
        r2 = r8.o;	 Catch:{ OutOfMemoryError -> 0x0076, Exception -> 0x0065 }
        r3 = "no-content-length";
        r2.b = r3;	 Catch:{ OutOfMemoryError -> 0x0076, Exception -> 0x0065 }
    L_0x0032:
        if (r1 == 0) goto L_0x0044;
    L_0x0034:
        r1 = r8.o;	 Catch:{ OutOfMemoryError -> 0x0076, Exception -> 0x0065 }
        r2 = r4.toByteArray();	 Catch:{ OutOfMemoryError -> 0x0076, Exception -> 0x0065 }
        r1.d = r2;	 Catch:{ OutOfMemoryError -> 0x0076, Exception -> 0x0065 }
        r1 = r8.v;	 Catch:{ OutOfMemoryError -> 0x0076, Exception -> 0x0065 }
        r2 = android.os.SystemClock.elapsedRealtime();	 Catch:{ OutOfMemoryError -> 0x0076, Exception -> 0x0065 }
        r1.f = r2;	 Catch:{ OutOfMemoryError -> 0x0076, Exception -> 0x0065 }
    L_0x0044:
        r4.close();	 Catch:{ Exception -> 0x0074, OutOfMemoryError -> 0x0076 }
    L_0x0047:
        return;
    L_0x0048:
        r0 = move-exception;
        r0 = r1;
    L_0x004a:
        r1 = r8.o;
        r2 = -306; // 0xfffffffffffffece float:NaN double:NaN;
        r1.a = r2;
        r1 = r8.o;
        r2 = new java.lang.StringBuilder;
        r3 = "no-content-length:";
        r2.<init>(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.b = r0;
        goto L_0x0047;
    L_0x0065:
        r0 = move-exception;
        r0 = r8.o;
        r1 = -287; // 0xfffffffffffffee1 float:NaN double:NaN;
        r0.a = r1;
        r0 = r8.o;
        r1 = "read without content-length error";
        r0.b = r1;
        goto L_0x0047;
    L_0x0074:
        r0 = move-exception;
        goto L_0x0047;
    L_0x0076:
        r1 = move-exception;
        goto L_0x004a;
    L_0x0078:
        r1 = r2;
        goto L_0x0032;
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.ak.a(int):void");
    }

    private void b() {
        Object obj = null;
        if (this.d != null && this.d.size() > 0) {
            Object obj2;
            Iterator it = this.d.keySet().iterator();
            while (true) {
                obj2 = obj;
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                this.B.addRequestProperty(str, (String) this.d.get(str));
                obj = str.toLowerCase().contains("host") ? 1 : obj2;
            }
            obj = obj2;
        }
        if (obj == null) {
            this.B.setRequestProperty("Host", this.E);
        }
        this.B.setRequestProperty("Halley", this.g + "-" + this.z + "-" + System.currentTimeMillis());
        if (this.y) {
            this.B.setRequestProperty("Connection", "close");
        }
        if (this.x) {
            this.B.setRequestProperty("X-Online-Host", this.E);
            this.B.setRequestProperty("x-tx-host", this.E);
        }
    }

    private void c() {
        try {
            if (this.B != null) {
                this.B.disconnect();
            }
            if (this.C != null) {
                this.C.close();
            }
            if (this.D != null) {
                this.D.close();
            }
        } catch (Throwable th) {
        }
    }

    public final aj a() {
        int i = 1;
        this.m = System.currentTimeMillis();
        this.w = SystemClock.elapsedRealtime();
        this.v.a = this.w;
        this.o = new aj(0, "");
        try {
            HttpURLConnection httpURLConnection;
            URL url = new URL(this.b);
            this.p = url.getProtocol().toLowerCase().startsWith("https");
            this.q = ci.d(url.getHost());
            if (this.p) {
                if (!this.x || p.k() == null) {
                    HttpsURLConnection httpURLConnection2 = (HttpsURLConnection) url.openConnection();
                } else {
                    httpURLConnection2 = (HttpsURLConnection) url.openConnection(p.k());
                }
                if (this.q) {
                    this.F = new ai(this.E);
                    httpURLConnection2.setSSLSocketFactory(this.F);
                    httpURLConnection2.setHostnameVerifier(new ah(this.E));
                }
            } else {
                httpURLConnection2 = (!this.x || p.k() == null) ? (HttpURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection(p.k());
            }
            this.B = httpURLConnection2;
            this.B.setRequestMethod(this.c ? "GET" : "POST");
            this.B.setConnectTimeout(this.f);
            this.B.setReadTimeout(this.f);
            this.B.setUseCaches(false);
            this.B.setDoInput(true);
            this.B.setInstanceFollowRedirects(false);
            b();
            if (!(this.c || ci.a(this.e))) {
                this.B.setDoOutput(true);
                this.t = (long) this.e.length;
            }
            this.v.b = SystemClock.elapsedRealtime();
            this.B.connect();
            this.v.c = SystemClock.elapsedRealtime();
            if (!(this.c || ci.a(this.e))) {
                this.C = new DataOutputStream(this.B.getOutputStream());
                this.C.write(this.e);
                this.C.flush();
            }
            this.v.d = SystemClock.elapsedRealtime();
            int responseCode = this.B.getResponseCode();
            this.v.e = SystemClock.elapsedRealtime();
            this.o.c = responseCode;
            this.r = this.B.getContentType();
            Map hashMap = new HashMap();
            for (Entry entry : this.B.getHeaderFields().entrySet()) {
                if (entry.getKey() != null) {
                    hashMap.put(entry.getKey(), ((List) entry.getValue()).get(0));
                }
            }
            this.o.a(hashMap);
            if (this.o.c >= 200 && this.o.c < 300) {
                this.s = this.B.getContentLength();
                responseCode = w.a("app_receive_pack_size", 524288, 10485760, 2097152);
                if (this.s < 0) {
                    a(responseCode);
                } else if (this.s == 0) {
                    this.o.d = null;
                    this.v.f = SystemClock.elapsedRealtime();
                } else if (this.s > responseCode) {
                    this.o.a = -303;
                    this.o.b = this.s;
                } else {
                    try {
                        byte[] bArr = new byte[this.s];
                        this.D = new DataInputStream(this.B.getInputStream());
                        this.D.readFully(bArr);
                        this.o.d = bArr;
                        this.v.f = SystemClock.elapsedRealtime();
                    } catch (OutOfMemoryError e) {
                        this.o.a = -306;
                        this.o.b = this.s;
                    }
                }
            } else if (this.o.c < 300 || this.o.c >= 400) {
                this.u = ci.c(this.E);
            } else {
                this.h = this.o.a("location");
            }
            c();
            this.w = SystemClock.elapsedRealtime() - this.w;
            this.v.a();
        } catch (MalformedURLException e2) {
            this.o.a = -300;
            c();
            this.w = SystemClock.elapsedRealtime() - this.w;
            this.v.a();
        } catch (Throwable th) {
            c();
            this.w = SystemClock.elapsedRealtime() - this.w;
            this.v.a();
            throw th;
        }
        return this.o;
    }

    public final void a(boolean z) {
    }
}
