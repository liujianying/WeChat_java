package com.tencent.mm.plugin.setting.ui.setting;

import android.net.Uri;
import android.os.FileObserver;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.io.File;

public class SelfQRCodeUI$a extends FileObserver {
    private String mQA;
    final /* synthetic */ SelfQRCodeUI mQy;
    private MMActivity mQz;

    public SelfQRCodeUI$a(SelfQRCodeUI selfQRCodeUI, MMActivity mMActivity) {
        this.mQy = selfQRCodeUI;
        super(SelfQRCodeUI.access$700(), 8);
        this.mQz = mMActivity;
    }

    public final void onEvent(int i, String str) {
        if (str != null && i == 8) {
            if (this.mQA == null || !str.equalsIgnoreCase(this.mQA)) {
                this.mQA = str;
                Uri.fromFile(new File(SelfQRCodeUI.access$700() + str));
                SelfQRCodeUI.btv();
                x.i("MicroMsg.SelfQRCodeNewUI$ScreenshotObserver", "Send event to listener.");
            }
        }
    }

    public final void start() {
        super.startWatching();
    }

    public final void stop() {
        super.stopWatching();
    }
}
