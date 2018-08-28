package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.t.d;
import com.tencent.mm.ui.chatting.viewitems.au;

public class t$k extends d {
    public t$k(a aVar) {
        super(aVar);
    }

    public final void a(View view, a aVar, bd bdVar) {
        au auVar = (au) view.getTag();
        int i = auVar.tid;
        String str = auVar.dyH;
        String str2 = auVar.desc;
        String str3 = auVar.iconUrl;
        String str4 = auVar.secondUrl;
        if (i != 0) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", aVar.getTalkerUserName());
            intent.putExtra("rawUrl", auVar.cGB);
            intent.putExtra("topic_id", i);
            intent.putExtra("topic_name", str);
            intent.putExtra("topic_desc", str2);
            intent.putExtra("topic_icon_url", str3);
            intent.putExtra("topic_ad_url", str4);
            intent.putExtra("extra_scence", 22);
            com.tencent.mm.bg.d.b(aVar.tTq.getContext(), "emoji", ".ui.EmojiStoreTopicUI", intent);
            return;
        }
        x.i("MicroMsg.DesignerClickListener", "topic id is zero.");
    }
}
