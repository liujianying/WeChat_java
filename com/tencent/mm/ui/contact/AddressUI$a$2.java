package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.biy;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.f;
import com.tencent.mm.ui.contact.AddressUI.a;

class AddressUI$a$2 implements OnItemClickListener {
    final /* synthetic */ a uhE;

    AddressUI$a$2(a aVar) {
        this.uhE = aVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.i("MicroMsg.AddressUI", "onItemClick " + i + (a.g(this.uhE) == null ? a.g(this.uhE) : Boolean.valueOf(a.g(this.uhE).uFK)));
        if ((i != 0 || "@biz.contact".equals(a.h(this.uhE))) && i >= a.c(this.uhE).getHeaderViewsCount()) {
            int headerViewsCount = i - a.c(this.uhE).getHeaderViewsCount();
            String str;
            if (a.g(this.uhE) == null || !a.g(this.uhE).uFK) {
                f fVar = (f) a.a(this.uhE).Dy(headerViewsCount);
                if (fVar != null) {
                    str = fVar.field_username;
                    a aVar = this.uhE;
                    if (str != null && str.length() > 0) {
                        if (s.hE(str)) {
                            x.e("MicroMsg.AddressUI", "error, 4.5 do not contain this contact %s", new Object[]{str});
                            return;
                        }
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", str);
                        if (s.hc(str)) {
                            intent.putExtra("Is_group_card", true);
                        }
                        if (str != null && str.length() > 0) {
                            e.a(intent, str);
                            d.b(aVar.getContext(), "profile", ".ui.ContactInfoUI", intent);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            boolean qY = a.g(this.uhE).qY(headerViewsCount);
            boolean Gl = a.g(this.uhE).Gl(headerViewsCount);
            x.i("MicroMsg.AddressUI", "onItemClick " + Gl);
            Intent intent2;
            if (Gl) {
                a.g(this.uhE).abn("");
            } else if (qY) {
                biy Gk = a.g(this.uhE).Gk(headerViewsCount);
                String str2 = Gk.rvi.siM;
                au.HU();
                ab Yg = c.FR().Yg(str2);
                if (com.tencent.mm.l.a.gd(Yg.field_type)) {
                    intent2 = new Intent();
                    intent2.putExtra("Contact_User", str2);
                    intent2.putExtra("Contact_Scene", 3);
                    if (str2 != null && str2.length() > 0) {
                        if (Yg.ckW()) {
                            h.mEJ.k(10298, str2 + ",3");
                        }
                        e.a(intent2, str2);
                        d.b(this.uhE.getContext(), "profile", ".ui.ContactInfoUI", intent2);
                        return;
                    }
                    return;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("Contact_User", Gk.rvi.siM);
                intent3.putExtra("Contact_Alias", Gk.eJM);
                intent3.putExtra("Contact_Nick", Gk.rQz.siM);
                intent3.putExtra("Contact_Signature", Gk.eJK);
                intent3.putExtra("Contact_RegionCode", RegionCodeDecoder.aq(Gk.eJQ, Gk.eJI, Gk.eJJ));
                intent3.putExtra("Contact_Sex", Gk.eJH);
                intent3.putExtra("Contact_VUser_Info", Gk.rTf);
                intent3.putExtra("Contact_VUser_Info_Flag", Gk.rTe);
                intent3.putExtra("Contact_KWeibo_flag", Gk.rTi);
                intent3.putExtra("Contact_KWeibo", Gk.rTg);
                intent3.putExtra("Contact_KWeiboNick", Gk.rTh);
                intent3.putExtra("Contact_KSnsIFlag", Gk.rTk.eJS);
                intent3.putExtra("Contact_KSnsBgId", Gk.rTk.eJU);
                intent3.putExtra("Contact_KSnsBgUrl", Gk.rTk.eJT);
                if (Gk.rTl != null) {
                    try {
                        intent3.putExtra("Contact_customInfo", Gk.rTl.toByteArray());
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.AddressUI", e, "", new Object[0]);
                    }
                }
                if ((Gk.rTe & 8) > 0) {
                    h.mEJ.k(10298, str2 + ",3");
                }
                d.b(this.uhE.getContext(), "profile", ".ui.ContactInfoUI", intent3);
            } else {
                ab oj = a.g(this.uhE).oj(headerViewsCount);
                if (oj == null) {
                    x.e("MicroMsg.AddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[]{Integer.valueOf(a.g(this.uhE).getCount()), Integer.valueOf(headerViewsCount)});
                    return;
                }
                str = oj.field_username;
                if (s.hE(str)) {
                    Intent intent4 = new Intent(this.uhE.getContext(), AddressUI.class);
                    intent4.putExtra("Contact_GroupFilter_Type", "@biz.contact");
                    this.uhE.startActivity(intent4);
                    return;
                }
                intent2 = new Intent();
                intent2.putExtra("Contact_User", str);
                intent2.putExtra("Contact_Scene", 3);
                if (str != null && str.length() > 0) {
                    d.b(this.uhE.getContext(), "profile", ".ui.ContactInfoUI", intent2);
                }
            }
        }
    }
}
