package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.azs;
import com.tencent.mm.protocal.c.ccp;
import com.tencent.mm.protocal.c.cct;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.Iterator;

public final class ac extends eo {
    public static a dhO;
    public String kRf = "";
    private azs prn = new azs();
    public ccp pro = null;
    public cct prp = null;
    public boolean prq = false;
    public String prr = "";
    public String prs = "";
    public String prt = "";
    public String pru = "";

    static {
        a aVar = new a();
        aVar.sKy = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "wallet_region";
        aVar.sKA.put("wallet_region", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "wallet_region";
        aVar.columns[1] = "wallet_grey_item_buf";
        aVar.sKA.put("wallet_grey_item_buf", "BLOB");
        stringBuilder.append(" wallet_grey_item_buf BLOB");
        aVar.columns[2] = "rowid";
        aVar.sql = stringBuilder.toString();
        dhO = aVar;
    }

    protected final a AX() {
        return dhO;
    }

    public ac() {
        if (this.pro == null) {
            this.pro = new ccp();
        }
        if (this.prp == null) {
            this.prp = new cct();
        }
    }

    public final void d(Cursor cursor) {
        super.d(cursor);
        this.prn = new azs();
        try {
            this.prn = (azs) this.prn.aG(this.field_wallet_grey_item_buf);
            this.pro = this.prn.scn;
            this.prp = this.prn.sco;
            this.prq = this.prn.scp;
            this.pru = "";
            Iterator it = this.prn.scq.iterator();
            while (it.hasNext()) {
                this.pru += ((String) it.next()) + "\n";
            }
            if (this.prn.scl != null) {
                this.prr = ab.a(this.prn.scl.syw);
                this.prs = ab.a(this.prn.scl.syx);
            }
            if (this.prn.scm != null) {
                this.prt = ab.a(this.prn.scm.syu);
                this.kRf = ab.a(this.prn.scm.syv);
            }
            x.v("WalletRegionGreyItem", "noticeContent %s", new Object[]{this.prt});
        } catch (Exception e) {
            x.e("WalletRegionGreyItem", "parser PayIBGGetOverseaWalletRsp error");
        }
        if (this.pro == null) {
            this.pro = new ccp();
        }
        if (this.prp == null) {
            this.prp = new cct();
        }
    }
}
