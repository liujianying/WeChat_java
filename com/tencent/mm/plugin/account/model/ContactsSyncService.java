package com.tencent.mm.plugin.account.model;

import android.accounts.Account;
import android.app.Service;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SyncResult;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.sdk.platformtools.x;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class ContactsSyncService extends Service implements e {
    private static Account evK;
    private a eNR = null;
    private Looper eNS;

    private class a extends AbstractThreadedSyncAdapter {
        private Context mContext;

        public a(Context context) {
            super(context, true);
            this.mContext = context;
            x.i("MicroMsg.ContactsSyncService", "ContactsSyncService SyncAdapterImpl construction");
        }

        public final void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
            x.i("MicroMsg.ContactsSyncService", "ContactsSyncService SyncAdapterImpl onPerformSync");
            if (g.Eg().Dx()) {
                try {
                    Looper.prepare();
                    ContactsSyncService.this.eNS = Looper.myLooper();
                    ContactsSyncService.a(ContactsSyncService.this, account);
                    Looper.loop();
                    return;
                } catch (Exception e) {
                    ContactsSyncService.this.Yj();
                    x.e("MicroMsg.ContactsSyncService", "ContactsSyncService.onPerformSync error: " + e.getMessage());
                    return;
                }
            }
            x.e("MicroMsg.ContactsSyncService", "ContactsSyncService account not ready, ignore this sync");
        }
    }

    public ContactsSyncService() {
        x.i("MicroMsg.ContactsSyncService", "ContactsSyncService construction");
    }

    public IBinder onBind(Intent intent) {
        IBinder iBinder = null;
        if (com.tencent.mm.pluginsdk.permission.a.bj(this, "android.permission.READ_CONTACTS")) {
            if (this.eNR == null) {
                this.eNR = new a(getApplicationContext());
            }
            iBinder = this.eNR.getSyncAdapterBinder();
        } else {
            x.i("MicroMsg.ContactsSyncService", "ContactsSyncService onBind no permission");
        }
        x.i("MicroMsg.ContactsSyncService", "ContactsSyncService onBind ret[%s]", new Object[]{iBinder});
        return iBinder;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.ContactsSyncService", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + lVar.getType());
        if (lVar.getType() == 133) {
            g.DF().b(133, this);
            x.i("MicroMsg.ContactsSyncService", "uploadcontact onSceneEnd: errType = " + i + ", errCode = " + i2);
            long longValue = ((Long) g.Ei().DT().get(327728, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            x.d("MicroMsg.ContactsSyncService", "getMFriend : curTime=" + currentTimeMillis + ", lastTime=" + longValue);
            if (i2 == 0 || currentTimeMillis - longValue >= 86400000) {
                g.Ei().DT().set(327728, Long.valueOf(currentTimeMillis));
                g.DF().a(32, this);
                al alVar = (al) lVar;
                g.DF().a(new ab(alVar.eLj, alVar.eLk), 0);
            } else {
                Yj();
                x.e("MicroMsg.ContactsSyncService", "uploadmcontact list null, do not do getmfriend.");
                return;
            }
        }
        if (lVar.getType() == 32) {
            g.DF().b(32, this);
            x.i("MicroMsg.ContactsSyncService", "getmfriend onSceneEnd: errType = " + i + ", errCode = " + i2);
            if (i == 0 && i2 == 0) {
                com.tencent.mm.sdk.f.e.b(new i(this, evK), "MMAccountManager_updateLocalContacts").start();
            }
            Yj();
        }
    }

    private void Yj() {
        if (this.eNS != null) {
            this.eNS.quit();
        }
    }

    public void onDestroy() {
        x.i("MicroMsg.ContactsSyncService", "contacts sync service destroy");
        super.onDestroy();
    }
}
