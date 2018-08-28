package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import android.util.SparseArray;
import com.tencent.mm.g.c.ek;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.json.JSONArray;

public final class t extends ek {
    public static a dhO;
    public ArrayList<MallFunction> kXY = new ArrayList();
    private ArrayList<MallNews> kXZ = new ArrayList();
    private ArrayList<com.tencent.mm.plugin.wallet_core.model.mall.a> kYa = new ArrayList();
    public SparseArray<String> kYb = new SparseArray();

    static {
        a aVar = new a();
        aVar.sKy = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "wallet_region";
        aVar.sKA.put("wallet_region", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "wallet_region";
        aVar.columns[1] = "function_list";
        aVar.sKA.put("function_list", "TEXT");
        stringBuilder.append(" function_list TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "new_list";
        aVar.sKA.put("new_list", "TEXT");
        stringBuilder.append(" new_list TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "banner_list";
        aVar.sKA.put("banner_list", "TEXT");
        stringBuilder.append(" banner_list TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "type_name_list";
        aVar.sKA.put("type_name_list", "TEXT");
        stringBuilder.append(" type_name_list TEXT");
        aVar.columns[5] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public final void d(Cursor cursor) {
        super.d(cursor);
        String str = this.field_function_list;
        String str2 = this.field_new_list;
        String str3 = this.field_banner_list;
        String str4 = this.field_type_name_list;
        try {
            if (!bi.oW(str)) {
                this.kXY = b.x(new JSONArray(str));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e, "", new Object[0]);
        }
        try {
            if (!bi.oW(str2)) {
                this.kXZ = b.u(new JSONArray(str2));
            }
        } catch (Throwable e2) {
            this.kXZ = null;
            x.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e2, "", new Object[0]);
        }
        try {
            if (!bi.oW(str3)) {
                this.kYa = b.v(new JSONArray(str3));
            }
        } catch (Throwable e22) {
            this.kYa = null;
            x.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e22, "", new Object[0]);
        }
        try {
            if (!bi.oW(str4)) {
                this.kYb = b.w(new JSONArray(str4));
            }
        } catch (Throwable e222) {
            this.kYb = null;
            x.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e222, "", new Object[0]);
        }
    }
}
