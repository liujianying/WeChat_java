package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import java.util.ArrayList;
import java.util.List;

public class SelectScanModePanel extends LinearLayout {
    private static int mLV = 85;
    private static int mLW = 85;
    private Context context;
    private final int mLX = 0;
    private int mLY = 0;
    protected List<SelectScanModeGrid> mLZ;
    private int[] mMa = new int[]{R.l.scan_entry_qbar, R.l.scan_entry_image, R.l.scan_entry_street, R.l.scan_entry_ocr};
    private int[] mMb = new int[]{R.g.scan_qr, R.g.scan_book, R.g.scan_street, R.g.scan_word};
    private int[] mMc = new int[]{R.g.scan_qr_hl, R.g.scan_book_hl, R.g.scan_street_hl, R.g.scan_word_hl};
    private int[] mMd = new int[]{1, 2, 5, 3};
    private OnItemClickListener mMe;
    private int mMf = 0;
    private boolean mMg = false;
    private int mMh;
    private int mMi;
    private MMFlipper mMj;
    private MMDotView mMk;
    private a mMl;

    public interface a {
        void vB(int i);
    }

    static /* synthetic */ void c(SelectScanModePanel selectScanModePanel) {
        if (selectScanModePanel.mMe == null) {
            selectScanModePanel.mMe = new 3(selectScanModePanel);
        }
        selectScanModePanel.mLZ = new ArrayList();
        if (selectScanModePanel.mMh != 0 && selectScanModePanel.mMi != 0) {
            selectScanModePanel.mMj.removeAllViews();
            int b = b.b(selectScanModePanel.context, 64.0f);
            int i = selectScanModePanel.mMh / b;
            b = selectScanModePanel.mMi / b.b(selectScanModePanel.context, 78.0f);
            if (i == 0) {
                i = 1;
            } else if (i > selectScanModePanel.mMd.length) {
                i = selectScanModePanel.mMd.length;
            }
            if (b == 0) {
                b = 1;
            }
            int i2 = i * b;
            selectScanModePanel.mMf = 0;
            b = 5;
            while (b > 0) {
                b -= i2;
                selectScanModePanel.mMf++;
            }
            for (i = 0; i < selectScanModePanel.mMf; i++) {
                List arrayList = new ArrayList();
                int i3 = i * i2;
                b = i3;
                while (b < selectScanModePanel.mMa.length && b < i3 + i2) {
                    arrayList.add(new SelectScanModeGrid.b(selectScanModePanel.mMa[b], selectScanModePanel.mMb[b], selectScanModePanel.mMc[b], selectScanModePanel.mMd[b]));
                    b++;
                }
                if (arrayList.size() > 0) {
                    SelectScanModeGrid selectScanModeGrid = (SelectScanModeGrid) inflate(selectScanModePanel.context, R.i.select_scan_mode_grid, null);
                    selectScanModeGrid.setNumColumns(i2);
                    com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a aVar = new com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a(selectScanModePanel.context, arrayList);
                    aVar.mLO = selectScanModePanel.mLY;
                    selectScanModeGrid.setAdapter(aVar);
                    selectScanModePanel.mMj.addView(selectScanModeGrid, new LayoutParams(-1, -1));
                    selectScanModeGrid.setOnItemClickListener(selectScanModePanel.mMe);
                    selectScanModePanel.mLZ.add(selectScanModeGrid);
                }
            }
            if (selectScanModePanel.mLZ.size() <= 1) {
                selectScanModePanel.mMk.setVisibility(4);
                return;
            }
            selectScanModePanel.mMk.setVisibility(0);
            selectScanModePanel.mMk.setDotCount(selectScanModePanel.mLZ.size());
            b = selectScanModePanel.mMj.getCurScreen();
            selectScanModePanel.mMj.setToScreen(b);
            selectScanModePanel.mMk.setSelectedDot(b);
        }
    }

    public SelectScanModePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        View.inflate(this.context, R.i.select_scan_mode_panel, this);
        this.mMk = (MMDotView) findViewById(R.h.select_scan_mode_panel_dot);
        x.v("MicroMsg.scanner.SelectScanModePanel", "AppPanel initFlipper");
        this.mMj = (MMFlipper) findViewById(R.h.select_scan_mode_panel_flipper);
        View findViewById = findViewById(R.h.select_scan_mode_panel_display_view);
        LayoutParams layoutParams;
        if (this.context.getResources().getConfiguration().orientation == 2) {
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = b.b(this.context, (float) mLW);
            findViewById.setLayoutParams(layoutParams);
        } else {
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = b.b(this.context, (float) mLV);
            findViewById.setLayoutParams(layoutParams);
        }
        this.mMj.removeAllViews();
        this.mMj.setOnMeasureListener(new 1(this));
        this.mMj.setOnScreenChangedListener(new 2(this));
    }

    public void setOnGridItemClickCallback(a aVar) {
        this.mMl = aVar;
    }

    public void setSelectedMode(int i) {
        for (int i2 = 0; i2 < this.mMd.length; i2++) {
            if (this.mMd[i2] == i) {
                this.mLY = i2;
            }
        }
        if (this.mLZ != null) {
            for (int i3 = 0; i3 < this.mLZ.size(); i3++) {
                com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a aVar = (com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a) ((SelectScanModeGrid) this.mLZ.get(i3)).getAdapter();
                if (aVar != null) {
                    for (int i4 = 0; i4 < aVar.getCount(); i4++) {
                        SelectScanModeGrid.b bVar = (SelectScanModeGrid.b) aVar.getItem(i4);
                        if (!(bVar == null || bVar.mLU == null)) {
                            if (bVar.mLT == i) {
                                bVar.mLU.setBackgroundResource(bVar.mLS);
                                if (i3 > 0) {
                                    this.mMj.setToScreen(i3);
                                    this.mMk.setSelectedDot(i3);
                                }
                            } else {
                                bVar.mLU.setBackgroundResource(bVar.mLR);
                            }
                        }
                    }
                }
            }
        }
    }
}
