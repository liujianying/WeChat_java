package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase.c;
import com.tencent.mm.plugin.appbrand.widget.input.c.a.a;
import com.tencent.mm.plugin.appbrand.widget.input.z;
import java.lang.ref.WeakReference;

public final class d {
    public static <Input extends EditText & z> void a(p pVar, Input input, a aVar) {
        if (((z) input).apw()) {
            1 1 = new 1(new WeakReference(input), new WeakReference(pVar));
            b autoFillController = ((z) input).getAutoFillController();
            autoFillController.gKa = new a(autoFillController.gJU.getContext(), aVar.gLk);
            autoFillController.gKa.gJN = autoFillController.gJY;
            e eVar = autoFillController.gJV;
            a aVar2 = autoFillController.gKa;
            if (eVar.mObserver == null) {
                eVar.mObserver = new c(eVar, (byte) 0);
            } else if (eVar.Do != null) {
                eVar.Do.unregisterDataSetObserver(eVar.mObserver);
            }
            eVar.Do = aVar2;
            if (eVar.Do != null) {
                aVar2.registerDataSetObserver(eVar.mObserver);
            }
            if (eVar.gKo != null) {
                eVar.gKo.setAdapter(eVar.Do);
            }
            autoFillController.gJY.gKg = 1;
            int i = "screen".equalsIgnoreCase(aVar.gLj) ? f.gKv : f.gKw;
            if (i != 0) {
                autoFillController.gJZ = i;
            }
            autoFillController.apY();
        }
    }
}
