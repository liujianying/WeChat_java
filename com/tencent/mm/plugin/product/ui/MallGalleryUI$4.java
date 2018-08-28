package com.tencent.mm.plugin.product.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.wxpay.a.b;
import com.tencent.mm.ui.base.h;

class MallGalleryUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ MallGalleryUI lSt;

    MallGalleryUI$4(MallGalleryUI mallGalleryUI) {
        this.lSt = mallGalleryUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String[] stringArray;
        if (d.QS("favorite")) {
            stringArray = this.lSt.getResources().getStringArray(b.mall_product_gallery_ui_opt_list_with_fav);
        } else {
            stringArray = this.lSt.getResources().getStringArray(b.mall_product_gallery_ui_opt_list_without_fav);
        }
        h.a(this.lSt.mController.tml, null, stringArray, null, false, new 1(this));
        return true;
    }
}
