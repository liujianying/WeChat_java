package com.tencent.mm.plugin.sns.ui;

import android.view.KeyEvent;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.x;

class SnsUploadSayFooter$4 implements a {
    final /* synthetic */ SnsUploadSayFooter ogJ;

    SnsUploadSayFooter$4(SnsUploadSayFooter snsUploadSayFooter) {
        this.ogJ = snsUploadSayFooter;
    }

    public final void bbF() {
    }

    public final void gp(boolean z) {
    }

    public final void apK() {
        SnsUploadSayFooter.c(this.ogJ).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
        SnsUploadSayFooter.c(this.ogJ).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
    }

    public final void append(String str) {
        try {
            SnsUploadSayFooter.c(this.ogJ).abr(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsUploadSayFooter", e, "", new Object[0]);
        }
    }
}
