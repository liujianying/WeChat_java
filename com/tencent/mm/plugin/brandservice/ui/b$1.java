package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.bju;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.base.sortview.a.b;

class b$1 extends b {
    final /* synthetic */ b hok;

    b$1(b bVar) {
        this.hok = bVar;
    }

    public final boolean a(Context context, a aVar, Object... objArr) {
        if (!(aVar instanceof b)) {
            return false;
        }
        String str;
        String str2;
        b bVar = (b) aVar;
        bju bju = (bju) aVar.data;
        if (bju.rQz != null) {
            str = bju.rQz.siM;
        } else {
            str = null;
        }
        if (bju.rvi != null) {
            str2 = bju.rvi.siM;
        } else {
            str2 = null;
        }
        if (bi.oW(str2)) {
            x.e("MicroMsg.BizRecommDataItem", "onItemClick but username is null");
            return false;
        }
        c cVar;
        ab Yg = ((i) g.l(i.class)).FR().Yg(str2);
        Intent intent = new Intent();
        if (com.tencent.mm.l.a.gd(Yg.field_type)) {
            intent.putExtra("Contact_User", str2);
            intent.putExtra("Contact_Scene", 55);
        } else {
            intent.putExtra("Contact_User", str2);
            intent.putExtra("Contact_Alias", bju.eJM);
            intent.putExtra("Contact_Nick", str);
            intent.putExtra("Contact_Signature", bju.eJK);
            intent.putExtra("Contact_RegionCode", RegionCodeDecoder.aq(bju.eJQ, bju.eJI, bju.eJJ));
            intent.putExtra("Contact_Sex", bju.eJH);
            intent.putExtra("Contact_VUser_Info", bju.rTf);
            intent.putExtra("Contact_VUser_Info_Flag", bju.rTe);
            intent.putExtra("Contact_KWeibo_flag", bju.rTi);
            intent.putExtra("Contact_KWeibo", bju.rTg);
            intent.putExtra("Contact_KWeiboNick", bju.rTh);
            intent.putExtra("Contact_Scene", 55);
            if (bju.rTl != null) {
                try {
                    intent.putExtra("Contact_customInfo", bju.rTl.toByteArray());
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BizRecommDataItem", e, "", new Object[0]);
                }
            }
        }
        com.tencent.mm.plugin.brandservice.a.ezn.d(intent, context);
        if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof c)) {
            cVar = null;
        } else {
            cVar = (c) objArr[0];
        }
        c.b avb = bVar.avb();
        if (avb == null || cVar == null) {
            return true;
        }
        avb.a(cVar, aVar, 1, str2, bVar.avc(), bVar.getPosition());
        return true;
    }

    public final View b(Context context, View view) {
        if (view == null) {
            return View.inflate(context, e.search_or_recommend_biz_item, null);
        }
        return view;
    }

    public final void a(Context context, a.a aVar, a aVar2) {
        int i = 0;
        if (context == null || aVar == null || aVar2 == null || aVar2.data == null) {
            x.e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
        } else if (!(aVar instanceof b.a)) {
            x.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of BizRecommViewHolder.");
        } else if (aVar2.data instanceof bju) {
            int i2;
            b.a aVar3 = (b.a) aVar;
            b bVar = (b) aVar2;
            aVar3.username = bVar.username;
            aVar3.iconUrl = bVar.iconUrl;
            com.tencent.mm.plugin.brandservice.ui.base.b.a.a(aVar3.eCl, bVar.username, bVar.iconUrl);
            aVar3.eTm.setText(bVar.eCh, BufferType.SPANNABLE);
            View view = aVar3.hoh;
            if (bVar.hob) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view.setVisibility(i2);
            View view2 = aVar3.hod;
            if (!bVar.hoa) {
                i = 8;
            }
            view2.setVisibility(i);
            aVar3.hoe.setText(bVar.hnX, BufferType.SPANNABLE);
            com.tencent.mm.plugin.brandservice.b.a.b(aVar3.hoc, bVar.hoj);
        } else {
            x.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of SearchOrRecommendItem.");
        }
    }

    public final void a(View view, a.a aVar) {
        if (view != null && aVar != null && (aVar instanceof b.a)) {
            b.a aVar2 = (b.a) aVar;
            aVar2.eCl = (ImageView) view.findViewById(d.avatarIV);
            aVar2.eTm = (TextView) view.findViewById(d.nicknameTV);
            aVar2.hoc = (TextView) view.findViewById(d.contactitem_catalog);
            aVar2.hoh = view.findViewById(d.bizTrademarkProtectionIV);
            aVar2.hod = view.findViewById(d.verifyIV);
            aVar2.hoe = (TextView) view.findViewById(d.introduceTV);
        }
    }
}
