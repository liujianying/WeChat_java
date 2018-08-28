package com.tencent.mm.plugin.messenger.foundation.a;

import com.tencent.mm.kernel.b.a;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.bv;

public interface o extends a {
    b getBizTimeLineCallback();

    bv getSysCmdMsgExtension();

    void setBizTimeLineCallback(b bVar);

    void setIDataTransferFactoryDelegate(ai aiVar);
}
