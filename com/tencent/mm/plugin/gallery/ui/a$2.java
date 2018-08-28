package com.tencent.mm.plugin.gallery.ui;

import android.view.View.OnClickListener;

class a$2 implements OnClickListener {
    final /* synthetic */ a jBH;

    a$2(a aVar) {
        this.jBH = aVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r10) {
        /*
        r9 = this;
        r2 = 1;
        r3 = 0;
        r0 = com.tencent.mm.R.h.media_cbx_clickarea;
        r0 = r10.getTag(r0);
        r0 = (java.lang.Integer) r0;
        r1 = r9.jBH;
        r1 = com.tencent.mm.plugin.gallery.ui.a.a(r1);
        r4 = r0.intValue();
        r1 = r1.get(r4);
        r1 = (com.tencent.mm.plugin.gallery.model.GalleryItem$MediaItem) r1;
        if (r1 != 0) goto L_0x0026;
    L_0x001c:
        r0 = "MicroMsg.AlbumAdapter";
        r1 = "[onClick] null == item!";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
    L_0x0025:
        return;
    L_0x0026:
        r4 = "MicroMsg.AlbumAdapter";
        r5 = new java.lang.StringBuilder;
        r6 = "click Image path:";
        r5.<init>(r6);
        r6 = r1.egA;
        r5 = r5.append(r6);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.x.i(r4, r5);
        r4 = r9.jBH;
        r4 = com.tencent.mm.plugin.gallery.ui.a.b(r4);
        r4 = r4.contains(r1);
        if (r4 == 0) goto L_0x00a3;
    L_0x004a:
        r4 = r9.jBH;
        r4 = com.tencent.mm.plugin.gallery.ui.a.b(r4);
        r4.indexOf(r1);
        r4 = r9.jBH;
        r4 = com.tencent.mm.plugin.gallery.ui.a.b(r4);
        r4.remove(r1);
        r1 = r2;
        r4 = r3;
    L_0x005e:
        if (r4 != 0) goto L_0x0163;
    L_0x0060:
        r4 = r9.jBH;
        r4 = com.tencent.mm.plugin.gallery.ui.a.f(r4);
        if (r4 == 0) goto L_0x007d;
    L_0x0068:
        r4 = r9.jBH;
        r4 = com.tencent.mm.plugin.gallery.ui.a.f(r4);
        r5 = r9.jBH;
        r5 = r5.jBA;
        r5 = r5.size();
        r0 = r0.intValue();
        r4.J(r5, r0, r1);
    L_0x007d:
        if (r2 != r1) goto L_0x0201;
    L_0x007f:
        r0 = com.tencent.mm.R.h.media_cbx;
        r0 = r10.getTag(r0);
        r0 = (android.widget.CheckBox) r0;
        r0.setChecked(r3);
        r0 = com.tencent.mm.R.h.media_mask;
        r0 = r10.getTag(r0);
        r0 = (android.view.View) r0;
        r0.setVisibility(r3);
        r0 = com.tencent.mm.R.h.media_mask;
        r0 = r10.getTag(r0);
        r0 = (android.view.View) r0;
        r1 = com.tencent.mm.R.e.image_gallery_mask;
        r0.setBackgroundResource(r1);
        goto L_0x0025;
    L_0x00a3:
        r4 = com.tencent.mm.plugin.gallery.model.c.aRf();
        r4 = r4.aRI();
        r5 = 3;
        if (r4 != r5) goto L_0x013b;
    L_0x00ae:
        if (r1 == 0) goto L_0x013b;
    L_0x00b0:
        r4 = r1.mMimeType;
        r5 = "image/gif";
        r4 = r4.equalsIgnoreCase(r5);
        if (r4 == 0) goto L_0x013b;
    L_0x00bb:
        r4 = new com.tencent.mm.plugin.gif.e;
        r5 = r1.egA;
        r4.<init>(r5);
        r5 = r1.egA;
        r5 = com.tencent.mm.a.e.cm(r5);
        if (r5 == 0) goto L_0x00d6;
    L_0x00ca:
        r6 = r9.jBH;	 Catch:{ Exception -> 0x012e }
        r6 = com.tencent.mm.plugin.gallery.ui.a.c(r6);	 Catch:{ Exception -> 0x012e }
        r6 = r6.AA();	 Catch:{ Exception -> 0x012e }
        if (r5 > r6) goto L_0x00f8;
    L_0x00d6:
        r6 = r4.khG;	 Catch:{ Exception -> 0x012e }
        r7 = 0;
        r6 = r6[r7];	 Catch:{ Exception -> 0x012e }
        r7 = r9.jBH;	 Catch:{ Exception -> 0x012e }
        r7 = com.tencent.mm.plugin.gallery.ui.a.c(r7);	 Catch:{ Exception -> 0x012e }
        r7 = r7.Az();	 Catch:{ Exception -> 0x012e }
        if (r6 > r7) goto L_0x00f8;
    L_0x00e7:
        r4 = r4.khG;	 Catch:{ Exception -> 0x012e }
        r6 = 1;
        r4 = r4[r6];	 Catch:{ Exception -> 0x012e }
        r6 = r9.jBH;	 Catch:{ Exception -> 0x012e }
        r6 = com.tencent.mm.plugin.gallery.ui.a.c(r6);	 Catch:{ Exception -> 0x012e }
        r6 = r6.Az();	 Catch:{ Exception -> 0x012e }
        if (r4 <= r6) goto L_0x013b;
    L_0x00f8:
        r0 = r9.jBH;	 Catch:{ Exception -> 0x012e }
        r0 = com.tencent.mm.plugin.gallery.ui.a.c(r0);	 Catch:{ Exception -> 0x012e }
        r1 = 13459; // 0x3493 float:1.886E-41 double:6.6496E-320;
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x012e }
        r2.<init>();	 Catch:{ Exception -> 0x012e }
        r2 = r2.append(r5);	 Catch:{ Exception -> 0x012e }
        r3 = ",1,,0";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x012e }
        r2 = r2.toString();	 Catch:{ Exception -> 0x012e }
        r0.al(r1, r2);	 Catch:{ Exception -> 0x012e }
        r0 = r9.jBH;	 Catch:{ Exception -> 0x012e }
        r0 = com.tencent.mm.plugin.gallery.ui.a.d(r0);	 Catch:{ Exception -> 0x012e }
        r1 = r9.jBH;	 Catch:{ Exception -> 0x012e }
        r1 = com.tencent.mm.plugin.gallery.ui.a.d(r1);	 Catch:{ Exception -> 0x012e }
        r2 = com.tencent.mm.R.l.gallery_select_gif_to_big;	 Catch:{ Exception -> 0x012e }
        r1 = r1.getString(r2);	 Catch:{ Exception -> 0x012e }
        com.tencent.mm.ui.base.h.bA(r0, r1);	 Catch:{ Exception -> 0x012e }
        goto L_0x0025;
    L_0x012e:
        r0 = move-exception;
        r1 = "MicroMsg.AlbumAdapter";
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
        com.tencent.mm.sdk.platformtools.x.e(r1, r0);
        goto L_0x0025;
    L_0x013b:
        r4 = r9.jBH;
        r4 = com.tencent.mm.plugin.gallery.ui.a.b(r4);
        r4 = r4.size();
        r5 = r9.jBH;
        r5 = com.tencent.mm.plugin.gallery.ui.a.e(r5);
        if (r4 >= r5) goto L_0x0226;
    L_0x014d:
        r4 = r9.jBH;
        r4 = com.tencent.mm.plugin.gallery.ui.a.b(r4);
        r4.add(r1);
        r1 = r9.jBH;
        r1 = com.tencent.mm.plugin.gallery.ui.a.b(r1);
        r1.size();
        r1 = r3;
        r4 = r3;
        goto L_0x005e;
    L_0x0163:
        r0 = r9.jBH;
        r0 = com.tencent.mm.plugin.gallery.ui.a.g(r0);
        if (r0 != r2) goto L_0x019a;
    L_0x016b:
        r0 = r9.jBH;
        r0 = com.tencent.mm.plugin.gallery.ui.a.d(r0);
        r4 = r9.jBH;
        r4 = com.tencent.mm.plugin.gallery.ui.a.d(r4);
        r4 = r4.getResources();
        r5 = com.tencent.mm.R.j.gallery_pic_limit;
        r6 = r9.jBH;
        r6 = com.tencent.mm.plugin.gallery.ui.a.e(r6);
        r7 = new java.lang.Object[r2];
        r8 = r9.jBH;
        r8 = com.tencent.mm.plugin.gallery.ui.a.e(r8);
        r8 = java.lang.Integer.valueOf(r8);
        r7[r3] = r8;
        r4 = r4.getQuantityString(r5, r6, r7);
        com.tencent.mm.ui.base.h.bA(r0, r4);
        goto L_0x007d;
    L_0x019a:
        r0 = r9.jBH;
        r0 = com.tencent.mm.plugin.gallery.ui.a.g(r0);
        r4 = 2;
        if (r0 != r4) goto L_0x01d2;
    L_0x01a3:
        r0 = r9.jBH;
        r0 = com.tencent.mm.plugin.gallery.ui.a.d(r0);
        r4 = r9.jBH;
        r4 = com.tencent.mm.plugin.gallery.ui.a.d(r4);
        r4 = r4.getResources();
        r5 = com.tencent.mm.R.j.gallery_video_limit;
        r6 = r9.jBH;
        r6 = com.tencent.mm.plugin.gallery.ui.a.e(r6);
        r7 = new java.lang.Object[r2];
        r8 = r9.jBH;
        r8 = com.tencent.mm.plugin.gallery.ui.a.e(r8);
        r8 = java.lang.Integer.valueOf(r8);
        r7[r3] = r8;
        r4 = r4.getQuantityString(r5, r6, r7);
        com.tencent.mm.ui.base.h.bA(r0, r4);
        goto L_0x007d;
    L_0x01d2:
        r0 = r9.jBH;
        r0 = com.tencent.mm.plugin.gallery.ui.a.d(r0);
        r4 = r9.jBH;
        r4 = com.tencent.mm.plugin.gallery.ui.a.d(r4);
        r4 = r4.getResources();
        r5 = com.tencent.mm.R.j.gallery_pic_or_video_limit;
        r6 = r9.jBH;
        r6 = com.tencent.mm.plugin.gallery.ui.a.e(r6);
        r7 = new java.lang.Object[r2];
        r8 = r9.jBH;
        r8 = com.tencent.mm.plugin.gallery.ui.a.e(r8);
        r8 = java.lang.Integer.valueOf(r8);
        r7[r3] = r8;
        r4 = r4.getQuantityString(r5, r6, r7);
        com.tencent.mm.ui.base.h.bA(r0, r4);
        goto L_0x007d;
    L_0x0201:
        r0 = com.tencent.mm.R.h.media_cbx;
        r0 = r10.getTag(r0);
        r0 = (android.widget.CheckBox) r0;
        r0.setChecked(r2);
        r0 = com.tencent.mm.R.h.media_mask;
        r0 = r10.getTag(r0);
        r0 = (android.view.View) r0;
        r0.setVisibility(r3);
        r0 = com.tencent.mm.R.h.media_mask;
        r0 = r10.getTag(r0);
        r0 = (android.view.View) r0;
        r1 = com.tencent.mm.R.e.half_alpha_black;
        r0.setBackgroundResource(r1);
        goto L_0x0025;
    L_0x0226:
        r1 = r2;
        r4 = r2;
        goto L_0x005e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.ui.a$2.onClick(android.view.View):void");
    }
}
