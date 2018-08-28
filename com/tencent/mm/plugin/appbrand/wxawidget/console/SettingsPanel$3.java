package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bp.a;
import com.tencent.mm.ui.widget.picker.b;
import java.util.ArrayList;

class SettingsPanel$3 implements OnClickListener {
    final /* synthetic */ SettingsPanel gQR;

    SettingsPanel$3(SettingsPanel settingsPanel) {
        this.gQR = settingsPanel;
    }

    public final void onClick(View view) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("MHADrawableView");
        arrayList.add("MTextureView");
        arrayList.add("MSurfaceView");
        arrayList.add("MCanvasView");
        arrayList.add("MDrawableView");
        b bVar = new b(this.gQR.getContext(), arrayList);
        bVar.GC(((Integer) SettingsPanel.b(this.gQR).getTag()).intValue());
        bVar.uLl = new 1(this, bVar);
        bVar.GB(a.fromDPToPix(this.gQR.getContext(), 288));
        bVar.show();
    }
}
