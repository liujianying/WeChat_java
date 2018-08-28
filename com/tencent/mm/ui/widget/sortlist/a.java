package com.tencent.mm.ui.widget.sortlist;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

public final class a extends d implements OnGestureListener, OnTouchListener {
    private int fW;
    private int gbM;
    private int gbN;
    private int ioh;
    private GestureDetector uG;
    private int uMT = 0;
    boolean uMU = true;
    boolean uMV = false;
    private boolean uMW = false;
    private GestureDetector uMX;
    private int uMY = -1;
    private int uMZ = -1;
    private int uNa = -1;
    private int[] uNb = new int[2];
    private int uNc;
    private int uNd;
    private boolean uNe = false;
    private float uNf = 500.0f;
    private int uNg;
    private int uNh;
    private int uNi;
    private boolean uNj;
    private DragSortListView uNk;
    private int uNl;
    private OnGestureListener uNm = new 1(this);

    public a(DragSortListView dragSortListView, int i, int i2, int i3, int i4, int i5) {
        super(dragSortListView);
        this.uNk = dragSortListView;
        this.uG = new GestureDetector(dragSortListView.getContext(), this);
        this.uMX = new GestureDetector(dragSortListView.getContext(), this.uNm);
        this.uMX.setIsLongpressEnabled(false);
        this.fW = ViewConfiguration.get(dragSortListView.getContext()).getScaledTouchSlop();
        this.uNg = i;
        this.uNh = i4;
        this.uNi = i5;
        this.ioh = i3;
        this.uMT = i2;
    }

    private boolean as(int i, int i2, int i3) {
        int i4;
        int i5;
        boolean z = false;
        if (!this.uMU || this.uMW) {
            i4 = 0;
        } else {
            i4 = 12;
        }
        if (this.uMV && this.uMW) {
            i5 = (i4 | 1) | 2;
        } else {
            i5 = i4;
        }
        DragSortListView dragSortListView = this.uNk;
        int headerViewsCount = i - this.uNk.getHeaderViewsCount();
        if (dragSortListView.uNZ && dragSortListView.uOa != null) {
            View GK = dragSortListView.uOa.GK(headerViewsCount);
            if (GK != null) {
                z = dragSortListView.a(headerViewsCount, GK, i5, i2, i3);
            }
        }
        this.uNe = z;
        return this.uNe;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.uNk.uNF && !this.uNk.uOp) {
            this.uG.onTouchEvent(motionEvent);
            if (this.uMV && this.uNe && this.ioh == 1) {
                this.uMX.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.gbM = (int) motionEvent.getX();
                    this.gbN = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.uMV && this.uMW) {
                        if ((this.uNl >= 0 ? this.uNl : -this.uNl) > this.uNk.getWidth() / 2) {
                            this.uNk.aE(0.0f);
                            break;
                        }
                    }
                    break;
                case 3:
                    this.uMW = false;
                    this.uNe = false;
                    break;
            }
        }
        return false;
    }

    public final void i(Point point) {
        if (this.uMV && this.uMW) {
            this.uNl = point.x;
        }
    }

    private int k(MotionEvent motionEvent, int i) {
        int pointToPosition = this.uNk.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        int headerViewsCount = this.uNk.getHeaderViewsCount();
        int footerViewsCount = this.uNk.getFooterViewsCount();
        int count = this.uNk.getCount();
        if (pointToPosition != -1 && pointToPosition >= headerViewsCount && pointToPosition < count - footerViewsCount) {
            View childAt = this.uNk.getChildAt(pointToPosition - this.uNk.getFirstVisiblePosition());
            count = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            View findViewById = i == 0 ? childAt : childAt.findViewById(i);
            if (findViewById != null) {
                findViewById.getLocationOnScreen(this.uNb);
                if (count > this.uNb[0] && rawY > this.uNb[1] && count < this.uNb[0] + findViewById.getWidth()) {
                    if (rawY < findViewById.getHeight() + this.uNb[1]) {
                        this.uNc = childAt.getLeft();
                        this.uNd = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        int i = -1;
        if (this.uMV && this.ioh == 0) {
            this.uNa = k(motionEvent, this.uNh);
        }
        this.uMY = k(motionEvent, this.uNg);
        if (this.uMY != -1 && this.uMT == 0) {
            as(this.uMY, ((int) motionEvent.getX()) - this.uNc, ((int) motionEvent.getY()) - this.uNd);
        }
        this.uMW = false;
        this.uNj = true;
        this.uNl = 0;
        if (this.ioh == 1) {
            i = k(motionEvent, this.uNi);
        }
        this.uMZ = i;
        return true;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int x2 = (int) motionEvent2.getX();
        int y2 = (int) motionEvent2.getY();
        int i = x2 - this.uNc;
        int i2 = y2 - this.uNd;
        if (!(!this.uNj || this.uNe || (this.uMY == -1 && this.uMZ == -1))) {
            if (this.uMY != -1) {
                if (this.uMT == 1 && Math.abs(y2 - y) > this.fW && this.uMU) {
                    as(this.uMY, i, i2);
                } else if (this.uMT != 0 && Math.abs(x2 - x) > this.fW && this.uMV) {
                    this.uMW = true;
                    as(this.uMZ, i, i2);
                }
            } else if (this.uMZ != -1) {
                if (Math.abs(x2 - x) > this.fW && this.uMV) {
                    this.uMW = true;
                    as(this.uMZ, i, i2);
                } else if (Math.abs(y2 - y) > this.fW) {
                    this.uNj = false;
                }
            }
        }
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        if (this.uMY != -1 && this.uMT == 2) {
            this.uNk.performHapticFeedback(0);
            as(this.uMY, this.gbM - this.uNc, this.gbN - this.uNd);
        }
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.uMV && this.ioh == 0 && this.uNa != -1) {
            DragSortListView dragSortListView = this.uNk;
            int headerViewsCount = this.uNa - this.uNk.getHeaderViewsCount();
            dragSortListView.uOn = false;
            dragSortListView.k(headerViewsCount, 0.0f);
        }
        return true;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }
}
