package com.tencent.mm.ui.chatting;

import android.view.View;
import java.util.LinkedList;

public final class ao {
    private static LinkedList<View> tNs = new LinkedList();
    private static LinkedList<View> tNt = new LinkedList();
    private static LinkedList<View> tNu = new LinkedList();

    public static View EX(int i) {
        LinkedList linkedList = i == 1 ? tNs : i == 2 ? tNt : tNu;
        if (linkedList.size() != 0) {
            return (View) linkedList.removeFirst();
        }
        return null;
    }

    public static void L(View view, int i) {
        LinkedList linkedList = i == 1 ? tNs : i == 2 ? tNt : tNu;
        if (linkedList.size() >= 35) {
            linkedList.removeFirst();
        }
        linkedList.addLast(view);
    }

    public static void clear() {
        tNs.clear();
        tNt.clear();
        tNu.clear();
    }
}
