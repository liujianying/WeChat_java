package com.tencent.mm.ui.chatting.gallery;

import android.view.MenuItem;
import com.tencent.mm.g.a.cb;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.n.d;
import java.util.ArrayList;
import java.util.List;

class ImageGalleryUI$4 implements d {
    final /* synthetic */ ImageGalleryUI tWn;

    ImageGalleryUI$4(ImageGalleryUI imageGalleryUI) {
        this.tWn = imageGalleryUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        bd cwN;
        r nW;
        switch (menuItem.getItemId()) {
            case 0:
                cwN = ImageGalleryUI.f(this.tWn).cwN();
                if (cwN == null || !cwN.cmj()) {
                    ImageGalleryUI.f(this.tWn).Fn(this.tWn.jDB.getCurrentItem());
                    return;
                }
                nW = t.nW(cwN.field_imgPath);
                if (nW.status == 199 || nW.status == 199) {
                    ImageGalleryUI.f(this.tWn).Fn(this.tWn.jDB.getCurrentItem());
                    return;
                }
                ImageGalleryUI.b(this.tWn, t.e(cwN.field_msgId, 1));
                ImageGalleryUI.f(this.tWn).Fs(this.tWn.jDB.getCurrentItem());
                return;
            case 1:
                cwN = ImageGalleryUI.f(this.tWn).cwN();
                if (cwN == null || !cwN.cmj()) {
                    List arrayList = new ArrayList();
                    arrayList.add(ImageGalleryUI.f(this.tWn).cwN());
                    b.ehL.B((bd) arrayList.get(0));
                    b.e(this.tWn.mController.tml, arrayList);
                    return;
                }
                nW = t.nW(cwN.field_imgPath);
                if (nW.status == 199 || nW.status == 199) {
                    List arrayList2 = new ArrayList();
                    arrayList2.add(ImageGalleryUI.f(this.tWn).cwN());
                    b.e(this.tWn.mController.tml, arrayList2);
                    return;
                }
                ImageGalleryUI.b(this.tWn, t.e(cwN.field_msgId, 2));
                ImageGalleryUI.f(this.tWn).Fs(this.tWn.jDB.getCurrentItem());
                return;
            case 2:
                if (com.tencent.mm.bg.d.QS("favorite")) {
                    ImageGalleryUI.f(this.tWn).Fp(this.tWn.jDB.getCurrentItem());
                    return;
                }
                return;
            case 3:
                x.i("MicroMsg.ImageGalleryUI", "request deal QBAR string");
                cb cbVar = new cb();
                cbVar.bJq.activity = this.tWn;
                cbVar.bJq.bHL = ImageGalleryUI.c(this.tWn);
                cbVar.bJq.bJr = ImageGalleryUI.x(this.tWn);
                cbVar.bJq.bJs = ImageGalleryUI.y(this.tWn);
                cbVar.bJq.scene = 37;
                cbVar.bJq.bJx = this.tWn.getIntent().getBundleExtra("_stat_obj");
                ImageGalleryUI.a(this.tWn, cbVar);
                ImageGalleryUI.b(this.tWn, cbVar);
                a.sFg.m(cbVar);
                return;
            case 4:
                ImageGalleryUI.f(this.tWn).Fo(this.tWn.jDB.getCurrentItem());
                return;
            case 5:
                ImageGalleryUI.z(this.tWn);
                return;
            case 6:
                if (b.bg(ImageGalleryUI.f(this.tWn).cwN())) {
                    ImageGalleryUI.A(this.tWn);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
