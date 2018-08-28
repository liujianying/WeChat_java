package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask.a;

public class SubCoreGameCenter$StartGameProcessTask extends GameProcessActivityTask {
    public static final Creator<SubCoreGameCenter$StartGameProcessTask> CREATOR = new 1();
    public long bGm;

    /* synthetic */ SubCoreGameCenter$StartGameProcessTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public final void a(Context context, a aVar) {
        Intent intent = new Intent(context, FileDownloadConfirmUI.class);
        intent.putExtra("extra_download_id", this.bGm);
        context.startActivity(intent);
        aVar.ahz();
    }

    public final void aaj() {
    }

    public final void g(Parcel parcel) {
        this.bGm = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.bGm);
    }

    public SubCoreGameCenter$StartGameProcessTask(Context context) {
        super(context);
    }

    private SubCoreGameCenter$StartGameProcessTask(Parcel parcel) {
        g(parcel);
    }
}
