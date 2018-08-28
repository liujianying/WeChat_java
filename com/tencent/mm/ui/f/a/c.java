package com.tencent.mm.ui.f.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.b;

public final class c {
    protected static String utl = "https://m.facebook.com/dialog/";
    protected static String utm = "https://graph.facebook.com/";
    protected static String utn = "https://api.facebook.com/restserver.php";
    public String eFo = null;
    private String mAppId;
    private long uto = 0;
    public long utp = 0;
    private Activity utq;
    private String[] utr;
    private int uts;
    private a utt;
    private final long utu = 86400000;

    public c(String str) {
        this.mAppId = str;
    }

    public final void a(Activity activity, String[] strArr, a aVar) {
        this.utt = aVar;
        a(activity, strArr);
        h.mEJ.a(582, 0, 1, false);
    }

    private void a(Activity activity, String[] strArr) {
        Bundle bundle = new Bundle();
        if (strArr.length > 0) {
            bundle.putString("scope", TextUtils.join(",", strArr));
        }
        com.tencent.xweb.c.ij(activity);
        a(activity, "oauth", bundle, new a() {
            public final void m(Bundle bundle) {
                com.tencent.xweb.c.cIk();
                com.tencent.xweb.c.sync();
                c.this.aaT(bundle.getString("access_token"));
                c.this.aaU(bundle.getString("expires_in"));
                if (c.this.czh()) {
                    x.d("Facebook-authorize", "Login Success! access_token=" + c.this.eFo + " expires=" + c.this.utp);
                    c.this.utt.m(bundle);
                    return;
                }
                c.this.utt.a(new d("Failed to receive access token."));
            }

            public final void a(b bVar) {
                x.d("Facebook-authorize", "Login failed: " + bVar);
                c.this.utt.a(bVar);
            }

            public final void a(d dVar) {
                x.d("Facebook-authorize", "Login failed: " + dVar);
                c.this.utt.a(dVar);
            }

            public final void onCancel() {
                x.d("Facebook-authorize", "Login canceled");
                c.this.utt.onCancel();
            }
        });
    }

    public final void g(int i, int i2, Intent intent) {
        if (i != this.uts) {
            return;
        }
        if (i2 == -1) {
            String stringExtra = intent.getStringExtra("error");
            if (stringExtra == null) {
                stringExtra = intent.getStringExtra("error_type");
            }
            if (stringExtra == null) {
                aaT(intent.getStringExtra("access_token"));
                aaU(intent.getStringExtra("expires_in"));
                if (czh()) {
                    x.d("Facebook-authorize", "Login Success! access_token=" + this.eFo + " expires=" + this.utp);
                    this.utt.m(intent.getExtras());
                    return;
                }
                this.utt.a(new d("Failed to receive access token."));
            } else if (stringExtra.equals("service_disabled") || stringExtra.equals("AndroidAuthKillSwitchException")) {
                x.d("Facebook-authorize", "Hosted auth currently disabled. Retrying dialog auth...");
                a(this.utq, this.utr);
            } else if (stringExtra.equals("access_denied") || stringExtra.equals("OAuthAccessDeniedException")) {
                x.d("Facebook-authorize", "Login canceled by user.");
                this.utt.onCancel();
            } else {
                String stringExtra2 = intent.getStringExtra("error_description");
                if (stringExtra2 != null) {
                    stringExtra = stringExtra + ":" + stringExtra2;
                }
                x.d("Facebook-authorize", "Login failed: " + stringExtra);
                this.utt.a(new d(stringExtra));
            }
        } else if (i2 != 0) {
        } else {
            if (intent != null) {
                x.d("Facebook-authorize", "Login failed: " + intent.getStringExtra("error"));
                this.utt.a(new b(intent.getStringExtra("error"), intent.getIntExtra("error_code", -1), intent.getStringExtra("failing_url")));
                return;
            }
            x.d("Facebook-authorize", "Login canceled by user.");
            this.utt.onCancel();
        }
    }

    public final String gY(Context context) {
        com.tencent.xweb.c.ij(context);
        b.cIi().removeAllCookie();
        aaT(null);
        this.utp = 0;
        return null;
    }

    public final String a(String str, Bundle bundle, String str2) {
        bundle.putString("format", "json");
        if (czh()) {
            bundle.putString("access_token", this.eFo);
        }
        return e.e(str != null ? utm + str : utn, str2, bundle);
    }

    public final void a(Context context, String str, Bundle bundle, a aVar) {
        String str2 = utl + str;
        bundle.putString("display", "touch");
        bundle.putString("redirect_uri", "fbconnect://success");
        if (str.equals("oauth")) {
            bundle.putString("type", "user_agent");
            bundle.putString("client_id", this.mAppId);
        } else {
            bundle.putString("app_id", this.mAppId);
        }
        if (czh()) {
            bundle.putString("access_token", this.eFo);
        }
        str2 = str2 + "?" + e.ai(bundle);
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            e.E(context, "Error", "Application requires permission to access the Internet");
        } else {
            new f(context, str2, aVar).show();
        }
    }

    public final boolean czh() {
        return this.eFo != null && (this.utp == 0 || System.currentTimeMillis() < this.utp);
    }

    public final void aaT(String str) {
        this.eFo = str;
        this.uto = System.currentTimeMillis();
    }

    public final void aaU(String str) {
        if (str != null) {
            long j;
            if (str.equals("0")) {
                j = 0;
            } else {
                j = System.currentTimeMillis() + (bi.WV(str) * 1000);
            }
            this.utp = j;
        }
    }
}
