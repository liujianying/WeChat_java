package com.tencent.mm.plugin.music.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.an.b;
import com.tencent.mm.plugin.music.model.h;

class MusicMainUI$1 implements OnClickListener {
    final /* synthetic */ MusicMainUI lBe;

    MusicMainUI$1(MusicMainUI musicMainUI) {
        this.lBe = musicMainUI;
    }

    public final void onClick(View view) {
        MusicMainUI.a(this.lBe);
        if (MusicMainUI.b(this.lBe).isChecked()) {
            b.yL();
            MusicMainUI.b(this.lBe).setChecked(true);
            MusicMainUI.biL();
            return;
        }
        MusicMainUI.c(this.lBe);
        if (h.bic().bhQ().PZ()) {
            h.bic().bhQ().resume();
        } else {
            h.bic().e(null);
        }
        this.lBe.biK();
        MusicMainUI.b(this.lBe).setChecked(false);
    }
}
