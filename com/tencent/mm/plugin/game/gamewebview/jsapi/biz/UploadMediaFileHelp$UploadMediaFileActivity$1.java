package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.UploadMediaFileHelp.UploadMediaFileActivity;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.UploadMediaFileHelp.a;
import com.tencent.mm.sdk.platformtools.x;

class UploadMediaFileHelp$UploadMediaFileActivity$1 implements a {
    final /* synthetic */ GameProcessActivityTask.a jGc;
    final /* synthetic */ UploadMediaFileActivity jHS;

    UploadMediaFileHelp$UploadMediaFileActivity$1(UploadMediaFileActivity uploadMediaFileActivity, GameProcessActivityTask.a aVar) {
        this.jHS = uploadMediaFileActivity;
        this.jGc = aVar;
    }

    public final void b(boolean z, String str, String str2) {
        x.i("MicroMsg.UploadMediaFileActivity", "success = %b, mediaId = %s, mediaUrl = %s", new Object[]{Boolean.valueOf(z), str, str2});
        if (z) {
            UploadMediaFileActivity.a(this.jHS, this.jGc, str, str2);
        } else {
            UploadMediaFileActivity.a(this.jHS, this.jGc);
        }
    }
}
