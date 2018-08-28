package com.tencent.mm.model;

import android.os.Message;
import android.webkit.URLUtil;
import com.tencent.mm.a.e;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.w.c;
import com.tencent.mm.network.b;
import com.tencent.mm.network.u;
import com.tencent.mm.network.v;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

class w$a implements Runnable {
    final /* synthetic */ w dBg;
    public boolean dBj = true;

    w$a(w wVar) {
        this.dBg = wVar;
    }

    public final void run() {
        Throwable e;
        Throwable th;
        this.dBj = false;
        int i = 0;
        while (!this.dBj) {
            if (i > 10) {
                this.dBj = true;
                return;
            }
            OutputStream outputStream = null;
            InputStream inputStream = null;
            c cVar = null;
            try {
                c cVar2 = (c) this.dBg.dBe.poll(500, TimeUnit.MILLISECONDS);
                if (cVar2 != null) {
                    try {
                        if (!bi.oW(cVar2.url)) {
                            i = 0;
                            x.d("MicroMsg.GetPicService", "Thread get :" + cVar2.url + " file:" + cVar2.filename);
                            if (e.cn(cVar2.filename)) {
                                x.d("MicroMsg.GetPicService", "Thread exist file:" + cVar2.filename);
                            } else {
                                w.a(this.dBg, 0, 1);
                                long VF = bi.VF();
                                x.d("MicroMsg.GetPicService", "get GetPicRunnable, run, url:%s", new Object[]{cVar2.url});
                                byte[] bArr;
                                OutputStream fileOutputStream;
                                int read;
                                String contentType;
                                if (URLUtil.isHttpsUrl(cVar2.url)) {
                                    v oy = b.oy(cVar2.url);
                                    if (q.Pn() && q.lY(cVar2.url)) {
                                        x.d("MicroMsg.GetPicService", "webp referer:%s", new Object[]{q.hY(d.qVN)});
                                        oy.esX.setRequestProperty("Referer", r3);
                                    }
                                    x.i("MicroMsg.GetPicService", "getCookie = %s, url = %s", new Object[]{cVar2.dBl, cVar2.url});
                                    if (!bi.oW(cVar2.dBl)) {
                                        String str = cVar2.dBl;
                                        oy.esX.setRequestProperty("Cookie", str);
                                    }
                                    oy.UM();
                                    oy.UK();
                                    oy.UL();
                                    inputStream = oy.esX.getInputStream();
                                    bArr = new byte[1024];
                                    fileOutputStream = new FileOutputStream(cVar2.filename + ".tmp");
                                    while (true) {
                                        try {
                                            read = inputStream.read(bArr);
                                            if (read == -1) {
                                                break;
                                            }
                                            fileOutputStream.write(bArr, 0, read);
                                        } catch (Exception e2) {
                                            e = e2;
                                            cVar = cVar2;
                                            outputStream = fileOutputStream;
                                            try {
                                                x.e("MicroMsg.GetPicService", "exception:%s", new Object[]{bi.i(e)});
                                                w.a(this.dBg, 2, 1);
                                                w.a(this.dBg, 15, 1);
                                                if (outputStream != null) {
                                                    try {
                                                        outputStream.close();
                                                    } catch (Exception e3) {
                                                    }
                                                }
                                                if (inputStream == null) {
                                                    inputStream.close();
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                if (outputStream != null) {
                                                    try {
                                                        outputStream.close();
                                                    } catch (Exception e4) {
                                                        throw th;
                                                    }
                                                }
                                                if (inputStream != null) {
                                                    inputStream.close();
                                                }
                                                throw th;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            outputStream = fileOutputStream;
                                            if (outputStream != null) {
                                                try {
                                                    outputStream.close();
                                                } catch (Exception e42) {
                                                    throw th;
                                                }
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    new File(cVar2.filename + ".tmp").renameTo(new File(cVar2.filename));
                                    contentType = oy.esX.getContentType();
                                    x.d("MicroMsg.GetPicService", "contentType:%s", new Object[]{contentType});
                                    outputStream = fileOutputStream;
                                } else {
                                    u a = b.a(cVar2.url, null);
                                    if (q.Pn() && q.lY(cVar2.url)) {
                                        x.d("MicroMsg.GetPicService", "webp referer:%s", new Object[]{q.hY(d.qVN)});
                                        a.oz(r3);
                                    }
                                    x.i("MicroMsg.GetPicService", "getCookie = %s, url = %s", new Object[]{cVar2.dBl, cVar2.url});
                                    if (!bi.oW(cVar2.dBl)) {
                                        a.setRequestProperty("Cookie", cVar2.dBl);
                                    }
                                    a.setUseCaches(true);
                                    a.setConnectTimeout(3000);
                                    a.setReadTimeout(3000);
                                    inputStream = a.getInputStream();
                                    bArr = new byte[1024];
                                    fileOutputStream = new FileOutputStream(cVar2.filename + ".tmp");
                                    while (true) {
                                        try {
                                            read = inputStream.read(bArr);
                                            if (read == -1) {
                                                break;
                                            }
                                            fileOutputStream.write(bArr, 0, read);
                                        } catch (Exception e5) {
                                            e = e5;
                                            cVar = cVar2;
                                            outputStream = fileOutputStream;
                                            x.e("MicroMsg.GetPicService", "exception:%s", new Object[]{bi.i(e)});
                                            w.a(this.dBg, 2, 1);
                                            if (cVar != null && q.lY(cVar.url)) {
                                                w.a(this.dBg, 15, 1);
                                            }
                                            if (outputStream != null) {
                                                try {
                                                    outputStream.close();
                                                } catch (Exception e32) {
                                                }
                                            }
                                            if (inputStream == null) {
                                                inputStream.close();
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            outputStream = fileOutputStream;
                                            if (outputStream != null) {
                                                try {
                                                    outputStream.close();
                                                } catch (Exception e422) {
                                                    throw th;
                                                }
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    new File(cVar2.filename + ".tmp").renameTo(new File(cVar2.filename));
                                    contentType = a.aBv.getContentType();
                                    x.d("MicroMsg.GetPicService", "contentType:%s", new Object[]{contentType});
                                    outputStream = fileOutputStream;
                                }
                                if (q.Pn() && q.lY(cVar2.url) && !bi.oW(contentType) && contentType.equals("image/webp")) {
                                    x.d("MicroMsg.GetPicService", "receive a webp picture");
                                    cVar2.dBk = true;
                                    w.a(this.dBg, 13, 1);
                                } else {
                                    cVar2.dBk = false;
                                }
                                Message message = new Message();
                                message.obj = cVar2;
                                message.arg1 = cVar2.pos;
                                this.dBg.handler.sendMessage(message);
                                long VF2 = bi.VF() - VF;
                                x.d("MicroMsg.GetPicService", "download image used: %dms", new Object[]{Long.valueOf(VF2)});
                                w.a(this.dBg, 4, VF2);
                                if (cVar2 != null && cVar2.dBk) {
                                    w.a(this.dBg, 17, VF2);
                                }
                                try {
                                    outputStream.close();
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                } catch (Exception e6) {
                                }
                            }
                        }
                    } catch (Exception e7) {
                        e = e7;
                        cVar = cVar2;
                    }
                }
                i++;
            } catch (Throwable th5) {
                e = th5;
                x.e("MicroMsg.GetPicService", "exception:%s", new Object[]{bi.i(e)});
                w.a(this.dBg, 2, 1);
                w.a(this.dBg, 15, 1);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e322) {
                    }
                }
                if (inputStream == null) {
                    inputStream.close();
                }
            }
        }
    }
}
