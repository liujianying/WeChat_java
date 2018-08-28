package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

class ChatroomContactUI$12 implements OnItemLongClickListener {
    final /* synthetic */ ChatroomContactUI uiv;

    ChatroomContactUI$12(ChatroomContactUI chatroomContactUI) {
        this.uiv = chatroomContactUI;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.d("MicroMsg.ChatroomContactUI", "onItemLongClick, targetview is SearchBar::ListView, pos = " + i);
        if (i < ChatroomContactUI.b(this.uiv).getHeaderViewsCount()) {
            x.w("MicroMsg.ChatroomContactUI", "on item long click, but match header view");
            return true;
        } else if (ChatroomContactUI.d(this.uiv) != null && ChatroomContactUI.d(this.uiv).uFK) {
            return true;
        } else {
            String str = ((ab) ChatroomContactUI.f(this.uiv).getItem(i - ChatroomContactUI.b(this.uiv).getHeaderViewsCount())).field_username;
            if (s.hE(str) || s.hF(str)) {
                return true;
            }
            ChatroomContactUI.c(this.uiv, str);
            ChatroomContactUI.j(this.uiv).a(view, i, j, this.uiv, ChatroomContactUI.g(this.uiv), ChatroomContactUI.h(this.uiv), ChatroomContactUI.i(this.uiv));
            return true;
        }
    }
}
