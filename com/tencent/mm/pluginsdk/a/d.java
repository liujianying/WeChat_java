package com.tencent.mm.pluginsdk.a;

import android.content.Context;
import com.tencent.mm.ab.d.a;
import com.tencent.mm.ar.f;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.storage.emotion.s;
import java.util.ArrayList;
import java.util.List;

public interface d extends e {
    String a(Context context, WXMediaMessage wXMediaMessage, String str);

    void a(Context context, bd bdVar);

    void a(String str, EmojiInfo emojiInfo, bd bdVar);

    boolean a(Context context, EmojiInfo emojiInfo, int i, String str);

    boolean a(String str, String str2, long j, String str3, a aVar);

    byte[] a(EmojiInfo emojiInfo);

    boolean aDP();

    ArrayList<q> aDQ();

    ArrayList<String> aDR();

    ArrayList<s> aDS();

    f aDT();

    ap cu(String str, String str2);

    String cv(String str, String str2);

    void d(EmojiInfo emojiInfo);

    int e(EmojiInfo emojiInfo);

    int[] f(EmojiInfo emojiInfo);

    boolean o(Context context, String str, String str2);

    boolean p(ArrayList<q> arrayList);

    boolean q(ArrayList<s> arrayList);

    EmojiInfo zi(String str);

    String zj(String str);

    List<EmojiInfo> zk(String str);

    boolean zl(String str);

    ArrayList<String> zm(String str);

    String zn(String str);

    String zo(String str);

    int zp(String str);

    String zq(String str);

    void zr(String str);
}
