package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.s.j;

class JsApiAddNativeDownloadTask$3 implements Runnable {
    final /* synthetic */ JsApiAddNativeDownloadTask fFz;
    final /* synthetic */ Context val$context;

    JsApiAddNativeDownloadTask$3(JsApiAddNativeDownloadTask jsApiAddNativeDownloadTask, Context context) {
        this.fFz = jsApiAddNativeDownloadTask;
        this.val$context = context;
    }

    public final void run() {
        Toast.makeText(this.val$context, this.val$context.getString(j.game_download_not_enough_space), 0).show();
    }
}
