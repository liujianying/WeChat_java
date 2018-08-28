package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.common.e;

public final class a extends p$a {
    private Account aIy;
    int aNo;
    private Context mContext;

    public static Account b(p pVar) {
        Account account = null;
        if (pVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = pVar.pc();
            } catch (RemoteException e) {
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return account;
    }

    public final boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof a) ? false : this.aIy.equals(((a) obj).aIy);
    }

    public final Account pc() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.aNo) {
            return this.aIy;
        }
        if (e.q(this.mContext, callingUid)) {
            this.aNo = callingUid;
            return this.aIy;
        }
        throw new SecurityException("Caller is not GooglePlayServices");
    }
}
