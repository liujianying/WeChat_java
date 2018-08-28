package com.tencent.mm.storage.emotion;

import com.tencent.mm.bt.g;
import com.tencent.mm.bt.g.a;
import com.tencent.mm.bt.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

public final class f extends i<e> implements a {
    public static final String[] diD = new String[]{i.a(e.dhO, "EmojiSuggestDescInfo")};
    private e diF;

    public f(e eVar) {
        this(eVar, e.dhO, "EmojiSuggestDescInfo");
    }

    private f(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.diF = eVar;
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.diF = gVar;
        }
        return 0;
    }

    public final boolean ad(ArrayList<ArrayList<String>> arrayList) {
        if (arrayList.isEmpty()) {
            x.i("MicroMsg.emoji.EmojiDescMapStorage", "group list is null.");
        } else {
            long dO;
            h hVar;
            if (this.diF instanceof h) {
                h hVar2 = (h) this.diF;
                dO = hVar2.dO(Thread.currentThread().getId());
                hVar = hVar2;
            } else {
                dO = -1;
                hVar = null;
            }
            this.diF.delete("EmojiSuggestDescInfo", "", null);
            Iterator it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                ArrayList arrayList2 = (ArrayList) it.next();
                if (!(arrayList2 == null || arrayList2.isEmpty())) {
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        String str = (String) it2.next();
                        if (!bi.oW(str)) {
                            x.d("MicroMsg.emoji.EmojiDescMapStorage", "insert groupID%s, word:%s", new Object[]{String.valueOf(i), str});
                            b(new e(String.valueOf(i), str));
                        }
                    }
                    i++;
                }
                i = i;
            }
            if (hVar != null) {
                hVar.gp(dO);
            }
        }
        return false;
    }
}
