package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.s.j;

class JsApiAddNativeDownloadTask$1 implements Runnable {
    final /* synthetic */ JsApiAddNativeDownloadTask fFz;
    final /* synthetic */ Context val$context;

    JsApiAddNativeDownloadTask$1(JsApiAddNativeDownloadTask jsApiAddNativeDownloadTask, Context context) {
        this.fFz = jsApiAddNativeDownloadTask;
        this.val$context = context;
    }

    public final void run() {
        Toast.makeText(this.val$context, this.val$context.getString(j.game_download_network_unavailable), 0).show();
    }
}
