package com.tencent.mm.plugin.scanner.ui;

import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ag;

class BaseScanUI$1 extends a {
    final /* synthetic */ BaseScanUI mHS;

    BaseScanUI$1(BaseScanUI baseScanUI) {
        this.mHS = baseScanUI;
    }

    public final void ev(final int i) {
        if (BaseScanUI.a(this.mHS)) {
            new ag(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    if (au.DF().Lg() == 6 || au.DF().Lg() == 4) {
                        if (!BaseScanUI.b(BaseScanUI$1.this.mHS)) {
                            if (!(BaseScanUI.c(BaseScanUI$1.this.mHS) == null || BaseScanUI.d(BaseScanUI$1.this.mHS) == null)) {
                                BaseScanUI.c(BaseScanUI$1.this.mHS).setVisibility(8);
                                BaseScanUI.d(BaseScanUI$1.this.mHS).setVisibility(8);
                            }
                            BaseScanUI.a(BaseScanUI$1.this.mHS, true);
                            BaseScanUI.b(BaseScanUI$1.this.mHS, false);
                            BaseScanUI.e(BaseScanUI$1.this.mHS);
                        } else {
                            return;
                        }
                    } else if (BaseScanUI.b(BaseScanUI$1.this.mHS)) {
                        if (!(BaseScanUI.c(BaseScanUI$1.this.mHS) == null || BaseScanUI.d(BaseScanUI$1.this.mHS) == null)) {
                            BaseScanUI.c(BaseScanUI$1.this.mHS).setText(R.l.scan_no_network);
                            BaseScanUI.d(BaseScanUI$1.this.mHS).setVisibility(0);
                            BaseScanUI.c(BaseScanUI$1.this.mHS).setVisibility(0);
                        }
                        if (BaseScanUI.f(BaseScanUI$1.this.mHS) != null && BaseScanUI.f(BaseScanUI$1.this.mHS).lfJ) {
                            BaseScanUI.f(BaseScanUI$1.this.mHS).bdR();
                        }
                        if (BaseScanUI.g(BaseScanUI$1.this.mHS) != null) {
                            BaseScanUI.g(BaseScanUI$1.this.mHS).bsS();
                            BaseScanUI.g(BaseScanUI$1.this.mHS).hide();
                        }
                        BaseScanUI.a(BaseScanUI$1.this.mHS, false);
                        BaseScanUI.b(BaseScanUI$1.this.mHS, true);
                        BaseScanUI$1.this.mHS.bsr();
                    } else {
                        return;
                    }
                    if (BaseScanUI.h(BaseScanUI$1.this.mHS) != null) {
                        BaseScanUI.h(BaseScanUI$1.this.mHS).bsj();
                    }
                }
            });
        }
    }
}
