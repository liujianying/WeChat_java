package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.a.c;
import com.tencent.mm.ac.a.t;
import com.tencent.mm.ac.n;
import com.tencent.mm.ac.z;
import com.tencent.mm.bg.d;
import com.tencent.mm.protocal.c.ans;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;
import java.util.Map;

class g$87 implements n {
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;
    final /* synthetic */ String qjO;

    g$87(g gVar, i iVar, String str) {
        this.qiK = gVar;
        this.qiH = iVar;
        this.qjO = str;
    }

    public final void a(int i, l lVar) {
        if (i != 0) {
            g.a(this.qiK, this.qiH, "openEnterpriseChat:fail", null);
            return;
        }
        ans Nv = ((t) lVar).Nv();
        String str;
        if (Nv != null && Nv.riQ != null && Nv.riQ.ret == 0) {
            str = Nv.riK;
            String str2 = ((t) lVar).dNT;
            if (str2 == null) {
                g.a(this.qiK, this.qiH, "openEnterpriseChat:fail", null);
                return;
            }
            c la = z.Na().la(str2);
            if (la == null || bi.oW(str)) {
                g.a(this.qiK, this.qiH, "openEnterpriseChat:fail", null);
                return;
            }
            Intent intent;
            if (bi.oW(this.qjO) || !this.qjO.equals("long")) {
                intent = new Intent();
                intent.putExtra("Chat_User", str);
                intent.putExtra("key_biz_chat_id", la.field_bizChatLocalId);
                intent.putExtra("finish_direct", true);
                intent.putExtra("key_need_send_video", false);
                intent.putExtra("key_is_biz_chat", true);
                d.e(g.j(this.qiK), ".ui.chatting.ChattingUI", intent);
            } else {
                intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("biz_chat_need_to_jump_to_chatting_ui", true);
                intent.putExtra("Main_User", str);
                intent.putExtra("biz_chat_chat_id", la.field_bizChatLocalId);
                intent.putExtra("biz_chat_from_scene", 8);
                d.e(g.j(this.qiK), ".ui.LauncherUI", intent);
            }
            Map hashMap = new HashMap();
            if (!(bi.oW(Nv.ruG) || bi.oW(Nv.ruH))) {
                hashMap.put("chat_type", Nv.ruG);
                hashMap.put("chat_id", Nv.ruH);
            }
            g.a(this.qiK, this.qiH, "openEnterpriseChat:ok", hashMap);
        } else if (Nv == null || Nv.riQ == null) {
            g.a(this.qiK, this.qiH, "openEnterpriseChat:fail", null);
        } else {
            Map hashMap2 = new HashMap();
            hashMap2.put("err_code", Integer.valueOf(Nv.riQ.ret));
            str = "openEnterpriseChat:fail";
            if (Nv.riQ.bMI != null) {
                str = Nv.riQ.bMI;
            }
            g.a(this.qiK, this.qiH, str, hashMap2);
        }
    }
}
