package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.n.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.viewitems.s.1.2.1;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class s$1$2$1$1 implements a {
    final /* synthetic */ String tiQ;
    final /* synthetic */ 1 ucr;

    s$1$2$1$1(1 1, String str) {
        this.ucr = 1;
        this.tiQ = str;
    }

    public final void b(WxaAttributes wxaAttributes) {
        if (wxaAttributes == null) {
            s.makeText(this.ucr.ucq.gvo.getContext(), R.l.notify_message_settings_operation_failed, 0).show();
            return;
        }
        if (TextUtils.isEmpty(wxaAttributes.field_appId) || TextUtils.isEmpty(this.tiQ)) {
            x.i("MicroMsg.ChattingItemDyeingTemplate", "appId(%s) or msgId(%s) is null or nil.", new Object[]{r0, this.tiQ});
            s.makeText(this.ucr.ucq.gvo.getContext(), R.l.notify_message_settings_operation_failed, 0).show();
            return;
        }
        try {
            x.d("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", new Object[]{this.tiQ, r0, String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&msgid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[]{URLEncoder.encode(r0, "utf-8"), URLEncoder.encode(this.tiQ, "utf-8"), Integer.valueOf(1), Integer.valueOf(this.ucr.ucq.ucp), Integer.valueOf(this.ucr.ucq.fuS)})});
            Intent intent = new Intent();
            intent.putExtra("rawUrl", r1);
            d.b(s.b(this.ucr.ucq.uco.ucn).tTq.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        } catch (UnsupportedEncodingException e) {
            x.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
            s.makeText(this.ucr.ucq.gvo.getContext(), R.l.notify_message_settings_operation_failed, 0).show();
        }
    }
}
