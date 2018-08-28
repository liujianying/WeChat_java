package com.tencent.mm.plugin.scanner.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

class ProductFurtherInfoUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ProductFurtherInfoUI mIE;

    ProductFurtherInfoUI$2(ProductFurtherInfoUI productFurtherInfoUI) {
        this.mIE = productFurtherInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(this.mIE.getString(R.l.scan_product_feedback_title));
        linkedList2.add(Integer.valueOf(0));
        h.a(this.mIE.mController.tml, "", linkedList, linkedList2, "", false, new 1(this));
        return true;
    }
}
