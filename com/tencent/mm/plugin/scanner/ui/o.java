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
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.protocal.c.awi;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class o extends i implements e, a {
    private int mFO;
    int mKE = 0;
    int mKF = 2;
    private long mKG;
    private final int mKH = 184;
    private final int mKI = 46;
    private final int mKJ = 276;
    private final int mKK = 70;
    private float mKP;
    private final int mKS = 50;
    com.tencent.mm.plugin.scanner.a.e mKX;
    private int mKY = 0;
    private TextView mKZ;
    private TextView mLa;
    private final int mLb = 5000;
    private final int mLc = 8000;
    private ag mLd = new 1(this);

    public o(b bVar, Point point) {
        super(bVar, point, (byte) 0);
        do(184, 46);
        this.mKP = p.dq(276, this.mKl);
        x.d("MicroMsg.scanner.ScanModeOCR", "frameRectWidth = [%s], frameRectHeight = [%s], scaleRate = [%s]", new Object[]{Integer.valueOf(this.mKl), Integer.valueOf(this.mKm), Float.valueOf(this.mKP)});
        this.mFO = (int) (System.currentTimeMillis() & -1);
    }

    protected final void j(Rect rect) {
        this.gmo = (TextView) this.mKp.findViewById(R.h.scan_tip_tv);
        this.mLa = (TextView) this.mKp.findViewById(R.h.ocr_result_tips);
        this.mKZ = (TextView) this.mKp.findViewById(R.h.ocr_source_tv);
        this.gmo = (TextView) this.mKp.findViewById(R.h.scan_tip_tv);
        if (rect.bottom > 0) {
            LayoutParams layoutParams = (LayoutParams) this.gmo.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.b(this.mKp.getContext(), 13.0f);
            this.gmo.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) this.mKZ.getLayoutParams();
            layoutParams.topMargin = (rect.bottom + 0) + BackwardSupportUtil.b.b(this.mKp.getContext(), 13.0f);
            this.mKZ.setLayoutParams(layoutParams);
            this.mKZ.setVisibility(4);
        }
        if (d.zf()) {
            this.gmo.setPadding(BackwardSupportUtil.b.b(this.mKp.getContext(), 54.0f), this.gmo.getPaddingTop(), BackwardSupportUtil.b.b(this.mKp.getContext(), 54.0f), this.gmo.getPaddingBottom());
            this.mKZ.setPadding(BackwardSupportUtil.b.b(this.mKp.getContext(), 54.0f), this.mKZ.getPaddingTop(), BackwardSupportUtil.b.b(this.mKp.getContext(), 54.0f), this.mKZ.getPaddingBottom());
        }
        if (this.mKj != null) {
            ((j) this.mKj).lhy = this.mKp.bsz();
        }
        bsN();
        hw(true);
    }

    protected final void bsn() {
        j(new Rect(0, 0, 0, 0));
        this.mKp.b(4, null);
        this.mKp.ev(0);
        onResume();
    }

    protected final int bsl() {
        return R.i.scan_ocr_body;
    }

    protected final com.tencent.mm.plugin.scanner.util.b bsk() {
        if (this.mKj == null) {
            int i = 50;
            if (q.deM.ddb > 0) {
                i = q.deM.ddb;
                x.d("MicroMsg.scanner.ScanModeOCR", "ImageQuality=[%s]", new Object[]{Integer.valueOf(q.deM.ddb)});
            }
            if (ao.is2G(this.mKp.getContext())) {
                this.mKj = new j(this, i - 10, this.mKP, true, this.mKp.bsz());
            } else {
                this.mKj = new j(this, i, this.mKP, true, this.mKp.bsz());
            }
        }
        return this.mKj;
    }

    protected final void bsj() {
        if (this.mKp == null) {
            x.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
        } else {
            bsN();
        }
    }

    private void bsN() {
        if (this.mKp == null) {
            x.e("MicroMsg.scanner.ScanModeOCR", "dealWithNetWork(), scanUICallback == null");
        } else if (au.DF().Lg() == 6 || au.DF().Lg() == 4) {
            this.mKp.ev(0);
        } else {
            this.mKZ.setText("");
            this.mLa.setText("");
            this.mKp.hu(true);
        }
    }

    public final void b(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
        if (this.mKp == null) {
            x.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
        } else if (bArr2 == null || bArr2.length <= 0) {
            String str2 = "MicroMsg.scanner.ScanModeOCR";
            String str3 = "greyData null:[%s]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(bArr2 == null);
            x.w(str2, str3, objArr);
            if (System.currentTimeMillis() - this.mKG <= 1840 || !((j) this.mKj).mNK) {
                this.mKp.eu(40);
            } else {
                this.mKG = System.currentTimeMillis();
                this.mKp.ev(0);
            }
            this.mKY = 0;
        } else if (this.mKE >= this.mKF) {
            if (System.currentTimeMillis() - this.mKG <= 1840 || !((j) this.mKj).mNK) {
                this.mKp.eu(40);
            } else {
                this.mKG = System.currentTimeMillis();
                this.mKp.ev(0);
            }
            x.w("MicroMsg.scanner.ScanModeOCR", "hasDoSceneCount[%s], maxDoSceneCount[%s]", new Object[]{Integer.valueOf(this.mKE), Integer.valueOf(this.mKF)});
        } else {
            this.mKX = new com.tencent.mm.plugin.scanner.a.e(bArr2, "en", "zh_CN", this.mFO);
            au.DF().a(this.mKX, 0);
            this.mKE++;
            this.mLd.removeMessages(0);
            if (ao.is2G(this.mKp.getContext())) {
                this.mLd.sendEmptyMessageDelayed(0, 8000);
            } else {
                this.mLd.sendEmptyMessageDelayed(0, 5000);
            }
            this.mKq += bArr2.length;
            x.d("MicroMsg.scanner.ScanModeOCR", "totalNetworkFlow[%s], hasTakePicNum[%s], maxDoSceneCount[%s]", new Object[]{Integer.valueOf(this.mKq), Integer.valueOf(this.mKY), Integer.valueOf(this.mKF)});
            if (System.currentTimeMillis() - this.mKG <= 1840 || !((j) this.mKj).mNK) {
                this.mKp.eu(40);
            } else {
                this.mKG = System.currentTimeMillis();
                this.mKp.ev(0);
            }
            x.v("MicroMsg.scanner.ScanModeOCR", "onDecodeFinished:" + this.mKE + "," + this.mKY);
        }
    }

    public final void bsf() {
        x.d("MicroMsg.scanner.ScanModeOCR", "decodeFail");
        if (this.mKp == null) {
            x.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
        } else if (System.currentTimeMillis() - this.mKG <= 1840 || !((j) this.mKj).mNK) {
            this.mKp.eu(40);
        } else {
            this.mKG = System.currentTimeMillis();
            this.mKp.ev(0);
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        this.mLd.removeMessages(0);
        switch (lVar.getType()) {
            case 392:
                this.mKE--;
                if (i == 0 && i2 == 0) {
                    awi awi;
                    x.d("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    com.tencent.mm.plugin.scanner.a.e eVar = (com.tencent.mm.plugin.scanner.a.e) lVar;
                    if (eVar.diG == null || eVar.diG.dIE.dIL == null) {
                        awi = null;
                    } else {
                        awi = (awi) eVar.diG.dIE.dIL;
                    }
                    if (awi == null) {
                        x.e("MicroMsg.scanner.ScanModeOCR", "onSceneEnd(), getResp() == null");
                        er(null, null);
                        return;
                    }
                    x.d("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() clientScanID = %s, imageType = %s, source = %s, translate = %s", new Object[]{Integer.valueOf(awi.rjz), Integer.valueOf(awi.rjD), awi.rZE, awi.rZF});
                    if (!bi.oW(awi.rZF)) {
                        er(awi.rZE, awi.rZF);
                        if (this.mKX != null) {
                            au.DF().c(this.mKX);
                            return;
                        }
                        return;
                    }
                    return;
                }
                x.e("MicroMsg.scanner.ScanModeOCR", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                this.mKG -= 300;
                er(null, null);
                return;
            default:
                return;
        }
    }

    private void er(String str, String str2) {
        if (bi.oW(str)) {
            this.mKZ.setText("");
        } else {
            this.gmo.setVisibility(8);
            this.mKZ.setText(str);
            this.mKZ.setVisibility(0);
        }
        if (bi.oW(str2)) {
            this.mLa.setText("");
            return;
        }
        this.gmo.setVisibility(8);
        this.mLa.setText(str2);
        this.mLa.setVisibility(0);
    }

    protected final void onResume() {
        au.DF().a(392, this);
        if (this.mKp == null) {
            x.w("MicroMsg.scanner.ScanModeOCR", "scanUICallback == null");
        } else {
            bsN();
        }
    }

    protected final void onPause() {
        hw(false);
        au.DF().b(392, this);
    }

    protected final int bsm() {
        return 0;
    }

    protected final void onDestroy() {
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
