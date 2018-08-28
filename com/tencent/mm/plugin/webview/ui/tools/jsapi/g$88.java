package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.a.c;
import com.tencent.mm.ac.a.m;
import com.tencent.mm.ac.n;
import com.tencent.mm.ac.z;
import com.tencent.mm.bg.d;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.sdk.platformtools.bi;

class g$88 implements n {
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;

    g$88(g gVar, i iVar) {
        this.qiK = gVar;
        this.qiH = iVar;
    }

    public final void a(int i, l lVar) {
        if (i != 0) {
            g.a(this.qiK, this.qiH, "enterEnterpriseChat:fail", null);
            return;
        }
        qg Ns = ((m) lVar).Ns();
        String str = "enterEnterpriseChat:fail";
        if (i < 0) {
            if (!(Ns == null || Ns.riQ == null || !bi.oW(Ns.riQ.bMI))) {
                str = "enterEnterpriseChat:fail_" + Ns.riQ.bMI;
            }
            g.a(this.qiK, this.qiH, str, null);
            return;
        }
        String str2 = Ns.riK;
        String str3 = ((m) lVar).dNT;
        if (str3 == null) {
            g.a(this.qiK, this.qiH, "enterEnterpriseChat:fail", null);
            return;
        }
        c la = z.Na().la(str3);
        if (la == null || bi.oW(str2)) {
            g.a(this.qiK, this.qiH, str, null);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str2);
        intent.putExtra("key_biz_chat_id", la.field_bizChatLocalId);
        intent.putExtra("finish_direct", true);
        intent.putExtra("key_need_send_video", false);
        intent.putExtra("key_is_biz_chat", true);
        d.e(g.j(this.qiK), ".ui.chatting.ChattingUI", intent);
        g.a(this.qiK, this.qiH, "enterEnterpriseChat:ok", null);
    }
}
