package com.tencent.mm.ipcinvoker.wx_extension;

import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper;

class b$2 implements c<IPCRunCgiRespWrapper> {
    final /* synthetic */ b$a dnl;

    b$2(b$a b_a) {
        this.dnl = b_a;
    }

    public final /* synthetic */ void at(Object obj) {
        IPCRunCgiRespWrapper iPCRunCgiRespWrapper = (IPCRunCgiRespWrapper) obj;
        if (this.dnl != null && iPCRunCgiRespWrapper != null) {
            this.dnl.a(iPCRunCgiRespWrapper.errType, iPCRunCgiRespWrapper.errCode, iPCRunCgiRespWrapper.Yy, iPCRunCgiRespWrapper.diG);
        }
    }
}
