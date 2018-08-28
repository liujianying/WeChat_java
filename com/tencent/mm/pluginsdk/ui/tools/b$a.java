package com.tencent.mm.pluginsdk.ui.tools;

import java.util.ArrayList;
import java.util.List;

class b$a {
    List<String> mSx;

    private b$a() {
        this.mSx = new ArrayList();
    }

    /* synthetic */ b$a(byte b) {
        this();
    }

    final String cfl() {
        if (this.mSx == null || this.mSx.size() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String append : this.mSx) {
            stringBuffer.append(append);
            stringBuffer.append(";");
        }
        return stringBuffer.toString();
    }

    final void KH(String str) {
        this.mSx = new ArrayList();
        if (str != null && str.length() != 0) {
            for (Object add : str.split(";")) {
                this.mSx.add(add);
            }
        }
    }
}
