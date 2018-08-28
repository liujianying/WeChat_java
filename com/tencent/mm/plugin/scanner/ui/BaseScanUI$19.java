package com.tencent.mm.plugin.scanner.ui;

import android.hardware.Camera.Parameters;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.util.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class BaseScanUI$19 implements OnClickListener {
    final /* synthetic */ BaseScanUI mHS;

    BaseScanUI$19(BaseScanUI baseScanUI) {
        this.mHS = baseScanUI;
    }

    public final void onClick(View view) {
        if (BaseScanUI.f(this.mHS) != null) {
            l.mFT.vz(2);
            if (BaseScanUI.f(this.mHS).lfJ) {
                BaseScanUI.f(this.mHS).bdR();
                BaseScanUI.g(this.mHS).bsS();
                return;
            }
            h f = BaseScanUI.f(this.mHS);
            x.i("MicroMsg.scanner.ScanCamera", "openFlash, camera: %s, isPreviewing: %s", new Object[]{f.ddt, Boolean.valueOf(f.iOl)});
            if (f.ddt != null && f.iOl) {
                try {
                    f.lfJ = true;
                    Parameters parameters = f.ddt.getParameters();
                    if (bi.cX(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("torch")) {
                        x.i("MicroMsg.scanner.ScanCamera", "camera not support flash!!");
                    } else {
                        parameters.setFlashMode("torch");
                        f.ddt.setParameters(parameters);
                        x.i("MicroMsg.scanner.ScanCamera", "open flash");
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.scanner.ScanCamera", e, "openFlash error: %s", new Object[]{e.getMessage()});
                }
            }
            ScannerFlashSwitcher g = BaseScanUI.g(this.mHS);
            x.i("MicroMsg.ScannerFlashSwitcher", "openFlashStatus");
            g.mLJ.setImageResource(R.k.scanner_flash_open_on);
        }
    }
}
