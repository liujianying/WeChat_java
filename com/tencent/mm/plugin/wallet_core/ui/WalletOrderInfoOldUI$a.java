package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

public class WalletOrderInfoOldUI$a extends BaseAdapter {
    final /* synthetic */ WalletOrderInfoOldUI pwD;

    public WalletOrderInfoOldUI$a(WalletOrderInfoOldUI walletOrderInfoOldUI) {
        this.pwD = walletOrderInfoOldUI;
    }

    public final int getCount() {
        return this.pwD.pvL != null ? this.pwD.pvL.size() : 0;
    }

    private Commodity zs(int i) {
        return (Commodity) this.pwD.pvL.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.pwD, g.wallet_order_info_item, null);
            a aVar2 = new a(this);
            aVar2.pwG = (TextView) view.findViewById(f.wallet_order_info_bankcard_title);
            aVar2.eCn = (TextView) view.findViewById(f.wallet_order_info_desc);
            aVar2.pwJ = (TextView) view.findViewById(f.wallet_order_info_spid);
            aVar2.pwH = (TextView) view.findViewById(f.wallet_order_info_total_fee);
            aVar2.pwI = (TextView) view.findViewById(f.wallet_order_info_org_total_fee);
            aVar2.pwI.getPaint().setFlags(16);
            aVar2.pwK = (TextView) view.findViewById(f.wallet_order_info_trans_id);
            aVar2.pwL = (TextView) view.findViewById(f.wallet_order_info_cre_time);
            aVar2.pwM = (TextView) view.findViewById(f.wallet_order_info_bankcard);
            aVar2.pwO = (MaxListView) view.findViewById(f.wallet_order_info_promotions);
            aVar2.pwP = view.findViewById(f.wallet_order_info_discount_ll);
            aVar2.pwN = view.findViewById(f.wallet_order_info_septator_3);
            aVar2.pwR = (TextView) view.findViewById(f.wallet_order_original_feeinfo_desc);
            aVar2.pwQ = (TextView) view.findViewById(f.wallet_order_original_feeinfo_title);
            aVar2.pwS = (TextView) view.findViewById(f.wallet_order_rate_info_desc);
            aVar2.pwT = (TextView) view.findViewById(f.wallet_order_rate_info_title);
            aVar2.pwV = (ViewGroup) view.findViewById(f.wallet_order_info_tiny_app_info);
            aVar2.ptp = (CdnImageView) view.findViewById(f.tinyapp_logo_iv);
            aVar2.ptq = (TextView) view.findViewById(f.tinyapp_desc);
            aVar2.ptr = (TextView) view.findViewById(f.tinyapp_name);
            aVar2.pwU = view.findViewById(f.wallet_order_info_septator_4);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        Commodity zs = zs(i);
        if (!(zs == null || aVar == null)) {
            CharSequence string;
            WalletOrderInfoOldUI.a(this.pwD, zs.bOe);
            aVar.pwH.setText(e.e(zs.hUL, zs.lNV));
            if (zs.ppw < 0.0d || zs.hUL >= zs.ppw) {
                aVar.pwI.setVisibility(8);
            } else {
                aVar.pwI.setText(e.e(zs.ppw, zs.lNV));
                aVar.pwI.setVisibility(0);
            }
            LinearLayout linearLayout = (LinearLayout) aVar.pwP;
            List list = zs.ppz;
            linearLayout.removeAllViews();
            if (list != null && list.size() > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= list.size()) {
                        break;
                    }
                    DiscountInfo discountInfo = (DiscountInfo) list.get(i3);
                    View textView = new TextView(this.pwD.mController.tml);
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.bottomMargin = this.pwD.mController.tml.getResources().getDimensionPixelOffset(d.BasicPaddingSize);
                    textView.setLayoutParams(layoutParams);
                    textView.setTextAppearance(this.pwD.mController.tml, j.MMWalletOrdersInfo);
                    if (discountInfo.ppR > 0.0d) {
                        textView.setText(discountInfo.mwP + e.e(discountInfo.ppR / 100.0d, this.pwD.pfb.lNV));
                    } else {
                        textView.setText(discountInfo.mwP);
                    }
                    linearLayout.addView(textView);
                    textView.setTextColor(this.pwD.getResources().getColor(c.wallet_favor_list_text_color));
                    i2 = i3 + 1;
                }
            }
            if (linearLayout.getChildCount() > 0) {
                linearLayout.setVisibility(0);
            } else {
                linearLayout.setVisibility(8);
            }
            TextView textView2 = aVar.pwG;
            WalletOrderInfoOldUI walletOrderInfoOldUI = this.pwD;
            if (q.GS()) {
                string = walletOrderInfoOldUI.getString(i.wallet_order_info_pay_method_payu);
            } else {
                string = walletOrderInfoOldUI.getString(i.wallet_order_info_pay_method);
            }
            textView2.setText(string);
            aVar.pwJ.setText(zs.lNK);
            aVar.eCn.setText(zs.desc);
            aVar.eCn.setTag(zs.desc);
            aVar.eCn.setOnLongClickListener(WalletOrderInfoOldUI.a(this.pwD));
            aVar.eCn.setBackgroundResource(a.e.wallet_order_info_trans_id_text_bg);
            aVar.pwK.setText(zs.bOe);
            aVar.pwK.setTag(zs.bOe);
            aVar.pwK.setOnLongClickListener(WalletOrderInfoOldUI.a(this.pwD));
            aVar.pwK.setBackgroundResource(a.e.wallet_order_info_trans_id_text_bg);
            aVar.pwL.setText(e.hb(zs.lNR));
            aVar.pwM.setText(zs.lNT);
            string = zs.ppA;
            if (aVar.pwS != null) {
                if (bi.oW(string)) {
                    aVar.pwT.setVisibility(8);
                    aVar.pwS.setVisibility(8);
                } else {
                    aVar.pwS.setText(string);
                    aVar.pwS.setVisibility(0);
                    aVar.pwT.setVisibility(0);
                }
            }
            string = zs.ppC;
            if (aVar.pwR != null) {
                if (bi.oW(string)) {
                    aVar.pwQ.setVisibility(8);
                    aVar.pwR.setVisibility(8);
                } else {
                    aVar.pwR.setText(string);
                    aVar.pwR.setVisibility(0);
                    aVar.pwQ.setVisibility(0);
                }
            }
            if (zs.ppF.size() > 0) {
                Promotions promotions = (Promotions) zs.ppF.get(0);
                h.mEJ.h(13033, new Object[]{Integer.valueOf(1), promotions.lNW, promotions.url, promotions.name, WalletOrderInfoOldUI.b(this.pwD)});
                this.pwD.pwx = new WalletOrderInfoOldUI.c(this.pwD, zs.ppF);
                aVar.pwO.setAdapter(this.pwD.pwx);
                aVar.pwO.setOnItemClickListener(new 1(this));
                this.pwD.pwx.notifyDataSetChanged();
                aVar.pwO.setVisibility(0);
                aVar.pwN.setVisibility(0);
            } else {
                aVar.pwO.setVisibility(8);
                aVar.pwV.setVisibility(8);
                aVar.pwN.setVisibility(8);
            }
            if (zs.ppD == null || bi.oW(zs.ppD.paD)) {
                aVar.pwV.setVisibility(8);
                aVar.pwU.setVisibility(8);
            } else {
                aVar.ptp.setUrl(zs.ppD.poJ);
                aVar.ptq.setText(zs.ppD.poK);
                aVar.ptr.setText(zs.ppD.poI);
                aVar.pwV.setOnClickListener(new 2(this, zs));
                aVar.pwU.setVisibility(0);
            }
        }
        return view;
    }
}
