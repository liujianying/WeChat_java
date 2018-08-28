package com.tencent.mm.plugin.music.model.e;

import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.storage.c;
import java.util.HashMap;
import java.util.Map;

public final class f {
    private static HashMap<Integer, Boolean> lzR = new HashMap();
    private static HashMap<Integer, Long> lzS = new HashMap();

    static {
        lzR.put(Integer.valueOf(0), Boolean.valueOf(false));
        lzR.put(Integer.valueOf(1), Boolean.valueOf(false));
        lzR.put(Integer.valueOf(4), Boolean.valueOf(false));
        lzR.put(Integer.valueOf(5), Boolean.valueOf(false));
        lzR.put(Integer.valueOf(6), Boolean.valueOf(false));
        lzR.put(Integer.valueOf(7), Boolean.valueOf(false));
        lzR.put(Integer.valueOf(8), Boolean.valueOf(false));
        lzR.put(Integer.valueOf(9), Boolean.valueOf(false));
        lzS.put(Integer.valueOf(0), Long.valueOf(0));
        lzS.put(Integer.valueOf(1), Long.valueOf(0));
        lzS.put(Integer.valueOf(4), Long.valueOf(0));
        lzS.put(Integer.valueOf(5), Long.valueOf(0));
        lzS.put(Integer.valueOf(6), Long.valueOf(0));
        lzS.put(Integer.valueOf(7), Long.valueOf(0));
        lzS.put(Integer.valueOf(8), Long.valueOf(0));
        lzS.put(Integer.valueOf(9), Long.valueOf(0));
    }

    public static boolean tI(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ((Long) lzS.get(Integer.valueOf(i))).longValue() < 10000) {
            return ((Boolean) lzR.get(Integer.valueOf(i))).booleanValue();
        }
        lzS.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
        c fJ = com.tencent.mm.model.c.c.Jx().fJ("100283");
        if (fJ.isValid()) {
            Map ckq = fJ.ckq();
            if (ckq == null) {
                x.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer args == null");
                return tJ(i);
            } else if (!ckq.containsKey("support_player_flag")) {
                x.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer not contain the support_player_flag key");
                return tJ(i);
            } else if (TextUtils.isEmpty((CharSequence) ckq.get("support_player_flag"))) {
                x.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer not contain the the value is empty");
                return tJ(i);
            } else {
                int intValue;
                boolean da;
                try {
                    intValue = Integer.valueOf((String) ckq.get("support_player_flag"), 16).intValue();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Music.MusicPlayerSwitcher", e, "supportQQMusicPlayer", new Object[0]);
                    intValue = 0;
                }
                x.i("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer contain support_player_flag:%s", new Object[]{r0});
                currentTimeMillis = ((Long) g.Ei().DT().get(a.sWr, Long.valueOf(0))).longValue();
                if (currentTimeMillis == 0) {
                    x.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is 0");
                    g.Ei().DT().a(a.sWr, Long.valueOf(fJ.field_sequence));
                    g.Ei().DT().a(a.sWq, Integer.valueOf(intValue));
                    da = da(i, intValue);
                } else if (currentTimeMillis == fJ.field_sequence) {
                    x.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is equal, check flag from local switch flag");
                    da = da(i, ((Integer) g.Ei().DT().get(a.sWq, Integer.valueOf(intValue))).intValue());
                } else {
                    x.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is diff, update local data");
                    g.Ei().DT().a(a.sWr, Long.valueOf(fJ.field_sequence));
                    g.Ei().DT().a(a.sWq, Integer.valueOf(intValue));
                    da = da(i, intValue);
                }
                lzR.put(Integer.valueOf(i), Boolean.valueOf(da));
                return da;
            }
        }
        x.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer item.isValid is false");
        return tJ(i);
    }

    private static boolean tJ(int i) {
        boolean da = da(i, ((Integer) g.Ei().DT().get(a.sWq, Integer.valueOf(0))).intValue());
        x.i("MicroMsg.Music.MusicPlayerSwitcher", "checkLocalSupportPlayerFlag support_player_flag:%s", new Object[]{Integer.toHexString(r0)});
        lzR.put(Integer.valueOf(i), Boolean.valueOf(da));
        return da;
    }

    private static boolean da(int i, int i2) {
        if (i == 0 && (i2 & 1) > 0) {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "support CHATTING_UI");
            return true;
        } else if (i == 1 && (i2 & 2) > 0) {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "support SNS_TIMELINE_UI");
            return true;
        } else if (i == 4 && (i2 & 4) > 0) {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "support SHAKE_MUSIC_UI");
            return true;
        } else if (i == 5 && (i2 & 8) > 0) {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "support PRODUCT_UI");
            return true;
        } else if (i == 6 && (i2 & 16) > 0) {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "support FAVORITE_UI");
            return true;
        } else if (i == 7 && (i2 & 32) > 0) {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "support WEBVIEW_UI");
            return true;
        } else if (i == 8 && (i2 & 64) > 0) {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "support SNS_USER_TIMELINE_UI");
            return true;
        } else if (i != 9 || (i2 & 128) <= 0) {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "QQMusicPlayer not support this scene %d", new Object[]{Integer.valueOf(i)});
            return false;
        } else {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "support SEARCH_TIMELINE_UI");
            return true;
        }
    }
}
