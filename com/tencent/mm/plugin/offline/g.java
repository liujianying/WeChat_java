package com.tencent.mm.plugin.offline;

import android.database.Cursor;
import com.tencent.mm.ab.e;
import com.tencent.mm.plugin.offline.a.d;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.util.HashSet;
import java.util.Map;

public final class g {
    public static String TAG = "MicroMsg.OfflineGetMsgLogic";
    public static int lII = 5000;
    private static int lIJ;
    private static int lIK = 5000;
    public static int lIL = 0;
    public static int lIM = 24;
    public static int lIN = 4;
    public static int lIO = 8;
    public static int lIP = 23;
    public static int lIQ = 6;
    public static int lIR = 5;
    public static int lIS = 20;
    public static int lIT = 20000;
    public static int lIU = 20001;
    public static int lIV = 10001;
    public static int lIW;
    public e lIX = new 1(this);
    public boolean lIY = true;
    public al lIZ = new al(new 2(this), false);
    public int status = 0;

    static /* synthetic */ void bkL() {
        x.i(TAG, "doGetOfflineMsg doScene:NetSceneOfflineGetMsg");
        d dVar = new d();
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(dVar, 0);
    }

    static {
        int intValue;
        lIJ = 30000;
        lIW = lIK;
        com.tencent.mm.kernel.g.Ek();
        Object obj = com.tencent.mm.kernel.g.Ei().DT().get(a.sXl, null);
        if (obj != null) {
            intValue = ((Integer) obj).intValue();
            lIW = intValue;
            if (intValue == 0) {
                lIW = lIK;
            }
        }
        com.tencent.mm.kernel.g.Ek();
        obj = com.tencent.mm.kernel.g.Ei().DT().get(a.sXn, Integer.valueOf(0));
        if (obj != null) {
            intValue = ((Integer) obj).intValue();
            if (intValue != 0) {
                lIJ = intValue;
            }
        }
    }

    public static int bkJ() {
        return lIJ;
    }

    public g() {
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(385, this.lIX);
    }

