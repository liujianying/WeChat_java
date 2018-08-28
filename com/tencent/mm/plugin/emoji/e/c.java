package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;

public class c {
    public static c ifi;
    public ArrayList<String> ifj = new ArrayList();
    public boolean ifk = true;
    public boolean ifl = false;

    static /* synthetic */ void a(c cVar, Context context, EmojiInfo emojiInfo) {
        if (context != null && emojiInfo != null && !cVar.ifj.contains(emojiInfo.field_groupId)) {
            if (!aDK() || cVar.ifl) {
                if (aDK()) {
                    cVar.b(emojiInfo, false);
                    x.i("MicroMsg.emoji.EmojiFileCheckerMgr", "smiley pannel emotion broken. try to recover in mobile netword:%s", new Object[]{emojiInfo.field_groupId});
                    return;
                }
                cVar.b(emojiInfo, true);
                x.i("MicroMsg.emoji.EmojiFileCheckerMgr", "smiley pannel emotion broken. try to recover in wifi netword:%s", new Object[]{emojiInfo.field_groupId});
            } else if (cVar.ifk) {
                h.a(context, context.getString(R.l.emoji_store_recover_emotion), "", new 3(cVar, emojiInfo), new 4(cVar));
                cVar.ifk = false;
            } else {
                x.i("MicroMsg.emoji.EmojiFileCheckerMgr", "has alert recover.");
            }
        }
    }

    public static c aDJ() {
        if (ifi == null) {
            synchronized (c.class) {
                ifi = new c();
            }
        }
        return ifi;
    }

    public static void a(EmojiInfo emojiInfo, boolean z) {
        if (emojiInfo != null) {
            emojiInfo.field_reserved4 = 0;
            i.aEA().igx.q(emojiInfo);
            i.aEu().g(emojiInfo);
            if (z) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(231, 0, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.h.mEJ.a(231, 1, 1, false);
            }
        }
    }

    private void b(EmojiInfo emojiInfo, boolean z) {
        if (this.ifj == null) {
            this.ifj = new ArrayList();
        }
        this.ifj.add(emojiInfo.field_groupId);
        au.DF().a(new g(emojiInfo.field_groupId), 0);
        if (z) {
            com.tencent.mm.plugin.report.service.h.mEJ.a(231, 3, 1, false);
        } else {
            com.tencent.mm.plugin.report.service.h.mEJ.a(231, 2, 1, false);
        }
    }

    private static boolean aDK() {
        return ao.is3G(ad.getContext()) || ao.is4G(ad.getContext()) || ao.is2G(ad.getContext());
    }
}
