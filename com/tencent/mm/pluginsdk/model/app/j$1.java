package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.e;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.io.ByteArrayOutputStream;

class j$1 implements a {
    final /* synthetic */ long dUM;
    final /* synthetic */ long dUQ;
    final /* synthetic */ String dUR;
    final /* synthetic */ String dUT;
    final /* synthetic */ int dUU;
    final /* synthetic */ String dhh;
    final /* synthetic */ int qzS;
    final /* synthetic */ boolean qzT;
    final /* synthetic */ j qzU;

    j$1(j jVar, long j, String str, long j2, int i, String str2, String str3, int i2, boolean z) {
        this.qzU = jVar;
        this.dUM = j;
        this.dUT = str;
        this.dUQ = j2;
        this.dUU = i;
        this.dhh = str2;
        this.dUR = str3;
        this.qzS = i2;
        this.qzT = z;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        if (i != 0) {
            x.e("MicroMsg.AppMessageExtension", "getThumbByCdn start failed: msgid:%d startRet:%d thumbUrl:%s", new Object[]{Long.valueOf(this.dUM), Integer.valueOf(i), this.dUT});
            h.mEJ.h(10421, new Object[]{Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(this.dUQ), Long.valueOf(bi.VF()), Integer.valueOf(d.bL(ad.getContext())), Integer.valueOf(b.MediaType_THUMBIMAGE), Integer.valueOf(this.dUU), ""});
            return i;
        } else if (keep_sceneresult == null) {
            return 0;
        } else {
            h hVar;
            if (keep_sceneresult.field_retCode != 0) {
                x.e("MicroMsg.AppMessageExtension", "getThumbByCdn failed: msgid:%d sceneResult.field_retCode:%d thumbUrl:%s", new Object[]{Long.valueOf(this.dUM), Integer.valueOf(keep_sceneresult.field_retCode), this.dUT});
            } else {
                au.HU();
                bd I = c.FT().I(this.dhh, this.dUM);
                if (I.field_msgSvrId != this.dUM) {
                    x.e("MicroMsg.AppMessageExtension", "hy: appmsg %d has been deleted", new Object[]{Long.valueOf(this.dUM)});
                    return 0;
                }
                String a;
                long j;
                x.i("MicroMsg.AppMessageExtension", "hy: %d current msg type is %d", new Object[]{Long.valueOf(this.dUM), Integer.valueOf(I.getType())});
                byte[] e = e.e(this.dUR, 0, -1);
                if (this.qzS == 33 || this.qzS == 36) {
                    a = o.Pf().a(e, CompressFormat.JPEG);
                } else {
                    a = j.a(e, this.qzT, I.cmm());
                }
                if (!bi.oW(a)) {
                    I.eq(a);
                    au.HU();
                    c.FT().b(I.field_msgSvrId, I);
                }
                x.i("MicroMsg.AppMessageExtension", "getThumbByCdn finished msgid:%d talker:%s thumbUrl:%s path:%s", new Object[]{Long.valueOf(this.dUM), this.dhh, this.dUT, a});
                h.mEJ.a(198, 16, (long) this.dUU, false);
                h.mEJ.a(198, 17, 1, false);
                hVar = h.mEJ;
                if (s.fq(this.dhh)) {
                    j = 19;
                } else {
                    j = 18;
                }
                hVar.a(198, j, 1, false);
            }
            hVar = h.mEJ;
            Object[] objArr = new Object[16];
            objArr[0] = Integer.valueOf(keep_sceneresult == null ? -1 : keep_sceneresult.field_retCode);
            objArr[1] = Integer.valueOf(2);
            objArr[2] = Long.valueOf(this.dUQ);
            objArr[3] = Long.valueOf(bi.VF());
            objArr[4] = Integer.valueOf(d.bL(ad.getContext()));
            objArr[5] = Integer.valueOf(b.MediaType_THUMBIMAGE);
            objArr[6] = Integer.valueOf(this.dUU);
            objArr[7] = keep_sceneresult == null ? "" : keep_sceneresult.field_transInfo;
            objArr[8] = "";
            objArr[9] = "";
            objArr[10] = "";
            objArr[11] = "";
            objArr[12] = "";
            objArr[13] = "";
            objArr[14] = "";
            objArr[15] = keep_sceneresult == null ? "" : keep_sceneresult.report_Part2;
            hVar.h(10421, objArr);
            if (!(keep_sceneresult == null || keep_sceneresult.field_retCode == 0)) {
                hVar = h.mEJ;
                objArr = new Object[16];
                objArr[0] = Integer.valueOf(keep_sceneresult == null ? -1 : keep_sceneresult.field_retCode);
                objArr[1] = Integer.valueOf(2);
                objArr[2] = Long.valueOf(this.dUQ);
                objArr[3] = Long.valueOf(bi.VF());
                objArr[4] = Integer.valueOf(d.bL(ad.getContext()));
                objArr[5] = Integer.valueOf(b.MediaType_THUMBIMAGE);
                objArr[6] = Integer.valueOf(this.dUU);
                objArr[7] = keep_sceneresult == null ? "" : keep_sceneresult.field_transInfo;
                objArr[8] = "";
                objArr[9] = "";
                objArr[10] = "";
                objArr[11] = "";
                objArr[12] = "";
                objArr[13] = "";
                objArr[14] = "";
                objArr[15] = keep_sceneresult == null ? "" : keep_sceneresult.report_Part2;
                hVar.h(13937, objArr);
            }
            o.Pf().doNotify();
            return 0;
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return null;
    }
}
