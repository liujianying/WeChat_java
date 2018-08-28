package com.tencent.mm.plugin.emoji.ui;

import com.tencent.mm.ab.f;
import com.tencent.mm.ab.l;

class AppMsgEmojiDownloadUI$1 implements f {
    final /* synthetic */ AppMsgEmojiDownloadUI ikb;

    AppMsgEmojiDownloadUI$1(AppMsgEmojiDownloadUI appMsgEmojiDownloadUI) {
        this.ikb = appMsgEmojiDownloadUI;
    }

    public final void a(int i, int i2, l lVar) {
        float f;
        if (i2 == 0) {
            f = 0.0f;
        } else {
            f = (((float) i) * 100.0f) / ((float) i2);
        }
        AppMsgEmojiDownloadUI.a(this.ikb, (int) f);
    }
}
