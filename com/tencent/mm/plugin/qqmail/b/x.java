package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.network.u;
import com.tencent.mm.plugin.qqmail.b.h.a;
import com.tencent.mm.plugin.qqmail.b.h.b;
import com.tencent.mm.plugin.qqmail.b.h.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public final class x extends h {
    private u mdZ;

    public final c a(String str, String str2, b bVar, a aVar) {
        int responseCode;
        Throwable e;
        int i;
        c cVar;
        OutputStream outputStream;
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.URLConnectionUtil", "uri=" + str2 + ", " + bVar);
        OutputStream outputStream2 = null;
        InputStream inputStream = null;
        OutputStream outputStream3;
        try {
            this.mdZ = com.tencent.mm.network.b.a(b(str, str2, bVar.mcx == 0 ? bVar.mcy : null), null);
            this.mdZ.setConnectTimeout(dkb);
            this.mdZ.setRequestMethod(bVar.mcx == 0 ? "GET" : "POST");
            this.mdZ.UI();
            this.mdZ.UJ();
            this.mdZ.setUseCaches(false);
            this.mdZ.setRequestProperty("User-Agent", aBr);
            this.mdZ.setRequestProperty("Host", host);
            System.setProperty("http.keepAlive", "false");
            this.mdZ.setRequestProperty("Accept-Charset", "utf-8");
            this.mdZ.setRequestProperty("Accept-Encoding", "compress;q=0.5, gzip;q=1.0");
            this.mdZ.setRequestProperty("Cookie", J(bVar.mcz));
            this.mdZ.connect();
            outputStream3 = this.mdZ.getOutputStream();
            try {
                if (bVar.mcx == 1) {
                    a(bVar, outputStream3);
                }
                outputStream3.flush();
                responseCode = this.mdZ.getResponseCode();
            } catch (Exception e2) {
                e = e2;
                i = 0;
                try {
                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e, "", new Object[0]);
                    cVar = new c(i == 0 ? 503 : 500, null, null);
                    if (outputStream3 != null) {
                        try {
                            outputStream3.close();
                        } catch (Throwable e3) {
                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e3, "", new Object[0]);
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e32) {
                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e32, "", new Object[0]);
                        }
                    }
                    if (this.mdZ != null) {
                        return cVar;
                    }
                    this.mdZ.aBv.disconnect();
                    return cVar;
                } catch (Throwable th) {
                    e = th;
                    outputStream2 = outputStream3;
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (Throwable e322) {
                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e322, "", new Object[0]);
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e3222) {
                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e3222, "", new Object[0]);
                        }
                    }
                    if (this.mdZ != null) {
                        this.mdZ.aBv.disconnect();
                    }
                    throw e;
                }
            }
            try {
                Object obj;
                InputStream inputStream2;
                byte[] bArr;
                Map JR;
                c cVar2;
                String headerField = this.mdZ.getHeaderField("set-cookie");
                String headerField2 = this.mdZ.getHeaderField("Content-Encoding");
                String headerField3 = this.mdZ.getHeaderField("Content-Disposition");
                if (headerField3 != null && headerField3.contains("attachment;")) {
                    if (str2.contains("download")) {
                        obj = 1;
                        inputStream2 = this.mdZ.getInputStream();
                        if (headerField2 != null) {
                            try {
                                if (headerField2.contains("gzip")) {
                                    inputStream = new GZIPInputStream(inputStream2);
                                    outputStream = null;
                                    if (obj != null) {
                                        try {
                                            Object valueOf;
                                            String str3 = mcw;
                                            StringBuilder stringBuilder = new StringBuilder();
                                            if (bVar.mcy.get("default_attach_name") == null) {
                                                valueOf = Long.valueOf(System.currentTimeMillis());
                                            } else {
                                                Serializable valueOf2 = (Serializable) bVar.mcy.get("default_attach_name");
                                            }
                                            outputStream = new FileOutputStream(new File(str3, stringBuilder.append(valueOf2).toString()), true);
                                        } catch (Throwable e4) {
                                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e4, "", new Object[0]);
                                            cVar = new c(responseCode == 0 ? 503 : 500, null, null);
                                            if (outputStream != null) {
                                                outputStream.flush();
                                                outputStream.close();
                                            }
                                            if (outputStream3 != null) {
                                                try {
                                                    outputStream3.close();
                                                } catch (Throwable e32222) {
                                                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e32222, "", new Object[0]);
                                                }
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Throwable e322222) {
                                                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e322222, "", new Object[0]);
                                                }
                                            }
                                            if (this.mdZ == null) {
                                                return cVar;
                                            }
                                            this.mdZ.aBv.disconnect();
                                            return cVar;
                                        } catch (Throwable th2) {
                                            if (outputStream != null) {
                                                outputStream.flush();
                                                outputStream.close();
                                            }
                                        }
                                    } else {
                                        outputStream = new ByteArrayOutputStream();
                                    }
                                    bArr = new byte[1024];
                                    while (true) {
                                        i = inputStream.read(bArr);
                                        if (i <= 0) {
                                            break;
                                        }
                                        outputStream.write(bArr, 0, i);
                                        outputStream.flush();
                                        aVar.bol();
                                    }
                                    JR = JR(headerField);
                                    if (obj != null) {
                                        headerField3 = "";
                                    } else {
                                        headerField3 = new String(((ByteArrayOutputStream) outputStream).toByteArray());
                                    }
                                    cVar2 = new c(responseCode, JR, headerField3);
                                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.URLConnectionUtil", "uri=" + str2 + ", " + cVar2);
                                    outputStream.flush();
                                    outputStream.close();
                                    if (outputStream3 != null) {
                                        try {
                                            outputStream3.close();
                                        } catch (Throwable e42) {
                                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e42, "", new Object[0]);
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable e422) {
                                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e422, "", new Object[0]);
                                        }
                                    }
                                    if (this.mdZ != null) {
                                        this.mdZ.aBv.disconnect();
                                    }
                                    return cVar2;
                                }
                            } catch (Exception e5) {
                                e422 = e5;
                                i = responseCode;
                                inputStream = inputStream2;
                                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e422, "", new Object[0]);
                                if (i == 0) {
                                }
                                cVar = new c(i == 0 ? 503 : 500, null, null);
                                if (outputStream3 != null) {
                                    try {
                                        outputStream3.close();
                                    } catch (Throwable e3222222) {
                                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e3222222, "", new Object[0]);
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable e32222222) {
                                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e32222222, "", new Object[0]);
                                    }
                                }
                                if (this.mdZ != null) {
                                    return cVar;
                                }
                                this.mdZ.aBv.disconnect();
                                return cVar;
                            } catch (Throwable th3) {
                                e422 = th3;
                                inputStream = inputStream2;
                                outputStream2 = outputStream3;
                                if (outputStream2 != null) {
                                    try {
                                        outputStream2.close();
                                    } catch (Throwable e322222222) {
                                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e322222222, "", new Object[0]);
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable e3222222222) {
                                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e3222222222, "", new Object[0]);
                                    }
                                }
                                if (this.mdZ != null) {
                                    this.mdZ.aBv.disconnect();
                                }
                                throw e422;
                            }
                        }
                        inputStream = inputStream2;
                        outputStream = null;
                        if (obj != null) {
                            outputStream = new ByteArrayOutputStream();
                        } else {
                            try {
                                Object valueOf22;
                                String str32 = mcw;
                                StringBuilder stringBuilder2 = new StringBuilder();
                                if (bVar.mcy.get("default_attach_name") == null) {
                                    valueOf22 = Long.valueOf(System.currentTimeMillis());
                                } else {
                                    Serializable valueOf222 = (Serializable) bVar.mcy.get("default_attach_name");
                                }
                                outputStream = new FileOutputStream(new File(str32, stringBuilder2.append(valueOf222).toString()), true);
                            } catch (Throwable e4222) {
                                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e4222, "", new Object[0]);
                                cVar = new c(responseCode == 0 ? 503 : 500, null, null);
                                if (outputStream != null) {
                                    outputStream.flush();
                                    outputStream.close();
                                }
                                if (outputStream3 != null) {
                                    try {
                                        outputStream3.close();
                                    } catch (Throwable e32222222222) {
                                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e32222222222, "", new Object[0]);
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable e322222222222) {
                                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e322222222222, "", new Object[0]);
                                    }
                                }
                                if (this.mdZ == null) {
                                    return cVar;
                                }
                                this.mdZ.aBv.disconnect();
                                return cVar;
                            } catch (Throwable th22) {
                                if (outputStream != null) {
                                    outputStream.flush();
                                    outputStream.close();
                                }
                            }
                        }
                        bArr = new byte[1024];
                        while (true) {
                            i = inputStream.read(bArr);
                            if (i <= 0) {
                                break;
                            }
                            outputStream.write(bArr, 0, i);
                            outputStream.flush();
                            aVar.bol();
                        }
                        JR = JR(headerField);
                        if (obj != null) {
                            headerField3 = new String(((ByteArrayOutputStream) outputStream).toByteArray());
                        } else {
                            headerField3 = "";
                        }
                        cVar2 = new c(responseCode, JR, headerField3);
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.URLConnectionUtil", "uri=" + str2 + ", " + cVar2);
                        outputStream.flush();
                        outputStream.close();
                        if (outputStream3 != null) {
                            try {
                                outputStream3.close();
                            } catch (Throwable e42222) {
                                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e42222, "", new Object[0]);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e422222) {
                                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e422222, "", new Object[0]);
                            }
                        }
                        if (this.mdZ != null) {
                            this.mdZ.aBv.disconnect();
                        }
                        return cVar2;
                    }
                }
                obj = null;
                inputStream2 = this.mdZ.getInputStream();
                if (headerField2 != null) {
                    try {
                        if (headerField2.contains("gzip")) {
                            inputStream = new GZIPInputStream(inputStream2);
                            outputStream = null;
                            if (obj != null) {
                                try {
                                    Object valueOf2222;
                                    String str322 = mcw;
                                    StringBuilder stringBuilder22 = new StringBuilder();
                                    if (bVar.mcy.get("default_attach_name") == null) {
                                        valueOf2222 = Long.valueOf(System.currentTimeMillis());
                                    } else {
                                        Serializable valueOf22222 = (Serializable) bVar.mcy.get("default_attach_name");
                                    }
                                    outputStream = new FileOutputStream(new File(str322, stringBuilder22.append(valueOf22222).toString()), true);
                                } catch (Throwable e4222222) {
                                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e4222222, "", new Object[0]);
                                    cVar = new c(responseCode == 0 ? 503 : 500, null, null);
                                    if (outputStream != null) {
                                        outputStream.flush();
                                        outputStream.close();
                                    }
                                    if (outputStream3 != null) {
                                        try {
                                            outputStream3.close();
                                        } catch (Throwable e3222222222222) {
                                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e3222222222222, "", new Object[0]);
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable e32222222222222) {
                                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e32222222222222, "", new Object[0]);
                                        }
                                    }
                                    if (this.mdZ == null) {
                                        return cVar;
                                    }
                                    this.mdZ.aBv.disconnect();
                                    return cVar;
                                } catch (Throwable th222) {
                                    if (outputStream != null) {
                                        outputStream.flush();
                                        outputStream.close();
                                    }
                                }
                            } else {
                                outputStream = new ByteArrayOutputStream();
                            }
                            bArr = new byte[1024];
                            while (true) {
                                i = inputStream.read(bArr);
                                if (i <= 0) {
                                    break;
                                }
                                outputStream.write(bArr, 0, i);
                                outputStream.flush();
                                aVar.bol();
                            }
                            JR = JR(headerField);
                            if (obj != null) {
                                headerField3 = "";
                            } else {
                                headerField3 = new String(((ByteArrayOutputStream) outputStream).toByteArray());
                            }
                            cVar2 = new c(responseCode, JR, headerField3);
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.URLConnectionUtil", "uri=" + str2 + ", " + cVar2);
                            outputStream.flush();
                            outputStream.close();
                            if (outputStream3 != null) {
                                try {
                                    outputStream3.close();
                                } catch (Throwable e42222222) {
                                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e42222222, "", new Object[0]);
                                }
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e422222222) {
                                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e422222222, "", new Object[0]);
                                }
                            }
                            if (this.mdZ != null) {
                                this.mdZ.aBv.disconnect();
                            }
                            return cVar2;
                        }
                    } catch (Exception e52) {
                        e422222222 = e52;
                        i = responseCode;
                        inputStream = inputStream2;
                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e422222222, "", new Object[0]);
                        if (i == 0) {
                        }
                        cVar = new c(i == 0 ? 503 : 500, null, null);
                        if (outputStream3 != null) {
                            try {
                                outputStream3.close();
                            } catch (Throwable e322222222222222) {
                                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e322222222222222, "", new Object[0]);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e3222222222222222) {
                                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e3222222222222222, "", new Object[0]);
                            }
                        }
                        if (this.mdZ != null) {
                            return cVar;
                        }
                        this.mdZ.aBv.disconnect();
                        return cVar;
                    } catch (Throwable th32) {
                        e422222222 = th32;
                        inputStream = inputStream2;
                        outputStream2 = outputStream3;
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (Throwable e32222222222222222) {
                                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e32222222222222222, "", new Object[0]);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e322222222222222222) {
                                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e322222222222222222, "", new Object[0]);
                            }
                        }
                        if (this.mdZ != null) {
                            this.mdZ.aBv.disconnect();
                        }
                        throw e422222222;
                    }
                }
                inputStream = inputStream2;
                outputStream = null;
                if (obj != null) {
                    try {
                        Object valueOf222222;
                        String str3222 = mcw;
                        StringBuilder stringBuilder222 = new StringBuilder();
                        if (bVar.mcy.get("default_attach_name") == null) {
                            valueOf222222 = Long.valueOf(System.currentTimeMillis());
                        } else {
                            Serializable valueOf2222222 = (Serializable) bVar.mcy.get("default_attach_name");
                        }
                        outputStream = new FileOutputStream(new File(str3222, stringBuilder222.append(valueOf2222222).toString()), true);
                    } catch (Throwable e4222222222) {
                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e4222222222, "", new Object[0]);
                        cVar = new c(responseCode == 0 ? 503 : 500, null, null);
                        if (outputStream != null) {
                            outputStream.flush();
                            outputStream.close();
                        }
                        if (outputStream3 != null) {
                            try {
                                outputStream3.close();
                            } catch (Throwable e3222222222222222222) {
                                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e3222222222222222222, "", new Object[0]);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e32222222222222222222) {
                                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e32222222222222222222, "", new Object[0]);
                            }
                        }
                        if (this.mdZ == null) {
                            return cVar;
                        }
                        this.mdZ.aBv.disconnect();
                        return cVar;
                    } catch (Throwable th2222) {
                        if (outputStream != null) {
                            outputStream.flush();
                            outputStream.close();
                        }
                    }
                } else {
                    outputStream = new ByteArrayOutputStream();
                }
                bArr = new byte[1024];
                while (true) {
                    i = inputStream.read(bArr);
                    if (i <= 0) {
                        break;
                    }
                    outputStream.write(bArr, 0, i);
                    outputStream.flush();
                    aVar.bol();
                }
                JR = JR(headerField);
                if (obj != null) {
                    headerField3 = "";
                } else {
                    headerField3 = new String(((ByteArrayOutputStream) outputStream).toByteArray());
                }
                cVar2 = new c(responseCode, JR, headerField3);
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.URLConnectionUtil", "uri=" + str2 + ", " + cVar2);
                outputStream.flush();
                outputStream.close();
                if (outputStream3 != null) {
                    try {
                        outputStream3.close();
                    } catch (Throwable e42222222222) {
                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e42222222222, "", new Object[0]);
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e422222222222) {
                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e422222222222, "", new Object[0]);
                    }
                }
                if (this.mdZ != null) {
                    this.mdZ.aBv.disconnect();
                }
                return cVar2;
            } catch (Exception e6) {
                e422222222222 = e6;
                i = responseCode;
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e422222222222, "", new Object[0]);
                if (i == 0) {
                }
                cVar = new c(i == 0 ? 503 : 500, null, null);
                if (outputStream3 != null) {
                    try {
                        outputStream3.close();
                    } catch (Throwable e322222222222222222222) {
                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e322222222222222222222, "", new Object[0]);
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e3222222222222222222222) {
                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e3222222222222222222222, "", new Object[0]);
                    }
                }
                if (this.mdZ != null) {
                    return cVar;
                }
                this.mdZ.aBv.disconnect();
                return cVar;
            }
        } catch (Exception e7) {
            e422222222222 = e7;
            i = 0;
            outputStream3 = null;
        } catch (Throwable th4) {
            e422222222222 = th4;
            if (outputStream2 != null) {
                try {
                    outputStream2.close();
                } catch (Throwable e32222222222222222222222) {
                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e32222222222222222222222, "", new Object[0]);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e322222222222222222222222) {
                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.URLConnectionUtil", e322222222222222222222222, "", new Object[0]);
                }
            }
            if (this.mdZ != null) {
                this.mdZ.aBv.disconnect();
            }
            throw e422222222222;
        }
    }

    public final void cancel() {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.URLConnectionUtil", "cancel conection.");
        if (this.mdZ != null) {
            this.mdZ.aBv.disconnect();
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
