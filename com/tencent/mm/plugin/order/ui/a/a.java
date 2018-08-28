package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.c;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a implements com.tencent.mm.plugin.order.model.a.a {
    public c lQc;

    public final List<Preference> a(final Context context, f fVar, final MallTransactionObject mallTransactionObject) {
        Object obj;
        CharSequence string;
        f fVar2;
        ab Yg;
        String BL;
        f fVar3;
        String string2;
        h hVar;
        List<Preference> arrayList = new ArrayList();
        if (mallTransactionObject.bCK == 2) {
            obj = 1;
        } else {
            obj = null;
        }
        if (!(bi.oW(mallTransactionObject.lNX) || bi.oW(mallTransactionObject.fqJ))) {
            d dVar = new d(context);
            dVar.iAb = mallTransactionObject.fqJ;
            dVar.mName = mallTransactionObject.lNX;
            dVar.mOnClickListener = new 1(this, mallTransactionObject, context);
            arrayList.add(dVar);
            arrayList.add(new PreferenceSmallCategory(context));
        }
        i iVar = new i(context);
        iVar.lQC = e.e(mallTransactionObject.hUL, mallTransactionObject.lNV);
        if (obj != null) {
            string = context.getString(i.wallet_order_info_amount_income);
        } else if (mallTransactionObject.lNG == 11) {
            string = context.getString(i.wallet_order_info_save_amount);
        } else {
            string = context.getString(i.wallet_order_info_amount);
        }
        iVar.setTitle(string);
        if (!bi.oW(mallTransactionObject.lNN)) {
            iVar.Jx(mallTransactionObject.lNN);
        }
        arrayList.add(iVar);
        boolean z = false;
        if (mallTransactionObject.hUL != mallTransactionObject.lOb) {
            h hVar2 = new h(context);
            hVar2.lQz = false;
            hVar2.lQA = true;
            arrayList.add(hVar2);
            fVar2 = new f(context);
            fVar2.setContent(e.e(mallTransactionObject.lOb, mallTransactionObject.lNV));
            fVar2.setTitle(i.wallet_order_info_orginal_amount);
            arrayList.add(fVar2);
            z = true;
        }
        if (!(mallTransactionObject.hUL == mallTransactionObject.lOb || bi.oW(mallTransactionObject.lOa))) {
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
        h hVar3 = new h(context);
        hVar3.lQz = z;
        hVar3.lQA = true;
        arrayList.add(hVar3);
        if (obj == null && !bi.oW(mallTransactionObject.lOk)) {
            g.Ek();
            Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg(mallTransactionObject.lOk);
            if (Yg != null && ((int) Yg.dhP) > 0) {
                BL = Yg.BL();
                fVar3 = new f(context);
                fVar3.setTitle(i.wallet_order_info_spid);
                fVar3.setContent(BL);
                arrayList.add(fVar3);
            }
        }
        if (!(mallTransactionObject.lNG != 31 || obj == null || bi.oW(mallTransactionObject.lOr))) {
            g.Ek();
            Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg(mallTransactionObject.lOr);
            if (Yg != null && ((int) Yg.dhP) > 0) {
                BL = Yg.BL();
                fVar3 = new f(context);
                fVar3.setTitle(i.wallet_order_info_from);
                fVar3.setContent(BL);
                arrayList.add(fVar3);
            }
        }
        if (!bi.oW(mallTransactionObject.desc)) {
            if (obj != null) {
                fVar2 = new f(context);
                if (mallTransactionObject.lNG == 32 || mallTransactionObject.lNG == 33 || mallTransactionObject.lNG == 31) {
                    fVar2.setTitle(i.wallet_order_info_collect_remark_txt);
                } else {
                    fVar2.setTitle(i.wallet_order_info_from);
                }
                fVar2.setContent(mallTransactionObject.desc);
                arrayList.add(fVar2);
            } else {
                fVar2 = new f(context);
                if (mallTransactionObject.lNG == 31) {
                    fVar2.setTitle(i.wallet_order_info_remittance_memo);
                } else {
                    fVar2.setTitle(i.wallet_order_info_desc);
                }
                if (bi.oW(mallTransactionObject.lNL)) {
                    fVar2.setContent(mallTransactionObject.desc);
                } else {
                    string2 = context.getString(i.wallet_order_info_check_detail);
                    fVar2.a(mallTransactionObject.desc + " " + string2, mallTransactionObject.desc.length() + 1, string2.length() + (mallTransactionObject.desc.length() + 1), new 2(this, mallTransactionObject, fVar2, fVar));
                }
                arrayList.add(fVar2);
            }
        }
        if (!bi.oW(mallTransactionObject.lOv)) {
            fVar2 = new f(context);
            fVar2.setTitle(i.wallet_order_original_feeinfo_title);
            fVar2.setContent(mallTransactionObject.lOv);
            arrayList.add(fVar2);
        }
        if (!bi.oW(mallTransactionObject.lOu)) {
            fVar2 = new f(context);
            fVar2.setTitle(i.wallet_order_rate_title);
            fVar2.setContent(mallTransactionObject.lOu);
            arrayList.add(fVar2);
        }
        if (!TextUtils.isEmpty(mallTransactionObject.lOm)) {
            fVar2 = new f(context);
            fVar2.setTitle(i.wallet_order_info_charge_fee);
            fVar2.setContent(mallTransactionObject.lOm);
            arrayList.add(fVar2);
        }
        if (!bi.oW(mallTransactionObject.lNK)) {
            fVar2 = new f(context);
            fVar2.setTitle(i.wallet_order_info_merchant_name);
            fVar2.setContent(mallTransactionObject.lNK);
            arrayList.add(fVar2);
        }
        if (!bi.oW(mallTransactionObject.lNP)) {
            fVar2 = new f(context);
            fVar2.setTitle(i.wallet_order_info_status);
            if (mallTransactionObject.lNG != 31 || q.GF().equals(mallTransactionObject.lOk) || mallTransactionObject.lOl <= 0 || bi.oW(mallTransactionObject.lOk) || bi.oW(mallTransactionObject.bOe)) {
                fVar2.setContent(mallTransactionObject.lNP);
                if (!bi.oW(mallTransactionObject.lNQ)) {
                    fVar2.Jw(mallTransactionObject.lNQ);
                }
            } else {
                string2 = context.getString(i.remittance_resend_transfer_msg);
                fVar2.a(mallTransactionObject.lNP + " " + string2, mallTransactionObject.lNP.length() + 1, (string2.length() + mallTransactionObject.lNP.length()) + 1, new 3(this, context, mallTransactionObject));
            }
            arrayList.add(fVar2);
        }
        fVar2 = new f(context);
        fVar2.setTitle(i.wallet_order_info_deal_time);
        fVar2.setContent(e.hb(mallTransactionObject.dTR));
        arrayList.add(fVar2);
        if (!bi.oW(mallTransactionObject.lNT)) {
            f fVar4 = new f(context);
            fVar4.setTitle(i.wallet_order_info_pay_method);
            BL = mallTransactionObject.lNT;
            if (!bi.oW(mallTransactionObject.lNU)) {
                BL = BL + "(" + mallTransactionObject.lNU + ")";
            }
            fVar4.setContent(BL);
            arrayList.add(fVar4);
        }
        if (!bi.oW(mallTransactionObject.bOe)) {
            fVar2 = new f(context);
            fVar2.setTitle(i.wallet_order_info_trans_id);
            fVar2.setContent(mallTransactionObject.bOe);
            arrayList.add(fVar2);
        }
        if (!bi.oW(mallTransactionObject.lNS)) {
            fVar2 = new f(context);
            fVar2.setTitle(i.wallet_order_info_sp_billno);
            if (mallTransactionObject.lNG == 8) {
                fVar2.setContent(context.getString(i.wallet_order_info_sp_billno_tip));
                c cVar = new c(context);
                final Bitmap b = com.tencent.mm.bm.a.a.b(context, mallTransactionObject.lNS, 5, 0);
                cVar.lQk = e.acd(mallTransactionObject.lNS);
                cVar.dHf = b;
                cVar.mOnClickListener = new OnClickListener() {
                    public final void onClick(View view) {
                        if (a.this.lQc != null) {
                            a aVar = a.this;
                            Bitmap bitmap = b;
                            String str = mallTransactionObject.lNS;
                            if (aVar.lQc != null) {
                                aVar.lQc.gn(str, str);
                                aVar.lQc.lLl = bitmap;
                                aVar.lQc.lLm = bitmap;
                                aVar.lQc.cDE();
                            }
                            a.this.lQc.v(view, true);
                        }
                    }
                };
                arrayList.add(fVar2);
                arrayList.add(cVar);
            } else {
                fVar2.setContent(mallTransactionObject.lNS);
                arrayList.add(fVar2);
            }
        }
        Object obj2 = mallTransactionObject.lNv.size() == 0 ? null : 1;
        if (obj2 != null || (bi.oW(mallTransactionObject.lOf) && bi.oW(mallTransactionObject.lNW) && bi.oW(mallTransactionObject.lNy))) {
            hVar = new h(context);
            hVar.lQz = true;
            hVar.gOc = false;
            arrayList.add(hVar);
        } else {
            hVar = new h(context);
            hVar.lQz = true;
            arrayList.add(hVar);
            arrayList.add(com.tencent.mm.plugin.order.model.a.a(context, mallTransactionObject));
        }
        if (obj2 != null) {
            j jVar = new j(context);
            if (mallTransactionObject.lNw == 1) {
                if (!(bi.oW(mallTransactionObject.lOf) && bi.oW(mallTransactionObject.lNW) && bi.oW(mallTransactionObject.lNy))) {
                    if (bi.oW(mallTransactionObject.lOg)) {
                        jVar.lQD = context.getString(i.wallet_order_info_support_customer_service);
                    } else {
                        jVar.lQD = mallTransactionObject.lOg;
                    }
                    jVar.lQE = new OnClickListener() {
                        public final void onClick(View view) {
                            List linkedList = new LinkedList();
                            List linkedList2 = new LinkedList();
                            if (!bi.oW(mallTransactionObject.lNW)) {
                                linkedList2.add(Integer.valueOf(0));
                                linkedList.add(context.getString(i.wallet_order_info_support_biz));
                            }
                            if (!bi.oW(mallTransactionObject.lNy)) {
                                linkedList2.add(Integer.valueOf(1));
                                linkedList.add(context.getString(i.wallet_order_info_support_call));
                            }
                            if (!bi.oW(mallTransactionObject.lOf)) {
                                linkedList2.add(Integer.valueOf(2));
                                linkedList.add(context.getString(i.wallet_order_info_support_safeguard));
                            }
                            if (linkedList2.size() == 1) {
                                com.tencent.mm.plugin.order.model.a.a(((Integer) linkedList2.get(0)).intValue(), context, mallTransactionObject);
                                return;
                            }
                            h.a(context, null, linkedList, linkedList2, null, true, new 1(this));
                        }
                    };
                }
            } else if (!bi.oW(mallTransactionObject.lOg)) {
                jVar.lQD = mallTransactionObject.lOg;
                jVar.lQE = new OnClickListener() {
                    public final void onClick(View view) {
                        a.a(context, mallTransactionObject.lOf, mallTransactionObject);
                    }
                };
            }
            jVar.lNv = mallTransactionObject.lNv;
            jVar.mOnClickListener = new 7(this, context, mallTransactionObject);
            hVar = new h(context);
            hVar.lQz = true;
            arrayList.add(hVar);
            arrayList.add(jVar);
        }
        return arrayList;
    }
}
