package com.tencent.mm.plugin.bbom;

import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.c.ato;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bd;

public final class i implements l {
    private String hev = null;

    public i(String str) {
        this.hev = str;
    }

    public final void a(ato ato, bd bdVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<msgsource>");
        stringBuilder.append("<strangerantispamticket ticket=\"" + this.hev + "\"></strangerantispamticket>");
        stringBuilder.append(bi.oV(bf.Iq()));
        String str = (bi.oW(ato.rco) || !ato.rco.startsWith("<msgsource>")) ? "<msgsource></msgsource>" : ato.rco;
        ato.rco = str;
        ato.rco = ato.rco.replace("<msgsource>", stringBuilder.toString());
    }
}
