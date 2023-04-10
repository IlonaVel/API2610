package HW18API;

public enum ExchangeEnaum {
    USD("USD"), GB("GBP"), ENA("JPY");
    private static String val;

    ExchangeEnaum(String type){
      String  val = type;
    }

    public static String getVal(){
        return val;
    }
}
