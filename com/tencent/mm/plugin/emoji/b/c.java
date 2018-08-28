package com.tencent.mm.plugin.emoji.b;

import com.tencent.mm.kernel.b.a;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.pluginsdk.a.e;

public interface c extends a {
    d getEmojiMgr();

    e getProvider();

    void removeEmojiMgr();

    void setEmojiMgr();
}
