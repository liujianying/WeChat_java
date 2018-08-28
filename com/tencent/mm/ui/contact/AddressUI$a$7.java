package com.tencent.mm.ui.contact;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.VerticalScrollBar.a;

class AddressUI$a$7 implements a {
    final /* synthetic */ AddressUI.a uhE;

    AddressUI$a$7(AddressUI.a aVar) {
        this.uhE = aVar;
    }

    public final void ys(String str) {
        int i = 0;
        if (this.uhE.getString(R.l.scroll_bar_search).equals(str)) {
            AddressUI.a.c(this.uhE).setSelection(0);
            return;
        }
        a a = AddressUI.a.a(this.uhE);
        x.v("MicroMsg.AddressAdapter", "getSections");
        String[] strArr = a.ugL;
        if (strArr == null) {
            return;
        }
        if ("↑".equals(str)) {
            AddressUI.a.c(this.uhE).setSelection(0);
        } else if ("☆".equals(str)) {
            AddressUI.a.c(this.uhE).setSelection(AddressUI.a.c(this.uhE).getHeaderViewsCount());
        } else {
            while (i < strArr.length && strArr[i] != null) {
                if (strArr[i].equals(str)) {
                    AddressUI.a.c(this.uhE).setSelection(AddressUI.a.a(this.uhE).getPositionForSection(i) + AddressUI.a.c(this.uhE).getHeaderViewsCount());
                    return;
                }
                i++;
            }
        }
    }
}
