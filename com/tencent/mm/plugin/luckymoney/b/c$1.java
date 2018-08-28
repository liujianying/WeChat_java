package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements k$a {
    final /* synthetic */ c kPD;

    c$1(c cVar) {
        this.kPD = cVar;
    }

    public final void a(keep_SceneResult keep_sceneresult, String str, boolean z) {
        if (z) {
            x.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "the download image data is success! filePath:" + str);
        } else {
            x.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "download image fail!  filePath:" + str);
        }
    }
}
