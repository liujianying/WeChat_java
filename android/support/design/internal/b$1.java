package android.support.design.internal;

import android.support.v7.view.menu.h;
import android.view.View;
import android.view.View.OnClickListener;

class b$1 implements OnClickListener {
    final /* synthetic */ b bz;

    b$1(b bVar) {
        this.bz = bVar;
    }

    public final void onClick(View view) {
        NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
        this.bz.o(true);
        h itemData = navigationMenuItemView.getItemData();
        boolean a = this.bz.bq.a(itemData, this.bz, 0);
        if (itemData != null && itemData.isCheckable() && a) {
            this.bz.br.d(itemData);
        }
        this.bz.o(false);
        this.bz.n(false);
    }
}
