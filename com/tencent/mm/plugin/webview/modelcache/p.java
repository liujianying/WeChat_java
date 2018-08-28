package com.tencent.mm.plugin.webview.modelcache;

import android.net.Uri;
import android.webkit.URLUtil;
import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public final class p {
    public static boolean vN(String str) {
        return !bi.oW(str) && (URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str));
    }

    public static String QB(String str) {
        String str2;
        if (!vN(str)) {
            return null;
        }
        try {
            URI uri = new URI(str);
            String toLowerCase = bi.oV(uri.getScheme()).toLowerCase();
            String toLowerCase2 = bi.oV(uri.getHost()).toLowerCase();
            if (bi.oW(toLowerCase2)) {
                return null;
            }
            int port = uri.getPort() == -1 ? toLowerCase.equalsIgnoreCase("http") ? 80 : JsApiPauseDownloadTask.CTRL_INDEX : uri.getPort();
            str = toLowerCase + "://" + toLowerCase2 + ":" + port + "/" + bi.oV(uri.getPath()) + (bi.oW(uri.getQuery()) ? "" : "?" + uri.getQuery()) + (bi.oW(uri.getFragment()) ? "" : "#" + uri.getFragment());
            if (str.endsWith("/")) {
                str = str + "/";
            }
            return QC(str);
        } catch (URISyntaxException e) {
            str2 = str;
            x.e("MicroMsg.WebViewCacheUtils", "getFormattedHttpURL URISyntaxException : %s", new Object[]{e.getMessage()});
            return str2;
        } catch (Exception e2) {
            str2 = str;
            x.e("MicroMsg.WebViewCacheUtils", "getFormattedHttpURL normal : %s", new Object[]{e2.getMessage()});
            return str2;
        }
    }

    private static String QC(String str) {
        Uri parse = Uri.parse(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(parse.getScheme()).append("://");
        stringBuilder.append(parse.getHost()).append(":").append(parse.getPort());
        if (bi.cX(parse.getPathSegments())) {
            stringBuilder.append("/");
        } else {
            for (String append : parse.getPathSegments()) {
                stringBuilder.append("/").append(append);
            }
        }
        if (!bi.oW(parse.getQuery())) {
            stringBuilder.append("?").append(parse.getQuery());
        }
        if (!bi.oW(parse.getFragment())) {
            stringBuilder.append("#").append(parse.getFragment());
        }
        if (str.endsWith("/")) {
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }

    public static String QD(String str) {
        String QB = QB(str);
        if (bi.oW(QB)) {
            return null;
        }
        return Uri.parse(QB).getHost();
    }

    public static String QE(String str) {
        String QF = QF(str);
        return bi.oW(QF) ? null : QF.replaceAll("http://", "").replaceAll("https://", "");
    }

    public static String QF(String str) {
        String QB = QB(str);
        if (bi.oW(QB)) {
            x.e("MicroMsg.WebViewCacheUtils", "evaluateResURLWithScheme, original url is invalid = %s", new Object[]{str});
            return null;
        }
        Uri parse = Uri.parse(QB);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(parse.getScheme()).append("://").append(parse.getHost()).append(":").append(parse.getPort());
        if (!bi.cX(parse.getPathSegments())) {
            for (String QB2 : parse.getPathSegments()) {
                stringBuilder.append("/").append(bi.oV(QB2));
            }
        }
        if (str.endsWith("/")) {
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }

    public static byte[] QG(String str) {
        Exception e;
        Throwable th;
        Closeable byteArrayOutputStream;
        Closeable inputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setRequestMethod("GET");
                int responseCode = httpURLConnection.getResponseCode();
                int contentLength = httpURLConnection.getContentLength();
                x.d("MicroMsg.WebViewCacheUtils", "getBytesFromURL, url = %s, statusCode = %d, contentLength = %d", new Object[]{str, Integer.valueOf(responseCode), Integer.valueOf(contentLength)});
                inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    try {
                        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                        while (true) {
                            contentLength = inputStream.read(bArr);
                            if (contentLength != -1) {
                                byteArrayOutputStream.write(bArr, 0, contentLength);
                            } else {
                                bArr = byteArrayOutputStream.toByteArray();
                                bi.d(inputStream);
                                bi.d(byteArrayOutputStream);
                                return bArr;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            x.e("MicroMsg.WebViewCacheUtils", "getBytesFromURL, url = %s, e = %s", new Object[]{str, e});
                            bi.d(inputStream);
                            bi.d(byteArrayOutputStream);
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            bi.d(inputStream);
                            bi.d(byteArrayOutputStream);
                            throw th;
                        }
                    }
                }
                bi.d(inputStream);
                bi.d(byteArrayOutputStream);
                return null;
            } catch (Exception e3) {
                e = e3;
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
                bi.d(inputStream);
                bi.d(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream = null;
            inputStream = null;
            x.e("MicroMsg.WebViewCacheUtils", "getBytesFromURL, url = %s, e = %s", new Object[]{str, e});
            bi.d(inputStream);
            bi.d(byteArrayOutputStream);
            return null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            inputStream = null;
            bi.d(inputStream);
            bi.d(byteArrayOutputStream);
            throw th;
        }
    }

    public static String QH(String str) {
        FileNotFoundException e;
        Throwable th;
        Exception e2;
        String str2 = null;
        if (FileOp.cn(str)) {
            Closeable openRead;
            try {
                int mI = (int) FileOp.mI(str);
                openRead = FileOp.openRead(str);
                try {
                    str2 = g.b(openRead, mI);
                    bi.d(openRead);
                } catch (FileNotFoundException e3) {
                    e = e3;
                    try {
                        x.e("MicroMsg.WebViewCacheUtils", "getContentMd5, localPath = %s, exception = %s", new Object[]{str, e});
                        bi.d(openRead);
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        bi.d(openRead);
                        throw th;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    x.e("MicroMsg.WebViewCacheUtils", "getContentMd5, localPath = %s, exception = %s", new Object[]{str, e2});
                    bi.d(openRead);
                    return str2;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                openRead = str2;
            } catch (Exception e6) {
                e2 = e6;
                openRead = str2;
                x.e("MicroMsg.WebViewCacheUtils", "getContentMd5, localPath = %s, exception = %s", new Object[]{str, e2});
                bi.d(openRead);
                return str2;
            } catch (Throwable th3) {
                th = th3;
                openRead = str2;
                bi.d(openRead);
                throw th;
            }
        }
        return str2;
    }

    public static int a(i iVar) {
        if (!bi.oV(iVar.qkl).equals("cache")) {
            return -1;
        }
        if (!Boolean.parseBoolean((String) iVar.mcy.get("async")) || bi.oW((String) iVar.mcy.get("src"))) {
            return !bi.oW((String) iVar.mcy.get("resourceList")) ? 1 : -1;
        } else {
            return 2;
        }
    }
}
