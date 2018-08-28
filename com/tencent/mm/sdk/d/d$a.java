package com.tencent.mm.sdk.d;

import android.os.Message;
import android.text.TextUtils;
import java.util.Calendar;

public class d$a {
    private d sJS;
    private long sJT;
    private int sJU;
    private String sJV;
    private a sJW;
    private a sJX;
    private a sJY;

    d$a(d dVar, Message message, String str, a aVar, a aVar2, a aVar3) {
        a(dVar, message, str, aVar, aVar2, aVar3);
    }

    public final void a(d dVar, Message message, String str, a aVar, a aVar2, a aVar3) {
        this.sJS = dVar;
        this.sJT = System.currentTimeMillis();
        this.sJU = message != null ? message.what : 0;
        this.sJV = str;
        this.sJW = aVar;
        this.sJX = aVar2;
        this.sJY = aVar3;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("time=");
        Calendar.getInstance().setTimeInMillis(this.sJT);
        stringBuilder.append(String.format("%tm-%td %tH:%tM:%tS.%tL", new Object[]{r0, r0, r0, r0, r0, r0}));
        stringBuilder.append(" processed=");
        stringBuilder.append(this.sJW == null ? "<null>" : this.sJW.getName());
        stringBuilder.append(" org=");
        stringBuilder.append(this.sJX == null ? "<null>" : this.sJX.getName());
        stringBuilder.append(" dest=");
        stringBuilder.append(this.sJY == null ? "<null>" : this.sJY.getName());
        stringBuilder.append(" what=");
        Object obj = this.sJS != null ? null : "";
        if (TextUtils.isEmpty(obj)) {
            stringBuilder.append(this.sJU);
            stringBuilder.append("(0x");
            stringBuilder.append(Integer.toHexString(this.sJU));
            stringBuilder.append(")");
        } else {
            stringBuilder.append(obj);
        }
        if (!TextUtils.isEmpty(this.sJV)) {
            stringBuilder.append(" ");
            stringBuilder.append(this.sJV);
        }
        return stringBuilder.toString();
    }
}
