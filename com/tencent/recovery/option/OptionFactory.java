package com.tencent.recovery.option;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.recovery.ConstantsRecovery.DefaultProcessOptions;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.option.CommonOptions.Builder;
import com.tencent.recovery.util.Util;

public class OptionFactory {
    private static IOptionsCreator vhE;

    public static ProcessOptions dA(String str, int i) {
        ProcessOptions processOptions = null;
        if (vhE != null) {
            processOptions = vhE.createProcessOptions(str, i);
        }
        if (processOptions != null) {
            return processOptions;
        }
        RecoveryLog.i("Recovery.OptionFactory", "not found custom process options, use default %d", Integer.valueOf(i));
        if (i == 1) {
            return DefaultProcessOptions.vgY;
        }
        return DefaultProcessOptions.vgW;
    }

    public static CommonOptions hj(Context context) {
        CommonOptions commonOptions = null;
        if (vhE != null) {
            commonOptions = vhE.createCommonOptions(context);
        }
        if (commonOptions != null) {
            return commonOptions;
        }
        RecoveryLog.i("Recovery.OptionFactory", "not found custom custom options, use default", new Object[0]);
        Builder builder = new Builder();
        builder.vhv = "";
        builder.vhB = false;
        builder.fMk = String.valueOf(Util.hl(context));
        try {
            builder.clientVersion = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
        }
        builder.vhC = 600000;
        builder.vhD = 600000;
        return builder.cEZ();
    }
}
