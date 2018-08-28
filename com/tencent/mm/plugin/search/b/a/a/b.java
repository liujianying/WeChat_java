package com.tencent.mm.plugin.search.b.a.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.f;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.FTSConvMessageUI;
import com.tencent.mm.plugin.fts.ui.FTSConvTalkerMessageUI;
import com.tencent.mm.plugin.fts.ui.a.m;
import com.tencent.mm.plugin.fts.ui.a.p;
import com.tencent.mm.sdk.platformtools.bi;

public final class b implements com.tencent.mm.plugin.fts.a.d.a.b {
    public final boolean a(Context context, a aVar) {
        String str = null;
        m mVar = (m) aVar;
        Intent intent;
        d kH;
        Intent intent2;
        if (mVar.jyF < 2) {
            if (f.kM(mVar.username)) {
                com.tencent.mm.plugin.search.a.ezn.d(new Intent().putExtra("Contact_User", mVar.username), context);
            } else if (f.eZ(mVar.username)) {
                intent = new Intent();
                intent.putExtra("Contact_User", mVar.username);
                intent.addFlags(67108864);
                intent.putExtra("biz_chat_from_scene", 5);
                com.tencent.mm.bg.d.e(context, ".ui.bizchat.BizChatConversationUI", intent);
            } else if (f.kN(mVar.username)) {
                kH = f.kH(mVar.username);
                if (kH != null) {
                    str = kH.Mc();
                }
                if (str == null) {
                    str = "";
                }
                intent2 = new Intent();
                intent2.putExtra("rawUrl", str);
                intent2.putExtra("useJs", true);
                intent2.putExtra("srcUsername", mVar.username);
                intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                intent2.addFlags(67108864);
                com.tencent.mm.bg.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
            } else {
                com.tencent.mm.plugin.search.a.ezn.e(new Intent().putExtra("Chat_User", mVar.username).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", mVar.fyJ.jsA).putExtra("highlight_keyword_list", bi.F(mVar.jrx.jrX)), context);
            }
        } else if (f.eZ(mVar.username)) {
            intent = new Intent();
            intent.putExtra("Contact_User", mVar.username);
            intent.addFlags(67108864);
            intent.putExtra("biz_chat_from_scene", 5);
            com.tencent.mm.bg.d.e(context, ".ui.bizchat.BizChatConversationUI", intent);
        } else if (f.kN(mVar.username)) {
            kH = f.kH(mVar.username);
            if (kH != null) {
                str = kH.Mc();
            }
            if (str == null) {
                str = "";
            }
            intent2 = new Intent();
            intent2.putExtra("rawUrl", str);
            intent2.putExtra("useJs", true);
            intent2.putExtra("srcUsername", mVar.username);
            intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
            intent2.addFlags(67108864);
            com.tencent.mm.bg.d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
        } else if (mVar instanceof p) {
            p pVar = (p) mVar;
            context.startActivity(new Intent(context, FTSConvTalkerMessageUI.class).putExtra("Search_Scene", pVar.jsZ).putExtra("key_talker_query", pVar.jxW.jrx.jrV).putExtra("key_talker", pVar.jxW.jrv).putExtra("key_conv", pVar.username).putExtra("key_query", pVar.jrx.jrV).putExtra("detail_type", pVar.showType));
        } else {
            context.startActivity(new Intent(context, FTSConvMessageUI.class).putExtra("Search_Scene", mVar.jsZ).putExtra("key_conv", mVar.username).putExtra("key_query", mVar.jrx.jrV).putExtra("key_count", mVar.jyF));
        }
        return true;
    }
}
