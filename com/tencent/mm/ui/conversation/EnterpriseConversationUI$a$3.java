package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import com.tencent.mm.ui.conversation.EnterpriseConversationUI.a;

class EnterpriseConversationUI$a$3 implements OnItemClickListener {
    final /* synthetic */ a uqA;

    EnterpriseConversationUI$a$3(a aVar) {
        this.uqA = aVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str = null;
        ai aiVar = (ai) a.f(this.uqA).getItem(i);
        if (aiVar == null) {
            x.e("MicroMsg.EnterpriseConversationUI", "user should not be null. position:%d, size:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(a.f(this.uqA).getCount())});
            a.f(this.uqA).notifyDataSetChanged();
        } else if (f.eZ(aiVar.field_username)) {
            Intent intent = new Intent(this.uqA.thisActivity(), BizChatConversationUI.class);
            intent.putExtra("Contact_User", aiVar.field_username);
            intent.putExtra("biz_chat_from_scene", 7);
            intent.addFlags(67108864);
            this.uqA.startActivity(intent);
        } else if (f.kN(aiVar.field_username)) {
            d kH = f.kH(aiVar.field_username);
            if (kH != null) {
                str = kH.Mc();
            }
            if (str == null) {
                str = "";
            }
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", str);
            intent2.putExtra("useJs", true);
            intent2.putExtra("srcUsername", aiVar.field_username);
            intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
            intent2.putExtra("geta8key_scene", 51);
            intent2.addFlags(67108864);
            com.tencent.mm.bg.d.b(this.uqA.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
            a.a(this.uqA, kH, 2, aiVar.field_unReadCount);
        } else {
            this.uqA.ui.startChatting(aiVar.field_username, null, true);
            a.a(this.uqA, f.kH(aiVar.field_username), 1, aiVar.field_unReadCount);
        }
    }
}
