package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class s$15 implements OnClickListener {
    final /* synthetic */ s ucn;

    s$15(s sVar) {
        this.ucn = sVar;
    }

    public final void onClick(View view) {
        au auVar = (au) view.getTag();
        x.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", new Object[]{auVar.userName});
        qu quVar = new qu();
        quVar.cbq.userName = auVar.userName;
        quVar.cbq.cbs = auVar.ufD;
        Map z = bl.z(auVar.bXQ.field_content, "msg");
        String str = "";
        if (z != null && z.size() > 0) {
            quVar.cbq.cbt = bi.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
            str = bi.oV((String) z.get(".msg.appmsg.template_id"));
        }
        quVar.cbq.cbx = true;
        quVar.cbq.scene = 1014;
        quVar.cbq.bGG = auVar.bXQ.field_msgSvrId + ":" + auVar.userName + ":" + s.b(this.ucn).getTalkerUserName() + ":" + str;
        a.sFg.m(quVar);
        s.C(9, s.c(this.ucn), s.d(this.ucn));
        h.mEJ.h(11608, new Object[]{s.d(this.ucn), auVar.userName, Integer.valueOf(0)});
    }
}
