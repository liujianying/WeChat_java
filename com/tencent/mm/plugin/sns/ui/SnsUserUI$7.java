package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.jt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsUserUI$7 extends c<jt> {
    final /* synthetic */ SnsUserUI ohd;

    SnsUserUI$7(SnsUserUI snsUserUI) {
        this.ohd = snsUserUI;
        this.sFo = jt.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        jt jtVar = (jt) bVar;
        if (jtVar instanceof jt) {
            switch (jtVar.bTE.action) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                    SnsUserUI.a(this.ohd).notifyDataSetChanged();
                    break;
            }
        }
        return false;
    }
}
