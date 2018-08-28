package f.a.a.a;

import f.a.a.a.a.b;
import java.util.LinkedList;

public final class a {
    private final b unknownTagHandler;
    public final f.a.a.b.a.a vHC;
    public int vHD = 0;

    public a(byte[] bArr, b bVar) {
        this.vHC = new f.a.a.b.a.a(bArr, bArr.length);
        this.unknownTagHandler = bVar;
    }

    public final int cJN() {
        return this.vHC.rY();
    }

    public final LinkedList<Integer> cJO() {
        f.a.a.b.a.a aVar = this.vHC;
        LinkedList<Integer> linkedList = new LinkedList();
        while (aVar.bfI < aVar.bufferSize) {
            linkedList.add(Integer.valueOf(aVar.rY()));
        }
        return linkedList;
    }

    public final String cJP() {
        return this.vHC.readString();
    }

    public final boolean cJQ() {
        return this.vHC.rY() != 0;
    }

    public final com.tencent.mm.bk.b cJR() {
        f.a.a.b.a.a aVar = this.vHC;
        int rY = aVar.rY();
        if (rY >= aVar.bufferSize - aVar.bfI || rY <= 0) {
            return com.tencent.mm.bk.b.bi(aVar.dY(rY));
        }
        com.tencent.mm.bk.b t = com.tencent.mm.bk.b.t(aVar.buffer, aVar.bfI, rY);
        aVar.bfI = rY + aVar.bfI;
        return t;
    }

    public final void cJS() {
        int ef = f.a.a.b.a.ef(this.vHD);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FieldNumber: ").append(f.a.a.b.a.eg(this.vHD)).append(" - ");
        switch (ef) {
            case 0:
                stringBuffer.append("varint (long, int or boolean) value: ").append(this.vHC.rZ());
                return;
            case 1:
                stringBuffer.append("double value: ").append(Double.toString(this.vHC.readDouble()));
                return;
            case 2:
                stringBuffer.append("Length delimited (String or ByteString) value: ").append(this.vHC.readString());
                return;
            case 5:
                stringBuffer.append("float value: ").append(Float.toString(this.vHC.readFloat()));
                return;
            default:
                return;
        }
    }

    public final LinkedList<byte[]> IC(int i) {
        return this.vHC.IC(i);
    }
}
