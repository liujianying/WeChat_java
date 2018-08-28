package com.tencent.mm.plugin.expt.roomexpt;

class RoomExptDebugUI$7 implements Runnable {
    final /* synthetic */ RoomExptDebugUI iIF;

    RoomExptDebugUI$7(RoomExptDebugUI roomExptDebugUI) {
        this.iIF = roomExptDebugUI;
    }

    public final void run() {
        RoomExptDebugUI.d(this.iIF).notifyDataSetChanged();
        RoomExptDebugUI.c(this.iIF);
    }
}
