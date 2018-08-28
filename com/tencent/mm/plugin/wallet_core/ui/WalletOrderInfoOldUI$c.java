package com.tencent.mm.plugin.wallet_core.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Promotions;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

class WalletOrderInfoOldUI$c extends BaseAdapter {
    protected List<Promotions> ppF;
    final /* synthetic */ WalletOrderInfoOldUI pwD;

    public WalletOrderInfoOldUI$c(WalletOrderInfoOldUI walletOrderInfoOldUI, List<Promotions> list) {
        this.pwD = walletOrderInfoOldUI;
        this.ppF = null;
        this.ppF = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Promotions promotions = (Promotions) list.get(i);
            if (promotions != null && (!bi.oW(promotions.lNW) || promotions.ppT == 2 || promotions.ppT == 1)) {
                this.ppF.add(list.get(i));
            }
        }
    }

    public final int getCount() {
        return this.ppF != null ? this.ppF.size() : 0;
    }

    /* renamed from: zt */
    public final Promotions getItem(int i) {
        return (Promotions) this.ppF.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        String fx;
        a aVar;
        Promotions zt = getItem(i);
        if (bi.oW(zt.lNW) && zt.pji > 0) {
            fx = this.pwD.fx(zt.pji);
            h hVar = h.mEJ;
            Object[] objArr = new Object[6];
            objArr[0] = WalletOrderInfoOldUI.b(this.pwD);
            objArr[1] = Integer.valueOf(1);
            objArr[2] = Integer.valueOf(zt.ppT);
            if ("-1".equals(fx)) {
                fx = Integer.valueOf(5);
            }
            objArr[3] = fx;
            objArr[4] = Long.valueOf(zt.pji);
            objArr[5] = Long.valueOf(zt.poF);
            hVar.h(13471, objArr);
        }
        a aVar2;
        View inflate;
        View view2;
        if (view == null) {
            aVar2 = new a(this);
            aVar2.type = zt.type;
            if (zt.type == Orders.ppv) {
                if (zt.ppS == 1) {
                    inflate = View.inflate(this.pwD, g.wallet_order_info_promotions_activity_festival_item, null);
                    aVar2.pwW = (CdnImageView) inflate.findViewById(f.wallet_order_info_logo);
                    aVar2.eBO = (TextView) inflate.findViewById(f.wallet_order_info_title);
                    aVar2.pwX = (TextView) inflate.findViewById(f.wallet_order_info_btn);
                    aVar2.eHU = (TextView) inflate.findViewById(f.wallet_order_info_name);
                    if (!TextUtils.isEmpty(zt.url)) {
                        this.pwD.pww.put(zt.url, aVar2.pwX);
                    }
                    inflate.setTag(aVar2);
                    view2 = inflate;
                } else {
                    inflate = View.inflate(this.pwD, g.wallet_order_info_promotions_activity_item, null);
                    aVar2.pwW = (CdnImageView) inflate.findViewById(f.wallet_order_info_logo);
                    aVar2.pwX = (TextView) inflate.findViewById(f.wallet_order_info_btn);
                    aVar2.eHU = (TextView) inflate.findViewById(f.wallet_order_info_name);
                    aVar2.eBO = (TextView) inflate.findViewById(f.wallet_order_info_title);
                    if (!TextUtils.isEmpty(zt.url)) {
                        this.pwD.pww.put(zt.url, aVar2.pwX);
                    }
                    inflate.setTag(aVar2);
                    view2 = inflate;
                }
                aVar2.ppS = zt.ppS;
                view = view2;
                aVar = aVar2;
            } else {
                view = View.inflate(this.pwD, g.wallet_order_info_promotions_item, null);
                aVar2.pwW = (CdnImageView) view.findViewById(f.wallet_order_info_logo);
                aVar2.pwX = (TextView) view.findViewById(f.wallet_order_info_btn);
                aVar2.eHU = (TextView) view.findViewById(f.wallet_order_info_name);
                aVar2.pwY = (CheckBox) view.findViewById(f.agree_wx_cb);
                if (!TextUtils.isEmpty(zt.url)) {
                    this.pwD.pww.put(zt.url, aVar2.pwX);
                }
                view.setTag(aVar2);
                aVar = aVar2;
            }
        } else {
            a aVar3 = (a) view.getTag();
            Object obj = null;
            if (zt.type == aVar3.type && (zt.type != Orders.ppv || zt.ppS == aVar3.ppS)) {
                obj = 1;
            }
            if (obj == null) {
                aVar2 = new a(this);
                aVar2.type = zt.type;
                if (zt.type == Orders.ppv) {
                    if (zt.ppS == 1) {
                        inflate = View.inflate(this.pwD, g.wallet_order_info_promotions_activity_festival_item, null);
                        aVar2.pwW = (CdnImageView) inflate.findViewById(f.wallet_order_info_logo);
                        aVar2.eBO = (TextView) inflate.findViewById(f.wallet_order_info_title);
                        aVar2.pwX = (TextView) inflate.findViewById(f.wallet_order_info_btn);
                        aVar2.eHU = (TextView) inflate.findViewById(f.wallet_order_info_name);
                        if (!TextUtils.isEmpty(zt.url)) {
                            this.pwD.pww.put(zt.url, aVar2.pwX);
                        }
                        inflate.setTag(aVar2);
                        view2 = inflate;
                    } else {
                        inflate = View.inflate(this.pwD, g.wallet_order_info_promotions_activity_item, null);
                        aVar2.pwW = (CdnImageView) inflate.findViewById(f.wallet_order_info_logo);
                        aVar2.pwX = (TextView) inflate.findViewById(f.wallet_order_info_btn);
                        aVar2.eHU = (TextView) inflate.findViewById(f.wallet_order_info_name);
                        aVar2.eBO = (TextView) inflate.findViewById(f.wallet_order_info_title);
                        if (!TextUtils.isEmpty(zt.url)) {
                            this.pwD.pww.put(zt.url, aVar2.pwX);
                        }
                        inflate.setTag(aVar2);
                        view2 = inflate;
                    }
                    aVar2.ppS = zt.ppS;
                    view = view2;
                    aVar = aVar2;
                } else {
                    view = View.inflate(this.pwD, g.wallet_order_info_promotions_item, null);
                    aVar2.pwW = (CdnImageView) view.findViewById(f.wallet_order_info_logo);
                    aVar2.pwX = (TextView) view.findViewById(f.wallet_order_info_btn);
                    aVar2.eHU = (TextView) view.findViewById(f.wallet_order_info_name);
                    aVar2.pwY = (CheckBox) view.findViewById(f.agree_wx_cb);
                    if (!TextUtils.isEmpty(zt.url)) {
                        this.pwD.pww.put(zt.url, aVar2.pwX);
                    }
                    view.setTag(aVar2);
                    aVar = aVar2;
                }
            } else {
                aVar = aVar3;
            }
        }
        if (zt != null) {
            WalletOrderInfoOldUI$b walletOrderInfoOldUI$b = (WalletOrderInfoOldUI$b) WalletOrderInfoOldUI.c(this.pwD).get(zt.pji);
            x.i("MicroMsg.WalletOrderInfoOldUI", "try get result " + walletOrderInfoOldUI$b);
            if (walletOrderInfoOldUI$b != null) {
                aVar.pwW.setUrl(walletOrderInfoOldUI$b.bWP);
                aVar.eHU.setText(walletOrderInfoOldUI$b.bSc);
                aVar.pwX.setText(walletOrderInfoOldUI$b.pwk);
            } else {
                aVar.pwW.setUrl(zt.lRX);
                aVar.eHU.setText(zt.name);
                aVar.pwX.setText(zt.poG);
            }
            if (bi.oW(zt.lNW)) {
                aVar.pwX.setVisibility(0);
                if (aVar.pwY != null) {
                    aVar.pwY.setVisibility(8);
                }
            } else {
                aVar.pwX.setVisibility(8);
                if (aVar.pwY != null) {
                    aVar.pwY.setVisibility(0);
                    if (this.pwD.pvK.contains(zt.lNW)) {
                        aVar.pwY.setChecked(true);
                    } else {
                        aVar.pwY.setChecked(false);
                    }
                }
            }
            if (aVar.eBO != null && walletOrderInfoOldUI$b != null && !bi.oW(walletOrderInfoOldUI$b.title)) {
                aVar.eBO.setText(walletOrderInfoOldUI$b.title);
            } else if (aVar.eBO != null && !bi.oW(zt.title)) {
                aVar.eBO.setText(zt.title);
            } else if (aVar.eBO != null) {
                aVar.eBO.setVisibility(8);
            }
            if (!(bi.oW(this.pwD.ptj) || aVar.pwX == null)) {
                aVar.pwX.setClickable(this.pwD.bHS);
                aVar.pwX.setEnabled(this.pwD.bHS);
                aVar.pwX.setOnClickListener(null);
                if (this.pwD.bHT) {
                    aVar.pwX.setVisibility(8);
                }
            }
            fx = this.pwD.fx(zt.pji);
            if (fx.equals("0")) {
                aVar.pwX.setBackgroundColor(this.pwD.getResources().getColor(c.transparent));
                aVar.pwX.setTextColor(this.pwD.getResources().getColor(c.wechat_green));
            } else if (fx.equals("-1") || fx.equals("3")) {
                aVar.pwX.setBackgroundDrawable(this.pwD.getResources().getDrawable(e.btn_style_hollow_green));
                aVar.pwX.setTextColor(this.pwD.getResources().getColor(c.wechat_green));
            } else if (fx.equals("4") || fx.equals("2") || fx.equals("1")) {
                aVar.pwX.setBackgroundColor(this.pwD.getResources().getColor(c.transparent));
                aVar.pwX.setTextColor(this.pwD.getResources().getColor(c.hint_text_color));
            } else {
                x.e("MicroMsg.WalletOrderInfoOldUI", "PromotionsAdapter unknow award state");
            }
        }
        if (aVar.pwX != null) {
            int b = b.b(this.pwD.mController.tml, 15.0f);
            int b2 = b.b(this.pwD.mController.tml, 5.0f);
            aVar.pwX.setPadding(b, b2, b, b2);
        }
        return view;
    }
}
