package com.tencent.mm.plugin.masssend.ui;

import android.database.Cursor;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.masssend.a.a;
import com.tencent.mm.plugin.masssend.a.b;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.n.d;

class MassSendHistoryUI$4 implements d {
    final /* synthetic */ MassSendHistoryUI lbg;

    MassSendHistoryUI$4(MassSendHistoryUI massSendHistoryUI) {
        this.lbg = massSendHistoryUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (menuItem.getItemId() == 1) {
            a aVar = (a) MassSendHistoryUI.b(this.lbg).getItem(menuItem.getGroupId());
            if (aVar != null) {
                if (aVar.bcg().equals(MassSendHistoryUI.b(this.lbg).laO)) {
                    MassSendHistoryUI.h(this.lbg);
                }
                b bco = h.bco();
                String bcg = aVar.bcg();
                Cursor b = bco.dCZ.b("select * from massendinfo ORDER BY createtime DESC  limit 2", null, 0);
                if (b != null) {
                    a aVar2;
                    ai aiVar;
                    if (b.getCount() == 0) {
                        b.close();
                    } else if (b.getCount() == 1) {
                        b.moveToFirst();
                        aVar2 = new a();
                        aVar2.d(b);
                        b.close();
                        aiVar = new ai();
                        aiVar.setUsername("masssendapp");
                        aiVar.setContent(ad.getContext().getResources().getString(R.l.contact_info_masssend_tip));
                        aiVar.as(aVar2.createTime);
                        aiVar.eX(0);
                        aiVar.eV(0);
                        au.HU();
                        c.FW().a(aiVar, "masssendapp");
                    } else {
                        b.moveToPosition(1);
                        aVar2 = new a();
                        aVar2.d(b);
                        b.close();
                        aiVar = new ai();
                        aiVar.setUsername("masssendapp");
                        aiVar.setContent(b.a(aVar2));
                        aiVar.as(aVar2.createTime);
                        aiVar.eX(0);
                        aiVar.eV(0);
                        au.HU();
                        c.FW().a(aiVar, "masssendapp");
                    }
                }
                if (bco.dCZ.delete("massendinfo", "clientid= ?", new String[]{bcg}) > 0) {
                    bco.doNotify();
                }
            }
        }
    }
}
