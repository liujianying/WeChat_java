package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.webview.model.ad;
import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.plugin.webview.modeltools.e;

class UploadMediaFileHelp$8 implements OnCancelListener {
    final /* synthetic */ String jHJ;
    final /* synthetic */ UploadMediaFileHelp$a jHK;
    final /* synthetic */ b jHL;

    UploadMediaFileHelp$8(b bVar, String str, UploadMediaFileHelp$a uploadMediaFileHelp$a) {
        this.jHL = bVar;
        this.jHJ = str;
        this.jHK = uploadMediaFileHelp$a;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        e.bUW().a(this.jHL);
        e.bUW();
        ad.rq(this.jHJ);
        this.jHK.b(false, "", "");
    }
}
