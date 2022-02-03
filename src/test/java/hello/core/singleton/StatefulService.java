package hello.core.singleton;

//ctrl + shift + t : 테스트 생성
public class StatefulService {

    //private int price;
    //유상태
/*
    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price;

    }
*/
    //무상태

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price;
    }

//    public int getPrice() {
//        return price;
//    }



}
