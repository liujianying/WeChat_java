package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.R;
import com.tencent.mm.g.a.fc;
import com.tencent.mm.g.a.fk;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.ext.b;
import com.tencent.mm.pluginsdk.d.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bu;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderMsg extends ExtContentProviderBase {
    private static final UriMatcher iJT;
    private static final String[] iJW = new String[]{"msgId", "fromUserId", "fromUserNickName", "msgType", DownloadInfo.CONTENTTYPE, "content", DownloadInfo.STATUS, "createTime"};
    private static final String[] iJX = new String[]{"userId", "unReadCount"};
    private static final String[] iJY = new String[]{"userId", "unReadCount"};
    private static final String[] iJZ = new String[]{"userId", "retCode", "msgId"};
    private static final String[] iKa = new String[]{"msgId", "retCode"};
    private static final String[] iKb = new String[]{"msgId", "retCode"};
    private String[] iJE;
    private int iJF;
    private boolean iJU;
    private Context iJV;
    private MatrixCursor iKc;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        iJT = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.message", "oneMsg", 7);
        iJT.addURI("com.tencent.mm.plugin.ext.message", "unReadCount", 8);
        iJT.addURI("com.tencent.mm.plugin.ext.message", "unReadMsgs", 9);
        iJT.addURI("com.tencent.mm.plugin.ext.message", "unReadUserList", 10);
        iJT.addURI("com.tencent.mm.plugin.ext.message", "recordMsg", 11);
        iJT.addURI("com.tencent.mm.plugin.ext.message", "playVoice", 12);
        iJT.addURI("com.tencent.mm.plugin.ext.message", "setReaded", 13);
        iJT.addURI("com.tencent.mm.plugin.ext.message", "sendTextMsg", 14);
    }

    public ExtControlProviderMsg() {
        this.iKc = null;
        this.iJU = false;
        this.iJE = null;
        this.iJF = -1;
    }

    public ExtControlProviderMsg(String[] strArr, int i, Context context) {
        this.iKc = null;
        this.iJU = false;
        this.iJE = null;
        this.iJF = -1;
        this.iJU = true;
        this.iJE = strArr;
        this.iJF = i;
        this.iJV = context;
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.i("MicroMsg.ExtControlProviderMsg", "ExtControlProviderMsg query() mIsLocalUsed :" + this.iJU);
        if (this.iJU) {
            a(uri, this.iJV, this.iJF, this.iJE);
            if (bi.oW(this.iJN)) {
                x.e("MicroMsg.ExtControlProviderMsg", "AppID == null");
                cw(3, 7);
                return a.BA(7);
            } else if (bi.oW(aIW())) {
                x.e("MicroMsg.ExtControlProviderMsg", "PkgName == null");
                cw(3, 6);
                return a.BA(6);
            } else {
                int aIX = aIX();
                if (aIX != 1) {
                    x.e("MicroMsg.ExtControlProviderMsg", "invalid appid ! return code = " + aIX);
                    cw(2, aIX);
                    return a.BA(aIX);
                }
            }
        }
        this.iJV = getContext();
        a(uri, this.iJV, iJT);
        if (uri == null) {
            pr(3);
            return null;
        } else if (bi.oW(this.iJN) || bi.oW(aIW())) {
            pr(3);
            return null;
        } else if (!atA()) {
            pr(1);
            return this.hdQ;
        } else if (!df(this.iJV)) {
            x.w("MicroMsg.ExtControlProviderMsg", "invalid appid ! return null");
            pr(2);
            return null;
        }
        String oV = bi.oV(uri.getQueryParameter("source"));
        String oV2 = bi.oV(uri.getQueryParameter("count"));
        if (!this.iJU) {
            this.iJF = iJT.match(uri);
        }
        switch (this.iJF) {
            case 7:
                return c(strArr2, oV);
            case 8:
                return o(strArr2);
            case 9:
                return a(strArr2, oV, oV2);
            case 10:
                return aIY();
            case 11:
                return p(strArr2);
            case 12:
                return q(strArr2);
            case 13:
                return r(strArr2);
            case 14:
                return s(strArr2);
            default:
                cw(3, 15);
                return null;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private Cursor o(String[] strArr) {
        x.d("MicroMsg.ExtControlProviderMsg", "getUnReadCount()");
        if (strArr == null || strArr.length <= 0) {
            x.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            pr(3);
            return null;
        }
        Cursor matrixCursor = new MatrixCursor(iJX);
        try {
            int hX;
            if ("*".equals(strArr[0])) {
                au.HU();
                hX = c.FW().hX("");
                matrixCursor.addRow(new Object[]{"0", Integer.valueOf(hX)});
            } else {
                for (String AG : strArr) {
                    long AG2 = com.tencent.mm.plugin.ext.a.a.AG(AG);
                    au.HU();
                    ab gl = c.FR().gl(AG2);
                    if (gl != null && ((int) gl.dhP) > 0) {
                        au.HU();
                        int hX2 = c.FW().hX(" and ( rconversation.username='" + gl.field_username + "' );");
                        matrixCursor.addRow(new Object[]{Long.valueOf(AG2), Integer.valueOf(hX2)});
                    }
                }
            }
            pr(0);
            return matrixCursor;
        } catch (Throwable e) {
            x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            matrixCursor.close();
            pr(4);
            return null;
        }
    }

    private Cursor a(String[] strArr, String str, String str2) {
        Throwable e;
        MatrixCursor matrixCursor;
        x.i("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs() ");
        x.d("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs(), %s, %s", new Object[]{str, str2});
        if (strArr == null || strArr.length <= 0) {
            x.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            cw(3, 3701);
            return a.BA(3701);
        } else if (bi.oW(str)) {
            x.e("MicroMsg.ExtControlProviderMsg", "callSource == null");
            cw(3, 3702);
            return a.BA(3702);
        } else if (bi.oW(str2)) {
            x.e("MicroMsg.ExtControlProviderMsg", "countStr == null");
            cw(3, 3703);
            return a.BA(3703);
        } else {
            ai Yg;
            boolean z = str != null && str.equalsIgnoreCase("openapi");
            if (z) {
                try {
                    bu Zq = b.aIM().Zq(strArr[0]);
                    if (Zq == null || bi.oW(Zq.field_openId) || bi.oW(Zq.field_username)) {
                        x.e("MicroMsg.ExtControlProviderMsg", "openidInApp is null");
                        cw(3, 3704);
                        return a.BA(3704);
                    }
                    au.HU();
                    Yg = c.FR().Yg(Zq.field_username);
                } catch (Exception e2) {
                    e = e2;
                    matrixCursor = null;
                    x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                    x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                    if (matrixCursor != null) {
                        matrixCursor.close();
                    }
                    H(3, 4, 12);
                    return a.BA(12);
                }
            }
            long AG = com.tencent.mm.plugin.ext.a.a.AG(strArr[0]);
            au.HU();
            Yg = c.FR().gl(AG);
            if (Yg == null || Yg.field_username == null || Yg.field_username.length() <= 0) {
                x.e("MicroMsg.ExtControlProviderMsg", "contact is null");
                cw(3, 3705);
                return a.BA(3705);
            }
            boolean z2;
            Cursor bE;
            String BL = Yg.BL();
            if (Yg.field_username.endsWith("@chatroom")) {
                BL = r.gT(Yg.field_username);
                z2 = true;
            } else {
                z2 = false;
            }
            if (z) {
                int i;
                try {
                    i = bi.getInt(str2, 0);
                } catch (Exception e3) {
                    x.e("MicroMsg.ExtControlProviderMsg", "exception in parseInt(%s)", new Object[]{str2});
                    i = 0;
                }
                if (i <= 0 || i >= 15) {
                    au.HU();
                    bE = c.FT().bE(Yg.field_username, 15);
                } else {
                    au.HU();
                    bE = c.FT().bE(Yg.field_username, i);
                }
            } else {
                au.HU();
                bE = c.FT().bE(Yg.field_username, 3);
            }
            if (bE == null) {
                x.e("MicroMsg.ExtControlProviderMsg", "msgCursor == null");
                H(3, 4, 3706);
                return a.BA(3706);
            }
            matrixCursor = new MatrixCursor(iJW);
            try {
                if (bE.getCount() <= 0 || !bE.moveToFirst()) {
                    bE.close();
                    H(2, 0, 1);
                    return matrixCursor;
                }
                bd bdVar = new bd();
                do {
                    bdVar.d(bE);
                    a(matrixCursor, bdVar, Yg, z2, BL, z, strArr[0]);
                } while (bE.moveToNext());
                bE.close();
                H(2, 0, 1);
                return matrixCursor;
            } catch (Exception e4) {
                e = e4;
                x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                if (matrixCursor != null) {
                    matrixCursor.close();
                }
                H(3, 4, 12);
                return a.BA(12);
            }
        }
    }

    private Cursor aIY() {
        x.d("MicroMsg.ExtControlProviderMsg", "getUnReadUserList()");
        Object matrixCursor = new MatrixCursor(iJY);
        try {
            au.HU();
            Cursor bdi = c.FT().bdi();
            if (bdi != null) {
                if (bdi.moveToFirst()) {
                    do {
                        String string = bdi.getString(bdi.getColumnIndex("talker"));
                        au.HU();
                        ab Yg = c.FR().Yg(string);
                        if (!s.fq(string)) {
                            int i = (s.hO(Yg.field_username) || s.hM(Yg.field_username) || ab.Dk(Yg.field_verifyFlag) || s.hE(Yg.field_username) || s.hF(Yg.field_username)) ? 0 : 1;
                            if (i == 0) {
                                long j = (long) ((int) Yg.dhP);
                                matrixCursor.addRow(new Object[]{com.tencent.mm.plugin.ext.a.a.dc(j), Integer.valueOf(bdi.getInt(bdi.getColumnIndex("unReadCount")))});
                            }
                        }
                    } while (bdi.moveToNext());
                }
                bdi.close();
            }
            pr(0);
            return matrixCursor;
        } catch (Throwable e) {
            x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            matrixCursor.close();
            pr(4);
            return null;
        }
    }

    private Cursor c(String[] strArr, String str) {
        Throwable e;
        boolean z = true;
        x.d("MicroMsg.ExtControlProviderMsg", "getOneMsg()");
        if (strArr == null || strArr.length <= 0) {
            x.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            pr(3);
            return null;
        }
        MatrixCursor matrixCursor;
        try {
            long AG = com.tencent.mm.plugin.ext.a.a.AG(strArr[0]);
            au.HU();
            bd dW = c.FT().dW(AG);
            au.HU();
            ab Yg = c.FR().Yg(dW.field_talker);
            if (Yg == null || ((int) Yg.dhP) <= 0) {
                pr(3);
                return null;
            }
            boolean z2;
            String BL = Yg.BL();
            if (Yg.field_username.endsWith("@chatroom")) {
                BL = r.gT(Yg.field_username);
                z2 = true;
            } else {
                z2 = false;
            }
            if (str == null || !str.equalsIgnoreCase("openapi")) {
                z = false;
            }
            matrixCursor = new MatrixCursor(iJW);
            try {
                a(matrixCursor, dW, Yg, z2, BL, z, strArr[0]);
                pr(0);
                return matrixCursor;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            matrixCursor = null;
            x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            if (matrixCursor != null) {
                matrixCursor.close();
            }
            pr(4);
            return null;
        }
    }

    private Cursor p(String[] strArr) {
        Cursor cursor = null;
        x.d("MicroMsg.ExtControlProviderMsg", "handleRecordMsg()");
        if (strArr == null || strArr.length < 2) {
            x.w("MicroMsg.ExtControlProviderMsg", "wrong args");
            pr(3);
            return cursor;
        }
        try {
            int intValue = Integer.valueOf(strArr[0]).intValue();
            long AG = com.tencent.mm.plugin.ext.a.a.AG(strArr[1]);
            if (AG <= 0) {
                pr(3);
                return cursor;
            }
            com.tencent.mm.pluginsdk.d.a.b bVar = new com.tencent.mm.pluginsdk.d.a.b();
            bVar.b(4000, new 1(this, intValue, AG, bVar, strArr));
            return this.iKc;
        } catch (Throwable e) {
            x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            if (this.iKc != null) {
                this.iKc.close();
            }
            pr(4);
            return cursor;
        }
    }

    private Cursor q(String[] strArr) {
        Throwable e;
        MatrixCursor matrixCursor;
        x.d("MicroMsg.ExtControlProviderMsg", "handlePlayVoice()");
        if (strArr == null || strArr.length < 2) {
            x.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            pr(3);
            return null;
        }
        try {
            int intValue = Integer.valueOf(strArr[0]).intValue();
            long AG = com.tencent.mm.plugin.ext.a.a.AG(strArr[1]);
            if (AG <= 0) {
                pr(3);
                return null;
            } else if (intValue == 3) {
                MatrixCursor matrixCursor2 = new MatrixCursor(iKa);
                try {
                    fk fkVar = new fk();
                    fkVar.bNM.bJC = AG;
                    com.tencent.mm.sdk.b.a.sFg.m(fkVar);
                    if (fkVar.bNN.fileName == null || fkVar.bNN.fileName.length() <= 0) {
                        matrixCursor2.addRow(new Object[]{strArr[1], Integer.valueOf(2)});
                        pr(4);
                        return matrixCursor2;
                    }
                    fc fcVar = new fc();
                    fcVar.bNi.op = 1;
                    fcVar.bNi.fileName = fkVar.bNN.fileName;
                    if (com.tencent.mm.sdk.b.a.sFg.m(fcVar)) {
                        matrixCursor2.addRow(new Object[]{strArr[1], Integer.valueOf(1)});
                        pr(0);
                    } else {
                        x.e("MicroMsg.ExtControlProviderMsg", "play failed");
                        matrixCursor2.addRow(new Object[]{strArr[1], Integer.valueOf(2)});
                        pr(4);
                    }
                    b.aIJ();
                    b.db(AG);
                    return matrixCursor2;
                } catch (Exception e2) {
                    e = e2;
                    matrixCursor = matrixCursor2;
                    x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                    x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                    if (matrixCursor != null) {
                        matrixCursor.close();
                    }
                    pr(4);
                    return null;
                }
            } else if (intValue != 4) {
                return null;
            } else {
                fc fcVar2 = new fc();
                fcVar2.bNi.op = 2;
                if (com.tencent.mm.sdk.b.a.sFg.m(fcVar2)) {
                    x.i("MicroMsg.ExtControlProviderMsg", "stop last playing");
                    pr(0);
                    return null;
                }
                x.i("MicroMsg.ExtControlProviderMsg", "stop last playing fail");
                pr(4);
                return null;
            }
        } catch (Throwable e3) {
            e = e3;
            matrixCursor = null;
            x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            if (matrixCursor != null) {
                matrixCursor.close();
            }
            pr(4);
            return null;
        }
    }

    private Cursor r(String[] strArr) {
        x.i("MicroMsg.ExtControlProviderMsg", "setMsgReaded()");
        if (strArr == null || strArr.length <= 0) {
            x.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            cw(3, 3801);
            return a.BA(3801);
        }
        int i = 0;
        while (i < strArr.length) {
            try {
                if (strArr[i] == null || strArr[i].length() <= 0) {
                    x.w("MicroMsg.ExtControlProviderMsg", "setMsgReaded() wrongArgs i = " + i);
                } else {
                    long AG = com.tencent.mm.plugin.ext.a.a.AG(strArr[i]);
                    b.aIJ();
                    b.db(AG);
                }
                i++;
            } catch (Throwable e) {
                x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                cw(4, 12);
                return a.BA(12);
            }
        }
        cw(0, 1);
        return a.BA(1);
    }

    private Cursor s(String[] strArr) {
        x.d("MicroMsg.ExtControlProviderMsg", "sendTextMsg()");
        if (strArr == null || strArr.length <= 0) {
            x.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            pr(3);
            return null;
        }
        try {
            long AG = com.tencent.mm.plugin.ext.a.a.AG(strArr[0]);
            if (AG <= 0) {
                pr(3);
                return null;
            }
            b.aIJ();
            ab da = b.da(AG);
            if (da == null || ((int) da.dhP) <= 0) {
                x.e("MicroMsg.ExtControlProviderMsg", "toContact is null ");
                pr(3);
                return null;
            }
            this.iKc = new MatrixCursor(iKb);
            com.tencent.mm.pluginsdk.d.a.b bVar = new com.tencent.mm.pluginsdk.d.a.b();
            bVar.b(15000, new 2(this, da, strArr, bVar));
            return this.iKc;
        } catch (Throwable e) {
            x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            if (this.iKc != null) {
                this.iKc.close();
            }
            pr(4);
            return null;
        }
    }

    private void a(MatrixCursor matrixCursor, bd bdVar, ab abVar, boolean z, String str, boolean z2, String str2) {
        if (bdVar != null) {
            if (bi.oW(str2)) {
                x.d("MicroMsg.ExtControlProviderMsg", "userOpenId is null");
            } else if (bdVar.getType() != 9999 && bdVar.getType() != 10000) {
                String str3 = "";
                String str4 = "";
                if (z) {
                    int iA = com.tencent.mm.model.bd.iA(bdVar.field_content);
                    if (iA != -1 && bdVar.field_content.length() > iA) {
                        String trim = bdVar.field_content.substring(0, iA).trim();
                        if (trim != null && trim.length() > 0 && bdVar.field_content.length() >= iA + 2) {
                            str3 = r.gT(trim);
                            str4 = bdVar.field_content.substring(iA + 2);
                        }
                    }
                }
                String str5 = "";
                int P = com.tencent.mm.plugin.ext.b.b.P(bdVar);
                if (P == 1) {
                    if (z) {
                        str3 = str3 + "!]" + str4;
                    } else {
                        str3 = bdVar.field_content;
                    }
                } else if (P == 2) {
                    p iH = m.TI().iH((int) bdVar.field_msgId);
                    if (iH == null || iH.fileName == null) {
                        str4 = str5;
                    } else {
                        str4 = q.getFullPath(iH.fileName);
                        x.d("MicroMsg.ExtControlProviderMsg", "voice file = %s", new Object[]{str4});
                    }
                    str3 = str4;
                } else if (!z) {
                    if (this.iJV != null) {
                        str3 = this.iJV.getString(R.l.ext_receive_unknown_type_message);
                    } else {
                        str3 = "";
                    }
                }
                if (!z2) {
                    str2 = com.tencent.mm.plugin.ext.a.a.dc((long) ((int) abVar.dhP));
                }
                try {
                    if (bi.oW(str2)) {
                        x.w("MicroMsg.ExtControlProviderMsg", "userId is null");
                        return;
                    }
                    Object[] objArr = new Object[8];
                    objArr[0] = com.tencent.mm.plugin.ext.a.a.dc(bdVar.field_msgId);
                    objArr[1] = str2;
                    objArr[2] = str;
                    objArr[3] = Integer.valueOf(bdVar.field_isSend == 0 ? 1 : 2);
                    objArr[4] = Integer.valueOf(P);
                    objArr[5] = str3;
                    objArr[6] = Integer.valueOf(bdVar.field_status == 4 ? 1 : 2);
                    objArr[7] = Long.valueOf(bdVar.field_createTime);
                    matrixCursor.addRow(objArr);
                } catch (Throwable e) {
                    x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                    x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                }
            }
        }
    }
}
