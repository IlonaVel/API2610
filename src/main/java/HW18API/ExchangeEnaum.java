package HW18API;

public enum ExchangeEnaum {
    USD("USD"), GB("GBP"), ENA("JPY");
    private  String val;

    ExchangeEnaum(String type) {
        this.val = type;
    }

    public  String getVal() {
        return this.val;
    }
}
