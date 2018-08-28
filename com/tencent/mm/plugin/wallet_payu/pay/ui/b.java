package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.a;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

public class b extends o {
    private b pFB;
    private int pFC = 0;
    private boolean pFD = false;
    private a pFE;

    public b(Context context) {
        super(context);
    }

    protected final void co(Context context) {
        et(context);
        super.eu(context);
        if (this.pxD != null) {
            this.pxD.setVisibility(8);
        }
    }

    protected final void eu(Context context) {
        super.eu(context);
    }

    public static b a(Context context, Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard, b bVar, OnClickListener onClickListener, OnCancelListener onCancelListener, boolean z) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        List bPV;
        String str;
        boolean z2;
        CharSequence charSequence;
        a a = com.tencent.mm.plugin.wallet_core.ui.b.psB.a(orders);
        if (a != null) {
            if (favorPayInfo != null) {
                if (!(bankcard == null || bankcard.field_bankcardType.equals(favorPayInfo.pnR))) {
                    String bb = a.bb(favorPayInfo.pnP, false);
                    a.a aVar = (a.a) a.ba(bb, true).get(bankcard.field_bankcardType);
                    if (aVar == null || aVar.psy == null || bi.oW(aVar.psy.pem)) {
                        favorPayInfo.pnP = bb;
                    } else {
                        favorPayInfo.pnP = aVar.psy.pem;
                    }
                }
            } else if (orders.ppg != null) {
                favorPayInfo = a.Pq(a.Pr(orders.ppg.pdY));
            }
            bPV = a.bPV();
        } else {
            x.d("MicroMsg.WalletPayUPwdDialog", "getFavorLogicHelper null");
            bPV = null;
        }
        Commodity commodity = (Commodity) orders.ppf.get(0);
        StringBuilder stringBuilder = new StringBuilder();
        if (bi.oW(commodity.lNK)) {
            str = "";
        } else {
            str = commodity.lNK + "\n";
        }
        String stringBuilder2 = stringBuilder.append(str).append(((Commodity) orders.ppf.get(0)).desc).toString();
        String str2 = null;
        String str3 = null;
        CharSequence charSequence2 = null;
        double d = orders.mBj;
        if (a == null || favorPayInfo == null) {
            z2 = false;
        } else {
            h Pn = a.Pn(favorPayInfo.pnP);
            if (Pn != null && Pn.pen > 0.0d) {
                z2 = true;
                double d2 = Pn.pdX;
                str3 = e.e(orders.mBj, orders.lNV);
                str2 = e.e(Pn.pdX, orders.lNV);
                charSequence2 = context.getString(i.wallet_pay_favor, new Object[]{e.A(Pn.pen)});
                d = d2;
            } else if (bPV == null || bPV.size() <= 0) {
                z2 = false;
                str2 = e.e(orders.mBj, orders.lNV);
            } else {
                z2 = true;
                Object charSequence22 = context.getString(i.wallet_pwd_dialog_more_favors);
            }
        }
        if (bankcard == null) {
            charSequence = "";
        } else {
            charSequence = bankcard.field_desc;
        }
        b bVar2 = new b(context);
        bVar2.pxC = bankcard;
        bVar2.a(context, orders, favorPayInfo, bankcard);
        bVar2.bQA();
        bVar2.a(onCancelListener);
        bVar2.setOnCancelListener(onCancelListener);
        bVar2.setCancelable(true);
        bVar2.Pu(stringBuilder2);
        bVar2.d(str2, d);
        bVar2.Pw(str3);
        bVar2.a(charSequence, onClickListener, z2);
        if (TextUtils.isEmpty(charSequence22)) {
            bVar2.pxn.setVisibility(8);
        } else {
            bVar2.pxn.setVisibility(0);
            bVar2.pxn.setText(charSequence22);
        }
        bVar2.pFD = z;
        bVar2.pxo.setEncrType(-10);
        bVar2.pFB = bVar;
        bVar2.show();
        com.tencent.mm.ui.base.h.a(context, bVar2);
        return bVar2;
    }

    protected final void bQv() {
        if (this.pxz != null) {
            this.pxz.onClick(this, 0);
        }
        dismiss();
        if (this.pFB == null) {
            return;
        }
        if (!this.pFD) {
            this.pFB.a(this.pxo.getText(), "", this.pfz);
        } else if (this.pFC == 0) {
            Context context = getContext();
            final a aVar = new a(this, this.pxo.getText(), this.pxC, this.pfz, this.pxA, this.DI, this.pxV, this.pFB);
            if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                b anonymousClass1 = new b(context) {
                    public final int bQz() {
                        int i = 3;
                        if (aVar.pFH != null && aVar.pFH.field_bankcardClientType == 1) {
                            x.d("MicroMsg.WalletPayUPwdDialog", "hy: the bankcard can be assembled to BankcardPayU");
                            i = new com.tencent.mm.plugin.wallet_core.model.a.b(aVar.pFH).pst;
                        }
                        if (i != 4) {
                            return g.payu_full_cvv_dialog;
                        }
                        x.d("MicroMsg.WalletPayUPwdDialog", "hy: is 4 digits cvv");
                        return g.payu_full_cvv_4_dialog;
                    }
                };
                anonymousClass1.pFC = 1;
                anonymousClass1.pFD = true;
                anonymousClass1.pFE = aVar;
                if (anonymousClass1.pFE != null) {
                    anonymousClass1.bQA();
                    anonymousClass1.a(anonymousClass1.pFE.pFL);
                    anonymousClass1.setOnCancelListener(anonymousClass1.pFE.pFL);
                    anonymousClass1.setCancelable(true);
                    anonymousClass1.d(anonymousClass1.pFE.pFH == null ? "" : anonymousClass1.pFE.pFH.field_desc, 0.0d);
                    anonymousClass1.jB(false);
                    anonymousClass1.pxV = anonymousClass1.pFE.pxV;
                    anonymousClass1.pFB = anonymousClass1.pFE.pFK;
                    anonymousClass1.pxo.setEncrType(30);
                    anonymousClass1.show();
                    com.tencent.mm.ui.base.h.a(context, anonymousClass1);
                }
            }
        } else if (this.pFC == 1) {
            this.pFB.a(this.pFE.pFG, this.pxo.getText(), this.pFE.pFI);
        } else {
            x.e("MicroMsg.WalletPayUPwdDialog", "hy: error dialog state");
        }
    }
}
