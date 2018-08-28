package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import com.tencent.mm.a.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity.a;

class ax$2 implements a {
    final /* synthetic */ GameJsApiMMTask.a jGI;
    final /* synthetic */ ax jHy;

    ax$2(ax axVar, GameJsApiMMTask.a aVar) {
        this.jHy = axVar;
        this.jGI = aVar;
    }

    public final void b(int i, int i2, Intent intent) {
        x.i("MicroMsg.GameJsApiShareEmotion", "mmOnActivityResult, %d", new Object[]{Integer.valueOf(i)});
        if (i == (this.jHy.hashCode() & 65535)) {
            x.i("MicroMsg.GameJsApiShareEmotion", "share emmotion resultCode: %d", new Object[]{Integer.valueOf(i2)});
            switch (i2) {
                case -1:
                    EmojiInfo b;
                    String aG = bi.aG(intent.getStringExtra("Select_Conv_User"), "");
                    String aG2 = bi.aG(intent.getStringExtra("emoji_thumb_path"), "");
                    EmojiInfo Zy = i.aEA().igx.Zy(aG2);
                    if (Zy == null) {
                        au.HU();
                        String L = EmojiLogic.L(c.Gg(), "", aG2);
                        if (e.cn(L)) {
                            b = i.aEA().igx.b(aG2, "", EmojiInfo.tcB, o.Wf(L) ? EmojiInfo.tcJ : EmojiInfo.tcI, e.cm(L), "");
                            for (String str : bi.F(bi.aG(aG, "").split(","))) {
                                if (b != null) {
                                    i.aEw().a(str, b, null);
                                }
                            }
                            this.jGI.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("shareEmoticon:ok", null));
                            return;
                        }
                    }
                    b = Zy;
                    for (String str2 : bi.F(bi.aG(aG, "").split(","))) {
                        if (b != null) {
                            i.aEw().a(str2, b, null);
                        }
                    }
                    this.jGI.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("shareEmoticon:ok", null));
                    return;
                case 0:
                    this.jGI.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("shareEmoticon:ok", null));
                    return;
                default:
                    this.jGI.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("shareEmoticon:ok", null));
                    return;
            }
        }
    }
}
