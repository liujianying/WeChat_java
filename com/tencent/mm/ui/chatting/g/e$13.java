package com.tencent.mm.ui.chatting.g;

import com.tencent.mm.R;

class e$13 implements Runnable {
    final /* synthetic */ e tYu;

    e$13(e eVar) {
        this.tYu = eVar;
    }

    public final void run() {
        if (e.c(this.tYu) != null) {
            e.c(this.tYu).Fk(R.l.gallery_selected_save_err_part);
        }
    }
}
