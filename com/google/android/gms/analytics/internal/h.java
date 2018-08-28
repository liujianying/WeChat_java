package com.google.android.gms.analytics.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.zip.GZIPOutputStream;

final class h extends o {
    private static final byte[] aFs = "\n".getBytes();
    private final String aFq;
    private final j aFr;

    h(q qVar) {
        super(qVar);
        String str = p.VERSION;
        String str2 = VERSION.RELEASE;
        String c = k.c(Locale.getDefault());
        String str3 = Build.MODEL;
        String str4 = Build.ID;
        this.aFq = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{"GoogleAnalytics", str, str2, c, str3, str4});
        this.aFr = new j(qVar.aFC);
    }

    private int a(URL url, byte[] bArr) {
        OutputStream outputStream;
        Object e;
        Throwable th;
        w.ah(url);
        w.ah(bArr);
        b("POST bytes, url", Integer.valueOf(bArr.length), url);
        if (no()) {
            d("Post payload\n", new String(bArr));
        }
        HttpURLConnection c;
        try {
            c = c(url);
            try {
                c.setDoOutput(true);
                c.setFixedLengthStreamingMode(bArr.length);
                c.connect();
                outputStream = c.getOutputStream();
            } catch (IOException e2) {
                e = e2;
                outputStream = null;
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e3) {
                        g("Error closing http post connection output stream", e3);
                    }
                }
                if (c != null) {
                    c.disconnect();
                }
                throw th;
            }
            try {
                outputStream.write(bArr);
                b(c);
                int responseCode = c.getResponseCode();
                if (responseCode == 200) {
                    this.aFn.nt().nk();
                }
                e("POST status", Integer.valueOf(responseCode));
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e32) {
                        g("Error closing http post connection output stream", e32);
                    }
                }
                if (c == null) {
                    return responseCode;
                }
                c.disconnect();
                return responseCode;
            } catch (IOException e4) {
                e = e4;
                try {
                    f("Network POST connection error", e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e5) {
                            g("Error closing http post connection output stream", e5);
                        }
                    }
                    if (c != null) {
                        c.disconnect();
                    }
                    return 0;
                } catch (Throwable th3) {
                    th = th3;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e322) {
                            g("Error closing http post connection output stream", e322);
                        }
                    }
                    if (c != null) {
                        c.disconnect();
                    }
                    throw th;
                }
            }
        } catch (IOException e6) {
            e = e6;
            outputStream = null;
            c = null;
            f("Network POST connection error", e);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e52) {
                    g("Error closing http post connection output stream", e52);
                }
            }
            if (c != null) {
                c.disconnect();
            }
            return 0;
        } catch (Throwable th4) {
            th = th4;
            outputStream = null;
            c = null;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e3222) {
                    g("Error closing http post connection output stream", e3222);
                }
            }
            if (c != null) {
                c.disconnect();
            }
            throw th;
        }
    }

    private URL a(c cVar) {
        try {
            return new URL(cVar.aFf ? ac.oa() + ac.oc() : ac.ob() + ac.oc());
        } catch (MalformedURLException e) {
            g("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private int b(URL url) {
        w.ah(url);
        e("GET request", url);
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = c(url);
            httpURLConnection.connect();
            b(httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                this.aFn.nt().nk();
            }
            e("GET status", Integer.valueOf(responseCode));
            if (httpURLConnection == null) {
                return responseCode;
            }
            httpURLConnection.disconnect();
            return responseCode;
        } catch (IOException e) {
            f("Network GET connection error", e);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return 0;
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private int b(URL url, byte[] bArr) {
        OutputStream outputStream;
        Object e;
        Throwable th;
        w.ah(url);
        w.ah(bArr);
        HttpURLConnection c;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            super.a(3, "POST compressed size, ratio %, url", Integer.valueOf(toByteArray.length), Long.valueOf((100 * ((long) toByteArray.length)) / ((long) bArr.length)), url);
            if (toByteArray.length > bArr.length) {
                c("Compressed payload is larger then uncompressed. compressed, uncompressed", Integer.valueOf(toByteArray.length), Integer.valueOf(bArr.length));
            }
            if (no()) {
                d("Post payload", "\n" + new String(bArr));
            }
            c = c(url);
            try {
                c.setDoOutput(true);
                c.addRequestProperty("Content-Encoding", "gzip");
                c.setFixedLengthStreamingMode(toByteArray.length);
                c.connect();
                outputStream = c.getOutputStream();
            } catch (IOException e2) {
                e = e2;
                outputStream = null;
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e3) {
                        g("Error closing http compressed post connection output stream", e3);
                    }
                }
                if (c != null) {
                    c.disconnect();
                }
                throw th;
            }
            try {
                outputStream.write(toByteArray);
                outputStream.close();
                b(c);
                int responseCode = c.getResponseCode();
                if (responseCode == 200) {
                    this.aFn.nt().nk();
                }
                e("POST status", Integer.valueOf(responseCode));
                if (c == null) {
                    return responseCode;
                }
                c.disconnect();
                return responseCode;
            } catch (IOException e4) {
                e = e4;
                try {
                    f("Network compressed POST connection error", e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e5) {
                            g("Error closing http compressed post connection output stream", e5);
                        }
                    }
                    if (c != null) {
                        c.disconnect();
                    }
                    return 0;
                } catch (Throwable th3) {
                    th = th3;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e32) {
                            g("Error closing http compressed post connection output stream", e32);
                        }
                    }
                    if (c != null) {
                        c.disconnect();
                    }
                    throw th;
                }
            }
        } catch (IOException e6) {
            e = e6;
            outputStream = null;
            c = null;
            f("Network compressed POST connection error", e);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e52) {
                    g("Error closing http compressed post connection output stream", e52);
                }
            }
            if (c != null) {
                c.disconnect();
            }
            return 0;
        } catch (Throwable th4) {
            th = th4;
            outputStream = null;
            c = null;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e322) {
                    g("Error closing http compressed post connection output stream", e322);
                }
            }
            if (c != null) {
                c.disconnect();
            }
            throw th;
        }
    }

    private URL b(c cVar, String str) {
        try {
            return new URL(cVar.aFf ? ac.oa() + ac.oc() + "?" + str : ac.ob() + ac.oc() + "?" + str);
        } catch (MalformedURLException e) {
            g("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private static void b(StringBuilder stringBuilder, String str, String str2) {
        if (stringBuilder.length() != 0) {
            stringBuilder.append('&');
        }
        stringBuilder.append(URLEncoder.encode(str, "UTF-8"));
        stringBuilder.append('=');
        stringBuilder.append(URLEncoder.encode(str2, "UTF-8"));
    }

    private void b(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            do {
            } while (inputStream.read(new byte[1024]) > 0);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    g("Error closing http connection input stream", e);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    g("Error closing http connection input stream", e2);
                }
            }
        }
    }

    private HttpURLConnection c(URL url) {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(((Integer) aj.aHV.get()).intValue());
            httpURLConnection.setReadTimeout(((Integer) aj.aHW.get()).intValue());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("User-Agent", this.aFq);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain http connection");
    }

    private URL mP() {
        try {
            return new URL(ac.oa() + ((String) aj.aHK.get()));
        } catch (MalformedURLException e) {
            g("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private List<Long> t(List<c> list) {
        List<Long> arrayList = new ArrayList(list.size());
        for (c cVar : list) {
            boolean z;
            w.ah(cVar);
            String a = a(cVar, !cVar.aFf);
            if (a == null) {
                this.aFn.nr().a(cVar, "Error formatting hit for upload");
                z = true;
            } else {
                URL b;
                if (a.length() <= ((Integer) aj.aHL.get()).intValue()) {
                    b = b(cVar, a);
                    if (b == null) {
                        aS("Failed to build collect GET endpoint url");
                    } else {
                        z = b(b) == 200;
                    }
                } else {
                    String a2 = a(cVar, false);
                    if (a2 == null) {
                        this.aFn.nr().a(cVar, "Error formatting hit for POST upload");
                        z = true;
                    } else {
                        byte[] bytes = a2.getBytes();
                        if (bytes.length > ((Integer) aj.aHQ.get()).intValue()) {
                            this.aFn.nr().a(cVar, "Hit payload exceeds size limit");
                            z = true;
                        } else {
                            b = a(cVar);
                            if (b == null) {
                                aS("Failed to build collect POST endpoint url");
                            } else if (a(b, bytes) == 200) {
                                z = true;
                            }
                        }
                    }
                }
                z = false;
            }
            if (!z) {
                break;
            }
            arrayList.add(Long.valueOf(cVar.aFc));
            if (arrayList.size() >= ac.nY()) {
                break;
            }
        }
        return arrayList;
    }

    final String a(c cVar, boolean z) {
        w.ah(cVar);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Entry entry : cVar.aFa.entrySet()) {
                String str = (String) entry.getKey();
                if (!("ht".equals(str) || "qt".equals(str) || "AppUID".equals(str) || "z".equals(str) || "_gmsv".equals(str))) {
                    b(stringBuilder, str, (String) entry.getValue());
                }
            }
            b(stringBuilder, "ht", String.valueOf(cVar.aFd));
            b(stringBuilder, "qt", String.valueOf(this.aFn.aFC.currentTimeMillis() - cVar.aFd));
            if (f.aNr) {
                b(stringBuilder, "_gmsv", p.VERSION);
            }
            if (z) {
                long aL = k.aL(cVar.l("_s", "0"));
                b(stringBuilder, "z", aL != 0 ? String.valueOf(aL) : String.valueOf(cVar.aFc));
            }
            return stringBuilder.toString();
        } catch (UnsupportedEncodingException e) {
            g("Failed to encode name or value", e);
            return null;
        }
    }

    protected final void mE() {
        d("Network initialized. User agent", this.aFq);
    }

    public final boolean mO() {
        NetworkInfo activeNetworkInfo;
        q.nx();
        np();
        try {
            activeNetworkInfo = ((ConnectivityManager) this.aFn.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        aO("No network connectivity");
        return false;
    }

    public final List<Long> s(List<c> list) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        q.nx();
        np();
        w.ah(list);
        if (this.aFn.aFV.od().isEmpty() || !this.aFr.Y(((long) ((Integer) aj.aHT.get()).intValue()) * 1000)) {
            z = false;
        } else {
            z = x.aY((String) aj.aHM.get()) != x.aGR;
            if (z.aZ((String) aj.aHN.get()) == z.aHb) {
                z2 = true;
                if (z) {
                    return t(list);
                }
                if (list.isEmpty()) {
                    z3 = false;
                }
                w.au(z3);
                a("Uploading batched hits. compression, count", Boolean.valueOf(z2), Integer.valueOf(list.size()));
                a aVar = new a(this);
                List<Long> arrayList = new ArrayList();
                for (c cVar : list) {
                    if (!aVar.b(cVar)) {
                        break;
                    }
                    arrayList.add(Long.valueOf(cVar.aFc));
                }
                if (aVar.aFt == 0) {
                    return arrayList;
                }
                URL mP = mP();
                if (mP == null) {
                    aS("Failed to build batching endpoint url");
                } else {
                    int b = z2 ? b(mP, aVar.aFu.toByteArray()) : a(mP, aVar.aFu.toByteArray());
                    if (200 == b) {
                        d("Batched upload completed. Hits batched", Integer.valueOf(aVar.aFt));
                        return arrayList;
                    }
                    d("Network error uploading hits. status code", Integer.valueOf(b));
                    if (this.aFn.aFV.od().contains(Integer.valueOf(b))) {
                        aR("Server instructed the client to stop batching");
                        this.aFr.start();
                    }
                }
                return Collections.emptyList();
            }
        }
        z2 = false;
        if (z) {
            return t(list);
        }
        if (list.isEmpty()) {
            z3 = false;
        }
        w.au(z3);
        a("Uploading batched hits. compression, count", Boolean.valueOf(z2), Integer.valueOf(list.size()));
        a aVar2 = new a(this);
        List<Long> arrayList2 = new ArrayList();
        for (c cVar2 : list) {
            if (!aVar2.b(cVar2)) {
                break;
            }
            arrayList2.add(Long.valueOf(cVar2.aFc));
        }
        if (aVar2.aFt == 0) {
            return arrayList2;
        }
        URL mP2 = mP();
        if (mP2 == null) {
            aS("Failed to build batching endpoint url");
        } else {
            int b2 = z2 ? b(mP2, aVar2.aFu.toByteArray()) : a(mP2, aVar2.aFu.toByteArray());
            if (200 == b2) {
                d("Batched upload completed. Hits batched", Integer.valueOf(aVar2.aFt));
                return arrayList2;
            }
            d("Network error uploading hits. status code", Integer.valueOf(b2));
            if (this.aFn.aFV.od().contains(Integer.valueOf(b2))) {
                aR("Server instructed the client to stop batching");
                this.aFr.start();
            }
        }
        return Collections.emptyList();
    }
}
