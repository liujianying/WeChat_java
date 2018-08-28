package com.tencent.mm.plugin.sns.ui;

import android.os.AsyncTask;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.ag;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

class SnsAdNativeLandingTestUI$a extends AsyncTask<String, Void, Void> {
    private static Set<String> nGe = new HashSet();
    private static byte[] nGf = new byte[0];
    final String fileName;
    final String filePath;
    final ag handler;
    final String nGg;
    final String nGh;
    final String nGi;
    final int nGk;
    final a nTi;

    public SnsAdNativeLandingTestUI$a(String str, String str2, ag agVar, a aVar) {
        this(str, str2, agVar, aVar, 0);
    }

    public SnsAdNativeLandingTestUI$a(String str, String str2, ag agVar, a aVar, int i) {
        FileOp.mL(str);
        this.nGi = str;
        this.fileName = str2;
        this.filePath = str + "/" + str2;
        this.nGh = "temp_" + str2;
        this.nGg = str + "/" + this.nGh;
        this.handler = agVar;
        this.nGk = i;
        this.nTi = new 1(this, agVar, aVar);
    }

    private Void y(String... strArr) {
        InputStream inputStream;
        OutputStream fileOutputStream;
        Exception e;
        HttpURLConnection httpURLConnection;
        Throwable th;
        int i = 0;
        synchronized (nGf) {
            if (nGe.contains(strArr[0])) {
            } else {
                nGe.add(strArr[0]);
                try {
                    if (FileOp.cn(this.filePath)) {
                        this.nTi.MZ(this.filePath);
                        synchronized (nGf) {
                            nGe.remove(strArr[0]);
                        }
                    } else {
                        if (FileOp.cn(this.nGg)) {
                            FileOp.deleteFile(this.nGg);
                        }
                        HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(strArr[0]).openConnection();
                        try {
                            httpURLConnection2.connect();
                            if (httpURLConnection2.getResponseCode() != 200) {
                                this.nTi.MY("Server returned HTTP " + httpURLConnection2.getResponseCode() + " " + httpURLConnection2.getResponseMessage());
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                }
                                synchronized (nGf) {
                                    nGe.remove(strArr[0]);
                                }
                            } else {
                                httpURLConnection2.getContentLength();
                                inputStream = httpURLConnection2.getInputStream();
                                try {
                                    fileOutputStream = new FileOutputStream(this.nGg);
                                } catch (Exception e2) {
                                    e = e2;
                                    httpURLConnection = httpURLConnection2;
                                    fileOutputStream = null;
                                    try {
                                        this.nTi.MY(e.getMessage());
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e3) {
                                                if (httpURLConnection != null) {
                                                    httpURLConnection.disconnect();
                                                }
                                                synchronized (nGf) {
                                                    nGe.remove(strArr[0]);
                                                }
                                                return null;
                                            }
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        synchronized (nGf) {
                                            nGe.remove(strArr[0]);
                                        }
                                        return null;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e4) {
                                                if (httpURLConnection != null) {
                                                    httpURLConnection.disconnect();
                                                }
                                                synchronized (nGf) {
                                                    nGe.remove(strArr[0]);
                                                }
                                                throw th;
                                            }
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        synchronized (nGf) {
                                            nGe.remove(strArr[0]);
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    httpURLConnection = httpURLConnection2;
                                    fileOutputStream = null;
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e42) {
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            synchronized (nGf) {
                                                nGe.remove(strArr[0]);
                                            }
                                            throw th;
                                        }
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    synchronized (nGf) {
                                        nGe.remove(strArr[0]);
                                    }
                                    throw th;
                                }
                                try {
                                    byte[] bArr = new byte[GLIcon.LEFT];
                                    int i2 = 0;
                                    while (true) {
                                        int i3 = i;
                                        i = inputStream.read(bArr);
                                        if (i == -1) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, i);
                                        i += i3;
                                        if (this.nGk != 0 && i - i2 >= this.nGk) {
                                            this.nTi.cg(this.nGg, i);
                                            i2 = i;
                                        }
                                    }
                                    FileOp.av(this.nGg, this.filePath);
                                    this.nTi.MZ(this.filePath);
                                    try {
                                        fileOutputStream.close();
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                    } catch (IOException e5) {
                                    }
                                    if (httpURLConnection2 != null) {
                                        httpURLConnection2.disconnect();
                                    }
                                    synchronized (nGf) {
                                        nGe.remove(strArr[0]);
                                    }
                                } catch (Exception e6) {
                                    e = e6;
                                    httpURLConnection = httpURLConnection2;
                                    this.nTi.MY(e.getMessage());
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e32) {
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            synchronized (nGf) {
                                                nGe.remove(strArr[0]);
                                            }
                                            return null;
                                        }
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    synchronized (nGf) {
                                        nGe.remove(strArr[0]);
                                    }
                                    return null;
                                } catch (Throwable th4) {
                                    th = th4;
                                    httpURLConnection = httpURLConnection2;
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e422) {
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            synchronized (nGf) {
                                                nGe.remove(strArr[0]);
                                            }
                                            throw th;
                                        }
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    synchronized (nGf) {
                                        nGe.remove(strArr[0]);
                                    }
                                    throw th;
                                }
                            }
                        } catch (Exception e7) {
                            e = e7;
                            httpURLConnection = httpURLConnection2;
                            fileOutputStream = null;
                            inputStream = null;
                        } catch (Throwable th5) {
                            th = th5;
                            httpURLConnection = httpURLConnection2;
                            fileOutputStream = null;
                            inputStream = null;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e4222) {
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    synchronized (nGf) {
                                        nGe.remove(strArr[0]);
                                    }
                                    throw th;
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            synchronized (nGf) {
                                nGe.remove(strArr[0]);
                            }
                            throw th;
                        }
                    }
                } catch (Exception e8) {
                    e = e8;
                    httpURLConnection = null;
                    fileOutputStream = null;
                    inputStream = null;
                    this.nTi.MY(e.getMessage());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e322) {
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            synchronized (nGf) {
                                nGe.remove(strArr[0]);
                            }
                            return null;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    synchronized (nGf) {
                        nGe.remove(strArr[0]);
                    }
                    return null;
                } catch (Throwable th22) {
                    th = th22;
                    httpURLConnection = null;
                    fileOutputStream = null;
                    inputStream = null;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e42222) {
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            synchronized (nGf) {
                                nGe.remove(strArr[0]);
                            }
                            throw th;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    synchronized (nGf) {
                        nGe.remove(strArr[0]);
                    }
                    throw th;
                }
            }
        }
        return null;
    }
}
