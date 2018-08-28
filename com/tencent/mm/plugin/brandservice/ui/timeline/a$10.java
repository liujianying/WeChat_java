package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.g.a;
import com.tencent.mm.storage.q;

class a$10 implements OnClickListener {
    final /* synthetic */ a hqX;

    a$10(a aVar) {
        this.hqX = aVar;
    }

    public final void onClick(View view) {
        q qVar = (q) view.getTag();
        Intent intent = new Intent();
        intent.putExtra("Chat_User", qVar.field_talker);
        intent.putExtra("finish_direct", true);
        d.e(a.b(this.hqX), ".ui.chatting.ChattingUI", intent);
        a aVar = (a) a.h(this.hqX).hsb.get(Long.valueOf(qVar.field_msgId));
        if (aVar != null) {
            aVar.rjs = 1;
        }
    }
}
