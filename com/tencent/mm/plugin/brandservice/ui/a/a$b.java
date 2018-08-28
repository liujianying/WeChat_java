package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ac.f;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.brandservice.b$e;
import com.tencent.mm.plugin.brandservice.b.c;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.ui.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.websearch.api.x;

public class a$b extends b {
    final /* synthetic */ a hqB;

    public a$b(a aVar) {
        this.hqB = aVar;
        super(aVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(b$e.fts_biz_contact_item, viewGroup, false);
        a aVar = this.hqB.hqA;
        aVar.eCl = (ImageView) inflate.findViewById(d.avatar_iv);
        aVar.eCm = (TextView) inflate.findViewById(d.title_tv);
        aVar.eCn = (TextView) inflate.findViewById(d.desc_tv);
        aVar.contentView = inflate.findViewById(d.search_item_content_layout);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
        a aVar3 = (a) aVar2;
        a aVar4 = (a) aVar;
        m.h(aVar4.contentView, this.hqB.jtj);
        m.a(context, aVar4.eCl, aVar3.iconUrl, null, c.brand_default_head);
        m.a(aVar3.hqx, aVar4.eCm);
        m.a(aVar3.hqy, aVar4.eCn);
    }

    public final boolean a(Context context, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
        a aVar2 = (a) aVar;
        a(this.hqB.jrx.jrV, aVar2.fyJ);
        Intent intent;
        if (f.kM(aVar2.username)) {
            intent = new Intent();
            intent.putExtra("enterprise_biz_name", aVar2.username);
            intent.putExtra("enterprise_biz_display_name", r.gT(aVar2.username));
            intent.putExtra("enterprise_from_scene", 3);
            com.tencent.mm.bg.d.e(context, ".ui.conversation.EnterpriseConversationUI", intent);
        } else if (f.eZ(aVar2.username)) {
            intent = new Intent();
            intent.putExtra("Contact_User", aVar2.username);
            intent.addFlags(67108864);
            intent.putExtra("biz_chat_from_scene", 5);
            com.tencent.mm.bg.d.e(context, ".ui.bizchat.BizChatConversationUI", intent);
        } else if (f.kN(aVar2.username)) {
            com.tencent.mm.ac.d kH = f.kH(aVar2.username);
            String Mc = kH == null ? null : kH.Mc();
            if (Mc == null) {
                Mc = "";
            }
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", Mc);
            intent2.putExtra("useJs", true);
            intent2.putExtra("srcUsername", aVar2.username);
            intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
            intent2.addFlags(67108864);
            com.tencent.mm.bg.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
        } else {
            intent = new Intent();
            intent.putExtra("Chat_User", aVar2.username);
            intent.putExtra("finish_direct", true);
            com.tencent.mm.bg.d.e(context, ".ui.chatting.ChattingUI", intent);
        }
        x.PZ(aVar2.username);
        return true;
    }
}
