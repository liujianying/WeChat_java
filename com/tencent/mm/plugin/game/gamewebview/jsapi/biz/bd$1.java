package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.UploadMediaFileHelp.b;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

class bd$1 implements b {
    final /* synthetic */ int doP;
    final /* synthetic */ d jGF;
    final /* synthetic */ bd jHB;

    bd$1(bd bdVar, d dVar, int i) {
        this.jHB = bdVar;
        this.jGF = dVar;
        this.doP = i;
    }

    public final void a(boolean z, HashMap<String, Object> hashMap) {
        x.i("MicroMsg.GameJsApiUploadMediaFile", "sucess = %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.jGF.E(this.doP, bd.f("uploadMediaFile:ok", hashMap));
        } else {
            this.jGF.E(this.doP, a.f("uploadMediaFile:fail", null));
        }
        UploadMediaFileHelp uploadMediaFileHelp = this.jHB.jHA;
        uploadMediaFileHelp.fcq = null;
        uploadMediaFileHelp.jGU = null;
        uploadMediaFileHelp.mAppId = null;
        uploadMediaFileHelp.jHD = null;
        uploadMediaFileHelp.jHF = null;
    }
}
