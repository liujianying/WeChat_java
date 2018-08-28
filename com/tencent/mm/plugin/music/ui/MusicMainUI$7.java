package com.tencent.mm.plugin.music.ui;

import com.tencent.mm.plugin.music.b.a.c.a;

class MusicMainUI$7 implements a {
    final /* synthetic */ MusicMainUI lBe;

    MusicMainUI$7(MusicMainUI musicMainUI) {
        this.lBe = musicMainUI;
    }

    public final void co(int i, int i2) {
        if (MusicMainUI.l(this.lBe) == 1 && !MusicMainUI.m(this.lBe)) {
            float floatExtra = this.lBe.getIntent().getFloatExtra("key_offset", 0.0f);
            floatExtra *= 1000.0f;
            long currentTimeMillis = (long) (floatExtra + ((float) (System.currentTimeMillis() - this.lBe.getIntent().getLongExtra("music_player_beg_time", 0))));
            if (currentTimeMillis >= 0) {
                MusicMainUI.h(this.lBe).D(MusicMainUI.i(this.lBe).getCurrentItem(), currentTimeMillis + 200);
            }
        } else if (i >= 0 && i2 > 0) {
            MusicMainUI.h(this.lBe).D(MusicMainUI.i(this.lBe).getCurrentItem(), (long) i);
        }
    }
}
