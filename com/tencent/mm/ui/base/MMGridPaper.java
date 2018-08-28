package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMFlipper.b;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import junit.framework.Assert;

public final class MMGridPaper extends LinearLayout {
    protected View Iq;
    protected MMDotView gKU;
    protected int hQu = 0;
    protected int mNumColumns = 0;
    protected ag msM = new ag(Looper.getMainLooper());
    protected int tsr = 10;
    protected int tss = 10;
    protected MMFlipper tuF;
    protected j tuG;
    protected int tuH;
    protected int tuI;
    protected int tuJ = 0;
    protected int tuK = 0;
    protected int tuL = 3;
    protected int tuM = 0;
    protected int tuN = (this.tuL - 1);
    protected int tuO = 0;
    protected boolean tuP = false;
    protected int tuQ = 9;
    protected int tuR = -1;
    protected int tuS = -1;
    protected int tuT = 96;
    protected int tuU = 96;
    protected boolean tuV = false;
    protected boolean tuW = false;
    protected int tuX = -1;
    protected int tuY = -1;
    protected int tuZ = 0;
    final b tuk = new 5(this);
    final com.tencent.mm.ui.base.MMFlipper.a tul = new 4(this);
    protected int tva = -1;
    protected int tvb = -1;
    protected boolean tvc = false;
    protected int tvd = 0;
    protected int tve = 0;
    protected a tvf;

    public interface a {
    }

    static /* synthetic */ void a(MMGridPaper mMGridPaper, int i) {
        mMGridPaper.tuM += i;
        if (mMGridPaper.tuM < 0) {
            mMGridPaper.tuM = 0;
        } else if (mMGridPaper.tuM > mMGridPaper.tuO - mMGridPaper.tuL) {
            mMGridPaper.tuM = mMGridPaper.tuO - mMGridPaper.tuL;
        }
        mMGridPaper.tuN = (mMGridPaper.tuM + mMGridPaper.tuL) - 1;
    }

