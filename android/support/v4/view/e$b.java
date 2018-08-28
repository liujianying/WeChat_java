package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.tencent.smtt.utils.TbsLog;

class e$b implements e$a {
    private static final int ul = ViewConfiguration.getLongPressTimeout();
    private static final int um = ViewConfiguration.getTapTimeout();
    private static final int un = ViewConfiguration.getDoubleTapTimeout();
    private VelocityTracker cE;
    private final Handler mHandler = new a(this);
    private float uA;
    private float uB;
    private float uC;
    private float uD;
    private boolean uE;
    private int ug;
    private int uh;
    private int uj;
    private int uk;
    private final OnGestureListener uo;
    private OnDoubleTapListener uq;
    private boolean ur;
    private boolean ut;
    private boolean uu;
    private boolean uv;
    private boolean uw;
    private MotionEvent ux;
    private MotionEvent uy;
    private boolean uz;

    static /* synthetic */ void c(e$b e_b) {
        e_b.mHandler.removeMessages(3);
        e_b.ut = false;
        e_b.uu = true;
        e_b.uo.onLongPress(e_b.ux);
    }

    public e$b(Context context, OnGestureListener onGestureListener) {
        this.uo = onGestureListener;
        if (onGestureListener instanceof OnDoubleTapListener) {
            this.uq = (OnDoubleTapListener) onGestureListener;
        }
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        } else if (this.uo == null) {
            throw new IllegalArgumentException("OnGestureListener must not be null");
        } else {
            this.uE = true;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.uj = viewConfiguration.getScaledMinimumFlingVelocity();
            this.uk = viewConfiguration.getScaledMaximumFlingVelocity();
            this.ug = scaledTouchSlop * scaledTouchSlop;
            this.uh = scaledDoubleTapSlop * scaledDoubleTapSlop;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        int action = motionEvent.getAction();
        if (this.cE == null) {
            this.cE = VelocityTracker.obtain();
        }
        this.cE.addMovement(motionEvent);
        boolean z = (action & 255) == 6;
        int e = z ? o.e(motionEvent) : -1;
        int f = o.f(motionEvent);
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (i = 0; i < f; i++) {
            if (e != i) {
                f3 += o.d(motionEvent, i);
                f2 += o.e(motionEvent, i);
            }
        }
        e = z ? f - 1 : f;
        f3 /= (float) e;
        f2 /= (float) e;
        boolean hasMessages;
        float b;
        float a;
        switch (action & 255) {
            case 0:
                if (this.uq != null) {
                    hasMessages = this.mHandler.hasMessages(3);
                    if (hasMessages) {
                        this.mHandler.removeMessages(3);
                    }
                    if (!(this.ux == null || this.uy == null || !hasMessages)) {
                        MotionEvent motionEvent2 = this.ux;
                        MotionEvent motionEvent3 = this.uy;
                        if (this.uw && motionEvent.getEventTime() - motionEvent3.getEventTime() <= ((long) un)) {
                            f = ((int) motionEvent2.getX()) - ((int) motionEvent.getX());
                            e = ((int) motionEvent2.getY()) - ((int) motionEvent.getY());
                            if ((e * e) + (f * f) < this.uh) {
                                hasMessages = true;
                                if (hasMessages) {
                                    this.uz = true;
                                    e = (this.uq.onDoubleTap(this.ux) | 0) | this.uq.onDoubleTapEvent(motionEvent);
                                    this.uA = f3;
                                    this.uC = f3;
                                    this.uB = f2;
                                    this.uD = f2;
                                    if (this.ux != null) {
                                        this.ux.recycle();
                                    }
                                    this.ux = MotionEvent.obtain(motionEvent);
                                    this.uv = true;
                                    this.uw = true;
                                    this.ur = true;
                                    this.uu = false;
                                    this.ut = false;
                                    if (this.uE) {
                                        this.mHandler.removeMessages(2);
                                        this.mHandler.sendEmptyMessageAtTime(2, (this.ux.getDownTime() + ((long) um)) + ((long) ul));
                                    }
                                    this.mHandler.sendEmptyMessageAtTime(1, this.ux.getDownTime() + ((long) um));
                                    return e | this.uo.onDown(motionEvent);
                                }
                            }
                        }
                        hasMessages = false;
                        if (hasMessages) {
                            this.uz = true;
                            e = (this.uq.onDoubleTap(this.ux) | 0) | this.uq.onDoubleTapEvent(motionEvent);
                            this.uA = f3;
                            this.uC = f3;
                            this.uB = f2;
                            this.uD = f2;
                            if (this.ux != null) {
                                this.ux.recycle();
                            }
                            this.ux = MotionEvent.obtain(motionEvent);
                            this.uv = true;
                            this.uw = true;
                            this.ur = true;
                            this.uu = false;
                            this.ut = false;
                            if (this.uE) {
                                this.mHandler.removeMessages(2);
                                this.mHandler.sendEmptyMessageAtTime(2, (this.ux.getDownTime() + ((long) um)) + ((long) ul));
                            }
                            this.mHandler.sendEmptyMessageAtTime(1, this.ux.getDownTime() + ((long) um));
                            return e | this.uo.onDown(motionEvent);
                        }
                    }
                    this.mHandler.sendEmptyMessageDelayed(3, (long) un);
                }
                e = 0;
                this.uA = f3;
                this.uC = f3;
                this.uB = f2;
                this.uD = f2;
                if (this.ux != null) {
                    this.ux.recycle();
                }
                this.ux = MotionEvent.obtain(motionEvent);
                this.uv = true;
                this.uw = true;
                this.ur = true;
                this.uu = false;
                this.ut = false;
                if (this.uE) {
                    this.mHandler.removeMessages(2);
                    this.mHandler.sendEmptyMessageAtTime(2, (this.ux.getDownTime() + ((long) um)) + ((long) ul));
                }
                this.mHandler.sendEmptyMessageAtTime(1, this.ux.getDownTime() + ((long) um));
                return e | this.uo.onDown(motionEvent);
            case 1:
                this.ur = false;
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                if (this.uz) {
                    hasMessages = this.uq.onDoubleTapEvent(motionEvent) | 0;
                } else if (this.uu) {
                    this.mHandler.removeMessages(3);
                    this.uu = false;
                    hasMessages = false;
                } else if (this.uv) {
                    hasMessages = this.uo.onSingleTapUp(motionEvent);
                    if (this.ut && this.uq != null) {
                        this.uq.onSingleTapConfirmed(motionEvent);
                    }
                } else {
                    VelocityTracker velocityTracker = this.cE;
                    int c = o.c(motionEvent, 0);
                    velocityTracker.computeCurrentVelocity(TbsLog.TBSLOG_CODE_SDK_BASE, (float) this.uk);
                    b = y.b(velocityTracker, c);
                    a = y.a(velocityTracker, c);
                    hasMessages = (Math.abs(b) > ((float) this.uj) || Math.abs(a) > ((float) this.uj)) ? this.uo.onFling(this.ux, motionEvent, a, b) : false;
                }
                if (this.uy != null) {
                    this.uy.recycle();
                }
                this.uy = obtain;
                if (this.cE != null) {
                    this.cE.recycle();
                    this.cE = null;
                }
                this.uz = false;
                this.ut = false;
                this.mHandler.removeMessages(1);
                this.mHandler.removeMessages(2);
                return hasMessages;
            case 2:
                if (this.uu) {
                    return false;
                }
                a = this.uA - f3;
                b = this.uB - f2;
                if (this.uz) {
                    return this.uq.onDoubleTapEvent(motionEvent) | 0;
                }
                if (this.uv) {
                    i = (int) (f3 - this.uC);
                    int i2 = (int) (f2 - this.uD);
                    i = (i * i) + (i2 * i2);
                    if (i > this.ug) {
                        hasMessages = this.uo.onScroll(this.ux, motionEvent, a, b);
                        this.uA = f3;
                        this.uB = f2;
                        this.uv = false;
                        this.mHandler.removeMessages(3);
                        this.mHandler.removeMessages(1);
                        this.mHandler.removeMessages(2);
                    } else {
                        hasMessages = false;
                    }
                    if (i > this.ug) {
                        this.uw = false;
                    }
                    return hasMessages;
                } else if (Math.abs(a) < 1.0f && Math.abs(b) < 1.0f) {
                    return false;
                } else {
                    boolean onScroll = this.uo.onScroll(this.ux, motionEvent, a, b);
                    this.uA = f3;
                    this.uB = f2;
                    return onScroll;
                }
            case 3:
                this.mHandler.removeMessages(1);
                this.mHandler.removeMessages(2);
                this.mHandler.removeMessages(3);
                this.cE.recycle();
                this.cE = null;
                this.uz = false;
                this.ur = false;
                this.uv = false;
                this.uw = false;
                this.ut = false;
                if (!this.uu) {
                    return false;
                }
                this.uu = false;
                return false;
            case 5:
                this.uA = f3;
                this.uC = f3;
                this.uB = f2;
                this.uD = f2;
                this.mHandler.removeMessages(1);
                this.mHandler.removeMessages(2);
                this.mHandler.removeMessages(3);
                this.uz = false;
                this.uv = false;
                this.uw = false;
                this.ut = false;
                if (!this.uu) {
                    return false;
                }
                this.uu = false;
                return false;
            case 6:
                this.uA = f3;
                this.uC = f3;
                this.uB = f2;
                this.uD = f2;
                this.cE.computeCurrentVelocity(TbsLog.TBSLOG_CODE_SDK_BASE, (float) this.uk);
                int e2 = o.e(motionEvent);
                e = o.c(motionEvent, e2);
                f3 = y.a(this.cE, e);
                float b2 = y.b(this.cE, e);
                for (e = 0; e < f; e++) {
                    if (e != e2) {
                        i = o.c(motionEvent, e);
                        if ((y.b(this.cE, i) * b2) + (y.a(this.cE, i) * f3) < 0.0f) {
                            this.cE.clear();
                            return false;
                        }
                    }
                }
                return false;
            default:
                return false;
        }
    }
}
