package com.tencent.mm.modelsimple;

import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bmz;
import com.tencent.mm.protocal.c.bnb;
import com.tencent.mm.protocal.c.bnc;
import com.tencent.mm.protocal.c.bnd;
import com.tencent.mm.protocal.c.ok;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.util.c;
import java.io.File;
import java.util.List;

public final class d extends l implements k {
    private b dZf;
    private e diJ;
    private List<String> eeX;
    private String eeY;
    private int type;

    public d(int i, List<String> list, String str) {
        this.type = i;
        this.eeX = list;
        this.eeY = str;
    }

    private void T(List<String> list) {
        MediaMetadataRetriever mediaMetadataRetriever;
        Throwable e;
        Throwable th;
        ok okVar = (ok) this.dZf.dID.dIL;
        okVar.hcE = 3;
        long currentTimeMillis = System.currentTimeMillis();
        for (String str : list) {
            x.i("MicroMsg.NetSceneCheckSysShare", "video file %s", new Object[]{str});
            bnd bnd = new bnd();
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    x.i("MicroMsg.NetSceneCheckSysShare", "video duration %d", new Object[]{Integer.valueOf(bi.getInt(mediaMetadataRetriever.extractMetadata(9), -1))});
                    bnd.slf = r2;
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.NetSceneCheckSysShare", e2, "%s", new Object[]{e2.getMessage()});
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.NetSceneCheckSysShare", e2, "Analysis duration of mediaItem %s error %s", new Object[]{str, e2.getMessage()});
                        if (mediaMetadataRetriever != null) {
                            try {
                                mediaMetadataRetriever.release();
                            } catch (Throwable e22) {
                                x.printErrStackTrace("MicroMsg.NetSceneCheckSysShare", e22, "%s", new Object[]{e22.getMessage()});
                            }
                        }
                        bnd.rwt = c.m(new File(str));
                        okVar.rsJ.add(bnd);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Exception e4) {
                e22 = e4;
                mediaMetadataRetriever = null;
                x.printErrStackTrace("MicroMsg.NetSceneCheckSysShare", e22, "Analysis duration of mediaItem %s error %s", new Object[]{str, e22.getMessage()});
                if (mediaMetadataRetriever != null) {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Throwable e222) {
                        x.printErrStackTrace("MicroMsg.NetSceneCheckSysShare", e222, "%s", new Object[]{e222.getMessage()});
                    }
                }
                bnd.rwt = c.m(new File(str));
                okVar.rsJ.add(bnd);
            } catch (Throwable th3) {
                th = th3;
                mediaMetadataRetriever = null;
            }
            bnd.rwt = c.m(new File(str));
            okVar.rsJ.add(bnd);
        }
        x.i("MicroMsg.NetSceneCheckSysShare", "cost %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return;
        if (mediaMetadataRetriever != null) {
            try {
                mediaMetadataRetriever.release();
            } catch (Throwable e5) {
                x.printErrStackTrace("MicroMsg.NetSceneCheckSysShare", e5, "%s", new Object[]{e5.getMessage()});
            }
        }
        throw th;
        throw th;
    }

    private void U(List<String> list) {
        ok okVar = (ok) this.dZf.dID.dIL;
        okVar.hcE = 5;
        long currentTimeMillis = System.currentTimeMillis();
        for (String str : list) {
            x.i("MicroMsg.NetSceneCheckSysShare", "share text %s", new Object[]{str});
            int indexOf = str.indexOf("|");
            bnc bnc = new bnc();
            if (indexOf < 0 || indexOf + 1 >= str.length()) {
                bnc.bHD = "";
                bnc.URL = str;
            } else {
                bnc.bHD = str.substring(0, indexOf);
                bnc.URL = str.substring(indexOf + 1);
            }
            bnc.rwt = c.u(bnc.URL.getBytes());
            okVar.rsM.add(bnc);
        }
        x.i("MicroMsg.NetSceneCheckSysShare", "cost %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    private void V(List<String> list) {
        ok okVar = (ok) this.dZf.dID.dIL;
        okVar.hcE = 4;
        long currentTimeMillis = System.currentTimeMillis();
        for (String str : list) {
            bmz bmz = new bmz();
            File file = new File(str);
            bmz.ruE = (int) file.length();
            bmz.rwt = c.m(file);
            okVar.rsL.add(bmz);
        }
        x.i("MicroMsg.NetSceneCheckSysShare", "cost %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public final int getType() {
        return 837;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        a aVar = new a();
        ok okVar = new ok();
        if (!bi.oW(this.eeY)) {
            okVar.rsH = this.eeY;
        }
        aVar.dIG = okVar;
        aVar.dIH = new ol();
        aVar.uri = "/cgi-bin/micromsg-bin/checksystemshare";
        aVar.dIF = 837;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.dZf = aVar.KT();
        switch (this.type) {
            case 1:
                List<String> list = this.eeX;
                ok okVar2 = (ok) this.dZf.dID.dIL;
                okVar2.hcE = 1;
                Options options = new Options();
                options.inJustDecodeBounds = true;
                long currentTimeMillis = System.currentTimeMillis();
                for (String str : list) {
                    x.i("MicroMsg.NetSceneCheckSysShare", "img file %s", new Object[]{str});
                    byte[] e = com.tencent.mm.a.e.e(str, 0, -1);
                    if (e != null && e.length > 0) {
                        bnb bnb = new bnb();
                        bnb.rwt = c.u(e);
                        MMBitmapFactory.decodeByteArray(e, 0, e.length, options);
                        x.i("MicroMsg.NetSceneCheckSysShare", "decode img, width %d, height: %d", new Object[]{Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight)});
                        bnb.Width = options.outWidth;
                        bnb.Height = options.outHeight;
                        com.tencent.mm.plugin.af.a.d Kf = new com.tencent.mm.plugin.af.a.a().Kf(str);
                        if (Kf != null) {
                            x.i("MicroMsg.NetSceneCheckSysShare", "scan qrcode, type %s, result %s, ", new Object[]{Kf.mji, Kf.result});
                            if (!bi.oW(Kf.mji)) {
                                if (Kf.mji.equals("QR_CODE") || Kf.mji.equals("WX_CODE")) {
                                    bnb.siz = Kf.result;
                                } else {
                                    int indexOf = Kf.result.indexOf(",");
                                    if (indexOf < 0 || indexOf + 1 >= Kf.result.length()) {
                                        bnb.siz = Kf.result;
                                    } else {
                                        bnb.siz = Kf.result.substring(indexOf + 1);
                                    }
                                }
                                bnb.sle = Kf.mji;
                            }
                        }
                        okVar2.rsI.add(bnb);
                    }
                }
                x.i("MicroMsg.NetSceneCheckSysShare", "cost %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                break;
            case 3:
                T(this.eeX);
                break;
            case 4:
                V(this.eeX);
                break;
            case 5:
                U(this.eeX);
                break;
        }
        int i = 1;
        if (g.Eg().Dx()) {
            i = bi.getInt(com.tencent.mm.k.g.AT().getValue("ShareExtCheckSwitch"), 1);
        }
        if (i == 1) {
            return a(eVar, this.dZf, this);
        }
        this.diJ.a(0, 0, "need not check", this);
        return 0;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneCheckSysShare", "errType %d, errCode %d, errMsg", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.diJ.a(i2, i3, str, this);
    }
}
