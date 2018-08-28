package com.tencent.recovery;

import android.content.Context;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.option.IOptionsCreator;
import com.tencent.recovery.option.ProcessOptions;
import com.tencent.recovery.util.Util;
import com.tencent.recovery.wx.WXConstantsRecovery;
import com.tencent.recovery.wx.service.WXRecoveryHandleService;
import com.tencent.recovery.wx.service.WXRecoveryUploadService;
import com.tencent.recovery.wx.util.FileUtil;
import com.tencent.recovery.wx.util.WXUtil;
import java.io.File;

public class DefaultOptionsCreator implements IOptionsCreator {
    private String clientVersion;

    public ProcessOptions createProcessOptions(String str, int i) {
        return null;
    }

    public CommonOptions createCommonOptions(Context context) {
        Builder builder = new Builder();
        builder.vhz = WXRecoveryHandleService.class.getName();
        builder.vhA = WXRecoveryUploadService.class.getName();
        builder.clientVersion = getClientVersion();
        builder.vhv = String.format("http://dldir1.qq.com/weixin/android/recovery-%s.conf", new Object[]{getClientVersion()});
        builder.fMk = WXUtil.hp(context);
        builder.vhB = true;
        builder.vhC = 600000;
        builder.vhD = 600000;
        return builder.cEZ();
    }

    private String getClientVersion() {
        if (Util.oW(this.clientVersion)) {
            File file = new File(WXConstantsRecovery.vhL, "version.info");
            if (file.exists()) {
                this.clientVersion = FileUtil.W(file);
            }
        }
        if (Util.oW(this.clientVersion)) {
            this.clientVersion = "0x26060736";
        }
        return this.clientVersion;
    }

    public String toString() {
        return String.format("Creator: [ClientVersion=%s]", new Object[]{getClientVersion()});
    }
}
