package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.net.Proxy;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.util.Date;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;

public class dq$a extends dq {
    private Context a;

    public dq$a(Context context) {
        this.a = context;
    }

    public final byte[] a(String str, byte[] bArr, dn dnVar) {
        if (str == null) {
            ct.d("no destUrl!", new Object[0]);
            return null;
        }
        long j;
        do doVar = null;
        int i = 0;
        if (bArr == null) {
            j = 0;
        } else {
            j = (long) bArr.length;
        }
        ct.h("start req: %s sz:%d", new Object[]{str, Long.valueOf(j)});
        String str2 = "";
        String str3 = "";
        Object obj = null;
        int i2 = 0;
        String str4 = str;
        while (true) {
            int i3 = i + 1;
            if (i < 3 && i2 < 2) {
                if (obj != null) {
                    throw new Exception("net redirect");
                }
                Object obj2;
                int i4;
                if (i3 > 1) {
                    ct.h("try time:" + i3, new Object[0]);
                    if (i3 == 2 && dnVar.c() == 2) {
                        dnVar.b(false);
                    }
                    try {
                        Thread.sleep(5000);
                    } catch (Throwable e) {
                        ct.a(e);
                    }
                }
                String n = e.n(this.a);
                new Date().getTime();
                try {
                    doVar = a(str4, bArr, n, i3);
                } catch (Exception e2) {
                    n = e2.toString();
                    if (str3.equals(n)) {
                        str2 = str2 + i3 + ":same ";
                    } else {
                        str2 = str2 + i3 + ":" + n + " ";
                    }
                    str3 = n;
                }
                new Date().getTime();
                if (doVar != null) {
                    HttpResponse httpResponse = doVar.a;
                    HttpEntity entity = httpResponse.getEntity();
                    long j2 = 0;
                    if (entity != null) {
                        j2 = entity.getContentLength();
                        if (j2 < 0) {
                            j2 = 0;
                        }
                    }
                    int statusCode = httpResponse.getStatusLine().getStatusCode();
                    ct.h("response code:%d ", new Object[]{Integer.valueOf(statusCode)});
                    ct.h("contentLength:%d ", new Object[]{Long.valueOf(j2)});
                    if (statusCode != 200) {
                        obj2 = (statusCode == 301 || statusCode == 302 || statusCode == 303 || statusCode == 307) ? 1 : null;
                        if (obj2 != null) {
                            obj2 = 1;
                            Header firstHeader = httpResponse.getFirstHeader("Location");
                            if (firstHeader == null) {
                                ct.d("redirect code:" + statusCode + " Location is null! return", new Object[0]);
                                try {
                                    if (doVar.b != null) {
                                        doVar.b.abort();
                                    }
                                } catch (Exception e3) {
                                }
                                return null;
                            }
                            i4 = i2 + 1;
                            i = 0;
                            String value = firstHeader.getValue();
                            ct.h("redirect code:%d , to:%s", new Object[]{Integer.valueOf(statusCode), value});
                            try {
                                if (doVar.b != null) {
                                    doVar.b.abort();
                                }
                                obj = 1;
                                i2 = i4;
                                str4 = value;
                            } catch (Exception e4) {
                                str4 = value;
                            }
                        }
                    } else if (!httpResponse.containsHeader("encrypt-status")) {
                        return a(httpResponse, doVar.b);
                    } else {
                        ct.d("svr encry failed: " + httpResponse.getFirstHeader("encrypt-status").getValue(), new Object[0]);
                        return null;
                    }
                }
                obj2 = obj;
                i4 = i2;
                i = i3;
                obj = obj2;
                i2 = i4;
            }
        }
        throw new Exception(str2);
    }

