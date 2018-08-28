package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import com.tencent.mm.plugin.webview.ui.tools.OpenFileChooserUI.6;
import com.tencent.mm.sdk.platformtools.x;

class OpenFileChooserUI$6$4 implements Runnable {
    final /* synthetic */ String fQh;
    final /* synthetic */ 6 pWi;
    final /* synthetic */ String pWl;

    OpenFileChooserUI$6$4(6 6, String str, String str2) {
        this.pWi = 6;
        this.fQh = str;
        this.pWl = str2;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.putExtra("key_pick_local_media_callback_type", 1);
        intent.putExtra("key_pick_local_media_local_id", this.fQh);
        intent.putExtra("key_pick_local_media_thumb_local_id", this.pWl);
        x.i("MicroMsg.OpenFileChooserUI", "thumbLocalId:%s", new Object[]{this.pWl});
        this.pWi.pWh.setResult(-1, intent);
        this.pWi.pWh.finish();
    }
}
