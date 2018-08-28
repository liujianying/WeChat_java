package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.model.s;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.c.a;

final class c$a {
    static void a(Intent intent, a aVar, bd bdVar, b bVar) {
        String str;
        int i;
        Bundle bundle;
        String talkerUserName = aVar.getTalkerUserName();
        String b = bVar.b(aVar, bdVar);
        Bundle bundle2 = new Bundle();
        if (aVar.cwr()) {
            str = "stat_scene";
            i = 2;
            bundle = bundle2;
        } else {
            str = "stat_scene";
            if (s.hf(talkerUserName)) {
                i = 7;
                bundle = bundle2;
            } else {
                i = 1;
                bundle = bundle2;
            }
        }
        bundle.putInt(str, i);
        bundle2.putString("stat_msg_id", "msg_" + Long.toString(bdVar.field_msgSvrId));
        bundle2.putString("stat_chat_talker_username", talkerUserName);
        bundle2.putString("stat_send_msg_user", b);
        intent.putExtra("_stat_obj", bundle2);
    }
}
