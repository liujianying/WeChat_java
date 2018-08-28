package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.b.3;

class b$1 implements OnClickListener {
    final /* synthetic */ b$a uhF;
    final /* synthetic */ b uhG;

    b$1(b bVar, b$a b_a) {
        this.uhG = bVar;
        this.uhF = b_a;
    }

    public final void onClick(View view) {
        switch (3.uhH[this.uhF.ordinal()]) {
            case 1:
                Intent intent = new Intent();
                intent.setClassName(b.a(this.uhG), "com.tencent.mm.ui.contact.ChatroomContactUI");
                b.a(this.uhG).startActivity(intent);
                return;
            case 2:
                d.b(b.a(this.uhG), "label", ".ui.ContactLabelManagerUI", new Intent());
                return;
            case 3:
                d.b(b.a(this.uhG), "ipcall", ".ui.IPCallAddressUI", new Intent());
                return;
            default:
                x.e("MicroMsg.ChatroomContactEntranceView", "[cpan] unknow type for click. type:%s", new Object[]{this.uhF});
                return;
        }
    }
}
