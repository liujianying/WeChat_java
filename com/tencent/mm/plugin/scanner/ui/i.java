package com.tencent.mm.plugin.scanner.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.util.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public abstract class i {
    protected ProgressDialog eHw = null;
    protected TextView gmo;
    GestureDetector iEv;
    protected Point iOm;
    protected long mKh;
    protected Rect mKi;
    protected b mKj;
    protected Point mKk;
    protected int mKl;
    protected int mKm;
    protected int mKn = 40;
    protected int mKo = 20;
    protected b mKp;
    protected int mKq;
    protected boolean mKr;
    protected ag mKs = new 1(this);

    protected abstract void bsj();

    protected abstract b bsk();

    protected abstract int bsl();

    protected abstract int bsm();

    protected abstract void bsn();

    protected abstract boolean bso();

    protected abstract boolean bsp();

    protected abstract void j(Rect rect);

    protected abstract void onDestroy();

    protected abstract void onResume();

    public final b bsM() {
        return this.mKp;
    }

    protected final void hw(boolean z) {
        if (this.gmo != null) {
            if (z) {
                this.gmo.setVisibility(4);
                this.mKs.sendEmptyMessageDelayed(1, 210);
                return;
            }
            this.mKs.removeMessages(1);
            this.gmo.setVisibility(4);
        }
    }

    public i(b bVar, Point point) {
        this.mKp = bVar;
        this.mKk = point;
    }

    public i(b bVar, Point point, byte b) {
        this.mKp = bVar;
        this.mKk = point;
        this.mKn = 50;
    }

    protected void onPause() {
        if (this.eHw != null && this.eHw.isShowing()) {
            this.eHw.dismiss();
        }
    }

    public final void g(Point point) {
        this.mKk = point;
    }

    protected void cv(View view) {
    }

    protected final double do(int i, int i2) {
        Context context = this.mKp.getContext();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        double d = ((double) displayMetrics.densityDpi) / 160.0d;
        x.d("MicroMsg.scanner.ScanMode", "dpiLevel [%s]", new Object[]{Double.valueOf(d)});
        if (d > 1.2d) {
            if (this.mKk.x + this.mKk.y <= 3000 || d >= 2.4d) {
                this.mKl = BackwardSupportUtil.b.b(this.mKp.getContext(), (float) i);
                this.mKm = BackwardSupportUtil.b.b(this.mKp.getContext(), (float) i2);
            } else {
                this.mKl = BackwardSupportUtil.b.b(this.mKp.getContext(), ((float) i) * 1.6f);
                this.mKm = BackwardSupportUtil.b.b(this.mKp.getContext(), ((float) i2) * 1.6f);
                if (this instanceof j) {
                    int i3 = (int) (((double) this.mKk.y) * 0.8d);
                    int i4 = (int) (((double) this.mKk.x) * 0.8d);
                    if (this.mKl > i3 && this.mKm > i4) {
                        float f = 1.5f;
                        while (this.mKl > i3 && this.mKm > i4) {
                            this.mKl = BackwardSupportUtil.b.b(this.mKp.getContext(), ((float) i) * f);
                            this.mKm = BackwardSupportUtil.b.b(this.mKp.getContext(), ((float) i2) * f);
                            f -= 0.1f;
                        }
                        x.i("MicroMsg.scanner.ScanMode", "final adjust ratio: %s", new Object[]{Float.valueOf(f)});
                    }
                }
            }
        } else if (this.mKk != null && this.mKk.x + this.mKk.y > 1560) {
            this.mKl = BackwardSupportUtil.b.b(this.mKp.getContext(), ((float) i) * 1.7f);
            this.mKm = BackwardSupportUtil.b.b(this.mKp.getContext(), ((float) i2) * 1.7f);
        } else if (this.mKk == null || this.mKk.x + this.mKk.y <= 1460) {
            this.mKl = BackwardSupportUtil.b.b(this.mKp.getContext(), ((float) i) / 1.1f);
            this.mKm = BackwardSupportUtil.b.b(this.mKp.getContext(), ((float) i2) / 1.1f);
        } else {
            this.mKl = BackwardSupportUtil.b.b(this.mKp.getContext(), ((float) i) * 1.1f);
            this.mKm = BackwardSupportUtil.b.b(this.mKp.getContext(), ((float) i2) * 1.1f);
        }
        if (this.mKl % 2 == 1) {
            this.mKl++;
        }
        if (this.mKm % 2 == 1) {
            this.mKm++;
        }
        x.d("MicroMsg.scanner.ScanMode", "frame, width:%d, height:%d, visDisplayFrameRes:%s", new Object[]{Integer.valueOf(this.mKl), Integer.valueOf(this.mKm), this.mKk});
        return d;
    }

    protected final Rect B(boolean z, boolean z2) {
        if (this.mKi == null || z) {
            int i;
            int i2;
            int i3;
            int i4;
            int i5 = this.mKk.x;
            int i6 = this.mKk.y;
            int b = BackwardSupportUtil.b.b(this.mKp.getContext(), (float) this.mKn);
            if (this.mKp.bsz()) {
                i = b;
            } else {
                i = 0;
            }
            if (!z2) {
                i2 = (i5 / 2) - (this.mKl / 2);
                i3 = (i5 / 2) + (this.mKl / 2);
                b = (i6 / 2) - (this.mKm / 2);
                if (b - i > 0) {
                    b -= i;
                }
                i = this.mKm + b;
                i4 = b;
            } else if (i5 < i6) {
                i2 = (i6 / 2) - (this.mKl / 2);
                i3 = (i6 / 2) + (this.mKl / 2);
                i4 = BackwardSupportUtil.b.b(this.mKp.getContext(), (float) this.mKo);
                i = this.mKm + i4;
            } else {
                i2 = (i5 / 2) - (this.mKl / 2);
                i3 = (i5 / 2) + (this.mKl / 2);
                i4 = BackwardSupportUtil.b.b(this.mKp.getContext(), (float) this.mKo);
                i = this.mKm + i4;
            }
            x.d("MicroMsg.scanner.ScanMode", "framingRect: width = %s, height = %s; left = %s, right = %s, top = %s, bottom = %s", new Object[]{Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i)});
            this.mKi = new Rect(i2, i4, i3, i);
        }
        return this.mKi;
    }

    protected Rect hx(boolean z) {
        return B(true, z);
    }

    protected void h(Point point) {
        this.iOm = point;
    }

    public final void hy(boolean z) {
        if (this.gmo != null) {
            this.gmo.setVisibility(z ? 0 : 4);
        }
    }

    protected void a(byte[] bArr, Point point, int i, Rect rect) {
        x.i("MicroMsg.scanner.ScanMode", "decode count:" + l.mFT.mFW);
        if (bsk() != null) {
            bsk().a(bArr, point, i, rect);
            if (l.mFT.mFW == 30) {
                this.mKp.bsD();
            }
        }
    }
}
