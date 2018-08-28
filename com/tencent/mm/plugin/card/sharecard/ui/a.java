package com.tencent.mm.plugin.card.sharecard.ui;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.card.a$g;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public final class a {
    private final String TAG = "MicroMsg.CardConsumeCodeController";
    Bitmap eZA;
    OnClickListener eZF = new 1(this);
    MMActivity gKS;
    b htQ;
    View hyK;
    private View hyL;
    private View hyM;
    private View hyN;
    Bitmap hyO;
    TextView hyP;
    TextView hyQ;
    CheckBox hyR;
    String hyS;
    int hyT = 1;
    boolean hyU = false;
    a hyV;
    float hyW = 0.0f;
    private OnLongClickListener hyX = new 2(this);

    public a(MMActivity mMActivity, View view) {
        this.gKS = mMActivity;
        this.hyK = view;
    }

    final void ag(float f) {
        LayoutParams attributes = this.gKS.getWindow().getAttributes();
        attributes.screenBrightness = f;
        this.gKS.getWindow().setAttributes(attributes);
    }

    public final void axM() {
        x.i("MicroMsg.CardConsumeCodeController", "doUpdate()");
        if (this.hyU) {
            String str;
            ImageView imageView;
            if (!bi.oW(this.htQ.awn().rnp)) {
                x.i("MicroMsg.CardConsumeCodeController", "code:%s from sign_number", new Object[]{this.htQ.awn().rnp});
                str = r0;
            } else if (this.htQ.awg()) {
                x.i("MicroMsg.CardConsumeCodeController", "code:%s from dynamic code", new Object[]{am.axv().getCode()});
                str = r0;
            } else {
                x.i("MicroMsg.CardConsumeCodeController", "code:%s from dataInfo", new Object[]{this.htQ.awn().code});
                str = r0;
            }
            View view;
            TextView textView;
            switch (this.htQ.awn().rnc) {
                case 0:
                    if (this.hyN == null) {
                        this.hyN = ((ViewStub) this.hyK.findViewById(d.card_code_text_stub)).inflate();
                    }
                    TextView textView2 = (TextView) this.hyN.findViewById(d.code_text);
                    textView2.setText(m.yd(str));
                    textView2.setOnLongClickListener(this.hyX);
                    if (!this.htQ.avT()) {
                        textView2.setTextColor(l.xV(this.htQ.awm().dxh));
                    }
                    if (str.length() <= 12) {
                        textView2.setTextSize(1, 33.0f);
                    } else if (str.length() > 12 && str.length() <= 16) {
                        textView2.setTextSize(1, 30.0f);
                    } else if (str.length() > 16 && str.length() <= 20) {
                        textView2.setTextSize(1, 24.0f);
                    } else if (str.length() > 20 && str.length() <= 40) {
                        textView2.setTextSize(1, 18.0f);
                    } else if (str.length() > 40) {
                        textView2.setVisibility(8);
                    }
                    co(this.hyN);
                    break;
                case 1:
                    if (this.hyM == null) {
                        this.hyM = ((ViewStub) this.hyK.findViewById(d.card_code_barcode_stub)).inflate();
                    }
                    view = this.hyM;
                    imageView = (ImageView) view.findViewById(d.code_bar_area);
                    textView = (TextView) view.findViewById(d.code_text);
                    if (!this.htQ.avT()) {
                        textView.setTextColor(l.xV(this.htQ.awm().dxh));
                    }
                    if (TextUtils.isEmpty(str) || str.length() > 40) {
                        textView.setVisibility(8);
                    } else {
                        textView.setText(m.yd(str));
                        if (this.htQ.awc()) {
                            textView.setVisibility(0);
                            textView.setOnLongClickListener(this.hyX);
                        } else {
                            textView.setVisibility(8);
                        }
                    }
                    if (this.hyT != 1) {
                        textView.setVisibility(4);
                    }
                    try {
                        l.x(this.hyO);
                        if (TextUtils.isEmpty(str)) {
                            this.hyO = null;
                            imageView.setImageBitmap(this.hyO);
                        } else {
                            this.hyO = com.tencent.mm.bm.a.a.b(this.gKS, str, 5, 0);
                            a(imageView, this.hyO);
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.CardConsumeCodeController", e, "", new Object[0]);
                    }
                    co(this.hyM);
                    break;
                case 2:
                    if (this.hyL == null) {
                        this.hyL = ((ViewStub) this.hyK.findViewById(d.card_code_qrcode_stub)).inflate();
                    }
                    view = this.hyL;
                    imageView = (ImageView) view.findViewById(d.code_qr_area);
                    textView = (TextView) view.findViewById(d.code_text);
                    if (!this.htQ.avT()) {
                        textView.setTextColor(l.xV(this.htQ.awm().dxh));
                    }
                    if (str.length() <= 40) {
                        textView.setText(m.yd(str));
                        if (this.htQ.awc()) {
                            textView.setVisibility(0);
                            textView.setOnLongClickListener(this.hyX);
                        } else {
                            textView.setVisibility(8);
                        }
                    } else {
                        textView.setVisibility(8);
                    }
                    if (this.hyT != 1) {
                        textView.setVisibility(4);
                    }
                    try {
                        l.x(this.eZA);
                        if (TextUtils.isEmpty(str)) {
                            this.eZA = null;
                            imageView.setImageBitmap(this.eZA);
                        } else {
                            this.eZA = com.tencent.mm.bm.a.a.b(this.gKS, str, 0, 3);
                            a(imageView, this.eZA);
                        }
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.CardConsumeCodeController", e2, "", new Object[0]);
                    }
                    co(this.hyL);
                    break;
            }
            if (bi.oW(this.htQ.awm().hUy)) {
                this.hyP.setVisibility(8);
                this.hyQ.setVisibility(8);
            } else if (this.htQ.awm().rok != null) {
                this.hyQ.setText(this.htQ.awm().hUy);
                this.hyQ.setVisibility(0);
                this.hyP.setVisibility(8);
                if (this.hyL != null) {
                    imageView = (ImageView) this.hyL.findViewById(d.code_qr_area);
                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    layoutParams.height = com.tencent.mm.bp.a.fromDPToPix(this.gKS, 180);
                    layoutParams.width = com.tencent.mm.bp.a.fromDPToPix(this.gKS, 180);
                    imageView.setLayoutParams(layoutParams);
                }
            } else {
                this.hyP.setText(this.htQ.awm().hUy);
                this.hyP.setVisibility(0);
            }
            if (!this.htQ.avS() || TextUtils.isEmpty(this.htQ.aws()) || this.htQ.aws().equals(q.GF())) {
                this.hyR.setChecked(false);
                this.hyR.setVisibility(8);
                return;
            }
            this.hyR.setVisibility(0);
            this.hyR.setText(j.d(this.gKS, " " + this.gKS.getString(a$g.card_code_notify_user, new Object[]{l.xY(this.htQ.aws())}), this.gKS.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.card.a.b.SmallerTextSize)));
            return;
        }
        x.i("MicroMsg.CardConsumeCodeController", "doUpdate() not ready show!");
    }

    private void a(ImageView imageView, Bitmap bitmap) {
        if (imageView != null && bitmap != null && !bitmap.isRecycled()) {
            imageView.setImageBitmap(bitmap);
            if (this.hyT != 1) {
                imageView.setAlpha(10);
            } else {
                imageView.setAlpha(255);
            }
        }
    }

    private void co(View view) {
        Button button = (Button) view.findViewById(d.code_mark_btn);
        if (this.hyT == 1) {
            button.setVisibility(8);
        } else {
            button.setVisibility(0);
        }
        if (this.hyT == -1) {
            button.setText(a$g.card_mark_failed_tips);
        }
    }
}
