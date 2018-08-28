package android.support.v4.d;

class e$b implements e$c {
    public static final e$b tn = new e$b();

    public final int b(CharSequence charSequence, int i) {
        int i2 = i + 0;
        int i3 = 2;
        for (int i4 = 0; i4 < i2 && i3 == 2; i4++) {
            i3 = e.aa(Character.getDirectionality(charSequence.charAt(i4)));
        }
        return i3;
    }

    private e$b() {
    }
}
