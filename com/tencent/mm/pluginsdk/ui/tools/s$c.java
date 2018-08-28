package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.util.Base64;
import android.webkit.URLUtil;
import android.widget.Toast;
import com.tencent.mm.plugin.ak.a.h;
import com.tencent.mm.pluginsdk.ui.tools.s.b;
import com.tencent.mm.sdk.platformtools.at.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;

class s$c implements a {
    private static Pattern qUx = Pattern.compile("image/[A-Za-z0-9]+");
    private static Pattern qUy = Pattern.compile("filename=[A-Za-z0-9@.]+.[A-Za-z0-9]+");
    private Context context;
    private String edG;
    private String imagePath;
    private int opType;
    private String qUA;
    private boolean qUB;
    private b qUC;
    private String qUz;

    public s$c(Context context, String str, String str2, boolean z) {
        this(context, str, str2, z, 0, null);
    }

    public s$c(Context context, String str, String str2, boolean z, int i, b bVar) {
        this.context = context;
        this.edG = str;
        this.qUA = str2;
        this.qUB = z;
        this.opType = i;
        this.qUC = bVar;
    }

    public final boolean Ks() {
        if (1 == this.opType) {
            this.qUC.uf(this.imagePath);
        } else if (bi.oW(this.qUz)) {
            Toast.makeText(this.context, this.context.getString(h.wv_save_image_error), 1).show();
        } else {
            Toast.makeText(this.context, this.qUz, 1).show();
        }
        return true;
    }

