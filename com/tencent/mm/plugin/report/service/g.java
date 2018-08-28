package com.tencent.mm.plugin.report.service;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class g {
    private static boolean mEA = true;
    private static long mEB = 0;
    private static long mEC = 0;
    private static long mED = 0;
    private static SparseArray<Long> mEy = new SparseArray();
    private static SparseArray<HashMap<Integer, Integer>> mEz = new SparseArray();

    public static void vu(int i) {
        if (mEA) {
            mEy.put(i, Long.valueOf(bi.VF()));
            x.d("MicroMsg.ReportLogInfo", "ReportLogInfo operationBegin eventID:%d  time:%d", Integer.valueOf(i), Long.valueOf(bi.VF()));
        }
    }

    public static void er(long j) {
        if (mEA) {
            x.d("MicroMsg.ReportLogInfo", "ReportLogInfo operationBegin eventID:%d  with time:%d", Integer.valueOf(8), Long.valueOf(j));
            mEy.put(8, Long.valueOf(j));
        }
    }

    public static void vv(int i) {
        if (mEA) {
            Long l = (Long) mEy.get(i);
            if (l != null && l.longValue() != -1) {
                mEy.put(i, Long.valueOf(-1));
                long VF = bi.VF() - l.longValue();
                if (VF > 0) {
                    switch (i) {
                        case 8:
                            if (!ad.sGA) {
                                G(1, VF);
                                F(227, VF);
                                h.mEJ.e(23, 1, 2, (int) VF, false);
                                break;
                            }
                            h.mEJ.e(23, 4, 5, (int) VF, false);
                            break;
                        case 9:
                            G(3, VF);
                            F(229, VF);
                            h.mEJ.e(27, 1, 2, (int) VF, false);
                            break;
                        case 10:
                            G(2, VF);
                            F(228, VF);
                            h.mEJ.e(28, 1, 2, (int) VF, false);
                            break;
                        case 12:
                            G(6, VF);
                            break;
                        case 13:
                            G(7, VF);
                            break;
                        case 14:
                            G(8, VF);
                            break;
                        case 18:
                            G(10, VF);
                            break;
                        case 19:
                            G(9, VF);
                            break;
                        case 20:
                            G(12, VF);
                            break;
                        case 21:
                            G(11, VF);
                            break;
                        case 22:
                            G(13, VF);
                            break;
                        case 23:
                            G(16, VF);
                            break;
                        case 24:
                            G(15, VF);
                            break;
                        case 25:
                            G(14, VF);
                            break;
                    }
                    x.i("MicroMsg.ReportLogInfo", "ReportLogInfo operationEnd eventID:%d  time:%d", Integer.valueOf(i), Long.valueOf(VF));
                }
            }
        }
    }

    private static void F(int i, long j) {
        if (j > 0) {
            if (j < 1000) {
                h.mEJ.U(i, 0, 1);
            } else if (j < 2000) {
                h.mEJ.U(i, 0, 3);
            } else if (j < 5000) {
                h.mEJ.U(i, 0, 5);
            } else if (j < 10000) {
                h.mEJ.U(i, 0, 7);
            } else {
                h.mEJ.U(i, 0, 9);
            }
        }
    }

    private static void G(int i, long j) {
        long currentTimeMillis;
        if (i == 6) {
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis >= mEB + 60000) {
                mEB = currentTimeMillis;
            } else {
                return;
            }
        } else if (i == 7) {
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis >= mEC + 60000) {
                mEC = currentTimeMillis;
            } else {
                return;
            }
        } else if (i == 8) {
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis >= mED + 60000) {
                mED = currentTimeMillis;
            } else {
                return;
            }
        }
        if (a.brT().hasInit) {
            h.mEJ.a(11335, true, false, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(r0.mEF), Long.valueOf(r0.mEE[0]), Long.valueOf(r0.mEE[1]), Long.valueOf(r0.mEH));
            return;
        }
        h.mEJ.a(11335, true, false, Integer.valueOf(i), Long.valueOf(j));
    }

    public static void vw(int i) {
        if (mEA) {
            x.d("MicroMsg.ReportLogInfo", "ReportLogInfo stopOperation stop eventID:%d", Integer.valueOf(i));
            mEy.put(i, Long.valueOf(-1));
        }
    }
}
