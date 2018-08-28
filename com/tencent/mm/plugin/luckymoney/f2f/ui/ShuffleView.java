package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public class ShuffleView extends FrameLayout {
    public static DisplayMetrics ewi;
    View eRT;
    GestureDetector iEv = new GestureDetector(new 14(this));
    List<View> kOO = new ArrayList();
    private c kOP = new c();
    ValueAnimator kOQ;
    private ValueAnimator kOR;
    ValueAnimator kOS;
    ValueAnimator kOT;
    private a kOU;
    private a kOV;
    private b kOW;
    View kOX;
    private View kOY;
    int kOZ;
    private View kPa;
    private int kPb;
    int kPc;
    private float kPd;
    private float kPe;
    private final float kPf = 0.23f;
    private final float kPg = 0.28f;
    private final float kPh = 0.33f;
    private ArrayList<Float> kPi = new ArrayList();
    private ArrayList<Float> kPj = new ArrayList();
    private boolean kPk;
    private int kPl = getResources().getDimensionPixelSize(d.lucky_money_f2f_shuffle_view_touch_error_distance);
    private int kPm = 2500;

    public ShuffleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setShuffleSetting(c cVar) {
        this.kOP = cVar;
        this.kOS = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration((long) cVar.kPu);
        this.kOT = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration((long) cVar.kPv);
    }

    public void setAllShuffleCards(List<View> list) {
        this.kOO.clear();
        this.kOO.addAll(list);
        this.kOZ = 0;
        this.eRT = null;
        this.kPb = -1;
        this.kPa = null;
        removeAllViews();
        List list2 = this.kOO;
        if (list2.size() > 100) {
            this.kPc = 100;
        } else {
            this.kPc = list2.size();
            if (this.kPc == 1) {
                ((View) list2.get(0)).findViewById(f.lucky_money_f2f_single_card).setVisibility(0);
            }
        }
        for (int i = this.kPc - 1; i >= 0; i--) {
            addView((View) list2.get(i));
        }
        addOnLayoutChangeListener(new 1(this));
    }

    private void baO() {
        if (this.kPc > 1) {
            x.d("ShuffleView", "card width: %d,height: %d", new Object[]{Integer.valueOf(((View) this.kOO.get(0)).getWidth()), Integer.valueOf(((View) this.kOO.get(0)).getHeight())});
            if (this.kOP.kPr == 2) {
                this.kPd = (((float) ((View) this.kOO.get(0)).getWidth()) * 1.5f) / ((float) this.kPc);
                if (this.kPd > ((float) ((View) this.kOO.get(0)).getWidth()) * 0.23f) {
                    this.kPd = ((float) ((View) this.kOO.get(0)).getWidth()) * 0.23f;
                    return;
                }
                return;
            } else if (this.kOP.kPr == 1) {
                this.kPe = (((float) ((View) this.kOO.get(0)).getHeight()) * 1.0f) / ((float) this.kPc);
                return;
            } else {
                return;
            }
        }
        this.kPd = 0.0f;
        this.kPe = 0.0f;
    }

    final void A(View view, int i) {
        if (this.kOP.kPr == 1) {
            view.setScaleX(1.0f - (this.kOP.scaleX * ((float) i)));
            view.setTranslationY(sc(i));
        } else if (this.kOP.kPr == 2) {
            view.setScaleY(1.0f - (this.kOP.scaleY * ((float) i)));
            view.setTranslationX(sb(i));
        }
    }

    public final float sb(int i) {
        if (this.kOP.kPr == 2 && this.kPc > 0) {
            if (this.kOP.kPs == 3) {
                return ((((float) (this.kPc - 1)) * 0.5f) * this.kPd) - (this.kPd * ((float) i));
            }
            if (this.kOP.kPs == 4) {
                return (this.kPd * ((float) i)) - ((((float) (this.kPc - 1)) * 0.5f) * this.kPd);
            }
        }
        return 0.0f;
    }

    public final float sc(int i) {
        if (this.kOP.kPr == 1) {
            if (this.kOP.kPs == 1) {
                return ((((float) (this.kPc - 1)) * 0.5f) * this.kPe) - (this.kPe * ((float) i));
            }
            if (this.kOP.kPs == 2) {
                return (this.kPe * ((float) i)) - ((((float) (this.kPc - 1)) * 0.5f) * this.kPe);
            }
        }
        return 0.0f;
    }

    /* renamed from: baP */
    final int y() {
        return (int) (Math.random() * ((double) this.kPc));
    }

    private void baQ() {
        if (this.eRT != null) {
            x.i("ShuffleView", "selectView != null, cancel select");
            if (this.kOT.isStarted()) {
                this.kOT.cancel();
            }
            this.kOT.removeAllUpdateListeners();
            this.kOT.removeAllListeners();
            switch (this.kOP.kPs) {
                case 4:
                    if (this.kOZ >= 0) {
                        this.kOT.addUpdateListener(new 8(this));
                        break;
                    }
                    break;
            }
            this.eRT = null;
            this.kOZ = 0;
            this.kOT.start();
        }
    }

    private float getSelectScaleTranslationX() {
        if (this.eRT != null) {
            float width = (0.33f * ((float) this.eRT.getWidth())) - this.kPd;
            int i = this.kOZ - 1;
            int i2 = (this.kPc - 1) - this.kOZ;
            int i3 = 0;
            if (i > 0) {
                i3 = i + 0;
            }
            if (i2 > 0) {
                i3 += i2;
            }
            if (i3 > 0) {
                return (width * 2.0f) / ((float) i3);
            }
        }
        return 0.0f;
    }

    /* renamed from: sd */
    final void c(int i) {
        if (i >= 0 && i < this.kPc) {
            x.i("ShuffleView", "select card " + i);
            if (this.kOT.isStarted()) {
                this.kOT.cancel();
            }
            this.kOT.removeAllUpdateListeners();
            this.kOT.removeAllListeners();
            this.eRT = (View) this.kOO.get(i);
            this.kOZ = i;
            this.kPa = null;
            this.kPb = -1;
            switch (this.kOP.kPs) {
                case 4:
                    if (i <= 0) {
                        this.kOT.addUpdateListener(new 10(this));
                        break;
                    }
                    this.kOT.addUpdateListener(new 9(this, i - 1, (this.kPc - 1) - i));
                    break;
            }
            this.kOT.start();
        }
    }

    private void baR() {
        if (this.kPa != null) {
            x.i("ShuffleView", "touchView != null,cancel touch");
            if (this.kOT.isStarted()) {
                this.kOT.cancel();
            }
            this.kOT.removeAllUpdateListeners();
            this.kOT.removeAllListeners();
            switch (this.kOP.kPs) {
                case 4:
                    if (this.kPb >= 0) {
                        this.kOT.addUpdateListener(new 11(this));
                        break;
                    }
                    break;
            }
            this.kPa = null;
            this.kPb = -1;
            this.kOT.start();
        }
    }

    private float getTouchScaleTranslationX() {
        if (this.kPa != null) {
            float width = (0.28f * ((float) this.kPa.getWidth())) - this.kPd;
            int i = this.kPb - 1;
            int i2 = (this.kPc - 1) - this.kPb;
            int i3 = 0;
            if (i > 0) {
                i3 = i + 0;
            }
            if (i2 > 0) {
                i3 += i2;
            }
            if (i3 > 0) {
                return (width * 2.0f) / ((float) i3);
            }
        }
        return 0.0f;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.kPk) {
            return true;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.kPc <= 0) {
            return false;
        }
        x.d("ShuffleView", "y:%d,packet largest:%d", new Object[]{Integer.valueOf(y), Integer.valueOf((getHeight() - ((View) this.kOO.get(0)).getHeight()) - (((View) this.kOO.get(0)).getHeight() / 7))});
        if (y >= (getHeight() - ((View) this.kOO.get(0)).getHeight()) - (((View) this.kOO.get(0)).getHeight() / 7)) {
            int i;
            for (i = 0; i < this.kPc; i++) {
                Rect se = se(i);
                if (se != null && se.contains(x, y)) {
                    i = 1;
                    break;
                }
            }
            boolean z = false;
            if (i == 0) {
                x.d("ShuffleView", "event %d out of cards,%d,%d", new Object[]{Integer.valueOf(motionEvent.getActionMasked()), Integer.valueOf(x), Integer.valueOf(y)});
                if (this.eRT != null && motionEvent.getActionMasked() == 0) {
                    if (this.kOW != null) {
                        this.kOW.cN(this.kOZ, this.kPc);
                    }
                    baQ();
                } else if (this.kPa != null && this.kPa.getTranslationY() == ((float) ((-this.kPa.getHeight()) / 7))) {
                    if (this.kOW != null) {
                        this.kOW.rZ(this.kPc);
                    }
                    c(this.kPb);
                } else if (this.kPa != null) {
                    baR();
                }
            }
            if (this.kPc <= 1) {
                return false;
            }
            x.i("ShuffleView", "ret:%s,action:%s", new Object[]{Boolean.valueOf(this.iEv.onTouchEvent(motionEvent)), Integer.valueOf(motionEvent.getActionMasked())});
            if (!this.iEv.onTouchEvent(motionEvent) && motionEvent.getActionMasked() == 1) {
                if (this.kPa != null && this.kPa.getTranslationY() == ((float) ((-this.kPa.getHeight()) / 7))) {
                    if (this.kOW != null) {
                        this.kOW.rZ(this.kPc);
                    }
                    c(this.kPb);
                } else if (this.kPa != null) {
                    baR();
                }
            }
            return true;
        } else if (this.eRT != null && motionEvent.getActionMasked() == 0) {
            if (this.kOW != null) {
                this.kOW.cN(this.kOZ, this.kPc);
            }
            baQ();
            return false;
        } else if (this.kPa != null && this.kPa.getTranslationY() == ((float) ((-this.kPa.getHeight()) / 7))) {
            if (this.kOW != null) {
                this.kOW.rZ(this.kPc);
            }
            c(this.kPb);
            return false;
        } else if (this.kPa == null) {
            return false;
        } else {
            baR();
            return false;
        }
    }

    private Rect se(int i) {
        if (i >= 0 && i < this.kPc) {
            View view = (View) this.kOO.get(i);
            switch (this.kOP.kPs) {
                case 4:
                    if (i == 0) {
                        return new Rect(view.getLeft() + ((int) view.getTranslationX()), view.getTop() + ((int) view.getTranslationY()), view.getRight() + ((int) view.getTranslationX()), ((int) view.getTranslationY()) + view.getBottom());
                    }
                    View view2 = (View) this.kOO.get(i - 1);
                    return new Rect(((int) view2.getTranslationX()) + view2.getRight(), view.getTop() + ((int) view.getTranslationY()), view.getRight() + ((int) view.getTranslationX()), ((int) view.getTranslationY()) + view.getBottom());
            }
        }
        return null;
    }

    /* renamed from: sf */
    final void f(int i) {
        this.kOS.removeAllUpdateListeners();
        this.kOS.removeAllListeners();
        if (this.kOO.size() < this.kPc) {
            this.kPc--;
            if (this.kPc == 1) {
                ((View) this.kOO.get(0)).findViewById(f.lucky_money_f2f_single_card).setVisibility(0);
            }
            baO();
            this.kOS.addUpdateListener(new 15(this));
            this.kOS.addListener(new 2(this));
        } else {
            this.kOY = (View) this.kOO.get(this.kPc - 1);
            A(this.kOY, this.kPc - 1);
            addView(this.kOY, 0);
            if (this.kOR != null) {
                switch (this.kOP.kPt) {
                    case 1:
                        this.kOY.setTranslationY((float) (-ewi.heightPixels));
                        break;
                    case 2:
                        this.kOY.setTranslationY((float) ewi.heightPixels);
                        break;
                    case 3:
                        this.kOY.setTranslationX((float) (-ewi.widthPixels));
                        break;
                    case 4:
                        this.kOY.setTranslationX((float) ewi.widthPixels);
                        break;
                }
            }
            this.kOY.setVisibility(4);
            this.kOS.addUpdateListener(new 3(this, i));
            this.kOS.addListener(new 4(this));
        }
        this.kOS.start();
    }

    public void setExitAnimator(ValueAnimator valueAnimator) {
        if (this.kOQ != null) {
            this.kOQ.removeAllListeners();
            this.kOQ.cancel();
        }
        this.kOQ = valueAnimator;
        if (this.kOQ != null) {
            this.kOQ.addUpdateListener(new 6(this));
        }
    }

    public void setEnterAnimator(ValueAnimator valueAnimator) {
        if (this.kOR != null) {
            this.kOR.removeAllListeners();
            this.kOR.cancel();
        }
        this.kOR = valueAnimator;
        if (this.kOR != null) {
            this.kOR.addUpdateListener(new 7(this));
        }
    }

    public void setExitAnimatorListener(a aVar) {
        this.kOU = aVar;
    }

    public void setEnterAnimatorListener(a aVar) {
        this.kOV = aVar;
    }

    public void setCardListener(b bVar) {
        this.kOW = bVar;
    }

    public View getExitView() {
        return this.kOX;
    }

    public View getEnterView() {
        return this.kOY;
    }
}
