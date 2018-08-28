package com.tencent.mm.plugin.emoji;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.mm.br.f;
import com.tencent.mm.br.g;
import com.tencent.mm.pluginsdk.ui.d.j;

public final class a implements com.tencent.mm.plugin.emoji.b.a {
    public final SpannableString a(CharSequence charSequence, float f) {
        return g.cjL().a(charSequence, f);
    }

    public final SpannableString a(Context context, CharSequence charSequence, float f) {
        return j.a(context, charSequence, f);
    }

    public final String cp(String str, String str2) {
        g.cjL();
        f cjI = f.cjI();
        int i = 0;
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == '/' || charAt == '[') {
                f$a Xx = cjI.Xx(str.substring(i));
                if (Xx != null) {
                    stringBuilder.append(str2);
                    i += Xx.text.length();
                }
            }
            stringBuilder.append(charAt);
            i++;
        }
        return stringBuilder.toString();
    }

    public final boolean u(CharSequence charSequence) {
        return g.cjL().u(charSequence);
    }

    public final boolean v(CharSequence charSequence) {
        return g.cjL().v(charSequence);
    }
}
