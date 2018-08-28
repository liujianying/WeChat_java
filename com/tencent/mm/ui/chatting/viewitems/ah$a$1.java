package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.viewitems.ah.a;

class ah$a$1 implements OnClickListener {
    final /* synthetic */ e udY;
    final /* synthetic */ a udZ;

    ah$a$1(a aVar, e eVar) {
        this.udZ = aVar;
        this.udY = eVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(view.getContext(), TextPreviewUI.class);
        au auVar = (au) this.udY.ueb.getTag();
        if (auVar != null) {
            CharSequence charSequence = this.udY.ueb.mText;
            intent.putExtra("Chat_Msg_Id", auVar.bXQ.field_msgId);
            intent.putExtra("key_chat_text", charSequence);
            view.getContext().startActivity(intent);
            b.gE(view.getContext());
        }
    }
}
