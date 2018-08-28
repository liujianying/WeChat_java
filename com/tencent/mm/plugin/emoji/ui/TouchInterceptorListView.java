package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.x;

public class TouchInterceptorListView extends ListView {
    private Rect bJ = new Rect();
    private final int fW;
    private GestureDetector gbw;
    private int idC;
    private ImageView inT;
    private WindowManager inU;
    private LayoutParams inV;
    private int inW;
    private int inX;
    private int inY;
    private int inZ;
    private int ioa;
    private int iob;
    private a ioc;
    private b iod;
    private c ioe;
    private int iof;
    private int iog;
    private int ioh = -1;
    private Bitmap ioi;
    private int ioj;
    private int iok;
    private Drawable iol;
    private int iom = 0;
    private int mHeight;

    public TouchInterceptorListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fW = ViewConfiguration.get(context).getScaledTouchSlop();
        Resources resources = getResources();
        this.idC = resources.getDimensionPixelSize(R.f.emoji_item_list_height) + 1;
        this.iok = this.idC / 2;
        this.ioj = this.idC * 2;
        this.iom = resources.getDimensionPixelOffset(R.f.emoji_itme_drag_width);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.ioe != null && this.gbw == null && this.ioh == 0) {
            this.gbw = new GestureDetector(getContext(), new SimpleOnGestureListener() {
                public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    if (TouchInterceptorListView.this.inT == null) {
                        return false;
                    }
                    if (f > 1000.0f) {
                        Rect b = TouchInterceptorListView.this.bJ;
                        TouchInterceptorListView.this.inT.getDrawingRect(b);
                        if (motionEvent2.getX() > ((float) ((b.right * 2) / 3))) {
                            TouchInterceptorListView.this.aGe();
                            TouchInterceptorListView.this.en(true);
                        }
                    }
                    return true;
                }
            });
        }
        if (!(this.ioc == null && this.iod == null)) {
            switch (motionEvent.getAction()) {
                case 0:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    int pointToPosition = pointToPosition(x, y);
                    if (pointToPosition != -1) {
                        ViewGroup viewGroup = (ViewGroup) getChildAt(pointToPosition - getFirstVisiblePosition());
                        this.inY = x - viewGroup.getLeft();
                        this.inZ = y - viewGroup.getTop();
                        this.ioa = ((int) motionEvent.getRawX()) - x;
                        this.iob = ((int) motionEvent.getRawY()) - y;
                        if (x >= this.iom) {
                            aGe();
                            break;
                        }
                        viewGroup.setDrawingCacheEnabled(true);
                        Bitmap createBitmap = Bitmap.createBitmap(viewGroup.getDrawingCache());
                        aGe();
                        this.inV = new LayoutParams();
                        this.inV.gravity = 49;
                        this.inV.x = (x - this.inY) + this.ioa;
                        this.inV.y = (y - this.inZ) + this.iob;
                        this.inV.height = -2;
                        this.inV.width = -2;
                        this.inV.flags = 920;
                        this.inV.format = -3;
                        this.inV.windowAnimations = 0;
                        Context context = getContext();
                        View imageView = new ImageView(context);
                        imageView.setBackgroundColor(context.getResources().getColor(R.e.white));
                        imageView.setBackgroundResource(R.g.emotionstore_emotionmanaged_cellshadow);
                        imageView.setPadding(0, 0, 0, 0);
                        imageView.setImageBitmap(createBitmap);
                        this.ioi = createBitmap;
                        this.inU = (WindowManager) context.getSystemService("window");
                        this.inU.addView(imageView, this.inV);
                        this.inT = imageView;
                        this.inW = pointToPosition;
                        this.inX = this.inW;
                        this.mHeight = getHeight();
                        int i = this.fW;
                        this.iof = Math.min(y - i, this.mHeight / 3);
                        this.iog = Math.max(i + y, (this.mHeight * 2) / 3);
                        return false;
                    }
                    break;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private int cv(int i, int i2) {
        int cv;
        if (i2 < 0) {
            cv = cv(i, this.idC + i2);
            if (cv > 0) {
                return cv - 1;
            }
        }
        Rect rect = this.bJ;
        for (cv = getChildCount() - 1; cv >= 0; cv--) {
            getChildAt(cv).getHitRect(rect);
            if (rect.contains(i, i2)) {
                return cv + getFirstVisiblePosition();
            }
        }
        return -1;
    }

    private void en(boolean z) {
        int i = 0;
        while (true) {
            View childAt = getChildAt(i);
            if (childAt == null) {
                if (z) {
                    int firstVisiblePosition = getFirstVisiblePosition();
                    int top = getChildAt(0).getTop();
                    setAdapter(getAdapter());
                    setSelectionFromTop(firstVisiblePosition, top);
                }
                try {
                    layoutChildren();
                    childAt = getChildAt(i);
                } catch (IllegalStateException e) {
                }
                if (childAt == null) {
                    return;
                }
            }
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.height = this.idC;
            childAt.setLayoutParams(layoutParams);
            childAt.setVisibility(0);
            i++;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 4;
        int i2 = 0;
        if (this.gbw != null) {
            this.gbw.onTouchEvent(motionEvent);
        }
        if ((this.ioc == null && this.iod == null) || this.inT == null) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        switch (action) {
            case 0:
            case 2:
                int width;
                int width2;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (this.ioh == 1) {
                    float f = 1.0f;
                    width = this.inT.getWidth();
                    if (x > width / 2) {
                        f = ((float) (width - x)) / ((float) (width / 2));
                    }
                    this.inV.alpha = f;
                }
                if (this.ioh == 0 || this.ioh == 2) {
                    this.inV.x = (x - this.inY) + this.ioa;
                } else {
                    this.inV.x = 0;
                }
                this.inV.y = (y - this.inZ) + this.iob;
                this.inU.updateViewLayout(this.inT, this.inV);
                if (this.iol != null) {
                    width2 = this.inT.getWidth();
                    if (y > (getHeight() * 3) / 4) {
                        this.iol.setLevel(2);
                    } else if (width2 <= 0 || x <= width2 / 4) {
                        this.iol.setLevel(0);
                    } else {
                        this.iol.setLevel(1);
                    }
                }
                x = (y - this.inZ) - this.iok;
                width2 = cv(0, x);
                if (width2 >= 0) {
                    if (width2 <= this.inX) {
                        width2++;
                    }
                } else if (x < 0) {
                    width2 = 0;
                }
                if (width2 < 0) {
                    return true;
                }
                if (action == 0 || width2 != this.inW) {
                    this.inW = width2;
                    x.d("MicroMsg.emoji.TouchInterceptorListView", "doExpansion mDragPos:%d mSrcDragPos:%d", new Object[]{Integer.valueOf(this.inW), Integer.valueOf(this.inX)});
                    x.d("MicroMsg.emoji.TouchInterceptorListView", "getFirstVisiblePosition:%d", new Object[]{Integer.valueOf(getFirstVisiblePosition())});
                    x.d("MicroMsg.emoji.TouchInterceptorListView", "getHeaderViewsCount:%d", new Object[]{Integer.valueOf(getHeaderViewsCount())});
                    width = this.inW - getFirstVisiblePosition();
                    int headerViewsCount = getHeaderViewsCount();
                    View childAt = getChildAt(this.inX - getFirstVisiblePosition());
                    x = 0;
                    while (true) {
                        View childAt2 = getChildAt(x);
                        if (childAt2 != null) {
                            action = this.idC;
                            if (this.inW >= headerViewsCount || x != headerViewsCount) {
                                if (childAt2.equals(childAt)) {
                                    if (this.inW == this.inX || getPositionForView(childAt2) == getCount()) {
                                        action = this.idC;
                                        x.d("MicroMsg.emoji.TouchInterceptorListView", "2. visibility = View.INVISIBLE");
                                        width2 = 4;
                                    } else {
                                        x.d("MicroMsg.emoji.TouchInterceptorListView", "2. height = 1");
                                        width2 = 0;
                                        action = 1;
                                    }
                                } else if (x != width) {
                                    x.d("MicroMsg.emoji.TouchInterceptorListView", "4");
                                    width2 = 0;
                                } else if (this.inW < headerViewsCount || this.inW >= getCount()) {
                                    x.d("MicroMsg.emoji.TouchInterceptorListView", "3. ");
                                    width2 = 0;
                                } else {
                                    action = this.ioj;
                                    x.d("MicroMsg.emoji.TouchInterceptorListView", "3. height = mItemHeightExpanded;");
                                    width2 = 0;
                                }
                            } else if (childAt2.equals(childAt)) {
                                x.d("MicroMsg.emoji.TouchInterceptorListView", "1. visibility = View.INVISIBLE");
                                width2 = 4;
                            } else {
                                action = this.ioj;
                                x.d("MicroMsg.emoji.TouchInterceptorListView", "1. height = mItemHeightExpanded");
                                width2 = 0;
                            }
                            ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                            layoutParams.height = action;
                            childAt2.setLayoutParams(layoutParams);
                            childAt2.setVisibility(width2);
                            x++;
                        }
                    }
                }
                if (y >= this.mHeight / 3) {
                    this.iof = this.mHeight / 3;
                }
                if (y <= (this.mHeight * 2) / 3) {
                    this.iog = (this.mHeight * 2) / 3;
                }
                if (y > this.iog) {
                    if (getLastVisiblePosition() < getCount() - 1) {
                        if (y > (this.mHeight + this.iog) / 2) {
                            i = 16;
                        }
                        i2 = i;
                    } else {
                        i2 = 1;
                    }
                } else if (y < this.iof) {
                    width2 = y < this.iof / 2 ? -16 : -4;
                    if (getFirstVisiblePosition() != 0 || getChildAt(0).getTop() < getPaddingTop()) {
                        i2 = width2;
                    }
                }
                if (i2 == 0 || d.fS(8)) {
                    return true;
                }
                smoothScrollBy(i2, 30);
                return true;
            case 1:
            case 3:
                Rect rect = this.bJ;
                this.inT.getDrawingRect(rect);
                aGe();
                if (this.ioh != 1 || motionEvent.getX() <= ((float) ((rect.right * 3) / 4))) {
                    if (this.iod != null && this.inW >= 0) {
                        getCount();
                    }
                    en(false);
                    return true;
                }
                en(true);
                return true;
            default:
                return true;
        }
    }

    private void aGe() {
        if (this.inT != null) {
            this.inT.setVisibility(8);
            ((WindowManager) getContext().getSystemService("window")).removeView(this.inT);
            this.inT.setImageDrawable(null);
            this.inT = null;
        }
        if (this.ioi != null) {
            x.i("MicroMsg.emoji.TouchInterceptorListView", "bitmap recycle %s", new Object[]{this.ioi});
            this.ioi.recycle();
            this.ioi = null;
        }
        if (this.iol != null) {
            this.iol.setLevel(0);
        }
    }

    public void setTrashcan(Drawable drawable) {
        this.iol = drawable;
        this.ioh = 2;
    }

    public void setDragListener(a aVar) {
        this.ioc = aVar;
    }

    public void setDropListener(b bVar) {
        this.iod = bVar;
    }

    public void setRemoveListener(c cVar) {
        this.ioe = cVar;
    }
}
