package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Gallery;
import android.widget.OverScroller;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.w.a.g;
import java.lang.ref.WeakReference;

public class MMGestureGallery extends Gallery {
    private int SQ;
    private int SR;
    private float aaZ = 0.0f;
    private float aba = 0.0f;
    private float bwH;
    private VelocityTracker cE;
    private int count = 0;
    private ag handler = new ag(Looper.getMainLooper());
    private int hmV;
    private int hmW;
    private long jEP = 0;
    private long jEQ = 0;
    private float jER = 0.0f;
    private float jES = 0.0f;
    private long jET = 0;
    private boolean jEU = false;
    private OverScroller jEV;
    private GestureDetector jEW;
    private RectF jEX = new RectF();
    private float jEZ;
    private boolean jFa = false;
    private boolean jFb = false;
    private boolean jFc = false;
    private boolean jFd = false;
    private MultiTouchImageView jFl;
    private boolean nZh = false;
    private boolean nZi = false;
    private boolean nZj = false;
    private boolean tyA = false;
    private boolean tyB = false;
    private int tyC = 0;
    private final int tyQ = 60;
    private final int tyR = 500;
    public boolean tyx = false;
    private boolean tyy = false;
    private boolean tyz = false;
    public l uAf;
    public l uAg;
    public l uAh;
    private a uAi;
    private f uAj;
    private c uAk;
    private e uAl;
    private boolean uAm = true;
    private b uAn;

    static /* synthetic */ void z(MMGestureGallery mMGestureGallery) {
        mMGestureGallery.aSa();
        mMGestureGallery.uAf.h(1, 15, 15);
    }

    public void setSingleClickOverListener(f fVar) {
        this.uAj = fVar;
    }

    public void setLongClickOverListener(c cVar) {
        this.uAk = cVar;
    }

    public void setScrollLeftRightListener(e eVar) {
        this.uAl = eVar;
    }

    public MMGestureGallery(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setStaticTransformationsEnabled(true);
    }

    private void aSa() {
        this.uAf.removeMessages(1);
    }

    public void setGalleryScaleListener(b bVar) {
        this.uAn = bVar;
    }

    public void setLoadQuit(boolean z) {
        this.uAm = z;
    }

