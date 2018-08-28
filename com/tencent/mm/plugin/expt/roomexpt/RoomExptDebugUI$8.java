package com.tencent.mm.plugin.expt.roomexpt;

class RoomExptDebugUI$8 implements Runnable {
    final /* synthetic */ RoomExptDebugUI iIF;

    RoomExptDebugUI$8(RoomExptDebugUI roomExptDebugUI) {
        this.iIF = roomExptDebugUI;
    }

    public final void run() {
        RoomExptDebugUI.d(this.iIF).notifyDataSetChanged();
        RoomExptDebugUI.c(this.iIF);
    }
}
