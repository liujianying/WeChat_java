package com.tencent.mm.bo;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.pluginsdk.a.e;
import com.tencent.mm.protocal.c.bnv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class a implements e {
    public static a sCu = new a();
    public static b sCv = new b();
    public static c sCw = new c();
    private com.tencent.mm.ak.a.a iwt;
    private String sCq;
    private ArrayList<EmojiInfo> sCr = new ArrayList();
    private HashMap<String, ArrayList<EmojiInfo>> sCs = new HashMap();
    private ArrayList<EmojiGroupInfo> sCt = new ArrayList();

    public static class a {
    }

    public final String zf(String str) {
        if (((h) g.Ef().DM()).ES()) {
            return ((c) g.n(c.class)).getEmojiMgr().zf(str);
        }
        return ad.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getCurLangDesc", str, null).getString("data", "");
    }

    public final bnv aDU() {
        if (((h) g.Ef().DM()).ES()) {
            return ((c) g.n(c.class)).getEmojiMgr().aDU();
        }
        return null;
    }

    public final void a(bnv bnv) {
        if (((h) g.Ef().DM()).ES()) {
            ((c) g.n(c.class)).getEmojiMgr().a(bnv);
        }
    }

    public final int aDV() {
        if (((h) g.Ef().DM()).ES()) {
            return ((c) g.n(c.class)).getEmojiMgr().aDV();
        }
        return ad.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "countCustomEmoji", null, null).getInt("data", 0);
    }

    public final int zs(String str) {
        if (((h) g.Ef().DM()).ES()) {
            return ((c) g.n(c.class)).getEmojiMgr().zs(str);
        }
        return ad.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "countProductId", str, null).getInt("data", 0);
    }

    public final int aDX() {
        if (((h) g.Ef().DM()).ES()) {
            return ((c) g.n(c.class)).getEmojiMgr().aDX();
        }
        return ad.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getDownloadedCount", null, null).getInt("data", 0);
    }

    public final boolean a(EmojiGroupInfo emojiGroupInfo) {
        if (((h) g.Ef().DM()).ES()) {
            return ((c) g.n(c.class)).getEmojiMgr().a(emojiGroupInfo);
        }
        return false;
    }

    public final ArrayList<EmojiGroupInfo> aDW() {
        if (((h) g.Ef().DM()).ES()) {
            return ((c) g.n(c.class)).getEmojiMgr().aDW();
        }
        if (this.sCt.size() == 0) {
            Bundle call = ad.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getEmojiGroupInfoList", null, null);
            if (call != null) {
                call.setClassLoader(EmojiGroupInfo.class.getClassLoader());
                if (call.containsKey("data")) {
                    this.sCt.addAll(call.getParcelableArrayList("data"));
                    x.i("MicroMsg.EmotionStorageResolver", "[getEmojiGroupInfoListExport] size%s", new Object[]{Integer.valueOf(r0.size())});
                }
            }
        }
        return this.sCt;
    }

    public final ArrayList<EmojiInfo> aDY() {
        if (((h) g.Ef().DM()).ES()) {
            return ((c) g.n(c.class)).getEmojiMgr().aDY();
        }
        if (this.sCr.size() == 0) {
            Bundle call = ad.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getAllCustomEmoji", "false", null);
            if (call != null) {
                call.setClassLoader(EmojiInfo.class.getClassLoader());
                if (call.containsKey("data")) {
                    this.sCr.addAll(call.getParcelableArrayList("data"));
                    x.i("MicroMsg.EmotionStorageResolver", "[getAllCustomEmojiExport] size:%s", new Object[]{Integer.valueOf(r0.size())});
                }
            }
        }
        return this.sCr;
    }

    public final ArrayList<EmojiInfo> zt(String str) {
        if (((h) g.Ef().DM()).ES()) {
            return ((c) g.n(c.class)).getEmojiMgr().zt(str);
        }
        ArrayList<EmojiInfo> arrayList = (ArrayList) this.sCs.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.sCs.put(str, arrayList);
        }
        if (arrayList.size() != 0) {
            return arrayList;
        }
        Bundle call = ad.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getEmojiListByGroupId", str, null);
        if (call == null) {
            return arrayList;
        }
        call.setClassLoader(EmojiInfo.class.getClassLoader());
        if (!call.containsKey("data")) {
            return arrayList;
        }
        arrayList.addAll(call.getParcelableArrayList("data"));
        x.i("MicroMsg.EmotionStorageResolver", "[getEmojiListByGroupIdExport] size%s", new Object[]{Integer.valueOf(r1.size())});
        return arrayList;
    }

    public final com.tencent.mm.ak.a.a aDZ() {
        if (((h) g.Ef().DM()).ES()) {
            return ((c) g.n(c.class)).getEmojiMgr().aDZ();
        }
        if (this.iwt == null) {
            com.tencent.mm.ak.a.a.b.a aVar = new com.tencent.mm.ak.a.a.b.a(ad.getContext());
            aVar.dXl = new com.tencent.mm.view.d.a();
            this.iwt = new com.tencent.mm.ak.a.a(aVar.Ps());
        }
        return this.iwt;
    }

    public final void g(com.tencent.mm.sdk.e.j.a aVar) {
        if (((h) g.Ef().DM()).ES()) {
            ((c) g.n(c.class)).getEmojiMgr().g(aVar);
        }
    }

    public final byte[] a(EmojiInfo emojiInfo) {
        if (((h) g.Ef().DM()).ES()) {
            return ((c) g.n(c.class)).getEmojiMgr().a(emojiInfo);
        }
        if (emojiInfo == null) {
            x.w("MicroMsg.EmotionStorageResolver", "[decodeEmojiDataExport] failed. emoji is null.");
            return null;
        }
        String cnF = emojiInfo.cnF();
        Object e = com.tencent.mm.a.e.e(cnF, 0, com.tencent.mm.a.e.cm(cnF));
        if (com.tencent.mm.a.e.cm(cnF) <= 0 || e == null || e.length < 10) {
            x.i("MicroMsg.EmotionStorageResolver", "decode emoji file failed. path is no exist :%s ", new Object[]{cnF});
            return null;
        }
        Object obj = new byte[10];
        System.arraycopy(e, 0, obj, 0, 10);
        if ((emojiInfo.field_reserved4 & EmojiInfo.tcW) != EmojiInfo.tcW || o.bw(obj)) {
            return e;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int cm = com.tencent.mm.a.e.cm(cnF);
        if (cm > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            cm = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        }
        Object aesCryptEcb = !bi.oW(aDN()) ? AesEcb.aesCryptEcb(com.tencent.mm.a.e.e(cnF, 0, cm), aDN().getBytes(), false, false) : null;
        if (bi.bC(aesCryptEcb) || bi.bC(e)) {
            x.i("MicroMsg.EmotionStorageResolver", "decode emoji file failed. path:%s return original ", new Object[]{cnF});
            return e;
        }
        System.arraycopy(aesCryptEcb, 0, e, 0, cm);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        x.d("MicroMsg.EmotionStorageResolver", "decode emoji file length:%d use time:%d", new Object[]{Integer.valueOf(e.length), Long.valueOf(currentTimeMillis2)});
        return e;
    }

    public final void h(com.tencent.mm.sdk.e.j.a aVar) {
        if (((h) g.Ef().DM()).ES()) {
            ((c) g.n(c.class)).getEmojiMgr().h(aVar);
        }
    }

    public final void i(com.tencent.mm.sdk.e.j.a aVar) {
        if (((h) g.Ef().DM()).ES()) {
            ((c) g.n(c.class)).getEmojiMgr().i(aVar);
        }
    }

    public final void j(com.tencent.mm.sdk.e.j.a aVar) {
        if (((h) g.Ef().DM()).ES()) {
            ((c) g.n(c.class)).getEmojiMgr().j(aVar);
        }
    }

    public final EmojiInfo c(EmojiInfo emojiInfo) {
        if (((h) g.Ef().DM()).ES()) {
            return ((c) g.n(c.class)).getEmojiMgr().c(emojiInfo);
        }
        Bundle bundle = new Bundle(EmojiInfo.class.getClassLoader());
        bundle.putParcelable("emoji", emojiInfo);
        bundle = ad.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getRamdomEmoji", null, bundle);
        if (bundle == null) {
            x.e("MicroMsg.EmotionStorageResolver", "[getRamdomEmoji] bunndle is null! ");
            return null;
        }
        bundle.setClassLoader(EmojiInfo.class.getClassLoader());
        if (bundle.containsKey("data")) {
            return (EmojiInfo) bundle.getParcelable("data");
        }
        boolean z;
        String str = "MicroMsg.EmotionStorageResolver";
        String str2 = "[getRamdomEmoji] bundle is null?";
        Object[] objArr = new Object[1];
        if (bundle == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.e(str, str2, objArr);
        return null;
    }

    private static String aDN() {
        return ad.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getEmojiKey", null, null).getString("key", "");
    }

    public final String Gq() {
        if (((h) g.Ef().DM()).ES()) {
            this.sCq = ((c) g.n(c.class)).getEmojiMgr().Gq();
        } else if (bi.oW(this.sCq)) {
            this.sCq = ad.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/"), "getAccPath", null, null).getString("path");
        }
        return this.sCq;
    }

    public static a cgy() {
        return sCu;
    }

    public final void onDestroy() {
        this.sCt.clear();
    }

    public final boolean aEa() {
        if (((h) g.Ef().DM()).ES()) {
            return ((c) g.n(c.class)).getEmojiMgr().aEa();
        }
        return true;
    }

    public final void bg(String str, int i) {
        if (((h) g.Ef().DM()).ES()) {
            ((c) g.n(c.class)).getEmojiMgr().bg(str, i);
        }
    }

    public final List<u> aEb() {
        if (((h) g.Ef().DM()).ES()) {
            return ((c) g.n(c.class)).getEmojiMgr().aEb();
        }
        return null;
    }

    public final void aEc() {
        if (((h) g.Ef().DM()).ES()) {
            ((c) g.n(c.class)).getEmojiMgr().aEc();
        }
    }

    public final void k(com.tencent.mm.sdk.e.j.a aVar) {
        if (((h) g.Ef().DM()).ES()) {
            ((c) g.n(c.class)).getEmojiMgr().l(aVar);
        }
    }

    public final void l(com.tencent.mm.sdk.e.j.a aVar) {
        if (((h) g.Ef().DM()).ES()) {
            ((c) g.n(c.class)).getEmojiMgr().k(aVar);
        }
    }
}
