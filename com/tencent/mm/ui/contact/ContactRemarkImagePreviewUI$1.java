package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.d;

class ContactRemarkImagePreviewUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ContactRemarkImagePreviewUI uiD;

    ContactRemarkImagePreviewUI$1(ContactRemarkImagePreviewUI contactRemarkImagePreviewUI) {
        this.uiD = contactRemarkImagePreviewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        d dVar = new d(this.uiD, 1, false);
        dVar.ofp = new c() {
            public final void a(l lVar) {
                if (!ContactRemarkImagePreviewUI.a(ContactRemarkImagePreviewUI$1.this.uiD)) {
                    lVar.e(0, ContactRemarkImagePreviewUI$1.this.uiD.getString(R.l.app_delete));
                }
                lVar.e(1, ContactRemarkImagePreviewUI$1.this.uiD.getString(R.l.save_to_local));
                if (com.tencent.mm.bg.d.QS("favorite")) {
                    lVar.e(2, ContactRemarkImagePreviewUI$1.this.uiD.getString(R.l.plugin_favorite_opt));
                }
            }
        };
        dVar.ofq = new 2(this);
        dVar.bXO();
        return true;
    }
}
