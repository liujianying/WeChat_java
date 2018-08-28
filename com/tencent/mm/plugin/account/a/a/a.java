package com.tencent.mm.plugin.account.a.a;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.m;
import java.util.LinkedList;

public interface a extends d {
    void clearFriendData();

    m getAddrUploadStg();

    j getFacebookFrdStg();

    j getFrdExtStg();

    LinkedList getFriendData();

    j getGoogleFriendStorage();

    j getInviteFriendOpenStg();

    String getPhoneNum(Context context, String str);

    j getQQGroupStg();

    m getQQListStg();

    void removeSelfAccount(Context context);

    void setFriendData(LinkedList linkedList);

    void showAddrBookUploadConfirm(Activity activity, Runnable runnable, boolean z, int i);

    boolean syncAddrBook(b bVar);

    void syncAddrBookAndUpload();

    void syncUploadMContactStatus(boolean z, boolean z2);

    void updateAllContact();
}
