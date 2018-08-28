package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.kernel.b.d;
import com.tencent.mm.protocal.c.wd;
import com.tencent.mm.protocal.c.wo;
import java.util.List;

public interface ae extends d {
    void checkFavItem(wo woVar);

    void checkFavItem(List<wd> list);

    r getCheckCdnService();

    u getEditService();

    o getFavCdnService();

    q getFavCdnStorage();

    s getFavConfigStorage();

    t getFavEditInfoStorage();

    x getFavItemInfoStorage();

    aa getFavSearchStorage();

    l getFavTagSetMgr();

    z getModService();

    ac getSendService();
}
