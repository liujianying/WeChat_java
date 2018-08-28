package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.k.c;
import com.tencent.mm.k.g;
import com.tencent.mm.model.q;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AppPanel extends LinearLayout {
    private static int mLV = 215;
    private static int mLW = 158;
    private static boolean qKE = false;
    Context context;
    private SharedPreferences duR;
    private List<f> eul = new LinkedList();
    private boolean huc = false;
    private boolean mMg = false;
    private int mMh;
    private int mMi;
    public MMFlipper mMj;
    private MMDotView mMk;
    private int qJY = 17;
    private boolean qKA = true;
    private final int qKB = 2;
    private int qKC = -1;
    private AppGrid$b qKD = new 3(this);
    private boolean qKF = true;
    private int qKG = -1;
    private final boolean[] qKh = new boolean[17];
    private a qKi;
    private b qKj;
    private List<AppGrid> qKk;
    private int qKl = this.qJY;
    private int qKm;
    public a qKn;
    private int qKo = 0;
    private int qKp = 0;
    private int qKq = 0;
    private boolean qKr = false;
    private boolean qKs = false;
    private boolean qKt = false;
    private boolean qKu = false;
    boolean qKv = false;
    boolean qKw = false;
    boolean qKx = false;
    public boolean qKy = false;
    private Map<String, f> qKz = null;

    public interface a {
        void b(f fVar);

        void bcA();

        void bcB();

        void bcC();

        void bcD();

        void bcE();

        void bcF();

        void bcG();

        void bcH();

        void bcI();

        void bcJ();

        void bcK();

        void bcL();

        void bcy();

        void bcz();

        void st(int i);

        void su(int i);
    }

    public AppPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public final void init(int i) {
        this.qKn = new a();
        this.qKq = i;
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            this.qKo = defaultDisplay.getWidth();
            this.qKp = defaultDisplay.getHeight();
        } else {
            this.qKo = defaultDisplay.getHeight();
            this.qKp = defaultDisplay.getWidth();
        }
        View.inflate(this.context, R.i.app_panel, this);
        this.mMk = (MMDotView) findViewById(R.h.app_panel_dot);
        this.mMj = (MMFlipper) findViewById(R.h.app_panel_flipper);
        try {
            String value = g.AT().getValue("ShowAPPSuggestion");
            if (bi.oW(value) || Integer.valueOf(value).intValue() != 1) {
                this.eul = com.tencent.mm.pluginsdk.model.app.g.a(this.context, false, this.qKq);
                if (!cef()) {
                    cU(this.eul);
                }
                cT(this.eul);
                cec();
                cdZ();
            }
            this.eul = com.tencent.mm.pluginsdk.model.app.g.a(this.context, true, this.qKq);
            if (cef()) {
                cU(this.eul);
            }
            cT(this.eul);
            cec();
            cdZ();
        } catch (Exception e) {
            x.e("MicroMsg.AppPanel", "exception in appPanel init, %s", new Object[]{e.getMessage()});
            this.eul = com.tencent.mm.pluginsdk.model.app.g.a(this.context, false, this.qKq);
        }
    }

    public void setServiceShowFlag(int i) {
        this.qKq = i;
    }

    private void cT(List<f> list) {
        boolean z = this.qKr;
        this.qKr = false;
        boolean z2 = this.qKs;
        boolean z3 = this.qKt;
        boolean z4 = this.qKu;
        this.qKs = false;
        this.qKt = false;
        this.qKu = false;
        int i = this.qKq;
        ArrayList arrayList = new ArrayList();
        if (com.tencent.mm.plugin.ac.a.a.a.bmm() == null) {
            x.e("MicroMsg.AppInfoLogic", "getServiceByAppInfoFlagAndShowFlag, getISubCorePluginBase() == null");
            i = 0;
        } else {
            Cursor dh = com.tencent.mm.plugin.ac.a.a.a.bmm().dh(0, i);
            if (dh == null) {
                i = 0;
            } else {
                i = dh.getCount();
                dh.close();
            }
        }
        x.d("MicroMsg.AppPanel", "serviceCount, %d", new Object[]{Integer.valueOf(i)});
        this.qKz = new HashMap();
        if (i > 0 && list != null && list.size() > 0) {
            int i2 = 0;
            while (i2 < list.size()) {
                f fVar = (f) list.get(i2);
                if (!(fVar == null || fVar.field_appId == null || !fVar.cbJ())) {
                    boolean z5;
                    int i3;
                    if ((fVar.field_serviceAppInfoFlag & 1) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (!z5) {
                        this.qKr = true;
                    }
                    if (f.qzE.equals(fVar.field_appId)) {
                        this.qKz.put(f.qzE, fVar);
                        if (!this.qKw) {
                            this.qKs = true;
                        }
                        i3 = i2 - 1;
                        list.remove(i2);
                        i2 = i3;
                    }
                    if (f.qzG.equals(fVar.field_appId)) {
                        this.qKz.put(f.qzG, fVar);
                        if (!this.qKv) {
                            this.qKt = true;
                        }
                        i3 = i2 - 1;
                        list.remove(i2);
                        i2 = i3;
                    }
                    if (f.qzH.equals(fVar.field_appId)) {
                        this.qKz.put(f.qzH, fVar);
                        if (!this.qKx) {
                            this.qKu = true;
                        }
                        i = i2 - 1;
                        list.remove(i2);
                        i2 = i;
                    }
                }
                i2++;
            }
        }
        x.d("MicroMsg.AppPanel", "hasService %b", new Object[]{Boolean.valueOf(this.qKr)});
        if (z != this.qKr || z2 != this.qKs || z3 != this.qKt || z4 != this.qKu) {
            this.qKn.kJ(this.qKr);
            this.qKn.kK(this.qKs);
            this.qKn.kL(this.qKt);
            this.qKn.kM(this.qKu);
            ceb();
        }
    }

    public final void cdZ() {
        a aVar = this.qKn;
        aVar.qKJ.value = true;
        aVar.qKK.value = true;
        aVar.qKL.value = true;
        aVar.qKM.value = true;
        aVar.qKN.value = true;
        aVar.qKO.value = true;
        aVar.qKP.value = true;
        aVar.qKY.value = true;
        aVar.qKW.value = true;
        aVar.qKQ.value = true;
        aVar.qKR.value = true;
        aVar.qKS.value = true;
        aVar.qKT.value = true;
        aVar.qKU.value = true;
        aVar.qKV.value = true;
        aVar.qKX.value = true;
        aVar.qKZ.value = true;
        aVar.qLa.value = false;
        aVar.qLb.value = true;
        aVar.qLc.value = true;
        aVar.qLe.value = true;
        aVar.qLf.value = true;
        aVar.qLe.value = false;
        aVar.qLg.value = true;
        this.qKv = false;
        this.qKw = false;
        this.qKx = false;
        this.qKy = false;
        cea();
        this.qKn.kJ(this.qKr);
        this.qKn.kK(this.qKs);
        this.qKn.kL(this.qKt);
        this.qKn.kM(this.qKu);
        ceb();
    }

    public final void cea() {
        boolean z = true;
        g.AU();
        boolean z2 = c.AF() == 2;
        this.qKn.qKP.value = true;
        this.qKn.qKV.value = z2;
        this.qKn.qKZ.value = d.QS("location");
        if ((q.GQ() & 33554432) != 0) {
            z = false;
        }
        this.qKn.qKX.value = z;
    }

    public final void kI(boolean z) {
        boolean z2 = !z;
        this.qKn.qKU.value = z2;
        ceb();
        x.d("MicroMsg.AppPanel", "enable " + this.qKn.qKV.value + " isVoipAudioEnable " + z2);
    }

    public final void ceb() {
        int i;
        int length = this.qKh.length;
        for (i = 0; i < length; i++) {
            this.qKh[i] = true;
        }
        if (this.qKn.qKL.value) {
            i = 0;
        } else {
            this.qKh[0] = false;
            i = 1;
        }
        if (!this.qKn.qKK.value) {
            this.qKh[1] = false;
            i++;
        }
        if (!this.qKn.qLg.value) {
            this.qKh[16] = false;
            i++;
        }
        if (!(this.qKn.qKY.value && this.qKn.qKZ.value)) {
            this.qKh[6] = false;
            i++;
        }
        if (!this.qKn.qKQ.value) {
            this.qKh[14] = false;
            i++;
        }
        if (!this.qKn.qKR.value) {
            this.qKh[8] = false;
            i++;
        }
        if (!this.qKn.qKM.value) {
            this.qKh[11] = false;
            i++;
        }
        if (!this.qKn.qLa.value) {
            this.qKh[13] = false;
            i++;
        }
        if (!this.qKn.qLd.value) {
            this.qKh[3] = false;
            i++;
        }
        if (!this.qKn.qKN.value) {
            this.qKh[12] = false;
            i++;
        }
        if (!this.qKn.qKT.value) {
            this.qKh[5] = false;
            i++;
        }
        if (!(this.qKn.qKV.value && this.qKn.qKU.value)) {
            this.qKh[4] = false;
            i++;
        }
        if (!(this.qKn.qKP.value && this.qKn.qKO.value)) {
            this.qKh[2] = false;
            i++;
        }
        if (!(this.qKn.qKX.value && this.qKn.qKW.value)) {
            this.qKh[10] = false;
            i++;
        }
        if (!this.qKn.qLc.value) {
            this.qKh[7] = false;
            i++;
        }
        if (!this.qKn.qLe.value) {
            this.qKh[15] = false;
            i++;
        }
        this.qKh[9] = false;
        this.qJY = 17 - (i + 1);
    }

    private int getScreenOrientation() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            return 1;
        }
        return 2;
    }

    private void cec() {
        x.d("MicroMsg.AppPanel", "AppPanel initFlipper");
        this.qKC = -1;
        this.mMj.removeAllViews();
        this.mMj.setOnMeasureListener(new 1(this));
        this.mMj.setOnScreenChangedListener(new 2(this));
        cee();
    }

    public final void refresh() {
        x.i("MicroMsg.AppPanel", "app panel refleshed");
        try {
            String value = g.AT().getValue("ShowAPPSuggestion");
            int curScreen;
            if (bi.oW(value) || Integer.valueOf(value).intValue() != 1) {
                this.eul = com.tencent.mm.pluginsdk.model.app.g.a(this.context, false, this.qKq);
                x.d("MicroMsg.AppPanel", "jacks not show App Suggestion");
                if (!cef()) {
                    cU(this.eul);
                }
                cT(this.eul);
                if (this.qKn != null) {
                    this.qKn.kJ(this.qKr);
                    this.qKn.kK(this.qKs);
                    this.qKn.kL(this.qKt);
                    this.qKn.kM(this.qKu);
                }
                curScreen = this.mMj.getCurScreen();
                ced();
                this.mMj.setToScreen(curScreen);
                this.mMk.setSelectedDot(curScreen);
            }
            x.d("MicroMsg.AppPanel", "jacks show App Suggestion");
            this.eul = com.tencent.mm.pluginsdk.model.app.g.a(this.context, true, this.qKq);
            if (cef()) {
                cU(this.eul);
            }
            cT(this.eul);
            if (this.qKn != null) {
                this.qKn.kJ(this.qKr);
                this.qKn.kK(this.qKs);
                this.qKn.kL(this.qKt);
                this.qKn.kM(this.qKu);
            }
            curScreen = this.mMj.getCurScreen();
            ced();
            this.mMj.setToScreen(curScreen);
            this.mMk.setSelectedDot(curScreen);
        } catch (Exception e) {
            x.e("MicroMsg.AppPanel", "exception in appPanel init, %s", new Object[]{e.getMessage()});
            this.eul = com.tencent.mm.pluginsdk.model.app.g.a(this.context, false, this.qKq);
        }
    }

    private void ced() {
        if (this.mMh != 0 && this.mMi != 0) {
            int i;
            Object obj;
            AppGrid appGrid;
            int b = b.b(this.context, 82.0f);
            int b2 = b.b(this.context, 90.0f);
            ceb();
            int i2 = 4;
            if (!this.qKA) {
                i2 = this.mMh / b;
            }
            b = this.mMi / b2;
            if (b > 2) {
                b = 2;
            }
            int i3 = (this.mMi - (b2 * b)) / (b + 1);
            x.d("MicroMsg.AppPanel", "jacks spacing2 = %d", new Object[]{Integer.valueOf(i3)});
            x.d("MicroMsg.AppPanel", "in initAppGrid, gridWidth = %d, gridHeight = %d", new Object[]{Integer.valueOf(this.mMh), Integer.valueOf(this.mMi)});
            if (i2 == 0) {
                i = 1;
            } else {
                i = i2;
            }
            if (b == 0) {
                b = 1;
            }
            this.qKm = b;
            int i4 = i * b;
            if (this.qKn.qKS.value) {
                this.qKl = this.qJY + this.eul.size();
            } else {
                this.qKl = this.qJY;
            }
            int ceil = (int) Math.ceil(((double) this.qKl) / ((double) i4));
            x.i("MicroMsg.AppPanel", "in initAppGrid, totalItemCount = %d, itemsPerPage = %d, pageCount = %d visibleLocalAppCount = %d infoList = %d", new Object[]{Integer.valueOf(this.qKl), Integer.valueOf(i4), Integer.valueOf(ceil), Integer.valueOf(this.qJY), Integer.valueOf(this.eul.size())});
            if (this.qKC == ceil) {
                x.i("MicroMsg.AppPanel", "mLastPageCount == pageCount! [%s:%s]", new Object[]{Integer.valueOf(this.qKC), Integer.valueOf(ceil)});
                obj = null;
            } else {
                int obj2 = 1;
            }
            if (obj2 != null) {
                this.qKk = new ArrayList();
                this.mMj.removeAllViews();
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i5 = 0;
            long j = 0;
            while (i5 < ceil) {
                long currentTimeMillis2 = System.currentTimeMillis();
                if (obj2 != null || this.qKk.size() <= i5 || this.qKk.get(i5) == null) {
                    appGrid = (AppGrid) inflate(this.context, R.i.app_grid, null);
                } else {
                    appGrid = (AppGrid) this.qKk.get(i5);
                }
                j += System.currentTimeMillis() - currentTimeMillis2;
                appGrid.qJZ = new com.tencent.mm.pluginsdk.ui.chat.AppGrid.a(appGrid, appGrid.context, this.eul, this.qKz);
                appGrid.setBackgroundResource(0);
                appGrid.setAdapter(appGrid.qJZ);
                appGrid.setOnItemClickListener(appGrid.hpE);
                appGrid.setOnItemLongClickListener(appGrid.jbf);
                appGrid.setPadding(b.b(appGrid.context, 16.0f), b.b(appGrid.context, 6.0f), b.b(appGrid.context, 16.0f), 0);
                b = this.qKl;
                int i6 = this.qJY;
                appGrid.qJX = i5;
                appGrid.qJU = b;
                appGrid.qJV = i4;
                appGrid.qJW = ceil;
                appGrid.qJY = i6;
                appGrid.setNumColumns(i);
                if (i3 > 0) {
                    appGrid.setPadding(b.b(appGrid.context, 16.0f), i3, b.b(appGrid.context, 16.0f), 0);
                    appGrid.setVerticalSpacing(i3 / 2);
                }
                if (obj2 != null) {
                    this.mMj.addView(appGrid, new LayoutParams(-1, -2));
                    this.qKk.add(appGrid);
                }
                i5++;
            }
            x.i("MicroMsg.AppPanel", "[initAppGrid] cost:%sms inflateCost:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(j)});
            for (AppGrid appGrid2 : this.qKk) {
                appGrid2.setOnAppSelectedListener(this.qKD);
            }
            if (this.qKk.size() <= 1) {
                this.mMk.setVisibility(4);
            } else {
                this.mMk.setVisibility(0);
                this.mMk.setDotCount(this.qKk.size());
                i2 = this.mMj.getCurScreen();
                this.mMj.setToScreen(i2);
                this.mMk.setSelectedDot(i2);
            }
            this.qKC = ceil;
            requestLayout();
        }
    }

    public int getPageMaxRowCount() {
        if (this.qKm != 0) {
            return this.qKm;
        }
        int i = (this.qKl + 3) / 4;
        if (i > 2) {
            return 2;
        }
        return i;
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            x.d("MicroMsg.AppPanel", "onConfigChanged:" + configuration.orientation);
            if (configuration.orientation == 1) {
                this.qKA = true;
            } else {
                this.qKA = false;
            }
            setNeedRefreshHeight(true);
            ul();
        }
    }

    public final void ul() {
        x.i("MicroMsg.AppPanel", "[dealOrientationChange]");
        this.mMg = false;
        this.mMj.setToScreen(0);
        cec();
        requestLayout();
    }

    public void setOnSwitchPanelListener(b bVar) {
        this.qKj = bVar;
    }

    public void setAppPanelListener(a aVar) {
        this.qKi = aVar;
    }

    public void setPortHeighDP(int i) {
        if (mLV != i) {
            mLV = i;
            this.qKF = true;
        }
    }

    public void setPortHeighPx(int i) {
        if (this.qKG != i) {
            this.qKG = i;
            this.qKF = true;
        }
    }

    public void setNeedRefreshHeight(boolean z) {
        this.qKF = z;
    }

    public final void cee() {
        if (this.qKF) {
            View findViewById;
            ViewGroup.LayoutParams layoutParams;
            if (getScreenOrientation() == 2) {
                x.d("MicroMsg.AppPanel", "initFlipper, landscape");
                findViewById = findViewById(R.h.app_panel_display_view);
                layoutParams = new LayoutParams(-1, 0);
                layoutParams.height = b.b(this.context, (float) mLW);
                findViewById.setLayoutParams(layoutParams);
            } else {
                x.d("MicroMsg.AppPanel", "initFlipper, portrait: %d", new Object[]{Integer.valueOf(mLV)});
                findViewById = findViewById(R.h.app_panel_display_view);
                layoutParams = new LayoutParams(-1, 0);
                layoutParams.height = getPortHeightPX();
                findViewById.setLayoutParams(layoutParams);
            }
            this.qKF = false;
        }
    }

    private int getPortHeightPX() {
        return this.qKG > 0 ? this.qKG : b.b(this.context, (float) mLV);
    }

    private static void cU(List<f> list) {
        if (list != null && !list.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    f fVar = (f) list.get(i2);
                    if (fVar == null || !f.qzF.equals(fVar.field_appId)) {
                        i = i2 + 1;
                    } else {
                        list.remove(fVar);
                        return;
                    }
                }
                return;
            }
        }
    }

    private boolean cef() {
        if (this.qKy) {
            return false;
        }
        com.tencent.mm.plugin.card.c.b bVar = (com.tencent.mm.plugin.card.c.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.card.c.b.class);
        if (bVar != null) {
            return bVar.axz() && bVar.axC() > 0;
        } else {
            return false;
        }
    }
}