    private static boolean a(r rVar) {
        boolean z = false;
        if (rVar != null) {
            x.i(TAG, "isOrderClosed lastest status req_key=" + rVar.field_reqkey);
        }
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(lIT));
        hashSet.add(Integer.valueOf(lIQ));
        hashSet.add(Integer.valueOf(lIR));
        hashSet.add(Integer.valueOf(lIN));
        hashSet.add(Integer.valueOf(-1));
        if (rVar == null || hashSet.contains(Integer.valueOf(rVar.field_status))) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("isOrderClosed true;status==null?");
            if (rVar == null) {
                z = true;
            }
            x.i(str, stringBuilder.append(z).toString());
            if (rVar != null) {
                x.i(TAG, "isOrderClosed status.field_status=" + rVar.field_status);
            }
            return true;
        }
        x.i(TAG, "isOrderClosed false");
        if (rVar != null) {
            x.i(TAG, "status=" + rVar.field_status + ";req_key=" + rVar.field_reqkey);
            return false;
        }
        x.i(TAG, "isOrderClosed status=null");
        return false;
    }

    public static boolean ec(String str, String str2) {
        Object obj;
        Map z;
        String str3;
        int i;
        if (bi.oW(str2)) {
            x.i(TAG, "shouldDeal appmsg is null");
            obj = null;
        } else {
            String str4;
            String str5;
            int i2;
            boolean z2;
            Object[] objArr;
            Object[] objArr2;
            z = bl.z(str2, "sysmsg");
            str3 = (String) z.get(".sysmsg.paymsg.req_key");
            i = bi.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
            k.bkO();
            r IX = k.bkS().IX(str3);
            k.bkO();
            r bkW = k.bkS().bkW();
            boolean a = a(bkW);
            if (IX != null) {
                h.mEJ.a(135, 63, 1, true);
            } else {
                h.mEJ.a(135, 64, 1, true);
            }
            Object[] objArr3;
            if (bkW != null) {
                str4 = TAG;
                str5 = "latestStatus: reqKey: %s, status:%d, isLatestClose: %b";
                objArr3 = new Object[3];
                objArr3[0] = bkW.field_reqkey;
                objArr3[1] = Integer.valueOf(bkW.field_status);
                i2 = 2;
                z2 = a;
                objArr = objArr3;
                objArr2 = objArr3;
            } else {
                str4 = TAG;
                str5 = "latestStatus is null. isLatestClose: %b, localStatus is null ?: %b";
                objArr3 = new Object[2];
                objArr3[0] = Boolean.valueOf(a);
                i2 = 1;
                if (IX == null) {
                    z2 = true;
                    objArr = objArr3;
                    objArr2 = objArr3;
                } else {
                    z2 = false;
                    objArr = objArr3;
                    objArr2 = objArr3;
                }
            }
            objArr[i2] = Boolean.valueOf(z2);
            x.i(str4, str5, objArr2);
            if (IX == null) {
                if (bkW == null) {
                    x.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d; cannot get latest order in local storage. return true", new Object[]{str3, Integer.valueOf(i)});
                    obj = 1;
                } else if (a) {
                    x.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is closed, reqKey:%s, status:%d. return true", new Object[]{str3, Integer.valueOf(i), bkW.field_reqkey, Integer.valueOf(bkW.field_status)});
                    obj = 1;
                } else {
                    x.i(TAG, "== current reqKey: %s not in local storage, payMsgType:%d. the latest order in local storage is not closed, reqKey:%s, status:%d. return false", new Object[]{str3, Integer.valueOf(i), bkW.field_reqkey, Integer.valueOf(bkW.field_status)});
                    obj = null;
                }
            } else if (a(IX)) {
                x.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d, it is final status. return false.", new Object[]{IX.field_reqkey, Integer.valueOf(i), Integer.valueOf(IX.field_status)});
                obj = null;
            } else if (bkW == null) {
                x.i(TAG, "== unbelievable! current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; cannot get latest order in local storage , or all local orders is in give-up. return false.", new Object[]{str3, Integer.valueOf(i), Integer.valueOf(IX.field_status)});
                k.bkO();
                k.bkS().IY(str3);
                obj = null;
            } else {
                x.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s ", new Object[]{str3, Integer.valueOf(i), Integer.valueOf(IX.field_status), bkW.field_reqkey, Integer.valueOf(bkW.field_status)});
                if (IX.field_reqkey.equals(bkW.field_reqkey)) {
                    if (de(bkW.field_status, i)) {
                        x.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return true", new Object[]{str3, Integer.valueOf(i), Integer.valueOf(IX.field_status), bkW.field_reqkey, Integer.valueOf(bkW.field_status)});
                        obj = 1;
                    } else {
                        x.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are equal. return false.", new Object[]{str3, Integer.valueOf(i), Integer.valueOf(IX.field_status), bkW.field_reqkey, Integer.valueOf(bkW.field_status)});
                        if (bkW.field_status != i) {
                            x.i(TAG, "mark reqKey: %s as give up", new Object[]{str3});
                            k.bkO();
                            k.bkS().IY(str3);
                        }
                        obj = null;
                    }
                } else if (a) {
                    x.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is closed. return true.", new Object[]{str3, Integer.valueOf(i), Integer.valueOf(IX.field_status), bkW.field_reqkey, Integer.valueOf(bkW.field_status)});
                    obj = 1;
                } else {
                    x.i(TAG, "== current reqKey: %s  is in local storage, payMsgType: %d, local status is %d; the latest order is in local storage, reqKey: %s, status: %s. the two reqKeys are not equal. the latest order is not closed. return false.", new Object[]{str3, Integer.valueOf(i), Integer.valueOf(IX.field_status), bkW.field_reqkey, Integer.valueOf(bkW.field_status)});
                    k.bkO();
                    k.bkS().IY(str3);
                    obj = null;
                }
            }
        }
        if (obj != null) {
            k.bkO();
            r bkW2 = k.bkS().bkW();
            z = bl.z(str2, "sysmsg");
            i = bi.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
            str3 = (String) z.get(".sysmsg.paymsg.req_key");
            if (i == 24) {
                h.mEJ.a(135, 58, 1, true);
            } else if (i == 6) {
                h.mEJ.a(135, 59, 1, true);
            } else if (i == 4 || i == 5 || i == 20) {
                h.mEJ.a(135, 60, 1, true);
            } else if (i == 23) {
                h.mEJ.a(135, 66, 1, true);
            }
            if (bkW2 == null || bkW2.field_reqkey == null || !bkW2.field_reqkey.equals(str3)) {
                r rVar = new r();
                rVar.field_reqkey = str3;
                if (!bi.oW(str)) {
                    rVar.field_ack_key = str;
                }
                rVar.field_status = lIL;
                a(rVar, i);
            } else {
                a(bkW2, i);
            }
            x.i(TAG, "dealMsg true");
            return true;
        }
        x.i(TAG, "dealMsg false");
        return false;
    }

    private static boolean de(int i, int i2) {
        x.i(TAG, "checkStatus from=" + i + ";to=" + i2);
        if (i == i2) {
            return false;
        }
        if (i == lIL) {
            return true;
        }
        if (i == lIM) {
            if (i2 != lIM) {
                return true;
            }
            return false;
        } else if (i == lIQ) {
            if (i2 == lIT) {
                return true;
            }
            return false;
        } else if (i == lIR) {
            if (i2 == lIT) {
                return true;
            }
            return false;
        } else if (i == lIN) {
            if (i2 == lIT) {
                return true;
            }
            return false;
        } else if (i == lIS) {
            if (i2 == lIT) {
                return true;
            }
            return false;
        } else if (i == lIO || i == lIP) {
            if (i2 == lIQ || i2 == lIT) {
                return true;
            }
            return false;
        } else if (i != lIV) {
            return false;
        } else {
            if (i2 == lIQ || i2 == lIT) {
                return true;
            }
            return false;
        }
    }

    private static boolean a(r rVar, int i) {
        if (i == lIN) {
            i = lIT;
        }
        boolean de = de(rVar.field_status, i);
        x.i(TAG, "in changeStatus: isallow=%b; old status = %d; new status = %d", new Object[]{Boolean.valueOf(de), Integer.valueOf(rVar.field_status), Integer.valueOf(i)});
        if (de) {
            rVar.field_status = i;
            k.bkO();
            k.bkS().b(rVar);
        }
        return de;
    }

    public static void bR(String str, int i) {
        if (!bi.oW(str)) {
            k.bkO();
            r IX = k.bkS().IX(str);
            if (IX != null) {
                a(IX, i);
                return;
            }
            IX = new r();
            IX.field_reqkey = str;
            IX.field_status = i;
            k.bkO();
            k.bkS().b(IX);
        }
    }

    public static void bkK() {
        long j;
        x.i(TAG, "endAllOldOrder");
        k.bkO();
        com.tencent.mm.plugin.offline.b.a bkS = k.bkS();
        x.i("MicroMsg.OfflineOrderStatusStorage", "end all orders to final status. orders count: %d, latest 3 orders: %s", new Object[]{Integer.valueOf(bkS.bkY()), bkS.bkX()});
        Cursor b = bkS.diF.b(String.format("SELECT %s FROM %s ORDER BY %s DESC LIMIT 1;", new Object[]{"rowid", "OfflineOrderStatus", "rowid"}), null, 2);
        if (b == null) {
            x.e("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders: error. cursor is null \n");
            j = 0;
        } else {
            b.moveToFirst();
            j = (b.isAfterLast() || b.getColumnCount() <= 0) ? 0 : b.getLong(0);
            b.close();
        }
        if (j - 10 > 0) {
            x.i("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders. latestRowId is %d. sql: %s", new Object[]{Long.valueOf(j), String.format("DELETE FROM %s WHERE %s < %d;", new Object[]{"OfflineOrderStatus", "rowid", Long.valueOf(j - 10)})});
            bkS.diF.fV("OfflineOrderStatus", r2);
        } else {
            x.i("MicroMsg.OfflineOrderStatusStorage", "removeOlderOrders. latestRowId is %d. do nothing", new Object[]{Long.valueOf(j)});
        }
        bkS.diF.fV("OfflineOrderStatus", "UPDATE OfflineOrderStatus SET status=" + lIT + " where status!=" + lIT);
    }

    public final void stop() {
        if (com.tencent.mm.plugin.offline.c.a.bma()) {
            x.i(TAG, "OFFLINEGETMSGLOGIN STOP; IS stopped=" + this.lIZ.ciq());
            if (!this.lIZ.ciq()) {
                h.mEJ.a(135, 62, 1, true);
                this.lIZ.SO();
            }
        }
    }
}
