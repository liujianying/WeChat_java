package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.platformtools.x;

public class g$a {
    public Class<? extends u> Yw;
    public Class<? extends u> tON;

    public g$a(Class<? extends u> cls, Class<? extends u> cls2) {
        this.Yw = cls;
        this.tON = cls2;
    }

    public final u cuO() {
        try {
            return (u) this.tON.newInstance();
        } catch (Throwable e) {
            x.printErrStackTrace("ChattingComponentFactory", e, "", new Object[0]);
        } catch (Throwable e2) {
            x.printErrStackTrace("ChattingComponentFactory", e2, "", new Object[0]);
        }
        return null;
    }
}
