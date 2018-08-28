package com.tencent.mm.plugin.ext.provider;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ext.b;
import com.tencent.mm.pluginsdk.d.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bu;
import com.tencent.wcdb.database.SQLiteDatabase;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderEntry extends ExtContentProviderBase {
    private static final UriMatcher iJT;
    private String[] iJE;
    private int iJF;
    private boolean iJU;
    private Context iJV;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        iJT = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.entry", "view_profile", 2);
        iJT.addURI("com.tencent.mm.plugin.ext.entry", "to_chatting", 3);
        iJT.addURI("com.tencent.mm.plugin.ext.entry", "to_nearby", 4);
        iJT.addURI("com.tencent.mm.plugin.ext.entry", "sns_comment_detail", 5);
        iJT.addURI("com.tencent.mm.plugin.ext.entry", "share_time_line", 6);
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public ExtControlProviderEntry() {
        this.iJU = false;
        this.iJE = null;
        this.iJF = -1;
    }

    public ExtControlProviderEntry(String[] strArr, int i, Context context) {
        this.iJU = false;
        this.iJE = null;
        this.iJF = -1;
        this.iJU = true;
        this.iJE = strArr;
        this.iJF = i;
        this.iJV = context;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.i("MicroMsg.ExtControlEntryProvider", "ExtControlProviderEntry query() mIsLocalUsed :" + this.iJU);
        if (this.iJU) {
            a(uri, this.iJV, this.iJF, this.iJE);
            if (bi.oW(this.iJN)) {
                x.e("MicroMsg.ExtControlEntryProvider", "AppID == null");
                cw(3, 7);
                return a.BA(7);
            } else if (bi.oW(aIW())) {
                x.e("MicroMsg.ExtControlEntryProvider", "PkgName == null");
                cw(3, 6);
                return a.BA(6);
            } else {
                int aIX = aIX();
                if (aIX != 1) {
                    x.e("MicroMsg.ExtControlEntryProvider", "invalid appid ! return code = " + aIX);
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
            return a.BA(3);
        } else if (!atA()) {
            pr(1);
            return this.hdQ;
        } else if (!df(this.iJV)) {
            x.w("MicroMsg.ExtControlEntryProvider", "invalid appid ! return null");
            pr(2);
            return null;
        }
        String oV = bi.oV(uri.getQueryParameter("source"));
        if (!this.iJU) {
            this.iJF = iJT.match(uri);
        }
        switch (this.iJF) {
            case 2:
                return m(strArr2);
            case 3:
                return b(strArr2, oV);
            case 4:
                if (this.iJV == null) {
                    pr(4);
                    return null;
                }
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI"));
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                this.iJV.startActivity(intent);
                pr(0);
                return a.BA(1);
            case 5:
                return n(strArr2);
            case 6:
                if (strArr2 == null || strArr2.length <= 0) {
                    x.w("MicroMsg.ExtControlEntryProvider", "wrong args");
                    pr(3);
                    return null;
                } else if (this.iJV == null) {
                    pr(4);
                    return null;
                } else {
                    Intent intent2 = new Intent();
                    intent2.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI"));
                    intent2.setAction("android.intent.action.SEND");
                    intent2.addCategory("android.intent.category.DEFAULT");
                    intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    intent2.putExtra("android.intent.extra.TEXT", strArr2[1] == null ? "" : strArr2[1]);
                    if (strArr2[0] != null && strArr2[0].trim().length() > 0) {
                        intent2.putExtra("android.intent.extra.STREAM", Uri.parse(strArr2[0]));
                    }
                    intent2.putExtra("Ksnsupload_empty_img", true);
                    intent2.setType("image/*");
                    this.iJV.startActivity(intent2);
                    pr(0);
                    return a.BA(1);
                }
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

    private Cursor m(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            x.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            pr(3);
            return null;
        }
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            x.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
            pr(3);
            return null;
        }
        try {
            au.HU();
            ai gl = c.FR().gl(com.tencent.mm.plugin.ext.a.a.AG(str));
            if (gl == null || ((int) gl.dhP) <= 0 || this.iJV == null) {
                pr(3);
                return null;
            }
            Intent intent = new Intent();
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("Contact_User", gl.field_username);
            d.b(this.iJV, "profile", ".ui.ContactInfoUI", intent);
            pr(0);
            return a.BA(1);
        } catch (Throwable e) {
            x.w("MicroMsg.ExtControlEntryProvider", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlEntryProvider", e, "", new Object[0]);
            pr(3);
            return null;
        }
    }

    private Cursor b(String[] strArr, String str) {
        x.i("MicroMsg.ExtControlEntryProvider", "toChattingUI");
        if (strArr == null || strArr.length <= 0) {
            x.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            cw(3, 3601);
            return a.BA(3601);
        } else if (bi.oW(str)) {
            x.w("MicroMsg.ExtControlEntryProvider", "callSource == null");
            cw(3, 3602);
            return a.BA(3602);
        } else {
            String str2 = strArr[0];
            if (str2 == null || str2.length() <= 0) {
                x.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
                cw(3, 3603);
                return a.BA(3603);
            }
            ai Yg;
            boolean z = str != null && str.equalsIgnoreCase("openapi");
            if (z) {
                try {
                    bu Zq = b.aIM().Zq(str2);
                    if (Zq == null || bi.oW(Zq.field_openId) || bi.oW(Zq.field_username)) {
                        x.e("MicroMsg.ExtControlEntryProvider", "openidInApp is null");
                        cw(3, 3604);
                        return a.BA(3604);
                    }
                    au.HU();
                    Yg = c.FR().Yg(Zq.field_username);
                } catch (Throwable e) {
                    x.w("MicroMsg.ExtControlEntryProvider", e.getMessage());
                    x.printErrStackTrace("MicroMsg.ExtControlEntryProvider", e, "", new Object[0]);
                    H(5, 4, 12);
                    return a.BA(12);
                }
            }
            au.HU();
            Yg = c.FR().gl(com.tencent.mm.plugin.ext.a.a.AG(str2));
            if (Yg == null || ((int) Yg.dhP) <= 0 || this.iJV == null) {
                x.e("MicroMsg.ExtControlEntryProvider", "wrong args ct");
                cw(3, 3605);
                return a.BA(3605);
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.chatting.ChattingUI"));
            intent.putExtra("Chat_User", Yg.field_username);
            intent.putExtra("finish_direct", true);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.addFlags(67108864);
            this.iJV.startActivity(intent);
            H(4, 0, 1);
            return a.BA(1);
        }
    }

    private Cursor n(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            x.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            pr(3);
            return null;
        }
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            x.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            pr(3);
            return null;
        }
        try {
            long AG = com.tencent.mm.plugin.ext.a.a.AG(str);
            if (AG <= 0) {
                pr(3);
                return null;
            } else if (this.iJV == null) {
                pr(4);
                return null;
            } else {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI"));
                intent.putExtra("INTENT_SNS_LOCAL_ID", (int) AG);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                this.iJV.startActivity(intent);
                pr(0);
                return a.BA(1);
            }
        } catch (Throwable e) {
            x.w("MicroMsg.ExtControlEntryProvider", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlEntryProvider", e, "", new Object[0]);
            pr(3);
            return null;
        }
    }
}
