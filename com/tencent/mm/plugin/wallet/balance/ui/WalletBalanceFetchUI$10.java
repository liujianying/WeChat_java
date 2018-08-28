package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.List;

class WalletBalanceFetchUI$10 implements c {
    final /* synthetic */ WalletBalanceFetchUI pad;
    final /* synthetic */ List pah;
    final /* synthetic */ Context val$context;

    WalletBalanceFetchUI$10(WalletBalanceFetchUI walletBalanceFetchUI, List list, Context context) {
        this.pad = walletBalanceFetchUI;
        this.pah = list;
        this.val$context = context;
    }

    public final void a(l lVar) {
        int i = 0;
        for (Bankcard bankcard : this.pah) {
            CharSequence spannableString;
            String str;
            CharSequence spannableString2;
            Bitmap a;
            e h = b.h(this.val$context, bankcard.field_bankcardType, bankcard.bOr());
            String str2 = "";
            if (h != null) {
                str2 = h.lCU;
            }
            x.d("MicroMsg.WalletBalanceFetchUI", "logo url: %s", new Object[]{str2});
            Bitmap a2 = y.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(str2));
            str2 = "";
            if (!bi.oW(bankcard.field_forbidWord)) {
                str2 = bankcard.field_forbidWord;
            }
            if (bi.oW(bankcard.field_forbid_title)) {
                spannableString = new SpannableString(str2);
                str = str2;
            } else {
                String str3 = str2 + " ";
                spannableString2 = new SpannableString(str3 + bankcard.field_forbid_title);
                1 1 = new 1(this, this.val$context, bankcard);
                int length = str3.length();
                int length2 = str3.length() + bankcard.field_forbid_title.length();
                spannableString2.setSpan(new ForegroundColorSpan(this.val$context.getResources().getColor(a$c.wallet_offline_link_color)), length, length2, 33);
                spannableString2.setSpan(1, length, length2, 33);
                spannableString = spannableString2;
                str = str3;
            }
            if (bi.K(spannableString)) {
                spannableString = new SpannableString(bankcard.field_fetchArriveTimeWording);
            }
            spannableString2 = bankcard.field_desc;
            if (a2 != null) {
                a = com.tencent.mm.sdk.platformtools.c.a(a2, this.val$context.getResources().getDimensionPixelOffset(d.wallet_offline_bank_logo_width), this.val$context.getResources().getDimensionPixelOffset(d.wallet_offline_bank_logo_width), true, false);
            } else {
                a = null;
            }
            x.i("MicroMsg.WalletBalanceFetchUI", "i %d fee %s %s", new Object[]{Integer.valueOf(i), spannableString2, spannableString});
            int i2 = i + 1;
            lVar.a(i, spannableString2, spannableString, a == null ? null : new BitmapDrawable(a), !bi.oW(str));
            i = i2;
        }
        lVar.e(i, this.val$context.getString(i.wallet_balance_fetch_use_new_card));
    }
}
