package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.facedetect.b.c;
import com.tencent.mm.plugin.facedetect.b.d;
import com.tencent.mm.plugin.facedetect.b.u;
import com.tencent.mm.plugin.facedetect.b.v;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.e;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public abstract class a {
    private int iLW;
    protected d iLX = null;
    protected c iLY = null;
    protected WeakReference<e> iMN;
    protected boolean iMO = false;
    int iMP = -1;
    private com.tencent.mm.remoteservice.d iMQ = null;
    protected com.tencent.mm.plugin.facedetect.b.a iMR = null;
    protected boolean iMS = false;
    private Context mContext;

    protected abstract l aJy();

    public abstract Bundle aJz();

    public abstract void ac(int i, String str);

    public abstract boolean b(int i, String str, Bundle bundle);

    public abstract void c(int i, int i2, String str, Bundle bundle);

    public abstract void i(int i, int i2, String str);

    public abstract void i(int i, int i2, String str, l lVar);

    public abstract void onRelease();

    protected abstract void onStart();

    a(Context context, e eVar, int i) {
        this.mContext = context;
        this.iLW = i;
        this.iMN = new WeakReference(eVar);
        this.iMR = new com.tencent.mm.plugin.facedetect.b.a(i);
        this.iMP = FaceDetectReporter.pw(i);
    }

    public final void a(c cVar) {
        if (this.iMR != null) {
            this.iLY = cVar;
            this.iMR.iLY = this.iLY;
        }
    }

    public final void a(d dVar) {
        if (this.iMR != null) {
            this.iLX = dVar;
            this.iMR.iLX = dVar;
        }
    }

    public final void aJu() {
        if (this.iMR != null) {
            com.tencent.mm.plugin.facedetect.b.a aVar = this.iMR;
            g.Eg();
            aVar.iLZ = com.tencent.mm.kernel.a.Dw();
            x.i("MicroMsg.FaceUploadProcessor", "alvinluo isLogin: %b", new Object[]{Boolean.valueOf(aVar.iLZ)});
            if (aVar.iLZ) {
                g.DF().a(732, aVar);
            } else {
                g.DF().a(733, aVar);
            }
            aVar = this.iMR;
            aVar.iMb = 0;
            aVar.iMc = 0;
            if (aVar.iMd != null) {
                g.DF().c(aVar.iMd);
            }
            if (e.aJE()) {
                e.df(aVar.iMb);
            }
            if (aVar.iLZ) {
                aVar.iMd = new u(aVar.iLW);
            } else {
                aVar.iMd = new v(aVar.iLW);
            }
            g.DF().a(aVar.iMd, 0);
        }
    }

    public final void aJv() {
        if (!(this.iMN == null || this.iMN.get() == null)) {
            ((e) this.iMN.get()).aJv();
        }
        onStart();
    }

    public final void AS(String str) {
        if (this.iMR != null) {
            com.tencent.mm.plugin.facedetect.b.a aVar = this.iMR;
            if (!aVar.iMa) {
                aVar.iMc = 1;
                if (bi.oW(str)) {
                    x.e("MicroMsg.FaceUploadProcessor", "hy: err face file null");
                    aVar.h(4, 90011, "face file null");
                } else if (!FileOp.cn(str)) {
                    x.e("MicroMsg.FaceUploadProcessor", "hy: file not exist");
                    aVar.h(4, 90011, "get image failed");
                } else if (aVar.iMb == 0) {
                    x.e("MicroMsg.FaceUploadProcessor", "hy: err not init");
                    aVar.h(4, 90014, "uploadId not init");
                } else {
                    x.i("MicroMsg.FaceUploadProcessor", "hy: start upload file : %s", new Object[]{str});
                    if (!aVar.iMa) {
                        i iVar = new i();
                        iVar.dPV = aVar.iMh;
                        iVar.field_mediaId = o.AV(str);
                        iVar.field_fullpath = str;
                        iVar.field_thumbpath = "";
                        iVar.field_fileType = b.MediaType_FILE;
                        iVar.field_talker = "";
                        iVar.field_priority = b.dOk;
                        iVar.field_needStorage = false;
                        iVar.field_isStreamMedia = false;
                        iVar.field_appType = 0;
                        iVar.field_bzScene = 0;
                        iVar.field_largesvideo = 0;
                        if (!com.tencent.mm.modelcdntran.g.ND().c(iVar)) {
                            x.e("MicroMsg.FaceUploadProcessor", "hy: cdntra addSendTask failed. clientid:%s", new Object[]{iVar.field_mediaId});
                            aVar.h(4, 90019, "add to cdn failed");
                        }
                    }
                }
            }
        }
    }

    public final long aJw() {
        if (this.iMR != null) {
            return this.iMR.iMb;
        }
        return -1;
    }

    public final void aJx() {
        x.i("MicroMsg.FaceDetectBaseController", "alvinluo controller releaseFaceDetect");
        if (!(this.iMN == null || this.iMN.get() == null)) {
            ((e) this.iMN.get()).aJx();
        }
        this.iMN = null;
        String an = bi.an(ad.getContext(), Process.myPid());
        String packageName = ad.getPackageName();
        x.i("MicroMsg.FaceDetectBaseController", "process name: %s", new Object[]{an});
        if (an.equalsIgnoreCase(packageName)) {
            if (this.iMR != null) {
                com.tencent.mm.plugin.facedetect.b.a aVar = this.iMR;
                String str = "MicroMsg.FaceUploadProcessor";
                String str2 = "alvinluo uinit mCurrentNetScene == null: %b";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(aVar.iMd == null);
                x.v(str, str2, objArr);
                aVar.iMa = true;
                if (aVar.iMd != null) {
                    x.i("MicroMsg.FaceUploadProcessor", "alvinluo hy: current scene: %s is not finished yet. cancel.", new Object[]{aVar.iMd.getClass().getSimpleName()});
                    g.DF().c(aVar.iMd);
                }
                if (aVar.iLZ) {
                    g.DF().b(732, aVar);
                } else {
                    g.DF().b(733, aVar);
                }
                aVar.aJo();
            }
            this.iMR = null;
        }
        onRelease();
    }

    protected final void a(int i, int i2, String str, Bundle bundle) {
        boolean z = true;
        String str2 = "MicroMsg.FaceDetectBaseController";
        String str3 = "alvinluo finishWithResult mUIModel == null: %b";
        Object[] objArr = new Object[1];
        if (this.iMN != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str2, str3, objArr);
        if (this.iMN != null && this.iMN.get() != null) {
            ((e) this.iMN.get()).a(i, i2, str, bundle);
        }
    }

    public final void a(boolean z, boolean z2, com.tencent.mm.plugin.facedetect.ui.a.b bVar) {
        if (this.iMN != null && this.iMN.get() != null) {
            ((e) this.iMN.get()).a(z, z2, bVar);
        }
    }

    protected final void b(int i, int i2, String str, Bundle bundle) {
        if (this.iMN != null && this.iMN.get() != null) {
            ((e) this.iMN.get()).d(i, i2, str, bundle);
        }
    }

    public final void a(int i, String str, Bundle bundle) {
        if (i == 0 && !b(i, str, bundle)) {
            x.i("MicroMsg.FaceDetectBaseController", "alvinluo onUploadSuccess");
            this.iMO = true;
            if (this.iMS) {
                l aJy = aJy();
                if (aJy == null) {
                    x.e("MicroMsg.FaceDetectBaseController", "alvinluo verifyNetScene is null, stop verify");
                    return;
                }
                x.i("MicroMsg.FaceDetectBaseController", "alvinluo start verify, sceneType: %d", new Object[]{Integer.valueOf(aJy.getType())});
                if (!this.iMO) {
                    x.e("MicroMsg.FaceDetectBaseController", "isUploadDone: %b, upload not done, can't startVerify", new Object[]{Boolean.valueOf(this.iMO)});
                } else if (this.iMR != null) {
                    com.tencent.mm.plugin.facedetect.b.a aVar = this.iMR;
                    if (aJy == null) {
                        x.e("MicroMsg.FaceUploadProcessor", "alvinluo verifyNetScene is null");
                        return;
                    }
                    x.i("MicroMsg.FaceUploadProcessor", "uploader start verify, sceneType: %d", new Object[]{Integer.valueOf(aJy.getType())});
                    aVar.aJo();
                    aVar.iMe = aJy;
                    aVar.iMc = 2;
                    g.DF().a(aJy.getType(), aVar);
                    g.DF().a(aJy, 0);
                    aVar.iMf = System.currentTimeMillis();
                }
            }
        }
    }
}
