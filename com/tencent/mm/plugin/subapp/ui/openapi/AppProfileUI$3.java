package com.tencent.mm.plugin.subapp.ui.openapi;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class AppProfileUI$3 extends ag {
    final /* synthetic */ AppProfileUI osO;

    AppProfileUI$3(AppProfileUI appProfileUI) {
        this.osO = appProfileUI;
    }

    public final void handleMessage(Message message) {
        this.osO.finish();
    }
}
