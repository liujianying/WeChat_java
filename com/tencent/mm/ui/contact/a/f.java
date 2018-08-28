package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.mm.plugin.fts.ui.b.b;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.ui.contact.a.a.a;

public final class f extends a {
    private CharSequence jyi;
    private a$b umH = new b(this);
    a umI = new a(this);

    public f(int i) {
        super(5, i);
    }

    public final void ck(Context context) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (Object obj : this.jrx.jrX) {
            CharSequence spannableString = new SpannableString(obj);
            spannableString.setSpan(new ForegroundColorSpan(b.jvr), 0, obj.length(), 33);
            spannableStringBuilder.append(spannableString);
            spannableStringBuilder.append("、");
        }
        this.jyi = TextUtils.concat(new CharSequence[]{context.getString(h.select_contact_create_desc_prefix), spannableStringBuilder.subSequence(0, spannableStringBuilder.length() - 1), context.getString(h.select_contact_create_desc_prefix)});
    }

    public final a$b Wg() {
        return this.umH;
    }

    protected final a Wh() {
        return this.umI;
    }
}
