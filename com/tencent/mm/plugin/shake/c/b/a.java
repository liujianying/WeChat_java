package com.tencent.mm.plugin.shake.c.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.ak.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.pe;
import com.tencent.mm.g.a.pe$b;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i;

public final class a extends i {
    private static final String hwK = (e.bnE + "card");
    private boolean eWV;
    private ProgressBar eWx;
    private OnClickListener eZF = new 2(this);
    private String htC = "";
    private View hyK;
    private ImageView hzt;
    private Button hzu;
    private ImageView kOI;
    private TextView mBP;
    private Resources mResources;
    private com.tencent.mm.plugin.shake.c.a.e mXG;
    private View mXJ;
    private TextView mXK;
    private TextView mXL;
    private TextView mXM;
    private TextView mXN;
    private View mXO;
    private View mXP;
    private View mXQ;
    private TextView mXR;
    private TextView mXS;
    private TextView mXT;
    private View mXU;
    private ImageView mXV;
    public boolean mXW = false;
    private boolean mXX = false;
    private int mXY = 0;
    private pe$b mXZ;
    private int mYa = a.mYf;
    private b mYb;
    private c mYc = new 1(this);

    static /* synthetic */ void d(a aVar) {
        x.i("MicroMsg.ShakeCardDialog", "doNetSceneAccept()");
        if (TextUtils.isEmpty(aVar.mXG.huU)) {
            x.e("MicroMsg.ShakeCardDialog", "card_tp_id is empty befor doNetSceneAccept");
            return;
        }
        pe peVar = new pe();
        peVar.cab = null;
        peVar.caa.cac = aVar.mXG.huU;
        peVar.caa.cad = aVar.mXG.cad;
        peVar.caa.cae = 15;
        peVar.bJX = new 3(aVar, peVar);
        com.tencent.mm.sdk.b.a.sFg.a(peVar, Looper.getMainLooper());
    }

    static /* synthetic */ void f(a aVar) {
        x.i("MicroMsg.ShakeCardDialog", "goCardDetailUI ShakeCardDialog");
        h.mEJ.k(11665, aVar.htC);
        com.tencent.mm.plugin.shake.c.c.a.s(aVar.getContext(), aVar.htC, aVar.mXG.cad);
    }

    static /* synthetic */ void i(a aVar) {
        aVar.buP();
        if (aVar.mYa == a.mYh) {
            aVar.mBP.setText(R.l.shake_accept_succes_tips);
            if (aVar.mXY == 1) {
                aVar.mXV.setImageResource(R.k.shake_success_icon);
            } else {
                aVar.mXV.setImageResource(R.k.shake_success_icon_no_activity);
            }
        }
    }

