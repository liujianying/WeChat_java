package com.tencent.magicbrush.engine;

import java.nio.ByteBuffer;

public class b {
    protected long bnA;
    protected boolean bnB;
    protected a bnz;

    public b() {
        this.bnz = new a();
        this.bnB = true;
        this.bnA = JsEngine.createVMContext(this.bnz.bny);
    }

    public final a tb() {
        return this.bnz;
    }

    public b(a aVar) {
        this.bnz = aVar;
        this.bnA = JsEngine.createVMContext(aVar.bny);
    }

    public void dispose() {
        if (this.bnA != 0) {
            JsEngine.releaseVMContext(this.bnA);
            this.bnA = 0;
            if (this.bnB && this.bnz != null) {
                this.bnz.dispose();
                this.bnz = null;
            }
        }
    }

    public final String bP(String str) {
        if (this.bnA == 0) {
            return "";
        }
        return JsEngine.evaluateJavascript(this.bnA, str);
    }

    public final String r(String str, String str2) {
        if (this.bnA == 0) {
            return "";
        }
        return JsEngine.evaluateJavascriptFile(this.bnA, str, str2);
    }

    public final void d(Object obj, String str) {
        if (JsClassUtils.hasJavascriptInterface(obj)) {
            JsEngine.addJsInterface(this.bnA, obj, str);
        }
    }

    public final boolean a(b bVar, String str) {
        return JsEngine.pushObject(this.bnA, bVar.bnA, str);
    }

    public final ByteBuffer getNativeBuffer(int i) {
        ByteBuffer nativeBuffer = JsEngine.getNativeBuffer(i, this.bnz.bny);
        if (nativeBuffer == null) {
            return ByteBuffer.allocate(0);
        }
        return nativeBuffer;
    }
}
