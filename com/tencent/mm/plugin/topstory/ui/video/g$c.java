package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.protocal.c.btj;
import java.io.ByteArrayOutputStream;

class g$c implements a {
    final /* synthetic */ g oAe;

    private g$c(g gVar) {
        this.oAe = gVar;
    }

    /* synthetic */ g$c(g gVar, byte b) {
        this(gVar);
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        if (keep_progressinfo != null && keep_progressinfo.field_toltalLength > 0 && this.oAe.oAd.containsKey(str)) {
            btj btj = (btj) this.oAe.oAd.get(str);
            btj.srf = (long) keep_progressinfo.field_finishedLength;
            btj.srg = (long) ((keep_progressinfo.field_finishedLength * 100) / keep_progressinfo.field_toltalLength);
            btj.srb = (long) keep_progressinfo.field_toltalLength;
            this.oAe.oAd.put(str, btj);
        }
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return new byte[0];
    }
}
