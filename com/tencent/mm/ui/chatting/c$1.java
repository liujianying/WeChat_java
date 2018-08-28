package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.pd;
import com.tencent.mm.model.au;
import com.tencent.mm.protocal.c.asd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.chatting.t.n;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;

class c$1 implements c {
    final /* synthetic */ n tGX;
    final /* synthetic */ c tGY;

    c$1(c cVar, n nVar) {
        this.tGY = cVar;
        this.tGX = nVar;
    }

    public final void ju(int i) {
        switch (i) {
            case 0:
                Intent intent = new Intent();
                try {
                    intent.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/readtemplate?t=wxm-appmsg-inform&bizusername=%s&tid=%s&mid=%s&mtime=%s&scene=%s#wechat_redirect", new Object[]{URLEncoder.encode(this.tGX.otZ, "UTF-8"), URLEncoder.encode(this.tGX.dxx, "UTF-8"), Long.valueOf(this.tGX.bXQ.field_msgSvrId), Integer.valueOf((int) (this.tGX.bXQ.field_createTime / 1000)), Integer.valueOf(42)}));
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("showShare", false);
                    d.b(c.a(this.tGY).tTq.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    return;
                } catch (UnsupportedEncodingException e) {
                    x.e("MicroMsg.AppSpamClickListener", "exception in expore, %s", new Object[]{e.getMessage()});
                    return;
                }
            case 1:
                x.d("MicroMsg.AppSpamClickListener", "hakon refulse, fromUserName = %s, templateId = %s", new Object[]{this.tGX.otZ, this.tGX.dxx});
                au.DF().a(1030, this.tGY);
                asd asd = new asd();
                asd.rbZ = 1;
                asd.rUx = this.tGX.dxx;
                asd.bHD = "";
                LinkedList linkedList = new LinkedList();
                linkedList.add(asd);
                pd pdVar = new pd();
                pdVar.bZY.bYo = this.tGX.otZ;
                pdVar.bZY.bZZ = linkedList;
                if (a.sFg.m(pdVar)) {
                    c cVar = this.tGY;
                    Context context = c.a(this.tGY).tTq.getContext();
                    c.a(this.tGY).tTq.getMMResources().getString(R.l.app_tip);
                    c.a(cVar, h.a(context, c.a(this.tGY).tTq.getMMResources().getString(R.l.app_waiting), true, new 1(this)));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
