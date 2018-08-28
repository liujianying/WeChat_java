package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class SnsTimeLineUI$43 implements c {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$43(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
    }

    public final void a(l lVar) {
        if (!af.eyg) {
            lVar.e(3, this.odw.getString(j.app_field_mmsight));
        }
        lVar.e(1, this.odw.getString(j.app_field_select_new_pic));
    }
}