    public MMGridPaper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(getContext(), h.mm_gridpaper, this);
        this.tuZ = getScreenOrientation();
    }

    public final void setOnPageSizeChangeListener(a aVar) {
        this.tvf = aVar;
    }

    public final void setMaxDotCount(int i) {
        this.tuQ = i;
    }

    public final void setItemWidthInDp(int i) {
        this.tuT = i;
    }

    public final void setItemHeightInDp(int i) {
        this.tuU = i;
    }

    public final void setMaxRow(int i) {
        this.tvb = i;
    }

    public final void setMaxCol(int i) {
        this.tva = i;
    }

    public final void setDisplayHeightLandInDp(int i) {
        this.tuR = i;
    }

    public final void setDisplayHeightPortInDp(int i) {
        this.tuS = i;
    }

    public final void setDialogMode(boolean z) {
        this.tuW = z;
    }

    public final void crv() {
        this.tuY = 3;
        this.tuX = 3;
    }

    public final void crw() {
        this.tsr = 8;
        this.tss = 15;
    }

    public final void setHeaderView(View view) {
        this.Iq = view;
        ViewGroup viewGroup = (ViewGroup) findViewById(g.header_area);
        viewGroup.removeAllViews();
        if (this.Iq != null) {
            viewGroup.addView(this.Iq);
        }
    }

    public final void setGridPaperAdapter(j jVar) {
        boolean z = true;
        this.tuG = jVar;
        String str = "MicroMsg.MMGridPaper";
        String str2 = "setGridPaperAdapter:adapter is null[%B]";
        Object[] objArr = new Object[1];
        if (jVar != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.d(str, str2, objArr);
        if (this.tuG != null) {
            this.tuG.tvj = new com.tencent.mm.ui.base.j.a() {
                public final void avj() {
                    MMGridPaper.this.refresh();
                }
            };
        }
        cec();
    }

    public final void refresh() {
        this.tuJ = (this.tuK * this.mNumColumns) * this.hQu;
        x.v("MicroMsg.MMGridPaper", "refreshed:virtualPage[%d], col[%d], row[%d], scrollCount[%d]", new Object[]{Integer.valueOf(this.tuK), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.hQu), Integer.valueOf(this.tuJ)});
        cec();
    }

    public final int getPageCount() {
        return this.tuO;
    }

    public final int getItemsCountPerPage() {
        return this.hQu * this.mNumColumns;
    }

    private int getScreenOrientation() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            return 1;
        }
        return 2;
    }

    private void crx() {
        View findViewById;
        LayoutParams layoutParams;
        int fromDPToPix;
        if (-1 != this.tuR && getScreenOrientation() == 2) {
            findViewById = findViewById(g.gridpaper_display_view);
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(getContext(), this.tuR);
            if (fromDPToPix != layoutParams.height) {
                x.i("MicroMsg.MMGridPaper", "set land mode, special height is %d", new Object[]{Integer.valueOf(this.tuR)});
                layoutParams.height = fromDPToPix;
                findViewById.setLayoutParams(layoutParams);
                this.msM.post(new 2(this));
            }
        } else if (-1 != this.tuS && getScreenOrientation() == 1) {
            findViewById = findViewById(g.gridpaper_display_view);
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(getContext(), this.tuS);
            if (fromDPToPix != layoutParams.height) {
                x.i("MicroMsg.MMGridPaper", "set port mode, special height is %d", new Object[]{Integer.valueOf(this.tuS)});
                layoutParams.height = fromDPToPix;
                findViewById.setLayoutParams(layoutParams);
                this.msM.post(new 3(this));
            }
        }
    }

    private void cec() {
        x.v("MicroMsg.MMGridPaper", "MMGridPaper initFlipper");
        if (this.gKU == null) {
            this.gKU = (MMDotView) findViewById(g.gridpaper_dot);
            this.gKU.setMaxCount(this.tuQ);
        }
        if (this.tuF == null) {
            this.tuF = (MMFlipper) findViewById(g.gridpaper_flipper);
            this.tuF.setOnMeasureListener(this.tul);
            this.tuF.setOnScreenChangedListener(this.tuk);
        }
        crx();
        cry();
    }

    public final void setGridWidth(int i) {
        this.tuH = i;
    }

    public final void setGridHeight(int i) {
        this.tuI = i;
    }

    public final void setManualMeasureMode(boolean z) {
        this.tvc = z;
    }

    private void cry() {
        x.v("MicroMsg.MMGridPaper", "initSubGrid, grid width %d, grid height %d", new Object[]{Integer.valueOf(this.tuH), Integer.valueOf(this.tuI)});
        if (this.tuH == 0 || this.tuI == 0) {
            x.w("MicroMsg.MMGridPaper", "initSubGrid:gridWithd or gridHeight is 0");
            return;
        }
        boolean z;
        int min;
        int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(getContext(), this.tuT);
        int fromDPToPix2 = com.tencent.mm.bp.a.fromDPToPix(getContext(), this.tuU);
        fromDPToPix = Math.max(this.tuH / fromDPToPix, 1);
        fromDPToPix2 = Math.max(this.tuI / fromDPToPix2, 1);
        if (!(fromDPToPix == this.mNumColumns && fromDPToPix2 == this.hQu)) {
            this.tuP = true;
        }
        this.mNumColumns = fromDPToPix;
        if (this.tva != -1) {
            this.mNumColumns = Math.min(this.mNumColumns, this.tva);
        }
        this.hQu = fromDPToPix2;
        if (this.tvb != -1) {
            this.hQu = Math.min(this.hQu, this.tvb);
        }
        int i = this.mNumColumns * this.hQu;
        this.tuO = 0;
        fromDPToPix2 = (this.tuG == null ? 0 : this.tuG.getCount()) + 0;
        x.d("MicroMsg.MMGridPaper", "totalCount is %d, dialogMode is %B", new Object[]{Integer.valueOf(fromDPToPix2), Boolean.valueOf(this.tuW)});
        if (fromDPToPix2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (this.tuW) {
            fromDPToPix = eQ(fromDPToPix2, this.mNumColumns);
            switch (getScreenOrientation()) {
                case 1:
                    min = ((this.tuU + 10) * Math.min(fromDPToPix, this.tuX)) + 8;
                    x.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", new Object[]{Integer.valueOf(getScreenOrientation()), Integer.valueOf(Math.min(fromDPToPix, this.tuX)), Integer.valueOf(min), Integer.valueOf(this.tuS), Boolean.valueOf(this.tuV)});
                    if (this.tuS == min) {
                        z = true;
                        break;
                    }
                    this.tuS = min;
                    z = false;
                    break;
                case 2:
                    min = ((this.tuU + 10) * Math.min(fromDPToPix, this.tuY)) + 8;
                    x.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", new Object[]{Integer.valueOf(getScreenOrientation()), Integer.valueOf(Math.min(fromDPToPix, this.tuY)), Integer.valueOf(min), Integer.valueOf(this.tuR), Boolean.valueOf(this.tuV)});
                    if (this.tuR == min) {
                        z = true;
                        break;
                    }
                    this.tuR = min;
                    z = false;
                    break;
            }
        }
        z = true;
        if (z) {
            this.tuO = eQ(fromDPToPix2, i);
            min = this.tuO - 1;
            int i2 = this.tuJ;
            if (i2 == 0 || i <= 0) {
                x.w("MicroMsg.MMGridPaper", "floor:total[%d], length[%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
                fromDPToPix = 0;
            } else {
                fromDPToPix2 = i2;
                fromDPToPix = 0;
                while (fromDPToPix2 >= i) {
                    fromDPToPix2 -= i;
                    fromDPToPix++;
                }
                x.i("MicroMsg.MMGridPaper", "floor:num[%d], length[%d], result[%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(fromDPToPix)});
            }
            this.tuK = Math.min(min, fromDPToPix);
            this.tuL = Math.min(3, this.tuO);
            this.tuM = Math.min(this.tuO - this.tuL, Math.max(0, this.tuK - (this.tuL >> 1)));
            this.tuN = (this.tuM + this.tuL) - 1;
            x.d("MicroMsg.MMGridPaper", "initSubGrid:item[%ddp,%ddp], row[%d], column[%d], activePage[%d], virtualPage[%d], curVirtualPage[%d], edge[%d, %d]", new Object[]{Integer.valueOf(this.tuT), Integer.valueOf(this.tuU), Integer.valueOf(this.hQu), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.tuL), Integer.valueOf(this.tuO), Integer.valueOf(this.tuK), Integer.valueOf(this.tuM), Integer.valueOf(this.tuN)});
            MMGridPaperGridView mMGridPaperGridView;
            if (this.tuF.getChildCount() != this.tuL || this.tuP) {
                x.w("MicroMsg.MMGridPaper", "error child count or RowOrColChanged(%B), reset child view", new Object[]{Boolean.valueOf(this.tuP)});
                this.tuP = false;
                this.tuF.removeAllViews();
                fromDPToPix = this.tuM;
                while (true) {
                    int i3 = fromDPToPix;
                    if (i3 <= this.tuN) {
                        mMGridPaperGridView = (MMGridPaperGridView) inflate(getContext(), h.mm_drap_drop_gridview, null);
                        mMGridPaperGridView.a(i3, this.hQu, this.mNumColumns, this.tuG);
                        mMGridPaperGridView.setHorizontalSpacing(com.tencent.mm.bp.a.fromDPToPix(getContext(), this.tsr));
                        mMGridPaperGridView.setVerticalSpacing(com.tencent.mm.bp.a.fromDPToPix(getContext(), this.tss));
                        this.tuF.addView(mMGridPaperGridView, new LayoutParams(-1, -1));
                        fromDPToPix = i3 + 1;
                    }
                }
            } else {
                fromDPToPix = this.tuM;
                while (true) {
                    fromDPToPix2 = fromDPToPix;
                    if (fromDPToPix2 <= this.tuN) {
                        mMGridPaperGridView = (MMGridPaperGridView) this.tuF.getChildAt(fromDPToPix2 - this.tuM);
                        if (mMGridPaperGridView.getIndex() != fromDPToPix2) {
                            x.w("MicroMsg.MMGridPaper", "old index %d, new index %d, reset it", new Object[]{Integer.valueOf(mMGridPaperGridView.getIndex()), Integer.valueOf(fromDPToPix2)});
                            mMGridPaperGridView.a(fromDPToPix2, this.hQu, this.mNumColumns, this.tuG);
                            if (mMGridPaperGridView.tvp != null) {
                                mMGridPaperGridView.tvp.notifyDataSetChanged();
                            }
                        } else {
                            x.v("MicroMsg.MMGridPaper", "same grid index, continus");
                        }
                        fromDPToPix = fromDPToPix2 + 1;
                    }
                }
            }
            crz();
            return;
        }
        crx();
    }

    private static int eQ(int i, int i2) {
        if (i2 <= 0) {
            x.w("MicroMsg.MMGridPaper", "ceil:total[%d], length[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            return 0;
        }
        int i3 = i;
        int i4 = 0;
        while (i3 > 0) {
            i3 -= i2;
            i4++;
        }
        x.i("MicroMsg.MMGridPaper", "ceil:num[%d], length[%d], result[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4)});
        return i4;
    }

    private void crz() {
        x.v("MicroMsg.MMGridPaper", "set DotView");
        Assert.assertTrue(this.tuO >= 0);
        this.gKU.setDotCount(this.tuO);
        if (this.tuG == null || this.tuO <= 1) {
            this.gKU.setVisibility(8);
            x.v("MicroMsg.MMGridPaper", "set DotView gone");
        } else {
            this.gKU.setVisibility(0);
            x.v("MicroMsg.MMGridPaper", "set DotView visible");
        }
        if (this.tuK >= this.tuO) {
            this.tuK = this.tuO - 1;
        }
        this.tuF.El(this.tuK - this.tuM);
        this.tuF.Em(this.tuK);
        this.gKU.setSelectedDot(this.tuK);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        x.d("MicroMsg.MMGridPaper", "onLayout left=%s top=%s right=%s bottom=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        if (this.tuZ != getScreenOrientation()) {
            this.tuZ = getScreenOrientation();
            x.d("MicroMsg.MMGridPaper", "onLayout, currentOrientation changed, reAdjustDisplayArea");
            this.tuV = true;
            clearAnimation();
            crx();
            cry();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @TargetApi(8)
    public final void onConfigurationChanged(Configuration configuration) {
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            x.d("MicroMsg.MMGridPaper", "onConfigChanged:" + configuration.orientation);
            this.tuV = true;
        }
    }

    private MMGridPaperGridView getCurrentPage() {
        return (MMGridPaperGridView) this.tuF.getChildAt(this.tuF.getCurScreen());
    }
}
