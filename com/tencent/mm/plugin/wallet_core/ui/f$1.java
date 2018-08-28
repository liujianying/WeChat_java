package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.d;
import java.util.HashMap;
import java.util.List;

class f$1 implements c {
    final /* synthetic */ List pah;
    final /* synthetic */ boolean psO = false;
    final /* synthetic */ HashMap vLQ;
    final /* synthetic */ d vLR;
    final /* synthetic */ Context val$context;

    f$1(List list, Context context, HashMap hashMap, d dVar) {
        this.pah = list;
        this.val$context = context;
        this.vLQ = hashMap;
        this.vLR = dVar;
    }

    public final void a(l lVar) {
        int i = 0;
        for (Bankcard bankcard : this.pah) {
            String str;
            CharSequence spannableString;
            String str2;
            CharSequence spannableString2;
            e eVar = null;
            if (bankcard.bOt()) {
                Bankcard bankcard2 = o.bOW().prG;
                if (bankcard2 != null) {
                    eVar = bankcard2.pmc;
                }
            } else {
                eVar = b.h(this.val$context, bankcard.field_bankcardType, bankcard.bOr());
            }
            String str3 = "";
            if (eVar != null) {
                str = eVar.lCU;
            } else {
                str = str3;
            }
            x.d("MicroMsg.WalletBankcardBottomSheetHelper", "logo url: %s", new Object[]{str});
            Bitmap a = y.a(new com.tencent.mm.plugin.wallet_core.ui.view.c(str));
            y.a(new 1(this, str, lVar));
            String str4 = "";
            if (!bi.oW(bankcard.field_forbidWord)) {
                str4 = bankcard.field_forbidWord;
            }
            if (bi.oW(bankcard.field_forbid_title)) {
                spannableString = new SpannableString(str4);
                str2 = str4;
            } else {
                str2 = str4 + " ";
                spannableString2 = new SpannableString(str2 + bankcard.field_forbid_title);
                2 2 = new 2(this, this.val$context, bankcard);
                int length = str2.length();
                int length2 = str2.length() + bankcard.field_forbid_title.length();
                spannableString2.setSpan(new ForegroundColorSpan(this.val$context.getResources().getColor(a.c.wallet_offline_link_color)), length, length2, 33);
                spannableString2.setSpan(2, length, length2, 33);
                spannableString = spannableString2;
            }
            if (this.psO && bi.K(r3) && !bi.oW(bankcard.field_fetchArriveTimeWording)) {
                spannableString = new SpannableString(bankcard.field_fetchArriveTimeWording);
            }
            spannableString2 = bankcard.field_desc;
            if (a != null) {
                a = com.tencent.mm.sdk.platformtools.c.a(a, this.val$context.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), this.val$context.getResources().getDimensionPixelOffset(a.d.wallet_offline_bank_logo_width), true, false);
            } else {
                a = null;
            }
            if (a == null) {
                this.vLQ.put(str, Integer.valueOf(i));
            }
            x.i("MicroMsg.WalletBankcardBottomSheetHelper", "i %d fee %s %s", new Object[]{Integer.valueOf(i), spannableString2, spannableString});
            int i2;
            if (bankcard.bOs()) {
                boolean z;
                i2 = i + 1;
                Drawable drawable = this.val$context.getResources().getDrawable(a$e.wallet_balance_manager_logo_small);
                if (bi.oW(str2)) {
                    z = false;
                } else {
                    z = true;
                }
                lVar.a(i, spannableString2, spannableString, drawable, z);
                i = i2;
            } else {
                i2 = i + 1;
                lVar.a(i, spannableString2, spannableString, a == null ? null : new BitmapDrawable(a), !bi.oW(str2));
                i = i2;
            }
        }
    }
}
