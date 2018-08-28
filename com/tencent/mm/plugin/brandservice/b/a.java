package com.tencent.mm.plugin.brandservice.b;

import android.content.Context;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.widget.TextView;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.protocal.c.qu;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.List;

public final class a {
    private static ag dvt = new ag(Looper.getMainLooper());

    public static d a(d dVar, qu quVar) {
        if (quVar != null) {
            dVar.field_brandFlag = quVar.eJV;
            dVar.field_brandIconURL = quVar.eJY;
            dVar.field_brandInfo = quVar.eJX;
            dVar.field_extInfo = quVar.eJW;
        }
        return dVar;
    }

    public static Spanned b(Context context, String str, List<String> list) {
        if (bi.oW(str)) {
            return null;
        }
        if (context == null || list == null) {
            return new SpannableString(str);
        }
        e a = f.a(com.tencent.mm.plugin.fts.a.a.d.a(str, list));
        return a.jrO instanceof Spannable ? (Spannable) a.jrO : new SpannableString(a.jrO);
    }

    public static boolean b(TextView textView, CharSequence charSequence) {
        if (textView == null) {
            return false;
        }
        if (charSequence == null || charSequence.length() == 0) {
            textView.setVisibility(8);
            return false;
        }
        textView.setVisibility(0);
        textView.setText(charSequence);
        return true;
    }
}
