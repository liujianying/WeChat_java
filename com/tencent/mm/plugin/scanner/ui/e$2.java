package com.tencent.mm.plugin.scanner.ui;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mm.sdk.platformtools.x;

class e$2 implements OnGlobalLayoutListener {
    final /* synthetic */ e mIo;

    e$2(e eVar) {
        this.mIo = eVar;
    }

    public final void onGlobalLayout() {
        x.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() = " + e.b(this.mIo).getHeight() + ", summaryTv.getLineHeight() = " + e.b(this.mIo).getLineHeight());
        if (e.b(this.mIo).getText() != null && e.b(this.mIo).getHeight() > 0 && e.b(this.mIo).getLineHeight() > 0 && e.d(this.mIo) == null) {
            if (!(e.b(this.mIo).getHeight() / e.b(this.mIo).getLineHeight() <= 5 || this.mIo.mIk || this.mIo.mIj)) {
                e.a(this.mIo).setVisibility(0);
                e.b(this.mIo).setMaxLines(5);
                this.mIo.mIk = true;
                if (e.c(this.mIo) != null && e.c(this.mIo).KI(this.mIo.mKey) == null) {
                    e.c(this.mIo).a(this.mIo.mKey, Boolean.valueOf(false));
                    e.c(this.mIo).bsE();
                }
            }
            x.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() / summaryTv.getLineHeight() = " + (e.b(this.mIo).getHeight() / e.b(this.mIo).getLineHeight()));
        }
        e.b(this.mIo).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
}
