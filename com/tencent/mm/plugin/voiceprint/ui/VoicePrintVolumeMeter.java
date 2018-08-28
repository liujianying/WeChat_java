package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aq;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;

public class VoicePrintVolumeMeter extends View {
    static int kHx = 20;
    private static float oGE = 1.5f;
    private static float oGF = 2.0f;
    private static float oGG = 0.1f;
    private static float oGH = 0.05f;
    private static int oGv = Color.rgb(aq.CTRL_BYTE, 250, 235);
    private static int oGw = Color.rgb(210, aq.CTRL_BYTE, 200);
    private static int oGx = 100;
    private Paint cN;
    private View kHl;
    private Context mContext;
    boolean mIsPlaying = false;
    private float mVolume = -1.0f;
    private float oGA = 0.0f;
    private float oGB = 0.0f;
    private float oGC = 0.0f;
    private float oGD = 0.0f;
    private boolean oGI = true;
    private int oGr = -1;
    private int oGs = -1;
    ah oGt = null;
    al oGu = null;
    private float oGy = 0.0f;
    private float oGz = 0.0f;

    static /* synthetic */ void a(VoicePrintVolumeMeter voicePrintVolumeMeter) {
        if (voicePrintVolumeMeter.mIsPlaying) {
            if (voicePrintVolumeMeter.oGI) {
                voicePrintVolumeMeter.oGC *= oGG + 1.0f;
                voicePrintVolumeMeter.oGD = voicePrintVolumeMeter.oGC * oGE;
            } else {
                voicePrintVolumeMeter.oGC *= 1.0f - oGH;
                voicePrintVolumeMeter.oGD = voicePrintVolumeMeter.oGC * oGE;
            }
            voicePrintVolumeMeter.postInvalidate();
        }
    }

    public VoicePrintVolumeMeter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public VoicePrintVolumeMeter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.cN = new Paint();
        this.oGt = new ah("VoicePrintVolumeMeter");
        this.oGu = new al(this.oGt.lnJ.getLooper(), new 1(this), true);
    }

    public void setArchView(View view) {
        this.kHl = view;
    }

    final void bJj() {
        if (this.kHl != null && this.kHl.getVisibility() != 8) {
            int[] iArr = new int[2];
            this.kHl.getLocationOnScreen(iArr);
            if (iArr[0] == 0 || iArr[1] == 0) {
                x.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView location");
                return;
            }
            int width = this.kHl.getWidth();
            int height = this.kHl.getHeight();
            if (height == 0 || width == 0) {
                x.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView size");
                return;
            }
            this.oGr = iArr[0] + (width / 2);
            this.oGs = (iArr[1] + (height / 2)) - a.fromDPToPix(this.mContext, 25);
            x.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, mCenterX:%d, mCenterY:%d", new Object[]{Integer.valueOf(this.oGr), Integer.valueOf(this.oGs)});
            this.oGy = ((float) width) / 2.0f;
            this.oGz = this.oGy * oGE;
            this.oGA = this.oGy * oGF;
            this.oGB = this.oGz * oGF;
            this.oGD = this.oGz;
            this.oGC = this.oGy;
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mIsPlaying) {
            if (this.oGr == -1 || this.oGs == -1) {
                bJj();
            }
            this.cN.setAlpha(oGx);
            if (this.oGD > this.oGB) {
                this.oGD = this.oGB;
            }
            if (this.oGD < this.oGz) {
                this.oGD = this.oGz;
            }
            this.cN.setColor(oGv);
            canvas.drawCircle((float) this.oGr, (float) this.oGs, this.oGD, this.cN);
            if (this.oGC > this.oGA) {
                this.oGC = this.oGA;
            }
            if (this.oGC < this.oGy) {
                this.oGC = this.oGy;
            }
            this.cN.setColor(oGw);
            canvas.drawCircle((float) this.oGr, (float) this.oGs, this.oGC, this.cN);
        }
    }

    public final void stop() {
        reset();
        this.mIsPlaying = false;
        this.oGu.SO();
        postInvalidate();
    }

    public void setVolume(float f) {
        if (f > this.mVolume) {
            this.oGI = true;
        } else {
            this.oGI = false;
        }
        this.mVolume = f;
    }

    public final void reset() {
        this.oGI = false;
        this.mVolume = -1.0f;
        this.mIsPlaying = false;
        this.oGC = 0.0f;
        this.oGD = 0.0f;
        postInvalidate();
    }
}
