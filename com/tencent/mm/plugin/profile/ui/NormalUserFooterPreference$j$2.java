package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.j;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;

class NormalUserFooterPreference$j$2 implements OnClickListener {
    final /* synthetic */ j lXQ;

    NormalUserFooterPreference$j$2(j jVar) {
        this.lXQ = jVar;
    }

    public final void onClick(View view) {
        if (NormalUserFooterPreference.a(this.lXQ.lXw).BA()) {
            s.i(NormalUserFooterPreference.a(this.lXQ.lXw));
            NormalUserFooterPreference.a(this.lXQ.lXw).Be();
            this.lXQ.bnA();
            return;
        }
        h.a(this.lXQ.lXw.mContext, this.lXQ.lXw.mContext.getString(ab.XR(NormalUserFooterPreference.a(this.lXQ.lXw).field_username) ? R.l.contact_info_movein_blacklist_confirm_for_openim : R.l.contact_info_movein_blacklist_confirm), this.lXQ.lXw.mContext.getString(R.l.contact_info_movein_blacklist), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                s.h(NormalUserFooterPreference.a(NormalUserFooterPreference$j$2.this.lXQ.lXw));
                NormalUserFooterPreference.a(NormalUserFooterPreference$j$2.this.lXQ.lXw).Bd();
                NormalUserFooterPreference$j$2.this.lXQ.bnA();
            }
        }, null);
    }
}
