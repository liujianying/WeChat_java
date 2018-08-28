package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.List;

public final class b implements a {
    public final List<Preference> a(Context context, final f fVar, final MallTransactionObject mallTransactionObject) {
        f fVar2;
        f fVar3;
        List<Preference> arrayList = new ArrayList();
        boolean z = mallTransactionObject.bCK == 2;
        if (!(bi.oW(mallTransactionObject.lNX) || bi.oW(mallTransactionObject.fqJ))) {
            d dVar = new d(context);
            dVar.iAb = mallTransactionObject.fqJ;
            dVar.mName = mallTransactionObject.lNX;
            dVar.mOnClickListener = new 1(this, mallTransactionObject, context);
            arrayList.add(dVar);
            arrayList.add(new PreferenceSmallCategory(context));
        }
        x.i("MicroMsg.FetchOrderPrefFactory", "getOrderPrefList() chargeFee is " + mallTransactionObject.lOm + " and fetchTotalFee is " + mallTransactionObject.lOw);
        h hVar;
        if (TextUtils.isEmpty(mallTransactionObject.lOm)) {
            CharSequence string;
            boolean z2;
            i iVar = new i(context);
            iVar.lQC = e.e(mallTransactionObject.hUL, mallTransactionObject.lNV);
            if (z) {
                string = context.getString(i.wallet_order_info_amount_income);
            } else {
                string = context.getString(i.wallet_order_info_fetch_amount);
            }
            iVar.setTitle(string);
            if (!bi.oW(mallTransactionObject.lNN)) {
                iVar.Jx(mallTransactionObject.lNN);
            }
            arrayList.add(iVar);
            if (mallTransactionObject.hUL == mallTransactionObject.lOb || mallTransactionObject.lOb <= 0.0d) {
                z2 = false;
            } else {
                hVar = new h(context);
                hVar.lQz = false;
                hVar.lQA = true;
                arrayList.add(hVar);
                fVar2 = new f(context);
                fVar2.setContent(e.e(mallTransactionObject.lOb, mallTransactionObject.lNV));
                fVar2.setTitle(i.wallet_order_info_orginal_amount);
                arrayList.add(fVar2);
                if (!bi.oW(mallTransactionObject.lOa)) {
                    g gVar = new g(context);
                    gVar.setTitle(i.wallet_order_info_discount);
                    gVar.gua = fVar;
                    String[] split = mallTransactionObject.lOa.split("\n");
                    if (split.length == 1) {
                        gVar.lQs = split[0];
                    } else {
                        gVar.lQs = context.getString(i.wallet_order_info_discount_summary, new Object[]{Integer.valueOf(split.length), e.e(mallTransactionObject.lOb - mallTransactionObject.hUL, mallTransactionObject.lNV)});
                        gVar.a(split, TruncateAt.MIDDLE);
                    }
                    arrayList.add(gVar);
                }
                z2 = true;
            }
            h hVar2 = new h(context);
            hVar2.lQz = z2;
            hVar2.lQA = true;
            arrayList.add(hVar2);
        } else {
            i iVar2 = new i(context);
            iVar2.lQC = e.e(mallTransactionObject.lOw, mallTransactionObject.lNV);
            iVar2.setTitle(context.getString(i.wallet_order_info_amount_outcome));
            if (!bi.oW(mallTransactionObject.lOx)) {
                iVar2.Jx(mallTransactionObject.lOx);
            }
            arrayList.add(iVar2);
            hVar = new h(context);
            hVar.lQz = false;
            hVar.lQA = true;
            arrayList.add(hVar);
            fVar2 = new f(context);
            fVar2.setTitle(i.wallet_order_info_fetch_amount);
            fVar2.setContent(e.e(mallTransactionObject.hUL, mallTransactionObject.lNV));
            arrayList.add(fVar2);
            fVar2 = new f(context);
            fVar2.setTitle(i.wallet_order_info_charge_fee);
            fVar2.setContent(mallTransactionObject.lOm);
            arrayList.add(fVar2);
        }
        if (!bi.oW(mallTransactionObject.desc)) {
            if (z) {
                fVar3 = new f(context);
                fVar3.setTitle(i.wallet_order_info_from);
                fVar3.setContent(mallTransactionObject.desc);
                arrayList.add(fVar3);
            } else {
                fVar3 = new f(context);
                fVar3.setTitle(i.wallet_order_info_desc);
                if (bi.oW(mallTransactionObject.lNL)) {
                    fVar3.setContent(mallTransactionObject.desc);
                } else {
                    String string2 = context.getString(i.wallet_order_info_check_detail);
                    fVar3.a(mallTransactionObject.desc + " " + string2, mallTransactionObject.desc.length() + 1, string2.length() + (mallTransactionObject.desc.length() + 1), new OnClickListener() {
                        public final void onClick(View view) {
                            fVar3.setContent(mallTransactionObject.desc + "\n" + mallTransactionObject.lNL);
                            fVar.notifyDataSetChanged();
                        }
                    });
                }
                arrayList.add(fVar3);
            }
        }
        if (!bi.oW(mallTransactionObject.lNK)) {
            fVar3 = new f(context);
            fVar3.setTitle(i.wallet_order_info_merchant_name);
            fVar3.setContent(mallTransactionObject.lNK);
            arrayList.add(fVar3);
        }
        if (!bi.oW(mallTransactionObject.lNP)) {
            fVar3 = new f(context);
            fVar3.setTitle(i.wallet_order_info_status);
            fVar3.setContent(mallTransactionObject.lNP);
            if (!bi.oW(mallTransactionObject.lNQ)) {
                fVar3.Jw(mallTransactionObject.lNQ);
            }
            arrayList.add(fVar3);
        }
        fVar3 = new f(context);
        fVar3.setTitle(i.wallet_order_info_fetch_deal_time);
        fVar3.setContent(e.hb(mallTransactionObject.dTR));
        arrayList.add(fVar3);
        if (mallTransactionObject.lOi > 0) {
            fVar3 = new f(context);
            fVar3.setTitle(i.wallet_order_info_fetch_arrive_time);
            fVar3.setContent(e.hb(mallTransactionObject.lOi));
            arrayList.add(fVar3);
        } else if (mallTransactionObject.lOh > 0) {
            fVar3 = new f(context);
            fVar3.setTitle(i.wallet_order_info_fetch_pre_time);
            fVar3.setContent(e.hb(mallTransactionObject.lOh));
            arrayList.add(fVar3);
        } else {
            x.e("MicroMsg.FetchOrderPrefFactory", "hy: is fetch but no arrive time or fetch time");
        }
        if (!bi.oW(mallTransactionObject.lNT)) {
            fVar2 = new f(context);
            fVar2.setTitle(i.wallet_order_info_fetch_bank);
            String str = mallTransactionObject.lNT;
            if (!bi.oW(mallTransactionObject.lNU)) {
                str = str + "(" + mallTransactionObject.lNU + ")";
            }
            fVar2.setContent(str);
            arrayList.add(fVar2);
        }
        if (!bi.oW(mallTransactionObject.lNS)) {
            fVar3 = new f(context);
            fVar3.setTitle(i.wallet_order_info_fetch_trans_id);
            fVar3.setContent(mallTransactionObject.lNS);
            arrayList.add(fVar3);
        }
        h hVar3;
        if (bi.oW(mallTransactionObject.lOf) && bi.oW(mallTransactionObject.lNW) && bi.oW(mallTransactionObject.lNy)) {
            hVar3 = new h(context);
            hVar3.lQz = true;
            hVar3.gOc = false;
            arrayList.add(hVar3);
        } else {
            hVar3 = new h(context);
            hVar3.lQz = true;
            arrayList.add(hVar3);
            arrayList.add(com.tencent.mm.plugin.order.model.a.a(context, mallTransactionObject));
        }
        return arrayList;
    }
}
