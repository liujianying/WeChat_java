package com.tencent.mm.modelvideo;

import com.tencent.mm.modelcdntran.i$a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import java.io.ByteArrayOutputStream;

class u$2 implements i$a {
    final /* synthetic */ long dUM;
    final /* synthetic */ String dUN;
    final /* synthetic */ long dUQ;
    final /* synthetic */ String dUR;
    final /* synthetic */ String dUT;
    final /* synthetic */ int dUU;
    final /* synthetic */ r eoo;
    final /* synthetic */ u eop;

    u$2(u uVar, long j, r rVar, String str, String str2, int i, String str3, long j2) {
        this.eop = uVar;
        this.dUM = j;
        this.eoo = rVar;
        this.dUN = str;
        this.dUT = str2;
        this.dUU = i;
        this.dUR = str3;
        this.dUQ = j2;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        return u.a(i, keep_sceneresult, this.dUM, this.eoo, this.dUN, this.dUT, this.dUU, this.dUR, this.dUQ);
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return null;
    }
}
