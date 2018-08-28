package com.tencent.mm.plugin.scanner;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.i;
import java.util.Iterator;
import java.util.Set;

class a$a implements i<Bundle, Bundle> {
    private a$a() {
    }

    public final /* synthetic */ Object av(Object obj) {
        Bundle bundle = new Bundle();
        Set brX = a.brX();
        StringBuilder stringBuilder = new StringBuilder();
        if (!(brX == null || brX.isEmpty())) {
            Iterator it = brX.iterator();
            stringBuilder.append((String) it.next());
            while (it.hasNext()) {
                stringBuilder.append("|");
                stringBuilder.append((String) it.next());
            }
            bundle.putString("wxCodePrefix", stringBuilder.toString());
        }
        return bundle;
    }
}
