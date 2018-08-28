package com.tencent.mm.aa;

import android.annotation.SuppressLint;
import com.tencent.mm.a.o;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.io.InputStream;
import java.io.OutputStream;
import junit.framework.Assert;
import org.xwalk.core.XWalkUpdater;

public final class g implements e {
    private at dHA = null;
    j dHh = null;
    b dHx = null;
    m dHy = null;
    boolean dHz = false;

    public interface b {
        int bd(int i, int i2);
    }

    @SuppressLint({"DefaultLocale"})
    class a implements com.tencent.mm.sdk.platformtools.at.a {
        public String dHB = null;
        public boolean dHC = true;
        private com.tencent.mm.compatible.util.g.a dHD;
        public j dHd = null;

        public a(j jVar) {
            this.dHd = jVar;
            this.dHB = q.Kp().c(jVar.getUsername(), true, false);
            this.dHD = new com.tencent.mm.compatible.util.g.a();
        }

        public final boolean Kr() {
            Throwable e;
            OutputStream outputStream;
            if (this.dHd == null) {
                return false;
            }
            String Kx = this.dHd.Kx();
            String str = "";
            if (com.tencent.mm.kernel.g.Eg().Dx()) {
                r3 = new Object[4];
                com.tencent.mm.kernel.g.Eg();
                r3[1] = o.getString(com.tencent.mm.kernel.a.Df());
                r3[2] = Integer.valueOf(ao.getNetTypeForStat(ad.getContext()));
                r3[3] = Integer.valueOf(ao.getStrength(ad.getContext()));
                str = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", r3);
            }
            x.d("MicroMsg.GetHDHeadImgHelper", "dkreferer dkavatar user: %s referer: %s  url:%s", this.dHd.getUsername(), str, Kx);
            this.dHC = true;
            u a;
            InputStream inputStream;
            try {
                a = com.tencent.mm.network.b.a(Kx, null);
                try {
                    a.setRequestMethod("GET");
                    a.setRequestProperty("referer", str);
                    a.setConnectTimeout(5000);
                    a.setReadTimeout(5000);
                    if (com.tencent.mm.network.b.a(a) != 0) {
                        x.e("MicroMsg.GetHDHeadImgHelper", "checkHttpConnection failed! url:%s", Kx);
                        return true;
                    }
                    inputStream = a.getInputStream();
                    if (inputStream == null) {
                        try {
                            x.d("MicroMsg.GetHDHeadImgHelper", "getInputStream failed. url:%s", Kx);
                            return true;
                        } catch (Exception e2) {
                            e = e2;
                            outputStream = null;
                            x.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", bi.i(e));
                            this.dHC = true;
                            if (a != null) {
                                try {
                                    a.aBv.disconnect();
                                } catch (Throwable e3) {
                                    x.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", bi.i(e3));
                                    x.e("MicroMsg.GetHDHeadImgHelper", "close conn failed : %s", e3.getMessage());
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            return true;
                        }
                    }
                    byte[] bArr = new byte[1024];
                    outputStream = FileOp.jx(this.dHB + ".tmp");
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            outputStream.write(bArr, 0, read);
                        } catch (Exception e4) {
                            e3 = e4;
                            x.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", bi.i(e3));
                            this.dHC = true;
                            if (a != null) {
                                try {
                                    a.aBv.disconnect();
                                } catch (Throwable e32) {
                                    x.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", bi.i(e32));
                                    x.e("MicroMsg.GetHDHeadImgHelper", "close conn failed : %s", e32.getMessage());
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            return true;
                        }
                    }
                    this.dHC = false;
                    outputStream.close();
                    a.aBv.disconnect();
                    try {
                        inputStream.close();
                        inputStream = null;
                        outputStream = null;
                        a = null;
                    } catch (Exception e5) {
                        e32 = e5;
                        outputStream = null;
                        a = null;
                        x.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", bi.i(e32));
                        this.dHC = true;
                        if (a != null) {
                            try {
                                a.aBv.disconnect();
                            } catch (Throwable e322) {
                                x.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", bi.i(e322));
                                x.e("MicroMsg.GetHDHeadImgHelper", "close conn failed : %s", e322.getMessage());
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        return true;
                    }
                    if (a != null) {
                        try {
                            a.aBv.disconnect();
                        } catch (Throwable e3222) {
                            x.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", bi.i(e3222));
                            x.e("MicroMsg.GetHDHeadImgHelper", "close conn failed : %s", e3222.getMessage());
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    return true;
                } catch (Exception e6) {
                    e3222 = e6;
                    inputStream = null;
                    outputStream = null;
                    x.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", bi.i(e3222));
                    this.dHC = true;
                    if (a != null) {
                        try {
                            a.aBv.disconnect();
                        } catch (Throwable e32222) {
                            x.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", bi.i(e32222));
                            x.e("MicroMsg.GetHDHeadImgHelper", "close conn failed : %s", e32222.getMessage());
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    return true;
                }
            } catch (Exception e7) {
                e32222 = e7;
                inputStream = null;
                outputStream = null;
                a = null;
            }
        }

        public final boolean Ks() {
            if (g.this.dHz) {
                return false;
            }
            if (this.dHC || bi.oW(this.dHB)) {
                g.this.dHx.bd(4, -1);
                return false;
            }
            x.d("MicroMsg.GetHDHeadImgHelper", "dkavatar user:" + this.dHd.getUsername() + " urltime:" + this.dHD.Ad());
            if (com.tencent.mm.model.am.a.dBs != null) {
                com.tencent.mm.model.am.a.dBs.aY((int) FileOp.mI(this.dHB + ".tmp"), 0);
            }
            FileOp.deleteFile(this.dHB);
            FileOp.av(this.dHB + ".tmp", this.dHB);
            m.ae(this.dHB, g.this.dHh.getUsername());
            g.this.dHx.bd(0, 0);
            return true;
        }
    }

    public g() {
        com.tencent.mm.kernel.g.DF().a(158, (e) this);
    }

    public final void Ku() {
        com.tencent.mm.kernel.g.DF().b(158, (e) this);
    }

    public final int a(String str, b bVar) {
        Assert.assertTrue("GetHDHeadImg must set callback", true);
        if (bi.oW(str)) {
            bVar.bd(3, XWalkUpdater.ERROR_SET_VERNUM);
            return XWalkUpdater.ERROR_SET_VERNUM;
        }
        String XV;
        this.dHx = bVar;
        if (ab.gY(str)) {
            XV = ab.XV(str);
        } else {
            XV = str;
        }
        this.dHh = q.KH().kc(XV);
        x.d("MicroMsg.GetHDHeadImgHelper", "GetHDHeadImg: %s", XV);
        if (this.dHh == null || !this.dHh.getUsername().equals(XV)) {
            this.dHh = new j();
            this.dHh.username = XV;
        }
        if (bi.oW(this.dHh.Kx())) {
            x.w("MicroMsg.GetHDHeadImgHelper", "dkhurl [%s] has NO URL flag:%d !", str, Integer.valueOf(this.dHh.csA));
            this.dHy = new m(XV);
            if (com.tencent.mm.kernel.g.DF().a(this.dHy, 0)) {
                return 0;
            }
            bVar.bd(3, -102);
            return -102;
        }
        j jVar = this.dHh;
        if (this.dHA == null || this.dHA.ciz()) {
            this.dHA = new at(1, "get-hd-headimg", 1);
        }
        if (this.dHA.c(new a(jVar)) == 0) {
            return 0;
        }
        bVar.bd(3, -103);
        return -103;
    }

    public final void a(int i, int i2, String str, l lVar) {
        this.dHx.bd(i, i2);
    }
}
