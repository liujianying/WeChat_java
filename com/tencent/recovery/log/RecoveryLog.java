package com.tencent.recovery.log;

import java.util.ArrayList;

public class RecoveryLog {
    private static RecoveryLogImpl edi = new RecoveryCacheLog();

    public interface RecoveryLogImpl {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void v(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    public static void i(String str, String str2, Object... objArr) {
        if (edi != null) {
            edi.i(str, str2, objArr);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (edi != null) {
            edi.e(str, str2, objArr);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (edi != null) {
            edi.printErrStackTrace(str, th, str2, objArr);
        }
    }

    public static void a(RecoveryLogImpl recoveryLogImpl) {
        if (edi instanceof RecoveryCacheLog) {
            RecoveryCacheLog recoveryCacheLog = (RecoveryCacheLog) edi;
            int size = recoveryCacheLog.vhn.size();
            for (int i = 0; i < size; i++) {
                LogItem logItem = (LogItem) recoveryCacheLog.vhn.get(i);
                switch (logItem.level) {
                    case 1:
                        recoveryLogImpl.v(logItem.tag, logItem.vho, logItem.vhp);
                        break;
                    case 2:
                        recoveryLogImpl.d(logItem.tag, logItem.vho, logItem.vhp);
                        break;
                    case 3:
                        recoveryLogImpl.i(logItem.tag, logItem.vho, logItem.vhp);
                        break;
                    case 4:
                        recoveryLogImpl.w(logItem.tag, logItem.vho, logItem.vhp);
                        break;
                    case 5:
                        if (logItem.vhq == null) {
                            recoveryLogImpl.e(logItem.tag, logItem.vho, logItem.vhp);
                            break;
                        } else {
                            recoveryLogImpl.printErrStackTrace(logItem.tag, logItem.vhq, logItem.vho, logItem.vhp);
                            break;
                        }
                    default:
                        break;
                }
            }
            recoveryCacheLog.vhn = new ArrayList();
        }
        edi = recoveryLogImpl;
    }

    public static void cEW() {
        if (edi instanceof RecoveryFileLog) {
            ((RecoveryFileLog) edi).bC("", true);
        }
    }

    public static RecoveryLogImpl cEX() {
        return edi;
    }
}
