package com.tencent.mm.ui.appbrand;

import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.ui.appbrand.a.c;
import com.tencent.mm.ui.base.l;

public class a$e extends c {
    final /* synthetic */ a tre;

    public a$e(a aVar) {
        this.tre = aVar;
        super(aVar);
    }

    public final void a(l lVar) {
        super.a(lVar);
        lVar.e(3, this.tre.context.getString(R.l.app_brand_service_menu_refuse_msg));
        lVar.e(8, this.tre.context.getString(R.l.app_brand_service_menu_expose));
        lVar.e(7, a.a(this.tre));
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        super.onMMMenuItemSelected(menuItem, i);
    }
}
