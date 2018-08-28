package com.tencent.mm.plugin.mmsight.segment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import android.support.v7.widget.RecyclerView.t;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.segment.n.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;

public class RecyclerThumbSeekBar extends RelativeLayout implements c {
    private int dwI;
    private int dwJ;
    private int egD = -1;
    private RecyclerView gxh;
    private VideoTransPara lfT;
    private int llN;
    private c$a llO;
    private c$b llP;
    private c llQ;
    private n llR;
    private int llS;
    private d$a llT = new d$a(new 1(this));
    private Runnable llU = new 2(this);
    private k llV = new 5(this);
    private a llW = new 6(this);
    private String path;

    private class e extends t {
        ImageView bOA;

        e(View view, int i) {
            super(view);
            if (i == 0) {
                this.bOA = (ImageView) ((LinearLayout) view).getChildAt(0);
            }
        }
    }

    static /* synthetic */ int e(RecyclerThumbSeekBar recyclerThumbSeekBar, int i) {
        if (recyclerThumbSeekBar.llQ == null) {
            throw new IllegalStateException("recyclerAdapter is null");
        } else if (recyclerThumbSeekBar.egD <= 0) {
            throw new IllegalStateException("durationMs <= 0");
        } else {
            recyclerThumbSeekBar.llQ.getItemCount();
            return (int) ((Math.min(Math.max(0.0f, ((float) i) / ((float) recyclerThumbSeekBar.egD)), 1.0f) * ((float) recyclerThumbSeekBar.dwJ)) * ((float) (recyclerThumbSeekBar.llQ.getItemCount() - 2)));
        }
    }

    public RecyclerThumbSeekBar(Context context) {
        super(context);
        init();
    }

    public RecyclerThumbSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public RecyclerThumbSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.gxh = new RecyclerView(getContext());
        getContext();
        this.gxh.setLayoutManager(new LinearLayoutManager(0));
        this.gxh.setHasFixedSize(true);
        int ad = com.tencent.mm.bp.a.ad(getContext(), k$b.video_segment_seekbar_recycler_view_height);
        this.llS = com.tencent.mm.bp.a.ad(getContext(), k$b.video_segment_seekbar_padding);
        addView(this.gxh, new LayoutParams(-1, ad));
        this.llR = new n(getContext());
        addView(this.llR, new LayoutParams(-1, -1));
        this.llR.setOnSliderTouchListener(this.llW);
        this.gxh.a(this.llV);
    }

    public void setCurrentCursorPosition(float f) {
        float f2 = 0.0f;
        n nVar = this.llR;
        if (!(this.llQ == null || this.gxh == null)) {
            float itemCount = ((float) this.llQ.getItemCount()) * f;
            int floor = (int) Math.floor((double) itemCount);
            itemCount -= (float) floor;
            t bk = this.gxh.bk(floor + 1);
            if (bk != null) {
                View view = bk.SU;
                f2 = ((((float) view.getWidth()) * itemCount) + ((float) view.getLeft())) / ((float) getWidth());
            }
        }
        nVar.setCursorPos(f2);
    }

    public final void Hu(String str) {
        if (bi.oW(str) || !FileOp.cn(str)) {
            beY();
            return;
        }
        this.path = str;
        post(this.llU);
    }

    public int getDurationMs() {
        return this.egD;
    }

    public final void gv(boolean z) {
        if (z) {
            this.llR.lml = true;
        } else {
            this.llR.lml = false;
        }
    }

    public void setVideoTransPara(VideoTransPara videoTransPara) {
        this.lfT = videoTransPara;
    }

    private void setViewWidth(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    private void beY() {
        ah.A(new 4(this));
    }

    public final void release() {
        Lock lock = null;
        this.egD = -1;
        this.path = null;
        if (this.llT != null) {
            d$a d_a = this.llT;
            if (d_a.lkV != null) {
                d_a.jhz.lock();
                if (d_a.lkV == null) {
                    d_a.jhz.unlock();
                } else {
                    try {
                        Iterator it = d_a.lkV.iterator();
                        while (it.hasNext()) {
                            ((d) it.next()).release();
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("FetcherPool", e, "destroy fetcher %s", new Object[]{e.getMessage()});
                    } finally {
                        d_a.lkV = null;
                        lock = d_a.jhz;
                        lock.unlock();
                    }
                }
            }
        }
        if (!(this.llQ == null || this.llQ.lmb == null)) {
            d dVar = this.llQ.lmb;
            if (!(dVar.lmg == null || dVar.lmg.length == 0)) {
                for (int i = lock; i < dVar.lmg.length; i++) {
                    if (dVar.lmg[i] != null) {
                        dVar.lmg[i].quit();
                        dVar.lmg[i] = null;
                    }
                }
            }
            this.llQ.lmb = null;
            this.llQ = null;
        }
        if (this.llR != null) {
            n nVar = this.llR;
            if (nVar.lmF != null && nVar.lmG != null) {
                nVar.lmo.setBounds(nVar.lmF);
                nVar.lmp.setBounds(nVar.lmG);
                nVar.lmt = -1.0f;
                nVar.postInvalidate();
            }
        }
    }

    public void setOnPreparedListener(c$a c_a) {
        this.llO = c_a;
    }

    public void setThumbBarSeekListener(c$b c_b) {
        this.llP = c_b;
    }

    public final float beM() {
        if (this.llR == null) {
            return 0.0f;
        }
        x.d("RecyclerThumbSeekBar", "computeStartPercent x : [%d] ret[%f] seekLoopStartTime[%d] durationMs[%d]", new Object[]{Integer.valueOf(this.llR.getLeftSliderBound()), Float.valueOf(r0), Integer.valueOf(Math.round(((float) this.egD) * M(this.llR.getLeftSliderBound(), false))), Integer.valueOf(this.egD)});
        return M(this.llR.getLeftSliderBound(), false);
    }

    public final float beN() {
        if (this.llR == null) {
            return 0.0f;
        }
        x.d("RecyclerThumbSeekBar", "computeEndPercent x : [%d] ret[%f] seekLoopEndTime[%d]", new Object[]{Integer.valueOf(this.llR.getRightSliderBound()), Float.valueOf(r0), Integer.valueOf(Math.round(((float) this.egD) * M(this.llR.getRightSliderBound(), true)))});
        return M(this.llR.getRightSliderBound(), true);
    }

    private float M(int i, boolean z) {
        if (this.llQ == null || this.gxh == null) {
            return 0.0f;
        }
        View u = this.gxh.u((float) i, 0.0f);
        if (u == null) {
            x.w("RecyclerThumbSeekBar", "getPositionInTotalRange x[%d] isEnd[%b], view is null.", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
            return 0.0f;
        }
        int aZ = RecyclerView.aZ(u);
        int itemCount = this.llQ.getItemCount();
        if (aZ <= 1) {
            return 0.0f;
        }
        if (aZ >= itemCount - 1) {
            return 1.0f;
        }
        return (((float) (aZ - 1)) + (((float) (i - u.getLeft())) / ((float) u.getWidth()))) / ((float) (itemCount - 2));
    }
}
