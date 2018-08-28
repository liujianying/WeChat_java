package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.facedetect.a.c;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Timer;

public class FaceNumberView extends LinearLayout {
    private String iUn;
    private int iUo;
    private ViewGroup iUp;
    public FaceNumberItemView[] iUq;
    private int iUr;
    private Animation iUs;
    private int iUt;

    public void setNumberLengthAndInflate(int i) {
        if (i > 12) {
            x.e("MicroMsg.Facing.MMPwdInputView", "hy: number length exceed max length: %d", new Object[]{Integer.valueOf(i)});
        } else if (i <= 0) {
            x.e("MicroMsg.Facing.MMPwdInputView", "hy: number length exceed min length: %d", new Object[]{Integer.valueOf(i)});
        } else if (i == this.iUr) {
            x.i("MicroMsg.Facing.MMPwdInputView", "hy: already correct length. quit");
            AY(null);
        } else {
            this.iUp.removeAllViews();
            this.iUr = i;
            this.iUq = new FaceNumberItemView[this.iUr];
            for (int i2 = 0; i2 < i; i2++) {
                int i3;
                int dimensionPixelSize;
                FaceNumberItemView faceNumberItemView = (FaceNumberItemView) inflate(getContext(), g.face_number_view_item, null);
                faceNumberItemView.setImageResource(d.face_point);
                if (i2 == 0) {
                    i3 = 3;
                    dimensionPixelSize = (getResources().getDimensionPixelSize(c.face_number_width) + a.fromDPToPix(getContext(), 48)) / 2;
                } else if (i2 == i - 1) {
                    i3 = 5;
                    dimensionPixelSize = (getResources().getDimensionPixelSize(c.face_number_width) + a.fromDPToPix(getContext(), 48)) / 2;
                } else {
                    i3 = 17;
                    dimensionPixelSize = getResources().getDimensionPixelSize(c.face_number_width);
                }
                faceNumberItemView.setGravity(i3);
                this.iUq[i2] = faceNumberItemView;
                this.iUp.addView(faceNumberItemView, new LayoutParams(dimensionPixelSize, getResources().getDimensionPixelSize(c.face_number_height)));
            }
        }
    }

    public FaceNumberView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public FaceNumberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.iUn = null;
        this.iUq = null;
        this.iUr = 0;
        this.iUs = null;
        this.iUt = a.iUv;
        this.iUp = (ViewGroup) inflate(getContext(), g.face_number_view, null);
        addView(this.iUp);
        this.iUs = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.facedetect.a.a.pop_in);
    }

    private static void a(FaceNumberItemView faceNumberItemView, String str) {
        if (faceNumberItemView != null) {
            if (str.equals("0")) {
                faceNumberItemView.setImageResource(d.face_number0);
            } else if (str.equals("1")) {
                faceNumberItemView.setImageResource(d.face_number1);
            } else if (str.equals("2")) {
                faceNumberItemView.setImageResource(d.face_number2);
            } else if (str.equals("3")) {
                faceNumberItemView.setImageResource(d.face_number3);
            } else if (str.equals("4")) {
                faceNumberItemView.setImageResource(d.face_number4);
            } else if (str.equals("5")) {
                faceNumberItemView.setImageResource(d.face_number5);
            } else if (str.equals("6")) {
                faceNumberItemView.setImageResource(d.face_number6);
            } else if (str.equals("7")) {
                faceNumberItemView.setImageResource(d.face_number7);
            } else if (str.equals("8")) {
                faceNumberItemView.setImageResource(d.face_number8);
            } else if (str.equals("9")) {
                faceNumberItemView.setImageResource(d.face_number9);
            } else {
                faceNumberItemView.setImageResource(d.face_point);
            }
        }
    }

    public final void AY(String str) {
        int i = 0;
        this.iUn = str;
        if (this.iUn != null) {
            this.iUo = this.iUn.length();
        } else {
            this.iUo = 0;
        }
        if (this.iUq != null && this.iUq.length > 0) {
            if (bi.oW(this.iUn)) {
                while (i < this.iUq.length) {
                    a(this.iUq[i], "point");
                    i++;
                }
                return;
            }
            for (int i2 = 0; i2 < this.iUq.length; i2++) {
                String str2;
                if (this.iUo > i2) {
                    String str3 = this.iUn.charAt(i2);
                    FaceNumberItemView faceNumberItemView;
                    if (this.iUo == i2 + 1) {
                        faceNumberItemView = this.iUq[i2];
                        if (faceNumberItemView.iUc != null) {
                            faceNumberItemView.aKM();
                        }
                        faceNumberItemView.iUc = new Timer("FaceNumberItemView_karaoke", true);
                        faceNumberItemView.iUc.scheduleAtFixedRate(new FaceNumberItemView.a(faceNumberItemView, faceNumberItemView.iUk, (byte) 0), 0, FaceNumberItemView.iUd);
                        str2 = str3;
                    } else {
                        this.iUq[i2].aKM();
                        faceNumberItemView = this.iUq[i2];
                        faceNumberItemView.iUj = 30;
                        faceNumberItemView.invalidate();
                        str2 = str3;
                    }
                } else {
                    str2 = "";
                }
                a(this.iUq[i2], str2);
            }
        }
    }
}
