package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.f;
import com.tencent.mm.ui.contact.AddressUI.a;

class AddressUI$a$3 implements OnItemLongClickListener {
    final /* synthetic */ a uhE;

    AddressUI$a$3(a aVar) {
        this.uhE = aVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.i("MicroMsg.AddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = " + i);
        if (i < a.c(this.uhE).getHeaderViewsCount()) {
            x.w("MicroMsg.AddressUI", "on item long click, but match header view");
            return true;
        } else if (a.g(this.uhE) != null && a.g(this.uhE).uFK) {
            return true;
        } else {
            f fVar = (f) a.a(this.uhE).Dy(i - a.c(this.uhE).getHeaderViewsCount());
            if (fVar == null) {
                x.e("MicroMsg.AddressUI", "cont is null. position:%d, header count:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(a.c(this.uhE).getHeaderViewsCount())});
                return true;
            }
            String str = fVar.field_username;
            if (s.hE(str) || s.hF(str)) {
                return true;
            }
            a.b(this.uhE, str);
            a.l(this.uhE).a(view, i, j, this.uhE, a.i(this.uhE), a.j(this.uhE), a.k(this.uhE));
            return true;
        }
    }
}
