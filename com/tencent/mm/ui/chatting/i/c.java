package com.tencent.mm.ui.chatting.i;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.chatting.i.a.b;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;

public final class c extends a {
    public c(b bVar) {
        super(bVar);
    }

    final String cxK() {
        return "link_revoke";
    }

    final CharSequence a(Map<String, String> map, String str, WeakReference<Context> weakReference) {
        String str2 = (String) map.get(str + ".title");
        LinkedList linkedList = new LinkedList();
        int i = 0;
        while (true) {
            Object obj = str + ".usernamelist.username";
            if (i != 0) {
                obj = obj + i;
            }
            String str3 = (String) map.get(obj);
            if (bi.oW(str3)) {
                CharSequence spannableString = new SpannableString(str2);
                spannableString.setSpan(new 1(this, linkedList), 0, str2.length(), 33);
                return spannableString;
            }
            linkedList.add(str3);
            i++;
        }
    }
}
