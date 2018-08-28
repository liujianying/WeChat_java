package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.o;
import com.tencent.mm.app.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.y.g;

class h$a extends a {
    public static final int uba = (((int) com.tencent.mm.bp.a.getDensity(b.applicationLike.getApplication())) * 64);
    public TextView eCm;
    public TextView eCn;
    public MMImageView tZI;
    public TextView uaX;
    public View uaY;
    public boolean uaZ;
    public int uau = 0;

    h$a() {
    }

    public final h$a r(View view, boolean z) {
        super.dx(view);
        this.uaZ = z;
        this.hrs = (TextView) this.jEz.findViewById(R.h.chatting_time_tv);
        this.jBR = (CheckBox) view.findViewById(R.h.chatting_checkbox);
        this.gFD = this.jEz.findViewById(R.h.chatting_maskview);
        this.mQc = (TextView) this.jEz.findViewById(R.h.chatting_user_tv);
        this.tZI = (MMImageView) this.jEz.findViewById(R.h.appmsg_coupon_card_icon);
        this.eCm = (TextView) this.jEz.findViewById(R.h.appmsg_coupon_card_title);
        this.eCn = (TextView) this.jEz.findViewById(R.h.appmsg_coupon_card_desc);
        this.uaX = (TextView) this.jEz.findViewById(R.h.appmsg_coupon_card_bottom_title);
        this.uaY = this.jEz.findViewById(R.h.appmsg_coupon_card_content);
        this.uau = b.gP(ad.getContext());
        return this;
    }

    public final void a(Context context, g.a aVar, String str, boolean z) {
        P(this.hrH, this.uau);
        Bitmap a;
        com.tencent.mm.ak.a.a Pj;
        String str2;
        MMImageView mMImageView;
        c.a bg;
        switch (aVar.type) {
            case 16:
                this.eCm.setText(aVar.description);
                this.eCn.setText(aVar.dxF);
                this.tZI.setVisibility(0);
                if (z) {
                    a = o.Pf().a(str, com.tencent.mm.bp.a.getDensity(context), false);
                    if (a == null || a.isRecycled()) {
                        Pj = o.Pj();
                        str2 = aVar.thumburl;
                        mMImageView = this.tZI;
                        bg = new c.a().bg(uba, uba);
                        bg.dXN = R.k.app_attach_file_icon_webpage;
                        bg.dXW = true;
                        Pj.a(str2, mMImageView, bg.Pt());
                        return;
                    }
                    this.tZI.setImageBitmap(com.tencent.mm.sdk.platformtools.c.a(a, false, (float) (a.getWidth() / 2)));
                    return;
                }
                this.tZI.setImageResource(R.g.nosdcard_app);
                return;
            case 34:
                if (aVar.title == null || aVar.title.length() <= 0) {
                    this.eCm.setVisibility(8);
                } else {
                    this.eCm.setVisibility(0);
                    this.eCm.setText(aVar.title);
                    if (bi.oW(aVar.dxO)) {
                        this.eCm.setTextColor(context.getResources().getColor(R.e.black));
                    } else {
                        this.eCm.setTextColor(bi.bc(aVar.dxO, context.getResources().getColor(R.e.black)));
                    }
                }
                this.eCn.setMaxLines(2);
                this.eCn.setVisibility(0);
                this.eCn.setText(aVar.description);
                if (bi.oW(aVar.dxP)) {
                    this.eCn.setTextColor(context.getResources().getColor(R.e.grey_background_text_color));
                } else {
                    this.eCn.setTextColor(bi.bc(aVar.dxP, context.getResources().getColor(R.e.grey_background_text_color)));
                }
                if (bi.oW(aVar.dxK)) {
                    this.uaX.setText(R.l.chatting_item_coupon_card);
                } else {
                    this.uaX.setText(aVar.dxK);
                }
                if (z) {
                    a = o.Pf().a(str, com.tencent.mm.bp.a.getDensity(context), false);
                    if (a == null || a.isRecycled()) {
                        com.tencent.mm.ak.a.a Pj2 = o.Pj();
                        String str3 = aVar.thumburl;
                        MMImageView mMImageView2 = this.tZI;
                        c.a bg2 = new c.a().bg(uba, uba);
                        bg2.dXN = R.k.app_attach_file_icon_webpage;
                        bg2.dXW = true;
                        Pj2.a(str3, mMImageView2, bg2.Pt());
                    } else {
                        this.tZI.setImageBitmap(com.tencent.mm.sdk.platformtools.c.a(a, false, (float) (a.getWidth() / 2)));
                    }
                    if (bi.oW(aVar.dxN)) {
                        this.uaY.getViewTreeObserver().addOnPreDrawListener(new 2(this, context, a));
                        return;
                    }
                    Pj = o.Pj();
                    str2 = aVar.dxN;
                    ImageView imageView = new ImageView(context);
                    bg = new c.a();
                    bg.dXy = true;
                    Pj.a(str2, imageView, bg.Pt(), new 1(this, context));
                    return;
                }
                this.tZI.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.g.nosdcard_app));
                return;
            default:
                this.eCm.setText(aVar.description);
                this.eCn.setText(aVar.dxF);
                this.tZI.setVisibility(0);
                if (z) {
                    Pj = o.Pj();
                    str2 = o.Pf().E(str, true);
                    mMImageView = this.tZI;
                    bg = new c.a();
                    bg.dXD = 1;
                    bg = bg.bg(uba, uba);
                    bg.dXN = R.k.app_attach_file_icon_webpage;
                    bg.dXW = true;
                    Pj.a(str2, mMImageView, bg.Pt());
                    return;
                }
                this.tZI.setImageResource(R.g.nosdcard_app);
                return;
        }
    }
}
