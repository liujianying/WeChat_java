package com.tencent.mm.ui.chatting.b;

import android.os.Looper;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;

class y$4 implements a {
    final /* synthetic */ bd dAs;
    final /* synthetic */ String dat;
    final /* synthetic */ HashSet tOY;
    final /* synthetic */ y tQV;

    y$4(y yVar, bd bdVar, String str, HashSet hashSet) {
        this.tQV = yVar;
        this.dAs = bdVar;
        this.dat = str;
        this.tOY = hashSet;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        int i2;
        if (i == 0 && keep_sceneresult != null && keep_sceneresult.field_retCode == 0) {
            x.i("MicroMsg.ChattingUI.MessBoxComponent", "oreh downloadTpUrl done msgId:%d, mediaId:%s, path:%s", new Object[]{Long.valueOf(this.dAs.field_msgId), str, this.dat});
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (!(i == 0 && (keep_sceneresult == null || keep_sceneresult.field_retCode == 0))) {
            String str2 = "MicroMsg.ChattingUI.MessBoxComponent";
            String str3 = "oreh downloadTpUrl error msgId:%d, mediaId:%s, path:%s, err:(%d,%d)";
            Object[] objArr = new Object[5];
            objArr[0] = Long.valueOf(this.dAs.field_msgId);
            objArr[1] = str;
            objArr[2] = this.dat;
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Integer.valueOf(keep_sceneresult == null ? 0 : keep_sceneresult.field_retCode);
            x.e(str2, str3, objArr);
            i2 = 1;
        }
        if (i2 != 0) {
            this.tOY.remove(str);
            if (this.tOY.isEmpty()) {
                new ag(Looper.getMainLooper()).post(new 1(this));
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
