package com.tencent.mm.platformtools;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public class i$a {
    private final String TAG = "MicroMsg.BatchOperation";
    private final ContentResolver evN;
    ArrayList<ContentProviderOperation> evO;
    final /* synthetic */ i evP;

    public i$a(i iVar, ContentResolver contentResolver) {
        this.evP = iVar;
        this.evN = contentResolver;
        this.evO = new ArrayList();
    }

    public final void a(ContentProviderOperation contentProviderOperation) {
        this.evO.add(contentProviderOperation);
    }

    public final void execute() {
        if (this.evO.size() == 0) {
            x.d("MicroMsg.BatchOperation", "no batch operation");
        } else if (a.bj(i.a(this.evP), "android.permission.READ_CONTACTS")) {
            try {
                this.evN.applyBatch("com.android.contacts", this.evO);
            } catch (OperationApplicationException e) {
                x.e("MicroMsg.BatchOperation", "apply batch operation failed", new Object[]{e.toString()});
            } catch (RemoteException e2) {
                x.e("MicroMsg.BatchOperation", "apply batch operation failed", new Object[]{e2.toString()});
            } catch (Exception e3) {
                x.e("MicroMsg.BatchOperation", "apply batch operation failed", new Object[]{e3.toString()});
            }
            this.evO.clear();
        } else {
            x.e("MicroMsg.BatchOperation", "no contact permission");
        }
    }
}
