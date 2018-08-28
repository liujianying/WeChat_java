package com.tencent.mm.ui.widget.a;

import android.content.Context;
import com.tencent.mm.bw.a.i;

public final class e {
    static /* synthetic */ void a(Context context, c cVar, String str, String str2, boolean z, b bVar, b bVar2) {
        CharSequence str3;
        CharSequence str22;
        if (str3 == null || (str3 != null && str3.length() == 0)) {
            str3 = context.getResources().getString(i.button_ok);
        }
        if (str22 == null || (str22 != null && str22.length() == 0)) {
            str22 = context.getResources().getString(i.button_cancel);
        }
        cVar.a(str3, true, new 1(bVar, cVar));
        if (!z) {
            cVar.b(str22, true, new 2(bVar2));
        }
    }
}
