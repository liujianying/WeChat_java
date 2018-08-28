package com.tencent.mm.sdk.c;

import com.tencent.mm.sdk.c.b.b;
import com.tencent.mm.sdk.c.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public final class a extends b {
    private HttpURLConnection glD = null;

    public a(HttpURLConnection httpURLConnection) {
        this.glD = httpURLConnection;
    }

    public final void a(b bVar, c cVar) {
        Throwable e;
        x.i("MicroMsg.HttpURLConnectionWrapper", "request : %s", new Object[]{bVar});
        OutputStream outputStream = null;
        InputStream inputStream = null;
        int i;
        try {
            String str;
            this.glD.setConnectTimeout(bVar.dkb);
            this.glD.setRequestMethod(bVar.mcx == 0 ? "GET" : "POST");
            if (bVar.mcx == 1) {
                this.glD.setDoInput(true);
                this.glD.setDoOutput(true);
            }
            this.glD.setUseCaches(false);
            this.glD.setRequestProperty("User-Agent", "weixin/android");
            this.glD.setRequestProperty("Host", bVar.host);
            System.setProperty("http.keepAlive", "false");
            this.glD.setRequestProperty("Accept-Charset", "utf-8");
            this.glD.setRequestProperty("Accept-Encoding", "compress;q=0.5, gzip;q=1.0");
            HttpURLConnection httpURLConnection = this.glD;
            String str2 = "Cookie";
            Map map = bVar.mcz;
            if (map == null || map.size() == 0) {
                str = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                int i2 = 0;
                Iterator it = map.keySet().iterator();
                while (true) {
                    i = i2;
                    if (!it.hasNext()) {
                        break;
                    }
                    str = (String) it.next();
                    stringBuilder.append(URLEncoder.encode(str, "utf-8")).append('=').append(URLEncoder.encode((String) map.get(str), "utf-8"));
                    i2 = i + 1;
                    if (map.size() > i2) {
                        stringBuilder.append("; ");
                    }
                }
                str = stringBuilder.toString();
            }
            httpURLConnection.setRequestProperty(str2, str);
            this.glD.connect();
            if (bVar.mcx == 1) {
                outputStream = this.glD.getOutputStream();
                a(bVar, outputStream);
                outputStream.flush();
            }
            i = this.glD.getResponseCode();
            try {
                OutputStream outputStream2;
                byte[] bArr;
                String headerField = this.glD.getHeaderField("set-cookie");
                str = this.glD.getHeaderField("Content-Encoding");
                this.glD.getHeaderField("Content-Disposition");
                InputStream inputStream2 = this.glD.getInputStream();
                if (str != null) {
                    try {
                        if (str.contains("gzip")) {
                            inputStream = new GZIPInputStream(inputStream2);
                            outputStream2 = null;
                            if (cVar.sFv == null && bi.oW(cVar.sFv.filePath)) {
                                outputStream2 = new FileOutputStream(new File(cVar.sFv.filePath), true);
                            } else {
                                outputStream2 = new ByteArrayOutputStream();
                            }
                            bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                outputStream2.write(bArr, 0, read);
                                outputStream2.flush();
                            }
                            cVar.status = i;
                            cVar.mcz = b.JR(headerField);
                            cVar.content = outputStream2 instanceof ByteArrayOutputStream ? new String(((ByteArrayOutputStream) outputStream2).toByteArray()) : "";
                            outputStream2.flush();
                            outputStream2.close();
                            x.d("MicroMsg.HttpURLConnectionWrapper", "Response: %s" + cVar);
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Throwable e2) {
                                    x.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e2, "", new Object[0]);
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e22) {
                                    x.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e22, "", new Object[0]);
                                }
                            }
                            if (this.glD != null) {
                                this.glD.disconnect();
                            }
                        }
                    } catch (Exception e3) {
                        e22 = e3;
                        inputStream = inputStream2;
                        try {
                            x.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e22, "", new Object[0]);
                            cVar.status = i != 0 ? 503 : 500;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Throwable e222) {
                                    x.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e222, "", new Object[0]);
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e2222) {
                                    x.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e2222, "", new Object[0]);
                                }
                            }
                            if (this.glD != null) {
                                this.glD.disconnect();
                            }
                        } catch (Throwable th) {
                            e2222 = th;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Throwable e4) {
                                    x.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e4, "", new Object[0]);
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e42) {
                                    x.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e42, "", new Object[0]);
                                }
                            }
                            if (this.glD != null) {
                                this.glD.disconnect();
                            }
                            throw e2222;
                        }
                    } catch (Throwable th2) {
                        e2222 = th2;
                        inputStream = inputStream2;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Throwable e422) {
                                x.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e422, "", new Object[0]);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e4222) {
                                x.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e4222, "", new Object[0]);
                            }
                        }
                        if (this.glD != null) {
                            this.glD.disconnect();
                        }
                        throw e2222;
                    }
                }
                inputStream = inputStream2;
                outputStream2 = null;
                try {
                    if (cVar.sFv == null) {
                    }
                    outputStream2 = new ByteArrayOutputStream();
                    bArr = new byte[1024];
                    while (true) {
                        int read2 = inputStream.read(bArr);
                        if (read2 <= 0) {
                            break;
                        }
                        outputStream2.write(bArr, 0, read2);
                        outputStream2.flush();
                    }
                    cVar.status = i;
                    cVar.mcz = b.JR(headerField);
                    if (outputStream2 instanceof ByteArrayOutputStream) {
                    }
                    cVar.content = outputStream2 instanceof ByteArrayOutputStream ? new String(((ByteArrayOutputStream) outputStream2).toByteArray()) : "";
                    outputStream2.flush();
                    outputStream2.close();
                } catch (Throwable e22222) {
                    x.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e22222, "", new Object[0]);
                    cVar.status = i == 0 ? 503 : 500;
                    if (outputStream2 != null) {
                        outputStream2.flush();
                        outputStream2.close();
                    }
                } catch (Throwable th3) {
                    if (outputStream2 != null) {
                        outputStream2.flush();
                        outputStream2.close();
                    }
                }
                x.d("MicroMsg.HttpURLConnectionWrapper", "Response: %s" + cVar);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable e222222) {
                        x.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e222222, "", new Object[0]);
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e2222222) {
                        x.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e2222222, "", new Object[0]);
                    }
                }
                if (this.glD != null) {
                    this.glD.disconnect();
                }
            } catch (Exception e5) {
                e2222222 = e5;
            }
        } catch (Exception e6) {
            e2222222 = e6;
            i = 0;
            x.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e2222222, "", new Object[0]);
            if (i != 0) {
            }
            cVar.status = i != 0 ? 503 : 500;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable e22222222) {
                    x.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e22222222, "", new Object[0]);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e222222222) {
                    x.printErrStackTrace("MicroMsg.HttpURLConnectionWrapper", e222222222, "", new Object[0]);
                }
            }
            if (this.glD != null) {
                this.glD.disconnect();
            }
        }
    }

    private static void a(b bVar, OutputStream outputStream) {
        if (bVar.mcy != null) {
            StringBuilder stringBuilder = new StringBuilder();
            Object obj = 1;
            Iterator it = bVar.mcy.keySet().iterator();
            while (true) {
                Object obj2 = obj;
                if (it.hasNext()) {
                    String str = (String) it.next();
                    stringBuilder.append(obj2 != null ? "" : "&").append(URLEncoder.encode(str, "utf-8")).append('=').append(URLEncoder.encode((String) bVar.mcy.get(str), "utf-8"));
                    obj = null;
                } else {
                    outputStream.write(stringBuilder.toString().getBytes());
                    return;
                }
            }
        }
    }
}
