package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.plugin.chatroom.ui.SelectMemberUI.b;

class SelectMemberUI$b$2 implements Runnable {
    final /* synthetic */ b hPA;

    SelectMemberUI$b$2(b bVar) {
        this.hPA = bVar;
    }

    public final void run() {
        this.hPA.notifyDataSetChanged();
        if (b.c(this.hPA) == null || b.c(this.hPA).size() != 0) {
            SelectMemberUI.a(this.hPA.hPv).setVisibility(0);
            SelectMemberUI.g(this.hPA.hPv).setVisibility(8);
            return;
        }
        SelectMemberUI.a(this.hPA.hPv).setVisibility(8);
        SelectMemberUI.g(this.hPA.hPv).setVisibility(0);
    }
}
