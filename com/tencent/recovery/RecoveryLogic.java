package com.tencent.recovery;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryData;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.option.CommonOptions;
import com.tencent.recovery.service.RecoveryHandleService;
import com.tencent.recovery.service.RecoveryReportService;
import com.tencent.recovery.service.RecoveryUploadService;
import com.tencent.recovery.util.Util;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class RecoveryLogic {
    public static Field vhh = null;
    public static int vhi = 17;

    public static void a(Context context, ArrayList<RecoveryHandleItem> arrayList, String str) {
        RecoveryLog.i("Recovery.RecoveryLogic", "startReportService %s", "HandleStatus");
        Intent intent = new Intent(context, RecoveryReportService.class);
        intent.putExtra("KeyReportType", "HandleStatus");
        intent.putExtra("KeyReportUploadClassName", str);
        intent.putParcelableArrayListExtra("KeyReportItem", arrayList);
        context.startService(intent);
    }

    public static boolean a(Context context, CommonOptions commonOptions, RecoveryContext recoveryContext) {
        if (commonOptions.vhz == null) {
            RecoveryLog.i("Recovery.RecoveryLogic", "startRecoveryProcess not set handle service", new Object[0]);
            return false;
        }
        RecoveryLog.i("Recovery.RecoveryLogic", "startHandleService %s", Util.hm(context));
        String name = Util.oW(commonOptions.vhA) ? RecoveryUploadService.class.getName() : commonOptions.vhA;
        String name2 = Util.oW(commonOptions.vhz) ? RecoveryHandleService.class.getName() : commonOptions.vhz;
        Parcelable recoveryData = new RecoveryData();
        recoveryData.processName = Util.hm(context);
        recoveryData.fMk = commonOptions.fMk;
        recoveryData.vhv = commonOptions.vhv;
        recoveryData.vhw = recoveryContext.vhg;
        recoveryData.clientVersion = commonOptions.clientVersion;
        Intent intent = new Intent();
        intent.setClassName(context, commonOptions.vhz);
        intent.putExtra("KeyReportUploadClassName", name);
        intent.putExtra("KeyReportHandleClassName", name2);
        intent.putExtra("KeyRecoveryData", recoveryData);
        context.startService(intent);
        return true;
    }

    public static int bG(Context context, String str) {
        if (vhi != 17) {
            return vhi;
        }
        vhi = 16;
        if (vhh == null) {
            try {
                vhh = RunningAppProcessInfo.class.getDeclaredField("processState");
            } catch (Exception e) {
            }
        }
        if (vhh != null) {
            List runningAppProcesses;
            try {
                runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            } catch (Exception e2) {
                runningAppProcesses = null;
            }
            if (runningAppProcesses == null || runningAppProcesses.isEmpty()) {
                RecoveryLog.i("Recovery.RecoveryLogic", "can not get running app process", new Object[0]);
            } else {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null && runningAppProcessInfo.importance == 100 && runningAppProcessInfo.importanceReasonCode == 0) {
                        Integer valueOf;
                        try {
                            valueOf = Integer.valueOf(vhh.getInt(runningAppProcessInfo));
                        } catch (Exception e3) {
                            valueOf = null;
                        }
                        if (valueOf != null && valueOf.intValue() == 2) {
                            break;
                        }
                    }
                }
                RunningAppProcessInfo runningAppProcessInfo2 = null;
                if (runningAppProcessInfo2 != null) {
                    RecoveryLog.i("Recovery.RecoveryLogic", "%s %s", str, runningAppProcessInfo2.processName);
                    if (str.equals(runningAppProcessInfo2.processName)) {
                        vhi = 1;
                    }
                } else {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (RunningAppProcessInfo runningAppProcessInfo22 : runningAppProcesses) {
                        if (runningAppProcessInfo22 != null) {
                            stringBuffer.append(runningAppProcessInfo22.processName + ":" + runningAppProcessInfo22.importance + " ");
                        }
                    }
                    RecoveryLog.i("Recovery.RecoveryLogic", "foregroundInfo is null %s %s", Integer.valueOf(runningAppProcesses.size()), stringBuffer.toString());
                }
            }
        }
        return vhi;
    }
}
