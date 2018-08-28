package com.tencent.mm.ui.chatting.i;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.mm.ui.chatting.i.a.a;
import com.tencent.mm.ui.chatting.i.a.b;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class d extends a {
    public d(b bVar) {
        super(bVar);
    }

    final String cxK() {
        return "link_revoke_qrcode";
    }

    final CharSequence a(Map<String, String> map, String str, WeakReference<Context> weakReference) {
        String str2 = (String) map.get(str + ".title");
        a aVar = new a(this);
        aVar.username = (String) map.get(str + ".username");
        aVar.egr = (String) map.get(str + ".qrcode");
        CharSequence spannableString = new SpannableString(str2);
        spannableString.setSpan(new 1(this, aVar), 0, str2.length(), 33);
        return spannableString;
    }
}
