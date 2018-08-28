package com.tencent.mm.ui.contact;

import com.tencent.mm.R;
import com.tencent.mm.g.a.ob;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.ui.base.h;

class SnsLabelContactListUI$b extends c<ob> {
    final /* synthetic */ SnsLabelContactListUI ulZ;

    private SnsLabelContactListUI$b(SnsLabelContactListUI snsLabelContactListUI) {
        this.ulZ = snsLabelContactListUI;
        this.sFo = ob.class.getName().hashCode();
    }

    /* synthetic */ SnsLabelContactListUI$b(SnsLabelContactListUI snsLabelContactListUI, byte b) {
        this(snsLabelContactListUI);
        this.sFo = ob.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ob obVar = (ob) bVar;
        if (!(obVar instanceof ob)) {
            return false;
        }
        SnsLabelContactListUI.a(this.ulZ, obVar.bYX.bRc);
        if (SnsLabelContactListUI.b(this.ulZ) != null) {
            SnsLabelContactListUI.c(this.ulZ);
            this.ulZ.initView();
        } else {
            this.ulZ.initView();
            h.a(this.ulZ, this.ulZ.getString(R.l.sns_label_contact_list_get_failed), "", new 1(this));
        }
        return true;
    }
}
