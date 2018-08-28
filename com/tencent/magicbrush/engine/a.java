package com.tencent.magicbrush.engine;

public final class a {
    protected long bny = JsEngine.createVM();

    public final void dispose() {
        if (this.bny != 0) {
            JsEngine.releaseVM(this.bny);
            this.bny = 0;
        }
    }
}
