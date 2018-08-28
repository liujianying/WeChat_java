package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.support.Log;
import java.util.ArrayList;
import java.util.List;

public class MMSightProgressBar extends View {
    public static final int iGr = a.fromDPToPix(ad.getContext(), 3);
    public static final int lqU = a.fromDPToPix(ad.getContext(), 5);
    private static final int[] lqV = new int[]{-1, -1, Color.parseColor("#F5B3B2"), Color.parseColor("#EB6866"), Color.parseColor("#E64340")};
    private boolean bTv = false;
    private int centerX = 0;
    private int centerY = 0;
    private Paint fBa;
    private ag handler = null;
    private List<a> lqW = new ArrayList(5);
    private int lqX = 0;
    private b lqY;
    private boolean lqZ = false;
    private a lra;

    public MMSightProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMSightProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.fBa = new Paint();
        this.fBa.setColor(-65536);
        this.fBa.setAntiAlias(true);
        this.handler = new 1(this, Looper.getMainLooper());
        Log.i("MicroMsg.MMSightProgressBar", "init, pointRadius: %s, pointDistance: %s", new Object[]{Integer.valueOf(iGr), Integer.valueOf(lqU)});
    }

    public void setProgressCallback(a aVar) {
        this.lra = aVar;
    }

    protected void onDraw(Canvas canvas) {
        int right;
        float f;
        a aVar;
        super.onDraw(canvas);
        if (this.bTv && (this.centerX <= 0 || this.centerY <= 0)) {
            int left = getLeft();
            right = getRight();
            int top = getTop();
            int bottom = getBottom();
            this.centerX = (right - left) / 2;
            this.centerY = (bottom - top) / 2;
            Log.i("MicroMsg.MMSightProgressBar", "left: %s, right: %s, top: %s, bottom: %s, centerX: %s, centerY: %s", new Object[]{Integer.valueOf(left), Integer.valueOf(right), Integer.valueOf(top), Integer.valueOf(bottom), Integer.valueOf(this.centerX), Integer.valueOf(this.centerY)});
            Log.i("MicroMsg.MMSightProgressBar", "add init point");
            this.lqW.add(new a(0, this.centerX, this.centerY, -1));
        }
        int save = canvas.save();
        this.lqX = this.lqW.size();
        if (this.lqX % 2 == 0) {
            f = -(((((float) lqU) / 2.0f) + ((float) (((this.lqX / 2) - 1) * lqU))) + ((float) ((this.lqX / 2) * iGr)));
        } else {
            f = -(((((float) iGr) / 2.0f) + ((float) ((this.lqX / 2) * lqU))) + ((float) ((this.lqX / 2) * iGr)));
        }
        if (this.lqY != null && this.lqY.lrk) {
            float f2;
            right = this.lqX + 1;
            if (right % 2 == 0) {
                f2 = -(((float) ((right / 2) * iGr)) + ((((float) lqU) / 2.0f) + ((float) (((right / 2) - 1) * lqU))));
            } else {
                f2 = -(((float) ((right / 2) * iGr)) + ((((float) iGr) / 2.0f) + ((float) ((right / 2) * lqU))));
            }
            Log.d("MicroMsg.MMSightProgressBar", "add translateX for splitting, dstTranslateX: %s, progress: %s", new Object[]{Float.valueOf(f2), Float.valueOf(this.lqY.lrh)});
            f -= (Math.abs(f2) - Math.abs(f)) * (this.lqY.lrh / 100.0f);
        }
        Log.d("MicroMsg.MMSightProgressBar", "draw, translateX: %s, currentPointCount: %s", new Object[]{Float.valueOf(f), Integer.valueOf(this.lqX)});
        canvas.translate(f, 0.0f);
        if (this.lqY != null && this.lqY.lrk) {
            b bVar = this.lqY;
            Paint paint = this.fBa;
            x.d("MicroMsg.MMSightProgressPointSplitter", "drawForSplitProgress, progress: %s, rightPointXOffset: %s", new Object[]{Float.valueOf(bVar.lrh), Float.valueOf(((float) (lqU + (iGr * 2))) * (bVar.lrh / 100.0f))});
            if (bVar.lrs > bVar.lru) {
                float f3 = bVar.lri.lrd - ((float) iGr);
                f = bVar.lri.lre - ((float) iGr);
                paint.setColor(bVar.lrj.color);
                bVar.lrw.reset();
                bVar.lrw.moveTo(bVar.lrm.x + f3, bVar.lrm.y + f);
                bVar.lrw.quadTo(bVar.lrn.x + f3, bVar.lrn.y + f, bVar.lro.x + f3, bVar.lro.y + f);
                bVar.lrw.lineTo(bVar.lrr.x + f3, bVar.lrr.y + f);
                bVar.lrw.quadTo(bVar.lrq.x + f3, bVar.lrq.y + f, bVar.lrp.x + f3, f + bVar.lrp.y);
                if (bVar.lrj.color != bVar.lri.color) {
                    paint.setShader(new LinearGradient(bVar.lrm.x + f3, bVar.lri.lre - ((float) iGr), f3 + bVar.lro.x, bVar.lri.lre - ((float) iGr), new int[]{bVar.lri.color, bVar.lrj.color}, null, TileMode.REPEAT));
                }
                canvas.drawPath(bVar.lrw, paint);
                paint.setShader(null);
            }
            aVar = bVar.lrj;
            paint.setColor(aVar.color);
            aVar.lre = (float) aVar.lrg;
            aVar.lrd = ((float) (aVar.lrf + ((aVar.index - 1) * (lqU + (iGr * 2))))) + r11;
            Log.d("MicroMsg.MMSightProgressPoint", "drawWithOffset, index: %s, offset: %s, pointX: %s", new Object[]{Integer.valueOf(aVar.index), Float.valueOf(r11), Float.valueOf(aVar.lrd)});
            canvas.drawCircle(aVar.lrd, aVar.lre, (float) iGr, paint);
            paint.setShader(null);
        }
        for (a aVar2 : this.lqW) {
            Paint paint2 = this.fBa;
            paint2.setColor(aVar2.color);
            aVar2.lrd = (float) (aVar2.lrf + (aVar2.index * (lqU + (iGr * 2))));
            aVar2.lre = (float) aVar2.lrg;
            Log.d("MicroMsg.MMSightProgressPoint", "draw, index: %s, pointX: %s", new Object[]{Integer.valueOf(aVar2.index), Float.valueOf(aVar2.lrd)});
            canvas.drawCircle(aVar2.lrd, aVar2.lre, (float) iGr, paint2);
            paint2.setShader(null);
        }
        canvas.restoreToCount(save);
        if (this.bTv && !this.lqZ && this.lqW.size() > 0) {
            Log.i("MicroMsg.MMSightProgressBar", "start handler loop");
            this.lqZ = true;
            this.handler.sendEmptyMessage(233);
        }
    }
}
