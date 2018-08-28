package com.tencent.mm.wallet_core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class c {
    public Bundle jfZ = new Bundle();
    protected a uWT;

    public abstract void a(Activity activity, int i, Bundle bundle);

    public abstract String aNK();

    public abstract void b(Activity activity, Bundle bundle);

    public abstract void c(Activity activity, int i);

    public abstract boolean c(Activity activity, Bundle bundle);

    public final c am(Bundle bundle) {
        this.jfZ.putAll(bundle);
        return this;
    }

    private static String cA(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof Bundle) {
            return String.format("Bundle: %s, ", new Object[]{obj.toString()});
        } else if (obj instanceof Context) {
            return String.format("Context: %s, ", new Object[]{obj.toString()});
        } else if (obj instanceof Class) {
            return String.format("Class: %s, ", new Object[]{((Class) obj).getSimpleName()});
        } else {
            return String.format("Value: %s, ", new Object[]{obj.toString()});
        }
    }

    public final void y(Object... objArr) {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("this %s, procname %s", new Object[]{this, aNK()}));
        if (objArr.length <= 0) {
            x.w("MicroMsg.ProcessManager", "vals is null, use '' as value");
            stringBuilder = stringBuilder2.toString();
        } else {
            int length = objArr.length - 1;
            for (int i = 0; i < length; i++) {
                stringBuilder2.append(cA(objArr[i])).append(',');
            }
            stringBuilder2.append(cA(objArr[length]));
            stringBuilder = stringBuilder2.toString();
        }
        x.i("MicroMsg.ProcessManager", "__CURRENT__ %s", new Object[]{stringBuilder});
    }

    public final void b(Activity activity, Class<?> cls, Bundle bundle) {
        y("startActivity1", activity, cls, null);
        Intent intent = new Intent(activity, cls);
        intent.putExtra("process_id", getClass().hashCode());
        if (bundle != null) {
            intent.putExtras(bundle);
            x.d("MicroMsg.ProcessManager", "put bundle: %s", new Object[]{intent.getExtras().toString()});
        }
        activity.startActivity(intent);
        x.d("MicroMsg.ProcessManager", "bankcard tag :" + cCR());
    }

    public final void c(Activity activity, Class<?> cls, Bundle bundle) {
        y("startActivity1", activity, cls, bundle);
        Intent intent = new Intent(activity, cls);
        intent.putExtra("process_id", getClass().hashCode());
        activity.startActivity(intent);
        if (bundle != null) {
            this.jfZ.putAll(bundle);
        }
        x.d("MicroMsg.ProcessManager", "bankcard tag :" + cCR());
    }

    public final void a(Activity activity, String str, String str2, Bundle bundle) {
        y("startActivity3", activity, str, str2, bundle);
        Class fI = d.fI(str, str2);
        if (fI != null) {
            c(activity, fI, bundle);
        } else {
            x.e("MicroMsg.ProcessManager", " Class Not Found! can't startActivity to " + str + str2);
        }
    }

    public final void a(Activity activity, Class<?> cls, Bundle bundle, int i) {
        y("startActivityForResult1", activity, cls, bundle, Integer.valueOf(i));
        Intent intent = new Intent(activity, cls);
        intent.putExtra("process_id", getClass().hashCode());
        intent.addFlags(67108864);
        activity.startActivityForResult(intent, i);
        if (bundle != null) {
            this.jfZ.putAll(bundle);
        }
    }

    public void z(Activity activity) {
        y("finishActivity", activity);
        if (!activity.isFinishing() && (activity instanceof MMActivity)) {
            ((MMActivity) activity).finish();
        }
    }

    public final void a(Activity activity, Class<?> cls, int i) {
        y("finishActivity", activity, cls, "errCode " + i);
        Intent intent = new Intent(activity, cls);
        intent.putExtra("process_id", getClass().hashCode());
        intent.addFlags(67108864);
        activity.startActivity(intent);
        this.jfZ.putInt("key_err_code", i);
    }

    public c a(Activity activity, Bundle bundle) {
        return this;
    }

    public final void a(a aVar) {
        this.uWT = aVar;
    }

    public final void ag(Activity activity) {
        y("endProcess1", activity);
        if (!activity.isFinishing() && (activity instanceof MMActivity)) {
            ((MMActivity) activity).finish();
        }
        if (this.jfZ != null) {
            this.jfZ.clear();
        }
        a.remove(getClass().hashCode());
    }

    public final void l(Activity activity, Bundle bundle) {
        y("endProcess1", activity);
        if (!activity.isFinishing() && (activity instanceof MMActivity)) {
            ((MMActivity) activity).finish();
        }
        if (this.uWT != null) {
            this.uWT.n(0, bundle);
        }
        bundle.clear();
        a.remove(getClass().hashCode());
    }

    public final void a(Activity activity, Class<?> cls, int i, Intent intent, boolean z) {
        Intent n;
        y("endProcess2", activity, cls, Integer.valueOf(i), intent, Boolean.valueOf(z));
        if (this.uWT != null) {
            n = this.uWT.n(i, this.jfZ);
        } else {
            n = intent;
        }
        if (n == null) {
            n = new Intent(activity, cls);
            n.putExtra("key_process_is_stay", z);
        } else if (!(n.getExtras() == null || n.getExtras().containsKey("key_process_is_stay"))) {
            n.putExtra("key_process_is_stay", true);
        }
        n.addFlags(67108864);
        n.putExtra("key_process_is_end", true);
        activity.startActivity(n);
        if (this.jfZ != null) {
            this.jfZ.clear();
        }
        a.remove(getClass().hashCode());
    }

    public final void a(Activity activity, String str, String str2, int i, boolean z) {
        a(activity, str, str2, i, null, z);
    }

    public final void a(Activity activity, String str, String str2, int i, Intent intent, boolean z) {
        Intent n;
        y("endProcess3", activity, str, str2, Integer.valueOf(i), intent, Boolean.valueOf(z));
        if (this.uWT != null) {
            n = this.uWT.n(i, this.jfZ);
        } else {
            n = intent;
        }
        if (n == null) {
            n = new Intent();
            n.putExtra("key_process_is_stay", z);
        } else if (!(n.getExtras() == null || n.getExtras().containsKey("key_process_is_stay"))) {
            n.putExtra("key_process_is_stay", true);
        }
        n.addFlags(67108864);
        n.putExtra("key_process_is_end", true);
        d.b(activity, str, str2, n);
        if (this.jfZ != null) {
            this.jfZ.clear();
        }
        a.remove(getClass().hashCode());
    }

    public final void a(Activity activity, Class<?> cls, Intent intent) {
        a(activity, (Class) cls, -1, intent, true);
    }

    public final void a(Activity activity, Class<?> cls, int i, boolean z) {
        a(activity, (Class) cls, i, null, z);
    }

    public final void c(Activity activity, Class<?> cls) {
        a(activity, (Class) cls, -1, null, true);
    }

    public final void e(Activity activity, String str, String str2) {
        a(activity, str, str2, -1, true);
    }

    public final int cCR() {
        return this.jfZ.getInt("key_support_bankcard", 1);
    }

    public final boolean bQH() {
        return this.jfZ.getBoolean("key_is_oversea", false);
    }

    public final boolean cCS() {
        return this.jfZ.getInt("key_pay_flag", 0) == 2;
    }

    public final boolean cCT() {
        return this.jfZ.getInt("key_pay_flag", 0) == 1;
    }

    public final boolean cCU() {
        return this.jfZ.getInt("key_pay_flag", 0) == 3;
    }

    public g a(MMActivity mMActivity, i iVar) {
        return null;
    }

    public boolean h(Activity activity, Bundle bundle) {
        return false;
    }

    public final boolean cCV() {
        String string = this.jfZ.getString("key_bank_username");
        x.i("MicroMsg.ProcessManager", "follow bank account : isFollow " + this.jfZ.getBoolean("key_is_follow_bank_username", false) + ", username : " + string);
        if (!this.jfZ.getBoolean("key_is_follow_bank_username", false) || bi.oW(string)) {
            return false;
        }
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(new j(string), 0);
        return true;
    }

    public int a(MMActivity mMActivity, int i) {
        return -1;
    }

    public boolean a(WalletBaseUI walletBaseUI, int i, String str) {
        return false;
    }
}
