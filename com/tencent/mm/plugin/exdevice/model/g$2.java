package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.model.au;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.protocal.c.amw;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;

class g$2 implements a {
    final /* synthetic */ g iuX;

    g$2(g gVar) {
        this.iuX = gVar;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s] sentToCloud:[%s]", this.iuX.dVk, Integer.valueOf(i), keep_progressinfo, keep_sceneresult, Boolean.valueOf(this.iuX.iuD));
        if (keep_progressinfo != null) {
            try {
                int i2;
                int i3 = (int) ((((float) keep_progressinfo.field_finishedLength) / ((float) keep_progressinfo.field_toltalLength)) * 100.0f);
                x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "sent to cloud progress %d", Integer.valueOf(i3));
                if (i3 >= 100) {
                    i2 = 99;
                } else {
                    i2 = i3;
                }
                for (String a : this.iuX.iuF.keySet()) {
                    g.a(this.iuX, a, i2);
                }
            } catch (Exception e) {
                x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cdnCallback Exception %s", e);
            }
        }
        if (keep_sceneresult != null) {
            if (this.iuX.iuD) {
                amw amw = new amw();
                this.iuX.a(amw, this.iuX.cYP);
                this.iuX.iuD = false;
                if (g.cD(this.iuX.cYP).booleanValue() || g.cE(this.iuX.cYP).booleanValue()) {
                    amw.rPF.rmy = keep_sceneresult.field_aesKey;
                    amw.rPF.rPJ = this.iuX.iuH;
                    amw.rPF.rmC = keep_sceneresult.field_fileId;
                    amw.rPF.jPK = keep_sceneresult.field_fileUrl;
                    x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "image_msg.url:[%s]", amw.rPF.jPK);
                } else if (g.cC(this.iuX.cYP).booleanValue()) {
                    amw.rPG.rmy = keep_sceneresult.field_aesKey;
                    amw.rPG.rmC = keep_sceneresult.field_fileId;
                    amw.rPG.jPK = keep_sceneresult.field_fileUrl;
                    x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file_msg.url:[%s]", amw.rPG.jPK);
                } else if (g.cF(this.iuX.cYP).booleanValue()) {
                    amw.rPI.jPK = keep_sceneresult.field_fileUrl;
                    x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "video_msg.url:[%s]", amw.rPI.jPK);
                }
                this.iuX.iuG = amw;
                for (String a2 : this.iuX.iuF.keySet()) {
                    au.DF().a(new n(amw, (String) this.iuX.iuF.get(a2), a2, 1), 0);
                }
                this.iuX.iuF.clear();
            }
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "getCdnAuthInfo mediaId = " + str);
    }

    public final byte[] i(String str, byte[] bArr) {
        x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "decodePrepareResponse ");
        return bArr;
    }
}
