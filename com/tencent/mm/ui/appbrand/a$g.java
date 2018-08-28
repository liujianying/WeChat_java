package com.tencent.mm.ui.appbrand;

import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.y;

public class a$g extends a$c {
    final /* synthetic */ a tre;

    public a$g(a aVar) {
        this.tre = aVar;
        super(aVar);
    }

    public final View cqZ() {
        View inflate = y.gq(this.tre.context).inflate(R.i.chatting_appbrand_action_sheet_title, null);
        ((TextView) inflate.findViewById(R.h.appbrand_view_title)).setText(this.tre.context.getString(R.l.app_brand_service_menu_refuse_confirm_msg));
        return inflate;
    }

    public final void a(l lVar) {
        super.a(lVar);
        lVar.e(6, this.tre.context.getString(R.l.app_brand_menu_refuse_msg));
        lVar.e(4, this.tre.context.getString(R.l.app_brand_service_menu_cancel));
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        super.onMMMenuItemSelected(menuItem, i);
    }
}
