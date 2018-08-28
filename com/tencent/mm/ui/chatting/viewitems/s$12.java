package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class s$12 implements OnClickListener {
    final /* synthetic */ s ucn;

    s$12(s sVar) {
        this.ucn = sVar;
    }

    public final void onClick(View view) {
        au auVar = (au) view.getTag();
        x.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) name click", new Object[]{auVar.userName});
        Map z = bl.z(auVar.bXQ.field_content, "msg");
        if (!(z == null || z.size() == 0)) {
            bi.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
        }
        s sVar = this.ucn;
        view.getContext();
        s.a(sVar, auVar.userName);
    }
}
