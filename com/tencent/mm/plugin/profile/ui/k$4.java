package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.KeyValuePreference;

class k$4 extends KeyValuePreference {
    final /* synthetic */ b lWC;
    final /* synthetic */ k lWx;

    k$4(k kVar, Context context, b bVar) {
        this.lWx = kVar;
        this.lWC = bVar;
        super(context);
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        if (this.lWL != null) {
            int i = (this.lWC.action == 2 || this.lWC.action == 3) ? 1 : 0;
            if (i != 0) {
                this.lWL.setTextColor(ad.getResources().getColorStateList(R.e.phone_item_text_color));
            }
        }
        if (this.tCH != null && !TextUtils.isEmpty(this.lWC.bWP)) {
            this.tCH.setVisibility(0);
            o.Pj().a(this.lWC.bWP, this.tCH);
        }
    }
}
