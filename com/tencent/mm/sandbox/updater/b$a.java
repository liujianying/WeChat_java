package com.tencent.mm.sandbox.updater;

import android.os.AsyncTask;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.network.u;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.aiw;
import com.tencent.mm.protocal.c.aix;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

class b$a extends AsyncTask<aiw, Integer, aix> {
    private String host = null;
    private u mdZ = null;
    private a sDE = null;
    final /* synthetic */ b sDH;
    private int sDI = 200;
    private PInt sDJ = new PInt();

    protected final /* synthetic */ void onPostExecute(Object obj) {
        aix aix = (aix) obj;
        x.d("MicroMsg.NetSceneGetUpdatePack", "onPostExecute, netRet=" + this.sDI + ", svrRet=" + this.sDJ.value + ", result=" + aix);
        this.sDE.a(this.sDI, this.sDJ.value, aix);
    }

    public b$a(b bVar, String str, a aVar) {
        this.sDH = bVar;
        this.host = str;
        this.sDE = aVar;
    }

    private aix a(aiw... aiwArr) {
        Throwable e;
        InputStream inputStream;
        if (aiwArr.length == 0 || aiwArr[0] == null) {
            this.sDI = -1;
            return null;
        }
        x.d("MicroMsg.NetSceneGetUpdatePack", "doInBackground, params=" + aiwArr[0]);
        aiw aiw = aiwArr[0];
        PByteArray pByteArray = new PByteArray();
        int i = 6;
        if (b.foreground) {
            i = 7;
        }
        try {
            MMProtocalJni.pack(aiw.toByteArray(), pByteArray, b.j(this.sDH), b.k(this.sDH), q.zz(), b.l(this.sDH), 113, 0, new byte[0], new byte[0], b.m(this.sDH), i);
            OutputStream outputStream = null;
            InputStream inputStream2 = null;
            try {
                this.mdZ = com.tencent.mm.network.b.a("http://" + this.host + "/cgi-bin/micromsg-bin/getupdatepack", null);
                this.mdZ.setRequestMethod("POST");
                this.mdZ.UI();
                this.mdZ.UJ();
                this.mdZ.setUseCaches(false);
                this.mdZ.setRequestProperty("User-Agent", "Android QQMail HTTP Client");
                this.mdZ.setRequestProperty("Connection", "Keep-Alive");
                this.mdZ.setRequestProperty("Cache-Control", "no-cache");
                this.mdZ.setRequestProperty("Content-Type", "application/octet-stream");
                this.mdZ.setRequestProperty("accept", "*/*");
                this.mdZ.setRequestProperty("Accept-Charset", "UTF-8");
                this.mdZ.setConnectTimeout(15000);
                this.mdZ.connect();
                OutputStream outputStream2 = this.mdZ.getOutputStream();
                try {
                    outputStream2.write(pByteArray.value);
                    outputStream2.flush();
                    this.sDE.fV(150 + ((long) pByteArray.value.length));
                    this.sDI = this.mdZ.getResponseCode();
                    if (this.sDI != 200) {
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e2, "", new Object[0]);
                            }
                        }
                        if (this.mdZ != null) {
                            this.mdZ.aBv.disconnect();
                            this.mdZ = null;
                        }
                        return null;
                    }
                    Object obj;
                    InputStream inputStream3;
                    String headerField = this.mdZ.getHeaderField("Content-Encoding");
                    InputStream inputStream4 = this.mdZ.getInputStream();
                    long j = 150;
                    if (headerField == null || !headerField.contains("gzip")) {
                        obj = null;
                        inputStream3 = inputStream4;
                    } else {
                        inputStream3 = new GZIPInputStream(inputStream4);
                        obj = 1;
                    }
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream3.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                            j += (long) read;
                        }
                        if (obj == null || !inputStream4.markSupported()) {
                            this.sDE.fW(j);
                        } else {
                            inputStream4.mark(1);
                            j = 150;
                            while (true) {
                                int read2 = inputStream4.read(bArr);
                                if (read2 <= 0) {
                                    break;
                                }
                                j += (long) read2;
                            }
                            this.sDE.fW(j);
                        }
                        PByteArray pByteArray2 = new PByteArray();
                        MMProtocalJni.unpack(pByteArray2, byteArrayOutputStream.toByteArray(), b.j(this.sDH), new PByteArray(), this.sDJ, new PInt(), new PInt(0), new PInt(255));
                        aix aix = (aix) new aix().aG(pByteArray2.value);
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (Throwable e3) {
                                x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e3, "", new Object[0]);
                            }
                        }
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (Throwable e32) {
                                x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e32, "", new Object[0]);
                            }
                        }
                        if (this.mdZ == null) {
                            return aix;
                        }
                        this.mdZ.aBv.disconnect();
                        this.mdZ = null;
                        return aix;
                    } catch (Exception e4) {
                        e2 = e4;
                        inputStream = inputStream3;
                        outputStream = outputStream2;
                    } catch (Throwable th) {
                        e2 = th;
                        inputStream2 = inputStream3;
                        outputStream = outputStream2;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Throwable e322) {
                                x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e322, "", new Object[0]);
                            }
                        }
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Throwable e3222) {
                                x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e3222, "", new Object[0]);
                            }
                        }
                        if (this.mdZ != null) {
                            this.mdZ.aBv.disconnect();
                            this.mdZ = null;
                        }
                        throw e2;
                    }
                } catch (Exception e5) {
                    e2 = e5;
                    inputStream = null;
                    outputStream = outputStream2;
                    try {
                        x.e("MicroMsg.NetSceneGetUpdatePack", "Exception in doInBackground, [%s]", new Object[]{e2.getMessage()});
                        x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e2, "", new Object[0]);
                        this.sDI = -1;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Throwable e22) {
                                x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e22, "", new Object[0]);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e222) {
                                x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e222, "", new Object[0]);
                            }
                        }
                        if (this.mdZ != null) {
                            this.mdZ.aBv.disconnect();
                            this.mdZ = null;
                        }
                        return null;
                    } catch (Throwable th2) {
                        e222 = th2;
                        inputStream2 = inputStream;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Throwable e32222) {
                                x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e32222, "", new Object[0]);
                            }
                        }
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Throwable e322222) {
                                x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e322222, "", new Object[0]);
                            }
                        }
                        if (this.mdZ != null) {
                            this.mdZ.aBv.disconnect();
                            this.mdZ = null;
                        }
                        throw e222;
                    }
                } catch (Throwable th3) {
                    e222 = th3;
                    outputStream = outputStream2;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable e3222222) {
                            x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e3222222, "", new Object[0]);
                        }
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable e32222222) {
                            x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e32222222, "", new Object[0]);
                        }
                    }
                    if (this.mdZ != null) {
                        this.mdZ.aBv.disconnect();
                        this.mdZ = null;
                    }
                    throw e222;
                }
            } catch (Exception e6) {
                e222 = e6;
                inputStream = null;
            } catch (Throwable th4) {
                e222 = th4;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable e322222222) {
                        x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e322222222, "", new Object[0]);
                    }
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Throwable e3222222222) {
                        x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e3222222222, "", new Object[0]);
                    }
                }
                if (this.mdZ != null) {
                    this.mdZ.aBv.disconnect();
                    this.mdZ = null;
                }
                throw e222;
            }
        } catch (Throwable e2222) {
            x.e("MicroMsg.NetSceneGetUpdatePack", "Exception in MMProtocalJni.pack(), [%s]", new Object[]{e2222.getMessage()});
            x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e2222, "", new Object[0]);
            return null;
        }
    }

    protected final void onCancelled() {
        x.d("MicroMsg.NetSceneGetUpdatePack", "task had been cancelled.");
        if (this.mdZ != null) {
            this.mdZ.aBv.disconnect();
        }
    }
}
