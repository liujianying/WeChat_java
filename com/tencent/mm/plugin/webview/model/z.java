package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.protocal.c.awp;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public final class z {
    private static String[] pRu;
    private static boolean pRv = false;

    private static ArrayList<byte[]> am(LinkedList<awp> linkedList) {
        ArrayList<byte[]> arrayList = new ArrayList();
        if (linkedList == null || linkedList.isEmpty()) {
            return arrayList;
        }
        int i = 0;
        while (i < linkedList.size()) {
            try {
                arrayList.add(((awp) linkedList.get(i)).toByteArray());
                i++;
            } catch (IOException e) {
                x.w("MicroMsg.OauthAuthorizeLogic", "oauthScopeInfoListToBytesList index:%d, exp:%s ", new Object[]{Integer.valueOf(i), e.getLocalizedMessage()});
                arrayList.clear();
                return arrayList;
            }
        }
        return arrayList;
    }

    private static LinkedList<bio> S(ArrayList<byte[]> arrayList) {
        LinkedList<bio> linkedList = new LinkedList();
        if (arrayList == null || arrayList.isEmpty()) {
            return linkedList;
        }
        int i = 0;
        while (i < arrayList.size()) {
            try {
                awp awp = new awp();
                awp.aG((byte[]) arrayList.get(i));
                bio bio = new bio();
                bio.sjd = awp.rZQ;
                bio.jOS = awp.desc;
                bio.rjR = awp.scope;
                bio.fJU = awp.fJU;
                linkedList.add(bio);
                i++;
            } catch (IOException e) {
                x.w("MicroMsg.OauthAuthorizeLogic", "bytesListToBytesListScopeInfoList: i:%d, exp:%s", new Object[]{Integer.valueOf(i), e.getLocalizedMessage()});
                linkedList.clear();
                return linkedList;
            }
        }
        return linkedList;
    }
}
