package com.tencent.mm.ak;

import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.storage.bd;
import java.io.ByteArrayOutputStream;

class h$1 implements a {
    final /* synthetic */ bd dAs;
    final /* synthetic */ String dAt;
    final /* synthetic */ long dUM;
    final /* synthetic */ String dUN;
    final /* synthetic */ String dUO;
    final /* synthetic */ int dUP;
    final /* synthetic */ long dUQ;
    final /* synthetic */ String dUR;
    final /* synthetic */ h dUS;

    h$1(h hVar, bd bdVar, String str, long j, String str2, String str3, int i, long j2, String str4) {
        this.dUS = hVar;
        this.dAs = bdVar;
        this.dAt = str;
        this.dUM = j;
        this.dUN = str2;
        this.dUO = str3;
        this.dUP = i;
        this.dUQ = j2;
        this.dUR = str4;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        h.a(i, keep_sceneresult, this.dAs, this.dAt, this.dUM, this.dUN, this.dUO, this.dUP, this.dUQ, this.dUR);
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return new byte[0];
    }
}
