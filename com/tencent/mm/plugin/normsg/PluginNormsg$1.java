package com.tencent.mm.plugin.normsg;

import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.File;

class PluginNormsg$1 implements a {
    final /* synthetic */ File lFG;
    final /* synthetic */ File lFH;
    final /* synthetic */ PluginNormsg lFI;

    PluginNormsg$1(PluginNormsg pluginNormsg, File file, File file2) {
        this.lFI = pluginNormsg;
        this.lFG = file;
        this.lFH = file2;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        if (i == -21006) {
            x.w("MicroMsg.PluginNormsg", "uccek: duplicate request to download meta, ignore this request.");
        } else if (i != 0) {
            x.e("MicroMsg.PluginNormsg", "uccek: start failed : %d", new Object[]{Integer.valueOf(i)});
            h.mEJ.e(876, 3, 1);
        } else if (keep_sceneresult != null) {
            if (keep_sceneresult.field_retCode != 0) {
                x.e("MicroMsg.PluginNormsg", "uccek: download failure, sceneResult.retCode:%d sceneResult[%s]", new Object[]{Integer.valueOf(keep_sceneresult.field_retCode), keep_sceneresult});
                if (keep_progressinfo != null && keep_progressinfo.field_finishedLength > 0) {
                    x.w("MicroMsg.PluginNormsg", "uccek: download interrupt, clear broken file.");
                    this.lFG.delete();
                }
                h.mEJ.e(876, 4, 1);
            } else {
                x.i("MicroMsg.PluginNormsg", "uccek: cdn trans suceess.");
                this.lFG.renameTo(this.lFH);
                h.mEJ.e(876, 2, 1);
            }
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return new byte[0];
    }
}
