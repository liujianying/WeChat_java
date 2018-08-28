package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewStub;
import com.tencent.mm.a.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.c;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.x;

public final class i {
    public static void a(a aVar, bd bdVar, Intent intent) {
        if (aVar != null && bdVar != null) {
            String str;
            int i;
            Bundle bundle;
            String talkerUserName = aVar.getTalkerUserName();
            String str2 = aVar.oLT.field_username;
            boolean cur = ((c) aVar.O(c.class)).cur();
            if (s.fq(aVar.getTalkerUserName()) || cur) {
                if (s.fq(aVar.getTalkerUserName())) {
                    String iB = com.tencent.mm.model.bd.iB(bdVar.field_content);
                    if (str2 == null || iB == null || iB.length() <= 0) {
                        iB = str2;
                    }
                    str2 = iB;
                } else if (bdVar != null) {
                    str2 = bdVar.field_bizChatUserId;
                }
            }
            Bundle bundle2 = new Bundle();
            if (s.fq(aVar.getTalkerUserName())) {
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
            bundle2.putString("stat_send_msg_user", str2);
            intent.putExtra("_stat_obj", bundle2);
        }
    }

    public static boolean e(bd bdVar, String str) {
        if (System.currentTimeMillis() - bdVar.field_createTime <= 259200000 || (!bi.oW(str) && e.cn(str))) {
            return false;
        }
        return true;
    }

    public static boolean X(ab abVar) {
        return abVar.field_username.equals("medianote") && (q.GJ() & 16384) == 0;
    }

    public static ViewStub a(x xVar, int i) {
        ViewStub viewStub = (ViewStub) xVar.findViewById(i);
        if (viewStub != null) {
            viewStub.inflate();
        }
        return viewStub;
    }

    public static boolean aan(String str) {
        if (s.he(str) || !s.gW(str) || q.gQ(str)) {
            return false;
        }
        int i;
        int i2;
        au.HU();
        ab Yg = com.tencent.mm.model.c.FR().Yg(str);
        if (Yg != null) {
            i = Yg.field_type;
            au.HU();
            Yg = com.tencent.mm.model.c.FR().Yg(Yg.field_encryptUsername);
            i2 = Yg != null ? Yg.field_type : -1;
        } else {
            i2 = -1;
            i = -1;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.ChattingLogic", "isStranger:%s type:%d etype:%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        return true;
    }
}
