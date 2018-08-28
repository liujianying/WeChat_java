package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.UploadMediaFileHelp.UploadMediaFileActivity;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;

class UploadMediaFileHelp$3 implements Runnable {
    final /* synthetic */ UploadMediaFileHelp jHG;
    final /* synthetic */ UploadMediaFileActivity jHH;

    UploadMediaFileHelp$3(UploadMediaFileHelp uploadMediaFileHelp, UploadMediaFileActivity uploadMediaFileActivity) {
        this.jHG = uploadMediaFileHelp;
        this.jHH = uploadMediaFileActivity;
    }

    public final void run() {
        UploadMediaFileHelp.b(this.jHG);
        if (this.jHH.jHR) {
            HashMap hashMap = new HashMap();
            hashMap.put("serverId", bi.oV(this.jHH.mediaId));
            hashMap.put("mediaUrl", bi.oV(this.jHH.jHQ));
            this.jHG.jHF.a(true, hashMap);
            return;
        }
        this.jHG.jHF.a(false, null);
    }
}
