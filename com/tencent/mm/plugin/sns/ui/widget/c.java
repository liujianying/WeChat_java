package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mm.bp.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.pluginsdk.ui.d.o;
import com.tencent.mm.protocal.c.bon;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

public final class c {
    public static CharSequence a(Context context, bon bon, av avVar, int i, String str) {
        String str2;
        String str3 = "";
        String a = a(bon);
        CharSequence charSequence = null;
        CharSequence charSequence2 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = i == 21 ? 3 : 2;
        String str4 = bon.jSA;
        ab abVar = null;
        if (!bi.oW(str)) {
            g.Ek();
            abVar = ((i) g.l(i.class)).FR().Ye(str);
        }
        String BL;
        if (bon.smm == 1) {
            if (abVar != null) {
                BL = (abVar == null || TextUtils.isEmpty(abVar.BL())) ? str : abVar.BL();
                String str5 = a + context.getString(i$j.sns_at);
                i3 = str5.length();
                str2 = str5 + BL;
                charSequence = BL;
            } else {
                x.w("SnsCommentUtil", "feedContact null by feedOwnUserName %s", new Object[]{str});
                str2 = a;
            }
        } else if (bi.oW(bon.smB)) {
            str2 = a;
        } else {
            abVar = af.byc().Yf(bon.smB);
            BL = abVar == null ? bon.smB : abVar.BL();
            String str6 = a + context.getString(i$j.sns_reply);
            i2 = str6.length();
            str2 = str6 + BL;
            Object charSequence22 = BL;
        }
        SpannableString a2 = j.a(context, (str3 + str2 + ": ") + str4, a.fromDPToPix(context, (int) (15.0f * a.fe(context))), 2);
        int i5 = i == 21 ? 3 : 2;
        g.Ek();
        ((i) g.l(i.class)).FR().Ye(bon.rdS);
        k kVar = new k(a2);
        kVar.a(new o(bon.rdS, avVar.nUh, i5), a, 0);
        if (charSequence != null) {
            kVar.a(new o(str, avVar.nUh, i4), charSequence, i3);
        } else if (charSequence22 != null) {
            kVar.a(new o(bon.smB, avVar.nUh, i4), charSequence22, i2);
        }
        return kVar;
    }

    public static String a(bon bon) {
        ab Yf = af.byc().Yf(bon.rdS);
        if (Yf != null) {
            return Yf.BL();
        }
        return bon.rTW != null ? bon.rTW : bon.rdS;
    }
}
