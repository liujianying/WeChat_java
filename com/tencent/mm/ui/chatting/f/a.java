package com.tencent.mm.ui.chatting.f;

import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.Map;

public final class a extends com.tencent.mm.ap.a {
    public String tXR;
    public long tXS = 0;

    public a(Map<String, String> map, bd bdVar) {
        super(map, bdVar);
    }

    protected final boolean Qi() {
        if (this.values == null) {
            x.e("MicroMsg.InvokeMessageNewXmlMsg", "[parseXml] values == null ");
            return false;
        }
        if (this.values.containsKey(".sysmsg.invokeMessage.preContent")) {
            this.tXR = (String) this.values.get(".sysmsg.invokeMessage.preContent");
        }
        if (this.values.containsKey(".sysmsg.invokeMessage.timestamp")) {
            this.tXS = bi.WV((String) this.values.get(".sysmsg.invokeMessage.timestamp"));
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (String str : this.values.keySet()) {
            String str2;
            if (!str2.startsWith(".sysmsg.invokeMessage.text")) {
                if (str2.startsWith(".sysmsg.invokeMessage.link.text") && !bi.oW((String) this.values.get(str2))) {
                    str2 = (String) this.values.get(str2);
                    stringBuilder.append(str2);
                    this.ebH.add(str2);
                    i = str2.length();
                }
                i = i;
            } else if (stringBuilder.length() > 0) {
                stringBuilder.insert(0, (String) this.values.get(str2));
            } else {
                stringBuilder.append((String) this.values.get(str2));
            }
        }
        this.ebI.addFirst(Integer.valueOf(stringBuilder.length() - i));
        this.ebJ.add(Integer.valueOf(stringBuilder.length()));
        this.ebF = stringBuilder.toString();
        if (System.currentTimeMillis() - this.tXS >= 300000 && !bi.oW(this.tXR)) {
            e.post(new 1(this), "[checkExpired]");
        }
        return true;
    }
}
