package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.plugin.sns.b.n;

class SnsTagContactListUI$1 implements OnItemClickListener {
    final /* synthetic */ SnsTagContactListUI umh;

    SnsTagContactListUI$1(SnsTagContactListUI snsTagContactListUI) {
        this.umh = snsTagContactListUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Intent intent = new Intent();
        a aVar = (a) SnsTagContactListUI.a(this.umh).getItem(i);
        h hVar = n.nkC;
        if (hVar == null) {
            this.umh.finish();
            return;
        }
        Intent e = hVar.e(intent, aVar.field_username);
        if (e == null) {
            this.umh.finish();
        } else {
            d.b(this.umh.mController.tml, "sns", ".ui.SnsUserUI", e);
        }
    }
}
