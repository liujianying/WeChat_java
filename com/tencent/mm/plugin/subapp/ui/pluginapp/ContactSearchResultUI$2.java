package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.l.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.biy;
import com.tencent.mm.protocal.c.bjp;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ab;

class ContactSearchResultUI$2 implements OnItemClickListener {
    final /* synthetic */ ContactSearchResultUI ots;
    final /* synthetic */ int ott;

    ContactSearchResultUI$2(ContactSearchResultUI contactSearchResultUI, int i) {
        this.ots = contactSearchResultUI;
        this.ott = i;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = i - ContactSearchResultUI.a(this.ots).getHeaderViewsCount();
        if (headerViewsCount >= 0 && headerViewsCount < ContactSearchResultUI.a(this.ots).getCount()) {
            if (headerViewsCount >= ContactSearchResultUI.b(this.ots).size()) {
                ContactSearchResultUI.a(this.ots, (bjp) ContactSearchResultUI.c(this.ots).get(i - ContactSearchResultUI.b(this.ots).size()));
                return;
            }
            biy biy = (biy) ContactSearchResultUI.b(this.ots).get(headerViewsCount);
            String str = biy.rvi.siM;
            au.HU();
            ab Yg = c.FR().Yg(str);
            if (a.gd(Yg.field_type)) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", str);
                intent.putExtra("Contact_Scene", 3);
                if (str != null && str.length() > 0) {
                    if (Yg.ckW()) {
                        h.mEJ.k(10298, str + ",35");
                        intent.putExtra("Contact_Scene", 35);
                    }
                    d.b(this.ots, "profile", ".ui.ContactInfoUI", intent);
                    return;
                }
                return;
            }
            if ((biy.rTe & 8) > 0) {
                h.mEJ.k(10298, biy.rvi.siM + ",35");
            }
            Intent intent2 = new Intent();
            intent2.putExtra("Contact_User", biy.rvi.siM);
            intent2.putExtra("Contact_Alias", biy.eJM);
            intent2.putExtra("Contact_Nick", biy.rQz.siM);
            intent2.putExtra("Contact_Signature", biy.eJK);
            intent2.putExtra("Contact_RegionCode", RegionCodeDecoder.aq(biy.eJQ, biy.eJI, biy.eJJ));
            intent2.putExtra("Contact_Sex", biy.eJH);
            intent2.putExtra("Contact_VUser_Info", biy.rTf);
            intent2.putExtra("Contact_VUser_Info_Flag", biy.rTe);
            intent2.putExtra("Contact_KWeibo_flag", biy.rTi);
            intent2.putExtra("Contact_KWeibo", biy.rTg);
            intent2.putExtra("Contact_KWeiboNick", biy.rTh);
            intent2.putExtra("Contact_KSnsIFlag", biy.rTk.eJS);
            intent2.putExtra("Contact_KSnsBgId", biy.rTk.eJU);
            intent2.putExtra("Contact_KSnsBgUrl", biy.rTk.eJT);
            intent2.putExtra("Contact_Scene", 35);
            if (this.ott != 0) {
                intent2.putExtra("add_more_friend_search_scene", this.ott);
            }
            if (biy.rTl != null) {
                try {
                    intent2.putExtra("Contact_customInfo", biy.rTl.toByteArray());
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ContactSearchResultUI", e, "", new Object[0]);
                }
            }
            if ((biy.rTe & 8) > 0) {
                h.mEJ.k(10298, biy.rvi.siM + ",35");
            }
            d.b(this.ots, "profile", ".ui.ContactInfoUI", intent2);
        }
    }
}
