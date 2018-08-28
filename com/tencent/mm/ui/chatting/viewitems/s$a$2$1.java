package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.modelappbrand.q;
import com.tencent.mm.protocal.c.chw;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.viewitems.s.a.2;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class s$a$2$1 implements e {
    final /* synthetic */ 2 ucH;

    s$a$2$1(2 2) {
        this.ucH = 2;
    }

    public final void a(int i, int i2, String str, l lVar) {
        au.DF().b(1198, this);
        x.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(false)});
        if (s.a(this.ucH.ucG.ucn) != null) {
            s.a(this.ucH.ucG.ucn).dismiss();
            s.a(this.ucH.ucG.ucn, null);
        }
        if (i != 0 || i2 != 0) {
            s.makeText(this.ucH.gvo.getContext(), R.l.notify_message_settings_complain_failed, 0).show();
        } else if (this.ucH.dAs != this.ucH.gvo.getTag()) {
            x.w("MicroMsg.ChattingItemDyeingTemplate", "item msg(%s) has changed.", new Object[]{Long.valueOf(this.ucH.dAs.field_msgId)});
        } else {
            chw JV = ((q) lVar).JV();
            if (JV == null) {
                s.makeText(this.ucH.gvo.getContext(), R.l.notify_message_settings_complain_failed, 0).show();
                return;
            }
            String str2 = JV.sBS;
            x.d("MicroMsg.ChattingItemDyeingTemplate", "more view clicked, menu item COMPLAIN_APP_BRAND selected, sync attr username %s", new Object[]{this.ucH.qiU});
            try {
                x.i("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", new Object[]{str2, s.d(this.ucH.ucG.ucn), String.format("https://mp.weixin.qq.com/mp/infringement?from=8&username=%s&template_id=%s&template_msg_id=%s1#wechat_redirect", new Object[]{this.ucH.qiU, URLEncoder.encode(s.d(this.ucH.ucG.ucn), "utf-8"), URLEncoder.encode(str2, "utf-8")})});
                Intent intent = new Intent();
                intent.putExtra("rawUrl", r1);
                d.b(s.b(this.ucH.ucG.ucn).tTq.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            } catch (UnsupportedEncodingException e) {
                x.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
                s.makeText(this.ucH.gvo.getContext(), R.l.notify_message_settings_operation_failed, 0).show();
            }
        }
    }
}
