package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.d;
import java.nio.ByteBuffer;

public final class a implements com.google.android.exoplayer2.metadata.a {
    private q alB;
    private final j aoK = new j();
    private final i aqZ = new i();

    public final Metadata a(d dVar) {
        Entry spliceNullCommand;
        if (this.alB == null || dVar.aek != this.alB.mp()) {
            this.alB = new q(dVar.aih);
            this.alB.U(dVar.aih - dVar.aek);
        }
        ByteBuffer byteBuffer = dVar.aig;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.aoK.m(array, limit);
        this.aqZ.m(array, limit);
        this.aqZ.cX(39);
        long cY = ((long) this.aqZ.cY(32)) | (((long) this.aqZ.cY(1)) << 32);
        this.aqZ.cX(20);
        int cY2 = this.aqZ.cY(12);
        int cY3 = this.aqZ.cY(8);
        this.aoK.da(14);
        switch (cY3) {
            case 0:
                spliceNullCommand = new SpliceNullCommand();
                break;
            case 4:
                spliceNullCommand = SpliceScheduleCommand.c(this.aoK);
                break;
            case 5:
                spliceNullCommand = SpliceInsertCommand.a(this.aoK, cY, this.alB);
                break;
            case 6:
                spliceNullCommand = TimeSignalCommand.b(this.aoK, cY, this.alB);
                break;
            case 255:
                spliceNullCommand = PrivateCommand.a(this.aoK, cY2, cY);
                break;
            default:
                spliceNullCommand = null;
                break;
        }
        if (spliceNullCommand == null) {
            return new Metadata(new Entry[0]);
        }
        return new Metadata(spliceNullCommand);
    }
}
