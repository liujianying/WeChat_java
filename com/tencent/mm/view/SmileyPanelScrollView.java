package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.n.a$d;
import com.tencent.mm.plugin.n.a.c;
import com.tencent.mm.plugin.n.a.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.view.f.a;
import com.tencent.smtt.sdk.WebView;

public class SmileyPanelScrollView extends View {
    private static boolean DEBUG = false;
    private int STATE_NONE = 0;
    private int Tu;
    private int Tv;
    private Context mContext;
    private int mHeight;
    private int mState = this.STATE_NONE;
    private int mWidth;
    private b uSL;
    private a uSM;
    private Drawable uSN;
    private Drawable uSO;
    private Drawable uSP;
    private Drawable uSQ;
    public int uSR;
    public int uSS;
    private int uST;
    private Paint uSU;
    private int uSV;
    private int uSW;
    private int uSX;
    private int uSY;
    private int uSZ;
    private int uTa;
    private int uTb;
    private boolean uTc = false;
    private boolean uTd = false;
    public int uTe = -1;
    public int uTf = -1;
    public float uTg;
    public boolean uTh = false;
    public boolean uTi = false;
    public int uTj = 0;
    private int uTk = 1;
    private a uTl = new a(this);

    public interface b {
        void GP(int i);
    }

    public SmileyPanelScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public SmileyPanelScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.uSN = com.tencent.mm.svg.a.a.c(getResources(), g.smiley_recent_dot);
        this.uSP = this.mContext.getResources().getDrawable(a$d.smiley_panel_scroll_thumb_selected);
        this.uSO = this.mContext.getResources().getDrawable(a$d.smiley_panel_scroll_thumb_pressed);
        this.uSQ = this.mContext.getResources().getDrawable(a$d.smiley_panel_scroll_track_pressed);
        this.uSV = com.tencent.mm.bp.a.fromDPToPix(this.mContext, 12);
        this.uSW = this.uSO.getIntrinsicHeight();
        this.uSX = this.uSO.getIntrinsicWidth();
        this.uSY = this.uSQ.getIntrinsicHeight();
        this.uTa = this.uSP.getIntrinsicHeight();
        this.uTb = this.uSP.getIntrinsicWidth();
        x.d("MicroMsg.SmileyPanelScrollView", "init mDotPadding:%d mDotHeight:%d mDotWidth:%d", new Object[]{Integer.valueOf(this.uSV), Integer.valueOf(this.uSW), Integer.valueOf(this.uSX)});
        this.uSU = new Paint();
        this.uSU.setColor(-65536);
        this.uSU.setAntiAlias(true);
        this.uSU.setTextAlign(Align.CENTER);
        this.mWidth = getMeasuredWidth();
        this.mHeight = getMeasuredHeight();
        this.uST = this.uSZ / (this.uSX + this.uSV);
        x.d("MicroMsg.SmileyPanelScrollView", "init mWidth:%d mHeight:%d mTrackWidth:%d mMaxDot:%d", new Object[]{Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(this.uSZ), Integer.valueOf(this.uST)});
    }

    public void setSmileyPanelStg(a aVar) {
        this.uSM = aVar;
    }

    public void setOnPageSelectListener(b bVar) {
        this.uSL = bVar;
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = 102;
        int i4 = 0;
        super.draw(canvas);
        a aVar = this.uTl;
        if (aVar.uTn.getState() != aVar.uTn.uTk) {
            i = 102;
        } else {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis > aVar.mStartTime + aVar.uTm) {
                i3 = 255;
            } else {
                i2 = ((int) (((uptimeMillis - aVar.mStartTime) * 153) / aVar.uTm)) + 102;
                if (i2 >= 102) {
                    i3 = i2;
                }
            }
            i = i3;
        }
        int i5;
        if (this.uSR > this.uST) {
            this.uTc = true;
            i4 = (this.mHeight - this.uSY) / 2;
            i5 = (this.mWidth - this.uSZ) / 2;
            this.Tu = i5 - (this.uTb / 2);
            this.Tv = (this.Tu + this.uSZ) + this.uTb;
            if (DEBUG) {
                canvas.drawLine((float) this.Tu, 0.0f, (float) this.Tu, (float) this.mHeight, this.uSU);
                canvas.drawLine((float) this.Tv, 0.0f, (float) this.Tv, (float) this.mHeight, this.uSU);
            }
            this.uSQ.setBounds(i5, i4, this.uSZ + i5, this.uSY + i4);
            this.uSQ.setAlpha(i);
            this.uSQ.draw(canvas);
            i2 = (this.mHeight - this.uTa) / 2;
            if (this.uTd || this.uTh) {
                i3 = (((this.uSZ / (this.uSR - 1)) * this.uSS) + i5) - (this.uTb / 2);
            } else if (this.uTf == this.uTe) {
                i3 = ((((this.uSZ / (this.uSR - 1)) * this.uTe) + i5) - (this.uTb / 2)) + ((int) (((float) (this.uSZ / (this.uSR - 1))) * this.uTg));
            } else {
                i3 = ((((this.uSZ / (this.uSR - 1)) * this.uTe) + i5) - (this.uTb / 2)) - ((int) (((float) (this.uSZ / (this.uSR - 1))) * (1.0f - this.uTg)));
            }
            this.uSP.setBounds(i3, i2, this.uTb + i3, this.uTa + i2);
            this.uSP.draw(canvas);
        } else {
            this.uTc = false;
            i5 = (this.mHeight - this.uSW) / 2;
            int i6 = (this.mWidth - (((this.uSV + this.uSX) * (this.uSR - 1)) + this.uSX)) / 2;
            this.Tu = i6 - ((this.uTb - this.uSX) / 2);
            this.Tv = ((this.Tu + (this.uSX * this.uSR)) + (this.uSV * (this.uSR - 1))) + (this.uTb - this.uSX);
            if (DEBUG) {
                canvas.drawLine((float) this.Tu, 0.0f, (float) this.Tu, (float) this.mHeight, this.uSU);
                canvas.drawLine((float) this.Tv, 0.0f, (float) this.Tv, (float) this.mHeight, this.uSU);
            }
            this.uSO.setBounds(i6, i5, this.uSX + i6, this.uSW + i5);
            i3 = (this.uSN.getIntrinsicWidth() - this.uSX) / 2;
            i2 = (this.uSN.getIntrinsicHeight() - this.uSW) / 2;
            this.uSN.setBounds(i6 - i3, i5 - i2, i3 + (this.uSX + i6), i2 + (i5 + this.uSW));
            i2 = (this.mHeight - this.uTa) / 2;
            if (this.uTd || this.uTh) {
                i3 = i6 - ((this.uTb - this.uSX) / 2);
            } else {
                i3 = (i6 - ((this.uTb - this.uSX) / 2)) + ((int) (((float) (this.uSX + this.uSV)) * (((float) (this.uTf - this.uTe)) + this.uTg)));
            }
            this.uSP.setBounds(i3, i2, this.uTb + i3, this.uTa + i2);
            for (i2 = 0; i2 < this.uSR; i2++) {
                canvas.save();
                if (i2 > 0) {
                    canvas.translate((float) ((this.uSX + this.uSV) * i2), 0.0f);
                }
                if (i2 == 0 && this.uTi) {
                    this.uSN.draw(canvas);
                } else {
                    this.uSO.setAlpha(i);
                    this.uSO.draw(canvas);
                }
                canvas.restore();
            }
            if (this.uTe > this.uSR - 1) {
                this.uTe = this.uSR - 1;
            }
            i2 = (this.uSX + this.uSV) * this.uTe;
            if (i3 + i2 > this.Tv) {
                x.i("MicroMsg.SmileyPanelScrollView", "over right.");
            } else {
                i4 = i2;
            }
            canvas.save();
            canvas.translate((float) i4, 0.0f);
            this.uSP.draw(canvas);
            canvas.restore();
        }
        if (getState() == this.uTk && i < WebView.NORMAL_MODE_ALPHA) {
            invalidate();
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != this.mWidth) {
            this.mWidth = getMeasuredWidth();
            this.mHeight = getMeasuredHeight();
            this.uSZ = (this.mWidth - (this.uSM.getColumnWidth() - this.uSM.uWg)) - (com.tencent.mm.bp.a.ad(this.mContext, c.SmallerPadding) * 2);
            this.uST = this.uSZ / (this.uSX + this.uSV);
            x.d("MicroMsg.SmileyPanelScrollView", "onSizeChanged mWidth:%d mHeight:%d mTrackWidth:%d mMaxDot:%d", new Object[]{Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(this.uSZ), Integer.valueOf(this.uST)});
            if (this.mHeight == 0) {
                x.i("MicroMsg.SmileyPanelScrollView", "user default height");
                this.mHeight = com.tencent.mm.bp.a.fromDPToPix(this.mContext, 16);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        if (x < this.Tu - this.uSV || x > this.Tv + this.uSV) {
            x.d("MicroMsg.SmileyPanelScrollView", "over x :%d mLeft:%d mRight:%d ", new Object[]{Integer.valueOf(x), Integer.valueOf(this.Tu), Integer.valueOf(this.Tv)});
            if (action == 0) {
                return super.onTouchEvent(motionEvent);
            }
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (x < this.Tu) {
                x = this.Tu;
            }
            if (x > this.Tv) {
                x = this.Tv;
            }
            if (this.uTc) {
                x = (x - this.Tu) / (this.uSZ / (this.uSR - 1));
            } else {
                x = ((x - this.Tu) + this.uSV) / (this.uSX + this.uSV);
            }
            if (x > this.uSR - 1) {
                x = this.uSR - 1;
            }
            this.uSL.GP(x);
            this.uTe = x;
            this.uTf = x;
        }
        switch (action) {
            case 0:
                if (!z) {
                    this.uTd = true;
                    this.uTh = true;
                    setState(this.uTk);
                    this.uTl.cCc();
                    invalidate();
                    break;
                }
                break;
            case 1:
            case 3:
                setState(this.STATE_NONE);
                this.uTd = false;
                invalidate();
                break;
            case 2:
                if (!(z || getState() == this.uTk)) {
                    setState(this.uTk);
                    this.uTl.cCc();
                    invalidate();
                    break;
                }
        }
        return true;
    }

    public int getState() {
        return this.mState;
    }

    public void setState(int i) {
        this.mState = i;
    }
}
