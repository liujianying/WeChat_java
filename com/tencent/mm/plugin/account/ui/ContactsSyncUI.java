package com.tencent.mm.plugin.account.ui;

import android.accounts.AccountAuthenticatorResponse;
import android.os.Bundle;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public final class ContactsSyncUI extends MMActivity {
    private AccountAuthenticatorResponse ePE = null;
    Bundle ePF = null;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle("");
        int a = s.a(getIntent(), "wizard_activity_result_code", 0);
        x.i("MicroMsg.ContactsSyncUI", "onCreate() resultCode[%d]", new Object[]{Integer.valueOf(a)});
        switch (a) {
            case -1:
            case 0:
                x.i("MicroMsg.ContactsSyncUI", "summerper checkPermission checkContacts read[%b],stack[%s]", new Object[]{Boolean.valueOf(a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bi.cjd()});
                if (a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
                    x.i("MicroMsg.ContactsSyncUI", "summerper checkPermission checkContacts write[%b],stack[%s]", new Object[]{Boolean.valueOf(a.a(this, "android.permission.WRITE_CONTACTS", 48, null, null)), bi.cjd()});
                    if (a.a(this, "android.permission.WRITE_CONTACTS", 48, null, null)) {
                        initView();
                        return;
                    }
                    return;
                }
                return;
            case 1:
                finish();
                return;
            default:
                x.e("MicroMsg.ContactsSyncUI", "onCreate, should not reach here, resultCode = " + a);
                finish();
                return;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void initView() {
        /*
        r10 = this;
        r3 = 0;
        r4 = 2;
        r5 = -1;
        r1 = 1;
        r2 = 0;
        com.tencent.mm.kernel.g.Eg();
        r0 = com.tencent.mm.kernel.a.Dw();
        if (r0 == 0) goto L_0x0014;
    L_0x000e:
        r0 = com.tencent.mm.kernel.a.Dr();
        if (r0 == 0) goto L_0x0026;
    L_0x0014:
        r0 = new android.content.Intent;
        r1 = com.tencent.mm.plugin.account.ui.SimpleLoginUI.class;
        r0.<init>(r10, r1);
        r1 = r10.getIntent();
        com.tencent.mm.ui.MMWizardActivity.b(r10, r0, r1);
        r10.finish();
    L_0x0025:
        return;
    L_0x0026:
        r0 = r10.getIntent();
        if (r0 != 0) goto L_0x0039;
    L_0x002c:
        r0 = "MicroMsg.ContactsSyncUI";
        r1 = "initView fail, intent is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r10.finish();
        goto L_0x0025;
    L_0x0039:
        r0 = r10.getIntent();
        r6 = "contact_sync_scene";
        r0 = com.tencent.mm.sdk.platformtools.s.a(r0, r6, r5);
        r6 = r10.getIntent();
        r6 = r6.getAction();
        if (r6 == 0) goto L_0x006f;
    L_0x004e:
        r6 = r10.getIntent();
        r6 = r6.getAction();
        r7 = "com.tencent.mm.login.ACTION_LOGIN";
        r6 = r6.equalsIgnoreCase(r7);
        if (r6 == 0) goto L_0x006f;
    L_0x005f:
        r0 = 4;
    L_0x0060:
        if (r0 != r5) goto L_0x00e1;
    L_0x0062:
        r0 = "MicroMsg.ContactsSyncUI";
        r1 = "unkown scene, finish";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r10.finish();
        goto L_0x0025;
    L_0x006f:
        r6 = r10.getIntent();
        r6 = r6.resolveType(r10);
        r7 = "MicroMsg.ContactsSyncUI";
        r8 = new java.lang.StringBuilder;
        r9 = "scheme = ";
        r8.<init>(r9);
        r8 = r8.append(r6);
        r9 = ", action = ";
        r8 = r8.append(r9);
        r9 = r10.getIntent();
        r9 = r9.getAction();
        r8 = r8.append(r9);
        r8 = r8.toString();
        com.tencent.mm.sdk.platformtools.x.i(r7, r8);
        r7 = com.tencent.mm.sdk.platformtools.bi.oW(r6);
        if (r7 != 0) goto L_0x0060;
    L_0x00a6:
        r0 = "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile";
        r0 = r6.equals(r0);
        if (r0 == 0) goto L_0x00b1;
    L_0x00af:
        r0 = r4;
        goto L_0x0060;
    L_0x00b1:
        r0 = "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip";
        r0 = r6.equals(r0);
        if (r0 == 0) goto L_0x00bd;
    L_0x00ba:
        r0 = 12;
        goto L_0x0060;
    L_0x00bd:
        r0 = "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video";
        r0 = r6.equals(r0);
        if (r0 == 0) goto L_0x00c9;
    L_0x00c6:
        r0 = 13;
        goto L_0x0060;
    L_0x00c9:
        r0 = "vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline";
        r0 = r6.equals(r0);
        if (r0 == 0) goto L_0x00d4;
    L_0x00d2:
        r0 = 3;
        goto L_0x0060;
    L_0x00d4:
        r0 = "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.phonenum";
        r0 = r6.equals(r0);
        if (r0 == 0) goto L_0x00df;
    L_0x00dd:
        r0 = 6;
        goto L_0x0060;
    L_0x00df:
        r0 = r5;
        goto L_0x0060;
    L_0x00e1:
        switch(r0) {
            case 1: goto L_0x01a2;
            case 2: goto L_0x00f3;
            case 3: goto L_0x0140;
            case 4: goto L_0x0159;
            case 5: goto L_0x00e4;
            case 6: goto L_0x00f3;
            case 7: goto L_0x00e4;
            case 8: goto L_0x00e4;
            case 9: goto L_0x00e4;
            case 10: goto L_0x00e4;
            case 11: goto L_0x00e4;
            case 12: goto L_0x010c;
            case 13: goto L_0x0126;
            default: goto L_0x00e4;
        };
    L_0x00e4:
        r0 = r3;
    L_0x00e5:
        if (r0 == 0) goto L_0x023c;
    L_0x00e7:
        r0 = r0.cm(r10);
        switch(r0) {
            case 0: goto L_0x00ee;
            case 1: goto L_0x00ee;
            case 2: goto L_0x01d7;
            case 3: goto L_0x01fe;
            case 4: goto L_0x0219;
            case 5: goto L_0x0025;
            default: goto L_0x00ee;
        };
    L_0x00ee:
        r10.finish();
        goto L_0x0025;
    L_0x00f3:
        r0 = r10.getIntent();
        r2 = r0.getData();
        r0 = r10.getIntent();
        r3 = "k_phone_num";
        r3 = com.tencent.mm.sdk.platformtools.s.j(r0, r3);
        r0 = new com.tencent.mm.plugin.account.model.b$b;
        r0.<init>(r1, r3, r2);
        goto L_0x00e5;
    L_0x010c:
        r0 = r10.getIntent();
        r2 = r0.getData();
        r0 = r10.getIntent();
        r3 = "k_phone_num";
        r3 = com.tencent.mm.sdk.platformtools.s.j(r0, r3);
        r0 = new com.tencent.mm.plugin.account.model.b$b;
        r5 = 3;
        r0.<init>(r5, r3, r2);
        goto L_0x00e5;
    L_0x0126:
        r0 = r10.getIntent();
        r2 = r0.getData();
        r0 = r10.getIntent();
        r3 = "k_phone_num";
        r3 = com.tencent.mm.sdk.platformtools.s.j(r0, r3);
        r0 = new com.tencent.mm.plugin.account.model.b$b;
        r5 = 4;
        r0.<init>(r5, r3, r2);
        goto L_0x00e5;
    L_0x0140:
        r0 = r10.getIntent();
        r2 = r0.getData();
        r0 = r10.getIntent();
        r3 = "k_phone_num";
        r3 = com.tencent.mm.sdk.platformtools.s.j(r0, r3);
        r0 = new com.tencent.mm.plugin.account.model.b$b;
        r0.<init>(r4, r3, r2);
        goto L_0x00e5;
    L_0x0159:
        r0 = r10.getIntent();
        r5 = "accountAuthenticatorResponse";
        r0 = r0.getParcelableExtra(r5);
        r10.ePE = r3;
        if (r0 == 0) goto L_0x0170;
    L_0x0168:
        r5 = r0 instanceof android.accounts.AccountAuthenticatorResponse;
        if (r5 == 0) goto L_0x0170;
    L_0x016c:
        r0 = (android.accounts.AccountAuthenticatorResponse) r0;
        r10.ePE = r0;
    L_0x0170:
        r0 = r10.ePE;
        if (r0 == 0) goto L_0x0179;
    L_0x0174:
        r0 = r10.ePE;
        r0.onRequestContinued();
    L_0x0179:
        r0 = com.tencent.mm.sdk.platformtools.ad.chY();
        r0 = r10.getSharedPreferences(r0, r2);
        r5 = "upload_contacts_already_displayed";
        r0 = r0.getBoolean(r5, r2);
        if (r0 != 0) goto L_0x00e4;
    L_0x018a:
        r3 = new com.tencent.mm.plugin.account.ui.ContactsSyncUI$a;
        r0 = r10.getIntent();
        r5 = "k_login_without_bind_mobile";
        r0 = com.tencent.mm.sdk.platformtools.s.a(r0, r5, r2);
        if (r0 != 0) goto L_0x01a0;
    L_0x0199:
        r0 = r1;
    L_0x019a:
        r3.<init>(r10, r0);
        r0 = r3;
        goto L_0x00e5;
    L_0x01a0:
        r0 = r2;
        goto L_0x019a;
    L_0x01a2:
        r0 = r10.getIntent();
        r5 = "accountAuthenticatorResponse";
        r0 = r0.getParcelableExtra(r5);
        r10.ePE = r3;
        if (r0 == 0) goto L_0x01b9;
    L_0x01b1:
        r3 = r0 instanceof android.accounts.AccountAuthenticatorResponse;
        if (r3 == 0) goto L_0x01b9;
    L_0x01b5:
        r0 = (android.accounts.AccountAuthenticatorResponse) r0;
        r10.ePE = r0;
    L_0x01b9:
        r0 = r10.ePE;
        if (r0 == 0) goto L_0x01c2;
    L_0x01bd:
        r0 = r10.ePE;
        r0.onRequestContinued();
    L_0x01c2:
        r0 = new com.tencent.mm.plugin.account.ui.ContactsSyncUI$a;
        r3 = r10.getIntent();
        r5 = "k_login_without_bind_mobile";
        r3 = com.tencent.mm.sdk.platformtools.s.a(r3, r5, r2);
        if (r3 != 0) goto L_0x01d2;
    L_0x01d1:
        r2 = r1;
    L_0x01d2:
        r0.<init>(r10, r2);
        goto L_0x00e5;
    L_0x01d7:
        r0 = r10.getIntent();
        r2 = com.tencent.mm.plugin.account.ui.ContactsSyncUI.class;
        r0.setClass(r10, r2);
        r2 = new android.content.Intent;
        r2.<init>();
        r3 = com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.class;
        r2.setClass(r10, r3);
        r3 = "key_upload_scene";
        r2.putExtra(r3, r4);
        r3 = "is_bind_for_contact_sync";
        r2.putExtra(r3, r1);
        com.tencent.mm.ui.MMWizardActivity.b(r10, r2, r0);
        r10.finish();
        goto L_0x00ee;
    L_0x01fe:
        r0 = r10.getIntent();
        r1 = com.tencent.mm.plugin.account.ui.ContactsSyncUI.class;
        r0.setClass(r10, r1);
        r1 = new android.content.Intent;
        r1.<init>();
        r2 = com.tencent.mm.plugin.account.ui.SimpleLoginUI.class;
        r1.setClass(r10, r2);
        com.tencent.mm.ui.MMWizardActivity.b(r10, r1, r0);
        r10.finish();
        goto L_0x00ee;
    L_0x0219:
        r0 = r10.getIntent();
        r1 = com.tencent.mm.plugin.account.ui.ContactsSyncUI.class;
        r0.setClass(r10, r1);
        r1 = new android.content.Intent;
        r1.<init>();
        r2 = com.tencent.mm.plugin.account.ui.SimpleLoginUI.class;
        r1.setClass(r10, r2);
        r2 = "accountAuthenticatorResponse";
        r3 = r10.ePE;
        r1.putExtra(r2, r3);
        com.tencent.mm.ui.MMWizardActivity.b(r10, r1, r0);
        r10.finish();
        goto L_0x00ee;
    L_0x023c:
        r0 = "MicroMsg.ContactsSyncUI";
        r1 = "unkown scene, finish";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x00ee;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.account.ui.ContactsSyncUI.initView():void");
    }

    public final void finish() {
        if (this.ePE != null) {
            if (this.ePF != null) {
                this.ePE.onResult(this.ePF);
            } else {
                this.ePE.onError(4, "canceled");
            }
            this.ePE = null;
        }
        super.finish();
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.ContactsSyncUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bi.cjd();
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.ContactsSyncUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case f$k.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (iArr[0] == 0) {
                    new ag().post(new 1(this, strArr[0]));
                    return;
                } else {
                    h.a(this, getString(j.permission_contacts_request_again_msg), getString(j.permission_tips_title), getString(j.jump_to_settings), getString(j.app_cancel), false, new 2(this), new 3(this));
                    return;
                }
            default:
                return;
        }
    }
}
