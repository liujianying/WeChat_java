package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.Scroller;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.v;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.game.d.ba;
import com.tencent.mm.plugin.game.d.bb;
import com.tencent.mm.plugin.game.f.b;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.f;
import com.tencent.mm.sdk.platformtools.x;

public class GameIndexListView extends LoadMoreRecyclerView {
    private static boolean jVl = true;
    private static boolean jVp;
    private static int jVr = 0;
    private static int jYI = 0;
    private static int jYR = 0;
    private View Iq;
    private float jVm;
    private int jVn;
    private boolean jVq;
    private ImageView jVs;
    private ImageView jVt;
    b jYO;
    private bb jYP;
    private boolean jYQ = true;
    private Context mContext;
    private Scroller wf;

    public static void setSourceScene(int i) {
        jYI = i;
    }

    public static int getSourceScene() {
        return jYI;
    }

    public GameIndexListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        x.d("MicroMsg.GameIndexListView", "onFinishInflate");
        this.jVn = ViewConfiguration.get(this.mContext).getScaledTouchSlop();
        this.wf = new Scroller(this.mContext);
        getContext();
        setLayoutManager(new LinearLayoutManager());
        this.jYO = new b(this);
        setAdapter(this.jYO);
        a(new a(this, getResources(), b.game_divided_line_color));
        setLoadingView(f.game_feed_loading_view);
        setOnLoadingStateChangedListener(new 1(this));
        ds(true);
        aUV();
    }

    private void aUV() {
        com.tencent.mm.vending.e.b bVar;
        a aVar = new a();
        ba baVar = new ba();
        baVar.jRG = this.jYP != null ? this.jYP.jRI : null;
        aVar.dIG = baVar;
        aVar.dIH = new bb();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindex4feedslist";
        aVar.dIF = 2943;
        aVar.dII = 0;
        aVar.dIJ = 0;
        com.tencent.mm.ab.b KT = aVar.KT();
        2 2 = new 2(this);
        if (this.mContext instanceof com.tencent.mm.vending.e.b) {
            bVar = (com.tencent.mm.vending.e.b) this.mContext;
        } else {
            bVar = null;
        }
        v.a(KT, 2, false, bVar);
    }

    public static void setCanPulldown(boolean z) {
        jVp = z;
    }

    public static void setDefaultPadding(int i) {
        jVr = i;
    }

    public static void setInitPadding(int i) {
        jYR = i;
        jVl = true;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        x.d("MicroMsg.GameIndexListView", "onLayout, changed = " + z);
        super.onLayout(z, i, i2, i3, i4);
        if (jVl || this.Iq == null || this.jVt == null || this.jVs == null) {
            this.Iq = getChildAt(0);
            if (this.Iq != null) {
                this.Iq.setPadding(0, jYR, 0, 0);
                this.jVt = (ImageView) this.Iq.findViewById(e.small_image);
                this.jVs = (ImageView) this.Iq.findViewById(e.big_image);
            }
            jVl = false;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!jVp || this.Iq == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.jVq = false;
                this.jVm = motionEvent.getRawY();
                break;
            case 2:
                boolean z;
                if (((LinearLayoutManager) getLayoutManager()).fi() == 0 && this.Iq != null && this.Iq.getTop() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (this.jVq) {
                        return true;
                    }
                    int rawY = (int) (motionEvent.getRawY() - this.jVm);
                    if (this.Iq.getPaddingTop() <= jVr + this.jVn) {
                        if (rawY > 0 && Math.abs(rawY) >= this.jVn) {
                            this.jVq = true;
                            this.wf.startScroll(0, this.Iq.getPaddingTop(), 0, -this.Iq.getPaddingTop(), 500);
                            this.jVs.setClickable(true);
                            invalidate();
                            motionEvent.setAction(3);
                            super.dispatchTouchEvent(motionEvent);
                            return true;
                        }
                    } else if (this.Iq.getPaddingTop() >= (-this.jVn) && rawY < 0 && Math.abs(rawY) >= this.jVn) {
                        this.jVq = true;
                        this.wf.startScroll(0, 0, 0, jVr, 500);
                        invalidate();
                        motionEvent.setAction(3);
                        super.dispatchTouchEvent(motionEvent);
                        return true;
                    }
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void computeScroll() {
        if (this.Iq != null && this.wf.computeScrollOffset()) {
            int currY = this.wf.getCurrY();
            x.d("MicroMsg.GameIndexListView", "computeScroll, currY = " + currY);
            this.Iq.setPadding(0, currY, 0, 0);
            float f = (((float) (jVr - currY)) / ((float) jVr)) * 255.0f;
            int i = 255 - ((int) f);
            currY = (int) f;
            this.jVt.setAlpha(i);
            this.jVs.setAlpha(currY);
            invalidate();
        }
    }
}
