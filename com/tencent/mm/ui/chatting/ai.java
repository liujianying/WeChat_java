package com.tencent.mm.ui.chatting;

public final class ai {
    private static ai tMC;
    Object tMB;

    public static synchronized ai cui() {
        ai aiVar;
        synchronized (ai.class) {
            if (tMC == null) {
                tMC = new ai();
            }
            aiVar = tMC;
        }
        return aiVar;
    }
}
