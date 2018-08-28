package com.tencent.mm.plugin.topstory.a;

import com.tencent.mm.kernel.b.d;
import com.tencent.mm.protocal.c.bth;

public interface b extends d {
    e getRedDotMgr();

    f getReporter();

    void onVideoListUICreate();

    void onVideoListUIDestroy(bth bth);

    void onVideoListUIPause();

    void onVideoListUIResume();
}
