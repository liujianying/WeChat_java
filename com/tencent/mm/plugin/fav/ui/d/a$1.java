package com.tencent.mm.plugin.fav.ui.d;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.g;

class a$1 implements OnCheckedChangeListener {
    final /* synthetic */ a jen;

    a$1(a aVar) {
        this.jen = aVar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.getTag() != null) {
            g gVar = (g) compoundButton.getTag();
            if (z) {
                this.jen.jem.jbJ.put(Long.valueOf(gVar.field_localId), ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(gVar.field_localId));
            } else {
                this.jen.jem.jbJ.remove(Long.valueOf(gVar.field_localId));
            }
            if (this.jen.jem.jeo != null) {
                this.jen.jem.jeo.dC(gVar.field_localId);
            }
        }
    }
}
