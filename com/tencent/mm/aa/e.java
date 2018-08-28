package com.tencent.mm.aa;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.mm.a.f;
import com.tencent.mm.a.o;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.u;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ano;
import com.tencent.mm.protocal.c.aue;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public final class e implements com.tencent.mm.ab.e {
    boolean dGS = false;
    Set<String> dGT = new HashSet();
    f<String, c> dGU = new f(400);
    Stack<j> dGV = new Stack();
    private at dGW = null;
    private at dGX = null;
    String dGY = null;
    f<String, String> dGZ = new f(HardCoderJNI.sHCDBDELAY_WRITE);
    al dHa = new al(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
        private long dHc = 0;

        public final boolean vD() {
            long currentTimeMillis = System.currentTimeMillis();
            if (e.this.dGS && currentTimeMillis - this.dHc > 60000) {
                x.w("MicroMsg.AvatarService", "do scene TIMEOUT: %d", Long.valueOf(currentTimeMillis - this.dHc));
                e.this.dGS = false;
            }
            if (e.this.dGS) {
                e.this.dHa.J(1000, 1000);
                return false;
            }
            this.dHc = currentTimeMillis;
            e.this.dGS = true;
            LinkedList linkedList = new LinkedList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 5 || e.this.dGV.size() <= 0) {
                    g.DF().a(new l(linkedList), 0);
                    h.mEJ.a(138, 44, 1, true);
                } else {
                    h.mEJ.a(138, 42, 1, true);
                    linkedList.add(new bhz().VO(((j) e.this.dGV.pop()).getUsername()));
                    i = i2 + 1;
                }
            }
            g.DF().a(new l(linkedList), 0);
            h.mEJ.a(138, 44, 1, true);
            return false;
        }
    }, false);

    private static class c {
        public long dDj;
        public int dHg;

        private c() {
            this.dDj = 0;
            this.dHg = 0;
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    private class a implements com.tencent.mm.sdk.platformtools.at.a {
        public j dHd = null;
        public byte[] dHe = null;

        public a(j jVar) {
            this.dHd = jVar;
        }

        public final boolean Kr() {
            h hVar;
            Object[] objArr;
            if (this.dHd == null) {
                return false;
            }
            if (!ao.isNetworkConnected(ad.getContext())) {
                x.w("MicroMsg.HttpGetAvatar", "[tomys] network is unavailable, skip rest loading logic.");
                x.chR();
            }
            String Ky = this.dHd.Ky();
            String str = "";
            if (g.Eg().Dx()) {
                r1 = new Object[4];
                g.Eg();
                r1[1] = o.getString(com.tencent.mm.kernel.a.Df());
                r1[2] = Integer.valueOf(ao.getNetTypeForStat(ad.getContext()));
                r1[3] = Integer.valueOf(ao.getStrength(ad.getContext()));
                str = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", r1);
            }
            x.d("MicroMsg.HttpGetAvatar", "dkreferer dkavatar user: %s referer: %s", this.dHd.getUsername(), str);
            this.dHe = null;
            u uVar = null;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            InputStream inputStream = null;
            h.mEJ.a(138, 40, 1, true);
            try {
                uVar = com.tencent.mm.network.b.a(Ky, null);
                uVar.setRequestMethod("GET");
                uVar.setRequestProperty("referer", str);
                uVar.setConnectTimeout(5000);
                uVar.setReadTimeout(5000);
                if (com.tencent.mm.network.b.a(uVar) != 0) {
                    int responseCode = uVar.getResponseCode();
                    Map headerFields = uVar.getHeaderFields();
                    List list = headerFields != null ? (List) headerFields.get("X-ErrNo") : null;
                    str = (list == null || list.size() <= 0) ? "" : (String) list.get(0);
                    x.e("MicroMsg.HttpGetAvatar", "checkHttpConnection failed! url:%s code:%d xErr:%s", Ky, Integer.valueOf(responseCode), str);
                    switch (responseCode) {
                        case 404:
                            h.mEJ.a(138, 2, 1, true);
                            h.mEJ.h(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.dHd.getUsername(), uVar.esW, Integer.valueOf(uVar.erZ), uVar.url.getHost(), Ky, str);
                            break;
                        case 502:
                            h.mEJ.a(138, 3, 1, true);
                            h.mEJ.h(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.dHd.getUsername(), uVar.esW, Integer.valueOf(uVar.erZ), uVar.url.getHost(), Ky, str);
                            break;
                        case 503:
                            h.mEJ.a(138, 4, 1, true);
                            h.mEJ.h(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.dHd.getUsername(), uVar.esW, Integer.valueOf(uVar.erZ), uVar.url.getHost(), Ky, str);
                            break;
                        case 504:
                            h.mEJ.a(138, 5, 1, true);
                            h.mEJ.h(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.dHd.getUsername(), uVar.esW, Integer.valueOf(uVar.erZ), uVar.url.getHost(), Ky, str);
                            break;
                        default:
                            h.mEJ.a(138, 6, 1, true);
                            h.mEJ.h(14058, Integer.valueOf(100001), Integer.valueOf(responseCode), "", Integer.valueOf(0), this.dHd.getUsername(), uVar.esW, Integer.valueOf(uVar.erZ), uVar.url.getHost(), Ky, str);
                            break;
                    }
                    return true;
                }
                int contentLength = uVar.aBv.getContentLength();
                inputStream = uVar.getInputStream();
                if (inputStream == null) {
                    x.d("MicroMsg.HttpGetAvatar", "getInputStream failed. url:%s", Ky);
                    return true;
                }
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                h.mEJ.a(138, 41, 1, true);
                if (com.tencent.mm.sdk.a.b.chp()) {
                    h.mEJ.h(14058, Integer.valueOf(100001), Integer.valueOf(HardCoderJNI.sHCENCODEVIDEOTIMEOUT), "", Integer.valueOf(contentLength), this.dHd.getUsername(), uVar.esW, Integer.valueOf(uVar.erZ), uVar.url.getHost(), Ky, "");
                }
                this.dHe = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                byteArrayOutputStream = null;
                uVar.aBv.disconnect();
                uVar = null;
                inputStream.close();
                inputStream = null;
                if (contentLength > 0 && this.dHe.length < contentLength) {
                    h.mEJ.a(138, 15, 1, true);
                    x.e("MicroMsg.HttpGetAvatar", "HTTP downloaded length is smaller than Content-Length field. Drop.");
                }
                if (uVar != null) {
                    try {
                        uVar.aBv.disconnect();
                    } catch (Throwable e) {
                        x.e("MicroMsg.HttpGetAvatar", "exception:%s", bi.i(e));
                        x.e("MicroMsg.HttpGetAvatar", "close conn failed : %s", e.getMessage());
                        h.mEJ.a(138, 9, 1, true);
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                return true;
            } catch (ProtocolException e2) {
                ProtocolException protocolException = e2;
                h.mEJ.a(138, 1, 1, true);
                hVar = h.mEJ;
                objArr = new Object[10];
                objArr[0] = Integer.valueOf(100001);
                objArr[1] = Integer.valueOf(10001);
                objArr[2] = protocolException.getMessage();
                objArr[3] = Integer.valueOf(0);
                objArr[4] = this.dHd.getUsername();
                if (uVar == null) {
                    str = "null";
                } else {
                    str = uVar.esW;
                }
                objArr[5] = str;
                objArr[6] = uVar == null ? "null" : Integer.valueOf(uVar.erZ);
                objArr[7] = uVar == null ? "null" : uVar.url.getHost();
                objArr[8] = Ky;
                objArr[9] = "";
                hVar.h(14058, objArr);
                x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Ky, protocolException.getClass().getSimpleName(), protocolException.getMessage());
            } catch (SocketTimeoutException e3) {
                SocketTimeoutException socketTimeoutException = e3;
                h.mEJ.a(138, 8, 1, true);
                hVar = h.mEJ;
                objArr = new Object[10];
                objArr[0] = Integer.valueOf(100001);
                objArr[1] = Integer.valueOf(10002);
                objArr[2] = socketTimeoutException.getMessage();
                objArr[3] = Integer.valueOf(0);
                objArr[4] = this.dHd.getUsername();
                if (uVar == null) {
                    str = "null";
                } else {
                    str = uVar.esW;
                }
                objArr[5] = str;
                objArr[6] = uVar == null ? "null" : Integer.valueOf(uVar.erZ);
                objArr[7] = uVar == null ? "null" : uVar.url.getHost();
                objArr[8] = Ky;
                objArr[9] = "";
                hVar.h(14058, objArr);
                x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Ky, socketTimeoutException.getClass().getSimpleName(), socketTimeoutException.getMessage());
            } catch (IOException e4) {
                IOException iOException = e4;
                h.mEJ.a(138, 7, 1, true);
                hVar = h.mEJ;
                objArr = new Object[10];
                objArr[0] = Integer.valueOf(100001);
                objArr[1] = Integer.valueOf(10003);
                objArr[2] = iOException.getMessage();
                objArr[3] = Integer.valueOf(0);
                objArr[4] = this.dHd.getUsername();
                if (uVar == null) {
                    str = "null";
                } else {
                    str = uVar.esW;
                }
                objArr[5] = str;
                objArr[6] = uVar == null ? "null" : Integer.valueOf(uVar.erZ);
                objArr[7] = uVar == null ? "null" : uVar.url.getHost();
                objArr[8] = Ky;
                objArr[9] = "";
                hVar.h(14058, objArr);
                x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Ky, iOException.getClass().getSimpleName(), iOException.getMessage());
            } catch (Exception e5) {
                Exception exception = e5;
                h.mEJ.a(138, 0, 1, true);
                hVar = h.mEJ;
                objArr = new Object[10];
                objArr[0] = Integer.valueOf(100001);
                objArr[1] = Integer.valueOf(10003);
                objArr[2] = exception.getMessage();
                objArr[3] = Integer.valueOf(0);
                objArr[4] = this.dHd.getUsername();
                if (uVar == null) {
                    str = "null";
                } else {
                    str = uVar.esW;
                }
                objArr[5] = str;
                if (uVar == null) {
                    str = "null";
                } else {
                    str = Integer.valueOf(uVar.erZ);
                }
                objArr[6] = str;
                if (uVar == null) {
                    str = "null";
                } else {
                    str = uVar.url.getHost();
                }
                objArr[7] = str;
                objArr[8] = Ky;
                objArr[9] = "";
                hVar.h(14058, objArr);
                x.e("MicroMsg.HttpGetAvatar", "HTTP download exception: url:%s exception:%s %s", Ky, exception.getClass().getSimpleName(), exception.getMessage());
            }
        }

        public final boolean Ks() {
            if (!(this.dHd == null || bi.oW(this.dHd.getUsername()))) {
                if (bi.bC(this.dHe)) {
                    e.this.dGT.remove(this.dHd.getUsername());
                    h.mEJ.a(138, 10, 1, true);
                } else {
                    if (com.tencent.mm.model.am.a.dBs != null) {
                        com.tencent.mm.model.am.a.dBs.aY(this.dHe.length, 0);
                    }
                    e.this.a(new d(this.dHd, this.dHe));
                }
            }
            return false;
        }
    }

    private class b implements com.tencent.mm.sdk.platformtools.at.a {
        Bitmap dHf = null;
        String username = null;

        public b(String str) {
            this.username = str;
        }

        public final boolean Kr() {
            j jVar = null;
            int i = 0;
            if (bi.oW(this.username)) {
                return false;
            }
            String str = this.username;
            if (str == null ? false : str.startsWith("ammURL_")) {
                String str2 = (String) e.this.dGZ.get(str);
                if (!bi.oW(str2)) {
                    j kc = q.KH().kc(str);
                    if (kc == null || !str.equals(kc.getUsername())) {
                        Cursor b = q.KH().dCZ.b("select img_flag.username,img_flag.imgflag,img_flag.lastupdatetime,img_flag.reserved1,img_flag.reserved2,img_flag.reserved3,img_flag.reserved4 from img_flag where img_flag.reserved2=\"" + bi.oU(str2) + "\"", null, 2);
                        if (b != null) {
                            if (b.moveToFirst()) {
                                b.moveToFirst();
                                jVar = new j();
                                jVar.d(b);
                            }
                            b.close();
                        }
                        if (!(jVar == null || bi.oW(jVar.getUsername()))) {
                            FileOp.y(c.A(jVar.getUsername(), false), c.A(str, true));
                        }
                        jVar = new j();
                        jVar.username = str;
                        jVar.csA = 3;
                        jVar.dHQ = str2;
                        jVar.dHR = str2;
                        jVar.bWA = 3;
                        jVar.by(true);
                        jVar.bWA = 31;
                        q.KH().a(jVar);
                    }
                }
            }
            f Kp = e.Kp();
            if (Kp == null) {
                return false;
            }
            if (f.dHm.containsKey(this.username)) {
                i = ((Integer) f.dHm.get(this.username)).intValue();
            }
            if (i != 0) {
                q.KG();
                Context context = q.getContext();
                if (context != null) {
                    Kp.f(this.username, com.tencent.mm.compatible.g.a.decodeResource(context.getResources(), i));
                }
            }
            this.dHf = Kp.jT(this.username);
            return true;
        }

        public final boolean Ks() {
            if (this.dHf == null) {
                j jVar;
                e eVar = e.this;
                String str = this.username;
                x.d("MicroMsg.AvatarService", "avatar service push: %s", str);
                if (bi.oW(str)) {
                    jVar = null;
                } else if (str.equals(eVar.dGY + "@bottle") && !bi.a((Boolean) g.Ei().DT().get(60, null), false)) {
                    jVar = null;
                } else if (!str.equals(eVar.dGY) || bi.a((Boolean) g.Ei().DT().get(59, null), false)) {
                    long VE = bi.VE();
                    c cVar = (c) eVar.dGU.get(str);
                    if (cVar == null || cVar.dHg < 5 || VE - cVar.dDj >= 600) {
                        j jQ = e.jQ(str);
                        if (jQ == null) {
                            x.w("MicroMsg.AvatarService", "checkUser block local no need: %s", str);
                            cVar = new c();
                            cVar.dHg = 5;
                            cVar.dDj = VE;
                            eVar.dGU.m(str, cVar);
                            jVar = null;
                        } else {
                            if (cVar == null || VE - cVar.dDj > 600) {
                                x.d("MicroMsg.AvatarService", "new user: %s", str);
                                cVar = new c();
                                cVar.dHg = 1;
                                cVar.dDj = VE;
                                eVar.dGU.m(str, cVar);
                            } else if (cVar.dHg < 5) {
                                x.d("MicroMsg.AvatarService", "checkUser: %s tryCount: %d time: %d", str, Integer.valueOf(cVar.dHg), Long.valueOf(VE - cVar.dDj));
                                cVar.dHg++;
                                cVar.dDj = VE;
                                eVar.dGU.m(str, cVar);
                            }
                            jVar = jQ;
                        }
                    } else {
                        x.w("MicroMsg.AvatarService", "checkUser block by recentdown: %s", str);
                        jVar = null;
                    }
                } else {
                    jVar = null;
                }
                if (jVar == null) {
                    eVar.dGT.remove(str);
                } else if (bi.oW(jVar.Ky())) {
                    x.w("MicroMsg.AvatarService", "dkhurl [%s] has NO URL flag:%d !", str, Integer.valueOf(jVar.csA));
                    if (4 == jVar.csA) {
                        x.w("MicroMsg.AvatarService", "no avatar, do not batch get head image");
                    } else {
                        eVar.dGV.push(jVar);
                        if (eVar.dGV.size() > 5) {
                            eVar.dHa.J(0, 0);
                        } else {
                            eVar.dHa.J(1000, 1000);
                        }
                    }
                } else {
                    eVar.a(new a(jVar));
                }
                return false;
            }
            f Kp = e.Kp();
            if (Kp != null) {
                Kp.e(this.username, this.dHf);
            }
            e.this.dGT.remove(this.username);
            return false;
        }
    }

    private class d implements com.tencent.mm.sdk.platformtools.at.a {
        Bitmap bitmap = null;
        byte[] buf;
        j dHh = null;

        public d(j jVar, byte[] bArr) {
            this.dHh = jVar;
            this.buf = bArr;
        }

        public final boolean Kr() {
            if (this.dHh == null || bi.oW(this.dHh.getUsername())) {
                x.e("MicroMsg.AvatarService", "SaveAvatar imgFlag info is null");
                h.mEJ.a(138, 13, 1, true);
                return false;
            }
            f Kp = e.Kp();
            if (Kp != null) {
                this.bitmap = Kp.f(this.dHh.getUsername(), this.buf);
                if (this.bitmap == null) {
                    h.mEJ.a(138, 14, 1, true);
                }
            }
            k Kq = e.Kq();
            if (Kq == null) {
                return true;
            }
            this.dHh.bWA = -1;
            this.dHh.Kz();
            Kq.a(this.dHh);
            return true;
        }

        public final boolean Ks() {
            if (!bi.oW(this.dHh.getUsername())) {
                f Kp = e.Kp();
                if (!(Kp == null || this.bitmap == null)) {
                    Kp.e(this.dHh.getUsername(), this.bitmap);
                }
                e.this.dGT.remove(this.dHh.getUsername());
            }
            return false;
        }
    }

    static /* synthetic */ k Kq() {
        return g.Eg().Dx() ? q.KH() : null;
    }

    public e() {
        g.DF().a(123, (com.tencent.mm.ab.e) this);
        this.dGS = false;
        this.dGY = q.GF();
    }

    public final Bitmap b(String str, boolean z, int i) {
        Bitmap bitmap;
        f Kp = Kp();
        if (Kp != null) {
            if (i < 0 || i <= 5) {
                bitmap = null;
            } else {
                bitmap = f.jS(String.format("%s$$%d", new Object[]{str, Integer.valueOf(i)}));
                if (bitmap != null) {
                    x.i("MicroMsg.AvatarService", "find custom corner avatar, custom corner %d", Integer.valueOf(i));
                    return bitmap;
                }
                x.i("MicroMsg.AvatarService", "can not find custom corner avatar, custom corner %d", Integer.valueOf(i));
            }
            if (bitmap == null) {
                bitmap = f.jS(str);
            }
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            if (i < 0 || i <= 5) {
                return bitmap;
            }
            x.i("MicroMsg.AvatarService", "create custom corner avatar, custom corner %d", Integer.valueOf(i));
            bitmap = com.tencent.mm.sdk.platformtools.c.a(bitmap, false, (float) i);
            Kp.e(String.format("%s$$%d", new Object[]{str, Integer.valueOf(i)}), bitmap);
            return bitmap;
        } else if (z) {
            return null;
        } else {
            x.v("MicroMsg.AvatarService", "get bitmap from cache failed, try to load :%s", str);
            if (this.dGT.contains(str)) {
                return null;
            }
            this.dGT.add(str);
            a(new b(str));
            return null;
        }
    }

    public final void jO(String str) {
        a(new b(str));
    }

    public final void jP(final String str) {
        g.Em().H(new Runnable() {
            public final void run() {
                if (!bi.oW(str) && !str.equals(e.this.dGY)) {
                    k Kq = e.Kq();
                    if (Kq != null) {
                        j kc = Kq.kc(str);
                        if (kc != null && kc.getUsername().equals(str)) {
                            boolean z;
                            if (bi.VE() - (((long) kc.dHT) * 60) > TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z) {
                                return;
                            }
                            if (bi.oW(kc.Ky())) {
                                x.w("MicroMsg.AvatarService", "dkhurl user has no url [%s]", str);
                            } else if (e.Kp() != null) {
                                f.B(str, false);
                                f.B(str, true);
                                e.this.jO(str);
                            }
                        }
                    }
                }
            }

            public final String toString() {
                return super.toString() + "|checkAvatarExpire";
            }
        });
    }

    static j jQ(String str) {
        j kc = q.KH().kc(str);
        if (kc != null && kc.getUsername().equals(str)) {
            return kc;
        }
        ai Yg = ((i) g.l(i.class)).FR().Yg(str);
        if (Yg == null || !Yg.field_username.equals(str)) {
            boolean z;
            String str2 = "MicroMsg.AvatarService";
            String str3 = "ct == null? :%s";
            Object[] objArr = new Object[2];
            if (Yg == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = str;
            x.d(str2, str3, objArr);
            return null;
        } else if (Yg.csA == 4) {
            c.J(str, Yg.csA);
            x.d("MicroMsg.AvatarService", "ct imgFlag :%s", Integer.valueOf(Yg.csA));
            return null;
        } else {
            kc = new j();
            kc.username = str;
            kc.csA = 3;
            byte[] Yk = ((i) g.l(i.class)).FR().Yk(str);
            if (bi.bC(Yk)) {
                return kc;
            }
            j a;
            try {
                a = c.a(str, (aue) new aue().aG(Yk));
            } catch (Throwable e) {
                x.e("MicroMsg.AvatarService", "exception:%s", bi.i(e));
                a = kc;
            }
            return a;
        }
    }

    public final void cancel() {
        while (this.dGV.size() > 0) {
            this.dGT.remove(this.dGV.pop());
        }
    }

    final int a(com.tencent.mm.sdk.platformtools.at.a aVar) {
        if (aVar instanceof a) {
            if (this.dGW == null) {
                this.dGW = new at(1, "getavatar", 2, g.Em().lnJ.getLooper());
            }
            return this.dGW.c(aVar);
        }
        if (this.dGX == null) {
            this.dGX = new at(1, "readsave", 1, g.Em().lnJ.getLooper());
        }
        return this.dGX.c(aVar);
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() == 123) {
            if (!(i == 0 && i2 == 0)) {
                h.mEJ.a(138, 12, 1, true);
            }
            h.mEJ.a(138, 45, 1, true);
            l lVar2 = (l) lVar;
            Set hashSet = new HashSet();
            if (lVar2.dHW != null) {
                Iterator it = lVar2.dHW.iterator();
                while (it.hasNext()) {
                    ano ano = (ano) it.next();
                    String str2 = ano.rQp.siM;
                    if (ano.rcn == null || ano.rcn.siK == null || ano.rcn.siK.lR == null) {
                        h.mEJ.a(138, 11, 1, true);
                    } else {
                        hashSet.add(str2);
                        j jVar = new j();
                        jVar.username = str2;
                        jVar.csA = 3;
                        h.mEJ.a(138, 43, 1, true);
                        a(new d(jVar, ano.rcn.siK.lR));
                    }
                }
            }
            if (lVar2.dHV != null) {
                Iterator it2 = lVar2.dHV.iterator();
                while (it2.hasNext()) {
                    String str3 = ((bhz) it2.next()).siM;
                    if (!hashSet.contains(str3)) {
                        this.dGT.remove(str3);
                    }
                }
            }
            this.dGS = false;
            if (this.dGV.size() > 0) {
                this.dHa.J(0, 0);
            }
        }
    }

    static f Kp() {
        if (g.Eg().Dx()) {
            return q.Kp();
        }
        return null;
    }

    public final String jR(String str) {
        if (bi.oW(str)) {
            return "";
        }
        String format;
        try {
            format = String.format("%s%x_%s", new Object[]{"ammURL_", Integer.valueOf(str.hashCode()), str.substring(str.length() - 24, str.length() - 4)});
        } catch (Exception e) {
            format = String.format("%s%x_", new Object[]{"ammURL_", Integer.valueOf(str.hashCode())});
        }
        this.dGZ.put(format, str);
        return format;
    }
}
