package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ab.e;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;

public class a extends al {
    private static int iie = 0;
    private static a iif;
    private static q iig;
    private static e iih = new 1();

    public static final a aEF() {
        if (iif == null) {
            synchronized (a.class) {
                if (iif == null) {
                    iif = new a();
                }
            }
        } else {
            iif.SO();
        }
        return iif;
    }

    public static void aEG() {
        iie = 0;
        iig = new q("com.tencent.xin.emoticon.tusiji", 1);
        au.DF().a(iig, 0);
        au.DF().a(413, iih);
        x.d("MicroMsg.emoji.MockTuziDownloading", "add listener");
    }

    public final void aEH() {
        SO();
        i.aEC().g(com.tencent.mm.plugin.emoji.h.a.aGv(), 3, iie, "");
        aEI();
    }

    public static void aEI() {
        if (iig != null) {
            au.DF().c(iig);
        }
        au.DF().b(413, iih);
        x.d("MicroMsg.emoji.MockTuziDownloading", "remove listener");
    }

    private a() {
        super(new a(), true);
    }
}
