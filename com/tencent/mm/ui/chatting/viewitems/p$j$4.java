package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.applet.e$a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.viewitems.p.c;
import com.tencent.mm.ui.chatting.viewitems.p.j;

class p$j$4 implements e$a {
    final /* synthetic */ bd dAs;
    final /* synthetic */ c ubU;
    final /* synthetic */ j ubW;

    p$j$4(j jVar, c cVar, bd bdVar) {
        this.ubW = jVar;
        this.ubU = cVar;
        this.dAs = bdVar;
    }

    public final void onFinish() {
        this.ubU.ubQ.hrq.setVisibility(0);
        if ((this.dAs.field_msgId + "_0").equals(this.ubU.tZw)) {
            this.ubU.ubQ.hrp.setImageResource(R.g.chatting_item_biz_music_pause_selector);
        } else {
            this.ubU.ubQ.hrp.setImageResource(R.g.chatting_item_biz_music_play_selector);
        }
    }
}
