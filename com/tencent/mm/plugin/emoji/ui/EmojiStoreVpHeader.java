package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.a.i;
import com.tencent.mm.plugin.emoji.model.a;
import com.tencent.mm.protocal.c.th;
import com.tencent.mm.protocal.c.tj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.MMDotView;
import java.util.Iterator;
import java.util.LinkedList;

public class EmojiStoreVpHeader extends LinearLayout implements e {
    private MMDotView gKU;
    private ViewPager hE;
    private View hyK;
    private View ido;
    private LinkedList<a> inK;
    private i inL;
    private float inM;
    private float inN;
    private a inO;
    private volatile boolean inP;
    private final int inQ = 5;
    private final int inR = 0;

    public EmojiStoreVpHeader(Context context) {
        super(context);
        setOrientation(1);
    }

    public EmojiStoreVpHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
    }

    public static int[] db(Context context) {
        int[] iArr = new int[2];
        if (context instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } else {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
        }
        return iArr;
    }

    private synchronized void aGa() {
        if (this.inK == null) {
            throw new IllegalAccessError("must has emoji baner list first");
        }
        if (this.hyK == null) {
            this.hyK = inflate(getContext(), R.i.emoji_store_vp_header, null);
            this.ido = this.hyK.findViewById(R.h.emoji_store_ad_root);
            this.gKU = (MMDotView) this.hyK.findViewById(R.h.emoji_store_ad_dot);
            this.hE = (ViewPager) this.hyK.findViewById(R.h.emoji_store_ad_viewpager);
            this.inO = new a(this, (byte) 0);
            int i = ((db(getContext())[0] * 3) / 8) + 1;
            if (this.ido != null) {
                this.ido.setLayoutParams(new LayoutParams(-1, i));
            }
            addView(this.hyK, new LayoutParams(-1, -2));
        }
        if (this.gKU != null) {
            this.gKU.setDotCount(this.inK == null ? 0 : this.inK.size());
            this.gKU.setSelectedDot(0);
            this.gKU.setVisibility(8);
        }
        if (!(this.hE == null || this.inK == null)) {
            if (this.inK.size() > 0) {
                if (this.ido != null) {
                    this.ido.setVisibility(0);
                }
                this.hE.setOnPageChangeListener(this);
                if (this.inL == null) {
                    this.inL = new i(getContext(), this.inK);
                    this.hE.setAdapter(this.inL);
                    this.hE.setOffscreenPageLimit(1);
                    aGb();
                } else {
                    post(new 1(this));
                }
            } else if (this.ido != null) {
                this.ido.setVisibility(8);
            }
        }
    }

    private void aGb() {
        if (this.hE != null) {
            this.hE.k((i.ied / 2) * this.inK.size(), false);
        }
    }

    public final void aGc() {
        if (this.inO == null) {
            this.inO = new a(this, (byte) 0);
        }
        this.inP = true;
        this.inO.removeMessages(0);
        this.inO.sendEmptyMessageDelayed(0, 5000);
    }

    public final void aGd() {
        if (this.inO != null) {
            this.inP = false;
            this.inO.removeMessages(0);
        }
    }

    public final void clear() {
        if (this.inL != null) {
            i iVar = this.inL;
            if (iVar.iec != null) {
                iVar.iec.clear();
            }
            if (iVar.ieg != null) {
                iVar.ieg.clear();
            }
            iVar.ief = true;
            this.inL = null;
        }
        this.inO = null;
    }

    public final void c(LinkedList<th> linkedList, LinkedList<tj> linkedList2) {
        if (linkedList != null) {
            if (this.inK == null) {
                this.inK = new LinkedList();
            } else {
                this.inK.clear();
            }
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                tj tjVar = (tj) it.next();
                if (!(tjVar == null || tjVar.rwF == null || bi.oW(tjVar.rwF.rwG))) {
                    this.inK.add(new a(null, tjVar, true));
                }
            }
            it = linkedList.iterator();
            while (it.hasNext()) {
                th thVar = (th) it.next();
                if (!(thVar == null || thVar.rwF == null || bi.oW(thVar.rwF.rwG))) {
                    this.inK.add(new a(thVar, null, false));
                }
            }
            aGa();
        }
    }

    public final void N(int i) {
    }

    public final void a(int i, float f, int i2) {
    }

    public final void O(int i) {
        if (this.inK != null && this.inK.size() > 1) {
            if (i == 0 || i == this.inL.getCount() - 1) {
                this.hyK.postDelayed(new 2(this), 350);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int action2 = motionEvent.getAction();
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        switch (action2) {
            case 0:
                this.inM = rawX;
                this.inN = rawY;
                break;
            case 1:
            case 3:
                this.inM = 0.0f;
                this.inN = 0.0f;
                em(false);
                break;
            case 2:
                if (Math.abs((int) (rawX - this.inM)) > Math.abs((int) (rawY - this.inN))) {
                    em(true);
                    break;
                }
                break;
        }
        switch (action) {
            case 0:
                aGd();
                break;
            case 1:
            case 3:
                aGc();
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private void em(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }
}
