package com.tencent.qqmusic.mediaplayer.network;

import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.UnknownServiceException;
import java.util.Map;

public class DefaultMediaHTTPConnection implements IMediaHTTPConnection {
    private static final int CONNECT_TIMEOUT_MS = 30000;
    private static final int HTTP_TEMP_REDIRECT = 307;
    private static final int MAX_REDIRECTS = 20;
    private static final String TAG = "MediaHTTPConnection";
    private static final boolean VERBOSE = false;
    private boolean mAllowCrossDomainRedirect = true;
    private boolean mAllowCrossProtocolRedirect = true;
    private HttpURLConnection mConnection = null;
    private long mCurrentOffset = -1;
    private Map<String, String> mHeaders = null;
    private InputStream mInputStream = null;
    private long mTotalSize = -1;
    private URL mURL = null;

    public boolean connect(URL url, Map<String, String> map) {
        disconnect();
        this.mAllowCrossDomainRedirect = true;
        this.mURL = url;
        this.mHeaders = map;
        return true;
    }

    private boolean parseBoolean(String str) {
        try {
            if (Long.parseLong(str) != 0) {
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            if ("true".equalsIgnoreCase(str) || "yes".equalsIgnoreCase(str)) {
                return true;
            }
            return false;
        }
    }

    private boolean filterOutInternalHeaders(String str, String str2) {
        if (!"android-allow-cross-domain-redirect".equalsIgnoreCase(str)) {
            return false;
        }
        this.mAllowCrossDomainRedirect = parseBoolean(str2);
        this.mAllowCrossProtocolRedirect = this.mAllowCrossDomainRedirect;
        return true;
    }

    public void disconnect() {
        teardownConnection();
        this.mHeaders = null;
        this.mURL = null;
    }

    private void teardownConnection() {
        if (this.mConnection != null) {
            this.mInputStream = null;
            this.mConnection.disconnect();
            this.mConnection = null;
            this.mCurrentOffset = -1;
        }
    }

    private static final boolean isLocalHost(URL url) {
        if (url == null) {
            return false;
        }
        String host = url.getHost();
        if (host == null) {
            return false;
        }
        try {
            if (host.equalsIgnoreCase("localhost")) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            Logger.e(TAG, "isLocalHost", e);
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void seekTo(long r10) {
        /*
        r9 = this;
        r9.teardownConnection();
        r1 = 0;
        r0 = r9.mURL;	 Catch:{ IOException -> 0x0084 }
        r5 = isLocalHost(r0);	 Catch:{ IOException -> 0x0084 }
        r4 = r1;
    L_0x000b:
        if (r5 == 0) goto L_0x007b;
    L_0x000d:
        r1 = java.net.Proxy.NO_PROXY;	 Catch:{ IOException -> 0x0084 }
        r0 = r0.openConnection(r1);	 Catch:{ IOException -> 0x0084 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ IOException -> 0x0084 }
        r9.mConnection = r0;	 Catch:{ IOException -> 0x0084 }
    L_0x0017:
        r0 = "MediaHTTPConnection";
        r1 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0084 }
        r2 = "setConnectTimeout ";
        r1.<init>(r2);	 Catch:{ IOException -> 0x0084 }
        r2 = r9.mURL;	 Catch:{ IOException -> 0x0084 }
        r1 = r1.append(r2);	 Catch:{ IOException -> 0x0084 }
        r1 = r1.toString();	 Catch:{ IOException -> 0x0084 }
        com.tencent.qqmusic.mediaplayer.util.Logger.i(r0, r1);	 Catch:{ IOException -> 0x0084 }
        r0 = r9.mConnection;	 Catch:{ IOException -> 0x0084 }
        r1 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r0.setConnectTimeout(r1);	 Catch:{ IOException -> 0x0084 }
        r0 = r9.mConnection;	 Catch:{ IOException -> 0x0084 }
        r1 = r9.mAllowCrossDomainRedirect;	 Catch:{ IOException -> 0x0084 }
        r0.setInstanceFollowRedirects(r1);	 Catch:{ IOException -> 0x0084 }
        r6 = "Accept-Encoding";
        r3 = 0;
        r0 = r9.mHeaders;	 Catch:{ IOException -> 0x0084 }
        if (r0 == 0) goto L_0x009d;
    L_0x0045:
        r0 = r9.mHeaders;	 Catch:{ IOException -> 0x0084 }
        r0 = r0.entrySet();	 Catch:{ IOException -> 0x0084 }
        r7 = r0.iterator();	 Catch:{ IOException -> 0x0084 }
    L_0x004f:
        r0 = r7.hasNext();	 Catch:{ IOException -> 0x0084 }
        if (r0 == 0) goto L_0x009d;
    L_0x0055:
        r0 = r7.next();	 Catch:{ IOException -> 0x0084 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ IOException -> 0x0084 }
        r8 = r9.mConnection;	 Catch:{ IOException -> 0x0084 }
        r1 = r0.getKey();	 Catch:{ IOException -> 0x0084 }
        r1 = (java.lang.String) r1;	 Catch:{ IOException -> 0x0084 }
        r2 = r0.getValue();	 Catch:{ IOException -> 0x0084 }
        r2 = (java.lang.String) r2;	 Catch:{ IOException -> 0x0084 }
        r8.setRequestProperty(r1, r2);	 Catch:{ IOException -> 0x0084 }
        if (r3 != 0) goto L_0x022c;
    L_0x006e:
        r0 = r0.getKey();	 Catch:{ IOException -> 0x0084 }
        r0 = r6.equals(r0);	 Catch:{ IOException -> 0x0084 }
        if (r0 == 0) goto L_0x022c;
    L_0x0078:
        r0 = 1;
    L_0x0079:
        r3 = r0;
        goto L_0x004f;
    L_0x007b:
        r0 = r0.openConnection();	 Catch:{ IOException -> 0x0084 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ IOException -> 0x0084 }
        r9.mConnection = r0;	 Catch:{ IOException -> 0x0084 }
        goto L_0x0017;
    L_0x0084:
        r0 = move-exception;
        r2 = -1;
        r9.mTotalSize = r2;
        r1 = 0;
        r9.mInputStream = r1;
        r1 = 0;
        r9.mConnection = r1;
        r2 = -1;
        r9.mCurrentOffset = r2;
        r1 = "MediaHTTPConnection";
        r2 = "seekTo";
        com.tencent.qqmusic.mediaplayer.util.Logger.e(r1, r2, r0);
        throw r0;
    L_0x009d:
        r0 = 0;
        r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x00c2;
    L_0x00a3:
        r0 = r9.mConnection;	 Catch:{ IOException -> 0x0084 }
        r1 = "Range";
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0084 }
        r7 = "bytes=";
        r2.<init>(r7);	 Catch:{ IOException -> 0x0084 }
        r2 = r2.append(r10);	 Catch:{ IOException -> 0x0084 }
        r7 = "-";
        r2 = r2.append(r7);	 Catch:{ IOException -> 0x0084 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x0084 }
        r0.setRequestProperty(r1, r2);	 Catch:{ IOException -> 0x0084 }
    L_0x00c2:
        if (r3 != 0) goto L_0x00cc;
    L_0x00c4:
        r0 = r9.mConnection;	 Catch:{ IOException -> 0x0084 }
        r1 = "";
        r0.setRequestProperty(r6, r1);	 Catch:{ IOException -> 0x0084 }
    L_0x00cc:
        r0 = r9.mConnection;	 Catch:{ Exception -> 0x0102 }
        r2 = r0.getResponseCode();	 Catch:{ Exception -> 0x0102 }
        r0 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r2 == r0) goto L_0x00e6;
    L_0x00d6:
        r0 = 301; // 0x12d float:4.22E-43 double:1.487E-321;
        if (r2 == r0) goto L_0x00e6;
    L_0x00da:
        r0 = 302; // 0x12e float:4.23E-43 double:1.49E-321;
        if (r2 == r0) goto L_0x00e6;
    L_0x00de:
        r0 = 303; // 0x12f float:4.25E-43 double:1.497E-321;
        if (r2 == r0) goto L_0x00e6;
    L_0x00e2:
        r0 = 307; // 0x133 float:4.3E-43 double:1.517E-321;
        if (r2 != r0) goto L_0x01c3;
    L_0x00e6:
        r1 = r4 + 1;
        r0 = 20;
        if (r1 <= r0) goto L_0x011d;
    L_0x00ec:
        r0 = new java.net.NoRouteToHostException;	 Catch:{ IOException -> 0x0084 }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0084 }
        r3 = "Too many redirects: ";
        r2.<init>(r3);	 Catch:{ IOException -> 0x0084 }
        r1 = r2.append(r1);	 Catch:{ IOException -> 0x0084 }
        r1 = r1.toString();	 Catch:{ IOException -> 0x0084 }
        r0.<init>(r1);	 Catch:{ IOException -> 0x0084 }
        throw r0;	 Catch:{ IOException -> 0x0084 }
    L_0x0102:
        r0 = move-exception;
        r1 = new java.io.IOException;	 Catch:{ IOException -> 0x0084 }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0084 }
        r3 = "An suspicious exception occurred: ";
        r2.<init>(r3);	 Catch:{ IOException -> 0x0084 }
        r0 = r0.getMessage();	 Catch:{ IOException -> 0x0084 }
        r0 = r2.append(r0);	 Catch:{ IOException -> 0x0084 }
        r0 = r0.toString();	 Catch:{ IOException -> 0x0084 }
        r1.<init>(r0);	 Catch:{ IOException -> 0x0084 }
        throw r1;	 Catch:{ IOException -> 0x0084 }
    L_0x011d:
        r0 = r9.mConnection;	 Catch:{ IOException -> 0x0084 }
        r0 = r0.getRequestMethod();	 Catch:{ IOException -> 0x0084 }
        r3 = 307; // 0x133 float:4.3E-43 double:1.517E-321;
        if (r2 != r3) goto L_0x0142;
    L_0x0127:
        r3 = "GET";
        r3 = r0.equals(r3);	 Catch:{ IOException -> 0x0084 }
        if (r3 != 0) goto L_0x0142;
    L_0x0130:
        r3 = "HEAD";
        r0 = r0.equals(r3);	 Catch:{ IOException -> 0x0084 }
        if (r0 != 0) goto L_0x0142;
    L_0x0139:
        r0 = new java.net.NoRouteToHostException;	 Catch:{ IOException -> 0x0084 }
        r1 = "Invalid redirect";
        r0.<init>(r1);	 Catch:{ IOException -> 0x0084 }
        throw r0;	 Catch:{ IOException -> 0x0084 }
    L_0x0142:
        r0 = r9.mConnection;	 Catch:{ IOException -> 0x0084 }
        r3 = "Location";
        r3 = r0.getHeaderField(r3);	 Catch:{ IOException -> 0x0084 }
        if (r3 != 0) goto L_0x0156;
    L_0x014d:
        r0 = new java.net.NoRouteToHostException;	 Catch:{ IOException -> 0x0084 }
        r1 = "Invalid redirect";
        r0.<init>(r1);	 Catch:{ IOException -> 0x0084 }
        throw r0;	 Catch:{ IOException -> 0x0084 }
    L_0x0156:
        r0 = new java.net.URL;	 Catch:{ IOException -> 0x0084 }
        r4 = r9.mURL;	 Catch:{ IOException -> 0x0084 }
        r0.<init>(r4, r3);	 Catch:{ IOException -> 0x0084 }
        r3 = r0.getProtocol();	 Catch:{ IOException -> 0x0084 }
        r4 = "https";
        r3 = r3.equals(r4);	 Catch:{ IOException -> 0x0084 }
        if (r3 != 0) goto L_0x0180;
    L_0x016a:
        r3 = r0.getProtocol();	 Catch:{ IOException -> 0x0084 }
        r4 = "http";
        r3 = r3.equals(r4);	 Catch:{ IOException -> 0x0084 }
        if (r3 != 0) goto L_0x0180;
    L_0x0177:
        r0 = new java.net.NoRouteToHostException;	 Catch:{ IOException -> 0x0084 }
        r1 = "Unsupported protocol redirect";
        r0.<init>(r1);	 Catch:{ IOException -> 0x0084 }
        throw r0;	 Catch:{ IOException -> 0x0084 }
    L_0x0180:
        r3 = r9.mURL;	 Catch:{ IOException -> 0x0084 }
        r3 = r3.getProtocol();	 Catch:{ IOException -> 0x0084 }
        r4 = r0.getProtocol();	 Catch:{ IOException -> 0x0084 }
        r3 = r3.equals(r4);	 Catch:{ IOException -> 0x0084 }
        r4 = r9.mAllowCrossProtocolRedirect;	 Catch:{ IOException -> 0x0084 }
        if (r4 != 0) goto L_0x019d;
    L_0x0192:
        if (r3 != 0) goto L_0x019d;
    L_0x0194:
        r0 = new java.net.NoRouteToHostException;	 Catch:{ IOException -> 0x0084 }
        r1 = "Cross-protocol redirects are disallowed";
        r0.<init>(r1);	 Catch:{ IOException -> 0x0084 }
        throw r0;	 Catch:{ IOException -> 0x0084 }
    L_0x019d:
        r3 = r9.mURL;	 Catch:{ IOException -> 0x0084 }
        r3 = r3.getHost();	 Catch:{ IOException -> 0x0084 }
        r4 = r0.getHost();	 Catch:{ IOException -> 0x0084 }
        r3 = r3.equals(r4);	 Catch:{ IOException -> 0x0084 }
        r4 = r9.mAllowCrossDomainRedirect;	 Catch:{ IOException -> 0x0084 }
        if (r4 != 0) goto L_0x01ba;
    L_0x01af:
        if (r3 != 0) goto L_0x01ba;
    L_0x01b1:
        r0 = new java.net.NoRouteToHostException;	 Catch:{ IOException -> 0x0084 }
        r1 = "Cross-domain redirects are disallowed";
        r0.<init>(r1);	 Catch:{ IOException -> 0x0084 }
        throw r0;	 Catch:{ IOException -> 0x0084 }
    L_0x01ba:
        r3 = 307; // 0x133 float:4.3E-43 double:1.517E-321;
        if (r2 == r3) goto L_0x01c0;
    L_0x01be:
        r9.mURL = r0;	 Catch:{ IOException -> 0x0084 }
    L_0x01c0:
        r4 = r1;
        goto L_0x000b;
    L_0x01c3:
        r0 = r9.mAllowCrossDomainRedirect;	 Catch:{ IOException -> 0x0084 }
        if (r0 == 0) goto L_0x01cf;
    L_0x01c7:
        r0 = r9.mConnection;	 Catch:{ IOException -> 0x0084 }
        r0 = r0.getURL();	 Catch:{ IOException -> 0x0084 }
        r9.mURL = r0;	 Catch:{ IOException -> 0x0084 }
    L_0x01cf:
        r0 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r2 != r0) goto L_0x0206;
    L_0x01d3:
        r0 = r9.mConnection;	 Catch:{ IOException -> 0x0084 }
        r1 = "Content-Range";
        r0 = r0.getHeaderField(r1);	 Catch:{ IOException -> 0x0084 }
        r4 = -1;
        r9.mTotalSize = r4;	 Catch:{ IOException -> 0x0084 }
        if (r0 == 0) goto L_0x01f6;
    L_0x01e2:
        r1 = 47;
        r1 = r0.lastIndexOf(r1);	 Catch:{ IOException -> 0x0084 }
        if (r1 < 0) goto L_0x01f6;
    L_0x01ea:
        r1 = r1 + 1;
        r0 = r0.substring(r1);	 Catch:{ IOException -> 0x0084 }
        r0 = java.lang.Long.parseLong(r0);	 Catch:{ NumberFormatException -> 0x022a }
        r9.mTotalSize = r0;	 Catch:{ NumberFormatException -> 0x022a }
    L_0x01f6:
        r0 = 0;
        r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x021a;
    L_0x01fc:
        r0 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r2 == r0) goto L_0x021a;
    L_0x0200:
        r0 = new java.net.ProtocolException;	 Catch:{ IOException -> 0x0084 }
        r0.<init>();	 Catch:{ IOException -> 0x0084 }
        throw r0;	 Catch:{ IOException -> 0x0084 }
    L_0x0206:
        r0 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r2 == r0) goto L_0x0210;
    L_0x020a:
        r0 = new java.io.IOException;	 Catch:{ IOException -> 0x0084 }
        r0.<init>();	 Catch:{ IOException -> 0x0084 }
        throw r0;	 Catch:{ IOException -> 0x0084 }
    L_0x0210:
        r0 = r9.mConnection;	 Catch:{ IOException -> 0x0084 }
        r0 = r0.getContentLength();	 Catch:{ IOException -> 0x0084 }
        r0 = (long) r0;	 Catch:{ IOException -> 0x0084 }
        r9.mTotalSize = r0;	 Catch:{ IOException -> 0x0084 }
        goto L_0x01f6;
    L_0x021a:
        r0 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x0084 }
        r1 = r9.mConnection;	 Catch:{ IOException -> 0x0084 }
        r1 = r1.getInputStream();	 Catch:{ IOException -> 0x0084 }
        r0.<init>(r1);	 Catch:{ IOException -> 0x0084 }
        r9.mInputStream = r0;	 Catch:{ IOException -> 0x0084 }
        r9.mCurrentOffset = r10;	 Catch:{ IOException -> 0x0084 }
        return;
    L_0x022a:
        r0 = move-exception;
        goto L_0x01f6;
    L_0x022c:
        r0 = r3;
        goto L_0x0079;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qqmusic.mediaplayer.network.DefaultMediaHTTPConnection.seekTo(long):void");
    }

    public int readAt(byte[] bArr, int i, int i2) {
        int i3 = 0;
        try {
            if (((long) i) != this.mCurrentOffset) {
                seekTo((long) i);
            }
            int read = this.mInputStream.read(bArr, 0, i2);
            if (read != -1) {
                i3 = read;
            }
            this.mCurrentOffset += (long) i3;
            return i3;
        } catch (ProtocolException e) {
            Logger.w(TAG, "readAt " + i + " / " + i2 + " => " + e);
            return -1010;
        } catch (NoRouteToHostException e2) {
            Logger.w(TAG, "readAt " + i + " / " + i2 + " => " + e2);
            return -1010;
        } catch (UnknownServiceException e3) {
            Logger.w(TAG, "readAt " + i + " / " + i2 + " => " + e3);
            return -1010;
        } catch (IOException e4) {
            return -1;
        } catch (Exception e5) {
            return -1;
        }
    }

    public long getSize() {
        if (this.mConnection == null) {
            try {
                seekTo(0);
            } catch (Throwable e) {
                Logger.e(TAG, "getSize", e);
                return -1;
            }
        }
        return this.mTotalSize;
    }

    public String getMIMEType() {
        if (this.mConnection == null) {
            try {
                seekTo(0);
            } catch (Throwable e) {
                Logger.e(TAG, "getMIMEType", e);
                return "application/octet-stream";
            }
        }
        return this.mConnection.getContentType();
    }

    public String getUri() {
        return this.mURL.toString();
    }
}
