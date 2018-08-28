package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.widget.input.c.e;
import com.tencent.mm.sdk.platformtools.x;

public abstract class v extends AppBrandInputInvokeHandler {
    boolean addInputImpl(w wVar, e eVar) {
        if (wVar == null) {
            x.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl failed, EditText is null");
            return false;
        }
        int i = eVar.gGq;
        if (this.mPageRef != null) {
            p pVar = (p) this.mPageRef.get();
            if (pVar != null) {
                u agU = pVar.agU();
                if (agU == null) {
                    x.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) failed, CustomViewContainer is null", new Object[]{Integer.valueOf(i)});
                    return false;
                }
                boolean z;
                int i2 = (eVar.gLR == null || !eVar.gLR.booleanValue()) ? 0 : 4;
                int i3 = eVar.dGN;
                float[] fArr = new float[]{(float) eVar.gLE.intValue(), (float) eVar.gLD.intValue(), (float) eVar.gLB.intValue(), (float) eVar.gLC.intValue(), 0.0f};
                if (eVar.gLV == null || !eVar.gLV.booleanValue()) {
                    z = false;
                } else {
                    z = true;
                }
                x.i("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) success = %s, ", new Object[]{Integer.valueOf(i), Boolean.valueOf(agU.a(wVar, i, i3, fArr, i2, z))});
                return agU.a(wVar, i, i3, fArr, i2, z);
            }
        }
        x.w("MicroMsg.AppBrandTextAreaInvokeHandler", "addInputImpl(viewId : %s) failed, pageView is null", new Object[]{Integer.valueOf(i)});
        return false;
    }

    boolean updateInputPosition(w wVar, e eVar) {
        if (wVar == null) {
            x.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition failed, EditText is null");
            return false;
        }
        int inputId = wVar.getInputId();
        if (this.mPageRef != null) {
            p pVar = (p) this.mPageRef.get();
            if (pVar != null) {
                u agU = pVar.agU();
                if (agU == null) {
                    x.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, CustomViewContainer is null", new Object[]{Integer.valueOf(inputId)});
                    return false;
                }
                int i = (eVar.gLR == null || !eVar.gLR.booleanValue()) ? 0 : 4;
                x.i("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) success = %s", new Object[]{Integer.valueOf(inputId), Boolean.valueOf(agU.a(inputId, new float[]{(float) eVar.gLE.intValue(), (float) eVar.gLD.intValue(), (float) eVar.gLB.intValue(), (float) eVar.gLC.intValue(), 0.0f}, i, eVar.gLV))});
                return agU.a(inputId, new float[]{(float) eVar.gLE.intValue(), (float) eVar.gLD.intValue(), (float) eVar.gLB.intValue(), (float) eVar.gLC.intValue(), 0.0f}, i, eVar.gLV);
            }
        }
        x.w("MicroMsg.AppBrandTextAreaInvokeHandler", "updateInputPosition(viewId : %s) failed, pageView is null", new Object[]{Integer.valueOf(inputId)});
        return false;
    }

    void removeInputImpl(w wVar) {
        if (wVar == null) {
            x.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl failed, EditText is null");
            return;
        }
        int inputId = wVar.getInputId();
        wVar.b(this.mInputFocusChangeListenerImpl);
        p pVar = this.mPageRef == null ? null : (p) this.mPageRef.get();
        if (pVar == null) {
            x.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, pageView is null", new Object[]{Integer.valueOf(inputId)});
            return;
        }
        u agU = pVar.agU();
        if (agU == null) {
            x.w("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) failed, CustomViewContainer is null", new Object[]{Integer.valueOf(inputId)});
            return;
        }
        boolean lt = agU.lt(inputId);
        x.i("MicroMsg.AppBrandTextAreaInvokeHandler", "removeInputImpl(viewId : %s) success = %s", new Object[]{Integer.valueOf(inputId), Boolean.valueOf(lt)});
    }
}
