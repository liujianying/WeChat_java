package com.tencent.mm.plugin.subapp.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.afw;
import com.tencent.mm.protocal.c.afx;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class a extends l implements k {
    private RandomAccessFile aBA = null;
    private int dHI = 0;
    private e diJ;
    private String filePath = null;
    private int hjW = 0;
    String url;

    public a(String str) {
        this.url = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new afw();
        aVar.dIH = new afx();
        aVar.uri = "/cgi-bin/micromsg-bin/getpsmimg";
        aVar.dIF = 141;
        aVar.dII = 29;
        aVar.dIJ = 1000000029;
        b KT = aVar.KT();
        afw afw = (afw) KT.dID.dIL;
        afw.URL = this.url;
        afw.rjC = this.hjW;
        x.v("MicroMsg.NetSceneGetPSMImg", "doscene url:[" + this.url + "] + offset:" + this.hjW + " totallen:" + this.dHI);
        return a(eVar, KT, this);
    }

    protected final int a(q qVar) {
        String str = ((afw) ((b) qVar).dID.dIL).URL;
        Object obj = str == null ? null : str.indexOf("weixin://") != 0 ? null : 1;
        if (obj == null) {
            x.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : url invalid:" + this.url);
            return l.b.dJn;
        } else if (this.hjW < 0 || this.dHI < 0) {
            x.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.hjW + " total:" + this.dHI);
            return l.b.dJn;
        } else {
            if (this.hjW == 0) {
                if (this.dHI != 0) {
                    x.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.hjW + " total:" + this.dHI);
                    return l.b.dJn;
                }
            } else if (this.hjW >= this.dHI) {
                x.e("MicroMsg.NetSceneGetPSMImg", "security checked failed : offset:" + this.hjW + " total:" + this.dHI);
                return l.b.dJn;
            }
            return l.b.dJm;
        }
    }

    protected final int Cc() {
        return 10;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            afx afx = (afx) ((b) qVar).dIE.dIL;
            x.d("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd url:[" + this.url + "] + offset:" + this.hjW + " Resp[ totallen:" + afx.rjB + " bufSize:" + afx.rtW.siI + " ]");
            if (afx.rjB > 0) {
                this.dHI = afx.rjB;
            }
            if (d(this.url, afx.rtW.siK.lR, this.hjW)) {
                this.hjW = afx.rtW.siI + this.hjW;
                if (this.dHI <= this.hjW) {
                    x.d("MicroMsg.NetSceneGetPSMImg", "down url:[" + this.url + "] final size: " + this.dHI);
                    this.diJ.a(i2, i3, str, this);
                    return;
                } else if (a(this.dIX, this.diJ) < 0) {
                    this.diJ.a(i2, i3, str, this);
                    return;
                } else {
                    return;
                }
            }
            this.diJ.a(3, -1, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneGetPSMImg", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.diJ.a(i2, i3, str, this);
    }

    private boolean d(String str, byte[] bArr, int i) {
        if (i == 0) {
            if (this.aBA == null && this.filePath == null) {
                this.filePath = com.tencent.mm.pluginsdk.h.a.a.Ts(str);
                if (this.filePath == null) {
                    x.e("MicroMsg.NetSceneGetPSMImg", "writeFile getPath From url failed:[" + str + "]");
                    return false;
                }
                try {
                    this.aBA = new RandomAccessFile(this.filePath, "rw");
                } catch (Exception e) {
                    x.e("MicroMsg.NetSceneGetPSMImg", "writeFile open file error [" + this.filePath + "] e:" + e.getMessage());
                    return false;
                }
            }
            x.e("MicroMsg.NetSceneGetPSMImg", "writeFile param error");
            return false;
        }
        try {
            this.aBA.seek((long) i);
            this.aBA.write(bArr, 0, bArr.length);
            return true;
        } catch (IOException e2) {
            x.e("MicroMsg.NetSceneGetPSMImg", "writeFile write file error [" + this.filePath + "]  e:" + e2.getMessage());
            return false;
        }
    }

    public final int getType() {
        return 141;
    }
}
