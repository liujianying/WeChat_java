package com.tencent.mm.ap;

import com.tencent.mm.storage.bd;
import java.util.Map;

public final class c extends a {
    public c(Map<String, String> map, bd bdVar) {
        super(map, bdVar);
    }

    protected final boolean Qi() {
        if (this.values != null && this.TYPE.equals("chatroommuteexpt")) {
            String str = (String) this.values.get(".sysmsg.chatroommuteexpt.link.text");
            String str2 = ((String) this.values.get(".sysmsg.chatroommuteexpt.text")) + str;
            this.ebH.add(str);
            this.ebI.addFirst(Integer.valueOf(str2.length() - str.length()));
            this.ebJ.add(Integer.valueOf(str2.length()));
            this.ebF = str2;
        }
        return false;
    }
}
