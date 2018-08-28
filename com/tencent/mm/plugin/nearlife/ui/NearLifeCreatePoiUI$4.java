package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.nearlife.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class NearLifeCreatePoiUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ NearLifeCreatePoiUI lEr;

    NearLifeCreatePoiUI$4(NearLifeCreatePoiUI nearLifeCreatePoiUI) {
        this.lEr = nearLifeCreatePoiUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.mEJ.h(11138, new Object[]{"2", "0", NearLifeCreatePoiUI.b(this.lEr)});
        NearLifeCreatePoiUI nearLifeCreatePoiUI = this.lEr;
        Context context = this.lEr.mController.tml;
        this.lEr.getString(R.l.nl_create_poi_title);
        NearLifeCreatePoiUI.a(nearLifeCreatePoiUI, com.tencent.mm.ui.base.h.a(context, this.lEr.getString(R.l.nl_creating), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                au.DF().c(NearLifeCreatePoiUI.c(NearLifeCreatePoiUI$4.this.lEr));
            }
        }));
        NearLifeCreatePoiUI.a(this.lEr, NearLifeCreatePoiUI.d(this.lEr).getText().toString());
        NearLifeCreatePoiUI.b(this.lEr, NearLifeCreatePoiUI.e(this.lEr).getText().toString());
        NearLifeCreatePoiUI.c(this.lEr, NearLifeCreatePoiUI.f(this.lEr).getText().toString());
        String obj = ((EditText) this.lEr.findViewById(R.h.et_position_tel)).getText().toString();
        LinkedList g = NearLifeCreatePoiUI.g(this.lEr);
        NearLifeCreatePoiUI.a(this.lEr, new b(NearLifeCreatePoiUI.h(this.lEr), NearLifeCreatePoiUI.i(this.lEr), NearLifeCreatePoiUI.j(this.lEr), NearLifeCreatePoiUI.k(this.lEr), g.size(), g, obj));
        au.DF().a(NearLifeCreatePoiUI.c(this.lEr), 0);
        x.d("MicroMsg.NearLifeCreatePoiUI", "do scene start");
        return true;
    }
}
