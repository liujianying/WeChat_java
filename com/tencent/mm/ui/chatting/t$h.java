package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.t.d;
import com.tencent.mm.ui.chatting.viewitems.au;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;

public class t$h extends d {
    public t$h(a aVar) {
        super(aVar);
    }

    public final void a(View view, a aVar, bd bdVar) {
        au auVar = (au) view.getTag();
        int i = auVar.designerUIN;
        String str = auVar.designerName;
        String str2 = auVar.designerRediretctUrl;
        if (i != 0) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", aVar.getTalkerUserName());
            intent.putExtra("rawUrl", auVar.cGB);
            intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, i);
            intent.putExtra("name", str);
            intent.putExtra("rediret_url", str2);
            intent.putExtra("extra_scence", 22);
            com.tencent.mm.bg.d.b(aVar.tTq.getContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", intent);
        }
    }
}
