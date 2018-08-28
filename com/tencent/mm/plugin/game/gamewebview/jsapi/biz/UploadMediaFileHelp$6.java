package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.UploadMediaFileHelp.a;
import com.tencent.mm.plugin.webview.model.ad;
import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.plugin.webview.modeltools.e;

class UploadMediaFileHelp$6 implements OnCancelListener {
    final /* synthetic */ String jHJ;
    final /* synthetic */ a jHK;
    final /* synthetic */ b jHL;

    UploadMediaFileHelp$6(b bVar, String str, a aVar) {
        this.jHL = bVar;
        this.jHJ = str;
        this.jHK = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        e.bUW().a(this.jHL);
        e.bUW();
        ad.rq(this.jHJ);
        this.jHK.b(false, "", "");
    }
}
