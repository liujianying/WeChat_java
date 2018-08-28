package com.tencent.mm.plugin.offline.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

class WalletOfflineCoinPurseUI$28 implements c {
    final /* synthetic */ d eRB;
    final /* synthetic */ List kkU;
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;

    WalletOfflineCoinPurseUI$28(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI, List list, d dVar) {
        this.lMe = walletOfflineCoinPurseUI;
        this.kkU = list;
        this.eRB = dVar;
    }

    public final void a(l lVar) {
        for (int i = 0; i < this.kkU.size(); i++) {
            String str;
            CharSequence spannableString;
            String str2;
            CharSequence charSequence;
            Drawable c;
            Drawable drawable;
            boolean z;
            Bankcard bankcard = (Bankcard) this.kkU.get(i);
            String Jg = a.Jg(bankcard.field_bankcardType);
            if (bankcard.bOt() && bankcard.pmc != null) {
                Jg = bankcard.pmc.lCU;
            }
            Bitmap a = y.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(Jg));
            y.a(new 1(this, Jg, lVar));
            String str3 = "";
            if (!bi.oW(bankcard.field_forbidWord)) {
                str3 = bankcard.field_forbidWord;
            }
            if (!bi.oW(str3) || bankcard.field_support_micropay) {
                str = str3;
            } else {
                str = bi.oW(bankcard.field_no_micro_word) ? "" : bankcard.field_no_micro_word;
            }
            if (bi.oW(bankcard.field_forbid_title)) {
                spannableString = new SpannableString(str);
                str2 = str;
            } else {
                str = str + " ";
                spannableString = new SpannableString(str + bankcard.field_forbid_title);
                2 2 = new 2(this, this.lMe, bankcard);
                int length = str.length();
                int length2 = str.length() + bankcard.field_forbid_title.length();
                spannableString.setSpan(new ForegroundColorSpan(this.lMe.getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.wallet_offline_link_color)), length, length2, 33);
                spannableString.setSpan(2, length, length2, 33);
                str2 = str;
            }
            if ((bankcard.bOs() || bankcard.bOt()) && bankcard.plV >= 0.0d) {
                charSequence = bankcard.field_desc + this.lMe.getString(i.wallet_balance_left, new Object[]{e.B(bankcard.plV)});
            } else {
                charSequence = bankcard.field_desc;
            }
            if (bankcard.bOw()) {
                c = com.tencent.mm.svg.a.a.c(this.lMe.getResources(), h.honey_pay_bank_logo);
            } else if (a != null) {
                c = new BitmapDrawable(com.tencent.mm.sdk.platformtools.c.a(a, this.lMe.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.wxpay.a.d.wallet_offline_bank_logo_width), this.lMe.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.wxpay.a.d.wallet_offline_bank_logo_width), true, false));
            } else {
                c = null;
            }
            if (c == null) {
                WalletOfflineCoinPurseUI.J(this.lMe).put(Jg, Integer.valueOf(i));
            }
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "i %d fee %s %s", new Object[]{Integer.valueOf(i), charSequence, spannableString});
            CharSequence a2 = j.a(this.lMe.mController.tml, charSequence);
            if (c == null) {
                drawable = null;
            } else {
                drawable = c;
            }
            if (bi.oW(str2)) {
                z = false;
            } else {
                z = true;
            }
            lVar.a(i, a2, spannableString, drawable, z);
        }
    }
}
