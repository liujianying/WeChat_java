package com.tencent.mm.storage;

import com.tencent.mm.m.a;

public final class ai extends a implements com.tencent.mm.bt.a.a<String> {
    public bd tay;

    public final /* bridge */ /* synthetic */ Object getKey() {
        return this.field_username;
    }

    public ai(String str) {
        super(str);
    }

    public final void aj(bd bdVar) {
        ai aiVar;
        long j;
        ai aiVar2;
        setStatus(bdVar.field_status);
        eX(bdVar.field_isSend);
        if (bdVar.cmk()) {
            aiVar = this;
        } else if (bdVar.field_status == 1) {
            j = Long.MAX_VALUE;
            aiVar2 = this;
            aiVar2.as(j);
            if (bdVar.cmh()) {
                setContent(bdVar.field_content);
            } else {
                setContent(bdVar.cmH());
            }
        } else {
            aiVar = this;
        }
        j = bdVar.field_createTime;
        aiVar2 = aiVar;
        aiVar2.as(j);
        if (bdVar.cmh()) {
            setContent(bdVar.field_content);
        } else {
            setContent(bdVar.cmH());
        }
    }

    public final void clx() {
        setStatus(0);
        eX(0);
        setContent("");
        ec("0");
        eV(0);
        fd(0);
        au(0);
        fc(0);
        fc(0);
        super.ed("");
        super.ee("");
    }

    public final void q(int i, byte[] bArr) {
    }

    public final void R(int i, long j) {
        switch (i) {
            case 0:
                eV((int) j);
                return;
            case 1:
                setStatus((int) j);
                return;
            case 2:
                eX((int) j);
                return;
            case 3:
                as(j);
                return;
            case 7:
                at(j);
                return;
            case 10:
                eZ((int) j);
                return;
            case 12:
                fa((int) j);
                return;
            case 13:
                fb((int) j);
                return;
            case 14:
                fd((int) j);
                return;
            default:
                return;
        }
    }

    public final void aY(int i, String str) {
        switch (i) {
            case 4:
                setUsername(str);
                return;
            case 5:
                setContent(str);
                return;
            case 6:
                ec(str);
                return;
            case 8:
                ed(str);
                return;
            case 9:
                ee(str);
                return;
            case 11:
                eg(str);
                return;
            default:
                return;
        }
    }

    public final void cks() {
    }
}
