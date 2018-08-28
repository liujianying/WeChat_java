package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.SnsUserUI.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class SnsUserUI$a$1 implements c {
    final /* synthetic */ a ohe;

    SnsUserUI$a$1(a aVar) {
        this.ohe = aVar;
    }

    public final void a(l lVar) {
        lVar.e(0, this.ohe.ohd.getString(j.app_field_mmsight));
        lVar.e(1, this.ohe.ohd.getString(j.app_field_select_new_pic));
    }
}
