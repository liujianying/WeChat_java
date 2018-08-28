package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import com.google.android.gms.common.images.ImageManager.c;
import java.util.ArrayList;

final class ImageManager$ImageReceiver extends ResultReceiver {
    private final Uri aMJ;
    private final ArrayList<a> aMK;
    final /* synthetic */ ImageManager aML;

    public final void onReceiveResult(int i, Bundle bundle) {
        ImageManager.f(this.aML).execute(new c(this.aML, this.aMJ, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
    }
}
