package com.tencent.mm.ui.chatting.gallery;

import android.support.v4.view.ViewPager.e;
import android.view.View;
import com.tencent.mm.ak.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;

class ImageGalleryUI$5 implements e {
    final /* synthetic */ ImageGalleryUI tWn;
    private boolean tWo = false;

    ImageGalleryUI$5(ImageGalleryUI imageGalleryUI) {
        this.tWn = imageGalleryUI;
    }

    public final void a(int i, float f, int i2) {
    }

    public final void O(int i) {
        if (ImageGalleryUI.f(this.tWn) != null) {
            ImageGalleryUI.a(this.tWn, ImageGalleryUI.f(this.tWn).qC(i));
            ImageGalleryUI.a(this.tWn, ImageGalleryUI.f(this.tWn).qD(i));
            if (ImageGalleryUI.l(this.tWn) != null || ImageGalleryUI.m(this.tWn) == null) {
                ImageGalleryUI.b(this.tWn, false);
            } else {
                ImageGalleryUI.b(this.tWn, true);
            }
            View Ep = ImageGalleryUI.f(this.tWn).Ep(i);
            if (Ep == null) {
                x.e("MicroMsg.ImageGalleryUI", "onPageSelected the view is null, position = %s ", new Object[]{Integer.valueOf(i)});
            }
            ImageGalleryUI.r(this.tWn);
            ImageGalleryUI.e(this.tWn, i);
            if (ImageGalleryUI.f(this.tWn) != null) {
                b f = ImageGalleryUI.f(this.tWn);
                f.tTE.cwV();
                f.tTF.cwV();
                bd ES = ImageGalleryUI.f(this.tWn).ES(i);
                if (!((!b.bg(ES) && !b.bj(ES)) || Ep == null || Ep.getTag() == null)) {
                    if (ImageGalleryUI.B(this.tWn)) {
                        ((j) Ep.getTag()).tXn.crm();
                    } else {
                        ((j) Ep.getTag()).tXm.crm();
                    }
                }
                if (ES != null) {
                    this.tWn.gK(ES.field_msgId);
                }
                if (ImageGalleryUI.f(this.tWn) != null) {
                    com.tencent.mm.ak.e h = ImageGalleryUI.f(this.tWn).h(ES, false);
                    ImageGalleryUI.f(this.tWn);
                    if (b.a(ES, h)) {
                        h = f.a(h);
                        int i2 = h.dHI;
                        x.d("MicroMsg.ImageGalleryUI", "jacks loading hd from imgInfo : %d, time: %d", new Object[]{Integer.valueOf(Math.max(1, (int) (i2 != 0 ? ((((long) h.offset) * 100) / ((long) i2)) - 1 : 0))), Long.valueOf(System.currentTimeMillis())});
                        this.tWn.FG(r0);
                    } else if (ES == null || ES.cmj() || !ImageGalleryUI.f(this.tWn).bl(ES)) {
                        this.tWn.fm(true);
                    } else {
                        this.tWn.fm(false);
                    }
                } else {
                    x.e("MicroMsg.ImageGalleryUI", "[arthurdan.ImageGallery] Notice!!! adapter is null");
                }
                if (ES == null) {
                    x.e("MicroMsg.ImageGalleryUI", "update footer fail, msg is null, position = " + i);
                } else {
                    this.tWn.bz(ES);
                    ImageGalleryUI.g(this.tWn);
                }
            }
            if (ImageGalleryUI.f(this.tWn) != null) {
                ImageGalleryUI.f(this.tWn).O(i);
            }
        }
    }

    public final void N(int i) {
        x.d("MicroMsg.ImageGalleryUI", "onPageScrollStateChanged: %d", new Object[]{Integer.valueOf(i)});
        if (i == 2) {
            this.tWo = true;
            ImageGalleryUI.C(this.tWn);
            ImageGalleryUI.D(this.tWn);
            ImageGalleryUI.E(this.tWn);
        }
        if (i == 0) {
            if (this.tWo) {
                this.tWn.cxo();
            }
            this.tWo = false;
        }
        if (ImageGalleryUI.f(this.tWn) != null) {
            b f = ImageGalleryUI.f(this.tWn);
            if (f.tTD != null) {
                d dVar = f.tTD;
                dVar.if = i;
                if (dVar.tUQ != null) {
                    dVar.tUQ.N(i);
                }
            }
        }
    }
}
