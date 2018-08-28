package com.tencent.mm.plugin.emoji.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.o;
import java.util.ArrayList;

public class EmotionContentProvider extends ContentProvider {
    private static final UriMatcher ijd;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        ijd = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.storage.provider.emotion", "EmojiGroupInfo", 1);
        ijd.addURI("com.tencent.mm.storage.provider.emotion", "userinfo", 2);
        ijd.addURI("com.tencent.mm.storage.provider.emotion", "GetEmotionListCache", 3);
        ijd.addURI("com.tencent.mm.storage.provider.emotion", "EmojiInfo", 4);
        ijd.addURI("com.tencent.mm.storage.provider.emotion", "EmojiInfoDesc", 5);
    }

    public boolean onCreate() {
        x.i("MicroMsg.EmotionContentProvider", "[onCreate]");
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.i("MicroMsg.EmotionContentProvider", "[query] path:%s selection:%s", uri.getPath(), str);
        switch (ijd.match(uri)) {
            case 1:
                au.HU();
                return c.FO().b(str, strArr2, 2);
            case 3:
                au.HU();
                return c.FO().b(str, strArr2, 2);
            case 4:
                au.HU();
                return c.FO().b(str, strArr2, 2);
            case 5:
                au.HU();
                return c.FO().b(str, strArr2, 2);
            default:
                return null;
        }
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        switch (ijd.match(uri)) {
            case 3:
                au.HU();
                return Uri.withAppendedPath(uri, String.valueOf(c.FO().insert("GetEmotionListCache", o.dhO.sKz, contentValues)));
            default:
                return uri;
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        switch (ijd.match(uri)) {
            case 3:
                au.HU();
                return c.FO().delete("GetEmotionListCache", str, strArr);
            default:
                return 0;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (!g.Eg().Dx()) {
            return -1;
        }
        switch (ijd.match(uri)) {
            case 1:
                au.HU();
                return c.FO().update("EmojiGroupInfo", contentValues, str, strArr);
            case 2:
                au.HU();
                c.DT().set(((Integer) contentValues.get("type")).intValue(), contentValues.get("value"));
                return 0;
            default:
                return -1;
        }
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        boolean z = true;
        x.d("MicroMsg.EmotionContentProvider", "[call] method:%s", str);
        Bundle bundle2;
        Bundle bundle3;
        Bundle bundle4;
        if (str.equals("getAccPath")) {
            bundle2 = new Bundle();
            bundle2.putString("path", g.Ei().dqp);
            return bundle2;
        } else if (str.equals("getEmojiKey")) {
            bundle2 = new Bundle();
            bundle2.putString("key", i.aEA().igx.getKey());
            return bundle2;
        } else if (str.equals("ConfigStorage.getBoolean")) {
            bundle3 = new Bundle();
            au.HU();
            bundle3.putBoolean("key", ((Boolean) c.DT().get(bundle.getInt("key"), Boolean.valueOf(false))).booleanValue());
            return bundle3;
        } else if (str.equals("ConfigStorage.getString")) {
            bundle4 = new Bundle();
            au.HU();
            bundle4.putString("key", (String) c.DT().get(bundle.getInt("key"), (Object) ""));
            return bundle4;
        } else if (str.equals("getAllCustomEmoji")) {
            bundle2 = new Bundle(EmojiInfo.class.getClassLoader());
            bundle2.putParcelableArrayList("data", i.aEA().aDY());
            return bundle2;
        } else {
            if (str.equals("getRamdomEmoji")) {
                if (bundle != null) {
                    bundle.setClassLoader(EmojiInfo.class.getClassLoader());
                    EmojiInfo emojiInfo = (EmojiInfo) bundle.getParcelable("emoji");
                    bundle3 = new Bundle(EmojiInfo.class.getClassLoader());
                    bundle3.putParcelable("data", ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().c(emojiInfo));
                    return bundle3;
                }
                String str3 = "MicroMsg.EmotionContentProvider";
                String str4 = "[getRamdomEmoji] extras:%s";
                Object[] objArr = new Object[1];
                if (bundle != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                x.e(str3, str4, objArr);
            } else if (str.equals("getCurLangDesc")) {
                bundle2 = new Bundle();
                bundle2.putString("data", i.aEv().zf(str2));
                return bundle2;
            } else if (str.equals("countCustomEmoji")) {
                bundle4 = new Bundle();
                bundle4.putInt("data", i.aEA().igx.ln(true));
                return bundle4;
            } else if (str.equals("countProductId")) {
                bundle2 = new Bundle();
                bundle2.putInt("data", i.aEA().igx.zs(str2));
                return bundle2;
            } else if (str.equals("getDownloadedCount")) {
                bundle2 = new Bundle();
                bundle2.putInt("data", i.aEA().aDX());
                return bundle2;
            } else if (str.equals("getEmojiListByGroupId")) {
                bundle4 = new Bundle(EmojiInfo.class.getClassLoader());
                bundle4.putParcelableArrayList("data", (ArrayList) ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zk(str2));
                return bundle4;
            } else if (str.equals("getEmojiGroupInfoList")) {
                bundle2 = new Bundle(EmojiGroupInfo.class.getClassLoader());
                bundle2.putParcelableArrayList("data", i.aEA().aDW());
                return bundle2;
            }
            return null;
        }
    }
}
