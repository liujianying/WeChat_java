package com.tencent.mm.plugin.wallet.balance.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.List;

class WalletBalanceSaveUI$4 implements c {
    final /* synthetic */ List kkU;
    final /* synthetic */ WalletBalanceSaveUI paK;
    final /* synthetic */ com.tencent.mm.ui.widget.c paL;

    WalletBalanceSaveUI$4(WalletBalanceSaveUI walletBalanceSaveUI, List list, com.tencent.mm.ui.widget.c cVar) {
        this.paK = walletBalanceSaveUI;
        this.kkU = list;
        this.paL = cVar;
    }

    public final void a(l lVar) {
        int size = this.kkU.size();
        for (int i = 0; i < size; i++) {
            String str;
            CharSequence spannableString;
            String str2;
            Bankcard bankcard = (Bankcard) this.kkU.get(i);
            String str3 = "";
            e h = b.h(this.paK, bankcard.field_bankcardType, bankcard.bOr());
            if (h != null) {
                str = h.lCU;
            } else {
                str = str3;
            }
            Bitmap a = y.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(str));
            y.a(new 1(this, str, lVar));
            Bitmap bitmap = null;
            str3 = "";
            if (!bi.oW(bankcard.field_forbidWord)) {
                str3 = bankcard.field_forbidWord;
            }
            if (bi.oW(bankcard.field_forbid_title)) {
                spannableString = new SpannableString(str3);
                str2 = str3;
            } else {
                str3 = str3 + " ";
                spannableString = new SpannableString(str3 + bankcard.field_forbid_title);
                2 2 = new 2(this, this.paK);
                int length = str3.length();
                int length2 = str3.length() + bankcard.field_forbid_title.length();
                spannableString.setSpan(new ForegroundColorSpan(this.paK.getResources().getColor(a$c.wallet_offline_link_color)), length, length2, 33);
                spannableString.setSpan(2, length, length2, 33);
                str2 = str3;
            }
            CharSequence charSequence = bankcard.field_desc;
            if (bankcard.bOs()) {
                x.i("MicroMsg.WalletBalanceSaveUI", "i %d fee %s %s", new Object[]{Integer.valueOf(i), charSequence, spannableString});
                lVar.a(i, charSequence, spannableString, this.paK.getResources().getDrawable(a.e.wallet_balance_manager_logo_small), !bi.oW(str2));
            } else {
                if (a != null) {
                    bitmap = com.tencent.mm.sdk.platformtools.c.a(a, this.paK.getResources().getDimensionPixelOffset(d.wallet_offline_bank_logo_width), this.paK.getResources().getDimensionPixelOffset(d.wallet_offline_bank_logo_width), true, false);
                }
                x.i("MicroMsg.WalletBalanceSaveUI", "i %d fee %s %s", new Object[]{Integer.valueOf(i), charSequence, spannableString});
                lVar.a(i, charSequence, spannableString, bitmap == null ? null : new BitmapDrawable(bitmap), !bi.oW(str2));
            }
            if (bitmap == null) {
                WalletBalanceSaveUI.d(this.paK).put(str, Integer.valueOf(i));
            }
        }
        lVar.a(size, this.paK.getString(i.wallet_balance_save_bind_new_card_to_save), "", this.paK.getResources().getDrawable(a.e.wallet_add_bankcard_icon), false);
    }
}
