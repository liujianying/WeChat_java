package com.tencent.mm.ui.contact;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.bv.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.OpenIMAddressUI.a;

class OpenIMAddressUI$a$4 implements OnScrollListener {
    final /* synthetic */ a ulb;

    OpenIMAddressUI$a$4(a aVar) {
        this.ulb = aVar;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        x.i("MicroMsg.OpenIMAddressUI", "[onScroll] firstVisibleItem:%s", new Object[]{Integer.valueOf(i)});
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        x.i("MicroMsg.OpenIMAddressUI", "[onScrollStateChanged] scrollState:%s", new Object[]{Integer.valueOf(i)});
        if (i == 2) {
            d.cov().dh(OpenIMAddressUI.class.getName() + ".Listview", 4);
        }
    }
}
