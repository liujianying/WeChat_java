package com.tencent.mm.plugin.account;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.bg.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.p;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.an;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.account.friend.a.k;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.plugin.account.model.i;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public class PluginAccount extends f implements a {
    public void execute(g gVar) {
        c.Um("account");
        pin(new p(i.class));
        pin(new p(b.class));
        pin(new p(com.tencent.mm.plugin.account.security.a.g.class));
        x.i("MicroMsg.PluginAccount", "execute PluginAccount");
    }

    public b getAddrUploadStg() {
        return b.getAddrUploadStg();
    }

    public h getFacebookFrdStg() {
        return b.getFacebookFrdStg();
    }

    public k getFrdExtStg() {
        return b.getFrdExtStg();
    }

    public an getQQGroupStg() {
        return b.getQQGroupStg();
    }

    public q getInviteFriendOpenStg() {
        return b.getInviteFriendOpenStg();
    }

    public ap getQQListStg() {
        return b.getQQListStg();
    }

    public o getGoogleFriendStorage() {
        return b.getGoogleFriendStorage();
    }

    public void setFriendData(LinkedList linkedList) {
        b.setFriendData(linkedList);
    }

    public LinkedList<arf> getFriendData() {
        return b.getFriendData();
    }

    public void clearFriendData() {
        b.clearFriendData();
    }

    public void syncAddrBookAndUpload() {
        com.tencent.mm.platformtools.b.Vn();
    }

    public void showAddrBookUploadConfirm(Activity activity, Runnable runnable, boolean z, int i) {
        aa.showAddrBookUploadConfirm(activity, runnable, z, i);
    }

    public void removeSelfAccount(Context context) {
        com.tencent.mm.platformtools.x.ca(context);
    }

    public String getPhoneNum(Context context, String str) {
        return j.getPhoneNum(context, str);
    }

    public void syncUploadMContactStatus(boolean z, boolean z2) {
        aa.syncUploadMContactStatus(z, z2);
    }

    public boolean syncAddrBook(com.tencent.mm.plugin.account.a.a.b bVar) {
        return com.tencent.mm.platformtools.b.syncAddrBook(bVar);
    }

    public void updateAllContact() {
        com.tencent.mm.platformtools.x.cb(ad.getContext());
    }
}
