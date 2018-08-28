package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.model.CardInfo;
import java.util.HashMap;
import java.util.Map;

public final class e {
    public Map<String, Object> htT = new HashMap();
    public CardInfo hts = null;

    public e() {
        this.htT.clear();
    }

    public final void putValue(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            this.htT.put(str, obj);
        }
    }

    public final Object getValue(String str) {
        if (!TextUtils.isEmpty(str) && this.htT.containsKey(str)) {
            return this.htT.get(str);
        }
        return null;
    }
}