    private a(Context context) {
        super(context, R.m.mmcarddialog);
        x.i("MicroMsg.ShakeCardDialog", "init shake card dialog");
        this.mResources = context.getResources();
        setCanceledOnTouchOutside(true);
        getWindow().setSoftInputMode(2);
        this.hyK = View.inflate(context, R.i.shake_card_dialog, null);
        this.mXJ = this.hyK.findViewById(R.h.shake_card_dialog);
        this.mXK = (TextView) this.hyK.findViewById(R.h.card_view_title);
        this.mXL = (TextView) this.hyK.findViewById(R.h.card_sub_title);
        this.mXM = (TextView) this.hyK.findViewById(R.h.card_desc);
        this.kOI = (ImageView) this.hyK.findViewById(R.h.card_close_img);
        this.hzu = (Button) this.hyK.findViewById(R.h.card_accept_btn);
        this.mXN = (TextView) this.hyK.findViewById(R.h.card_accept_fail_tip);
        this.eWx = (ProgressBar) this.hyK.findViewById(R.h.card_progress_bar);
        this.kOI.setOnClickListener(this.eZF);
        this.hzu.setOnClickListener(this.eZF);
        this.mXO = this.hyK.findViewById(R.h.card_base_info_layout);
        this.mXP = this.hyK.findViewById(R.h.widget_body);
        this.mXQ = this.hyK.findViewById(R.h.card_widget_header);
        this.hzt = (ImageView) this.hyK.findViewById(R.h.card_logo);
        this.mXR = (TextView) this.hyK.findViewById(R.h.card_title);
        this.mXS = (TextView) this.hyK.findViewById(R.h.card_brand_name);
        this.mXT = (TextView) this.hyK.findViewById(R.h.card_time);
        this.mXU = this.hyK.findViewById(R.h.card_result_layout);
        this.mXV = (ImageView) this.hyK.findViewById(R.h.result_icon);
        this.mBP = (TextView) this.hyK.findViewById(R.h.result_desc);
        this.mXY = com.tencent.mm.plugin.shake.c.c.a.buT();
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            x.i("MicroMsg.ShakeCardDialog", "back key in shake card dialog");
            dismiss();
            if (this.mYb != null) {
                this.mYb.buR();
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.hyK);
    }

    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        this.eWV = z;
        setCanceledOnTouchOutside(this.eWV);
    }

    public final void dismiss() {
        try {
            if (this.mYb != null) {
                this.mYb.buR();
            }
            if (!(this.mYa == a.mYh || this.mXX)) {
                this.mXX = true;
                x.i("MicroMsg.ShakeCardDialog", "ShakeCardDialog card is not cancel accepte");
                au.DF().a(new com.tencent.mm.plugin.shake.c.a.a(this.mXG.huU, this.mXG.cad), 0);
            }
            com.tencent.mm.sdk.b.a.sFg.c(this.mYc);
            x.i("MicroMsg.ShakeCardDialog", "dismiss ShakeCardDialog");
            super.dismiss();
        } catch (Exception e) {
            x.e("MicroMsg.ShakeCardDialog", "dismiss exception, e = " + e.getMessage());
        }
    }

    private void buO() {
        if (this.mYa == a.mYh) {
            this.mXO.setVisibility(8);
            this.mXU.setVisibility(0);
        } else if (this.mYa == a.mYf || this.mYa == a.mYg || this.mYa == a.mYi) {
            this.mXO.setVisibility(0);
            this.mXU.setVisibility(8);
        }
    }

    private void buP() {
        if (this.mYa == a.mYf || this.mYa == a.mYi) {
            if (TextUtils.isEmpty(this.mXG.mXq)) {
                this.hzu.setText(R.l.card_add);
            } else {
                this.hzu.setText(this.mXG.mXq);
            }
        } else if (this.mYa == a.mYg) {
            this.hzu.setText("");
        } else if (this.mYa == a.mYh) {
            this.hzu.setText(R.l.shake_check_card_detail);
        }
    }

    private void buQ() {
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.f.shake_card_widget_bg_corner);
        Drawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{(float) dimensionPixelOffset, (float) dimensionPixelOffset, (float) dimensionPixelOffset, (float) dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f}, null, null));
        shapeDrawable.getPaint().setColor(com.tencent.mm.plugin.shake.c.c.a.xV(this.mXG.dxh));
        this.mXQ.setBackgroundDrawable(shapeDrawable);
        buP();
        if (!TextUtils.isEmpty(this.mXG.mXo)) {
            this.mXK.setText(this.mXG.mXo);
        }
        if (!TextUtils.isEmpty(this.mXG.mXs)) {
            this.mXL.setText(this.mXG.mXs);
            this.mXL.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.mXG.mXp)) {
            this.mXM.setText(this.mXG.mXp);
            this.mXM.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.mXG.huW)) {
            dimensionPixelOffset = getContext().getResources().getDimensionPixelSize(R.f.shake_card_logo_height);
            ImageView imageView = this.hzt;
            String str = this.mXG.huW;
            int i = R.k.shake_card_package_defaultlogo;
            if (!(imageView == null || TextUtils.isEmpty(str))) {
                if (TextUtils.isEmpty(str)) {
                    imageView.setImageResource(i);
                } else {
                    com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
                    aVar.dXB = e.bnE;
                    o.Pk();
                    aVar.dXU = null;
                    aVar.dXA = String.format("%s/%s", new Object[]{hwK, g.u(str.getBytes())});
                    aVar.dXy = true;
                    aVar.dXW = true;
                    aVar.dXw = true;
                    aVar.dXF = dimensionPixelOffset;
                    aVar.dXE = dimensionPixelOffset;
                    aVar.dXN = i;
                    o.Pj().a(str, imageView, aVar.Pt());
                }
            }
        }
        if (!TextUtils.isEmpty(this.mXG.title)) {
            this.mXR.setText(this.mXG.title);
        }
        if (!TextUtils.isEmpty(this.mXG.hwh)) {
            this.mXS.setText(this.mXG.hwh);
        }
        if (this.mXG.end_time > 0) {
            this.mXT.setText(getContext().getString(R.l.card_validate_to, new Object[]{com.tencent.mm.plugin.shake.c.c.a.bx((long) this.mXG.end_time)}));
        }
        if (this.mYa == a.mYi) {
            this.mXN.setVisibility(0);
        } else {
            this.mXN.setVisibility(8);
        }
    }

    public static a a(Context context, com.tencent.mm.plugin.shake.c.a.e eVar, OnCancelListener onCancelListener, b bVar) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.setOnCancelListener(onCancelListener);
        aVar.setCancelable(true);
        aVar.mXG = eVar;
        if (aVar.mXG == null) {
            x.e("MicroMsg.ShakeCardDialog", "updateView() mCardItem == null");
        } else {
            if (TextUtils.isEmpty(aVar.mXG.title)) {
                aVar.mXK.setText(aVar.mXG.title);
            }
            x.i("MicroMsg.ShakeCardDialog", "updateView() action_type is has card");
            aVar.mYa = a.mYf;
            aVar.buO();
            aVar.buQ();
            if (aVar.mXY == 0) {
                aVar.mXJ.setBackgroundResource(R.g.shake_card_dialog_no_activity_bg);
                aVar.mXP.setBackgroundResource(R.g.shake_card_normal_widget_body_bg);
                aVar.mXK.setTextColor(aVar.mResources.getColor(R.e.black));
                aVar.mXL.setTextColor(aVar.mResources.getColor(R.e.navbar_text_normal));
                aVar.mXM.setTextColor(aVar.mResources.getColor(R.e.navbar_text_normal));
                aVar.mBP.setTextColor(aVar.getContext().getResources().getColor(R.e.black));
                aVar.hzu.setBackgroundResource(R.g.btn_solid_green);
                aVar.hzu.setTextColor(aVar.getContext().getResources().getColor(R.e.white));
                aVar.mXN.setTextColor(aVar.getContext().getResources().getColor(R.e.noactivity_accept_fail_tip_color));
            }
        }
        aVar.mYb = bVar;
        aVar.show();
        com.tencent.mm.ui.base.h.a(context, aVar);
        return aVar;
    }
}
