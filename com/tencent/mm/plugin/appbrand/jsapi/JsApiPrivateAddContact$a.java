package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact.AddContactRequest;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact.AddContactResult;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

final class JsApiPrivateAddContact$a extends AppBrandProxyUIProcessTask {
    private JsApiPrivateAddContact$a() {
    }

    protected final void a(ProcessRequest processRequest) {
        boolean z = true;
        AddContactResult addContactResult = new AddContactResult();
        if (processRequest instanceof AddContactRequest) {
            AddContactRequest addContactRequest = (AddContactRequest) processRequest;
            f fVar = (f) g.l(f.class);
            MMActivity ahw = ahw();
            String str = addContactRequest.userName;
            int i = addContactRequest.scene;
            1 1 = new 1(this, addContactResult);
            if (addContactRequest.fGD != 1) {
                z = false;
            }
            fVar.a(ahw, str, i, 1, z, "").show();
            return;
        }
        x.w("MicroMsg.JsApiPrivateAddContact", "handleRequest !(request instanceof AddContactRequest)");
        AddContactResult.a(addContactResult, -1);
        a(addContactResult);
    }
}
