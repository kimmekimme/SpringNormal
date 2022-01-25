package hello.core.order;

public interface OrderService {
    //주문결과반환 멤버아이디, 아이템이름, 아이템가격
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
