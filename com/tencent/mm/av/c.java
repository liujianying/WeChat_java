package com.tencent.mm.av;

import com.tencent.map.swlocation.api.INetworkApi;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsMediaPlayer$TbsMediaPlayerListener;

public final class c implements INetworkApi, e {
    private float bSx;
    private float bUg;
    private int bUh;
    private int bUi;
    private String bUj;
    private String bUk;
    private a eem;
    private byte[] een;
    private al eeo;
    private int eep;
    private Object lock = new Object();
    private int scene;

    public c(float f, float f2, int i, int i2, String str, String str2, int i3, int i4) {
        g.Ek();
        this.eeo = new al(g.Em().lnJ.getLooper(), new 1(this), false);
        this.bUg = f;
        this.bSx = f2;
        this.bUh = i;
        this.bUi = i2;
        this.bUj = str;
        this.bUk = str2;
        this.eep = i3;
        this.scene = i4;
        g.Eh().dpP.a(TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA, this);
    }

    public final void finish() {
        this.eeo.SO();
        if (this.eem != null) {
            g.Eh().dpP.c(this.eem);
        }
        this.eem = null;
        this.een = null;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
        g.Eh().dpP.b(TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA, this);
    }

    public final byte[] httpRequest(String str, byte[] bArr) {
        x.w("MicroMsg.SenseWhereHttpUtil", "why use this method? sense where sdk has something warn.");
        return new byte[0];
    }

    public final byte[] httpRequest(byte[] bArr) {
        try {
            String str = new String(bArr, "UTF-8");
            x.d("MicroMsg.SenseWhereHttpUtil", "sense where http request content : " + str);
            this.een = null;
            this.eem = new a(this.bUg, this.bSx, this.bUh, this.bUi, this.bUj, this.bUk, this.eep, this.scene, str);
            g.Eh().dpP.a(this.eem, 0);
            this.eeo.J(60000, 60000);
            synchronized (this.lock) {
                this.lock.wait();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SenseWhereHttpUtil", e, "", new Object[0]);
            x.e("MicroMsg.SenseWhereHttpUtil", "sense where http request error: " + e.toString());
        }
        x.i("MicroMsg.SenseWhereHttpUtil", "upload sense where info finish. it is response is null? %b", new Object[]{Boolean.valueOf(bi.bC(this.een))});
        return this.een;
    }

    public final void a(int i, int i2, String str, l lVar) {
        this.eeo.SO();
        if (i == 0 && i2 == 0) {
            if (lVar instanceof a) {
                String aG = bi.aG(((a) lVar).edM, "");
                x.d("MicroMsg.SenseWhereHttpUtil", "senseWhereResp: " + aG);
                try {
                    this.een = aG.getBytes("UTF-8");
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SenseWhereHttpUtil", e, "", new Object[0]);
                    x.e("MicroMsg.SenseWhereHttpUtil", "string to byte[] error. " + e.toString());
                }
            } else {
                this.een = null;
            }
            synchronized (this.lock) {
                this.lock.notifyAll();
            }
        } else {
            x.w("MicroMsg.SenseWhereHttpUtil", "upload sense where info error. errType[%d] errCode[%d] errMsg[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            this.een = null;
            synchronized (this.lock) {
                this.lock.notifyAll();
            }
            b.Qv().Qx();
            h.mEJ.a(345, 4, 1, false);
        }
        this.eem = null;
    }
}
