package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.a;
import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.a.3;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

class EnterpriseBizContactListView$a$2 implements d {
    final /* synthetic */ a hpx;

    EnterpriseBizContactListView$a$2(a aVar) {
        this.hpx = aVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (!bi.oW(this.hpx.hpu) && menuItem.getItemId() == 1) {
            a aVar = this.hpx;
            String str = this.hpx.hpu;
            EnterpriseBizContactListView enterpriseBizContactListView = (EnterpriseBizContactListView) aVar.hpw.get();
            if (enterpriseBizContactListView != null) {
                Context context = enterpriseBizContactListView.getContext();
                h.a(context, context.getString(b.h.enterprise_contact_info_disable_sub_confirm), "", context.getString(b.h.enterprise_contact_info_disable_sub), context.getString(b.h.app_cancel), new 3(aVar, str, context), null);
            }
        }
    }
}
