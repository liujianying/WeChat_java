package com.tencent.mm.br;

import android.text.SpannableString;
import com.tencent.mm.pluginsdk.ui.d.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public final class g implements d {
    private static g sMk;
    private int sMj = TbsListener$ErrorCode.ERROR_CODE_LOAD_BASE;

    private g() {
    }

    public static g cjL() {
        if (sMk == null) {
            sMk = new g();
        }
        return sMk;
    }

    public final SpannableString g(CharSequence charSequence, int i) {
        if (charSequence == null || bi.oW(charSequence.toString())) {
            return new SpannableString("");
        }
        if (charSequence == null || bi.oW(charSequence.toString())) {
            return new SpannableString("");
        }
        SpannableString spannableString = charSequence instanceof SpannableString ? (SpannableString) charSequence : new SpannableString(charSequence);
        PInt pInt = new PInt();
        pInt.value = this.sMj;
        return f.cjI().b(b.cjC().a(spannableString, i, pInt), i, pInt.value);
    }

    public final SpannableString a(CharSequence charSequence, float f) {
        if (charSequence == null || bi.oW(charSequence.toString())) {
            return new SpannableString("");
        }
        return g(charSequence, (int) f);
    }

    public final boolean v(CharSequence charSequence) {
        return f.cjI().Xx(charSequence.toString()) != null;
    }

    public final boolean u(CharSequence charSequence) {
        b.cjC();
        return b.Xv(charSequence.toString());
    }
}
