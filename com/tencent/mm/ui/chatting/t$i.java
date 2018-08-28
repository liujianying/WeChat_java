package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.t.d;
import com.tencent.mm.ui.chatting.viewitems.au;

public class t$i extends d {
    public t$i(a aVar) {
        super(aVar);
    }

    public final void a(View view, a aVar, bd bdVar) {
        au auVar = (au) view.getTag();
        int i = auVar.tid;
        String str = auVar.dyH;
        String str2 = auVar.desc;
        String str3 = auVar.iconUrl;
        String str4 = auVar.secondUrl;
        int i2 = auVar.pageType;
        if (i != 0) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", aVar.getTalkerUserName());
            intent.putExtra("rawUrl", auVar.cGB);
            intent.putExtra("set_id", i);
            intent.putExtra("set_title", str);
            intent.putExtra("set_iconURL", str3);
            intent.putExtra("set_desc", str2);
            intent.putExtra("headurl", str4);
            intent.putExtra("pageType", i2);
            com.tencent.mm.bg.d.b(aVar.tTq.getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
            return;
        }
        x.i("MicroMsg.DesignerClickListener", "topic id is zero.");
    }
}
