package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.ChattingUI;

class ad$8 implements OnItemClickListener {
    final /* synthetic */ ad tRG;

    ad$8(ad adVar) {
        this.tRG = adVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bd bdVar = (bd) ad.d(this.tRG).getItem(i);
        if (bdVar != null && !bi.oW(bdVar.field_talker)) {
            h.mEJ.h(10450, new Object[]{Integer.valueOf(1)});
            Intent intent = new Intent(this.tRG.bAG.tTq.getContext(), ChattingUI.class);
            intent.putExtra("Chat_User", bdVar.field_talker);
            intent.putExtra("finish_direct", true);
            intent.putExtra("show_search_chat_content_result", false);
            intent.putExtra("msg_local_id", bdVar.field_msgId);
            intent.putExtra("img_gallery_enter_from_chatting_ui", true);
            this.tRG.bAG.tTq.startActivity(intent);
        }
    }
}
