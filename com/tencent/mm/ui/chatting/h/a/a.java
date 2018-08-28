package com.tencent.mm.ui.chatting.h.a;

import android.text.Spannable;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.bd;

public class a {
    private static volatile a tYL = null;
    private static final ah tYM = new ah();

    private a() {
    }

    public static a cxI() {
        if (tYL != null) {
            return tYL;
        }
        a aVar;
        synchronized (a.class) {
            if (tYL == null) {
                tYL = new a();
            }
            aVar = tYL;
        }
        return aVar;
    }

    public static com.tencent.mm.ui.widget.MMTextView.a cxJ() {
        return a.tYN;
    }

    private static void a(CharSequence charSequence, bd bdVar, int i) {
        if (charSequence instanceof Spannable) {
            tYM.H(new b(charSequence, bdVar, i));
        }
    }

    public static void a(CharSequence charSequence, bd bdVar) {
        a(charSequence, bdVar, 1);
    }
}
