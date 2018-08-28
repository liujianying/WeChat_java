package com.tencent.mm.plugin.chatroom.ui;

import com.tencent.mm.platformtools.h;
import com.tencent.mm.plugin.chatroom.ui.SelectMemberUI.a;
import com.tencent.mm.plugin.chatroom.ui.SelectMemberUI.b;
import java.util.Comparator;

class SelectMemberUI$b$3 implements Comparator<a> {
    final /* synthetic */ b hPA;

    SelectMemberUI$b$3(b bVar) {
        this.hPA = bVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return h.oI(b.a(this.hPA, ((a) obj).guS)).compareToIgnoreCase(h.oI(b.a(this.hPA, ((a) obj2).guS)));
    }
}
