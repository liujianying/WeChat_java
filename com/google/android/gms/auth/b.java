package com.google.android.gms.auth;

import android.accounts.Account;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.c.c$a;
import com.google.android.gms.c.i;
import com.google.android.gms.common.c;
import com.google.android.gms.common.d;
import com.google.android.gms.common.e;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.w;
import java.io.IOException;

public final class b {
    public static final String KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
    public static final String KEY_CALLER_UID = "callerUid";
    private static final ComponentName aIA = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
    private static final ComponentName aIB = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");

    static {
        int i = VERSION.SDK_INT;
        i = VERSION.SDK_INT;
    }

    private static Bundle a(Context context, Account account, String str, Bundle bundle) {
        Context applicationContext = context.getApplicationContext();
        w.bi("Calling this from your main thread can lead to deadlock");
        try {
            e.ag(applicationContext);
            Bundle bundle2 = new Bundle(bundle);
            String str2 = context.getApplicationInfo().packageName;
            bundle2.putString("clientPackageName", str2);
            if (TextUtils.isEmpty(bundle2.getString(KEY_ANDROID_PACKAGE_NAME))) {
                bundle2.putString(KEY_ANDROID_PACKAGE_NAME, str2);
            }
            ServiceConnection hVar = new h();
            m aj = m.aj(applicationContext);
            if (aj.a(aIA, hVar, "GoogleAuthUtil")) {
                try {
                    Bundle a = c$a.m(hVar.pI()).a(account, str, bundle2);
                    if (a == null) {
                        throw new a("ServiceUnavailable");
                    } else if (TextUtils.isEmpty(a.getString("authtoken"))) {
                        String string = a.getString("Error");
                        Intent intent = (Intent) a.getParcelable("userRecoveryIntent");
                        Object obj = ("BadAuthentication".equals(string) || "CaptchaRequired".equals(string) || "DeviceManagementRequiredOrSyncDisabled".equals(string) || "NeedPermission".equals(string) || "NeedsBrowser".equals(string) || "UserCancel".equals(string) || "AppDownloadRequired".equals(string) || i.DM_SYNC_DISABLED.aXq.equals(string) || i.DM_ADMIN_BLOCKED.aXq.equals(string) || i.DM_ADMIN_PENDING_APPROVAL.aXq.equals(string) || i.DM_STALE_SYNC_REQUIRED.aXq.equals(string) || i.DM_DEACTIVATED.aXq.equals(string) || i.DM_REQUIRED.aXq.equals(string) || i.THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED.aXq.equals(string)) ? 1 : null;
                        if (obj != null) {
                            throw new d(string, intent);
                        }
                        Object obj2 = ("NetworkError".equals(string) || "ServiceUnavailable".equals(string) || "Timeout".equals(string)) ? 1 : null;
                        if (obj2 != null) {
                            throw new IOException(string);
                        }
                        throw new a(string);
                    } else {
                        aj.a(aIA, hVar);
                        return a;
                    }
                } catch (RemoteException e) {
                    throw new IOException("remote exception");
                } catch (InterruptedException e2) {
                    throw new a("Interrupted");
                } catch (Throwable th) {
                    aj.a(aIA, hVar);
                }
            } else {
                throw new IOException("Could not bind to service with the given context.");
            }
        } catch (d e3) {
            throw new c(e3.aIC, e3.getMessage(), new Intent(e3.Hq));
        } catch (c e4) {
            throw new a(e4.getMessage());
        }
    }

    @Deprecated
    public static String e(Context context, String str, String str2) {
        return a(context, new Account(str, "com.google"), str2, new Bundle()).getString("authtoken");
    }
}
