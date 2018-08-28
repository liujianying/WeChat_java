package com.tencent.mm.plugin.bottle.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.bottle.a;
import com.tencent.mm.storage.ai;

class BottleConversationUI$8 implements OnItemClickListener {
    final /* synthetic */ BottleConversationUI hlc;

    BottleConversationUI$8(BottleConversationUI bottleConversationUI) {
        this.hlc = bottleConversationUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ai aiVar = (ai) BottleConversationUI.a(this.hlc).getItem(i);
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("Chat_User", aiVar.field_username);
        intent.putExtra("finish_direct", true);
        intent.putExtra("key_need_send_video", false);
        a.ezn.e(intent, this.hlc);
    }
}
