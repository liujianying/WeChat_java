package com.tencent.mm.plugin.profile.ui;

import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.11;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

class NormalUserFooterPreference$a$11$1 implements d {
    final /* synthetic */ 11 lXF;

    NormalUserFooterPreference$a$11$1(11 11) {
        this.lXF = 11;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                this.lXF.lXy.JH(NormalUserFooterPreference.a(this.lXF.lXy.lXw).field_username);
                return;
            case 5:
                h.a(this.lXF.lXy.lXw.mContext, this.lXF.lXy.lXw.mContext.getString(ab.XR(NormalUserFooterPreference.a(this.lXF.lXy.lXw).field_username) ? R.l.contact_info_movein_blacklist_confirm_for_openim : R.l.contact_info_movein_blacklist_confirm), this.lXF.lXy.lXw.mContext.getString(R.l.contact_info_movein_blacklist), new 1(this), null);
                return;
            case 8:
                a.a(this.lXF.lXy);
                return;
            default:
                return;
        }
    }
}
