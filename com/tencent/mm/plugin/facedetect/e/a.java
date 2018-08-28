package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.a.e;
import com.tencent.mm.e.b.c$a;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.mmsight.api.b;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public class a {
    private static volatile a iSe = null;
    private static final String iSt = (o.aJX() + File.separator + "fdv_");
    public static final String iSu = (o.aJX() + File.separator + "video_temp_test.mp4");
    private static final String iSv = (o.aJX() + File.separator + "fdv_t_");
    private d fam;
    public com.tencent.mm.remoteservice.d iMQ;
    public ah iSf;
    private final int iSg;
    private final int iSh;
    private final int iSi;
    private int iSj;
    private int iSk;
    private boolean iSl;
    private int iSm;
    public boolean iSn;
    private b iSo;
    public int iSp;
    public int iSq;
    private String iSr;
    public b iSs;
    private com.tencent.mm.plugin.mmsight.model.a.d.a iSw;
    private com.tencent.mm.plugin.facedetect.model.d.b iSx;
    private String mFilePath;
    private final Object mLock;

    static /* synthetic */ void d(a aVar) {
        e.deleteFile(aVar.mFilePath);
        e.deleteFile(aVar.iSr);
    }

    private a() {
        this.mLock = new Object();
        this.iSf = null;
        this.iSg = 960;
        this.iSh = 540;
        this.iSi = 15;
        this.iSj = a.iSN;
        this.iSk = 0;
        this.iSl = false;
        this.iSm = 0;
        this.iSn = false;
        this.iSo = null;
        this.iSp = -1;
        this.iSq = -1;
        this.mFilePath = "";
        this.iSr = "";
        this.iMQ = new com.tencent.mm.remoteservice.d(ad.getContext());
        this.iSs = b.leD.ZP();
        this.iSw = new 5(this);
        this.iSx = new 6(this);
        this.iSf = new ah("face_video_handler");
    }

    public static a aKA() {
        if (iSe != null) {
            return iSe;
        }
        a aVar;
        synchronized (a.class) {
            if (iSe == null) {
                iSe = new a();
            }
            aVar = iSe;
        }
        return aVar;
    }

    public final boolean isStarted() {
        boolean z;
        synchronized (this.mLock) {
            z = this.iSj == a.iSP;
        }
        return z;
    }

    public final c$a aKB() {
        if (this.fam != null) {
            return this.fam.bet();
        }
        x.w("MicroMsg.FaceVideoRecorder", "hy: no media recorder");
        return null;
    }

    public final void aKC() {
        this.iSf.H(new 3(this));
    }

    public final void a(b bVar) {
        this.iSf.H(new 4(this, bVar));
    }

    public final int aKD() {
        int i;
        synchronized (this.mLock) {
            i = this.iSj;
        }
        return i;
    }
}
