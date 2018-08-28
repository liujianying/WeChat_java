package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.UploadMediaFileHelp.a;
import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.plugin.webview.modeltools.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class UploadMediaFileHelp$5 implements b {
    final /* synthetic */ String jHJ;
    final /* synthetic */ a jHK;

    UploadMediaFileHelp$5(String str, a aVar) {
        this.jHJ = str;
        this.jHK = aVar;
    }

    public final void a(boolean z, String str, String str2, String str3) {
        x.i("MicroMsg.UploadMediaFileHelp", " on cdn finish,  is success : %s, mediaid : %s, local id is : %s, mediaUrl : %s", new Object[]{Boolean.valueOf(z), str2, str, str3});
        if (!bi.oW(str) && str.equals(this.jHJ)) {
            e.bUW().a(this);
            if (UploadMediaFileHelp.aSA() != null) {
                UploadMediaFileHelp.aSA().dismiss();
                UploadMediaFileHelp.aSB();
            }
            this.jHK.b(z, str2, str3);
        }
    }
}
