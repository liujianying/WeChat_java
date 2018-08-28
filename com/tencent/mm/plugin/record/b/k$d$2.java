package com.tencent.mm.plugin.record.b;

import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.plugin.record.b.k.d;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

class k$d$2 implements a {
    final /* synthetic */ String dUN;
    final /* synthetic */ vx jam;
    final /* synthetic */ d mso;

    k$d$2(d dVar, vx vxVar, String str) {
        this.mso = dVar;
        this.jam = vxVar;
        this.dUN = str;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        int i2;
        if (i == 0 && keep_sceneresult != null && keep_sceneresult.field_retCode == 0) {
            x.i("MicroMsg.RecordMsgSendService", "[record] downloadTpThumbUrl done id:%s, mediaId:%s, thumbPath:%s", new Object[]{this.jam.jdM, str, this.dUN});
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (!(i == 0 && (keep_sceneresult == null || keep_sceneresult.field_retCode == 0))) {
            String str2 = "MicroMsg.RecordMsgSendService";
            String str3 = "[record] downloadTpThumbUrl error id:%s, mediaId:%s, thumbPath:%s err:(%d,%d)";
            Object[] objArr = new Object[5];
            objArr[0] = this.jam.jdM;
            objArr[1] = str;
            objArr[2] = this.dUN;
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Integer.valueOf(keep_sceneresult == null ? 0 : keep_sceneresult.field_retCode);
            x.e(str2, str3, objArr);
            i2 = 1;
        }
        if (i2 != 0) {
            f Kr = n.getRecordMsgCDNStorage().Kr(str);
            Kr.field_status = 0;
            n.getRecordMsgCDNStorage().a(Kr);
            n.bqx().run();
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return new byte[0];
    }
}
