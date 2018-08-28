package com.tencent.mm.plugin.scanner.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.x;

class e$1 implements OnTouchListener {
    final /* synthetic */ e mIo;

    e$1(e eVar) {
        this.mIo = eVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            x.d("MicroMsg.scanner.PlainTextPreference", "moreTv onTouch");
            e.a(this.mIo).setVisibility(4);
            e.b(this.mIo).setMaxLines(2000);
            this.mIo.mIj = true;
            if (e.c(this.mIo) != null) {
                e.c(this.mIo).a(this.mIo.mKey, Boolean.valueOf(true));
                e.c(this.mIo).bsE();
            }
        }
        return false;
    }
}
