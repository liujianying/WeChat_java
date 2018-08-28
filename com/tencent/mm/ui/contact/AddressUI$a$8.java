package com.tencent.mm.ui.contact;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.bv.d;
import com.tencent.mm.ui.contact.AddressUI.a;

class AddressUI$a$8 implements OnScrollListener {
    final /* synthetic */ a uhE;

    AddressUI$a$8(a aVar) {
        this.uhE = aVar;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i >= 2 && !a.n(this.uhE)) {
            a.o(this.uhE);
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            d.cov().dh(AddressUI.class.getName() + ".Listview", 4);
        }
    }
}
