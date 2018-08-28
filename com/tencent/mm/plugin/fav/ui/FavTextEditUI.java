package com.tencent.mm.plugin.fav.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.m.f;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.auj;
import com.tencent.mm.protocal.c.aum;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.MMTextInputUI;
import java.util.LinkedList;

public class FavTextEditUI extends MMTextInputUI {
    protected final int getLayoutId() {
        return f.fav_edit_input_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.favorite_edit_title);
    }

    protected final void w(CharSequence charSequence) {
        if (charSequence == null || bi.oW(charSequence.toString())) {
            x.w("MicroMsg.FavTextEditUI", "text is null");
            return;
        }
        int intExtra = getIntent().getIntExtra("key_fav_item_id", -1);
        String charSequence2 = charSequence.toString();
        if (intExtra <= 0) {
            x.w("MicroMsg.FavTextEditUI", "modEditText favid:%d", new Object[]{Integer.valueOf(intExtra)});
            return;
        }
        LinkedList linkedList = new LinkedList();
        auj auj = new auj();
        auj.rXA = 4;
        auj.rXB = 0;
        linkedList.add(auj);
        LinkedList linkedList2 = new LinkedList();
        aum aum = new aum();
        aum.jSt = "favitem.desc";
        aum.mEl = bi.aG(charSequence2, "");
        linkedList2.add(aum);
        aum = new aum();
        aum.jSt = "favitem.edittime";
        aum.mEl = String.valueOf(bi.VE());
        linkedList2.add(aum);
        g dz = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dz((long) intExtra);
        if (dz != null) {
            dz.field_edittime = bi.VE();
            dz.field_favProto.fT(dz.field_edittime);
            dz.field_favProto.Vv(bi.aG(charSequence2, ""));
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().a(dz, new String[]{"localId"});
        }
        com.tencent.mm.kernel.g.DF().a(new al(intExtra, linkedList, linkedList2), 0);
        h.mEJ.h(10874, new Object[]{Integer.valueOf(1)});
    }
}