    private void cfC() {
        Exception e;
        HttpURLConnection httpURLConnection;
        Throwable th;
        InputStream inputStream;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.edG).openConnection();
            try {
                httpURLConnection2.setRequestMethod("GET");
                httpURLConnection2.setRequestProperty("Cookie", this.qUA);
                httpURLConnection2.setAllowUserInteraction(true);
                int responseCode = httpURLConnection2.getResponseCode();
                String headerField;
                if (responseCode != 200) {
                    if (responseCode == com.tencent.mm.plugin.appbrand.jsapi.p.b.CTRL_INDEX || responseCode == 302) {
                        headerField = httpURLConnection2.getHeaderField("Location");
                        if (headerField == null) {
                            headerField = httpURLConnection2.getHeaderField("location");
                        }
                        x.i("MicroMsg.WebViewUtil", "redirect url = %s", new Object[]{headerField});
                        if (!bi.oW(headerField)) {
                            this.edG = headerField;
                            cfC();
                            a(httpURLConnection2, null);
                            return;
                        }
                    }
                    this.qUz = this.context.getString(h.wv_save_image_error);
                    a(httpURLConnection2, null);
                    return;
                }
                headerField = httpURLConnection2.getContentType();
                inputStream = httpURLConnection2.getInputStream();
                try {
                    a(headerField, httpURLConnection2.getHeaderField("Content-Disposition"), inputStream);
                    a(httpURLConnection2, inputStream);
                } catch (Exception e2) {
                    e = e2;
                    httpURLConnection = httpURLConnection2;
                    try {
                        x.e("MicroMsg.WebViewUtil", "init http url connection failed : %s", new Object[]{e.getMessage()});
                        a(httpURLConnection, inputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        a(httpURLConnection, inputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection2;
                    a(httpURLConnection, inputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                inputStream = null;
                httpURLConnection = httpURLConnection2;
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                httpURLConnection = httpURLConnection2;
                a(httpURLConnection, inputStream);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            inputStream = null;
            httpURLConnection = null;
            x.e("MicroMsg.WebViewUtil", "init http url connection failed : %s", new Object[]{e.getMessage()});
            a(httpURLConnection, inputStream);
        } catch (Throwable th22) {
            th = th22;
            inputStream = null;
            httpURLConnection = null;
            a(httpURLConnection, inputStream);
            throw th;
        }
    }

    private static void a(HttpURLConnection httpURLConnection, InputStream inputStream) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WebViewUtil", e, "", new Object[0]);
            }
        }
    }

    private void a(String str, String str2, InputStream inputStream) {
        Matcher matcher;
        x.i("MicroMsg.WebViewUtil", "contentType = %s, dispositionType = %s", new Object[]{str, str2});
        String str3 = null;
        if (!bi.oW(str)) {
            matcher = qUx.matcher(str);
            if (matcher.find()) {
                str3 = matcher.group().substring(matcher.group().lastIndexOf(47) + 1);
            }
        }
        if (bi.oW(str3) && !bi.oW(str2)) {
            matcher = qUy.matcher(str2);
            if (matcher.find()) {
                str3 = matcher.group().substring(matcher.group().lastIndexOf(46) + 1);
            }
        }
        if (bi.oW(str3)) {
            q qVar = new q(this.edG);
            int lastIndexOf = qVar.ben.lastIndexOf(46);
            if (lastIndexOf == -1) {
                str3 = "jpg";
            } else {
                str3 = qVar.ben.substring(lastIndexOf + 1);
            }
        }
        this.imagePath = l.oN(str3);
        FileOutputStream fileOutputStream = new FileOutputStream(this.imagePath);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                try {
                    break;
                } catch (Exception e) {
                    x.e("MicroMsg.WebViewUtil", "close os failed : %s", new Object[]{e.getMessage()});
                }
            }
        }
        fileOutputStream.flush();
        fileOutputStream.close();
        if (this.opType == 0) {
            this.qUz = this.context.getString(h.cropimage_saved, new Object[]{l.Vs()});
            l.a(this.imagePath, this.context);
        }
    }

    public final boolean Kr() {
        Exception e;
        Throwable th;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        Throwable th2;
        Object inputStream2;
        FileOutputStream fileOutputStream = null;
        if (!this.qUB) {
            this.qUz = this.context.getString(h.wv_save_image_error_nosdcard);
            return true;
        } else if (bi.oW(this.edG)) {
            return false;
        } else {
            int indexOf;
            if (URLUtil.isDataUrl(this.edG)) {
                this.imagePath = l.oN("jpg");
                try {
                    indexOf = this.edG.indexOf("base64");
                    if (indexOf > 0) {
                        this.edG = this.edG.substring(indexOf + 7);
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(this.imagePath);
                    try {
                        byte[] decode = Base64.decode(this.edG, 0);
                        if (decode != null) {
                            fileOutputStream2.write(decode);
                        }
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                        this.qUz = this.context.getString(h.cropimage_saved, new Object[]{l.Vs()});
                        l.a(this.imagePath, this.context);
                        try {
                            fileOutputStream2.close();
                        } catch (Exception e2) {
                            x.e("MicroMsg.WebViewUtil", "close FileOutputStream failed : %s", new Object[]{e2.getMessage()});
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        fileOutputStream = fileOutputStream2;
                        try {
                            x.e("MicroMsg.WebViewUtil", "decode base64 pic failed : %s", new Object[]{e2.getMessage()});
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e22) {
                                    x.e("MicroMsg.WebViewUtil", "close FileOutputStream failed : %s", new Object[]{e22.getMessage()});
                                }
                            }
                            return true;
                        } catch (Throwable th3) {
                            th = th3;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e4) {
                                    x.e("MicroMsg.WebViewUtil", "close FileOutputStream failed : %s", new Object[]{e4.getMessage()});
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e42) {
                                x.e("MicroMsg.WebViewUtil", "close FileOutputStream failed : %s", new Object[]{e42.getMessage()});
                            }
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e22 = e5;
                    x.e("MicroMsg.WebViewUtil", "decode base64 pic failed : %s", new Object[]{e22.getMessage()});
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e222) {
                            x.e("MicroMsg.WebViewUtil", "close FileOutputStream failed : %s", new Object[]{e222.getMessage()});
                        }
                    }
                    return true;
                }
            } else if (URLUtil.isHttpsUrl(this.edG)) {
                try {
                    HttpURLConnection httpURLConnection2 = (HttpsURLConnection) new URL(this.edG).openConnection();
                    try {
                        httpURLConnection2.setRequestMethod("GET");
                        httpURLConnection2.setRequestProperty("Cookie", this.qUA);
                        httpURLConnection2.setAllowUserInteraction(true);
                        indexOf = httpURLConnection2.getResponseCode();
                        String headerField;
                        if (indexOf != 200) {
                            if (indexOf == com.tencent.mm.plugin.appbrand.jsapi.p.b.CTRL_INDEX || indexOf == 302) {
                                headerField = httpURLConnection2.getHeaderField("Location");
                                if (headerField == null) {
                                    headerField = httpURLConnection2.getHeaderField("location");
                                }
                                x.i("MicroMsg.WebViewUtil", "redirect url = %s", new Object[]{headerField});
                                if (!bi.oW(headerField)) {
                                    this.edG = headerField;
                                    cfC();
                                    a(httpURLConnection2, fileOutputStream);
                                }
                            }
                            this.qUz = this.context.getString(h.wv_save_image_error);
                            a(httpURLConnection2, fileOutputStream);
                        } else {
                            headerField = httpURLConnection2.getContentType();
                            InputStream inputStream3 = httpURLConnection2.getInputStream();
                            try {
                                a(headerField, httpURLConnection2.getHeaderField("Content-Disposition"), inputStream3);
                                a(httpURLConnection2, inputStream3);
                            } catch (Exception e6) {
                                e222 = e6;
                                inputStream2 = inputStream3;
                                httpURLConnection = httpURLConnection2;
                                try {
                                    x.e("MicroMsg.WebViewUtil", "download https resource failed : %s", new Object[]{e222.getMessage()});
                                    a(httpURLConnection, inputStream2);
                                    return true;
                                } catch (Throwable th5) {
                                    th2 = th5;
                                    a(httpURLConnection, inputStream2);
                                    throw th2;
                                }
                            } catch (Throwable th6) {
                                th2 = th6;
                                inputStream2 = inputStream3;
                                httpURLConnection = httpURLConnection2;
                                a(httpURLConnection, inputStream2);
                                throw th2;
                            }
                        }
                    } catch (Exception e7) {
                        e222 = e7;
                        inputStream2 = fileOutputStream;
                        httpURLConnection = httpURLConnection2;
                    } catch (Throwable th7) {
                        th2 = th7;
                        inputStream2 = fileOutputStream;
                        httpURLConnection = httpURLConnection2;
                        a(httpURLConnection, inputStream2);
                        throw th2;
                    }
                } catch (Exception e8) {
                    e222 = e8;
                    inputStream2 = fileOutputStream;
                    httpURLConnection = fileOutputStream;
                    x.e("MicroMsg.WebViewUtil", "download https resource failed : %s", new Object[]{e222.getMessage()});
                    a(httpURLConnection, inputStream2);
                    return true;
                } catch (Throwable th52) {
                    th2 = th52;
                    inputStream2 = fileOutputStream;
                    httpURLConnection = fileOutputStream;
                    a(httpURLConnection, inputStream2);
                    throw th2;
                }
            } else {
                cfC();
            }
            return true;
        }
    }
}
