package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.protocal.c.bbd;
import com.tencent.mm.protocal.c.bin;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.Map;

@f(chx = {BaseScanUI.class})
public final class q extends i implements e, a {
    private static int mKB = 300;
    private float cXm;
    private float cXn;
    private com.tencent.mm.modelgeo.a.a cXs = new 1(this);
    private c dMm;
    private boolean dMp = false;
    private TextView mHt;
    private final int mKH = 260;
    private final int mKI = 300;
    private final int mKL = 220;
    private final int mKM = 240;
    private String mLA;
    private boolean mLB = false;
    private float mLC = -10000.0f;
    private boolean mLD = false;
    private boolean mLE = false;
    private boolean mLF = false;
    private a mLG;
    protected ag mLH = new 2(this);
    private int mLx;
    private int mLy;
    private String mLz;
    private float pitch = -10000.0f;

    static /* synthetic */ void b(q qVar) {
        if (!qVar.mLB || qVar.mLD || qVar.mLF) {
            x.i("MicroMsg.scanner.ScanModeStreetView", "!hasGetLbsInfo || hasPause || hasDoScene,abort");
            return;
        }
        qVar.mLF = true;
        bbd bbd = new bbd();
        bbd.ryX = qVar.mLA;
        bbd.ryY = qVar.mLx;
        bbd.rms = qVar.cXm;
        bbd.rmr = qVar.cXn;
        bbd.ryW = qVar.mLz;
        bbd.ryV = qVar.mLy;
        if (au.HX()) {
            au.DF().a(new v(bbd, qVar.mLC, qVar.pitch), 0);
        }
    }

    public q(b bVar, Point point) {
        super(bVar, point);
        if (d.zf()) {
            do(220, 240);
        } else {
            do(260, 300);
        }
    }

    protected final void j(Rect rect) {
        this.mHt = (TextView) this.mKp.findViewById(R.h.scan_no_network_tips);
        this.mHt.setText(R.l.scan_no_network);
        this.gmo = (TextView) this.mKp.findViewById(R.h.scan_tip_tv);
        if (rect.bottom > 0) {
            LayoutParams layoutParams = (LayoutParams) this.gmo.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.b(this.mKp.getContext(), 13.0f);
            this.gmo.setLayoutParams(layoutParams);
        }
        if (d.zf()) {
            this.gmo.setPadding(BackwardSupportUtil.b.b(this.mKp.getContext(), 54.0f), this.gmo.getPaddingTop(), BackwardSupportUtil.b.b(this.mKp.getContext(), 54.0f), this.gmo.getPaddingBottom());
        }
        bsN();
        hw(true);
    }

    protected final void bsn() {
        j(new Rect(0, 0, 0, 0));
        this.mKp.b(4, null);
        onResume();
    }

    protected final int bsl() {
        return R.i.scan_street_view_body;
    }

    protected final com.tencent.mm.plugin.scanner.util.b bsk() {
        return null;
    }

    protected final void bsj() {
        if (this.mKp == null) {
            x.w("MicroMsg.scanner.ScanModeStreetView", "handleNetworkChange(), scanUICallback == null");
        } else {
            bsN();
        }
    }

    private void bsN() {
        if (this.mKp == null) {
            x.e("MicroMsg.scanner.ScanModeStreetView", "dealWithNetWork(), scanUICallback == null");
        } else if (this.mLE) {
            this.mKp.hu(true);
        } else if (!au.HX()) {
        } else {
            if (au.DF().Lg() == 6 || au.DF().Lg() == 4) {
                this.mKp.ev(0);
                if (this.dMm != null) {
                    return;
                }
                if (this.mKp == null) {
                    x.w("MicroMsg.scanner.ScanModeStreetView", "initLBS(), scanUICallback == null");
                    return;
                }
                if (this.dMm == null) {
                    this.dMm = c.OB();
                }
                this.cXm = -85.0f;
                this.cXn = -1000.0f;
                this.mLy = -1000;
                this.mLx = 1;
                this.mLz = "";
                this.mLA = "";
                this.dMm.a(this.cXs, true);
            }
        }
    }

    public final void b(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
    }

    public final void bsf() {
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.mKp == null) {
            x.w("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd(), scanUICallback == null");
            return;
        }
        this.mLF = false;
        switch (lVar.getType()) {
            case 424:
                if (i == 0 && i2 == 0) {
                    this.mLF = true;
                    bin Ru = ((v) lVar).Ru();
                    if (Ru == null || Ru.rjF == null) {
                        x.d("MicroMsg.scanner.ScanModeStreetView", "resp null");
                        return;
                    }
                    x.i("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd() errType = [%s], errCode = [%s], resp.Type=[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(Ru.hcE)});
                    String mY;
                    if (Ru.hcE == 0) {
                        mY = v.mY(Ru.rjF);
                        if (bi.oW(mY)) {
                            x.e("MicroMsg.scanner.ScanModeStreetView", "SCAN_STREET_VIEW_TYPE_STREETVIEW url is null");
                            return;
                        }
                        if (this.mLG == null) {
                            this.mLG = new a(this, (byte) 0);
                        }
                        this.mLG.url = mY;
                        ah.M(this.mLG);
                        ah.i(this.mLG, 800);
                        return;
                    } else if (Ru.hcE == 2) {
                        if (this.mLH != null && !this.mLD) {
                            this.mLH.removeMessages(0);
                            this.mLH.sendEmptyMessageDelayed(0, 1000);
                            return;
                        }
                        return;
                    } else if (Ru.hcE == 1) {
                        try {
                            mY = Ru.rjF;
                            if (mY != null) {
                                Map z = bl.z(mY, "recommend");
                                if (z != null) {
                                    LinkedList g = v.b.g(z, ".recommend");
                                    v.b bVar = new v.b();
                                    bVar.title = bi.oV((String) z.get(".recommend.title"));
                                    bVar.desc = bi.oV((String) z.get(".recommend.desc"));
                                    bVar.egs = g;
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.scanner.ScanModeStreetView", e, "", new Object[0]);
                            x.e("MicroMsg.scanner.ScanModeStreetView", "MM_SCAN_STREET_VIEW_TYPE_RECOMMEND， [%s]", new Object[]{e.getMessage()});
                            return;
                        }
                    } else {
                        return;
                    }
                }
                x.e("MicroMsg.scanner.ScanModeStreetView", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            default:
                return;
        }
    }

    protected final void onResume() {
        if (au.HX()) {
            au.DF().a(424, this);
        }
        if (this.mKp == null) {
            x.w("MicroMsg.scanner.ScanModeStreetView", "scanUICallback == null");
        } else {
            bsN();
        }
    }

    protected final void onPause() {
        this.mLD = true;
        hw(false);
        if (au.HX()) {
            au.DF().b(424, this);
        }
        if (this.dMm != null) {
            this.dMm.c(this.cXs);
        }
        if (this.mLH != null) {
            this.mLH.removeMessages(0);
        }
    }

    protected final void onDestroy() {
    }

    protected final int bsm() {
        return mKB;
    }

    protected final boolean bso() {
        return true;
    }

    protected final boolean bsp() {
        return true;
    }

    public final void E(Bundle bundle) {
    }
}
