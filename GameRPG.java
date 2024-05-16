package RPGG;

public class GameRPG {
    public static void main(String[] args) {
        // senjata dan baju besi untuk karakter Alucard dan Vexana
        Senjata senjataAlucard = new Senjata("Sword", 20);
        BajuBesi bajuAlucard = new BajuBesi(5);
        Senjata senjataVexana = new Senjata("Axe", 25);
        BajuBesi bajuVexana = new BajuBesi(3);

        // Membuat karakter Alucard dan Vexana
        Pahlawan alucard = new Pahlawan("Alucard", "Knight", senjataAlucard, bajuAlucard, 1);
        Musuh vexana = new Musuh("Vexana", "Goblin", senjataVexana, bajuVexana);

        // Alucard menyerang Vexana
        System.out.println("Sebelum serangan:");
        cetakStatus(alucard, vexana);
        alucard.serang(vexana);
        System.out.println("Setelah serangan:");
        cetakStatus(alucard, vexana);

        // Vexana menyerang Alucard
        System.out.println("Sebelum serangan:");
        cetakStatus(alucard, vexana);
        vexana.serang(alucard);
        System.out.println("Setelah serangan:");
        cetakStatus(alucard, vexana);
    }
    public static void cetakStatus(Karakter karakter1, Karakter karakter2) {
        System.out.println(karakter1.namaKarakter + " HP: " + karakter1.currentHP);
        System.out.println(karakter2.namaKarakter + " HP: " + karakter2.currentHP);
        System.out.println();
    }
     // Class Character
     public static abstract class Karakter {
        protected String namaKarakter;
        protected String ras;
        protected int maxHP;
        protected int maxMP;
        protected int currentHP;
        protected int currentMP;
        protected Senjata senjata;
        protected BajuBesi bajuBesi;

        public Karakter(String namaKarakter, String ras, Senjata senjata, BajuBesi bajuBesi) {
            this.namaKarakter = namaKarakter;
            this.ras = ras;
            this.senjata = senjata;
            this.bajuBesi = bajuBesi;
            this.currentHP = hitungMaxHP();
            this.currentMP = hitungMaxMP();
        }
        public abstract void serang(Karakter target);

        public abstract void gunakanKeterampilan(Karakter target, int biayaMP);

        public void gunakanRamuan(int jumlah) {
            currentHP = Math.min(currentHP + jumlah, maxHP);
        }

        public void gunakanEther(int jumlah) {
            currentMP = Math.min(currentMP + jumlah, maxMP);
        }

        public void gunakanElixir(int jumlahHP, int jumlahMP) {
            gunakanRamuan(jumlahHP);
            gunakanEther(jumlahMP);
        }

        protected abstract int hitungMaxHP();

        protected abstract int hitungMaxMP();
    }

    // Subclass Pahlawan
    public static class Pahlawan extends Karakter {
        private int level;

        public Pahlawan(String namaKarakter, String ras, Senjata senjata, BajuBesi bajuBesi, int level) {
            super(namaKarakter, ras, senjata, bajuBesi);
            this.level = level;
        }

        @Override
        public void serang(Karakter target) {
            int damage = senjata.getDampak();
            target.currentHP -= damage;
        }

        @Override
        public void gunakanKeterampilan(Karakter target, int biayaMP) {
            int damage = biayaMP * level; // Contoh perhitungan kerusakan keterampilan
            target.currentHP -= damage;
            currentMP -= biayaMP;
        }

        @Override
        protected int hitungMaxHP() {
            return level * 10; // Contoh perhitungan HP maksimum berdasarkan level
        }
        @Override
        protected int hitungMaxMP() {
            return level * 5; // Contoh perhitungan MP maksimum berdasarkan level
        }
    }

    // Subclass Musuh
    public static class Musuh extends Karakter {
        public Musuh(String namaKarakter, String ras, Senjata senjata, BajuBesi bajuBesi) {
            super(namaKarakter, ras, senjata, bajuBesi);
        }

        @Override
        public void serang(Karakter target) {
            int damage = senjata.getDampak();
            target.currentHP -= damage;
        }

        @Override
        public void gunakanKeterampilan(Karakter target, int biayaMP) {
            // Musuh tidak menggunakan keterampilan dalam contoh ini
        }

        @Override
        protected int hitungMaxHP() {
            // Perhitungan HP maksimum Musuh
            return 100;
        }

        @Override
        protected int hitungMaxMP() {
            // Perhitungan MP maksimum Musuh
            return 50;
        }
    }

    // Kelas Senjata
    public static class Senjata {
        private String jenis;
        private int dampak;

        public Senjata(String jenis, int dampak) {
            this.jenis = jenis;
            this.dampak = dampak;
        }

        public int getDampak() {
            return dampak;
        }
    }

 // Kelas BajuBesi
 public static class BajuBesi {
    private int reduksiDampak;

    public BajuBesi(int reduksiDampak) {
        this.reduksiDampak = reduksiDampak;
    }
}

// Kelas Ramuan
public static class Ramuan {
    private int jumlahHP;

    public Ramuan(int jumlahHP) {
        this.jumlahHP = jumlahHP;
    }

    public int getJumlahHP() {
        return jumlahHP;
    }
}
// Kelas Ether
public static class Ether {
    private int jumlahMP;

    public Ether(int jumlahMP) {
        this.jumlahMP = jumlahMP;
    }

    public int getJumlahMP() {
        return jumlahMP;
    }
}

// Kelas Elixir
public static class Elixir {
    // Elixir tidak memiliki atribut tambahan
}
}