    private static do a(String str, byte[] bArr, String str2, int i) {
        Throwable th;
        HttpPost httpPost;
        if (str == null) {
            ct.d("no destUrl!", new Object[0]);
            return null;
        }
        HttpEntity byteArrayEntity;
        if (bArr != null) {
            try {
                byteArrayEntity = new ByteArrayEntity(bArr);
            } catch (Throwable th2) {
                th = th2;
                httpPost = null;
                ct.a(th);
                ct.d("execute error:%s", new Object[]{th.toString()});
                if (httpPost != null) {
                    httpPost.abort();
                }
                throw new Exception(th.toString());
            }
        }
        byteArrayEntity = new ByteArrayEntity("".getBytes());
        HttpClient a = a(str2, i);
        if (a == null) {
            ct.d("no httpClient!", new Object[0]);
            return null;
        }
        httpPost = new HttpPost(str);
        try {
            httpPost.setHeader("wup_version", "3.0");
            httpPost.setHeader("TYPE_COMPRESS", "2");
            httpPost.setHeader("encr_type", "rsapost");
            ch a2 = ch.a();
            if (a2 != null) {
                httpPost.setHeader("bea_key", a2.j());
            }
            httpPost.setEntity(byteArrayEntity);
            HttpResponse execute = a.execute(httpPost, new BasicHttpContext());
            ct.h("execute request:\n %s", new Object[]{((HttpRequest) r0.getAttribute("http.request")).getRequestLine().toString()});
            return new do(execute, httpPost);
        } catch (Throwable th3) {
            th = th3;
            ct.a(th);
            ct.d("execute error:%s", new Object[]{th.toString()});
            if (httpPost != null) {
                httpPost.abort();
            }
            throw new Exception(th.toString());
        }
    }

    private byte[] a(HttpResponse httpResponse, HttpPost httpPost) {
        Throwable th;
        byte[] bArr = null;
        if (httpResponse != null) {
            if (httpResponse.getStatusLine().getStatusCode() != 200) {
                StatusLine statusLine = httpResponse.getStatusLine();
                ct.c("request failure code:%d , line:%s ", new Object[]{Integer.valueOf(r1), statusLine});
            } else {
                if (httpResponse.containsHeader("session_id") && httpResponse.containsHeader("max_time")) {
                    ch.a().a(this.a, httpResponse.getFirstHeader("session_id").getValue(), httpResponse.getFirstHeader("max_time").getValue());
                }
                HttpEntity entity = httpResponse.getEntity();
                if (entity == null) {
                    ct.d("no response datas!", new Object[0]);
                } else {
                    BufferedInputStream bufferedInputStream;
                    try {
                        bufferedInputStream = new BufferedInputStream(new DataInputStream(entity.getContent()));
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(128);
                            while (true) {
                                int read = bufferedInputStream.read();
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(read);
                            }
                            byteArrayOutputStream.flush();
                            bArr = byteArrayOutputStream.toByteArray();
                            try {
                                bufferedInputStream.close();
                            } catch (Throwable th2) {
                                ct.a(th2);
                            }
                            if (httpPost != null) {
                                httpPost.abort();
                            }
                        } catch (Throwable th3) {
                            th2 = th3;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        bufferedInputStream = bArr;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Throwable th5) {
                                ct.a(th5);
                            }
                        }
                        if (httpPost != null) {
                            httpPost.abort();
                        }
                        throw th2;
                    }
                }
            }
        }
        return bArr;
    }

    private static HttpClient a(String str, int i) {
        try {
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 30000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
            HttpConnectionParams.setSocketBufferSize(basicHttpParams, 2000);
            basicHttpParams.setBooleanParameter("http.protocol.handle-redirects", false);
            HttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
            HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
            defaultHttpClient.setHttpRequestRetryHandler(new 1());
            if (str == null || !str.toLowerCase(Locale.US).contains("wap") || i == 2) {
                if (str != null) {
                    ct.a("Don't use proxy: %s, try time: %s", new Object[]{str, Integer.valueOf(i)});
                }
                defaultHttpClient.getParams().removeParameter("http.route.default-proxy");
                return defaultHttpClient;
            }
            ct.a("use proxy: %s, try time: %s", new Object[]{str, Integer.valueOf(i)});
            defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(Proxy.getDefaultHost(), Proxy.getDefaultPort()));
            return defaultHttpClient;
        } catch (Throwable th) {
            ct.a(th);
            ct.d("httpclient error!", new Object[0]);
            return null;
        }
    }
}
