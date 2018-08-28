package com.tencent.mm.ui.chatting.g;

import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.l.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.gallery.b;

class e$3 implements a {
    final /* synthetic */ bd dAB;
    final /* synthetic */ e tYu;

    e$3(e eVar, bd bdVar) {
        this.tYu = eVar;
        this.dAB = bdVar;
    }

    public final void eu(int i, int i2) {
        if (i == i2) {
            x.i("MicroMsg.MediaHistoryGalleryPresenter", "[onSceneProgressEnd] MsgId:%s", new Object[]{Long.valueOf(this.dAB.field_msgId)});
            e.h(this.tYu);
            if (!b.b(e.b(this.tYu), this.dAB, false)) {
                e.a(this.tYu, true);
            }
            if (!e.g(this.tYu)) {
                return;
            }
            if (e.f(this.tYu)) {
                e.d(this.tYu).post(new Runnable() {
                    public final void run() {
                        if (e.c(e$3.this.tYu) != null) {
                            e.c(e$3.this.tYu).Fk(R.l.gallery_selected_save_err_part);
                        }
                    }
                });
            } else {
                e.d(this.tYu).post(new 1(this));
            }
        }
    }
}
