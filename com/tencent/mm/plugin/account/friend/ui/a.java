package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.util.LinkedList;

public final class a implements OnClickListener {
    private Context context;
    private a eLH;

    static /* synthetic */ void y(ab abVar) {
        com.tencent.mm.l.a abVar2;
        if (((int) abVar2.dhP) == 0) {
            ((i) g.l(i.class)).FR().U(abVar2);
            if (!bi.oW(abVar2.field_username)) {
                abVar2 = ((i) g.l(i.class)).FR().Yg(abVar2.field_username);
            } else {
                return;
            }
        }
        if (((int) abVar2.dhP) <= 0) {
            x.e("MicroMsg.AddContactListener", "addContact : insert contact failed");
        } else {
            s.p(abVar2);
        }
    }

    public a(Context context, a aVar) {
        this.context = context;
        this.eLH = aVar;
    }

    public final void onClick(View view) {
        b bVar = (b) view.getTag();
        String str = bVar.username;
        int i = bVar.eLK;
        int i2 = bVar.position;
        ab Yg = ((i) g.l(i.class)).FR().Yg(str);
        if (bi.oW(Yg.field_username)) {
            Yg.setUsername(str);
        }
        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.context, new 1(this, Yg, i2, str));
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(i));
        aVar.c(str, linkedList);
    }
}
