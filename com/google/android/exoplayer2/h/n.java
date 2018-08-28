package com.google.android.exoplayer2.h;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.d.b;
import com.google.android.exoplayer2.h.q.c;
import com.google.android.exoplayer2.h.q.d;
import com.google.android.exoplayer2.h.q.e;
import com.google.android.exoplayer2.h.q.f;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.t;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.opensdk.constants.ConstantsAPI$AppSupportContentFlag;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class n implements q {
    private static final Pattern aBm = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> aBn = new AtomicReference();
    private final t<? super n> aAB;
    private InputStream aAC;
    private final boolean aBo;
    private final int aBp;
    private final int aBq;
    private final String aBr;
    private final l<String> aBs;
    private final f aBt;
    private final f aBu;
    private HttpURLConnection aBv;
    private long aBw;
    private long aBx;
    private long aBy;
    private long aBz;
    private i asJ;
    private boolean opened;

    public n(String str, t<? super n> tVar, int i, int i2, boolean z, f fVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        this.aBr = str;
        this.aBs = null;
        this.aAB = tVar;
        this.aBu = new f();
        this.aBp = i;
        this.aBq = i2;
        this.aBo = z;
        this.aBt = fVar;
    }

    public final Uri getUri() {
        return this.aBv == null ? null : Uri.parse(this.aBv.getURL().toString());
    }

    public final long a(i iVar) {
        this.asJ = iVar;
        this.aBz = 0;
        this.aBy = 0;
        try {
            int i;
            HttpURLConnection a;
            URL url = new URL(iVar.uri.toString());
            byte[] bArr = iVar.aAI;
            long j = iVar.position;
            long j2 = iVar.aAK;
            boolean lQ = iVar.lQ();
            if (this.aBo) {
                i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (i <= 20) {
                        a = a(url, bArr, j, j2, lQ, false);
                        int responseCode = a.getResponseCode();
                        if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && (bArr != null || (responseCode != 307 && responseCode != 308))) {
                            break;
                        }
                        bArr = null;
                        String headerField = a.getHeaderField("Location");
                        a.disconnect();
                        if (headerField == null) {
                            throw new ProtocolException("Null location redirect");
                        }
                        URL url2 = new URL(url, headerField);
                        String protocol = url2.getProtocol();
                        if ("https".equals(protocol) || "http".equals(protocol)) {
                            i = i2;
                            url = url2;
                        } else {
                            throw new ProtocolException("Unsupported protocol redirect: " + protocol);
                        }
                    }
                    throw new NoRouteToHostException("Too many redirects: " + i2);
                }
            }
            a = a(url, bArr, j, j2, lQ, true);
            this.aBv = a;
            try {
                i = this.aBv.getResponseCode();
                b.i("DefaultHttpDataSource", "open, responseCode:%d", Integer.valueOf(i));
                if (i < 200 || i > 299) {
                    Map headerFields = this.aBv.getHeaderFields();
                    lW();
                    e eVar = new e(i, headerFields, iVar);
                    if (i == 416) {
                        eVar.initCause(new g());
                    }
                    throw eVar;
                }
                String contentType = this.aBv.getContentType();
                if (this.aBs == null || this.aBs.Y(contentType)) {
                    long j3 = (i != 200 || iVar.position == 0) ? 0 : iVar.position;
                    this.aBw = j3;
                    if (iVar.lQ()) {
                        this.aBx = iVar.aAK;
                    } else if (iVar.aAK != -1) {
                        this.aBx = iVar.aAK;
                    } else {
                        j3 = a(this.aBv);
                        this.aBx = j3 != -1 ? j3 - this.aBw : -1;
                    }
                    try {
                        this.aAC = this.aBv.getInputStream();
                        this.opened = true;
                        if (this.aAB != null) {
                            this.aAB.lS();
                        }
                        return this.aBx;
                    } catch (IOException e) {
                        lW();
                        throw new c(e, iVar, 1);
                    }
                }
                lW();
                throw new d(contentType, iVar);
            } catch (IOException e2) {
                lW();
                throw new c("Unable to connect to " + iVar.uri.toString(), e2, iVar);
            }
        } catch (IOException e22) {
            throw new c("Unable to connect to " + iVar.uri.toString(), e22, iVar);
        }
    }

    public final int read(byte[] bArr, int i, int i2) {
        try {
            if (this.aBy != this.aBw) {
                Object obj = (byte[]) aBn.getAndSet(null);
                if (obj == null) {
                    obj = new byte[GLIcon.LEFT];
                }
                while (this.aBy != this.aBw) {
                    int read = this.aAC.read(obj, 0, (int) Math.min(this.aBw - this.aBy, (long) obj.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read == -1) {
                        throw new EOFException();
                    } else {
                        this.aBy += (long) read;
                        if (this.aAB != null) {
                            this.aAB.cW(read);
                        }
                    }
                }
                aBn.set(obj);
            }
            if (i2 == 0) {
                return 0;
            }
            if (this.aBx != -1) {
                long j = this.aBx - this.aBz;
                if (j == 0) {
                    return -1;
                }
                i2 = (int) Math.min((long) i2, j);
            }
            int read2 = this.aAC.read(bArr, i, i2);
            if (read2 != -1) {
                this.aBz += (long) read2;
                if (this.aAB == null) {
                    return read2;
                }
                this.aAB.cW(read2);
                return read2;
            } else if (this.aBx == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } catch (IOException e) {
            throw new c(e, this.asJ, 2);
        }
    }

    public final void close() {
        try {
            if (this.aAC != null) {
                HttpURLConnection httpURLConnection = this.aBv;
                long j = this.aBx == -1 ? this.aBx : this.aBx - this.aBz;
                if (t.SDK_INT == 19 || t.SDK_INT == 20) {
                    try {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        if (j != -1 ? j <= ConstantsAPI$AppSupportContentFlag.MMAPP_SUPPORT_XLSX : inputStream.read() == -1) {
                            String name = inputStream.getClass().getName();
                            if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                                Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                                declaredMethod.setAccessible(true);
                                declaredMethod.invoke(inputStream, new Object[0]);
                            }
                        }
                    } catch (Exception e) {
                    }
                }
                this.aAC.close();
            }
            this.aAC = null;
            lW();
            if (this.opened) {
                this.opened = false;
                if (this.aAB != null) {
                    this.aAB.lT();
                }
            }
        } catch (IOException e2) {
            throw new c(e2, this.asJ, 3);
        } catch (Throwable th) {
            this.aAC = null;
            lW();
            if (this.opened) {
                this.opened = false;
                if (this.aAB != null) {
                    this.aAB.lT();
                }
            }
        }
    }

    private HttpURLConnection a(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.aBp);
        httpURLConnection.setReadTimeout(this.aBq);
        if (this.aBt != null) {
            for (Entry entry : this.aBt.lX().entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        for (Entry entry2 : this.aBu.lX().entrySet()) {
            httpURLConnection.setRequestProperty((String) entry2.getKey(), (String) entry2.getValue());
        }
        if (!(j == 0 && j2 == -1)) {
            String str = "bytes=" + j + "-";
            if (j2 != -1) {
                str = str + ((j + j2) - 1);
            }
            httpURLConnection.setRequestProperty("Range", str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.aBr);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length != 0) {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
                return httpURLConnection;
            }
        }
        httpURLConnection.connect();
        return httpURLConnection;
    }

    private static long a(HttpURLConnection httpURLConnection) {
        long j = -1;
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (!TextUtils.isEmpty(headerField)) {
            try {
                j = Long.parseLong(headerField);
            } catch (NumberFormatException e) {
                b.e("DefaultHttpDataSource", "Unexpected Content-Length [" + headerField + "]", new Object[0]);
            }
        }
        String headerField2 = httpURLConnection.getHeaderField("Content-Range");
        if (TextUtils.isEmpty(headerField2)) {
            return j;
        }
        Matcher matcher = aBm.matcher(headerField2);
        if (!matcher.find()) {
            return j;
        }
        try {
            long parseLong = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
            if (j < 0) {
                return parseLong;
            }
            if (j == parseLong) {
                return j;
            }
            b.w("DefaultHttpDataSource", "Inconsistent headers [" + headerField + "] [" + headerField2 + "]", new Object[0]);
            return Math.max(j, parseLong);
        } catch (NumberFormatException e2) {
            b.e("DefaultHttpDataSource", "Unexpected Content-Range [" + headerField2 + "]", new Object[0]);
            return j;
        }
    }

    private void lW() {
        if (this.aBv != null) {
            try {
                this.aBv.disconnect();
            } catch (Exception e) {
                b.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.aBv = null;
        }
    }
}
