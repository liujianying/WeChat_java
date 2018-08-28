package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.viewitems.au;
import com.tencent.mm.ui.chatting.viewitems.s.b;
import java.util.Map;

public class t$o extends t$d {
    public t$o(a aVar) {
        super(aVar);
    }

    public final void a(View view, a aVar, bd bdVar) {
        int i = 0;
        au auVar = (au) view.getTag();
        x.d("MicroMsg.WebViewClickListener", "edw timestamp, onClick = " + System.currentTimeMillis());
        if (!f.a(auVar.ceR, aVar.tTq.getContext(), null, aVar.getTalkerUserName())) {
            String str = auVar.userName;
            String str2 = auVar.ufy;
            if (str != null && !str.equals("")) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str);
                intent.putExtra("shortUrl", str);
                intent.putExtra("webpageTitle", str2);
                Bundle bundle = new Bundle();
                if (bdVar != null) {
                    if (bdVar.cmg()) {
                        Map z = bl.z(bdVar.field_content, "msg");
                        if (z != null) {
                            b az = b.az(z);
                            if (!ai.oW(az.dxx)) {
                                intent.putExtra("KTemplateId", az.dxx);
                                x.d("MicroMsg.WebViewClickListener", "report template msg click action, templateId(%s). srcUsername(%s)", new Object[]{az.dxx, auVar.bZG});
                                h.mEJ.h(11608, new Object[]{az.dxx, auVar.bZG, Integer.valueOf(0)});
                            }
                        }
                    }
                    com.tencent.mm.model.au.HU();
                    ab Yg = c.FR().Yg(bdVar.field_talker);
                    if (Yg != null && Yg.ckW()) {
                        x.d("MicroMsg.WebViewClickListener", "hakon click biz msg %s", new Object[]{Yg.field_username});
                        i = 4;
                    }
                    intent.putExtra("msg_id", bdVar.field_msgId);
                    intent.putExtra("KPublisherId", "msg_" + Long.toString(bdVar.field_msgSvrId));
                    intent.putExtra("pre_username", bdVar.field_talker);
                    com.tencent.mm.ui.chatting.b.b.c cVar = (com.tencent.mm.ui.chatting.b.b.c) aVar.O(com.tencent.mm.ui.chatting.b.b.c.class);
                    intent.putExtra("prePublishId", "msg_" + Long.toString(bdVar.field_msgSvrId));
                    intent.putExtra("preUsername", com.tencent.mm.ui.chatting.viewitems.b.a(bdVar, auVar.tGg, cVar.cur()));
                    intent.putExtra("preChatName", aVar.getTalkerUserName());
                    intent.putExtra("preChatTYPE", t.N(com.tencent.mm.ui.chatting.viewitems.b.a(bdVar, auVar.tGg, cVar.cur()), aVar.getTalkerUserName()));
                    intent.putExtra("preMsgIndex", auVar.pSA);
                    Bundle bundle2 = auVar.ufE;
                    if (bundle2 != null) {
                        intent.putExtras(bundle2);
                    }
                }
                bundle.putInt("snsWebSource", i);
                intent.putExtra("jsapiargs", bundle);
                intent.putExtra("geta8key_username", aVar.getTalkerUserName());
                if (!ai.oW(auVar.bZG)) {
                    intent.putExtra("srcUsername", auVar.bZG);
                    intent.putExtra("srcDisplayname", auVar.bZH);
                    intent.putExtra("mode", 1);
                }
                intent.putExtra("message_id", auVar.pSz);
                intent.putExtra("message_index", auVar.pSA);
                intent.putExtra("from_scence", 1);
                intent.addFlags(536870912);
                d.b(aVar.tTq.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                if (!ai.oW(aVar.getTalkerUserName())) {
                    com.tencent.mm.model.au.HU();
                    if (c.FR().Yg(aVar.getTalkerUserName()).csS == 1) {
                        com.tencent.mm.model.au.HU();
                        c.FW().Yu(aVar.getTalkerUserName());
                    }
                }
            }
        }
    }
}
