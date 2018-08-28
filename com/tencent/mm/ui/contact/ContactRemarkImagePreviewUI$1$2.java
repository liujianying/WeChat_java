package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.contact.ContactRemarkImagePreviewUI.1;
import java.io.File;

class ContactRemarkImagePreviewUI$1$2 implements d {
    final /* synthetic */ 1 uiE;

    ContactRemarkImagePreviewUI$1$2(1 1) {
        this.uiE = 1;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                if (ContactRemarkImagePreviewUI.b(this.uiE.uiD)) {
                    new File(ContactRemarkImagePreviewUI.c(this.uiE.uiD)).delete();
                    ContactRemarkImagePreviewUI.a(this.uiE.uiD, true);
                    return;
                }
                ContactRemarkImagePreviewUI.a(this.uiE.uiD, true);
                return;
            case 1:
                l.i(ContactRemarkImagePreviewUI.c(this.uiE.uiD), this.uiE.uiD);
                return;
            case 2:
                ContactRemarkImagePreviewUI.d(this.uiE.uiD);
                return;
            default:
                return;
        }
    }
}
