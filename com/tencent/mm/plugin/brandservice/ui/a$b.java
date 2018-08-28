package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.ui.base.b$a;
import com.tencent.mm.plugin.brandservice.ui.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.jz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.sortview.a;

public class a$b extends com.tencent.mm.ui.base.sortview.a$b {
    public final boolean a(Context context, a aVar, Object... objArr) {
        if (!(aVar instanceof a)) {
            return false;
        }
        a aVar2 = (a) aVar;
        if (aVar.data instanceof jz) {
            jz jzVar = (jz) aVar.data;
            if (jzVar.rlB == null || jzVar.rlB.rlj == null) {
                x.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
                return false;
            }
            int i;
            c cVar = null;
            String str = "";
            if (objArr != null) {
                c cVar2;
                if (objArr.length <= 0 || !(objArr[0] instanceof c)) {
                    cVar2 = null;
                } else {
                    cVar2 = (c) objArr[0];
                }
                if (objArr.length <= 2 || !(objArr[2] instanceof Integer)) {
                    i = 0;
                } else {
                    i = ((Integer) objArr[2]).intValue();
                }
                if (objArr.length <= 3 || !(objArr[3] instanceof String)) {
                    cVar = cVar2;
                } else {
                    str = (String) objArr[3];
                    cVar = cVar2;
                }
            } else {
                i = 0;
            }
            String str2 = jzVar.rlB.jOU;
            bjv bjv = jzVar.rlB.rlj;
            String str3 = bjv.rQz != null ? bjv.rQz.siM : null;
            String str4 = bjv.rvi != null ? bjv.rvi.siM : null;
            if (bi.oW(str4)) {
                x.e("MicroMsg.BizContactDataItem", "onItemClick but username is null");
                return false;
            }
            int i2;
            com.tencent.mm.plugin.websearch.api.x.PZ(str4);
            if (bi.oW(str2)) {
                ab Yg = ((i) g.l(i.class)).FR().Yg(str4);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("Contact_Ext_Args_Search_Id", str);
                bundle.putInt("Contact_Ext_Args_Index", aVar2.avc());
                bundle.putString("Contact_Ext_Args_Query_String", "");
                bundle.putInt("Contact_Scene", i);
                intent.putExtra("Contact_Ext_Args", bundle);
                intent.putExtra("Contact_User", str4);
                intent.putExtra("Contact_Scene", i);
                if (!com.tencent.mm.l.a.gd(Yg.field_type)) {
                    intent.putExtra("Contact_Alias", bjv.eJM);
                    intent.putExtra("Contact_Nick", str3);
                    intent.putExtra("Contact_Signature", bjv.eJK);
                    intent.putExtra("Contact_RegionCode", RegionCodeDecoder.aq(bjv.eJQ, bjv.eJI, bjv.eJJ));
                    intent.putExtra("Contact_Sex", bjv.eJH);
                    intent.putExtra("Contact_VUser_Info", bjv.rTf);
                    intent.putExtra("Contact_VUser_Info_Flag", bjv.rTe);
                    intent.putExtra("Contact_KWeibo_flag", bjv.rTi);
                    intent.putExtra("Contact_KWeibo", bjv.rTg);
                    intent.putExtra("Contact_KWeiboNick", bjv.rTh);
                    if (bjv.sjI != null) {
                        try {
                            intent.putExtra("Contact_customInfo", bjv.sjI.toByteArray());
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.BizContactDataItem", e, "", new Object[0]);
                        }
                    }
                }
                com.tencent.mm.plugin.brandservice.a.ezn.d(intent, context);
                i2 = 1;
            } else {
                i2 = 8;
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", str2);
                intent2.putExtra("useJs", true);
                intent2.putExtra("vertical_scroll", true);
                d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
            }
            b avb = aVar2.avb();
            if (!(avb == null || cVar == null)) {
                avb.a(cVar, aVar, i2, str4, aVar2.avc(), aVar2.getPosition());
            }
            return true;
        }
        x.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BusinessResultItem.");
        return false;
    }

    public final View b(Context context, View view) {
        if (view == null) {
            return View.inflate(context, e.search_or_recommend_biz_item, null);
        }
        return view;
    }

    public final void a(Context context, a.a aVar, a aVar2) {
        int i = 8;
        if (context == null || aVar == null || aVar2 == null || aVar2.data == null) {
            x.e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
        } else if (!(aVar instanceof a.a)) {
            x.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
        } else if (aVar2 instanceof a) {
            a.a aVar3 = (a.a) aVar;
            a aVar4 = (a) aVar2;
            aVar3.username = aVar4.username;
            aVar3.iconUrl = aVar4.iconUrl;
            b$a.a(aVar3.eCl, aVar4.username, aVar4.iconUrl);
            aVar3.hod.setVisibility(aVar4.hoa ? 0 : 8);
            View view = aVar3.hoh;
            if (aVar4.hob) {
                i = 0;
            }
            view.setVisibility(i);
            com.tencent.mm.plugin.brandservice.b.a.b(aVar3.eMf, aVar4.nickName);
            boolean b = com.tencent.mm.plugin.brandservice.b.a.b(aVar3.hog, aVar4.hnZ);
            boolean b2 = com.tencent.mm.plugin.brandservice.b.a.b(aVar3.hof, aVar4.hnY);
            if (com.tencent.mm.plugin.brandservice.b.a.b(aVar3.hoe, aVar4.hnX)) {
                if (b || b2) {
                    aVar3.hoe.setMaxLines(1);
                } else {
                    aVar3.hoe.setMaxLines(2);
                }
            }
            x.d("MicroMsg.BizContactDataItem", "fillingView , nickName : %s, followFriends : %s.", new Object[]{aVar4.nickName, aVar4.hnY});
        } else {
            x.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
        }
    }

    public final void a(View view, a.a aVar) {
        if (view != null && aVar != null && (aVar instanceof a.a)) {
            a.a aVar2 = (a.a) aVar;
            aVar2.hoc = (TextView) view.findViewById(com.tencent.mm.plugin.brandservice.b.d.contactitem_catalog);
            aVar2.hoh = view.findViewById(com.tencent.mm.plugin.brandservice.b.d.bizTrademarkProtectionIV);
            aVar2.eCl = (ImageView) view.findViewById(com.tencent.mm.plugin.brandservice.b.d.avatarIV);
            aVar2.eMf = (TextView) view.findViewById(com.tencent.mm.plugin.brandservice.b.d.nicknameTV);
            aVar2.hod = view.findViewById(com.tencent.mm.plugin.brandservice.b.d.verifyIV);
            aVar2.hof = (TextView) view.findViewById(com.tencent.mm.plugin.brandservice.b.d.followFriendTV);
            aVar2.hoe = (TextView) view.findViewById(com.tencent.mm.plugin.brandservice.b.d.introduceTV);
            aVar2.hog = (TextView) view.findViewById(com.tencent.mm.plugin.brandservice.b.d.wxidTV);
        }
    }
}
