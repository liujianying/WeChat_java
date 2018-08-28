package com.tencent.mm.plugin.collect.reward.b;

import com.tencent.mm.loader.stub.b;
import com.tencent.mm.model.q;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;

public final class a implements com.tencent.mm.modelcdntran.i.a {
    public static final String hVf = (b.duN + "wallet/img/");
    private static a hVg;
    public Map<String, a> diQ;
    private String filename;

    public static a aBR() {
        if (hVg == null) {
            hVg = new a();
        }
        return hVg;
    }

    public final boolean aBS() {
        return new File(hVf + aBT()).exists();
    }

    public final String aBT() {
        if (bi.oW(this.filename)) {
            this.filename = ac.ce(q.GF() + "_reward_img");
        }
        return this.filename;
    }

    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
        x.i("MicroMsg.QrRewardCdnDownloadHelper", "cdn callback, id: %s, ret: %s, sceneResult: %s", new Object[]{str, Integer.valueOf(i), keep_sceneresult});
        ah.A(new 1(this, str, keep_sceneresult, i));
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] i(String str, byte[] bArr) {
        return new byte[0];
    }
}
