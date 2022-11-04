package pojos;

public class BookingDatesPojo {
    // 1.Tum key'ler icin private variable'lar oluturuyoruz
    private String checkin;
    private String checkout;

    // 2.Tum parametrelerle ve parametresiz constractor olusturuyoruz


    public BookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public BookingDatesPojo() {
    }

    //  3. Public Getter ve Setter method'larini olusturuyoruz


    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    // 4. toString() method'unu olusturuyoruz


    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
