package com.tencent.mm.plugin.qmessage.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.qmessage.a;
import com.tencent.mm.storage.ai;

class QConversationUI$9 implements OnItemClickListener {
    final /* synthetic */ QConversationUI mbV;

    QConversationUI$9(QConversationUI qConversationUI) {
        this.mbV = qConversationUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ai aiVar = (ai) QConversationUI.b(this.mbV).getItem(i);
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("Chat_User", aiVar.field_username);
        intent.putExtra("key_need_send_video", false);
        a.ezn.e(intent, this.mbV.mController.tml);
    }
}
