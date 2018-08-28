package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ac.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.n.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class s$16 implements OnClickListener {
    final /* synthetic */ s ucn;

    s$16(s sVar) {
        this.ucn = sVar;
    }

    public final void onClick(View view) {
        au auVar = (au) view.getTag();
        Map z = bl.z(auVar.bXQ.field_content, "msg");
        if (z == null) {
            x.i("MicroMsg.ChattingItemDyeingTemplate", "values map is null.");
            return;
        }
        int i = bi.getInt((String) z.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
        String oV;
        if (i == 1) {
            String str = (String) z.get(".msg.appmsg.mmreader.category.item.weapp_username");
            String str2 = (String) z.get(".msg.appmsg.mmreader.category.item.weapp_path");
            int i2 = bi.getInt((String) z.get(".msg.appmsg.mmreader.category.item.weapp_version"), 0);
            int i3 = bi.getInt((String) z.get(".msg.appmsg.mmreader.category.item.weapp_state"), 0);
            oV = bi.oV((String) z.get(".msg.appmsg.template_id"));
            x.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", new Object[]{str});
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.bGG = auVar.bXQ.field_msgSvrId + ":" + auVar.userName + ":" + s.b(this.ucn).getTalkerUserName() + ":" + oV;
            if (((a) g.l(a.class)).gr(auVar.userName)) {
                appBrandStatObject.scene = 1014;
                ((d) g.l(d.class)).a(s.b(this.ucn).tTq.getContext(), str, null, i3, i2, str2, appBrandStatObject);
            } else {
                appBrandStatObject.scene = 1043;
                com.tencent.mm.ac.d kH = f.kH(auVar.userName);
                ((d) g.l(d.class)).a(s.b(this.ucn).tTq.getContext(), str, null, i3, i2, str2, appBrandStatObject, kH == null ? null : kH.field_appId);
            }
            s.C(9, s.c(this.ucn), s.d(this.ucn));
            h.mEJ.h(11608, new Object[]{s.d(this.ucn), auVar.userName, Integer.valueOf(0)});
        } else if (i == 2) {
            s.b(view.getContext(), (String) z.get(".msg.appmsg.mmreader.category.item.schedule_username"), bi.getLong((String) z.get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1));
            x.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", new Object[]{oV, Long.valueOf(r2)});
        }
    }
}
