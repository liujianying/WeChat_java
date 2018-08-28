package com.tencent.mm.plugin.wallet_core.id_verify;

import android.text.SpannableString;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.ui.h;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

class a$3 extends g {
    final /* synthetic */ a pjX;

    a$3(a aVar, MMActivity mMActivity, i iVar) {
        this.pjX = aVar;
        super(mMActivity, iVar);
    }

    public final CharSequence ui(int i) {
        if (i != 0) {
            return null;
        }
        String string = this.fEY.getString(a.i.wallet_real_name_verify_cur_verify_id_tip);
        String string2 = this.fEY.getString(a.i.wallet_real_name_verify_change_to_bindcard);
        string = this.fEY.getString(a.i.wallet_real_name_verify_tip, new Object[]{string, string2});
        h hVar = new h(this.fEY);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(hVar, string.length() - string2.length(), string.length(), 33);
        return spannableString.subSequence(0, spannableString.length());
    }

    public final boolean m(Object... objArr) {
        return false;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }
}
