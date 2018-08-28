package com.tencent.mm.ui.transmit;

import android.content.Intent;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.widget.a.c$a$b;

class SelectConversationUI$3 implements c$a$b {
    final /* synthetic */ SelectConversationUI uEC;

    SelectConversationUI$3(SelectConversationUI selectConversationUI) {
        this.uEC = selectConversationUI;
    }

    public final void aMV() {
        Intent intent = new Intent(this.uEC.mController.tml, ImageGalleryUI.class);
        intent.putExtra("img_gallery_msg_id", SelectConversationUI.i(this.uEC));
        intent.putExtra("img_gallery_msg_svr_id", SelectConversationUI.j(this.uEC).field_msgSvrId);
        intent.putExtra("img_gallery_talker", SelectConversationUI.j(this.uEC).field_talker);
        intent.putExtra("img_gallery_chatroom_name", SelectConversationUI.j(this.uEC).field_talker);
        intent.putExtra("img_preview_only", true);
        this.uEC.startActivity(intent);
        b.gE(this.uEC.mController.tml);
    }
}
