package com.tencent.mm.plugin.subapp.ui.gallery;

import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.cb;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.k.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.s;

class GestureGalleryUI$6 implements d {
    final /* synthetic */ GestureGalleryUI osu;

    GestureGalleryUI$6(GestureGalleryUI gestureGalleryUI) {
        this.osu = gestureGalleryUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                if (bi.oW(GestureGalleryUI.b(this.osu))) {
                    x.w("MicroMsg.GestureGalleryUI", "share image to friend fail, imgPath is null");
                    return;
                } else if (o.Wf(GestureGalleryUI.b(this.osu))) {
                    EmojiInfo zi;
                    EmojiInfo zi2 = ((c) g.n(c.class)).getEmojiMgr().zi(com.tencent.mm.a.g.cu(GestureGalleryUI.b(this.osu)));
                    if (zi2 == null) {
                        zi = ((c) g.n(c.class)).getEmojiMgr().zi(((c) g.n(c.class)).getEmojiMgr().zj(GestureGalleryUI.b(this.osu)));
                    } else {
                        zi = zi2;
                    }
                    int cm = zi == null ? 0 : e.cm(zi.cnF());
                    String b = zi == null ? GestureGalleryUI.b(this.osu) : zi.cnF();
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    int i2;
                    if ((com.tencent.mm.sdk.platformtools.c.decodeFile(b, options) == null || options.outHeight <= b.Az()) && options.outWidth <= b.Az()) {
                        i2 = 0;
                    } else {
                        i2 = true;
                    }
                    if (cm > b.AA() || i2 != 0) {
                        h.a(this.osu.mController.tml, this.osu.getString(R.l.emoji_custom_gif_max_size_limit_cannot_send), "", this.osu.getString(R.l.i_know_it), null);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("Retr_File_Name", zi == null ? "" : zi.Xh());
                    intent.putExtra("Retr_Msg_Type", 5);
                    intent.putExtra("Retr_MsgImgScene", 1);
                    com.tencent.mm.plugin.subapp.b.ezn.l(intent, this.osu.mController.tml);
                    return;
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Retr_File_Name", GestureGalleryUI.b(this.osu));
                    intent2.putExtra("Retr_Compress_Type", 0);
                    intent2.putExtra("Retr_Msg_Type", 0);
                    com.tencent.mm.plugin.subapp.b.ezn.l(intent2, this.osu.mController.tml);
                    return;
                }
            case 2:
                if (GestureGalleryUI.b(this.osu) != null && !GestureGalleryUI.b(this.osu).equals("")) {
                    au.HU();
                    if (com.tencent.mm.model.c.isSDCardAvailable()) {
                        l.i(GestureGalleryUI.b(this.osu), this.osu);
                        return;
                    } else {
                        s.gH(this.osu);
                        return;
                    }
                }
                return;
            case 3:
                ch chVar = new ch();
                com.tencent.mm.pluginsdk.model.e.a(chVar, 1, GestureGalleryUI.b(this.osu));
                chVar.bJF.activity = this.osu;
                chVar.bJF.bJM = 32;
                a.sFg.m(chVar);
                return;
            case 4:
                x.i("MicroMsg.GestureGalleryUI", "request deal QBAR string");
                cb cbVar = new cb();
                cbVar.bJq.activity = this.osu;
                cbVar.bJq.bHL = GestureGalleryUI.e(this.osu);
                cbVar.bJq.bJr = GestureGalleryUI.d(this.osu);
                cbVar.bJq.bJs = GestureGalleryUI.h(this.osu);
                cbVar.bJq.scene = GestureGalleryUI.i(this.osu);
                cbVar.bJq.bJx = this.osu.getIntent().getBundleExtra("_stat_obj");
                a.sFg.m(cbVar);
                return;
            default:
                return;
        }
    }
}
