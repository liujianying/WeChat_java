package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.wallet.balance.a.a.i;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.protocal.c.arq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.d;
import java.util.List;

class WalletLqtSaveFetchUI$13 implements c {
    final /* synthetic */ d eRB;
    final /* synthetic */ List kkU;
    final /* synthetic */ WalletLqtSaveFetchUI pcc;

    WalletLqtSaveFetchUI$13(WalletLqtSaveFetchUI walletLqtSaveFetchUI, List list, d dVar) {
        this.pcc = walletLqtSaveFetchUI;
        this.kkU = list;
        this.eRB = dVar;
    }

    public final void a(l lVar) {
        int size = this.kkU.size();
        for (int i = 0; i < size; i++) {
            String str;
            CharSequence spannableString;
            String str2;
            Bankcard bankcard = (Bankcard) this.kkU.get(i);
            String str3 = "";
            e h = b.h(this.pcc, bankcard.field_bankcardType, bankcard.bOr());
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
                2 2 = new 2(this, this.pcc);
                int length = str3.length();
                int length2 = str3.length() + bankcard.field_forbid_title.length();
                spannableString.setSpan(new ForegroundColorSpan(this.pcc.getResources().getColor(a.c.wallet_offline_link_color)), length, length2, 33);
                spannableString.setSpan(2, length, length2, 33);
                str2 = str3;
            }
            CharSequence charSequence = bankcard.field_desc;
            if (bankcard.bOs()) {
                x.i("MicroMsg.WalletLqtSaveFetchUI", "i %d fee %s %s", new Object[]{Integer.valueOf(i), charSequence, spannableString});
                lVar.a(i, charSequence, spannableString, this.pcc.getResources().getDrawable(a.e.wallet_balance_manager_logo_small), !bi.oW(str2));
            } else {
                if (a != null) {
                    bitmap = com.tencent.mm.sdk.platformtools.c.a(a, this.pcc.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), this.pcc.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false);
                }
                x.i("MicroMsg.WalletLqtSaveFetchUI", "i %d fee %s %s", new Object[]{Integer.valueOf(i), charSequence, spannableString});
                lVar.a(i, charSequence, spannableString, bitmap == null ? null : new BitmapDrawable(bitmap), !bi.oW(str2));
            }
            if (bitmap == null) {
                WalletLqtSaveFetchUI.f(this.pcc).put(str, Integer.valueOf(i));
            }
        }
        i iVar = i.oYM;
        boolean z = WalletLqtSaveFetchUI.g(this.pcc) == 1;
        iVar.jf(z);
        arq arq = z ? iVar.oYG : iVar.oYH;
        if (arq != null ? arq.rTS : false) {
            x.i("MicroMsg.WalletLqtSaveFetchUI", "isNoSupportLqtBank");
        } else if (WalletLqtSaveFetchUI.g(this.pcc) == 1) {
            lVar.a(size, this.pcc.getString(a.i.wallet_lqt_save_new_card), "", this.pcc.getResources().getDrawable(a.e.wallet_add_bankcard_icon), false);
        } else if (WalletLqtSaveFetchUI.g(this.pcc) == 2) {
            lVar.a(size, this.pcc.getString(a.i.wallet_lqt_fetch_new_card), "", this.pcc.getResources().getDrawable(a.e.wallet_add_bankcard_icon), false);
        }
    }
}
