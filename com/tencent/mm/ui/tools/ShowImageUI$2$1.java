package com.tencent.mm.ui.tools;

import com.tencent.mm.g.a.ch;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.tools.ShowImageUI.2;

class ShowImageUI$2$1 implements d {
    final /* synthetic */ 2 uCe;

    ShowImageUI$2$1(2 2) {
        this.uCe = 2;
    }

    public final void bx(int i, int i2) {
        switch (i2) {
            case 0:
                ShowImageUI.b(this.uCe.uCd);
                return;
            case 1:
                ShowImageUI showImageUI = this.uCe.uCd;
                ch chVar = new ch();
                long longExtra = showImageUI.getIntent().getLongExtra("key_message_id", -1);
                if (-1 == longExtra) {
                    x.w("MicroMsg.ShowImageUI", "msg id error, try fav simple data");
                    e.a(chVar, showImageUI.getIntent().getIntExtra("key_favorite_source_type", 1), showImageUI.getIntent().getStringExtra("key_image_path"));
                } else {
                    e.a(chVar, longExtra);
                }
                chVar.bJF.activity = showImageUI;
                a.sFg.m(chVar);
                return;
            case 2:
                ShowImageUI.c(this.uCe.uCd);
                return;
            case 3:
                ShowImageUI.d(this.uCe.uCd);
                return;
            default:
                return;
        }
    }
}
