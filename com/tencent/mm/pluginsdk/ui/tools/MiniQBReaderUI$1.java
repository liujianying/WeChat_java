package com.tencent.mm.pluginsdk.ui.tools;

import android.webkit.ValueCallback;
import com.tencent.mm.sdk.platformtools.x;

class MiniQBReaderUI$1 implements ValueCallback<String> {
    final /* synthetic */ MiniQBReaderUI qTe;

    MiniQBReaderUI$1(MiniQBReaderUI miniQBReaderUI) {
        this.qTe = miniQBReaderUI;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        x.i("MicroMsg.MiniQBReaderUI", "startMiniQBToLoadUrl, onReceiveValue: %s", new Object[]{(String) obj});
        if ("fileReaderClosed".equals((String) obj)) {
            this.qTe.finish();
        }
    }
}
