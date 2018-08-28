package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.f;
import com.tencent.mm.plugin.brandservice.a;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class EnterpriseBizContactListView$1 implements OnItemClickListener {
    final /* synthetic */ EnterpriseBizContactListView hpt;

    EnterpriseBizContactListView$1(EnterpriseBizContactListView enterpriseBizContactListView) {
        this.hpt = enterpriseBizContactListView;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag = view.getTag();
        if (tag != null && (tag instanceof c)) {
            c cVar = (c) tag;
            if (!bi.oW(cVar.username)) {
                boolean kN = f.kN(cVar.username);
                boolean eZ = f.eZ(cVar.username);
                d kH = f.kH(cVar.username);
                String Mc = kH == null ? null : kH.Mc();
                if (Mc == null) {
                    Mc = "";
                }
                Intent intent;
                if (kN) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", Mc);
                    intent2.putExtra("useJs", true);
                    intent2.putExtra("srcUsername", cVar.username);
                    intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                    intent2.addFlags(67108864);
                    com.tencent.mm.bg.d.b(this.hpt.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                    EnterpriseBizContactListView.a(this.hpt, kH, 2);
                } else if (eZ) {
                    intent = new Intent();
                    intent.putExtra("Contact_User", cVar.username);
                    intent.addFlags(67108864);
                    intent.putExtra("biz_chat_from_scene", 3);
                    com.tencent.mm.bg.d.e(this.hpt.getContext(), ".ui.bizchat.BizChatConversationUI", intent);
                } else {
                    intent = new Intent();
                    intent.addFlags(67108864);
                    intent.putExtra("finish_direct", true);
                    intent.putExtra("Chat_User", cVar.username);
                    intent.putExtra("chat_from_scene", 2);
                    Context context = this.hpt.getContext();
                    x.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
                    a.ezn.e(intent, context);
                    EnterpriseBizContactListView.a(this.hpt, kH, 1);
                }
            }
        }
    }
}
