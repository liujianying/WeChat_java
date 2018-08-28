package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.mm.plugin.brandservice.b.c;
import com.tencent.mm.plugin.brandservice.ui.b.b;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.storage.q;

class a$4 implements a {
    final /* synthetic */ q her;
    final /* synthetic */ a hqX;
    final /* synthetic */ c$e hqY;

    a$4(a aVar, c$e c_e, q qVar) {
        this.hqX = aVar;
        this.hqY = c_e;
        this.her = qVar;
    }

    public final void onFinish() {
        this.hqY.hrE.hrq.setVisibility(0);
        if ((this.her.field_msgId + "_0").equals(b.avq())) {
            this.hqY.hrE.hrp.setImageResource(c.chatting_item_biz_music_pause_selector);
        } else {
            this.hqY.hrE.hrp.setImageResource(c.chatting_item_biz_music_play_selector);
        }
    }
}
