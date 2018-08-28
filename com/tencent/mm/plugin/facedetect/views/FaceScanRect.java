package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.c;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.sdk.platformtools.x;

public class FaceScanRect extends RelativeLayout {
    public View iUA;
    private ImageView iUB;
    private ImageView iUC;
    private ImageView iUD;
    private ImageView iUE;
    private ImageView iUF;
    private ImageView iUG;
    private ImageView iUH;
    private ImageView iUI;
    public ImageView[] iUJ;
    private ScaleAnimation iUK;
    private ScaleAnimation iUL;
    private ScaleAnimation iUM;
    private ScaleAnimation iUN;
    public TranslateAnimation iUO;
    private b iUP;
    private ViewGroup iUQ;
    public View iUR;
    public int iUS;

    public FaceScanRect(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceScanRect(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iUA = null;
        this.iUB = null;
        this.iUC = null;
        this.iUD = null;
        this.iUE = null;
        this.iUF = null;
        this.iUG = null;
        this.iUH = null;
        this.iUI = null;
        this.iUJ = null;
        this.iUK = null;
        this.iUL = null;
        this.iUM = null;
        this.iUN = null;
        this.iUO = null;
        this.iUP = null;
        this.iUQ = null;
        this.iUR = null;
        LayoutInflater.from(context).inflate(g.face_scan_rect, this, true);
        this.iUA = findViewById(e.face_scan_rect_parent);
        this.iUB = (ImageView) findViewById(e.face_rect_top_left);
        this.iUC = (ImageView) findViewById(e.face_rect_top_right);
        this.iUD = (ImageView) findViewById(e.face_rect_left_top);
        this.iUE = (ImageView) findViewById(e.face_rect_left_bottom);
        this.iUF = (ImageView) findViewById(e.face_rect_right_top);
        this.iUG = (ImageView) findViewById(e.face_rect_right_bottom);
        this.iUH = (ImageView) findViewById(e.face_rect_bottom_left);
        this.iUI = (ImageView) findViewById(e.face_rect_bottom_right);
        this.iUR = findViewById(e.face_detect_scan_line);
        this.iUQ = (ViewGroup) findViewById(e.face_center_hint);
        this.iUJ = new ImageView[]{this.iUB, this.iUC, this.iUD, this.iUE, this.iUF, this.iUG, this.iUH, this.iUI};
        this.iUS = a.iUV;
        this.iUO = new TranslateAnimation(2, 0.0f, 2, 1.0f, 2, 0.0f, 2, 0.0f);
        this.iUO.setRepeatCount(-1);
        this.iUO.setRepeatMode(1);
        this.iUO.setDuration(1000);
    }

    public void setOnRefreshRectListener(b bVar) {
        this.iUP = bVar;
    }

    public ViewGroup getCenterHintHolder() {
        return this.iUQ;
    }

    public final void b(AnimationListener animationListener) {
        if (this.iUS == a.iUU) {
            x.w("MicroMsg.FaceScanRect", "hy: already closed");
            if (animationListener != null) {
                animationListener.onAnimationEnd(null);
                return;
            }
            return;
        }
        this.iUS = a.iUU;
        int width = getWidth();
        int height = getHeight();
        int dimensionPixelSize = getResources().getDimensionPixelSize(c.face_rect_green_string_length);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(c.face_rect_white_string_length);
        float f = ((float) (((width - (dimensionPixelSize * 2)) - (dimensionPixelSize2 * 2)) + dimensionPixelSize2)) / ((float) dimensionPixelSize2);
        float f2 = ((float) (((height - (dimensionPixelSize * 2)) - (dimensionPixelSize2 * 2)) + dimensionPixelSize2)) / ((float) dimensionPixelSize2);
        x.i("MicroMsg.FaceScanRect", "hy: horizontalScale : %f, verticalScale : %f", new Object[]{Float.valueOf(f), Float.valueOf(f2)});
        this.iUK = new ScaleAnimation(1.0f, f, 1.0f, 1.0f, 1, 0.0f, 1, 0.0f);
        this.iUK.setFillAfter(true);
        this.iUK.setDuration(1500);
        this.iUK.setInterpolator(getContext(), 17563654);
        this.iUK.setAnimationListener(animationListener);
        this.iUL = new ScaleAnimation(1.0f, f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.iUL.setFillAfter(true);
        this.iUL.setDuration(1500);
        this.iUL.setInterpolator(getContext(), 17563654);
        this.iUM = new ScaleAnimation(1.0f, 1.0f, 1.0f, f2, 1, 0.0f, 1, 0.0f);
        this.iUM.setFillAfter(true);
        this.iUM.setDuration(1500);
        this.iUM.setInterpolator(getContext(), 17563654);
        this.iUN = new ScaleAnimation(1.0f, 1.0f, 1.0f, f2, 1, 0.0f, 1, 1.0f);
        this.iUN.setFillAfter(true);
        this.iUN.setDuration(1500);
        this.iUN.setInterpolator(getContext(), 17563654);
        this.iUB.startAnimation(this.iUK);
        this.iUE.startAnimation(this.iUN);
        this.iUF.startAnimation(this.iUM);
        this.iUI.startAnimation(this.iUL);
        this.iUR.setVisibility(8);
        this.iUA.setBackground(null);
        this.iUR.clearAnimation();
        for (ImageView backgroundColor : this.iUJ) {
            backgroundColor.setBackgroundColor(getResources().getColor(b.face_white_string_transparent));
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.iUP != null) {
            this.iUP.aKx();
        }
    }
}
