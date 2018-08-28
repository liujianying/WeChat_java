package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class s$11 implements OnClickListener {
    final /* synthetic */ s ucn;

    s$11(s sVar) {
        this.ucn = sVar;
    }

    public final void onClick(View view) {
        au auVar = (au) view.getTag();
        x.i("MicroMsg.ChattingItemDyeingTemplate", "on header (%s) name click", auVar.userName);
        Map z = bl.z(auVar.bXQ.field_content, "msg");
        String oV = bi.oV((String) z.get(".msg.fromusername"));
        h.mEJ.h(11608, s.d(this.ucn), oV, Integer.valueOf(66666));
        String oV2 = bi.oV((String) z.get(".msg.appmsg.mmreader.template_header.weapp_username"));
        if (bi.oW(oV2)) {
            String oV3 = bi.oV((String) z.get(".msg.appmsg.mmreader.template_header.header_jump_url"));
            if (!bi.oW(oV3)) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", oV3);
                d.b(s.b(this.ucn).tTq.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                return;
            }
            return;
        }
        String oV4 = bi.oV((String) z.get(".msg.appmsg.mmreader.template_header.weapp_path"));
        int i = bi.getInt((String) z.get(".msg.appmsg.mmreader.template_header.weapp_state"), 0);
        int i2 = bi.getInt((String) z.get(".msg.appmsg.mmreader.template_header.weapp_version"), 0);
        oV = bi.oV((String) z.get(".msg.appmsg.template_id"));
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.bGG = auVar.bXQ.field_msgSvrId + ":" + auVar.userName + ":" + s.b(this.ucn).getTalkerUserName() + ":" + oV;
        appBrandStatObject.scene = HardCoderJNI.FUNC_CANCEL_UNIFY_CPU_IO_THREAD_CORE;
        ((com.tencent.mm.plugin.appbrand.n.d) g.l(com.tencent.mm.plugin.appbrand.n.d.class)).a(s.b(this.ucn).tTq.getContext(), oV2, null, i, i2, oV4, appBrandStatObject);
    }
}
