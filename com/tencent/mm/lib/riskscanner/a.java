package com.tencent.mm.lib.riskscanner;

import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.PrintWriter;
import java.io.StringWriter;

final class a {
    private static ThreadLocal<Long> duH = new ThreadLocal();

    public static void Fi() {
        x.i("MicroMsg.RiskScannerReportService", "Report scan triggering.");
        f.mDy.a(590, 0, 1, true);
        duH.set(Long.valueOf(bi.VG()));
    }

    public static void c(Throwable th) {
        Throwable th2;
        PrintWriter printWriter;
        x.i("MicroMsg.RiskScannerReportService", "Report an exception with message: %s", new Object[]{th.getMessage()});
        duH.remove();
        f.mDy.a(590, 4, 1, true);
        StringWriter stringWriter;
        PrintWriter printWriter2;
        try {
            stringWriter = new StringWriter();
            try {
                printWriter2 = new PrintWriter(stringWriter);
                try {
                    th.printStackTrace(printWriter2);
                    printWriter2.flush();
                    f.mDy.a(14177, "-1," + stringWriter.toString().replace(",", "##"), false, true);
                    try {
                        stringWriter.close();
                    } catch (Throwable th3) {
                    }
                    try {
                        printWriter2.close();
                    } catch (Throwable th4) {
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    printWriter = printWriter2;
                    if (stringWriter != null) {
                        try {
                            stringWriter.close();
                        } catch (Throwable th6) {
                        }
                    }
                    if (printWriter != null) {
                        try {
                            printWriter.close();
                        } catch (Throwable th7) {
                        }
                    }
                    throw th2;
                }
            } catch (Throwable th8) {
                th2 = th8;
                printWriter = null;
                if (stringWriter != null) {
                    try {
                        stringWriter.close();
                    } catch (Throwable th62) {
                    }
                }
                if (printWriter != null) {
                    try {
                        printWriter.close();
                    } catch (Throwable th72) {
                    }
                }
                throw th2;
            }
        } catch (Throwable th82) {
            th2 = th82;
            printWriter = null;
            stringWriter = null;
            if (stringWriter != null) {
                try {
                    stringWriter.close();
                } catch (Throwable th622) {
                }
            }
            if (printWriter != null) {
                try {
                    printWriter.close();
                } catch (Throwable th722) {
                }
            }
            throw th2;
        }
    }

    public static void gP(int i) {
        x.i("MicroMsg.RiskScannerReportService", "Report scan result, %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case -10:
                f.mDy.a(590, 2, 1, true);
                return;
            case 0:
                Long l = (Long) duH.get();
                if (l != null) {
                    x.i("MicroMsg.RiskScannerReportService", "Scan cost: %d ms", new Object[]{Long.valueOf(bi.VG() - l.longValue())});
                    f.mDy.e(590, 5, 1, (int) r4, true);
                    return;
                }
                f.mDy.a(590, 1, 1, true);
                return;
            default:
                f.mDy.a(590, 3, 1, true);
                return;
        }
    }
}
