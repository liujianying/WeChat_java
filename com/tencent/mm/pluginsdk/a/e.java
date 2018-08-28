package com.tencent.mm.pluginsdk.a;

import com.tencent.mm.ak.a.a;
import com.tencent.mm.protocal.c.bnv;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.u;
import java.util.ArrayList;
import java.util.List;

public interface e {
    String Gq();

    void a(bnv bnv);

    boolean a(EmojiGroupInfo emojiGroupInfo);

    byte[] a(EmojiInfo emojiInfo);

    bnv aDU();

    int aDV();

    ArrayList<EmojiGroupInfo> aDW();

    int aDX();

    ArrayList<EmojiInfo> aDY();

    a aDZ();

    boolean aEa();

    List<u> aEb();

    void aEc();

    void bg(String str, int i);

    EmojiInfo c(EmojiInfo emojiInfo);

    void g(j.a aVar);

    void h(j.a aVar);

    void i(j.a aVar);

    void j(j.a aVar);

    void k(j.a aVar);

    void l(j.a aVar);

    void onDestroy();

    String zf(String str);

    int zs(String str);

    ArrayList<EmojiInfo> zt(String str);
}
