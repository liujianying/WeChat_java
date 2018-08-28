package com.tencent.mm.plugin.card.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.ui.base.h;

class m$1 implements OnClickListener {
    final /* synthetic */ m hGU;

    m$1(m mVar) {
        this.hGU = mVar;
    }

    public final void onClick(View view) {
        String str = (String) view.getTag();
        if (!TextUtils.isEmpty(str)) {
            String substring;
            if (str.contains(";")) {
                substring = str.substring(0, str.indexOf(";"));
            } else {
                substring = str;
            }
            h.a(m.a(this.hGU), true, substring, "", m.a(this.hGU).getString(g.card_contact_info_dial), m.a(this.hGU).getString(g.confirm_dialog_cancel), new 1(this, substring), null);
        }
    }
}
