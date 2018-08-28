package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.s;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class h {
    private static final Drawable kXh = new ColorDrawable();
    private Activity activity;
    private String imagePath;
    private o kXg;
    private GetHdHeadImageGalleryView kXi;
    private int kXj;
    private int kXk;
    private String username;

    static /* synthetic */ void a(h hVar) {
        List arrayList = new ArrayList();
        arrayList.add(hVar.activity.getString(i.retransmits));
        arrayList.add(hVar.activity.getString(i.save_to_local));
        arrayList.add(hVar.activity.getString(i.plugin_favorite_opt));
        com.tencent.mm.ui.base.h.a(hVar.activity, null, (String[]) arrayList.toArray(new String[arrayList.size()]), "", new 2(hVar));
    }

    static /* synthetic */ void e(h hVar) {
        ch chVar = new ch();
        wl wlVar = new wl();
        vx vxVar = new vx();
        vxVar.CF(2);
        vxVar.UP(hVar.imagePath);
        LinkedList linkedList = new LinkedList();
        linkedList.add(vxVar);
        wlVar.ar(linkedList);
        chVar.bJF.bJH = wlVar;
        chVar.bJF.type = 2;
        chVar.bJF.activity = hVar.activity;
        chVar.bJF.bJM = 2;
        a.sFg.m(chVar);
    }

    public h(Activity activity, String str, String str2) {
        this(activity, str, str2, a.kXm);
    }

    private h(Activity activity, String str, String str2, int i) {
        this.kXk = 1;
        this.activity = activity;
        this.username = str;
        this.imagePath = str2;
        this.kXj = i;
    }

    public final void m(boolean z, int i) {
        x.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "previewImg readImgFromCache:" + z + ", sceneFromUI:" + i);
        View inflate = LayoutInflater.from(this.activity).inflate(g.wallet_get_hd_head_image_gallery_view, null);
        this.kXg = new o(inflate, -1, -1);
        this.kXg.setFocusable(true);
        this.kXg.setOutsideTouchable(true);
        this.kXg.setBackgroundDrawable(kXh);
        this.kXg.showAtLocation(this.activity.getWindow().getDecorView(), 49, 0, 0);
        this.kXi = (GetHdHeadImageGalleryView) inflate.findViewById(f.gallery);
        this.kXi.setParentWindow(this.kXg);
        this.kXi.setUsername(this.username);
        this.kXi.setHdHeadImagePath(this.imagePath);
        this.kXk = i;
        com.tencent.mm.kernel.g.Ek();
        Bitmap aE;
        if (com.tencent.mm.kernel.g.Ei().isSDCardAvailable()) {
            aE = com.tencent.mm.plugin.luckymoney.b.o.aE(this.imagePath, z);
            if (aE == null || aE.isRecycled()) {
                x.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "The image of %s is not in the cache, use default avatar", new Object[]{this.username});
            } else {
                x.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "The image of %s is in the cache", new Object[]{this.username});
                this.kXi.setHdHeadImage(aE);
            }
            this.kXi.setLongClickOverListener(new 1(this));
            return;
        }
        x.i("MicroMsg.LuckyMoneyPreviewImgGallaryView", "previewImg sdcard is not available!");
        s.gH(this.activity);
        aE = BitmapFactory.decodeResource(ad.getContext().getResources(), e.nosdcard_chatting_bg);
        try {
            Bitmap bitmap;
            if (aE.getWidth() >= 480 || aE.getWidth() <= 0) {
                bitmap = aE;
            } else {
                float width = 480.0f / ((float) aE.getWidth());
                Matrix matrix = new Matrix();
                matrix.postScale(width, width);
                bitmap = Bitmap.createBitmap(aE, 0, 0, aE.getWidth(), aE.getHeight(), matrix, true);
            }
            x.d("MicroMsg.LuckyMoneyPreviewImgGallaryView", "dkhdbm old[%d %d] new[%d %d]", new Object[]{Integer.valueOf(aE.getWidth()), Integer.valueOf(aE.getHeight()), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())});
            this.kXi.setHdHeadImage(bitmap);
            this.kXi.setHdHeadImagePath(null);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.LuckyMoneyPreviewImgGallaryView", e, "", new Object[0]);
        }
    }
}
