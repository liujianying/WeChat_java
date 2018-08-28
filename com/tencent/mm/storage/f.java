package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.a.o;
import com.tencent.mm.bt.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.x;

public final class f implements a<String> {
    public long dhP;
    private String field_alias;
    public String field_conRemark;
    public int field_deleteFlag;
    public String field_descWording;
    public String field_descWordingId;
    public String field_descWordingQuanpin;
    public byte[] field_lvbuff;
    public String field_nickname;
    public String field_openImAppid;
    public String field_remarkDesc;
    public int field_showHead;
    public String field_signature;
    public String field_username;
    public int field_verifyFlag;
    public int field_weiboFlag;
    public CharSequence sNQ;

    public final /* bridge */ /* synthetic */ Object getKey() {
        return this.field_username;
    }

    public final void d(Cursor cursor) {
        this.field_username = cursor.getString(0);
        this.field_nickname = cursor.getString(1);
        this.field_alias = cursor.getString(2);
        this.field_conRemark = cursor.getString(3);
        this.field_verifyFlag = cursor.getInt(4);
        this.field_showHead = cursor.getInt(5);
        this.field_weiboFlag = cursor.getInt(6);
        this.dhP = cursor.getLong(7);
        this.field_deleteFlag = cursor.getInt(8);
        this.field_lvbuff = cursor.getBlob(9);
        this.field_descWordingId = cursor.getString(10);
        this.field_openImAppid = cursor.getString(11);
        if (cursor.getColumnCount() >= 14) {
            this.field_descWording = cursor.getString(12);
            this.field_descWordingQuanpin = cursor.getString(13);
        }
        ckr();
    }

    public final String BL() {
        if (this.field_conRemark != null && !this.field_conRemark.trim().equals("")) {
            return this.field_conRemark;
        }
        String fv = com.tencent.mm.l.a.fv(this.field_username);
        if (fv != null) {
            return fv;
        }
        if (this.field_nickname != null && this.field_nickname.length() > 0) {
            return this.field_nickname;
        }
        fv = this.field_alias;
        if (!bi.oW(fv)) {
            return fv;
        }
        fv = this.field_username;
        if (fv == null) {
            fv = null;
        } else if (fv.toLowerCase().endsWith("@t.qq.com")) {
            fv = "@" + fv.replace("@t.qq.com", "");
        } else if (fv.toLowerCase().endsWith("@qqim")) {
            fv = fv.replace("@qqim", "");
            long longValue = Long.valueOf(fv).longValue();
            if (longValue < 0) {
                fv = new o(longValue).toString();
            }
        }
        return (fv == null || fv.length() == 0) ? this.field_username : fv;
    }

    private void ckr() {
        if (this.field_lvbuff != null) {
            try {
                if (this.field_lvbuff != null && this.field_lvbuff.length != 0) {
                    u uVar = new u();
                    if (uVar.by(this.field_lvbuff) == 0) {
                        uVar.CX(4);
                        uVar.CX(4);
                        uVar.chC();
                        uVar.CX(8);
                        uVar.CX(4);
                        uVar.chC();
                        uVar.chC();
                        uVar.CX(4);
                        uVar.CX(4);
                        uVar.chC();
                        uVar.chC();
                        uVar.CX(4);
                        uVar.CX(4);
                        this.field_signature = uVar.getString();
                        uVar.chC();
                        uVar.chC();
                        uVar.chC();
                        uVar.CX(4);
                        uVar.CX(4);
                        uVar.chC();
                        uVar.CX(4);
                        uVar.chC();
                        uVar.chC();
                        uVar.CX(4);
                        uVar.CX(4);
                        if (!uVar.chD()) {
                            this.field_remarkDesc = uVar.getString();
                        }
                        this.field_lvbuff = null;
                    }
                }
            } catch (Throwable e) {
                x.e("MicroMsg.AddressUIContact", "exception:%s", new Object[]{bi.i(e)});
            }
        }
    }

    public final void q(int i, byte[] bArr) {
        if (i == 9) {
            this.field_lvbuff = bArr;
        }
    }

    public final void R(int i, long j) {
        switch (i) {
            case 4:
                this.field_verifyFlag = (int) j;
                return;
            case 5:
                this.field_showHead = (int) j;
                return;
            case 6:
                this.field_weiboFlag = (int) j;
                return;
            case 7:
                this.dhP = j;
                return;
            case 8:
                this.field_deleteFlag = (int) j;
                return;
            default:
                return;
        }
    }

    public final void aY(int i, String str) {
        switch (i) {
            case 0:
                this.field_username = str;
                return;
            case 1:
                this.field_nickname = str;
                return;
            case 2:
                this.field_alias = str;
                return;
            case 3:
                this.field_conRemark = str;
                return;
            case 10:
                this.field_descWordingId = str;
                return;
            case 11:
                this.field_openImAppid = str;
                return;
            case 12:
                this.field_descWording = str;
                return;
            case 13:
                this.field_descWordingQuanpin = str;
                return;
            default:
                return;
        }
    }

    public final void cks() {
        ckr();
    }
}
