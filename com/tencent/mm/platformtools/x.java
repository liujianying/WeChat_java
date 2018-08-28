package com.tencent.mm.platformtools;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.Settings;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l$a;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.storage.ab;
import java.util.regex.Pattern;

public final class x {
    public static int a(Context context, a aVar) {
        if (context == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.MMAccountManager", "context is null");
            return 0;
        }
        String VC = VC();
        if (bi.oW(VC)) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.MMAccountManager", "account username is null or nil");
            VC = (String) g.Ei().DT().get(6, "");
            if (bi.oW(VC)) {
                return 0;
            }
        }
        if (J(context, VC)) {
            return 3;
        }
        if (!a.bj(context, "android.permission.READ_CONTACTS")) {
            return 2;
        }
        try {
            AccountManager accountManager = AccountManager.get(context);
            Account account = new Account(VC, "com.tencent.mm.account");
            if (accountManager.addAccountExplicitly(account, "", null)) {
                ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
                Bundle bundle = new Bundle();
                bundle.putString("authAccount", VC);
                bundle.putString("accountType", "com.tencent.mm.account");
                if (aVar != null) {
                    aVar.l(bundle);
                }
                return 1;
            }
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.MMAccountManager", "exception in addAccountNoNeedBindMobile() " + e.getMessage());
        }
        if (aVar != null) {
            aVar.l(null);
        }
        return 2;
    }

    public static int a(Context context, String str, a aVar) {
        if (context == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.MMAccountManager", "activity is null");
            return 0;
        } else if (bi.oW(str)) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.MMAccountManager", "account username is null or nil");
            return 0;
        } else {
            String VC = VC();
            if (!bi.oW(VC)) {
                str = VC;
            }
            try {
                AccountManager accountManager = AccountManager.get(context);
                Account account = new Account(str, "com.tencent.mm.account");
                if (!a.bj(context, "android.permission.READ_CONTACTS")) {
                    return 2;
                }
                if (J(context, str)) {
                    ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
                    return 3;
                }
                H(context, null);
                if (accountManager.addAccountExplicitly(account, "", null)) {
                    ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
                    Bundle bundle = new Bundle();
                    bundle.putString("authAccount", str);
                    bundle.putString("accountType", "com.tencent.mm.account");
                    if (aVar != null) {
                        aVar.l(bundle);
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("account_name", str);
                    contentValues.put("account_type", "com.tencent.mm.account");
                    contentValues.put("should_sync", Integer.valueOf(1));
                    contentValues.put("ungrouped_visible", Integer.valueOf(1));
                    context.getContentResolver().insert(Settings.CONTENT_URI, contentValues);
                    return 1;
                }
                if (aVar != null) {
                    aVar.l(null);
                }
                return 2;
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.MMAccountManager", "exception in addAccount() " + e.getMessage());
            }
        }
    }

    public static void bZ(Context context) {
        d.cfH();
        if (e.bxq == 0) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.MMAccountManager", "do not auto add account");
        } else if (e.bxq == 1) {
            if (l.XC() == l$a.SUCC) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.MMAccountManager", "auto add account result: " + a(context, l.XE(), null));
                return;
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.MMAccountManager", "the user not bind mobile or not aggreed to upload addressbook");
        } else if (e.bxq == 2) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.MMAccountManager", "auto add account result: " + a(context, null));
        }
    }

    public static boolean H(Context context, String str) {
        boolean oW = bi.oW(str);
        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.MMAccountManager", "remove account : " + str);
        if (context == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.MMAccountManager", "null context");
            return false;
        }
        try {
            Account[] cf = cf(context);
            if (cf == null || cf.length == 0) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.MMAccountManager", "get account info is null or nil");
                return true;
            }
            AccountManager accountManager = AccountManager.get(context);
            for (Account account : cf) {
                if (oW) {
                    accountManager.removeAccount(account, null, null);
                } else if (account.name.equals(str)) {
                    accountManager.removeAccount(account, null, null);
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.MMAccountManager", "remove account success: " + str);
                }
            }
            return true;
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.MMAccountManager", "exception in removeAccount() " + e.getMessage());
            return false;
        }
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.INTENTCHECK})
    public static boolean ca(Context context) {
        boolean z = false;
        if (context != null) {
            Intent intent = new Intent("com.tencent.mm.login.ACTION_LOGOUT");
            intent.putExtra("accountName", VC());
            intent.putExtra("accountType", "com.tencent.mm.account");
            z = H(context, VC());
            if (z) {
                context.sendBroadcast(intent);
            }
        }
        return z;
    }

    private static String VC() {
        if (g.Eg().Dx()) {
            String str = "";
            String str2 = (String) g.Ei().DT().get(4, null);
            if (bi.oW(str2)) {
                str2 = q.GG();
                if (bi.oW(str2)) {
                    str2 = q.GF();
                    if (bi.oW(str2) || ab.XT(str2)) {
                        str2 = str;
                    }
                }
            }
            return oP(str2);
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.MMAccountManager", "getCurrentAccountName MMCore.acc Not Ready");
        return "";
    }

    public static void cb(Context context) {
        if (cc(context)) {
            com.tencent.mm.sdk.f.e.b(new i(context, ce(context)), "MMAccountManager_updateAllContact").start();
            return;
        }
        H(context, null);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.MMAccountManager", "no account added or not current account");
    }

    public static void I(Context context, String str) {
        if (cc(context)) {
            com.tencent.mm.sdk.f.e.b(new i(context, ce(context), str), "MMAccountManager_deleteSpecifiedContact").start();
            return;
        }
        H(context, null);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.MMAccountManager", "no account added or not current account");
    }

    public static boolean cc(Context context) {
        Account ce = ce(context);
        if (ce != null && ce.name.equals(VC())) {
            return true;
        }
        return false;
    }

    public static boolean cd(Context context) {
        if (!cc(context)) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.MMAccountManager", "no account added or not current account");
            return false;
        } else if (!a.bj(context, "android.permission.READ_CONTACTS")) {
            return false;
        } else {
            Account ce = ce(context);
            if (ce != null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("expedited", true);
                bundle.putBoolean("do_not_retry", true);
                ContentResolver.requestSync(ce, "com.android.contacts", bundle);
                return true;
            }
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.MMAccountManager", "no account added");
            return false;
        }
    }

    public static Account ce(Context context) {
        String VC = VC();
        if (bi.oW(VC)) {
            VC = (String) g.Ei().DT().get(6, "");
        }
        if (!bi.oW(VC)) {
            Account[] cf = cf(context);
            if (cf == null) {
                return null;
            }
            for (Account account : cf) {
                if (account.name.equals(VC)) {
                    return account;
                }
            }
        }
        return null;
    }

    private static Account[] cf(Context context) {
        try {
            return AccountManager.get(context).getAccountsByType("com.tencent.mm.account");
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.MMAccountManager", "get all accounts failed");
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
            return null;
        }
    }

    private static boolean J(Context context, String str) {
        Account[] cf = cf(context);
        if (cf == null || cf.length == 0) {
            return false;
        }
        for (Account account : cf) {
            if (account.name.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private static Account[] K(Context context, String str) {
        Account[] accountArr = null;
        try {
            return AccountManager.get(context).getAccountsByType(str);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.MMAccountManager", "get all accounts failed");
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
            return accountArr;
        }
    }

    public static String cg(Context context) {
        Account[] K = K(context, "com.google");
        String str = null;
        if (K != null && K.length > 0) {
            for (Account account : K) {
                str = account.name;
                if (!bi.oW(str) && bi.WF(str)) {
                    break;
                }
            }
        }
        return str;
    }

    private static String oP(String str) {
        try {
            return Pattern.compile("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#¥￥%……&*（）——+|{}【】‘；：”“’。，、？]").matcher(str).replaceAll("_").trim();
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.MMAccountManager", "stringFilter failed, %s, %s", new Object[]{str, e.getMessage()});
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
            return str;
        }
    }
}
