package com.tencent.mm.plugin.card.base;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.card.a$g;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.ui.base.h;

class CardBaseUI$6 implements a {
    final /* synthetic */ String dhF;
    final /* synthetic */ CardBaseUI htt;
    final /* synthetic */ boolean htw;

    CardBaseUI$6(CardBaseUI cardBaseUI, String str, boolean z) {
        this.htt = cardBaseUI;
        this.dhF = str;
        this.htw = z;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            CardBaseUI.c(this.htt, this.dhF);
            h.bA(this.htt, this.htt.getResources().getString(a$g.card_has_gift_tips));
            if (this.htw) {
                CardBaseUI cardBaseUI = this.htt;
                String str2 = this.dhF;
                Intent intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", str2);
                d.e(cardBaseUI, ".ui.chatting.ChattingUI", intent);
            }
        }
    }
}
