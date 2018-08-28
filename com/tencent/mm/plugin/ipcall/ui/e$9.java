package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.l;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;

class e$9 implements d {
    final /* synthetic */ e kuf;
    final /* synthetic */ k kug;
    final /* synthetic */ int kuh;

    e$9(e eVar, k kVar, int i) {
        this.kuf = eVar;
        this.kug = kVar;
        this.kuh = i;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (i == 0) {
            e eVar = this.kuf;
            k kVar = this.kug;
            int i2 = this.kuh;
            l aXw;
            if (kVar.field_addressId > 0) {
                aXw = i.aXw();
                if (kVar.field_addressId > 0 && aXw.diF.delete("IPCallRecord", "addressId=?", new String[]{String.valueOf(kVar.field_addressId)}) < 0) {
                    x.d("MicroMsg.IPCallRecordStorage", "deleteByAddressId failed, ret: %d, addressId: %d", new Object[]{Integer.valueOf(aXw.diF.delete("IPCallRecord", "addressId=?", new String[]{String.valueOf(kVar.field_addressId)})), Long.valueOf(r4)});
                }
            } else {
                aXw = i.aXw();
                if (!bi.oW(kVar.field_phonenumber) && aXw.diF.delete("IPCallRecord", "phonenumber=?", new String[]{kVar.field_phonenumber}) < 0) {
                    x.d("MicroMsg.IPCallRecordStorage", "deleteByCallPhoneNumber failed, ret: %d, phoneNumber: %s", new Object[]{Integer.valueOf(aXw.diF.delete("IPCallRecord", "phonenumber=?", new String[]{kVar.field_phonenumber})), r1});
                }
            }
            h hVar = eVar.ktW;
            hVar.kxg.remove(i2);
            hVar.notifyDataSetChanged();
            if (eVar.ktW.getCount() > 0) {
                eVar.ktX.setVisibility(8);
            } else {
                eVar.ktX.setVisibility(0);
            }
        }
    }
}