    public MMGestureGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setStaticTransformationsEnabled(true);
        this.jEW = new GestureDetector(context, new d(this, (byte) 0));
        this.uAf = new l(new WeakReference(this));
        this.uAg = new l(new WeakReference(this));
        this.uAh = new l(new WeakReference(this));
        this.jEV = new OverScroller(context, new DecelerateInterpolator(2.0f));
        this.tyC = (int) (getResources().getDisplayMetrics().density * 3000.0f);
        setOnTouchListener(new 1(this));
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.hmV = MeasureSpec.getSize(i);
        this.hmW = MeasureSpec.getSize(i2);
        this.jEX.set(0.0f, 0.0f, (float) this.hmV, (float) this.hmW);
        x.v("MicroMsg.MMGestureGallery", "MMGestureGallery width:" + this.hmV + " height:" + this.hmW);
    }

    private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.tyy) {
            return true;
        }
        this.tyz = true;
        if (this.uAl != null) {
            this.uAl.bDu();
        }
        return super.onScroll(motionEvent, motionEvent2, f, f2);
    }

    private boolean a(float f, float f2, View view, float f3) {
        boolean z;
        if (this.tyz || this.tyy) {
            z = false;
        } else {
            if (getPositionForView(view) == getAdapter().getCount() - 1) {
                if (this.tyB) {
                    if (f3 > 0.0f) {
                        if (f2 >= ((float) this.hmV)) {
                            this.jFl.V(-f3, 0.0f);
                        } else if (f2 > ((float) this.hmV) * 0.7f && f2 < ((float) this.hmW)) {
                            this.jFl.V(-(f3 * 0.3f), 0.0f);
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                } else if (f3 > 0.0f) {
                    if (f2 < ((float) this.hmV)) {
                        this.tyB = true;
                    }
                    if (f2 >= ((float) this.hmV)) {
                        this.jFl.V(-f3, 0.0f);
                    } else if (f2 > ((float) this.hmV) * 0.7f && f2 < ((float) this.hmW)) {
                        this.jFl.V(-(f3 * 0.3f), 0.0f);
                    }
                    z = true;
                }
            }
            this.tyB = false;
            z = false;
        }
        if (z) {
            return true;
        }
        if (this.tyz || this.tyy) {
            z = false;
        } else {
            if (getPositionForView(view) == 0) {
                if (this.tyA) {
                    if (f3 < 0.0f) {
                        if (f > 0.0f && f < ((float) this.hmV) * 0.3f) {
                            this.jFl.V(-(f3 * 0.3f), 0.0f);
                        } else if (f <= 0.0f) {
                            this.jFl.V(-f3, 0.0f);
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                } else if (f3 < 0.0f) {
                    if (f > 0.0f) {
                        this.tyA = true;
                    }
                    if (f > 0.0f && f < ((float) this.hmV) * 0.3f) {
                        this.jFl.V(-(f3 * 0.3f), 0.0f);
                    } else if (f <= 0.0f) {
                        this.jFl.V(-f3, 0.0f);
                    }
                    z = true;
                }
            }
            this.tyA = false;
            z = false;
        }
        if (z) {
            return true;
        }
        return false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.jEU || this.nZh) {
            return true;
        }
        View selectedView = getSelectedView();
        if (selectedView instanceof ViewGroup) {
            View findViewById = selectedView.findViewById(g.image_gallery_download_success);
            if (findViewById == null || findViewById.getVisibility() == 8) {
                return a(motionEvent, motionEvent2, f, f2);
            }
            selectedView = findViewById.findViewById(g.image);
            if (selectedView == null) {
                return a(motionEvent, motionEvent2, f, f2);
            }
        }
        if (!(selectedView instanceof MultiTouchImageView)) {
            return a(motionEvent, motionEvent2, f, f2);
        }
        this.jFl = (MultiTouchImageView) selectedView;
        float[] fArr = new float[9];
        this.jFl.getImageMatrix().getValues(fArr);
        float scale = this.jFl.getScale() * ((float) this.jFl.getImageWidth());
        float scale2 = this.jFl.getScale() * ((float) this.jFl.getImageHeight());
        float f3 = fArr[2];
        float f4 = f3 + scale;
        float f5 = fArr[5];
        float f6 = f5 + scale2;
        this.jFl.getGlobalVisibleRect(new Rect());
        if (((int) scale) > this.hmV || ((int) scale2) > this.hmW) {
            if (((int) scale) > this.hmV || ((int) scale2) <= this.hmW) {
                if (((int) scale) <= this.hmV || ((int) scale2) > this.hmW) {
                    if (Math.abs(f2) > Math.abs(f)) {
                        if (f != 0.0f) {
                            this.tyz = true;
                            if (f < 0.0f) {
                                if (f3 > this.jEX.left) {
                                    this.jFc = true;
                                }
                                if (f3 > this.jEX.left && f4 >= ((float) this.hmV)) {
                                    if (f3 > this.jEX.left && f3 < ((float) this.hmV) * 0.3f) {
                                        f *= 0.3f;
                                    }
                                }
                                if (f2 != 0.0f) {
                                    this.tyy = true;
                                    if (f2 < 0.0f) {
                                        if (f5 > this.jEX.top) {
                                            this.jFa = true;
                                        }
                                        if (f5 > this.jEX.top && f6 >= ((float) this.hmW)) {
                                            if (f5 > this.jEX.top && f5 < ((float) this.hmW) * 0.3f) {
                                                f2 *= 0.3f;
                                            }
                                        }
                                        this.jFl.V(-f, -f2);
                                        return true;
                                    }
                                    if (f6 < this.jEX.bottom) {
                                        this.jFb = true;
                                    }
                                    if (f5 <= 0.0f && f6 < ((float) this.hmW)) {
                                        if (f6 > ((float) this.hmW) * 0.7f && f6 < ((float) this.hmW)) {
                                            f2 *= 0.3f;
                                        }
                                    }
                                    this.jFl.V(-f, -f2);
                                    return true;
                                }
                                f2 = 0.0f;
                                this.jFl.V(-f, -f2);
                                return true;
                            }
                            if (f4 < this.jEX.right) {
                                this.jFd = true;
                            }
                            if (f3 <= 0.0f && f4 < ((float) this.hmV)) {
                                if (f4 > ((float) this.hmV) * 0.7f && f4 < ((float) this.hmV)) {
                                    f *= 0.3f;
                                }
                            }
                            if (f2 != 0.0f) {
                                this.tyy = true;
                                if (f2 < 0.0f) {
                                    if (f5 > this.jEX.top) {
                                        this.jFa = true;
                                    }
                                    if (f5 > this.jEX.top && f6 >= ((float) this.hmW)) {
                                        if (f5 > this.jEX.top && f5 < ((float) this.hmW) * 0.3f) {
                                            f2 *= 0.3f;
                                        }
                                    }
                                    this.jFl.V(-f, -f2);
                                    return true;
                                }
                                if (f6 < this.jEX.bottom) {
                                    this.jFb = true;
                                }
                                if (f5 <= 0.0f && f6 < ((float) this.hmW)) {
                                    if (f6 > ((float) this.hmW) * 0.7f && f6 < ((float) this.hmW)) {
                                        f2 *= 0.3f;
                                    }
                                }
                                this.jFl.V(-f, -f2);
                                return true;
                            }
                            f2 = 0.0f;
                            this.jFl.V(-f, -f2);
                            return true;
                        }
                        f = 0.0f;
                        if (f2 != 0.0f) {
                            this.tyy = true;
                            if (f2 < 0.0f) {
                                if (f5 > this.jEX.top) {
                                    this.jFa = true;
                                }
                                if (f5 > this.jEX.top && f6 >= ((float) this.hmW)) {
                                    if (f5 > this.jEX.top && f5 < ((float) this.hmW) * 0.3f) {
                                        f2 *= 0.3f;
                                    }
                                }
                                this.jFl.V(-f, -f2);
                                return true;
                            }
                            if (f6 < this.jEX.bottom) {
                                this.jFb = true;
                            }
                            if (f5 <= 0.0f && f6 < ((float) this.hmW)) {
                                if (f6 > ((float) this.hmW) * 0.7f && f6 < ((float) this.hmW)) {
                                    f2 *= 0.3f;
                                }
                            }
                            this.jFl.V(-f, -f2);
                            return true;
                        }
                        f2 = 0.0f;
                        this.jFl.V(-f, -f2);
                        return true;
                    } else if (a(f3, f4, selectedView, f)) {
                        return true;
                    } else {
                        if (f > 0.0f) {
                            if (f4 <= ((float) this.hmV)) {
                                return a(motionEvent, motionEvent2, f, 0.0f);
                            }
                        } else if (f3 >= 0.0f) {
                            return a(motionEvent, motionEvent2, f, 0.0f);
                        }
                        if (!this.tyz) {
                            this.jFl.V(-f, -f2);
                        }
                        return true;
                    }
                } else if (a(f3, f4, selectedView, f)) {
                    return true;
                } else {
                    if (f > 0.0f) {
                        if (f4 <= ((float) this.hmV)) {
                            return a(motionEvent, motionEvent2, f, 0.0f);
                        }
                    } else if (f3 >= 0.0f) {
                        return a(motionEvent, motionEvent2, f, 0.0f);
                    }
                    if (!this.tyz) {
                        this.jFl.V(-f, 0.0f);
                    }
                    return true;
                }
            } else if (Math.abs(f2) > Math.abs(f)) {
                if (this.tyz || this.tyA || this.tyB) {
                    return true;
                }
                this.tyy = true;
                float f7 = 0.0f;
                float f8 = 0.0f;
                if (f2 < 0.0f) {
                    if (f5 > this.jEX.top) {
                        this.jFa = true;
                    }
                    if (f5 <= this.jEX.top || f6 < ((float) this.hmW)) {
                        f8 = -f2;
                    } else if (f5 > this.jEX.top && f5 < ((float) this.hmW) * 0.3f) {
                        f8 = -(0.3f * f2);
                    }
                } else {
                    if (f6 < this.jEX.bottom) {
                        this.jFb = true;
                    }
                    if (f5 > 0.0f || f6 >= ((float) this.hmW)) {
                        f8 = -f2;
                    } else if (f6 > ((float) this.hmW) * 0.7f && f6 < ((float) this.hmW)) {
                        f8 = -(0.3f * f2);
                    }
                }
                if (f < 0.0f && f3 > this.jEX.left) {
                    this.jFc = true;
                    f7 = -(0.3f * f);
                } else if (f > 0.0f && f4 < this.jEX.right) {
                    this.jFd = true;
                    f7 = -(0.3f * f);
                }
                this.jFl.V(f7, f8);
                return true;
            } else if (a(f3, f4, selectedView, f)) {
                return true;
            } else {
                if (f > 0.0f) {
                    if (f4 <= ((float) this.hmV)) {
                        if (f4 > ((float) this.hmV) * 0.7f) {
                            return a(motionEvent, motionEvent2, 0.3f * f, 0.0f);
                        }
                        return a(motionEvent, motionEvent2, 0.0f, 0.0f);
                    }
                } else if (f3 >= 0.0f) {
                    if (f3 < ((float) this.hmV) * 0.3f) {
                        return a(motionEvent, motionEvent2, 0.3f * f, 0.0f);
                    }
                    return a(motionEvent, motionEvent2, 0.0f, 0.0f);
                }
                if (!this.tyz) {
                    this.jFl.V(-f, 0.0f);
                }
                return true;
            }
        } else if (a(f3, f4, selectedView, f)) {
            return true;
        } else {
            if (f > 0.0f) {
                if (f4 <= ((float) this.hmV)) {
                    return a(motionEvent, motionEvent2, f, 0.0f);
                }
            } else if (f3 >= 0.0f) {
                return a(motionEvent, motionEvent2, f, 0.0f);
            }
            if (!this.tyz) {
                this.jFl.V(-f, 0.0f);
            }
            return true;
        }
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (this.jEV != null) {
            this.jEV.forceFinished(true);
        }
        return super.onDown(motionEvent);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        View selectedView = getSelectedView();
        if (selectedView instanceof ViewGroup) {
            selectedView = selectedView.findViewById(g.image_gallery_download_success);
            if (selectedView == null || selectedView.getVisibility() == 8) {
                a(motionEvent, motionEvent2, f);
                return false;
            }
            selectedView = selectedView.findViewById(g.image);
            if (selectedView == null) {
                a(motionEvent, motionEvent2, f);
                return false;
            }
        }
        if (selectedView instanceof MultiTouchImageView) {
            MultiTouchImageView multiTouchImageView = (MultiTouchImageView) selectedView;
            float scale = multiTouchImageView.getScale() * ((float) multiTouchImageView.getImageWidth());
            float scale2 = multiTouchImageView.getScale() * ((float) multiTouchImageView.getImageHeight());
            if (multiTouchImageView.tzB || multiTouchImageView.tzC || ((int) scale) > this.hmV || ((int) scale2) > this.hmW) {
                float f3;
                r4 = new float[9];
                multiTouchImageView.getImageMatrix().getValues(r4);
                float f4 = r4[2];
                float f5 = f4 + scale;
                float f6 = r4[5];
                float f7 = f6 + scale2;
                x.d("MicroMsg.MMGestureGallery", "jacks left: %f,right: %f isGestureRight=> %B, vX: %s, vY: %s", new Object[]{Float.valueOf(f4), Float.valueOf(f5), Boolean.valueOf(b(motionEvent, motionEvent2)), Float.valueOf(f), Float.valueOf(f2)});
                if (((float) Math.round(f4)) >= this.jEX.left || ((float) Math.round(f5)) <= this.jEX.right) {
                    f3 = 0.0f;
                } else {
                    f3 = f;
                }
                if (((float) Math.round(f6)) >= this.jEX.top || ((float) Math.round(f7)) <= this.jEX.bottom) {
                    f2 = 0.0f;
                }
                if (((float) Math.round(f6)) < this.jEX.top) {
                    this.tyx = true;
                } else {
                    this.tyx = false;
                }
                int i = (int) (this.jEX.right - scale);
                int i2 = (int) (scale + this.jEX.right);
                int i3 = (int) (this.jEX.bottom - scale2);
                int i4 = (int) (this.jEX.bottom + scale2);
                if (f3 >= 0.0f) {
                    if (Math.abs(f3) >= ((float) this.tyC)) {
                        f3 = (float) this.tyC;
                    }
                    f6 = f3;
                } else {
                    if (Math.abs(f3) >= ((float) this.tyC)) {
                        f3 = (float) (-this.tyC);
                    }
                    f6 = f3;
                }
                if (f2 >= 0.0f) {
                    if (Math.abs(f2) >= ((float) this.tyC)) {
                        f2 = (float) this.tyC;
                    }
                } else if (Math.abs(f2) >= ((float) this.tyC)) {
                    f2 = (float) (-this.tyC);
                }
                this.jEV.forceFinished(true);
                this.jEV.fling(this.jEV.getCurrX(), this.jEV.getCurrY(), (int) f6, (int) f2, i, i2, i3, i4, 0, 0);
                if ((!b(motionEvent, motionEvent2) || f4 < 0.0f) && (b(motionEvent, motionEvent2) || f5 > ((float) this.hmV))) {
                    return true;
                }
            }
        }
        if (this.jEU) {
            return true;
        }
        a(motionEvent, motionEvent2, f);
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.nZj = true;
        super.onLongPress(motionEvent);
    }

    private static boolean b(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return motionEvent.getX() - motionEvent2.getX() < 0.0f;
    }

    private void a(MotionEvent motionEvent, MotionEvent motionEvent2, float f) {
        float x = motionEvent.getX() - motionEvent2.getX();
        float y = motionEvent.getY() - motionEvent2.getY();
        boolean b = b(motionEvent, motionEvent2);
        x = Math.abs(x);
        y = Math.abs(y);
        if (Math.abs(f) <= 500.0f || x < 60.0f || x < y) {
            return;
        }
        if (b) {
            onKeyDown(21, null);
        } else {
            onKeyDown(22, null);
        }
    }

    public int getScreenWidth() {
        return this.hmV;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.jEW.onTouchEvent(motionEvent);
        x.d("dktest", "onTouchEvent event.getAction()" + motionEvent.getAction());
        switch (motionEvent.getAction()) {
            case 1:
                View selectedView = getSelectedView();
                if (selectedView instanceof MultiTouchImageView) {
                    this.jFl = (MultiTouchImageView) selectedView;
                    float scale = this.jFl.getScale() * ((float) this.jFl.getImageWidth());
                    float scale2 = this.jFl.getScale() * ((float) this.jFl.getImageHeight());
                    if (((int) scale) <= this.hmV && ((int) scale2) <= this.hmW) {
                        x.i("dktest", "onTouchEvent width:" + scale + "height:" + scale2);
                        break;
                    }
                    float[] fArr = new float[9];
                    this.jFl.getImageMatrix().getValues(fArr);
                    scale = fArr[5];
                    x.d("dktest", "onTouchEvent top:" + scale + " height:" + scale2 + " bottom:" + (scale + scale2));
                    break;
                }
                break;
        }
        computeScroll();
        return super.onTouchEvent(motionEvent);
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            super.onFocusChanged(z, i, rect);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (z) {
            super.onWindowFocusChanged(z);
        }
    }

    public void computeScroll() {
        int i = 0;
        if (this.jFl != null && this.jEV.computeScrollOffset()) {
            int currX = this.jEV.getCurrX() - this.SQ;
            int currY = this.jEV.getCurrY() - this.SR;
            this.SQ = this.jEV.getCurrX();
            this.SR = this.jEV.getCurrY();
            float scale = this.jFl.getScale() * ((float) this.jFl.getImageWidth());
            float scale2 = this.jFl.getScale() * ((float) this.jFl.getImageHeight());
            float[] fArr = new float[9];
            this.jFl.getImageMatrix().getValues(fArr);
            float f = fArr[2];
            scale += f;
            float f2 = fArr[5];
            float f3 = f2 + scale2;
            if (currX < 0 && ((float) currX) < this.jEX.right - ((float) Math.round(scale))) {
                currX = (int) (this.jEX.right - ((float) Math.round(scale)));
            }
            if (currX > 0 && ((float) currX) > this.jEX.left - ((float) Math.round(f))) {
                currX = (int) (this.jEX.left - ((float) Math.round(f)));
            }
            if (currY < 0 && ((float) currY) < this.jEX.bottom - ((float) Math.round(f3))) {
                currY = (int) (this.jEX.bottom - ((float) Math.round(f3)));
            }
            if (currY > 0 && ((float) currY) > this.jEX.top - ((float) Math.round(f2))) {
                currY = (int) (this.jEX.top - ((float) Math.round(f2)));
            }
            if (((float) Math.round(f)) >= this.jEX.left || ((float) Math.round(scale)) <= this.jEX.right) {
                currX = 0;
            } else if (((float) Math.round(f2)) >= this.jEX.top || ((float) Math.round(f3)) <= this.jEX.bottom) {
                currY = 0;
            }
            if (scale2 >= ((float) this.hmW)) {
                i = currY;
            }
            this.jFl.V((float) currX, (float) i);
            postInvalidate();
        }
    }

    public boolean isFocused() {
        return true;
    }
}
