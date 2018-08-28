package com.tencent.mm.plugin.offline.b;

import android.database.Cursor;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends i<r> {
    public static final String[] diD = new String[]{i.a(r.dhO, "OfflineOrderStatus")};
    public e diF;

    public a(e eVar) {
        super(eVar, r.dhO, "OfflineOrderStatus", null);
        this.diF = eVar;
    }

    public final r bkW() {
        int i = 1;
        r rVar = null;
        x.i("MicroMsg.OfflineOrderStatusStorage", "in getLastestOrder: orders count: %d, latest 3 orders: %s", new Object[]{Integer.valueOf(bkY()), bkX()});
        Cursor b = this.diF.b("SELECT * FROM OfflineOrderStatus WHERE status!=-1 ORDER BY rowid DESC LIMIT 1", null, 2);
        if (b != null) {
            b.moveToFirst();
            if (b.isAfterLast()) {
                i = 0;
            }
            if (i != 0) {
                rVar = new r();
                rVar.d(b);
            }
            b.close();
            if (rVar != null) {
                x.i("MicroMsg.OfflineOrderStatusStorage", "getLastestOrder status = " + rVar.field_status);
            } else {
                x.i("MicroMsg.OfflineOrderStatusStorage", "getLastestOrder null");
            }
        }
        return rVar;
    }

    public final r IX(String str) {
        r rVar = null;
        Cursor b = this.diF.b("select * from OfflineOrderStatus where reqkey=?", new String[]{str}, 2);
        if (b != null) {
            b.moveToFirst();
            x.i("MicroMsg.OfflineOrderStatusStorage", "in getOrderStatusByTranId: cursor.isAfterLast() = " + b.isAfterLast());
            if (!b.isAfterLast()) {
                rVar = new r();
                rVar.d(b);
            }
            b.close();
        }
        return rVar;
    }

    public final void b(r rVar) {
        if (rVar.field_reqkey == null) {
            x.e("MicroMsg.OfflineOrderStatusStorage", "status.field_reqkey is null");
            return;
        }
        int i;
        Cursor b = this.diF.b("select * from OfflineOrderStatus where reqkey=?", new String[]{rVar.field_reqkey}, 2);
        if (b == null) {
            i = 0;
        } else {
            b.moveToFirst();
            i = !b.isAfterLast() ? 1 : 0;
            b.close();
        }
        if (i == 0) {
            x.i("MicroMsg.OfflineOrderStatusStorage", "saveOfflineOrderStatus: insert reqKey: %s,  status: %d ", new Object[]{rVar.field_reqkey, Integer.valueOf(rVar.field_status)});
            b(rVar);
            return;
        }
        x.i("MicroMsg.OfflineOrderStatusStorage", "saveOfflineOrderStatus: update reqKey: %s,  status: %d ", new Object[]{rVar.field_reqkey, Integer.valueOf(rVar.field_status)});
        c(rVar, new String[0]);
    }

    public final void IY(String str) {
        r IX = IX(str);
        if (IX != null) {
            IX.field_status = -1;
        } else {
            IX = new r();
            IX.field_reqkey = str;
            IX.field_status = -1;
        }
        b(IX);
    }

    public final String bkX() {
        Cursor b = this.diF.b(String.format("SELECT * FROM %s ORDER BY %s DESC LIMIT %d;", new Object[]{"OfflineOrderStatus", "rowid", Integer.valueOf(3)}), null, 2);
        String str = "";
        if (b == null) {
            x.e("MicroMsg.OfflineOrderStatusStorage", "getAllOrdersInfo: error.cursor is null\n");
        } else {
            int i = 0;
            while (b.moveToNext()) {
                int i2 = i + 1;
                if (i2 > 3) {
                    break;
                }
                for (i = 0; i < b.getColumnCount(); i++) {
                    str = str + b.getColumnName(i) + ": " + b.getString(i) + ", ";
                }
                str = str + ";";
                i = i2;
            }
            b.close();
        }
        return str;
    }

    public final int bkY() {
        int i = 0;
        Cursor b = this.diF.b(String.format("SELECT COUNT(*) FROM %s;", new Object[]{"OfflineOrderStatus"}), null, 2);
        if (b == null) {
            x.e("MicroMsg.OfflineOrderStatusStorage", "getOrdersCount: error.cursor is null\n");
        } else {
            if (b.moveToNext() && b.getColumnCount() > 0) {
                i = b.getInt(0);
            }
            b.close();
        }
        return i;
    }
}
