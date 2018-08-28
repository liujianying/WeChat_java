package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.f;
import com.tencent.mm.ui.contact.OpenIMAddressUI.a;

class OpenIMAddressUI$a$16 implements OnItemLongClickListener {
    final /* synthetic */ a ulb;

    OpenIMAddressUI$a$16(a aVar) {
        this.ulb = aVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.i("MicroMsg.OpenIMAddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = " + i);
        if (i < a.c(this.ulb).getHeaderViewsCount()) {
            x.w("MicroMsg.OpenIMAddressUI", "on item long click, but match header view");
            return true;
        } else if (a.d(this.ulb) != null && a.d(this.ulb).uFK) {
            return true;
        } else {
            f fVar = (f) a.a(this.ulb).Dy(i - a.c(this.ulb).getHeaderViewsCount());
            if (fVar == null) {
                x.e("MicroMsg.OpenIMAddressUI", "cont is null. position:%d, header count:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(a.c(this.ulb).getHeaderViewsCount())});
                return true;
            }
            String str = fVar.field_username;
            if (s.hE(str) || s.hF(str)) {
                return true;
            }
            a.b(this.ulb, str);
            a.h(this.ulb).a(view, i, j, this.ulb, a.e(this.ulb), a.f(this.ulb), a.g(this.ulb));
            return true;
        }
    }
}
