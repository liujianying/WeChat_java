package com.tencent.mm.modelmulti;

import android.database.Cursor;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public final class r {
    private static ArrayList<by> eaT = new ArrayList();
    private static ArrayList<ab> eaU = new ArrayList();

    static /* synthetic */ void mp(String str) {
        Throwable e;
        int i = 0;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        i++;
                        String[] split = readLine.split("###");
                        if (split == null || split.length != 3) {
                            String str2 = "MicroMsg.TestSyncAddMsg";
                            String str3 = "readMsgFromFile parse line %d failed : len:%d ";
                            Object[] objArr = new Object[2];
                            objArr[0] = Integer.valueOf(i);
                            objArr[1] = Integer.valueOf(split == null ? -1 : split.length);
                            x.e(str2, str3, objArr);
                        } else {
                            by byVar = new by();
                            byVar.rck = new bhz().VO(q.GF());
                            byVar.hcd = 2;
                            byVar.rcn = new bhy().bq(new byte[0]);
                            byVar.jQd = bi.getInt(split[0], 0);
                            byVar.rcm = bi.getInt(split[1], 0);
                            byVar.rcl = new bhz().VO(split[2]);
                            eaT.add(byVar);
                        }
                    } else {
                        try {
                            bufferedReader.close();
                            return;
                        } catch (Exception e2) {
                            return;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        x.e("MicroMsg.TestSyncAddMsg", "readMsgFromFile failed e:%s", new Object[]{e.getMessage()});
                        x.printErrStackTrace("MicroMsg.TestSyncAddMsg", e, "", new Object[0]);
                        try {
                            bufferedReader.close();
                        } catch (Exception e4) {
                            return;
                        }
                    } catch (Throwable th) {
                        e = th;
                        try {
                            bufferedReader.close();
                        } catch (Exception e5) {
                        }
                        throw e;
                    }
                }
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
            x.e("MicroMsg.TestSyncAddMsg", "readMsgFromFile failed e:%s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.TestSyncAddMsg", e, "", new Object[0]);
            bufferedReader.close();
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            bufferedReader.close();
            throw e;
        }
    }

    static /* synthetic */ void vg() {
        au.HU();
        Cursor d = c.FR().d(null, null, new ArrayList());
        while (d.moveToNext()) {
            ab abVar = new ab();
            abVar.d(d);
            eaU.add(abVar);
        }
        d.close();
    }

    public static void bh(int i, int i2) {
        au.Em().H(new 1(i, i2));
    }
}
