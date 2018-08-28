package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.q;
import com.tencent.mm.y.g.a;

public class au extends c {
    public String bKk;
    public a bXA;
    public String bZG;
    public String bZH;
    public String cGB;
    public String ceR;
    public int cfR;
    public String chatroomName;
    public String desc;
    public String designerName;
    public String designerRediretctUrl;
    public int designerUIN;
    public String dyH;
    public String iconUrl;
    public int pSA;
    public long pSz;
    public int pageType;
    public int position;
    public String secondUrl;
    public boolean tGg;
    public int tid;
    public String title;
    public boolean ufA;
    public String ufB;
    public boolean ufC;
    public String ufD;
    public Bundle ufE;
    public q ufF;
    public boolean ufx;
    public String ufy;
    public boolean ufz;
    public String userName;

    public au() {
        this.cfR = 0;
    }

    public au(bd bdVar, int i, String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7, String str8) {
        this.cfR = 0;
        this.bXQ = bdVar;
        this.tGg = false;
        this.position = i;
        this.userName = str;
        this.ufx = false;
        this.title = str2;
        this.bZG = str3;
        this.bZH = str4;
        this.ufy = str5;
        this.designerUIN = i2;
        this.designerName = str6;
        this.designerRediretctUrl = str7;
        this.cGB = str8;
    }

    public au(bd bdVar, boolean z, int i, String str, boolean z2, String str2, String str3, String str4, String str5, String str6, String str7, boolean z3, boolean z4) {
        this.cfR = 0;
        this.bXQ = bdVar;
        this.tGg = z;
        this.position = i;
        this.userName = str;
        this.ufx = z2;
        this.title = str2;
        this.bZG = str3;
        this.bZH = str4;
        this.ufy = str5;
        this.bKk = str6;
        this.cGB = str7;
        this.ufz = z3;
        this.ufA = z4;
    }

    public au(bd bdVar, boolean z, int i, String str, boolean z2, String str2, String str3, String str4, String str5) {
        this(bdVar, z, i, str, z2, str2, str3, str4, str5, null, null, false, false);
    }

    public au(bd bdVar, boolean z, int i, String str, boolean z2, String str2, String str3, String str4) {
        this(bdVar, z, i, str, z2, str2, str3, str4, null);
    }

    private au(bd bdVar, boolean z, int i, String str) {
        this(bdVar, z, i, str, false, null, null, null);
    }

    private au(bd bdVar, boolean z, int i, String str, byte b) {
        this(bdVar, z, i, str);
    }

    public au(bd bdVar, boolean z, int i, String str, char c) {
        this(bdVar, z, i, str, (byte) 0);
    }

    public au(bd bdVar, boolean z, int i, String str, String str2) {
        this(bdVar, z, i, str, (byte) 0);
        this.chatroomName = str2;
    }

    public au(bd bdVar, String str) {
        this(str);
        this.bXQ = bdVar;
    }

    private au(String str) {
        this.cfR = 0;
        this.userName = str;
    }

    public au(String str, String str2) {
        this.cfR = 0;
        this.userName = str;
        this.chatroomName = str2;
    }

    public au(bd bdVar, String str, String str2) {
        this.cfR = 0;
        this.bXQ = bdVar;
        this.userName = str;
        this.bXQ = bdVar;
        this.ufD = str2;
    }

    public static au aaI(String str) {
        au auVar = new au();
        auVar.cGB = str;
        return auVar;
    }

    public static au a(a aVar, bd bdVar) {
        au auVar = new au();
        auVar.bXA = aVar;
        auVar.bXQ = bdVar;
        return auVar;
    }

    public static au b(bd bdVar, boolean z, int i) {
        au auVar = new au();
        auVar.bXQ = bdVar;
        auVar.tGg = z;
        auVar.position = i;
        auVar.ufC = false;
        return auVar;
    }
}
